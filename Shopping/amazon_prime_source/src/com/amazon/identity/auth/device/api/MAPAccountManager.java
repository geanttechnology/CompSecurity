// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.accounts.AccountManagerDefinition;
import com.amazon.identity.auth.accounts.AccountManagerImplementationFactory;
import com.amazon.identity.auth.accounts.AccountsCallbackHelpers;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.cbl.CBLLogic;
import com.amazon.identity.auth.device.endpoint.OpenIdRequest;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPInit, SigninOption, Callback, MAPFuture, 
//            RegistrationType

public class MAPAccountManager
{
    public static final class AuthPortalActivityUIOptions
    {

        public static final String KEY_ABOVE_LOCKSCREEN = "AuthPortalActivityUIOptions.aboveLockScreen";
        public static final String KEY_AMAZON_SCREEN_MODES = "AuthPortalActivityUIOptions.amazonScreenModes";
        public static final String KEY_INVERT_SPINNER = "progressbar_invert_spinner";
        public static final String KEY_IS_FULLSCREEN = "AuthPortalActivityUIOptions.fullscreen";
        public static final String KEY_PROGRESSBAR_BACKGROUND_RESOURCE = "progressbar_background_resource";
        public static final String KEY_PROGRESSBAR_FADE = "progressbar_fade";
        public static final String KEY_PROGRESSBAR_POSITION = "progressbar_position";
        public static final String KEY_PROGRESSBAR_PRIMARY_COLOR = "progressbar_primary_color";
        public static final String KEY_PROGRESSBAR_RESOURCE = "progressbar_resource";
        public static final String KEY_PROGRESSBAR_SECONDARY_COLOR = "progressbar_secondary_color";
        public static final String KEY_PROGRESSBAR_STATE = "progressbar_state";
        public static final String KEY_PROGRESSBAR_STRETCH = "progressbar_stretch";
        public static final String KEY_REQUESTED_ORIENTATION = "AuthPortalActivityUIOptions.requestedOrientation";
        public static final String KEY_SPLASH_SCREEN_RESOURCE = "splashscreen_resource";
        public static final String KEY_SPLASH_SCREEN_SCALE_TYPE = "splashscreen_scale_type";
        public static final String KEY_SYSTEM_UI_VISIBILITY = "AuthPortalActivityUIOptions.systemUiVisibility";
        public static final String KEY_WINDOW_FLAGS = "AuthPortalActivityUIOptions.windowFlags";

        public AuthPortalActivityUIOptions()
        {
        }
    }

    public static final class AuthPortalActivityUIOptions.ProgressBarState extends Enum
    {

        private static final AuthPortalActivityUIOptions.ProgressBarState $VALUES[];
        public static final AuthPortalActivityUIOptions.ProgressBarState OFF;
        public static final AuthPortalActivityUIOptions.ProgressBarState PROGRESS_BAR;
        public static final AuthPortalActivityUIOptions.ProgressBarState SPINNER_LARGE;
        public static final AuthPortalActivityUIOptions.ProgressBarState SPINNER_MEDIUM;
        public static final AuthPortalActivityUIOptions.ProgressBarState SPINNER_SMALL;
        private String mValue;

        public static AuthPortalActivityUIOptions.ProgressBarState get(String s)
        {
            AuthPortalActivityUIOptions.ProgressBarState aprogressbarstate[] = values();
            int j = aprogressbarstate.length;
            for (int i = 0; i < j; i++)
            {
                AuthPortalActivityUIOptions.ProgressBarState progressbarstate = aprogressbarstate[i];
                if (progressbarstate.getValue().equals(s))
                {
                    return progressbarstate;
                }
            }

            MAPLog.formattedError(MAPAccountManager.TAG, "Invalid ProgressBarState value: %s", new Object[] {
                s
            });
            return null;
        }

        public static AuthPortalActivityUIOptions.ProgressBarState valueOf(String s)
        {
            return (AuthPortalActivityUIOptions.ProgressBarState)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ProgressBarState, s);
        }

