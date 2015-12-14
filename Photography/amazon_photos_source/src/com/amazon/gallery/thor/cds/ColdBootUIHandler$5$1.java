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

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ColdBootUIHandler.access$700(_fld0).findViewById(0x7f0c0119).setVisibility(8);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/thor/cds/ColdBootUIHandler$5

/* anonymous class */
    class ColdBootUIHandler._cls5
        implements Runnable
    {

        final ColdBootUIHandler this$0;

        public void run()
        {
            final ColdBootUIHandler._cls5._cls1 onAnimationEnd;
label0:
            {
                if (ColdBootUIHandler.access$600(ColdBootUIHandler.this).getVisibility() == 0)
                {
                    ColdBootUIHandler.access$300(ColdBootUIHandler.this, 100);
                    onAnimationEnd = new ColdBootUIHandler._cls5._cls1();
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
            translateanimation.setAnimationListener(new ColdBootUIHandler._cls5._cls2());
            ColdBootUIHandler.access$600(ColdBootUIHandler.this).startAnimation(translateanimation);
        }

            
            {
                this$0 = ColdBootUIHandler.this;
                super();
            }

        // Unreferenced inner class com/amazon/gallery/thor/cds/ColdBootUIHandler$5$2

/* anonymous class */
        class ColdBootUIHandler._cls5._cls2
            implements android.view.animation.Animation.AnimationListener
        {

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
        }

    }

}
