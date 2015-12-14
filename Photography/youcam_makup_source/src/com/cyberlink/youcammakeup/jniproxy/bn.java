// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class bn
{

    protected boolean a;
    private long b;

    public bn()
    {
        this(UIVenusJNI.new_UIWigLuminance__SWIG_0(), true);
    }

    protected bn(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public bn(bn bn1)
    {
        this(UIVenusJNI.new_UIWigLuminance__SWIG_1(a(bn1), bn1), true);
    }

    protected static long a(bn bn1)
    {
        if (bn1 == null)
        {
            return 0L;
        } else
        {
            return bn1.b;
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
                UIVenusJNI.delete_UIWigLuminance(b);
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
        UIVenusJNI.UIWigLuminance_setValue(b, this, i);
    }

    public int b()
    {
        return UIVenusJNI.UIWigLuminance_getValue(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
