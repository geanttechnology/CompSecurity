// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

// Referenced classes of package wantu.sephiroth.android.library.imagezoom:
//            ImageViewTouchBase

class d
    implements Runnable
{

    final Drawable a;
    final boolean b;
    final Matrix c;
    final float d;
    final ImageViewTouchBase e;

    public void run()
    {
        e.setImageDrawable(a, b, c, d);
    }

    (ImageViewTouchBase imageviewtouchbase, Drawable drawable, boolean flag, Matrix matrix, float f)
    {
        e = imageviewtouchbase;
        a = drawable;
        b = flag;
        c = matrix;
        d = f;
        super();
    }
}
