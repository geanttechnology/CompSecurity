// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.messaging;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            EsrbRatingModel

public class EsrbRating extends TextView
    implements RetailSearchResultView
{

    Context context;

    public EsrbRating(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(EsrbRatingModel esrbratingmodel, ViewType viewtype)
    {
        if (esrbratingmodel == null)
        {
            setVisibility(8);
            return;
        } else
        {
            setText(esrbratingmodel.getEsrbRatingMessage());
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((EsrbRatingModel)obj, viewtype);
    }
}
