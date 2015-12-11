// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
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
//            OAuthTokenManager, TokenCallbackHelpers, MAPCookie

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

    private static class ExchangeTokenCookiesResponse
    {

        private final List mCookies;
        private final String mResponseUrl;

        public List getCookies()
        {
            return mCookies;
        }

        public String getResponseUrl()
        {
            return mResponseUrl;
        }

        public ExchangeTokenCookiesResponse(List list, String s)
        {
            mCookies = list;
            mResponseUrl = s;
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

    private ExchangeTokenCookiesResponse fetchCookiesFromServer(String s, String s1, String s2, List list, Tracer tracer)
        throws MAPCallbackErrorException
    {
        String s3;
        String s4;
        String s5;
        String s6;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        MAPLog.i(TAG, "Fetching cookies");
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "fetchCookiesFromServer");
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        URL url = getCookieExchangeTokenURL(s1);
        if (url != null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid Parameter: Domain"));
        s;
        s3 = s4;
        MAPLog.e(TAG, "Got IOException when fetching Cookie from server ", s);
        s3 = s4;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:IOException", new String[0]);
        s3 = s4;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE.value(), s.getMessage()));
        s;
        if (s3 != null)
        {
            s3.disconnect();
        }
        throw s;
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        if (url.getHost().contains(".amazon."))
        {
            break MISSING_BLOCK_LABEL_314;
        }
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        MAPLog.w(TAG, "The cookie exchanger url does not look like an Amazon domain. Failing the getCookies call.");
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Invalid Parameter: Domain. Cannot exchange cookies at a non-amazon domain"));
        s;
        s3 = s5;
        MAPLog.e(TAG, "Got JSONException while parsing response ", s);
        s3 = s5;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:JSONException", new String[0]);
        s3 = s5;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), s.getMessage()));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        MAPLog.i(TAG, (new StringBuilder("Using CookieExchangeToken URL: ")).append(url.toString()).toString());
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        Object obj4 = new ArrayList();
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("requested_token_type", "auth_cookies"));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("app_name", mContext.getPackageName()));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("app_version", String.valueOf(BuildInfo.getBuildInfo().mMapSWVersion)));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("domain", s1));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        MAPLog.i(TAG, "Requesting all cookies");
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        String s7 = mOAuthTokenManager.getRefreshToken(s, null, tracer);
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("source_token_type", "refresh_token"));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("source_token", s7));
_L9:
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_741;
        }
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        ((List) (obj4)).add(new BasicNameValuePair("url", s2));
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        obj4 = new UrlEncodedFormEntity(((List) (obj4)), "UTF-8");
        if (list != null) goto _L4; else goto _L3
_L3:
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        s2 = new ArrayList();
_L10:
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        addTheSidCookieToTheAuthCookies(s2, s, s1);
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        s1 = mAuthPortalHelper.startIdentityRequestURLEncoded(mContext, url, ((UrlEncodedFormEntity) (obj4)), false, s2, s, null, tracer);
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        int i = s1.getResponseCode();
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        MAPLog.i(TAG, "Headers received update request to exchange token endpoint");
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        list = JSONHelpers.toJson(s1);
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        platformmetricstimer.stop();
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        MAPLog.i(TAG, "Response parsed for cookie request to exchange token endpoint");
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        if (!mAuthPortalHelper.isFailure(i) && list != null) goto _L6; else goto _L5
_L5:
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_1325;
        }
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        s2 = list.toString();
_L11:
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        s2 = (new AuthEndpointErrorParser()).parse(list);
        if (s2 != null) goto _L8; else goto _L7
_L7:
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("Received unrecongized error from the server with status code %d", new Object[] {
            Integer.valueOf(i)
        })));
        s;
        s3 = s6;
        MAPLog.e(TAG, String.format("Get error when fetchAuthCookies: %s", new Object[] {
            s.getErrorMsg()
        }));
        s3 = s6;
        MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:OAuthTokenManagerException", new String[0]);
        s3 = s6;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(s.getErrorCode(), s.getMessage()));
_L2:
        s4 = obj;
        s3 = obj1;
        s5 = obj2;
        s6 = obj3;
        MAPLog.i(TAG, "Requesting just non-auth cookies");
          goto _L9
_L8:
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        mOAuthTokenManager.handleTokenExchangeError(s, null, s2, i, OAuthTokenManager.AuthTokenExchangeType.OauthRefreshToCookieExchange);
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), String.format("Received Error code %s from the server. Message: %s .Detail: %s", new Object[] {
            s2.getAuthTypeError().getCode(), s2.getMessage(), s2.getDetail()
        })));
_L6:
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        MAPLog.i(TAG, "Parsing getCookies success response");
        s4 = s1;
        s3 = s1;
        s5 = s1;
        s6 = s1;
        s = parseExchangeTokenCookiesResponse(s, list);
        if (s1 != null)
        {
            s1.disconnect();
        }
        return s;
