// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            Price

public class PriceGallery extends Price
{

    public PriceGallery(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void postInflate()
    {
        priceLineList.add((TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_price_line0));
    }
}
