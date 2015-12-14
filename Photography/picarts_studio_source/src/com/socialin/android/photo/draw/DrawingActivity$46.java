// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.animation.Animator;
import android.view.View;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements android.animation.stener
{

    private View a;
    private DrawingActivity b;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        b.findViewById(0x7f1003cf).setVisibility(8);
        b.findViewById(0x7f1003d0).setVisibility(0);
        DrawingActivity.a(b, eraPanelState.OPENED);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
        DrawingActivity.a(b, eraPanelState.OPENING);
        a.setVisibility(0);
    }

    eraPanelState(DrawingActivity drawingactivity, View view)
    {
        b = drawingactivity;
        a = view;
        super();
    }
}
