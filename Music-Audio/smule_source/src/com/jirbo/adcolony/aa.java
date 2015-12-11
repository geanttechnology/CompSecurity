// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.graphics.Bitmap;
import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            s, ak, ap, be, 
//            q, u, AdColonyBrowser, ad, 
//            ab, bl, bj, db

public class aa extends s
{

    u q;
    ab r;
    ad s;
    boolean t;

    public aa()
    {
        ak.l = false;
        ak.e();
        e = "interstitial";
        f = "fullscreen";
        t = false;
        g = ap.a();
    }

    public aa(String s1)
    {
        e = "interstitial";
        f = "fullscreen";
        ak.e();
        b = s1;
        t = false;
        g = ap.a();
    }

    boolean a(boolean flag)
    {
        if (b == null)
        {
            b = ak.c.e();
            if (b == null)
            {
                return false;
            }
        }
        return ak.c.e(b);
    }

    public boolean f()
    {
        if (b == null)
        {
            b = ak.c.e();
            if (b == null)
            {
                return false;
            }
        }
        if (com.jirbo.adcolony.q.d(b))
        {
            ak.T = 12;
            return false;
        } else
        {
            return ak.c.e(b);
        }
    }

    void g()
    {
        e = "interstitial";
        f = "fullscreen";
        if (q != null)
        {
            q.a(this);
        } else
        if (r != null)
        {
            if (c())
            {
                s.A = true;
            } else
            {
                s.A = false;
            }
            r.b(true, s);
        }
        ak.f();
        System.gc();
        if (!ak.l && !AdColonyBrowser.C)
        {
            for (int i = 0; i < ak.U.size(); i++)
            {
                ((Bitmap)ak.U.get(i)).recycle();
            }

            ak.U.clear();
        }
        ak.B = null;
        ak.m = true;
    }

    boolean h()
    {
        return false;
    }

    public void j()
    {
        ak.T = 0;
        if (t)
        {
            bl.d.b("Show attempt on out of date ad object. Please instantiate a new ad object for each ad attempt.");
        } else
        {
            t = true;
            e = "interstitial";
            f = "fullscreen";
            if (!f())
            {
                new bj(ak.c) {

                    final aa a;

                    void b()
                    {
                        if (a.b != null)
                        {
                            n.d.a(a.b, a);
                        }
                    }

            
            {
                a = aa.this;
                super(be1);
            }
                };
                a = 2;
                if (q != null)
                {
                    q.a(this);
                    return;
                }
            } else
            {
                if (ak.m)
                {
                    new bj(ak.c) {

                        final aa a;

                        void b()
                        {
                            n.d.a(a.b, a);
                        }

            
            {
                a = aa.this;
                super(be1);
            }
                    };
                    ak.m = false;
                    i();
                    ak.A = this;
                    if (!ak.c.b(this))
                    {
                        if (q != null)
                        {
                            q.a(this);
                        }
                        ak.m = true;
                        return;
                    }
                    if (q != null)
                    {
                        q.b(this);
                    }
                }
                a = 4;
                return;
            }
        }
    }
}
