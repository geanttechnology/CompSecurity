// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;

import android.graphics.Bitmap;
import com.socialin.android.NoProGuard;
import java.io.File;
import java.nio.ByteBuffer;

public class GifEncoder
    implements NoProGuard
{

    public GifEncoder()
    {
    }

    public static native void convertToYUV21(int ai[], byte abyte0[], int i, int j);

    public static native ByteBuffer getBitmapInYUV(Bitmap bitmap);

    public native int addFrame(int ai[]);

    public void cancelGifGeneration(String s)
    {
        close();
        try
        {
            s = new File(s);
            if (s.exists())
            {
                s.delete();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public native void close();

    public native int init(String s, int i, int j, int k, int l, int i1);

    static 
    {
        System.loadLibrary("gifencoder");
    }
}
