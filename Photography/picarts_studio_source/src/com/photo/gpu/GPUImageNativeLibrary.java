// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;


public class GPUImageNativeLibrary
{

    public GPUImageNativeLibrary()
    {
    }

    public static native void YUVtoARBG(byte abyte0[], int i, int j, int ai[]);

    public static native void YUVtoRBGA(byte abyte0[], int i, int j, int ai[]);

    static 
    {
        System.loadLibrary("gpuimage-library");
    }
}
