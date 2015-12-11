// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSummary;
import com.groupon.models.EndlessList;
import commonlib.adapter.JavaListAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealSummaryListLoaderCallbacks, BaseDealsWithOptionalWidgetsListFragment, DataTransformer

protected class dataTransformer extends DealSummaryListLoaderCallbacks
{

    private DataTransformer dataTransformer;
    final BaseDealsWithOptionalWidgetsListFragment this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        bundle = new dataTransformer(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel, pagerChannel.name(), widgetsSupported, dataTransformer);
        bundle.ownload(isForceDownload);
        return bundle;
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        onLoadFinished onloadfinished = (onLoadFinished)list;
        if (widgetListAdapter == null || list == null) goto _L2; else goto _L1
_L1:
        Object obj;
        widgetListAdapter.setSmuggledDeals(onLoadFinished(onloadfinished));
        widgetListAdapter.setList(onLoadFinished(onloadfinished), false);
        obj = list;
_L4:
        super.onLoadFinished(loader, ((List) (obj)));
        return;
_L2:
        obj = list;
        if (list != null)
        {
            obj = list;
            if (onLoadFinished(onloadfinished).size() > 0)
            {
                list = (EndlessList)onloadfinished.onLoadFinished();
                obj = new EndlessList(new ArrayList(), list.getTotalSize(), list.getCurrentOffset(), list.getAttr());
                ((EndlessList) (obj)).addAll(onLoadFinished(onloadfinished));
                ((EndlessList) (obj)).addAll(list);
                obj = new onLoadFinished(((EndlessList) (obj)), new ArrayList(), new ArrayList());
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public (JavaListAdapter javalistadapter, BaseDealsWithOptionalWidgetsListFragment basedealswithoptionalwidgetslistfragment1, DataTransformer datatransformer)
    {
        this$0 = BaseDealsWithOptionalWidgetsListFragment.this;
        super(javalistadapter, basedealswithoptionalwidgetslistfragment1);
        dataTransformer = datatransformer;
    }
}
