// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import com.cyberlink.youcammakeup.Globals;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            bm

public class StorageMonitor extends BroadcastReceiver
{

    private static final bm a = new bm() {

        public void a(Uri uri)
        {
        }

    };
    private static final StorageMonitor b = new StorageMonitor();
    private bm c;
    private boolean d;

    private StorageMonitor()
    {
        d = false;
    }

    public static StorageMonitor a()
    {
        return b;
    }

    public void a(bm bm1)
    {
        this;
        JVM INSTR monitorenter ;
        c = bm1;
        this;
        JVM INSTR monitorexit ;
        return;
        bm1;
        throw bm1;
    }

    public void b()
    {
        if (d)
        {
            return;
        } else
        {
            IntentFilter intentfilter = new IntentFilter();
            intentfilter.addAction("android.intent.action.MEDIA_EJECT");
            intentfilter.addDataScheme("file");
            Globals.d().getApplicationContext().registerReceiver(this, intentfilter);
            d = true;
            return;
        }
    }

    public void b(bm bm1)
    {
        this;
        JVM INSTR monitorenter ;
        c = a;
        this;
        JVM INSTR monitorexit ;
        return;
        bm1;
        throw bm1;
    }

    public void onReceive(Context context, Intent intent)
    {
        try
        {
            context = intent.getAction();
            if (context.compareTo("android.intent.action.MEDIA_EJECT") == 0)
            {
                Log.w("StorageMonitor", (new StringBuilder()).append("onReceive: ").append(context).toString());
                c.a(intent.getData());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

}
