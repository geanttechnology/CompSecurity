// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

// Referenced classes of package com.amazon.identity.snds.api:
//            BoundServiceCaller

class this._cls0
    implements ServiceConnection
{

    final BoundServiceCaller this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        BoundServiceCaller.access$002(BoundServiceCaller.this, true);
        try
        {
            useService(componentname, ibinder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ComponentName componentname)
        {
            unbind();
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        synchronized (BoundServiceCaller.access$100(BoundServiceCaller.this))
        {
            BoundServiceCaller.access$202(BoundServiceCaller.this, null);
        }
        return;
        exception;
        componentname;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = BoundServiceCaller.this;
        super();
    }
}
