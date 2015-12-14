// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import com.socialin.android.brushlib.controller.ShapeOverlayController;
import com.socialin.android.brushlib.controller.e;
import com.socialin.android.brushlib.state.a;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

public final class a
    implements Runnable
{

    private DrawingView a;

    public final void run()
    {
        itingMode itingmode = com.socialin.android.brushlib.view.DrawingView.a(a).i;
        if (itingmode == null) goto _L2; else goto _L1
_L1:
        c[itingmode.ordinal()];
        JVM INSTR tableswitch 4 5: default 44
    //                   4 53
    //                   5 66;
           goto _L2 _L3 _L4
_L2:
        a.a(true);
        return;
_L3:
        DrawingView.b(a).a();
        continue; /* Loop/switch isn't completed */
_L4:
        DrawingView.c(a).c();
        if (true) goto _L2; else goto _L5
_L5:
    }

    public rlayController(DrawingView drawingview)
    {
        a = drawingview;
        super();
    }
}
