// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.sql.Timestamp;

// Referenced classes of package com.tapjoy.internal:
//            t, u, ag, cw

public abstract class s extends t
{

    public final Context a;
    public final u b;
    private boolean c;

    public s(Context context, u u1)
    {
        c = false;
        a = context.getApplicationContext();
        b = u1;
    }

    private void a(Context context)
    {
        b.b(context, 3000);
    }

    private static void b(Context context, Intent intent)
    {
        intent.putExtra("app", PendingIntent.getBroadcast(context, 0, new Intent(), 0));
    }

    private boolean b()
    {
        boolean flag = b.e(a);
        if (flag)
        {
            long l = b.f(a);
            if (l != 0L && System.currentTimeMillis() > l)
            {
                new Timestamp(l);
                return false;
            }
        }
        return flag;
    }

    private static boolean b(Context context, String s1)
    {
        Intent intent;
        int i;
        try
        {
            i = ag.b(context.getPackageManager(), "com.google.android.gms");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        if (i < 0x30345a)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        b(context, intent);
        intent.putExtra("sender", s1);
        return context.startService(intent) != null;
        return false;
    }

    private static boolean c(Context context, String s1)
    {
        try
        {
            ag.b(context.getPackageManager(), "com.google.android.gsf");
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gsf");
            b(context, intent);
            intent.putExtra("sender", s1);
            context = context.startService(intent);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return context != null;
    }

    private void d(String s1)
    {
        String s2 = b.b(a);
        if (s2.length() == 0)
        {
            e(s1);
            return;
        }
        if (!s1.equals(b.a(a)))
        {
            e(s1);
            return;
        }
        int i = b.d(a);
        int j = ag.a(a);
        if (i != 0x80000000 && i != j)
        {
            e(s1);
            return;
        }
        if (b.c(a))
        {
            e(s1);
            return;
        }
        if (!b())
        {
            a(a, s2);
            return;
        } else
        {
            return;
        }
    }

    private void e(String s1)
    {
        b.a(a, s1);
        b.a(a, true);
        while (!c && b(a, s1) || !c(a, s1)) 
        {
            return;
        }
    }

    private void f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        a(a);
        b.a(a, false);
        int i = ag.a(a);
        b.a(a, i);
        if (s1.equals(b.b(a))) goto _L2; else goto _L1
_L1:
        b.b(a, false);
        b.b(a, s1);
        a(a, s1);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!b())
        {
            a(a, s1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public final transient void a(String as[])
    {
        int i = 1;
        a(a);
        if (as == null || as.length == 0)
        {
            throw new IllegalArgumentException("No senderIds");
        }
        if (as.length == 1)
        {
            as = as[0];
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(as[0]);
            for (; i < as.length; i++)
            {
                stringbuilder.append(',').append(as[i]);
            }

            as = stringbuilder.toString();
        }
        d(as);
    }

    public final boolean a()
    {
        String s1 = b.a(a);
        if (!cw.c(s1))
        {
            d(s1);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean a(Intent intent)
    {
        Object obj = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(obj)) goto _L2; else goto _L1
_L1:
        String s1;
        obj = intent.getStringExtra("registration_id");
        s1 = intent.getStringExtra("unregistered");
        intent = intent.getStringExtra("error");
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((String) (obj)).length() <= 0) goto _L6; else goto _L5
_L5:
        f(((String) (obj)));
_L13:
        return false;
_L6:
        if (s1 == null && intent == null && !c)
        {
            c = true;
            a();
            return true;
        }
_L4:
        if (s1 != null)
        {
            intent = b.b(a);
            a(a);
            b.b(a, false);
            b.b(a, "");
            b.a(a, true);
            obj = a;
            a(((String) (intent)));
            return false;
        }
        if (intent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!"SERVICE_NOT_AVAILABLE".equals(intent)) goto _L8; else goto _L7
_L7:
        boolean flag;
        obj = a;
        flag = b(intent);
_L11:
        if (flag)
        {
            int i = b.g(a);
            intent = new Intent("com.google.android.gcm.intent.RETRY");
            intent.setPackage(a.getPackageName());
            intent = PendingIntent.getBroadcast(a, 0, intent, 0);
            ((AlarmManager)a.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)i, intent);
            if (i < 0x36ee80)
            {
                b.b(a, i * 2);
            }
        }
_L10:
        return true;
_L8:
        if (c)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = a;
        b(intent);
        c = true;
        a();
        if (true) goto _L10; else goto _L9
_L9:
        obj = a;
        flag = c(intent);
        if (true) goto _L11; else goto _L2
_L2:
        if ("com.google.android.c2dm.intent.RECEIVE".equals(obj))
        {
            obj = intent.getStringExtra("message_type");
            if (obj != null)
            {
                if ("deleted_messages".equals(obj))
                {
                    intent = intent.getStringExtra("total_deleted");
                    if (intent != null)
                    {
                        try
                        {
                            int j = Integer.parseInt(intent);
                            intent = a;
                            a(j);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Intent intent)
                        {
                            return false;
                        }
                        return false;
                    }
                } else
                {
                    return false;
                }
            } else
            {
                return a(a, intent);
            }
        } else
        if ("com.google.android.gcm.intent.RETRY".equals(obj))
        {
            intent = intent.getPackage();
            if (intent == null || !intent.equals(a.getPackageName()))
            {
                return false;
            } else
            {
                a();
                return true;
            }
        } else
        {
            return false;
        }
        if (true) goto _L13; else goto _L12
_L12:
    }
}
