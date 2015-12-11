// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.HasCustomContent;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.SummarizableWithDefault;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            BaseDetailController

public class DeliveryOptionsController extends BaseDetailController
    implements TextWatcher, android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, HasCustomContent, SummarizableWithDefault
{

    public static final String SYNC_SHIPPING_SUMMARY = "syncShippingSummary";
    private CheckBox expeditedShippingCheckbox;
    private View expeditedShippingDivider;
    private View expeditedShippingLayout;
    private CheckBox freeShippingCheckbox;

    public DeliveryOptionsController(SearchRefineFragment searchrefinefragment)
    {
        super(searchrefinefragment);
    }

    private void notifySummaryChanged()
    {
        ContentSyncManager.notifyUpdate(this, "syncShippingSummary");
    }

    private void onCheckExpeditedShipping(boolean flag)
    {
        SearchParameters searchparameters = getSearchParameters();
        searchparameters.expeditedShipping = flag;
        expeditedShippingCheckbox.setChecked(searchparameters.expeditedShipping);
        getRefinementLocks().unlock(com.ebay.mobile.search.RefinementLocks.RefinementLockType.EXPEDITEDSHIPPING);
        notifySummaryChanged();
        updateVisibility();
        searchParamsUpdated();
    }

    private void onCheckFreeShipping(boolean flag)
    {
        SearchParameters searchparameters = getSearchParameters();
        searchparameters.freeShipping = flag;
        freeShippingCheckbox.setChecked(searchparameters.freeShipping);
        getRefinementLocks().unlock(com.ebay.mobile.search.RefinementLocks.RefinementLockType.FREESHIPPING);
        notifySummaryChanged();
        updateVisibility();
        searchParamsUpdated();
    }

    private void updateVisibility()
    {
        SearchParameters searchparameters = getSearchParameters();
        freeShippingCheckbox.setChecked(searchparameters.freeShipping);
        expeditedShippingCheckbox.setChecked(searchparameters.expeditedShipping);
        int i;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineExpeditedShippingEnabled))
        {
            i = 0;
        } else
        {
            i = 8;
        }
        expeditedShippingLayout.setVisibility(i);
        expeditedShippingDivider.setVisibility(i);
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public View createView()
    {
        View view = refineFragment.getInflater().inflate(0x7f0301db, parentView, false);
        View view1 = view.findViewById(0x7f1005c3);
        freeShippingCheckbox = (CheckBox)view.findViewById(0x7f1005c4);
        expeditedShippingLayout = view.findViewById(0x7f1005c7);
        expeditedShippingCheckbox = (CheckBox)view.findViewById(0x7f1005c8);
        expeditedShippingDivider = view.findViewById(0x7f1005c6);
        updateVisibility();
        view1.setOnClickListener(this);
        freeShippingCheckbox.setOnClickListener(this);
        expeditedShippingLayout.setOnClickListener(this);
        expeditedShippingCheckbox.setOnClickListener(this);
        return view;
    }

    public String getDefaultSummary()
    {
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.refineExpeditedShippingEnabled))
        {
            return getString(0x7f07098a);
        } else
        {
            return getString(0x7f07097b);
        }
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.DELIVERY_OPTIONS;
    }

    public String getSummary()
    {
        SearchParameters searchparameters = getSearchParameters();
        ArrayList arraylist = new ArrayList();
        if (searchparameters.freeShipping)
        {
            arraylist.add(getString(0x7f07097b));
        }
        if (searchparameters.expeditedShipping)
        {
            arraylist.add(getString(0x7f07097a));
        }
        if (arraylist.size() == 0)
        {
            return getDefaultSummary();
        } else
        {
            return TextUtils.join(", ", arraylist);
        }
    }

    public String getTitle()
    {
        return getString(0x7f070970);
    }

    public boolean isDefault()
    {
        SearchParameters searchparameters = getSearchParameters();
        return !searchparameters.expeditedShipping && !searchparameters.freeShipping;
    }

    public void onBackClicked()
    {
    }

    public void onClick(View view)
    {
        boolean flag1 = true;
        boolean flag = true;
        switch (view.getId())
        {
        case 2131756485: 
        case 2131756486: 
        default:
            return;

        case 2131756483: 
        case 2131756484: 
            if (getSearchParameters().freeShipping)
            {
                flag = false;
            }
            onCheckFreeShipping(flag);
            return;

        case 2131756487: 
        case 2131756488: 
            break;
        }
        if (!getSearchParameters().expeditedShipping)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        onCheckExpeditedShipping(flag);
    }

    public void onDoneClicked()
    {
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return false;
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        refineFragment.trackingEventListener.onRefinePriceRange();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        if (customView != null)
        {
            updateVisibility();
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
