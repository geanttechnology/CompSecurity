// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class av
{

    protected boolean a;
    private long b;

    public av()
    {
        this(UIVenusJNI.new_UIIntVector__SWIG_0(), true);
    }

    protected av(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(av av1)
    {
        if (av1 == null)
        {
            return 0L;
        } else
        {
            return av1.b;
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
                UIVenusJNI.delete_UIIntVector(b);
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
        UIVenusJNI.UIIntVector_add(b, this, i);
    }

    public int b(int i)
    {
        return UIVenusJNI.UIIntVector_get(b, this, i);
    }

    public long b()
    {
        return UIVenusJNI.UIIntVector_size(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
