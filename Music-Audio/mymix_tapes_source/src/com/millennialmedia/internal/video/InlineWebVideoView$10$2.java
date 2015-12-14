// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.widget.ToggleButton;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class this._cls1
    implements android.animation.r
{

    final is._cls0 this$1;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        InlineWebVideoView.access$900(_fld0).setVisibility(8);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$10

/* anonymous class */
    class InlineWebVideoView._cls10
        implements Runnable
    {

        final InlineWebVideoView this$0;

        public void run()
        {
            InlineWebVideoView.access$500(InlineWebVideoView.this).animate().alpha(0.0F).setDuration(500L).setListener(new InlineWebVideoView._cls10._cls1()).start();
            InlineWebVideoView.access$900(InlineWebVideoView.this).animate().alpha(0.0F).setDuration(500L).setListener(new InlineWebVideoView._cls10._cls2()).start();
        }

            
            {
                this$0 = InlineWebVideoView.this;
                super();
            }

        // Unreferenced inner class com/millennialmedia/internal/video/InlineWebVideoView$10$1

/* anonymous class */
        class InlineWebVideoView._cls10._cls1
            implements android.animation.Animator.AnimatorListener
        {

            final InlineWebVideoView._cls10 this$1;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                InlineWebVideoView.access$500(this$0).setVisibility(8);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

                    
                    {
                        this$1 = InlineWebVideoView._cls10.this;
                        super();
                    }
        }

    }

}
