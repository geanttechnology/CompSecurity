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

    private byte a[];
    private DrawingActivity b;

    public final void run()
    {
        DrawingActivity.b(b).setDrawingMode(com.socialin.android.brushlib.view.Mode.DRAW);
        DrawingActivity.b(b).setEditingMode(com.socialin.android.brushlib.view.Mode.SHAPE);
        DrawingActivity.b(b).setClipArtData(a);
    }

    ingMode(DrawingActivity drawingactivity, byte abyte0[])
    {
        b = drawingactivity;
        a = abyte0;
        super();
    }
}
