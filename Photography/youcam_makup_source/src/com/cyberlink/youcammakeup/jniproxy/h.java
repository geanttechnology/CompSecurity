// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            CommonJNI

public class h
{

    protected boolean a;
    private long b;

    protected h(long l, boolean flag)
    {
        a = flag;
        b = l;
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
                CommonJNI.delete_IDestroyable(b);
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
        CommonJNI.IDestroyable_Destroy(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
