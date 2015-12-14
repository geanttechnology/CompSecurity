// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class al
{

    protected boolean a;
    private long b;

    public al()
    {
        this(UIVenusJNI.new_UIFaceTattooColor(), true);
    }

    protected al(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(al al1)
    {
        if (al1 == null)
        {
            return 0L;
        } else
        {
            return al1.b;
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
                UIVenusJNI.delete_UIFaceTattooColor(b);
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

    public void a(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setRRatio(b, this, j);
    }

    public void a(boolean flag)
    {
        UIVenusJNI.UIFaceTattooColor_setColorAdjustable(b, this, flag);
    }

    public void b(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setGRatio(b, this, j);
    }

    public void c(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setBRatio(b, this, j);
    }

    public void d(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setBrightness(b, this, j);
    }

    public void e(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setContrastFirstOldy(b, this, j);
    }

    public void f(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setContrastFirstNewy(b, this, j);
    }

    protected void finalize()
    {
        a();
    }

    public void g(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setContrastSecondOldy(b, this, j);
    }

    public void h(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setContrastSecondNewy(b, this, j);
    }

    public void i(int j)
    {
        UIVenusJNI.UIFaceTattooColor_setLuminanceParameter(b, this, j);
    }
}
