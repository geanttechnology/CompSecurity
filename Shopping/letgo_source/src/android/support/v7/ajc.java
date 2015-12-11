// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            ajd, aje, ait, aiu, 
//            ajr, ajt, ajs, ajj

public class ajc
    implements ajd
{
    protected static class a
    {

        public final int a;
        public final boolean b;

        protected a()
        {
            a = 0;
            b = false;
        }

        protected a(int i, boolean flag)
        {
            a = i;
            b = flag;
        }
    }

    protected static class b
    {

        public final aiu a;
        public final a b;

        protected b(aiu aiu1, a a1)
        {
            a = aiu1;
            b = a1;
        }
    }


    protected final boolean a;

    public ajc(boolean flag)
    {
        a = flag;
    }

    private boolean a(String s, String s1)
    {
        return "image/jpeg".equalsIgnoreCase(s1) && ajj.a.a(s) == ajj.a.c;
    }

    protected Bitmap a(Bitmap bitmap, aje aje1, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        ait ait1 = aje1.d();
        if (ait1 == ait.e || ait1 == ait.f)
        {
            aiu aiu1 = new aiu(bitmap.getWidth(), bitmap.getHeight(), i);
            aiu aiu2 = aje1.c();
            aix aix = aje1.e();
            float f;
            boolean flag1;
            if (ait1 == ait.f)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f = ajr.b(aiu1, aiu2, aix, flag1);
            if (Float.compare(f, 1.0F) != 0)
            {
                matrix.setScale(f, f);
                if (a)
                {
                    ajt.a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", new Object[] {
                        aiu1, aiu1.a(f), Float.valueOf(f), aje1.a()
                    });
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (a)
            {
                ajt.a("Flip image horizontally [%s]", new Object[] {
                    aje1.a()
                });
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (a)
            {
                ajt.a("Rotate image on %1$d\260 [%2$s]", new Object[] {
                    Integer.valueOf(i), aje1.a()
                });
            }
        }
        aje1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (aje1 != bitmap)
        {
            bitmap.recycle();
        }
        return aje1;
    }

    public Bitmap a(aje aje1)
        throws IOException
    {
        InputStream inputstream;
        InputStream inputstream1;
        inputstream1 = b(aje1);
        inputstream = inputstream1;
        b b1 = a(inputstream1, aje1);
        inputstream = inputstream1;
        inputstream1 = b(inputstream1, aje1);
        inputstream = inputstream1;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream1, null, a(b1.a, aje1));
        ajs.a(inputstream1);
        if (bitmap == null)
        {
            ajt.d("Image can't be decoded [%s]", new Object[] {
                aje1.a()
            });
            return bitmap;
        } else
        {
            return a(bitmap, aje1, b1.b.a, b1.b.b);
        }
        aje1;
        ajs.a(inputstream);
        throw aje1;
    }

    protected android.graphics.BitmapFactory.Options a(aiu aiu1, aje aje1)
    {
        ait ait1 = aje1.d();
        int i;
        if (ait1 == ait.a)
        {
            i = 1;
        } else
        if (ait1 == ait.b)
        {
            i = ajr.a(aiu1);
        } else
        {
            aiu aiu2 = aje1.c();
            boolean flag;
            if (ait1 == ait.c)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = ajr.a(aiu1, aiu2, aje1.e(), flag);
        }
        if (i > 1 && a)
        {
            ajt.a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", new Object[] {
                aiu1, aiu1.a(i), Integer.valueOf(i), aje1.a()
            });
        }
        aiu1 = aje1.i();
        aiu1.inSampleSize = i;
        return aiu1;
    }

    protected a a(String s)
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
        int j = (new ExifInterface(ajj.a.c.c(s))).getAttributeInt("Orientation", 1);
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
        return new a(i, flag1);
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
        ajt.c("Can't read EXIF tags from file [%s]", new Object[] {
            s
        });
        if (true) goto _L1; else goto _L11
_L11:
    }

    protected b a(InputStream inputstream, aje aje1)
        throws IOException
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        inputstream = aje1.b();
        if (aje1.h() && a(((String) (inputstream)), options.outMimeType))
        {
            inputstream = a(((String) (inputstream)));
        } else
        {
            inputstream = new a();
        }
        return new b(new aiu(options.outWidth, options.outHeight, ((a) (inputstream)).a), inputstream);
    }

    protected InputStream b(aje aje1)
        throws IOException
    {
        return aje1.f().a(aje1.b(), aje1.g());
    }

    protected InputStream b(InputStream inputstream, aje aje1)
        throws IOException
    {
        try
        {
            inputstream.reset();
        }
        catch (IOException ioexception)
        {
            ajs.a(inputstream);
            return b(aje1);
        }
        return inputstream;
    }
}
