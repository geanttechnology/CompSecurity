// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.Matrix;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer

class af
{

    public Matrix a;
    public boolean b;
    final PanZoomViewer c;

    public af(PanZoomViewer panzoomviewer, Matrix matrix, boolean flag)
    {
        c = panzoomviewer;
        super();
        a = null;
        b = true;
        a = new Matrix(matrix);
        b = flag;
    }
}
