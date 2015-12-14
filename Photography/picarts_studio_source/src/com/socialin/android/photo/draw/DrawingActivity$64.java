// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.animation.Animator;
import android.view.ViewGroup;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity, b

final class a
    implements android.animation.stener
{

    private DrawingActivity a;

    public final void onAnimationCancel(Animator animator)
    {
        onAnimationEnd(animator);
    }

    public final void onAnimationEnd(Animator animator)
    {
        DrawingActivity.ar(a).setVisibility(8);
        com.socialin.android.photo.draw.DrawingActivity.b(a).c.b.f = DrawingActivity.aq(a);
        DrawingActivity.r(a).notifyDataSetChanged();
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    (DrawingActivity drawingactivity)
    {
        a = drawingactivity;
        super();
    }
}
