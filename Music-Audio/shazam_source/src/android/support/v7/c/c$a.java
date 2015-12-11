// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.c;

import android.graphics.Bitmap;
import java.util.List;

// Referenced classes of package android.support.v7.c:
//            c, a, b

public static final class b
{

    private List a;
    private Bitmap b;
    private int c;
    private int d;
    private e e;

    public final c a()
    {
        Object obj;
        if (b != null)
        {
            if (d <= 0)
            {
                throw new IllegalArgumentException("Minimum dimension size for resizing should should be >= 1");
            }
            obj = b;
            int i = d;
            int j = Math.max(((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
            a a1;
            if (j > i)
            {
                float f = (float)i / (float)j;
                obj = Bitmap.createScaledBitmap(((Bitmap) (obj)), Math.round((float)((Bitmap) (obj)).getWidth() * f), Math.round(f * (float)((Bitmap) (obj)).getHeight()), false);
            }
            a1 = android.support.v7.c.a.a(((Bitmap) (obj)), c);
            if (obj != b)
            {
                ((Bitmap) (obj)).recycle();
            }
            obj = a1.c;
        } else
        {
            obj = a;
        }
        if (e == null)
        {
            e = new b();
        }
        e.a(((List) (obj)));
        return new c(((List) (obj)), e, (byte)0);
    }

    public Exception(Bitmap bitmap)
    {
        c = 16;
        d = 192;
        if (bitmap == null || bitmap.isRecycled())
        {
            throw new IllegalArgumentException("Bitmap is not valid");
        } else
        {
            b = bitmap;
            return;
        }
    }
}
