// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.activity.IntentFactory;
import com.groupon.db.events.DialogCallbackEvent;
import com.groupon.db.models.Pagination;
import com.groupon.manager.UniversalInfo;
import com.groupon.manager.UniversalSyncManager;
import com.groupon.models.country.Country;
import com.groupon.service.LoginService;
import com.groupon.service.core.AbTestService;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.adapter.mapping.FallbackCardMapping;
import com.groupon.v3.adapter.mapping.PendingViewMapping;
import com.groupon.v3.loader.EmptyListChecker;
import com.groupon.v3.loader.UniversalListLoadResultData;
import com.groupon.v3.view.GrouponSwipeRefreshLayoutV3;
import com.groupon.v3.view.layout.GrouponSpanSizeLookup;
import com.squareup.otto.Bus;
import commonlib.loader.event.UpdateEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.groupon.util:
//            ArraySharedPreferences, DeviceInfoUtil, LoaderCallbacksUtil, CountryUtil, 
//            DialogManager, Function2

public class BaseRecyclerViewDelegate
{
    private static class DefaultEmptyListChecker
        implements EmptyListChecker
    {

        public boolean isEmpty(List list)
        {
            boolean flag;
label0:
            {
                boolean flag1 = false;
                if (list != null && !list.isEmpty())
                {
                    flag = flag1;
                    if (list.size() != 1)
                    {
                        break label0;
                    }
                    flag = flag1;
                    if (!(list.get(0) instanceof Pagination))
                    {
                        break label0;
                    }
                }
                flag = true;
            }
            return flag;
        }

        private DefaultEmptyListChecker()
        {
        }

    }

    private class SwipeToRefreshRunnable
        implements Runnable
    {

        private GrouponSwipeRefreshLayoutV3 swipeLayout;
        final BaseRecyclerViewDelegate this$0;

        public void run()
        {
            swipeLayout.setRefreshing(true);
        }

        public SwipeToRefreshRunnable(GrouponSwipeRefreshLayoutV3 grouponswiperefreshlayoutv3)
        {
            this$0 = BaseRecyclerViewDelegate.this;
            super();
            swipeLayout = grouponswiperefreshlayoutv3;
        }
    }

    public static interface SyncManagerHelper
    {

        public abstract UniversalInfo getInfoForSync();
    }


    public static final int DEFAULT_DEALS_PER_PAGE = 15;
    private AbTestService abTestService;
    private Activity activity;
    private Country country;
    private CountryUtil countryUtil;
    private UniversalListAdapter dataAdapter;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private EmptyListChecker emptyListChecker;
    private View emptyView;
    private int emptyViewLayoutId;
    private boolean enablePullToRefresh;
    private Bus globalBus;
    private IntentFactory intentFactory;
    private boolean isOnPause;
    private boolean isSyncError;
    private List listDecoration;
    protected Object listener;
    private ArraySharedPreferences loginPrefs;
    private LoginService loginService;
    private android.support.v7.widget.RecyclerView.OnScrollListener onScrollListener;
    private RecyclerView recyclerView;
    private GrouponSwipeRefreshLayoutV3 swipeLayout;
    private boolean syncAutomaticallyOnResume;
    private SyncManagerHelper syncManagerHelper;
    private commonlib.manager.SyncManager.SyncUiCallbacks syncUiCallbacks;
    private UniversalSyncManager universalSyncManager;

    public BaseRecyclerViewDelegate()
    {
        listener = new Object() {

            final BaseRecyclerViewDelegate this$0;

            public void onEvent(UpdateEvent updateevent)
            {
                if (updateevent.getClass() == com/groupon/db/events/DialogCallbackEvent && ((DialogCallbackEvent)updateevent).getEventId().equalsIgnoreCase("negative_click"))
                {
                    updateevent = dataAdapter.getList();
                    if (updateevent.isEmpty() || updateevent.size() == 1 && (updateevent.get(0) instanceof Pagination))
                    {
                        dataAdapter.setList(new ArrayList());
                        emptyView.setVisibility(0);
                    }
                }
            }

            
            {
                this$0 = BaseRecyclerViewDelegate.this;
                super();
            }
        };
        syncAutomaticallyOnResume = false;
        isOnPause = false;
        isSyncError = false;
    }

