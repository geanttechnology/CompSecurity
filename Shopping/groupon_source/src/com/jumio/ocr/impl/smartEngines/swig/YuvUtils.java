// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jniInterfaceJNI

public class YuvUtils
{

    private long a;
    protected boolean swigCMemOwn;

    public YuvUtils()
    {
        this(jniInterfaceJNI.new_YuvUtils(), true);
    }

    protected YuvUtils(long l, boolean flag)
    {
        swigCMemOwn = flag;
        a = l;
    }

    protected static long getCPtr(YuvUtils yuvutils)
    {
        if (yuvutils == null)
        {
            return 0L;
        } else
        {
            return yuvutils.a;
        }
    }

    public static int yuv2rgb(byte abyte0[], byte abyte1[], int i, int j)
    {
        return jniInterfaceJNI.YuvUtils_yuv2rgb(abyte0, abyte1, i, j);
    }

    public static int yuvCutRotateScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jniInterfaceJNI.YuvUtils_yuvCutRotateScale(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutRotateScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jniInterfaceJNI.YuvUtils_yuvCutRotateScale2rgb(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jniInterfaceJNI.YuvUtils_yuvCutScale(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jniInterfaceJNI.YuvUtils_yuvCutScale2rgb(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
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
                jniInterfaceJNI.delete_YuvUtils(a);
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
