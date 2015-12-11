// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;


public class FFmpegInvoke
{

    private String mPath;

    public FFmpegInvoke(String s)
    {
        mPath = s;
    }

    private native int run(String s, String as[]);

    public native void YUVtoRBG(int ai[], byte abyte0[], int i, int j);

    public int run(String as[])
    {
        return run(mPath, as);
    }
}
