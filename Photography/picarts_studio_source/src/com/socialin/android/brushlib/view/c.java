// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.view;

import com.socialin.android.photo.draw.DrawingActivity;

// Referenced classes of package com.socialin.android.brushlib.view:
//            DrawingView

public class c
{

    public DrawingActivity a;

    public c(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }

    public void a(DrawingView.EditingMode editingmode)
    {
        DrawingView.DrawingMode drawingmode = DrawingActivity.b(a).b();
        if (drawingmode != null && editingmode != null)
        {
            DrawingActivity.a(a, editingmode, drawingmode);
        }
    }
}
