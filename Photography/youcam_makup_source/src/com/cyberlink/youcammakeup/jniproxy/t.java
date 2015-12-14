// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, UIBytePerPixel, UIImageFormat

public class t
{

    protected boolean a;
    private long b;

    public t()
    {
        this(UIImageCodecJNI.new_UIDecodeParamRef(), true);
    }

    protected t(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(t t1)
    {
        if (t1 == null)
        {
            return 0L;
        } else
        {
            return t1.b;
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
                UIImageCodecJNI.delete_UIDecodeParamRef(b);
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
        UIImageCodecJNI.UIDecodeParamRef_ulWidth_set(b, this, l);
    }

    public void a(UIBytePerPixel uibyteperpixel)
    {
        UIImageCodecJNI.UIDecodeParamRef_nBytePerPixel_set(b, this, uibyteperpixel.a());
    }

    public void a(UIImageFormat uiimageformat)
    {
        UIImageCodecJNI.UIDecodeParamRef_nFormat_set(b, this, uiimageformat.a());
    }

    public void b(long l)
    {
        UIImageCodecJNI.UIDecodeParamRef_ulHeight_set(b, this, l);
    }

    public void c(long l)
    {
        UIImageCodecJNI.UIDecodeParamRef_ulSampleSize_set(b, this, l);
    }

    protected void finalize()
    {
        a();
    }
}
