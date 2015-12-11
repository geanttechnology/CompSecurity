// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.FileDescriptor;

public class BitmapDecoder
{

    private static final String TAG = "BitmapDecoder";

    private BitmapDecoder()
    {
    }

    public static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int k;
        int l;
        int i1;
        l = options.outHeight;
        i1 = options.outWidth;
        k = 1;
        if (l <= j && i1 <= i) goto _L2; else goto _L1
_L1:
        float f;
        float f1;
        if (i1 > l)
        {
            k = Math.round((float)l / (float)j);
        } else
        {
            k = Math.round((float)i1 / (float)i);
        }
        f = i1 * l;
        f1 = i * j * 2;
_L5:
        if (f / (float)(k * k) > f1) goto _L3; else goto _L2
_L2:
        return k;
_L3:
        k++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor filedescriptor, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        options.inSampleSize = calculateInSampleSize(options, i, j);
        options.inJustDecodeBounds = false;
        try
        {
            filedescriptor = BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (FileDescriptor filedescriptor)
        {
            Log.e("BitmapDecoder", "decodeSampledBitmapFromDescriptor\u5185\u5B58\u6EA2\u51FA\uFF0C\u5982\u679C\u9891\u7E41\u51FA\u73B0\u8FD9\u4E2A\u60C5\u51B5 \u53EF\u4EE5\u5C1D\u8BD5\u914D\u7F6E\u589E\u52A0\u5185\u5B58\u7F13\u5B58\u5927\u5C0F");
            filedescriptor.printStackTrace();
            return null;
        }
        return filedescriptor;
    }

    public static Bitmap decodeSampledBitmapFromFile(String s, int i, int j)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        BitmapFactory.decodeFile(s, options);
        options.inSampleSize = calculateInSampleSize(options, i, j);
        options.inJustDecodeBounds = false;
        try
        {
            s = BitmapFactory.decodeFile(s, options);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("BitmapDecoder", "decodeSampledBitmapFromFile\u5185\u5B58\u6EA2\u51FA\uFF0C\u5982\u679C\u9891\u7E41\u51FA\u73B0\u8FD9\u4E2A\u60C5\u51B5 \u53EF\u4EE5\u5C1D\u8BD5\u914D\u7F6E\u589E\u52A0\u5185\u5B58\u7F13\u5B58\u5927\u5C0F");
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i, int j, int k)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPurgeable = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = calculateInSampleSize(options, j, k);
        options.inJustDecodeBounds = false;
        try
        {
            resources = BitmapFactory.decodeResource(resources, i, options);
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            Log.e("BitmapDecoder", "decodeSampledBitmapFromResource\u5185\u5B58\u6EA2\u51FA\uFF0C\u5982\u679C\u9891\u7E41\u51FA\u73B0\u8FD9\u4E2A\u60C5\u51B5 \u53EF\u4EE5\u5C1D\u8BD5\u914D\u7F6E\u589E\u52A0\u5185\u5B58\u7F13\u5B58\u5927\u5C0F");
            resources.printStackTrace();
            return null;
        }
        return resources;
    }
}
