// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.IGenericIPC;
import com.amazon.identity.auth.device.callback.RemoteCallbackWrapper;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            GenericIPCSender, BoundServiceManager

private static final class <init> extends <init>
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

    private (Callback callback, Bundle bundle, Class class1, BoundServiceManager boundservicemanager)
    {
        mCallback = callback;
        mParameters = bundle;
        mIpcCommandClass = class1;
        mBoundServiceManager = boundservicemanager;
        mAlreadyCalledBack = false;
    }

    mAlreadyCalledBack(Callback callback, Bundle bundle, Class class1, BoundServiceManager boundservicemanager, byte byte0)
    {
        this(callback, bundle, class1, boundservicemanager);
    }
}
