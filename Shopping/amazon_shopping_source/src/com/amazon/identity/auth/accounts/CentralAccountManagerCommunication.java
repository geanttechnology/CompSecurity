// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.features.Feature;
import com.amazon.identity.auth.device.features.FeatureSet;
import com.amazon.identity.auth.device.features.FeatureSetCache;
import com.amazon.identity.auth.device.features.FeatureSetProvider;
import com.amazon.identity.auth.device.framework.AccountManagerCallbackAdapter;
import com.amazon.identity.auth.device.framework.AccountManagerFutureAdapter;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.GenericIPCSender;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.CallbackUtils;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsRequest;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerDefinition, AccountsCallbackHelpers, StandardAccountManagerCallbackAdapter, AccountManagerLogic, 
//            StandardAccountManagerFutureAdapter, AmazonAccountManager, ChildApplicationHelpers, SubAuthenticatorDescription

public class CentralAccountManagerCommunication
    implements AccountManagerDefinition
{
    public static class AuthenticateAccountAction
        implements IPCCommand
    {

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = AccountManagerLogic.getInstance(context);
            Tracer tracer = Tracer.createFromBundle(bundle, "AuthenticateAccount:");
            context.authenticateAccount(bundle, MetricsHelper.wrapCallback(tracer, callback), tracer);
            return null;
        }

        public AuthenticateAccountAction()
        {
        }
    }

    public static class DeregisterAccountAction
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directedId";

        public static Bundle parametersToBundle(String s, Tracer tracer)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            tracer.addToBundle(bundle);
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directedId");
            context = AccountManagerLogic.getInstance(context);
            bundle = Tracer.createFromBundle(bundle, "DeregisterAccount");
            context.deregisterAccount(s, MetricsHelper.wrapRegistrationCallbackWithMetrics(callback, bundle, "com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED), bundle);
            return null;
        }

        public DeregisterAccountAction()
        {
        }
    }

    public static class DeregisterDeviceAction
        implements IPCCommand
    {

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = AccountManagerLogic.getInstance(context);
            bundle = Tracer.createFromBundle(bundle, "DeregisterDevice");
            context.deregisterDevice(MetricsHelper.wrapRegistrationCallbackWithMetrics(callback, bundle, "com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED), bundle);
            return null;
        }

        public DeregisterDeviceAction()
        {
        }
    }

    public static class GetAccountAction
        implements IPCCommand
    {

        public static final String KEY_PACKAGE_NAME = "packageName";
        public static final String KEY_VALUE = "value";

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public static Bundle parametersToBundle(String s)
        {
            Bundle bundle = new Bundle();
            bundle.putString("packageName", s);
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle = bundle.getString("packageName");
            context = AccountManagerLogic.getInstance(context);
            callback = new Bundle();
            callback.putString("value", context.getAccount(bundle));
            return callback;
        }

        public GetAccountAction()
        {
        }
    }

    public static class GetAccountsAction
        implements IPCCommand
    {

        public static final String KEY_VALUES = "values";

        public static Set getResult(Bundle bundle)
        {
            bundle = bundle.getStringArray("values");
            HashSet hashset = new HashSet();
            if (bundle != null)
            {
                hashset.addAll(Arrays.asList(bundle));
            }
            return hashset;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = AccountManagerLogic.getInstance(context);
            bundle = new Bundle();
            bundle.putStringArray("values", (String[])context.getAccounts().toArray(new String[0]));
            return bundle;
        }

        public GetAccountsAction()
        {
        }
    }

    public static class GetPrimaryAccountAction
        implements IPCCommand
    {

        public static final String KEY_VALUE = "value";

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = AccountManagerLogic.getInstance(context);
            bundle = new Bundle();
            bundle.putString("value", context.getPrimaryAccount());
            return bundle;
        }

        public GetPrimaryAccountAction()
        {
        }
    }

    public static class IsAccountRegisteredAction
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directed_id";
        public static final String KEY_VALUE = "value";

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public static Bundle parametersToBundle(String s)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directed_id", s);
            return bundle;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            bundle = bundle.getString("directed_id");
            context = AccountManagerLogic.getInstance(context);
            callback = new Bundle();
            callback.putBoolean("value", context.isAccountRegistered(bundle));
            return callback;
        }

        public IsAccountRegisteredAction()
        {
        }
    }

    public static class IsDeviceRegisteredAction
        implements IPCCommand
    {

        public static final String KEY_CALLING_APPLICATION_INFO_BUNDLE = "calling.app.info";
        public static final String KEY_VALUE = "value";

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            context = AccountManagerLogic.getInstance(context);
            bundle = new Bundle();
            bundle.putBoolean("value", context.isDeviceRegistered());
            return bundle;
        }

        public IsDeviceRegisteredAction()
        {
        }
    }

    public static class RegisterAccountAction
        implements IPCCommand
    {

        public static final String KEY_REG_DATA = "regData";
        public static final String KEY_REG_TYPE = "regType";

        public static Bundle parametersToBundle(RegistrationType registrationtype, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("regType", registrationtype.getName());
            bundle1.putBundle("regData", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            RegistrationType registrationtype;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            registrationtype = RegistrationType.fromName(bundle.getString("regType"));
            bundle1 = bundle.getBundle("regData");
            context = AccountManagerLogic.getInstance(context);
            bundle = Tracer.createFromBundle(bundle, (new StringBuilder("RegisterAccount:")).append(MetricsHelper.getRegType(registrationtype)).toString());
            bundle.incrementCounter("Count");
            context.registerAccount(registrationtype, bundle1, MetricsHelper.wrapRegistrationCallbackWithMetrics(callback, bundle, "com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED), bundle);
            return null;
        }

        public RegisterAccountAction()
        {
        }
    }

    public static class RegisterChildApplication
        implements IPCCommand
    {

        public static final String KEY_DEVICE_TYPE = "device_type";
        public static final String KEY_DIRECTED_ID = "directed_id";
        public static final String KEY_OPTIONS = "options";

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("device_type", s1);
            bundle1.putBundle("options", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            String s1;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directed_id");
            s1 = bundle.getString("device_type");
            bundle1 = bundle.getBundle("options");
            context = AccountManagerLogic.getInstance(context);
            bundle = Tracer.createFromBundle(bundle, "RegisterChildApplication");
            context.registerChildApplication(s, s1, bundle1, MetricsHelper.wrapCallback(bundle, callback), bundle);
            return null;
        }

        public RegisterChildApplication()
        {
        }
    }

    public static class RenameDeviceAction
        implements IPCCommand
    {

        public static final String KEY_DEVICE_NAME_ERROR = "deviceNameError";
        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_NEW_DEVICE_NAME = "newDeviceName";
        public static final String KEY_OPTIONS = "options";

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directedId", s);
            bundle1.putString("newDeviceName", s1);
            bundle1.putBundle("options", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            String s1;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directedId");
            s1 = bundle.getString("newDeviceName");
            bundle1 = bundle.getBundle("options");
            context = AccountManagerLogic.getInstance(context);
            bundle = Tracer.createFromBundle(bundle, "RenameDevice");
            context.renameDevice(s, s1, bundle1, MetricsHelper.wrapCallback(bundle, callback), bundle);
            return null;
        }

        public RenameDeviceAction()
        {
        }
    }

    public static class UpdateCredentialsAction
        implements IPCCommand
    {

        public static final String KEY_DIRECTED_ID = "directedId";
        public static final String KEY_KEY = "key";
        public static final String KEY_OPTIONS = "options";

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directedId", s);
            bundle1.putString("key", s1);
            bundle1.putBundle("options", bundle);
            return bundle1;
        }

        public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
        {
            String s;
            KeyInfo keyinfo;
            Bundle bundle1;
            if (bundle == null)
            {
                bundle = new Bundle();
            }
            s = bundle.getString("directedId");
            keyinfo = KeyInfo.parseKey(bundle.getString("key"));
            bundle1 = bundle.getBundle("options");
            AccountManagerLogic.getInstance(context).updateAccountWithKey(s, keyinfo, bundle1, callback, Tracer.createFromBundle(bundle, "UpdateCredentials"));
            return null;
        }

        public UpdateCredentialsAction()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/CentralAccountManagerCommunication.getName();
    private AccountManagerLogic mAccountManLogic;
    private final AccountManagerWrapper mAcctManWrapper;
    private final Context mContext;
    private FeatureSet mFeatureSet;
    private final GenericIPCSender mGenericIpcSender;
    private PlatformWrapper mPlatform;

    public CentralAccountManagerCommunication(Context context)
    {
        this(context, new GenericIPCSender(context, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value())));
    }

    public CentralAccountManagerCommunication(Context context, AccountManagerLogic accountmanagerlogic)
    {
        this(context);
        mAccountManLogic = accountmanagerlogic;
    }

    public CentralAccountManagerCommunication(Context context, FeatureSet featureset, PlatformWrapper platformwrapper)
    {
        this(context);
        mFeatureSet = featureset;
        mPlatform = platformwrapper;
    }

    public CentralAccountManagerCommunication(Context context, GenericIPCSender genericipcsender)
    {
        mContext = ServiceWrappingContext.create(context);
        mAcctManWrapper = (AccountManagerWrapper)mContext.getSystemService("dcp_account_manager");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mGenericIpcSender = genericipcsender;
        mFeatureSet = new FeatureSetCache(new FeatureSetProvider(mContext));
    }

    private Bundle addClientMetadata(Bundle bundle)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        bundle.putString("calling_package", mContext.getPackageName());
        bundle.putInt("calling_profile", AndroidUser.getMyUserId());
        return bundle;
    }

    private AccountManagerCallback getAccountManagerCallback(Callback callback)
    {
        if (callback == null)
        {
            return null;
        } else
        {
            return new StandardAccountManagerCallbackAdapter(callback);
        }
    }

    private AccountManagerLogic getAccountManagerLogicInstance()
    {
        this;
        JVM INSTR monitorenter ;
        AccountManagerLogic accountmanagerlogic;
        if (mAccountManLogic == null)
        {
            mAccountManLogic = AccountManagerLogic.getInstance(mContext);
        }
        accountmanagerlogic = mAccountManLogic;
        this;
        JVM INSTR monitorexit ;
        return accountmanagerlogic;
        Exception exception;
        exception;
        throw exception;
    }

    private String getNewestPackageWithDeviceType(String s)
    {
        Iterator iterator = MAPApplicationInformationQueryer.getInstance(mContext).getSortedByLatestMapApplications().iterator();
_L2:
        RemoteMapInfo remotemapinfo;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        remotemapinfo = (RemoteMapInfo)iterator.next();
        String s1;
        if (!TextUtils.equals(remotemapinfo.getDeviceType(), s))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = remotemapinfo.getPackageName();
        return s1;
        RemoteMAPException remotemapexception;
        remotemapexception;
        MAPLog.w(TAG, (new StringBuilder("Couldn't determine device type for ")).append(remotemapinfo.getPackageName()).toString(), remotemapexception);
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    private MAPFuture updateCredentials$11ad18a8(Account account, String s, Bundle bundle, Callback callback)
    {
        callback = getAccountManagerCallback(callback);
        return new StandardAccountManagerFutureAdapter(mAcctManWrapper.updateCredentials(account, s, bundle, null, callback, null));
    }

    public void authenticateAccount(Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = addClientMetadata(bundle);
        if (mPlatform.isPostMergeDevice())
        {
            tracer.addToBundle(bundle);
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$AuthenticateAccountAction, bundle, callback);
            return;
        } else
        {
            getAccountManagerLogicInstance().authenticateAccount(bundle, callback, tracer);
            return;
        }
    }

    public void authenticateAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        getAccountManagerLogicInstance().authenticateAccountWithUI(activity, signinoption, bundle, callback, tracer);
    }

    public void confirmCredential(Activity activity, String s, Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        getAccountManagerLogicInstance().confirmCredential(activity, s, bundle, callback, tracer);
    }

    public MAPFuture deregisterAccount(String s, Callback callback, Tracer tracer)
    {
        if (mPlatform.isPostMergeDevice())
        {
            callback = new CallbackFuture(callback);
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterAccountAction, DeregisterAccountAction.parametersToBundle(s, tracer), callback);
            return callback;
        }
        if (mPlatform.isBackedByAccountManager())
        {
            tracer = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
            if (tracer == null)
            {
                return CallbackUtils.callbackSuccessAndReturnResult(callback, AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED.value(), "Account given does not exist or was already deregistered"));
            }
            if (callback == null)
            {
                s = null;
            } else
            {
                s = new AccountManagerCallbackAdapter(callback) {

                    final CentralAccountManagerCommunication this$0;

                    protected void onResult(Callback callback1, Boolean boolean1)
                    {
                        if (boolean1 == null || !boolean1.booleanValue())
                        {
                            callback1.onError(AccountsCallbackHelpers.getErrorBundle(CentralAccountManagerCommunication.this));
                            return;
                        } else
                        {
                            callback1.onSuccess(new Bundle(CentralAccountManagerCommunication.this));
                            return;
                        }
                    }

                    protected volatile void onResult(Callback callback1, Object obj)
                    {
                        onResult(callback1, (Boolean)obj);
                    }

            
            {
                this$0 = CentralAccountManagerCommunication.this;
                super(callback);
            }
                };
            }
            return new AccountManagerFutureAdapter(mAcctManWrapper.removeAccount(tracer, s)) {

                final CentralAccountManagerCommunication this$0;

                protected Bundle getResultBundle(Boolean boolean1)
                    throws MAPCallbackErrorException
                {
                    if (boolean1 == null || !boolean1.booleanValue())
                    {
                        throw new MAPCallbackErrorException(AccountsCallbackHelpers.getErrorBundle(CentralAccountManagerCommunication.this));
                    } else
                    {
                        return new Bundle(CentralAccountManagerCommunication.this);
                    }
                }

                protected volatile Bundle getResultBundle(Object obj)
                    throws MAPCallbackErrorException
                {
                    return getResultBundle((Boolean)obj);
                }

            
            {
                this$0 = CentralAccountManagerCommunication.this;
                super(accountmanagerfuture);
            }
            };
        } else
        {
            return getAccountManagerLogicInstance().deregisterAccount(s, callback, tracer);
        }
    }

    public MAPFuture deregisterDevice(Callback callback, Tracer tracer)
    {
        if (mPlatform.isPostMergeDevice())
        {
            callback = new CallbackFuture(callback);
            Bundle bundle = new Bundle();
            tracer.addToBundle(bundle);
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$DeregisterDeviceAction, bundle, callback);
            return callback;
        }
        if (mPlatform.isBackedByAccountManager())
        {
            return deregisterAccount(((AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man")).getDevicePrimaryAmazonAccount(), callback, tracer);
        } else
        {
            return getAccountManagerLogicInstance().deregisterDevice(callback, tracer);
        }
    }

    public String getAccount(String s)
    {
        if (mPlatform.isPostMergeDevice())
        {
            s = GetAccountAction.parametersToBundle(s);
            return GetAccountAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountAction, s));
        } else
        {
            return getAccountManagerLogicInstance().getAccount(s);
        }
    }

    public Set getAccounts()
    {
        if (mPlatform.isPostMergeDevice())
        {
            return GetAccountsAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetAccountsAction, null));
        } else
        {
            return getAccountManagerLogicInstance().getAccounts();
        }
    }

    public String getPrimaryAccount()
    {
        if (mPlatform.isPostMergeDevice())
        {
            return GetPrimaryAccountAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$GetPrimaryAccountAction, null));
        } else
        {
            return getAccountManagerLogicInstance().getPrimaryAccount();
        }
    }

    public boolean isAccountRegistered(String s)
    {
        if (mPlatform.isPostMergeDevice())
        {
            s = IsAccountRegisteredAction.parametersToBundle(s);
            return IsAccountRegisteredAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsAccountRegisteredAction, s));
        } else
        {
            return getAccountManagerLogicInstance().isAccountRegistered(s);
        }
    }

    public boolean isDeviceRegistered()
    {
        if (mPlatform.isPostMergeDevice())
        {
            return IsDeviceRegisteredAction.getResult(mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$IsDeviceRegisteredAction, null));
        } else
        {
            return getAccountManagerLogicInstance().isDeviceRegistered();
        }
    }

    public void registerAccount(RegistrationType registrationtype, Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = addClientMetadata(bundle);
        if (mPlatform.isPostMergeDevice())
        {
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction, RegisterAccountAction.parametersToBundle(registrationtype, bundle, tracer), callback);
            return;
        }
        if (mPlatform.isBackedByAccountManager())
        {
            bundle.putString("registration_type", registrationtype.getName());
            if (registrationtype.equals(RegistrationType.FROM_AUTH_TOKEN) && !mFeatureSet.hasFeature(Feature.RegistrationViaAuthToken))
            {
                MAPLog.e(TAG, "Registration via auth token is not supported on this platform.");
                callback.onError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Registration via auth token is not supported on this platform."));
                return;
            } else
            {
                registrationtype = getAccountManagerCallback(callback);
                mAcctManWrapper.addAccount("com.amazon.account", null, null, bundle, null, registrationtype, null);
                return;
            }
        } else
        {
            getAccountManagerLogicInstance().registerAccount(registrationtype, bundle, callback, tracer);
            return;
        }
    }

    public void registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        getAccountManagerLogicInstance().registerAccountWithUI(activity, signinoption, bundle, callback, tracer);
    }

    public MAPFuture registerChildApplication(String s, String s1, Bundle bundle, Callback callback, final Tracer tracer)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        if (!mPlatform.isPostMergeDevice())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        callback = new CallbackFuture(callback);
        if (ChildApplicationHelpers.isChildApplication(mContext, s1)) goto _L2; else goto _L1
