// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.DelegatedAccountHelper;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
import com.amazon.identity.auth.device.utils.BuildInfo;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.JSONHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import com.amazon.identity.platform.util.PlatformUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            ServerRegistrationSyncHelper

public class OAuthTokenManager
{
    public static final class OAuthTokenManagerException extends Exception
    {

        private com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError mAuthEndpointError;
        private final int mErrorCode;
        private final String mErrorMsg;

        public com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError getAuthEndpointError()
        {
            return mAuthEndpointError;
        }

        public int getErrorCode()
        {
            return mErrorCode;
        }

        public String getErrorMsg()
        {
            return mErrorMsg;
        }

        public OAuthTokenManagerException(int i, String s)
        {
            super(s);
            mErrorCode = i;
            mErrorMsg = s;
        }

        public OAuthTokenManagerException(int i, String s, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
        {
            super(s);
            mErrorCode = i;
            mErrorMsg = s;
            mAuthEndpointError = authendpointerror;
        }

        public OAuthTokenManagerException(int i, String s, Throwable throwable)
        {
            super(s, throwable);
            mErrorCode = i;
            mErrorMsg = s;
        }
    }


    public static final String ACCESS_TOKEN = "access_token";
    public static final String APP_NAME = "app_name";
    public static final String APP_VERSION = "app_version";
    public static final String AUTH_COOKIES = "auth_cookies";
    public static final String BEARER_TOKEN = "bearer_token";
    public static final String DELEGATED_ACCESS_TOKEN = "delegated_access_token";
    public static final String DIRECTED_ID = "directed_id";
    public static final String DMS_TOKEN = "dms_token";
    public static final String DOMAIN = "domain";
    public static final String EXPIRES_IN = "expires_in";
    public static final String FORCE_REFRESH_DMS_TO_OAUTH_DONE_ONCE_TRUE = "true";
    private static final long FUDGE_FACTOR;
    public static final String KEY_FORCE_REFRESH_DMS_TO_OAUTH_DONE_ONCE = "force_refresh_dms_to_oauth_done_once";
    public static final String KEY_OAUTH_REFRESHED_AT = "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at";
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/token/OAuthTokenManager.getSimpleName();
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String REQUESTED_TOKEN_TYPE = "requested_token_type";
    public static final String SOURCE_TOKEN = "source_token";
    public static final String SOURCE_TOKEN_TYPE = "source_token_type";
    private static final String TAG = com/amazon/identity/auth/device/token/OAuthTokenManager.getName();
    public static final String TOKEN = "token";
    public static final String TOKEN_EXPIRES_IN = "token_expires_in";
    public static final String TOKEN_TYPE = "token_type";
    private final AuthPortalHelper mAuthPortalHelper;
    private final Context mContext;
    private final DelegatedAccountHelper mDelegatedAccountHelper;
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;
    private final MAPAccountManager mMapAccountManager;
    private final ServerRegistrationSyncHelper mServerRegSync;
    private final SystemWrapper mSystemWrapper;

    public OAuthTokenManager(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mSystemWrapper = (SystemWrapper)mContext.getSystemService("dcp_system");
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(mContext);
        mAuthPortalHelper = new AuthPortalHelper(mContext);
        mMapAccountManager = new MAPAccountManager(mContext);
        mDelegatedAccountHelper = new DelegatedAccountHelper();
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
    }

    OAuthTokenManager(Context context, AuthPortalHelper authportalhelper, DelegatedAccountHelper delegatedaccounthelper)
    {
        mContext = ServiceWrappingContext.create(context);
        mSystemWrapper = (SystemWrapper)mContext.getSystemService("dcp_system");
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(mContext);
        mAuthPortalHelper = authportalhelper;
        mMapAccountManager = new MAPAccountManager(mContext);
        mDelegatedAccountHelper = delegatedaccounthelper;
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
    }

    private void addAppParams(List list)
    {
        list.add(new BasicNameValuePair("app_name", mContext.getPackageName()));
        list.add(new BasicNameValuePair("app_version", String.valueOf(BuildInfo.getBuildInfo().mMapSWVersion)));
    }

    private String createErrorMsg(com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror)
    {
        if (authendpointerror != null)
        {
            return String.format("Received Error code %s from the server. Message: %s Detail: %s", new Object[] {
                authendpointerror.getAuthTypeError().getCode(), authendpointerror.getMessage(), authendpointerror.getDetail()
            });
        } else
        {
            return "Invalid error response received from the token exchange endpoint";
        }
    }

