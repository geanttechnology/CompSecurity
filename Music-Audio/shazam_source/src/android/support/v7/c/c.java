// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.c;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package android.support.v7.c:
//            a, b

public final class android.support.v7.c.c
{
    public static final class a
    {

        private List a;
        private Bitmap b;
        private int c;
        private int d;
        private b e;

        public final android.support.v7.c.c a()
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
                android.support.v7.c.a a1;
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
                e = new android.support.v7.c.b();
            }
            e.a(((List) (obj)));
            return new android.support.v7.c.c(((List) (obj)), e, (byte)0);
        }

        public a(Bitmap bitmap)
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

    public static abstract class b
    {

        public d a()
        {
            return null;
        }

        public abstract void a(List list);

        public d b()
        {
            return null;
        }

        public d c()
        {
            return null;
        }

        public d d()
        {
            return null;
        }

        b()
        {
        }
    }

    public static interface c
    {

        public abstract void a(android.support.v7.c.c c1);
    }

    public static final class d
    {

        public final int a;
        final int b;
        private final int c;
        private final int d;
        private final int e;
        private boolean f;
        private int g;
        private int h;
        private float i[];

        private void b()
        {
            int j;
            int k;
label0:
            {
                if (!f)
                {
                    j = android.support.v4.b.a.a(-1, a, 4.5F);
                    k = android.support.v4.b.a.a(-1, a, 3F);
                    if (j == -1 || k == -1)
                    {
                        break label0;
                    }
                    h = android.support.v4.b.a.b(-1, j);
                    g = android.support.v4.b.a.b(-1, k);
                    f = true;
                }
                return;
            }
            int i1 = android.support.v4.b.a.a(0xff000000, a, 4.5F);
            int l = android.support.v4.b.a.a(0xff000000, a, 3F);
            if (i1 != -1 && i1 != -1)
            {
                h = android.support.v4.b.a.b(0xff000000, i1);
                g = android.support.v4.b.a.b(0xff000000, l);
                f = true;
                return;
            }
            if (j != -1)
            {
                j = android.support.v4.b.a.b(-1, j);
            } else
            {
                j = android.support.v4.b.a.b(0xff000000, i1);
            }
            h = j;
            if (k != -1)
            {
                j = android.support.v4.b.a.b(-1, k);
            } else
            {
                j = android.support.v4.b.a.b(0xff000000, l);
            }
            g = j;
            f = true;
        }

        public final float[] a()
        {
            if (i == null)
            {
                i = new float[3];
                android.support.v4.b.a.a(c, d, e, i);
            }
            return i;
        }

        public final boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (d)obj;
                if (b != ((d) (obj)).b || a != ((d) (obj)).a)
                {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode()
        {
            return a * 31 + b;
        }

        public final String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(getClass().getSimpleName())).append(" [RGB: #").append(Integer.toHexString(a)).append(']').append(" [HSL: ").append(Arrays.toString(a())).append(']').append(" [Population: ").append(b).append(']').append(" [Title Text: #");
            b();
            stringbuilder = stringbuilder.append(Integer.toHexString(g)).append(']').append(" [Body Text: #");
            b();
            return stringbuilder.append(Integer.toHexString(h)).append(']').toString();
        }

        public d(int j, int k)
        {
            c = Color.red(j);
            d = Color.green(j);
            e = Color.blue(j);
            a = j;
            b = k;
        }
    }


    public final b a;
    private final List b;

    private android.support.v7.c.c(List list, b b1)
    {
        b = list;
        a = b1;
    }

    android.support.v7.c.c(List list, b b1, byte byte0)
    {
        this(list, b1);
    }

    public final int a(int i)
    {
        d d1 = a.a();
        if (d1 != null)
        {
            i = d1.a;
        }
        return i;
    }

    public final int b(int i)
    {
        d d1 = a.b();
        if (d1 != null)
        {
            i = d1.a;
        }
        return i;
    }
}
