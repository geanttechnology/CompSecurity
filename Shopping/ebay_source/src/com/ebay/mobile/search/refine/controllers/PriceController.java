// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.HasCustomContent;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            BaseDetailController

public class PriceController extends BaseDetailController
    implements TextWatcher, android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, HasCustomContent
{

    private static final String EXTRA_DIRTY_MAX = "MAX";
    private static final String EXTRA_DIRTY_MIN = "MIN";
    private Button applyButton;
    private Button clearButton;
    private String currencyCode;
    private boolean dirty;
    private String maxPrice;
    private PriceView maxPriceText;
    private String minPrice;
    private PriceView minPriceText;
    private View parent;

    public PriceController(SearchRefineFragment searchrefinefragment)
    {
        super(searchrefinefragment);
        dirty = false;
    }

    private void applyPrices()
    {
        Object obj2 = null;
        Object obj = null;
        Object obj1 = null;
        Double double2 = minPriceText.getPriceAsBoxedDouble();
        Double double1 = maxPriceText.getPriceAsBoxedDouble();
        if (double2 != null && double1 != null && double1.doubleValue() <= double2.doubleValue())
        {
            if (parent != null)
            {
                obj = (View)parent.getParent();
                ((View) (obj)).startAnimation(AnimationUtils.loadAnimation(((View) (obj)).getContext(), 0x7f040010));
            }
            dirty = false;
            return;
        }
        if (double2 != null)
        {
            obj = double2.toString();
        }
        if (double1 != null)
        {
            obj1 = double1.toString();
        }
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new ItemCurrency(currencyCode, ((String) (obj)));
        }
        if (obj1 == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = new ItemCurrency(currencyCode, ((String) (obj1)));
        }
        Util.hideSoftInput(refineActivity, maxPriceText);
        if (dirty && refineFragment.setPrice(((ItemCurrency) (obj)), ((ItemCurrency) (obj1))))
        {
            unlockRefinements(new com.ebay.mobile.search.RefinementLocks.RefinementLockType[] {
                com.ebay.mobile.search.RefinementLocks.RefinementLockType.MINPRICE, com.ebay.mobile.search.RefinementLocks.RefinementLockType.MAXPRICE
            });
            refineFragment.commitDetail();
        }
        dirty = false;
    }

    public void afterTextChanged(Editable editable)
    {
        dirty = true;
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public View createView()
    {
        View view = refineFragment.getInflater().inflate(0x7f0301e2, parentView, false);
        minPriceText = (PriceView)view.findViewById(0x7f1004f0);
        maxPriceText = (PriceView)view.findViewById(0x7f1004f2);
        applyButton = (Button)view.findViewById(0x7f1005ee);
        clearButton = (Button)view.findViewById(0x7f1005ef);
        parent = view;
        minPriceText.setOnEditorActionListener(this);
        maxPriceText.setOnEditorActionListener(this);
        applyButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        minPriceText.addTextChangedListener(this);
        maxPriceText.addTextChangedListener(this);
        minPriceText.setCurrency(currencyCode);
        maxPriceText.setCurrency(currencyCode);
        return view;
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.PRICE;
    }

    public Bundle getStateExtras()
    {
        Bundle bundle = super.getStateExtras();
        if (dirty)
        {
            bundle.putString("MIN", minPriceText.getPriceAsString());
            bundle.putString("MAX", maxPriceText.getPriceAsString());
        }
        return bundle;
    }

    public String getTitle()
    {
        return getString(0x7f070983);
    }

    public void init(SearchParameters searchparameters)
    {
        Object obj = null;
        String s;
        if (searchparameters.minPrice != null)
        {
            s = searchparameters.minPrice.code;
        } else
        if (searchparameters.maxPrice != null)
        {
            s = searchparameters.maxPrice.code;
        } else
        {
            s = searchparameters.country.getCurrency().getCurrencyCode();
        }
        currencyCode = s;
        if (searchparameters.minPrice != null)
        {
            s = searchparameters.minPrice.value;
        } else
        {
            s = null;
        }
        minPrice = s;
        s = obj;
        if (searchparameters.maxPrice != null)
        {
            s = searchparameters.maxPrice.value;
        }
        maxPrice = s;
    }

    public void onBackClicked()
    {
        applyPrices();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756526: 
            applyPrices();
            return;

        case 2131756527: 
            minPriceText.clear();
            break;
        }
        maxPriceText.clear();
        applyPrices();
    }

    public void onDoneClicked()
    {
        applyPrices();
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        i;
        JVM INSTR tableswitch 6 6: default 20
    //                   6 22;
           goto _L1 _L2
_L1:
        return false;
_L2:
        applyPrices();
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onPause()
    {
        Util.hideSoftInput(refineActivity, minPriceText);
        super.onPause();
    }

    public void onResume()
    {
        dirty = false;
        if (deferredStateExtras != null)
        {
            if (deferredStateExtras.containsKey("MIN"))
            {
                minPrice = deferredStateExtras.getString("MIN");
                dirty = true;
            }
            if (deferredStateExtras.containsKey("MAX"))
            {
                maxPrice = deferredStateExtras.getString("MAX");
                dirty = true;
            }
            deferredStateExtras = null;
        }
        Double double1;
        if (TextUtils.isEmpty(minPrice))
        {
            double1 = null;
        } else
        {
            double1 = Double.valueOf(Double.parseDouble(minPrice));
        }
        minPriceText.setPrice(double1);
        if (TextUtils.isEmpty(maxPrice))
        {
            double1 = null;
        } else
        {
            double1 = Double.valueOf(Double.parseDouble(maxPrice));
        }
        maxPriceText.setPrice(double1);
        super.onResume();
        refineFragment.trackingEventListener.onRefinePriceRange();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        init(searchparameters);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
