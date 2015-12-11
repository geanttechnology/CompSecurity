// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            g, q, s, ac, 
//            f, n, AdColonyBrowser, i, 
//            m

public final class l extends g
{

    i q;
    m r;
    n s;
    boolean t;

    public l()
    {
        q.l = false;
        com.jirbo.adcolony.q.e();
        e = "interstitial";
        f = "fullscreen";
        t = false;
        g = com.jirbo.adcolony.s.a();
    }

    public l(String s1)
    {
        e = "interstitial";
        f = "fullscreen";
        com.jirbo.adcolony.q.e();
        b = s1;
        t = false;
        g = com.jirbo.adcolony.s.a();
    }

    public final boolean a()
    {
        if (b == null)
        {
            b = q.c.c();
            if (b == null)
            {
                return false;
            }
        }
        if (f.b(b))
        {
            q.T = 12;
            return false;
        } else
        {
            return q.c.e(b);
        }
    }

    public final boolean b()
    {
        if (b == null)
        {
            b = q.c.c();
            if (b == null)
            {
                return false;
            }
        }
        return q.c.e(b);
    }

    final void c()
    {
        e = "interstitial";
        f = "fullscreen";
        if (q == null && r != null)
        {
            int i;
            if (super.a == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                s.B = true;
            } else
            {
                s.B = false;
            }
        }
        com.jirbo.adcolony.q.f();
        System.gc();
        if (!q.l && !AdColonyBrowser.C)
        {
            for (i = 0; i < q.U.size(); i++)
            {
                ((Bitmap)q.U.get(i)).recycle();
            }

            q.U.clear();
        }
        q.B = null;
        q.m = true;
    }

    final boolean d()
    {
        return false;
    }
}
