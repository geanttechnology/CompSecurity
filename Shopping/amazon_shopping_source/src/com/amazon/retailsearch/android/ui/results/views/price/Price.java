// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            PriceModel

public abstract class Price extends LinearLayout
    implements RetailSearchResultView
{

    private static final String ATTR_HIDE_BADGES = "Rs.Results.Price.HideBadges";
    private static final String ATTR_SHOW_LIST_PRICE = "Rs.Results.Price.ShowListPrice";
    private static final String ATTR_SHOW_SOME_PRIME = "Rs.Results.Price.ShowSomePrimeMsg";
    private Context context;
    private boolean hideBadges;
    private PriceModel model;
    protected List priceLineList;
    private Resources res;
    Lazy retailSearchDataProvider;
    private boolean showListPrice;
    private boolean showSomePrime;
    protected TextView somePrimeLine;
    protected TextView sponsoredProductLine;
    private ViewType viewType;

    public Price(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        priceLineList = new ArrayList(3);
        context = context1;
        res = getResources();
        showListPrice = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.Price.ShowListPrice", false);
        showSomePrime = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.Price.ShowSomePrimeMsg", false);
        hideBadges = ResUtils.getAttributeBooleanValue(attributeset, "Rs.Results.Price.HideBadges", false);
        RetailSearchDaggerGraphController.inject(this);
    }

    private void buildAdditionalPriceMsgs()
    {
label0:
        {
            if (somePrimeLine != null)
            {
                if (!TextUtils.isEmpty(model.getSomePrimeMsg()))
                {
                    somePrimeLine.setText(model.getSomePrimeMsg());
                    somePrimeLine.setVisibility(0);
                } else
                {
                    somePrimeLine.setVisibility(8);
                }
            }
            if (sponsoredProductLine != null)
            {
                if (TextUtils.isEmpty(model.getSponsoredPriceMsg()))
                {
                    break label0;
                }
                sponsoredProductLine.setText(model.getSponsoredPriceMsg());
                sponsoredProductLine.setVisibility(0);
            }
            return;
        }
        sponsoredProductLine.setVisibility(8);
    }

    private void buildEditionsPrices()
    {
        List list = model.getEditions();
        int i = 0;
        while (i < priceLineList.size()) 
        {
            TextView textview = (TextView)priceLineList.get(i);
            if (list == null || i >= list.size())
            {
                textview.setVisibility(8);
            } else
            {
                Object obj = (PriceModel.UIPriceInfo)list.get(i);
                String s = ((PriceModel.UIPriceInfo) (obj)).getPrice();
                obj = ((PriceModel.UIPriceInfo) (obj)).getLabel();
                StyledSpannableString styledspannablestring = new StyledSpannableString(viewType, context);
                styledspannablestring.append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_PriceSpan);
                styledspannablestring.append(((String) (obj)), com.amazon.retailsearch.R.style.Results_EditionPriceLabelSpan);
                setText(textview, styledspannablestring);
            }
            i++;
        }
    }

    private void buildRegularPrices(TextView textview)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(viewType, context);
        if (model.getMapTextId() == null) goto _L2; else goto _L1
_L1:
        styledspannablestring.append((new StringBuilder()).append(res.getString(model.getMapTextId().intValue())).append(" ").toString(), com.amazon.retailsearch.R.style.Results_MapPriceSpan);
_L4:
        if (model.getBadgeId() != null && !hideBadges)
        {
            styledspannablestring.appendBadge(model.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_PriceBadgeSpan));
        }
        setText(textview, styledspannablestring);
        return;
_L2:
        String s = model.getPrice();
        if (!TextUtils.isEmpty(s))
        {
            styledspannablestring.append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_PriceSpan);
        }
        s = model.getUnitOrIssuePrice();
        if (!TextUtils.isEmpty(s))
        {
            styledspannablestring.append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_UnitPriceSpan);
        }
        if (!TextUtils.isEmpty(model.getListPrice()))
        {
            styledspannablestring.append(model.getListPrice(), com.amazon.retailsearch.R.style.Results_ListPriceSpan);
            styledspannablestring.append(" ", com.amazon.retailsearch.R.style.Results_PriceSpan);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setText(TextView textview, SpannableStringBuilder spannablestringbuilder)
    {
        if (TextUtils.isEmpty(spannablestringbuilder))
        {
            textview.setVisibility(8);
            return;
        } else
        {
            textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            textview.setVisibility(0);
            return;
        }
    }

    public void buildView(PriceModel pricemodel, ViewType viewtype)
    {
        if (pricemodel == null || viewtype == null)
        {
            setVisibility(8);
            return;
        }
        model = pricemodel;
        viewType = viewtype;
        if (pricemodel.getUseEditions())
        {
            buildEditionsPrices();
        } else
        {
            buildRegularPrices((TextView)priceLineList.get(0));
            int i = 1;
            while (i < priceLineList.size()) 
            {
                ((TextView)priceLineList.get(i)).setVisibility(8);
                i++;
            }
        }
        buildAdditionalPriceMsgs();
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ViewType viewtype)
    {
        buildView((PriceModel)obj, viewtype);
    }

    public boolean getShowListPrice()
    {
        return showListPrice;
    }

    public boolean getShowSomePrime()
    {
        return showSomePrime;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        postInflate();
        sponsoredProductLine = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_results_price_sponsored_msg);
    }

    protected abstract void postInflate();
}
