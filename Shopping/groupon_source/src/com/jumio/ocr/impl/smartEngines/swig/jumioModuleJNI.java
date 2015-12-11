// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


public class jumioModuleJNI
{

    public jumioModuleJNI()
    {
    }

    public static final native int getCpuCount();

    public static final native int getCpuFamily();

    public static final native int getCpuFeatures();

    public static final native int yuv2rgb(byte abyte0[], byte abyte1[], int i, int j);

    public static final native int yuvCutRotateScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1);

    public static final native int yuvCutRotateScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1);

    public static final native int yuvCutScale(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1);

    public static final native int yuvCutScale2rgb(byte abyte0[], int i, int j, int k, int l, int i1, int j1, byte abyte1[], 
            int k1, int l1);
}
