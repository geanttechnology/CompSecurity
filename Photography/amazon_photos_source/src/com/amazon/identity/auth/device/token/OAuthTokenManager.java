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
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.SystemWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.utils.AuthPortalExchangeTokenHelper;
import com.amazon.identity.auth.device.utils.AuthPortalHelper;
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
import java.net.URL;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            ServerRegistrationSyncHelper, PandaOAuthExchangeRequestHelper, ExchangeTokenRequestHelperDefinition, AuthPortalOAuthExchangeRequestHelper

public class OAuthTokenManager
{
    public static final class AuthTokenExchangeType extends Enum
    {

        private static final AuthTokenExchangeType $VALUES[];
        public static final AuthTokenExchangeType DMSTokenToOauthTokenExchange;
        public static final AuthTokenExchangeType OauthRefreshToAccessExchange;
        public static final AuthTokenExchangeType OauthRefreshToCookieExchange;
        public static final AuthTokenExchangeType OauthRefreshToDelegationAccessExchange;
        final String mFailureMetric;

        public static AuthTokenExchangeType valueOf(String s)
        {
            return (AuthTokenExchangeType)Enum.valueOf(com/amazon/identity/auth/device/token/OAuthTokenManager$AuthTokenExchangeType, s);
        }

        public static AuthTokenExchangeType[] values()
        {
            return (AuthTokenExchangeType[])$VALUES.clone();
        }

        static 
        {
            DMSTokenToOauthTokenExchange = new AuthTokenExchangeType("DMSTokenToOauthTokenExchange", 0, "exchangeDMSCredentialsForOAuthTokenFailure");
            OauthRefreshToAccessExchange = new AuthTokenExchangeType("OauthRefreshToAccessExchange", 1, "refreshNormalOAuthTokenFailure");
            OauthRefreshToCookieExchange = new AuthTokenExchangeType("OauthRefreshToCookieExchange", 2, "fetchCookiesFromServerFailure");
            OauthRefreshToDelegationAccessExchange = new AuthTokenExchangeType("OauthRefreshToDelegationAccessExchange", 3, "refreshDelegatedOAuthTokenFailure");
            $VALUES = (new AuthTokenExchangeType[] {
                DMSTokenToOauthTokenExchange, OauthRefreshToAccessExchange, OauthRefreshToCookieExchange, OauthRefreshToDelegationAccessExchange
            });
        }

        private AuthTokenExchangeType(String s, int i, String s1)
        {
            super(s, i);
            mFailureMetric = s1;
        }
    }

    public static class ExchangeTokenResponse
    {

        final String mAccessToken;
        final int mExpiresIn;
        final String mRefreshToken;

        public ExchangeTokenResponse(String s, int i)
        {
            this(s, i, null);
        }

        public ExchangeTokenResponse(String s, int i, String s1)
        {
            mAccessToken = s;
            mExpiresIn = i;
            mRefreshToken = s1;
        }
    }

    public static final class OAuthTokenManagerException extends Exception
    {

        private static final long serialVersionUID = 0x99ef63de08a68351L;
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


    private static final Set EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN = EnumSet.allOf(com/amazon/identity/auth/device/token/OAuthTokenManager$AuthTokenExchangeType);
    private static final long FUDGE_FACTOR;
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/token/OAuthTokenManager.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/token/OAuthTokenManager.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser = new AuthEndpointErrorParser();
    private final AuthPortalExchangeTokenHelper mAuthPortalExchangeTokenHelper = new AuthPortalExchangeTokenHelper();
    private final AuthPortalHelper mAuthPortalHelper = new AuthPortalHelper();
    private final ServiceWrappingContext mContext;
    private final DelegatedAccountHelper mDelegatedAccountHelper = new DelegatedAccountHelper();
    private final FeatureSet mFeatureSet;
    private final LocalAppDataAwareDataStorage mLocalAppDataAwareDataStorage;
    private final MAPAccountManager mMapAccountManager;
    private final ServerRegistrationSyncHelper mServerRegSync;
    private final SystemWrapper mSystemWrapper;

    public OAuthTokenManager(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mSystemWrapper = (SystemWrapper)mContext.getSystemService("dcp_system");
        mLocalAppDataAwareDataStorage = new LocalAppDataAwareDataStorage(mContext);
        mMapAccountManager = new MAPAccountManager(mContext);
        mServerRegSync = new ServerRegistrationSyncHelper(mContext, mLocalAppDataAwareDataStorage);
        mFeatureSet = mContext.getFeatureSet();
    }