        public static AuthPortalActivityUIOptions.ProgressBarState[] values()
        {
            return (AuthPortalActivityUIOptions.ProgressBarState[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        public String toString()
        {
            return getValue();
        }

        static 
        {
            OFF = new AuthPortalActivityUIOptions.ProgressBarState("OFF", 0, "off");
            PROGRESS_BAR = new AuthPortalActivityUIOptions.ProgressBarState("PROGRESS_BAR", 1, "progress_bar");
            SPINNER_SMALL = new AuthPortalActivityUIOptions.ProgressBarState("SPINNER_SMALL", 2, "spinner_small");
            SPINNER_MEDIUM = new AuthPortalActivityUIOptions.ProgressBarState("SPINNER_MEDIUM", 3, "spinner_medium");
            SPINNER_LARGE = new AuthPortalActivityUIOptions.ProgressBarState("SPINNER_LARGE", 4, "spinner_large");
            $VALUES = (new AuthPortalActivityUIOptions.ProgressBarState[] {
                OFF, PROGRESS_BAR, SPINNER_SMALL, SPINNER_MEDIUM, SPINNER_LARGE
            });
        }

        private AuthPortalActivityUIOptions.ProgressBarState(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }

    public static final class AuthPortalActivityUIOptions.ScreenPosition extends Enum
    {

        private static final AuthPortalActivityUIOptions.ScreenPosition $VALUES[];
        public static final AuthPortalActivityUIOptions.ScreenPosition BOTTOM_CENTER;
        public static final AuthPortalActivityUIOptions.ScreenPosition BOTTOM_LEFT;
        public static final AuthPortalActivityUIOptions.ScreenPosition BOTTOM_RIGHT;
        public static final AuthPortalActivityUIOptions.ScreenPosition CENTER_CENTER;
        public static final AuthPortalActivityUIOptions.ScreenPosition CENTER_LEFT;
        public static final AuthPortalActivityUIOptions.ScreenPosition CENTER_RIGHT;
        public static final AuthPortalActivityUIOptions.ScreenPosition TOP_CENTER;
        public static final AuthPortalActivityUIOptions.ScreenPosition TOP_LEFT;
        public static final AuthPortalActivityUIOptions.ScreenPosition TOP_RIGHT;
        private String mValue;

        public static AuthPortalActivityUIOptions.ScreenPosition get(String s)
        {
            AuthPortalActivityUIOptions.ScreenPosition ascreenposition[] = values();
            int j = ascreenposition.length;
            for (int i = 0; i < j; i++)
            {
                AuthPortalActivityUIOptions.ScreenPosition screenposition = ascreenposition[i];
                if (screenposition.getValue().equals(s))
                {
                    return screenposition;
                }
            }

            MAPLog.formattedError(MAPAccountManager.TAG, "Invalid ScreenPosition value: %s", new Object[] {
                s
            });
            return null;
        }

        public static AuthPortalActivityUIOptions.ScreenPosition valueOf(String s)
        {
            return (AuthPortalActivityUIOptions.ScreenPosition)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$AuthPortalActivityUIOptions$ScreenPosition, s);
        }

        public static AuthPortalActivityUIOptions.ScreenPosition[] values()
        {
            return (AuthPortalActivityUIOptions.ScreenPosition[])$VALUES.clone();
        }

        public String getValue()
        {
            return mValue;
        }

        public String toString()
        {
            return getValue();
        }

        static 
        {
            TOP_LEFT = new AuthPortalActivityUIOptions.ScreenPosition("TOP_LEFT", 0, "top_left");
            TOP_CENTER = new AuthPortalActivityUIOptions.ScreenPosition("TOP_CENTER", 1, "top_center");
            TOP_RIGHT = new AuthPortalActivityUIOptions.ScreenPosition("TOP_RIGHT", 2, "top_right");
            CENTER_LEFT = new AuthPortalActivityUIOptions.ScreenPosition("CENTER_LEFT", 3, "center_left");
            CENTER_CENTER = new AuthPortalActivityUIOptions.ScreenPosition("CENTER_CENTER", 4, "center_center");
            CENTER_RIGHT = new AuthPortalActivityUIOptions.ScreenPosition("CENTER_RIGHT", 5, "center_right");
            BOTTOM_LEFT = new AuthPortalActivityUIOptions.ScreenPosition("BOTTOM_LEFT", 6, "bottom_left");
            BOTTOM_CENTER = new AuthPortalActivityUIOptions.ScreenPosition("BOTTOM_CENTER", 7, "bottom_center");
            BOTTOM_RIGHT = new AuthPortalActivityUIOptions.ScreenPosition("BOTTOM_RIGHT", 8, "bottom_right");
            $VALUES = (new AuthPortalActivityUIOptions.ScreenPosition[] {
                TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER_LEFT, CENTER_CENTER, CENTER_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
            });
        }

        private AuthPortalActivityUIOptions.ScreenPosition(String s, int i, String s1)
        {
            super(s, i);
            mValue = s1;
        }
    }

    public static final class AuthPortalOptions
    {

        public static final String KEY_ASSOCIATION_HANDLE = "com.amazon.identity.ap.assoc_handle";
        public static final String KEY_CLIENT_CONTEXT = "com.amazon.identity.ap.clientContext";
        public static final String KEY_DOMAIN = "com.amazon.identity.ap.domain";
        public static final String KEY_PAGEID = "com.amazon.identity.ap.pageid";
        public static final String KEY_PREFIX = "com.amazon.identity.ap";
        public static final String KEY_REQUEST_PARAMETERS = "com.amazon.identity.ap.request.parameters";

        public AuthPortalOptions()
        {
        }
    }

    public static final class RegistrationError extends Enum
    {

        private static final RegistrationError $VALUES[];
        public static final RegistrationError ACCOUNT_ALREADY_EXISTS;
        public static final RegistrationError ALREADY_DEREGISTERED;
        public static final RegistrationError AUTHENTICATION_CHALLENGED;
        public static final RegistrationError AUTHENTICATION_FAILED;
        public static final RegistrationError BAD_REQUEST;
        public static final RegistrationError BAD_SECRET;
        public static final RegistrationError CUSTOMER_NOT_FOUND;
        public static final RegistrationError DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED;
        public static final RegistrationError DEREGISTER_FAILED;
        public static final RegistrationError DEVICE_ALREADY_REGISTERED;
        public static final RegistrationError DUPLICATE_DEVICE_NAME;
        public static final RegistrationError INTERNAL_ERROR;
        public static final RegistrationError NETWORK_FAILURE;
        public static final RegistrationError NO_ACCOUNT;
        public static final RegistrationError PARSE_ERROR;
        public static final RegistrationError REGISTER_FAILED;
        public static final RegistrationError UI_NOT_FOUND;
        public static final RegistrationError UNRECOGNIZED;
        private final String mName;
        private final int mValue;

        public static RegistrationError fromValue(int i)
        {
            RegistrationError registrationerror = fromValueHelper(i);
            if (registrationerror != null)
            {
                return registrationerror;
            } else
            {
                throw new IndexOutOfBoundsException();
            }
        }

        public static RegistrationError fromValue(int i, RegistrationError registrationerror)
        {
            RegistrationError registrationerror1 = fromValueHelper(i);
            if (registrationerror1 != null)
            {
                return registrationerror1;
            } else
            {
                return registrationerror;
            }
        }

        private static RegistrationError fromValueHelper(int i)
        {
            RegistrationError aregistrationerror[] = values();
            int k = aregistrationerror.length;
            for (int j = 0; j < k; j++)
            {
                RegistrationError registrationerror = aregistrationerror[j];
                if (registrationerror.value() == i)
                {
                    return registrationerror;
                }
            }

            return null;
        }

        public static RegistrationError valueOf(String s)
        {
            return (RegistrationError)Enum.valueOf(com/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError, s);
        }

        public static RegistrationError[] values()
        {
            return (RegistrationError[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        public int value()
        {
            return mValue;
        }

        static 
        {
            ACCOUNT_ALREADY_EXISTS = new RegistrationError("ACCOUNT_ALREADY_EXISTS", 0, 0, "AccountAlreadyExists");
            NETWORK_FAILURE = new RegistrationError("NETWORK_FAILURE", 1, 1, "NetworkFailure");
            AUTHENTICATION_FAILED = new RegistrationError("AUTHENTICATION_FAILED", 2, 2, "AuthenticationFailed");
            PARSE_ERROR = new RegistrationError("PARSE_ERROR", 3, 3, "ParseError");
            CUSTOMER_NOT_FOUND = new RegistrationError("CUSTOMER_NOT_FOUND", 4, 4, "CustomerNotFound");
            DEVICE_ALREADY_REGISTERED = new RegistrationError("DEVICE_ALREADY_REGISTERED", 5, 5, "DeviceAlreadyRegistered");
            DUPLICATE_DEVICE_NAME = new RegistrationError("DUPLICATE_DEVICE_NAME", 6, 6, "DuplicateDeviceName");
            DEREGISTER_FAILED = new RegistrationError("DEREGISTER_FAILED", 7, 7, "DeregisterFailed");
            UNRECOGNIZED = new RegistrationError("UNRECOGNIZED", 8, 8, "Unrecognized");
            REGISTER_FAILED = new RegistrationError("REGISTER_FAILED", 9, 9, "RegisterFailed");
            BAD_REQUEST = new RegistrationError("BAD_REQUEST", 10, 10, "BadRequest");
            ALREADY_DEREGISTERED = new RegistrationError("ALREADY_DEREGISTERED", 11, 11, "AlreadyDeregistered");
            BAD_SECRET = new RegistrationError("BAD_SECRET", 12, 12, "BadSecret");
            NO_ACCOUNT = new RegistrationError("NO_ACCOUNT", 13, 13, "NoAccount");
            UI_NOT_FOUND = new RegistrationError("UI_NOT_FOUND", 14, 14, "UINotFound");
            DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED = new RegistrationError("DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED", 15, 15, "DelegateeAccountAlreadyDeregistered");
            AUTHENTICATION_CHALLENGED = new RegistrationError("AUTHENTICATION_CHALLENGED", 16, 16, "AuthenticationChallenged");
            INTERNAL_ERROR = new RegistrationError("INTERNAL_ERROR", 17, 17, "InternalError");
            $VALUES = (new RegistrationError[] {
                ACCOUNT_ALREADY_EXISTS, NETWORK_FAILURE, AUTHENTICATION_FAILED, PARSE_ERROR, CUSTOMER_NOT_FOUND, DEVICE_ALREADY_REGISTERED, DUPLICATE_DEVICE_NAME, DEREGISTER_FAILED, UNRECOGNIZED, REGISTER_FAILED, 
                BAD_REQUEST, ALREADY_DEREGISTERED, BAD_SECRET, NO_ACCOUNT, UI_NOT_FOUND, DELEGATEE_ACCOUNT_ALREADY_DEREGISTERED, AUTHENTICATION_CHALLENGED, INTERNAL_ERROR
            });
        }

        private RegistrationError(String s, int i, int j, String s1)
        {
            super(s, i);
            mValue = j;
            mName = s1;
        }
    }


    public static final String ACCOUNT_ADDED_ON_DEVICE_INTENT_ACTION = "com.amazon.identity.auth.account.added.on.device";
    public static final String ACCOUNT_FOR_KEY_HAS_CHANGED_INTENT_ACTION = "com.amazon.identity.action.ACCOUNT_FOR_KEY";
    public static final String ACCOUNT_FOR_PACKAGE_HAS_CHANGED_INTENT_ACTION = "com.amazon.identity.action.ACCOUNT_FOR_PACKAGE_CHANGED";
    public static final String ACCOUNT_REMOVED_ON_DEVICE_INTENT_ACTION = "com.amazon.identity.auth.account.removed.on.device";
    private static final List CLIENT_WHITELIST = Arrays.asList(new String[] {
        "com.amazon.map.sample.one", "com.amazon.map.sample.two", "com.amazon.map.sample", "com.amazon.map.client.sample.three", "com.amazon.kindle.otter.oobe", "com.amazon.kindle.otter.settings", "com.amazon.avod", "com.amazon.alta.h2debug", "com.amazon.venezia", "com.amazon.kor.demo", 
        "com.amazon.h2settingsfortablet", "com.amazon.tv.oobe", "com.googlecode.android_scripting", "com.amazon.aiv.us", "com.amazon.aiv.eu", "com.amazon.aiv.fe", "com.amazon.aiv.blast"
    });
    public static final String KEY_ACCESS_TOKEN = "com.amazon.dcp.sso.AddAccount.options.AccessToken";
    public static final String KEY_ACCOUNT_MISSING_ATTRIBUTES = "AccountMissingAttributes";
    public static final String KEY_ADDITIONAL_SIGNIN_DOMAINS = "signin_domains";
    public static final String KEY_ADD_ACCOUNT_AMAZON_DOMAIN = "com.amazon.identity.ap.domain";
    public static final String KEY_ADP_TOKEN = "adp_token";
    public static final String KEY_ALLOW_ADDING_MULTIPLE_ACCOUNT = "com.amazon.dcp.sso.AddAccount.options.AddAsSecondary";
    public static final String KEY_AMAZON_ACCOUNT_LOGIN_NAME = "authAccount";
    public static final String KEY_AMAZON_ACCOUNT_PASSWORD = "password";
    public static final String KEY_AMAZON_DOMAIN = "com.amazon.identity.ap.domain";
    public static final String KEY_AP_ASSOC_HANDLE = "com.amazon.identity.ap.assoc_handle";
    public static final String KEY_AP_PAGEID = "com.amazon.identity.ap.pageid";
    public static final String KEY_AT_MAIN = "com.amazon.dcp.sso.AddAccount.options.ATMain";
    public static final String KEY_AUTHENTICATION_CHALLENGE = "com.amazon.identity.auth.ChallengeException";
    public static final String KEY_AUTH_DATA_ADDITIONAL_INFO = "auth_data_additional_info";
    public static final String KEY_AUTH_TOKEN = "com.amazon.dcp.sso.AddAccount.options.AuthToken";
    public static final String KEY_AUTH_TOKEN_CONTEXT = "com.amazon.dcp.sso.AddAccount.options.AuthTokenClientContext";
    public static final String KEY_CLAIM_TYPE = "claim_type";
    public static final String KEY_DEVICE_NAME = "device_name";
    public static final String KEY_DIRECTED_ID = "com.amazon.dcp.sso.property.account.acctId";
    public static final String KEY_DIRECTED_ID_DELEGATEE = "com.amazon.dcp.sso.property.account.delegateeaccount";
    public static final String KEY_DMS_GET_CREDENTIALS_URL = "com.amazon.dcp.sso.AddAccount.options.URL";
    public static final String KEY_ENSURE_ACCOUNT_STATE_ATTRIBUTES = "EnsureAccountStateAttributes";
    public static final String KEY_ERROR_CODE = "com.amazon.dcp.sso.ErrorCode";
    public static final String KEY_ERROR_MESSAGE = "com.amazon.dcp.sso.ErrorMessage";
    public static final String KEY_EXTRA_DIRECTED_ID = "com.amazon.dcp.sso.extra.account.directed_id";
    public static final String KEY_EXTRA_KEY = "account_key";
    public static final String KEY_EXTRA_PROFILES_ACCOUNT_ADDED_OR_REMOVED_BELONG_TO = "com.amazon.identity.auth.extra.account.profiles";
    public static final String KEY_GET_LINK_CODE_WITH_LENGTH = "get_link_code_with_length";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_IS_NEW_ACCOUNT = "com.amazon.identity.auth.device.accountManager.newaccount";
    public static final String KEY_LINK_CODE = "link_code";
    public static final String KEY_LINK_CODE_DOMAIN = "link_code_domain";
    public static final String KEY_LINK_CODE_TIME_TO_LIVE = "link_code_expiry";
    public static final String KEY_OVERRIDE_RETURN_TO_DOMAIN = "return_to_domain";
    public static final String KEY_PRE_AUTHORIZED_LINK_CODE = "pre_authorized_link_code";
    public static final String KEY_PRIVATE_KEY = "adp_private_key";
    public static final String KEY_PROFILE_MAPPING = "profile_mapping";
    public static final String KEY_REGISTRATION_DOMAIN = "registration_domain";
    public static final String KEY_RESULT_CODE = "result code";
    public static final String KEY_RESUME_AUTHENTICATION_URL = "resume_authentication_url";
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/api/MAPAccountManager.getSimpleName();
    public static final String PRIMARY_AMAZON_ACCOUNT_ADDED_INTENT_ACTION = "com.amazon.dcp.sso.action.account.added";
    public static final String PRIMARY_AMAZON_ACCOUNT_REMOVED_INTENT_ACTION = "com.amazon.dcp.sso.action.account.removed";
    public static final String SECONDARY_AMAZON_ACCOUNT_ADDED_INTENT_ACTION = "com.amazon.dcp.sso.action.secondary.account.added";
    public static final String SECONDARY_AMAZON_ACCOUNT_REMOVED_INTENT_ACTION = "com.amazon.dcp.sso.action.secondary.account.removed";
    private static final String TAG = com/amazon/identity/auth/device/api/MAPAccountManager.getName();
    private final ServiceWrappingContext mContext;
    private AccountManagerDefinition mInnerAccountManager;
    private final Object mLock[] = new Object[0];

    public MAPAccountManager(Context context)
    {
        MAPInit.getInstance(context).initialize();
        mContext = ServiceWrappingContext.create(context);
    }

    private Bundle addClientMetadata(Bundle bundle)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        bundle.putString("calling_package", mContext.getPackageName());
        bundle.putInt("calling_profile", AndroidUser.getMyUserId());
        return bundle;
    }

    private AccountManagerDefinition getInternalImpl()
    {
        AccountManagerDefinition accountmanagerdefinition;
        synchronized (mLock)
        {
            if (mInnerAccountManager == null)
            {
                mInnerAccountManager = AccountManagerImplementationFactory.getAccountManagerImplementation(mContext);
            }
            accountmanagerdefinition = mInnerAccountManager;
        }
        return accountmanagerdefinition;
        exception;
        aobj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private String getTracerNameForSpecificFlow(Bundle bundle, String s)
    {
        if (bundle != null && bundle.containsKey("com.amazon.identity.auth.ChallengeException"))
        {
            Bundle bundle1 = bundle.getBundle("com.amazon.identity.auth.ChallengeException");
            if (bundle1 != null)
            {
                String s3 = bundle1.getString("com.amazon.identity.auth.ChallengeException.Reason");
                String s1 = s3;
                if (TextUtils.isEmpty(s3))
                {
                    s1 = "Challenge";
                }
                s1 = (new StringBuilder()).append(s).append(":").append(s1).toString();
                s3 = bundle1.getString("com.amazon.identity.auth.ChallengeException.requiredAuthenticationMethod");
                if (!TextUtils.isEmpty(s3))
                {
                    (new StringBuilder()).append(s1).append(":").append(s3);
                }
            }
        }
        String s2 = s;
        if (isAuthenticateWithResumeUrlFlow(bundle))
        {
            s2 = (new StringBuilder()).append(s).append(":ResumeUrl").toString();
        }
        return s2;
    }

    private boolean isAuthenticateWithResumeUrlFlow(Bundle bundle)
    {
        return bundle != null && bundle.containsKey("resume_authentication_url") && !TextUtils.isEmpty(bundle.getString("resume_authentication_url"));
    }

    private void logAndThrowException(String s)
    {
        MAPLog.e(TAG, s);
        throw new IllegalArgumentException(s);
    }

    private MAPFuture throwBadRequestError(CallbackFuture callbackfuture, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.ErrorCode", RegistrationError.BAD_REQUEST.value());
        bundle.putString("com.amazon.dcp.sso.ErrorMessage", s);
        callbackfuture.onError(bundle);
        return callbackfuture;
    }

    public MAPFuture authenticateAccount(final Activity activity, final SigninOption signinOption, final Bundle authData, final Bundle options, final Callback callbackFuture)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        Tracer tracer = Tracer.getNewTracer("AuthenticateAccount");
        if (activity == null)
        {
            return throwBadRequestError(callbackFuture, "Activity passed should not be null. Please pass non null activity");
        } else
        {
            Bundle bundle = addClientMetadata(authData);
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "authenticateAccount");
            getInternalImpl().authenticateAccount(bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, new Callback() {

                final MAPAccountManager this$0;
                final Activity val$activity;
                final Bundle val$authData;
                final CallbackFuture val$callbackFuture;
                final Bundle val$options;
                final SigninOption val$signinOption;

                public void onError(Bundle bundle1)
                {
                    if (bundle1.getInt("com.amazon.dcp.sso.ErrorCode", -1) == RegistrationError.AUTHENTICATION_CHALLENGED.value())
                    {
                        bundle1 = bundle1.getBundle("com.amazon.identity.auth.ChallengeException");
                        Bundle bundle2 = new Bundle();
                        if (options != null)
                        {
                            bundle2.putAll(options);
                        }
                        Object obj = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(bundle1);
                        if (authData.containsKey("com.amazon.dcp.sso.property.account.acctId") && !bundle2.containsKey("com.amazon.dcp.sso.property.account.acctId"))
                        {
                            bundle2.putString("com.amazon.dcp.sso.property.account.acctId", authData.getString("com.amazon.dcp.sso.property.account.acctId"));
                        }
                        bundle2.putBundle("com.amazon.identity.auth.ChallengeException", bundle1);
                        authenticateAccountWithUI(activity, signinOption, bundle2, callbackFuture);
                        return;
                    } else
                    {
                        callbackFuture.onError(bundle1);
                        return;
                    }
                }

                public void onSuccess(Bundle bundle1)
                {
                    callbackFuture.onSuccess(bundle1);
                }

            
            {
                this$0 = MAPAccountManager.this;
                callbackFuture = callbackfuture;
                options = bundle;
                authData = bundle1;
                activity = activity1;
                signinOption = signinoption;
                super();
            }
            }), tracer);
            return callbackFuture;
        }
    }

    public MAPFuture authenticateAccount(Bundle bundle, Callback callback)
    {
        callback = new CallbackFuture(callback);
        Tracer tracer = Tracer.getNewTracer("AuthenticateAccountWithoutActivity");
        bundle = addClientMetadata(bundle);
        if (CLIENT_WHITELIST.contains(mContext.getPackageName()))
        {
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "authenticateAccount_legacy");
            getInternalImpl().authenticateAccount(bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
            return callback;
        } else
        {
            return throwBadRequestError(callback, "This API has been deprecated. Please use our new API MAPAccountManager.authenticateAccount(Activity, SigninOptions, Bundle, Bundle, Callback). Please refer to the authenticateAccount API Java doc for more details.");
        }
    }

    public MAPFuture authenticateAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback)
    {
        CallbackFuture callbackfuture = CallbackFuture.create(callback);
        Tracer tracer = Tracer.getNewTracer(getTracerNameForSpecificFlow(bundle, (new StringBuilder("AuthenticateAccountWithUI:")).append(signinoption.name()).toString()));
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        getInternalImpl().authenticateAccountWithUI(activity, signinoption, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback, isAuthenticateWithResumeUrlFlow(bundle)), tracer);
        return callbackfuture;
    }

