// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements Runnable
{

    final MainPage this$0;

    public void run()
    {
        rlVideoPlayer.setVisibility(0);
        rlPanelTop.setVisibility(0);
        rlPanelBottom.setVisibility(0);
        Animation animation = MainPage.access$400(800, 0.0F, 0.0F, -1F, 0.0F);
        class _cls1
            implements android.view.animation.Animation.AnimationListener
        {

            final MainPage._cls32 this$1;

            public void onAnimationEnd(Animation animation1)
            {
                if (getRequestedOrientation() == 6 && SCREEN_STATE == 1)
                {
                    setFullScreen();
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            _cls1()
            {
                this$1 = MainPage._cls32.this;
                super();
            }
        }

        animation.setAnimationListener(new _cls1());
        rlVideoPlayer.startAnimation(animation);
    }

    _cls1()
    {
        this$0 = MainPage.this;
        super();
    }
}
