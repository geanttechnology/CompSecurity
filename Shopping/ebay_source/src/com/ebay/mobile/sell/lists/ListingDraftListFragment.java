// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.ListSelector;
import com.ebay.mobile.common.RefineContentFragment;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.sell.util.SellUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.SavedListingDraftDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            ListingDraftListItem, SellListAdapter

public final class ListingDraftListFragment extends RefineContentFragment
    implements SellListAdapter.OnItemClickListener, com.ebay.nautilus.domain.content.dm.SavedListingDraftDataManager.Observer, TrackingSupport
{

    protected static final int DIALOG_INVALID_DRAFT = 1;
    public static final String EXTRA_PENDING_REFRESH = "com.ebay.mobile.sell.lists.pendingRefresh";
    protected static final String KEY_LAYOUT_STATE = "layoutManagerState";
    protected SellListAdapter adapter;
    protected SavedListingDraftDataManager dm;
    protected TextView emptyView;
    private View errorLayout;
    protected boolean pendingRefresh;
    protected View progressView;
    protected RecyclerView recyclerView;
    protected SwipeRefreshLayout refreshLayout;
    protected Parcelable restoredState;
    protected UserContextDataManager userDm;

    public ListingDraftListFragment()
    {
    }

    private void setList(Content content)
    {
        if (isViewCreated() && getActivity() != null && !getActivity().isFinishing())
        {
            setListShown(true);
            Object obj = content.getStatus();
            if (((ResultStatus) (obj)).hasError())
            {
                handleError(((ResultStatus) (obj)));
                return;
            }
            obj = (List)content.getData();
            content = new ArrayList();
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); content.add(new ListingDraftListItem((ListingDraft)((Iterator) (obj)).next()))) { }
            if (content.size() == 0)
            {
                setEmptyListShown();
                adapter.clear();
                return;
            }
            if (adapter.getListCount() == 0)
            {
                adapter.add(adapter.newSection(0, "", content, content.size(), content.size(), -1, 1, -1));
                adapter.add(adapter.newSection(1, "", null, 0, 0, 1, -1));
            } else
            {
                adapter.setList(0, adapter.newSection(0, "", content, content.size(), content.size(), -1, 1, -1));
                adapter.setList(1, adapter.newSection(1, "", null, 0, 0, 1, -1));
            }
            if (restoredState != null)
            {
                recyclerView.getLayoutManager().onRestoreInstanceState(restoredState);
                restoredState = null;
                return;
            }
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

    protected void deleteItems(List list)
    {
        if (list == null)
        {
            return;
        }
        if (list.size() > 0)
        {
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList(list.size());
            ListingDraftListItem listingdraftlistitem;
            for (list = list.iterator(); list.hasNext(); arraylist.add(new com.ebay.nautilus.domain.content.dm.SavedListingDraftDataManager.DraftIdWithSite(listingdraftlistitem.siteId, listingdraftlistitem.id)))
            {
                listingdraftlistitem = (ListingDraftListItem)(Parcelable)list.next();
                arraylist1.add(listingdraftlistitem);
            }

            dm.deleteDraftsById(arraylist);
        }
        setListShown(false);
    }

    protected String getTitleText(Resources resources)
    {
        return resources.getString(0x7f07029d);
    }

    public String getTrackingEventName()
    {
        return "MyEbaySellingDrafts";
    }

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
        adapter = new SellListAdapter(getActivity(), 0x7f030228, 0x1020014, this, SellingListActivity.ListType.DRAFT);
        adapter.setLoadingViewResource(0x7f0301ac);
        adapter.setHeaderViewResource(0x7f03020d);
        adapter.setEmptyViewResource(0x7f03020c);
        adapter.setItemSelector(selectionModeHandler.getListItemSelector());
        recyclerView.setAdapter(adapter);
    }

    public void invalidate()
    {
        if (getView() == null || dm == null)
        {
            pendingRefresh = true;
        } else
        {
            pendingRefresh = false;
            clearSelectedItems();
            setListShown(false);
            if (dm != null)
            {
                dm.invalidateAndForceReloadData();
                return;
            }
        }
    }

    protected final boolean isViewCreated()
    {
        return emptyView != null;
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

    public void onContentChanged(Content content, com.ebay.nautilus.domain.content.dm.SavedListingDraftDataManager.DispatchType dispatchtype)
    {
        setList(content);
        if (dispatchtype == com.ebay.nautilus.domain.content.dm.SavedListingDraftDataManager.DispatchType.DELETE && content != null)
        {
            content = (List)content.getData();
            int i;
            if (content != null)
            {
                i = content.size();
            } else
            {
                i = 0;
            }
            content = new TrackingData("MyEbayItemRemove", TrackingType.EVENT);
            content.addKeyValuePair("draftitem", String.valueOf(i));
            content.send(getActivity());
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
        emptyView.setText(0x7f0703ad);
        errorLayout = layoutinflater.findViewById(0x7f10065f);
        errorLayout.findViewById(0x7f10022c).setOnClickListener(this);
        recyclerView = (RecyclerView)layoutinflater.findViewById(0x7f10065e);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        refreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final ListingDraftListFragment this$0;

            public void onRefresh()
            {
                refreshLayout.setRefreshing(false);
                invalidate();
            }

            
            {
                this$0 = ListingDraftListFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroyView()
    {
        adapter = null;
        super.onDestroyView();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (SavedListingDraftDataManager)datamanagercontainer.initialize(SavedListingDraftDataManager.KEY, this);
        if (pendingRefresh)
        {
            invalidate();
        }
    }

    public void onItemClicked(int i)
    {
        ListingDraftListItem listingdraftlistitem = (ListingDraftListItem)adapter.getItem(i);
        if (ListingCategoryFilters.categoryOkForNewListing(EbaySite.getInstanceFromId(listingdraftlistitem.siteId).id, listingdraftlistitem.categoryPath))
        {
            Intent intent = new Intent();
            intent.setClass(getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
            intent.putExtra("site", EbaySite.getInstanceFromId(listingdraftlistitem.siteId));
            intent.putExtra("draft_id", listingdraftlistitem.id);
            intent.putExtra("category_id", listingdraftlistitem.getLeafCategory());
            intent.putExtra("listing_mode", listingdraftlistitem.listingMode);
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
            startActivity(intent);
            return;
        } else
        {
            SellUtil.showInvalidDraftDialog(this, 1);
            return;
        }
    }

    public void onRefinementSelected(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement)
    {
    }

    public void onResetPressed(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement, com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement1)
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.ebay.mobile.sell.lists.pendingRefresh", pendingRefresh);
        bundle.putParcelable("layoutManagerState", recyclerView.getLayoutManager().onSaveInstanceState());
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
        initAdapter();
        if (bundle != null)
        {
            pendingRefresh = bundle.getBoolean("com.ebay.mobile.sell.lists.pendingRefresh");
            restoredState = bundle.getParcelable("layoutManagerState");
        }
        setListShown(false);
    }

    protected void setEmptyListShown()
    {
        recyclerView.setVisibility(0);
        progressView.setVisibility(8);
        emptyView.setVisibility(0);
        setEditAvailability(false);
        refreshLayout.setEnabled(true);
        errorLayout.setVisibility(8);
    }

    protected void setListShown(boolean flag)
    {
        boolean flag1 = false;
        Object obj = recyclerView;
        int i;
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
        setEditAvailability(flag);
        refreshLayout.setEnabled(flag);
        errorLayout.setVisibility(8);
    }
}
