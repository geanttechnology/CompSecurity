// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.c.a:
//            a

final class b
    implements com.c.a.a
{
    private static final class a
        implements Callable
    {

        private final int a[];
        private final int b;
        private final int c;
        private final int d = 15;
        private final int e;
        private final int f;
        private final int g;

        public final Object call()
        {
            b.a(a, b, c, d, e, f, g);
            return null;
        }

        public a(int ai[], int i, int j, int k, int l, int i1)
        {
            a = ai;
            b = i;
            c = j;
            e = k;
            f = l;
            g = i1;
        }
    }


    private static final short c[] = {
        512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 
        271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 
        298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 
        273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 
        312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 
        404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 
        282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 
        417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 
        320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 
        507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 
        412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 
        341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 
        287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 
        489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 
        422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 
        368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 
        324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 
        287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 
        257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 
        460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 
        416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 
        377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 
        344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 
        315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 
        289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 
        267, 265, 263, 261, 259
    };
    private static final byte d[] = {
        9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 
        15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 
        17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 
        18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 
        19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 
        20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 
        20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 
        21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 
        21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 
        22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 
        22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 
        22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 
        22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 
        23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
        23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
        23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
        23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
        23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 
        23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 
        24, 24, 24, 24, 24
    };
    private final int a;
    private final ExecutorService b;

    b(ExecutorService executorservice, int i)
    {
        b = executorservice;
        a = i;
    }

    static void a(int ai[], int i, int j, int k, int l, int i1, int j1)
    {
        int j3 = i - 1;
        int k3 = j - 1;
        int l3 = k * 2 + 1;
        int i4 = c[k];
        byte byte0 = d[k];
        int ai1[] = new int[l3];
        if (j1 == 1)
        {
            j1 = (i1 * j) / l;
            k3 = ((i1 + 1) * j) / l;
            l = j1;
            while (l < k3) 
            {
                long l7 = 0L;
                i1 = i * l;
                long l6 = 0L;
                long l4 = 0L;
                long l10 = 0L;
                long l11 = 0L;
                long l12 = 0L;
                j = 0;
                long l5 = 0L;
                for (; j <= k; j++)
                {
                    ai1[j] = ai[i1];
                    l12 += (ai[i1] >>> 16 & 0xff) * (j + 1);
                    l11 += (ai[i1] >>> 8 & 0xff) * (j + 1);
                    l10 += (ai[i1] & 0xff) * (j + 1);
                    l4 += ai[i1] >>> 16 & 0xff;
                    l6 += ai[i1] >>> 8 & 0xff;
                    l5 += ai[i1] & 0xff;
                }

                long l9 = 0L;
                j = 1;
                long l8 = 0L;
                while (j <= k) 
                {
                    j1 = i1;
                    if (j <= j3)
                    {
                        j1 = i1 + 1;
                    }
                    ai1[j + k] = ai[j1];
                    l12 += (ai[j1] >>> 16 & 0xff) * ((k + 1) - j);
                    l11 += (ai[j1] >>> 8 & 0xff) * ((k + 1) - j);
                    l10 += (ai[j1] & 0xff) * ((k + 1) - j);
                    l9 += ai[j1] >>> 16 & 0xff;
                    l8 += ai[j1] >>> 8 & 0xff;
                    l7 += ai[j1] & 0xff;
                    j++;
                    i1 = j1;
                }
                int k1;
                int l1;
                int j2;
                int k2;
                int i3;
                int j4;
                long l13;
                long l14;
                long l15;
                if (k > j3)
                {
                    j = j3;
                } else
                {
                    j = k;
                }
                j1 = k;
                i1 = 0;
                k2 = j + l * i;
                k1 = j;
                l1 = l * i;
                l13 = l9;
                l14 = l8;
                l15 = l7;
                j = j1;
                l9 = l12;
                l8 = l11;
                l7 = l10;
                l12 = l13;
                l11 = l14;
                l10 = l15;
                j1 = l1;
                while (i1 < i) 
                {
                    ai[j1] = (int)((long)(ai[j1] & 0xff000000) | ((long)i4 * l9 >>> byte0 & 255L) << 16 | ((long)i4 * l8 >>> byte0 & 255L) << 8 | (long)i4 * l7 >>> byte0 & 255L);
                    l1 = (j + l3) - k;
                    int l2 = l1;
                    if (l1 >= l3)
                    {
                        l2 = l1 - l3;
                    }
                    l15 = ai1[l2] >>> 16 & 0xff;
                    l14 = ai1[l2] >>> 8 & 0xff;
                    l13 = ai1[l2] & 0xff;
                    int i2 = k2;
                    l1 = k1;
                    if (k1 < j3)
                    {
                        i2 = k2 + 1;
                        l1 = k1 + 1;
                    }
                    ai1[l2] = ai[i2];
                    l12 += ai[i2] >>> 16 & 0xff;
                    l11 += ai[i2] >>> 8 & 0xff;
                    l10 += ai[i2] & 0xff;
                    l9 = (l9 - l4) + l12;
                    l8 = (l8 - l6) + l11;
                    l7 = (l7 - l5) + l10;
                    k1 = j + 1;
                    j = k1;
                    if (k1 >= l3)
                    {
                        j = 0;
                    }
                    l4 = (l4 - l15) + (long)(ai1[j] >>> 16 & 0xff);
                    l6 = (l6 - l14) + (long)(ai1[j] >>> 8 & 0xff);
                    l5 = (l5 - l13) + (long)(ai1[j] & 0xff);
                    l12 -= ai1[j] >>> 16 & 0xff;
                    l11 -= ai1[j] >>> 8 & 0xff;
                    l10 -= ai1[j] & 0xff;
                    i1++;
                    j1++;
                    k2 = i2;
                    k1 = l1;
                }
                l++;
            }
        } else
        if (j1 == 2)
        {
            j1 = (i1 * i) / l;
            j4 = ((i1 + 1) * i) / l;
            l = j1;
            while (l < j4) 
            {
                l13 = 0L;
                i1 = 0;
                l4 = 0L;
                l5 = 0L;
                l6 = 0L;
                l7 = 0L;
                l8 = 0L;
                l9 = 0L;
                for (; i1 <= k; i1++)
                {
                    ai1[i1] = ai[l];
                    l9 += (ai[l] >>> 16 & 0xff) * (i1 + 1);
                    l8 += (ai[l] >>> 8 & 0xff) * (i1 + 1);
                    l7 += (ai[l] & 0xff) * (i1 + 1);
                    l6 += ai[l] >>> 16 & 0xff;
                    l5 += ai[l] >>> 8 & 0xff;
                    l4 += ai[l] & 0xff;
                }

                l14 = 0L;
                l15 = 0L;
                i1 = 1;
                j1 = l;
                l12 = l9;
                l11 = l8;
                l10 = l7;
                l9 = l15;
                l8 = l14;
                l7 = l13;
                while (i1 <= k) 
                {
                    k1 = j1;
                    if (i1 <= k3)
                    {
                        k1 = j1 + i;
                    }
                    ai1[i1 + k] = ai[k1];
                    l12 += (ai[k1] >>> 16 & 0xff) * ((k + 1) - i1);
                    l11 += (ai[k1] >>> 8 & 0xff) * ((k + 1) - i1);
                    l10 += (ai[k1] & 0xff) * ((k + 1) - i1);
                    l9 += ai[k1] >>> 16 & 0xff;
                    l8 += ai[k1] >>> 8 & 0xff;
                    l7 += ai[k1] & 0xff;
                    i1++;
                    j1 = k1;
                }
                if (k > k3)
                {
                    i1 = k3;
                } else
                {
                    i1 = k;
                }
                i3 = i1 * i + l;
                l1 = k;
                j1 = 0;
                j2 = i1;
                k1 = l;
                i1 = l1;
                for (l1 = j2; j1 < j; l1 = j2)
                {
                    ai[k1] = (int)((long)(ai[k1] & 0xff000000) | ((long)i4 * l12 >>> byte0 & 255L) << 16 | ((long)i4 * l11 >>> byte0 & 255L) << 8 | (long)i4 * l10 >>> byte0 & 255L);
                    j2 = (i1 + l3) - k;
                    j3 = j2;
                    if (j2 >= l3)
                    {
                        j3 = j2 - l3;
                    }
                    l15 = ai1[j3] >>> 16 & 0xff;
                    l14 = ai1[j3] >>> 8 & 0xff;
                    l13 = ai1[j3] & 0xff;
                    k2 = i3;
                    j2 = l1;
                    if (l1 < k3)
                    {
                        k2 = i3 + i;
                        j2 = l1 + 1;
                    }
                    ai1[j3] = ai[k2];
                    l9 += ai[k2] >>> 16 & 0xff;
                    l8 += ai[k2] >>> 8 & 0xff;
                    l7 += ai[k2] & 0xff;
                    l12 = (l12 - l6) + l9;
                    l11 = (l11 - l5) + l8;
                    l10 = (l10 - l4) + l7;
                    l1 = i1 + 1;
                    i1 = l1;
                    if (l1 >= l3)
                    {
                        i1 = 0;
                    }
                    l6 = (l6 - l15) + (long)(ai1[i1] >>> 16 & 0xff);
                    l5 = (l5 - l14) + (long)(ai1[i1] >>> 8 & 0xff);
                    l4 = (l4 - l13) + (long)(ai1[i1] & 0xff);
                    l9 -= ai1[i1] >>> 16 & 0xff;
                    l8 -= ai1[i1] >>> 8 & 0xff;
                    l7 -= ai1[i1] & 0xff;
                    j1++;
                    k1 += i;
                    i3 = k2;
                }

                l++;
            }
        }
    }

    public final Bitmap a(Bitmap bitmap)
    {
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        int ai[] = new int[j * k];
        bitmap.getPixels(ai, 0, j, 0, 0, j, k);
        bitmap = new ArrayList(a);
        ArrayList arraylist = new ArrayList(a);
        for (int i = 0; i < a; i++)
        {
            bitmap.add(new a(ai, j, k, a, i, 1));
            arraylist.add(new a(ai, j, k, a, i, 2));
        }

        try
        {
            b.invokeAll(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        try
        {
            b.invokeAll(arraylist);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return null;
        }
        return Bitmap.createBitmap(ai, j, k, android.graphics.Bitmap.Config.ARGB_8888);
    }

}
