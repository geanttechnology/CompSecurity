// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.os.RemoteException;
import android.util.Log;
import com.amazon.avod.sdk.internal.aidl.AivPlaybackSdk;

// Referenced classes of package com.amazon.avod.sdk.internal:
//            BindingConnection, BlockingBindingConnection

private static abstract class <init>
    implements Runnable
{

    private final BlockingBindingConnection mServiceConnection;

    public final void run()
    {
        try
        {
            if (!mServiceConnection.isConnected())
            {
                mServiceConnection.bind();
            }
            run(mServiceConnection.getService());
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.e("AmazonInstantVideoSDK", "RemoteException calling to the service", remoteexception);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Log.e("AmazonInstantVideoSDK", "InterruptedException calling to the service", interruptedexception);
        }
    }

    protected abstract void run(AivPlaybackSdk aivplaybacksdk)
        throws RemoteException;

    private (BlockingBindingConnection blockingbindingconnection)
    {
        mServiceConnection = blockingbindingconnection;
    }

    mServiceConnection(BlockingBindingConnection blockingbindingconnection, mServiceConnection mserviceconnection)
    {
        this(blockingbindingconnection);
    }
}
