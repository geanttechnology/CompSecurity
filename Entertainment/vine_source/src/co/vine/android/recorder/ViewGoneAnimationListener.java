// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.animation.Animator;
import android.view.View;
import android.view.ViewPropertyAnimator;

public class ViewGoneAnimationListener
    implements android.animation.Animator.AnimatorListener
{

    private View mView;

    public ViewGoneAnimationListener(View view)
    {
        mView = view;
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (mView != null)
        {
            mView.setVisibility(4);
            mView.animate().setListener(null);
            mView.setAlpha(1.0F);
            mView = null;
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }
}
