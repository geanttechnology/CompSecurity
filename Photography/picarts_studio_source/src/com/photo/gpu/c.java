// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.net.URL;

// Referenced classes of package com.photo.gpu:
//            b, GPUImage

final class c extends b
{

    private final Uri a;
    private GPUImage b;

    public c(GPUImage gpuimage, GPUImage gpuimage1, Uri uri)
    {
        b = gpuimage;
        super(gpuimage, gpuimage1);
        a = uri;
    }

    protected final int a()
    {
        Cursor cursor = b.a.getContentResolver().query(a, new String[] {
            "orientation"
        }, null, null, null);
        if (cursor == null || cursor.getCount() != 1)
        {
            return 0;
        } else
        {
            cursor.moveToFirst();
            int i = cursor.getInt(0);
            cursor.close();
            return i;
        }
    }

    protected final Bitmap a(android.graphics.BitmapFactory.Options options)
    {
        try
        {
            java.io.InputStream inputstream;
            if (a.getScheme().startsWith("http") || a.getScheme().startsWith("https"))
            {
                inputstream = (new URL(a.toString())).openStream();
            } else
            {
                inputstream = b.a.getContentResolver().openInputStream(a);
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
