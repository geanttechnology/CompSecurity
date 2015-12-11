// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.agt;
import android.support.v7.agv;
import android.support.v7.agx;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

// Referenced classes of package com.kahuna.sdk:
//            r, m, v

public class p
{
    private class a extends BroadcastReceiver
    {

        final p a;

        public void onReceive(Context context, Intent intent)
        {
            try
            {
                p.a(context, intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.e("Kahuna", "KahunaSDK wasn't initialized in onAppCreate(), please initialized Kahuna correctly to prevent strange behavior");
            }
            context.printStackTrace();
        }

        private a()
        {
            a = p.this;
            super();
        }

    }

    private class b extends TimerTask
    {

        final p a;
        private String b;
        private String c;
        private boolean d;

        public void run()
        {
            agx agx1;
            agx1 = new agx();
            agx1.a("key", b);
            agx1.a("dev_id", c);
            String s;
            if (d)
            {
                s = "s";
            } else
            {
                s = "p";
            }
            try
            {
                agx1.a("env", s);
                long l = System.currentTimeMillis() / 1000L;
                agx1.a("monitoring_key", (new StringBuilder()).append(l + 0x15180L).append("kah").toString());
                if (m.a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Sending monitor request: ").append(agx1).toString());
                }
                p.a(a).a("https://tap-nexus.appspot.com/monitor_device", agx1, new agv(this) {

                    final b a;

                    public void a(String s)
                    {
                        if (m.a)
                        {
                            Log.d("Kahuna", (new StringBuilder()).append("Successfully sent monitor request: ").append(s).toString());
                        }
                    }

                    public void a(Throwable throwable, String s)
                    {
                        super.a(throwable, s);
                        if (m.a)
                        {
                            Log.d("Kahuna", (new StringBuilder()).append("Failed to send monitor request: ").append(s).toString(), throwable);
                        }
                    }

            
            {
                a = b1;
                super();
            }
                });
                return;
            }
            catch (Exception exception)
            {
                if (m.a)
                {
                    Log.d("Kahuna", (new StringBuilder()).append("Caught exception in Send Monitor Request Task handler: ").append(exception).toString());
                }
            }
            return;
        }

        public b(String s, String s1, boolean flag)
        {
            a = p.this;
            super();
            b = s;
            c = s1;
            d = flag;
        }
    }


    private static p a;
    private a b;
    private long c;
    private boolean d;
    private Object e;
    private agt f;
    private Timer g;
    private boolean h;
    private long i;

    private p()
    {
        b = new a();
        c = -1L;
        d = false;
        e = new Object();
        h = false;
        i = -1L;
    }

    static agt a(p p1)
    {
        return p1.f;
    }