_L1:
        AccountsCallbackHelpers.onError(callback, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), String.format("%s is not a child application device type", new Object[] {
            s1
        }), null);
_L4:
        return callback;
_L2:
        boolean flag;
        if (ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, s, s1))
        {
            MAPLog.i(TAG, String.format("Child application device type %s is already registered", new Object[] {
                s1
            }));
            callback.onSuccess(ChildApplicationHelpers.createSuccessBundle());
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication, RegisterChildApplication.parametersToBundle(s, s1, bundle, tracer), callback);
        return callback;
        if (mPlatform.isPreMergeDevice())
        {
            final CallbackFuture callbackFuture = new CallbackFuture(callback);
            Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
            if (account == null)
            {
                AccountsCallbackHelpers.onError(callbackFuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND.value(), "Account given does not exist or was already deregistered", null);
                return callbackFuture;
            }
            Object obj = getNewestPackageWithDeviceType(s1);
            if (obj == null)
            {
                AccountsCallbackHelpers.onError(callbackFuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("Could not find a package that registers the child device type %s", new Object[] {
                    s1
                }), null);
                return callbackFuture;
            }
            String s2 = SubAuthenticatorDescription.getDMSAdpTokenNameFromPackageName(((String) (obj)));
            String s3 = SubAuthenticatorDescription.getDMSDeviceTypeFromPackageName(((String) (obj)));
            obj = new TokenCache(mContext, account);
            boolean flag1;
            if (((TokenCache) (obj)).getToken(s2) == null)
            {
                flag1 = false;
            } else
            if (ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, s, s1))
            {
                flag1 = false;
            } else
            {
                flag1 = true;
            }
            if (flag1)
            {
                MAPLog.i(TAG, "Upgrading SSO credentials (from DMS Sub Auth) to MAP R5 credentials for device type %s", new Object[] {
                    s1
                });
                s = ((TokenCache) (obj)).getToken(s3);
                if (s != null && !s.equals(s1))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1)
                {
                    MAPLog.e(TAG, String.format("Cannot upgrade a legacy child device type: %s  to a different device type: %s. This is a bug. Deregistering the device to clean up.", new Object[] {
                        s, s1
                    }));
                    ThreadUtils.submitToBackgroundThread(new Runnable() {

                        final CentralAccountManagerCommunication this$0;
                        final Tracer val$tracer;

                        public void run()
                        {
                            deregisterDevice(new Callback() {

                                final _cls1 this$1;

                                public void onError(Bundle bundle)
                                {
                                    MAPLog.e(CentralAccountManagerCommunication.TAG, "Failed to deregister the device after detecting child device type change.");
                                }

                                public void onSuccess(Bundle bundle)
                                {
                                    MAPLog.i(CentralAccountManagerCommunication.TAG, "Device was deregistered due to the child device type change.");
                                }

            
            {
                this$1 = _cls1.this;
                super();
            }
                            }, tracer);
                        }

            
            {
                this$0 = CentralAccountManagerCommunication.this;
                tracer = tracer1;
                super();
            }
                    });
                    AccountsCallbackHelpers.onError(callbackFuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), "Cannot upgrade a legacy child device type to a different device type. Deregistering the device to clean up the bad state.", null);
                    return callbackFuture;
                } else
                {
                    return updateCredentials$11ad18a8(account, s2, bundle, callback);
                }
            } else
            {
                s = new com.amazon.identity.auth.device.token.TokenCache.Listener() {

                    final CentralAccountManagerCommunication this$0;
                    final CallbackFuture val$callbackFuture;

                    public void failure(String s4, int i, String s5)
                    {
                        AccountsCallbackHelpers.onError(callbackFuture, i, s5, null);
                    }

                    public void failure(String s4, Bundle bundle1)
                    {
                        callbackFuture.onError(bundle1);
                    }

                    public void success()
                    {
                        callbackFuture.onSuccess(new Bundle());
                    }

            
            {
                this$0 = CentralAccountManagerCommunication.this;
                callbackFuture = callbackfuture;
                super();
            }
                };
                ((TokenCache) (obj)).fetchTokens(new String[] {
                    s2
                }, s);
                return callbackFuture;
            }
        } else
        {
            return getAccountManagerLogicInstance().registerChildApplication(s, s1, bundle, callback, tracer);
        }
    }

    public MAPFuture renameDevice(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        if (mPlatform.isPostMergeDevice())
        {
            callback = new CallbackFuture(callback);
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RenameDeviceAction, RenameDeviceAction.parametersToBundle(s, s1, bundle, tracer), callback);
            return callback;
        } else
        {
            return getAccountManagerLogicInstance().renameDevice(s, s1, bundle, callback, tracer);
        }
    }

    public MAPFuture updateAccountWithKey(String s, KeyInfo keyinfo, Bundle bundle, Callback callback, Tracer tracer)
    {
        if (mPlatform.isPostMergeDevice())
        {
            callback = new CallbackFuture(callback);
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$UpdateCredentialsAction, UpdateCredentialsAction.parametersToBundle(s, keyinfo.getRawKey(), bundle), callback);
            return callback;
        }
        if (!mPlatform.isBackedByAccountManager())
        {
            break MISSING_BLOCK_LABEL_291;
        }
        tracer = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
        s = keyinfo.getRawKey();
        if (!mPlatform.isPostMergeDevice())
        {
            if (DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, keyinfo.getPackageName()))
            {
                s = "com.amazon.dcp.sso.token.devicedevicetype";
            } else
            {
                s = new StringBuffer();
                s.append(keyinfo.getPackageName());
                s.append(".tokens.");
                if (keyinfo.getKey().equals("com.amazon.dcp.sso.token.devicedevicetype"))
                {
                    s.append("device_type");
                } else
                if (keyinfo.getKey().equals("com.amazon.dcp.sso.token.device.deviceserialname"))
                {
                    s.append("dsn");
                } else
                if (keyinfo.getKey().equals("com.amazon.dcp.sso.property.deviceemail"))
                {
                    s.append("email");
                } else
                if (keyinfo.getKey().equals("com.amazon.dcp.sso.property.devicename"))
                {
                    s.append("device_name");
                } else
                {
label0:
                    {
                        if (!keyinfo.getKey().equals("com.amazon.dcp.sso.property.username"))
                        {
                            break label0;
                        }
                        s.append("user_name");
                    }
                }
                s = s.toString();
            }
        }
_L1:
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle.putString("com.amazon.dcp.sso.AddAccount.options.URL", UpdateDeviceCredentialsRequest.getDefaultUrl());
        return updateCredentials$11ad18a8(tracer, s, bundle, callback);
        s = keyinfo.getRawKey();
          goto _L1
        return getAccountManagerLogicInstance().updateAccountWithKey(s, keyinfo, bundle, callback, tracer);
    }




}
