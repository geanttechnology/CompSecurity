// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            CommonJNI

public class p
{

    protected boolean a;
    private long b;

    public p()
    {
        this(CommonJNI.new_UICacheFileInfo(), true);
    }

    protected p(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(p p1)
    {
        if (p1 == null)
        {
            return 0L;
        } else
        {
            return p1.b;
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
                CommonJNI.delete_UICacheFileInfo(b);
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
        return CommonJNI.UICacheFileInfo_ulWidth_get(b, this);
    }

    public long c()
    {
        return CommonJNI.UICacheFileInfo_ulHeight_get(b, this);
    }

    public long d()
    {
        return CommonJNI.UICacheFileInfo_ulBpp_get(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
