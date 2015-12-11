// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            s, ak, ap, as, 
//            at, be, u, AdColonyBrowser, 
//            bq, bs, bl, bj, 
//            db

public final class ag extends s
{

    u q;
    boolean r;
    boolean s;
    boolean t;

    public ag()
    {
        r = false;
        s = false;
        ak.l = false;
        ak.e();
        e = "v4vc";
        t = false;
        f = "fullscreen";
        g = ap.a();
    }

    public ag(String s1)
    {
        r = false;
        s = false;
        ak.e();
        b = s1;
        e = "v4vc";
        t = false;
        f = "fullscreen";
        g = ap.a();
    }

    void a(String s1)
    {
        String s2 = j();
        String s3 = (new StringBuilder()).append("").append(k()).toString();
        s2 = (new StringBuilder()).append(s3).append(" ").append(s2).toString();
        if (s1.equals("Confirmation"))
        {
            ak.z = new as(s2, this);
            return;
        } else
        {
            ak.z = new at(s2, this);
            return;
        }
    }

    boolean a(boolean flag)
    {
        return false;
    }

    void c(boolean flag)
    {
        if (flag)
        {
            if (ak.c.b(this))
            {
                if (q != null)
                {
                    q.b(this);
                }
                a = 4;
            } else
            {
                a = 3;
            }
        } else
        {
            a = 1;
        }
        if (a != 4 && q != null)
        {
            q.a(this);
        }
    }

    public boolean f()
    {
        if (b == null)
        {
            b = ak.c.f();
            if (b == null)
            {
                return false;
            }
        }
        return ak.c.f(b);
    }

    void g()
    {
        if (a == 4 && s)
        {
            a("Result");
        }
        if (q != null)
        {
            q.a(this);
        }
        ak.f();
        if (!ak.l && !AdColonyBrowser.C)
        {
            for (int i = 0; i < ak.U.size(); i++)
            {
                ((Bitmap)ak.U.get(i)).recycle();
            }

            ak.U.clear();
        }
        ak.B = null;
        if (!s)
        {
            ak.m = true;
        }
        System.gc();
    }

    boolean h()
    {
        return true;
    }

    public String j()
    {
        if (!i())
        {
            return "";
        } else
        {
            return c.j.d;
        }
    }

    public int k()
    {
        if (!i())
        {
            return 0;
        } else
        {
            return c.j.c;
        }
    }

    public int l()
    {
        if (!i())
        {
            return 0;
        } else
        {
            return c.j.f;
        }
    }

    public int m()
    {
        if (!i())
        {
            return 0;
        } else
        {
            return c.j.f - ak.c.d(c.j.d);
        }
    }

    public void n()
    {
        ak.T = 0;
        if (!t) goto _L2; else goto _L1
_L1:
        bl.d.b("Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
_L4:
        return;
_L2:
        t = true;
        if (f())
        {
            continue; /* Loop/switch isn't completed */
        }
        new bj(ak.c) {

            final ag a;

            void b()
            {
                if (a.b != null)
                {
                    n.d.a(a.b, a);
                }
            }

            
            {
                a = ag.this;
                super(be1);
            }
        };
        a = 2;
        if (q == null) goto _L4; else goto _L3
_L3:
        q.a(this);
        return;
        if (!ak.m) goto _L4; else goto _L5
_L5:
        new bj(ak.c) {

            final ag a;

            void b()
            {
                n.d.a(a.b, a);
            }

            
            {
                a = ag.this;
                super(be1);
            }
        };
        ak.m = false;
        i();
        ak.A = this;
        ak.c.a(this);
        if (r)
        {
            a("Confirmation");
            return;
        } else
        {
            c(true);
            return;
        }
    }
}
