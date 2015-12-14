// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.IAccountAuthenticatorResponse;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.amazon.identity.auth.attributes.CORPFMResponse;
import com.amazon.identity.auth.attributes.CorPfmLogic;
import com.amazon.identity.auth.attributes.CustomerAttributeStoreKeyUtils;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.AuthPortalUIActivity;
import com.amazon.identity.auth.device.DeviceDataStoreCache;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.api.SigninOption;
import com.amazon.identity.auth.device.api.TokenManagement;
import com.amazon.identity.auth.device.attribute.PandaUserProfileRequest;
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
import com.amazon.identity.platform.util.PlatformUtils;
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
//            AccountStateBroadcasts

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
            AccountManagerLogic accountmanagerlogic = AccountManagerLogic.this;
            AccountsCallbackHelpers.onError(registrationerror, callback, bundle);
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
                    AccountManagerLogic accountmanagerlogic = _fld0;
                    RegistrationType registrationtype = regType;
                    Bundle bundle = regData;
                    Callback callback1 = callback;
                    String s = accountType;
                    AccountManagerLogic.access$500$70268062(accountmanagerlogic, registrationtype, bundle, callback1, accountName, extras);
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
        final Bundle val$regData;
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
            boolean flag = regData.getBoolean("com.amazon.identity.auth.device.accountManager.newaccount", false);
            ServiceWrappingContext servicewrappingcontext = mContext;
            MultipleAccountsLogic multipleaccountslogic = mMultipleAccountLogic;
            MultipleAccountPlugin multipleaccountplugin = mMultipleAccountPlugin;
            ThreadUtils.submitToBackgroundThread(new AccountStateBroadcasts._cls1(servicewrappingcontext, directedId, multipleaccountslogic, multipleaccountplugin, flag));
        }

        _cls5()
        {
            this$0 = AccountManagerLogic.this;
            directedId = s;
            userData = bundle;
            deviceEmail = s1;
            deviceType = s2;
            regData = bundle1;
            super();
        }
    }


    public static final AccountAuthenticatorQueue ACCOUNT_AUTHENTICATOR_QUEUE = new AccountAuthenticatorQueue();
    private static final String TAG = com/amazon/identity/auth/accounts/AccountManagerLogic.getName();
    private static AccountManagerLogic sTheOneAndTheOnly;
    private final AmazonAccountManager mAmazonAccountManager;
    private final AccountAuthenticator mAuthenticator;
    private final ServiceWrappingContext mContext;
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
        MAPLog.formattedInfo(TAG, "Confirm Credential called with options: %s.", new Object[] {
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

    private String[] getAuthCookie$7dacfd92(String s, String s1, Callback callback)
    {
        TokenManagement tokenmanagement;
        Bundle bundle;
        tokenmanagement = new TokenManagement(mContext);
        bundle = new Bundle();
        bundle.putBoolean("com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh", true);
        bundle.putString("domain", s1);
        s1 = ((Bundle)tokenmanagement.getCookies(s, s1, bundle, null).get()).getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        s = s1;
        if (s1.length != 0)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "Cookie force refresh fail before lauching auth portal ui for fix up page"));
        s = null;
        return s;
        s;
        s = s.getErrorBundle();
        if (s != null)
        {
            MAPLog.e(TAG, (new StringBuilder("Cannot refresh the cookie to start auth portal attributes fix up flow. Error Code:")).append(s.getInt("com.amazon.dcp.sso.ErrorCode")).append(" Error message:").append(s.getString("com.amazon.dcp.sso.ErrorMessage")).toString());
        }
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "Cookie force refresh fail before lauching auth portal ui for fix up page"));
_L2:
        return null;
        s;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "Cookie force refresh fail before lauching auth portal ui for fix up page"));
        continue; /* Loop/switch isn't completed */
        s;
        callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "Cookie force refresh fail before lauching auth portal ui for fix up page"));
        if (true) goto _L2; else goto _L1
