// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            FreeRentalLineModel

public class FreeRentalLine extends TextView
    implements RetailSearchResultView
{

    public FreeRentalLine(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(FreeRentalLineModel freerentallinemodel, ResultLayoutType resultlayouttype)
    {
        if (freerentallinemodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setText(freerentallinemodel.getFreeRentalLabel());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((FreeRentalLineModel)obj, resultlayouttype);
    }
}
