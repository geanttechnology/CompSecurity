// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

class val.isBarcode
    implements android.view.animation.tView._cls9
{

    final ViewItTutorialContentView this$0;
    final boolean val$isBarcode;

    public void onAnimationEnd(Animation animation)
    {
        mProductsFrame.setVisibility(8);
        if (!val$isBarcode)
        {
            hideTutorialTitleAndDescription();
            ViewItTutorialContentView.access$1100(ViewItTutorialContentView.this);
            return;
        } else
        {
            com.amazon.mShop.platform.().invokeLater(new Runnable() {

                final ViewItTutorialContentView._cls9 this$1;

                public void run()
                {
                    ViewItTutorialContentView.access$300(this$0, com.amazon.mShop.android.lib.R.string.view_it_tutorial_title_3, com.amazon.mShop.android.lib.R.string.view_it_tutorial_description_3);
                    ViewItTutorialContentView.access$1200(this$0);
                }

            
            {
                this$1 = ViewItTutorialContentView._cls9.this;
                super();
            }
            }, 100L);
            return;
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls1.this._cls1()
    {
        this$0 = final_viewittutorialcontentview;
        val$isBarcode = Z.this;
        super();
    }
}
