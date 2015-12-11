// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import co.vine.android.animation.SimpleAnimationListener;

// Referenced classes of package co.vine.android.recorder:
//            RecordingAnimations

static final class er extends SimpleAnimationListener
{

    final AlphaAnimation val$focusDismissAnimation;
    final ImageView val$focusIndicator;

    public void onAnimationEnd(Animation animation)
    {
        val$focusIndicator.startAnimation(val$focusDismissAnimation);
    }

    er(ImageView imageview, AlphaAnimation alphaanimation)
    {
        val$focusIndicator = imageview;
        val$focusDismissAnimation = alphaanimation;
        super();
    }
}