    private String exchangeDMSCredentialsForOAuthTokenAndStore(String s, String s1, boolean flag, Tracer tracer)
        throws OAuthTokenManagerException
    {
        Object obj;
        Tracer tracer1;
        Tracer tracer2;
        Tracer tracer3;
        Object obj1;
        JSONObject jsonobject;
        Object obj2;
        Object obj3;
        if (s == null)
        {
            throw new OAuthTokenManagerException(8, "Given Account is currently not valid");
        }
        MAPLog.i(TAG, (new StringBuilder("Exchange DMS token to OAuth token for package ")).append(s1).append(" due to ").append(tracer.getPackageToBlame(mContext)).toString());
        jsonobject = null;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        tracer1 = ((Tracer) (obj1));
        obj = jsonobject;
        tracer2 = obj2;
        tracer3 = obj3;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "exchangeDMSCredentialsForOAuthToken");
        tracer1 = ((Tracer) (obj1));
        obj = jsonobject;
        tracer2 = obj2;
        tracer3 = obj3;
        URL url = mAuthPortalExchangeTokenHelper.getExchangeTokenURL(mContext, s);
        tracer1 = ((Tracer) (obj1));
        obj = jsonobject;
        tracer2 = obj2;
        tracer3 = obj3;
        MAPLog.i(TAG, (new StringBuilder("Exchanging DMS token with exchange token endpoint: ")).append(url.toString()).toString());
        tracer1 = ((Tracer) (obj1));
        obj = jsonobject;
        tracer2 = obj2;
        tracer3 = obj3;
        org.apache.http.client.entity.UrlEncodedFormEntity urlencodedformentity = mAuthPortalExchangeTokenHelper.getDMSExchangeTokenBody(mContext);
        tracer1 = ((Tracer) (obj1));
        obj = jsonobject;
        tracer2 = obj2;
        tracer3 = obj3;
        tracer = mAuthPortalHelper.startIdentityRequestURLEncoded(mContext, url, urlencodedformentity, true, null, s, s1, tracer);
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        int i = tracer.getResponseCode();
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        MAPLog.i(TAG, "Response received for exchange DMS to OAuth end-point");
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        jsonobject = JSONHelpers.toJson(tracer);
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        platformmetricstimer.stop();
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        if (!mAuthPortalHelper.isFailure(i) && jsonobject != null) goto _L2; else goto _L1
_L1:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        obj1 = TAG;
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        obj1 = jsonobject.toString();
        obj = obj1;
_L5:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        throw handleTokenExchangeError(s, s1, mAuthEndpointErrorParser.parse(jsonobject), i, AuthTokenExchangeType.DMSTokenToOauthTokenExchange);
        s;
        obj = tracer1;
        MetricsHelper.incrementCounter("exchangeDMSCredentialsForOAuthTokenFailure:IOException", new String[0]);
        obj = tracer1;
        throw new OAuthTokenManagerException(3, s.getMessage());
        s;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
_L4:
        obj = "Null Json Response";
        if (true) goto _L5; else goto _L2
_L2:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        MetricsHelper.incrementCounter("exchangeDMSCredentialsForOAuthTokenSuccess", new String[0]);
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        obj1 = mAuthPortalExchangeTokenHelper.handleDMSExchangeTokenSuccess(jsonobject);
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        receiveAndStoreUpdatedTokensForOAuthRefresh(s, s1, ((ExchangeTokenResponse) (obj1)));
        if (!flag) goto _L7; else goto _L6
_L6:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        s1 = ((ExchangeTokenResponse) (obj1)).mRefreshToken;
        s = s1;
        if (tracer != null)
        {
            tracer.disconnect();
            s = s1;
        }
_L8:
        return s;
_L7:
        tracer1 = tracer;
        obj = tracer;
        tracer2 = tracer;
        tracer3 = tracer;
        s1 = ((ExchangeTokenResponse) (obj1)).mAccessToken;
        s = s1;
        if (tracer != null)
        {
            tracer.disconnect();
            return s1;
        }
          goto _L8
        s;
        obj = tracer2;
        MetricsHelper.incrementCounter("exchangeDMSCredentialsForOAuthTokenFailure:ParseException", new String[0]);
        obj = tracer2;
        throw new OAuthTokenManagerException(5, s.getMessage());
        s;
        obj = tracer3;
        MetricsHelper.incrementCounter("exchangeDMSCredentialsForOAuthTokenFailure:JSONException", new String[0]);
        obj = tracer3;
        throw new OAuthTokenManagerException(5, s.getMessage());
          goto _L8
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

    private String getLocalRefreshToken(String s, String s1)
    {
        return mLocalAppDataAwareDataStorage.peekToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
    }

    private void receiveAndStoreUpdatedTokensForOAuthRefresh(String s, String s1, ExchangeTokenResponse exchangetokenresponse)
    {
        if (mMapAccountManager.isAccountRegistered(s) || UnitTestUtils.isRunningInUnitTest())
        {
            storeOAuthTokens(s, s1, exchangetokenresponse.mExpiresIn, exchangetokenresponse.mRefreshToken, exchangetokenresponse.mAccessToken);
            mServerRegSync.recordRegistrationCheckTime(s);
        }
    }

