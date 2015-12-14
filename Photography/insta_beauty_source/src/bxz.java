// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.net.URL;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class bxz extends bxy
{

    final GPUImage a;
    private final Uri c;

    public bxz(GPUImage gpuimage, GPUImage gpuimage1, Uri uri)
    {
        a = gpuimage;
        super(gpuimage, gpuimage1);
        c = uri;
    }

    protected int a()
    {
        Cursor cursor = GPUImage.b(a).getContentResolver().query(c, new String[] {
            "orientation"
        }, null, null, null);
        if (cursor == null || cursor.getCount() != 1)
        {
            return 0;
        } else
        {
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
    }

    protected Bitmap a(android.graphics.BitmapFactory.Options options)
    {
        try
        {
            java.io.InputStream inputstream;
            if (c.getScheme().startsWith("http") || c.getScheme().startsWith("https"))
            {
                inputstream = (new URL(c.toString())).openStream();
            } else
            {
                inputstream = GPUImage.b(a).getContentResolver().openInputStream(c);
            }
            return BitmapFactory.decodeStream(inputstream, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (android.graphics.BitmapFactory.Options options)
        {
            options.printStackTrace();
        }
        return null;
    }
}
