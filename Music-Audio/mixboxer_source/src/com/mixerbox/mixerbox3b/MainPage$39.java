// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0
    implements android.view.Listener
{

    final MainPage this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 1)
        {
            return true;
        }
        if (videoState == 1)
        {
            MainPage.access$200(MainPage.this).removeMessages(1);
            MainPage.access$200(MainPage.this).sendEmptyMessageDelayed(1, 4000L);
        }
        if (rlPanelTop.getVisibility() == 8)
        {
            if (SCREEN_STATE == 2)
            {
                rlPanelPopup.setVisibility(0);
                rlPanelPopup.startAnimation(MainPage.access$400(300, 0.0F, 0.0F, -1F, 0.0F));
                btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200d3));
            } else
            {
                rlPanelPopup.setVisibility(8);
                btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
            }
            rlPanelTop.setVisibility(0);
            rlPanelTop.startAnimation(MainPage.access$400(300, 0.0F, 0.0F, -1F, 0.0F));
            rlPanelBottom.setVisibility(0);
            rlPanelBottom.startAnimation(MainPage.access$400(300, 0.0F, 0.0F, 1.0F, 0.0F));
            return true;
        } else
        {
            rlPanelPopup.setVisibility(8);
            btnExpand.setImageDrawable(getResources().getDrawable(0x7f0200db));
            view = MainPage.access$400(300, 0.0F, 0.0F, 0.0F, -1F);
            class _cls1
                implements android.view.animation.Animation.AnimationListener
            {

                final MainPage._cls39 this$1;

                public void onAnimationEnd(Animation animation)
                {
                    rlPanelTop.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            _cls1()
            {
                this$1 = MainPage._cls39.this;
                super();
            }
            }

            view.setAnimationListener(new _cls1());
            rlPanelTop.startAnimation(view);
            view = MainPage.access$400(300, 0.0F, 0.0F, 0.0F, 1.0F);
            class _cls2
                implements android.view.animation.Animation.AnimationListener
            {

                final MainPage._cls39 this$1;

                public void onAnimationEnd(Animation animation)
                {
                    rlPanelBottom.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            _cls2()
            {
                this$1 = MainPage._cls39.this;
                super();
            }
            }

            view.setAnimationListener(new _cls2());
            rlPanelBottom.startAnimation(view);
            return true;
        }
    }

    _cls2()
    {
        this$0 = MainPage.this;
        super();
    }
}
