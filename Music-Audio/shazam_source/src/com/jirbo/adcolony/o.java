// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            g, q, s, ac, 
//            t, AdColonyBrowser, u

public final class o extends g
{

    boolean q;
    boolean r;
    boolean s;

    public o()
    {
        q = false;
        r = false;
        q.l = false;
        com.jirbo.adcolony.q.e();
        e = "v4vc";
        s = false;
        f = "fullscreen";
        g = com.jirbo.adcolony.s.a();
    }

    public final boolean a()
    {
        if (b == null)
        {
            b = q.c.d();
            if (b == null)
            {
                return false;
            }
        }
        return q.c.f(b);
    }

    final void b(boolean flag)
    {
        if (flag)
        {
            if (q.c.a(this))
            {
                a = 4;
                return;
            } else
            {
                a = 3;
                return;
            }
        } else
        {
            a = 1;
            return;
        }
    }

    final boolean b()
    {
        return false;
    }

    final void c()
    {
        if (a == 4 && r)
        {
            String s1 = e();
            String s2 = (new StringBuilder()).append(f()).toString();
            s1 = (new StringBuilder()).append(s2).append(" ").append(s1).toString();
            int i;
            if ("Result".equals("Confirmation"))
            {
                q.z = new t(s1, this);
            } else
            {
                q.z = new u(s1, this);
            }
        }
        com.jirbo.adcolony.q.f();
        if (!q.l && !AdColonyBrowser.C)
        {
            for (i = 0; i < q.U.size(); i++)
            {
                ((Bitmap)q.U.get(i)).recycle();
            }

            q.U.clear();
        }
        q.B = null;
        if (!r)
        {
            q.m = true;
        }
        System.gc();
    }

    final boolean d()
    {
        return true;
    }

    public final String e()
    {
        if (!a(false))
        {
            return "";
        } else
        {
            return c.j.d;
        }
    }

    public final int f()
    {
        if (!a(false))
        {
            return 0;
        } else
        {
            return c.j.c;
        }
    }

    public final int g()
    {
        if (!a(false))
        {
            return 0;
        } else
        {
            return c.j.f;
        }
    }

    public final int h()
    {
        if (!a(false))
        {
            return 0;
        } else
        {
            return c.j.f - q.c.d(c.j.d);
        }
    }
}
