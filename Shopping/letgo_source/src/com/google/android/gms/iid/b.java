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
import com.google.android.gms.gcm.d;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.iid:
//            f, a, e, MessengerCompat

public class b extends Service
{

    static String a = "action";
    private static String f = "google.com/iid";
    private static String g = "CMD";
    private static String h = "gcm.googleapis.com/refresh";
    MessengerCompat b;
    BroadcastReceiver c;
    int d;
    int e;

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

    void a()
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
            Log.d("InstanceID", (new StringBuilder()).append("Stop ").append(d).append(" ").append(e).toString());
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

    void a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        d = d + 1;
        if (i > e)
        {
            e = i;
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

    public void a(Intent intent)
    {
        Object obj;
        String s;
        String s1;
        s1 = intent.getStringExtra("subtype");
        if (s1 == null)
        {
            obj = com.google.android.gms.iid.a.b(this);
        } else
        {
            obj = new Bundle();
            ((Bundle) (obj)).putString("subtype", s1);
            obj = com.google.android.gms.iid.a.a(this, ((Bundle) (obj)));
        }
        s = intent.getStringExtra(g);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder()).append("Register result in service ").append(s1).toString());
        }
        ((a) (obj)).d().d(intent);
_L4:
        return;
_L2:
        if (Log.isLoggable("InstanceID", 3))
        {
            Log.d("InstanceID", (new StringBuilder()).append("Service command ").append(s1).append(" ").append(s).append(" ").append(intent.getExtras()).toString());
        }
        if (intent.getStringExtra("unregistered") != null)
        {
            f f1 = ((a) (obj)).c();
            s = s1;
            if (s1 == null)
            {
                s = "";
            }
            f1.e(s);
            ((a) (obj)).d().d(intent);
            return;
        }
        if (h.equals(intent.getStringExtra("from")))
        {
            ((a) (obj)).c().e(s1);
            a(false);
            return;
        }
        if ("RST".equals(s))
        {
            ((a) (obj)).b();
            a(true);
            return;
        }
        if (!"RST_FULL".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((a) (obj)).c().a())
        {
            ((a) (obj)).c().b();
            a(true);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ("SYNC".equals(s))
        {
            ((a) (obj)).c().e(s1);
            a(false);
            return;
        }
        if ("PING".equals(s))
        {
            try
            {
                com.google.android.gms.gcm.d.a(this).a(f, com.google.android.gms.iid.e.b(), 0L, intent.getExtras());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                Log.w("InstanceID", "Failed to send ping response");
            }
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void a(boolean flag)
    {
        b();
    }

    public void b()
    {
    }

    public IBinder onBind(Intent intent)
    {
        if (intent != null && "com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            return b.a();
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        IntentFilter intentfilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentfilter.addCategory(getPackageName());
        registerReceiver(c, intentfilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy()
    {
        unregisterReceiver(c);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        a(j);
        if (intent == null)
        {
            a();
            return 2;
        }
        Intent intent1;
        if (!"com.google.android.gms.iid.InstanceID".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (android.os.Build.VERSION.SDK_INT > 18)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        intent1 = (Intent)intent.getParcelableExtra("GSF");
        if (intent1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        startService(intent1);
        a();
        return 1;
        a(intent);
        a();
        if (intent.getStringExtra("from") != null)
        {
            com.google.android.gms.gcm.b.a(intent);
        }
        return 2;
        intent;
        a();
        throw intent;
    }

}