    private String exchangeDMSCredentialsForOAuthTokenAndStore(String s, String s1, boolean flag, Tracer tracer)
        throws OAuthTokenManagerException
    {
        Tracer tracer1;
        Tracer tracer2;
        Tracer tracer3;
        Tracer tracer4;
        Object obj;
        Object obj1;
        String s2;
        Object obj2;
        if (s == null)
        {
            throw new OAuthTokenManagerException(8, "Given Account is currently not valid");
        }
        MAPLog.i(TAG, (new StringBuilder("Exchange DMS token to OAuth token for package")).append(s1).toString());
        obj1 = null;
        s2 = null;
        obj2 = null;
        obj = null;
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "exchangeDMSCredentialsForOAuthToken");
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        URL url = getExchangeTokenURL(s);
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        MAPLog.i(TAG, (new StringBuilder("Exchanging DMS token with exchange token endpoint: ")).append(url.toString()).toString());
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        Object obj3 = new ArrayList();
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        ((List) (obj3)).add(new BasicNameValuePair("source_token_type", "dms_token"));
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        ((List) (obj3)).add(new BasicNameValuePair("source_token", "source_token"));
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        ((List) (obj3)).add(new BasicNameValuePair("requested_token_type", "refresh_token"));
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        addAppParams(((List) (obj3)));
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        obj3 = new UrlEncodedFormEntity(((List) (obj3)), "UTF-8");
        tracer2 = ((Tracer) (obj));
        tracer1 = ((Tracer) (obj1));
        tracer3 = s2;
        tracer4 = obj2;
        tracer = mAuthPortalHelper.startIdentityRequest(mContext, url, ((UrlEncodedFormEntity) (obj3)), true, null, s, s1, tracer);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        int i = tracer.getResponseCode();
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MAPLog.i(TAG, "Response received for exchange DMS to OAuth end-point");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj = JSONHelpers.toJson(tracer);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        platformmetricstimer.stop();
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        if (!mAuthPortalHelper.isFailure(i)) goto _L2; else goto _L1
_L1:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s1 = mAuthPortalHelper.handleTokenExchangeError(s, s1, ((JSONObject) (obj)), i, com.amazon.identity.auth.device.utils.AuthPortalHelper.AuthTokenExchangeType.DMSTokenToOauthTokenExchange, mMapAccountManager);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj = createErrorMsg(s1);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = "InvalidErrorResponse";
_L5:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MetricsHelper.increasePeriodicCounter("exchangeDMSCredentialsForOAuthTokenFailure", new String[] {
            s
        });
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        throw new OAuthTokenManagerException(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), ((String) (obj)), s1);
        s;
        tracer1 = tracer2;
        MetricsHelper.increasePeriodicCounter("exchangeDMSCredentialsForOAuthTokenFailure:IOException", new String[0]);
        tracer1 = tracer2;
        throw new OAuthTokenManagerException(3, s.getMessage());
        s;
        if (tracer1 != null)
        {
            tracer1.disconnect();
        }
        throw s;
_L4:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s = s1.getAuthTypeError().name();
        if (true) goto _L5; else goto _L2
_L2:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MetricsHelper.increasePeriodicCounter("exchangeDMSCredentialsForOAuthTokenSuccess", new String[0]);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj1 = ((JSONObject) (obj)).getJSONObject("response");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        i = ((JSONObject) (obj1)).getInt("expires_in");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s2 = ((JSONObject) (obj1)).getString("token_type");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj = ((JSONObject) (obj1)).getString("refresh_token");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj1 = ((JSONObject) (obj1)).getString("access_token");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        if ("bearer_token".equals(s2))
        {
            break MISSING_BLOCK_LABEL_925;
        }
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        throw new ParseException("Unexpected token type.", 0);
        s;
        tracer1 = tracer3;
        MetricsHelper.increasePeriodicCounter("exchangeDMSCredentialsForOAuthTokenFailure:ParseException", new String[0]);
        tracer1 = tracer3;
        throw new OAuthTokenManagerException(5, s.getMessage());
        if (obj1 != null && obj != null)
        {
            break MISSING_BLOCK_LABEL_995;
        }
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        throw new ParseException("Incomplete response.", 0);
        s;
        tracer1 = tracer4;
        MetricsHelper.increasePeriodicCounter("exchangeDMSCredentialsForOAuthTokenFailure:JSONException", new String[0]);
        tracer1 = tracer4;
        throw new OAuthTokenManagerException(5, s.getMessage());
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        storeOAuthTokens(s, s1, i, ((String) (obj)), ((String) (obj1)));
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        mServerRegSync.recordRegistrationCheckTime(s);
        if (flag)
        {
            s = ((String) (obj));
        } else
        {
            s = ((String) (obj1));
        }
        if (tracer != null)
        {
            tracer.disconnect();
        }
        return s;
    }

    private String getAuthDomainForDirectedId(String s)
    {
        return mLocalAppDataAwareDataStorage.getUserData(s, "authDomain");
    }

    private String getDirectedIdDelegatee(String s, Bundle bundle)
    {
        String s1 = bundle.getString("com.amazon.dcp.sso.property.account.delegateeaccount");
        bundle = s1;
        if (TextUtils.isEmpty(s1))
        {
            bundle = mDelegatedAccountHelper.getDelegateeAccountForTheDelegatedAccount(s, mLocalAppDataAwareDataStorage);
        }
        return bundle;
    }

    private URL getExchangeTokenURL(String s)
    {
        return getExchangeTokenURLCommon(getAuthDomainForDirectedId(s));
    }

    private URL getExchangeTokenURLCommon(String s)
        throws AssertionError
    {
        try
        {
            s = new URL("https", AmazonDomainHelper.getCompleteAuthPortalDomain(s), 443, "/ap/exchangetoken");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError("Should never happen; hardcoded constant.");
        }
        return s;
    }

    private String getLocalRefreshToken(String s, String s1)
    {
        return mLocalAppDataAwareDataStorage.peekToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
    }

    private String receiveAndStoreUpdatedTokensForOAuthRefresh(String s, String s1, JSONObject jsonobject)
        throws ParseException, JSONException
    {
        Object obj = jsonobject.getJSONObject("response");
        int i = ((JSONObject) (obj)).getInt("token_expires_in");
        jsonobject = ((JSONObject) (obj)).getString("token_type");
        obj = ((JSONObject) (obj)).getString("token");
        if (!"bearer_token".equals(jsonobject))
        {
            throw new ParseException("Unexpected token type.", 0);
        }
        if (obj == null)
        {
            throw new ParseException("Incomplete response.", 0);
        }
        if (mMapAccountManager.isAccountRegistered(s) || UnitTestUtils.isRunningInUnitTest())
        {
            storeOAuthTokens(s, s1, i, null, ((String) (obj)));
            mServerRegSync.recordRegistrationCheckTime(s);
        }
        return ((String) (obj));
    }

    private String refreshDelegatedOAuthTokenAndStore(String s, String s1, String s2, String s3, Bundle bundle, Tracer tracer)
        throws OAuthTokenManagerException
    {
        String s4;
        String s5;
        String s6;
        String s7;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj1 = null;
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "refreshDelegatedOAuthToken");
        Object obj;
        obj = null;
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        obj = mDelegatedAccountHelper.getDelegationDomainFromAPIBundle(bundle);
        bundle = ((Bundle) (obj));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        bundle = mDelegatedAccountHelper.getDelegationDomainForDirectedId(s1, mLocalAppDataAwareDataStorage);
        obj = bundle;
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        if (!TextUtils.isEmpty(bundle))
        {
            break MISSING_BLOCK_LABEL_183;
        }
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        obj = getAuthDomainForDirectedId(s1);
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        bundle = getExchangeTokenURLCommon(((String) (obj)));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        MAPLog.i(TAG, (new StringBuilder("Refreshing Delegated Oauth token with exchange token endpoint: ")).append(bundle.toString()).toString());
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        obj = new ArrayList();
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        addAppParams(((List) (obj)));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        ((List) (obj)).add(new BasicNameValuePair("source_token_type", "refresh_token"));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        ((List) (obj)).add(new BasicNameValuePair("source_token", s2));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        ((List) (obj)).add(new BasicNameValuePair("requested_token_type", "delegated_access_token"));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        ((List) (obj)).add(new BasicNameValuePair("directed_id", s1));
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        s2 = new UrlEncodedFormEntity(((List) (obj)), "UTF-8");
        s5 = obj1;
        s4 = obj2;
        s6 = obj3;
        s7 = obj4;
        s2 = mAuthPortalHelper.startIdentityRequest(mContext, bundle, s2, false, null, s1, s3, tracer);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        int i = s2.getResponseCode();
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        MAPLog.i(TAG, "Response received from OAuth refresh to delegated access exchange end-point");
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        bundle = JSONHelpers.toJson(s2);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        platformmetricstimer.stop();
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        if (!mAuthPortalHelper.isFailure(i)) goto _L2; else goto _L1
_L1:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s = mAuthPortalHelper.handleTokenExchangeError(s, s3, bundle, i, com.amazon.identity.auth.device.utils.AuthPortalHelper.AuthTokenExchangeType.OauthRefreshToDelegationAccessExchange, mMapAccountManager);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s1 = createErrorMsg(s);
        if (s != null) goto _L4; else goto _L3
