// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.util.Utils;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            CouponModel

public class Coupon extends TextView
    implements RetailSearchResultView
{

    public Coupon(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(CouponModel couponmodel, ResultLayoutType resultlayouttype)
    {
        if (couponmodel == null || resultlayouttype == null || Utils.isEmpty(couponmodel.getBadgeText()) && Utils.isEmpty(couponmodel.getLabel()))
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, getContext());
        if (!Utils.isEmpty(couponmodel.getBadgeText()))
        {
            resultlayouttype.append(couponmodel.getBadgeText(), com.amazon.retailsearch.R.style.Results_Coupon);
        }
        resultlayouttype.append(couponmodel.getLabel(), com.amazon.retailsearch.R.style.Results_Coupon);
        setText(resultlayouttype);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((CouponModel)obj, resultlayouttype);
    }
}
