// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            BoundServiceCaller

class this._cls0
    implements ServiceConnection
{

    final BoundServiceCaller this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        BoundServiceCaller.access$000();
        String.format("Connected to service: %s", new Object[] {
            componentname.toString()
        });
        BoundServiceCaller.access$102(BoundServiceCaller.this, true);
        try
        {
            useService(componentname, ibinder);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IBinder ibinder)
        {
            MAPLog.e(BoundServiceCaller.access$000(), String.format("Service died: %s", new Object[] {
                componentname.toString()
            }));
        }
        unbind();
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        synchronized (BoundServiceCaller.access$200(BoundServiceCaller.this))
        {
            BoundServiceCaller.access$302(BoundServiceCaller.this, null);
        }
        serviceDisconnected();
        BoundServiceCaller.access$000();
        String.format("Disconnected from service: %s", new Object[] {
            componentname.toString()
        });
    }

    ()
    {
        this$0 = BoundServiceCaller.this;
        super();
    }
}
