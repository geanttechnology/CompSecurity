// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package jumiomobile:
//            be

public class ay
{

    public static Bitmap a(byte abyte0[], int i, int j)
    {
        Bitmap bitmap = Bitmap.createBitmap(i, j, android.graphics.Bitmap.Config.ARGB_8888);
        for (j = 0; j < abyte0.length / 3; j++)
        {
            bitmap.setPixel(j % i, j / i, 0xff000000 | (abyte0[j * 3] & 0xff) << 16 | (abyte0[j * 3 + 1] & 0xff) << 8 | abyte0[j * 3 + 2] & 0xff);
        }

        return bitmap;
    }

    public static byte[] a(Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(compressformat, i, bytearrayoutputstream);
        bitmap = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        return bitmap;
        compressformat;
        bitmap = null;
_L2:
        compressformat.printStackTrace();
        return bitmap;
        compressformat;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static byte[] a(byte abyte0[], int i, int j, android.graphics.Bitmap.CompressFormat compressformat, int k)
    {
        abyte0 = a(abyte0, i, j);
        compressformat = a(((Bitmap) (abyte0)), compressformat, k);
        be.b(abyte0);
        return compressformat;
    }
}
