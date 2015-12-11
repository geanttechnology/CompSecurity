// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

public final class iz
{

    final String a;
    public final String b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;
    public final ArrayList g = new ArrayList();
    int h;
    int i;
    public int j;
    public int k;
    public int l;
    public Bundle m;
    if n;
    private final iy o;
    private int p;

    iz(iy iy1, String s, String s1)
    {
        p = -1;
        o = iy1;
        a = s;
        b = s1;
    }

    final int a(if if1)
    {
label0:
        {
            int j1 = 1;
            boolean flag1 = false;
            boolean flag = false;
            int i1 = ((flag1) ? 1 : 0);
            if (n != if1)
            {
                n = if1;
                i1 = ((flag1) ? 1 : 0);
                if (if1 != null)
                {
                    i1 = ((flag) ? 1 : 0);
                    if (!ir.a(c, if1.b()))
                    {
                        c = if1.b();
                        i1 = 1;
                    }
                    if (!ir.a(d, if1.c()))
                    {
                        d = if1.c();
                        i1 = 1;
                    }
                    if (e != if1.d())
                    {
                        e = if1.d();
                    } else
                    {
                        j1 = i1;
                    }
                    i1 = j1;
                    if (f != if1.e())
                    {
                        f = if1.e();
                        i1 = j1 | true;
                    }
                    j1 = i1;
                    if (!g.equals(if1.f()))
                    {
                        g.clear();
                        g.addAll(if1.f());
                        j1 = i1 | 1;
                    }
                    i1 = j1;
                    if (h != if1.h())
                    {
                        h = if1.h();
                        i1 = j1 | true;
                    }
                    j1 = i1;
                    if (i != if1.i())
                    {
                        i = if1.i();
                        j1 = i1 | 1;
                    }
                    i1 = j1;
                    if (j != if1.l())
                    {
                        j = if1.l();
                        i1 = j1 | 3;
                    }
                    j1 = i1;
                    if (k != if1.j())
                    {
                        k = if1.j();
                        j1 = i1 | 3;
                    }
                    i1 = j1;
                    if (l != if1.k())
                    {
                        l = if1.k();
                        i1 = j1 | 3;
                    }
                    j1 = i1;
                    if (p != if1.m())
                    {
                        p = if1.m();
                        j1 = i1 | 5;
                    }
                    if (ir.a(m, if1.n()))
                    {
                        break label0;
                    }
                    m = if1.n();
                    i1 = j1 | 1;
                }
            }
            return i1;
        }
        return j1;
    }

    public final void a(int i1)
    {
        ir.d();
        iu iu1 = ir.a;
        i1 = Math.min(l, Math.max(0, i1));
        if (this == iu1.i && iu1.j != null)
        {
            iu1.j.a(i1);
        }
    }

    public final boolean a()
    {
        ir.d();
        return ir.a.b() == this;
    }

    public final boolean a(ip ip1)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        } else
        {
            ir.d();
            return ip1.a(g);
        }
    }

    public final boolean a(String s)
    {
        ir.d();
        int j1 = g.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            if (((IntentFilter)g.get(i1)).hasCategory(s))
            {
                return true;
            }
        }

        return false;
    }

    public final void b(int i1)
    {
        ir.d();
        if (i1 != 0)
        {
            iu iu1 = ir.a;
            if (this == iu1.i && iu1.j != null)
            {
                iu1.j.b(i1);
            }
        }
    }

    public final boolean b()
    {
        ir.d();
        return ir.a.a() == this;
    }

    public final void c()
    {
        ir.d();
        iu iu1 = ir.a;
        if (!iu1.c.contains(this))
        {
            Log.w("MediaRouter", (new StringBuilder("Ignoring attempt to select removed route: ")).append(this).toString());
            return;
        }
        if (!e)
        {
            Log.w("MediaRouter", (new StringBuilder("Ignoring attempt to select disabled route: ")).append(this).toString());
            return;
        } else
        {
            iu1.a(this);
            return;
        }
    }

    final ii d()
    {
        iy iy1 = o;
        ir.d();
        return iy1.a;
    }

    public final String toString()
    {
        return (new StringBuilder("MediaRouter.RouteInfo{ uniqueId=")).append(b).append(", name=").append(c).append(", description=").append(d).append(", enabled=").append(e).append(", connecting=").append(f).append(", playbackType=").append(h).append(", playbackStream=").append(i).append(", volumeHandling=").append(j).append(", volume=").append(k).append(", volumeMax=").append(l).append(", presentationDisplayId=").append(p).append(", extras=").append(m).append(", providerPackageName=").append(o.a()).append(" }").toString();
    }
}
