// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import android.app.Activity;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.MyGroupons;
import com.groupon.adapter.VpsAdapter;
import com.groupon.adapter.mygroupons.MyGrouponsCardEndlessAdapter;
import com.groupon.adapter.mygroupons.MyGrouponsJavaAdapter;
import com.groupon.db.events.MyGrouponsUpdateEvent;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.fragment.GrouponListFragment;
import com.groupon.loader.MyGrouponsListLoader;
import com.groupon.manager.mygroupons.BaseMyGrouponsPaginatedSyncManager;
import com.groupon.models.EndlessList;
import com.groupon.models.country.Country;
import com.groupon.models.gdt.GtgMockMyGrouponItemSummary;
import com.groupon.models.nst.GtgMockGrouponItemExtraInfo;
import com.groupon.models.nst.TrackPackageExtraInfo;
import com.groupon.service.LoginService;
import com.groupon.service.MarkUsedManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CountryUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.Function2;
import com.groupon.util.LoaderCallbacksUtil;
import com.groupon.view.GrouponSwipeRefreshLayout;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.PendingAdapterInterface;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.manager.PaginatedSyncManager;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

public abstract class BaseMyGrouponsFragment extends GrouponListFragment
    implements com.groupon.fragment.DealsAndMyGrouponsBaseEndlessAdapter.PaginatedSyncManagerProvider, commonlib.manager.SyncManager.SyncUiCallbacks
{
    protected static class GrouponsListLoaderCallbacks extends ListLoaderCallbacks
    {

        private BaseMyGrouponsFragment baseMyGrouponsFragment;
        private String grouponCategory;
        private boolean isEditOrderEnabled;

        private void setGrouponsSelectable(List list)
        {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) 
            {
                MyGrouponItemSummary mygrouponitemsummary = (MyGrouponItemSummary)iterator.next();
                String s;
                boolean flag;
                boolean flag1;
                boolean flag2;
                if (Strings.notEmpty(mygrouponitemsummary.availability))
                {
                    list = mygrouponitemsummary.availability;
                } else
                {
                    list = mygrouponitemsummary.purchaseStatus;
                }
                s = mygrouponitemsummary.status;
                flag2 = mygrouponitemsummary.remoteId.startsWith("groupon_item_internal_id");
                if (Strings.equalsIgnoreCase(list, "refunded") && Strings.equalsIgnoreCase(s, "succeeded"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (isEditOrderEnabled && Strings.equals(mygrouponitemsummary.status, "failed"))
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (flag1 || !flag2 && !Strings.equalsIgnoreCase(list, "pending") && !Strings.equalsIgnoreCase(s, "pending") && !Strings.equalsIgnoreCase(s, "failed") && !flag)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                mygrouponitemsummary.isSelectable = flag2;
            }
        }

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            bundle = new MyGrouponsListLoader(com/groupon/db/models/mygroupons/MyGrouponItemSummary, com/groupon/db/events/MyGrouponsUpdateEvent, baseMyGrouponsFragment.getActivity(), grouponCategory);
            bundle.setForceDownload(baseMyGrouponsFragment.isForceDownload());
            return bundle;
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            if (list != null)
            {
                setGrouponsSelectable(list);
                baseMyGrouponsFragment.onFinishedLoading(list);
            }
        }

        public void onLoaderReset(Loader loader)
        {
            super.onLoaderReset(loader);
            baseMyGrouponsFragment.myGrouponsCardEndlessAdapter.setTotalSize(0);
            baseMyGrouponsFragment.myGrouponsCardEndlessAdapter.enableAppending(true);
        }

        public GrouponsListLoaderCallbacks(BaseMyGrouponsFragment basemygrouponsfragment, JavaAdapter javaadapter, String s, boolean flag)
        {
            super(javaadapter);
            baseMyGrouponsFragment = basemygrouponsfragment;
            grouponCategory = s;
            isEditOrderEnabled = flag;
        }
    }

    private class TrackPackageClickListener
        implements android.view.View.OnClickListener
    {

        final BaseMyGrouponsFragment this$0;

        public void onClick(View view)
        {
            onTrackPackageButtonClick((MyGrouponItemSummary)view.getTag());
        }

        private TrackPackageClickListener()
        {
            this$0 = BaseMyGrouponsFragment.this;
            super();
        }

    }


    private static final String GOODS_TRACK_PACKAGE = "goods_track_package";
    protected Lazy countryUtil;
    protected CurrentCountryManager currentCountryManager;
    protected Lazy dialogManager;
    protected Lazy editOrderAbTestHelper;
    TextView emptyTitleTextView;
    View emptyView;
    private boolean forceDownload;
    protected GdtService gdtService;
    protected Lazy intentFactory;
    protected Logger logger;
    protected Lazy loginService;
    protected MarkUsedManager markUsedManager;
    protected MyGrouponsCardEndlessAdapter myGrouponsCardEndlessAdapter;
    protected JavaListAdapter myGrouponsJavaAdapter;
    GrouponSwipeRefreshLayout swipeLayout;

    public BaseMyGrouponsFragment()
    {
        forceDownload = true;
    }

    private void handleSyncErrorCancellation(Runnable runnable, Exception exception)
    {
        getAppendingAdapter().enableAppending(false);
    }

    private void onListItemClick(MyGrouponItemSummary mygrouponitemsummary)
    {
        if (Strings.equals(mygrouponitemsummary.remoteId, "gtg_mock_my_groupon_item_summary_remote_id"))
        {
            startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(gdtService.getGtgUserOrdersUrl(), false, true, true, true, false));
            logger.logClick("", "mygroupons_myfood_click", "mygroupon_available_tab", Logger.NULL_NST_FIELD, new GtgMockGrouponItemExtraInfo(String.valueOf(((GtgMockMyGrouponItemSummary)mygrouponitemsummary).getNumberOfOrders()), "header"));
            return;
        }
        if (mygrouponitemsummary.isMarketRate)
        {
            String s = mygrouponitemsummary.reservationId;
            mygrouponitemsummary = mygrouponitemsummary.hotelTimezoneIdentifier;
            startActivity(((IntentFactory)intentFactory.get()).newMarketRateReservationIntent(s, mygrouponitemsummary));
            return;
        }
        String s2 = mygrouponitemsummary.availability;
        String s1 = s2;
        if (Strings.isEmpty(s2))
        {
            s1 = mygrouponitemsummary.purchaseStatus;
        }
        boolean flag = Strings.equalsIgnoreCase(mygrouponitemsummary.status, "succeeded");
        int i;
        if (mygrouponitemsummary.isCustomerRedeemed || mygrouponitemsummary.isMerchantRedeemed)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        s2 = mygrouponitemsummary.remoteId;
        if (i != 0 || markUsedManager.isQueued(s2) || markUsedManager.isCachedForGroupons(s2) || Strings.equalsIgnoreCase(s1, "redeemed") && flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = ((MyGroupons)getActivity()).getCurrentTabPosition();
        startActivityForResult(((IntentFactory)intentFactory.get()).newGrouponIntent(mygrouponitemsummary.remoteId, flag, i), 10108);
    }

    private void onTrackPackageButtonClick(MyGrouponItemSummary mygrouponitemsummary)
    {
        logger.logClick("", "goods_track_package", Channel.GOODS.toString(), Logger.NULL_NST_FIELD, new TrackPackageExtraInfo(mygrouponitemsummary.orderId));
        startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(mygrouponitemsummary.shipmentsListTrackUrl, true, true, false, true, false));
    }

    private void setPullToRefreshEnabled(boolean flag)
    {
        if (swipeLayout != null)
        {
            swipeLayout.setEnabled(flag);
        }
    }

    private void setUpRefreshListener()
    {
        if (swipeLayout != null)
        {
            swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final BaseMyGrouponsFragment this$0;

                public void onRefresh()
                {
                    forceReload();
                }

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super();
            }
            });
        }
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
        if (swipeLayout != null && swipeLayout.isEnabled())
        {
            swipeLayout.setRefreshing(true);
        }
        getAppendingAdapter().enableAppending(true);
        getSyncManager().requestSync(this, null);
    }

    public PendingAdapterInterface getAppendingAdapter()
    {
        return myGrouponsCardEndlessAdapter;
    }

    public abstract BaseMyGrouponsPaginatedSyncManager getSyncManager();

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected TrackPackageClickListener getTrackPackageClickListener()
    {
        return new TrackPackageClickListener();
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if (!isAdded() || isRemoving())
        {
            return;
        } else
        {
            final Activity context = getActivity();
            LoaderCallbacksUtil.handleSyncError(runnable, exception, context, (LoginService)loginService.get(), (CountryUtil)countryUtil.get(), currentCountryManager.getCurrentCountry(), getSyncManager(), (IntentFactory)intentFactory.get(), new Function2() {

                final BaseMyGrouponsFragment this$0;
                final Context val$context;

                public volatile void execute(Object obj, Object obj1)
                    throws Exception
                {
                    execute((Runnable)obj, (Exception)obj1);
                }

                public void execute(Runnable runnable1, Exception exception1)
                {
                    LoaderCallbacksUtil.showGenericErrorMessage(runnable1, exception1, context, (DialogManager)dialogManager.get(), getSyncManager(), new Function2() {

                        final _cls6 this$1;

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
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }, new Function2() {

                        final _cls6 this$1;

                        public volatile void execute(Object obj, Object obj1)
                            throws Exception
                        {
                            execute((Runnable)obj, (Exception)obj1);
                        }

                        public void execute(Runnable runnable, Exception exception)
                        {
                            handleSyncErrorCancellation(runnable, exception);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                }

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                context = context1;
                super();
            }
            });
            return;
        }
    }

    public abstract void initLoader();

    protected void installAdapters()
    {
        myGrouponsJavaAdapter = new MyGrouponsJavaAdapter(getActivity(), getTrackPackageClickListener());
        myGrouponsCardEndlessAdapter = new MyGrouponsCardEndlessAdapter(this, this, myGrouponsJavaAdapter);
        setListAdapter(new VpsAdapter(myGrouponsCardEndlessAdapter));
    }

    public boolean isForceDownload()
    {
        return forceDownload;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        RoboGuice.getInjector(getActivity()).injectMembers(this);
        editOrderAbTestHelper = new Lazy(getActivity()) {

            final BaseMyGrouponsFragment this$0;

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super(context);
            }
        };
        loginService = new Lazy(getActivity()) {

            final BaseMyGrouponsFragment this$0;

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super(context);
            }
        };
        countryUtil = new Lazy(getActivity()) {

            final BaseMyGrouponsFragment this$0;

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super(context);
            }
        };
        dialogManager = new Lazy(getActivity()) {

            final BaseMyGrouponsFragment this$0;

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super(context);
            }
        };
        intentFactory = new Lazy(getActivity()) {

            final BaseMyGrouponsFragment this$0;

            
            {
                this$0 = BaseMyGrouponsFragment.this;
                super(context);
            }
        };
        forceDownload = true;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            emptyTitleTextView.setText(getString(0x7f0802b2));
        }
        setUpRefreshListener();
        installAdapters();
        initLoader();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030170, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    protected void onFinishedLoading(List list)
    {
        toggleEmptyViewVisibility(list.isEmpty());
        EndlessList endlesslist = (EndlessList)list;
        myGrouponsCardEndlessAdapter.setTotalSize(endlesslist.getTotalSize());
        myGrouponsJavaAdapter.setList(list);
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        super.onListItemClick(listview, view, i, l);
        onListItemClick((MyGrouponItemSummary)getListView().getItemAtPosition(i));
    }

    public void onPause()
    {
        if (swipeLayout != null)
        {
            swipeLayout.clearAnimation();
        }
        getSyncManager().stopAutomaticSyncs();
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (!getActivity().isFinishing())
        {
            getSyncManager().startAutomaticSyncs(this, null);
        }
    }

    public void setForceDownload(boolean flag)
    {
        forceDownload = flag;
    }

    public void toggleEmptyViewVisibility(boolean flag)
    {
        byte byte0 = 8;
        Object obj = emptyView;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = getListView();
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((ListView) (obj)).setVisibility(i);
    }


}
