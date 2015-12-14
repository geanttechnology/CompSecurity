// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.cyberlink.youcammakeup.venus:
//            MutableFloat, CPUUtility, MutableInteger

public class CommonShare
{

    protected static boolean m_is_dump_cpu_info = true;

    public CommonShare()
    {
    }

    public static void WriteResourceDrawable(Resources resources, int i, String s, android.graphics.Bitmap.CompressFormat compressformat, int j)
    {
        Bitmap bitmap = BitmapFactory.decodeResource(resources, i);
        resources = new File(s);
        try
        {
            resources = new FileOutputStream(resources);
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            resources.printStackTrace();
            resources = null;
        }
        bitmap.compress(compressformat, j, resources);
        try
        {
            resources.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            resources.printStackTrace();
        }
    }

    public static void copyfile(String s, String s1)
    {
        byte abyte0[];
        s = new File(s);
        s1 = new File(s1);
        s = new FileInputStream(s);
        s1 = new FileOutputStream(s1);
        abyte0 = new byte[1024];
_L1:
        int i = s.read(abyte0);
label0:
        {
            if (i <= 0)
            {
                break label0;
            }
            try
            {
                s1.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return;
            }
        }
          goto _L1
        s.close();
        s1.close();
        return;
    }

    public static Bitmap decodeFileToFitResolution(String s, int i, int j, MutableFloat mutablefloat)
    {
        Object obj = null;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inMutable = true;
        float f;
        float f1;
        float f2;
        try
        {
            BitmapFactory.decodeFile(s, options);
        }
        catch (Exception exception)
        {
            Log.e("Exception", (new StringBuilder()).append("Error ").append(exception.toString()).toString());
        }
        f2 = options.outWidth;
        f = options.outHeight;
        f = (float)i / (float)options.outWidth;
        f1 = (float)j / (float)options.outHeight;
        if (f >= f1)
        {
            f = f1;
        }
        if (f < 1.0F)
        {
            int k = (int)(1.0F / f);
            options.inJustDecodeBounds = false;
            options.inSampleSize = k;
            int l;
            try
            {
                s = BitmapFactory.decodeFile(s, options);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("Exception", (new StringBuilder()).append("Error ").append(s.toString()).toString());
                s = ((String) (obj));
            }
        } else
        {
            try
            {
                s = BitmapFactory.decodeFile(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("Exception", (new StringBuilder()).append("Error ").append(s.toString()).toString());
                s = ((String) (obj));
            }
        }
        k = s.getWidth();
        l = s.getHeight();
        f = (float)i / (float)k;
        f1 = (float)j / (float)l;
        if (f >= f1)
        {
            f = f1;
        }
        obj = s;
        if (f != 1.0F)
        {
            obj = Bitmap.createScaledBitmap(s, Math.round((float)k * f), Math.round(f * (float)l), false);
            s.recycle();
        }
        mutablefloat.value = (float)((Bitmap) (obj)).getWidth() / f2;
        return ((Bitmap) (obj));
    }

    public static boolean getCpuFrequency(int ai[], int ai1[], double ad[])
    {
        if (ai.length != 1 || ai1.length != 1 || ad.length != 1)
        {
            return false;
        }
        try
        {
            ai[0] = CPUUtility.getCPUFrequencyCurrent();
            ai1[0] = CPUUtility.getCPUFrequencyMax();
            ad[0] = (100D * (double)ai[0]) / (double)ai1[0];
        }
        catch (Exception exception)
        {
            ai[0] = 0;
            ai1[0] = 0;
            ad[0] = 0.0D;
            return false;
        }
        return true;
    }

    public static void getImageResolution(String s, MutableInteger mutableinteger, MutableInteger mutableinteger1)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try
        {
            BitmapFactory.decodeFile(s, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Exception", (new StringBuilder()).append("Error ").append(s.toString()).toString());
        }
        mutableinteger.value = options.outWidth;
        mutableinteger1.value = options.outHeight;
    }

    public static String getTempFilename()
    {
        return getTempFilename("");
    }

    public static String getTempFilename(String s)
    {
        String s1 = openTempFolder();
        String s2 = Long.toString(System.currentTimeMillis());
        byte abyte0[];
        StringBuilder stringbuilder;
        int j;
        try
        {
            abyte0 = MessageDigest.getInstance("MD5").digest(s2.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("No MD5 supported.", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 is supported.", s);
        }
        stringbuilder = new StringBuilder(abyte0.length * 2);
        j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            int k = abyte0[i] & 0xff;
            if (k < 16)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(Integer.toHexString(k));
        }

        return (new StringBuilder()).append(s1).append("/").append(stringbuilder.toString()).append(s).append(".jpg").toString();
    }

    public static String openTempFolder()
    {
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/tmp").toString();
        File file = new File(s);
        if (!file.exists())
        {
            file.mkdir();
        }
        return s;
    }

}