_L4:
        s2 = list;
          goto _L10
        s2 = "Null Json Response";
          goto _L11
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

    private Bundle onSuccess(List list, String s, String s1)
    {
        return onSuccess(list, s, s1, null);
    }

    private Bundle onSuccess(List list, String s, String s1, String s2)
    {
        if (list == null)
        {
            list = new ArrayList();
        }
        addTheSidCookieToTheAuthCookies(list, s, s1);
        list = CookieUtils.getBundleForCookieList(list);
        if (!TextUtils.isEmpty(s2))
        {
            list.putString("com.amazon.identity.auth.device.api.cookiekeys.ResponseUrl", s2);
        }
        return list;
    }

    private ExchangeTokenCookiesResponse parseExchangeTokenCookiesResponse(String s, JSONObject jsonobject)
    {
        try
        {
            jsonobject = jsonobject.getJSONObject("response");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new ExchangeTokenCookiesResponse(new ArrayList(), null);
        }
        try
        {
            s = parseJSONCookies(s, jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = new ArrayList();
        }
        return new ExchangeTokenCookiesResponse(s, jsonobject.optString("uri"));
    }

    private List parseJSONCookies(String s, JSONObject jsonobject)
        throws JSONException
    {
        ArrayList arraylist;
        JSONObject jsonobject1;
        jsonobject1 = jsonobject.getJSONObject("tokens").getJSONObject("cookies");
        arraylist = new ArrayList();
        if (jsonobject1 != null) goto _L2; else goto _L1
_L1:
        jsonobject = null;
_L4:
        return jsonobject;
_L2:
        Iterator iterator = jsonobject1.keys();
        do
        {
            jsonobject = arraylist;
            if (!iterator.hasNext())
            {
                continue;
            }
            jsonobject = ((String)iterator.next()).trim();
            JSONArray jsonarray = jsonobject1.getJSONArray(jsonobject);
            if (jsonarray != null)
            {
                arraylist.addAll(generateCookieListFromCookieJSONArray(s, jsonarray, jsonobject));
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
                list.add(getSidCookie(s, AmazonDomainHelper.getDomainFromCompleteUrl(s1)));
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

    public Bundle getAuthCookies(String s, String s1, Bundle bundle, Tracer tracer)
        throws MAPCallbackErrorException
    {
        List list;
        String s2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (!TextUtils.isEmpty(s) && !mMapAccountManager.isAccountRegistered(s))
        {
            MAPLog.i(TAG, "Account not registered");
            throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT.value(), "Given Account is currently not registered."));
        }
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        if (bundle.getBoolean("com.amazon.identity.auth.device.internal.cookiekeys.options.ignorefresh", false))
        {
            tracer = getAuthCookiesFromStorage(s, s1);
            bundle = tracer;
            if (CollectionUtils.isEmpty(tracer))
            {
                bundle = new ArrayList();
            }
            return onSuccess(bundle, s, s1);
        }
        flag2 = bundle.containsKey("com.amazon.identity.auth.device.api.cookiekeys.options.SignInUrl");
        if (bundle.getBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", false) || flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s2 = bundle.getString("com.amazon.identity.auth.device.api.cookiekeys.options.SignInUrl");
        flag = false;
        if (s == null) goto _L2; else goto _L1
_L1:
        list = getAuthCookiesFromStorage(s, s1);
        if (!CollectionUtils.isEmpty(list))
        {
            bundle = list;
            if (!flag1)
            {
                flag = true;
                bundle = list;
            }
        } else
        {
            bundle = getNonAuthCookiesFromStorage(s1);
        }
_L4:
        bundle = new CookieCacheResponse(bundle, flag);
        list = bundle.getCookies();
        flag = bundle.shouldReturnCookies();
        flag3 = shouldRefreshCookiesBasedOnExpiry(list);
        if (!CollectionUtils.isEmpty(list) && !flag3 && flag)
        {
            return onSuccess(list, s, s1);
        }
        break; /* Loop/switch isn't completed */
_L2:
        list = getNonAuthCookiesFromStorage(s1);
        bundle = list;
        if (!flag1)
        {
            flag = true;
            bundle = list;
        }
        if (true) goto _L4; else goto _L3
_L3:
        MAPLog.i(TAG, (new StringBuilder("Fetching cookies from server due to ")).append(tracer.getPackageToBlame(mContext)).append(", for domain ").append(s1).append(" with options forceRefresh=").append(flag1).append(" haveCookiesExpired=").append(flag3).toString());
        tracer = fetchCookiesFromServer(s, s1, s2, list, tracer);
        bundle = tracer.getCookies();
        tracer = tracer.getResponseUrl();
        if (flag2 && TextUtils.isEmpty(tracer))
        {
            MAPLog.e(TAG, "Expected url, but did not receive one from getCookies request. Cannot proceed.");
            MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:MissingExpectedResponseUrl", new String[0]);
            throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "Expected url, but did not receive one from getCookies request"));
        }
        if (!flag2 && CollectionUtils.isEmpty(bundle))
        {
            MAPLog.e(TAG, "Expected cookies, but did not receive them from getCookies request");
            MetricsHelper.incrementCounter("fetchCookiesFromServerFailure:MissingExpectedCookies", new String[0]);
            throw new MAPCallbackErrorException(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "Expected cookies, but did not receive them from getCookies request"));
        }
        MetricsHelper.incrementCounter("fetchCookiesFromServerSuccess", new String[0]);
        if (CollectionUtils.isEmpty(bundle)) goto _L6; else goto _L5
_L5:
        if (!TextUtils.isEmpty(s)) goto _L8; else goto _L7
_L7:
        mCookieDataStore.setNonAuthCookies(s1, bundle);
_L6:
        return onSuccess(bundle, s, s1, tracer);
_L8:
        updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(bundle, s);
        mCookieDataStore.setAllCookies(s, s1, bundle);
        if (!flag1)
        {
            mCookieDataStore.setNonAuthCookies(s1, null);
        }
        if (true) goto _L6; else goto _L9
_L9:
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
        mDataStorage.setToken(s, "com.amazon.dcp.sso.token.cookie.sid", s1);
    }

    static 
    {
        FUDGE_FACTOR = TimeUtil.fromMinutesTo(1L, TimeUnit.MILLISECONDS);
    }
}
