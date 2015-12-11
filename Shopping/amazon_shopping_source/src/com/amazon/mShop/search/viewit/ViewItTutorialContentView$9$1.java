// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        ViewItTutorialContentView.access$300(_fld0, com.amazon.mShop.android.lib.e_3, com.amazon.mShop.android.lib.ription_3);
        ViewItTutorialContentView.access$1200(_fld0);
    }

    l.isBarcode()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItTutorialContentView$9

/* anonymous class */
    class ViewItTutorialContentView._cls9
        implements android.view.animation.Animation.AnimationListener
    {

        final ViewItTutorialContentView this$0;
        final boolean val$isBarcode;

        public void onAnimationEnd(Animation animation)
        {
            mProductsFrame.setVisibility(8);
            if (!isBarcode)
            {
                hideTutorialTitleAndDescription();
                ViewItTutorialContentView.access$1100(ViewItTutorialContentView.this);
                return;
            } else
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new ViewItTutorialContentView._cls9._cls1(), 100L);
                return;
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = final_viewittutorialcontentview;
                isBarcode = Z.this;
                super();
            }
    }

}
