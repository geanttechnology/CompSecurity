// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.m;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            p, o, Status, a

public final class l
    implements p
{

    private final o a;

    public l(o o1)
    {
        a = o1;
    }

    private void a(o.e e)
    {
        a.a(e);
        a.b b1 = a.a(e.d());
        if (!b1.e() && a.n.containsKey(e.d()))
        {
            e.c(new Status(17));
            return;
        } else
        {
            e.b(b1);
            return;
        }
    }

    public final k.a a(k.a a1)
    {
        return b(a1);
    }

    public final void a()
    {
        while (!a.f.isEmpty()) 
        {
            try
            {
                a((o.e)a.f.remove());
            }
            catch (DeadObjectException deadobjectexception) { }
        }
    }

    public final void a(int i)
    {
        if (i == 1)
        {
            o o1 = a;
            if (!o1.g)
            {
                o1.g = true;
                if (o1.l == null)
                {
                    o1.l = new o.c(o1);
                    IntentFilter intentfilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentfilter.addDataScheme("package");
                    o1.d.getApplicationContext().registerReceiver(o1.l, intentfilter);
                }
                o1.j.sendMessageDelayed(o1.j.obtainMessage(1), o1.h);
                o1.j.sendMessageDelayed(o1.j.obtainMessage(2), o1.i);
            }
        }
        for (Iterator iterator = a.t.iterator(); iterator.hasNext(); ((o.e)iterator.next()).b(new Status(8, "The connection to Google Play services was lost"))) { }
        a.a(null);
        a.c.a(i);
        a.c.a();
        if (i == 2)
        {
            a.b();
        }
    }

    public final void a(Bundle bundle)
    {
    }

    public final void a(ConnectionResult connectionresult, a a1, int i)
    {
    }

    public final k.a b(k.a a1)
    {
        try
        {
            a(a1);
        }
        catch (DeadObjectException deadobjectexception)
        {
            a.a(new o.b(this) {

                final l a;

                public final void a()
                {
                    a.a(1);
                }

            
            {
                a = l.this;
                super(p1);
            }
            });
            return a1;
        }
        return a1;
    }

    public final void b()
    {
        a.n.clear();
        a.f();
        a.a(null);
        a.c.a();
    }

    public final void c()
    {
    }

    public final String d()
    {
        return "CONNECTED";
    }
}
