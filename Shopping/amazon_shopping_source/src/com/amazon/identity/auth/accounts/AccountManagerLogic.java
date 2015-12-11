// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.attributes.CORPFMResponse;
import com.amazon.identity.auth.attributes.CorPfmLogic;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreKeyUtils;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.AuthPortalUIActivity;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.identity.auth.device.callback.CallbackFuture;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.CookieDataStore;
import com.amazon.identity.auth.device.storage.CookieDataStoreFactory;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.LocalAppDataAwareDataStorage;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.token.MAPCookieManager;
import com.amazon.identity.auth.device.token.OAuthTokenManager;
import com.amazon.identity.auth.device.token.TokenCallbackHelpers;
import com.amazon.identity.auth.device.utils.AmazonDomainHelper;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.BundleUtils;
import com.amazon.identity.auth.device.utils.CollectionUtils;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.IntentHelpers;
import com.amazon.identity.auth.device.utils.KeyInfo;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.kcpsdk.auth.CredentialMapSerializer;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountManagerDefinition, AccountAuthenticatorQueue, AccountAuthenticator, DeregisterAccount, 
//            RegisterChildApplicationAction, SubAuthenticatorRegistry, AmazonAccountManager, AccountRegistrarAuthenticator, 
//            AccountRegistrar, MultipleAccountsLogic, MultipleAccountPluginHolder, DelegatedAccountHelper, 
//            RenameDevice, AccountsCallbackHelpers, MultipleAccountPlugin, DMSSubAuthenticator, 
//            AccountAuthenticatorResponseHelper, AccountAuthenticatorResponseWrapper, AccountStateBroadcasts

