// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.c.a.b.a.a;
import com.c.a.b.a.d;
import com.c.a.b.c.b;
import com.c.a.b.e;
import com.c.a.b.f;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.f:
//            d

public class c
{

    private static final String a = com/smule/android/f/c.getName();

    public c()
    {
    }

    public static Bitmap a(Bitmap bitmap, int i)
    {
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        Object obj = new Paint(1);
        ((Paint) (obj)).setColor(i);
        ((Paint) (obj)).setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        obj = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(((android.graphics.Shader) (obj)));
        paint.setAntiAlias(true);
        (new Canvas(bitmap1)).drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        return bitmap1;
        bitmap;
        bitmap1 = null;
_L2:
        aa.b(a, bitmap.getMessage());
        return bitmap1;
        bitmap;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Bitmap a(Bitmap bitmap, int i, int j)
    {
        if (i != 0 && j != 0)
        {
            int k = bitmap.getWidth();
            int l = bitmap.getHeight();
            if (k != i || l != j)
            {
                float f1 = (float)i / (float)k;
                float f2 = (float)j / (float)l;
                Matrix matrix = new Matrix();
                matrix.postScale(f1, f2);
                return Bitmap.createBitmap(bitmap, 0, 0, k, l, matrix, false);
            }
        }
        return bitmap;
    }

    public static void a(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void a(ImageView imageview, Bitmap bitmap, int i, boolean flag)
    {
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        Bitmap bitmap1;
        if (j != k)
        {
            if (j >= k)
            {
                bitmap = Bitmap.createBitmap(bitmap, bitmap.getWidth() / 2 - bitmap.getHeight() / 2, 0, bitmap.getHeight(), bitmap.getHeight());
            } else
            {
                bitmap = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight() / 2 - bitmap.getWidth() / 2, bitmap.getWidth(), bitmap.getWidth());
            }
        }
        bitmap1 = bitmap;
        if (flag)
        {
            bitmap1 = a(bitmap, imageview.getWidth(), imageview.getHeight());
        }
        imageview.setImageBitmap(a(bitmap1, i));
    }

    public static void a(String s, ImageView imageview, int i, boolean flag, int j)
    {
        a(s, imageview, i, flag, j, null);
    }

    public static void a(String s, ImageView imageview, int i, boolean flag, int j, com.smule.android.f.d d)
    {
        if (s == null || s.length() == 0)
        {
            imageview.setImageResource(i);
            return;
        } else
        {
            f.a().a(s, imageview, (new e()).a(i).a().b().a(new b(100)).c(), new d(flag, j, d) {

                final boolean a;
                final int b;
                final com.smule.android.f.d c;

                public void a(String s1, View view)
                {
                }

                public void a(String s1, View view, Bitmap bitmap)
                {
                    if (a)
                    {
                        com.smule.android.f.c.a((ImageView)view, bitmap, b, true);
                    }
                    if (c != null)
                    {
                        c.a(s1, view, bitmap);
                    }
                }

                public void a(String s1, View view, a a1)
                {
                }

                public void b(String s1, View view)
                {
                }

            
            {
                a = flag;
                b = i;
                c = d1;
                super();
            }
            });
            return;
        }
    }

}
