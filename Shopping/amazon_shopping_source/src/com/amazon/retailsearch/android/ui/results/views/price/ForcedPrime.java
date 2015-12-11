// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.InteractiveRetailSearchResultView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            ForcedPrimeModel

public class ForcedPrime extends TextView
    implements InteractiveRetailSearchResultView
{

    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String PRICE_STYLED_TEXT = "HIGHLIGHT";
    private ForcedPrimeModel model;
    UserInteractionListener userInteractionListener;

    public ForcedPrime(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void buildView(ForcedPrimeModel forcedprimemodel, ViewType viewtype)
    {
        if (forcedprimemodel == null)
        {
            setVisibility(8);
            return;
        }
        model = forcedprimemodel;
        viewtype = new StyledSpannableString(viewtype, getContext());
        viewtype.append(forcedprimemodel.getLowerPriceMessage(), com.amazon.retailsearch.R.style.Results_ForcedPrimeLowerPriceLink);
        if (forcedprimemodel.getPriceAndLabel() != null && !forcedprimemodel.getPriceAndLabel().isEmpty())
        {
            viewtype.append(NEW_LINE);
            for (forcedprimemodel = forcedprimemodel.getPriceAndLabel().iterator(); forcedprimemodel.hasNext();)
            {
                StyledText styledtext = (StyledText)forcedprimemodel.next();
                if ("HIGHLIGHT".equals(styledtext.getStyle()))
                {
                    viewtype.append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_ForcedPrimePrice);
                } else
                {
                    viewtype.append(styledtext.getText());
                }
            }

        }
        setText(viewtype);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((ForcedPrimeModel)obj, viewtype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem retailsearchresultitem = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(model.getAsin(), model.getUrl(), model.getProductGroup());
        userInteractionListener.resultItemSelected(retailsearchresultitem, DetailPageType.FORCED_PRIME);
    }

}
