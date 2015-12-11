// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeaconManager, IBeaconConsumer

class this._cls0
    implements ServiceConnection
{

    final IBeaconManager this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconManager", "we have a connection to the service now");
        }
        IBeaconManager.access$102(IBeaconManager.this, new Messenger(ibinder));
        componentname = IBeaconManager.access$200(IBeaconManager.this);
        componentname;
        JVM INSTR monitorenter ;
        ibinder = IBeaconManager.access$200(IBeaconManager.this).keySet().iterator();
        do
        {
            if (!ibinder.hasNext())
            {
                break;
            }
            IBeaconConsumer ibeaconconsumer = (IBeaconConsumer)ibinder.next();
            if (!Boolean.valueOf(((nsumerInfo)IBeaconManager.access$200(IBeaconManager.this).get(ibeaconconsumer)).isConnected).booleanValue())
            {
                ibeaconconsumer.onIBeaconServiceConnect();
                nsumerInfo nsumerinfo = (nsumerInfo)IBeaconManager.access$200(IBeaconManager.this).get(ibeaconconsumer);
                nsumerinfo.isConnected = true;
                IBeaconManager.access$200(IBeaconManager.this).put(ibeaconconsumer, nsumerinfo);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_159;
        ibinder;
        componentname;
        JVM INSTR monitorexit ;
        throw ibinder;
        componentname;
        JVM INSTR monitorexit ;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        Log.e("IBeaconManager", "onServiceDisconnected");
    }

    nsumerInfo()
    {
        this$0 = IBeaconManager.this;
        super();
    }
}
