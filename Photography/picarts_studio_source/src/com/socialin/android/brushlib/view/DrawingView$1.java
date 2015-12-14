// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;


// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

final class a
    implements Runnable
{

    private DrawingView a;

    public final void run()
    {
        a.setEditingMode(itingMode.COLOR_PICKER);
        a.a(true);
    }

    itingMode(DrawingView drawingview)
    {
        a = drawingview;
        super();
    }
}
