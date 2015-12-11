// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            alb, alj

public abstract class ald
{
    public static final class a
    {

        private final aky.d a;
        private final Bitmap b;
        private final InputStream c;
        private final int d;

        public Bitmap a()
        {
            return b;
        }

        public InputStream b()
        {
            return c;
        }

        public aky.d c()
        {
            return a;
        }

        int d()
        {
            return d;
        }

        public a(Bitmap bitmap, aky.d d1)
        {
            this((Bitmap)alj.a(bitmap, "bitmap == null"), null, d1, 0);
        }

        a(Bitmap bitmap, InputStream inputstream, aky.d d1, int i)
        {
            boolean flag1 = true;
            super();
            boolean flag;
            if (bitmap != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (inputstream == null)
            {
                flag1 = false;
            }
            if (!(flag1 ^ flag))
            {
                throw new AssertionError();
            } else
            {
                b = bitmap;
                c = inputstream;
                a = (aky.d)alj.a(d1, "loadedFrom == null");
                d = i;
                return;
            }
        }

        public a(InputStream inputstream, aky.d d1)
        {
            this(null, (InputStream)alj.a(inputstream, "stream == null"), d1, 0);
        }
    }


    public ald()
    {
    }

    static void a(int i, int j, int k, int l, android.graphics.BitmapFactory.Options options, alb alb1)
    {
        int i1 = 1;
        if (l > j || k > i)
        {
            if (j == 0)
            {
                i1 = (int)Math.floor((float)k / (float)i);
            } else
            if (i == 0)
            {
                i1 = (int)Math.floor((float)l / (float)j);
            } else
            {
                j = (int)Math.floor((float)l / (float)j);
                i = (int)Math.floor((float)k / (float)i);
                if (alb1.k)
                {
                    i1 = Math.max(j, i);
                } else
                {
                    i1 = Math.min(j, i);
                }
            }
        }
        options.inSampleSize = i1;
        options.inJustDecodeBounds = false;
    }

    static void a(int i, int j, android.graphics.BitmapFactory.Options options, alb alb1)
    {
        a(i, j, options.outWidth, options.outHeight, options, alb1);
    }

    static boolean a(android.graphics.BitmapFactory.Options options)
    {
        return options != null && options.inJustDecodeBounds;
    }

    static android.graphics.BitmapFactory.Options c(alb alb1)
    {
        boolean flag1 = alb1.d();
        android.graphics.BitmapFactory.Options options;
        boolean flag;
        if (alb1.q != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        options = null;
        if (flag1 || flag)
        {
            android.graphics.BitmapFactory.Options options1 = new android.graphics.BitmapFactory.Options();
            options1.inJustDecodeBounds = flag1;
            options = options1;
            if (flag)
            {
                options1.inPreferredConfig = alb1.q;
                options = options1;
            }
        }
        return options;
    }

    int a()
    {
        return 0;
    }

    public abstract a a(alb alb1, int i)
        throws IOException;

    public abstract boolean a(alb alb1);

    boolean a(boolean flag, NetworkInfo networkinfo)
    {
        return false;
    }

    boolean b()
    {
        return false;
    }
}
