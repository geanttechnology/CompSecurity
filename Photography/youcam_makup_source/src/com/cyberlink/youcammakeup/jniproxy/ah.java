// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class ah
{

    protected boolean a;
    private long b;

    public ah()
    {
        this(UIVenusJNI.new_UIFacePoint__SWIG_0(), true);
    }

    protected ah(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public ah(ah ah1)
    {
        this(UIVenusJNI.new_UIFacePoint__SWIG_1(a(ah1), ah1), true);
    }

    protected static long a(ah ah1)
    {
        if (ah1 == null)
        {
            return 0L;
        } else
        {
            return ah1.b;
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
                UIVenusJNI.delete_UIFacePoint(b);
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
        UIVenusJNI.UIFacePoint_x_set(b, this, f);
    }

    public float b()
    {
        return UIVenusJNI.UIFacePoint_x_get(b, this);
    }

    public void b(float f)
    {
        UIVenusJNI.UIFacePoint_y_set(b, this, f);
    }

    public float c()
    {
        return UIVenusJNI.UIFacePoint_y_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
