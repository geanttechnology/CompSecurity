// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.app.LoaderManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.groupon.abtest.EditOrderAbTestHelper;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.adapter.mygroupons.MyGrouponsCardEndlessAdapter;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.manager.mygroupons.BaseMyGrouponsPaginatedSyncManager;
import com.groupon.manager.mygroupons.MyAvailableGrouponsSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.models.gdt.GdtUserOrdersData;
import com.groupon.models.gdt.GdtUserOrdersDataContainer;
import com.groupon.models.gdt.GtgMockMyGrouponItemSummary;
import com.groupon.service.LoginService;
import com.groupon.service.gdt.GdtService;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.ReturningFunction1;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.PendingAdapterInterface;
import commonlib.manager.PaginatedSyncManager;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            BaseMyGrouponsFragment

public class MyAvailableGrouponsFragment extends BaseMyGrouponsFragment
{

    private final int MAX_ORDERS_DISPLAY_NUMBER = 10;
    private final String TEN_PLUS_ORDERS = "10+";
    private GtgAbTestHelper gtgAbTestHelper;
    private boolean isGTGEnabled;
    private LoginService loginService;
    private MyAvailableGrouponsSyncManager myAvailableGrouponsSyncManager;

    public MyAvailableGrouponsFragment()
    {
    }

    private void getUserGdtOrdersAndSetGrouponsList(final List grouponsList)
    {
        gdtService.getGdtUserOrdersData(loginService.getConsumerId(), new Function1() {

            final MyAvailableGrouponsFragment this$0;
            final List val$grouponsList;

            public void execute(GdtUserOrdersDataContainer gdtuserordersdatacontainer)
            {
                if (gdtuserordersdatacontainer != null && gdtuserordersdatacontainer.data != null && gdtuserordersdatacontainer.data.orders.size() > 0)
                {
                    int i = gdtuserordersdatacontainer.data.orders.size();
                    if (i > 0)
                    {
                        gdtuserordersdatacontainer = new GtgMockMyGrouponItemSummary(i);
                        gdtuserordersdatacontainer.setTitle(getString(0x7f0804da));
                        if (i == 1)
                        {
                            gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, 1));
                        } else
                        if (i <= 10)
                        {
                            gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, i, new Object[] {
                                Integer.valueOf(i)
                            }));
                        } else
                        {
                            gdtuserordersdatacontainer.setSubtitle(getResources().getQuantityString(0x7f0c0014, i, new Object[] {
                                "10+"
                            }));
                        }
                        if (grouponsList.isEmpty() || grouponsList.get(0) != null && !Strings.equals(((MyGrouponItemSummary)grouponsList.get(0)).remoteId, "gtg_mock_my_groupon_item_summary_remote_id"))
                        {
                            grouponsList.add(0, gdtuserordersdatacontainer);
                        }
                    }
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((GdtUserOrdersDataContainer)obj);
            }

            
            {
                this$0 = MyAvailableGrouponsFragment.this;
                grouponsList = list;
                super();
            }
        }, new ReturningFunction1() {

            final MyAvailableGrouponsFragment this$0;

            public Boolean execute(Exception exception)
            {
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = MyAvailableGrouponsFragment.this;
                super();
            }
        }, new Function0() {

            final MyAvailableGrouponsFragment this$0;
            final List val$grouponsList;

            public void execute()
            {
                toggleEmptyViewVisibility(grouponsList.isEmpty());
                EndlessList endlesslist = (EndlessList)grouponsList;
                myGrouponsCardEndlessAdapter.setTotalSize(endlesslist.getTotalSize());
                myGrouponsJavaAdapter.setList(grouponsList);
            }

            
            {
                this$0 = MyAvailableGrouponsFragment.this;
                grouponsList = list;
                super();
            }
        });
    }

    public PendingAdapterInterface getAppendingAdapter()
    {
        return myGrouponsCardEndlessAdapter;
    }

    public volatile BaseMyGrouponsPaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public MyAvailableGrouponsSyncManager getSyncManager()
    {
        return myAvailableGrouponsSyncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public void initLoader()
    {
        getLoaderManager().initLoader(0, null, new BaseMyGrouponsFragment.GrouponsListLoaderCallbacks(this, myGrouponsJavaAdapter, "available_groupons", ((EditOrderAbTestHelper)editOrderAbTestHelper.get()).isEditOrderEnabled()));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        boolean flag;
        if (gtgAbTestHelper.isGtgJumpoffCardOnFeatured() || gtgAbTestHelper.isGtgPromoCardOnFeatured() || gtgAbTestHelper.isGtgOnSearch() || gtgAbTestHelper.isGtgOnNearby())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isGTGEnabled = flag;
    }

    protected void onFinishedLoading(List list)
    {
        if (isGTGEnabled)
        {
            getUserGdtOrdersAndSetGrouponsList(list);
            return;
        } else
        {
            super.onFinishedLoading(list);
            return;
        }
    }
}
