// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class at
{

    protected boolean a;
    private long b;

    public at()
    {
        this(UIVenusJNI.new_UIIntPoint__SWIG_0(), true);
    }

    protected at(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(at at1)
    {
        if (at1 == null)
        {
            return 0L;
        } else
        {
            return at1.b;
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
                UIVenusJNI.delete_UIIntPoint(b);
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
        UIVenusJNI.UIIntPoint_x_set(b, this, i);
    }

    public void b(int i)
    {
        UIVenusJNI.UIIntPoint_y_set(b, this, i);
    }

    protected void finalize()
    {
        a();
    }
}
