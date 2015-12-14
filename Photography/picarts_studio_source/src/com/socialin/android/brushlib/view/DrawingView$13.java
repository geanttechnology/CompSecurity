// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import com.socialin.android.brushlib.layer.CameraMaskLayer;
import com.socialin.android.brushlib.state.a;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class a
    implements Runnable
{

    private Runnable a;
    private DrawingView b;

    public final void run()
    {
        b.a(true);
        com.socialin.android.brushlib.view.DrawingView.a(b).c(com.socialin.android.brushlib.view.DrawingView.a(b).j.d);
        a.run();
    }

    r(DrawingView drawingview, Runnable runnable)
    {
        b = drawingview;
        a = runnable;
        super();
    }
}
