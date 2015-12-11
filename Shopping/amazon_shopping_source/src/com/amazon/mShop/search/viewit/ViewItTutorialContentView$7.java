// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView, ViewItTutorialView2, ViewItTutorialView3

class val.fromXValue
    implements android.view.animation.tView._cls7
{

    final ViewItTutorialContentView this$0;
    final float val$fromXValue;
    final int val$scannedItemIndex;

    public void onAnimationEnd(Animation animation)
    {
        ViewItTutorialContentView.access$500(ViewItTutorialContentView.this).setVisibility(8);
        switch (val$scannedItemIndex)
        {
        default:
            return;

        case 0: // '\0'
            mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.bottle);
            ViewItTutorialContentView.access$600(ViewItTutorialContentView.this, val$fromXValue);
            return;

        case 1: // '\001'
            mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.book);
            ViewItTutorialContentView.access$700(ViewItTutorialContentView.this, val$fromXValue);
            return;

        case 2: // '\002'
            mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.jar);
            ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new android.view.View.OnClickListener() {

                final ViewItTutorialContentView._cls7 this$1;

                public void onClick(View view)
                {
                    view = new ViewItTutorialView2(ViewItTutorialContentView.access$800(this$0), mDeviceFrameHeight, mProductsFrameWidth);
                    ViewItTutorialContentView.access$800(this$0).pushView(view, false);
                }

            
            {
                this$1 = ViewItTutorialContentView._cls7.this;
                super();
            }
            });
            return;

        case 3: // '\003'
            mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.barcode);
            break;
        }
        ViewItTutorialContentView.access$900(ViewItTutorialContentView.this, new android.view.View.OnClickListener() {

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
        });
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    _cls2.this._cls1()
    {
        this$0 = final_viewittutorialcontentview;
        val$scannedItemIndex = i;
        val$fromXValue = F.this;
        super();
    }
}
