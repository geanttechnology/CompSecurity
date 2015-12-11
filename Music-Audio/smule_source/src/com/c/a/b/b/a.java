// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.c.a.b.a.e;
import com.c.a.b.a.f;
import com.c.a.b.d.c;
import com.c.a.c.b;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.c.a.b.b:
//            d, e, c, b

public class a
    implements d
{

    protected final boolean a;

    public a(boolean flag)
    {
        a = flag;
    }

    private boolean a(String s, String s1)
    {
        return android.os.Build.VERSION.SDK_INT >= 5 && "image/jpeg".equalsIgnoreCase(s1) && c.a(s) == c.c;
    }

    protected Bitmap a(Bitmap bitmap, com.c.a.b.b.e e1, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        e e2 = e1.d();
        if (e2 == e.d || e2 == e.e)
        {
            f f2 = new f(bitmap.getWidth(), bitmap.getHeight(), i);
            f f3 = e1.c();
            com.c.a.b.a.l l = e1.e();
            float f1;
            boolean flag1;
            if (e2 == e.e)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f1 = com.c.a.c.a.b(f2, f3, l, flag1);
            if (Float.compare(f1, 1.0F) != 0)
            {
                matrix.setScale(f1, f1);
                if (a)
                {
                    com.c.a.c.c.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] {
                        f2, f2.a(f1), Float.valueOf(f1), e1.a()
                    });
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (a)
            {
                com.c.a.c.c.a("Flip image horizontally [%s]", new Object[] {
                    e1.a()
                });
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (a)
            {
                com.c.a.c.c.a("Rotate image on %1$d\260 [%2$s]", new Object[] {
                    Integer.valueOf(i), e1.a()
                });
            }
        }
        e1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (e1 != bitmap)
        {
            bitmap.recycle();
        }
        return e1;
    }

    public Bitmap a(com.c.a.b.b.e e1)
    {
        Object obj = b(e1);
        com.c.a.b.b.c c1 = a(((InputStream) (obj)), e1);
        android.graphics.BitmapFactory.Options options = a(c1.a, e1);
        obj = a(b(((InputStream) (obj)), e1), options);
        if (obj == null)
        {
            com.c.a.c.c.d("Image can't be decoded [%s]", new Object[] {
                e1.a()
            });
            return ((Bitmap) (obj));
        } else
        {
            return a(((Bitmap) (obj)), e1, c1.b.a, c1.b.b);
        }
    }

    protected Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        options = BitmapFactory.decodeStream(inputstream, null, options);
        com.c.a.c.b.a(inputstream);
        return options;
        options;
        com.c.a.c.b.a(inputstream);
        throw options;
    }

    protected android.graphics.BitmapFactory.Options a(f f1, com.c.a.b.b.e e1)
    {
        int i = 1;
        e e2 = e1.d();
        f f2 = e1.c();
        if (e2 != e.a)
        {
            boolean flag;
            if (e2 == e.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = com.c.a.c.a.a(f1, f2, e1.e(), flag);
            if (a)
            {
                com.c.a.c.c.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] {
                    f1, f1.a(i), Integer.valueOf(i), e1.a()
                });
            }
        }
        f1 = e1.i();
        f1.inSampleSize = i;
        return f1;
    }

    protected com.c.a.b.b.b a(String s)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag = false;
        flag2 = true;
        flag3 = true;
        flag4 = true;
        flag1 = true;
        int j = (new ExifInterface(c.c.c(s))).getAttributeInt("Orientation", 1);
        int i = ((flag) ? 1 : 0);
        j;
        JVM INSTR tableswitch 1 8: default 88
    //                   1 88
    //                   2 94
    //                   3 118
    //                   4 121
    //                   5 135
    //                   6 105
    //                   7 108
    //                   8 132;
           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        flag1 = false;
        i = ((flag) ? 1 : 0);
_L10:
        return new com.c.a.b.b.b(i, flag1);
_L6:
        flag2 = false;
_L7:
        i = 90;
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
_L3:
        flag3 = false;
_L4:
        i = 180;
        flag1 = flag3;
        continue; /* Loop/switch isn't completed */
_L8:
        flag4 = false;
_L5:
        i = 270;
        flag1 = flag4;
        if (true) goto _L10; else goto _L9
_L9:
        IOException ioexception;
        ioexception;
        com.c.a.c.c.c("Can't read EXIF tags from file [%s]", new Object[] {
            s
        });
        if (true) goto _L1; else goto _L11
_L11:
    }

    protected com.c.a.b.b.c a(InputStream inputstream, com.c.a.b.b.e e1)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        inputstream = e1.b();
        if (e1.h() && a(((String) (inputstream)), options.outMimeType))
        {
            inputstream = a(((String) (inputstream)));
        } else
        {
            inputstream = new com.c.a.b.b.b();
        }
        return new com.c.a.b.b.c(new f(options.outWidth, options.outHeight, ((com.c.a.b.b.b) (inputstream)).a), inputstream);
    }

    protected InputStream b(com.c.a.b.b.e e1)
    {
        return e1.f().a(e1.b(), e1.g());
    }

    protected InputStream b(InputStream inputstream, com.c.a.b.b.e e1)
    {
        try
        {
            inputstream.reset();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return b(e1);
        }
        return inputstream;
    }
}
