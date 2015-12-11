// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapter;
import com.ebay.mobile.search.refine.types.SortOrder;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class SortOrderRefinementController extends CheckedDetailController
{

    private static List syncKeys = Arrays.asList(new String[] {
        "syncAuthChanged", "syncCountryChanged"
    });
    private int selectedIndex;

    public SortOrderRefinementController(SearchRefineFragment searchrefinefragment, ListView listview)
    {
        super(searchrefinefragment, listview, true);
        selectedIndex = 0;
        selectSortOrder(getSearchParameters().sortOrder);
        refreshAdapter();
    }

    private void selectSortOrder(String s)
    {
        for (int i = 0; i < refineFragment.sortOrders.length; i++)
        {
            if (refineFragment.sortOrders[i].sortOrder.equals(s))
            {
                selectedIndex = i;
            }
        }

    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public List getContentSyncKeys()
    {
        return syncKeys;
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.SORT;
    }

    public String getTitle()
    {
        return getString(0x7f070ad9);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        getRefinementLocks().unlock(com.ebay.mobile.search.RefinementLocks.RefinementLockType.SORTORDER);
        super.onItemClick(adapterview, view, i, l);
    }

    public void onResume()
    {
        super.onResume();
        setupListView(selectedIndex);
        onSearchParametersUpdated(getSearchParameters(), null, null);
        com.ebay.mobile.search.SearchResultFragment.OnTrackingEventsListener ontrackingeventslistener = refineFragment.trackingEventListener;
        String s;
        if (oneShot)
        {
            s = "SortOptions";
        } else
        {
            s = "RefineSort";
        }
        ontrackingeventslistener.onRefineSort(s);
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        selectedIndex = 0;
        for (int i = 0; i < refineFragment.sortOrders.length; i++)
        {
            if (refineFragment.sortOrders[i].sortOrder.equals(searchparameters.sortOrder))
            {
                selectedIndex = i;
            }
        }

        setupListView(selectedIndex);
    }

    public void refreshAdapter()
    {
        adapter = new RefineSingleOptionAdapter(refineActivity, refineFragment.sortOrders) {

            final SortOrderRefinementController this$0;

            public int getCount()
            {
                int j = super.getCount();
                int i;
                if (refineFragment.sortIndexToSkip != 0x7fffffff)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                return j - i;
            }

            public SortOrder getItem(int i)
            {
                if (i >= refineFragment.sortIndexToSkip)
                {
                    i++;
                }
                return (SortOrder)super.getItem(i);
            }

            public volatile Object getItem(int i)
            {
                return getItem(i);
            }

            
            {
                this$0 = SortOrderRefinementController.this;
                super(context, asortorder);
            }
        };
        setupListView(selectedIndex);
    }

    protected boolean update(SortOrder sortorder)
    {
        SortOrder sortorder1 = refineFragment.setSortOrder(sortorder, true);
        if (sortorder1 == null)
        {
            return false;
        }
        if (sortorder1.sortOrder.equals(sortorder.sortOrder))
        {
            return true;
        } else
        {
            selectSortOrder(sortorder1.sortOrder);
            setupListView(selectedIndex);
            return false;
        }
    }

    protected volatile boolean update(Object obj)
    {
        return update((SortOrder)obj);
    }

}