public class AccountManagerLogic
    implements AccountManagerDefinition
{
    private class _cls7
        implements DeregisterAccount.IDeregisterAccount
    {

        final AccountManagerLogic this$0;
        final Account val$backCompatAccount;
        final Callback val$callback;
        final String val$directedId;
        final boolean val$isPrimaryAccount;
        final Set val$profilesForRemovedDirectedId;

        public void onError(int i, String s)
        {
            String s2 = AccountManagerLogic.TAG;
            String s1;
            if (s != null)
            {
                s1 = s;
            } else
            {
                s1 = "<null>";
            }
            MAPLog.e(s2, String.format("Device deregistration error: code = %d, msg = \"%s\"", new Object[] {
                Integer.valueOf(i), s1
            }));
            AccountsCallbackHelpers.onError(callback, i, s, null);
        }

        public void onResult(Bundle bundle)
        {
            if (bundle.getBoolean("booleanResult"))
            {
                MAPLog.i(AccountManagerLogic.TAG, "Device deregistration success");
            } else
            {
                MAPLog.w(AccountManagerLogic.TAG, "Device deregistration failed");
            }
            AccountStateBroadcasts.sendAccountRemovedNotification(mContext, isPrimaryAccount, directedId, backCompatAccount, null, profilesForRemovedDirectedId);
            callbackDeregisterCommon(callback);
        }

        _cls7()
        {
            this$0 = AccountManagerLogic.this;
            isPrimaryAccount = flag;
            directedId = s;
            backCompatAccount = account;
            profilesForRemovedDirectedId = set;
            callback = callback1;
            super();
        }
    }

    private class _cls4
        implements AccountRegistrar.Listener
    {

        final AccountManagerLogic this$0;
        final Callback val$callback;
        final Bundle val$regData;
        final RegistrationType val$regType;

        public void accountAlreadyExists(String s)
        {
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, s);
        }

        public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle)
        {
            onRegistrationError(registrationerror, callback, bundle);
        }

        public void success(final String accountType, final String accountName, final Bundle extras)
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final _cls4 this$1;
                final String val$accountName;
                final String val$accountType;
                final Bundle val$extras;

                public void run()
                {
                    AccountManagerLogic.access$500(_fld0, regType, regData, callback, accountType, accountName, extras);
                }

                
                {
                    this$1 = _cls4.this;
                    accountType = s;
                    accountName = s1;
                    extras = bundle;
                    super();
                }
            });
        }

        _cls4()
        {
            this$0 = AccountManagerLogic.this;
            regType = registrationtype;
            regData = bundle;
            callback = callback1;
            super();
        }
    }

    private class _cls5
        implements com.amazon.identity.auth.device.storage.DataStorage.DataPropogationCallback
    {

        final AccountManagerLogic this$0;
        final String val$deviceEmail;
        final String val$deviceType;
        final String val$directedId;
        final Bundle val$userData;

        public void onSuccess()
        {
            String _tmp = AccountManagerLogic.TAG;
            mMultipleAccountLogic.invalidateCache();
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final _cls5 this$1;

                public void run()
                {
                    CorPfmLogic.notifyChange(directedId, mMultipleAccountPlugin);
                    String s = userData.getString("com.amazon.dcp.sso.property.devicename");
                    UserProperties.sendDeviceNameChangedNotification(mContext, directedId, s);
                    if (!mAmazonAccountManager.isSecondaryAmazonAccount(directedId))
                    {
                        AccountManagerLogic.access$1100(_fld0, deviceEmail, directedId, deviceType);
                    }
                }

                
                {
                    this$1 = _cls5.this;
                    super();
                }
            });
            AccountStateBroadcasts.sendAsynchronousAccountAddedNotification(mContext, mMultipleAccountLogic, mMultipleAccountPlugin, directedId, null);
        }

        _cls5()
        {
            this$0 = AccountManagerLogic.this;
            directedId = s;
            userData = bundle;
            deviceEmail = s1;
            deviceType = s2;
            super();
        }
    }


    private static final AccountAuthenticatorQueue ACCOUNT_AUTHENTICATOR_QUEUE = new AccountAuthenticatorQueue();
    private static final String TAG = com/amazon/identity/auth/accounts/AccountManagerLogic.getName();
    private static AccountManagerLogic sTheOneAndTheOnly;
    private final AmazonAccountManager mAmazonAccountManager;
    private final AccountAuthenticator mAuthenticator;
    private final Context mContext;
    private final CookieDataStore mCookieDataStore;
    private final CorPfmLogic mCorPfmLogic;
    private final DataStorage mDataStorage;
    private final DelegatedAccountHelper mDelegatedAccountHelper;
    private final DeregisterAccount mDeregisterAccount;
    private final MultipleAccountsLogic mMultipleAccountLogic;
    private final MultipleAccountPlugin mMultipleAccountPlugin;
    private final OAuthTokenManager mOAuthTokenManager;
    private final RegisterChildApplicationAction mRegisterChildApplicationAction;
    private final AccountRegistrar mRegistrar;
    private final AccountRegistrarAuthenticator mRegistrarAuthenticator;
    private final SubAuthenticatorRegistry mRegistry;
    private final RenameDevice mRenameDevice;

    public AccountManagerLogic(ServiceWrappingContext servicewrappingcontext)
    {
        this(servicewrappingcontext, new AccountAuthenticator(servicewrappingcontext), new DeregisterAccount(servicewrappingcontext), new RegisterChildApplicationAction(servicewrappingcontext), new SubAuthenticatorRegistry(servicewrappingcontext), new AmazonAccountManager(servicewrappingcontext), new AccountRegistrarAuthenticator(servicewrappingcontext), new AccountRegistrar(servicewrappingcontext), servicewrappingcontext.getDataStorage(), MultipleAccountsLogic.getInstance(servicewrappingcontext), MultipleAccountPluginHolder.getMultipleAccountPlugin(servicewrappingcontext), CorPfmLogic.getInstance(servicewrappingcontext), new DelegatedAccountHelper(), new OAuthTokenManager(servicewrappingcontext), (new CookieDataStoreFactory(servicewrappingcontext)).getDataStore(), new RenameDevice(servicewrappingcontext));
    }

    AccountManagerLogic(ServiceWrappingContext servicewrappingcontext, AccountAuthenticator accountauthenticator, DeregisterAccount deregisteraccount, RegisterChildApplicationAction registerchildapplicationaction, SubAuthenticatorRegistry subauthenticatorregistry, AmazonAccountManager amazonaccountmanager, AccountRegistrarAuthenticator accountregistrarauthenticator, 
            AccountRegistrar accountregistrar, DataStorage datastorage, MultipleAccountsLogic multipleaccountslogic, MultipleAccountPlugin multipleaccountplugin, CorPfmLogic corpfmlogic, DelegatedAccountHelper delegatedaccounthelper, OAuthTokenManager oauthtokenmanager, 
            CookieDataStore cookiedatastore, RenameDevice renamedevice)
    {
        mContext = servicewrappingcontext;
        mDeregisterAccount = deregisteraccount;
        mRegisterChildApplicationAction = registerchildapplicationaction;
        mRegistry = subauthenticatorregistry;
        mAmazonAccountManager = amazonaccountmanager;
        mRegistrarAuthenticator = accountregistrarauthenticator;
        mRegistrar = accountregistrar;
        mDataStorage = datastorage;
        mMultipleAccountLogic = multipleaccountslogic;
        mMultipleAccountPlugin = multipleaccountplugin;
        mCorPfmLogic = corpfmlogic;
        mAuthenticator = accountauthenticator;
        mDelegatedAccountHelper = delegatedaccounthelper;
        mOAuthTokenManager = oauthtokenmanager;
        mCookieDataStore = cookiedatastore;
        mRenameDevice = renamedevice;
    }

    private void addNeccesaryUserdata(Bundle bundle, Bundle bundle1)
    {
        bundle.putString("com.amazon.dcp.sso.property.account.UUID", UUID.randomUUID().toString());
        Iterator iterator = bundle1.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (s.startsWith("com.amazon.dcp.sso.property.account.extratokens"))
            {
                bundle.putString(s, bundle1.getString(s));
            }
        } while (true);
    }

    private void callbackDeregisterCommon(Callback callback, boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("booleanResult", flag);
        callback.onSuccess(bundle);
    }

    private void confirmCredentialInternal(Activity activity, String s, boolean flag, Bundle bundle, Callback callback, Tracer tracer)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        BundleUtils.sanitizeSerializableOptions(bundle);
        MAPLog.i(TAG, "Confirm Credential called with options: %s.", new Object[] {
            bundle.toString()
        });
        if (TextUtils.isEmpty(s))
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, "Cannot confirm credential given empty directedId."));
            return;
        }
        if (flag && !mAmazonAccountManager.doesAccountExist(s))
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.CUSTOMER_NOT_FOUND.value(), String.format("Customer %s is not registered.", new Object[] {
                s
            })));
            return;
        }
        bundle.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.CONFIRM_CREDENTIAL.toString());
        bundle.putString("directedid", s);
        s = signInOrCreateAccountWithWebView(bundle, callback, tracer);
        if (s != null && activity != null)
        {
            startIntentForActivity(activity, s, callback);
            return;
        }
        if (s != null)
        {
            AccountsCallbackHelpers.resultToSuccessOrError(callback, s);
            return;
        } else
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, "Could not find a sign in UI. This more than likely represents a bug."));
            return;
        }
    }

    private List getCookiesAndRemove(String s, Bundle bundle)
    {
        Object obj = bundle.getString("website_cookies_json_array");
        ArrayList arraylist = new ArrayList();
        try
        {
            obj = new JSONArray(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("String to JSONArray Conversion failed : ")).append(s.getMessage()).toString());
            return arraylist;
        }
        try
        {
            s = (new MAPCookieManager(mContext)).parseJSONArrayCookies(s, ((JSONArray) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, (new StringBuilder("Failed to parse the cookie JSONArray : ")).append(s.getMessage()).toString());
            s = arraylist;
        }
        bundle.remove("website_cookies_json_array");
        return s;
    }

    public static AccountManagerLogic getInstance(Context context)
    {
        com/amazon/identity/auth/accounts/AccountManagerLogic;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheOneAndTheOnly = new AccountManagerLogic(ServiceWrappingContext.create(context.getApplicationContext()));
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/accounts/AccountManagerLogic;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void handleIntent(Activity activity, Callback callback, Bundle bundle, String s)
    {
        if (bundle != null && activity != null)
        {
            startIntentForActivity(activity, bundle, callback);
            return;
        }
        if (bundle != null)
        {
            AccountsCallbackHelpers.resultToSuccessOrError(callback, bundle);
            return;
        } else
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UI_NOT_FOUND, s));
            return;
        }
    }

    private void onRegistrationError(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Callback callback, Bundle bundle)
    {
        AccountsCallbackHelpers.onError(callback, registrationerror.value(), null, bundle);
    }

    private Bundle registerWithMyAccount(Bundle bundle, Callback callback)
    {
        MAPLog.i(TAG, "Register with My Account");
        boolean flag = PlatformSettings.getInstance(mContext).getSettingBoolean("default.to.register.client", false);
        Intent intent = new Intent("com.amazon.dcp.sso.AddAccount");
        Iterator iterator = (new TrustedPackageManager(mContext)).queryIntentActivities(intent, 0).iterator();
        Object obj = null;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ActivityInfo activityinfo = ((ResolveInfo)iterator.next()).activityInfo;
            boolean flag1 = "com.amazon.registerclient".equals(activityinfo.packageName);
            if (!flag)
            {
                obj = activityinfo;
                if (!flag1)
                {
                    break;
                }
            }
            obj = activityinfo;
            if (!flag)
            {
                continue;
            }
            obj = activityinfo;
            if (!flag1)
            {
                continue;
            }
            obj = activityinfo;
            break;
        } while (true);
        if (obj == null)
        {
            obj = null;
        } else
        {
            intent.setComponent(new ComponentName(((ActivityInfo) (obj)).packageName, ((ActivityInfo) (obj)).name));
            obj = intent;
        }
        if (obj == null)
        {
            return null;
        } else
        {
            ((Intent) (obj)).putExtras(bundle);
            ((Intent) (obj)).putExtra("accountAuthenticatorResponse", AccountAuthenticatorResponseHelper.createCallbackToAccountAuthenticatorResponseAdapter(callback));
            ((Intent) (obj)).putExtra("com.amazon.dcp.sso.addAccountParameters.authTokenType", bundle.getString("com.amazon.dcp.sso.addAccountParameters.authTokenType"));
            ((Intent) (obj)).putExtra("com.amazon.dcp.sso.addAccountParameters.requiredFeatures", bundle.getStringArray("com.amazon.dcp.sso.addAccountParameters.requiredFeatures"));
            ((Intent) (obj)).putExtra("com.amazon.dcp.sso.addAccountParameters.options", bundle.getBundle("com.amazon.dcp.sso.addAccountParameters.options"));
            ((Intent) (obj)).putExtra("com.amazon.dcp.sso.addAccountParameters.caller", mContext.getPackageName());
            bundle = new Bundle();
            bundle.putParcelable("intent", ((android.os.Parcelable) (obj)));
            return bundle;
        }
    }

    private Bundle scheduleDeregister(final String directedId, Callback callback, final Tracer tracer)
    {
        MAPLog.i(TAG, "Deregister initiated");
        if (PlatformSettings.getInstance(mContext).getSettingBoolean("ignore.deregister", false))
        {
            MAPLog.i(TAG, "Ignoring deregister based on DCP settings");
            callbackDeregisterCommon(callback, false);
            return null;
        }
        if (!mAmazonAccountManager.doesAccountExist(directedId))
        {
            callbackDeregisterCommon(callback, true);
            return null;
        } else
        {
            ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new AccountAuthenticatorQueue.AccountAuthenticatorTask() {

                final AccountManagerLogic this$0;
                final String val$directedId;
                final Tracer val$tracer;

                public Bundle run(Callback callback1)
                {
                    return MAPLog.i(AccountManagerLogic.this, directedId, callback1, tracer);
                }

            
            {
                this$0 = AccountManagerLogic.this;
                directedId = s;
                tracer = tracer1;
                super();
            }
            }, callback, "DeregisterAccount");
            return null;
        }
    }

    private Bundle signInOrCreateAccountWithWebView(Bundle bundle, Callback callback, Tracer tracer)
    {
        Intent intent = IntentHelpers.getBestIntentForActivity(mContext, null, com/amazon/identity/auth/device/AuthPortalUIActivity.getName());
        if (tracer != null)
        {
            tracer.addToIntent(intent);
        }
        intent.putExtras(bundle);
        if (!bundle.containsKey("requestType"))
        {
            intent.putExtra("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
        }
        bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        intent.putExtra("callback", new RemoteCallbackWrapper(callback));
        bundle.putInt("result code", 100);
        return bundle;
    }

    private void startIntentForActivity(Activity activity, Bundle bundle, Callback callback)
    {
        Intent intent = (Intent)bundle.getParcelable("intent");
        bundle.remove("intent");
        if (intent == null)
        {
            MAPLog.e(TAG, "Failed to locate an activity containing the sign-in UI");
            AccountsCallbackHelpers.onAccountManagerError(callback, 6, "Failed to locate an activity containing the sign-in UI");
            return;
        }
        if (bundle.containsKey("result code"))
        {
            callback = Integer.valueOf(bundle.getInt("result code", 0));
        } else
        {
            callback = null;
        }
        bundle.remove("result code");
        if (callback != null)
        {
            activity.startActivityForResult(intent, callback.intValue());
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    private void updateAccountCredentials(String s, String s1, Bundle bundle)
    {
        if (bundle != null)
        {
            Object obj = new BackwardsCompatiableDataStorage(mContext, mDataStorage);
            String s3 = ((BackwardsCompatiableDataStorage) (obj)).getUserData(s, "com.amazon.dcp.sso.property.devicename");
            String s2 = ((BackwardsCompatiableDataStorage) (obj)).getUserData(s, "com.amazon.dcp.sso.property.deviceemail");
            if (s1 == null)
            {
                String s5;
                for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); ((BackwardsCompatiableDataStorage) (obj)).setUserData(s, s5, bundle.getString(s5)))
                {
                    s5 = (String)iterator.next();
                }

            } else
            {
                LocalAppDataAwareDataStorage localappdataawaredatastorage = new LocalAppDataAwareDataStorage(mContext, ((DataStorage) (obj)));
                String s6;
                for (Iterator iterator1 = bundle.keySet().iterator(); iterator1.hasNext(); localappdataawaredatastorage.setUserData(s, StorageKeyUtils.getKeyWithPackageNamespace(s1, s6), bundle.getString(s6)))
                {
                    s6 = (String)iterator1.next();
                }

            }
            bundle = ((BackwardsCompatiableDataStorage) (obj)).getUserData(s, "com.amazon.dcp.sso.property.devicename");
            obj = ((BackwardsCompatiableDataStorage) (obj)).getUserData(s, "com.amazon.dcp.sso.property.deviceemail");
            if (!TextUtils.equals(s3, bundle) && DeviceTypeHelpers.isPackageUsingCentralDeviceType(mContext, s1))
            {
                String s4 = TAG;
                UserProperties.storeDeviceName(mContext, s, bundle);
            }
            if (!TextUtils.equals(s2, ((CharSequence) (obj))) && DeviceTypeHelpers.arePackagesUsingTheSameDeviceType(mContext, s1, "com.amazon.kindle"))
            {
                s1 = TAG;
                UserProperties.sendDeviceEmailChangedNotification(mContext, s, ((String) (obj)));
                return;
            }
        }
    }

    public void authenticateAccount(final Bundle authData, final Callback callback, final Tracer tracer)
    {
        if (authData == null || !authData.containsKey("com.amazon.dcp.sso.property.account.acctId") && !authData.containsKey("authAccount") || !authData.containsKey("password"))
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, "A login/directedId and password are required to authenticate/confirmCredential."));
            return;
        }
        if (authData.containsKey("authAccount") && authData.containsKey("com.amazon.dcp.sso.property.account.acctId"))
        {
            callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST, "Cannot pass in both login and directedId to authenticateAccount API."));
            return;
        } else
        {
            ThreadUtils.submitToBackgroundThread(new Runnable() {

                final AccountManagerLogic this$0;
                final Bundle val$authData;
                final Callback val$callback;
                final Tracer val$tracer;

                public void run()
                {
                    mAuthenticator.authenticateAccount(authData, callback, tracer);
                }

            
            {
                this$0 = AccountManagerLogic.this;
                authData = bundle;
                callback = callback1;
                tracer = tracer1;
                super();
            }
            });
            return;
        }
    }

    public void authenticateAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        Object obj;
        MAPArgContracts.throwIfNull(signinoption, "option");
        obj = TAG;
        (new StringBuilder("authenticateAccountWithUI SigninOption:")).append(signinoption.name()).toString();
        static class _cls9
        {

            static final int $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[];

            static 
            {
                $SwitchMap$com$amazon$identity$auth$device$api$SigninOption = new int[SigninOption.values().length];
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewSignin.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewCreateAccount.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.MyAccountSignin.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$identity$auth$device$api$SigninOption[SigninOption.WebviewConfirmCredentials.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        Object obj1;
        if (bundle != null)
        {
            obj = bundle;
        } else
        {
            obj = new Bundle();
        }
        BundleUtils.sanitizeSerializableOptions(((Bundle) (obj)));
        obj1 = null;
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.SigninOption[signinoption.ordinal()];
        JVM INSTR tableswitch 1 4: default 88
    //                   1 139
    //                   2 88
    //                   3 88
    //                   4 167;
           goto _L1 _L2 _L1 _L1 _L3
_L1:
        AccountsCallbackHelpers.onAccountManagerError(callback, 7, String.format("Signin Options %s is not supported", new Object[] {
            signinoption.name()
        }));
        signinoption = obj1;
_L4:
        handleIntent(activity, callback, signinoption, "Could not find the sign in UI. This more than likely represents a bug.");
        return;
_L2:
        ((Bundle) (obj)).putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.AUTHENTICATE.toString());
        signinoption = signInOrCreateAccountWithWebView(((Bundle) (obj)), callback, tracer);
        if (true) goto _L4; else goto _L3
_L3:
        confirmCredentialInternal(activity, bundle.getString("com.amazon.dcp.sso.property.account.acctId"), false, bundle, callback, tracer);
        return;
    }

    public void confirmCredential(Activity activity, String s, Bundle bundle, Callback callback, Tracer tracer)
    {
        confirmCredentialInternal(activity, s, true, bundle, callback, tracer);
    }

    public MAPFuture deregisterAccount(String s, Callback callback, Tracer tracer)
    {
        MAPLog.i(TAG, "deregisterAccount logic called");
        callback = new CallbackFuture(callback);
        scheduleDeregister(s, callback, tracer);
        return callback;
    }

    public MAPFuture deregisterDevice(Callback callback, Tracer tracer)
    {
        MAPLog.i(TAG, "deregisterDevice logic called");
        callback = new CallbackFuture(callback);
        Object obj = getAccounts();
        for (Iterator iterator = ((Set) (obj)).iterator(); iterator.hasNext();)
        {
            String s1 = (String)iterator.next();
            if (mMultipleAccountPlugin.deregisterAllAccountsOnAccountRemoval(s1))
            {
                scheduleDeregister(s1, callback, tracer);
                return callback;
            }
        }

        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            String s = (String)((Iterator) (obj)).next();
            try
            {
                CallbackFuture callbackfuture = new CallbackFuture();
                scheduleDeregister(s, callbackfuture, tracer);
                callbackfuture.get();
            }
            catch (MAPCallbackErrorException mapcallbackerrorexception)
            {
                MAPLog.e(TAG, (new StringBuilder("MAP Error calling deregister. Error: ")).append(BundleUtils.toString(mapcallbackerrorexception.getErrorBundle())).toString(), mapcallbackerrorexception);
            }
            catch (InterruptedException interruptedexception)
            {
                MAPLog.e(TAG, "InterruptedException calling deregister.", interruptedexception);
            }
            catch (ExecutionException executionexception)
            {
                MAPLog.e(TAG, "ExecutionException calling deregister", executionexception);
            }
        }

        callbackDeregisterCommon(callback, true);
        return callback;
    }

    public String getAccount(String s)
    {
        int i = AndroidUser.getCallingUserId();
        return mMultipleAccountLogic.getAccountForMapping(mMultipleAccountPlugin.getAccountHierarchy(s, i));
    }

    public Set getAccounts()
    {
        return mAmazonAccountManager.getNonDeregisteringAmazonAccounts();
    }

    public String getPrimaryAccount()
    {
        int i = AndroidUser.getCallingUserId();
        return mMultipleAccountLogic.getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
            com.amazon.identity.auth.device.api.MultipleAccountManager.PrimaryUserMappingType.createPrimaryMappingForProfile(i)
        });
    }

    public boolean isAccountRegistered(String s)
    {
        return getAccounts().contains(s);
    }

    public boolean isDeviceRegistered()
    {
        return mAmazonAccountManager.hasDevicePrimaryAmazonAccount();
    }

    public void registerAccount(final RegistrationType regType, final Bundle regData, Callback callback, final Tracer tracer)
    {
        MAPArgContracts.throwIfNull(regType, "RegistrationType");
        MAPLog.i(TAG, (new StringBuilder("registerAccount:")).append(regType.getName()).toString());
        if (regData == null)
        {
            regData = new Bundle();
        }
        ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new AccountAuthenticatorQueue.AccountAuthenticatorTask() {

            final AccountManagerLogic this$0;
            final Bundle val$regData;
            final RegistrationType val$regType;
            final Tracer val$tracer;

            public Bundle run(Callback callback1)
            {
                return MAPLog.i(AccountManagerLogic.this, regType, regData, callback1, tracer);
            }

            
            {
                this$0 = AccountManagerLogic.this;
                regType = registrationtype;
                regData = bundle;
                tracer = tracer1;
                super();
            }
        }, callback, "AddAccount");
    }

    public void registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        Object obj;
        MAPLog.i(TAG, (new StringBuilder("registerAccountWithUI SigninOption:")).append(signinoption.name()).toString());
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        BundleUtils.sanitizeSerializableOptions(bundle);
        if (mAmazonAccountManager.hasDevicePrimaryAmazonAccount() && !bundle.containsKey("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"))
        {
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, mAmazonAccountManager.getDevicePrimaryAmazonAccount());
            return;
        }
        obj = null;
        _cls9..SwitchMap.com.amazon.identity.auth.device.api.SigninOption[signinoption.ordinal()];
        JVM INSTR tableswitch 1 3: default 116
    //                   1 155
    //                   2 234
    //                   3 260;
           goto _L1 _L2 _L3 _L4
