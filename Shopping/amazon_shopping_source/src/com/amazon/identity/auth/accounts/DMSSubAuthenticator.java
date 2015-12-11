// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.attributes.UserProperties;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.framework.AmazonWebServiceCallerCreator;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCall;
import com.amazon.identity.auth.device.framework.AsyncAmazonWebserviceCaller;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.storage.AccountTransaction;
import com.amazon.identity.auth.device.storage.BackwardsCompatiableDataStorage;
import com.amazon.identity.auth.device.storage.CookieDataStore;
import com.amazon.identity.auth.device.storage.CookieDataStoreFactory;
import com.amazon.identity.auth.device.storage.CookieJar;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.storage.StorageKeyUtils;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PackageUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.kcpsdk.auth.DefaultAmazonWebserviceCallListener;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceError;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceRequest;
import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsRequest;
import com.amazon.identity.kcpsdk.auth.UpdateDeviceCredentialsResponseParser;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.SoftwareVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorDescription, AmazonAccountManager, MultipleAccountsLogic, ChildApplicationHelpers, 
//            ChildApplicationOverrideDSNHelper, ChildApplicationRegistrar, AccountStateBroadcasts, SubAuthChildApplicationRegistrar, 
//            StandardChildApplicationRegistrar, ChildApplicationRegistrarCallback

