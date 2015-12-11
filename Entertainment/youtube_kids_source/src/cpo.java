// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.FloatMath;

public final class cpo
    implements cou
{

    private final int a;
    private final boolean b;
    private final android.graphics.Bitmap.Config c;

    public cpo()
    {
        a = 0;
        b = false;
        c = android.graphics.Bitmap.Config.ARGB_8888;
    }

    public cpo(int i, boolean flag, android.graphics.Bitmap.Config config)
    {
        boolean flag1;
        if (i > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        b.a(flag1, "desiredWidth must be > 0");
        a = i;
        b = flag;
        c = config;
    }

    private static int a(int i, int j)
    {
        boolean flag = true;
        int k = j;
        j = ((flag) ? 1 : 0);
        do
        {
            k >>= 1;
            if (k >= i)
            {
                j <<= 1;
            } else
            {
                return j;
            }
        } while (true);
    }

    public final Object a_(Object obj)
    {
        obj = (byte[])obj;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, options);
        if (options.outWidth < 0)
        {
            obj = null;
        } else
        {
            Bitmap bitmap;
            int i;
            if (a == 0)
            {
                i = 1;
            } else
            {
                i = a(a, options.outWidth);
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = c;
            options.inPurgeable = true;
            options.inInputShareable = false;
            bitmap = BitmapFactory.decodeByteArray(((byte []) (obj)), 0, obj.length, options);
            obj = bitmap;
            if (b)
            {
                obj = bitmap;
                if (bitmap != null)
                {
                    float f = options.outWidth;
                    i = (int)FloatMath.ceil(((float)options.outHeight - f * 0.5625F) / 2.0F);
                    obj = bitmap;
                    if (i > 0)
                    {
                        int j = options.outHeight - i * 2;
                        obj = bitmap;
                        if (j > 0)
                        {
                            obj = Bitmap.createBitmap(bitmap, 0, i, options.outWidth, j);
                            bitmap.recycle();
                        }
                    }
                }
            }
        }
        if (obj == null)
        {
            throw new bnn("failed to decode bitmap");
        } else
        {
            return obj;
        }
    }
}
