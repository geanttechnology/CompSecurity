// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.ArrayUtil;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountRegistrarAuthenticator, AmazonAccountManager, MultipleAccountsLogic, AccountRegistrar, 
//            SubAuthenticatorConnection, SubAuthenticatorDescription, MultipleAccountPluginHolder, MultipleAccountPlugin, 
//            ChildApplicationOverrideDSNHelper

public class DeregisterAccount
{
    public static interface ConnectionFactory
    {

        public abstract AccountRegistrar createAccountRegistrar();

        public abstract SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription);
    }

    public static class DefaultConnectionFactory
        implements ConnectionFactory
    {

        private final Context mContext;

        public AccountRegistrar createAccountRegistrar()
        {
            return new AccountRegistrar(mContext);
        }

        public SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription)
        {
            return new SubAuthenticatorConnection(subauthenticatordescription, mContext);
        }

        public DefaultConnectionFactory(Context context)
        {
            mContext = context;
        }
    }

    private static class DeregisterRequest
        implements Runnable
    {

        private final AccountCredentials mAccountCredentials;
        private final AmazonAccountManager mAmazonAccountManager;
        private ConnectionFactory mConnectionFactory;
        private final Context mContext;
        private final DataStorage mDataStorage;
        private final boolean mDeregisterAllOnAccountRemoval;
        private final String mDirectedId;
        private final MAPAccountManager mMapAcctMan;
        private final PlatformWrapper mPlatform;
        private final AccountRegistrarAuthenticator mRegistrarAuthenticator;
        private ResponseListener mResponseListener;
        private final ArrayList mSubAuths;
        private final Tracer mTracer;

        private boolean notifySubAuthsAccountRemoved()
        {
            Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, mDirectedId);
            if (account != null) goto _L2; else goto _L1
_L1:
            boolean flag1;
            MAPLog.e(DeregisterAccount.TAG, "Sub authenticators are not supported on 3rd party devices yet");
            flag1 = true;
_L4:
            return flag1;
_L2:
            Iterator iterator;
            boolean flag;
            flag = true;
            iterator = mSubAuths.iterator();
_L5:
            flag1 = flag;
            if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
            Object obj;
label0:
            {
                SubAuthenticatorDescription subauthenticatordescription = (SubAuthenticatorDescription)iterator.next();
                obj = new SynchronousSubAuthConnector(getConnectionFactory().createSubAuthConnection(subauthenticatordescription));
                ((SynchronousSubAuthConnector) (obj)).run();
                if (!((SynchronousSubAuthConnector) (obj)).getConnected())
                {
                    MAPLog.e(DeregisterAccount.TAG, (new StringBuilder("Failed to establish SubAuthenticator Connection: ")).append(subauthenticatordescription.packageName).toString());
                    obj = null;
                } else
                {
                    obj = ((SynchronousSubAuthConnector) (obj)).getConnection();
                }
                if (obj != null)
                {
                    break label0;
                }
                SSOMetrics.deregistrationSubAuthFailure(subauthenticatordescription.packageName);
                flag = false;
            }
              goto _L5
            if (notifySubAuthAccountRemoved(account, ((SubAuthenticatorConnection) (obj))))
            {
                break MISSING_BLOCK_LABEL_168;
            }
            SSOMetrics.deregistrationSubAuthFailure(((SubAuthenticatorConnection) (obj)).getPackageName());
            flag = false;
            ((SubAuthenticatorConnection) (obj)).closeConnection();
              goto _L5
            Exception exception;
            exception;
            ((SubAuthenticatorConnection) (obj)).closeConnection();
            throw exception;
        }

        public ConnectionFactory getConnectionFactory()
        {
            this;
            JVM INSTR monitorenter ;
            ConnectionFactory connectionfactory;
            if (mConnectionFactory == null)
            {
                mConnectionFactory = new DefaultConnectionFactory(mContext);
            }
            connectionfactory = mConnectionFactory;
            this;
            JVM INSTR monitorexit ;
            return connectionfactory;
            Exception exception;
            exception;
            throw exception;
        }

        public ResponseListener getResponseListener()
        {
            this;
            JVM INSTR monitorenter ;
            ResponseListener responselistener = mResponseListener;
            this;
            JVM INSTR monitorexit ;
            return responselistener;
            Exception exception;
            exception;
            throw exception;
        }

        protected boolean isRegistered(String s)
        {
            return mAmazonAccountManager.doesAccountExist(s);
        }

        protected boolean notifySubAuthAccountRemoved(Account account, SubAuthenticatorConnection subauthenticatorconnection)
        {
            MAPLog.i(DeregisterAccount.TAG, (new StringBuilder("Notifying subauth: ")).append(subauthenticatorconnection.getPackageName()).toString());
            account = new SynchronousSubAuthDeregistration(subauthenticatorconnection, account);
            subauthenticatorconnection = SSOMetrics.getDeregistrationSubAuthTimer(subauthenticatorconnection.getPackageName());
            subauthenticatorconnection.start();
            account.run(Long.valueOf(7L), TimeUnit.SECONDS, "NotifySubAuthAccountRemoval");
            subauthenticatorconnection.stop();
            return account.getSuccess();
        }

        public void onRequestComplete(boolean flag)
        {
            ResponseListener responselistener = getResponseListener();
            if (responselistener != null)
            {
                responselistener.onRequestComplete(flag);
            }
        }

        public void run()
        {
            boolean flag1 = true;
            boolean flag;
            if (!isRegistered(mDirectedId))
            {
                SSOMetrics.deregistrationRequestFailure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ALREADY_DEREGISTERED);
                flag = false;
            } else
            {
                PlatformMetricsTimer platformmetricstimer = SSOMetrics.getDeregistrationTimer();
                platformmetricstimer.start();
                if (!notifySubAuthsAccountRemoved())
                {
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (DeregisterAccount.haveWeNotifiedServerOfDeregister(mAmazonAccountManager, mDirectedId))
                {
                    String _tmp = DeregisterAccount.TAG;
                    String s = mDirectedId;
                } else
                {
                    Object obj1 = getConnectionFactory().createAccountRegistrar();
                    obj1 = new SynchronousAccountRegistrarDeregistration(mContext, mDirectedId, mDeregisterAllOnAccountRemoval, ((AccountRegistrar) (obj1)), mRegistrarAuthenticator, mAccountCredentials, mTracer);
                    ((SynchronousAccountRegistrarDeregistration) (obj1)).run();
                    flag1 = ((SynchronousAccountRegistrarDeregistration) (obj1)).getSuccess();
                    if (flag1)
                    {
                        Object obj2;
                        if (mDeregisterAllOnAccountRemoval)
                        {
                            obj2 = mMapAcctMan.getAccounts();
                        } else
                        {
                            obj2 = ArrayUtil.asSet(new String[] {
                                mDirectedId
                            });
                        }
                        obj2 = ((Set) (obj2)).iterator();
                        while (((Iterator) (obj2)).hasNext()) 
                        {
                            String s1 = (String)((Iterator) (obj2)).next();
                            DeregisterAccount.setHasDeregisteredAccount(mAmazonAccountManager, s1);
                        }
                    } else
                    {
                        MAPLog.e(DeregisterAccount.TAG, "Deregister was not successful. Not marking accounts that they were deregistered on the server");
                    }
                }
                if (!flag1)
                {
                    flag = false;
                }
                if (mPlatform.isThirdPartyDevice())
                {
                    Object obj = ChildApplicationOverrideDSNHelper.getOverridingDSNChildDeviceTypePackages(mDirectedId, mDataStorage);
                    if (!((Collection) (obj)).isEmpty())
                    {
                        final String overridingDSNChildDevicePackageName;
                        final AccountRegistrar registrar;
                        final AccountRegistrar.Listener emptyListener;
                        AccountCredentials accountcredentials;
                        for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); DeregisterAccount.THREAD_POOL.execute(accountcredentials. new Runnable() {

        final DeregisterRequest this$0;
        final AccountCredentials val$creds;
        final AccountRegistrar.Listener val$emptyListener;
        final String val$overridingDSNChildDevicePackageName;
        final AccountRegistrar val$registrar;

        public void run()
        {
            registrar.deregister(emptyListener, overridingDSNChildDevicePackageName, mDirectedId, creds, true, mRegistrarAuthenticator, mTracer);
        }

            
            {
                this$0 = final_deregisterrequest;
                registrar = accountregistrar;
                emptyListener = listener;
                overridingDSNChildDevicePackageName = s;
                creds = AccountCredentials.this;
                super();
            }
    }))
                        {
                            overridingDSNChildDevicePackageName = (String)((Iterator) (obj)).next();
                            registrar = getConnectionFactory().createAccountRegistrar();
                            emptyListener = new AccountRegistrar.Listener() {

                                final DeregisterRequest this$0;

                                public void accountAlreadyExists(String s)
                                {
                                    MAPLog.e(DeregisterAccount.TAG, String.format("Deregister Failure for Overriding DSN Child Device Type due to registration already existing.  This should not happen. DirectedId: %s", new Object[] {
                                        s
                                    }));
                                }

                                public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle)
                                {
                                    MAPLog.e(DeregisterAccount.TAG, String.format("Deregister Failure for Overriding DSN Child Device Type: %s", new Object[] {
                                        registrationerror.name()
                                    }));
                                }

                                public void success(String s, String s1, Bundle bundle)
                                {
                                    String _tmp = DeregisterAccount.TAG;
                                    String.format("Deregister Succeeded for Overriding DSN Child Device Type. directedId %s", new Object[] {
                                        s
                                    });
                                }

            
            {
                this$0 = DeregisterRequest.this;
                super();
            }
                            };
                            accountcredentials = registrar.getAccountCredentialsFromTokenAndKey(mDirectedId, overridingDSNChildDevicePackageName);
                        }

                    }
                }
                if (mDeregisterAllOnAccountRemoval)
                {
                    String s2;
                    for (Iterator iterator = mAmazonAccountManager.getSecondaryAmazonAccounts().iterator(); iterator.hasNext(); mMapAcctMan.deregisterAccount(s2, null))
                    {
                        s2 = (String)iterator.next();
                    }

                }
                mDataStorage.removeAccount(mDirectedId);
                platformmetricstimer.stop();
            }
            onRequestComplete(flag);
        }

        public void setConnectionFactory(ConnectionFactory connectionfactory)
        {
            this;
            JVM INSTR monitorenter ;
            mConnectionFactory = connectionfactory;
            this;
            JVM INSTR monitorexit ;
            return;
            connectionfactory;
            throw connectionfactory;
        }

        public void setResponseListener(ResponseListener responselistener)
        {
            this;
            JVM INSTR monitorenter ;
            mResponseListener = responselistener;
            this;
            JVM INSTR monitorexit ;
            return;
            responselistener;
            throw responselistener;
        }




        public DeregisterRequest(Context context, String s, Collection collection, AccountRegistrarAuthenticator accountregistrarauthenticator, AccountCredentials accountcredentials, Tracer tracer)
        {
            mContext = context;
            mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
            mMapAcctMan = new MAPAccountManager(mContext);
            mAmazonAccountManager = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
            mDataStorage = ((DataStorageFactory)mContext.getSystemService("dcp_data_storage_factory")).getDataStorage();
            mSubAuths = new ArrayList(collection);
            mDirectedId = s;
            mRegistrarAuthenticator = accountregistrarauthenticator;
            mDeregisterAllOnAccountRemoval = MultipleAccountPluginHolder.getMultipleAccountPlugin(mContext).deregisterAllAccountsOnAccountRemoval(s);
            mAccountCredentials = accountcredentials;
            mTracer = tracer;
        }
    }

    public static interface IDeregisterAccount
    {

        public abstract void onResult(Bundle bundle);
    }

    public static interface ResponseListener
    {

        public abstract void onRequestComplete(boolean flag);
    }

    private static class SynchronousAccountRegistrarDeregistration extends AsyncToSyncAdapter
        implements AccountRegistrar.Listener
    {

        private final AccountCredentials mAccountCredentials;
        private final Context mContext;
        private final boolean mDeregisterAllAccounts;
        private final String mDirectedId;
        private final AccountRegistrar mRegistrar;
        private final AccountRegistrarAuthenticator mRegistrarAuthenticator;
        private AtomicBoolean mSuccess;
        private final Tracer mTracer;

        public void accountAlreadyExists(String s)
        {
            failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError.ACCOUNT_ALREADY_EXISTS, null);
        }

        public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle)
        {
            String _tmp = DeregisterAccount.TAG;
            SSOMetrics.deregistrationRequestFailure(registrationerror);
            setSuccess(false);
            asyncOperationComplete();
        }

        public boolean getSuccess()
        {
            return mSuccess.get();
        }

        public void setSuccess(boolean flag)
        {
            mSuccess.set(flag);
        }

        protected void startAsyncOperation()
        {
            mRegistrar.deregister(this, mContext.getPackageName(), mDirectedId, mAccountCredentials, mDeregisterAllAccounts, mRegistrarAuthenticator, mTracer);
        }

        public void success(String s, String s1, Bundle bundle)
        {
            String _tmp = DeregisterAccount.TAG;
            setSuccess(true);
            asyncOperationComplete();
        }

        public SynchronousAccountRegistrarDeregistration(Context context, String s, boolean flag, AccountRegistrar accountregistrar, AccountRegistrarAuthenticator accountregistrarauthenticator, AccountCredentials accountcredentials, Tracer tracer)
        {
            mSuccess = new AtomicBoolean(false);
            mContext = context;
            mDirectedId = s;
            mDeregisterAllAccounts = flag;
            mRegistrar = accountregistrar;
            mRegistrarAuthenticator = accountregistrarauthenticator;
            mAccountCredentials = accountcredentials;
            mTracer = tracer;
        }
    }

    private static class SynchronousSubAuthConnector extends AsyncToSyncAdapter
        implements SubAuthenticatorConnection.ISubAuthenticatorConnectionCallback
    {

        private AtomicBoolean mConnected;
        private final SubAuthenticatorConnection mConnection;

        private void setConnected(boolean flag)
        {
            mConnected.set(flag);
        }

        public boolean getConnected()
        {
            return mConnected.get();
        }

        public SubAuthenticatorConnection getConnection()
        {
            return mConnection;
        }

        public void onConnected$33345943()
        {
            setConnected(true);
            asyncOperationComplete();
        }

        public void onConnectionTimeout(SubAuthenticatorConnection subauthenticatorconnection)
        {
            MAPLog.e(DeregisterAccount.TAG, (new StringBuilder("SubAuth Connection timeout: ")).append(subauthenticatorconnection.getPackageName()).toString());
            setConnected(false);
            asyncOperationComplete();
        }

        public void onDisconnected(SubAuthenticatorConnection subauthenticatorconnection)
        {
            MAPLog.i(DeregisterAccount.TAG, (new StringBuilder("SubAuth Disconnected: ")).append(subauthenticatorconnection.getPackageName()).toString());
            setConnected(false);
        }

        protected void startAsyncOperation()
        {
            if (!mConnection.openConnection(this))
            {
                MAPLog.e(DeregisterAccount.TAG, (new StringBuilder("Error binding to service: ")).append(mConnection.getPackageName()).toString());
                setConnected(false);
                asyncOperationComplete();
            }
        }

        public SynchronousSubAuthConnector(SubAuthenticatorConnection subauthenticatorconnection)
        {
            mConnected = new AtomicBoolean(false);
            mConnection = subauthenticatorconnection;
        }
    }

    private static class SynchronousSubAuthDeregistration extends AsyncToSyncAdapter
        implements SubAuthenticatorConnection.IDeregisterConnectionCallback
    {

        private final Account mAccount;
        private final SubAuthenticatorConnection mConnection;
        private AtomicBoolean mSuccess;
        private final Object mSyncObj[] = new Object[0];

        private void setSuccess(boolean flag)
        {
            mSuccess.set(flag);
        }

        public void error$1a7fe030(int i, String s)
        {
            synchronized (mSyncObj)
            {
                MAPLog.e(DeregisterAccount.TAG, String.format("SubAuth Deregister Error: Package=%s, errorCode=%d, msg=%s", new Object[] {
                    mConnection.getPackageName(), Integer.valueOf(i), s
                }));
                setSuccess(false);
                asyncOperationComplete();
            }
        }

        public boolean getSuccess()
        {
            return mSuccess.get();
        }

        public void onTimeout()
        {
            synchronized (mSyncObj)
            {
                MAPLog.e(DeregisterAccount.TAG, String.format("SubAuth Deregister Timeout: Package=%s", new Object[] {
                    mConnection.getPackageName()
                }));
                setSuccess(false);
                asyncOperationComplete();
            }
        }

        protected void startAsyncOperation()
        {
            DeregisterAccount.THREAD_POOL.execute(new Runnable() {

                final SynchronousSubAuthDeregistration this$0;

                public void run()
                {
                    mConnection.deregister(mAccount, SynchronousSubAuthDeregistration.this);
                }

            
            {
                this$0 = SynchronousSubAuthDeregistration.this;
                super();
            }
            });
        }

        public void success$44f542f7()
        {
            synchronized (mSyncObj)
            {
                MAPLog.i(DeregisterAccount.TAG, String.format("SubAuth Deregister Success: Package=%s,", new Object[] {
                    mConnection.getPackageName()
                }));
                setSuccess(true);
                asyncOperationComplete();
            }
        }



        public SynchronousSubAuthDeregistration(SubAuthenticatorConnection subauthenticatorconnection, Account account)
        {
            mSuccess = new AtomicBoolean(false);
            mConnection = subauthenticatorconnection;
            mAccount = account;
        }
    }


    private static final String TAG = com/amazon/identity/auth/accounts/DeregisterAccount.getName();
    private static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(10, ThreadUtils.getNamedThreadFactory("MAP-DeregisterThreadPool"));
    private final AmazonAccountManager mAmznAcctMan;
    private final ConnectionFactory mConnectionFactory = new ConnectionFactory() {

        final DeregisterAccount this$0;

        public AccountRegistrar createAccountRegistrar()
        {
            return DeregisterAccount.this.createAccountRegistrar();
        }

        public SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription)
        {
            return DeregisterAccount.this.createSubAuthConnection(subauthenticatordescription);
        }

            
            {
                this$0 = DeregisterAccount.this;
                super();
            }
    };
    private final Context mContext;
    private final MultipleAccountsLogic mMultipleAccountLogic;
    private final AccountRegistrarAuthenticator mRegistrarAuthenticator;

    public DeregisterAccount(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mRegistrarAuthenticator = new AccountRegistrarAuthenticator(mContext);
        mAmznAcctMan = (AmazonAccountManager)mContext.getSystemService("dcp_amazon_account_man");
        mMultipleAccountLogic = MultipleAccountsLogic.getInstance(mContext);
    }

    public static boolean haveWeNotifiedServerOfDeregister(AmazonAccountManager amazonaccountmanager, String s)
    {
        return amazonaccountmanager.getUserData(s, "has.notified.server.of.deregister") != null;
    }

    public static void setHasDeregisteredAccount(AmazonAccountManager amazonaccountmanager, String s)
    {
        amazonaccountmanager.setUserData(s, "has.notified.server.of.deregister", "true");
    }

    protected AccountRegistrar createAccountRegistrar()
    {
        return new AccountRegistrar(mContext);
    }

    protected SubAuthenticatorConnection createSubAuthConnection(SubAuthenticatorDescription subauthenticatordescription)
    {
        return new SubAuthenticatorConnection(subauthenticatordescription, mContext);
    }

    public void startDeregister(List list, final IDeregisterAccount response, String s, Tracer tracer)
    {
        MAPLog.i(TAG, "Starting deregister request");
        AccountCredentials accountcredentials = mConnectionFactory.createAccountRegistrar().getAccountCredentialsFromTokenAndKey(s, mContext.getPackageName());
        mAmznAcctMan.setAccountRegistrationStatus(s, AmazonAccountManager.AccountRegistrationStatus.Deregistering);
        mMultipleAccountLogic.onDeregister(s);
        list = new DeregisterRequest(mContext, s, list, mRegistrarAuthenticator, accountcredentials, tracer);
        list.setResponseListener(new ResponseListener() {

            final DeregisterAccount this$0;
            final IDeregisterAccount val$response;

            public void onRequestComplete(boolean flag)
            {
                Bundle bundle = new Bundle();
                bundle.putBoolean("booleanResult", flag);
                response.onResult(bundle);
            }

            
            {
                this$0 = DeregisterAccount.this;
                response = ideregisteraccount;
                super();
            }
        });
        list.setConnectionFactory(mConnectionFactory);
        THREAD_POOL.execute(list);
    }



}
