// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            TradeInModel

public class TradeIn extends TextView
    implements RetailSearchResultView
{

    Context context;

    public TradeIn(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(TradeInModel tradeinmodel, ResultLayoutType resultlayouttype)
    {
        if (tradeinmodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setText(tradeinmodel.getTradeInMessage());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((TradeInModel)obj, resultlayouttype);
    }
}
