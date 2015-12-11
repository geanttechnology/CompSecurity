// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;

import android.graphics.Bitmap;
import java.io.InputStream;

// Referenced classes of package com.g.c:
//            z, ah

public static final class ring
{

    final ject a;
    final Bitmap b;
    final InputStream c;
    final int d;

    public tStream(Bitmap bitmap, hics.Bitmap bitmap1)
    {
        this((Bitmap)ah.a(bitmap, "bitmap == null"), null, bitmap1, 0);
    }

    ring(Bitmap bitmap, InputStream inputstream, tStream tstream, int i)
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
            a = (a)ah.a(tstream, "loadedFrom == null");
            d = i;
            return;
        }
    }

    public tStream(InputStream inputstream, tStream tstream)
    {
        this(null, (InputStream)ah.a(inputstream, "stream == null"), tstream, 0);
    }
}
