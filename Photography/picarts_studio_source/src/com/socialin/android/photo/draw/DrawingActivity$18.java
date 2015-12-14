// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.view.View;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.view.r
{

    private DrawingActivity a;

    public final void onClick(View view)
    {
        DrawingActivity.b(a, view);
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