_L1:
        AccountsCallbackHelpers.onAccountManagerError(callback, 7, String.format("Signin Options %s is not supported", new Object[] {
            signinoption.name()
        }));
        signinoption = obj;
_L6:
        handleIntent(activity, callback, signinoption, "Could not find the sign in UI. If the option passed in was MyAccount, you are on a 3rd party device. Otherwise, this more than likely represents a bug.");
        return;
_L2:
        if (bundle.containsKey("com.amazon.identity.auth.ChallengeException"))
        {
            bundle.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
            signinoption = signInOrCreateAccountWithWebView(bundle, callback, tracer);
        } else
        {
            Bundle bundle1 = registerWithMyAccount(bundle, callback);
            signinoption = bundle1;
            if (bundle1 == null)
            {
                bundle.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
                signinoption = signInOrCreateAccountWithWebView(bundle, callback, tracer);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        bundle.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER.toString());
        signinoption = signInOrCreateAccountWithWebView(bundle, callback, tracer);
        continue; /* Loop/switch isn't completed */
_L4:
        signinoption = registerWithMyAccount(bundle, callback);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MAPFuture registerChildApplication(String s, String s1, Bundle bundle, Callback callback, Tracer tracer)
    {
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(s1, "deviceType");
        MAPLog.i(TAG, (new StringBuilder("registerChildApplication device type:")).append(s1).toString());
        callback = new CallbackFuture(callback);
        try
        {
            mRegisterChildApplicationAction.registerChildApplication(s, s1, bundle, callback, tracer);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AccountsCallbackHelpers.onError(callback, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), String.format("%s is not a child application device type", new Object[] {
                s1
            }), null);
            return callback;
        }
        return callback;
    }

    public MAPFuture renameDevice(final String directedId, final String newDeviceName, final Bundle options, Callback callback, final Tracer tracer)
    {
        MAPLog.i(TAG, "renameDevice logic called");
        callback = new CallbackFuture(callback);
        ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new AccountAuthenticatorQueue.AccountAuthenticatorTask() {

            final AccountManagerLogic this$0;
            final String val$directedId;
            final String val$newDeviceName;
            final Bundle val$options;
            final Tracer val$tracer;

            public Bundle run(Callback callback1)
            {
                mRenameDevice.renameDevice(directedId, newDeviceName, options, callback1, tracer);
                return null;
            }

            
            {
                this$0 = AccountManagerLogic.this;
                directedId = s;
                newDeviceName = s1;
                options = bundle;
                tracer = tracer1;
                super();
            }
        }, callback, "RenameDevice");
        return callback;
    }

    public MAPFuture updateAccountWithKey(final String directedId, final KeyInfo key, Bundle bundle, final Callback callbackFuture, Tracer tracer)
    {
        callbackFuture = new CallbackFuture(callbackFuture);
        if (!validateAccount(directedId, callbackFuture))
        {
            return callbackFuture;
        }
        if (!CustomerAttributeStoreKeyUtils.canUpdateCredentials(key))
        {
            AccountsCallbackHelpers.onError(callbackFuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("key %s is not valid", new Object[] {
                key.getKey()
            }), null);
            return callbackFuture;
        }
        AccountRegistrar.Listener listener = new AccountRegistrar.Listener() {

            final AccountManagerLogic this$0;
            final CallbackFuture val$callbackFuture;
            final String val$directedId;
            final KeyInfo val$key;

            public void accountAlreadyExists(String s)
            {
                AccountsCallbackHelpers.onAccountAlreadyExistsError(callbackFuture, s);
            }

            public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle1)
            {
                registrationerror = AccountsCallbackHelpers.getErrorBundle(registrationerror.value(), null);
                callbackFuture.onError(registrationerror);
            }

            public void success(String s, String s1, Bundle bundle1)
            {
                updateAccountCredentials(directedId, key.getPackageName(), bundle1);
                s = new Bundle();
                BackwardsCompatiabilityHelper.addAccountManagerSuccessInformation(mContext, directedId, s);
                s.putString("authtoken", mDataStorage.getUserData(directedId, key.getKey()));
                callbackFuture.onSuccess(s);
            }

            
            {
                this$0 = AccountManagerLogic.this;
                directedId = s;
                key = keyinfo;
                callbackFuture = callbackfuture;
                super();
            }
        };
        AccountRegistrar accountregistrar = mRegistrar;
        key = key.getPackageName();
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        accountregistrar.updateCredentials(listener, directedId, key, bundle, mRegistrarAuthenticator, tracer);
        return callbackFuture;
    }

    protected boolean validateAccount(String s, AccountAuthenticatorResponseWrapper accountauthenticatorresponsewrapper)
    {
        if (s == null || !mAmazonAccountManager.doesAccountExist(s))
        {
            accountauthenticatorresponsewrapper.onError(7, "The provided account does not exist");
            return false;
        } else
        {
            return true;
        }
    }

    protected boolean validateAccount(String s, Callback callback)
    {
        if (s == null || !mAmazonAccountManager.doesAccountExist(s))
        {
            AccountsCallbackHelpers.onError(callback, 7, "The provided account does not exist", null);
            return false;
        } else
        {
            return true;
        }
    }






