// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.ListSelector;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.content.ListCountContent;
import com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager;
import com.ebay.nautilus.domain.content.dm.MyEbayDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Connector;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.connection.myebay:
//            MyEbayListFragmentBase, MyEbayBaseRecyclerAdapter, BuyingRecyclerAdapter

public final class BuyingFragment extends MyEbayListFragmentBase
    implements android.app.LoaderManager.LoaderCallbacks, android.widget.AdapterView.OnItemSelectedListener, com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, BuyingRecyclerAdapter.CountCallback, com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.Observer
{
    private static class BucksLoader extends AsyncTaskLoader
    {

        private final Authentication auth;
        private final EbayContext context;
        private Incentive eBayBucks;
        private ResultStatus status;

        public Incentive loadInBackground()
        {
            Object obj;
            Object obj1;
            obj1 = new com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesRequest(EbayApiUtil.getCartApi(getContext(), auth), com.ebay.common.net.api.cart.GetUserIncentives.UserIncentiveType.VOUCHER);
            obj = null;
            obj1 = (com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse)context.getConnector().sendRequest(((com.ebay.nautilus.kernel.net.Request) (obj1)));
            obj = obj1;
            status = ((com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse) (obj1)).getResultStatus();
            obj = obj1;
_L2:
label0:
            {
                if (obj == null || status == null || status.hasError())
                {
                    break label0;
                }
                obj = ((com.ebay.common.net.api.cart.GetUserIncentives.GetUserIncentivesResponse) (obj)).getUserIncentives();
                if (obj == null)
                {
                    break label0;
                }
                obj = ((UserIncentives) (obj)).incentives;
                if (obj == null || ((List) (obj)).size() <= 0)
                {
                    break label0;
                }
                obj = ((List) (obj)).iterator();
                Incentive incentive;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label0;
                    }
                    incentive = (Incentive)((Iterator) (obj)).next();
                } while (!incentive.discountType.equals("AMOUNT"));
                eBayBucks = incentive;
            }
            return eBayBucks;
            InterruptedException interruptedexception;
            interruptedexception;
            interruptedexception.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        protected void onStartLoading()
        {
            if (status != null && !status.hasError())
            {
                deliverResult(eBayBucks);
                return;
            } else
            {
                forceLoad();
                return;
            }
        }

        public BucksLoader(EbayContext ebaycontext, Authentication authentication)
        {
            super((Context)ebaycontext.getExtension(android/content/Context));
            context = ebaycontext;
            auth = authentication;
        }
    }

    private static class SpinnerAdapter extends ArrayAdapter
    {

        private final int dropDownResource;
        private final LayoutInflater inflater;
        private final int textColorPrimary;
        private final int textColorSecondary;

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = view;
            if (view == null)
            {
                view1 = inflater.inflate(dropDownResource, viewgroup, false);
            }
            view = (SpinnerItem)getItem(i);
            viewgroup = (TextView)view1.findViewById(0x1020014);
            viewgroup.setText(view.getDropDownString());
            if (((SpinnerItem) (view)).isSelected)
            {
                viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201c3, 0);
                viewgroup.setTextAppearance(getContext(), 0x7f0a0154);
                viewgroup.setTextColor(textColorPrimary);
                return view1;
            }
            if (!view.isEnabled())
            {
                viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                viewgroup.setTextAppearance(getContext(), 0x7f0a013f);
                viewgroup.setTextColor(textColorSecondary);
                return view1;
            } else
            {
                viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                viewgroup.setTextAppearance(getContext(), 0x7f0a013f);
                viewgroup.setTextColor(textColorPrimary);
                return view1;
            }
        }

        public boolean isEnabled(int i)
        {
            return ((SpinnerItem)getItem(i)).isEnabled();
        }

        public SpinnerAdapter(Context context, int i, int j, int k, List list)
        {
            super(context, i, j, list);
            setDropDownViewResource(k);
            inflater = LayoutInflater.from(context);
            dropDownResource = k;
            list = context.getResources();
            textColorPrimary = ThemeUtil.resolveThemeColor(list, context.getTheme(), 0x1010036);
            textColorSecondary = ThemeUtil.resolveThemeColor(list, context.getTheme(), 0x1010038);
        }
    }

    private static class SpinnerItem
    {

        int count;
        final int displayMode;
        final String displayText;
        boolean isSelected;
        final boolean showCount;

        public String getDropDownString()
        {
            if (showCount)
            {
                return (new StringBuilder()).append(displayText).append(" (").append(count).append(")").toString();
            } else
            {
                return displayText;
            }
        }

        public boolean isEnabled()
        {
            return !showCount || count > 0;
        }

        public String toString()
        {
            return displayText;
        }

        public SpinnerItem(String s)
        {
            this(s, -1, false);
        }

        public SpinnerItem(String s, int i, boolean flag)
        {
            displayText = s;
            displayMode = i;
            showCount = flag;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isSelected = flag;
            count = 0;
        }
    }


    private static final int BUCKS_LOADER_ID = 0;
    public static final int DISPLAY_MODE_BID = 1;
    public static final int DISPLAY_MODE_NOT_WON = 4;
    public static final int DISPLAY_MODE_OFFERS = 2;
    public static final int DISPLAY_MODE_WON = 3;
    private static final String EXPIRED = "expired";
    private static final String KEY_BID_SORT = "bidSort";
    private static final String KEY_LOAD_COUNTS = "loadCounts";
    private static final String KEY_NOT_WON_SORT = "notWonSort";
    private static final String KEY_OFFER_SORT = "offerSort";
    private static final int MAX_ITEMS_WHEN_SHOWING_ALL = 5;
    public static final String PREFS_LAST_REFRESH = "LAST_REFRESH_BUYING";
    public static final String PREFS_LIST_SELECTION = "LASTLIST_BUYING";
    private Incentive bucksIncentive;
    private String currentBidSort;
    private String currentNotWonSort;
    private String currentOfferSort;
    private final int emptyResource = 0x7f030167;
    private String headerAll;
    private String headerBids;
    private String headerDidntWin;
    private String headerOffers;
    private String headerPurchases;
    private int pageCounts[];
    private MyEbayListFragmentBase.RequestMonitor requestMonitor;
    private Spinner spinner;
    private SpinnerAdapter spinnerAdapter;
    private final List spinnerItems = new ArrayList(5);
    private TrackingData trackingData;

    public BuyingFragment()
    {
        pageCounts = new int[5];
    }

    private void addPriceSorts(List list, Resources resources)
    {
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708ed)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "CurrentPrice";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708ec)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "CurrentPriceDescending";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
    }

    private void addTimeEndedSorts(List list, Resources resources)
    {
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708ef)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "EndTimeDescending";
            }

            public boolean isDefaultRefinement()
            {
                return true;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708f0)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "EndTime";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
    }

    private void addTimeLeftSorts(List list, Resources resources)
    {
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708f1)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "TimeLeft";
            }

            public boolean isDefaultRefinement()
            {
                return true;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
        list.add(new com.ebay.mobile.common.SimpleRefineFragment.Refinement(resources.getString(0x7f0708f2)) {

            final BuyingFragment this$0;

            public String getStringIdentifier()
            {
                return "EndTimeDescending";
            }

            public boolean isDefaultRefinement()
            {
                return false;
            }

            
            {
                this$0 = BuyingFragment.this;
                super(s);
            }
        });
    }

    private int getDisplayModeForListType(int i)
    {
        switch (i)
        {
        default:
            return 0;

        case 4: // '\004'
            return 1;

        case 7: // '\007'
            return 2;

        case 5: // '\005'
            return 3;

        case 6: // '\006'
            return 4;
        }
    }

    private SpinnerItem getSpinnerItemForDisplayMode(int i)
    {
        for (Iterator iterator = spinnerItems.iterator(); iterator.hasNext();)
        {
            SpinnerItem spinneritem = (SpinnerItem)iterator.next();
            if (spinneritem.displayMode == i)
            {
                return spinneritem;
            }
        }

        return null;
    }

    private void initAllAdapterLists()
    {
        recyclerAdapter.setMoreViewResource(0x7f030170);
        recyclerAdapter.setHeaderViewResource(0x7f030168);
        recyclerAdapter.setEmptyViewResource(0x7f03016a);
        recyclerAdapter.add(recyclerAdapter.newSection(4, headerBids, null, 0, 0, 0, 5));
        recyclerAdapter.add(recyclerAdapter.newSection(7, headerOffers, null, 0, 0, 0, 5));
        recyclerAdapter.add(recyclerAdapter.newSection(5, headerPurchases, null, 0, 0, 0, 5));
        recyclerAdapter.add(recyclerAdapter.newSection(6, headerDidntWin, null, 0, 0, 0, 5));
        recyclerAdapter.add(recyclerAdapter.newSection(8, " ", null, 0, 0, 0, 5));
    }

    private boolean isEbayBucksEnabled()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        return dcshelper.getConfig().get(DcsBoolean.IncentivesVouchers) && dcshelper.isMecOrMec2Enabled(null);
    }

    public static BuyingFragment newInstance(int i)
    {
        BuyingFragment buyingfragment = new BuyingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("target_list", i);
        buyingfragment.setArguments(bundle);
        return buyingfragment;
    }

    private void onCountChanged(int i, int j)
    {
label0:
        {
            SpinnerItem spinneritem = getSpinnerItemForDisplayMode(j);
            if (spinneritem != null)
            {
                spinneritem.count = i;
                spinnerAdapter.notifyDataSetChanged();
            }
            if (currentList == 0)
            {
                recyclerAdapter.notifyDataSetChanged();
            }
            if (j == currentList && i == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0)
            {
                if (currentList != 0)
                {
                    break label0;
                }
                setEmptyViewVisible(true, 0x7f030167);
            }
            return;
        }
        spinner.setSelection(0);
    }

    private void refreshBid(int i)
    {
        if (requestMonitor == null)
        {
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
        }
        requestMonitor.addRequest(Integer.valueOf(1), i);
        ((MyEbayBuyingDataManager)dm).forceReloadBidList();
        ((MyEbayBuyingDataManager)dm).loadBidList(i);
    }

    private void refreshNotWon(int i)
    {
        if (requestMonitor == null)
        {
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
        }
        requestMonitor.addRequest(Integer.valueOf(4), i);
        ((MyEbayBuyingDataManager)dm).forceReloadNotWonList();
        ((MyEbayBuyingDataManager)dm).loadNotWonList(i);
    }

    private void refreshOffers(int i)
    {
        if (requestMonitor == null)
        {
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
        }
        requestMonitor.addRequest(Integer.valueOf(2), i);
        ((MyEbayBuyingDataManager)dm).forceReloadOffersList();
        ((MyEbayBuyingDataManager)dm).loadOffersList(i);
    }

    private void refreshWon(int i)
    {
        if (requestMonitor == null)
        {
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
        }
        requestMonitor.addRequest(Integer.valueOf(3), i);
        ((MyEbayBuyingDataManager)dm).forceReloadWonList();
        ((MyEbayBuyingDataManager)dm).loadWonList(i);
    }

    private void sendItemRemovalTracking(String s, Content content)
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

    private void sendTracking()
    {
        if (trackingData != null)
        {
            trackingData.send(getActivity());
            trackingData = null;
        }
    }

    private void setList(int i, ListContent listcontent, String s, int j)
    {
        if (isViewCreated()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ResultStatus resultstatus;
        int l;
        l = currentList;
        if (l == 0 || l == j)
        {
            resultstatus = listcontent.getStatus();
            if (!resultstatus.hasError() || requestMonitor != null)
            {
                break; /* Loop/switch isn't completed */
            }
            handleError(resultstatus);
        }
_L4:
        if (requestMonitor != null && requestMonitor.isCompleted())
        {
            sendTracking();
            onRequestMonitorCompleted(requestMonitor);
            requestMonitor = null;
            setDoneLoading();
            if (shouldShowEmptyView())
            {
                setEmptyViewVisible(true, 0x7f030167);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        List list;
        MyEbayBaseRecyclerAdapter myebaybaserecycleradapter;
        byte byte0;
        byte byte1;
        int k;
        int i1;
        int j1;
        int k1;
        if (l == 0)
        {
            k = j - 1;
            byte1 = 5;
            byte0 = 5;
        } else
        {
            k = 0;
            byte1 = -1;
            byte0 = 50;
        }
        i1 = listcontent.getTotalItemCount();
        onCountChanged(i1, j);
        list = listcontent.getList();
        j1 = listcontent.getUnfilteredItemsLoaded();
        k1 = listcontent.getPagesLoaded();
        pageCounts[j] = k1;
        listcontent = recyclerAdapter;
        myebaybaserecycleradapter = recyclerAdapter;
        if (resultstatus.hasError())
        {
            j = -1;
        } else
        {
            j = byte0;
        }
        listcontent.setList(k, myebaybaserecycleradapter.newSection(i, s, list, i1, j1, byte1, k1, j));
        if (requestMonitor != null && requestMonitor.isCompleted())
        {
            if (l == 0)
            {
                i = recyclerAdapter.getListCount() - 1;
            } else
            {
                i = k + 1;
            }
            recyclerAdapter.setList(i, recyclerAdapter.newSection(8, " ", null, 0, 0, 1, byte0));
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    private boolean shouldShowEmptyView()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (currentList == 0)
        {
            int j = 0;
            int l = recyclerAdapter.getListCount();
            for (int i = 0; i < l;)
            {
                List list = recyclerAdapter.getList(i).list;
                int k = j;
                if (list != null)
                {
                    k = j + list.size();
                }
                i++;
                j = k;
            }

            flag = flag1;
            if (j == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    private void updateRequestMonitor(ListContent listcontent, int i)
    {
        if (requestMonitor != null)
        {
            int j = listcontent.getHighestPageIndex();
            int k = listcontent.getPagesLoaded();
            int l = requestMonitor.getTargetPage(Integer.valueOf(i));
            if (k == j || k >= l || listcontent.getStatus().hasError())
            {
                requestMonitor.setCompleted(Integer.valueOf(i), listcontent.getStatus());
            }
        }
    }

    private void updateTrackingWithCount(String s, ListContent listcontent)
    {
        if (trackingData != null && listcontent != null)
        {
            trackingData.addKeyValuePair(s, String.valueOf(listcontent.getTotalItemCount()));
        }
    }

    protected void deleteItems(List list)
    {
        if (spinner != null)
        {
            spinner.setEnabled(true);
        }
        if (list.size() == 0)
        {
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add((MyEbayListItem)(Parcelable)list.next())) { }
        list = (MyEbayListItem[])arraylist.toArray(new MyEbayListItem[arraylist.size()]);
        switch (currentList)
        {
        default:
            return;

        case 3: // '\003'
            ((MyEbayBuyingDataManager)dm).removeFromWonList(this, list);
            ((MyEbayBuyingDataManager)dm).invalidateRelatedDataManagers();
            return;

        case 4: // '\004'
            ((MyEbayBuyingDataManager)dm).removeFromNotWonList(this, list);
            break;
        }
        ((MyEbayBuyingDataManager)dm).invalidateRelatedDataManagers();
    }

    protected boolean doesHeaderContainSpinner()
    {
        return true;
    }

    public int getCountForListType(int i)
    {
        SpinnerItem spinneritem = getSpinnerItemForDisplayMode(getDisplayModeForListType(i));
        if (spinneritem != null)
        {
            return spinneritem.count;
        } else
        {
            return 0;
        }
    }

    protected String getLastRefreshPrefsName()
    {
        return "LAST_REFRESH_BUYING";
    }

    protected String getListSelectionPrefsName()
    {
        return "LASTLIST_BUYING";
    }

    protected MyEbayBaseRecyclerAdapter getRecyclerAdapter()
    {
        String s;
        if (userDm != null && userDm.getCurrentUser() != null)
        {
            s = userDm.getCurrentUser().user;
        } else
        {
            s = null;
        }
        return new BuyingRecyclerAdapter(getBaseActivity(), this, s, 0x7f030169, this, bucksIncentive);
    }

    public List getSortByRefinements()
    {
        Resources resources = getActivity().getResources();
        switch (currentList)
        {
        case 3: // '\003'
        default:
            return null;

        case 1: // '\001'
            ArrayList arraylist = new ArrayList();
            addTimeLeftSorts(arraylist, resources);
            return arraylist;

        case 4: // '\004'
            ArrayList arraylist1 = new ArrayList();
            addTimeEndedSorts(arraylist1, resources);
            addPriceSorts(arraylist1, resources);
            return arraylist1;

        case 2: // '\002'
            ArrayList arraylist2 = new ArrayList();
            addTimeLeftSorts(arraylist2, resources);
            addPriceSorts(arraylist2, resources);
            return arraylist2;
        }
    }

    protected SourceIdentification getSourceIdentification()
    {
        currentList;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 56
    //                   2 77
    //                   3 70
    //                   4 63;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        String s = "all";
_L7:
        return new SourceIdentification(getTrackingEventName(), "me", s);
_L2:
        s = "bids";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "lost";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "purchases";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "offers";
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String getTrackingEventName()
    {
        return "MyEbayBuying";
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
        case 3: // '\003'
        case 4: // '\004'
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
            currentList = 0;
            initAllAdapterLists();
            return;

        case 0: // '\0'
            initAllAdapterLists();
            return;

        case 1: // '\001'
            recyclerAdapter.setHeaderViewResource(0x7f030166);
            recyclerAdapter.setLoadingViewResource(0x7f03016e);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(4, headerBids, null, 0, 0, 0, 50));
            recyclerAdapter.add(recyclerAdapter.newSection(8, " ", null, 0, 0, 0, 50));
            return;

        case 3: // '\003'
            recyclerAdapter.setHeaderViewResource(0x7f030166);
            recyclerAdapter.setLoadingViewResource(0x7f03016e);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(5, headerPurchases, null, 0, 0, 0, 50));
            recyclerAdapter.add(recyclerAdapter.newSection(8, " ", null, 0, 0, 0, 50));
            return;

        case 4: // '\004'
            recyclerAdapter.setHeaderViewResource(0x7f030166);
            recyclerAdapter.setLoadingViewResource(0x7f03016e);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(6, headerDidntWin, null, 0, 0, 0, 50));
            recyclerAdapter.add(recyclerAdapter.newSection(8, " ", null, 0, 0, 0, 50));
            return;

        case 2: // '\002'
            recyclerAdapter.setHeaderViewResource(0x7f030166);
            recyclerAdapter.setLoadingViewResource(0x7f03016e);
            recyclerAdapter.setEmptyViewResource(0x7f03016a);
            recyclerAdapter.add(recyclerAdapter.newSection(7, headerOffers, null, 0, 0, 0, 50));
            recyclerAdapter.add(recyclerAdapter.newSection(8, " ", null, 0, 0, 0, 50));
            return;
        }
    }

    public void invalidate()
    {
        if (getView() == null || dm == null)
        {
            pendingRefresh = true;
            return;
        }
        pendingRefresh = false;
        setLoading();
        switch (currentList)
        {
        default:
            return;

        case 0: // '\0'
            refreshBid(pageCounts[1]);
            refreshNotWon(pageCounts[4]);
            refreshWon(pageCounts[3]);
            refreshOffers(pageCounts[2]);
            return;

        case 1: // '\001'
            refreshBid(pageCounts[1]);
            return;

        case 4: // '\004'
            refreshNotWon(pageCounts[4]);
            return;

        case 2: // '\002'
            refreshOffers(pageCounts[2]);
            return;

        case 3: // '\003'
            refreshWon(pageCounts[3]);
            return;
        }
    }

    protected boolean isEditEnabled()
    {
        switch (currentList)
        {
        default:
            return false;

        case 3: // '\003'
        case 4: // '\004'
            return true;
        }
    }

    protected boolean isRefineEnabled()
    {
        switch (currentList)
        {
        case 3: // '\003'
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
            return true;
        }
    }

    public void onBiddingCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
        onCountChanged(listcountcontent.getTotalItemCount(), 1);
    }

    public void onBiddingListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        updateTrackingWithCount("bc", listcontent);
        updateRequestMonitor(listcontent, 1);
        setList(4, listcontent, headerBids, 1);
    }

    public void onBuyingOffersCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
        onCountChanged(listcountcontent.getTotalItemCount(), 2);
    }

    public void onBuyingOffersListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        updateTrackingWithCount("offers", listcontent);
        updateRequestMonitor(listcontent, 2);
        setList(7, listcontent, headerOffers, 2);
    }

    protected void onCancelPressed()
    {
        super.onCancelPressed();
        if (spinner != null)
        {
            spinner.setEnabled(true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        headerAll = getString(0x7f0700c2);
        headerBids = getString(0x7f0700b8);
        headerOffers = getString(0x7f0700b9);
        headerPurchases = getString(0x7f070644);
        headerDidntWin = getString(0x7f070643);
        spinnerItems.add(new SpinnerItem(headerAll, 0, false));
        spinnerItems.add(new SpinnerItem(headerBids, 1, true));
        spinnerItems.add(new SpinnerItem(headerOffers, 2, true));
        spinnerItems.add(new SpinnerItem(headerPurchases, 3, true));
        spinnerItems.add(new SpinnerItem(headerDidntWin, 4, true));
        if (bundle != null)
        {
            pageCounts = bundle.getIntArray("loadCounts");
            currentBidSort = bundle.getString("bidSort", "TimeLeft");
            currentOfferSort = bundle.getString("offerSort", "TimeLeft");
            currentNotWonSort = bundle.getString("notWonSort", "EndTimeDescending");
        } else
        {
            currentOfferSort = "TimeLeft";
            currentBidSort = "TimeLeft";
            currentNotWonSort = "EndTimeDescending";
        }
        trackingData = null;
        initDataManagers();
        if (isEbayBucksEnabled())
        {
            getLoaderManager().initLoader(0, null, this);
        }
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new BucksLoader(getBaseActivity().getEbayContext(), userDm.getCurrentUser());
    }

    protected void onEditPressed()
    {
        super.onEditPressed();
        if (spinner != null)
        {
            spinner.setEnabled(false);
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
            dm = (MyEbayDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.MyEbayBuyingDataManager.KeyParams(userDm.getCurrentUser().user), this);
            ((MyEbayBuyingDataManager)dm).setDefaultSorts(currentBidSort, currentOfferSort, currentNotWonSort);
            datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
            if (pendingRefresh || shouldForceRefreshAtStartup)
            {
                invalidate();
                shouldForceRefreshAtStartup = false;
                setLastRefreshTime(EbayResponse.currentHostTime(), "LAST_REFRESH_BUYING");
            }
            if (getLastRefreshTime("LAST_REFRESH_BUYING") == 0L)
            {
                setLastRefreshTime(EbayResponse.currentHostTime(), "LAST_REFRESH_BUYING");
            }
            if (requestMonitor == null)
            {
                setDisplay(currentList);
                return;
            }
        }
    }

    protected void onInitializeSpinner(Spinner spinner1)
    {
        spinner = spinner1;
        spinnerAdapter = new SpinnerAdapter(getActivity(), 0x7f030174, 0x1020014, 0x7f03016b, spinnerItems);
        for (Iterator iterator = spinnerItems.iterator(); iterator.hasNext();)
        {
            ((SpinnerItem)iterator.next()).isSelected = false;
        }

        SpinnerItem spinneritem = getSpinnerItemForDisplayMode(currentList);
        if (spinneritem != null)
        {
            spinneritem.isSelected = true;
        }
        spinner1.setAdapter(spinnerAdapter);
        if (!getActivity().getResources().getBoolean(0x7f0b0006))
        {
            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            spinner1.setDropDownWidth(point.x);
        }
        spinner1.setSelection(currentList, false);
        spinner1.setOnItemSelectedListener(this);
    }

    public void onItemPressed(int i)
    {
        int j;
        int k;
        j = recyclerAdapter.getItemViewType(i);
        k = recyclerAdapter.getListIndexFromItemPosition(i);
        if (j != 3) goto _L2; else goto _L1
_L1:
        i = getDisplayModeForListType(recyclerAdapter.getList(k).listType);
        initAdapter(i);
        setDisplay(i);
        if (spinner != null)
        {
            spinner.setSelection(i);
            for (Iterator iterator = spinnerItems.iterator(); iterator.hasNext();)
            {
                ((SpinnerItem)iterator.next()).isSelected = false;
            }

            ((SpinnerItem)spinner.getItemAtPosition(i)).isSelected = true;
            spinnerAdapter.notifyDataSetChanged();
        }
_L4:
        return;
_L2:
        if (j != 0) goto _L4; else goto _L3
_L3:
        com.ebay.common.ConstantsCommon.ItemKind itemkind;
        String s;
        String s1;
        MyEbayListItem myebaylistitem;
        Intent intent;
        myebaylistitem = (MyEbayListItem)recyclerAdapter.getItem(i);
        intent = getIntentForItemSelected(myebaylistitem);
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Unknown;
        s = getBidSource();
        i = recyclerAdapter.getList(k).listType;
        s1 = null;
        i;
        JVM INSTR tableswitch 4 7: default 208
    //                   4 246
    //                   5 289
    //                   6 253
    //                   7 262;
           goto _L5 _L6 _L7 _L8 _L9
_L5:
        intent.putExtra("com.ebay.mobile.tracking.BidSource", s);
        intent.putExtra("com.ebay.mobile.analytics.sid", getSourceIdentification());
        ItemViewActivity.StartActivityFromMEB(getActivity(), myebaylistitem, s1, itemkind, intent);
        return;
_L6:
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
        continue; /* Loop/switch isn't completed */
_L8:
        s = null;
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Lost;
        continue; /* Loop/switch isn't completed */
_L9:
        if ("expired".equalsIgnoreCase(myebaylistitem.bestOfferStatus))
        {
            itemkind = com.ebay.common.ConstantsCommon.ItemKind.Found;
        } else
        {
            itemkind = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        s = null;
        itemkind = com.ebay.common.ConstantsCommon.ItemKind.Won;
        s1 = myebaylistitem.transaction.transactionId;
        if (true) goto _L5; else goto _L10
_L10:
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (i == currentList)
        {
            return;
        }
        for (view = spinnerItems.iterator(); view.hasNext();)
        {
            ((SpinnerItem)view.next()).isSelected = false;
        }

        ((SpinnerItem)adapterview.getItemAtPosition(i)).isSelected = true;
        spinnerAdapter.notifyDataSetChanged();
        initAdapter(i);
        setDisplay(i);
    }

    public void onLoadFinished(Loader loader, Incentive incentive)
    {
        bucksIncentive = incentive;
        ((BuyingRecyclerAdapter)recyclerAdapter).setBucksContent(incentive);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Incentive)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public void onNotWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
        onCountChanged(listcountcontent.getTotalItemCount(), 4);
    }

    public void onNotWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        updateTrackingWithCount("lost", listcontent);
        updateRequestMonitor(listcontent, 4);
        setList(6, listcontent, headerDidntWin, 4);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
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
        refinement = refinement.getStringIdentifier();
        switch (currentList)
        {
        case 3: // '\003'
        default:
            return;

        case 1: // '\001'
            setLoadingInBackground();
            ((MyEbayBuyingDataManager)dm).setBidSort(refinement);
            refreshBid(pageCounts[1]);
            return;

        case 4: // '\004'
            setLoadingInBackground();
            ((MyEbayBuyingDataManager)dm).setNotWonSort(refinement);
            refreshNotWon(pageCounts[4]);
            return;

        case 2: // '\002'
            setLoadingInBackground();
            ((MyEbayBuyingDataManager)dm).setOfferSort(refinement);
            refreshOffers(pageCounts[4]);
            return;
        }
    }

    public void onRemoveFromNotWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
        myebaybuyingdatamanager = content.getStatus();
        if (myebaybuyingdatamanager.hasError())
        {
            showDeletionFailedError(myebaybuyingdatamanager);
        }
        sendItemRemovalTracking("lostitem", content);
        invalidate();
    }

    public void onRemoveFromWonListComplete(MyEbayBuyingDataManager myebaybuyingdatamanager, Content content)
    {
        myebaybuyingdatamanager = content.getStatus();
        if (myebaybuyingdatamanager.hasError())
        {
            showDeletionFailedError(myebaybuyingdatamanager);
        }
        sendItemRemovalTracking("paiditem", content);
        invalidate();
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        switch (section.listType)
        {
        default:
            return;

        case 4: // '\004'
            ((MyEbayBuyingDataManager)dm).loadBidList(j);
            return;

        case 7: // '\007'
            ((MyEbayBuyingDataManager)dm).loadOffersList(j);
            return;

        case 5: // '\005'
            ((MyEbayBuyingDataManager)dm).loadWonList(j);
            return;

        case 6: // '\006'
            ((MyEbayBuyingDataManager)dm).loadNotWonList(j);
            return;
        }
    }

    public void onResetPressed(com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement, com.ebay.mobile.common.SimpleRefineFragment.Refinement refinement1)
    {
        onRefinementSelected(refinement);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putIntArray("loadCounts", pageCounts);
        bundle.putString("bidSort", currentBidSort);
        bundle.putString("offerSort", currentOfferSort);
        bundle.putString("notWonSort", currentNotWonSort);
    }

    public void onWonCountChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListCountContent listcountcontent)
    {
        onCountChanged(listcountcontent.getTotalItemCount(), 3);
    }

    public void onWonListChanged(MyEbayBuyingDataManager myebaybuyingdatamanager, ListContent listcontent)
    {
        updateTrackingWithCount("purchases", listcontent);
        updateRequestMonitor(listcontent, 3);
        setList(5, listcontent, headerPurchases, 3);
    }

    protected void setDisplay(int i)
    {
        super.setDisplay(i);
        currentList = i;
        clearRefinePanelAndRequery();
        if (!getUserVisibleHint())
        {
            return;
        }
        trackingData = getBasePageImpression();
        switch (currentList)
        {
        default:
            return;

        case 0: // '\0'
            trackingData.addKeyValuePair("dd", "all");
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
            requestMonitor.addRequest(Integer.valueOf(1));
            requestMonitor.addRequest(Integer.valueOf(4));
            requestMonitor.addRequest(Integer.valueOf(3));
            requestMonitor.addRequest(Integer.valueOf(2));
            ((MyEbayBuyingDataManager)dm).setObserving(this, true, true, true, true, true);
            return;

        case 1: // '\001'
            trackingData.addKeyValuePair("dd", "bids");
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
            requestMonitor.addRequest(Integer.valueOf(1));
            ((MyEbayBuyingDataManager)dm).setObserving(this, true, true, false, false, false);
            return;

        case 3: // '\003'
            trackingData.addKeyValuePair("dd", "purchases");
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
            requestMonitor.addRequest(Integer.valueOf(3));
            ((MyEbayBuyingDataManager)dm).setObserving(this, true, false, true, false, false);
            return;

        case 4: // '\004'
            trackingData.addKeyValuePair("dd", "lost");
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
            requestMonitor.addRequest(Integer.valueOf(4));
            ((MyEbayBuyingDataManager)dm).setObserving(this, true, false, false, true, false);
            return;

        case 2: // '\002'
            trackingData.addKeyValuePair("dd", "offers");
            requestMonitor = new MyEbayListFragmentBase.RequestMonitor();
            requestMonitor.addRequest(Integer.valueOf(2));
            ((MyEbayBuyingDataManager)dm).setObserving(this, true, false, false, false, true);
            return;
        }
    }

    protected void setEmptyViewVisible(boolean flag, int i)
    {
label0:
        {
            super.setEmptyViewVisible(flag, i);
            if (emptyView != null)
            {
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
        return true;
    }
}
