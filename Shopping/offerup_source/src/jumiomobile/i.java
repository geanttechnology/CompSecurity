// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Matrix;
import android.view.TextureView;

// Referenced classes of package jumiomobile:
//            g

class i
    implements Runnable
{

    final Matrix a;
    final g b;

    i(g g1, Matrix matrix)
    {
        b = g1;
        a = matrix;
        super();
    }

    public void run()
    {
        g.h(b).setTransform(a);
    }
}
