// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            InteractiveRetailSearchResultView, ResultCloseSeparatorBackgroundDrawable, ResultCloseSeparatorModel

public class ResultCloseSeparator extends View
    implements InteractiveRetailSearchResultView
{

    private android.view.View.OnClickListener listener;

    public ResultCloseSeparator(Context context)
    {
        super(context);
    }

    public ResultCloseSeparator(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public ResultCloseSeparator(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void buildView(ResultCloseSeparatorModel resultcloseseparatormodel, ResultLayoutType resultlayouttype)
    {
        if (resultcloseseparatormodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setBackgroundDrawable(new ResultCloseSeparatorBackgroundDrawable(getResources().getColor(com.amazon.retailsearch.R.color.rs_immersive_view_divider_fill), getResources().getColor(com.amazon.retailsearch.R.color.rs_immersive_view_divider_border), getResources().getColor(com.amazon.retailsearch.R.color.rs_immersive_view_divider_cross)));
            listener = resultcloseseparatormodel.getListener();
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((ResultCloseSeparatorModel)obj, resultlayouttype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        listener.onClick(this);
    }
}
