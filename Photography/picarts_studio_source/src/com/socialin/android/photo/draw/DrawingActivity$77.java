// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.brushlib.view.DrawingView;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a extends Thread
{

    private DrawingActivity a;

    public final void run()
    {
        String s = DrawingActivity.a(a, android.graphics.at.JPEG);
        c.a(a, s, DrawingActivity.b(a).f(), DrawingActivity.b(a).g());
        a.b();
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
