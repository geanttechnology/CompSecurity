// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI

public class bl
{

    protected boolean a;
    private long b;

    public bl()
    {
        this(UIVenusJNI.new_UIWarpedWigImageInfo__SWIG_0(), true);
    }

    protected bl(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(bl bl1)
    {
        if (bl1 == null)
        {
            return 0L;
        } else
        {
            return bl1.b;
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
                UIVenusJNI.delete_UIWarpedWigImageInfo(b);
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

    public int b()
    {
        return UIVenusJNI.UIWarpedWigImageInfo_width_get(b, this);
    }

    public int c()
    {
        return UIVenusJNI.UIWarpedWigImageInfo_height_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
