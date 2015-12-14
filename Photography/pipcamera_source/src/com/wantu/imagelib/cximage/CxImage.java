// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.cximage;

import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class CxImage
{

    Bitmap a;

    public CxImage(Bitmap bitmap)
    {
        a = bitmap;
    }

    private native byte[] alterABColor(byte abyte0[], int i);

    private native byte[] edge(byte abyte0[], int i);

    private native byte[] erode(byte abyte0[], long l);

    private native byte[] fisheye(byte abyte0[], float f);

    private native byte[] gaussianBlur(byte abyte0[], int i, float f);

    private native byte[] mix(byte abyte0[], int i, byte abyte1[], int j, int k);

    public Bitmap a()
    {
        return a;
    }

    public void a(Bitmap bitmap)
    {
        a = bitmap;
    }

    protected void a(byte abyte0[])
    {
        Log.d("CxImage", "onPostProcess start");
        abyte0 = ByteBuffer.wrap(abyte0);
        if (a.getConfig() != android.graphics.Bitmap.Config.ARGB_8888)
        {
            a = Bitmap.createBitmap(a.getWidth(), a.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        }
        a.copyPixelsFromBuffer(abyte0);
        Log.d("CxImage", "onPostProcess end");
    }

    public boolean a(float f)
    {
        byte abyte0[] = b();
        abyte0 = gaussianBlur(abyte0, abyte0.length, f);
        if (abyte0 == null)
        {
            return false;
        } else
        {
            a(abyte0);
            return true;
        }
    }

    public boolean a(int i)
    {
        byte abyte0[] = edge(b(), i);
        if (abyte0 == null)
        {
            return false;
        } else
        {
            a(abyte0);
            return true;
        }
    }

    public boolean a(long l)
    {
        byte abyte0[] = erode(b(), l);
        if (abyte0 == null)
        {
            return false;
        } else
        {
            a(abyte0);
            return true;
        }
    }

    public boolean a(Bitmap bitmap, int i)
    {
        byte abyte0[] = b();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 0, bytearrayoutputstream);
        bitmap = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Crashlytics.logException(ioexception);
        }
        bitmap = mix(abyte0, abyte0.length, bitmap, bitmap.length, i);
        if (bitmap == null)
        {
            return false;
        } else
        {
            a(((byte []) (bitmap)));
            return true;
        }
    }

    public boolean b(float f)
    {
        byte abyte0[] = fisheye(b(), f);
        if (abyte0 == null)
        {
            return false;
        } else
        {
            a(abyte0);
            return true;
        }
    }

    protected byte[] b()
    {
        Log.d("CxImage", "onPrepare start");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Crashlytics.logException(ioexception);
        }
        Log.d("CxImage", "onPrepare end");
        return abyte0;
    }

    public boolean c()
    {
        byte abyte0[] = b();
        abyte0 = alterABColor(abyte0, abyte0.length);
        if (abyte0 == null)
        {
            return false;
        } else
        {
            a(abyte0);
            return true;
        }
    }

    static 
    {
        Log.v("System Path", System.getProperty("java.library.path"));
        System.loadLibrary("cximage");
    }
}