    private String refreshDelegatedOAuthTokenAndStore(String s, String s1, String s2, String s3, Bundle bundle, Tracer tracer)
        throws OAuthTokenManagerException
    {
        String s4;
        String s5;
        String s6;
        String s7;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        obj2 = null;
        obj3 = null;
        obj = null;
        s5 = obj;
        s4 = obj1;
        s6 = obj2;
        s7 = obj3;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "refreshDelegatedOAuthToken");
        s5 = obj;
        s4 = obj1;
        s6 = obj2;
        s7 = obj3;
        bundle = mAuthPortalExchangeTokenHelper.getDelegationExchangeTokenURL(mContext, s1, bundle);
        s5 = obj;
        s4 = obj1;
        s6 = obj2;
        s7 = obj3;
        MAPLog.i(TAG, (new StringBuilder("Refreshing Delegated Oauth token with exchange token endpoint ")).append(bundle.toString()).append(" due to ").append(tracer.getPackageToBlame(mContext)).toString());
        s5 = obj;
        s4 = obj1;
        s6 = obj2;
        s7 = obj3;
        s2 = mAuthPortalExchangeTokenHelper.getRefreshDelegatedOAuthTokenBody(mContext, s2, s1);
        s5 = obj;
        s4 = obj1;
        s6 = obj2;
        s7 = obj3;
        s2 = mAuthPortalHelper.startIdentityRequestURLEncoded(mContext, bundle, s2, false, null, s1, s3, tracer);
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
        if (!mAuthPortalHelper.isFailure(i) && bundle != null) goto _L2; else goto _L1
_L1:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s1 = TAG;
        if (bundle == null) goto _L4; else goto _L3
_L3:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s1 = bundle.toString();
_L5:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        throw handleTokenExchangeError(s, s3, mAuthEndpointErrorParser.parse(bundle), i, AuthTokenExchangeType.OauthRefreshToDelegationAccessExchange);
        s;
        s4 = s5;
        MetricsHelper.incrementCounter("refreshDelegatedOAuthTokenFailure:IOException", new String[0]);
        s4 = s5;
        throw new OAuthTokenManagerException(3, s.getMessage(), s);
        s;
        if (s4 != null)
        {
            s4.disconnect();
        }
        throw s;
_L4:
        s1 = "Null Json Response";
        if (true) goto _L5; else goto _L2
_L2:
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        MetricsHelper.incrementCounter("refreshDelegatedOAuthTokenSuccess", new String[0]);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s = mAuthPortalExchangeTokenHelper.handleExchangeTokenSuccess(bundle);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        receiveAndStoreUpdatedTokensForOAuthRefresh(s1, s3, s);
        s5 = s2;
        s4 = s2;
        s6 = s2;
        s7 = s2;
        s = ((ExchangeTokenResponse) (s)).mAccessToken;
        if (s2 != null)
        {
            s2.disconnect();
        }
        return s;
        s;
        s4 = s6;
        MetricsHelper.incrementCounter("refreshDelegatedOAuthTokenFailure:ParseException", new String[0]);
        s4 = s6;
        throw new OAuthTokenManagerException(5, s.getMessage(), s);
        s;
        s4 = s7;
        MetricsHelper.incrementCounter("refreshDelegatedOAuthTokenFailure:JSONException", new String[0]);
        s4 = s7;
        throw new OAuthTokenManagerException(5, s.getMessage(), s);
    }

