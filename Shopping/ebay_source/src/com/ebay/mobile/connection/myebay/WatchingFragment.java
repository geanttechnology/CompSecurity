// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.ListSelector;
import com.ebay.mobile.common.SimpleRefineFragment;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.content.dm.MyEbayDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.UserDefinedList;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayListFragmentBase, MyEbayBaseRecyclerAdapter, WatchingRecyclerAdapter

public final class WatchingFragment extends MyEbayListFragmentBase
    implements com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Observer
{

    public static final int DISPLAY_MODE_ACTIVE_LIST = 1;
    public static final int DISPLAY_MODE_ENDED_LIST = 2;
    private static final String EXTRA_SORT_METHOD = "sort_method";
    public static final String PREFS_LAST_REFRESH = "LAST_REFRESH_WATCHING";
    public static final String PREFS_LIST_SELECTION = "LASTLIST_WATCHING";
    private int activeCount;
    private com.ebay.mobile.common.SimpleRefineFragment.Refinement activeFilter;
    private List activeItems;
    private List allItems;
    private com.ebay.mobile.common.SimpleRefineFragment.Refinement defaultRefinement;
    protected boolean editEnabled;
    private final int emptyResource = 0x7f030176;
    private int endedCount;
    private com.ebay.mobile.common.SimpleRefineFragment.Refinement endedFilter;
    private List endedItems;
    private List filterByRefinements;
    private String headerActive;
    private String headerEnded;
    protected boolean refineEnabled;
    private List sortByRefinements;
    private String sortMethod;

    public WatchingFragment()
    {
        filterByRefinements = null;
        sortByRefinements = null;
        activeCount = 0;
        endedCount = 0;
        editEnabled = true;
        refineEnabled = true;
        defaultRefinement = null;
        activeFilter = null;
        endedFilter = null;
    }

    public static WatchingFragment newInstance(int i)
    {
        WatchingFragment watchingfragment = new WatchingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("target_list", i);
        watchingfragment.setArguments(bundle);
        return watchingfragment;
    }

    private void populateList(List list, int i, String s)
    {
        int j = list.size();
        recyclerAdapter.setList(0, recyclerAdapter.newSection(i, s, list, j, j, j, 1, -1));
        recyclerAdapter.setList(1, recyclerAdapter.newSection(8, " ", null, 0, 0, 1, -1));
        i;
        JVM INSTR tableswitch 1 2: default 80
    //                   1 89
    //                   2 95;
           goto _L1 _L2 _L3
_L1:
        list = "all";
_L5:
        sendTracking(list);
        return;
_L2:
        list = "active";
        continue; /* Loop/switch isn't completed */
_L3:
        list = "ended";
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void sendTracking(String s)
    {
        TrackingData trackingdata = getBasePageImpression();
        trackingdata.addKeyValuePair("filterby", s);
        if (allItems != null)
        {
            trackingdata.addKeyValuePair("wi", String.valueOf(allItems.size()));
        }
        trackingdata.send(getActivity());
    }

    protected void deleteItems(List list)
    {
        if (list.size() == 0)
        {
            return;
        }
        setLoading();
        int j = list.size();
        EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[] = new EbayItemIdAndVariationSpecifics[j];
        for (int i = 0; i < j; i++)
        {
            aebayitemidandvariationspecifics[i] = new EbayItemIdAndVariationSpecifics((MyEbayListItem)list.get(i));
        }

        ((MyEbayWatchingDataManager)dm).removeFromWatchList(this, aebayitemidandvariationspecifics);
        ((MyEbayWatchingDataManager)dm).invalidateRelatedDataManagers();
    }

    public List getFilterByRefinements()
    {
        if (filterByRefinements == null)
        {
            filterByRefinements = new ArrayList();
            filterByRefinements.add(defaultRefinement);
            filterByRefinements.add(activeFilter);
            filterByRefinements.add(endedFilter);
        }
        return filterByRefinements;
    }

    protected String getLastRefreshPrefsName()
    {
        return "LAST_REFRESH_WATCHING";
    }

    protected String getListSelectionPrefsName()
    {
        return "LASTLIST_WATCHING";
    }

    protected MyEbayBaseRecyclerAdapter getRecyclerAdapter()
    {
        return new WatchingRecyclerAdapter(getBaseActivity(), this, 0x7f030175);
    }

    public List getSortByRefinements()
    {
        if (sortByRefinements == null)
        {
            Object obj = getActivity().getResources();
            sortByRefinements = new ArrayList();
            com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(((Resources) (obj)).getString(0x7f0708f1)) {

                final WatchingFragment this$0;

                public String getStringIdentifier()
                {
                    return com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.TimeLeft.toString();
                }

                public boolean isDefaultRefinement()
                {
                    return true;
                }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
            };
            sortByRefinements.add(refinement);
            refinement = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(((Resources) (obj)).getString(0x7f0708ed)) {

                final WatchingFragment this$0;

                public String getStringIdentifier()
                {
                    return com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.CurrentPrice.toString();
                }

                public boolean isDefaultRefinement()
                {
                    return false;
                }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
            };
            sortByRefinements.add(refinement);
            refinement = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(((Resources) (obj)).getString(0x7f0708ec)) {

                final WatchingFragment this$0;

                public String getStringIdentifier()
                {
                    return com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.CurrentPriceDescending.toString();
                }

                public boolean isDefaultRefinement()
                {
                    return false;
                }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
            };
            sortByRefinements.add(refinement);
            obj = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(((Resources) (obj)).getString(0x7f0708f2)) {

                final WatchingFragment this$0;

                public String getStringIdentifier()
                {
                    return com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.EndTimeDescending.toString();
                }

                public boolean isDefaultRefinement()
                {
                    return false;
                }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
            };
            sortByRefinements.add(obj);
        }
        return sortByRefinements;
    }

    protected SourceIdentification getSourceIdentification()
    {
        String s;
        if (currentList == 1)
        {
            s = "active";
        } else
        if (currentList == 2)
        {
            s = "ended";
        } else
        {
            s = "all";
        }
        return new SourceIdentification(getTrackingEventName(), "me", s);
    }

    protected String getTitleText(Resources resources)
    {
        return resources.getString(0x7f0700c4);
    }

    public String getTrackingEventName()
    {
        return "MyEbayWatching";
    }

    protected boolean hasList(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    protected void initAdapter(int i)
    {
        super.initAdapter(i);
        recyclerAdapter.setItemSelector(selectionModeHandler.getListItemSelector());
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            recyclerAdapter.setHeaderViewResource(0x7f030166);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(3, "", null, 0, 0, 0, -1));
            recyclerAdapter.add(recyclerAdapter.newSection(8, "", null, 0, 0, 0, -1));
            return;

        case 1: // '\001'
            recyclerAdapter.setHeaderViewResource(0x7f030177);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(1, headerActive, null, 0, 0, 0, -1));
            recyclerAdapter.add(recyclerAdapter.newSection(8, "", null, 0, 0, 0, -1));
            return;

        case 2: // '\002'
            recyclerAdapter.setHeaderViewResource(0x7f030177);
            break;
        }
        recyclerAdapter.setEmptyViewResource(0x7f03016a);
        recyclerAdapter.add(recyclerAdapter.newSection(2, headerEnded, null, 0, 0, 0, -1));
        recyclerAdapter.add(recyclerAdapter.newSection(8, "", null, 0, 0, 0, -1));
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
            setLoading();
            ((MyEbayWatchingDataManager)dm).forceReloadWatchList();
            return;
        }
    }

    protected boolean isEditEnabled()
    {
        return editEnabled;
    }

    protected boolean isRefineEnabled()
    {
        return refineEnabled;
    }

    public void onAddToWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        headerActive = getString(0x7f0700c0);
        headerEnded = getString(0x7f0700c1);
        defaultRefinement = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(getString(0x7f07055d)) {

            final WatchingFragment this$0;

            public String getStringIdentifier()
            {
                return "";
            }

            public boolean isDefaultRefinement()
            {
                return true;
            }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
        };
        activeFilter = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(getString(0x7f0700c0)) {

            final WatchingFragment this$0;

            public String getStringIdentifier()
            {
                return "active";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
        };
        endedFilter = new com.ebay.mobile.common.SimpleRefineFragment.Refinement(getString(0x7f0700c1)) {

            final WatchingFragment this$0;

            public String getStringIdentifier()
            {
                return "ended";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = WatchingFragment.this;
                super(s);
            }
        };
        if (bundle != null)
        {
            sortMethod = bundle.getString("sort_method");
        }
        initDataManagers();
    }

    protected View onCreateMainContentView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateMainContentView(layoutinflater, viewgroup, bundle);
        if (currentList == 1)
        {
            refineFragment.setCurrentFilterByRefinement(activeFilter);
            return layoutinflater;
        }
        if (currentList == 2)
        {
            refineFragment.setCurrentFilterByRefinement(endedFilter);
            return layoutinflater;
        } else
        {
            refineFragment.setCurrentFilterByRefinement(defaultRefinement);
            return layoutinflater;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (userDm.getCurrentUser() == null)
        {
            getActivity().finish();
        } else
        {
            dm = (MyEbayDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.KeyParams(userDm.getCurrentUser().user), this);
            if (!TextUtils.isEmpty(sortMethod))
            {
                ((MyEbayWatchingDataManager)dm).setSortMethod(com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.valueOf(sortMethod));
            }
            if (shouldForceRefreshAtStartup)
            {
                ((MyEbayWatchingDataManager)dm).forceReloadWatchList();
                shouldForceRefreshAtStartup = false;
            } else
            {
                ((MyEbayWatchingDataManager)dm).loadWatchList();
            }
            datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
            if (pendingRefresh)
            {
                invalidate();
                return;
            }
        }
    }

    public void onItemPressed(int i)
    {
        if (recyclerAdapter.getItemViewType(i) == 0)
        {
            MyEbayListItem myebaylistitem = (MyEbayListItem)recyclerAdapter.getItem(i);
            Intent intent = getIntentForItemSelected(myebaylistitem);
            intent.putExtra("item_view_from_my_ebay_or_reminders", true);
            intent.putExtra("com.ebay.mobile.tracking.BidSource", getBidSource());
            intent.putExtra("param_variation_values", myebaylistitem.nameValueList);
            intent.putExtra("com.ebay.mobile.analytics.sid", getSourceIdentification());
            intent.putExtra("ebay_list_item", myebaylistitem);
            ItemViewActivity.StartActivity(getActivity(), myebaylistitem.id, com.ebay.common.ConstantsCommon.ItemKind.Watched, intent);
        }
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        recyclerAdapter.notifyDataSetChanged();
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
    }

    public void onRefinementSelected(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement)
    {
        Object obj;
        byte byte0;
        obj = refinement.getStringIdentifier();
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 3: default 44
    //                   -1422950650: 143
    //                   0: 128
    //                   96651962: 157;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_157;
_L5:
        switch (byte0)
        {
        default:
            if (!TextUtils.equals(refinement.getStringIdentifier(), sortMethod))
            {
                setLoadingInBackground();
                obj = com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort.valueOf(refinement.getStringIdentifier());
                sortMethod = refinement.getStringIdentifier();
                ((MyEbayWatchingDataManager)dm).setSortMethod(((com.ebay.nautilus.domain.content.dm.MyEbayWatchingDataManager.Sort) (obj)));
                ((MyEbayWatchingDataManager)dm).loadWatchList();
            }
            return;

        case 0: // '\0'
            setDisplay(0);
            return;

        case 1: // '\001'
            setDisplay(1);
            return;

        case 2: // '\002'
            setDisplay(2);
            return;
        }
_L3:
        if (((String) (obj)).equals(""))
        {
            byte0 = 0;
        }
          goto _L5
_L2:
        if (((String) (obj)).equals("active"))
        {
            byte0 = 1;
        }
          goto _L5
        if (((String) (obj)).equals("ended"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public void onRemoveAllFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, ResultStatus resultstatus)
    {
    }

    public void onRemoveFromWatchListComplete(MyEbayWatchingDataManager myebaywatchingdatamanager, Content content)
    {
        myebaywatchingdatamanager = content.getStatus();
        if (!handleError(myebaywatchingdatamanager))
        {
            showDeletionFailedError(myebaywatchingdatamanager);
        }
        myebaywatchingdatamanager = new TrackingData("UnwatchItem", TrackingType.EVENT);
        myebaywatchingdatamanager.addKeyValuePair("action", "1");
        myebaywatchingdatamanager.send(getActivity());
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
    }

    public void onResetPressed(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement, com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement1)
    {
        onRefinementSelected(refinement1);
        onRefinementSelected(refinement);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (!TextUtils.isEmpty(sortMethod))
        {
            bundle.putString("sort_method", sortMethod);
        }
    }

    public void onWatchingListChanged(MyEbayWatchingDataManager myebaywatchingdatamanager, String s, DatedContent datedcontent)
    {
        boolean flag = true;
        if (isViewCreated() && !getActivity().isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        myebaywatchingdatamanager = (UserDefinedList)datedcontent.getData();
        ResultStatus resultstatus = datedcontent.getStatus();
        if (resultstatus.hasError())
        {
            handleError(resultstatus);
            return;
        }
        if (myebaywatchingdatamanager == null) goto _L1; else goto _L3
_L3:
        byte byte0;
        myebaywatchingdatamanager = ((UserDefinedList) (myebaywatchingdatamanager)).list;
        setLastRefreshTime(datedcontent.getLastUpdatedMillis(), getLastRefreshPrefsName());
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 112
    //                   -1422950650: 262
    //                   0: 292
    //                   96651962: 277;
           goto _L4 _L5 _L6 _L7
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            activeItems = myebaywatchingdatamanager;
            activeCount = myebaywatchingdatamanager.size();
            if (currentList == 1)
            {
                populateList(activeItems, 1, headerActive);
                if (activeCount == 0)
                {
                    setDisplay(0);
                    refineFragment.setCurrentFilterByRefinement(defaultRefinement);
                }
                setDoneLoading();
            }
            for (myebaywatchingdatamanager = getFilterByRefinements().iterator(); myebaywatchingdatamanager.hasNext();)
            {
                s = (com.ebay.mobile.common.SimpleRefineFragment.Refinement)myebaywatchingdatamanager.next();
                if ("".equals(s.getStringIdentifier()))
                {
                    s.updateTitleWithCount(activeCount + endedCount);
                } else
                if ("active".equals(s.getStringIdentifier()))
                {
                    s.updateTitleWithCount(activeCount);
                }
            }

            break; /* Loop/switch isn't completed */

        case 1: // '\001'
            endedItems = myebaywatchingdatamanager;
            endedCount = myebaywatchingdatamanager.size();
            if (currentList == 2)
            {
                populateList(endedItems, 2, headerEnded);
                if (endedCount == 0)
                {
                    setDisplay(0);
                    refineFragment.setCurrentFilterByRefinement(defaultRefinement);
                }
                setDoneLoading();
            }
            myebaywatchingdatamanager = getFilterByRefinements().iterator();
            do
            {
                if (!myebaywatchingdatamanager.hasNext())
                {
                    break;
                }
                s = (com.ebay.mobile.common.SimpleRefineFragment.Refinement)myebaywatchingdatamanager.next();
                if ("".equals(s.getStringIdentifier()))
                {
                    s.updateTitleWithCount(activeCount + endedCount);
                } else
                if ("ended".equals(s.getStringIdentifier()))
                {
                    s.updateTitleWithCount(endedCount);
                }
            } while (true);
            notifyRefineFragmentOfChange();
            return;

        case 2: // '\002'
            allItems = myebaywatchingdatamanager;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (s.equals("active"))
        {
            byte0 = 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (s.equals("ended"))
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (s.equals(""))
        {
            byte0 = 2;
        }
        if (true) goto _L4; else goto _L8
_L8:
        notifyRefineFragmentOfChange();
        return;
        if (currentList != 0) goto _L1; else goto _L9
_L9:
        populateList(allItems, 3, "");
        if (allItems.size() != 0)
        {
            flag = false;
        }
        setEmptyViewVisible(flag, 0x7f030176);
        setDoneLoading();
        return;
    }

    protected void setDisplay(int i)
    {
        if (dm != null)
        {
            super.setDisplay(i);
            currentList = i;
            if (getUserVisibleHint())
            {
                initAdapter(i);
                switch (i)
                {
                default:
                    return;

                case 0: // '\0'
                    populateList(allItems, 3, "");
                    return;

                case 1: // '\001'
                    populateList(activeItems, 1, headerActive);
                    return;

                case 2: // '\002'
                    populateList(endedItems, 2, headerEnded);
                    break;
                }
                return;
            }
        }
    }

    protected void setEmptyViewVisible(boolean flag, int i)
    {
label0:
        {
            boolean flag2 = true;
            super.setEmptyViewVisible(flag, i);
            if (emptyView != null)
            {
                boolean flag1;
                if (!flag)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                editEnabled = flag1;
                if (!flag)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
                refineEnabled = flag1;
                if (!flag)
                {
                    break label0;
                }
                emptyView.setVisibility(0);
                recyclerView.setVisibility(8);
                pullToRefresh.setVisibility(8);
            }
            return;
        }
        emptyView.setVisibility(8);
        recyclerView.setVisibility(0);
        pullToRefresh.setVisibility(0);
    }

    protected boolean supportsLoadMore(int i)
    {
        return false;
    }
}