    private void removeUnsupportedItems(List list)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            int i = dataAdapter.getItemViewType(obj);
            if (i == -1 || (dataAdapter.getMapping(i) instanceof FallbackCardMapping))
            {
                arraylist.add(obj);
            }
        } while (true);
        list.removeAll(arraylist);
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        if (flag)
        {
            setPullToRefreshEnabled(false);
            loginPrefs.edit().remove("should_refresh_deals_after_login").apply();
            return;
        }
        if (swipeLayout != null)
        {
            swipeLayout.setRefreshing(false);
        }
        setPullToRefreshEnabled(true);
    }

    public void forceReload()
    {
        if (swipeLayout != null && swipeLayout.isEnabled())
        {
            swipeLayout.setRefreshing(true);
        }
        universalSyncManager.requestSync(syncUiCallbacks, null);
    }

    public UniversalListAdapter getDataAdapter()
    {
        return dataAdapter;
    }

    public View getEmptyView()
    {
        return emptyView;
    }

    protected int getPageSize(boolean flag)
    {
        int j = activity.getResources().getInteger(0x7f0d0001);
        byte byte0 = 15;
        int k = getSizeOfDealToFitScreen();
        int i = byte0;
        if (flag)
        {
            int l = abTestService.getVariantAsInt("firstPageLimit");
            i = byte0;
            if (l > 0)
            {
                i = Math.max(l, k * j);
            }
        }
        return (((i + j) - 1) / j) * j;
    }

    public RecyclerView getRecyclerView()
    {
        return recyclerView;
    }

    protected int getSizeOfDealToFitScreen()
    {
        DisplayMetrics displaymetrics = deviceInfoUtil.getDisplayMetrics();
        float f = activity.getResources().getDimensionPixelSize(0x7f0b00e8);
        return (int)((float)displaymetrics.heightPixels / f) + 1;
    }

    public GrouponSwipeRefreshLayoutV3 getSwipeLayout()
    {
        return swipeLayout;
    }

    public UniversalSyncManager getUniversalSyncManager()
    {
        return universalSyncManager;
    }

    public void handleSyncError(Runnable runnable, Exception exception, final Context context)
    {
        isSyncError = true;
        LoaderCallbacksUtil.handleSyncError(runnable, exception, context, loginService, countryUtil, country, universalSyncManager, intentFactory, new Function2() {

            final BaseRecyclerViewDelegate this$0;
            final Context val$context;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                if (!isOnPause)
                {
                    LoaderCallbacksUtil.showGenericErrorMessage(runnable1, exception1, context, dialogManager, universalSyncManager, new Function2() {

                        final _cls3 this$1;

                        public volatile void execute(Object obj, Object obj1)
                            throws Exception
                        {
                            execute((Runnable)obj, (Exception)obj1);
                        }

                        public void execute(Runnable runnable, Exception exception)
                        {
                            if (swipeLayout != null && swipeLayout.isEnabled())
                            {
                                swipeLayout.setRefreshing(true);
                            }
                            isSyncError = false;
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }, new Function2() {

                        final _cls3 this$1;

                        public volatile void execute(Object obj, Object obj1)
                            throws Exception
                        {
                            execute((Runnable)obj, (Exception)obj1);
                        }

                        public void execute(Runnable runnable, Exception exception)
                        {
                            runnable = dataAdapter.getList();
                            if (runnable.size() > 0)
                            {
                                int i = runnable.size() - 1;
                                if (runnable.get(i) instanceof Pagination)
                                {
                                    runnable.remove(i);
                                }
                                dataAdapter.setList(runnable);
                            }
                            isSyncError = false;
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = BaseRecyclerViewDelegate.this;
                context = context1;
                super();
            }
        });
    }

    public void initDelegate(Activity activity1, commonlib.manager.SyncManager.SyncUiCallbacks syncuicallbacks, android.support.v7.widget.RecyclerView.OnScrollListener onscrolllistener, SyncManagerHelper syncmanagerhelper, int i, boolean flag, boolean flag1, 
            List list)
    {
        activity = activity1;
        syncUiCallbacks = syncuicallbacks;
        emptyViewLayoutId = i;
        enablePullToRefresh = flag;
        syncAutomaticallyOnResume = flag1;
        onScrollListener = onscrolllistener;
        listDecoration = list;
        syncManagerHelper = syncmanagerhelper;
        emptyListChecker = new DefaultEmptyListChecker();
    }

    public void onActivityCreated(Bundle bundle)
    {
        universalSyncManager.setFirstPageSize(getPageSize(true));
        universalSyncManager.setSubsequencePageSize(getPageSize(false));
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.registerOverrideMapping(new PendingViewMapping());
        setUpRefreshListener();
    }

    public View onCreateView(View view, LayoutInflater layoutinflater)
    {
        swipeLayout = (GrouponSwipeRefreshLayoutV3)view.findViewById(0x7f1000db);
        emptyView = layoutinflater.inflate(emptyViewLayoutId, null, false);
        emptyView.setVisibility(4);
        ViewGroup viewgroup = (ViewGroup)view.findViewById(0x7f1001e9);
        if (viewgroup != null)
        {
            recyclerView = (RecyclerView)layoutinflater.inflate(0x7f03002c, null, false);
            recyclerView.setHasFixedSize(true);
            int i = activity.getResources().getInteger(0x7f0d0001);
            layoutinflater = new GridLayoutManager(activity, i);
            GrouponSpanSizeLookup grouponspansizelookup = new GrouponSpanSizeLookup(dataAdapter, i);
            grouponspansizelookup.setSpanIndexCacheEnabled(false);
            layoutinflater.setSpanSizeLookup(grouponspansizelookup);
            recyclerView.setLayoutManager(layoutinflater);
            android.support.v7.widget.RecyclerView.ItemDecoration itemdecoration;
            for (layoutinflater = listDecoration.iterator(); layoutinflater.hasNext(); recyclerView.addItemDecoration(itemdecoration))
            {
                itemdecoration = (android.support.v7.widget.RecyclerView.ItemDecoration)layoutinflater.next();
            }

            if (onScrollListener != null)
            {
                recyclerView.setOnScrollListener(onScrollListener);
            }
            viewgroup.addView(recyclerView);
            viewgroup.addView(emptyView);
        }
        setPullToRefreshEnabled(enablePullToRefresh);
        return view;
    }

    public void onLoaderDataChanged(UniversalListLoadResultData universallistloadresultdata, boolean flag)
    {
        int i = 0;
        List list = universallistloadresultdata.getListData();
        removeUnsupportedItems(list);
        Pagination pagination = universallistloadresultdata.getPagination();
        if (universallistloadresultdata.hasNoData(emptyListChecker))
        {
            if (pagination == null)
            {
                universallistloadresultdata = new ArrayList();
                universallistloadresultdata.add(new Pagination());
                dataAdapter.setList(universallistloadresultdata);
                emptyView.setVisibility(4);
                return;
            } else
            {
                dataAdapter.setList(new ArrayList());
                emptyView.setVisibility(0);
                return;
            }
        }
        if (dataAdapter != null)
        {
            dataAdapter.setList(list);
        }
        universallistloadresultdata = emptyView;
        if (!list.isEmpty())
        {
            i = 4;
        }
        universallistloadresultdata.setVisibility(i);
    }

    public void onPause()
    {
        isOnPause = true;
        universalSyncManager.stopAutomaticSyncs();
        globalBus.unregister(listener);
    }

    public void onPendingViewBound()
    {
        if (!isSyncError)
        {
            universalSyncManager.requestSyncNextPage(syncUiCallbacks, null);
        }
    }

    public void onResume()
    {
        isOnPause = false;
        if (!activity.isFinishing() && syncAutomaticallyOnResume)
        {
            universalSyncManager.startAutomaticSyncs(syncUiCallbacks, syncManagerHelper.getInfoForSync());
        }
        globalBus.register(listener);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        if (swipeLayout != null)
        {
            swipeLayout.setRefreshing(false);
            setPullToRefreshEnabled(true);
        }
    }

    public BaseRecyclerViewDelegate setEmptyListChecker(EmptyListChecker emptylistchecker)
    {
        emptyListChecker = emptylistchecker;
        return this;
    }

    protected void setPullToRefreshEnabled(boolean flag)
    {
        if (swipeLayout != null && enablePullToRefresh)
        {
            swipeLayout.setEnabled(flag);
        } else
        if (swipeLayout != null)
        {
            swipeLayout.setEnabled(false);
            swipeLayout.setRefreshing(false);
            return;
        }
    }

    protected void setUpRefreshListener()
    {
        if (swipeLayout != null)
        {
            swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final BaseRecyclerViewDelegate this$0;

                public void onRefresh()
                {
                    forceReload();
                }

            
            {
                this$0 = BaseRecyclerViewDelegate.this;
                super();
            }
            });
        }
    }

    public void triggerSwipeRefreshAnimation()
    {
        swipeLayout.post(new SwipeToRefreshRunnable(swipeLayout));
    }








/*
    static boolean access$702(BaseRecyclerViewDelegate baserecyclerviewdelegate, boolean flag)
    {
        baserecyclerviewdelegate.isSyncError = flag;
        return flag;
    }

*/
}
