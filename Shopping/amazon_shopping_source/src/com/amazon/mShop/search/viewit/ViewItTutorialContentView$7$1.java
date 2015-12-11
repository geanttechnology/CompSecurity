// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialView2, ViewItTutorialContentView, ViewItTutorialView3

class this._cls1
    implements android.view.alContentView._cls7._cls1
{

    final is._cls0 this$1;

    public void onClick(View view)
    {
        view = new ViewItTutorialView2(ViewItTutorialContentView.access$800(_fld0), mDeviceFrameHeight, mProductsFrameWidth);
        ViewItTutorialContentView.access$800(_fld0).pushView(view, false);
    }

    l.fromXValue()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItTutorialContentView$7

/* anonymous class */
    class ViewItTutorialContentView._cls7
        implements android.view.animation.Animation.AnimationListener
    {

        final ViewItTutorialContentView this$0;
        final float val$fromXValue;
        final int val$scannedItemIndex;

        public void onAnimationEnd(Animation animation)
        {
            ViewItTutorialContentView.access$500(ViewItTutorialContentView.this).setVisibility(8);
            switch (scannedItemIndex)
            {
            default:
                return;

            case 0: // '\0'
                mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_bottle);
                ViewItTutorialContentView.access$600(ViewItTutorialContentView.this, fromXValue);
                return;

            case 1: // '\001'
                mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_book);
                ViewItTutorialContentView.access$700(ViewItTutorialContentView.this, fromXValue);
                return;

            case 2: // '\002'
                mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_jar);
                ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new ViewItTutorialContentView._cls7._cls1());
                return;

            case 3: // '\003'
                mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_barcode);
                break;
            }
            ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new ViewItTutorialContentView._cls7._cls2());
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

            
            {
                this$0 = final_viewittutorialcontentview;
                scannedItemIndex = i;
                fromXValue = F.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/search/viewit/ViewItTutorialContentView$7$2

/* anonymous class */
        class ViewItTutorialContentView._cls7._cls2
            implements android.view.View.OnClickListener
        {

            final ViewItTutorialContentView._cls7 this$1;

            public void onClick(View view)
            {
                view = new ViewItTutorialView3(ViewItTutorialContentView.access$800(this$0), mDeviceFrameHeight, mProductsFrameWidth);
                ViewItTutorialContentView.access$800(this$0).pushView(view, false);
            }

                    
                    {
                        this$1 = ViewItTutorialContentView._cls7.this;
                        super();
                    }
        }

    }

}
