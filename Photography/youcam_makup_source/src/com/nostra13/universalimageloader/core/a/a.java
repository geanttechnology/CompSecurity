// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.b.b;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core.a:
//            d, e, c, b

public class a
    implements com.nostra13.universalimageloader.core.a.d
{

    protected final boolean a;

    public a(boolean flag)
    {
        a = flag;
    }

    private boolean a(String s, String s1)
    {
        return "image/jpeg".equalsIgnoreCase(s1) && com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.a(s) == com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.c;
    }

    protected Bitmap a(Bitmap bitmap, e e1, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        ImageScaleType imagescaletype = e1.d();
        if (imagescaletype == ImageScaleType.e || imagescaletype == ImageScaleType.f)
        {
            c c1 = new c(bitmap.getWidth(), bitmap.getHeight(), i);
            c c2 = e1.c();
            com.nostra13.universalimageloader.core.assist.ViewScaleType viewscaletype = e1.e();
            float f;
            boolean flag1;
            if (imagescaletype == ImageScaleType.f)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f = com.nostra13.universalimageloader.b.a.b(c1, c2, viewscaletype, flag1);
            if (Float.compare(f, 1.0F) != 0)
            {
                matrix.setScale(f, f);
                if (a)
                {
                    d.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] {
                        c1, c1.a(f), Float.valueOf(f), e1.a()
                    });
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (a)
            {
                d.a("Flip image horizontally [%s]", new Object[] {
                    e1.a()
                });
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (a)
            {
                d.a("Rotate image on %1$d\260 [%2$s]", new Object[] {
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

    public Bitmap a(e e1)
    {
        InputStream inputstream;
        InputStream inputstream1;
        inputstream1 = b(e1);
        if (inputstream1 == null)
        {
            d.d("No stream for image [%s]", new Object[] {
                e1.a()
            });
            return null;
        }
        inputstream = inputstream1;
        com.nostra13.universalimageloader.core.a.c c1 = a(inputstream1, e1);
        inputstream = inputstream1;
        inputstream1 = b(inputstream1, e1);
        inputstream = inputstream1;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1, null, a(c1.a, e1));
        com.nostra13.universalimageloader.b.b.a(inputstream1);
        if (bitmap == null)
        {
            d.d("Image can't be decoded [%s]", new Object[] {
                e1.a()
            });
            return bitmap;
        } else
        {
            return a(bitmap, e1, c1.b.a, c1.b.b);
        }
        e1;
        com.nostra13.universalimageloader.b.b.a(inputstream);
        throw e1;
    }

    protected android.graphics.BitmapFactory.Options a(c c1, e e1)
    {
        ImageScaleType imagescaletype = e1.d();
        int i;
        if (imagescaletype == ImageScaleType.a)
        {
            i = 1;
        } else
        if (imagescaletype == ImageScaleType.b)
        {
            i = com.nostra13.universalimageloader.b.a.a(c1);
        } else
        {
            c c2 = e1.c();
            boolean flag;
            if (imagescaletype == ImageScaleType.c)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = com.nostra13.universalimageloader.b.a.a(c1, c2, e1.e(), flag);
        }
        if (i > 1 && a)
        {
            d.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] {
                c1, c1.a(i), Integer.valueOf(i), e1.a()
            });
        }
        c1 = e1.i();
        c1.inSampleSize = i;
        return c1;
    }

    protected com.nostra13.universalimageloader.core.a.b a(String s)
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
        int j = (new ExifInterface(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.c.c(s))).getAttributeInt("Orientation", 1);
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
        return new com.nostra13.universalimageloader.core.a.b(i, flag1);
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
        d.c("Can't read EXIF tags from file [%s]", new Object[] {
            s
        });
        if (true) goto _L1; else goto _L11
_L11:
    }

    protected com.nostra13.universalimageloader.core.a.c a(InputStream inputstream, e e1)
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
            inputstream = new com.nostra13.universalimageloader.core.a.b();
        }
        return new com.nostra13.universalimageloader.core.a.c(new c(options.outWidth, options.outHeight, ((com.nostra13.universalimageloader.core.a.b) (inputstream)).a), inputstream);
    }

    protected InputStream b(e e1)
    {
        return e1.f().a_(e1.b(), e1.g());
    }

    protected InputStream b(InputStream inputstream, e e1)
    {
        try
        {
            inputstream.reset();
        }
        catch (IOException ioexception)
        {
            com.nostra13.universalimageloader.b.b.a(inputstream);
            return b(e1);
        }
        return inputstream;
    }
}
