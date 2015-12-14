// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI

public class q
{

    protected boolean a;
    private long b;

    public q()
    {
        this(UIImageCodecJNI.new_UICancellationToken(), true);
    }

    protected q(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(q q1)
    {
        if (q1 == null)
        {
            return 0L;
        } else
        {
            return q1.b;
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
                UIImageCodecJNI.delete_UICancellationToken(b);
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

    public void b()
    {
        UIImageCodecJNI.UICancellationToken_Cancel(b, this);
    }

    public boolean c()
    {
        return UIImageCodecJNI.UICancellationToken_IsCancelled(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
