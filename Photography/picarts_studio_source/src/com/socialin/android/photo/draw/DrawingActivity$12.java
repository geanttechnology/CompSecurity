// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private DrawingActivity a;

    public final void run()
    {
        DrawingView drawingview = DrawingActivity.b(a);
        if (drawingview.d == null) goto _L2; else goto _L1
_L1:
        com.socialin.android.brushlib.view.[drawingview.s.rdinal()];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 45;
           goto _L2 _L3
_L2:
        return;
_L3:
        drawingview.a();
        return;
    }

    e(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