    public MAPFuture authorizeLinkCode(Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("AuthorizeLinkCode");
        Object obj = tracer.startTimer("Time");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        callback = CallbackFuture.create(callback);
        obj = MetricsHelper.wrapCallback(tracer, ((PlatformMetricsTimer) (obj)), callback);
        (new CBLLogic(mContext)).authorizeLinkCode(bundle, ((Callback) (obj)), tracer);
        return callback;
    }

    public MAPFuture confirmCredential(Activity activity, String s, Bundle bundle, Callback callback)
    {
        callback = new CallbackFuture(callback);
        Tracer tracer = Tracer.getNewTracer("DeregisterDevice");
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        getInternalImpl().confirmCredential(activity, s, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
        return callback;
    }

    public MAPFuture deregisterAccount(String s, Callback callback)
    {
        MAPLog.formattedInfo(TAG, "deregisterAccount called by %s", new Object[] {
            mContext.getPackageName()
        });
        Tracer tracer = Tracer.getNewTracer("DeregisterAccount");
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        return getInternalImpl().deregisterAccount(s, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
    }

    public MAPFuture deregisterDevice(Callback callback)
    {
        MAPLog.formattedInfo(TAG, "deregisterDevice called by %s", new Object[] {
            mContext.getPackageName()
        });
        Tracer tracer = Tracer.getNewTracer("DeregisterDevice");
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        return getInternalImpl().deregisterDevice(MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
    }

    public MAPFuture ensureAccountState(Activity activity, String s, Bundle bundle, Callback callback)
    {
        CallbackFuture callbackfuture = CallbackFuture.create(callback);
        Tracer tracer = Tracer.getNewTracer("EnsureAccountState");
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        if (activity == null)
        {
            logAndThrowException("For ensureAccountState activity can not be null");
        } else
        if (TextUtils.isEmpty(s))
        {
            logAndThrowException("For ensureAccountState directedId can not be null");
        } else
        if (bundle == null)
        {
            logAndThrowException("For ensureAccountState options can not be null");
        } else
        {
            String s1 = bundle.getString("com.amazon.identity.ap.domain");
            Object obj = bundle.getBundle("com.amazon.identity.ap.request.parameters");
            if (obj == null || ((Bundle) (obj)).isEmpty())
            {
                logAndThrowException("For ensureAccountState requestParameters which contains associationHandle can not be null");
            } else
            {
                obj = ((Bundle) (obj)).getString("openid.assoc_handle");
                ArrayList arraylist = bundle.getStringArrayList("EnsureAccountStateAttributes");
                if (TextUtils.isEmpty(s1))
                {
                    logAndThrowException("For ensureAccountState domain can not be null");
                } else
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    logAndThrowException("For ensureAccountState associationHandle can not be null");
                } else
                if (arraylist == null || arraylist.isEmpty())
                {
                    logAndThrowException("For ensureAccountState assertExistingAttributes can not be null");
                }
            }
        }
        if (!isAccountRegistered(s))
        {
            MAPLog.e(TAG, "The given account is not registered");
            callback.onError(AccountsCallbackHelpers.getErrorBundle(RegistrationError.CUSTOMER_NOT_FOUND.value(), String.format("Given directedId %s is not registered.", new Object[] {
                s
            })));
            return callbackfuture;
        } else
        {
            getInternalImpl().ensureAccountState(activity, s, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback, true), tracer);
            return callbackfuture;
        }
    }

    public String ensureAmazonAccount(Activity activity)
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        if (isDeviceRegistered())
        {
            break MISSING_BLOCK_LABEL_96;
        }
        MAPLog.i(TAG, "No amazon account found. Try to create one.");
        if (ThreadUtils.isRunningOnMainThread())
        {
            MAPLog.e(TAG, "Invoked on main thread.");
            throw new IllegalStateException("Do not run on main thread.");
        }
        break MISSING_BLOCK_LABEL_54;
        activity;
        aobj;
        JVM INSTR monitorexit ;
        throw activity;
        activity = registerAccountWithUI(activity, SigninOption.WebviewSignin, null, null);
        activity.get();
        activity = getAccount();
        aobj;
        JVM INSTR monitorexit ;
        return activity;
        activity;
        MAPLog.e(TAG, "Got exception when creating amazon account.", activity);
        aobj;
        JVM INSTR monitorexit ;
        return null;
        MAPLog.i(TAG, "Already have an amazon account.");
        activity = getAccount();
        aobj;
        JVM INSTR monitorexit ;
        return activity;
    }

