// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import java.util.Iterator;
import java.util.LinkedList;

final class bi
{

    private ag a;
    private ao b;
    private String c;
    private int d;
    private final LinkedList e = new LinkedList();

    bi()
    {
        c = null;
        d = 0;
    }

    private void a(String s, String s1)
    {
        s1 = new bj(s, s1);
        s = e;
        s;
        JVM INSTR monitorenter ;
        if (a != null && b != null) goto _L2; else goto _L1
_L1:
        if (e.size() < 10)
        {
            e.add(s1);
        }
_L4:
        return;
_L2:
        s1 = a.a(s1);
        if (s1 == null) goto _L4; else goto _L3
_L3:
        b.b(s1);
          goto _L4
        s1;
        s;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private static String d(Activity activity)
    {
        if (activity == null)
        {
            return "null";
        } else
        {
            return activity.getClass().getName();
        }
    }

    final void a(ag ag1, ao ao1)
    {
        LinkedList linkedlist = e;
        linkedlist;
        JVM INSTR monitorenter ;
        a = ag1;
        b = ao1;
        ag1 = e;
        ag1;
        JVM INSTR monitorenter ;
        ao1 = e.iterator();
_L2:
        Object obj;
        do
        {
            if (!ao1.hasNext())
            {
                break MISSING_BLOCK_LABEL_90;
            }
            obj = (bj)ao1.next();
            obj = a.a(((bj) (obj)));
        } while (obj == null);
        b.b(((org.json.JSONObject) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        ao1;
        ag1;
        JVM INSTR monitorexit ;
        throw ao1;
        ag1;
        linkedlist;
        JVM INSTR monitorexit ;
        throw ag1;
        ag1;
        JVM INSTR monitorexit ;
        linkedlist;
        JVM INSTR monitorexit ;
    }

    final void a(Activity activity)
    {
        if (d == 0)
        {
            bc.a("Lifecycle: App Start");
            activity = d(activity);
            a(((String) (activity)), "App Start");
            c = activity;
        }
        d = d + 1;
    }

    final void b(Activity activity)
    {
        d = d - 1;
        if (d == 0)
        {
            bc.a("Lifecycle: App Stop");
            a(d(activity), "App Stop");
            c = null;
        }
    }

    final void c(Activity activity)
    {
        activity = d(activity);
        if (!c.equals(activity))
        {
            bc.a("Lifecycle: Activity Change");
            a(activity, "Activity Change");
            c = activity;
        }
    }
}
