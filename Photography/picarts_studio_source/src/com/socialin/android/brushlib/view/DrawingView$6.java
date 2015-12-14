// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;


// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

public final class a
    implements Runnable
{

    private com.socialin.android.videogenerator.nerator.VideoOptions a;
    private DrawingView b;

    public final void run()
    {
        DrawingView.a(b, a);
    }

    public Options(DrawingView drawingview, com.socialin.android.videogenerator.nerator.VideoOptions videooptions)
    {
        b = drawingview;
        a = videooptions;
        super();
    }
}
