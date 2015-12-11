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
//            VariationsModel

public class Variations extends TextView
    implements RetailSearchResultView
{

    Context context;

    public Variations(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(VariationsModel variationsmodel, ResultLayoutType resultlayouttype)
    {
        if (variationsmodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setText(variationsmodel.getVariationsMessage());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((VariationsModel)obj, resultlayouttype);
    }
}
