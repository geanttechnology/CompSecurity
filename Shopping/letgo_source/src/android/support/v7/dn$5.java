// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.abtnprojects.ambatana.b;

// Referenced classes of package android.support.v7:
//            dn, aqo, da

class e
    implements Runnable
{

    final Bitmap a;
    final int b;
    final int c;
    final nit> d;
    final int e;
    final dn f;

    public void run()
    {
        Bitmap bitmap = ThumbnailUtils.extractThumbnail(a, b, c);
        if (bitmap != null)
        {
            d.b(new b(bitmap, e));
            return;
        } else
        {
            aqo.d("Could not generate the bitmap", new Object[0]);
            d.b(new da());
            return;
        }
    }

    a.b(dn dn1, Bitmap bitmap, int i, int j, a.b b1, int k)
    {
        f = dn1;
        a = bitmap;
        b = i;
        c = j;
        d = b1;
        e = k;
        super();
    }
}
