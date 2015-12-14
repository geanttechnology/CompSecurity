// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class ax
{

    protected boolean a;
    private long b;

    public ax()
    {
        this(UIVenusJNI.new_UIIrisRadius__SWIG_0(), true);
    }

    protected ax(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public ax(ax ax1)
    {
        this(UIVenusJNI.new_UIIrisRadius__SWIG_1(a(ax1), ax1), true);
    }

    protected static long a(ax ax1)
    {
        if (ax1 == null)
        {
            return 0L;
        } else
        {
            return ax1.b;
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
                UIVenusJNI.delete_UIIrisRadius(b);
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
        UIVenusJNI.UIIrisRadius_setValue(b, this, i);
    }

    public int b()
    {
        return UIVenusJNI.UIIrisRadius_getValue(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
