// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digidust.elokence.akinator.factories.AkLog;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl, AkInappManager

class this._cls0
    implements ServiceConnection
{

    final InappManagerImpl this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        AkLog.w("AkInappManagerImpl", "Inapp service connected");
        mService = com.android.vending.billing.e.Stub.asInterface(ibinder);
        AkInappManager.getInstance().signalInitialised(true);
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        AkLog.w("AkInappManagerImpl", "Inapp service disconnected");
        AkInappManager.getInstance().signalInitialised(false);
        mService = null;
    }

    ()
    {
        this$0 = InappManagerImpl.this;
        super();
    }
}
