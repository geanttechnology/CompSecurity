// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions.do;

import io.presage.actions.c;
import io.presage.actions.d;
import io.presage.actions.g;
import io.presage.do.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package io.presage.actions.do:
//            b

public final class a extends Thread
{

    private ArrayList a;
    private boolean b;
    private c c;
    private Timer d;
    private TimerTask e;

    public a()
    {
        e = new b(this);
        a = new ArrayList();
        b = false;
        d = null;
        c = new c();
    }

    static boolean a(a a1)
    {
        a1.b = true;
        return true;
    }

    public final void a(g g1)
    {
        if (!b)
        {
            if (d == null)
            {
                d = new Timer();
                d.schedule(e, 150L);
            }
            a.add(g1);
        }
    }

    public final void run()
    {
        if (!a.contains("home") && a.contains("close"))
        {
            c c1 = c;
            io.presage.actions.d.a();
            c1.a(io.presage.actions.d.a("home", "intent", new e(new ArrayList())));
        }
        g g1;
        for (Iterator iterator = a.iterator(); iterator.hasNext(); c.a(g1))
        {
            g1 = (g)iterator.next();
        }

        c.a();
    }
}
