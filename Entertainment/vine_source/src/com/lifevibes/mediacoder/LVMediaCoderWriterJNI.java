// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.lifevibes.mediacoder;


class LVMediaCoderWriterJNI
{

    LVMediaCoderWriterJNI()
    {
    }

    public static final native int LVMediaCoderInitWriter(String s);

    public static final native int LVMediaCoderWriterAddStreamAudio(int i, byte abyte0[], int j, int k, int l, int i1);

    public static final native int LVMediaCoderWriterAddStreamVideo(int i, byte abyte0[], int j, int k, int l);

    public static final native int LVMediaCoderWriterClose(int i);

    public static final native int LVMediaCoderWriterProcess(int i, int j, double d, double d1, byte abyte0[], int k);

    public static final native char RGB888toYUV420WithPlanar(byte abyte0[], byte abyte1[], int i, int j, int k);

    public static final native char RGB888toYUV420WithSemiPlanar(byte abyte0[], byte abyte1[], int i, int j, int k);

    public static final native char RGB888toYUV420WithStride512Aligned(byte abyte0[], byte abyte1[], int i, int j, int k, int l, int i1);

    public static final native char RGB888toYUV420WithUVInterchanged(byte abyte0[], byte abyte1[], int i, int j, int k);

    public static final native char RGB888toYUV420WithUVStride2KAligned(byte abyte0[], byte abyte1[], int i, int j, int k);
}
