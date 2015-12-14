// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.graphics.Bitmap;

// Referenced classes of package com.cyberlink.clgpuimage:
//            z, af

class b
    implements Runnable
{

    final Bitmap a;
    final boolean b;
    final z c;

    public void run()
    {
        Bitmap bitmap = null;
        if (a.getWidth() % 2 == 1)
        {
            bitmap = Bitmap.createScaledBitmap(a, a.getWidth() + 1, a.getHeight(), false);
        }
        z z1 = c;
        Bitmap bitmap1;
        if (bitmap != null)
        {
            bitmap1 = bitmap;
        } else
        {
            bitmap1 = a;
        }
        z.e(z1, af.a(bitmap1, z.n(c), b));
        if (bitmap != null)
        {
            bitmap.recycle();
        }
        z.a(c, a.getWidth());
        z.b(c, a.getHeight());
        z.a(c);
    }

    (z z1, Bitmap bitmap, boolean flag)
    {
        c = z1;
        a = bitmap;
        b = flag;
        super();
    }
}
