// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.gcm.d;

// Referenced classes of package com.kahuna.sdk:
//            q, g, m, h

public abstract class f extends IntentService
{

    private static android.os.PowerManager.WakeLock b;
    private static final Object c = com/kahuna/sdk/f;
    private static int e = 0;
    private final q a;
    private final String d[];

    protected f()
    {
        this(a("DynamicSenderIds"), null);
    }

    private f(String s, String as[])
    {
        super(s);
        a = new q((new StringBuilder()).append("[").append(getClass().getName()).append("]: ").toString());
        d = as;
        a.a(2, "Intent service name: %s", new Object[] {
            s
        });
    }

    protected transient f(String as[])
    {
        this(a(as), as);
    }

    private static String a(String s)
    {
        s = (new StringBuilder()).append("GCMIntentService-").append(s).append("-");
        int i = e + 1;
        e = i;
        return s.append(i).toString();
    }

    private static String a(String as[])
    {
        return a(g.a(as));
    }

    static void a(Context context, Intent intent, String s)
    {
        synchronized (c)
        {
            if (b == null)
            {
                b = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        b.acquire();
_L2:
        intent.setClassName(context, s);
        context.startService(intent);
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        SecurityException securityexception;
        securityexception;
        if (m.a)
        {
            Log.w("Kahuna", "App does not have WAKE_LOCK permission");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void b(Context context, Intent intent)
    {
        g.a();
        String s = intent.getStringExtra("registration_id");
        String s1 = intent.getStringExtra("error");
        intent = intent.getStringExtra("unregistered");
        a.a(3, "handleRegistration: registrationId = %s, error = %s, unregistered = %s", new Object[] {
            s, s1, intent
        });
        if (s != null)
        {
            h.b(context);
            g.b(context, s);
            b(context, s);
            return;
        }
        if (intent != null)
        {
            h.b(context);
            c(context, g.e(context));
            return;
        }
        if ("SERVICE_NOT_AVAILABLE".equals(s1))
        {
            h.e();
            return;
        } else
        {
            a(context, s1);
            return;
        }
    }

    protected void a(Context context, int i)
    {
    }

    protected abstract void a(Context context, Intent intent);

    protected abstract void a(Context context, String s);

    protected String[] a(Context context)
    {
        if (d == null)
        {
            throw new IllegalStateException("sender id not set on constructor");
        } else
        {
            return d;
        }
    }

    protected abstract void b(Context context, String s);

    protected abstract void c(Context context, String s);

    public final void onHandleIntent(Intent intent)
    {
        Object obj;
        Object obj1;
        obj = getApplicationContext();
        obj1 = intent.getAction();
        if (!h.c()) goto _L2; else goto _L1
_L1:
        obj1 = intent.getExtras();
        String s = com.google.android.gms.gcm.d.a(this).a(intent);
        if (!((Bundle) (obj1)).isEmpty() && "gcm".equals(s))
        {
            a(((Context) (obj)), intent);
        }
_L23:
        intent = ((Intent) (c));
        intent;
        JVM INSTR monitorenter ;
        if (b == null || !b.isHeld()) goto _L4; else goto _L3
_L3:
        b.release();
_L19:
        return;
_L2:
        if (((String) (obj1)).equals("com.google.android.c2dm.intent.REGISTRATION"))
        {
            g.b(((Context) (obj)));
            b(((Context) (obj)), intent);
            continue; /* Loop/switch isn't completed */
        }
          goto _L5
_L15:
        if (m.a)
        {
            Log.w("Kahuna", "Caught exception in GCM onHandleIntent, SDK might not be initialized correctly.");
            intent.printStackTrace();
        }
        intent = ((Intent) (c));
        intent;
        JVM INSTR monitorenter ;
        if (b == null || !b.isHeld()) goto _L7; else goto _L6
_L6:
        b.release();
_L20:
        return;
        obj;
        intent;
        JVM INSTR monitorexit ;
        throw obj;
_L5:
        if (!((String) (obj1)).equals("com.google.android.c2dm.intent.RECEIVE")) goto _L9; else goto _L8
_L8:
        obj1 = intent.getStringExtra("message_type");
        if (obj1 == null) goto _L11; else goto _L10
_L10:
        if (!((String) (obj1)).equals("deleted_messages")) goto _L13; else goto _L12
_L12:
        intent = intent.getStringExtra("total_deleted");
        if (intent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int i = Integer.parseInt(intent);
        a.a(2, "Received notification for %d deletedmessages", new Object[] {
            Integer.valueOf(i)
        });
        a(((Context) (obj)), i);
        continue; /* Loop/switch isn't completed */
        obj;
        try
        {
            a.a(6, "GCM returned invalid number of deleted messages (%d)", new Object[] {
                intent
            });
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        finally
        {
            intent = ((Intent) (c));
        }
        if (true) goto _L15; else goto _L14
_L14:
        intent;
        JVM INSTR monitorenter ;
        if (b == null || !b.isHeld()) goto _L17; else goto _L16
_L16:
        b.release();
_L21:
        intent;
        JVM INSTR monitorexit ;
        throw obj;
_L13:
        a.a(6, "Received unknown special message: %s", new Object[] {
            obj1
        });
        continue; /* Loop/switch isn't completed */
_L11:
        a(((Context) (obj)), intent);
        continue; /* Loop/switch isn't completed */
_L9:
        if (!((String) (obj1)).equals("com.google.android.gcm.intent.RETRY"))
        {
            continue; /* Loop/switch isn't completed */
        }
        intent = intent.getPackage();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        if (intent.equals(getApplicationContext().getPackageName()))
        {
            break MISSING_BLOCK_LABEL_433;
        }
        a.a(6, "Ignoring retry intent from another package (%s)", new Object[] {
            intent
        });
        intent = ((Intent) (c));
        intent;
        JVM INSTR monitorenter ;
        if (b == null || !b.isHeld())
        {
            break MISSING_BLOCK_LABEL_414;
        }
        b.release();
_L18:
        return;
        obj;
        intent;
        JVM INSTR monitorexit ;
        throw obj;
        a.a(6, "Wakelock reference is null or not held", new Object[0]);
          goto _L18
        if (com.kahuna.sdk.g.d(((Context) (obj))))
        {
            g.a(((Context) (obj)));
            continue; /* Loop/switch isn't completed */
        }
        g.b(((Context) (obj)), a(((Context) (obj))));
        continue; /* Loop/switch isn't completed */
_L4:
        a.a(6, "Wakelock reference is null or not held", new Object[0]);
          goto _L19
        Exception exception;
        exception;
        intent;
        JVM INSTR monitorexit ;
        throw exception;
_L7:
        a.a(6, "Wakelock reference is null or not held", new Object[0]);
          goto _L20
_L17:
        a.a(6, "Wakelock reference is null or not held", new Object[0]);
          goto _L21
        exception;
        intent;
        JVM INSTR monitorexit ;
        throw exception;
        if (true) goto _L23; else goto _L22
_L22:
    }

}
