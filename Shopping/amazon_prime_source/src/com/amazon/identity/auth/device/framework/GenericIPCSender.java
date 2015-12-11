// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseIntArray;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.IGenericIPC;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;
import com.amazon.identity.auth.device.utils.DBUtils;
import com.amazon.identity.auth.device.utils.MAPArgContracts;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ParcelUtils;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            SecureContentResolver, RemoteMAPException, BoundServiceManager, ContentProviderClientCallback

public class GenericIPCSender
{
    private final class ErrorCodeMapperCallback
        implements Callback
    {

        String mFirstCallbackMethod;
        final Callback mInnerCallback;
        final GenericIPCSender this$0;

        private boolean claimCallback(String s)
        {
            this;
            JVM INSTR monitorenter ;
            if (mFirstCallbackMethod == null) goto _L2; else goto _L1
_L1:
            MAPLog.w(GenericIPCSender.TAG, (new StringBuilder("Duplicate callback detected: ")).append(s).append(" called after ").append(mFirstCallbackMethod).toString());
            boolean flag = false;
_L4:
            this;
            JVM INSTR monitorexit ;
            return flag;
_L2:
            mFirstCallbackMethod = s;
            flag = true;
            if (true) goto _L4; else goto _L3
_L3:
            s;
            throw s;
        }

        public void onError(Bundle bundle)
        {
            while (!claimCallback("onError") || mInnerCallback == null) 
            {
                return;
            }
            mInnerCallback.onError(mapErrorKeysInBundle(bundle));
        }

        public void onSuccess(Bundle bundle)
        {
            while (!claimCallback("onSuccess") || mInnerCallback == null) 
            {
                return;
            }
            mInnerCallback.onSuccess(bundle);
        }

        private ErrorCodeMapperCallback(Callback callback)
        {
            this$0 = GenericIPCSender.this;
            super();
            mInnerCallback = callback;
        }

        ErrorCodeMapperCallback(Callback callback, byte byte0)
        {
            this(callback);
        }
    }

    private static final class GenericIPCServiceCallback extends BoundServiceManager.BoundServiceCallback
        implements Callback
    {

        private boolean mAlreadyCalledBack;
        private final BoundServiceManager mBoundServiceManager;
        private final Callback mCallback;
        private final Class mIpcCommandClass;
        private final Bundle mParameters;

        public void onError()
        {
            onError(GenericIPCSender.getIpcErrorBundle$4cf0af3c("Got an error while calling Generic IPC central store."));
        }

        public void onError(Bundle bundle)
        {
            this;
            JVM INSTR monitorenter ;
            if (!mAlreadyCalledBack)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            mAlreadyCalledBack = true;
            this;
            JVM INSTR monitorexit ;
            mBoundServiceManager.doneUsingService(this);
            mCallback.onError(bundle);
            return;
            bundle;
            this;
            JVM INSTR monitorexit ;
            throw bundle;
        }

        public void onSuccess(Bundle bundle)
        {
            this;
            JVM INSTR monitorenter ;
            if (!mAlreadyCalledBack)
            {
                break MISSING_BLOCK_LABEL_12;
            }
            this;
            JVM INSTR monitorexit ;
            return;
            mAlreadyCalledBack = true;
            this;
            JVM INSTR monitorexit ;
            mBoundServiceManager.doneUsingService(this);
            mCallback.onSuccess(bundle);
            return;
            bundle;
            this;
            JVM INSTR monitorexit ;
            throw bundle;
        }

        public void useService(IGenericIPC igenericipc)
            throws RemoteException
        {
            com.amazon.identity.auth.device.callback.IRemoteCallback iremotecallback = RemoteCallbackWrapper.toRemoteCallback(this);
            mBoundServiceManager.startUsingServiceAsynchronously(this);
            igenericipc.call(mIpcCommandClass.getName(), mParameters, iremotecallback);
        }

        public volatile void useService(Object obj)
            throws RemoteException
        {
            useService((IGenericIPC)obj);
        }

        private GenericIPCServiceCallback(Callback callback, Bundle bundle, Class class1, BoundServiceManager boundservicemanager)
        {
            mCallback = callback;
            mParameters = bundle;
            mIpcCommandClass = class1;
            mBoundServiceManager = boundservicemanager;
            mAlreadyCalledBack = false;
        }

        GenericIPCServiceCallback(Callback callback, Bundle bundle, Class class1, BoundServiceManager boundservicemanager, byte byte0)
        {
            this(callback, bundle, class1, boundservicemanager);
        }
    }

