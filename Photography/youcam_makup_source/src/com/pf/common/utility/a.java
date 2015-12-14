// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

// Referenced classes of package com.pf.common.utility:
//            d, b

public class a extends d
{

    public final android.graphics.Bitmap.CompressFormat a;
    public final int b;

    private a(android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        a = compressformat;
        b = i;
    }

    a(android.graphics.Bitmap.CompressFormat compressformat, int i, Bitmaps._cls1 _pcls1)
    {
        this(compressformat, i);
    }

    public static a a(android.graphics.Bitmap.CompressFormat compressformat, int i)
    {
        if (compressformat == android.graphics.Bitmap.CompressFormat.PNG)
        {
            return new b(compressformat, i, null);
        } else
        {
            return new a(compressformat, i);
        }
    }

    public Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        return BitmapFactory.decodeStream(inputstream, null, options);
    }

    public String a()
    {
        if (a == android.graphics.Bitmap.CompressFormat.JPEG)
        {
            return ".jpg";
        } else
        {
            return (new StringBuilder()).append('.').append(a.name().toLowerCase(Locale.US)).toString();
        }
    }

    public void a(Bitmap bitmap, OutputStream outputstream)
    {
        bitmap.compress(a, b, outputstream);
    }

    public String toString()
    {
        return (new StringBuilder()).append("BitmapCompressProfile [format=").append(a).append(", quality=").append(b).append(']').toString();
    }
}
