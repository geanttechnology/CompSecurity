// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class ai
{

    protected boolean a;
    private long b;

    public ai()
    {
        this(UIVenusJNI.new_UIFaceRect__SWIG_0(), true);
    }

    protected ai(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public ai(ai ai1)
    {
        this(UIVenusJNI.new_UIFaceRect__SWIG_1(a(ai1), ai1), true);
    }

    protected static long a(ai ai1)
    {
        if (ai1 == null)
        {
            return 0L;
        } else
        {
            return ai1.b;
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
                UIVenusJNI.delete_UIFaceRect(b);
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
        UIVenusJNI.UIFaceRect_setLeft(b, this, i);
    }

    public int b()
    {
        return UIVenusJNI.UIFaceRect_getLeft(b, this);
    }

    public void b(int i)
    {
        UIVenusJNI.UIFaceRect_setTop(b, this, i);
    }

    public int c()
    {
        return UIVenusJNI.UIFaceRect_getTop(b, this);
    }

    public void c(int i)
    {
        UIVenusJNI.UIFaceRect_setRight(b, this, i);
    }

    public int d()
    {
        return UIVenusJNI.UIFaceRect_getRight(b, this);
    }

    public void d(int i)
    {
        UIVenusJNI.UIFaceRect_setBottom(b, this, i);
    }

    public int e()
    {
        return UIVenusJNI.UIFaceRect_getBottom(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