/*
    static void access$1100(AccountManagerLogic accountmanagerlogic, String s, String s1, String s2)
    {
        if (TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, (new StringBuilder("The central device email is missing. Please check that the capability EMAIL_ALIAS_SUPPORTED is defined for the following device type in DMS: ")).append(s2).toString());
            MetricsHelper.increasePeriodicCounter("CentralDeviceEmailIsMissing", new String[] {
                s2
            });
        }
        UserProperties.sendDeviceEmailChangedNotification(accountmanagerlogic.mContext, s1, s);
        return;
    }

*/


/*
    static Bundle access$1200(AccountManagerLogic accountmanagerlogic, final String directedId, final Callback callback, Tracer tracer)
    {
        MAPLog.i(TAG, "Starting Deregistration");
        final Account backCompatAccount = BackwardsCompatiabilityHelper.getAccountWithDirectedId(accountmanagerlogic.mContext, directedId);
        final boolean isPrimaryAccount = accountmanagerlogic.mMultipleAccountLogic.isAPrimaryAccount(directedId);
        final Set profilesForRemovedDirectedId = accountmanagerlogic.mMultipleAccountLogic.getListOfProfilesWhereTheAccountIsPrimary(accountmanagerlogic.mContext, directedId);
        accountmanagerlogic.mDeregisterAccount.startDeregister(accountmanagerlogic.mRegistry.getSubAuthenticators(), accountmanagerlogic. new _cls7(), directedId, tracer);
        return null;
    }

*/






