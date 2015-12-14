// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class e
{

    private static final String a = com/inmobi/rendering/mraid/e.getSimpleName();

    public e()
    {
    }

    public static Bitmap a(String s, Context context, int i, int j)
    {
        j = i * j;
        double d;
        Object obj;
        int k;
        try
        {
            context = new FileInputStream(s);
            obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(context, null, ((android.graphics.BitmapFactory.Options) (obj)));
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, s.getMessage());
            return null;
        }
        i = 1;
        while ((double)(((android.graphics.BitmapFactory.Options) (obj)).outWidth * ((android.graphics.BitmapFactory.Options) (obj)).outHeight) * (1.0D / Math.pow(i, 2D)) > (double)j) 
        {
            i++;
        }
        context = new FileInputStream(s);
        if (i <= 1)
        {
            break MISSING_BLOCK_LABEL_219;
        }
        s = new android.graphics.BitmapFactory.Options();
        s.inSampleSize = i - 1;
        obj = BitmapFactory.decodeStream(context, null, s);
        i = ((Bitmap) (obj)).getHeight();
        k = ((Bitmap) (obj)).getWidth();
        d = Math.sqrt((double)j / ((double)k / (double)i));
        s = Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)((d / (double)i) * (double)k), (int)d, true);
        ((Bitmap) (obj)).recycle();
        System.gc();
_L1:
        context.close();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("bitmap size - width: ").append(s.getWidth()).append(", height: ").append(s.getHeight()).toString());
        return s;
        s = BitmapFactory.decodeStream(context);
          goto _L1
    }

    public static String a(Bitmap bitmap, Context context, int i)
    {
        context = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, i, context);
        return Base64.encodeToString(context.toByteArray(), 2);
    }

    public static String a(Uri uri, Context context)
    {
        uri = context.getContentResolver().query(uri, new String[] {
            "_data"
        }, null, null, null);
        int i = uri.getColumnIndexOrThrow("_data");
        uri.moveToFirst();
        context = uri.getString(i);
        uri.close();
        return context;
    }

}
