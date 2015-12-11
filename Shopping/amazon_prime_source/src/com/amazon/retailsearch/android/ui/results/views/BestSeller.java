// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import dagger.Lazy;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView, BestSellerModel

public class BestSeller extends TextView
    implements RetailSearchResultView
{

    Lazy retailSearchDataProvider;

    public BestSeller(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void buildView(BestSellerModel bestsellermodel, ResultLayoutType resultlayouttype)
    {
        if (bestsellermodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, getContext());
        resultlayouttype.appendBadge(bestsellermodel.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_BestSeller));
        if (!TextUtils.isEmpty(bestsellermodel.getDepartmentLabel()))
        {
            resultlayouttype.append(bestsellermodel.getDepartmentLabel());
        }
        setText(resultlayouttype);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((BestSellerModel)obj, resultlayouttype);
    }
}
