// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.animation.Animation;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ViewItTutorialContentView.access$100(_fld0, 3, 0.0F);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItTutorialContentView$10

/* anonymous class */
    class ViewItTutorialContentView._cls10
        implements android.view.animation.Animation.AnimationListener
    {

        final ViewItTutorialContentView this$0;

        public void onAnimationEnd(Animation animation)
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new ViewItTutorialContentView._cls10._cls1(), 300L);
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
