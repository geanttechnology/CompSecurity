// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.amazon.dcp.sso.ISubAuthenticator;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ResourceHelper;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            SubAuthenticatorDescription

public class SubAuthenticatorConnection
{
    private static final class CurrentState extends Enum
    {

        private static final CurrentState $VALUES[];
        public static final CurrentState Binding;
        public static final CurrentState Bound;
        public static final CurrentState Unbound;

        public static CurrentState valueOf(String s)
        {
            return (CurrentState)Enum.valueOf(com/amazon/identity/auth/accounts/SubAuthenticatorConnection$CurrentState, s);
        }

        public static CurrentState[] values()
        {
            return (CurrentState[])$VALUES.clone();
        }

        static 
        {
            Unbound = new CurrentState("Unbound", 0);
            Binding = new CurrentState("Binding", 1);
            Bound = new CurrentState("Bound", 2);
            $VALUES = (new CurrentState[] {
                Unbound, Binding, Bound
            });
        }

        private CurrentState(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface IDeregisterConnectionCallback
    {

        public abstract void error(SubAuthenticatorConnection subauthenticatorconnection, int i, String s);

        public abstract void success(SubAuthenticatorConnection subauthenticatorconnection, Bundle bundle);
    }

    public static interface ISubAuthenticatorConnectionCallback
    {

        public abstract void onConnected(SubAuthenticatorConnection subauthenticatorconnection);

        public abstract void onConnectionTimeout(SubAuthenticatorConnection subauthenticatorconnection);

        public abstract void onDisconnected(SubAuthenticatorConnection subauthenticatorconnection);
    }


    private static final long CONNECTION_TIMEOUT;
    private static final String TAG = com/amazon/identity/auth/accounts/SubAuthenticatorConnection.getName();
    private final Context mAppContext;
    private ISubAuthenticatorConnectionCallback mCallback;
    private ServiceConnection mConnection;
    private CurrentState mCurrentState;
    private Object mLocker;
    private ISubAuthenticator mService;
    private boolean mServiceConnectionWasEstablished;
    private final SubAuthenticatorDescription mSubAuthDesc;

    public SubAuthenticatorConnection(SubAuthenticatorDescription subauthenticatordescription, Context context)
    {
        mConnection = new ServiceConnection() {

            final SubAuthenticatorConnection this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                mServiceConnectionWasEstablished = true;
                synchronized (mLocker)
                {
                    mCurrentState = CurrentState.Bound;
                    mService = com.amazon.dcp.sso.ISubAuthenticator.Stub.asInterface(ibinder);
                    ibinder = mCallback;
                    MAPLog.i(SubAuthenticatorConnection.TAG, String.format("Connected to SubAuthenticator in package %s.", new Object[] {
                        mSubAuthDesc.packageName
                    }));
                }
                if (ibinder != null)
                {
                    ibinder.onConnected(SubAuthenticatorConnection.this);
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mConnection = null;
                ISubAuthenticatorConnectionCallback isubauthenticatorconnectioncallback;
                synchronized (mLocker)
                {
                    mCurrentState = CurrentState.Unbound;
                    isubauthenticatorconnectioncallback = mCallback;
                    mService = null;
                    MAPLog.i(SubAuthenticatorConnection.TAG, String.format("Disconnected from SubAuthenticator in package %s.", new Object[] {
                        mSubAuthDesc.packageName
                    }));
                }
                if (isubauthenticatorconnectioncallback != null)
                {
                    isubauthenticatorconnectioncallback.onDisconnected(SubAuthenticatorConnection.this);
                }
            }

            
            {
                this$0 = SubAuthenticatorConnection.this;
                super();
            }
        };
        mLocker = ((Object) (new Object[0]));
        if (subauthenticatordescription == null)
        {
            throw new IllegalArgumentException("SubAuthenticatorDescription cannot be null");
        }
        if (context == null)
        {
            throw new IllegalArgumentException("Context cannot be null");
        } else
        {
            mSubAuthDesc = subauthenticatordescription;
            mAppContext = context;
            mCurrentState = CurrentState.Unbound;
            mServiceConnectionWasEstablished = false;
            return;
        }
    }

    private void callFailureCallback(IDeregisterConnectionCallback ideregisterconnectioncallback)
    {
        if (ideregisterconnectioncallback == null)
        {
            return;
        } else
        {
            ideregisterconnectioncallback.error(this, -1, String.format(ResourceHelper.getString(mAppContext, "ErrorConnectingToSubAuth"), new Object[] {
                mSubAuthDesc.packageName
            }));
            return;
        }
    }

    private boolean safeBind$5b75c20b(Intent intent, ServiceConnection serviceconnection)
    {
        boolean flag;
        try
        {
            flag = mAppContext.bindService(intent, serviceconnection, 5);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            MAPLog.e(TAG, String.format("Unable to talk to package %s because of SecurityException", new Object[] {
                getPackageName()
            }), intent);
            return false;
        }
        return flag;
    }

    public void closeConnection()
    {
label0:
        {
            ServiceConnection serviceconnection;
            synchronized (mLocker)
            {
                if (mCurrentState == CurrentState.Bound)
                {
                    break label0;
                }
                MAPLog.e(TAG, "Cannot close the connection because it was not connected");
            }
            return;
        }
        serviceconnection = mConnection;
        if (serviceconnection == null) goto _L2; else goto _L1
_L1:
        mAppContext.unbindService(mConnection);
_L3:
        mConnection = null;
_L2:
        mCurrentState = CurrentState.Unbound;
        obj;
        JVM INSTR monitorexit ;
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        MAPLog.w(TAG, String.format("IllegalArgumentException is received during unbinding from %s. Ignored.", new Object[] {
            mSubAuthDesc.packageName
        }));
          goto _L3
    }

    public void deregister(Account account, final IDeregisterConnectionCallback deregisterCallback)
    {
        CurrentState currentstate;
        synchronized (mLocker)
        {
            currentstate = mCurrentState;
        }
        if (currentstate != CurrentState.Bound)
        {
            MAPLog.e(TAG, "Cannot deregister the Sub Authenticator until the connection has been opened");
            deregisterCallback.error(this, 8, "In bad state. Cannot deregister");
            return;
        }
        com.amazon.dcp.sso.ISubAuthenticatorResponse.Stub stub = new com.amazon.dcp.sso.ISubAuthenticatorResponse.Stub() {

            final SubAuthenticatorConnection this$0;
            final IDeregisterConnectionCallback val$deregisterCallback;

            public void onError(int i, String s)
            {
                if (deregisterCallback != null)
                {
                    deregisterCallback.error(SubAuthenticatorConnection.this, i, s);
                }
            }

            public void onResult(Bundle bundle)
            {
                if (deregisterCallback != null)
                {
                    deregisterCallback.success(SubAuthenticatorConnection.this, bundle);
                }
            }

            
            {
                this$0 = SubAuthenticatorConnection.this;
                deregisterCallback = ideregisterconnectioncallback;
                super();
            }
        };
        try
        {
            MAPLog.i(TAG, (new StringBuilder("Calling ")).append(mSubAuthDesc.packageName).append(" to start deregistration").toString());
            mService.getAccountRemovalAllowed(stub, account.type, account.name);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Account account)
        {
            MAPLog.e(TAG, (new StringBuilder()).append(mSubAuthDesc.packageName).append(" caused the following exception in it's getAccountRemovalAllowed implementation").toString(), account);
            callFailureCallback(deregisterCallback);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Account account)
        {
            callFailureCallback(deregisterCallback);
        }
    }

    public String getPackageName()
    {
        return mSubAuthDesc.packageName;
    }

    public SubAuthenticatorDescription getSubAuthenticatorDescription()
    {
        return mSubAuthDesc;
    }

    public boolean openConnection(ISubAuthenticatorConnectionCallback isubauthenticatorconnectioncallback)
    {
label0:
        {
            if (isubauthenticatorconnectioncallback == null)
            {
                throw new IllegalArgumentException("Callback parameter cannot be null.");
            }
            synchronized (mLocker)
            {
                if (mCurrentState != CurrentState.Unbound)
                {
                    throw new IllegalStateException("Cannot open a connection to the service because we are currently connecting or have already connected to the service.");
                }
                break label0;
            }
        }
        boolean flag;
        if (mConnection == null)
        {
            throw new IllegalStateException("Attempted to reuse a SubAuthenticatorConnection.  openConnection can only be executed once.");
        }
        mCurrentState = CurrentState.Binding;
        mCallback = isubauthenticatorconnectioncallback;
        isubauthenticatorconnectioncallback = new Intent("com.amazon.dcp.sso.AccountSubAuthenticator");
        isubauthenticatorconnectioncallback.setComponent(mSubAuthDesc.getComponentName());
        flag = safeBind$5b75c20b(isubauthenticatorconnectioncallback, mConnection);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        mCurrentState = CurrentState.Unbound;
        MAPLog.e(TAG, String.format("Application tried to bind to SubAuthenticator Service %s and failed.", new Object[] {
            mSubAuthDesc.packageName
        }));
        obj;
        JVM INSTR monitorexit ;
        return false;
        (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {

            final SubAuthenticatorConnection this$0;

            public void run()
            {
                if (mServiceConnectionWasEstablished)
                {
                    return;
                } else
                {
                    MAPLog.e(SubAuthenticatorConnection.TAG, String.format("Application tried to bind to SubAuthenticator Service %s timed out.", new Object[] {
                        mSubAuthDesc.packageName
                    }));
                    mCallback.onConnectionTimeout(SubAuthenticatorConnection.this);
                    closeConnection();
                    return;
                }
            }

            
            {
                this$0 = SubAuthenticatorConnection.this;
                super();
            }
        }, CONNECTION_TIMEOUT);
        obj;
        JVM INSTR monitorexit ;
        return flag;
    }

    static 
    {
        CONNECTION_TIMEOUT = TimeUnit.MILLISECONDS.convert(3L, TimeUnit.SECONDS);
    }



/*
    static boolean access$002(SubAuthenticatorConnection subauthenticatorconnection, boolean flag)
    {
        subauthenticatorconnection.mServiceConnectionWasEstablished = flag;
        return flag;
    }

*/



/*
    static CurrentState access$202(SubAuthenticatorConnection subauthenticatorconnection, CurrentState currentstate)
    {
        subauthenticatorconnection.mCurrentState = currentstate;
        return currentstate;
    }

*/


/*
    static ISubAuthenticator access$302(SubAuthenticatorConnection subauthenticatorconnection, ISubAuthenticator isubauthenticator)
    {
        subauthenticatorconnection.mService = isubauthenticator;
        return isubauthenticator;
    }

*/





/*
    static ServiceConnection access$702(SubAuthenticatorConnection subauthenticatorconnection, ServiceConnection serviceconnection)
    {
        subauthenticatorconnection.mConnection = serviceconnection;
        return serviceconnection;
    }

*/
}
