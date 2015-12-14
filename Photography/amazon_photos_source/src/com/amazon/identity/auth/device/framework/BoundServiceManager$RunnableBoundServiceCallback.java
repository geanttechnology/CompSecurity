// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.os.RemoteException;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceManager

private class mCallback
    implements Runnable
{

    private final mCallback mCallback;
    final BoundServiceManager this$0;

    public void run()
    {
        synchronized (BoundServiceManager.this)
        {
            obj = BoundServiceManager.access$000(BoundServiceManager.this);
        }
        if (obj == null)
        {
            MAPLog.w(BoundServiceManager.access$100(), "Service was disconnected before task could execute; re-enqueuing task to run after service re-connects.");
            BoundServiceManager.access$600(BoundServiceManager.this, mCallback);
            return;
        }
        try
        {
            mCallback.ce(obj);
            return;
        }
        catch (RemoteException remoteexception)
        {
            mCallback.mCallback();
        }
    }


    ( )
    {
        this$0 = BoundServiceManager.this;
        super();
        mCallback = ;
    }
}
