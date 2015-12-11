// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.activity.BusinessTipsPage;
import com.groupon.activity.IntentFactory;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.events.BusinessTipsUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Tip;
import com.groupon.manager.BusinessTipsSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.CountryUtil;
import com.groupon.util.Dates;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.view.GrouponSwipeRefreshLayout;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.adapter.EndlessAdapter;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.OrmLiteListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            GrouponListFragment

public class BusinessTipsFragment extends GrouponListFragment
    implements commonlib.manager.SyncManager.SyncUiCallbacks
{
    private class TipsEndlessAdapter extends EndlessAdapter
    {

        final BusinessTipsFragment this$0;

        protected View createPendingView(ViewGroup viewgroup)
        {
            return LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030201, null);
        }

        public int getCount()
        {
            if (!forceStopAppending && getWrappedAdapter().getCount() == 0)
            {
                return 1;
            } else
            {
                return super.getCount();
            }
        }

        public int getItemViewType(int i)
        {
            if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
            {
                return getWrappedAdapter().getViewTypeCount();
            } else
            {
                return super.getItemViewType(i);
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (!forceStopAppending && getWrappedAdapter().getCount() == 0 && i == 0)
            {
                return getPendingView(viewgroup);
            } else
            {
                return super.getView(i, view, viewgroup);
            }
        }

        protected void requestNextPage()
        {
            syncManager.requestSyncNextPage(BusinessTipsFragment.this, null);
        }

        public TipsEndlessAdapter(ListAdapter listadapter)
        {
            this$0 = BusinessTipsFragment.this;
            super(listadapter);
        }
    }

    private class TipsListLoaderCallback extends ListLoaderCallbacks
    {

        private String paginationChannelId;
        final BusinessTipsFragment this$0;

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            return new TipsLoader(com/groupon/db/models/Tip, com/groupon/db/events/BusinessTipsUpdateEvent, getActivity(), paginationChannelId);
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            if (list.size() == 0)
            {
                return;
            } else
            {
                loader = (EndlessList)list;
                tipsEndlessAdapter.setTotalSize(loader.getTotalSize());
                listAdapter.setList(list);
                return;
            }
        }

        public void onLoaderReset(Loader loader)
        {
            tipsEndlessAdapter.enableAppending(true);
            tipsEndlessAdapter.setTotalSize(0);
            super.onLoaderReset(loader);
        }

        public TipsListLoaderCallback(JavaListAdapter javalistadapter, String s)
        {
            this$0 = BusinessTipsFragment.this;
            super(javalistadapter);
            paginationChannelId = s;
        }
    }

    private static class TipsLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
    {

        private DaoPagination paginationDao;
        private DaoTip tipDao;
        private String tipsBusinessChannelId;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            Object obj;
            Pagination pagination;
            int i;
            int j;
            int k;
            try
            {
                obj = tipDao.queryBuilder().orderBy("updatedAt", false).where().eq("businessChannelId", tipsBusinessChannelId);
                obj = tipDao.query(((Where) (obj)).prepare());
                pagination = (Pagination)paginationDao.queryForFirstEq("channel", tipsBusinessChannelId);
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            j = 0;
            k = 0;
            i = 0;
            if (pagination == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            i = k;
            if (pagination.hasMorePages())
            {
                i = pagination.getCount();
            }
            k = pagination.getCurrentOffset();
            j = i;
            i = k;
            obj = new EndlessList(((List) (obj)), j, i, null);
            return ((List) (obj));
        }

        protected boolean shouldReload(BusinessTipsUpdateEvent businesstipsupdateevent)
        {
            return Strings.equals(businesstipsupdateevent.getBusinessId(), tipsBusinessChannelId);
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((BusinessTipsUpdateEvent)updateevent);
        }

        public TipsLoader(Class class1, Class class2, Context context, String s)
        {
            super(class1, class2, context);
            RoboGuice.getInjector(context).injectMembers(this);
            tipsBusinessChannelId = s;
        }
    }


    private static final String INITIAL_SYNC_STARTED = "initial_sync_started";
    private String businessId;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private DialogManager dialogManager;
    private boolean initialSyncStarted;
    private IntentFactory intentFactory;
    private LoginService loginService;
    GrouponSwipeRefreshLayout swipeLayout;
    private BusinessTipsSyncManager syncManager;
    private DaoTip tipDao;
    private String tipsBusinessChannelId;
    private TipsEndlessAdapter tipsEndlessAdapter;

    public BusinessTipsFragment()
    {
    }

    private void restoreInstanceState(Bundle bundle)
    {
        initialSyncStarted = bundle.getBoolean("initial_sync_started", false);
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        if (flag)
        {
            setPullToRefreshEnabled(false);
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
        if (!swipeLayout.isRefreshing())
        {
            swipeLayout.setRefreshing(true);
        }
        syncManager.requestSync(this, null);
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        LoaderCallbacksUtil.handleSyncError(runnable, exception, getActivity(), loginService, countryUtil, currentCountryManager.getCurrentCountry(), syncManager, intentFactory, new Function2() {

            final BusinessTipsFragment this$0;

            public volatile void execute(Object obj, Object obj1)
                throws Exception
            {
                execute((Runnable)obj, (Exception)obj1);
            }

            public void execute(Runnable runnable1, Exception exception1)
            {
                if (isAdded())
                {
                    runnable1 = dialogManager.getDialogFragment(Integer.valueOf(0x7f080165));
                    runnable1.setCancelable(false);
                    GrouponDialogFragment.show(getFragmentManager(), runnable1, "http_error_dialog");
                }
            }

            
            {
                this$0 = BusinessTipsFragment.this;
                super();
            }
        });
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        getLoaderManager().initLoader(0, null, new TipsListLoaderCallback(javalistadapter, tipsBusinessChannelId));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            restoreInstanceState(bundle);
        }
        businessId = ((BusinessTipsPage)getActivity()).getBusinessId();
        tipsBusinessChannelId = ((BusinessTipsPage)getActivity()).getPaginationChannelId();
        bundle = new OrmLiteListAdapter(tipDao) {

            final BusinessTipsFragment this$0;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                view = (Tip)getItem(i);
                viewgroup = getActivity().getLayoutInflater().inflate(0x7f030050, viewgroup, false);
                TextView textview = (TextView)viewgroup.findViewById(0x7f10016b);
                if (textview != null)
                {
                    textview.setText(((Tip) (view)).maskedName);
                }
                textview = (TextView)viewgroup.findViewById(0x7f10016a);
                if (textview != null)
                {
                    textview.setText(((Tip) (view)).text.trim());
                }
                textview = (TextView)viewgroup.findViewById(0x7f10016c);
                if (textview != null)
                {
                    textview.setText(Dates.getTimeStampStringExtended(getActivity(), ((Tip) (view)).updatedAt.getTime()));
                }
                viewgroup.setTag(Integer.valueOf(i));
                return viewgroup;
            }

            
            {
                this$0 = BusinessTipsFragment.this;
                super(dao);
            }
        };
        tipsEndlessAdapter = new TipsEndlessAdapter(bundle);
        setListAdapter(tipsEndlessAdapter);
        initLoader(bundle);
        syncManager.setBusinessId(businessId);
        syncManager.setTipsBusinessChannelId(tipsBusinessChannelId);
        if (!initialSyncStarted)
        {
            syncManager.requestSync(this, null);
            initialSyncStarted = true;
        }
        swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final BusinessTipsFragment this$0;

            public void onRefresh()
            {
                forceReload();
            }

            
            {
                this$0 = BusinessTipsFragment.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030055, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("initial_sync_started", initialSyncStarted);
    }

    protected void setPullToRefreshEnabled(boolean flag)
    {
        if (swipeLayout != null)
        {
            swipeLayout.setEnabled(flag);
        }
    }



}
