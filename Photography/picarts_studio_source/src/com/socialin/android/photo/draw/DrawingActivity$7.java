// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.support.v7.app.AppCompatDialog;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements Runnable
{

    private DrawingActivity a;

    public final void run()
    {
        DrawingActivity.t(a).dismiss();
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
