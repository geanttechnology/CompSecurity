// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.CookieDataStore;
import com.amazon.identity.auth.device.storage.CookieDataStoreFactory;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.CollectionUtils;
import com.amazon.identity.auth.device.utils.CookieUtils;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.cookie.Cookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            OAuthTokenManager, MAPCookie, TokenCallbackHelpers

public class MAPCookieManager
{
    private static class CookieCacheResponse
    {

        private final List mCookies;
        private final boolean mShouldReturn;

        public List getCookies()
        {
            return mCookies;
        }

        public boolean shouldReturnCookies()
        {
            return mShouldReturn;
        }

        CookieCacheResponse(List list, boolean flag)
        {
            mCookies = list;
            mShouldReturn = flag;
        }
    }


    private static final long FUDGE_FACTOR;
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/token/MAPCookieManager.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/token/MAPCookieManager.getName();
    private final AuthPortalHelper mAuthPortalHelper = new AuthPortalHelper();
    private final ServiceWrappingContext mContext;
    private final CookieDataStore mCookieDataStore;
    private DataStorage mDataStorage;
    private final MAPAccountManager mMapAccountManager;
    private final OAuthTokenManager mOAuthTokenManager;
    private SystemWrapper mSystemWrapper;

    public MAPCookieManager(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mSystemWrapper = (SystemWrapper)mContext.getSystemService("dcp_system");
        mOAuthTokenManager = new OAuthTokenManager(mContext);
        mMapAccountManager = new MAPAccountManager(mContext);
        mCookieDataStore = (new CookieDataStoreFactory(mContext)).getDataStore();
        mDataStorage = mContext.getDataStorage();
    }

    private void addAppParams(List list)
    {
        list.add(new BasicNameValuePair("app_name", mContext.getPackageName()));
        list.add(new BasicNameValuePair("app_version", String.valueOf(BuildInfo.getBuildInfo().mMapSWVersion)));
    }

