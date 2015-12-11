// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.RefineContentFragment;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.nautilus.domain.content.dm.MyEbayDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayBaseRecyclerAdapter

public abstract class MyEbayListFragmentBase extends RefineContentFragment
    implements DialogFragmentCallback, com.ebay.common.EbayTimer.OnTimerEvent, MyEbayBaseRecyclerAdapter.MyEbayAdapterCallback, com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.OnRequestMoreListener, TrackingSupport
{
    public static interface BidSourceProvider
    {

        public abstract String getBidSource();
    }

    protected static class RequestMonitor
    {

        private final HashMap requestToStatus = new HashMap();

        public void addRequest(Object obj)
        {
            addRequest(obj, 0);
        }

        public void addRequest(Object obj, int i)
        {
            requestToStatus.put(obj, new Info(i));
        }

        public ResultStatus getFirstError()
        {
            Object obj1 = null;
            Iterator iterator = requestToStatus.keySet().iterator();
            do
            {
                Object obj = obj1;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = iterator.next();
                obj = (Info)requestToStatus.get(obj);
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = ((Info) (obj)).status;
                }
            } while (obj == null || !((ResultStatus) (obj)).hasError());
            return ((ResultStatus) (obj));
        }

        public int getTargetPage(Object obj)
        {
            obj = (Info)requestToStatus.get(obj);
            if (obj != null)
            {
                return ((Info) (obj)).targetPage;
            } else
            {
                return 0;
            }
        }

        public boolean isCompleted()
        {
            boolean flag1 = true;
            Iterator iterator = requestToStatus.keySet().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = iterator.next();
                boolean flag;
                if (((Info)requestToStatus.get(obj)).status != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                flag1 &= flag;
            }
            return flag1;
        }

        public void setCompleted(Object obj, ResultStatus resultstatus)
        {
            Info info1 = (Info)requestToStatus.get(obj);
            Info info = info1;
            if (info1 == null)
            {
                info = new Info(0);
                requestToStatus.put(obj, info);
            }
            info.status = resultstatus;
        }

        protected RequestMonitor()
        {
        }
    }

    private class RequestMonitor.Info
    {

        ResultStatus status;
        int targetPage;
        final RequestMonitor this$0;

        public RequestMonitor.Info(int i)
        {
            this$0 = RequestMonitor.this;
            super();
            targetPage = i;
            status = null;
        }
    }


    protected static final long DEFAULT_REFRESH_TIME = 0L;
    private static final int DIALOG_CONFIRM_DELETE = 0;
    private static final int DIALOG_DELETE_INFO = 1;
    public static final int DISPLAY_MODE_ALL = 0;
    protected static final String EMPTY_TITLE = " ";
    public static final String EXTRA_PENDING_REFRESH = "com.ebay.mobile.myebay.MyEbayListFragmentBase.pendingRefresh";
    public static final String EXTRA_REQUESTED_SPINNER_ACCESS = "com.ebay.mobile.myebay.MyEbayListFragmentBase.requestedSpinnerAccess";
    public static final String EXTRA_SPINNER_TRIGGERED_BY_USER = "com.ebay.mobile.myebay.MyEbayListFragmentBase.isSpinnerTriggeredByUser";
    public static final String EXTRA_TARGET_LIST = "target_list";
    private static final String KEY_SEE_MORE_COUNTS = "seeMoreCounts";
    private static final String KEY_SEE_MORE_LISTS = "seeMoreLists";
    protected static final int LOAD_MORE_OFFSET = 50;
    private static final long REFRESH_INTERVAL = 0x493e0L;
    public static final int UNSPECIFIED_DISPLAY_MODE = -1;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("MyEbay", 3, "Log My Ebay");
    private BidSourceProvider bidSourceProvider;
    protected int currentList;
    protected MyEbayDataManager dm;
    protected ViewStub emptyStub;
    protected View emptyView;
    protected View goShoppingButton;
    protected boolean isLoadCompleted;
    private boolean isSpinnerTriggeredByUser;
    protected View mainContentContainer;
    protected boolean pendingRefresh;
    protected View progressContainer;
    protected SwipeRefreshLayout pullToRefresh;
    private android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener pullToRefreshListener;
    protected MyEbayBaseRecyclerAdapter recyclerAdapter;
    protected RecyclerView recyclerView;
    private SparseIntArray seeMoreCountPerList;
    protected boolean shouldForceRefreshAtStartup;
    protected UserCache userCache;
    protected UserContextDataManager userDm;

    public MyEbayListFragmentBase()
    {
        pullToRefreshListener = new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final MyEbayListFragmentBase this$0;

            public void onRefresh()
            {
                pullToRefresh.setRefreshing(false);
                invalidate();
            }

            
            {
                this$0 = MyEbayListFragmentBase.this;
                super();
            }
        };
        seeMoreCountPerList = new SparseIntArray();
    }

    public static long getLastRefreshTime(String s)
    {
        return MyApp.getPrefs().getUserPref(s, 0L);
    }

    private int getSavedListIndex()
    {
        return MyApp.getPrefs().getUserPref(getListSelectionPrefsName(), 0);
    }

    private void restoreSeeMoreCount(Bundle bundle)
    {
        if (bundle.containsKey("seeMoreLists") && bundle.containsKey("seeMoreCounts"))
        {
            int ai[] = bundle.getIntArray("seeMoreLists");
            bundle = bundle.getIntArray("seeMoreCounts");
            if (ai.length == bundle.length)
            {
                seeMoreCountPerList = new SparseIntArray(ai.length);
                for (int i = 0; i < ai.length; i++)
                {
                    seeMoreCountPerList.put(ai[i], bundle[i]);
                }

            }
        }
    }

    private void safeSetListShown(boolean flag)
    {
        if (isResumed())
        {
            setListShown(flag, true);
            return;
        } else
        {
            setListShown(flag, false);
            return;
        }
    }

    private void saveSeeMoreCount(Bundle bundle)
    {
        int ai[] = new int[seeMoreCountPerList.size()];
        int ai1[] = new int[seeMoreCountPerList.size()];
        for (int i = 0; i < seeMoreCountPerList.size(); i++)
        {
            ai[i] = seeMoreCountPerList.keyAt(i);
            ai1[i] = seeMoreCountPerList.get(ai[i]);
        }

        bundle.putIntArray("seeMoreLists", ai);
        bundle.putIntArray("seeMoreCounts", ai1);
    }

    public static void setLastRefreshTime(long l, String s)
    {
        MyApp.getPrefs().setUserPref(l, s);
    }

    private void setSavedListIndex(int i)
    {
        MyApp.getPrefs().setUserPref(i, getListSelectionPrefsName());
    }

    private void showConfirmDeleteDialog()
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(getResources().getString(0x7f07025f));
        builder.setNegativeButton(0x1040009);
        builder.setPositiveButton(0x7f070cc7);
        builder.createFromFragment(0, this).show(getFragmentManager(), getClass().getName());
    }

    private void showDeleteOrderInfoDialog()
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(getResources().getString(0x7f070147));
        builder.setPositiveButton(0x7f070738);
        builder.createFromFragment(1, this).show(getFragmentManager(), getClass().getName());
    }

    public void OnTimer()
    {
        if (recyclerAdapter != null && recyclerView != null)
        {
            int j = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
            if (j >= 0)
            {
                int k = recyclerView.getChildCount();
                int i = 0;
                while (i < k) 
                {
                    View view = recyclerView.getChildAt(i);
                    if (view != null)
                    {
                        recyclerAdapter.updateTimeRemaining(j + i, view);
                    }
                    i++;
                }
            }
        }
    }

    protected TrackingData getBasePageImpression()
    {
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        Activity activity = getActivity();
        Intent intent = activity.getIntent();
        if (intent != null)
        {
            NotificationTrackingUtil.addNotificationTracking(activity, trackingdata, intent, intent.getStringExtra("event_type"));
            intent.removeExtra("noti_type_id");
            trackingdata.addSourceIdentification(intent);
        }
        return trackingdata;
    }

    protected String getBidSource()
    {
        if (bidSourceProvider == null)
        {
            return null;
        } else
        {
            return bidSourceProvider.getBidSource();
        }
    }

    protected Intent getIntentForItemSelected(MyEbayListItem myebaylistitem)
    {
        Intent intent = new Intent();
        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
        if (myebaylistitem.transaction != null)
        {
            userCache.setShipped(String.valueOf(myebaylistitem.id), myebaylistitem.transaction.transactionId, myebaylistitem.transaction.shipped);
            userCache.addToPaidStatus(String.valueOf(myebaylistitem.id), myebaylistitem.transaction.transactionId, myebaylistitem.transaction.paidStatus, myebaylistitem.transaction.paidTime);
        }
        if (myebaylistitem.endDate != null)
        {
            intent.putExtra("item_view_end_date", myebaylistitem.endDate.getTime());
        }
        if (myebaylistitem.transaction != null)
        {
            intent.putExtra("transaction_id", myebaylistitem.transaction.transactionId);
            intent.putExtra("item_view_feedback_left", myebaylistitem.transaction.feedbackLeft);
        }
        if (myebaylistitem.nameValueList != null)
        {
            intent.putParcelableArrayListExtra("param_variation_values", myebaylistitem.nameValueList);
        }
        return intent;
    }

    protected abstract String getLastRefreshPrefsName();

    protected abstract String getListSelectionPrefsName();

    protected abstract MyEbayBaseRecyclerAdapter getRecyclerAdapter();

    protected abstract SourceIdentification getSourceIdentification();

    protected boolean handleError(ResultStatus resultstatus)
    {
        return EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
    }

    protected abstract boolean hasList(int i);

    protected void initAdapter(int i)
    {
        if (recyclerAdapter != null)
        {
            recyclerAdapter.setOnRequestMoreListener(null);
        }
        recyclerAdapter = getRecyclerAdapter();
        recyclerAdapter.setOnRequestMoreListener(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    public abstract void invalidate();

    protected abstract boolean isEditEnabled();

    protected abstract boolean isRefineEnabled();

    protected final boolean isViewCreated()
    {
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        userCache = new UserCache(getBaseActivity());
        initAdapter(currentList);
    }

    protected void onCancelPressed()
    {
        pullToRefresh.setEnabled(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        userDm = (UserContextDataManager)UserContextDataManager.get(getFwActivity().getEbayContext(), UserContextDataManager.KEY);
        Object obj = getActivity();
        if (obj instanceof BidSourceProvider)
        {
            bidSourceProvider = (BidSourceProvider)obj;
        }
        obj = getArguments();
        currentList = getSavedListIndex();
        if (obj != null)
        {
            int i = ((Bundle) (obj)).getInt("target_list", -1);
            if (hasList(i))
            {
                currentList = i;
            }
        }
        if (bundle != null)
        {
            pendingRefresh = bundle.getBoolean("com.ebay.mobile.myebay.MyEbayListFragmentBase.pendingRefresh");
            currentList = bundle.getInt("com.ebay.mobile.myebay.MyEbayListFragmentBase.requestedSpinnerAccess");
            isSpinnerTriggeredByUser = bundle.getBoolean("com.ebay.mobile.myebay.MyEbayListFragmentBase.isSpinnerTriggeredByUser");
            restoreSeeMoreCount(bundle);
        }
    }

    protected View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03016f, viewgroup, false);
        pullToRefresh = (SwipeRefreshLayout)layoutinflater.findViewById(0x7f1003c5);
        pullToRefresh.setOnRefreshListener(pullToRefreshListener);
        progressContainer = layoutinflater.findViewById(0x7f1000ca);
        mainContentContainer = layoutinflater.findViewById(0x7f1003c4);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f1003c6);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        emptyStub = (ViewStub)layoutinflater.findViewById(0x7f1003c3);
        setLoading();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        recyclerView = null;
        super.onDestroyView();
    }

    protected void onEditPressed()
    {
        pullToRefresh.setEnabled(false);
    }

    public void onNonDeletableOrderInfoClicked()
    {
        showDeleteOrderInfoDialog();
    }

    protected void onRequestMonitorCompleted(RequestMonitor requestmonitor)
    {
        isLoadCompleted = true;
        safeSetListShown(true);
        requestmonitor = requestmonitor.getFirstError();
        if (requestmonitor != null)
        {
            handleError(requestmonitor);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        saveSeeMoreCount(bundle);
        bundle.putBoolean("com.ebay.mobile.myebay.MyEbayListFragmentBase.pendingRefresh", pendingRefresh);
        bundle.putInt("com.ebay.mobile.myebay.MyEbayListFragmentBase.requestedSpinnerAccess", currentList);
        bundle.putBoolean("com.ebay.mobile.myebay.MyEbayListFragmentBase.isSpinnerTriggeredByUser", isSpinnerTriggeredByUser);
    }

    public void onStart()
    {
        long l = getLastRefreshTime(getLastRefreshPrefsName());
        boolean flag;
        if (l != 0L && EbayResponse.currentHostTime() - 0x493e0L > l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldForceRefreshAtStartup = flag;
        super.onStart();
    }

    public void refreshView(Item item)
    {
label0:
        {
            if (recyclerAdapter == null)
            {
                break label0;
            }
            boolean flag = false;
            for (int i = 0; i < recyclerAdapter.getListCount();)
            {
                Object obj = recyclerAdapter.getList(i);
                boolean flag1 = flag;
                if (obj != null)
                {
                    flag1 = flag;
                    if (((com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section) (obj)).list != null)
                    {
                        obj = ((com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section) (obj)).list.iterator();
label1:
                        do
                        {
                            MyEbayListItem myebaylistitem;
label2:
                            {
                                flag1 = flag;
                                if (!((Iterator) (obj)).hasNext())
                                {
                                    break label1;
                                }
                                myebaylistitem = (MyEbayListItem)((Iterator) (obj)).next();
                                if (item.id != myebaylistitem.id)
                                {
                                    continue;
                                }
                                if (myebaylistitem.transaction != null)
                                {
                                    if (myebaylistitem.transaction.transactionId != null && myebaylistitem.transaction.transactionId.equals(String.valueOf(item.transactionId)))
                                    {
                                        if (myebaylistitem.transaction.feedbackLeft != item.feedbackLeft)
                                        {
                                            flag = true;
                                            myebaylistitem.transaction.feedbackLeft = item.feedbackLeft;
                                        }
                                        if (!TextUtils.equals(myebaylistitem.transaction.paidStatus, item.paidStatus))
                                        {
                                            myebaylistitem.transaction.paidStatus = item.paidStatus;
                                            flag = true;
                                        }
                                        boolean flag2 = userCache.isShipped(item.getIdString(), Long.toString(item.transactionId.longValue()));
                                        if (myebaylistitem.transaction.shipped != flag2)
                                        {
                                            myebaylistitem.transaction.shipped = flag2;
                                            flag = true;
                                        }
                                    }
                                    continue;
                                }
                                int j = item.bidCount;
                                String s = item.highBidderUserId;
                                flag1 = flag;
                                if (myebaylistitem.currentPrice != null)
                                {
                                    flag1 = flag;
                                    if (item.currentPrice != null)
                                    {
                                        flag1 = flag;
                                        if (!myebaylistitem.currentPrice.equals(item.currentPrice))
                                        {
                                            flag1 = true;
                                            myebaylistitem.currentPrice = item.currentPrice;
                                        }
                                    }
                                }
                                flag = flag1;
                                if (myebaylistitem.convertedCurrentPrice != null)
                                {
                                    flag = flag1;
                                    if (item.convertedCurrentPrice != null)
                                    {
                                        flag = flag1;
                                        if (!myebaylistitem.convertedCurrentPrice.equals(item.convertedCurrentPrice))
                                        {
                                            flag = true;
                                            myebaylistitem.convertedCurrentPrice = item.convertedCurrentPrice;
                                        }
                                    }
                                }
                                if (myebaylistitem.bidCount != j)
                                {
                                    flag = true;
                                    myebaylistitem.bidCount = j;
                                }
                                if (!TextUtils.isEmpty(myebaylistitem.highBidderId) || TextUtils.isEmpty(s))
                                {
                                    flag1 = flag;
                                    if (TextUtils.isEmpty(myebaylistitem.highBidderId))
                                    {
                                        break label2;
                                    }
                                    flag1 = flag;
                                    if (myebaylistitem.highBidderId.equals(s))
                                    {
                                        break label2;
                                    }
                                }
                                flag1 = true;
                                myebaylistitem.highBidderId = s;
                            }
                            flag = flag1;
                            if (myebaylistitem.watchCount != item.watchCount)
                            {
                                flag = true;
                                myebaylistitem.watchCount = item.watchCount;
                            }
                        } while (true);
                    }
                }
                i++;
                flag = flag1;
            }

            if (flag)
            {
                recyclerAdapter.notifyDataSetChanged();
            }
        }
    }

    protected void setDisplay(int i)
    {
    }

    protected void setDoneLoading()
    {
        safeSetListShown(true);
        setEditAvailability(isEditEnabled());
        setRefineAvailability(isRefineEnabled());
        pullToRefresh.setEnabled(true);
    }

    protected void setEmptyViewVisible(boolean flag, int i)
    {
        if (emptyStub != null && emptyView == null)
        {
            emptyStub.setLayoutResource(i);
            emptyView = emptyStub.inflate();
        }
        if (goShoppingButton == null)
        {
            goShoppingButton = emptyView.findViewById(0x7f1003ad);
            goShoppingButton.setOnClickListener(new android.view.View.OnClickListener() {

                final MyEbayListFragmentBase this$0;

                public void onClick(View view)
                {
                    view = getActivity();
                    Intent intent = new Intent(view, com/ebay/mobile/activities/eBay);
                    intent.putExtra("HomeStartChannelTab", ChannelEnum.SHOP);
                    startActivity(intent);
                    view.finish();
                }

            
            {
                this$0 = MyEbayListFragmentBase.this;
                super();
            }
            });
        }
    }

    public void setList(int i)
    {
        if (hasList(i))
        {
            initAdapter(i);
            setDisplay(i);
        }
    }

    protected void setListShown(boolean flag, boolean flag1)
    {
        if (flag)
        {
            progressContainer.setVisibility(8);
            mainContentContainer.setVisibility(0);
            return;
        } else
        {
            progressContainer.setVisibility(0);
            mainContentContainer.setVisibility(8);
            return;
        }
    }

    protected void setLoading()
    {
        safeSetListShown(false);
        setEditAvailability(false);
        setRefineAvailability(false);
        pullToRefresh.setEnabled(false);
    }

    protected void setLoadingInBackground()
    {
        safeSetListShown(false);
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag && dm != null && !isLoadCompleted)
        {
            setDisplay(currentList);
        }
    }

    protected void showDeletionFailedError(ResultStatus resultstatus)
    {
        resultstatus = getActivity();
        if (resultstatus != null)
        {
            Toast.makeText(resultstatus, 0x7f07014b, 1).show();
        }
    }

    protected abstract boolean supportsLoadMore(int i);

}