_L1:
    }

    private List getCookiesAndRemove(String s, Bundle bundle)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = bundle.getString("website_cookies_json_array");
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return arraylist;
        }
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

    private Bundle registerWithMyAccount(Bundle bundle, Callback callback)
    {
        MAPLog.i(TAG, "Register with My Account");
        boolean flag = PlatformSettings.getInstance(mContext).getSettingBoolean("default.to.register.client", false);
        Intent intent = new Intent("com.amazon.dcp.sso.AddAccount");
        Iterator iterator = (new TrustedPackageManager(mContext)).queryIntentActivities$46e5b6ea(intent).iterator();
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
            callback = new AccountAuthenticatorResponseHelper._cls1(callback);
            Parcel parcel = Parcel.obtain();
            parcel.writeStrongBinder(callback.asBinder());
            parcel.setDataPosition(0);
            ((Intent) (obj)).putExtra("accountAuthenticatorResponse", new AccountAuthenticatorResponse(parcel));
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
        Intent intent = IntentHelpers.getBestIntentForActivity$49025054(mContext, com/amazon/identity/auth/device/AuthPortalUIActivity.getName());
        if (tracer != null)
        {
            tracer.addToIntent(intent);
        }
        intent.putExtras(bundle);
        if (!bundle.containsKey("requestType"))
        {
            intent.putExtra("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
        }
        intent.setFlags(0x20000);
        bundle = new Bundle();
        bundle.putParcelable("intent", intent);
        intent.putExtra("callback", new RemoteCallbackWrapper(callback));
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
                AccountTransaction accounttransaction = new AccountTransaction(s, null, null);
                String s5;
                for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); accounttransaction.setUserData(s5, bundle.getString(s5)))
                {
                    s5 = (String)iterator.next();
                }

                ((BackwardsCompatiableDataStorage) (obj)).setData(accounttransaction);
            } else
            {
                LocalAppDataAwareDataStorage localappdataawaredatastorage = new LocalAppDataAwareDataStorage(mContext, ((DataStorage) (obj)));
                AccountTransaction accounttransaction1 = new AccountTransaction(s, null, null);
                String s6;
                for (Iterator iterator1 = bundle.keySet().iterator(); iterator1.hasNext(); accounttransaction1.setUserData(StorageKeyUtils.getKeyWithPackageNamespace(s1, s6), bundle.getString(s6)))
                {
                    s6 = (String)iterator1.next();
                }

                localappdataawaredatastorage.setData(accounttransaction1);
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
        Object obj1;
        MAPArgContracts.throwIfNull(signinoption, "option");
        obj = TAG;
        (new StringBuilder("authenticateAccountWithUI SigninOption:")).append(signinoption.name()).toString();
        if (bundle != null)
        {
            obj = bundle;
        } else
        {
            obj = new Bundle();
        }
        BundleUtils.sanitizeSerializableOptions(((Bundle) (obj)));
        if (((Bundle) (obj)).getBoolean("set_cookie_for_authenticate_account_with_ui"))
        {
            String s = bundle.getString("com.amazon.identity.ap.domain");
            String as[] = getAuthCookie$7dacfd92(bundle.getString("com.amazon.dcp.sso.property.account.acctId"), s, callback);
            if (as == null)
            {
                return;
            }
            ((Bundle) (obj)).putStringArray("InjectCookiesToAuthPortalUIActivity", as);
        }
        obj1 = null;
        static class _cls11
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

        _cls11..SwitchMap.com.amazon.identity.auth.device.api.SigninOption[signinoption.ordinal()];
        JVM INSTR tableswitch 1 4: default 152
    //                   1 191
    //                   2 152
    //                   3 152
    //                   4 219;
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

    protected void bootstrapMAPWithADPToken(final Bundle regData, final Callback callback, final Tracer tracer)
    {
        if (!PlatformUtils.isIsolatedApplication(mContext))
        {
            MAPLog.e(TAG, "BootstrapWithADPToken API is only supported for isolated applications for now.");
            AccountsCallbackHelpers.onError(callback, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "BootstrapWithADPToken API is only supported for isolated applications for now.", null);
            return;
        }
        if (!getAccounts().isEmpty())
        {
            MAPLog.e(TAG, "Registered account found on device. bootstrap API works only on unregistered devices");
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, mAmazonAccountManager.getDevicePrimaryAmazonAccount());
            return;
        } else
        {
            ACCOUNT_AUTHENTICATOR_QUEUE.addAccountAuthenticatorTask(new AccountAuthenticatorQueue.AccountAuthenticatorTask() {

                final AccountManagerLogic this$0;
                final Callback val$callback;
                final Bundle val$regData;
                final Tracer val$tracer;

                public Bundle run(Callback callback1)
                {
                    if (!getAccounts().isEmpty())
                    {
                        MAPLog.e(AccountManagerLogic.TAG, "Registered account found on device. bootstrap API works only on unregistered devices");
                        AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, mAmazonAccountManager.getDevicePrimaryAmazonAccount());
                        return null;
                    } else
                    {
                        return MAPLog.i(AccountManagerLogic.this, RegistrationType.FROM_ADP_TOKEN, regData, callback1. new Callback() {

                            final _cls9 this$1;
                            final Callback val$innerCallback;

                            public void onError(Bundle bundle)
                            {
                                innerCallback.onError(bundle);
                            }

                            public void onSuccess(Bundle bundle)
                            {
                                mDataStorage.setDeviceData("dcp.third.party.device.state", "serial.number", regData.getString("Device Serial Number"));
                                DeviceDataStoreCache.getInstance().invalidateCache();
                                innerCallback.onSuccess(bundle);
                            }

            
            {
                this$1 = final__pcls9;
                innerCallback = Callback.this;
                super();
            }
                        }, tracer);
                    }
                }

            
            {
                this$0 = AccountManagerLogic.this;
                callback = callback1;
                regData = bundle;
                tracer = tracer1;
                super();
            }
            }, callback, "BootstrapMAPWithADPToken");
            return;
        }
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

    public void ensureAccountState(final Activity activity, final String directedId, final Bundle options, final Callback callback, final Tracer tracer)
    {
        ThreadUtils.runOffMainThread(new Runnable() {

            final AccountManagerLogic this$0;
            final Activity val$activity;
            final Callback val$callback;
            final String val$directedId;
            final Bundle val$options;
            final Tracer val$tracer;

            public void run()
            {
                Object obj1 = options.getString("com.amazon.identity.ap.domain");
                Object obj = options.getStringArrayList("EnsureAccountStateAttributes");
                Object obj2 = new TokenManagement(mContext);
                try
                {
                    obj2 = (Bundle)((TokenManagement) (obj2)).getToken(directedId, "com.amazon.dcp.sso.token.oauth.amazon.access_token", null, null).get();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MAPLog.e(AccountManagerLogic.TAG, "Cannot get access token");
                    callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "MAP cannot get access token for ensuring the account state"));
                    return;
                }
                obj1 = (new PandaUserProfileRequest(((Bundle) (obj2)).getString("value_key"), ((String) (obj1)), tracer)).getAccountMissingProfileAttributes(((List) (obj)));
                if (obj1 == null)
                {
                    MAPLog.e(AccountManagerLogic.TAG, "Cannot fetch user profile from Panda");
                    callback.onError(TokenCallbackHelpers.getErrorBundle(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.INTERNAL_ERROR.value(), "MAP cannot get user profile from Panda"));
                    return;
                }
                if (((ArrayList) (obj1)).isEmpty())
                {
                    obj1 = AccountManagerLogic.this;
                    Bundle bundle = new Bundle();
                    return;
                } else
                {
                    options.putStringArrayList("AccountMissingAttributes", ((ArrayList) (obj1)));
                    options.putBoolean("set_cookie_for_authenticate_account_with_ui", true);
                    options.putString("com.amazon.dcp.sso.property.account.acctId", directedId);
                    options.putBoolean("isAccountStateFixUpFlow", true);
                    authenticateAccountWithUI(activity, SigninOption.WebviewSignin, options, callback, tracer);
                    return;
                }
            }

            
            {
                this$0 = AccountManagerLogic.this;
                options = bundle;
                directedId = s;
                callback = callback1;
                tracer = tracer1;
                activity = activity1;
                super();
            }
        });
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
        if (regType == RegistrationType.FROM_ADP_TOKEN)
        {
            bootstrapMAPWithADPToken(regData, callback, tracer);
            return;
        } else
        {
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
            return;
        }
    }

    public void registerAccountWithUI(Activity activity, SigninOption signinoption, Bundle bundle, Callback callback, Tracer tracer)
    {
        Bundle bundle1;
        Object obj;
        MAPLog.i(TAG, (new StringBuilder("registerAccountWithUI SigninOption:")).append(signinoption.name()).toString());
        if (bundle != null)
        {
            bundle1 = bundle;
        } else
        {
            bundle1 = new Bundle();
        }
        BundleUtils.sanitizeSerializableOptions(bundle1);
        if (mAmazonAccountManager.hasDevicePrimaryAmazonAccount() && !bundle1.getBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"))
        {
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, mAmazonAccountManager.getDevicePrimaryAmazonAccount());
            return;
        }
        obj = null;
        bundle = null;
        _cls11..SwitchMap.com.amazon.identity.auth.device.api.SigninOption[signinoption.ordinal()];
        JVM INSTR tableswitch 1 3: default 124
    //                   1 162
    //                   2 270
    //                   3 298;
           goto _L1 _L2 _L3 _L4
_L1:
        AccountsCallbackHelpers.onAccountManagerError(callback, 7, String.format("Signin Options %s is not supported", new Object[] {
            signinoption.name()
        }));
        signinoption = bundle;
_L6:
        handleIntent(activity, callback, signinoption, "Could not find the sign in UI. If the option passed in was MyAccount, you are on a 3rd party device. Otherwise, this more than likely represents a bug.");
        return;
_L2:
        if (bundle1.containsKey("com.amazon.identity.auth.ChallengeException"))
        {
            bundle1.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
            signinoption = signInOrCreateAccountWithWebView(bundle1, callback, tracer);
        } else
        {
            bundle = obj;
            if (!PlatformUtils.hasGroverVersion3orLater(mContext))
            {
                bundle = obj;
                if (!PlatformUtils.hasCanary(mContext))
                {
                    bundle = registerWithMyAccount(bundle1, callback);
                }
            }
            signinoption = bundle;
            if (bundle == null)
            {
                bundle1.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.SIGN_IN.toString());
                signinoption = signInOrCreateAccountWithWebView(bundle1, callback, tracer);
            }
        }
        continue; /* Loop/switch isn't completed */
