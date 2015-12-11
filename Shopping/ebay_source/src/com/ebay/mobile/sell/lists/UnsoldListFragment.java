// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.res.Resources;
import android.os.SystemClock;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseFragment, SellListAdapter

public final class UnsoldListFragment extends SellListBaseFragment
{

    private static long lastRefreshTime;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("UnsoldItemList", 3, "Log Dest Unsold");

    public UnsoldListFragment()
    {
    }

    protected void deleteItems(List list)
    {
        if (list != null && list.size() > 0)
        {
            list = (MyEbayListItem[])list.toArray(new MyEbayListItem[list.size()]);
            dm.removeFromUnsoldList(this, list);
            setListShown(false);
        }
    }

    protected SellListAdapter getAdapter()
    {
        return new SellListAdapter(getActivity(), getLayoutResource(), 0x1020014, this, SellingListActivity.ListType.UNSOLD);
    }

    protected int getEmptyStateTextResource()
    {
        return 0x7f0703b4;
    }

    protected com.ebay.common.ConstantsCommon.ItemKind getItemKind()
    {
        return com.ebay.common.ConstantsCommon.ItemKind.Unsold;
    }

    protected SourceIdentification getSourceIdentification()
    {
        return new SourceIdentification(getTrackingEventName(), "me", "All");
    }

    protected String getTitleText(Resources resources)
    {
        return resources.getString(0x7f070b8f);
    }

    public String getTrackingEventName()
    {
        return "MyEbayUnsoldList";
    }

    public void invalidate()
    {
        super.invalidate();
        if (dm != null)
        {
            dm.forceReloadUnsoldList();
        }
    }

    protected boolean isEditEnabled()
    {
        return true;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (MyEbaySellingDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.KeyParams(userDm.getCurrentUser().user), this);
        dm.setObserving(this, false, false, false, true, false);
        if (restorePage != -1)
        {
            dm.loadUnsoldList(restorePage);
        }
        datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
        if (pendingRefresh)
        {
            invalidate();
        }
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        dm.loadUnsoldList(j);
    }

    public void onStart()
    {
        if (lastRefreshTime != 0L) goto _L2; else goto _L1
_L1:
        lastRefreshTime = SystemClock.elapsedRealtime();
_L4:
        super.onStart();
        return;
_L2:
        if (SystemClock.elapsedRealtime() - 0x493e0L > lastRefreshTime)
        {
            lastRefreshTime = SystemClock.elapsedRealtime();
            invalidate();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onUnsoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        super.onUnsoldListChanged(myebaysellingdatamanager, listcontent);
        setList(listcontent, null);
    }

}