    protected static void a(Context context)
    {
        p p1;
        p1 = c();
        if (p1.d)
        {
            return;
        }
        try
        {
            Object obj = new IntentFilter();
            ((IntentFilter) (obj)).addAction("com.kahuna.sdk.broadcast.FIND_MY_DEVICE");
            ((IntentFilter) (obj)).addAction("com.kahuna.sdk.broadcast.SDK_COMMAND");
            context.registerReceiver(p1.b, ((IntentFilter) (obj)));
            p1.d = true;
            obj = r.l(context);
            p1.h = ((JSONObject) (obj)).optBoolean("debug_logging_override", false);
            p1.i = ((JSONObject) (obj)).optLong("debug_logging_expiration_time", -1L);
            m.a(b(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in FindMyDevice ").append(context).toString());
        }
        return;
    }

    static void a(Context context, Intent intent)
    {
        b(context, intent);
    }

    protected static void a(Context context, String s)
    {
        int j = 0;
        if (!v.a(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k;
        s = s.split(",");
        k = s.length;
_L9:
        if (j >= k) goto _L1; else goto _L3
_L3:
        String as[];
        as = s[j].split("=");
        if (as.length != 2)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        p p1;
        if (!"dbg".equals(as[0]))
        {
            break MISSING_BLOCK_LABEL_172;
        }
        p1 = c();
        if (!"t".equals(as[1])) goto _L5; else goto _L4
_L4:
        p1.h = true;
        p1.i = System.currentTimeMillis() / 1000L + 0x15180L;
_L8:
        m.a(p1.h);
        p1.c(context);
        break MISSING_BLOCK_LABEL_172;
        context;
        if (!m.a) goto _L1; else goto _L6
_L6:
        Log.d("Kahuna", (new StringBuilder()).append("Handled exception processing injected SDK command: ").append(context).toString());
        context.printStackTrace();
        return;
_L5:
        if (!"f".equals(as[1])) goto _L8; else goto _L7
_L7:
        p1.h = false;
        p1.i = -1L;
          goto _L8
        j++;
          goto _L9
    }

    protected static void a(String s, String s1, boolean flag)
    {
        p p1;
        p1 = c();
        p1.c = -1L;
        if (p1.f == null)
        {
            p1.f = new agt();
            p1.f.a(15000);
        }
        synchronized (p1.e)
        {
            if (p1.g != null)
            {
                p1.g.cancel();
                p1.g = null;
            }
            p1.g = new Timer();
            Timer timer = p1.g;
            p1.getClass();
            timer.schedule(p1. new b(s, s1, flag), 0L);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw s;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception attempting to schedule monitor request ").append(s).toString());
        }
        return;
    }

    protected static boolean a()
    {
        p p1 = c();
        return p1.c > 0L && System.currentTimeMillis() / 1000L < p1.c;
    }

    protected static void b()
    {
        p p1 = c();
        p1.c = System.currentTimeMillis() / 1000L + 3600L;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Setting expire time of findMyDevice broadcast to ").append(p1.c).toString());
        }
_L1:
        return;
        Exception exception;
        exception;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception in FindMyDevice Broadcast Receiver ").append(exception).toString());
            return;
        }
          goto _L1
    }

    private static void b(Context context, Intent intent)
    {
        String s;
        String s1;
        s = intent.getStringExtra("secret_key");
        if (s != null)
        {
            s1 = m.j().k();
            break MISSING_BLOCK_LABEL_18;
        }
          goto _L1
_L5:
        do
        {
            return;
        } while (s1 == null || s1.length() < 4 || !v.a(s1.substring(0, 4), "SHA-1", true).equals(s));
_L1:
        s1 = intent.getAction();
        if (!"com.kahuna.sdk.broadcast.FIND_MY_DEVICE".equals(s1)) goto _L3; else goto _L2
_L2:
        b();
_L7:
        if (!m.a) goto _L5; else goto _L4
_L4:
        Log.d("Kahuna", (new StringBuilder()).append("Received Companion App command: ").append(intent.getAction()).toString());
        return;
_L3:
        if (!"com.kahuna.sdk.broadcast.SDK_COMMAND".equals(s1)) goto _L7; else goto _L6
_L6:
        s1 = intent.getStringExtra("com.kahuna.sdk.internal_hash");
        if (v.a(s1)) goto _L5; else goto _L8
_L8:
        String s2;
        String s3;
        long l = System.currentTimeMillis() / 1000L / 5L;
        s2 = v.a((new StringBuilder()).append("com.kahuna.sdk.internal_broadcasts").append(String.valueOf(l)).toString(), "SHA-1", true);
        s3 = v.a((new StringBuilder()).append("com.kahuna.sdk.internal_broadcasts").append(String.valueOf(l + 1L)).toString(), "SHA-1", true);
        if (!s1.equals(s2) && !s1.equals(s3) || v.a(s)) goto _L5; else goto _L9
_L9:
        a(context, intent.getStringExtra("cmd"));
          goto _L7
    }

    protected static boolean b(Context context)
    {
        p p1 = c();
        if (p1.h && System.currentTimeMillis() / 1000L > p1.i)
        {
            p1.h = false;
            p1.i = -1L;
            p1.c(context);
        }
        return p1.h;
    }

    private static p c()
    {
        if (a == null)
        {
            a = new p();
        }
        return a;
    }

    private void c(Context context)
    {
        JSONObject jsonobject = r.l(context);
        jsonobject.put("debug_logging_override", h);
        jsonobject.put("debug_logging_expiration_time", i);
        r.a(jsonobject, context);
_L1:
        return;
        context;
        if (m.a)
        {
            Log.d("Kahuna", (new StringBuilder()).append("Handled exception processing request to enable debug logs ").append(context).toString());
            return;
        }
          goto _L1
    }
}