    private static final class SimpleCallbackFuture
        implements Callback
    {

        private final CountDownLatch mLatch;
        private Bundle mResult;

        private void setResult(Bundle bundle)
        {
            mResult = bundle;
            mLatch.countDown();
        }

        public Bundle get$17a408ed(TimeUnit timeunit)
            throws InterruptedException, TimeoutException
        {
            if (mLatch.await(500L, timeunit))
            {
                return mResult;
            } else
            {
                throw new TimeoutException();
            }
        }

        public void onError(Bundle bundle)
        {
            setResult(bundle);
        }

        public void onSuccess(Bundle bundle)
        {
            setResult(bundle);
        }

        private SimpleCallbackFuture()
        {
            mLatch = new CountDownLatch(1);
        }

        SimpleCallbackFuture(byte byte0)
        {
            this();
        }
    }


    private static final String COLUMNS[] = {
        "bundle_value"
    };
    public static final Uri GENERIC_IPC_URI = Uri.parse("content://com.amazon.map.generic_ipc");
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/framework/GenericIPCSender.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/framework/GenericIPCSender.getName();
    private static BoundServiceManager sGenericIpcManager;
    private final BoundServiceManager mBoundServiceManager;
    private final String mErrorCodeKey;
    private final SparseIntArray mErrorCodeMap;
    private final String mErrorMessageKey;
    private final SecureContentResolver mSecureContentResolver;

    public GenericIPCSender(Context context, String s, String s1, Integer integer)
    {
        this(s, s1, integer, new SecureContentResolver(context), getGenericIpcManager(context));
    }

    public GenericIPCSender(String s, String s1, Integer integer, SecureContentResolver securecontentresolver, BoundServiceManager boundservicemanager)
    {
        mSecureContentResolver = securecontentresolver;
        mBoundServiceManager = boundservicemanager;
        mErrorCodeKey = s;
        mErrorMessageKey = s1;
        mErrorCodeMap = new SparseIntArray();
        if (integer != null)
        {
            mErrorCodeMap.put(500, integer.intValue());
        }
    }

