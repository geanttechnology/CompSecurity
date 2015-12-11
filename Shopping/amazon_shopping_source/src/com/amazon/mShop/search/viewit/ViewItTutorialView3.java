// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItTutorialContentView

public class ViewItTutorialView3 extends ViewItTutorialContentView
{

    public ViewItTutorialView3(Context context, int i, int j)
    {
        super(context);
        updateContentView();
        reLayoutContentView(i, j);
        updateTitleAndDescription(com.amazon.mShop.android.lib.R.string.view_it_tutorial_title_2, com.amazon.mShop.android.lib.R.string.view_it_tutorial_description_2);
        hideTutorialTitleAndDescription();
        hideNextButton();
        animateOutProductsFrame(true);
    }

    public void updateContentView()
    {
        super.updateContentView();
        mDeviceAndHistoryTrayFrame.setVisibility(0);
        mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_barcode);
        mProductsFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_barcode);
    }
}