public class DMSSubAuthenticator
    implements ISubAuthenticator
{
    private class _cls6
    {

        static final int $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[];

        static 
        {
            $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType = new int[RegisterDeviceErrorType.values().length];
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeCustomerNotFound.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDeviceAlreadyRegistered.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeDuplicateDeviceName.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognized.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedFirs.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedKindle.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$amazon$identity$kcpsdk$auth$RegisterDeviceErrorType[RegisterDeviceErrorType.RegisterDeviceErrorTypeUnrecognizedPanda.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

    private class _cls3
        implements Runnable
    {

        final DMSSubAuthenticator this$0;
        final String val$directedId;
        final RegisterDeviceResponse val$registerResponse;
        final ISubAuthenticatorResponse val$subAuthenticatorResponse;
        final String val$xmain;

        public void run()
        {
            storeTokenInner(registerResponse, directedId, xmain);
            if (subAuthenticatorResponse != null)
            {
                MAPLog.i(DMSSubAuthenticator.TAG, "Callback with success after storing tokens for the child app.");
                onSuccessCallback(subAuthenticatorResponse);
            }
        }

        _cls3()
        {
            this$0 = DMSSubAuthenticator.this;
            registerResponse = registerdeviceresponse;
            directedId = s;
            xmain = s1;
            subAuthenticatorResponse = isubauthenticatorresponse;
            super();
        }
    }

    private static class DataKey
    {

        public final String deviceTypeInvariantForm;
        public final String legacyToken;

        public String toString()
        {
            String s;
            String s1;
            if (legacyToken != null)
            {
                s = legacyToken;
            } else
            {
                s = "none";
            }
            if (deviceTypeInvariantForm != null)
            {
                s1 = deviceTypeInvariantForm;
            } else
            {
                s1 = "none";
            }
            return String.format("[%s,%s]", new Object[] {
                s, s1
            });
        }

        public DataKey(String s, String s1)
        {
            legacyToken = s;
            deviceTypeInvariantForm = s1;
        }
    }


    private static final String KINDLE_DEVICE_EMAIL = SubAuthenticatorDescription.getDMSDeviceEmailFromPackageName("com.amazon.kindle");
    private static final String TAG = com/amazon/identity/auth/accounts/DMSSubAuthenticator.getName();
    private final AmazonAccountManager mAmznAcctMan;
    private final BackwardsCompatiableDataStorage mBackwardsCompatiableDataStorage;
    private final AmazonWebServiceCallerCreator mCallerCreator;
    private final ServiceWrappingContext mContext;
    private final CookieDataStore mCookieDataStore;
    private final DataStorage mDataStorage;
    private final String mDeviceType;
    private final boolean mIsMultipleAccountAware;
    private final MultipleAccountsLogic mMultipleAccountsLogic;
    private final String mOverrideDsn;
    private final String mPackageName;
    private final PlatformWrapper mPlatform;
    private final String mSoftwareComponentId;
    private final DataKey mTokenAccountPool;
    private final DataKey mTokenDeviceName;
    private final DataKey mTokenStoreAuthCookie;
    private final DataKey mTokenTypeAppADPToken;
    private final DataKey mTokenTypeAppDeviceType;
    private final DataKey mTokenTypeAppDsn;
    private final DataKey mTokenTypeAppPrivateKey;
    private final DataKey mTokenTypeEmail;
    private final DataKey mTokenUserName;
    private final DataKey mTokenXmainCookie;
    private final Integer mVersionCode;

    protected DMSSubAuthenticator(Context context, String s, String s1, String s2, Integer integer, boolean flag)
    {
        mContext = ServiceWrappingContext.create(context);
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mMultipleAccountsLogic = MultipleAccountsLogic.getInstance(mContext);
        mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
        mBackwardsCompatiableDataStorage = new BackwardsCompatiableDataStorage(mContext);
        mCallerCreator = (AmazonWebServiceCallerCreator)mContext.getSystemService("sso_webservice_caller_creator");
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mDeviceType = s1;
        mOverrideDsn = s2;
        mPackageName = s;
        mVersionCode = integer;
        mSoftwareComponentId = DeviceTypeHelpers.getSoftwareComponentId(context, s1, s);
        mIsMultipleAccountAware = flag;
        mTokenTypeAppADPToken = new DataKey(SubAuthenticatorDescription.getDMSAdpTokenNameFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.device.adptoken"));
        mTokenTypeAppPrivateKey = new DataKey(SubAuthenticatorDescription.getDMSPrivateKeyFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.device.privatekey"));
        mTokenTypeAppDeviceType = new DataKey(SubAuthenticatorDescription.getDMSDeviceTypeFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.devicedevicetype"));
        mTokenTypeAppDsn = new DataKey(SubAuthenticatorDescription.getDMSDeviceSerialNumberFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.device.deviceserialname"));
        mTokenTypeEmail = new DataKey(SubAuthenticatorDescription.getDMSDeviceEmailFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.property.deviceemail"));
        mTokenStoreAuthCookie = new DataKey(SubAuthenticatorDescription.getDMSStoreAuthCookieFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.identity.cookies.xfsn"));
        mTokenXmainCookie = new DataKey(SubAuthenticatorDescription.getXmainCookieFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.cookie.xmain"));
        mTokenDeviceName = new DataKey(SubAuthenticatorDescription.getDeviceNameFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.property.devicename"));
        mTokenUserName = new DataKey(SubAuthenticatorDescription.getUserNameFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.property.username"));
        mTokenAccountPool = new DataKey(SubAuthenticatorDescription.getAccountPoolFromPackageName(s), StorageKeyUtils.getKeyWithDeviceTypePrefix(mContext, s1, "com.amazon.dcp.sso.token.device.accountpool"));
        mCookieDataStore = (new CookieDataStoreFactory(mContext)).getDataStore();
    }

    private Bundle buildSubAuthenticatorErrorBundle(int i, String s)
    {
        MAPLog.e(TAG, (new StringBuilder("Error gettingAuthToken ")).append(s).toString());
        Bundle bundle = new Bundle();
        bundle.putInt("com.amazon.dcp.sso.dms.ErrorCode", i);
        bundle.putString("com.amazon.dcp.sso.dms.ErrorMessage", s);
        return bundle;
    }

    public static DMSSubAuthenticator constructDMSSubAuthForDeviceType(Context context, String s, String s1, Integer integer, String s2)
    {
        return new DMSSubAuthenticator(context, s2, s, s1, integer, true);
    }

    public static DMSSubAuthenticator constructDMSSubAuthForThisPackage(Context context)
    {
        String s = context.getPackageName();
        RemoteMapInfo remotemapinfo = MAPApplicationInformationQueryer.getInstance(context).getAppInfo(s);
        if (remotemapinfo == null)
        {
            throw new IllegalStateException((new StringBuilder("Could not construct DMSSubAuthenticator for this package (")).append(s).append(") because it's not properly integrated with MAP").toString());
        }
        Integer integer = PackageUtils.getPackageVersion(context, s);
        try
        {
            context = new DMSSubAuthenticator(context, s, remotemapinfo.getDeviceType(), remotemapinfo.getOverrideDSN(), integer, true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder("Could not construct DMSSubAuthenticator for this package (")).append(s).append(") because we couldn't query its MAP info provider").toString(), context);
        }
        return context;
    }

    public static DMSSubAuthenticator constructDMSSubAuthenticatorFromDescription(Context context, SubAuthenticatorDescription subauthenticatordescription)
    {
        String s = DeviceTypeHelpers.getLegacySubAuthPackageDeviceType(context, subauthenticatordescription.packageName, subauthenticatordescription.deviceType);
        Integer integer = PackageUtils.getPackageVersion(context, subauthenticatordescription.packageName);
        return new DMSSubAuthenticator(context, subauthenticatordescription.packageName, s, null, integer, subauthenticatordescription.isKnownMultipleAccountAware);
    }

    private String getParentDsn(String s)
    {
        if (mOverrideDsn != null)
        {
            s = TAG;
            s = mOverrideDsn;
            s = mDeviceType;
            return mOverrideDsn;
        } else
        {
            return (new BackwardsCompatiableDataStorage(mContext, mDataStorage)).getUserData(s, "com.amazon.dcp.sso.token.device.deviceserialname");
        }
    }

    private void onSuccessCallback(ISubAuthenticatorResponse isubauthenticatorresponse)
    {
        try
        {
            isubauthenticatorresponse.onResult(ChildApplicationHelpers.createSuccessBundle());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ISubAuthenticatorResponse isubauthenticatorresponse)
        {
            MAPLog.e(TAG, "Error Callback Success", isubauthenticatorresponse);
        }
    }

    public static void populateChildApplicationTokensWithoutRegister(Context context, AccountTransaction accounttransaction, String s, Map map)
    {
        if (map == null || map.isEmpty() || TextUtils.isEmpty(s))
        {
            MAPLog.e(TAG, "The input device type or map is null or empty. Ignoring it.");
        } else
        if (ChildApplicationHelpers.isChildApplication(context, s))
        {
            (new DMSSubAuthenticator(context, null, s, null, null, true)).storeTokensForChildApp(accounttransaction, s, map);
            return;
        }
    }

    private void registerChildApplication$55988019(final ISubAuthenticatorResponse subAuthenticatorResponse, ChildApplicationRegistrar childapplicationregistrar, final String directedId, Tracer tracer)
    {
        subAuthenticatorResponse = new ChildApplicationRegistrarCallback() {

            final DMSSubAuthenticator this$0;
            final String val$directedId;
            final ISubAuthenticatorResponse val$subAuthenticatorResponse;

            public void onAuthenticationFailed()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Authentication error when registering the child app.");
                    Bundle bundle = buildSubAuthenticatorErrorBundle(103, "Authentication error during register");
                    subAuthenticatorResponse.onResult(bundle);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during authentication failure callback for registerChildApplication");
                }
            }

            public void onBadResponse()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Bad response when registering the child app.");
                    subAuthenticatorResponse.onError(5, "Received bad response");
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during invalid response callback for registerChildApplication");
                }
            }

            public void onInvalidRequest()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Bad request when registering the child app.");
                    subAuthenticatorResponse.onError(8, "Received bad request");
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during bad request callback for registerChildApplication");
                }
            }

            public void onNetworkError()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Network error when registering the child app.");
                    subAuthenticatorResponse.onError(3, "Network error");
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during network failure callback for registerChildApplication");
                }
            }

            public void onRegisterChildApplicationComplete(RegisterDeviceResponse registerdeviceresponse)
            {
                try
                {
                    MAPLog.i(DMSSubAuthenticator.TAG, "Getting response for the child application registration. Storing results.");
                    DMSSubAuthenticator.access$200(DMSSubAuthenticator.this, subAuthenticatorResponse, registerdeviceresponse, directedId);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (RegisterDeviceResponse registerdeviceresponse)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException when credentials was received for registerChildApplication");
                }
            }

            
            {
                this$0 = DMSSubAuthenticator.this;
                subAuthenticatorResponse = isubauthenticatorresponse;
                directedId = s;
                super();
            }
        };
        Object obj = new RegisterDeviceRequest();
        ((RegisterDeviceRequest) (obj)).setUseExchangeToken(true);
        ((RegisterDeviceRequest) (obj)).setDeviceType(mDeviceType);
        ((RegisterDeviceRequest) (obj)).setDeviceSerialNumber(getParentDsn(directedId));
        if (ChildApplicationOverrideDSNHelper.isOverridingDSN(mOverrideDsn, mContext.getFeatureSet()))
        {
            ((RegisterDeviceRequest) (obj)).setUseOverrideDSN(true);
        }
        boolean flag;
        if (mIsMultipleAccountAware && !mAmznAcctMan.isDevicePrimaryAmazonAccount(directedId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            MAPLog.i(TAG, String.format("Registering secondary account for device type %s", new Object[] {
                mDeviceType
            }));
        }
        ((RegisterDeviceRequest) (obj)).setAddAsSecondaryAccount(flag);
        if (mVersionCode != null)
        {
            ((RegisterDeviceRequest) (obj)).setDeviceSoftwareVersion(new SoftwareVersion(Integer.toString(mVersionCode.intValue())));
        }
        if (mSoftwareComponentId != null)
        {
            ((RegisterDeviceRequest) (obj)).setSoftwareComponentId(mSoftwareComponentId);
        }
        obj = ((RegisterDeviceRequest) (obj)).getWebRequest();
        if (obj != null)
        {
            childapplicationregistrar.registerChild(directedId, ((com.amazon.identity.kcpsdk.common.WebRequest) (obj)), subAuthenticatorResponse, tracer);
            return;
        } else
        {
            MAPLog.e(TAG, "Could not construct a valid child application registration request");
            return;
        }
    }

    private void setTokensInAccountTransaction(RegisterDeviceResponse registerdeviceresponse, AccountTransaction accounttransaction, String s, String s1)
    {
        storeTokenInAccountTransaction(accounttransaction, mTokenTypeAppADPToken, registerdeviceresponse.getAdpToken());
        storeTokenInAccountTransaction(accounttransaction, mTokenTypeAppPrivateKey, registerdeviceresponse.getPrivateKey());
        storeTokenInAccountTransaction(accounttransaction, mTokenStoreAuthCookie, registerdeviceresponse.getStoreAuthenticationCookie());
        storeTokenInAccountTransaction(accounttransaction, mTokenXmainCookie, s);
        storeUserDataInAccountTransaction(accounttransaction, mTokenTypeAppDeviceType, mDeviceType);
        storeUserDataInAccountTransaction(accounttransaction, mTokenTypeAppDsn, s1);
        storeUserDataInAccountTransaction(accounttransaction, mTokenTypeEmail, registerdeviceresponse.getEmail());
        storeUserDataInAccountTransaction(accounttransaction, mTokenDeviceName, registerdeviceresponse.getDeviceName());
        storeUserDataInAccountTransaction(accounttransaction, mTokenUserName, registerdeviceresponse.getUserName());
        storeUserDataInAccountTransaction(accounttransaction, mTokenAccountPool, registerdeviceresponse.getAccountPool());
        ChildApplicationHelpers.setChildApplicationWithDeviceTypeRegistered(mContext.getFeatureSet(), accounttransaction, mDeviceType, mPackageName, mOverrideDsn);
    }

    private void storeTokenInAccountTransaction(AccountTransaction accounttransaction, DataKey datakey, String s)
    {
        String s1 = TAG;
        (new StringBuilder("Local storeToken: ")).append(datakey).toString();
        if (s == null)
        {
            MAPLog.i(TAG, String.format("Tried to set token %s to null", new Object[] {
                datakey
            }));
        } else
        {
            if (datakey.legacyToken != null)
            {
                accounttransaction.setToken(datakey.legacyToken, s);
            }
            if (datakey.deviceTypeInvariantForm != null)
            {
                accounttransaction.setToken(datakey.deviceTypeInvariantForm, s);
                return;
            }
        }
    }

    private void storeTokenInner(RegisterDeviceResponse registerdeviceresponse, String s, String s1)
    {
        String s2 = getParentDsn(s);
        s = new AccountTransaction(s, new HashMap(), new HashMap(), mBackwardsCompatiableDataStorage);
        setTokensInAccountTransaction(registerdeviceresponse, s, s1, s2);
        mBackwardsCompatiableDataStorage.setData(s);
    }

    private void storeUserDataInAccountTransaction(AccountTransaction accounttransaction, DataKey datakey, String s)
    {
        String s1 = TAG;
        (new StringBuilder("Local storeUserData: ")).append(datakey).toString();
        if (s == null)
        {
            MAPLog.i(TAG, String.format("Tried to set user data %s to null", new Object[] {
                datakey
            }));
        } else
        {
            if (datakey.legacyToken != null)
            {
                accounttransaction.setToken(datakey.legacyToken, s);
            }
            if (datakey.deviceTypeInvariantForm != null)
            {
                accounttransaction.setUserData(datakey.deviceTypeInvariantForm, s);
                return;
            }
        }
    }

    private ISubAuthenticatorResponse wrapResponseWithGetTokenAndMetrics(final ISubAuthenticatorResponse subAuthenticatorResponse, final String directedId, final String authTokenType, final Tracer tracer)
    {
        return new ISubAuthenticatorResponse() {

            final DMSSubAuthenticator this$0;
            final String val$authTokenType;
            final String val$directedId;
            final ISubAuthenticatorResponse val$subAuthenticatorResponse;
            final Tracer val$tracer;

            public IBinder asBinder()
            {
                return subAuthenticatorResponse.asBinder();
            }

            public void onError(int i, String s)
                throws RemoteException
            {
                subAuthenticatorResponse.onError(i, s);
                if (tracer != null)
                {
                    tracer.finishTrace();
                }
            }

            public void onResult(Bundle bundle)
                throws RemoteException
            {
                bundle = DMSSubAuthenticator.access$000(DMSSubAuthenticator.this, bundle, directedId, authTokenType);
                subAuthenticatorResponse.onResult(bundle);
                if (tracer != null)
                {
                    tracer.finishTrace();
                }
            }

            
            {
                this$0 = DMSSubAuthenticator.this;
                subAuthenticatorResponse = isubauthenticatorresponse;
                tracer = tracer1;
                directedId = s;
                authTokenType = s1;
                super();
            }
        };
    }

    public IBinder asBinder()
    {
        throw new UnsupportedOperationException("asBinder is not supported in DMSSubAuthenticator");
    }

    public void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1)
    {
        MAPLog.w(TAG, "DMS sub authenticator getAccountRemovalAllowed was called");
        s = new Account(s1, s);
        if (!mPlatform.isPreMergeDevice())
        {
            s = TAG;
        } else
        {
            MAPLog.i(TAG, "Generating local account removed broadcast.");
            s1 = BackwardsCompatiabilityHelper.getDirectedId(mContext, s);
            mCookieDataStore.clearCookies(mContext, s1);
            MAPLog.i(TAG, "Cleared local cookies in pre merge devices");
            AccountStateBroadcasts.sendAccountRemovedNotification(mContext, mMultipleAccountsLogic.isAPrimaryAccount(s1), s1, s, mContext.getPackageName(), mMultipleAccountsLogic.getListOfProfilesWhereTheAccountIsPrimary(mContext, s1));
        }
        s = new Bundle();
        s.putBoolean("booleanResult", true);
        try
        {
            isubauthenticatorresponse.onResult(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ISubAuthenticatorResponse isubauthenticatorresponse)
        {
            MAPLog.e(TAG, "RemoteException during getAccountRemovalAllowed in DMS sub authenticator");
        }
    }

    public void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        bundle = Tracer.getNewTracer("DMSSubAuthenticator:GetAuthToken");
        if (!"com.amazon.account".equals(s))
        {
            MAPLog.e(TAG, "An Attempt to retrieve a token for a non amazon account.");
            return;
        }
        s = new Account(s1, s);
        s = BackwardsCompatiabilityHelper.getDirectedId(mContext, s);
        s1 = wrapResponseWithGetTokenAndMetrics(isubauthenticatorresponse, s, s2, bundle);
        if (iamazonaccountauthenticator != null)
        {
            isubauthenticatorresponse = new SubAuthChildApplicationRegistrar(iamazonaccountauthenticator);
        } else
        {
            isubauthenticatorresponse = new StandardChildApplicationRegistrar(mContext);
        }
        registerChildApplication$55988019(s1, isubauthenticatorresponse, s, bundle);
    }

    public void registerChildApplication(ISubAuthenticatorResponse isubauthenticatorresponse, String s, Bundle bundle, Tracer tracer)
    {
        if (ChildApplicationHelpers.isInvalidChildDeviceType(mDeviceType))
        {
            MAPLog.e(TAG, String.format("An Attempt to register an invalid child device type: %s. This is due to wrong integration with MAP.", new Object[] {
                mDeviceType
            }));
            try
            {
                isubauthenticatorresponse.onError(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.BAD_REQUEST.value(), "Child Application registration failed due to invalid child device type. This is due to wrong integration with MAP.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ISubAuthenticatorResponse isubauthenticatorresponse)
            {
                MAPLog.e(TAG, "RemoteException on callback error for account not existing.");
            }
            return;
        }
        if (!mAmznAcctMan.doesAccountExist(s))
        {
            MAPLog.e(TAG, "An Attempt to register a child device type for a non-existant amazon account. This can happen if the device has been deregistered during this flow.");
            try
            {
                isubauthenticatorresponse.onError(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.NO_ACCOUNT.value(), "Child Application registration failed due to account not being registered on the device. This can happen if the device has been deregistered during this flow.");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ISubAuthenticatorResponse isubauthenticatorresponse)
            {
                MAPLog.e(TAG, "RemoteException on callback error for account not existing.");
            }
            return;
        }
        if (ChildApplicationHelpers.isChildApplicationDeviceTypeRegistered(mContext, s, mDeviceType))
        {
            MAPLog.i(TAG, String.format("Child Application device type %s is already registered", new Object[] {
                mDeviceType
            }));
            onSuccessCallback(isubauthenticatorresponse);
            return;
        } else
        {
            registerChildApplication$55988019(isubauthenticatorresponse, new StandardChildApplicationRegistrar(mContext), s, tracer);
            return;
        }
    }

    public void storeTokensForChildApp(AccountTransaction accounttransaction, String s, Map map)
    {
        Object obj;
        if (map == null || map.isEmpty())
        {
            MAPLog.e(TAG, (new StringBuilder("The pre-populated credential map does not have any valid data, ignoring it for device type: ")).append(s).toString());
            obj = null;
        } else
        {
            String s12 = (String)map.get("adp_token");
            String s13 = (String)map.get("device_private_key");
            if (TextUtils.isEmpty(s12) || TextUtils.isEmpty(s13))
            {
                MAPLog.e(TAG, (new StringBuilder("The pre-populated credential map does not have valid ADP credentials, ignoring it for device type: ")).append(s).toString());
                MAPLog.e(TAG, (new StringBuilder("The pre-populated credential map contains the following  invalid key: ")).append(map.keySet()).toString());
                obj = null;
            } else
            {
                String s11 = (String)map.get("store_authentication_cookie");
                if (TextUtils.isEmpty(s11))
                {
                    MAPLog.i(TAG, (new StringBuilder("The batch registration did not return store auth cookie for device type: ")).append(s).toString());
                }
                obj = (String)map.get("user_device_name");
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = accounttransaction.getUserData("com.amazon.dcp.sso.property.devicename");
                    String s1 = TAG;
                    String.format("Using the device name: %s of central device type for child device type: %s", new Object[] {
                        obj, s
                    });
                }
                String s2 = (String)map.get("kindle_email_address");
                if (TextUtils.isEmpty(s2))
                {
                    s2 = accounttransaction.getUserData("com.amazon.dcp.sso.property.deviceemail");
                    String s4 = TAG;
                    String.format("Using the device email: %s of central device type for child device type: %s", new Object[] {
                        s2, s
                    });
                }
                String s5 = (String)map.get("name");
                if (TextUtils.isEmpty(s5))
                {
                    s5 = accounttransaction.getUserData("com.amazon.dcp.sso.property.username");
                    String s7 = TAG;
                    String.format("Using the username: %s of central device type for child device type: %s", new Object[] {
                        s5, s
                    });
                }
                String s9 = (String)map.get("account_pool");
                String s8 = s9;
                if (TextUtils.isEmpty(s9))
                {
                    s8 = accounttransaction.getUserData("com.amazon.dcp.sso.token.device.accountpool");
                    String s10 = TAG;
                    String.format("Using the account pool: %s of central device type for child device type: %s", new Object[] {
                        s8, s
                    });
                }
                obj = new RegisterDeviceResponse(s12, ((String) (obj)), s13, s5, s2, null);
                ((RegisterDeviceResponse) (obj)).setStoreAuthenticationCookie(s11);
                ((RegisterDeviceResponse) (obj)).setAccountPool(s8);
            }
        }
        if (obj == null)
        {
            return;
        }
        MAPLog.i(TAG, String.format("There are %d pre-populated tokens for child device type: %s", new Object[] {
            Integer.valueOf(map.size()), s
        }));
        String s3;
        for (map = map.keySet().iterator(); map.hasNext(); String.format("Pre-populating the token: %s for child device type: %s", new Object[] {
    s3, s
}))
        {
            s3 = (String)map.next();
            String s6 = TAG;
        }

        setTokensInAccountTransaction(((RegisterDeviceResponse) (obj)), accounttransaction, accounttransaction.getToken("com.amazon.dcp.sso.token.cookie.xmain"), accounttransaction.getUserData("com.amazon.dcp.sso.token.device.deviceserialname"));
    }

    public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        iamazonaccountauthenticator = Tracer.getNewTracer("DMSSubAuthenticator:UpdateAuthToken");
        MAPLog.i(TAG, "Updating DMS authentication tokens");
        s = new Account(s1, s);
        s = BackwardsCompatiabilityHelper.getDirectedId(mContext, s);
        updateCredentials(wrapResponseWithGetTokenAndMetrics(isubauthenticatorresponse, s, s2, iamazonaccountauthenticator), s, bundle, iamazonaccountauthenticator);
    }

    public void updateCredentials(final ISubAuthenticatorResponse subAuthenticatorResponse, final String directedId, Bundle bundle, Tracer tracer)
    {
        bundle = new UpdateDeviceCredentialsRequest();
        if (mVersionCode != null)
        {
            bundle.setSoftwareVersion(new SoftwareVersion(Integer.toString(mVersionCode.intValue())));
        }
        if (mSoftwareComponentId != null)
        {
            bundle.setSoftwareComponentId(mSoftwareComponentId);
        }
        subAuthenticatorResponse = new DefaultAmazonWebserviceCallListener() {

            final DMSSubAuthenticator this$0;
            final String val$directedId;
            final ISubAuthenticatorResponse val$subAuthenticatorResponse;

            public void onAuthenticationFailed()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Authentication failure when updating the credentials for child app.");
                    Bundle bundle1 = buildSubAuthenticatorErrorBundle(103, "Authentication error during update credentials");
                    subAuthenticatorResponse.onResult(bundle1);
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during authentication failure callback for updateCredentials");
                }
            }

            public void onNetworkFailure()
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Update SubAuthenticator Credentials onNetworkFailure");
                    subAuthenticatorResponse.onError(3, "Network failure");
                    return;
                }
                catch (RemoteException remoteexception)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during network failure callback for updateCredentials");
                }
            }

            public void onParseError(ParseError parseerror)
            {
                try
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "Update SubAuthenticator Credentials onParseError");
                    subAuthenticatorResponse.onError(5, "Received bad response");
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ParseError parseerror)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during invalid response callback for updateCredentials");
                }
            }

            public void onResponseComplete(Object obj)
            {
                MAPLog.i(DMSSubAuthenticator.TAG, "Update credential request succeeded");
                try
                {
                    obj = (RegisterDeviceResponse)obj;
                    DMSSubAuthenticator.access$200(DMSSubAuthenticator.this, subAuthenticatorResponse, ((RegisterDeviceResponse) (obj)), directedId);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MAPLog.e(DMSSubAuthenticator.TAG, "RemoteException during update credentials call");
                }
            }

            
            {
                this$0 = DMSSubAuthenticator.this;
                subAuthenticatorResponse = isubauthenticatorresponse;
                directedId = s;
                super();
            }
        };
        bundle = bundle.getWebRequest();
        UpdateDeviceCredentialsResponseParser updatedevicecredentialsresponseparser = new UpdateDeviceCredentialsResponseParser();
        directedId = new AccountCredentials() {

            final DMSSubAuthenticator this$0;
            final String val$directedId;

            public String getPrivateKey()
            {
                String s = mDataStorage.getToken(directedId, mTokenTypeAppPrivateKey.deviceTypeInvariantForm);
                if (s != null)
                {
                    return s;
                } else
                {
                    return mDataStorage.getToken(directedId, mTokenTypeAppPrivateKey.legacyToken);
                }
            }

            public String getToken()
            {
                String s = mDataStorage.getToken(directedId, mTokenTypeAppADPToken.deviceTypeInvariantForm);
                if (s != null)
                {
                    return s;
                } else
                {
                    return mDataStorage.getToken(directedId, mTokenTypeAppADPToken.legacyToken);
                }
            }

            public boolean isStale(Context context)
            {
                return false;
            }

            
            {
                this$0 = DMSSubAuthenticator.this;
                directedId = s;
                super();
            }
        };
        mCallerCreator.create(directedId, tracer).createCall(bundle, updatedevicecredentialsresponseparser, subAuthenticatorResponse).call();
    }



