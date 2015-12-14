// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;

public final class yh
{

    public static Cursor a(Activity activity, String s, String as[])
    {
        return activity.getContentResolver().query(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] {
            "_id", "_data", "_display_name", "picasa_id"
        }, s, as, "bucket_display_name");
    }

    public static Bitmap a(Activity activity, int i)
    {
        activity = a(activity, "_id=?", new String[] {
            (new StringBuilder()).append(i).append("").toString()
        });
        if (activity.getCount() <= 0)
        {
            activity.close();
        } else
        {
            activity.moveToPosition(0);
            String s = activity.getString(activity.getColumnIndexOrThrow("_data"));
            activity.close();
            if ((new File(s)).exists())
            {
                return a(s, 320);
            }
        }
        return null;
    }

    public static Bitmap a(String s, int i)
    {
        int j = 1;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s, options);
        if (options.outWidth > i || options.outHeight > i)
        {
            j = (int)Math.pow(2D, (int)Math.round(Math.log((double)i / (double)Math.max(options.outWidth, options.outHeight)) / Math.log(0.5D)));
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = j;
        return BitmapFactory.decodeFile(s, options);
    }
}
