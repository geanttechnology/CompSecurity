// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            InteractiveRetailSearchResultView, PrimeOptionsItemViewModel

public class PrimeOptionsItemView extends TextView
    implements InteractiveRetailSearchResultView
{

    private PrimeOptionsItemViewModel model;
    UserInteractionListener userInteractionListener;

    public PrimeOptionsItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        RetailSearchDaggerGraphController.inject(this);
    }

    public void buildView(PrimeOptionsItemViewModel primeoptionsitemviewmodel, ResultLayoutType resultlayouttype)
    {
        StyledSpannableString styledspannablestring;
        if (primeoptionsitemviewmodel == null || resultlayouttype == null || TextUtils.isEmpty(primeoptionsitemviewmodel.getBadgeId()) && TextUtils.isEmpty(primeoptionsitemviewmodel.getBadgeText()))
        {
            setVisibility(8);
            return;
        }
        model = primeoptionsitemviewmodel;
        styledspannablestring = new StyledSpannableString(resultlayouttype, getContext());
        if (!TextUtils.isEmpty(primeoptionsitemviewmodel.getBadgeId())) goto _L2; else goto _L1
_L1:
        styledspannablestring.append(primeoptionsitemviewmodel.getBadgeText(), com.amazon.retailsearch.R.style.Results_PrimeOptions_Item);
_L4:
        setText(styledspannablestring);
        setVisibility(0);
        return;
_L2:
        styledspannablestring.appendBadge(primeoptionsitemviewmodel.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_ConsumableMessaging_Badge));
        if (!TextUtils.isEmpty(primeoptionsitemviewmodel.getBadgeText()))
        {
            resultlayouttype = primeoptionsitemviewmodel.getBadgeText();
            if (primeoptionsitemviewmodel.getOfferCount() < 2)
            {
                primeoptionsitemviewmodel = (new StringBuilder()).append(" | ").append(resultlayouttype).toString();
            } else
            {
                styledspannablestring.appendNewLine();
                primeoptionsitemviewmodel = resultlayouttype;
            }
            styledspannablestring.append(primeoptionsitemviewmodel, com.amazon.retailsearch.R.style.Results_PrimeOptions_Item);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((PrimeOptionsItemViewModel)obj, resultlayouttype);
    }

    public View getView()
    {
        return this;
    }

    public void handleSingleTap()
    {
        com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem retailsearchresultitem = (new com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem.Builder()).build(model.getAsin(), model.getUrl(), model.getProductGroup());
        userInteractionListener.resultItemSelected(retailsearchresultitem, DetailPageType.PRIME_OPTION);
    }
}
