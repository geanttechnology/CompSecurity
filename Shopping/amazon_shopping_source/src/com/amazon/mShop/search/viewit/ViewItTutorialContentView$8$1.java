// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import com.amazon.mShop.net.RefMarkerObserver;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls1
    implements android.view.alContentView._cls8._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        ViewItTutorialContentView.access$000(_fld0);
        RefMarkerObserver.logRefMarker("fl_tutor_start_btn");
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItTutorialContentView$8

/* anonymous class */
    class ViewItTutorialContentView._cls8
        implements android.view.animation.Animation.AnimationListener
    {

        final ViewItTutorialContentView this$0;

        public void onAnimationEnd(Animation animation)
        {
            ViewItTutorialContentView.access$1000(ViewItTutorialContentView.this).setText(com.amazon.mShop.android.lib.R.string.view_it_tutorial_next_button_get_started_text);
            ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new ViewItTutorialContentView._cls8._cls1());
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
    }

}
