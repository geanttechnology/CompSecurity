// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.brushlib.view.b;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements b
{

    private DrawingActivity a;

    public final void a(com.socialin.android.brushlib.view.gMode gmode)
    {
        com.socialin.android.brushlib.view.gMode gmode1 = com.socialin.android.photo.draw.DrawingActivity.b(a).e();
        if (gmode1 != null && gmode != null)
        {
            DrawingActivity.a(a, gmode1, gmode);
        }
    }

    wingMode(DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
