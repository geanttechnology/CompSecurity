// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.api.TokenKeys;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.framework.AmazonWebServiceCallerCreator;
import com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage;
import com.amazon.identity.auth.device.framework.SSODeviceInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metadata.DeviceMetadataCollector;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.storage.CookieJar;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.token.MAPCookieManager;
import com.amazon.identity.auth.device.token.OAuthTokenManager;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.StringUtil;
import com.amazon.identity.auth.device.utils.TimeUtil;
import com.amazon.identity.kcpsdk.auth.AuthenticationChallenge;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceError;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceRequest;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceResponse;
import com.amazon.identity.kcpsdk.auth.DeregisterDeviceResponseParser;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCall;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.IAmazonWebserviceCaller;
import com.amazon.identity.kcpsdk.auth.ParseErrorException;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceError;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponseJsonParser;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponseParser;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceWithSecretRequest;
import com.amazon.identity.kcpsdk.auth.RegisterRequest;
import com.amazon.identity.kcpsdk.auth.RequestSigner;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsRequest;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsResponseParser;
import com.amazon.identity.kcpsdk.common.LocaleUtil;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AmazonAccountManager, AuthenticateAccountAction, AccountAuthenticator, DelegatedAccountHelper, 
//            AccountRegistrarAuthenticator, RegisterAccountHelper, AccountDataCollector

public class AccountRegistrar
{
    private class Listener
    {

        public abstract void accountAlreadyExists(String s);

        public abstract void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle);

        public abstract void success(String s, String s1, Bundle bundle);
    }

    private class _cls4 extends RegisterDeviceAmazonWebserviceCallListener
    {
        private class RegisterDeviceAmazonWebserviceCallListener extends DefaultAmazonWebserviceCallListener
        {

            protected final Listener mListener;
            protected final MAPAccountManager mMAPAccountManager;

            protected abstract void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype);

            public void onAuthenticationFailed()
            {
                MAPLog.e(AccountRegistrar.TAG, "Authentication failure performing registration request");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED, null);
            }

            public void onNetworkFailure()
            {
                MAPLog.e(AccountRegistrar.TAG, "Network failure performing registration request");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE, null);
            }

            public void onParseError$6fe276bc()
            {
                MAPLog.e(AccountRegistrar.TAG, "Parsing failure performing registration request");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR, null);
            }

            protected abstract RegisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse);

            public void onResponseComplete(Object obj)
            {
                RegisterDeviceResponse registerdeviceresponse;
                MAPLog.i(AccountRegistrar.TAG, "Successfully completed the registration request");
                registerdeviceresponse = (RegisterDeviceResponse)obj;
                if (registerdeviceresponse == null)
                {
                    MAPLog.e(AccountRegistrar.TAG, "Registration Error: Null response");
                    mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                    return;
                }
                if (registerdeviceresponse.getError() == null) goto _L2; else goto _L1
_L1:
                RegisterDeviceError registerdeviceerror;
                AuthenticationChallenge authenticationchallenge;
                registerdeviceerror = registerdeviceresponse.getError();
                obj = registerdeviceerror.getType().getErrorString();
                MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Error string: ")).append(((String) (obj))).toString());
                authenticationchallenge = registerdeviceresponse.getChallenge();
                registerdeviceresponse = null;
                static class _cls7
                {

                    static final int $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[];
                    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType[];
                    static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[];

                    static 
                    {
                        $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType = new int[DeregisterDeviceErrorType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$DeregisterDeviceErrorType[DeregisterDeviceErrorType.DeregisterDeviceErrorTypeFailed.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror27) { }
                        $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType = new int[RegistrationType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_LOGIN_CREDENTIALS.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror26) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_DEVICE_SECRET.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror25) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_ATMAIN.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror24) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_AUTH_TOKEN.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror23) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_ACCESS_TOKEN.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror22) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.FROM_ADP_TOKEN.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror21) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_EXPLICIT_URL.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror20) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.REGISTER_DELEGATED_ACCOUNT.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror19) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_DIRECTEDID_CREDENTIALS.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror18) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$auth$device$api$RegistrationType[RegistrationType.WITH_LINK_CODE.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror17) { }
                        $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType = new int[RegisterDeviceErrorType.values().length];
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror16) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror15) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror14) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeChallengeResponse.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror13) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeMissingValue.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror12) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidValue.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror11) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeProtocolError.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror10) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeMethodNotAllowed.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeServerError.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeNotImplemented.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDirectedId.ordinal()] = 11;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidDevice.ordinal()] = 12;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeServerUnavailable.ordinal()] = 13;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnauthorizedPanda.ordinal()] = 14;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeInvalidTokenPanda.ordinal()] = 15;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceNotRegisteredPanda.ordinal()] = 16;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary.ordinal()] = 17;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                _cls7..SwitchMap.com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType[registerdeviceerror.getType().ordinal()];
                JVM INSTR tableswitch 1 17: default 184
            //                           1 218
            //                           2 273
            //                           3 297
            //                           4 321
            //                           5 393
            //                           6 417
            //                           7 441
            //                           8 465
            //                           9 489
            //                           10 513
            //                           11 537
            //                           12 561
            //                           13 585
            //                           14 609
            //                           15 647
            //                           16 685
            //                           17 732;
                   goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20
_L3:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: Unrecognized response. If this is a 1st party Amazon device and is not corrected from a retry, please verify that your device has been fulfilled.");
                AccountRegistrar.TAG;
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
_L21:
                cleanupDeviceState(registerdeviceerror.getType());
                return;
_L4:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: Customer not found. Invalid credentials.");
                obj = registerdeviceresponse;
                if (authenticationchallenge != null)
                {
                    obj = registerdeviceresponse;
                    if (authenticationchallenge.getAuthDataAdditionalInfo() != null)
                    {
                        obj = new Bundle();
                        authenticationchallenge.addAdditionalInfoToBundle(((Bundle) (obj)));
                    }
                }
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND, ((Bundle) (obj)));
                continue; /* Loop/switch isn't completed */
_L5:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: Device already registered");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEVICE_ALREADY_REGISTERED, null);
                continue; /* Loop/switch isn't completed */
_L6:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: Duplicate device name");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DUPLICATE_DEVICE_NAME, null);
                continue; /* Loop/switch isn't completed */
_L7:
                MAPLog.i(AccountRegistrar.TAG, "Registration Error: Challenge Response Received");
                if (authenticationchallenge == null)
                {
                    MAPLog.e(AccountRegistrar.TAG, "Registration Error: Unknown. Challenge Exception was missing.");
                    mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                } else
                {
                    obj = new Bundle();
                    ((Bundle) (obj)).putBundle("com.amazon.identity.auth.ChallengeException", authenticationchallenge.toBundle());
                    mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_CHALLENGED, ((Bundle) (obj)));
                }
                continue; /* Loop/switch isn't completed */
_L8:
                MAPLog.e(AccountRegistrar.TAG, "MAP internal bug: One or more required values are missing");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                continue; /* Loop/switch isn't completed */
_L9:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: One or more required values are invalid");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                continue; /* Loop/switch isn't completed */
_L10:
                MAPLog.e(AccountRegistrar.TAG, "MAP internal bug: The Protocol is not supported. SSL required");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                continue; /* Loop/switch isn't completed */
_L11:
                MAPLog.e(AccountRegistrar.TAG, "MAP internal bug: The HTTP method is not valid. For example, using POST instead of GET");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                continue; /* Loop/switch isn't completed */
_L12:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: The server has encountered a runtime error, or the service is temporarily overloaded or unavailable, try again later");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                continue; /* Loop/switch isn't completed */
_L13:
                MAPLog.e(AccountRegistrar.TAG, "MAP internal bug: The feature is not implemented");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                continue; /* Loop/switch isn't completed */
