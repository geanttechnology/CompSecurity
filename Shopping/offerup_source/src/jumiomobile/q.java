// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package jumiomobile:
//            n, l, r

public class q
{

    private static r a;

    public static Bitmap a(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        for (j = 0; j < abyte0.length / 3; j++)
        {
            bitmap.setPixel(j % i, j / i, 0xff000000 | (abyte0[j * 3] & 0xff) << 16 | (abyte0[j * 3 + 1] & 0xff) << 8 | abyte0[j * 3 + 2] & 0xff);
        }

        return bitmap;
    }

    public static Bitmap a(byte abyte0[], boolean flag, l l1)
    {
        return a(abyte0, flag, l1, false);
    }

    public static Bitmap a(byte abyte0[], boolean flag, l l1, float f)
    {
        n n1 = new n(-1, -1);
        l1 = a(abyte0, flag, l1, f, n1);
        abyte0 = null;
        if (l1 != null)
        {
            abyte0 = a(((byte []) (l1)), n1.a, n1.b);
        }
        return abyte0;
    }

    public static Bitmap a(byte abyte0[], boolean flag, l l1, int i, int j, int k, int i1, int j1, 
            int k1)
    {
        l1 = b(abyte0, flag, l1, i, j, k, i1, j1, k1);
        abyte0 = null;
        if (l1 != null)
        {
            abyte0 = a(((byte []) (l1)), j1, k1);
        }
        return abyte0;
    }

    public static Bitmap a(byte abyte0[], boolean flag, l l1, boolean flag1)
    {
        n n1 = new n(-1, -1);
        l1 = a(abyte0, flag, l1, flag1, n1);
        abyte0 = null;
        if (l1 != null)
        {
            abyte0 = a(((byte []) (l1)), n1.a, n1.b);
        }
        return abyte0;
    }

    public static Bitmap a(byte abyte0[], boolean flag, l l1, boolean flag1, int i)
    {
        n n1 = new n(-1, -1);
        l1 = a(abyte0, flag, l1, flag1, n1, i);
        abyte0 = null;
        if (l1 != null)
        {
            abyte0 = a(((byte []) (l1)), n1.a, n1.b);
        }
        return abyte0;
    }

    public static void a(Bitmap bitmap, File file, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        file = new FileOutputStream(file);
        bitmap.compress(compressformat, i, file);
        file.flush();
        try
        {
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        return;
        bitmap;
        file = null;
_L2:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
            }
        }
        throw bitmap;
        bitmap;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void a(r r1)
    {
        a = r1;
    }

    public static byte[] a(byte abyte0[], boolean flag, l l1, float f, n n1)
    {
        return a(abyte0, flag, l1, f, n1, ((StringBuilder) (null)));
    }

    public static byte[] a(byte abyte0[], boolean flag, l l1, float f, n n1, StringBuilder stringbuilder)
    {
        float f1 = (float)l1.b.b / (float)l1.b.a;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        if (flag)
        {
            if (f1 >= f)
            {
                i1 = (int)(((float)(l1.a.a - l1.b.a) / 2.0F) * ((float)l1.c.a / (float)l1.a.a));
                j = l1.c.a - i1 * 2;
                i = (int)((float)j * f);
                k = (l1.c.b - i) / 2;
            } else
            {
                k = (int)(((float)(l1.a.b - l1.b.b) / 2.0F) * ((float)l1.c.b / (float)l1.a.b));
                i = l1.c.b - k * 2;
                j = (int)((float)i / f);
                i1 = (l1.c.a - j) / 2;
            }
        } else
        if (f1 <= f)
        {
            i1 = (int)(((float)(l1.a.b - l1.b.b) / 2.0F) * ((float)l1.c.b / (float)l1.a.b));
            j = l1.c.b - i1 * 2;
            i = (int)((float)j / f);
            k = (l1.c.a - i) / 2;
        } else
        {
            k = (int)(((float)(l1.a.a - l1.b.a) / 2.0F) * ((float)l1.c.a / (float)l1.a.a));
            i = l1.c.a - k * 2;
            j = (int)((float)i * f);
            i1 = (l1.c.b - j) / 2;
        }
        if (n1.a == -1)
        {
            if (flag)
            {
                j1 = j;
            } else
            {
                j1 = i;
            }
            n1.a = j1;
        }
        if (n1.b == -1)
        {
            if (flag)
            {
                j1 = i;
            } else
            {
                j1 = j;
            }
            n1.b = j1;
        }
        return b(abyte0, flag, l1, i, j, k, i1, n1.a, n1.b);
    }

