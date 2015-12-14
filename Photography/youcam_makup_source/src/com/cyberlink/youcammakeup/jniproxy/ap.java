// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI

public class ap
{

    protected boolean a;
    private long b;

    public ap()
    {
        this(UIImageCodecJNI.new_UIImageDimension__SWIG_0(), true);
    }

    protected ap(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(ap ap1)
    {
        if (ap1 == null)
        {
            return 0L;
        } else
        {
            return ap1.b;
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
                UIImageCodecJNI.delete_UIImageDimension(b);
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

    public void a(long l)
    {
        UIImageCodecJNI.UIImageDimension_ulWidth_set(b, this, l);
    }

    public long b()
    {
        return UIImageCodecJNI.UIImageDimension_ulWidth_get(b, this);
    }

    public void b(long l)
    {
        UIImageCodecJNI.UIImageDimension_ulHeight_set(b, this, l);
    }

    public long c()
    {
        return UIImageCodecJNI.UIImageDimension_ulHeight_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
