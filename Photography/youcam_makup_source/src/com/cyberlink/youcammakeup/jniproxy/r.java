// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class r
{

    protected boolean a;
    private long b;

    public r()
    {
        this(UIVenusJNI.new_UIColor__SWIG_0(), true);
    }

    public r(int i, int j, int k)
    {
        this(UIVenusJNI.new_UIColor__SWIG_1(i, j, k), true);
    }

    protected r(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(r r1)
    {
        if (r1 == null)
        {
            return 0L;
        } else
        {
            return r1.b;
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
                UIVenusJNI.delete_UIColor(b);
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
        UIVenusJNI.UIColor_setRLevel(b, this, i);
    }

    public void b(int i)
    {
        UIVenusJNI.UIColor_setGLevel(b, this, i);
    }

    public void c(int i)
    {
        UIVenusJNI.UIColor_setBLevel(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
