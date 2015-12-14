// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class bm
{

    protected boolean a;
    private long b;

    public bm()
    {
        this(UIVenusJNI.new_UIWigColor__SWIG_0(), true);
    }

    protected bm(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(bm bm1)
    {
        if (bm1 == null)
        {
            return 0L;
        } else
        {
            return bm1.b;
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
                UIVenusJNI.delete_UIWigColor(b);
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

    public void a(int i)
    {
        UIVenusJNI.UIWigColor_setBrightness(b, this, i);
    }

    public void b(int i)
    {
        UIVenusJNI.UIWigColor_setRRatio(b, this, i);
    }

    public void c(int i)
    {
        UIVenusJNI.UIWigColor_setGRatio(b, this, i);
    }

    public void d(int i)
    {
        UIVenusJNI.UIWigColor_setBRatio(b, this, i);
    }

    public void e(int i)
    {
        UIVenusJNI.UIWigColor_setContrastFirstOldy(b, this, i);
    }

    public void f(int i)
    {
        UIVenusJNI.UIWigColor_setContrastFirstNewy(b, this, i);
    }

    protected void finalize()
    {
        a();
    }

    public void g(int i)
    {
        UIVenusJNI.UIWigColor_setContrastSecondOldy(b, this, i);
    }

    public void h(int i)
    {
        UIVenusJNI.UIWigColor_setContrastSecondNewy(b, this, i);
    }
}
