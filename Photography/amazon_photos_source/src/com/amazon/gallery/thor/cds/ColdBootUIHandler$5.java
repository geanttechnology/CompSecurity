// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.app.Activity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class this._cls0
    implements Runnable
{

    final ColdBootUIHandler this$0;

    public void run()
    {
        final Runnable onAnimationEnd;
label0:
        {
            if (ColdBootUIHandler.access$600(ColdBootUIHandler.this).getVisibility() == 0)
            {
                ColdBootUIHandler.access$300(ColdBootUIHandler.this, 100);
                onAnimationEnd = new Runnable() {

                    final ColdBootUIHandler._cls5 this$1;

                    public void run()
                    {
                        ColdBootUIHandler.access$700(this$0).findViewById(0x7f0c0119).setVisibility(8);
                    }

            
            {
                this$1 = ColdBootUIHandler._cls5.this;
                super();
            }
                };
                if (!ColdBootUIHandler.USE_JELLYBEAN_ANIMATIONS)
                {
                    break label0;
                }
                ColdBootUIHandler.access$600(ColdBootUIHandler.this).animate().setDuration(400L).translationY(500F).withEndAction(onAnimationEnd);
            }
            return;
        }
        int ai[] = new int[2];
        ColdBootUIHandler.access$600(ColdBootUIHandler.this).getLocationOnScreen(ai);
        TranslateAnimation translateanimation = new TranslateAnimation(ai[0], ai[0], ai[1], 500F);
        translateanimation.setDuration(400L);
        translateanimation.setFillAfter(true);
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ColdBootUIHandler._cls5 this$1;
            final Runnable val$onAnimationEnd;

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
                this$1 = ColdBootUIHandler._cls5.this;
                onAnimationEnd = runnable;
                super();
            }
        });
        ColdBootUIHandler.access$600(ColdBootUIHandler.this).startAnimation(translateanimation);
    }

    _cls2.val.onAnimationEnd()
    {
        this$0 = ColdBootUIHandler.this;
        super();
    }
}
