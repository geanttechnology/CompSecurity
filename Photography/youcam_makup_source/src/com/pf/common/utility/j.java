// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.pf.common.utility:
//            d, h

class j extends d
    implements h
{

    private j()
    {
    }

    j(Bitmaps._cls1 _pcls1)
    {
        this();
    }

    public Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        return Bitmaps.Raw.a(inputstream, false);
    }

    public String a()
    {
        return ".abmp";
    }

    public void a(Bitmap bitmap, OutputStream outputstream)
    {
        Bitmaps.Raw.a(bitmap, outputstream, false);
    }

    public String toString()
    {
        return "AndroidBitmapRawCodec";
    }
}
