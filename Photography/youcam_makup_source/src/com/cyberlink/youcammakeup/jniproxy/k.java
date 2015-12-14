// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIImageCodecJNI, d, t, UIImageCodecErrorCode, 
//            q, v, ba, UIImageOrientation, 
//            UIInterpolation, UIImageFormat, ap, bd

public class k
{

    protected boolean a;
    private long b;

    protected k(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    public k(String s)
    {
        this(UIImageCodecJNI.new_ImageCodec(s), true);
    }

    public UIImageCodecErrorCode a(String s, d d1, t t1)
    {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromFile__SWIG_1(b, this, s, d.a(d1), d1, t.a(t1), t1));
    }

    public UIImageCodecErrorCode a(String s, d d1, t t1, q q1)
    {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromFile__SWIG_0(b, this, s, d.a(d1), d1, t.a(t1), t1, q.a(q1), q1));
    }

    public UIImageCodecErrorCode a(String s, d d1, v v1, ba ba1)
    {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_EncodeToFile__SWIG_1(b, this, s, d.a(d1), d1, v.a(v1), v1, ba.a(ba1), ba1));
    }

    public UIImageCodecErrorCode a(String s, d d1, v v1, ba ba1, q q1)
    {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_EncodeToFile__SWIG_0(b, this, s, d.a(d1), d1, v.a(v1), v1, ba.a(ba1), ba1, q.a(q1), q1));
    }

    public UIImageCodecErrorCode a(byte abyte0[], int i, d d1, t t1)
    {
        return UIImageCodecErrorCode.a(UIImageCodecJNI.ImageCodec_DecodeFromBuffer__SWIG_1(b, this, abyte0, i, d.a(d1), d1, t.a(t1), t1));
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
                UIImageCodecJNI.delete_ImageCodec(b);
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

    public void a(ba ba1)
    {
        UIImageCodecJNI.ImageCodec_DumpMetadata(b, this, ba.a(ba1), ba1);
    }

    public boolean a(d d1, d d2)
    {
        return UIImageCodecJNI.ImageCodec_Stretch__SWIG_1(b, this, d.a(d1), d1, d.a(d2), d2);
    }

    public boolean a(d d1, d d2, UIImageOrientation uiimageorientation)
    {
        return UIImageCodecJNI.ImageCodec_RotateFlip(b, this, d.a(d1), d1, d.a(d2), d2, uiimageorientation.a());
    }

    public boolean a(d d1, d d2, UIInterpolation uiinterpolation)
    {
        return UIImageCodecJNI.ImageCodec_Stretch__SWIG_0(b, this, d.a(d1), d1, d.a(d2), d2, uiinterpolation.a());
    }

    public boolean a(String s, UIImageFormat uiimageformat, long l, ap ap1)
    {
        return UIImageCodecJNI.ImageCodec_CalcOutputDimension(b, this, s, uiimageformat.a(), l, ap.a(ap1), ap1);
    }

    public boolean a(String s, ba ba1)
    {
        return UIImageCodecJNI.ImageCodec_GetMetadataFromFile(b, this, s, ba.a(ba1), ba1);
    }

    public boolean a(String s, bd bd1)
    {
        return UIImageCodecJNI.ImageCodec_GetThumbnailPropertyFromFile(b, this, s, bd.a(bd1), bd1);
    }

    public boolean a(String s, d d1)
    {
        return UIImageCodecJNI.ImageCodec_GetThumbnailFromFile__SWIG_1(b, this, s, d.a(d1), d1);
    }

    public boolean a(String s, d d1, boolean flag)
    {
        return UIImageCodecJNI.ImageCodec_GetThumbnailFromFile__SWIG_0(b, this, s, d.a(d1), d1, flag);
    }

    public boolean a(byte abyte0[], int i, UIImageFormat uiimageformat, long l, ap ap1)
    {
        return UIImageCodecJNI.ImageCodec_CalcOutputDimensionFromBuffer(b, this, abyte0, i, uiimageformat.a(), l, ap.a(ap1), ap1);
    }

    public boolean a(byte abyte0[], int i, ba ba1)
    {
        return UIImageCodecJNI.ImageCodec_GetMetadataFromBuffer(b, this, abyte0, i, ba.a(ba1), ba1);
    }

    protected void finalize()
    {
        a();
    }
}
