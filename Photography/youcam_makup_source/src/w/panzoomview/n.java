// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.graphics.Matrix;

// Referenced classes of package w.panzoomview:
//            PanZoomView

class n
{

    public Matrix a;
    public boolean b;
    final PanZoomView c;

    public n(PanZoomView panzoomview, Matrix matrix, boolean flag)
    {
        c = panzoomview;
        super();
        a = null;
        b = true;
        a = new Matrix(matrix);
        b = flag;
    }
}