    private String refreshNormalOAuthTokenAndStore(String s, String s1, Tracer tracer)
        throws OAuthTokenManagerException
    {
        Object obj;
        Object obj1;
        Tracer tracer1;
        Tracer tracer2;
        String s2;
        JSONObject jsonobject;
        Object obj3;
        Object obj4;
        jsonobject = null;
        obj3 = null;
        obj4 = null;
        s2 = null;
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        String s3 = mLocalAppDataAwareDataStorage.getToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
        if (s3 != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        return exchangeDMSCredentialsForOAuthTokenAndStore(s, s1, false, tracer);
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "refreshNormalOAuthToken");
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        if (!mFeatureSet.hasFeature(Feature.PandaExchangeRefreshToAccess)) goto _L2; else goto _L1
_L1:
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        Object obj2 = new PandaOAuthExchangeRequestHelper(mContext, mAuthPortalHelper);
_L5:
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        tracer = ((ExchangeTokenRequestHelperDefinition) (obj2)).startExchangeTokenRequest(s3, s, s1, tracer);
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        int i = tracer.getResponseCode();
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        MAPLog.i(TAG, "Response received from OAuth refresh to access exchange end-point");
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        jsonobject = JSONHelpers.toJson(tracer);
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        platformmetricstimer.stop();
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        if (!((ExchangeTokenRequestHelperDefinition) (obj2)).isFailure(i) && jsonobject != null) goto _L4; else goto _L3
_L3:
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        s2 = TAG;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_614;
        }
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        s2 = jsonobject.toString();
        obj = s2;
_L6:
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        throw handleTokenExchangeError(s, s1, ((ExchangeTokenRequestHelperDefinition) (obj2)).parseExchangeTokenFailure(jsonobject), i, AuthTokenExchangeType.OauthRefreshToAccessExchange);
        s;
        obj = obj1;
        MetricsHelper.incrementCounter("refreshNormalOAuthTokenFailure:IOException", new String[0]);
        obj = obj1;
        throw new OAuthTokenManagerException(3, s.getMessage());
        s;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
_L2:
        obj1 = s2;
        obj = jsonobject;
        tracer1 = obj3;
        tracer2 = obj4;
        obj2 = new AuthPortalOAuthExchangeRequestHelper(mContext, mAuthPortalHelper);
          goto _L5
_L4:
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        obj2 = ((ExchangeTokenRequestHelperDefinition) (obj2)).parseExchangeTokenSuccess(jsonobject);
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        MetricsHelper.incrementCounter("refreshNormalOAuthTokenSuccess", new String[0]);
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        receiveAndStoreUpdatedTokensForOAuthRefresh(s, s1, ((ExchangeTokenResponse) (obj2)));
        obj1 = tracer;
        obj = tracer;
        tracer1 = tracer;
        tracer2 = tracer;
        s = ((ExchangeTokenResponse) (obj2)).mAccessToken;
        if (tracer != null)
        {
            tracer.disconnect();
            return s;
        } else
        {
            return s;
        }
        s;
        obj = tracer1;
        MetricsHelper.incrementCounter("refreshNormalOAuthTokenFailure:ParseException", new String[0]);
        obj = tracer1;
        throw new OAuthTokenManagerException(5, s.getMessage());
        s;
        obj = tracer2;
        MetricsHelper.incrementCounter("refreshNormalOAuthTokenFailure:JSONException", new String[0]);
        obj = tracer2;
        throw new OAuthTokenManagerException(5, s.getMessage());
        obj = "Null Json Response";
          goto _L6
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
                flag1 = flag2;
                if (!mFeatureSet.hasFeature(Feature.IsolateApplication))
                {
                    flag1 = TextUtils.equals("true", mLocalAppDataAwareDataStorage.getUserData(s, "force_refresh_dms_to_oauth_done_once"));
                }
            }
        }
        if (!flag1)
        {
            exchangeDMSCredentialsForOAuthTokenAndStore(s, s1, flag, tracer);
            mLocalAppDataAwareDataStorage.setUserData(s, "force_refresh_dms_to_oauth_done_once", "true");
            MetricsHelper.incrementCounter("fixCentralTokenOn3PDevices", new String[0]);
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

    public OAuthTokenManagerException handleTokenExchangeError(String s, String s1, com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthEndpointError authendpointerror, int i, AuthTokenExchangeType authtokenexchangetype)
    {
        if (authendpointerror == null)
        {
            MAPLog.e(TAG, String.format("Received unrecongized error from the server with status code %d", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            mLocalAppDataAwareDataStorage.expireToken(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, "com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
            if (EXCHANGE_TYPES_REQUIRE_DEREGISTER_WHEN_INVALID_TOKEN.contains(authtokenexchangetype) && (authendpointerror.getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.InvalidToken || authendpointerror.getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.InvalidValue))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                mMapAccountManager.deregisterAccount(s, new CallbackFuture());
            }
            MAPLog.e(TAG, String.format("Received error code: %s \n Message: %s \n Detail: %s", new Object[] {
                authendpointerror.getAuthTypeError().getCode(), authendpointerror.getMessage(), authendpointerror.getDetail()
            }));
        }
        if (authendpointerror != null)
        {
            s = String.format("Received Error code %s from the server. Message: %s Detail: %s", new Object[] {
                authendpointerror.getAuthTypeError().getCode(), authendpointerror.getMessage(), authendpointerror.getDetail()
            });
        } else
        {
            s = "Invalid error response received from the token exchange endpoint";
        }
        authtokenexchangetype = authtokenexchangetype.mFailureMetric;
        if (authendpointerror == null)
        {
            s1 = "InvalidErrorResponse";
        } else
        {
            s1 = authendpointerror.getAuthTypeError().name();
        }
        MetricsHelper.incrementCounter(authtokenexchangetype, new String[] {
            s1
        });
        return new OAuthTokenManagerException(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR.value(), s, authendpointerror);
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
