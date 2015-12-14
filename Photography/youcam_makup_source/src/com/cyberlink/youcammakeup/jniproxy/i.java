// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            h, CommonJNI, AccessMode

public class i extends h
{

    private long b;

    protected i(long l, boolean flag)
    {
        super(CommonJNI.IImageBuffer_SWIGUpcast(l), flag);
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
                CommonJNI.delete_IImageBuffer(b);
            }
            b = 0L;
        }
        super.a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(AccessMode accessmode)
    {
        CommonJNI.IImageBuffer_SetAccessMode(b, this, accessmode.a());
    }

    public long e()
    {
        return CommonJNI.IImageBuffer_GetWidth(b, this);
    }

    public long f()
    {
        return CommonJNI.IImageBuffer_GetHeight(b, this);
    }

    protected void finalize()
    {
        a();
    }

    public long g()
    {
        return CommonJNI.IImageBuffer_GetBytesPerPixel(b, this);
    }
}
