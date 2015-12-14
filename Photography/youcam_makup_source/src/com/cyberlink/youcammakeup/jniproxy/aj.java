// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, ai

public class aj
{

    protected boolean a;
    private long b;

    public aj()
    {
        this(UIVenusJNI.new_UIFaceRectVector__SWIG_0(), true);
    }

    protected aj(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(aj aj1)
    {
        if (aj1 == null)
        {
            return 0L;
        } else
        {
            return aj1.b;
        }
    }

    public ai a(int i)
    {
        return new ai(UIVenusJNI.UIFaceRectVector_get(b, this, i), false);
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
                UIVenusJNI.delete_UIFaceRectVector(b);
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

    public long b()
    {
        return UIVenusJNI.UIFaceRectVector_size(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
