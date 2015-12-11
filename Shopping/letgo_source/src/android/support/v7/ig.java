// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            aqo

public class ig
{

    public static Bitmap a(Bitmap bitmap, int i)
        throws OutOfMemoryError
    {
        Object obj = new Matrix();
        i;
        JVM INSTR tableswitch 1 8: default 56
    //                   1 56
    //                   2 58
    //                   3 93
    //                   4 102
    //                   5 119
    //                   6 136
    //                   7 145
    //                   8 162;
           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return bitmap;
_L2:
        ((Matrix) (obj)).setScale(-1F, 1.0F);
_L10:
        obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        if (bitmap != obj)
        {
            bitmap.recycle();
        }
        return ((Bitmap) (obj));
_L3:
        ((Matrix) (obj)).setRotate(180F);
        continue; /* Loop/switch isn't completed */
_L4:
        ((Matrix) (obj)).setRotate(180F);
        ((Matrix) (obj)).postScale(-1F, 1.0F);
        continue; /* Loop/switch isn't completed */
_L5:
        ((Matrix) (obj)).setRotate(90F);
        ((Matrix) (obj)).postScale(-1F, 1.0F);
        continue; /* Loop/switch isn't completed */
_L6:
        ((Matrix) (obj)).setRotate(90F);
        continue; /* Loop/switch isn't completed */
_L7:
        ((Matrix) (obj)).setRotate(-90F);
        ((Matrix) (obj)).postScale(-1F, 1.0F);
        continue; /* Loop/switch isn't completed */
_L8:
        ((Matrix) (obj)).setRotate(-90F);
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static Bitmap a(Bitmap bitmap, String s)
        throws IOException
    {
        return a(bitmap, b(s));
    }

    public static Bitmap a(String s)
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        return ((Bitmap) (obj1));
_L2:
        Object obj;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inDither = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[32768];
        obj = new File(s);
        aqo.a("convertBitmap path : %s", new Object[] {
            s
        });
        try
        {
            obj = new FileInputStream(((File) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            obj = null;
        }
        s = obj2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = BitmapFactory.decodeFileDescriptor(((FileInputStream) (obj)).getFD(), null, options);
        obj1 = s;
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
                return s;
            }
            return s;
        }
          goto _L1
        s;
        s.printStackTrace();
        if (obj == null) goto _L1; else goto _L3
_L3:
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return null;
        s;
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw s;
    }

    public static Bitmap a(String s, int i)
        throws IOException
    {
        Object obj = null;
        Bitmap bitmap = a(s);
        if (bitmap != null)
        {
            if ((bitmap = b(bitmap, i)) != null)
            {
                s = a(bitmap, s);
                obj = s;
                if (bitmap != s)
                {
                    bitmap.recycle();
                    return s;
                }
            }
        }
        return ((Bitmap) (obj));
    }

    public static int b(String s)
        throws IOException
    {
        return (new ExifInterface(s)).getAttributeInt("Orientation", 1);
    }

    public static Bitmap b(Bitmap bitmap, int i)
    {
        int j = bitmap.getWidth();
        int k = bitmap.getHeight();
        if (j > k)
        {
            k = (k * i) / j;
            j = i;
        } else
        {
            j = (j * i) / k;
            k = i;
        }
        return Bitmap.createScaledBitmap(bitmap, j, k, false);
    }
}
