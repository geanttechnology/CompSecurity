// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.c.a;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.iid:
//            f, MessengerCompat, a, e

public final class b extends Service
{

    static String a = "action";
    private static String f = "google.com/iid";
    private static String g = "CMD";
    private static String h = "gcm.googleapis.com/refresh";
    MessengerCompat b;
    BroadcastReceiver c;
    int d;
    int e;

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        d = d - 1;
        if (d == 0)
        {
            stopSelf(e);
        }
        if (Log.isLoggable("InstanceID", 3))
        {
            (new StringBuilder("Stop ")).append(d).append(" ").append(e);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static void a(Context context)
    {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(g, "SYNC");
        context.startService(intent);
    }

    static void a(Context context, f f1)
    {
        f1.b();
        f1 = new Intent("com.google.android.gms.iid.InstanceID");
        f1.putExtra(g, "RST");
        f1.setPackage(context.getPackageName());
        context.startService(f1);
    }

    public final IBinder onBind(Intent intent)
    {
        if (intent != null && "com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            return b.a();
        } else
        {
            return null;
        }
    }

    public final void onCreate()
    {
        IntentFilter intentfilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentfilter.addCategory(getPackageName());
        registerReceiver(c, intentfilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public final void onDestroy()
    {
        unregisterReceiver(c);
    }

    public final int onStartCommand(Intent intent, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        d = d + 1;
        if (j > e)
        {
            e = j;
        }
        this;
        JVM INSTR monitorexit ;
        if (intent == null)
        {
            a();
            return 2;
        }
        break MISSING_BLOCK_LABEL_42;
        intent;
        this;
        JVM INSTR monitorexit ;
        throw intent;
        if (!"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        Object obj;
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = (Intent)intent.getParcelableExtra("GSF");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        startService(((Intent) (obj)));
        a();
        return 1;
        Object obj1 = intent.getStringExtra("subtype");
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj = com.google.android.gms.iid.a.b(this);
_L7:
        Object obj2 = intent.getStringExtra(g);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) goto _L6; else goto _L5
_L5:
        com.google.android.gms.iid.a.b().b(intent);
_L2:
        a();
        if (intent.getStringExtra("from") != null)
        {
            com.google.android.gms.c.a.a(intent);
        }
        return 2;
_L4:
        obj = new Bundle();
        ((Bundle) (obj)).putString("subtype", ((String) (obj1)));
        obj = com.google.android.gms.iid.a.a(this, ((Bundle) (obj)));
          goto _L7
_L6:
        if (Log.isLoggable("InstanceID", 3))
        {
            (new StringBuilder("Service command ")).append(((String) (obj1))).append(" ").append(((String) (obj2))).append(" ").append(intent.getExtras());
        }
        if (intent.getStringExtra("unregistered") == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        obj2 = com.google.android.gms.iid.a.a();
        obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        ((f) (obj2)).c(((String) (obj)));
        com.google.android.gms.iid.a.b().b(intent);
          goto _L2
label0:
        {
            if (!h.equals(intent.getStringExtra("from")))
            {
                break label0;
            }
            com.google.android.gms.iid.a.a().c(((String) (obj1)));
        }
          goto _L2
label1:
        {
            if (!"RST".equals(obj2))
            {
                break label1;
            }
            obj.f = 0L;
            obj1 = a.c;
            obj2 = ((com.google.android.gms.iid.a) (obj)).e;
            ((f) (obj1)).b((new StringBuilder()).append(((String) (obj2))).append("|").toString());
            obj.d = null;
        }
          goto _L2
label2:
        {
            if (!"RST_FULL".equals(obj2))
            {
                break label2;
            }
            if (!com.google.android.gms.iid.a.a().a())
            {
                com.google.android.gms.iid.a.a().b();
            }
        }
          goto _L2
label3:
        {
            if (!"SYNC".equals(obj2))
            {
                break label3;
            }
            com.google.android.gms.iid.a.a().c(((String) (obj1)));
        }
          goto _L2
        boolean flag = "PING".equals(obj2);
        if (flag)
        {
            try
            {
                com.google.android.gms.c.b.a(this).a(f, com.google.android.gms.iid.e.a(), intent.getExtras());
            }
            catch (IOException ioexception) { }
            finally
            {
                a();
                throw intent;
            }
        }
          goto _L2
    }

}