_L14:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: The directedId is invalid. e.g. The customer directedId is invalid. The device directedId is invalid");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                continue; /* Loop/switch isn't completed */
_L15:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: The device information is invalid. The device serial number is too long");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                continue; /* Loop/switch isn't completed */
_L16:
                MAPLog.e(AccountRegistrar.TAG, "Registration Error: The service is temporarily overloaded or unavailable, try again later");
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                continue; /* Loop/switch isn't completed */
_L17:
                MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Registration Error: ")).append(((String) (obj))).toString());
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED, null);
                continue; /* Loop/switch isn't completed */
_L18:
                MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Registration Error: ")).append(((String) (obj))).toString());
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED, null);
                continue; /* Loop/switch isn't completed */
_L19:
                MAPLog.i(AccountRegistrar.TAG, (new StringBuilder("Registration Error: ")).append(((String) (obj))).toString());
                MetricsHelper.incrementCounter("PrimaryAccountDeregisteredWhenRegisterSecondaryWithPanda", new String[0]);
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED, null);
                continue; /* Loop/switch isn't completed */
_L20:
                MAPLog.i(AccountRegistrar.TAG, (new StringBuilder("Registration Error: ")).append(((String) (obj))).toString());
                mListener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED, null);
                if (true) goto _L21; else goto _L2
_L2:
                obj = onRegisterResponseComplete(registerdeviceresponse);
                if (((RegisterInfo) (obj)).error == null)
                {
                    mListener.success(((RegisterInfo) (obj)).getDirectedId(), ((RegisterInfo) (obj)).getUserName(), ((RegisterInfo) (obj)).userData);
                    return;
                } else
                {
                    MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Registration Error: ")).append(((RegisterInfo) (obj)).error.toString()).toString());
                    mListener.failure(((RegisterInfo) (obj)).error, null);
                    return;
                }
            }

            public RegisterDeviceAmazonWebserviceCallListener(Listener listener)
            {
                mListener = listener;
                mMAPAccountManager = null;
            }

            public RegisterDeviceAmazonWebserviceCallListener(Listener listener, MAPAccountManager mapaccountmanager)
            {
                mListener = listener;
                mMAPAccountManager = mapaccountmanager;
            }
        }


        final AccountRegistrar this$0;
        final AccountRegistrarAuthenticator val$accountRegAuth;

        protected void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype)
        {
        }

        protected RegisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
        {
            AccountRegistrar accountregistrar = AccountRegistrar.this;
            AccountRegistrarAuthenticator accountregistrarauthenticator = accountRegAuth;
            AccountRegistrar.access$300$32336411(accountregistrar, registerdeviceresponse);
            if (AccountRegistrar.access$400(AccountRegistrar.this, registerdeviceresponse, accountRegAuth))
            {
                return new RegisterInfo();
            } else
            {
                return new RegisterInfo(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED);
            }
        }

        _cls4(AccountRegistrarAuthenticator accountregistrarauthenticator)
        {
            this$0 = AccountRegistrar.this;
            accountRegAuth = accountregistrarauthenticator;
            super(final_listener);
        }
    }

    private static class RegisterInfo
    {

        public com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError error;
        public Bundle userData;

        private String commonGetUserDataAttribute(String s)
        {
            if (userData == null)
            {
                return null;
            } else
            {
                return userData.getString(s);
            }
        }

        public String getDirectedId()
        {
            return commonGetUserDataAttribute("com.amazon.dcp.sso.property.account.acctId");
        }

        public String getUserName()
        {
            return commonGetUserDataAttribute("com.amazon.dcp.sso.property.username");
        }

        public RegisterInfo()
        {
        }

        public RegisterInfo(Bundle bundle)
        {
            userData = bundle;
        }

        public RegisterInfo(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror)
        {
            error = registrationerror;
        }
    }


    private static final long GET_CENTRAL_CREDENTIAL_TIME_OUT_MS;
    private static final String TAG = com/amazon/identity/auth/accounts/AccountRegistrar.getName();
    private final AccountAuthenticator mAccountAuthenticator;
    private final AmazonAccountManager mAmazonAccountManager;
    private final AmazonWebServiceCallerCreator mAmazonWebServiceCallerCreator;
    private final AuthenticateAccountAction mAuthenticateAccountAction;
    private final ServiceWrappingContext mContext;
    private final DataStorage mDataStorage;
    private final DelegatedAccountHelper mDelegatedAccountHelper;
    private final SSODeviceInfo mDeviceInfo;
    private final FeatureSet mFeatureSet;
    private final MAPAccountManager mMAPAccountManager;
    private final OAuthTokenManager mOAuthTokenManager;
    private final TokenManagement mTokenManagement;

    public AccountRegistrar(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context is null");
        } else
        {
            mContext = ServiceWrappingContext.create(context);
            mAmazonAccountManager = new AmazonAccountManager(mContext);
            mDeviceInfo = (SSODeviceInfo)mContext.getSystemService("dcp_device_info");
            mTokenManagement = (TokenManagement)mContext.getSystemService("dcp_token_mangement");
            mMAPAccountManager = new MAPAccountManager(mContext);
            mAmazonWebServiceCallerCreator = (AmazonWebServiceCallerCreator)mContext.getSystemService("sso_webservice_caller_creator");
            mAuthenticateAccountAction = new AuthenticateAccountAction(mContext);
            mAccountAuthenticator = new AccountAuthenticator(mContext);
            mOAuthTokenManager = new OAuthTokenManager(mContext);
            mDelegatedAccountHelper = new DelegatedAccountHelper();
            mFeatureSet = mContext.getFeatureSet();
            mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
            return;
        }
    }

    private Bundle addIgnorePlatformAgnosticToOptions()
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("ignore.platform.restrictions", true);
        return bundle;
    }

    private AuthenticateAccountAction.AuthenticatedAccountInfo authenticateAccount(String s, String s1, String s2, Listener listener, Bundle bundle, Tracer tracer)
    {
        s1 = mAuthenticateAccountAction.authenticateAccount(s, s1, s2, bundle, tracer);
        if (s1 == null)
        {
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
            s = null;
        } else
        {
            s = s1;
            if (s1.isError())
            {
                s = null;
                s2 = ((AuthenticateAccountAction.AuthenticatedAccountInfo) (s1)).challenge;
                if (s2 != null)
                {
                    s = new Bundle();
                    if (((AuthenticateAccountAction.AuthenticatedAccountInfo) (s1)).error.getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.CredentialError)
                    {
                        bundle = s2.getAuthDataAdditionalInfo();
                        if (bundle != null)
                        {
                            s.putString("auth_data_additional_info", bundle);
                        }
                    }
                    s.putBundle("com.amazon.identity.auth.ChallengeException", s2.toBundle());
                }
                listener.failure(((AuthenticateAccountAction.AuthenticatedAccountInfo) (s1)).error.getRegistrationError(), s);
                return null;
            }
        }
        return s;
    }

    private void commonRegisterDeviceRequest(RegisterDeviceRequest registerdevicerequest, Bundle bundle, String s, String s1, AccountRegistrarAuthenticator accountregistrarauthenticator, Listener listener, Tracer tracer)
    {
        commonRegisterDeviceRequest(registerdevicerequest, bundle, s, s1, accountregistrarauthenticator, listener, false, tracer);
    }

    private void commonRegisterDeviceRequest(RegisterDeviceRequest registerdevicerequest, Bundle bundle, String s, String s1, AccountRegistrarAuthenticator accountregistrarauthenticator, Listener listener, boolean flag, 
            Tracer tracer)
    {
        Object obj1;
label0:
        {
            boolean flag1 = bundle.getBoolean("is_delegated_account_registration", false);
            obj1 = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
            registerdevicerequest.setPandaCookieDomain(AmazonDomainHelper.getDomainFromCompleteUrl(((String) (obj1))));
            Object obj = new MAPCookieManager(mContext);
            String s2 = AmazonDomainHelper.getCompleteCookieDomain(((String) (obj1)));
            obj = ((MAPCookieManager) (obj)).getNonAuthCookies(s2);
            Object obj2 = bundle.getString("sid_cookie_value");
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                ((List) (obj)).add(MAPCookieManager.getSidCookie(((String) (obj2)), s2));
            }
            registerdevicerequest.setNonAuthCookies(((List) (obj)));
            s2 = getDeviceSerialNumber();
            registerdevicerequest.setDeviceSerialNumber(s2);
            obj = mDeviceInfo.getDeviceType();
            registerdevicerequest.setDeviceType(((String) (obj)));
            registerdevicerequest.setDeviceSoftwareVersion(mDeviceInfo.getSoftwareVersion());
            registerdevicerequest.setSoftwareComponentId(getSoftwareComponentId(((String) (obj))));
            obj2 = bundle.getString("calling_package");
            if (obj2 != null)
            {
                registerdevicerequest.setMetadataAppName(((String) (obj2)));
                obj2 = PackageUtils.getPackageVersion(mContext, ((String) (obj2)));
                if (obj2 != null)
                {
                    registerdevicerequest.setMetadataAppVersion(Integer.toString(((Integer) (obj2)).intValue()));
                }
            }
            if (flag || mFeatureSet.hasFeature(Feature.PandaRegistration) && !Boolean.valueOf(flag1).booleanValue())
            {
                registerdevicerequest.setPandaEndPointDomain(((String) (obj1)));
                registerdevicerequest.setRegisterEndpoint(com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.RegisterEndpointEnum.Panda);
                registerdevicerequest.setFraudMetadata(DeviceMetadataCollector.getFraudMetadata(mContext, s2, tracer));
                registerdevicerequest.setDeviceMetadataJSON(DeviceMetadataCollector.getDeviceMetadataJSON(mContext, ((String) (obj)), s2, tracer));
                if (registerdevicerequest.getAddAsSecondaryAccount())
                {
                    obj1 = mAmazonAccountManager.getDevicePrimaryAmazonAccount();
                    Object obj3 = KeyInfo.parseKey("com.amazon.dcp.sso.token.oauth.amazon.access_token");
                    try
                    {
                        obj1 = mOAuthTokenManager.getAccessToken(((String) (obj1)), ((KeyInfo) (obj3)), null, tracer);
                    }
                    // Misplaced declaration of an exception variable
                    catch (RegisterDeviceRequest registerdevicerequest)
                    {
                        MAPLog.e(TAG, String.format("Get error when getting the primary access token for secondary account registration %s.", new Object[] {
                            registerdevicerequest.getErrorMsg()
                        }));
                        registerdevicerequest = registerdevicerequest.getAuthEndpointError();
                        if (registerdevicerequest != null && registerdevicerequest.getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.InvalidToken)
                        {
                            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED, null);
                            return;
                        } else
                        {
                            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                            return;
                        }
                    }
                    registerdevicerequest.setPrimaryAccessToken(((String) (obj1)));
                    obj1 = bundle.getString("authAccount");
                    obj3 = bundle.getString("password");
                    if (!TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(((CharSequence) (obj3))))
                    {
                        registerdevicerequest.setSecondaryLogin(((String) (obj1)));
                        registerdevicerequest.setSecondaryPassword(((String) (obj3)));
                    }
                }
            }
            registerdevicerequest.setSecret(getDeviceSecret());
            if (s1 == null)
            {
                break label0;
            }
            if (s1.endsWith("amazon.co.jp"))
            {
                s1 = LocaleUtil.getLocaleAsLanguageTag(Locale.JAPAN);
            } else
            {
                if (!s1.endsWith("amazon.cn"))
                {
                    break label0;
                }
                s1 = LocaleUtil.getLocaleAsLanguageTag(Locale.CHINA);
            }
        }
