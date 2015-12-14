// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.animation.Animator;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

// Referenced classes of package com.millennialmedia.internal.video:
//            LightboxView

class this._cls1
    implements android.animation.istener
{

    final ledRunnable this$1;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        LightboxView.access$2202(_fld0, null);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    l.animationDuration()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/millennialmedia/internal/video/LightboxView$17

/* anonymous class */
    class LightboxView._cls17
        implements Runnable
    {

        final LightboxView this$0;
        final long val$animationDuration;

        public void run()
        {
            if (!LightboxView.access$100(LightboxView.this))
            {
                LightboxView.access$700(LightboxView.this).animate().alpha(0.0F).setDuration(animationDuration).setListener(new LightboxView._cls17._cls1()).start();
            }
        }

            
            {
                this$0 = final_lightboxview;
                animationDuration = J.this;
                super();
            }
    }

}
