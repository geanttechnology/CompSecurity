// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.fotoable.comlib.util.ImageCache;
import java.io.FileDescriptor;

public class zt extends zu
{

    protected int a;
    protected int b;

    public zt(Context context, int i)
    {
        super(context);
        a(i);
    }

    public zt(Context context, int i, int j)
    {
        super(context);
        a(i, j);
    }

    public static int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int i1 = options.outHeight;
        int j1 = options.outWidth;
        int l = 1;
        int k = 1;
        if (i1 > j || j1 > i)
        {
            l = i1 / 2;
            for (int k1 = j1 / 2; l / k > j && k1 / k > i; k *= 2) { }
            long l1 = (i1 * j1) / k;
            long l2 = i * j * 2;
            do
            {
                l = k;
                if (l1 <= l2)
                {
                    break;
                }
                l1 /= 2L;
                k *= 2;
            } while (true);
        }
        return l;
    }

    public static Bitmap a(Resources resources, int i, int j, int k, ImageCache imagecache)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = a(options, j, k);
        if (aaj.c())
        {
            a(options, imagecache);
        }
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap a(FileDescriptor filedescriptor, int i, int j, ImageCache imagecache)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        options.inSampleSize = a(options, i, j);
        options.inJustDecodeBounds = false;
        if (aaj.c())
        {
            a(options, imagecache);
        }
        try
        {
            filedescriptor = BitmapFactory.decodeFileDescriptor(filedescriptor, null, options);
        }
        // Misplaced declaration of an exception variable
        catch (FileDescriptor filedescriptor)
        {
            return null;
        }
        return filedescriptor;
    }

    private static void a(android.graphics.BitmapFactory.Options options, ImageCache imagecache)
    {
        options.inMutable = true;
        if (imagecache != null)
        {
            imagecache = imagecache.a(options);
            if (imagecache != null)
            {
                options.inBitmap = imagecache;
            }
        }
    }

    private Bitmap c(int i)
    {
        return a(d, i, a, b, g());
    }

    protected Bitmap a(Object obj)
    {
        return c(Integer.parseInt(b(obj)));
    }

    public void a(int i)
    {
        a(i, i);
    }

    public void a(int i, int j)
    {
        a = i;
        b = j;
    }
}
