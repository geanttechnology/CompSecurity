// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.EditionsPriceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            RetailSearchResultView, PrimeOptionsItemView, PrimeOptionsViewModel

public class PrimeOptionsView extends LinearLayout
    implements RetailSearchResultView
{

    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/results/views/PrimeOptionsView);
    List optionItemViews;

    public PrimeOptionsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        optionItemViews = new ArrayList();
    }

    private void removeOptionItemViews()
    {
        Iterator iterator = optionItemViews.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PrimeOptionsItemView primeoptionsitemview = (PrimeOptionsItemView)iterator.next();
            if (primeoptionsitemview != null)
            {
                try
                {
                    removeView(primeoptionsitemview);
                }
                catch (Exception exception)
                {
                    log.error("Unable to remove prime options view", exception);
                }
            }
        } while (true);
        optionItemViews.clear();
    }

    public void buildView(PrimeOptionsViewModel primeoptionsviewmodel, ResultLayoutType resultlayouttype)
    {
        if (primeoptionsviewmodel == null || resultlayouttype == null || Utils.isEmpty(primeoptionsviewmodel.getOfferList()))
        {
            setVisibility(8);
            return;
        }
        removeOptionItemViews();
        Iterator iterator = primeoptionsviewmodel.getOfferList().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (EditionsPriceInfo)iterator.next();
            if (obj != null)
            {
                obj = (new PrimeOptionsItemViewModel.Builder()).setOffer(((EditionsPriceInfo) (obj))).setAsin(primeoptionsviewmodel.getAsin()).setProductGroup(primeoptionsviewmodel.getProductGroup()).setOffersCount(primeoptionsviewmodel.getOfferList().size()).build();
                if (obj != null)
                {
                    PrimeOptionsItemView primeoptionsitemview = (PrimeOptionsItemView)View.inflate(getContext(), com.amazon.retailsearch.R.layout.rs_results_prime_options_item, null);
                    primeoptionsitemview.buildView(((PrimeOptionsItemViewModel) (obj)), resultlayouttype);
                    addView(primeoptionsitemview);
                    optionItemViews.add(primeoptionsitemview);
                    primeoptionsviewmodel.getGestureListener().addTapTarget(primeoptionsitemview);
                }
            }
        } while (true);
        setVisibility(0);
    }

    public volatile void buildView(Object obj, ResultLayoutType resultlayouttype)
    {
        buildView((PrimeOptionsViewModel)obj, resultlayouttype);
    }

}
