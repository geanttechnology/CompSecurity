// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.widget.Spinner;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private DrawingActivity a;

    public final void run()
    {
        DrawingActivity.E(a).setOnItemSelectedListener(DrawingActivity.D(a));
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
