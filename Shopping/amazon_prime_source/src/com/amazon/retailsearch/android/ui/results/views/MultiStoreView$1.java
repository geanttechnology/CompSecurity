// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ProductViewModel;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            MultiStoreView, MultiStoreModel

class val.model
    implements android.view.ner
{

    final MultiStoreView this$0;
    final List val$additionalViews;
    final ImageView val$indicator;
    final MultiStoreModel val$model;
    final TextView val$text;

    public void onClick(View view)
    {
        boolean flag = false;
        for (view = val$additionalViews.iterator(); view.hasNext();)
        {
            View view1 = (View)view.next();
            if (view1.getVisibility() == 8)
            {
                view1.setVisibility(0);
                flag = true;
            } else
            {
                view1.setVisibility(8);
                flag = false;
            }
        }

        MultiStoreView.access$000(MultiStoreView.this, val$text, val$indicator, flag);
        val$model.getProductViewModel().setMultiStoreExpanded(flag);
    }

    ()
    {
        this$0 = final_multistoreview;
        val$additionalViews = list;
        val$text = textview;
        val$indicator = imageview;
        val$model = MultiStoreModel.this;
        super();
    }
}
