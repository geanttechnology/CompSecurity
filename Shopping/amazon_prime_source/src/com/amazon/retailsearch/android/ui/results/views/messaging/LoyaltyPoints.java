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
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.messaging:
//            LoyaltyPointsModel

public class LoyaltyPoints extends TextView
    implements RetailSearchResultView
{

    Context context;

    public LoyaltyPoints(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        context = context1;
    }

    public void buildView(LoyaltyPointsModel loyaltypointsmodel, ResultLayoutType resultlayouttype)
    {
        if (loyaltypointsmodel == null)
        {
            setVisibility(8);
            return;
        }
        resultlayouttype = new StyledSpannableString(resultlayouttype, context);
        for (loyaltypointsmodel = loyaltypointsmodel.getLabelStyledText().iterator(); loyaltypointsmodel.hasNext();)
        {
            StyledText styledtext = (StyledText)loyaltypointsmodel.next();
            if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
            {
                resultlayouttype.append(styledtext, com.amazon.retailsearch.R.style.Results_LoyaltyPointsHighlight);
            } else
            if (RetailSearchResultStyles.STYLE_HIGHLIGHT2.equals(styledtext.getStyle()))
            {
                resultlayouttype.append(styledtext, com.amazon.retailsearch.R.style.Results_LoyaltyPointsHighlight2);
            } else
            if (RetailSearchResultStyles.STYLE_PLAIN.equals(styledtext.getStyle()))
            {
                resultlayouttype.append(styledtext, com.amazon.retailsearch.R.style.Results_LoyaltyPointsPlain);
            } else
            {
                resultlayouttype.append(styledtext.getText());
            }
        }

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
        buildView((LoyaltyPointsModel)obj, resultlayouttype);
    }
}