/*
    static Bundle access$400(AccountManagerLogic accountmanagerlogic, final RegistrationType regType, final Bundle regData, final Callback callback, Tracer tracer)
    {
        MAPLog.i(TAG, (new StringBuilder("Starting Registration: ")).append(regType).toString());
        _cls4 _lcls4 = accountmanagerlogic. new _cls4();
        String s = accountmanagerlogic.mAmazonAccountManager.getDevicePrimaryAmazonAccount();
        if (s != null && regType == RegistrationType.WITH_DEVICE_SECRET)
        {
            MAPLog.i(TAG, "Already registered. Returning success for register via device secret");
            regType = new Bundle();
            BackwardsCompatiabilityHelper.addAccountManagerSuccessInformation(accountmanagerlogic.mContext, s, regType);
            callback.onSuccess(regType);
            return null;
        } else
        {
            accountmanagerlogic.mRegistrar.register(_lcls4, regType, regData, accountmanagerlogic.mRegistrarAuthenticator, tracer);
            return null;
        }
    }

*/


/*
    static void access$500(AccountManagerLogic accountmanagerlogic, RegistrationType registrationtype, Bundle bundle, Callback callback, String s, String s1, final Bundle userData)
    {
        if (userData == null)
        {
            MAPLog.e(TAG, "No userdata returned. The account cannot be created.");
            AccountsCallbackHelpers.onAccountManagerError(callback, 7, "No userdata given. Cannot construct an account");
            return;
        }
        Bundle bundle1 = new Bundle();
        final String directedId = userData.getString("com.amazon.dcp.sso.property.account.acctId");
        if (accountmanagerlogic.mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(directedId))
        {
            accountmanagerlogic.updateAccountCredentials(directedId, null, userData);
            MAPLog.w(TAG, "An account has been registered multiple times!");
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, directedId);
            return;
        }
        if (accountmanagerlogic.mAmazonAccountManager.hasDevicePrimaryAmazonAccount() && bundle.containsKey("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"))
        {
            userData.putString("com.amazon.dcp.sso.property.secondary", "true");
        }
        if (accountmanagerlogic.mAmazonAccountManager.getSessionUsers().isEmpty())
        {
            userData.putString("com.amazon.dcp.sso.property.sessionuser", "true");
        }
        accountmanagerlogic.mMultipleAccountPlugin.addDataOnAddAccount(directedId, bundle, userData);
        BackwardsCompatiableDataStorage backwardscompatiabledatastorage = new BackwardsCompatiableDataStorage(accountmanagerlogic.mContext, accountmanagerlogic.mDataStorage);
        accountmanagerlogic.addNeccesaryUserdata(userData, bundle);
        if (registrationtype == RegistrationType.REGISTER_DELEGATED_ACCOUNT)
        {
            userData.putString("com.amazon.dcp.sso.property.account.delegateeaccount", bundle.getString("com.amazon.dcp.sso.property.account.delegateeaccount"));
            registrationtype = accountmanagerlogic.mDelegatedAccountHelper.getDelegationDomainFromAPIBundle(bundle);
            if (!TextUtils.isEmpty(registrationtype))
            {
                userData.putString("com.amazon.dcp.sso.property.account.delegationDomain", registrationtype);
            }
        }
        s = null;
        registrationtype = null;
        Object obj = userData.getString("com.amazon.dcp.sso.property.account.customer_region");
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = AmazonDomainHelper.getAuthPortalDomainBasedOnCustomerRegion(((String) (obj)));
            registrationtype = "customer region (home region)";
        }
        obj = registrationtype;
        final String deviceEmail = s;
        if (TextUtils.isEmpty(s))
        {
            String s2 = userData.getString("com.amazon.dcp.sso.token.device.accountpool");
            obj = registrationtype;
            deviceEmail = s;
            if (!TextUtils.isEmpty(s2))
            {
                deviceEmail = AmazonDomainHelper.getAuthPortalDomainBasedOnAccountPool(s2);
                obj = "account pool";
            }
        }
        if (!TextUtils.isEmpty(deviceEmail))
        {
            registrationtype = AmazonDomainHelper.getCompleteAuthPortalDomain(deviceEmail);
            MAPLog.i(TAG, String.format("Marking the amazon domain for added account: %s. It's generated base on %s.", new Object[] {
                registrationtype, obj
            }));
            userData.putString("authDomain", registrationtype);
        }
        obj = BackwardsCompatiabilityHelper.getUniqueAccountName(accountmanagerlogic.mDataStorage, s1);
        registrationtype = userData.getString("com.amazon.dcp.sso.property.account.cor");
        s = userData.getString("com.amazon.dcp.sso.property.account.sourceofcor");
        s1 = userData.getString("com.amazon.dcp.sso.property.account.pfm");
        userData.remove("com.amazon.dcp.sso.property.account.cor");
        userData.remove("com.amazon.dcp.sso.property.account.sourceofcor");
        userData.remove("com.amazon.dcp.sso.property.account.pfm");
        final String deviceType;
        Object obj1;
        Bundle bundle2;
        if (!CorPfmLogic.isValidCorPfmFromDCAS(registrationtype, s, s1))
        {
            MAPLog.i(TAG, "Registering account did not return cor/pfm.");
            registrationtype = null;
        } else
        {
            MAPLog.i(TAG, String.format("Using COR/SourceOfCor/PFM/ returned when registering the account: %s, %s, %s", new Object[] {
                registrationtype, s, s1
            }));
            registrationtype = new CORPFMResponse(registrationtype, s1, s);
        }
        s1 = CredentialMapSerializer.toMap(userData.getString("com.amazon.dcp.sso.token.device.credentialsmap"));
        userData.remove("com.amazon.dcp.sso.token.device.credentialsmap");
        s = s1;
        if (s1 == null)
        {
            s = Collections.emptyMap();
        }
        obj1 = accountmanagerlogic.getCookiesAndRemove(directedId, userData);
        s1 = userData.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        bundle2 = new Bundle();
        if (!TextUtils.isEmpty(s1))
        {
            bundle2.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token", s1);
            bundle2.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at", userData.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"));
            bundle2.putString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token", userData.getString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
        }
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at");
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.refresh_token");
        deviceEmail = userData.getString("com.amazon.dcp.sso.property.deviceemail");
        deviceType = userData.getString("com.amazon.dcp.sso.token.devicedevicetype");
        if (!bundle2.isEmpty())
        {
            bundle = AmazonDomainHelper.getCompleteCookieDomain(AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(bundle));
            s1 = new HashMap();
            s1.putAll(accountmanagerlogic.mOAuthTokenManager.getTokenMapFromRegistrationData(bundle2));
            MAPCookieManager.updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(((List) (obj1)), s1);
            s1.putAll(accountmanagerlogic.mCookieDataStore.getCookieTokenMapOrWriteToDataStoreFromRegistrationData(directedId, ((List) (obj1)), bundle));
        } else
        {
            s1 = null;
            bundle = null;
        }
        obj1 = BundleUtils.toStringStringMap(userData);
        accountmanagerlogic.mCorPfmLogic.setInitialCORPFM(registrationtype, ((Map) (obj1)));
        registrationtype = new AccountTransaction(directedId, ((Map) (obj1)), s1);
        for (s = s.entrySet().iterator(); s.hasNext(); DMSSubAuthenticator.populateChildApplicationTokensWithoutRegister(accountmanagerlogic.mContext, registrationtype, (String)s1.getKey(), (Map)s1.getValue()))
        {
            s1 = (java.util.Map.Entry)s.next();
        }

        if (!backwardscompatiabledatastorage.addAccount(((String) (obj)), registrationtype, accountmanagerlogic. new _cls5()))
        {
            accountmanagerlogic.onRegistrationError(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS, callback, null);
            return;
        }
        accountmanagerlogic.mMultipleAccountLogic.invalidateCache();
        BackwardsCompatiabilityHelper.addAccountManagerSuccessInformation(((String) (obj)), directedId, bundle1);
        if (bundle != null && !CollectionUtils.isEmpty(accountmanagerlogic.mCookieDataStore.getNonAuthCookies(bundle)))
        {
            accountmanagerlogic.mCookieDataStore.setNonAuthCookies(bundle, null);
        }
        MAPLog.i(TAG, "MAP finished adding account locally and will do the other necessary work asynchronously in the data propogation callback");
        callback.onSuccess(bundle1);
        return;
    }

*/




}