    public String generateForgotPasswordUrl(Bundle bundle)
    {
        return (new OpenIdRequest(null, com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.FORGOT_PASSWORD, bundle)).getRequestUrl();
    }

    public MAPFuture generateLinkCode(Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("GenerateLinkCode");
        Object obj = tracer.startTimer("Time");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        callback = CallbackFuture.create(callback);
        obj = MetricsHelper.wrapCallback(tracer, ((PlatformMetricsTimer) (obj)), callback);
        (new CBLLogic(mContext)).generateLinkCode(bundle, ((Callback) (obj)), tracer);
        return callback;
    }

    public MAPFuture generatePreAuthorizedLinkCode(Bundle bundle, Callback callback)
    {
        Tracer tracer = Tracer.getNewTracer("GeneratePreAuthorizedLinkCode");
        Object obj = tracer.startTimer("Time");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        callback = CallbackFuture.create(callback);
        obj = MetricsHelper.wrapCallback(tracer, ((PlatformMetricsTimer) (obj)), callback);
        (new CBLLogic(mContext)).generatePreAuthorizedLinkCode(bundle, ((Callback) (obj)), tracer);
        return callback;
    }

    public String getAccount()
    {
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAccount");
        String s = getInternalImpl().getAccount(mContext.getPackageName());
        platformmetricstimer.stop();
        return s;
        Exception exception;
        exception;
        platformmetricstimer.stop();
        throw exception;
    }

