// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import co.vine.android.animation.SimpleAnimationListener;

// Referenced classes of package co.vine.android.recorder:
//            RecordingAnimations

static final class er extends SimpleAnimationListener
{

    final ImageView val$focusIndicator;
    final ScaleAnimation val$focusResizeAnimation;

    public void onAnimationEnd(Animation animation)
    {
        val$focusIndicator.startAnimation(val$focusResizeAnimation);
    }

    er(ImageView imageview, ScaleAnimation scaleanimation)
    {
        val$focusIndicator = imageview;
        val$focusResizeAnimation = scaleanimation;
        super();
    }
}
