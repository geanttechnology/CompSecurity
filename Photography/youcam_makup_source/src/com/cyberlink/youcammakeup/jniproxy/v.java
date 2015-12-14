// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, UIImageFormat, UITiffCompression, UIJPEGSubSampling, 
//            UIBytePerPixel, UIImageOrientation

public class v
{

    protected boolean a;
    private long b;

    public v()
    {
        this(UIImageCodecJNI.new_UIEncodeParamRef__SWIG_0(), true);
    }

    protected v(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public v(UIImageFormat uiimageformat, int i, UITiffCompression uitiffcompression, UIJPEGSubSampling uijpegsubsampling, UIBytePerPixel uibyteperpixel, UIImageOrientation uiimageorientation)
    {
        this(UIImageCodecJNI.new_UIEncodeParamRef__SWIG_1(uiimageformat.a(), i, uitiffcompression.a(), uijpegsubsampling.a(), uibyteperpixel.a(), uiimageorientation.a()), true);
    }

    protected static long a(v v1)
    {
        if (v1 == null)
        {
            return 0L;
        } else
        {
            return v1.b;
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
                UIImageCodecJNI.delete_UIEncodeParamRef(b);
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

    public void a(int i)
    {
        UIImageCodecJNI.UIEncodeParamRef_SetQuality(b, this, i);
    }

    public void a(UIImageFormat uiimageformat)
    {
        UIImageCodecJNI.UIEncodeParamRef_SetFormat(b, this, uiimageformat.a());
    }

    public void a(UIImageOrientation uiimageorientation)
    {
        UIImageCodecJNI.UIEncodeParamRef_SetImageOrientation(b, this, uiimageorientation.a());
    }

    public UIImageFormat b()
    {
        return UIImageFormat.a(UIImageCodecJNI.UIEncodeParamRef_GetFormat(b, this));
    }

    protected void finalize()
    {
        a();
    }
}
