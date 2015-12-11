// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class mActivity extends Handler
{

    WeakReference mActivity;

    public void handleMessage(Message message)
    {
        final MainPage theActivity;
        theActivity = (MainPage)mActivity.get();
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 1 2: default 44
    //                   1 56
    //                   2 45;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (!MainPage.isPageLoaded)
        {
            theActivity.setVideoPlayer();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (theActivity.rlPanelTop.getVisibility() == 0)
        {
            theActivity.rlPanelPopup.setVisibility(8);
            theActivity.btnExpand.setImageDrawable(theActivity.btnExpand.getContext().getResources().getDrawable(0x7f0200db));
            message = MainPage.access$400(300, 0.0F, 0.0F, 0.0F, -1F);
            class _cls1
                implements android.view.animation.Animation.AnimationListener
            {

                final MainPage.MyHandler this$0;
                final MainPage val$theActivity;

                public void onAnimationEnd(Animation animation)
                {
                    theActivity.rlPanelTop.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            _cls1()
            {
                this$0 = MainPage.MyHandler.this;
                theActivity = mainpage;
                super();
            }
            }

            message.setAnimationListener(new _cls1());
            theActivity.rlPanelTop.startAnimation(message);
            message = MainPage.access$400(300, 0.0F, 0.0F, 0.0F, 1.0F);
            class _cls2
                implements android.view.animation.Animation.AnimationListener
            {

                final MainPage.MyHandler this$0;
                final MainPage val$theActivity;

                public void onAnimationEnd(Animation animation)
                {
                    theActivity.rlPanelBottom.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation)
                {
                }

                public void onAnimationStart(Animation animation)
                {
                }

            _cls2()
            {
                this$0 = MainPage.MyHandler.this;
                theActivity = mainpage;
                super();
            }
            }

            message.setAnimationListener(new _cls2());
            theActivity.rlPanelBottom.startAnimation(message);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    _cls2(MainPage mainpage)
    {
        mActivity = new WeakReference(mainpage);
    }
}
