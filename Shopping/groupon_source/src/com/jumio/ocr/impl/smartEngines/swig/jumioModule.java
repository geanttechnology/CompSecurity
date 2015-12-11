// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


// Referenced classes of package com.jumio.ocr.impl.smartEngines.swig:
//            jumioModuleJNI

public class jumioModule
{

    public jumioModule()
    {
    }

    public static int getCpuCount()
    {
        return jumioModuleJNI.getCpuCount();
    }

    public static int getCpuFamily()
    {
        return jumioModuleJNI.getCpuFamily();
    }

    public static int getCpuFeatures()
    {
        return jumioModuleJNI.getCpuFeatures();
    }

    public static int yuv2rgb(byte abyte0[], byte abyte1[], int i, int j)
    {
        return jumioModuleJNI.yuv2rgb(abyte0, abyte1, i, j);
    }

    public static int yuvCutRotateScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jumioModuleJNI.yuvCutRotateScale(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutRotateScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jumioModuleJNI.yuvCutRotateScale2rgb(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jumioModuleJNI.yuvCutScale(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }

    public static int yuvCutScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1)
    {
        return jumioModuleJNI.yuvCutScale2rgb(abyte0, i, j, k, l, i1, j1, abyte1, k1, l1);
    }
}
