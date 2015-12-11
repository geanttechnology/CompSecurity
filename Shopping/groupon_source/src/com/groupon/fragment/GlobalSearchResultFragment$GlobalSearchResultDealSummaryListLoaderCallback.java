// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.Business;
import com.groupon.db.models.DealSummary;
import com.groupon.models.EndlessList;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealSummaryListLoaderCallbacks, GlobalSearchResultFragment, DealCardEndlessAdapter

public class this._cls0 extends DealSummaryListLoaderCallbacks
{

    final GlobalSearchResultFragment this$0;

    public EndlessList getEndlessListClone(EndlessList endlesslist)
    {
        return new EndlessList(new ArrayList(endlesslist), endlesslist.getTotalSize(), endlesslist.getCurrentOffset(), endlesslist.getAttr());
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new this._cls0(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel, GlobalSearchResultFragment.this);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (List)obj);
    }

    public void onLoadFinished(Loader loader, List list)
    {
        if (list == null)
        {
            return;
        }
        loader = (onLoadFinished)list;
        list = getGlobalSearchResultActivity();
        Object obj;
        EndlessList endlesslist;
        boolean flag;
        if (loader.onLoadFinished() != 0 || loader.onLoadFinished() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        list.setHasMoreItems(flag);
        endlesslist = loader.onLoadFinished();
        list = getEndlessListClone(loader);
        obj = loader.getEndlessListClone();
        GlobalSearchResultFragment.access$202(GlobalSearchResultFragment.this, loader._mth0());
        GlobalSearchResultFragment.access$302(GlobalSearchResultFragment.this, endlesslist.size());
        GlobalSearchResultFragment.access$402(GlobalSearchResultFragment.this, ((EndlessList) (obj)).size());
        if (endlesslist.size() > 0)
        {
            list.addAll(endlesslist);
            list.setCurrentOffset(loader._mth0());
            list.setTotalSize(loader._mth0());
            list.setAttr(loader._mth0());
        }
        if (GlobalSearchResultFragment.access$500(GlobalSearchResultFragment.this) != null && ((EndlessList) (obj)).size() > 0)
        {
            GlobalSearchResultFragment.access$602(GlobalSearchResultFragment.this, ((Business)((EndlessList) (obj)).get(0)).isExactMatch);
        }
        computeABTestResults();
        if (GlobalSearchResultFragment.access$500(GlobalSearchResultFragment.this) != null)
        {
            ArrayList arraylist = new ArrayList();
            for (obj = ((EndlessList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((Business)((Iterator) (obj)).next())) { }
            if (GlobalSearchResultFragment.access$700(GlobalSearchResultFragment.this)[3] > 0)
            {
                GlobalSearchResultFragment.access$800(GlobalSearchResultFragment.this)._fld0 = (Business)arraylist.remove(0);
            }
            GlobalSearchResultFragment.access$500(GlobalSearchResultFragment.this)._fld0 = arraylist;
        }
        dealCardEndlessAdapter.setTotalSize(loader._mth0());
        listAdapter.setList(list);
        afterOnLoadFinished(loader);
    }

    public void onLoaderReset(Loader loader)
    {
        GlobalSearchResultFragment.access$202(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$302(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$402(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$702(GlobalSearchResultFragment.this, new int[6]);
        GlobalSearchResultFragment.access$902(GlobalSearchResultFragment.this, new ArrayList());
        super.onLoaderReset(loader);
    }

    public void reloadList()
    {
        GlobalSearchResultFragment.access$202(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$302(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$402(GlobalSearchResultFragment.this, 0);
        GlobalSearchResultFragment.access$702(GlobalSearchResultFragment.this, new int[6]);
        GlobalSearchResultFragment.access$902(GlobalSearchResultFragment.this, new ArrayList());
        listAdapter.setList(new ArrayList());
    }

    public (JavaListAdapter javalistadapter)
    {
        this$0 = GlobalSearchResultFragment.this;
        super(javalistadapter, GlobalSearchResultFragment.this);
    }
}