    public static byte[] a(byte abyte0[], boolean flag, l l1, int i, int j, int k, int i1, int j1, 
            int k1, StringBuilder stringbuilder)
    {
label0:
        {
            int i2;
            int j2;
            int k2;
            int l2;
            if (flag)
            {
                i2 = l1.c.b;
                j2 = l1.c.a;
            } else
            {
                i2 = l1.c.a;
                j2 = l1.c.b;
            }
            l2 = l1.e / 90;
            k2 = l2;
            if (!l1.d)
            {
                break label0;
            }
            if (l2 != 1)
            {
                k2 = l2;
                if (l2 != 3)
                {
                    break label0;
                }
            }
            k2 = (l2 + 2) % 4;
        }
        l1 = new byte[j1 * k1 * 3];
        l2 = -1;
        if (a != null)
        {
            l2 = a.a(abyte0, i2, j2, k, i1, i, j, l1, j1, k1, k2, stringbuilder);
        }
        abyte0 = l1;
        if (l2 != 0)
        {
            abyte0 = null;
        }
        return abyte0;
    }

    public static byte[] a(byte abyte0[], boolean flag, l l1, boolean flag1, n n1)
    {
        return a(abyte0, flag, l1, flag1, n1, -1);
    }

    public static byte[] a(byte abyte0[], boolean flag, l l1, boolean flag1, n n1, int i)
    {
label0:
        {
            int i2 = 0;
            int j;
            int k;
            int i1;
            int j1;
            int k1;
            int j2;
            int k2;
            if (flag1)
            {
                if (flag)
                {
                    i2 = (int)(((float)(l1.a.a - l1.b.a) / 2.0F) * ((float)l1.c.a / (float)l1.a.a));
                    j = l1.c.a - i2 * 2;
                    k1 = (int)(((float)(l1.a.b - l1.b.b) / 2.0F) * ((float)l1.c.b / (float)l1.a.b));
                    k = l1.c.b - k1 * 2;
                    i1 = k;
                    j1 = j;
                } else
                {
                    i2 = (int)(((float)(l1.a.b - l1.b.b) / 2.0F) * ((float)l1.c.b / (float)l1.a.b));
                    k = l1.c.b - i2 * 2;
                    k1 = (int)(((float)(l1.a.a - l1.b.a) / 2.0F) * ((float)l1.c.a / (float)l1.a.a));
                    j = l1.c.a - k1 * 2;
                    i1 = j;
                    j1 = k;
                }
            } else
            if (flag)
            {
                j = l1.c.a;
                k = l1.c.b;
                i1 = k;
                j1 = j;
                k1 = 0;
            } else
            {
                k = l1.c.b;
                j = l1.c.a;
                i1 = j;
                j1 = k;
                k1 = 0;
            }
            j2 = j;
            k2 = k;
            if (i == -1)
            {
                break label0;
            }
            if (j <= i)
            {
                j2 = j;
                k2 = k;
                if (k <= i)
                {
                    break label0;
                }
            }
            if (j > k)
            {
                k2 = (int)(((float)k / (float)j) * (float)i);
                j2 = i;
            } else
            {
                j2 = (int)(((float)j / (float)k) * (float)i);
                k2 = i;
            }
        }
        if (n1 != null)
        {
            n1.a = j2;
            n1.b = k2;
        }
        return b(abyte0, flag, l1, i1, j1, k1, i2, j2, k2);
    }

    public static byte[] b(byte abyte0[], boolean flag, l l1, int i, int j, int k, int i1, int j1, 
            int k1)
    {
        return a(abyte0, flag, l1, i, j, k, i1, j1, k1, null);
    }
}
