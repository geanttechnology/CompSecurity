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
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.views.RetailSearchResultView;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.Savings;
import com.amazon.searchapp.retailsearch.model.StyledText;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Iterator;
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
    FeatureConfiguration featureConfig;
    private boolean hideBadges;
    protected TextView inAppPurchaseLine;
    private PriceModel model;
    protected List priceLineList;
    private Resources res;
    private ResultLayoutType resultLayoutType;
    Lazy retailSearchDataProvider;
    protected TextView savingsLine;
    private boolean showListPrice;
    private boolean showSomePrime;
    protected TextView somePrimeLine;
    protected TextView sponsoredProductLine;

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

    private void appendBadges(StyledSpannableString styledspannablestring)
    {
        if (styledspannablestring != null && model != null)
        {
            if (model.getCodBadgeId() != null && !hideBadges)
            {
                styledspannablestring.appendBadge(model.getCodBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_PriceBadgeSpan));
            }
            if (model.getBadgeId() != null && !hideBadges)
            {
                styledspannablestring.appendBadge(model.getBadgeId(), Integer.valueOf(com.amazon.retailsearch.R.style.Results_PriceBadgeSpan));
                return;
            }
        }
    }

    private void buildAdditionalPriceMsgs()
    {
label0:
        {
            buildSavingsMessage();
            buildInAppPurchaseMessage();
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
                StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, context);
                styledspannablestring.append((new StringBuilder()).append(s).append(" ").toString(), com.amazon.retailsearch.R.style.Results_PriceSpan);
                styledspannablestring.append(((String) (obj)), com.amazon.retailsearch.R.style.Results_EditionPriceLabelSpan);
                setText(textview, styledspannablestring);
            }
            i++;
        }
    }

    private void buildInAppPurchaseMessage()
    {
        if (inAppPurchaseLine == null)
        {
            return;
        }
        Object obj = model.getInAppPurchaseMsg();
        if (obj == null)
        {
            inAppPurchaseLine.setVisibility(8);
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, context);
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            StyledText styledtext = (StyledText)((Iterator) (obj)).next();
            if (styledtext != null && !TextUtils.isEmpty(styledtext.getText()))
            {
                if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
                {
                    styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_InAppPurchaseHighlightSpan);
                } else
                if (RetailSearchResultStyles.STYLE_PLAIN.equals(styledtext.getStyle()))
                {
                    styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_InAppPurchasePlainSpan);
                } else
                {
                    styledspannablestring.append(styledtext.getText());
                }
            }
        } while (true);
        if (TextUtils.isEmpty(styledspannablestring))
        {
            inAppPurchaseLine.setVisibility(8);
            return;
        } else
        {
            inAppPurchaseLine.setText(styledspannablestring);
            inAppPurchaseLine.setVisibility(0);
            return;
        }
    }

    private void buildRegularPrices(TextView textview)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, context);
        if (model.getMapTextId() == null) goto _L2; else goto _L1
_L1:
        if (!TextUtils.isEmpty(model.getListPrice()))
        {
            styledspannablestring.append(model.getListPrice(), com.amazon.retailsearch.R.style.Results_ListPriceSpan);
            styledspannablestring.append(" ", com.amazon.retailsearch.R.style.Results_PriceSpan);
        }
        styledspannablestring.append((new StringBuilder()).append(res.getString(model.getMapTextId().intValue())).append(" ").toString(), com.amazon.retailsearch.R.style.Results_MapPriceSpan);
_L4:
        appendBadges(styledspannablestring);
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
        s = model.getListPrice();
        if (!TextUtils.isEmpty(s))
        {
            styledspannablestring.append(s, com.amazon.retailsearch.R.style.Results_ListPriceSpan);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void buildSavingsMessage()
    {
        if (savingsLine == null)
        {
            return;
        }
        Object obj = model.getSavings();
        if (model.getUseEditions() || obj == null || ((Savings) (obj)).getSavedMessage() == null)
        {
            savingsLine.setVisibility(8);
            return;
        }
        Object obj1 = ((Savings) (obj)).getSavedMessage();
        obj = new StyledSpannableString(resultLayoutType, context);
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            StyledText styledtext = (StyledText)((Iterator) (obj1)).next();
            if (styledtext != null && styledtext.getText() != null)
            {
                if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
                {
                    ((StyledSpannableString) (obj)).append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_SavingsBoldHighlightSpan);
                } else
                if (RetailSearchResultStyles.STYLE_HIGHLIGHT2.equals(styledtext.getStyle()))
                {
                    ((StyledSpannableString) (obj)).append(styledtext.getText(), com.amazon.retailsearch.R.style.Results_SavingsHighlightSpan);
                } else
                {
                    ((StyledSpannableString) (obj)).append(styledtext.getText());
                }
            }
        } while (true);
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            savingsLine.setVisibility(8);
            return;
        } else
        {
            savingsLine.setText(((CharSequence) (obj)));
            savingsLine.setVisibility(0);
            return;
        }
    }

    private void buildStyledPrices(TextView textview, List list)
    {
        if (textview == null || Utils.isEmpty(list))
        {
            return;
        }
        StyledSpannableString styledspannablestring = new StyledSpannableString(resultLayoutType, context);
        for (list = list.iterator(); list.hasNext();)
        {
            StyledText styledtext = (StyledText)list.next();
            if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
            {
                styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_PriceSpan);
            } else
            {
                styledspannablestring.append(styledtext.getText(), com.amazon.retailsearch.R.style.Rs_Twister_ItemInfo_TextSpan);
            }
        }

        styledspannablestring.append(" ");
        appendBadges(styledspannablestring);
        setText(textview, styledspannablestring);
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

    public void buildView(PriceModel pricemodel, ResultLayoutType resultlayouttype)
    {
        if (pricemodel == null || resultlayouttype == null)
        {
            setVisibility(8);
            return;
        }
        model = pricemodel;
        resultLayoutType = resultlayouttype;
        if (pricemodel.getUseEditions())
        {
            buildEditionsPrices();
        } else
        {
            int i = 1;
            if ("T1".equals(FeatureStateUtil.getTwisterRentalPriceWeblab(featureConfig)) && !Utils.isEmpty(pricemodel.getStyledRentalPrice()))
            {
                buildStyledPrices((TextView)priceLineList.get(0), pricemodel.getStyledRentalPrice());
                if (!Utils.isEmpty(pricemodel.getStyledPrice()))
                {
                    buildStyledPrices((TextView)priceLineList.get(1), pricemodel.getStyledPrice());
                    i = 1 + 1;
                }
            } else
            {
                buildRegularPrices((TextView)priceLineList.get(0));
            }
            while (i < priceLineList.size()) 
            {
                ((TextView)priceLineList.get(i)).setVisibility(8);
                i++;
            }
        }
        buildAdditionalPriceMsgs();
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((PriceModel)obj, resultlayouttype);
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
