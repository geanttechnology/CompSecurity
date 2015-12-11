// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            ProductDescriptionModel

public class ProductDescription extends TextView
    implements RetailSearchResultView
{

    public ProductDescription(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(ProductDescriptionModel productdescriptionmodel, ResultLayoutType resultlayouttype)
    {
        if (productdescriptionmodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, getContext());
        resultlayouttype.append(productdescriptionmodel.getDescription(), com.amazon.retailsearch.R.style.Results_ProductDescription);
        if (TextUtils.isEmpty(resultlayouttype))
        {
            setVisibility(8);
            return;
        } else
        {
            setText(resultlayouttype);
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((ProductDescriptionModel)obj, resultlayouttype);
    }
}
