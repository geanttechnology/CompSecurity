// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, at

public class au
{

    protected boolean a;
    private long b;

    public au()
    {
        this(UIVenusJNI.new_UIIntPointVector__SWIG_0(), true);
    }

    protected au(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(au au1)
    {
        if (au1 == null)
        {
            return 0L;
        } else
        {
            return au1.b;
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
                UIVenusJNI.delete_UIIntPointVector(b);
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

    public void a(at at1)
    {
        UIVenusJNI.UIIntPointVector_add(b, this, at.a(at1), at1);
    }

    protected void finalize()
    {
        a();
    }
}
