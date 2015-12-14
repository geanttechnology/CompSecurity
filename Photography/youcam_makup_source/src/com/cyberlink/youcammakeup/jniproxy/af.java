// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class af
{

    protected boolean a;
    private long b;

    public af()
    {
        this(UIVenusJNI.new_UIFaceMouth(), true);
    }

    protected af(long l1, boolean flag)
    {
        a = flag;
        b = l1;
    }

    protected static long a(af af1)
    {
        if (af1 == null)
        {
            return 0L;
        } else
        {
            return af1.b;
        }
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                UIVenusJNI.delete_UIFaceMouth(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_leftCorner_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l1 = UIVenusJNI.UIFaceMouth_leftCorner_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void b(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_topLip1_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l1 = UIVenusJNI.UIFaceMouth_topLip1_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void c(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_topLip2_set(b, this, ah.a(ah1), ah1);
    }

    public ah d()
    {
        long l1 = UIVenusJNI.UIFaceMouth_topLip2_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void d(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_rightCorner_set(b, this, ah.a(ah1), ah1);
    }

    public ah e()
    {
        long l1 = UIVenusJNI.UIFaceMouth_rightCorner_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void e(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_bottomLip1_set(b, this, ah.a(ah1), ah1);
    }

    public ah f()
    {
        long l1 = UIVenusJNI.UIFaceMouth_bottomLip1_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void f(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_bottomLip2_set(b, this, ah.a(ah1), ah1);
    }

    protected void finalize()
    {
        a();
    }

    public ah g()
    {
        long l1 = UIVenusJNI.UIFaceMouth_bottomLip2_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void g(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpTopLeft_set(b, this, ah.a(ah1), ah1);
    }

    public ah h()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpTopLeft_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void h(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpTopRight_set(b, this, ah.a(ah1), ah1);
    }

    public ah i()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpTopRight_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void i(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpBottomLeft_set(b, this, ah.a(ah1), ah1);
    }

    public ah j()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpBottomLeft_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void j(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpBottomRight_set(b, this, ah.a(ah1), ah1);
    }

    public ah k()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpBottomRight_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void k(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpInnerLeft_set(b, this, ah.a(ah1), ah1);
    }

    public ah l()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpInnerLeft_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void l(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpInnerRight_set(b, this, ah.a(ah1), ah1);
    }

    public ah m()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpInnerRight_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void m(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpUpperLeft_set(b, this, ah.a(ah1), ah1);
    }

    public ah n()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpUpperLeft_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void n(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpUpperRight_set(b, this, ah.a(ah1), ah1);
    }

    public ah o()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpUpperRight_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void o(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpLowerLeft_set(b, this, ah.a(ah1), ah1);
    }

    public ah p()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpLowerLeft_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }

    public void p(ah ah1)
    {
        UIVenusJNI.UIFaceMouth_interpLowerRight_set(b, this, ah.a(ah1), ah1);
    }

    public ah q()
    {
        long l1 = UIVenusJNI.UIFaceMouth_interpLowerRight_get(b, this);
        if (l1 == 0L)
        {
            return null;
        } else
        {
            return new ah(l1, false);
        }
    }
}
