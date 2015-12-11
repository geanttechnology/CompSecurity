// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.device.ads:
//            co, cn

class bs
{

    private static final String a = com/amazon/device/ads/bs.getSimpleName();
    private final cn b;

    bs()
    {
        new co();
        b = co.a(a);
    }

    public static String a(Context context, Bitmap bitmap, String s, String s1)
    {
        return android.provider.MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, s, s1);
    }

    public final Bitmap a(InputStream inputstream)
    {
        if (inputstream != null)
        {
            BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream, 32768);
            bufferedinputstream.mark(32768);
            inputstream = BitmapFactory.decodeStream(bufferedinputstream);
            try
            {
                bufferedinputstream.close();
            }
            catch (IOException ioexception)
            {
                b.d("IOException while trying to close the input stream.", null);
                return inputstream;
            }
            return inputstream;
        } else
        {
            return null;
        }
    }

}