    private List generateCookieListFromCookieJSONArray(String s, JSONArray jsonarray, String s1)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        int j = jsonarray.length();
        for (int i = 0; i < j; i++)
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            MAPCookie mapcookie = new MAPCookie(jsonobject.getString("Name"), jsonobject.getString("Value"), s1, s, jsonobject.getBoolean("Secure"));
            if (TextUtils.isEmpty(s1))
            {
                mapcookie.setDomain(jsonobject.getString("Domain"));
            }
            mapcookie.setPath(jsonobject.getString("Path"));
            if (jsonobject.has("Expires"))
            {
                mapcookie.setExpiryDate(jsonobject.getString("Expires"));
            }
            mapcookie.setHttpOnly(jsonobject.getBoolean("HttpOnly"));
            arraylist.add(mapcookie);
        }

        return arraylist;
    }

    private List getAuthCookiesFromStorage(String s, String s1)
    {
        return mCookieDataStore.getAllCookies(s, s1);
    }

    private URL getCookieExchangeTokenURL(String s)
    {
        try
        {
            s = new URL("https", AmazonDomainHelper.getCompleteAuthPortalDomain(s), 443, "/ap/exchangetoken/cookies");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Error parsing URL", s);
            return null;
        }
        return s;
    }

    private List getNonAuthCookiesFromStorage(String s)
    {
        return mCookieDataStore.getNonAuthCookies(s);
    }

    public static MAPCookie getSidCookie(String s, String s1)
    {
        return new MAPCookie("sid", s, s1, CookieUtils.getNonExpiringCookieExpiresString(), "/", null, true, true);
    }

    public static String getSidString(List list)
    {
        String s = null;
        if (!CollectionUtils.isEmpty(list)) goto _L2; else goto _L1
_L1:
        list = s;
_L4:
        return list;
_L2:
        Iterator iterator = list.iterator();
        do
        {
            list = s;
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            list = (Cookie)iterator.next();
        } while (!list.getName().equals("sid"));
        s = list.getValue();
        list = s;
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "The sid value inside the returned cookies is null or a empty string. There's a bug on server side!");
            MetricsHelper.incrementCounter("EmptySidCookieValueInsideAuthCookiesFromServer", new String[0]);
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void onSuccess(List list, String s, String s1, Callback callback)
    {
        if (list == null)
        {
            list = new ArrayList();
        }
        addTheSidCookieToTheAuthCookies(list, s, s1);
        callback.onSuccess(CookieUtils.getBundleForCookieList(list));
    }

    private List parseJSONCookies(String s, JSONObject jsonobject)
        throws JSONException
    {
        Object obj;
        JSONObject jsonobject1;
        obj = TAG;
        (new StringBuilder("Parsing getCookies Response for id=")).append(s).toString();
        jsonobject1 = jsonobject.getJSONObject("response").getJSONObject("tokens").getJSONObject("cookies");
        obj = new ArrayList();
        if (jsonobject1 != null) goto _L2; else goto _L1
_L1:
        jsonobject = null;
_L4:
        return jsonobject;
_L2:
        Iterator iterator = jsonobject1.keys();
        do
        {
            jsonobject = ((JSONObject) (obj));
            if (!iterator.hasNext())
            {
                continue;
            }
            jsonobject = ((String)iterator.next()).trim();
            JSONArray jsonarray = jsonobject1.getJSONArray(jsonobject);
            if (jsonarray != null)
            {
                ((List) (obj)).addAll(generateCookieListFromCookieJSONArray(s, jsonarray, jsonobject));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void removeTheSidCookieIfExist(List list)
    {
        if (!CollectionUtils.isEmpty(list)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Cookie cookie;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            cookie = (Cookie)iterator.next();
        } while (!cookie.getName().equals("sid"));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        String s = TAG;
        list.remove(cookie);
        return;
    }

    private boolean shouldRefreshCookiesBasedOnExpiry(List list)
    {
        if (list == null || list.size() <= 0)
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            Cookie cookie = (Cookie)list.next();
            Date date = cookie.getExpiryDate();
            long l = mSystemWrapper.currentTimeMillis();
            if (date == null)
            {
                MAPLog.w(TAG, String.format("Cookie: %s has null expiry date.", new Object[] {
                    cookie.getName()
                }));
                return true;
            }
            if (FUDGE_FACTOR + l >= date.getTime())
            {
                MAPLog.i(TAG, String.format("Cookie: %s near expiry, refreshing", new Object[] {
                    cookie.getName()
                }));
                return true;
            }
        }

        return false;
    }

    public static void updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(List list, Map map)
    {
        String s = getSidString(list);
        if (!TextUtils.isEmpty(s))
        {
            removeTheSidCookieIfExist(list);
            list = TAG;
            map.put("com.amazon.dcp.sso.token.cookie.sid", s);
        }
    }

    public void addTheSidCookieToTheAuthCookies(List list, String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            if (list == null)
            {
                MAPLog.e(TAG, "The currentCookies is null. Cannot add sidCookie!");
                return;
            }
            s = mDataStorage.getToken(s, "com.amazon.dcp.sso.token.cookie.sid");
            if (!TextUtils.isEmpty(s))
            {
                if (!TextUtils.isEmpty(getSidString(list)))
                {
                    MAPLog.w(TAG, "Before we add the sid cookie to the cookies that will be sent out, there's already a sid cookie inside; this is a bug since we should have removed the sid cookie before we saved the cookies.");
                    MetricsHelper.incrementCounter("SidCookieExistsInCookiesBeforeAddingOne", new String[0]);
                    removeTheSidCookieIfExist(list);
                }
                s1 = AmazonDomainHelper.getDomainFromCompleteUrl(s1);
                String s2 = TAG;
                (new StringBuilder("Add the sid cookie to cookies that will be sent out. The domain we use to create the sid cookies is ")).append(s1).toString();
                list.add(getSidCookie(s, s1));
                return;
            }
            if (!TextUtils.isEmpty(getSidString(list)))
            {
                MAPLog.e(TAG, "There's a sid cookie in the cookies that will be sent out, but we didn't update the sid; this is a bug since we should have updated the sid and removed the sid cookie before we saved the cookies.");
                MetricsHelper.incrementCounter("SidCookieExistsButHaveNotBeenSavedAsAToken", new String[0]);
                return;
            }
        }
    }

    List fetchCookiesFromServer(String s, String s1, List list, Callback callback, Tracer tracer)
    {
        String s2;
        ArrayList arraylist;
        String s3;
        Object obj;
        String s4;
        Object obj1;
        String s5;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        MAPLog.i(TAG, "Fetching cookies");
        arraylist = new ArrayList();
        obj5 = null;
        obj6 = null;
        obj7 = null;
        obj4 = null;
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "fetchCookiesFromServer");
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        URL url = getCookieExchangeTokenURL(s1);
        if (url != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid Parameter: Domain"));
        return arraylist;
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        if (url.getHost().contains(".amazon."))
        {
            break MISSING_BLOCK_LABEL_288;
        }
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        MAPLog.w(TAG, "The cookie exchanger url does not look like an Amazon domain. Failing the getCookies call.");
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid Parameter: Domain. Cannot exchange cookies at a non-amazon domain"));
        return arraylist;
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        MAPLog.i(TAG, (new StringBuilder("Using CookieExchangeToken URL: ")).append(url.toString()).toString());
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        MAPLog.i(TAG, "Requesting just non-auth cookies");
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        Object obj3 = new ArrayList();
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        ((List) (obj3)).add(new BasicNameValuePair("requested_token_type", "auth_cookies"));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        ((List) (obj3)).add(new BasicNameValuePair("domain", s1));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        addAppParams(((List) (obj3)));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        obj3 = new UrlEncodedFormEntity(((List) (obj3)), "UTF-8");
_L7:
        if (list != null)
        {
            break MISSING_BLOCK_LABEL_664;
        }
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        list = new ArrayList();
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        addTheSidCookieToTheAuthCookies(list, s, s1);
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        s1 = mAuthPortalHelper.startIdentityRequestURLEncoded(mContext, url, ((UrlEncodedFormEntity) (obj3)), false, list, s, null, tracer);
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        int i = s1.getResponseCode();
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        MAPLog.i(TAG, "Headers received update request to exchange token endpoint");
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        tracer = JSONHelpers.toJson(s1);
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        platformmetricstimer.stop();
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        MAPLog.i(TAG, "Response parsed for cookie request to exchange token endpoint");
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        if (!mAuthPortalHelper.isFailure(i) && tracer != null) goto _L4; else goto _L3
_L3:
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        list = TAG;
        if (tracer == null)
        {
            break MISSING_BLOCK_LABEL_2053;
        }
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        list = tracer.toString();
_L11:
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        list = (new AuthEndpointErrorParser()).parse(tracer);
        if (list != null) goto _L6; else goto _L5
_L5:
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("Received unrecongized error from the server with status code %d", new Object[] {
            Integer.valueOf(i)
        })));
