// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.SummarizableWithDefault;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapterWithHeader;
import com.ebay.mobile.search.refine.types.ItemLocation;
import com.ebay.mobile.util.ContentSyncManager;
import com.ebay.nautilus.domain.EbayCountry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class ItemLocationController extends CheckedDetailController
    implements SummarizableWithDefault
{

    public static final String SYNC_ITEM_LOCATION_SUMMARY = "syncRefineItemLocSummary";
    private static List syncKeys = Arrays.asList(new String[] {
        "syncAuthChanged", "syncCountryChanged"
    });
    private int selectedIndex;

    public ItemLocationController(SearchRefineFragment searchrefinefragment, ListView listview)
    {
        super(searchrefinefragment, listview, true);
        searchrefinefragment.populateItemLocations();
        adapter = new RefineSingleOptionAdapterWithHeader(searchrefinefragment.getActivity(), searchrefinefragment.locationItems) {

            final ItemLocationController this$0;

            
            {
                this$0 = ItemLocationController.this;
                super(context, list);
            }
        };
    }

    public List getContentSyncKeys()
    {
        return syncKeys;
    }

    public String getDefaultSummary()
    {
        String s = getSearchParameters().country.getSiteDomain().replace("ebay", getString(0x7f07016b));
        return String.format(getString(0x7f070976), new Object[] {
            s
        });
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.SL_ITEMLOCATION;
    }

    public String getSummary()
    {
        ItemLocation itemlocation = (ItemLocation)refineFragment.locationItems.get(refineFragment.getItemLocationIndex(null));
        if (itemlocation.tag == refineFragment.itemLocationOnEbayCom.tag)
        {
            return getDefaultSummary();
        } else
        {
            return itemlocation.toString();
        }
    }

    public String getTitle()
    {
        return refineFragment.getResources().getString(0x7f07097c);
    }

    public boolean isDefault()
    {
        return ((ItemLocation)refineFragment.locationItems.get(refineFragment.getItemLocationIndex(null))).tag == refineFragment.itemLocationOnEbayCom.tag;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        super.onItemClick(adapterview, view, i, l);
        unlockRefinements(new com.ebay.mobile.search.RefinementLocks.RefinementLockType[] {
            com.ebay.mobile.search.RefinementLocks.RefinementLockType.SEARCHOTHERCOUNTRIES, com.ebay.mobile.search.RefinementLocks.RefinementLockType.SEARCHLOCALCOUNTRY
        });
    }

    public void onPause()
    {
        ContentSyncManager.notifyUpdate(this, "syncRefineItemLocSummary");
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        refineFragment.trackingEventListener.onRefinePreferredLocation();
        setupListView(refineFragment.getItemLocationIndex(getSearchParameters()));
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        if (isActive())
        {
            listView.setSelection(selectedIndex);
        }
    }

    protected boolean update(ItemLocation itemlocation)
    {
        return refineFragment.setItemLocation(itemlocation);
    }

    protected volatile boolean update(Object obj)
    {
        return update((ItemLocation)obj);
    }

}
