// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class bi
{

    protected boolean a;
    private long b;

    public bi()
    {
        this(UIVenusJNI.new_UITransform__SWIG_0(), true);
    }

    protected bi(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public bi(bi bi1)
    {
        this(UIVenusJNI.new_UITransform__SWIG_1(a(bi1), bi1), true);
    }

    protected static long a(bi bi1)
    {
        if (bi1 == null)
        {
            return 0L;
        } else
        {
            return bi1.b;
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
                UIVenusJNI.delete_UITransform(b);
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

    public void a(float f)
    {
        UIVenusJNI.UITransform_setScale(b, this, f);
    }

    public float b()
    {
        return UIVenusJNI.UITransform_getScale(b, this);
    }

    public void b(float f)
    {
        UIVenusJNI.UITransform_setRotation(b, this, f);
    }

    public float c()
    {
        return UIVenusJNI.UITransform_getRotation(b, this);
    }

    public void c(float f)
    {
        UIVenusJNI.UITransform_setShiftX(b, this, f);
    }

    public float d()
    {
        return UIVenusJNI.UITransform_getShiftX(b, this);
    }

    public void d(float f)
    {
        UIVenusJNI.UITransform_setShiftY(b, this, f);
    }

    public float e()
    {
        return UIVenusJNI.UITransform_getShiftY(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
