// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            i, CommonJNI, PixelFormat, as, 
//            p, AccessMode

public class d extends i
{

    private long b;

    public d()
    {
        this(CommonJNI.new_CImageBuffer__SWIG_1(), true);
    }

    protected d(long l, boolean flag)
    {
        super(CommonJNI.CImageBuffer_SWIGUpcast(l), flag);
        b = l;
    }

    public d(PixelFormat pixelformat)
    {
        this(CommonJNI.new_CImageBuffer__SWIG_0(pixelformat.a()), true);
    }

    protected static long a(d d1)
    {
        if (d1 == null)
        {
            return 0L;
        } else
        {
            return d1.b;
        }
    }

    public static boolean a(d d1, d d2)
    {
        return CommonJNI.CImageBuffer_SwapColorChannel__SWIG_1(a(d1), d1, a(d2), d2);
    }

    public static boolean a(d d1, d d2, as as1)
    {
        return CommonJNI.CImageBuffer_CopyImageBufferToImageBuffer__SWIG_0(a(d1), d1, a(d2), d2, as.a(as1), as1);
    }

    public static boolean a(String s, p p1)
    {
        return CommonJNI.CImageBuffer_GetCacheFileInfo(s, p.a(p1), p1);
    }

    public static boolean b(d d1)
    {
        return CommonJNI.CImageBuffer_SwapColorChannel__SWIG_0(a(d1), d1);
    }

    public static boolean b(d d1, d d2)
    {
        return CommonJNI.CImageBuffer_ConvertColorDepth(a(d1), d1, a(d2), d2);
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
                CommonJNI.delete_CImageBuffer(b);
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
        CommonJNI.CImageBuffer_SetAccessMode(b, this, accessmode.a());
    }

    public void a(PixelFormat pixelformat)
    {
        CommonJNI.CImageBuffer_SetPixelFormat(b, this, pixelformat.a());
    }

    public boolean a(long l, long l1, long l2)
    {
        return CommonJNI.CImageBuffer_CreateBuffer(b, this, l, l1, l2);
    }

    public boolean a(d d1, as as1)
    {
        return CommonJNI.CImageBuffer_CreateFromImageBuffer(b, this, a(d1), d1, as.a(as1), as1);
    }

    public boolean a(Object obj)
    {
        return CommonJNI.CImageBuffer_AttachAndroidBitmap(b, this, obj);
    }

    public boolean a(String s)
    {
        return CommonJNI.CImageBuffer_LoadFromFile(b, this, s);
    }

    public void b()
    {
        CommonJNI.CImageBuffer_Destroy(b, this);
    }

    public boolean b(Object obj)
    {
        return CommonJNI.CImageBuffer_CopyToAndroidBitmap(b, this, obj);
    }

    public boolean b(String s)
    {
        return CommonJNI.CImageBuffer_DumpToFile(b, this, s);
    }

    public boolean c()
    {
        return CommonJNI.CImageBuffer_DetachAndroidBitmap(b, this);
    }

    public boolean c(Object obj)
    {
        return CommonJNI.CImageBuffer_ApplyMaskBitmap(b, this, obj);
    }

    public boolean d()
    {
        return CommonJNI.CImageBuffer_ClearAlphaChannel(b, this);
    }

    public long e()
    {
        return CommonJNI.CImageBuffer_GetWidth(b, this);
    }

    public long f()
    {
        return CommonJNI.CImageBuffer_GetHeight(b, this);
    }

    protected void finalize()
    {
        a();
    }

    public long g()
    {
        return CommonJNI.CImageBuffer_GetBytesPerPixel(b, this);
    }

    public PixelFormat h()
    {
        return PixelFormat.a(CommonJNI.CImageBuffer_GetPixelFormat(b, this));
    }
}
