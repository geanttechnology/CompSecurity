// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.ListSelector;
import com.ebay.mobile.common.RefineContentFragment;
import com.ebay.mobile.common.SimpleRefineFragment;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellingListRefinement;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListAdapter

public abstract class SellListBaseFragment extends RefineContentFragment
    implements com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, SellListAdapter.OnItemClickListener, com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.OnRequestMoreListener, com.ebay.nautilus.domain.content.dm.MyEbaySellingDataManager.Observer, TrackingSupport
{

    public static final String EXTRA_PENDING_REFRESH = "com.ebay.mobile.sell.lists.pendingRefresh";
    protected static final String KEY_LAYOUT_STATE = "layoutManagerState";
    protected static final String KEY_RESTORE_PAGE_COUNT = "restore_page_count";
    protected static final String KEY_SELECTED_REFINEMENT = "selected_refinement";
    private static final int LOAD_MORE_OFFSET = 25;
    protected static final long REFRESH_INTERVAL = 0x493e0L;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("SellListBaseFragment", 3, "Log Dest Base");
    protected SellListAdapter adapter;
    protected MyEbaySellingDataManager dm;
    protected TextView emptyView;
    private View errorLayout;
    protected int pageLoaded;
    protected boolean pendingRefresh;
    protected View progressView;
    protected RecyclerView recyclerView;
    protected List refinements;
    protected SwipeRefreshLayout refreshLayout;
    protected int restorePage;
    protected Parcelable restoredState;
    protected SellingListRefinement sellingListRefinement;
    protected UserContextDataManager userDm;

    public SellListBaseFragment()
    {
        pageLoaded = -1;
        restorePage = -1;
    }

    private void applyRefinement()
    {
        restorePage = -1;
        pageLoaded = -1;
        restoredState = null;
        setListShown(false);
        recyclerView.getLayoutManager().scrollToPosition(0);
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.EVENT);
        addFilterTracking(trackingdata);
        trackingdata.send(getActivity());
        dm.doRefine(this, sellingListRefinement);
    }

    private void sendItemRemovalTracking(String s, Content content)
    {
        if (content != null)
        {
            content = (MyEbayListItem[])content.getData();
            int i;
            if (content != null)
            {
                i = content.length;
            } else
            {
                i = 0;
            }
            content = new TrackingData("MyEbayItemRemove", TrackingType.EVENT);
            content.addKeyValuePair(s, String.valueOf(i));
            content.send(getActivity());
        }
    }

    private void showError(ResultStatus resultstatus)
    {
        setRefineAvailability(false);
        setEditAvailability(false);
        refreshLayout.setEnabled(false);
        recyclerView.setVisibility(8);
        progressView.setVisibility(8);
        emptyView.setVisibility(8);
        errorLayout.setVisibility(0);
        View view = errorLayout.findViewById(0x7f10022c);
        if (NetworkUtil.isConnectionError(resultstatus))
        {
            view.setVisibility(0);
            return;
        } else
        {
            view.setVisibility(8);
            return;
        }
    }

    public void addFilterTracking(TrackingData trackingdata)
    {
        if (sellingListRefinement != null && trackingdata != null)
        {
            trackingdata.addKeyValuePair("filterby", SellingListRefinement.getTrackingFilterName(sellingListRefinement.filter));
        }
    }

    protected abstract SellListAdapter getAdapter();

    protected abstract int getEmptyStateTextResource();

    protected abstract com.ebay.common.ConstantsCommon.ItemKind getItemKind();

    protected int getLayoutResource()
    {
        return 0x7f030228;
    }

    protected String getRefinementTitle(String s)
    {
        return "";
    }

    protected abstract SourceIdentification getSourceIdentification();

    protected boolean handleError(ResultStatus resultstatus)
    {
        setListShown(false);
        if (resultstatus.getFirstError() != null)
        {
            if (errorLayout.getVisibility() != 0)
            {
                showError(resultstatus);
            }
            return false;
        } else
        {
            return true;
        }
    }

    protected void initAdapter()
    {
        adapter = getAdapter();
        if (adapter == null)
        {
            return;
        } else
        {
            adapter.setLoadingViewResource(0x7f0301ac);
            adapter.setHeaderViewResource(0x7f03020d);
            adapter.setOnRequestMoreListener(this);
            adapter.setEmptyViewResource(0x7f03020c);
            adapter.setItemSelector(selectionModeHandler.getListItemSelector());
            recyclerView.setAdapter(adapter);
            return;
        }
    }

    public void invalidate()
    {
        if (getView() == null || dm == null)
        {
            pendingRefresh = true;
            return;
        } else
        {
            pendingRefresh = false;
            restorePage = -1;
            pageLoaded = -1;
            restoredState = null;
            clearSelectedItems();
            setListShown(false);
            return;
        }
    }

    protected boolean isEditEnabled()
    {
        return false;
    }

    protected boolean isRefineEnabled()
    {
        return false;
    }

    protected final boolean isViewCreated()
    {
        return emptyView != null;
    }

    public void onActiveCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onActiveCountChanged");
        }
    }

    public void onActiveListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onActiveListChanged");
        }
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f10022c)
        {
            errorLayout.setVisibility(8);
            invalidate();
            return;
        } else
        {
            super.onClick(view);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        userDm = (UserContextDataManager)UserContextDataManager.get(getBaseActivity().getEbayContext(), UserContextDataManager.KEY);
        if (userDm.getCurrentUser() == null)
        {
            getActivity().finish();
            return;
        } else
        {
            initDataManagers();
            return;
        }
    }

    public View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03020a, viewgroup, false);
        progressView = layoutinflater.findViewById(0x7f1000ca);
        refreshLayout = (SwipeRefreshLayout)layoutinflater.findViewById(0x7f1002e1);
        emptyView = (TextView)layoutinflater.findViewById(0x7f10065d);
        errorLayout = layoutinflater.findViewById(0x7f10065f);
        errorLayout.findViewById(0x7f10022c).setOnClickListener(this);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f10065e);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final SellListBaseFragment this$0;

            public void onRefresh()
            {
                refreshLayout.setRefreshing(false);
                invalidate();
            }

            
            {
                this$0 = SellListBaseFragment.this;
                super();
            }
        });
        initAdapter();
        if (bundle != null)
        {
            pendingRefresh = bundle.getBoolean("com.ebay.mobile.sell.lists.pendingRefresh");
            restoredState = bundle.getParcelable("layoutManagerState");
            sellingListRefinement = (SellingListRefinement)bundle.getParcelable("selected_refinement");
            restorePage = bundle.getInt("restore_page_count");
        }
        recyclerView.setVisibility(8);
        progressView.setVisibility(0);
        emptyView.setVisibility(8);
        errorLayout.setVisibility(8);
        if (sellingListRefinement != null && !sellingListRefinement.isDefault())
        {
            viewgroup = refineFragment.getCurrentFilterByRefinement();
            if (viewgroup != null && !viewgroup.getStringIdentifier().equals(sellingListRefinement.filter))
            {
                viewgroup = refinements.iterator();
                do
                {
                    if (!viewgroup.hasNext())
                    {
                        break;
                    }
                    bundle = (com.ebay.mobile.common.SimpleRefineFragment.Refinement)viewgroup.next();
                    if (bundle.getStringIdentifier().equals(sellingListRefinement.filter))
                    {
                        refineFragment.setCurrentFilterByRefinement(bundle);
                    }
                } while (true);
            }
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        adapter = null;
        super.onDestroyView();
    }

    public void onFilteredListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent, SellingListRefinement sellinglistrefinement)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onFilteredListChanged");
        }
        if (sellingListRefinement != null && sellinglistrefinement != null && sellinglistrefinement.filter.equals(sellingListRefinement.filter))
        {
            setList(listcontent, sellinglistrefinement);
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (userDm.getCurrentUser() == null)
        {
            getActivity().finish();
        }
        setListShown(false);
    }

    public void onItemClicked(int i)
    {
        Intent intent = new Intent();
        MyEbayListItem myebaylistitem = (MyEbayListItem)adapter.getItem(i);
        intent.putExtra("com.ebay.mobile.analytics.sid", getSourceIdentification());
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
        intent.putExtra("item_view_from_my_ebay_or_reminders", true);
        Activity activity = getActivity();
        String s;
        if (myebaylistitem.transaction != null)
        {
            s = myebaylistitem.transaction.transactionId;
        } else
        {
            s = null;
        }
        ItemViewActivity.StartActivityFromMEB(activity, myebaylistitem, s, getItemKind(), intent);
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRateChanged");
        }
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRateLoadCompleted");
        }
    }

    public void onRefinementSelected(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRefinementSelected");
        }
        sellingListRefinement.filter = refinement.getStringIdentifier();
        applyRefinement();
    }

    public void onRemoveFromSoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRemoveFromSoldListCompleted");
        }
        sendItemRemovalTracking("solditem", content);
    }

    public void onRemoveFromUnsoldListComplete(MyEbaySellingDataManager myebaysellingdatamanager, Content content)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRemoveFromUnsoldListCompelted");
        }
        sendItemRemovalTracking("unsolditem", content);
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onRequestMore");
        }
    }

    public void onResetPressed(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement, com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement1)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onResetPressed");
        }
        sellingListRefinement.resetDefault();
        applyRefinement();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.ebay.mobile.sell.lists.pendingRefresh", pendingRefresh);
        bundle.putParcelable("selected_refinement", sellingListRefinement);
        Parcelable parcelable;
        int i;
        if (restoredState == null)
        {
            parcelable = recyclerView.getLayoutManager().onSaveInstanceState();
        } else
        {
            parcelable = restoredState;
        }
        restoredState = parcelable;
        bundle.putParcelable("layoutManagerState", restoredState);
        if (restorePage == -1)
        {
            i = pageLoaded;
        } else
        {
            i = restorePage;
        }
        restorePage = i;
        bundle.putInt("restore_page_count", restorePage);
    }

    public void onScheduledCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onScheduledCountChanged");
        }
    }

    public void onScheduledListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onScheduldedListChanged");
        }
    }

    public void onSoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onSoldCountChanged");
        }
    }

    public void onSoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onSoldListChanged");
        }
    }

    public void onUnsoldCountChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListCountContent listcountcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onUnsoldCountChanged");
        }
    }

    public void onUnsoldListChanged(MyEbaySellingDataManager myebaysellingdatamanager, ListContent listcontent)
    {
        if (logTag.isLoggable)
        {
            logTag.log("onUnsoldListChanged");
        }
    }

    protected void setEmptyListShown()
    {
        setEditAvailability(false);
        com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement = refineFragment.getCurrentFilterByRefinement();
        if (refinement == null || refinement.isDefaultRefinement())
        {
            closeRefinePanel();
            setRefineAvailability(false);
        } else
        {
            setRefineAvailability(isRefineEnabled());
        }
        recyclerView.setVisibility(0);
        refreshLayout.setEnabled(true);
        progressView.setVisibility(8);
        emptyView.setVisibility(0);
        emptyView.setText(getEmptyStateTextResource());
        errorLayout.setVisibility(8);
    }

    protected void setList(ListContent listcontent, SellingListRefinement sellinglistrefinement)
    {
        pageLoaded = listcontent.getPagesLoaded();
        if (isViewCreated() && getActivity() != null && !getActivity().isFinishing() && restorePage <= pageLoaded)
        {
            Object obj = listcontent.getStatus();
            if (((ResultStatus) (obj)).hasError())
            {
                handleError(((ResultStatus) (obj)));
                return;
            }
            obj = listcontent.getList();
            if (obj != null && ((List) (obj)).size() == 0)
            {
                setEmptyListShown();
                adapter.clear();
                return;
            }
            int i = listcontent.getTotalLoadableItemCount();
            int j = listcontent.getUnfilteredItemsLoaded();
            int k = listcontent.getPagesLoaded();
            boolean flag;
            if (sellinglistrefinement != null && !sellinglistrefinement.isDefault())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            setListShown(true);
            if (adapter.getListCount() == 0)
            {
                SellListAdapter selllistadapter = adapter;
                SellListAdapter selllistadapter2 = adapter;
                if (flag)
                {
                    listcontent = getRefinementTitle(sellinglistrefinement.filter);
                } else
                {
                    listcontent = "";
                }
                selllistadapter.add(selllistadapter2.newSection(0, listcontent, ((List) (obj)), i, j, -1, k, 25));
                adapter.add(adapter.newSection(1, "", null, 0, 0, 1, 25));
            } else
            {
                SellListAdapter selllistadapter1 = adapter;
                SellListAdapter selllistadapter3 = adapter;
                if (flag)
                {
                    listcontent = getRefinementTitle(sellinglistrefinement.filter);
                } else
                {
                    listcontent = "";
                }
                selllistadapter1.setList(0, selllistadapter3.newSection(0, listcontent, ((List) (obj)), i, j, -1, k, 25));
                adapter.setList(1, adapter.newSection(1, "", null, 0, 0, 1, 25));
            }
            if (restoredState != null && restorePage <= pageLoaded)
            {
                recyclerView.getLayoutManager().onRestoreInstanceState(restoredState);
                restoredState = null;
                restorePage = -1;
                return;
            }
        }
    }

    protected void setListShown(boolean flag)
    {
        boolean flag3 = true;
        boolean flag1 = false;
        Object obj;
        int i;
        boolean flag2;
        if (flag && isRefineEnabled())
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        setRefineAvailability(flag2);
        if (flag && isEditEnabled())
        {
            flag2 = flag3;
        } else
        {
            flag2 = false;
        }
        setEditAvailability(flag2);
        refreshLayout.setEnabled(flag);
        obj = recyclerView;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((RecyclerView) (obj)).setVisibility(i);
        obj = progressView;
        i = ((flag1) ? 1 : 0);
        if (flag)
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        emptyView.setVisibility(8);
        errorLayout.setVisibility(8);
    }

}
