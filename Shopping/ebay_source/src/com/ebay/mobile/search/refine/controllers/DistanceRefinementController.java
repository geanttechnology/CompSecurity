// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.SummarizableWithDefault;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapterWithHeader;
import com.ebay.mobile.search.refine.types.TaggedItem;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class DistanceRefinementController extends CheckedDetailController
    implements SummarizableWithDefault
{

    private static final int UNSELECTABLE = -2;
    private List items;
    private int selectedIndex;

    public DistanceRefinementController(SearchRefineFragment searchrefinefragment, ListView listview)
    {
        super(searchrefinefragment, listview, true);
        items = null;
        Object obj = getSearchParameters().country;
        int i;
        int k;
        if (((EbayCountry) (obj)).getSite() == EbaySite.UK)
        {
            listview = new int[7];
            ListView _tmp = listview;
            listview[0] = 5;
            listview[1] = 10;
            listview[2] = 25;
            listview[3] = 50;
            listview[4] = 100;
            listview[5] = 200;
            listview[6] = 500;
        } else
        if (((EbayCountry) (obj)).isSite() && ((EbayCountry) (obj)).getSite() == EbaySite.US)
        {
            listview = new int[7];
            ListView _tmp1 = listview;
            listview[0] = 10;
            listview[1] = 25;
            listview[2] = 50;
            listview[3] = 100;
            listview[4] = 200;
            listview[5] = 500;
            listview[6] = 1000;
        } else
        {
            listview = new int[6];
            ListView _tmp2 = listview;
            listview[0] = 10;
            listview[1] = 25;
            listview[2] = 50;
            listview[3] = 100;
            listview[4] = 200;
            listview[5] = 500;
        }
        i = listview.length;
        obj = EbayCountryManager.getDistanceString(searchrefinefragment.getResources(), ((EbayCountry) (obj)));
        items = new ArrayList(i + 2);
        items.add(new TaggedItem(getString(0x7f070576), Integer.valueOf(-2)));
        items.add(new TaggedItem(getString(0x7f070978), Integer.valueOf(0)));
        k = listview.length;
        for (int j = 0; j < k; j++)
        {
            int l = listview[j];
            items.add(new TaggedItem((new StringBuilder()).append(String.valueOf(l)).append(" ").append(((String) (obj))).toString(), Integer.valueOf(l)));
        }

        adapter = new RefineSingleOptionAdapterWithHeader(searchrefinefragment.getActivity(), items) {

            final DistanceRefinementController this$0;

            public boolean showLeftArrowForPosition(int i1)
            {
                return i1 == 0;
            }

            
            {
                this$0 = DistanceRefinementController.this;
                super(context, list);
            }
        };
    }

    private int getDistanceIndex(int i)
    {
        int j = 2;
        for (int k = items.size(); j < k; j++)
        {
            if (i >= ((Integer)((TaggedItem)items.get(j)).tag).intValue() && (j + 1 >= k || i < ((Integer)((TaggedItem)items.get(j + 1)).tag).intValue()))
            {
                return j;
            }
        }

        return 1;
    }

    private void inferSelectedItem()
    {
        selectedIndex = getDistanceIndex(getSearchParameters().maxDistance);
    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public String getDefaultSummary()
    {
        return refineFragment.getResources().getString(0x7f070978);
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.SL_DISTANCE;
    }

    public String getSummary()
    {
        if (isDefault())
        {
            return getDefaultSummary();
        } else
        {
            return (new StringBuilder()).append(Integer.toString(getSearchParameters().maxDistance)).append(" ").append(EbayCountryManager.getDistanceString(refineFragment.getResources(), getSearchParameters().country)).toString();
        }
    }

    public String getTitle()
    {
        return refineFragment.getActivity().getResources().getString(0x7f070977);
    }

    public boolean isDefault()
    {
        return getSearchParameters().maxDistance <= 0;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        super.onItemClick(adapterview, view, i, l);
        getRefinementLocks().unlock(com.ebay.mobile.search.RefinementLocks.RefinementLockType.MAXDISTANCE);
    }

    public void onResume()
    {
        super.onResume();
        inferSelectedItem();
        setupListView(selectedIndex);
        refineFragment.trackingEventListener.onRefineMaxDistance();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        inferSelectedItem();
        setupListView(selectedIndex);
    }

    protected boolean update(TaggedItem taggeditem)
    {
        if (((Integer)taggeditem.tag).intValue() == -2)
        {
            refineFragment.showDetail(DetailMode.NEAR);
            return false;
        }
        selectedIndex = getAdapter().getPosition(taggeditem);
        if (getSearchParameters().maxDistance == ((Integer)taggeditem.tag).intValue())
        {
            return false;
        } else
        {
            getSearchParameters().maxDistance = ((Integer)taggeditem.tag).intValue();
            return true;
        }
    }

    protected volatile boolean update(Object obj)
    {
        return update((TaggedItem)obj);
    }
}