/*
    static Bundle access$000(DMSSubAuthenticator dmssubauthenticator, Bundle bundle, String s, String s1)
    {
        if (bundle.containsKey("com.amazon.dcp.sso.dms.ErrorCode"))
        {
            return bundle;
        }
        String s2 = dmssubauthenticator.mDataStorage.getToken(s, s1);
        if (s2 == null)
        {
            return dmssubauthenticator.buildSubAuthenticatorErrorBundle(104, "Requested token type was not found in authenticator cache.");
        }
        if (KINDLE_DEVICE_EMAIL.equals(s1))
        {
            UserProperties.sendDeviceEmailChangedNotification(dmssubauthenticator.mContext, s, s2);
        }
        bundle.putString("authtoken", s2);
        return bundle;
    }

*/



/*
    static void access$200(DMSSubAuthenticator dmssubauthenticator, final ISubAuthenticatorResponse subAuthenticatorResponse, final RegisterDeviceResponse registerResponse, final String directedId)
        throws RemoteException
    {
        if (registerResponse != null) goto _L2; else goto _L1
_L1:
        subAuthenticatorResponse.onError(5, "Could not parse response");
_L12:
        return;
_L2:
        if (registerResponse.getError() == null) goto _L4; else goto _L3
_L3:
        directedId = registerResponse.getError();
        registerResponse = null;
        _cls6..SwitchMap.com.amazon.identity.kcpsdk.auth.RegisterDeviceErrorType[directedId.getType().ordinal()];
        JVM INSTR tableswitch 1 7: default 84
    //                   1 128
    //                   2 141
    //                   3 154
    //                   4 167
    //                   5 167
    //                   6 167
    //                   7 167;
           goto _L5 _L6 _L7 _L8 _L9 _L9 _L9 _L9
_L5:
        subAuthenticatorResponse.onError(5, (new StringBuilder("Invalid Response: ")).append(directedId.getType().getErrorString()).toString());
        dmssubauthenticator = registerResponse;
_L10:
        if (dmssubauthenticator != null)
        {
            subAuthenticatorResponse.onResult(dmssubauthenticator);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        dmssubauthenticator = dmssubauthenticator.buildSubAuthenticatorErrorBundle(100, "Invalid username or password");
        continue; /* Loop/switch isn't completed */