_L3:
        s = "InvalidErrorResponse";
_L5:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        MetricsHelper.increasePeriodicCounter("refreshDelegatedOAuthTokenFailure", new String[] {
            s
        });
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        throw new OAuthTokenManagerException(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), s1);
        s;
        s4 = s5;
        MetricsHelper.increasePeriodicCounter("refreshDelegatedOAuthTokenFailure:IOException", new String[0]);
        s4 = s5;
        throw new OAuthTokenManagerException(3, s.getMessage(), s);
        s;
        if (s4 != null)
        {
            s4.disconnect();
        }
        throw s;
_L4:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s = s.getAuthTypeError().name();
        if (true) goto _L5; else goto _L2
_L2:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        MetricsHelper.increasePeriodicCounter("refreshDelegatedOAuthTokenSuccess", new String[0]);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s = receiveAndStoreUpdatedTokensForOAuthRefresh(s1, s3, bundle);
        if (s2 != null)
        {
            s2.disconnect();
        }
        return s;
        s;
        s4 = s6;
        MetricsHelper.increasePeriodicCounter("refreshDelegatedOAuthTokenFailure:ParseException", new String[0]);
        s4 = s6;
        throw new OAuthTokenManagerException(5, s.getMessage(), s);
        s;
        s4 = s7;
        MetricsHelper.increasePeriodicCounter("refreshDelegatedOAuthTokenFailure:JSONException", new String[0]);
        s4 = s7;
        throw new OAuthTokenManagerException(5, s.getMessage(), s);
    }

    private String refreshNormalOAuthTokenAndStore(String s, String s1, Tracer tracer)
        throws OAuthTokenManagerException
    {
        Tracer tracer1;
        Tracer tracer2;
        Tracer tracer3;
        Tracer tracer4;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        Object obj4 = mLocalAppDataAwareDataStorage.getToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
        if (obj4 != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        return exchangeDMSCredentialsForOAuthTokenAndStore(s, s1, false, tracer);
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "refreshNormalOAuthToken");
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        URL url = getExchangeTokenURL(s);
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        MAPLog.i(TAG, (new StringBuilder("Refreshing Normal OAuth token with exchange token endpoint: ")).append(url.toString()).toString());
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        ArrayList arraylist = new ArrayList();
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        addAppParams(arraylist);
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        arraylist.add(new BasicNameValuePair("source_token_type", "refresh_token"));
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        arraylist.add(new BasicNameValuePair("source_token", ((String) (obj4))));
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        arraylist.add(new BasicNameValuePair("requested_token_type", "access_token"));
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        obj4 = new UrlEncodedFormEntity(arraylist, "UTF-8");
        tracer2 = ((Tracer) (obj));
        tracer1 = obj1;
        tracer3 = obj2;
        tracer4 = obj3;
        tracer = mAuthPortalHelper.startIdentityRequest(mContext, url, ((UrlEncodedFormEntity) (obj4)), false, null, s, s1, tracer);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        int i = tracer.getResponseCode();
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MAPLog.i(TAG, "Response received from OAuth refresh to access exchange end-point");
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj = JSONHelpers.toJson(tracer);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        platformmetricstimer.stop();
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        if (!mAuthPortalHelper.isFailure(i)) goto _L2; else goto _L1
_L1:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s1 = mAuthPortalHelper.handleTokenExchangeError(s, s1, ((JSONObject) (obj)), i, com.amazon.identity.auth.device.utils.AuthPortalHelper.AuthTokenExchangeType.OauthRefreshToAccessExchange, mMapAccountManager);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        obj = createErrorMsg(s1);
        if (s1 != null) goto _L4; else goto _L3
_L3:
        s = "InvalidErrorResponse";
_L5:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MetricsHelper.increasePeriodicCounter("refreshNormalOAuthTokenFailure", new String[] {
            s
        });
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        throw new OAuthTokenManagerException(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), ((String) (obj)), s1);
        s;
        tracer1 = tracer2;
        MetricsHelper.increasePeriodicCounter("refreshNormalOAuthTokenFailure:IOException", new String[0]);
        tracer1 = tracer2;
        throw new OAuthTokenManagerException(3, s.getMessage());
        s;
        if (tracer1 != null)
        {
            tracer1.disconnect();
        }
        throw s;
