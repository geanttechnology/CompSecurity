// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Log;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a.a;
import java.io.File;
import java.io.FileDescriptor;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            n, j

public class m extends n
{

    protected int a;
    protected int b;

    public static int a(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int k1 = options.outHeight;
        int l1 = options.outWidth;
        int l = 1;
        if (k1 > j || l1 > i)
        {
            int k = (int)Math.ceil((float)k1 / (float)j);
            l = (int)Math.ceil((float)l1 / (float)i);
            int i1 = k1 / 2;
            int j1 = l1 / 2;
            if (k >= l)
            {
                k = l;
            }
            for (; k1 / k > j && l1 / k > i; k++) { }
            float f = l1 * k1;
            float f1 = i * j * 2;
            l = k;
            if (f / (float)(k * k) > f1)
            {
                for (; i1 / k > j || j1 / k > i; k++) { }
                l = (int)Math.pow(2D, (int)Math.ceil(Math.sqrt(k)));
            }
        }
        return l;
    }

    private Bitmap a(int i, boolean flag)
    {
        int k = 0;
        Bitmap bitmap = a(d, i, a, b, a());
        if (flag)
        {
            int l = bitmap.getWidth();
            int i1 = bitmap.getHeight();
            int j;
            if (l < i1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                j = 0;
            } else
            {
                j = (l - i1) / 2;
            }
            if (i != 0)
            {
                k = (i1 - l) / 2;
            }
            if (i != 0)
            {
                i = l;
            } else
            {
                i = i1;
            }
            return Bitmap.createBitmap(bitmap, j, k, i, i);
        } else
        {
            return bitmap;
        }
    }

    public static Bitmap a(Resources resources, int i, int j, int k, j j1)
    {
        j1 = new android.graphics.BitmapFactory.Options();
        j1.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, j1);
        j1.inSampleSize = a(((android.graphics.BitmapFactory.Options) (j1)), j, k);
        j1.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, j1);
    }

    public static Bitmap a(FileDescriptor filedescriptor, int i, int j, j j1)
    {
        j1 = new android.graphics.BitmapFactory.Options();
        j1.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(filedescriptor, null, j1);
        j1.inSampleSize = a(((android.graphics.BitmapFactory.Options) (j1)), i, j);
        j1.inJustDecodeBounds = false;
        j1.inDither = false;
        j1.inScaled = false;
        return BitmapFactory.decodeFileDescriptor(filedescriptor, null, j1);
    }

    public static Bitmap a(String s, boolean flag)
    {
        return a(s, flag, -1);
    }

    public static Bitmap a(String s, boolean flag, int i)
    {
        boolean flag5 = false;
        if (s != null && (new File(s)).exists()) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
label0:
        {
            Object obj = new android.graphics.BitmapFactory.Options();
            obj.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
            int j = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
            int k = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
            int i1;
            if (j <= k)
            {
                j = k;
            }
            if (i <= 0)
            {
                i = com.cyberlink.youcammakeup.database.m.a();
            }
            i1 = i;
            if (i > j)
            {
                i1 = j;
            }
            obj.inJustDecodeBounds = false;
            obj.inPreferredConfig = android.graphics.Bitmap.Config.RGB_565;
            obj.inPurgeable = true;
            obj.inInputShareable = true;
            obj.inSampleSize = a(((android.graphics.BitmapFactory.Options) (obj)), i1, i1);
            try
            {
                obj = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.e("ImageResizer", (new StringBuilder()).append("decodeFile ").append(s).append(" OutOfMemoryError").toString());
                obj = null;
            }
            if (obj == null)
            {
                return null;
            }
            i = ((Bitmap) (obj)).getWidth();
            j = ((Bitmap) (obj)).getHeight();
            float f;
            int l;
            boolean flag3;
            int j1;
            if (i < j)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            j1 = com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.a.a.a(s);
            if (flag)
            {
                float f1;
                if (flag3)
                {
                    l = 0;
                } else
                {
                    l = (i - j) / 2;
                }
                if (flag3)
                {
                    k = (j - i) / 2;
                } else
                {
                    k = 0;
                }
                if (!flag3)
                {
                    i = j;
                }
                f1 = (float)i1 / (float)i;
                f = f1;
                if (f1 <= 0.0F)
                {
                    f = 1.0F;
                }
                i1 = l;
                l = i;
                j = k;
                k = i;
                i = i1;
            } else
            {
                if (flag3)
                {
                    k = j;
                } else
                {
                    k = i;
                }
                f = (float)i1 / (float)k;
                if (f <= 0.0F)
                {
                    boolean flag1 = false;
                    boolean flag4 = false;
                    l = j;
                    k = i;
                    f = 1.0F;
                    i = ((flag4) ? 1 : 0);
                    j = ((flag1) ? 1 : 0);
                } else
                {
                    boolean flag2 = false;
                    l = j;
                    k = i;
                    i = 0;
                    j = ((flag2) ? 1 : 0);
                }
            }
            if (i == 0 && j == 0 && k == ((Bitmap) (obj)).getWidth() && l == ((Bitmap) (obj)).getHeight() && f == 1.0F)
            {
                i1 = ((flag5) ? 1 : 0);
                if (j1 == 0)
                {
                    break label0;
                }
            }
            i1 = 1;
        }
        s = ((String) (obj));
        if (i1 != 0)
        {
            s = new Matrix();
            s.postScale(f, f);
            s.postRotate(j1);
            s = Bitmap.createBitmap(((Bitmap) (obj)), i, j, k, l, s, true);
            ((Bitmap) (obj)).recycle();
            return s;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected Bitmap a(Object obj, boolean flag)
    {
        return a(Integer.parseInt(String.valueOf(obj)), flag);
    }
}
