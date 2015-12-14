// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            CommonJNI

public class as
{

    protected boolean a;
    private long b;

    public as(long l, long l1, long l2, long l3)
    {
        this(CommonJNI.new_UIImageROI(l, l1, l2, l3), true);
    }

    protected as(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(as as1)
    {
        if (as1 == null)
        {
            return 0L;
        } else
        {
            return as1.b;
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
                CommonJNI.delete_UIImageROI(b);
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

    protected void finalize()
    {
        a();
    }
}