_L4:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s = s1.getAuthTypeError().name();
        if (true) goto _L5; else goto _L2
_L2:
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        MetricsHelper.increasePeriodicCounter("refreshNormalOAuthTokenSuccess", new String[0]);
        tracer2 = tracer;
        tracer1 = tracer;
        tracer3 = tracer;
        tracer4 = tracer;
        s = receiveAndStoreUpdatedTokensForOAuthRefresh(s, s1, ((JSONObject) (obj)));
        if (tracer != null)
        {
            tracer.disconnect();
            return s;
        } else
        {
            return s;
        }
        s;
        tracer1 = tracer3;
        MetricsHelper.increasePeriodicCounter("refreshNormalOAuthTokenFailure:ParseException", new String[0]);
        tracer1 = tracer3;
        throw new OAuthTokenManagerException(5, s.getMessage());
        s;
        tracer1 = tracer4;
        MetricsHelper.increasePeriodicCounter("refreshNormalOAuthTokenFailure:JSONException", new String[0]);
        tracer1 = tracer4;
        throw new OAuthTokenManagerException(5, s.getMessage());
    }

    private boolean requireExchangeDMSTokenForOAuthToken(Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        if (bundle.getBoolean("com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshDMSTokenForOAuthToken"))
        {
            MAPLog.i(TAG, "Force refresh the DMS token for OAuth token.");
            return true;
        } else
        {
            return false;
        }
    }

    private boolean requireOAuthRefreshTokenExchange(String s, KeyInfo keyinfo, Bundle bundle)
    {
        if (!hasLocalOAuthAccessToken(s, keyinfo.getPackageName()))
        {
            return true;
        } else
        {
            return shouldRefreshExistingAccessToken(s, keyinfo, bundle);
        }
    }

    private void tryToCorrectTheOAuthTokensFor3PCentralDevicetype(String s, String s1, boolean flag, Tracer tracer)
        throws OAuthTokenManagerException
    {
        boolean flag2 = true;
        boolean flag1 = flag2;
        if (PlatformUtils.isThirdPartyDevice(mContext))
        {
            flag1 = flag2;
            if (DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, s1))
            {
                flag1 = TextUtils.equals("true", mLocalAppDataAwareDataStorage.getUserData(s, "force_refresh_dms_to_oauth_done_once"));
            }
        }
        if (!flag1)
        {
            exchangeDMSCredentialsForOAuthTokenAndStore(s, s1, flag, tracer);
            mLocalAppDataAwareDataStorage.setUserData(s, "force_refresh_dms_to_oauth_done_once", "true");
            MetricsHelper.increasePeriodicCounter("fixCentralTokenOn3PDevices", new String[0]);
        }
    }

    public String getAccessToken(String s, KeyInfo keyinfo, Bundle bundle, Tracer tracer)
        throws OAuthTokenManagerException
    {
        Bundle bundle1;
        String s1;
        Object obj;
        String s3;
        s1 = null;
        obj = null;
        if (TextUtils.isEmpty(s))
        {
            throw new OAuthTokenManagerException(8, "Given Account is currently not valid");
        }
        if (!"com.amazon.dcp.sso.token.oauth.amazon.access_token".equals(keyinfo.getKey()))
        {
            throw new OAuthTokenManagerException(7, String.format("Token key %s is not a valid key", new Object[] {
                keyinfo.getRawKey()
            }));
        }
        if (bundle == null)
        {
            bundle1 = new Bundle();
        } else
        {
            bundle1 = bundle;
        }
        s3 = getDirectedIdDelegatee(s, bundle1);
        if (TextUtils.isEmpty(s3)) goto _L2; else goto _L1
_L1:
        if (TextUtils.isEmpty(s3) || TextUtils.isEmpty(s))
        {
            throw new OAuthTokenManagerException(8, "Given account or delegated account is currently not valid");
        }
        s1 = keyinfo.getPackageName();
        if (!mMapAccountManager.isAccountRegistered(s3) && !UnitTestUtils.isRunningInUnitTest())
        {
            MAPLog.w(TAG, "The delegatee account is already deregistered.");
            s = TAG;
            String.format("The delegatee account %s is already deregistered.", new Object[] {
                s3
            });
            throw new OAuthTokenManagerException(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED.value(), "The delegatee account is already deregistered on this device");
        }
        if (!requireExchangeDMSTokenForOAuthToken(bundle1)) goto _L4; else goto _L3
_L3:
        bundle = refreshDelegatedOAuthTokenAndStore(s3, s, exchangeDMSCredentialsForOAuthTokenAndStore(s3, keyinfo.getPackageName(), true, tracer), keyinfo.getPackageName(), bundle1, tracer);
_L6:
        tracer = bundle;
        if (TextUtils.isEmpty(bundle))
        {
            tracer = mLocalAppDataAwareDataStorage.getToken(s, keyinfo.getRawKey());
        }
        return tracer;
_L4:
        bundle = obj;
        if (requireOAuthRefreshTokenExchange(s, keyinfo, bundle1))
        {
            s1 = getRefreshToken(s3, s1, tracer);
            bundle = s1;
            if (TextUtils.isEmpty(s1))
            {
                bundle = exchangeDMSCredentialsForOAuthTokenAndStore(s3, keyinfo.getPackageName(), true, tracer);
            }
            bundle = refreshDelegatedOAuthTokenAndStore(s3, s, bundle, keyinfo.getPackageName(), bundle1, tracer);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        bundle = keyinfo.getPackageName();
        String s2 = TAG;
        (new StringBuilder("Getting access token for package ")).append(bundle).toString();
        tryToCorrectTheOAuthTokensFor3PCentralDevicetype(s, bundle, false, tracer);
        if (!hasLocalOAuthRefreshToken(s, bundle) || requireExchangeDMSTokenForOAuthToken(bundle1))
        {
            bundle = exchangeDMSCredentialsForOAuthTokenAndStore(s, keyinfo.getPackageName(), false, tracer);
        } else
        {
            bundle = s1;
            if (requireOAuthRefreshTokenExchange(s, keyinfo, bundle1))
            {
                bundle = refreshOAuthTokenAndStore(s, keyinfo.getPackageName(), tracer);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getOAuthToken(String s, KeyInfo keyinfo, Tracer tracer)
        throws OAuthTokenManagerException
    {
        if ("com.amazon.dcp.sso.token.oauth.amazon.access_token".equals(keyinfo.getKey()))
        {
            return getAccessToken(s, keyinfo, null, tracer);
        }
        if ("com.amazon.dcp.sso.token.oauth.amazon.refresh_token".equals(keyinfo.getKey()))
        {
            return getRefreshToken(s, keyinfo.getPackageName(), tracer);
        } else
        {
            throw new OAuthTokenManagerException(7, String.format("Token key %s is not a valid key", new Object[] {
                keyinfo.getRawKey()
            }));
        }
    }

    public String getRefreshToken(String s, String s1, Tracer tracer)
        throws OAuthTokenManagerException
    {
        tryToCorrectTheOAuthTokensFor3PCentralDevicetype(s, s1, true, tracer);
        String s2 = getLocalRefreshToken(s, s1);
        if (s2 != null)
        {
            return s2;
        } else
        {
            return exchangeDMSCredentialsForOAuthTokenAndStore(s, s1, true, tracer);
        }
    }

    public Map getTokenMapFromRegistrationData(Bundle bundle)
    {
        HashMap hashmap;
        String s;
        int i;
        if (bundle == null || bundle.size() <= 0)
        {
            return Collections.emptyMap();
        }
        hashmap = new HashMap();
        s = bundle.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        i = 0;
        int j = Integer.parseInt(bundle.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"));
        i = j;
_L2:
        bundle = bundle.getString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token");
        long l = System.currentTimeMillis();
        long l1 = TimeUnit.MILLISECONDS.convert(i, TimeUnit.SECONDS);
        hashmap.put(TokenKeys.getAccessTokenKeyForPackage(null), s);
        hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(null, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"), Long.toString(l + l1));
        hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(null, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"), bundle);
        hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(null, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"), Long.toString(l));
        return hashmap;
        NumberFormatException numberformatexception;
        numberformatexception;
        MAPLog.e(TAG, "NumberFormatException fetching expiresInSeconds data");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean hasLocalOAuthAccessToken(String s, String s1)
    {
        return mLocalAppDataAwareDataStorage.peekToken(s, TokenKeys.getAccessTokenKeyForPackage(s1)) != null;
    }

    public boolean hasLocalOAuthRefreshToken(String s, String s1)
    {
        return getLocalRefreshToken(s, s1) != null;
    }

    public String refreshOAuthTokenAndStore(String s, String s1, Tracer tracer)
        throws OAuthTokenManagerException
    {
        if (s == null)
        {
            throw new OAuthTokenManagerException(8, "Given Account is currently not valid");
        }
        String s3 = TAG;
        Object obj = new StringBuilder("Refreshing access token for ");
        String s2;
        if (s1 != null)
        {
            s2 = (new StringBuilder("package ")).append(s1).toString();
        } else
        {
            s2 = "central";
        }
        MAPLog.i(s3, ((StringBuilder) (obj)).append(s2).toString());
        obj = getDirectedIdDelegatee(s, new Bundle());
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            String s4 = mLocalAppDataAwareDataStorage.getToken(((String) (obj)), StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
            s2 = s4;
            if (TextUtils.isEmpty(s4))
            {
                s2 = exchangeDMSCredentialsForOAuthTokenAndStore(((String) (obj)), s1, true, tracer);
            }
            return refreshDelegatedOAuthTokenAndStore(((String) (obj)), s, s2, s1, new Bundle(), tracer);
        } else
        {
            return refreshNormalOAuthTokenAndStore(s, s1, tracer);
        }
    }

    public boolean shouldRefreshExistingAccessToken(String s, KeyInfo keyinfo, Bundle bundle)
    {
        Object obj;
        long l;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        if (bundle.getBoolean("com.amazon.identity.auth.device.api.TokenKeys.Options.ForceRefreshOAuthToken"))
        {
            MAPLog.i(TAG, "Force refresh the OAuth access token.");
            return true;
        }
        obj = mLocalAppDataAwareDataStorage.getToken(s, StorageKeyUtils.getKeyWithPackageNamespace(keyinfo.getPackageName(), "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"));
        l = mSystemWrapper.currentTimeMillis();
        if (TextUtils.isEmpty(((CharSequence) (obj)))) goto _L2; else goto _L1
_L1:
        obj = StringConversionHelpers.toLong(((String) (obj)));
        if (obj == null || l >= ((Long) (obj)).longValue()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        if (flag)
        {
            MAPLog.i(TAG, "Clock skew detected. Refreshing...");
            return true;
        }
        break; /* Loop/switch isn't completed */
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        s = StringConversionHelpers.toLong(mLocalAppDataAwareDataStorage.getToken(s, StorageKeyUtils.getKeyWithPackageNamespace(keyinfo.getPackageName(), "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at")));
        if (s != null)
        {
            boolean flag1;
            if (Long.valueOf(l).longValue() + bundle.getLong("com.amazon.identity.auth.device.api.TokenKeys.Options.OAuthAccessTokenTTLInMilliSec", 0L) + FUDGE_FACTOR >= s.longValue())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                MAPLog.i(TAG, "OAuth access token near or past expiry. Refreshing...");
                return true;
            }
        }
        return false;
    }

    public void storeOAuthTokens(String s, String s1, int i, String s2, String s3)
    {
        long l = System.currentTimeMillis();
        long l1 = TimeUnit.MILLISECONDS.convert(i, TimeUnit.SECONDS);
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(s2))
        {
            hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"), s2);
        }
        hashmap.put(TokenKeys.getAccessTokenKeyForPackage(s1), s3);
        hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"), Long.toString(l + l1));
        hashmap.put(StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.access_token.refreshed_at"), Long.toString(l));
        mLocalAppDataAwareDataStorage.setTokens(s, hashmap);
    }

    static 
    {
        FUDGE_FACTOR = TimeUtil.fromMinutesTo(1L, TimeUnit.MILLISECONDS);
    }
}
