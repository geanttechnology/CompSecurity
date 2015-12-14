// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.ad;
import com.bumptech.glide.load.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import myobfuscated.aj.f;
import myobfuscated.aj.j;

public final class d
    implements g
{

    public static final c a = c.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    private static c b = c.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", Integer.valueOf(90));

    public d()
    {
    }

    private static boolean a(ad ad1, File file, e e1)
    {
        boolean flag1;
        Bitmap bitmap = (Bitmap)ad1.b();
        long l = f.a();
        ad1 = (android.graphics.Bitmap.CompressFormat)e1.a(a);
        int i;
        if (ad1 == null)
        {
            if (bitmap.hasAlpha())
            {
                ad1 = android.graphics.Bitmap.CompressFormat.PNG;
            } else
            {
                ad1 = android.graphics.Bitmap.CompressFormat.JPEG;
            }
        }
        i = ((Integer)e1.a(b)).intValue();
        flag1 = false;
        e1 = new FileOutputStream(file);
        file = e1;
        bitmap.compress(ad1, i, e1);
        file = e1;
        e1.close();
        boolean flag = true;
        try
        {
            e1.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        if (Log.isLoggable("BitmapEncoder", 2))
        {
            (new StringBuilder("Compressed with type: ")).append(ad1).append(" of size ").append(j.a(bitmap)).append(" in ").append(f.a(l));
        }
        return flag;
        file;
        e1 = null;
_L4:
        file = e1;
        Log.isLoggable("BitmapEncoder", 3);
        flag = flag1;
        if (e1 == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        try
        {
            e1.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            flag = flag1;
            break MISSING_BLOCK_LABEL_81;
        }
        flag = flag1;
        break MISSING_BLOCK_LABEL_81;
        ad1;
        file = null;
_L2:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        throw ad1;
        ad1;
        if (true) goto _L2; else goto _L1
_L1:
        file;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final EncodeStrategy a(e e1)
    {
        return EncodeStrategy.TRANSFORMED;
    }

    public final volatile boolean a(Object obj, File file, e e1)
    {
        return a((ad)obj, file, e1);
    }

}
