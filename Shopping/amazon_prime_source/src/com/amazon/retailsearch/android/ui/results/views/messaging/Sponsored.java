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
//            SponsoredModel

public class Sponsored extends TextView
    implements RetailSearchResultView
{

    public Sponsored(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public void buildView(SponsoredModel sponsoredmodel, ResultLayoutType resultlayouttype)
    {
        if (sponsoredmodel == null || Utils.isEmpty(sponsoredmodel.getMessage()))
        {
            setVisibility(8);
            return;
        } else
        {
            resultlayouttype = new StyledSpannableString(resultlayouttype, getContext());
            resultlayouttype.append(sponsoredmodel.getMessage(), com.amazon.retailsearch.R.style.Rs);
            setText(resultlayouttype);
            setVisibility(0);
            return;
        }
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((SponsoredModel)obj, resultlayouttype);
    }
}
