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
import com.amazon.identity.auth.device.framework.AccountManagerCallbackAdapter;
import com.amazon.identity.auth.device.framework.AccountManagerFutureAdapter;
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
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsRequest;
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

        public AuthenticateAccountAction()
        {
        }
    }

    public static class DeregisterAccountAction
        implements IPCCommand
    {

        public static Bundle parametersToBundle(String s, Tracer tracer)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            tracer.addToBundle(bundle);
            return bundle;
        }

        public DeregisterAccountAction()
        {
        }
    }

    public static class DeregisterDeviceAction
        implements IPCCommand
    {

        public DeregisterDeviceAction()
        {
        }
    }

    public static class GetAccountAction
        implements IPCCommand
    {

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

        public GetAccountAction()
        {
        }
    }

    public static class GetAccountsAction
        implements IPCCommand
    {

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

        public GetAccountsAction()
        {
        }
    }

    public static class GetPrimaryAccountAction
        implements IPCCommand
    {

        public static String getResult(Bundle bundle)
        {
            return bundle.getString("value");
        }

        public GetPrimaryAccountAction()
        {
        }
    }

    public static class IsAccountRegisteredAction
        implements IPCCommand
    {

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

        public IsAccountRegisteredAction()
        {
        }
    }

    public static class IsDeviceRegisteredAction
        implements IPCCommand
    {

        public static boolean getResult(Bundle bundle)
        {
            return bundle.getBoolean("value");
        }

        public IsDeviceRegisteredAction()
        {
        }
    }

    public static class RegisterAccountAction
        implements IPCCommand
    {

        public static Bundle parametersToBundle(RegistrationType registrationtype, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("regType", registrationtype.getName());
            bundle1.putBundle("regData", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public RegisterAccountAction()
        {
        }
    }

    public static class RegisterChildApplication
        implements IPCCommand
    {

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directed_id", s);
            bundle1.putString("device_type", s1);
            bundle1.putBundle("options", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public RegisterChildApplication()
        {
        }
    }

    public static class RenameDeviceAction
        implements IPCCommand
    {

        public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("directedId", s);
            bundle1.putString("newDeviceName", s1);
            bundle1.putBundle("options", bundle);
            tracer.addToBundle(bundle1);
            return bundle1;
        }

        public RenameDeviceAction()
        {
        }
    }

    public static class UpdateCredentialsAction
        implements IPCCommand
    {

        public static Bundle parametersToBundle$4fbc83d1(String s, String s1)
        {
            Bundle bundle = new Bundle();
            bundle.putString("directedId", s);
            bundle.putString("key", s1);
            bundle.putBundle("options", null);
            return bundle;
        }

        public UpdateCredentialsAction()
        {
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/CentralAccountManagerCommunication.getName();
    private AccountManagerLogic mAccountManLogic;
    private final AccountManagerWrapper mAcctManWrapper;
    private final ServiceWrappingContext mContext;
    private FeatureSet mFeatureSet;
    private final GenericIPCSender mGenericIpcSender;
    private PlatformWrapper mPlatform;

    public CentralAccountManagerCommunication(Context context)
    {
        this(context, new GenericIPCSender(context, "com.amazon.dcp.sso.ErrorCode", "com.amazon.dcp.sso.ErrorMessage", Integer.valueOf(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value())));
    }

    public CentralAccountManagerCommunication(Context context, GenericIPCSender genericipcsender)
    {
        mContext = ServiceWrappingContext.create(context);
        mAcctManWrapper = (AccountManagerWrapper)mContext.getSystemService("dcp_account_manager");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mGenericIpcSender = genericipcsender;
        mFeatureSet = mContext.getFeatureSet();
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

    private MAPFuture updateCredentials$11ad18a8$621b1426(Account account, String s, Bundle bundle)
    {
        AccountManagerCallback accountmanagercallback = getAccountManagerCallback(null);
        return new StandardAccountManagerFutureAdapter(mAcctManWrapper.updateCredentials$28742b0c(account, s, bundle, accountmanagercallback));
    }

    public void authenticateAccount(Bundle bundle, Callback callback, Tracer tracer)
    {
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
        tracer = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
        if (tracer == null)
        {
            s = AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED.value(), "Account given does not exist or was already deregistered");
            callback = new CallbackFuture(callback);
            callback.onSuccess(s);
            return callback;
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
                        callback1.onError(AccountsCallbackHelpers.getErrorBundle());
                        return;
                    } else
                    {
                        callback1.onSuccess(new Bundle());
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
                    throw new MAPCallbackErrorException(AccountsCallbackHelpers.getErrorBundle());
                } else
                {
                    return new Bundle();
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
        } else
        {
            return deregisterAccount(((AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man")).getDevicePrimaryAmazonAccount(), callback, tracer);
        }
    }

    public void ensureAccountState(Activity activity, String s, Bundle bundle, Callback callback, Tracer tracer)
    {
        getAccountManagerLogicInstance().ensureAccountState(activity, s, bundle, callback, tracer);
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
        if (mPlatform.isGroverInstalled() || mPlatform.isCanaryInstalled())
        {
            bundle.remove("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary");
        }
        if (registrationtype == RegistrationType.FROM_ADP_TOKEN)
        {
            getAccountManagerLogicInstance().bootstrapMAPWithADPToken(bundle, callback, tracer);
            return;
        }
        if (mPlatform.isPostMergeDevice())
        {
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterAccountAction, RegisterAccountAction.parametersToBundle(registrationtype, bundle, tracer), callback);
            return;
        }
        bundle.putString("registration_type", registrationtype.getName());
        if (registrationtype.equals(RegistrationType.FROM_AUTH_TOKEN) && !mFeatureSet.hasFeature(Feature.RegistrationViaAuthToken))
        {
            MAPLog.e(TAG, "Registration via auth token is not supported on this platform.");
            callback.onError(AccountsCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Registration via auth token is not supported on this platform."));
            return;
        } else
        {
            registrationtype = getAccountManagerCallback(callback);
            mAcctManWrapper.addAccount$2c9ed9ad("com.amazon.account", bundle, registrationtype);
            return;
        }
    }

    public void registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        getAccountManagerLogicInstance().registerAccountWithUI(activity, signinoption, bundle, callback, tracer);
    }

    public MAPFuture registerChildApplication$3b8086d2(String s, String s1, Bundle bundle, final Tracer tracer)
    {
        CallbackFuture callbackfuture;
        bundle = BundleUtils.constructEmptyBundleIfNull(bundle);
        if (!mPlatform.isPostMergeDevice())
        {
            break MISSING_BLOCK_LABEL_150;
        }
        callbackfuture = new CallbackFuture(null);
        if (ChildApplicationHelpers.isChildApplication(mContext, s1)) goto _L2; else goto _L1
_L1:
        AccountsCallbackHelpers.onError(callbackfuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), String.format("%s is not a child application device type", new Object[] {
            s1
        }), null);
_L4:
        return callbackfuture;
_L2:
        boolean flag;
        if (ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, mContext.getDataStorage(), s, s1))
        {
            MAPLog.i(TAG, String.format("Child application device type %s is already registered", new Object[] {
                s1
            }));
            callbackfuture.onSuccess(ChildApplicationHelpers.createSuccessBundle());
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$RegisterChildApplication, RegisterChildApplication.parametersToBundle(s, s1, bundle, tracer), callbackfuture);
        return callbackfuture;
        final CallbackFuture callbackFuture = new CallbackFuture(null);
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
        if (ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, mContext.getDataStorage(), s, s1))
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (flag1)
        {
            MAPLog.formattedInfo(TAG, "Upgrading SSO credentials (from DMS Sub Auth) to MAP R5 credentials for device type %s", new Object[] {
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
                return updateCredentials$11ad18a8$621b1426(account, s2, bundle);
            }
        } else
        {
            s = new com.amazon.identity.auth.device.token.TokenCache.Listener() {

                final CentralAccountManagerCommunication this$0;
                final CallbackFuture val$callbackFuture;

                public void failure$2498c652(int i, String s4)
                {
                    AccountsCallbackHelpers.onError(callbackFuture, i, s4, null);
                }

                public void failure$5dc9c75(Bundle bundle1)
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

    public MAPFuture updateAccountWithKey$5e2b1462(String s, KeyInfo keyinfo, Tracer tracer)
    {
        CallbackFuture callbackfuture = new CallbackFuture(null);
        if (mPlatform.isPostMergeDevice())
        {
            mGenericIpcSender.call(com/amazon/identity/auth/accounts/CentralAccountManagerCommunication$UpdateCredentialsAction, UpdateCredentialsAction.parametersToBundle._mth4fbc83d1(s, keyinfo.getRawKey()), callbackfuture);
            return callbackfuture;
        }
        tracer = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, s);
        if (tracer == null)
        {
            AccountsCallbackHelpers.onError(callbackfuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND.value(), "Account given does not exist or was already deregistered", null);
            return callbackfuture;
        }
        s = keyinfo.getRawKey();
        if (mPlatform.isPostMergeDevice()) goto _L2; else goto _L1
_L1:
        if (!DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, keyinfo.getPackageName())) goto _L4; else goto _L3
_L3:
        s = "com.amazon.dcp.sso.token.devicedevicetype";
_L2:
        keyinfo = new Bundle();
        keyinfo.putString("com.amazon.dcp.sso.AddAccount.options.URL", UpdateDeviceCredentialsRequest.getDefaultUrl());
        return updateCredentials$11ad18a8$621b1426(tracer, s, keyinfo);
_L4:
        s = new StringBuffer();
        s.append(keyinfo.getPackageName());
        s.append(".tokens.");
        if (!keyinfo.getKey().equals("com.amazon.dcp.sso.token.devicedevicetype")) goto _L6; else goto _L5
_L5:
        s.append("device_type");
_L8:
        s = s.toString();
        continue; /* Loop/switch isn't completed */
_L6:
        if (keyinfo.getKey().equals("com.amazon.dcp.sso.token.device.deviceserialname"))
        {
            s.append("dsn");
            continue; /* Loop/switch isn't completed */
        }
        if (keyinfo.getKey().equals("com.amazon.dcp.sso.property.deviceemail"))
        {
            s.append("email");
            continue; /* Loop/switch isn't completed */
        }
        if (keyinfo.getKey().equals("com.amazon.dcp.sso.property.devicename"))
        {
            s.append("device_name");
            continue; /* Loop/switch isn't completed */
        }
        if (!keyinfo.getKey().equals("com.amazon.dcp.sso.property.username"))
        {
            break; /* Loop/switch isn't completed */
        }
        s.append("user_name");
        if (true) goto _L8; else goto _L7
_L7:
        s = keyinfo.getRawKey();
        if (true) goto _L2; else goto _L9
_L9:
    }




}
