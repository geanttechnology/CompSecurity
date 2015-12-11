// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.RefinementLocks;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.RefineSingleOptionAdapter;
import com.ebay.mobile.search.refine.types.ItemConditionHelper;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            CheckedDetailController

public class ConditionController extends CheckedDetailController
{

    private final ItemConditionHelper helper;

    public ConditionController(SearchRefineFragment searchrefinefragment, ListView listview)
    {
        super(searchrefinefragment, listview, true);
        helper = new ItemConditionHelper(listview.getContext());
        adapter = new RefineSingleOptionAdapter(searchrefinefragment.getActivity(), helper.conditionDisplayValues);
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.CONDITION;
    }

    public String getTitle()
    {
        return refineFragment.getActivity().getResources().getString(0x7f070535);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        super.onItemClick(adapterview, view, i, l);
        getRefinementLocks().unlock(com.ebay.mobile.search.RefinementLocks.RefinementLockType.CONDITION);
    }

    public void onResume()
    {
        super.onResume();
        setupListView(helper.getConditionConstraintIndex(refineFragment.searchParameters.condition));
        refineFragment.trackingEventListener.onRefineCondition();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
    }

    protected volatile boolean update(Object obj)
    {
        return update((String)obj);
    }

    protected boolean update(String s)
    {
        return refineFragment.setCondition(s);
    }
}
