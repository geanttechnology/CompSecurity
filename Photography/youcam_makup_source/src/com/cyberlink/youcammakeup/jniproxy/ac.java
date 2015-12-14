// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ah

public class ac
{

    protected boolean a;
    private long b;

    public ac()
    {
        this(UIVenusJNI.new_UIFaceEye(), true);
    }

    protected ac(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ac ac1)
    {
        if (ac1 == null)
        {
            return 0L;
        } else
        {
            return ac1.b;
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
                UIVenusJNI.delete_UIFaceEye(b);
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
        UIVenusJNI.UIFaceEye_left_set(b, this, ah.a(ah1), ah1);
    }

    public ah b()
    {
        long l = UIVenusJNI.UIFaceEye_left_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void b(ah ah1)
    {
        UIVenusJNI.UIFaceEye_top_set(b, this, ah.a(ah1), ah1);
    }

    public ah c()
    {
        long l = UIVenusJNI.UIFaceEye_top_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void c(ah ah1)
    {
        UIVenusJNI.UIFaceEye_right_set(b, this, ah.a(ah1), ah1);
    }

    public ah d()
    {
        long l = UIVenusJNI.UIFaceEye_right_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void d(ah ah1)
    {
        UIVenusJNI.UIFaceEye_bottom_set(b, this, ah.a(ah1), ah1);
    }

    public ah e()
    {
        long l = UIVenusJNI.UIFaceEye_bottom_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    public void e(ah ah1)
    {
        UIVenusJNI.UIFaceEye_center_set(b, this, ah.a(ah1), ah1);
    }

    public ah f()
    {
        long l = UIVenusJNI.UIFaceEye_center_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new ah(l, false);
        }
    }

    protected void finalize()
    {
        a();
    }
}