_L1:
        registerdevicerequest.setLocale(s1);
        registerdevicerequest.setDeviceTypeToSoftwareVersionMapping(DeviceTypeHelpers.getAllMapDeviceTypesAndSoftwareVersion(mContext));
        obj1 = tryRetrieveSelfGeneratedKeyPair(mContext);
        s1 = null;
        if (obj1 == null)
        {
            MAPLog.i(TAG, "Self generated key pair was not available when call register.");
        } else
        {
            MAPLog.i(TAG, "Self generated key pair was available when call register.");
            registerdevicerequest.setPublicKeyData(((com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair) (obj1)).getEncodedPublicKey());
            registerdevicerequest.setPublicKeyFormat(((com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair) (obj1)).getFormat());
            registerdevicerequest.setPublicKeyAlgorithm(((com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair) (obj1)).getAlgo());
            s1 = ((com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair) (obj1)).getEncodedPrivateKey();
        }
        s = getRegisterListener(listener, accountregistrarauthenticator, s, ((String) (obj)), s2, s1);
        if (mFeatureSet.hasFeature(Feature.TrustZone))
        {
            registerdevicerequest.setTrustZone(tracer);
        }
        registerdevicerequest.setDeviceName(bundle.getString("device_name"));
        bundle = registerdevicerequest.getWebRequest();
        if (bundle == null)
        {
            MAPLog.e(TAG, "Could not construct a valid registration request");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        break MISSING_BLOCK_LABEL_657;
        s1 = LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault());
          goto _L1
        if (registerdevicerequest.getRegisterEndPoint() == com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.RegisterEndpointEnum.Panda)
        {
            invokeWebRequest(bundle, new RegisterDeviceResponseJsonParser(), s, tracer);
            return;
        } else
        {
            invokeRegisterWebRequest(registerdevicerequest, s, tracer);
            return;
        }
    }

    private void doUpdateCredentials(String s, String s1, String s2, final Listener final_listener, Tracer tracer)
    {
        if (final_listener == null)
        {
            throw new IllegalArgumentException("One or more null parameters");
        }
        if (!mAmazonAccountManager.doesAccountExist(s1))
        {
            final_listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT, null);
            return;
        }
        Object obj = new UpdateDeviceCredentialsRequest();
        if (s != null)
        {
            ((UpdateDeviceCredentialsRequest) (obj)).setURL(s);
        }
        ((UpdateDeviceCredentialsRequest) (obj)).setDeviceTypeToSoftwareVersionMapping(DeviceTypeHelpers.getAllMapDeviceTypesAndSoftwareVersion(mContext));
        s = new RegisterDeviceAmazonWebserviceCallListener(s1) {

            final AccountRegistrar this$0;
            final String val$directedId;

            protected void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype)
            {
            }

            protected RegisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
            {
                AccountDataCollector accountdatacollector = new AccountDataCollector();
                accountdatacollector.setUserName(registerdeviceresponse.getUserName());
                accountdatacollector.setDeviceName(registerdeviceresponse.getDeviceName());
                UserProperties.storeDeviceName(mContext, directedId, registerdeviceresponse.getDeviceName());
                String s3 = registerdeviceresponse.getEmail();
                if (s3 != null)
                {
                    accountdatacollector.setDeviceEmail(s3);
                } else
                {
                    MAPLog.i(AccountRegistrar.TAG, "Was not able to updated device email since it was not returned");
                }
                accountdatacollector.setAdpToken(registerdeviceresponse.getAdpToken());
                accountdatacollector.setPrivateKey(registerdeviceresponse.getPrivateKey());
                accountdatacollector.setDirectedId(registerdeviceresponse.getDirectedId());
                registerdeviceresponse = new CookieJar(registerdeviceresponse.getCookiesRetrievedFromFIRS());
                accountdatacollector.setXMainToken(registerdeviceresponse.getXmain());
                accountdatacollector.setXMainAndXAcbCookies(registerdeviceresponse.getInternationalXMainAndXAcbCookies());
                return new RegisterInfo(accountdatacollector.getCurrentUserData());
            }

            
            {
                this$0 = AccountRegistrar.this;
                directedId = s;
                super(final_listener);
            }
        };
        obj = ((UpdateDeviceCredentialsRequest) (obj)).getWebRequest();
        if (obj != null)
        {
            invokeWebRequest(((WebRequest) (obj)), s1, s2, null, new UpdateDeviceCredentialsResponseParser(), s, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a updateCredentials request from this todo item");
            final_listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
    }

    private String getDelegatedAccessTokenOrCallBackError(String s, String s1, String s2, Listener listener, Tracer tracer)
    {
        Bundle bundle = new Bundle();
        bundle.putString("com.amazon.dcp.sso.property.account.delegateeaccount", s);
        bundle.putString("com.amazon.identity.ap.domain", s2);
        boolean flag = false;
        s = KeyInfo.parseKey("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        try
        {
            s = mOAuthTokenManager.getAccessToken(s1, s, bundle, tracer);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("Got error when getting the delegated access token: ")).append(s.getErrorMsg()).toString(), s);
            if (s.getErrorCode() == com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED.value())
            {
                MAPLog.i(TAG, "The delegatee account is already deregistered.");
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED, null);
            } else
            if (s.getAuthEndpointError() != null && s.getAuthEndpointError().getAuthTypeError() == com.amazon.identity.auth.device.framework.AuthEndpointErrorParser.AuthErrorType.Forbidden)
            {
                MAPLog.i(TAG, "The delegatedd account is not valid in the household.");
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED, null);
            } else
            if (s.getErrorCode() == 3 && s.getCause() != null && (s.getCause() instanceof IOException))
            {
                MAPLog.e(TAG, "Cannot register the delegated account due to a network error.");
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE, null);
            } else
            {
                MAPLog.e(TAG, "Got unknown error when getting the delegated access token", s);
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
            }
            flag = true;
            s = null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Got Unknown error when getting the delegated access token.", s);
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
            flag = true;
            s = null;
        }
        if (TextUtils.isEmpty(s) && !flag)
        {
            MAPLog.e(TAG, "Failed to get delegated access token for unknown reason.");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
        }
        return s;
    }

    private IAmazonWebserviceCallListener getRegisterListener(final Listener final_listener1, AccountRegistrarAuthenticator accountregistrarauthenticator, String s, String s1, String s2, String s3)
    {
        return new RegisterDeviceAmazonWebserviceCallListener(s2, s1) {

            final AccountRegistrar this$0;
            final AccountRegistrarAuthenticator val$accountRegAuth;
            final String val$deviceType;
            final String val$email;
            final Listener val$listener;
            final String val$privateKeyOverWrite;
            final String val$serialNumber;

            protected void cleanupDeviceState(RegisterDeviceErrorType registerdeviceerrortype)
            {
                if (registerdeviceerrortype != RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceNotRegisteredPanda && registerdeviceerrortype != RegisterDeviceErrorType.RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary)
                {
                    return;
                }
                if (mMAPAccountManager == null)
                {
                    MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("MAPAccountManager not initialized. Not able to deregister the device due to error ")).append(registerdeviceerrortype.name()).toString());
                    return;
                } else
                {
                    mMAPAccountManager.deregisterDevice(registerdeviceerrortype. new Callback() {

                        final _cls5 this$1;
                        final RegisterDeviceErrorType val$error;

                        public void onError(Bundle bundle)
                        {
                            MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Got error while deregistering device in response to error : ")).append(error.name()).toString());
                            int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode", -1);
                            bundle = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
                            MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Error Code: ")).append(i).toString());
                            MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Error message: ")).append(bundle).toString());
                        }

                        public void onSuccess(Bundle bundle)
                        {
                            if (bundle.containsKey("com.amazon.dcp.sso.ErrorCode"))
                            {
                                onError(bundle);
                                return;
                            } else
                            {
                                MAPLog.e(AccountRegistrar.TAG, (new StringBuilder("Finished deregistering device in response to error : ")).append(error.name()).toString());
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls5;
                error = RegisterDeviceErrorType.this;
                super();
            }
                    });
                    return;
                }
            }

            protected RegisterInfo onRegisterResponseComplete(RegisterDeviceResponse registerdeviceresponse)
            {
                Object obj = AccountRegistrar.this;
                Object obj1 = accountRegAuth;
                AccountRegistrar.access$300$32336411(((AccountRegistrar) (obj)), registerdeviceresponse);
                if (isAnonymousCredentials(registerdeviceresponse))
                {
                    AccountRegistrar.access$400(AccountRegistrar.this, registerdeviceresponse, accountRegAuth);
                    MAPLog.w(AccountRegistrar.TAG, "Cannot register the device, because anonymous credentials were returned from the server. FRO has either already been called or this device is not associated with an account.");
                    return new RegisterInfo(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED);
                }
                AccountDataCollector accountdatacollector = new AccountDataCollector();
                if (email != null)
                {
                    accountdatacollector.setEmail(email);
                }
                obj1 = registerdeviceresponse.getUserName();
                obj = obj1;
                if (TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    obj = " ";
                }
                accountdatacollector.setUserName(((String) (obj)));
                accountdatacollector.setDeviceName(registerdeviceresponse.getDeviceName());
                accountdatacollector.setDeviceEmail(registerdeviceresponse.getEmail());
                accountdatacollector.setAdpToken(registerdeviceresponse.getAdpToken());
                if (registerdeviceresponse.getPrivateKey() != null)
                {
                    MAPLog.i(AccountRegistrar.TAG, "Registration returned server generated credentials.");
                    accountdatacollector.setPrivateKey(registerdeviceresponse.getPrivateKey());
                } else
                {
                    if (privateKeyOverWrite == null)
                    {
                        MAPLog.e(AccountRegistrar.TAG, "No private key to set after register.");
                        listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED, null);
                    }
                    MAPLog.i(AccountRegistrar.TAG, "The device will use self generated credentials.");
                    accountdatacollector.setPrivateKey(privateKeyOverWrite);
                }
                accountdatacollector.setDeviceSerialNumber(serialNumber);
                accountdatacollector.setDeviceType(deviceType);
                accountdatacollector.setDirectedId(registerdeviceresponse.getDirectedId());
                obj = new CookieJar(registerdeviceresponse.getCookiesRetrievedFromFIRS());
                accountdatacollector.setXMainToken(((CookieJar) (obj)).getXmain());
                accountdatacollector.setXMainAndXAcbCookies(((CookieJar) (obj)).getInternationalXMainAndXAcbCookies());
                accountdatacollector.setXfsnCookie(registerdeviceresponse.getStoreAuthenticationCookie());
                accountdatacollector.setAccountPool(registerdeviceresponse.getAccountPool());
                accountdatacollector.setCustomerRegion(registerdeviceresponse.getCustomerRegion());
                accountdatacollector.setCor(registerdeviceresponse.getCor());
                accountdatacollector.setSourceOfCor(registerdeviceresponse.getSourceOfCor());
                accountdatacollector.setPfm(registerdeviceresponse.getPfm());
                accountdatacollector.setCredentialsMap(registerdeviceresponse.getCredentialsReceived());
                accountdatacollector.setCookies(registerdeviceresponse.getCookiesRetrievedFromPanda());
                accountdatacollector.setAccessToken(registerdeviceresponse.getAccessToken());
                accountdatacollector.setAccessTokenExpiresIn(registerdeviceresponse.getAccessTokenExpiresIn());
                accountdatacollector.setRefreshToken(registerdeviceresponse.getRefreshToken());
                return new RegisterInfo(accountdatacollector.getUserDataNecessaryForAccountCreation());
            }

            
            {
                this$0 = AccountRegistrar.this;
                accountRegAuth = accountregistrarauthenticator;
                email = s;
                privateKeyOverWrite = s1;
                listener = listener2;
                serialNumber = s2;
                deviceType = s3;
                super(final_listener1, final_mapaccountmanager);
            }
        };
    }

    private String getSoftwareComponentId(String s)
    {
        return DeviceTypeHelpers.getSoftwareComponentId(mContext, s, null);
    }

    private void invokeWebRequest(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener, Tracer tracer)
    {
        invokeWebRequest(webrequest, mAmazonAccountManager.getDevicePrimaryAmazonAccount(), null, null, webresponseparser, iamazonwebservicecalllistener, tracer);
    }

    private boolean isAnonymousCredentials(RegisterDeviceResponse registerdeviceresponse)
    {
        String s = registerdeviceresponse.getUserName();
        for (String s1 = registerdeviceresponse.getDeviceName(); registerdeviceresponse.getDirectedId() != null || s != null && s1 != null;)
        {
            return false;
        }

        return true;
    }

    private boolean isSecondaryAccountRegistration(Bundle bundle)
    {
        return bundle.getBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary") && mAmazonAccountManager.hasDevicePrimaryAmazonAccount();
    }

    private void registerWithCustomerAccountToken(String s, Bundle bundle, AccountRegistrarAuthenticator accountregistrarauthenticator, Listener listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType customeraccounttokentype, Tracer tracer)
    {
        if (listener == null)
        {
            throw new IllegalArgumentException("One or more arguments are null or empty");
        }
        if (TextUtils.isEmpty(s))
        {
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        } else
        {
            RegisterDeviceRequest registerdevicerequest = new RegisterDeviceRequest();
            registerdevicerequest.setCustomerAccountToken(s);
            registerdevicerequest.setCustomerAccountTokenType(customeraccounttokentype);
            registerdevicerequest.setClientContext(bundle.getString("com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext"));
            registerdevicerequest.setAddAsSecondaryAccount(isSecondaryAccountRegistration(bundle));
            commonRegisterDeviceRequest(registerdevicerequest, bundle, null, null, accountregistrarauthenticator, listener, tracer);
            return;
        }
    }

    Bundle authenticateAccountWithDirectedId(String s, String s1, String s2, Listener listener, Bundle bundle, Tracer tracer)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("com.amazon.dcp.sso.property.account.acctId", s);
        bundle1.putString("password", s1);
        bundle1.putString("com.amazon.identity.ap.domain", s2);
        bundle1.putString("calling_package", bundle.getString("calling_package"));
        s1 = mAccountAuthenticator.authenticateAccount(bundle1, tracer);
        if (s1 == null)
        {
            MAPLog.i(TAG, "null auth data returned while authenticating.");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
            s = null;
        } else
        {
            s = s1;
            if (!s1.containsKey("com.amazon.dcp.sso.AddAccount.options.AccessToken"))
            {
                MAPLog.i(TAG, (new StringBuilder("Error occurred while authenticating. Error code: ")).append(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(s1.getInt("com.amazon.dcp.sso.ErrorCode")).getName()).toString());
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.fromValue(s1.getInt("com.amazon.dcp.sso.ErrorCode")), s1);
                return null;
            }
        }
        return s;
    }

    protected boolean canGetAnonymousCredentials()
    {
        return RegisterAccountHelper.canRegisterWithDeviceSecret(mContext);
    }

    public void deregister(final Listener listener, String s, String s1, AccountCredentials accountcredentials, final boolean deregisterAllAccounts, final AccountRegistrarAuthenticator accountRegAuth, final Tracer tracer)
    {
        if (listener == null)
        {
            throw new IllegalArgumentException("No response set. Could not deregister");
        }
        if (s1 == null)
        {
            MAPLog.e(TAG, "Deregister failed because an account was not specified.");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEREGISTER_FAILED, null);
            return;
        }
        if (s1 == null)
        {
            MAPLog.e(TAG, "deregister passed null account");
            throw new IllegalArgumentException("The account cannot be null");
        } else
        {
            DeregisterDeviceRequest deregisterdevicerequest = new DeregisterDeviceRequest();
            deregisterdevicerequest.setDidDeleteContent$1385ff();
            deregisterdevicerequest.setDeregisterAllAccountsForDevice(deregisterAllAccounts);
            listener = new DefaultAmazonWebserviceCallListener() {

                final AccountRegistrar this$0;
                final AccountRegistrarAuthenticator val$accountRegAuth;
                final boolean val$deregisterAllAccounts;
                final Listener val$listener;
                final Tracer val$tracer;

                public void onAuthenticationFailed()
                {
                    MAPLog.e(AccountRegistrar.TAG, "Authentication failure performing deregistration request");
                    listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.AUTHENTICATION_FAILED, null);
                }

                public void onNetworkFailure()
                {
                    MAPLog.e(AccountRegistrar.TAG, "Network failure performing deregistration request");
                    listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NETWORK_FAILURE, null);
                }

                public void onParseError$6fe276bc()
                {
                    MAPLog.e(AccountRegistrar.TAG, "Parsing failure performing deregistration request");
                    listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.PARSE_ERROR, null);
                }

                public void onResponseComplete(Object obj)
                {
                    MAPLog.i(AccountRegistrar.TAG, "Successfully completed the deregistration request");
                    obj = (DeregisterDeviceResponse)obj;
                    if (obj == null)
                    {
                        MAPLog.e(AccountRegistrar.TAG, "Deregistration Error: Null response");
                        listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                        return;
                    }
                    if (((DeregisterDeviceResponse) (obj)).getError() != null)
                    {
                        obj = ((DeregisterDeviceResponse) (obj)).getError();
                        switch (_cls7..SwitchMap.com.amazon.identity.kcpsdk.auth.DeregisterDeviceErrorType[((DeregisterDeviceError) (obj)).getType().ordinal()])
                        {
                        default:
                            MAPLog.e(AccountRegistrar.TAG, "Deregistration Error: Unrecognized response");
                            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
                            return;

                        case 1: // '\001'
                            MAPLog.e(AccountRegistrar.TAG, "Deregistration Error: Failed");
                            break;
                        }
                        listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.DEREGISTER_FAILED, null);
                        return;
                    }
                    if (deregisterAllAccounts)
                    {
                        AccountRegistrar.access$200(AccountRegistrar.this, accountRegAuth, listener, tracer);
                        return;
                    } else
                    {
                        listener.success(null, null, null);
                        return;
                    }
                }

            
            {
                this$0 = AccountRegistrar.this;
                listener = listener1;
                deregisterAllAccounts = flag;
                accountRegAuth = accountregistrarauthenticator;
                tracer = tracer1;
                super();
            }
            };
            invokeWebRequest(deregisterdevicerequest.getWebRequest(), s1, s, accountcredentials, new DeregisterDeviceResponseParser(), listener, tracer);
            return;
        }
    }

    public AccountCredentials getAccountCredentialsFromTokenAndKey(String s, String s1)
    {
        try
        {
            s = new AccountCredentials() {

                final AccountRegistrar this$0;
                final String val$adpToken;
                final String val$key;

                public String getPrivateKey()
                {
                    return key;
                }

                public String getToken()
                {
                    return adpToken;
                }

                public boolean isStale$faab209()
                {
                    return false;
                }

            
            {
                this$0 = AccountRegistrar.this;
                adpToken = s;
                key = s1;
                super();
            }
            };
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s.getErrorBundle();
            MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of callback error. Error Bundle: ")).append(s).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of InterruptedException: ")).append(s.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of ExecutionException: ")).append(s.getMessage()).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("Getting ADP Token failed because of TimeoutException: ")).append(s.getMessage()).toString());
            return null;
        }
        return s;
    }

    protected String getDeviceSecret()
    {
        return mDeviceInfo.getDeviceSecret();
    }

    protected String getDeviceSerialNumber()
    {
        return mDeviceInfo.getDeviceSerialNumber();
    }

    protected String getRadioId(Tracer tracer)
    {
        return mDeviceInfo.getMacAddress(tracer);
    }

    protected void invokeRegisterWebRequest(RegisterRequest registerrequest, IAmazonWebserviceCallListener iamazonwebservicecalllistener, Tracer tracer)
    {
        Object obj = mAmazonAccountManager.getDevicePrimaryAmazonAccount();
        IAmazonWebserviceCaller iamazonwebservicecaller = mAmazonWebServiceCallerCreator.createSync(((String) (obj)), tracer);
        String s;
        try
        {
            obj = (RegisterDeviceResponse)iamazonwebservicecaller.call$2b76e8ff(registerrequest.getWebRequest(), new RegisterDeviceResponseParser());
        }
        // Misplaced declaration of an exception variable
        catch (RegisterRequest registerrequest)
        {
            iamazonwebservicecalllistener.onNetworkFailure();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RegisterRequest registerrequest)
        {
            registerrequest.getError();
            iamazonwebservicecalllistener.onParseError$6fe276bc();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RegisterRequest registerrequest)
        {
            iamazonwebservicecalllistener.onNetworkFailure();
            return;
        }
        tracer = ((Tracer) (obj));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        s = ((RegisterDeviceResponse) (obj)).getServerTime();
        tracer = ((Tracer) (obj));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        tracer = TAG;
        (new StringBuilder("The server timestamp is ")).append(s).toString();
        MetricsHelper.incrementCounter("ClockSkewHappened", new String[0]);
        registerrequest.setTimestamp(s);
        tracer = (RegisterDeviceResponse)iamazonwebservicecaller.call$2b76e8ff(registerrequest.getWebRequest(), new RegisterDeviceResponseParser());
        iamazonwebservicecalllistener.onResponseComplete(tracer);
        return;
    }

    protected void invokeWebRequest(WebRequest webrequest, String s, String s1, AccountCredentials accountcredentials, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener, Tracer tracer)
    {
        if (s1 == null)
        {
            s = mAmazonWebServiceCallerCreator.createSync(s, tracer);
        } else
        {
            AccountCredentials accountcredentials1 = accountcredentials;
            if (accountcredentials == null)
            {
                accountcredentials1 = getAccountCredentialsFromTokenAndKey(s, s1);
            }
            s = mAmazonWebServiceCallerCreator.createSync(accountcredentials1, tracer);
        }
        s.createCall(webrequest, webresponseparser, iamazonwebservicecalllistener).call();
    }

    public void register(Listener listener, RegistrationType registrationtype, Bundle bundle, AccountRegistrarAuthenticator accountregistrarauthenticator, Tracer tracer)
    {
        boolean flag;
        if (listener == null)
        {
            throw new IllegalArgumentException("No response set. Could not register");
        }
        if (registrationtype == null)
        {
            throw new IllegalArgumentException("No registration type set. Could not register");
        }
        String s;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        s = mAmazonAccountManager.getDevicePrimaryAmazonAccount();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!bundle.getBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"))
        {
            flag = false;
        } else
        if (!RegistrationType.FROM_ACCESS_TOKEN.equals(registrationtype) && !RegistrationType.WITH_LOGIN_CREDENTIALS.equals(registrationtype) && !RegistrationType.REGISTER_DELEGATED_ACCOUNT.equals(registrationtype) && !RegistrationType.FROM_AUTH_TOKEN.equals(registrationtype) && !RegistrationType.WITH_DIRECTEDID_CREDENTIALS.equals(registrationtype) && !RegistrationType.WITH_EXPLICIT_URL.equals(registrationtype))
        {
            MAPLog.e(TAG, (new StringBuilder()).append(registrationtype).append("is not currently supported to add secondary accounts ").toString());
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag) goto _L2; else goto _L3
_L3:
        listener.accountAlreadyExists(s);
_L20:
        return;
_L2:
        final Object adpToken = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
        _cls7..SwitchMap.com.amazon.identity.auth.device.api.RegistrationType[registrationtype.ordinal()];
        JVM INSTR tableswitch 1 10: default 252
    //                   1 272
    //                   2 515
    //                   3 823
    //                   4 870
    //                   5 984
    //                   6 1031
    //                   7 1240
    //                   8 1257
    //                   9 1645
    //                   10 1916;
           goto _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L4:
        MAPLog.e(TAG, "Unrecognized or unsupported registration type.");
        listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
        return;
_L5:
        String s1;
        registrationtype = bundle.getString("authAccount");
        s1 = bundle.getString("password");
        if (registrationtype == null || s1 == null)
        {
            MAPLog.e(TAG, "Must provide an Amazon login and password to register with it");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        if (listener == null)
        {
            throw new IllegalArgumentException("Listener is null");
        }
        if (TextUtils.isEmpty(registrationtype) || TextUtils.isEmpty(s1))
        {
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND, null);
            return;
        }
        if (isSecondaryAccountRegistration(bundle)) goto _L16; else goto _L15
_L15:
        if (!mFeatureSet.hasFeature(Feature.SplitRegistration)) goto _L18; else goto _L17
_L17:
        registrationtype = authenticateAccount(registrationtype, s1, ((String) (adpToken)), listener, bundle, tracer);
        if (registrationtype == null) goto _L20; else goto _L19
_L19:
        registerWithCustomerAccountToken(((AuthenticateAccountAction.AuthenticatedAccountInfo) (registrationtype)).accessToken, bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.ACCESS_TOKEN, tracer);
        return;
_L18:
        RegisterDeviceRequest registerdevicerequest = new RegisterDeviceRequest();
        registerdevicerequest.setLogin(registrationtype);
        registerdevicerequest.setPassword(s1);
        commonRegisterDeviceRequest(registerdevicerequest, bundle, registrationtype, ((String) (adpToken)), accountregistrarauthenticator, listener, tracer);
        return;
_L16:
        adpToken = authenticateAccount(registrationtype, s1, ((String) (adpToken)), listener, bundle, tracer);
        if (adpToken == null) goto _L20; else goto _L21
_L21:
        registrationtype = ((RegistrationType) (adpToken));
        if (!mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(((AuthenticateAccountAction.AuthenticatedAccountInfo) (adpToken)).directedId)) goto _L19; else goto _L22
_L22:
        MAPLog.e(TAG, "Secondary account already exists on the device");
        listener.accountAlreadyExists(((AuthenticateAccountAction.AuthenticatedAccountInfo) (adpToken)).directedId);
        return;
_L6:
        if (listener == null)
        {
            throw new IllegalArgumentException("listener is null");
        }
        adpToken = getDeviceSerialNumber();
        String s2 = mDeviceInfo.getDeviceType();
        registrationtype = getDeviceSecret();
        if (StringUtil.isEmptyOrWhitespace(registrationtype))
        {
            MAPLog.e(TAG, "No device secret for registeration");
            SSOMetrics.registrationBadSecret(RegistrationType.WITH_DEVICE_SECRET);
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_SECRET, null);
            return;
        }
        bundle = new RegisterDeviceWithSecretRequest();
        bundle.setSecret(registrationtype);
        bundle.setRadioId(getRadioId(tracer));
        bundle.setDeviceType(s2);
        bundle.setDeviceSerialNumber(((String) (adpToken)));
        bundle.setVersionNumber(mDeviceInfo.getSoftwareVersion());
        bundle.setSoftwareComponentId(getSoftwareComponentId(s2));
        bundle.setReason("NoState");
        bundle.setLocale(LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault()));
        bundle.setDeviceTypeToSoftwareVersionMapping(DeviceTypeHelpers.getAllMapDeviceTypesAndSoftwareVersion(mContext));
        com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair selfgeneratedkeypair = tryRetrieveSelfGeneratedKeyPair(mContext);
        registrationtype = null;
        if (selfgeneratedkeypair == null)
        {
            MAPLog.i(TAG, "Self generated key pair was not available when call register with device secret.");
        } else
        {
            MAPLog.i(TAG, "Self generated key pair was available when call register with device secret.");
            bundle.setPublicKeyData(selfgeneratedkeypair.getEncodedPublicKey());
            bundle.setPublicKeyFormat(selfgeneratedkeypair.getFormat());
            bundle.setPublicKeyAlgorithm(selfgeneratedkeypair.getAlgo());
            registrationtype = selfgeneratedkeypair.getEncodedPrivateKey();
        }
        registrationtype = getRegisterListener(listener, accountregistrarauthenticator, null, s2, ((String) (adpToken)), registrationtype);
        if (mFeatureSet.hasFeature(Feature.TrustZone))
        {
            bundle.setTrustZone(tracer);
        }
        bundle = bundle.getWebRequest();
        if (bundle != null)
        {
            invokeWebRequest(bundle, new RegisterDeviceResponseParser(), registrationtype, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a valid pre-registration request");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
_L7:
        registrationtype = bundle.getString("com.amazon.dcp.sso.AddAccount.options.ATMain");
        if (registrationtype == null)
        {
            MAPLog.e(TAG, "Must provide at-main to register with it");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        } else
        {
            registerWithCustomerAccountToken(registrationtype, bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.AT_MAIN, tracer);
            return;
        }
_L8:
        registrationtype = bundle.getString("com.amazon.dcp.sso.AddAccount.options.AuthToken");
        adpToken = bundle.getString("com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext");
        String s3 = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
        if (TextUtils.isEmpty(registrationtype) || TextUtils.isEmpty(((CharSequence) (adpToken))) || TextUtils.isEmpty(s3))
        {
            MAPLog.e(TAG, "Must provide the auth token, the auth token context, and the auth token domain to register with it");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        if (!mFeatureSet.hasFeature(Feature.RegistrationViaAuthToken))
        {
            MAPLog.e(TAG, "Registration via auth token is not supported on this platform");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        } else
        {
            registerWithCustomerAccountToken(registrationtype, bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.AUTH_TOKEN, tracer);
            return;
        }
_L9:
        registrationtype = bundle.getString("com.amazon.dcp.sso.AddAccount.options.AccessToken");
        if (registrationtype == null)
        {
            MAPLog.e(TAG, "Must provide access token to register with it");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        } else
        {
            registerWithCustomerAccountToken(registrationtype, bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.ACCESS_TOKEN, tracer);
            return;
        }
_L10:
        if (listener == null)
        {
            throw new IllegalArgumentException("Bootstrap with ADP token call failed because null Listener passed.");
        }
        adpToken = bundle.getString("adp_token");
        final String privateKey = bundle.getString("adp_private_key");
        bundle = bundle.getString("Device Serial Number");
        if (TextUtils.isEmpty(((CharSequence) (adpToken))) || TextUtils.isEmpty(privateKey) || TextUtils.isEmpty(bundle))
        {
            MAPLog.e(TAG, "One of the following information is missing from Bootstrap with ADP token request: 1- ADP Token, 2- Private key, 3- DSN");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        String s7 = mDeviceInfo.getDeviceType();
        registrationtype = new UpdateDeviceCredentialsRequest();
        adpToken = new RequestSigner(new AccountCredentials() {

            final AccountRegistrar this$0;
            final String val$adpToken;
            final String val$privateKey;

            public String getPrivateKey()
            {
                return privateKey;
            }

            public String getToken()
            {
                return adpToken;
            }

            public boolean isStale$faab209()
            {
                return false;
            }

            
            {
                this$0 = AccountRegistrar.this;
                adpToken = s;
                privateKey = s1;
                super();
            }
        });
        bundle = getRegisterListener(listener, accountregistrarauthenticator, null, s7, bundle, null);
        registrationtype = registrationtype.getWebRequest();
        try
        {
            ((RequestSigner) (adpToken)).signRequest(registrationtype);
        }
        // Misplaced declaration of an exception variable
        catch (RegistrationType registrationtype)
        {
            MAPLog.e(TAG, "Error occured while trying to sign request with ADP token. Please make sure ADP token and private key are valid.", registrationtype);
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        if (registrationtype != null)
        {
            invokeWebRequest(registrationtype, new UpdateDeviceCredentialsResponseParser(), bundle, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a register with ADP token request");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
_L11:
        registerWithExplicitUrl(bundle.getString("com.amazon.dcp.sso.AddAccount.options.URL"), accountregistrarauthenticator, listener, tracer);
        return;
_L12:
        if (bundle == null || listener == null)
        {
            throw new IllegalArgumentException("One or more arguments are null or empty");
        }
        Object obj = bundle.getString("com.amazon.dcp.sso.property.account.delegateeaccount");
        adpToken = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        if (TextUtils.isEmpty(((CharSequence) (obj))) || TextUtils.isEmpty(((CharSequence) (adpToken))))
        {
            MAPLog.e(TAG, String.format("Either the delegated account %s or the delegatee account %s is not valid.", new Object[] {
                adpToken, obj
            }));
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        if (mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(((String) (adpToken))))
        {
            MAPLog.w(TAG, "The delegated account already exists on the device");
            listener.accountAlreadyExists(((String) (adpToken)));
            return;
        }
        bundle.putBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary", true);
        bundle.putBoolean("is_delegated_account_registration", true);
        String s8 = mDelegatedAccountHelper.getDelegationDomainFromAPIBundle(bundle);
        registrationtype = null;
        if (TextUtils.isEmpty(s8) || "www.amazon.com".equals(s8))
        {
            registrationtype = "ATVPDKIKX0DER";
        } else
        if ("www.amazon.co.uk".equals(s8))
        {
            registrationtype = "A1F83G8C2ARO7P";
        } else
        {
            String s10 = TAG;
            (new StringBuilder("Can't use combined delegated registration for domain: ")).append(s8).toString();
        }
        if (registrationtype != null && mFeatureSet.hasFeature(Feature.CombinedDelegatedAuthenticationAndRegistration))
        {
            obj = TAG;
            (new StringBuilder("Using combined delegated account registration with pfm=")).append(registrationtype).toString();
            if (listener == null)
            {
                throw new IllegalArgumentException("One or more arguments are null or empty");
            }
            if (TextUtils.isEmpty(((CharSequence) (adpToken))))
            {
                listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
                return;
            } else
            {
                obj = new RegisterDeviceRequest();
                ((RegisterDeviceRequest) (obj)).setSecondaryDirectedId(((String) (adpToken)));
                ((RegisterDeviceRequest) (obj)).setAddAsChildAccount$1385ff();
                ((RegisterDeviceRequest) (obj)).setPfmOfDelegatee(registrationtype);
                ((RegisterDeviceRequest) (obj)).setAddAsSecondaryAccount(isSecondaryAccountRegistration(bundle));
                commonRegisterDeviceRequest(((RegisterDeviceRequest) (obj)), bundle, null, null, accountregistrarauthenticator, listener, tracer);
                return;
            }
        }
        registrationtype = getDelegatedAccessTokenOrCallBackError(((String) (obj)), ((String) (adpToken)), s8, listener, tracer);
        if (TextUtils.isEmpty(registrationtype))
        {
            MAPLog.e(TAG, "Failed to get the delegated Access token. Quitting the register delegated account procedure");
            return;
        } else
        {
            registerWithCustomerAccountToken(registrationtype, bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.ACCESS_TOKEN, tracer);
            return;
        }
_L13:
        registrationtype = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        adpToken = bundle.getString("password");
        if (registrationtype == null || adpToken == null)
        {
            MAPLog.e(TAG, "Must provide an Amazon directedId and password to register with it");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
        String s4 = AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle);
        if (listener == null)
        {
            throw new IllegalArgumentException("Listener is null");
        }
        if (TextUtils.isEmpty(registrationtype) || TextUtils.isEmpty(((CharSequence) (adpToken))))
        {
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND, null);
            return;
        }
        if (mAmazonAccountManager.getAccounts().isEmpty())
        {
            MAPLog.e(TAG, "The device is not registered. Can not add secondary account.");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND, null);
            return;
        }
        if (mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(registrationtype))
        {
            MAPLog.e(TAG, "Secondary account already exists on the device");
            listener.accountAlreadyExists(registrationtype);
            return;
        }
        if (mFeatureSet.hasFeature(Feature.SplitRegistrationWithDirectedId))
        {
            registrationtype = authenticateAccountWithDirectedId(registrationtype, ((String) (adpToken)), s4, listener, bundle, tracer);
            if (registrationtype == null)
            {
                MAPLog.i(TAG, " null auth data was returned. registration is not successful.");
                return;
            } else
            {
                registerWithCustomerAccountToken(registrationtype.getString("com.amazon.dcp.sso.AddAccount.options.AccessToken"), bundle, accountregistrarauthenticator, listener, com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.CustomerAccountTokenType.ACCESS_TOKEN, tracer);
                return;
            }
        } else
        {
            RegisterDeviceRequest registerdevicerequest1 = new RegisterDeviceRequest();
            registerdevicerequest1.setRegisterEndpoint(com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest.RegisterEndpointEnum.Panda);
            registerdevicerequest1.setSecondaryDirectedId(registrationtype);
            registerdevicerequest1.setSecondaryPassword(((String) (adpToken)));
            registerdevicerequest1.setAddAsSecondaryAccount(true);
            commonRegisterDeviceRequest(registerdevicerequest1, bundle, null, s4, accountregistrarauthenticator, listener, true, tracer);
            return;
        }
_L14:
        registrationtype = new RegisterDeviceRequest();
        String s5 = bundle.getString("pre_authorized_link_code");
        if (!TextUtils.isEmpty(s5))
        {
            registrationtype.setCBLPreAuthorizedCode(s5);
        } else
        {
            String s6 = bundle.getString("cbl_public_code");
            String s9 = bundle.getString("cbl_private_code");
            registrationtype.setCBLPublicCode(s6);
            registrationtype.setCBLPrivateCode(s9);
        }
        commonRegisterDeviceRequest(registrationtype, bundle, null, ((String) (adpToken)), accountregistrarauthenticator, listener, true, tracer);
        return;
    }

    public void registerWithExplicitUrl(String s, AccountRegistrarAuthenticator accountregistrarauthenticator, Listener listener, Tracer tracer)
    {
        if (listener == null)
        {
            throw new IllegalArgumentException("Listner is null");
        }
        String s1 = getDeviceSerialNumber();
        String s2 = mDeviceInfo.getDeviceType();
        UpdateDeviceCredentialsRequest updatedevicecredentialsrequest = new UpdateDeviceCredentialsRequest();
        updatedevicecredentialsrequest.setURL(s);
        updatedevicecredentialsrequest.setDeviceTypeToSoftwareVersionMapping(DeviceTypeHelpers.getAllMapDeviceTypesAndSoftwareVersion(mContext));
        s = getRegisterListener(listener, accountregistrarauthenticator, null, s2, s1, null);
        accountregistrarauthenticator = updatedevicecredentialsrequest.getWebRequest();
        if (accountregistrarauthenticator != null)
        {
            invokeWebRequest(accountregistrarauthenticator, new RegisterDeviceResponseParser(), s, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a registration request from this todo item");
            listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, null);
            return;
        }
    }

    protected com.amazon.identity.auth.device.framework.PregeneratedKeyPairStorage.SelfGeneratedKeyPair tryRetrieveSelfGeneratedKeyPair(Context context)
    {
        return PregeneratedKeyPairStorage.getInstance(context).retrieveSelfGeneratedKeyPair();
    }

    public void updateCredentials$11350a19(Listener listener, String s, String s1, Bundle bundle, Tracer tracer)
    {
        if (listener == null)
        {
            throw new IllegalArgumentException("No response set. Could not update credentials");
        }
        if (s1 == null)
        {
            updateCredentials$5c9c7b31(listener, s, bundle, tracer);
            return;
        }
        if (bundle != null)
        {
            bundle = bundle.getString("com.amazon.dcp.sso.AddAccount.options.URL");
        } else
        {
            bundle = null;
        }
        doUpdateCredentials(bundle, s, s1, listener, tracer);
    }

    public void updateCredentials$5c9c7b31(Listener listener, String s, Bundle bundle, Tracer tracer)
    {
        if (listener == null)
        {
            throw new IllegalArgumentException("No response set. Could not update credentials");
        }
        if (bundle != null)
        {
            bundle = bundle.getString("com.amazon.dcp.sso.AddAccount.options.URL");
        } else
        {
            bundle = null;
        }
        doUpdateCredentials(bundle, s, null, listener, tracer);
    }

    static 
    {
        GET_CENTRAL_CREDENTIAL_TIME_OUT_MS = TimeUtil.fromMinutesTo(1L, TimeUnit.MILLISECONDS);
    }




/*
    static void access$200(AccountRegistrar accountregistrar, AccountRegistrarAuthenticator accountregistrarauthenticator, final Listener final_listener, Tracer tracer)
    {
        if (!accountregistrar.canGetAnonymousCredentials())
        {
            accountregistrar = TAG;
            final_listener.success(null, null, null);
            return;
        }
        MAPLog.i(TAG, "Attempting to get anonymous credentials");
        String s = accountregistrar.getDeviceSerialNumber();
        String s1 = accountregistrar.mDeviceInfo.getDeviceType();
        RegisterDeviceWithSecretRequest registerdevicewithsecretrequest = new RegisterDeviceWithSecretRequest();
        registerdevicewithsecretrequest.setSecret(accountregistrar.getDeviceSecret());
        registerdevicewithsecretrequest.setRadioId(accountregistrar.getRadioId(tracer));
        registerdevicewithsecretrequest.setDeviceType(s1);
        registerdevicewithsecretrequest.setDeviceSerialNumber(s);
        registerdevicewithsecretrequest.setVersionNumber(accountregistrar.mDeviceInfo.getSoftwareVersion());
        registerdevicewithsecretrequest.setSoftwareComponentId(accountregistrar.getSoftwareComponentId(s1));
        registerdevicewithsecretrequest.setLocale(LocaleUtil.getLocaleAsLanguageTag(Locale.getDefault()));
        accountregistrarauthenticator = accountregistrar. new _cls4(accountregistrarauthenticator);
        if (accountregistrar.mFeatureSet.hasFeature(Feature.TrustZone))
        {
            registerdevicewithsecretrequest.setTrustZone(tracer);
        }
        if (registerdevicewithsecretrequest.getWebRequest() != null)
        {
            accountregistrar.invokeRegisterWebRequest(registerdevicewithsecretrequest, accountregistrarauthenticator, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a valid pre-registration request to get anonymous credentials");
            final_listener.failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED, null);
            return;
        }
    }

*/


/*
    static void access$300$32336411(AccountRegistrar accountregistrar, RegisterDeviceResponse registerdeviceresponse)
    {
        if (registerdeviceresponse.getDeviceInfo() != null)
        {
            java.util.Map.Entry entry;
            for (registerdeviceresponse = registerdeviceresponse.getDeviceInfo().entrySet().iterator(); registerdeviceresponse.hasNext(); accountregistrar.mDataStorage.setDeviceData("device.metadata", (String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)registerdeviceresponse.next();
                MAPLog.i(TAG, (new StringBuilder("device attribute received: ")).append((String)entry.getKey()).append(" value: ").append((String)entry.getValue()).toString());
            }

        } else
        {
            MAPLog.i(TAG, "device info attribute is null in register Response.");
        }
        return;
    }

*/


/*
    static boolean access$400(AccountRegistrar accountregistrar, RegisterDeviceResponse registerdeviceresponse, AccountRegistrarAuthenticator accountregistrarauthenticator)
    {
        if (accountregistrarauthenticator == null)
        {
            MAPLog.e(TAG, "Could not save credentials because no AccountRegistrarAuthenticator was given.");
            return false;
        }
        if (!accountregistrar.isAnonymousCredentials(registerdeviceresponse))
        {
            MAPLog.e(TAG, "Was expecting anonymous credentials, but recieved account credentials");
            return false;
        } else
        {
            accountregistrarauthenticator.setAnonymousCredentials(registerdeviceresponse.getAdpToken(), registerdeviceresponse.getPrivateKey());
            return true;
        }
    }

*/

}