_L8:
        if (s1 != null)
        {
            s1.disconnect();
        }
        return arraylist;
_L2:
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        obj3 = mOAuthTokenManager.getRefreshToken(s, null, tracer);
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        MAPLog.i(TAG, "Requesting all cookies");
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        ArrayList arraylist1 = new ArrayList();
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        arraylist1.add(new BasicNameValuePair("source_token_type", "refresh_token"));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        arraylist1.add(new BasicNameValuePair("source_token", ((String) (obj3))));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        arraylist1.add(new BasicNameValuePair("requested_token_type", "auth_cookies"));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        arraylist1.add(new BasicNameValuePair("domain", s1));
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        addAppParams(arraylist1);
        s3 = obj4;
        obj = arraylist;
        s4 = obj5;
        obj1 = arraylist;
        s5 = obj6;
        obj2 = arraylist;
        s2 = obj7;
        obj3 = new UrlEncodedFormEntity(arraylist1, "UTF-8");
          goto _L7
_L6:
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        mOAuthTokenManager.handleTokenExchangeError(s, null, list, i, OAuthTokenManager.AuthTokenExchangeType.OauthRefreshToCookieExchange);
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), String.format("Received Error code %s from the server. Message: %s .Detail: %s", new Object[] {
            list.getAuthTypeError().getCode(), list.getMessage(), list.getDetail()
        })));
          goto _L8
        s;
        s2 = s3;
        MAPLog.e(TAG, "Got IOException when fetching Cookie from server ", s);
        s2 = s3;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), s.getMessage()));
        s2 = s3;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:IOException", new String[0]);
        list = ((List) (obj));
        if (s3 != null)
        {
            s3.disconnect();
            list = ((List) (obj));
        }
_L10:
        MetricsHelper.incrementCounter("fetchCookiesFromServerSuccess", new String[0]);
        return list;
_L4:
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        MAPLog.i(TAG, "Parsing Cookies from JSONObject");
        s3 = s1;
        obj = arraylist;
        s4 = s1;
        obj1 = arraylist;
        s5 = s1;
        obj2 = arraylist;
        s2 = s1;
        s = parseJSONCookies(s, tracer);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_1842;
        }
        s3 = s1;
        obj = s;
        s4 = s1;
        obj1 = s;
        s5 = s1;
        obj2 = s;
        s2 = s1;
        MAPLog.e(TAG, "The cookie response from server is null");
        s3 = s1;
        obj = s;
        s4 = s1;
        obj1 = s;
        s5 = s1;
        obj2 = s;
        s2 = s1;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "The cookie response from server is null"));
        s3 = s1;
        obj = s;
        s4 = s1;
        obj1 = s;
        s5 = s1;
        obj2 = s;
        s2 = s1;
        MAPLog.i(TAG, "Parsing Complete from JSONObject");
        list = s;
        if (s1 != null)
        {
            s1.disconnect();
            list = s;
        }
        continue; /* Loop/switch isn't completed */
        s;
        s2 = s4;
        MAPLog.e(TAG, "Got JSONException while parsing response ", s);
        s2 = s4;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), s.getMessage()));
        s2 = s4;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:JSONException", new String[0]);
        list = ((List) (obj1));
        if (s4 != null)
        {
            s4.disconnect();
            list = ((List) (obj1));
        }
        continue; /* Loop/switch isn't completed */
        s;
        s2 = s5;
        MAPLog.e(TAG, String.format("Get error when fetchAuthCookies: %s", new Object[] {
            s.getErrorMsg()
        }));
        s2 = s5;
        TokenCallbackHelpers.callbackError(callback, s.getErrorCode(), s.getMessage());
        s2 = s5;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:OAuthTokenManagerException", new String[0]);
        list = ((List) (obj2));
        if (s5 != null)
        {
            s5.disconnect();
            list = ((List) (obj2));
        }
        if (true) goto _L10; else goto _L9
