// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.view.animation.Animation;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.animation.SimpleAnimationListener;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity

class ener extends SimpleAnimationListener
{

    final AbstractRecordingActivity this$0;
    final MoveResizeAnimator val$animator;

    public void onAnimationEnd(Animation animation)
    {
        val$animator.start();
    }

    ener()
    {
        this$0 = final_abstractrecordingactivity;
        val$animator = MoveResizeAnimator.this;
        super();
    }
}
