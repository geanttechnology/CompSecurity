// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.pf.common.utility:
//            d, c

public class e extends d
{

    private final c a;

    public e(c c1)
    {
        if (c1 == null)
        {
            throw new NullPointerException("codec == null");
        } else
        {
            a = c1;
            return;
        }
    }

    public Bitmap a(InputStream inputstream, android.graphics.BitmapFactory.Options options)
    {
        return a.a(inputstream, options);
    }

    public String a()
    {
        return a.a();
    }

    public void a(Bitmap bitmap, OutputStream outputstream)
    {
        a.a(bitmap, outputstream);
    }
}
