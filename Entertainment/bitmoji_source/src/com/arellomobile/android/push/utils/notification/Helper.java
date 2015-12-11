// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.notification;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Helper
{

    public Helper()
    {
    }

    public static Bitmap getScaleBitmap(Bitmap bitmap, int i, Context context)
    {
        i = (int)((float)i * context.getResources().getDisplayMetrics().density);
        return Bitmap.createScaledBitmap(bitmap, (bitmap.getWidth() * i) / bitmap.getHeight(), i, true);
    }

    public static Bitmap tryToGetBitmapFromInternet(String s, Context context, int i)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        s = (new URL(s)).openConnection();
        s.connect();
        s = s.getInputStream();
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte1[];
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte1 = new byte[1024];
_L5:
        int j = s.read(abyte1);
        if (j == -1) goto _L4; else goto _L3
_L3:
        bytearrayoutputstream.write(abyte1, 0, j);
          goto _L5
        context;
_L9:
        float f;
        byte abyte0[];
        android.graphics.BitmapFactory.Options options;
        int k;
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        System.gc();
_L2:
        return null;
_L4:
        s.close();
        bytearrayoutputstream.close();
        abyte0 = bytearrayoutputstream.toByteArray();
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        k = Math.max(options.outWidth, options.outHeight);
        f = 1.0F;
        if (-1 == i)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        f = (float)k / ((float)i * context.getResources().getDisplayMetrics().density);
        options.inJustDecodeBounds = false;
        options.inSampleSize = Math.round(f);
        context = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        System.gc();
        return context;
        context;
        s = null;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        System.gc();
        throw context;
        context;
        if (true) goto _L7; else goto _L6
_L6:
        s;
        s = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static int tryToGetIconFormStringOrGetFromApplication(String s, Context context)
    {
        int i = context.getApplicationInfo().icon;
        if (s != null)
        {
            int j = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
            if (j != 0)
            {
                return j;
            }
        }
        return i;
    }
}
