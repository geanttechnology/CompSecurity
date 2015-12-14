// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, UIExifColorSpace

public class x
{

    protected boolean a;
    private long b;

    public x()
    {
        this(UIImageCodecJNI.new_UIExifInfo(), true);
    }

    protected x(long l, boolean flag)
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
                UIImageCodecJNI.delete_UIExifInfo(b);
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

    public UIExifColorSpace b()
    {
        return UIExifColorSpace.a(UIImageCodecJNI.UIExifInfo_nColorSpace_get(b, this));
    }

    protected void finalize()
    {
        a();
    }
}