    public Set getAccounts()
    {
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAccounts");
        Set set = getInternalImpl().getAccounts();
        platformmetricstimer.stop();
        return set;
        Exception exception;
        exception;
        platformmetricstimer.stop();
        throw exception;
    }

    public String getPrimaryAccount()
    {
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getPrimaryAccount");
        String s = getInternalImpl().getPrimaryAccount();
        platformmetricstimer.stop();
        return s;
        Exception exception;
        exception;
        platformmetricstimer.stop();
        throw exception;
    }

    public boolean isAccountRegistered(String s)
    {
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "isAccountRegistered");
        boolean flag = getInternalImpl().isAccountRegistered(s);
        platformmetricstimer.stop();
        return flag;
        s;
        platformmetricstimer.stop();
        throw s;
    }

    public boolean isDeviceRegistered()
    {
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "isDeviceRegistered");
        boolean flag = getInternalImpl().isDeviceRegistered();
        platformmetricstimer.stop();
        return flag;
        Exception exception;
        exception;
        platformmetricstimer.stop();
        throw exception;
    }

    public MAPFuture registerAccount(final Activity activity, final Bundle regData, final Bundle options, Callback callback)
    {
        final CallbackFuture callbackFuture = CallbackFuture.create(callback);
        if (activity == null)
        {
            return throwBadRequestError(callbackFuture, "Activity passed should not be null. Please pass non null activity");
        }
        final Tracer tracer = RegistrationType.WITH_LOGIN_CREDENTIALS;
        callback = tracer;
        if (regData != null)
        {
            callback = tracer;
            if (regData.containsKey("com.amazon.dcp.sso.property.account.acctId"))
            {
                callback = RegistrationType.WITH_DIRECTEDID_CREDENTIALS;
            }
        }
        tracer = Tracer.getNewTracer((new StringBuilder("RegisterAccount:")).append(callback.name()).toString());
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        Bundle bundle = addClientMetadata(regData);
        getInternalImpl().registerAccount(callback, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, new Callback() {

            final MAPAccountManager this$0;
            final Activity val$activity;
            final CallbackFuture val$callbackFuture;
            final Bundle val$options;
            final Bundle val$regData;
            final Tracer val$tracer;

            public void onError(Bundle bundle1)
            {
                if (bundle1.getInt("com.amazon.dcp.sso.ErrorCode", -1) == RegistrationError.AUTHENTICATION_CHALLENGED.value())
                {
                    Bundle bundle3 = bundle1.getBundle("com.amazon.identity.auth.ChallengeException");
                    Bundle bundle2 = options;
                    bundle1 = bundle2;
                    if (bundle2 == null)
                    {
                        bundle1 = new Bundle();
                    }
                    Object obj = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(bundle1);
                    bundle1.putBundle("com.amazon.identity.auth.ChallengeException", bundle3);
                    registerAccountWithUI(activity, SigninOption.WebviewSignin, bundle1, callbackFuture);
                    return;
                } else
                {
                    callbackFuture.onError(bundle1);
                    return;
                }
            }

            public void onSuccess(final Bundle result)
            {
                if (options != null && options.containsKey("EnsureAccountStateAttributes"))
                {
                    MAPLog.i(MAPAccountManager.TAG, "Register account is done, going to check whether the account has assert attributes");
                    Object obj = result.getString("com.amazon.dcp.sso.property.account.acctId");
                    String s = ((String) (obj));
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        MAPLog.i(MAPAccountManager.TAG, "Did not get the directedID in the reg success respone so we are going to fix the account we get from getAccount(). It should not happen on Gen6+ and normal 3P devices.");
                        s = getAccount();
                    }
                    obj = new Bundle();
                    ((Bundle) (obj)).putString("com.amazon.identity.ap.domain", regData.getString("com.amazon.identity.ap.domain"));
                    ((Bundle) (obj)).putBundle("com.amazon.identity.ap.request.parameters", options.getBundle("com.amazon.identity.ap.request.parameters"));
                    ((Bundle) (obj)).putStringArrayList("EnsureAccountStateAttributes", options.getStringArrayList("EnsureAccountStateAttributes"));
                    result = s. new Callback() {

                        final _cls1 this$1;
                        final String val$finalDirectedId;
                        final Bundle val$result;

                        public void onError(Bundle bundle)
                        {
                            try
                            {
                                tracer.incrementCounter("DeregisterAfterEnsuringAccountStateFail");
                                MAPLog.i(MAPAccountManager.TAG, "Going to degister the account, since the account doesn't have assert attributes");
                                deregisterAccount(finalDirectedId, null).get();
                            }
                            catch (Exception exception)
                            {
                                MAPLog.e(MAPAccountManager.TAG, "Exception happened when try to degister account because of missing assert attributes");
                            }
                            callbackFuture.onError(bundle);
                        }

                        public void onSuccess(Bundle bundle)
                        {
                            result.putAll(bundle);
                            callbackFuture.onSuccess(result);
                        }

            
            {
                this$1 = final__pcls1;
                result = bundle;
                finalDirectedId = String.this;
                super();
            }
                    };
                    tracer.incrementCounter("RegisterAccountWithEnsuringAccountState");
                    ensureAccountState(activity, s, ((Bundle) (obj)), result);
                    return;
                } else
                {
                    callbackFuture.onSuccess(result);
                    return;
                }
            }

            
            {
                this$0 = MAPAccountManager.this;
                options = bundle;
                regData = bundle1;
                callbackFuture = callbackfuture;
                tracer = tracer1;
                activity = activity1;
                super();
            }
        }), tracer);
        return callbackFuture;
    }

    public MAPFuture registerAccount(RegistrationType registrationtype, Bundle bundle, Callback callback)
    {
        Object obj = MetricsHelper.getRegType(registrationtype);
        Tracer tracer = Tracer.getNewTracer((new StringBuilder("RegisterAccountWithoutActivity:")).append(((String) (obj))).toString());
        obj = CallbackFuture.create(callback);
        if ((RegistrationType.WITH_LOGIN_CREDENTIALS == registrationtype || RegistrationType.WITH_DIRECTEDID_CREDENTIALS == registrationtype) && !CLIENT_WHITELIST.contains(mContext.getPackageName()))
        {
            return throwBadRequestError(((CallbackFuture) (obj)), (new StringBuilder("Invalid RegistrationType. RegisterAccount API with RegistrationType:")).append(registrationtype.getName()).append(" has been removed. Please use our new API MAPAccountManager.registerAccount(Activity, Bundle, Bundle, Callback). Please refer to the registerAccount API Java doc for more details.").toString());
        }
        callback = ((Callback) (obj));
        if (RegistrationType.WITH_LINK_CODE == registrationtype)
        {
            String s = bundle.getString("link_code");
            callback = bundle.getString("pre_authorized_link_code");
            if (TextUtils.isEmpty(s) && TextUtils.isEmpty(callback))
            {
                MAPLog.i(TAG, "No link code passed in the registerAccount API WITH_LINK_CODE");
                return throwBadRequestError(((CallbackFuture) (obj)), "A required parameter link code was not passed in the API. Call MAPAccountManager#generateLinkCode() or MAPAccountManager#generatePreAuthorizedLinkCode() to get a link code based on your use-case and pass them in the key MAPAccountManager#KEY_LINK_CODE or MAPAccountManager#KEY_PRE_AUTHORIZED_LINK_CODE respectively.");
            }
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(callback))
            {
                MAPLog.i(TAG, "Multiple link code keys set");
                return throwBadRequestError(((CallbackFuture) (obj)), "You cannot set both the keys MAPAccountManager#KEY_LINK_CODE and MAPAccountManager#KEY_PRE_AUTHORIZED_LINK_CODE. Based on the type of link code you have, set the appropriate key as specified in the javadoc of RegistrationType#WITH_LINK_CODE.");
            }
            callback = ((Callback) (obj));
            if (!TextUtils.isEmpty(s))
            {
                com.amazon.identity.auth.device.cbl.CBLLogic.CBLData cbldata = CBLLogic.getCBLDataFromStorage(mContext);
                if (cbldata == null)
                {
                    return throwBadRequestError(((CallbackFuture) (obj)), "The link code that MAP had has expired or it has not been generated yet. Please call MAPAccountManager#generateLinkCode to generate the link code.");
                }
                if (!cbldata.mPublicCode.equals(s))
                {
                    return throwBadRequestError(((CallbackFuture) (obj)), "The link code does not match the one that MAP has. Please call MAPAccountManager#generateLinkCode to get the link code.");
                }
                callback = CBLLogic.wrapCallbackToClearCBLStore(mContext, ((CallbackFuture) (obj)));
                bundle.putString("cbl_public_code", cbldata.mPublicCode);
                bundle.putString("cbl_private_code", cbldata.mPrivateCode);
            }
        }
        obj = tracer.startTimer("Time");
        bundle = addClientMetadata(bundle);
        getInternalImpl().registerAccount(registrationtype, bundle, MetricsHelper.wrapCallback(tracer, ((PlatformMetricsTimer) (obj)), callback), tracer);
        return callback;
    }

    public MAPFuture registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback)
    {
        MAPArgContracts.throwIfNull(signinoption, "option");
        Tracer tracer = Tracer.getNewTracer(getTracerNameForSpecificFlow(bundle, (new StringBuilder("RegisterAccountWithUI:")).append(signinoption.name()).toString()));
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("Time");
        callback = CallbackFuture.create(callback);
        getInternalImpl().registerAccountWithUI(activity, signinoption, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback, isAuthenticateWithResumeUrlFlow(bundle)), tracer);
        return callback;
    }

    public MAPFuture registerDelegatedAccount(String s, String s1, Bundle bundle, Callback callback)
    {
        callback = CallbackFuture.create(callback);
        Tracer tracer = Tracer.getNewTracer("registerDelegatedAccount");
        PlatformMetricsTimer platformmetricstimer = tracer.startTimer("registerDelegatedAccount_totalTime");
        tracer.incrementCounter("registerDelegatedAccount_count");
        MAPLog.i(TAG, "registerDelegatedAccount() is deprecated. Please use registerAccount().");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("com.amazon.dcp.sso.property.account.acctId", s1);
        bundle.putString("com.amazon.dcp.sso.property.account.delegateeaccount", s);
        bundle.putBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary", true);
        getInternalImpl().registerAccount(RegistrationType.REGISTER_DELEGATED_ACCOUNT, bundle, MetricsHelper.wrapCallback(tracer, platformmetricstimer, callback), tracer);
        return callback;
    }




