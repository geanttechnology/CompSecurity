// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

// Referenced classes of package co.vine.android:
//            ConversationFragment

private class _cls1 extends Animation
{

    private View mView;
    final ConversationFragment this$0;

    protected void applyTransformation(float f, Transformation transformation)
    {
        int i = getResources().getDimensionPixelSize(0x7f0b001e);
        mView.getLayoutParams().mView = (int)((float)i * (1.0F - f));
        mView.requestLayout();
    }

    public boolean willChangeBounds()
    {
        return true;
    }

    public _cls1.val.onAnimationEnd(View view, final Runnable onAnimationEnd)
    {
        this.this$0 = ConversationFragment.this;
        super();
        setFillAfter(true);
        setDuration(300L);
        mView = view;
        setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ConversationFragment.HeightAnimation this$1;
            final Runnable val$onAnimationEnd;
            final ConversationFragment val$this$0;

            public void onAnimationEnd(Animation animation)
            {
                onAnimationEnd.run();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$1 = ConversationFragment.HeightAnimation.this;
                this$0 = conversationfragment;
                onAnimationEnd = runnable;
                super();
            }
        });
    }
}
