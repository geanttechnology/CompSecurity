// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.credentials.AccountCredentials;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.metrics.SSOMetrics;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.DataStorageFactory;
import com.amazon.identity.auth.device.utils.ArrayUtil;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, AmazonAccountManager, MultipleAccountPluginHolder, MultipleAccountPlugin, 
//            SubAuthenticatorDescription, SubAuthenticatorConnection, ChildApplicationOverrideDSNHelper, AccountRegistrar, 
//            AccountRegistrarAuthenticator

private static class mTracer
    implements Runnable
{

    private final AmazonAccountManager mAmazonAccountManager;
    private mResponseListener mConnectionFactory;
    private final Context mContext;
    private final DataStorage mDataStorage;
    private final boolean mDeregisterAllOnAccountRemoval;
    private final String mDirectedId;
    private final MAPAccountManager mMapAcctMan;
    private final PlatformWrapper mPlatform;
    private final AccountRegistrarAuthenticator mRegistrarAuthenticator;
    private mResponseListener mResponseListener;
    private final ArrayList mSubAuths;
    private final Tracer mTracer;

    private boolean notifySubAuthsAccountRemoved()
    {
        Account account = BackwardsCompatiabilityHelper.getAccountWithDirectedId(mContext, mDirectedId);
        if (account != null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        MAPLog.e(DeregisterAccount.access$000(), "Sub authenticators are not supported on 3rd party devices yet");
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
            obj = new Connector(getConnectionFactory().createSubAuthConnection(subauthenticatordescription));
            ((Connector) (obj)).run();
            if (!((Connector) (obj)).getConnected())
            {
                MAPLog.e(DeregisterAccount.access$000(), (new StringBuilder("Failed to establish SubAuthenticator Connection: ")).append(subauthenticatordescription.packageName).toString());
                obj = null;
            } else
            {
                obj = ((Connector) (obj)).getConnection();
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

    public ection getConnectionFactory()
    {
        this;
        JVM INSTR monitorenter ;
        ection ection;
        if (mConnectionFactory == null)
        {
            mConnectionFactory = new actory(mContext);
        }
        ection = mConnectionFactory;
        this;
        JVM INSTR monitorexit ;
        return ection;
        Exception exception;
        exception;
        throw exception;
    }

    public mConnectionFactory getResponseListener()
    {
        this;
        JVM INSTR monitorenter ;
        mConnectionFactory mconnectionfactory = mResponseListener;
        this;
        JVM INSTR monitorexit ;
        return mconnectionfactory;
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
        MAPLog.i(DeregisterAccount.access$000(), (new StringBuilder("Notifying subauth: ")).append(subauthenticatorconnection.getPackageName()).toString());
        account = new Deregistration(subauthenticatorconnection, account);
        subauthenticatorconnection = SSOMetrics.getDeregistrationSubAuthTimer(subauthenticatorconnection.getPackageName());
        subauthenticatorconnection.start();
        account.run(Long.valueOf(7L), TimeUnit.SECONDS, "NotifySubAuthAccountRemoval");
        subauthenticatorconnection.stop();
        return account.getSuccess();
    }

    public void onRequestComplete(boolean flag)
    {
        Deregistration.getSuccess getsuccess = getResponseListener();
        if (getsuccess != null)
        {
            getsuccess.nRequestComplete(flag);
        }
    }

    public void run()
    {
        boolean flag1 = true;
        boolean flag;
        if (!isRegistered(mDirectedId))
        {
            SSOMetrics.deregistrationRequestFailure(com.amazon.identity.auth.device.api.ALREADY_DEREGISTERED);
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
                DeregisterAccount.access$000();
                String s = mDirectedId;
            } else
            {
                Object obj1 = getConnectionFactory().createAccountRegistrar();
                obj1 = new RegistrarDeregistration(mContext, mDirectedId, mDeregisterAllOnAccountRemoval, ((AccountRegistrar) (obj1)), mRegistrarAuthenticator, mTracer);
                ((RegistrarDeregistration) (obj1)).run();
                flag1 = ((RegistrarDeregistration) (obj1)).getSuccess();
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
                    MAPLog.e(DeregisterAccount.access$000(), "Deregister was not successful. Not marking accounts that they were deregistered on the server");
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
                    final r emptyListener;
                    final AccountCredentials creds;
                    for (obj = ((Collection) (obj)).iterator(); ((Iterator) (obj)).hasNext(); DeregisterAccount.access$400().execute(new Runnable() {

        final DeregisterAccount.DeregisterRequest this$0;
        final AccountCredentials val$creds;
        final AccountRegistrar.Listener val$emptyListener;
        final String val$overridingDSNChildDevicePackageName;
        final AccountRegistrar val$registrar;

        public void run()
        {
            registrar.deregister(emptyListener, overridingDSNChildDevicePackageName, mDirectedId, creds, true, mRegistrarAuthenticator, mTracer);
        }

            
            {
                this$0 = DeregisterAccount.DeregisterRequest.this;
                registrar = accountregistrar;
                emptyListener = listener;
                overridingDSNChildDevicePackageName = s;
                creds = accountcredentials;
                super();
            }
    }))
                    {
                        overridingDSNChildDevicePackageName = (String)((Iterator) (obj)).next();
                        registrar = getConnectionFactory().createAccountRegistrar();
                        emptyListener = new AccountRegistrar.Listener() {

                            final DeregisterAccount.DeregisterRequest this$0;

                            public void accountAlreadyExists(String s3)
                            {
                                MAPLog.e(DeregisterAccount.access$000(), String.format("Deregister Failure for Overriding DSN Child Device Type due to registration already existing.  This should not happen. DirectedId: %s", new Object[] {
                                    s3
                                }));
                            }

                            public void failure(com.amazon.identity.auth.device.api.MAPAccountManager.RegistrationError registrationerror, Bundle bundle)
                            {
                                MAPLog.e(DeregisterAccount.access$000(), String.format("Deregister Failure for Overriding DSN Child Device Type: %s", new Object[] {
                                    registrationerror.name()
                                }));
                            }

                            public void success(String s3, String s4, Bundle bundle)
                            {
                                DeregisterAccount.access$000();
                                String.format("Deregister Succeeded for Overriding DSN Child Device Type. directedId %s", new Object[] {
                                    s3
                                });
                            }

            
            {
                this$0 = DeregisterAccount.DeregisterRequest.this;
                super();
            }
                        };
                        creds = registrar.getAccountCredentialsFromTokenAndKey(mDirectedId, overridingDSNChildDevicePackageName);
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

    public void setConnectionFactory(onRequestComplete onrequestcomplete)
    {
        this;
        JVM INSTR monitorenter ;
        mConnectionFactory = onrequestcomplete;
        this;
        JVM INSTR monitorexit ;
        return;
        onrequestcomplete;
        throw onrequestcomplete;
    }

    public void setResponseListener(mConnectionFactory mconnectionfactory)
    {
        this;
        JVM INSTR monitorenter ;
        mResponseListener = mconnectionfactory;
        this;
        JVM INSTR monitorexit ;
        return;
        mconnectionfactory;
        throw mconnectionfactory;
    }




    public _cls2.val.creds(Context context, String s, Collection collection, AccountRegistrarAuthenticator accountregistrarauthenticator, Tracer tracer)
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
        mTracer = tracer;
    }
}
