// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


// Referenced classes of package com.jumio.clientlib.impl.livenessAndTM:
//            jniLivenessAndTMJNI, PixelFormatType

public class ImgWarp
{

    private long a;
    protected boolean swigCMemOwn;

    public ImgWarp()
    {
        this(jniLivenessAndTMJNI.new_ImgWarp(), true);
    }

    protected ImgWarp(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(ImgWarp imgwarp)
    {
        if (imgwarp == null)
        {
            return 0L;
        } else
        {
            return imgwarp.a;
        }
    }

    public static void warp(byte abyte0[], long l, int i, int j, PixelFormatType pixelformattype, float f, float f1, 
            float f2, float f3, float f4, float f5, float f6, float f7, byte abyte1[], 
            int k, int i1)
    {
        jniLivenessAndTMJNI.ImgWarp_warp(abyte0, l, i, j, pixelformattype.swigValue(), f, f1, f2, f3, f4, f5, f6, f7, abyte1, k, i1);
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                jniLivenessAndTMJNI.delete_ImgWarp(a);
            }
            a = 0L;
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
        delete();
    }
}
