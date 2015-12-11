// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.animation.Animation;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls0
    implements android.view.animation.View._cls10
{

    final ViewItTutorialContentView this$0;

    public void onAnimationEnd(Animation animation)
    {
        com.amazon.mShop.platform.w._mth10().invokeLater(new Runnable() {

            final ViewItTutorialContentView._cls10 this$1;

            public void run()
            {
                ViewItTutorialContentView.access$100(this$0, 3, 0.0F);
            }

            
            {
                this$1 = ViewItTutorialContentView._cls10.this;
                super();
            }
        }, 300L);
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