    private static BoundServiceManager getGenericIpcManager(Context context)
    {
        com/amazon/identity/auth/device/framework/GenericIPCSender;
        JVM INSTR monitorenter ;
        if (sGenericIpcManager == null) goto _L2; else goto _L1
_L1:
        context = sGenericIpcManager;
_L4:
        com/amazon/identity/auth/device/framework/GenericIPCSender;
        JVM INSTR monitorexit ;
        return context;
_L2:
        BoundServiceManager boundservicemanager = new BoundServiceManager(context, "com.amazon.identity.framework.GenericIPCService", ThreadUtils.MAP_COMMON_THREAD_POOL) {

            protected IGenericIPC asInterface(IBinder ibinder)
            {
                return com.amazon.identity.auth.device.callback.IGenericIPC.Stub.asInterface(ibinder);
            }

            protected volatile Object asInterface(IBinder ibinder)
            {
                return asInterface(ibinder);
            }

        };
        context = boundservicemanager;
        if (UnitTestUtils.isRunningInUnitTest())
        {
            continue; /* Loop/switch isn't completed */
        }
        sGenericIpcManager = boundservicemanager;
        context = boundservicemanager;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public static Bundle getIpcErrorBundle$4cf0af3c(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("ipc_error_code_key", 500);
        bundle.putString("ipc_error_code_message", s);
        return bundle;
    }

    private Bundle mapErrorKeysInBundle(Bundle bundle)
    {
        Bundle bundle1;
        if (bundle == null)
        {
            bundle1 = null;
        } else
        {
            bundle1 = bundle;
            if (mErrorCodeKey != null)
            {
                bundle1 = bundle;
                if (bundle.containsKey("ipc_error_code_key"))
                {
                    int i = bundle.getInt("ipc_error_code_key");
                    bundle.putInt(mErrorCodeKey, mErrorCodeMap.get(i, i));
                    bundle.remove("ipc_error_code_key");
                    String s = bundle.getString("ipc_error_code_message");
                    bundle.putString(mErrorMessageKey, s);
                    bundle.remove("ipc_error_code_message");
                    return bundle;
                }
            }
        }
        return bundle1;
    }

    private Bundle queryCentralStore(final Bundle command)
    {
        command = ParcelUtils.bundleToString(command);
        try
        {
            command = (Bundle)mSecureContentResolver.acquireContentProviderClient(GENERIC_IPC_URI, new ContentProviderClientCallback() {

                final GenericIPCSender this$0;
                final String val$command;

                public Bundle useContentProviderClient(ContentProviderClient contentproviderclient)
                    throws RemoteException
                {
                    contentproviderclient = contentproviderclient.query(GenericIPCSender.GENERIC_IPC_URI, GenericIPCSender.COLUMNS, command, null, null);
                    if (contentproviderclient != null)
                    {
                        break MISSING_BLOCK_LABEL_44;
                    }
                    throw new RuntimeException("Got a null cursor calling Generic IPC central store.");
                    Exception exception;
                    exception;
                    if (contentproviderclient != null)
                    {
                        contentproviderclient.close();
                    }
                    throw exception;
                    Bundle bundle;
                    if (!contentproviderclient.moveToFirst())
                    {
                        throw new RuntimeException("Got an empty cursor calling Generic IPC central store.");
                    }
                    bundle = ParcelUtils.stringToBundle(DBUtils.getString(contentproviderclient, "bundle_value"));
                    if (bundle != null)
                    {
                        break MISSING_BLOCK_LABEL_87;
                    }
                    throw new RuntimeException("Corrupted value returned.");
                    if (contentproviderclient != null)
                    {
                        contentproviderclient.close();
                    }
                    return bundle;
                }

                public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                    throws Exception
                {
                    return useContentProviderClient(contentproviderclient);
                }

            
            {
                this$0 = GenericIPCSender.this;
                command = s;
                super();
            }
            });
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle command)
        {
            MAPLog.e(TAG, "Got an error while calling Generic IPC central store. This can happen in certain edge cases around a crash.", command);
            return getIpcErrorBundle$4cf0af3c("Got an error while calling Generic IPC central store.");
        }
        return command;
    }

    public Bundle call(Class class1, Bundle bundle)
    {
        Bundle bundle2;
        PlatformMetricsTimer platformmetricstimer;
        MAPArgContracts.throwIfNull(class1, "ipcCommandClass");
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, class1.getSimpleName());
        bundle2 = null;
        SimpleCallbackFuture simplecallbackfuture;
        boolean flag;
        simplecallbackfuture = new SimpleCallbackFuture((byte)0);
        flag = mBoundServiceManager.useServiceIfAlreadyBound(new GenericIPCServiceCallback(simplecallbackfuture, bundle, class1, mBoundServiceManager, (byte)0));
        Bundle bundle1;
        bundle1 = bundle2;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        bundle1 = simplecallbackfuture._mth17a408ed(TimeUnit.MILLISECONDS);
_L1:
        bundle2 = bundle1;
        if (bundle1 != null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        bundle1 = new Bundle();
        bundle1.putString("command", class1.getName());
        bundle1.putBundle("parameters", bundle);
        bundle2 = queryCentralStore(bundle1);
        bundle = mapErrorKeysInBundle(bundle2);
        if (bundle.containsKey(mErrorMessageKey))
        {
            MAPLog.e(TAG, (new StringBuilder()).append(class1.getSimpleName()).append(" returned error ").append(bundle.getInt(mErrorCodeKey, -1)).append(" : ").append(bundle.getString(mErrorMessageKey)).toString());
        }
        platformmetricstimer.stop();
        return bundle;
        Object obj;
        obj;
        MAPLog.e(TAG, (new StringBuilder("InterruptedException while waiting for ")).append(class1.getSimpleName()).toString(), ((Throwable) (obj)));
        obj = getIpcErrorBundle$4cf0af3c("Got an error while calling Generic IPC central store.");
          goto _L1
        obj;
        MAPLog.e(TAG, (new StringBuilder("TimeoutException while waiting for ")).append(class1.getSimpleName()).append("; will retry over content provider").toString(), ((Throwable) (obj)));
        obj = bundle2;
          goto _L1
        class1;
        platformmetricstimer.stop();
        throw class1;
    }

    public void call(Class class1, Bundle bundle, Callback callback)
    {
        MAPArgContracts.throwIfNull(class1, "ipcCommandClass");
        MAPArgContracts.throwIfNull(callback, "callback");
        callback = MetricsHelper.wrapCallback(MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, class1.getSimpleName()), new ErrorCodeMapperCallback(callback, (byte)0));
        mBoundServiceManager.useService(new GenericIPCServiceCallback(callback, bundle, class1, mBoundServiceManager, (byte)0));
    }




}
