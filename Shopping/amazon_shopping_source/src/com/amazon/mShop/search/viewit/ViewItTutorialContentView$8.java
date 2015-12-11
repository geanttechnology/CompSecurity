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

class this._cls0
    implements android.view.animation.tView._cls8
{

    final ViewItTutorialContentView this$0;

    public void onAnimationEnd(Animation animation)
    {
        ViewItTutorialContentView.access$1000(ViewItTutorialContentView.this).setText(com.amazon.mShop.android.lib.xt_button_get_started_text);
        ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new android.view.View.OnClickListener() {

            final ViewItTutorialContentView._cls8 this$1;

            public void onClick(View view)
            {
                ViewItTutorialContentView.access$000(this$0);
                RefMarkerObserver.logRefMarker("fl_tutor_start_btn");
            }

            
            {
                this$1 = ViewItTutorialContentView._cls8.this;
                super();
            }
        });
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = ViewItTutorialContentView.this;
        super();
    }
}
