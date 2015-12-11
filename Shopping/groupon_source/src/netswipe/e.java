// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.graphics.Matrix;
import android.view.TextureView;

// Referenced classes of package netswipe:
//            c

class e
    implements Runnable
{

    final Matrix a;
    final c b;

    e(c c1, Matrix matrix)
    {
        b = c1;
        a = matrix;
        super();
    }

    public void run()
    {
        c.d(b).setTransform(a);
    }
}