_L3:
        bundle1.putString("requestType", com.amazon.identity.auth.device.endpoint.OpenIdRequest.REQUEST_TYPE.REGISTER.toString());
        signinoption = signInOrCreateAccountWithWebView(bundle1, callback, tracer);
        continue; /* Loop/switch isn't completed */
_L4:
        signinoption = registerWithMyAccount(bundle1, callback);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public MAPFuture registerChildApplication$3b8086d2(String s, String s1, Bundle bundle, Tracer tracer)
    {
        MAPArgContracts.throwIfNull(s, "directedId");
        MAPArgContracts.throwIfNull(s1, "deviceType");
        MAPLog.i(TAG, (new StringBuilder("registerChildApplication device type:")).append(s1).toString());
        CallbackFuture callbackfuture = new CallbackFuture(null);
        try
        {
            mRegisterChildApplicationAction.registerChildApplication(s, s1, bundle, callbackfuture, tracer);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            AccountsCallbackHelpers.onError(callbackfuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.REGISTER_FAILED.value(), String.format("%s is not a child application device type", new Object[] {
                s1
            }), null);
            return callbackfuture;
        }
        return callbackfuture;
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
                RenameDevice renamedevice = mRenameDevice;
                String s = directedId;
                String s1 = newDeviceName;
                Bundle bundle = options;
                renamedevice.renameDevice$28cc6a5(s, s1, callback1, tracer);
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

    public MAPFuture updateAccountWithKey$5e2b1462(final String directedId, final KeyInfo key, Tracer tracer)
    {
        final CallbackFuture callbackFuture = new CallbackFuture(null);
        if (!validateAccount(directedId, callbackFuture))
        {
            return callbackFuture;
        }
        boolean flag;
        if (CustomerAttributeStoreKeyUtils.isCustomerProfileAttributeKey(key) || CustomerAttributeStoreKeyUtils.isXMainAndXACBCookies(key))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            AccountsCallbackHelpers.onError(callbackFuture, com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.UNRECOGNIZED.value(), String.format("key %s is not valid", new Object[] {
                key.getKey()
            }), null);
            return callbackFuture;
        } else
        {
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
            Bundle bundle = new Bundle();
            AccountRegistrarAuthenticator accountregistrarauthenticator = mRegistrarAuthenticator;
            accountregistrar.updateCredentials$11350a19(listener, directedId, key, bundle, tracer);
            return callbackFuture;
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
            MetricsHelper.incrementCounter("CentralDeviceEmailIsMissing", new String[] {
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
    static void access$1500$3a298657(Callback callback, ArrayList arraylist)
    {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("EnsureAccountStateAttributes", arraylist);
        callback.onSuccess(bundle);
        return;
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
    static void access$500$70268062(AccountManagerLogic accountmanagerlogic, RegistrationType registrationtype, final Bundle regData, Callback callback, String s, final Bundle userData)
    {
        if (userData == null)
        {
            MAPLog.e(TAG, "No userdata returned. The account cannot be created.");
            AccountsCallbackHelpers.onAccountManagerError(callback, 7, "No userdata given. Cannot construct an account");
            return;
        }
        Bundle bundle = new Bundle();
        final String directedId = userData.getString("com.amazon.dcp.sso.property.account.acctId");
        if (accountmanagerlogic.mAmazonAccountManager.doesAccountExistAfterDeregisteringStateCleanup(directedId))
        {
            accountmanagerlogic.updateAccountCredentials(directedId, null, userData);
            MAPLog.w(TAG, "An account has been registered multiple times!");
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, directedId);
            return;
        }
        if (accountmanagerlogic.mAmazonAccountManager.hasDevicePrimaryAmazonAccount() && regData.getBoolean("com.amazon.dcp.sso.AddAccount.options.AddAsSecondary"))
        {
            userData.putString("com.amazon.dcp.sso.property.secondary", "true");
        }
        if (accountmanagerlogic.mAmazonAccountManager.getSessionUsers().isEmpty())
        {
            userData.putString("com.amazon.dcp.sso.property.sessionuser", "true");
        }
        accountmanagerlogic.mMultipleAccountPlugin.addDataOnAddAccount$3060423f(regData, userData);
        BackwardsCompatiableDataStorage backwardscompatiabledatastorage = new BackwardsCompatiableDataStorage(accountmanagerlogic.mContext, accountmanagerlogic.mDataStorage);
        accountmanagerlogic.addNeccesaryUserdata(userData, regData);
        if (registrationtype == RegistrationType.REGISTER_DELEGATED_ACCOUNT)
        {
            userData.putString("com.amazon.dcp.sso.property.account.delegateeaccount", regData.getString("com.amazon.dcp.sso.property.account.delegateeaccount"));
            registrationtype = accountmanagerlogic.mDelegatedAccountHelper.getDelegationDomainFromAPIBundle(regData);
            if (!TextUtils.isEmpty(registrationtype))
            {
                userData.putString("com.amazon.dcp.sso.property.account.delegationDomain", registrationtype);
            }
        }
        Object obj = null;
        registrationtype = null;
        Object obj1 = userData.getString("com.amazon.dcp.sso.property.account.customer_region");
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj = AmazonDomainHelper.getAuthPortalDomainBasedOnCustomerRegion(((String) (obj1)));
            registrationtype = "customer region (home region)";
        }
        obj1 = registrationtype;
        String s1 = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            String s2 = userData.getString("com.amazon.dcp.sso.token.device.accountpool");
            obj1 = registrationtype;
            s1 = ((String) (obj));
            if (!TextUtils.isEmpty(s2))
            {
                s1 = AmazonDomainHelper.getAuthPortalDomainBasedOnAccountPool(s2);
                obj1 = "account pool";
            }
        }
        if (!TextUtils.isEmpty(s1))
        {
            registrationtype = AmazonDomainHelper.getCompleteAuthPortalDomain(s1);
            MAPLog.i(TAG, String.format("Marking the amazon domain for added account: %s. It's generated base on %s.", new Object[] {
                registrationtype, obj1
            }));
            userData.putString("authDomain", registrationtype);
        }
        s1 = BackwardsCompatiabilityHelper.getUniqueAccountName(accountmanagerlogic.mDataStorage, s);
        registrationtype = userData.getString("com.amazon.dcp.sso.property.account.cor");
        s = userData.getString("com.amazon.dcp.sso.property.account.sourceofcor");
        obj = userData.getString("com.amazon.dcp.sso.property.account.pfm");
        userData.remove("com.amazon.dcp.sso.property.account.cor");
        userData.remove("com.amazon.dcp.sso.property.account.sourceofcor");
        userData.remove("com.amazon.dcp.sso.property.account.pfm");
        final String deviceEmail;
        final String deviceType;
        Object obj2;
        Bundle bundle1;
        if (!CorPfmLogic.isValidCorPfmFromDCAS(registrationtype, s, ((String) (obj))))
        {
            MAPLog.i(TAG, "Registering account did not return cor/pfm.");
            registrationtype = null;
        } else
        {
            MAPLog.i(TAG, String.format("Using COR/SourceOfCor/PFM/ returned when registering the account: %s, %s, %s", new Object[] {
                registrationtype, s, obj
            }));
            registrationtype = new CORPFMResponse(registrationtype, ((String) (obj)), s);
        }
        obj = CredentialMapSerializer.toMap(userData.getString("com.amazon.dcp.sso.token.device.credentialsmap"));
        userData.remove("com.amazon.dcp.sso.token.device.credentialsmap");
        s = ((String) (obj));
        if (obj == null)
        {
            s = Collections.emptyMap();
        }
        obj2 = accountmanagerlogic.getCookiesAndRemove(directedId, userData);
        obj = userData.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        bundle1 = new Bundle();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            bundle1.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token", ((String) (obj)));
            bundle1.putString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at", userData.getString("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at"));
            bundle1.putString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token", userData.getString("com.amazon.dcp.sso.token.oauth.amazon.refresh_token"));
        }
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.access_token");
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.access_token.expires_at");
        userData.remove("com.amazon.dcp.sso.token.oauth.amazon.refresh_token");
        deviceEmail = userData.getString("com.amazon.dcp.sso.property.deviceemail");
        deviceType = userData.getString("com.amazon.dcp.sso.token.devicedevicetype");
        if (!bundle1.isEmpty())
        {
            obj = AmazonDomainHelper.getCompleteCookieDomain(AmazonDomainHelper.getPartialAmazonDomainFromAPIBundle(regData));
            obj1 = new HashMap();
            ((Map) (obj1)).putAll(accountmanagerlogic.mOAuthTokenManager.getTokenMapFromRegistrationData(bundle1));
            MAPCookieManager.updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(((List) (obj2)), ((Map) (obj1)));
            ((Map) (obj1)).putAll(accountmanagerlogic.mCookieDataStore.getCookieTokenMapOrWriteToDataStoreFromRegistrationData(directedId, ((List) (obj2)), ((String) (obj))));
        } else
        {
            obj = null;
            obj1 = null;
        }
        obj2 = BundleUtils.toStringStringMap(userData);
        accountmanagerlogic.mCorPfmLogic.setInitialCORPFM(registrationtype, ((Map) (obj2)));
        registrationtype = new AccountTransaction(directedId, ((Map) (obj2)), ((Map) (obj1)));
        for (s = s.entrySet().iterator(); s.hasNext(); DMSSubAuthenticator.populateChildApplicationTokensWithoutRegister(accountmanagerlogic.mContext, registrationtype, (String)((java.util.Map.Entry) (obj1)).getKey(), (Map)((java.util.Map.Entry) (obj1)).getValue()))
        {
            obj1 = (java.util.Map.Entry)s.next();
        }

        if (!backwardscompatiabledatastorage.addAccount(s1, registrationtype, accountmanagerlogic. new _cls5()))
        {
            AccountsCallbackHelpers.onAccountAlreadyExistsError(callback, directedId);
            return;
        }
        accountmanagerlogic.mMultipleAccountLogic.invalidateCache();
        BackwardsCompatiabilityHelper.addAccountManagerSuccessInformation(s1, directedId, bundle);
        if (obj != null && !CollectionUtils.isEmpty(accountmanagerlogic.mCookieDataStore.getNonAuthCookies(((String) (obj)))))
        {
            accountmanagerlogic.mCookieDataStore.setNonAuthCookies(((String) (obj)), null);
        }
        MAPLog.i(TAG, "MAP finished adding account locally and will do the other necessary work asynchronously in the data propogation callback");
        callback.onSuccess(bundle);
        return;
    }

*/




}
