// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.AmazonWebServiceCallerCreator;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.kcpsdk.auth.AuthenticateAccountError;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCaller;
import com.amazon.identity.kcpsdk.auth.JwtSigner;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountRequest;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountResponse;
import com.amazon.identity.kcpsdk.auth.PandaAuthenticateAccountResponseParser;
import com.amazon.identity.kcpsdk.common.LocaleUtil;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class AccountAuthenticator
{
    private static class AuthenticateAccountAmazonWebserviceCallListener extends DefaultAmazonWebserviceCallListener
    {

        protected final Callback mCallback;

        private Bundle bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, String s)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("com.amazon.dcp.sso.ErrorCode", registrationerror.value());
            bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
            return bundle;
        }

        public void onAuthenticationFailed()
        {
            MAPLog.e(AccountAuthenticator.TAG, "Authentication failure performing authenticate account request");
            mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED, "Failed to authenticate"));
        }

        public void onNetworkFailure()
        {
            MAPLog.e(AccountAuthenticator.TAG, "Network failure performing authenticate account request. ");
            mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE, "Network failure occured while authenticating account. Please check your internet connectivity"));
        }

        public void onParseError$6fe276bc()
        {
            MAPLog.e(AccountAuthenticator.TAG, "Parsing failure performing authenticate account  request");
            mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR, "Failed to parse the response"));
        }

        public void onResponseComplete(Object obj)
        {
            String _tmp = AccountAuthenticator.TAG;
            (new StringBuilder("Got completed response of type (")).append(obj.getClass().getName()).append("): ").append(obj);
            Object obj1 = (PandaAuthenticateAccountResponse)obj;
            if (((PandaAuthenticateAccountResponse) (obj1)).getError() != null)
            {
                obj = ((PandaAuthenticateAccountResponse) (obj1)).getError();
                obj1 = ((PandaAuthenticateAccountResponse) (obj1)).getChallenge();
                static class _cls1
                {

                    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[];

                    static 
                    {
                        $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError = new int[AuthenticateAccountError.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorCredentialError.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorInvalidValue.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorMissingValue.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorServerError.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorServiceUnavailable.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorUnknown.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$AuthenticateAccountError[AuthenticateAccountError.AuthenticateAccountErrorChallengeException.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                Bundle bundle;
                switch (_cls1..SwitchMap.com.amazon.identity.kcpsdk.auth.AuthenticateAccountError[((AuthenticateAccountError) (obj)).ordinal()])
                {
                default:
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Unrecognized response.");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 1: // '\001'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Crentials Invalid");
                    obj = bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND, ((AuthenticateAccountError) (obj)).getErrorString());
                    if (obj1 != null)
                    {
                        ((AuthenticationChallenge) (obj1)).addAdditionalInfoToBundle(((Bundle) (obj)));
                    }
                    mCallback.onError(((Bundle) (obj)));
                    return;

                case 2: // '\002'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Invalid Value");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 3: // '\003'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Missing Value");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 4: // '\004'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Server Error");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 5: // '\005'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Service Unavailable");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 6: // '\006'
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Unknown.");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;

                case 7: // '\007'
                    MAPLog.i(AccountAuthenticator.TAG, "Authentication Error: Challenge Exception.");
                    bundle = bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_CHALLENGED, ((AuthenticateAccountError) (obj)).getErrorString());
                    break;
                }
                if (obj1 == null)
                {
                    MAPLog.e(AccountAuthenticator.TAG, "Authentication Error: Unknown. Challenge Exception was missing.");
                    mCallback.onError(bundleWithErrorCode(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, ((AuthenticateAccountError) (obj)).getErrorString()));
                    return;
                } else
                {
                    bundle.putBundle("com.amazon.identity.auth.ChallengeException", ((AuthenticationChallenge) (obj1)).toBundle());
                    mCallback.onError(bundle);
                    return;
                }
            } else
            {
                obj = new Bundle();
                ((Bundle) (obj)).putString("com.amazon.dcp.sso.property.account.acctId", ((PandaAuthenticateAccountResponse) (obj1)).getDirectedId());
                ((Bundle) (obj)).putString("com.amazon.dcp.sso.AddAccount.options.AccessToken", ((PandaAuthenticateAccountResponse) (obj1)).getAccessToken());
                mCallback.onSuccess(((Bundle) (obj)));
                return;
            }
        }

        public AuthenticateAccountAmazonWebserviceCallListener(Callback callback)
        {
            mCallback = callback;
        }
    }


    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/accounts/AccountAuthenticator.getName();
    private static final String TAG = com/amazon/identity/auth/accounts/AccountAuthenticator.getName();
    private final AmazonWebServiceCallerCreator mAmazonWebServiceCallerCreator;
    private final ServiceWrappingContext mContext;
    private final DataStorage mDataStorage;
    private final SSODeviceInfo mDeviceInfo;
    private final FeatureSet mFeatureSet;

    public AccountAuthenticator(Context context)
    {
        this(context, ((DataStorageFactory)ServiceWrappingContext.create(context).getSystemService("dcp_data_storage_factory")).getDataStorage());
    }

    public AccountAuthenticator(Context context, DataStorage datastorage)
    {
        MAPArgContracts.throwIfNull(context, "context");
        mContext = ServiceWrappingContext.create(context);
        mFeatureSet = mContext.getFeatureSet();
        mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
        mAmazonWebServiceCallerCreator = (AmazonWebServiceCallerCreator)mContext.getSystemService("sso_webservice_caller_creator");
        mDataStorage = datastorage;
    }

    public Bundle authenticateAccount(Bundle bundle, Tracer tracer)
    {
        CallbackFuture callbackfuture;
        callbackfuture = new CallbackFuture();
        authenticateAccount(bundle, ((Callback) (callbackfuture)), tracer);
        bundle = callbackfuture.get();
        return bundle;
        bundle;
        MAPLog.e(TAG, (new StringBuilder("MAPCallbackErrorException occurred while authenticating account with panda.")).append(BundleUtils.toString(bundle.getErrorBundle())).toString());
        return bundle.getErrorBundle();
        bundle;
        MAPLog.e(TAG, "InterruptedException occurred while authenticating account with panda.", bundle);
_L2:
        return null;
        bundle;
        MAPLog.e(TAG, "ExecutionException occurred while authenticating account with panda.", bundle);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void authenticateAccount(Bundle bundle, Callback callback, Tracer tracer)
    {
        PandaAuthenticateAccountRequest pandaauthenticateaccountrequest = new PandaAuthenticateAccountRequest();
        String s1 = bundle.getString("authAccount");
        String s = bundle.getString("password");
        String s3 = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) && TextUtils.isEmpty(s3))
        {
            bundle = new Bundle();
            bundle.putInt("com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value());
            bundle.putString("com.amazon.dcp.sso.ErrorMessage", "A login/directedId and password are required to authenticate/confirmCredential.");
            callback.onError(bundle);
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            pandaauthenticateaccountrequest.setUserID(s1);
        }
        if (!TextUtils.isEmpty(s3))
        {
            pandaauthenticateaccountrequest.setDirectedId(s3);
            String s2 = mDataStorage.getToken(s3, "com.amazon.dcp.sso.token.cookie.sid");
            if (!TextUtils.isEmpty(s2))
            {
                pandaauthenticateaccountrequest.setTrustedDeviceToken(s2.replaceAll("^\"|\"$", ""));
            }
        }
        pandaauthenticateaccountrequest.setPassword(s);
        pandaauthenticateaccountrequest.setCookieDomain(bundle.getString("com.amazon.identity.ap.domain"));
        pandaauthenticateaccountrequest.setDeviceInfo(mDeviceInfo);
        pandaauthenticateaccountrequest.setJwtSigner(JwtSigner.getSigner(PlatformSettings.getInstance(mContext), mDeviceInfo, tracer));
        s = mDeviceInfo.getDeviceSerialNumber();
        pandaauthenticateaccountrequest.setFraudMetadata(DeviceMetadataCollector.getFraudMetadata(mContext, s, tracer));
        if (mFeatureSet.hasFeature(Feature.UseDeviceLocaleAsLanguagePreference))
        {
            pandaauthenticateaccountrequest.setLocale(LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault()));
        }
        bundle = bundle.getString("calling_package");
        if (bundle != null)
        {
            pandaauthenticateaccountrequest.setMetadataAppName(bundle);
            bundle = PackageUtils.getPackageVersion(mContext, bundle);
            if (bundle != null)
            {
                pandaauthenticateaccountrequest.setMetadataAppVersion(Integer.toString(bundle.intValue()));
            }
        }
        bundle = new AuthenticateAccountAmazonWebserviceCallListener(MetricsHelper.wrapCallback(MetricsHelper.startTimer(METRICS_COMPONENT_NAME, "PandaService:SignIn"), callback));
        invokeWebRequest(pandaauthenticateaccountrequest.getWebRequest(), new PandaAuthenticateAccountResponseParser(), bundle, tracer);
    }

    protected void invokeWebRequest(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener, Tracer tracer)
    {
        mAmazonWebServiceCallerCreator.createSync(tracer).createCall(webrequest, webresponseparser, iamazonwebservicecalllistener).call();
    }


}