/*
    static void access$100$155a5955$7f64b773(Bundle bundle, String s)
    {
        Object obj = EnvironmentUtils.getInstance().getCompleteAuthPortalDomain(s);
        String s2 = EnvironmentUtils.getInstance().getDefaultAssocHandle(s);
        if (((String) (obj)).equals("www.amazon.com") || ((String) (obj)).equals("development.amazon.com") || ((String) (obj)).equals("pre-prod.amazon.com"))
        {
            return;
        }
        obj = bundle.getBundle("com.amazon.identity.ap.request.parameters");
        s = ((String) (obj));
        if (obj == null)
        {
            s = new Bundle();
        }
        if (TextUtils.isEmpty(s.getString("openid.assoc_handle")))
        {
            if (!TextUtils.isEmpty(bundle.getString("com.amazon.identity.ap.assoc_handle")))
            {
                s.putString("openid.assoc_handle", bundle.getString("com.amazon.identity.ap.assoc_handle"));
            } else
            {
                String s1 = s2;
                if (TextUtils.isEmpty(s2))
                {
                    s1 = "amzn_device_android";
                }
                s.putString("openid.assoc_handle", s1);
            }
        }
        if (TextUtils.isEmpty(s.getString("pageId")))
        {
            if (!TextUtils.isEmpty(bundle.getString("com.amazon.identity.ap.pageid")))
            {
                s.putString("pageId", bundle.getString("com.amazon.identity.ap.pageid"));
            } else
            {
                s.putString("pageId", "amzn_device_common_dark");
            }
        }
        bundle.putBundle("com.amazon.identity.ap.request.parameters", s);
        return;
    }

*/
}