_L7:
        dmssubauthenticator = dmssubauthenticator.buildSubAuthenticatorErrorBundle(101, "Device already registered to another user.");
        continue; /* Loop/switch isn't completed */
_L8:
        dmssubauthenticator = dmssubauthenticator.buildSubAuthenticatorErrorBundle(102, "Duplicate device name");
        continue; /* Loop/switch isn't completed */
_L9:
        subAuthenticatorResponse.onError(5, (new StringBuilder("Unrecognized Response ")).append(directedId.getType().getErrorString()).toString());
        dmssubauthenticator = registerResponse;
        if (true) goto _L10; else goto _L4
_L4:
        final String xmain = (new CookieJar(registerResponse.getCookiesRetrievedFromFIRS())).getXmain();
        if (ThreadUtils.isRunningOnMainThread())
        {
            ThreadUtils.submitToBackgroundThread(dmssubauthenticator. new _cls3());
            return;
        }
        dmssubauthenticator.storeTokenInner(registerResponse, directedId, xmain);
        if (subAuthenticatorResponse != null)
        {
            MAPLog.i(TAG, "Callback with success after storing tokens for the child app.");
            dmssubauthenticator.onSuccessCallback(subAuthenticatorResponse);
            return;
        }
        if (true) goto _L12; else goto _L11
_L11:
        return;
    }

*/






}