_L9:
        s;
        if (s2 != null)
        {
            s2.disconnect();
        }
        throw s;
        list = "Null Json Response";
          goto _L11
    }

    public void getAuthCookies(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        if (TextUtils.isEmpty(s) || mMapAccountManager.isAccountRegistered(s)) goto _L2; else goto _L1
_L1:
        MAPLog.i(TAG, "Account not registered");
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT.value(), "Given Account is currently not registered."));
_L8:
        return;
_L2:
        boolean flag;
        boolean flag1;
        if (bundle.getBoolean("com.amazon.identity.auth.device.internal.cookiekeys.options.ignorefresh", false))
        {
            tracer = getAuthCookiesFromStorage(s, s1);
            bundle = tracer;
            if (CollectionUtils.isEmpty(tracer))
            {
                bundle = new ArrayList();
            }
            onSuccess(bundle, s, s1, callback);
            return;
        }
        flag1 = bundle.getBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", false);
        bundle = TAG;
        flag = false;
        if (s == null) goto _L4; else goto _L3
_L3:
        boolean flag2;
        Object obj = getAuthCookiesFromStorage(s, s1);
        if (!CollectionUtils.isEmpty(((java.util.Collection) (obj))))
        {
            bundle = ((Bundle) (obj));
            if (!flag1)
            {
                flag = true;
                bundle = ((Bundle) (obj));
            }
        } else
        {
            bundle = getNonAuthCookiesFromStorage(s1);
        }
_L6:
        obj = new CookieCacheResponse(bundle, flag);
        bundle = ((CookieCacheResponse) (obj)).getCookies();
        flag = ((CookieCacheResponse) (obj)).shouldReturnCookies();
        flag2 = shouldRefreshCookiesBasedOnExpiry(bundle);
        if (!CollectionUtils.isEmpty(bundle) && !flag2 && flag)
        {
            tracer = TAG;
            onSuccess(bundle, s, s1, callback);
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        List list = getNonAuthCookiesFromStorage(s1);
        bundle = list;
        if (!flag1)
        {
            flag = true;
            bundle = list;
        }
        if (true) goto _L6; else goto _L5
_L5:
        MAPLog.i(TAG, (new StringBuilder("Fetching cookies from server due to ")).append(tracer.getPackageToBlame(mContext)).append(", for domain ").append(s1).append(" with options forceRefresh=").append(flag1).append(" haveCookiesExpired=").append(flag2).toString());
        bundle = fetchCookiesFromServer(s, s1, bundle, callback, tracer);
        if (CollectionUtils.isEmpty(bundle)) goto _L8; else goto _L7
_L7:
        tracer = TAG;
        if (!TextUtils.isEmpty(s)) goto _L10; else goto _L9
_L9:
        mCookieDataStore.setNonAuthCookies(s1, bundle);
_L12:
        onSuccess(bundle, s, s1, callback);
        return;
_L10:
        updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(bundle, s);
        mCookieDataStore.setAllCookies(s, s1, bundle);
        if (!flag1)
        {
            mCookieDataStore.setNonAuthCookies(s1, null);
            tracer = TAG;
            (new StringBuilder("Cleared non-auth cookies for doamin:")).append(s1).toString();
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    public List getNonAuthCookies(String s)
    {
        List list = getNonAuthCookiesFromStorage(s);
        if (CollectionUtils.isEmpty(list))
        {
            s = new ArrayList();
        } else
        {
            s = list;
            if (shouldRefreshCookiesBasedOnExpiry(list))
            {
                return new ArrayList();
            }
        }
        return s;
    }

    public List parseJSONArrayCookies(String s, JSONArray jsonarray)
        throws JSONException
    {
        return generateCookieListFromCookieJSONArray(s, jsonarray, null);
    }

    public void updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(List list, String s)
    {
        String s1;
label0:
        {
            s1 = getSidString(list);
            if (!TextUtils.isEmpty(s1))
            {
                removeTheSidCookieIfExist(list);
                if (!s1.equals(mDataStorage.getToken(s, "com.amazon.dcp.sso.token.cookie.sid")))
                {
                    break label0;
                }
            }
            return;
        }
        list = TAG;
        mDataStorage.setToken(s, "com.amazon.dcp.sso.token.cookie.sid", s1);
    }

    static 
    {
        FUDGE_FACTOR = TimeUtil.fromMinutesTo(1L, TimeUnit.MILLISECONDS);
    }
}
