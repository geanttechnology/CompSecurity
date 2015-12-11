// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.groupon.Channel;
import com.groupon.abtest.BadgesAbTestHelper;
import com.groupon.abtest.MerchantSpecialsAbTestHelper;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.DealClickListener;
import com.groupon.adapter.ImagePrefetchAdapterHelper;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.AbstractDeal;
import com.groupon.db.models.Badge;
import com.groupon.db.models.Business;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.Pagination;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.SearchSyncManager;
import com.groupon.mapview.DealsMapView;
import com.groupon.models.EndlessList;
import com.groupon.models.Place;
import com.groupon.models.country.Country;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.MerchantPageMerchantIdMetadata;
import com.groupon.service.DealTypeService;
import com.groupon.service.LocationService;
import com.groupon.service.SearchHelper;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.BuyUtils;
import com.groupon.util.CollectionUtils;
import com.groupon.util.DealCardListUtils;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.DealUtils;
import com.groupon.util.GeoPoint;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MergeAdapter;
import com.groupon.util.SearchServiceInterface;
import com.groupon.view.BusinessExactMatchCardView;
import com.groupon.view.BusinessNonExactMatchCardListView;
import com.groupon.view.HasImageView;
import com.groupon.view.SpinnerButton;
import com.groupon.view.dealcards.DealCardBase;
import com.groupon.view.dealcards.DefaultLargeDealCard;
import com.groupon.view.dealcards.DefaultSmallDealCard;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.adapter.JavaAdapter;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.event.UpdateEvent;
import commonlib.manager.PaginatedSyncManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment, DealCardEndlessAdapter, BaseCardListFragment, DealCardListLoader, 
//            DealSummaryListLoaderCallbacks

public class GlobalSearchResultFragment extends DealCardListFragment
    implements DealClickListener, SearchServiceInterface
{
    protected static class AllDealsFragmentDealSummaryListLoader extends DealCardListLoader
    {

        private AbTestService abTestService;
        private DaoBusiness businessDao;
        private DealCardListUtils dealCardListUtils;
        private int firstPageSize;
        private GlobalSearchResultFragment globalSearchResultFragment;
        private boolean isShowExactMatchMerchant1410USCAmatchAbove;
        private boolean isShowExactMatchMerchant1410USCAmatchBelow;
        private boolean isShowExactMatchMerchant1410USCAmatchNoDeals;
        private MerchantSpecialsAbTestHelper merchantSpecialsAbTestHelper;
        private boolean merchantSpecialsEnabledDivisions;
        private String otherDealChannel;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            Object obj;
            ArrayList arraylist;
            Pagination pagination;
            int l;
            if (globalSearchResultFragment.dataState == 0)
            {
                return null;
            }
            Object obj1;
            DealSubsetAttribute dealsubsetattribute;
            Object obj2;
            List list;
            DealSubsetAttribute dealsubsetattribute1;
            int i;
            int j;
            int k;
            boolean flag;
            try
            {
                list = dealSummaryDao.queryForEq("channel", pagerChannelAndSubchannel);
                pagination = (Pagination)CollectionUtils.getFirstItem(paginationDao.queryForEq("channel", pagerChannelAndSubchannel), null);
                dealsubsetattribute1 = (DealSubsetAttribute)CollectionUtils.getFirstItem(dealSubsetAttributeDao.queryForEq("channel", pagerChannelAndSubchannel), null);
                obj = new ArrayList();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
            obj2 = null;
            arraylist = new ArrayList();
            i = 0;
            k = 0;
            j = 0;
            l = 0;
            dealsubsetattribute = obj2;
            obj1 = obj;
            if (pagination == null)
            {
                break MISSING_BLOCK_LABEL_232;
            }
            if (pagination.hasMorePages())
            {
                k = pagination.getCount();
                l = pagination.getCurrentOffset();
            }
            flag = getContext().getResources().getBoolean(0x7f090007);
            i = k;
            j = l;
            dealsubsetattribute = obj2;
            obj1 = obj;
            if (k > firstPageSize)
            {
                break MISSING_BLOCK_LABEL_232;
            }
            i = k;
            j = l;
            dealsubsetattribute = obj2;
            obj1 = obj;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_232;
            }
            obj1 = dealSummaryDao.queryForEq("channel", otherDealChannel);
            dealsubsetattribute = (DealSubsetAttribute)CollectionUtils.getFirstItem(dealSubsetAttributeDao.queryForEq("channel", otherDealChannel), null);
            j = l;
            i = k;
            l = i;
            k = j;
            if (pagination == null)
            {
                break MISSING_BLOCK_LABEL_275;
            }
            l = i;
            k = j;
            if (pagination.hasMorePages())
            {
                l = pagination.getCount();
                k = pagination.getCurrentOffset();
            }
            obj = arraylist;
            if (pagination == null) goto _L2; else goto _L1
_L1:
            obj = arraylist;
            if (!merchantSpecialsEnabledDivisions) goto _L2; else goto _L3
_L3:
            if (l != 0) goto _L5; else goto _L4
_L4:
            if (isShowExactMatchMerchant1410USCAmatchNoDeals) goto _L6; else goto _L5
_L5:
            if (isShowExactMatchMerchant1410USCAmatchAbove) goto _L6; else goto _L7
_L7:
            obj = arraylist;
            if (!isShowExactMatchMerchant1410USCAmatchBelow) goto _L2; else goto _L6
_L6:
            if (l != 0) goto _L9; else goto _L8
_L8:
            if (isShowExactMatchMerchant1410USCAmatchNoDeals) goto _L10; else goto _L9
_L9:
            if (!isShowExactMatchMerchant1410USCAmatchAbove) goto _L11; else goto _L10
_L10:
            obj = businessDao.queryBuilder().where().eq("channel", pagerChannelAndSubchannel).and().eq("isExactMatch", Boolean.valueOf(true));
            obj = (Business)businessDao.queryForFirst(((Where) (obj)).prepare());
            if (obj == null) goto _L13; else goto _L12
_L12:
            if (!((Business) (obj)).isExactMatch || pagination.getNextOffset() >= l) goto _L13; else goto _L14
_L14:
            arraylist.add(obj);
            obj = arraylist;
_L2:
            obj = new MixedEndlessList(list, new EndlessList(((List) (obj1)), ((List) (obj1)).size(), ((List) (obj1)).size(), dealsubsetattribute), new EndlessList(((List) (obj)), ((List) (obj)).size(), ((List) (obj)).size(), null), l, k, dealsubsetattribute1);
            return ((List) (obj));
_L13:
            obj = arraylist;
            if (pagination.getNextOffset() < l) goto _L2; else goto _L15
_L15:
            obj = businessDao.queryForEq("channel", pagerChannelAndSubchannel);
              goto _L2
_L11:
            obj = arraylist;
            if (!isShowExactMatchMerchant1410USCAmatchBelow) goto _L2; else goto _L16
_L16:
            obj = arraylist;
            if (pagination.getNextOffset() < l) goto _L2; else goto _L17
_L17:
            obj = businessDao.queryForEq("channel", pagerChannelAndSubchannel);
              goto _L2
        }

        protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
        {
            boolean flag = Strings.equals(channelupdateevent.getChannel(), pagerChannelAndSubchannel);
            if (flag)
            {
                globalSearchResultFragment.dataState = 1;
            }
            return flag;
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((ChannelUpdateEvent)updateevent);
        }

        public AllDealsFragmentDealSummaryListLoader(Class class1, Class class2, Context context, String s, GlobalSearchResultFragment globalsearchresultfragment)
        {
            super(class1, class2, context, s);
            globalSearchResultFragment = globalsearchresultfragment;
            otherDealChannel = globalsearchresultfragment.otherDealChannel;
            firstPageSize = dealCardListUtils.getFirstPageSize();
            isShowExactMatchMerchant1410USCAmatchNoDeals = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchNoDeals");
            isShowExactMatchMerchant1410USCAmatchAbove = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchAbove");
            isShowExactMatchMerchant1410USCAmatchBelow = abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchBelow");
            class1 = globalsearchresultfragment.getGlobalSearchResultActivity().getPlace();
            merchantSpecialsEnabledDivisions = merchantSpecialsAbTestHelper.isMerchantSpecialsEnabled(class1);
        }
    }

    protected class BusinessExactMatchAdapter extends BaseAdapter
    {

        private Context context;
        public Business exactMatchBusiness;
        final GlobalSearchResultFragment this$0;

        public int getCount()
        {
            return adapterCountReferenceList[3];
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
label0:
            {
                if (view != null && view.getId() == 0x7f100156)
                {
                    viewgroup = view;
                    if (view instanceof BusinessExactMatchCardView)
                    {
                        break label0;
                    }
                }
                viewgroup = new BusinessExactMatchCardView(context);
            }
            if (exactMatchBusiness != null)
            {
                viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                    final BusinessExactMatchAdapter this$1;

                    public void onClick(View view)
                    {
                        loggingUtils.logClick("", "merchant_impression_click", Channel.MERCHANT_PAGE.toString(), loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(exactMatchBusiness.remoteId)));
                        startActivity(intentFactory.newMerchantPageIntent(exactMatchBusiness.remoteId));
                    }

            
            {
                this$1 = BusinessExactMatchAdapter.this;
                super();
            }
                });
                ((BusinessExactMatchCardView)viewgroup).setInfo(exactMatchBusiness);
                loggingUtils.logImpression("", "merchant", exactMatchBusiness.remoteId, "0", JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            }
            return viewgroup;
        }

        public BusinessExactMatchAdapter(Activity activity)
        {
            this$0 = GlobalSearchResultFragment.this;
            super();
            context = activity;
        }
    }

    protected class BusinessHeaderAdapter extends BaseAdapter
    {

        private LayoutInflater inflater;
        final GlobalSearchResultFragment this$0;

        public int getCount()
        {
            return adapterCountReferenceList[4];
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
label0:
            {
                if (view != null)
                {
                    view1 = view;
                    if (view.getId() == 0x7f1002ff)
                    {
                        break label0;
                    }
                }
                view1 = inflater.inflate(0x7f030104, viewgroup, false);
            }
            view = (TextView)view1.findViewById(0x7f100300);
            viewgroup = getGlobalSearchResultActivity().getPlace();
            if (Strings.equalsIgnoreCase(((Place) (viewgroup)).label, getResources().getString(0x7f0801fa)))
            {
                view.setText(getString(0x7f0801f9));
                return view1;
            } else
            {
                view.setText(String.format(getString(0x7f0801f8), new Object[] {
                    ((Place) (viewgroup)).label
                }));
                return view1;
            }
        }

        public BusinessHeaderAdapter(LayoutInflater layoutinflater)
        {
            this$0 = GlobalSearchResultFragment.this;
            super();
            inflater = layoutinflater;
        }
    }

    protected class BusinessNonExactMatchAdapter extends BaseAdapter
    {

        public List businesses;
        private Activity context;
        final GlobalSearchResultFragment this$0;
        private int trackingPositionOffset;

        public int getCount()
        {
            return adapterCountReferenceList[5];
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view != null && view.getTag() != null && ((Integer)view.getTag()).intValue() == i)
            {
                return view;
            }
            view = (Business)businesses.get(i);
            viewgroup = new BusinessNonExactMatchCardListView(context);
            if (view != null)
            {
                viewgroup.setOnClickListener(view. new android.view.View.OnClickListener() {

                    final BusinessNonExactMatchAdapter this$1;
                    final Business val$business;

                    public void onClick(View view)
                    {
                        loggingUtils.logClick("", "merchant_impression_click", Channel.MERCHANT_PAGE.toString(), loggingUtils.encodeAsJson(new MerchantPageMerchantIdMetadata(business.remoteId)));
                        startActivity(intentFactory.newMerchantPageIntent(business.remoteId));
                    }

            
            {
                this$1 = final_businessnonexactmatchadapter;
                business = Business.this;
                super();
            }
                });
                viewgroup.setInfo(view);
            }
            viewgroup.setTag(Integer.valueOf(i));
            if (i != 0) goto _L2; else goto _L1
_L1:
            int j = (int)(10F * context.getResources().getDisplayMetrics().density);
            FrameLayout framelayout = (FrameLayout)viewgroup.findViewById(0x7f100156);
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = new android.view.ViewGroup.MarginLayoutParams(framelayout.getLayoutParams());
            marginlayoutparams.setMargins(0, j, 0, 0);
            framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(marginlayoutparams));
_L4:
            if (trackingPositionOffset == -1)
            {
                trackingPositionOffset = getTrackingPositionOffset(5);
            }
            if (view != null)
            {
                loggingUtils.logImpression("", "merchant", ((Business) (view)).remoteId, (new StringBuilder()).append(trackingPositionOffset + i).append("").toString(), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            }
            return viewgroup;
_L2:
            if (i == businesses.size() - 1)
            {
                int k = (int)(10F * context.getResources().getDisplayMetrics().density);
                FrameLayout framelayout1 = (FrameLayout)viewgroup.findViewById(0x7f100156);
                android.view.ViewGroup.MarginLayoutParams marginlayoutparams1 = new android.view.ViewGroup.MarginLayoutParams(framelayout1.getLayoutParams());
                marginlayoutparams1.setMargins(0, 0, 0, k);
                framelayout1.setLayoutParams(new android.widget.FrameLayout.LayoutParams(marginlayoutparams1));
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public BusinessNonExactMatchAdapter(Activity activity)
        {
            this$0 = GlobalSearchResultFragment.this;
            super();
            trackingPositionOffset = 0;
            context = activity;
            activity = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(activity);
            trackingPositionOffset = -1;
        }
    }

    protected class DealsNearbyAdapter extends BaseAdapter
    {

        private LayoutInflater inflater;
        final GlobalSearchResultFragment this$0;

        public int getCount()
        {
            return adapterCountReferenceList[1];
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
label0:
            {
                if (view != null)
                {
                    view1 = view;
                    if (view.getId() == 0x7f1002ff)
                    {
                        break label0;
                    }
                }
                view1 = inflater.inflate(0x7f030104, viewgroup, false);
            }
            ((TextView)view1.findViewById(0x7f100300)).setText(getString(0x7f0801fb));
            return view1;
        }

        public DealsNearbyAdapter(LayoutInflater layoutinflater)
        {
            this$0 = GlobalSearchResultFragment.this;
            super();
            inflater = layoutinflater;
        }
    }

    public class GlobalSearchResultDealSummaryListLoaderCallback extends DealSummaryListLoaderCallbacks
    {

        final GlobalSearchResultFragment this$0;

        public EndlessList getEndlessListClone(EndlessList endlesslist)
        {
            return new EndlessList(new ArrayList(endlesslist), endlesslist.getTotalSize(), endlesslist.getCurrentOffset(), endlesslist.getAttr());
        }

        public Loader onCreateLoader(int i, Bundle bundle)
        {
            return new AllDealsFragmentDealSummaryListLoader(com/groupon/db/models/DealSummary, com/groupon/db/events/ChannelUpdateEvent, getActivity(), pagerChannelAndSubchannel, GlobalSearchResultFragment.this);
        }

        public volatile void onLoadFinished(Loader loader, Object obj)
        {
            onLoadFinished(loader, (List)obj);
        }

        public void onLoadFinished(Loader loader, List list)
        {
            if (list == null)
            {
                return;
            }
            loader = (MixedEndlessList)list;
            list = getGlobalSearchResultActivity();
            Object obj;
            EndlessList endlesslist;
            boolean flag;
            if (loader.getCurrentOffset() != 0 || loader.getTotalSize() != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            list.setHasMoreItems(flag);
            endlesslist = loader.getOtherEndlessList();
            list = getEndlessListClone(loader);
            obj = loader.getBusinessesEndlessList();
            primaryListSize = loader.size();
            otherListSize = endlesslist.size();
            businessListSize = ((EndlessList) (obj)).size();
            if (endlesslist.size() > 0)
            {
                list.addAll(endlesslist);
                list.setCurrentOffset(loader.size());
                list.setTotalSize(loader.size());
                list.setAttr(loader.getAttr());
            }
            if (businessAdapter != null && ((EndlessList) (obj)).size() > 0)
            {
                isExactMatch = ((Business)((EndlessList) (obj)).get(0)).isExactMatch;
            }
            computeABTestResults();
            if (businessAdapter != null)
            {
                ArrayList arraylist = new ArrayList();
                for (obj = ((EndlessList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add((Business)((Iterator) (obj)).next())) { }
                if (adapterCountReferenceList[3] > 0)
                {
                    businessExactMatchAdapter.exactMatchBusiness = (Business)arraylist.remove(0);
                }
                businessAdapter.businesses = arraylist;
            }
            dealCardEndlessAdapter.setTotalSize(loader.getTotalSize());
            listAdapter.setList(list);
            afterOnLoadFinished(loader);
        }

        public void onLoaderReset(Loader loader)
        {
            primaryListSize = 0;
            otherListSize = 0;
            businessListSize = 0;
            adapterCountReferenceList = new int[6];
            chooseAdapterReferenceList = new ArrayList();
            super.onLoaderReset(loader);
        }

        public void reloadList()
        {
            primaryListSize = 0;
            otherListSize = 0;
            businessListSize = 0;
            adapterCountReferenceList = new int[6];
            chooseAdapterReferenceList = new ArrayList();
            listAdapter.setList(new ArrayList());
        }

        public GlobalSearchResultDealSummaryListLoaderCallback(JavaListAdapter javalistadapter)
        {
            this$0 = GlobalSearchResultFragment.this;
            super(javalistadapter, GlobalSearchResultFragment.this);
        }
    }

    protected class MergeOtherDealsHeaderAdapter extends MergeAdapter
    {

        final GlobalSearchResultFragment this$0;

        protected int chooseAdapter(int i)
        {
            return ((Integer)chooseAdapterReferenceList.get(i)).intValue();
        }

        public MergeOtherDealsHeaderAdapter(ListAdapter listadapter, ListAdapter listadapter1, ListAdapter listadapter2, ListAdapter listadapter3, ListAdapter listadapter4, ListAdapter listadapter5)
        {
            this$0 = GlobalSearchResultFragment.this;
            super(new Adapter[] {
                listadapter, listadapter1, listadapter2, listadapter3, listadapter4, listadapter5
            });
        }
    }

    protected static class MixedEndlessList extends EndlessList
    {

        EndlessList businessesEndlessList;
        EndlessList otherDealsEndlessList;

        public EndlessList getBusinessesEndlessList()
        {
            return businessesEndlessList;
        }

        public EndlessList getOtherEndlessList()
        {
            return otherDealsEndlessList;
        }

        public MixedEndlessList(List list, EndlessList endlesslist, EndlessList endlesslist1, int i, int j, Object obj)
        {
            super(list, i, j, obj);
            otherDealsEndlessList = endlesslist;
            businessesEndlessList = endlesslist1;
        }
    }

    protected class OtherDealsHeaderAdapter extends BaseAdapter
    {

        private LayoutInflater inflater;
        final GlobalSearchResultFragment this$0;

        public int getCount()
        {
            return adapterCountReferenceList[2];
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
label0:
            {
                if (view != null)
                {
                    view1 = view;
                    if (view.getId() == 0x7f1002ff)
                    {
                        break label0;
                    }
                }
                view1 = inflater.inflate(0x7f030104, viewgroup, false);
            }
            ((TextView)view1.findViewById(0x7f100300)).setText(getString(0x7f080201));
            return view1;
        }

        public OtherDealsHeaderAdapter(LayoutInflater layoutinflater)
        {
            this$0 = GlobalSearchResultFragment.this;
            super();
            inflater = layoutinflater;
        }
    }


    private static final int DATA_STATE_FIRST_LOAD_COMPLETED = 1;
    private static final int DATA_STATE_UNLOADED = 0;
    private final int BUSINESS_EXACT_MATCH_ADAPTER = 3;
    private final int BUSINESS_HEADER_ADAPTER = 4;
    private final int BUSINESS_NON_EXACT_MATCH_ADAPTER = 5;
    private final String DATA_STATE = "data_state";
    private final int NEARBY_HEADER_POS = 1;
    String NO_DEALS_TEXT;
    private final String OTHER_DEAL = "otherDeal";
    private final int OTHER_HEADER_POS = 2;
    private final int PRIMARY_LIST_POS = 0;
    private int adapterCountReferenceList[];
    private BadgesAbTestHelper badgesAbTestHelper;
    private BusinessNonExactMatchAdapter businessAdapter;
    private BusinessExactMatchAdapter businessExactMatchAdapter;
    private int businessListSize;
    private BuyUtils buyUtil;
    private List chooseAdapterReferenceList;
    private int dataState;
    private DealTypeService dealTypeService;
    SpinnerButton globalSearchMapRefreshButton;
    private IntentFactory intentFactory;
    private boolean isExactMatch;
    private boolean isShowBadgeOnSearch1509USCA;
    private boolean isShowExactMatchMerchant1410USCAmatchAbove;
    private boolean isShowExactMatchMerchant1410USCAmatchBelow;
    private boolean isShowExactMatchMerchant1410USCAmatchNoDeals;
    private boolean isSmallDealCardsOnSearch1508;
    private GlobalSearchResultDealSummaryListLoaderCallback listLoaderCallback;
    private LocationService locationService;
    private String otherDealChannel;
    private View otherDealsListHeaderBody;
    private TextView otherDealsListHeaderHeading;
    private TextView otherDealsListTryNewSearchHeaderHeading;
    private int otherListSize;
    private int primaryListSize;
    private SearchHelper searchHelper;
    View searchListSection;
    View searchMapSection;
    DealsMapView searchMapView;
    private String searchTerm;
    private SearchSyncManager syncManager;

    public GlobalSearchResultFragment()
    {
        super(Channel.GLOBAL_SEARCH);
        dataState = 0;
        primaryListSize = 0;
        otherListSize = 0;
        businessListSize = 0;
        isExactMatch = false;
    }

    protected void addDeals(List list)
    {
        Place place = getPlaceForMap();
        searchMapView.addDeals(list, new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D)));
        dealTypeService.preProcessDealListNew(list);
    }

    protected void addIntegerToList(int i, int j)
    {
        for (int k = 0; k < j; k++)
        {
            chooseAdapterReferenceList.add(Integer.valueOf(i));
        }

        int ai[] = adapterCountReferenceList;
        ai[i] = ai[i] + j;
    }

    protected void adjustToFullMapMode(boolean flag)
    {
        searchMapView.enableMapDealDetails(flag);
        enableMyLocation(flag);
    }

    protected void afterOnLoadFinished(List list)
    {
        if ((!list.isEmpty() || isExactMatch) && (!list.isEmpty() || !isShowExactMatchMerchant1410USCAmatchBelow)) goto _L2; else goto _L1
_L1:
        showNoDealsHeader();
_L4:
        if (globalSearchMapRefreshButton.isSpinning())
        {
            globalSearchMapRefreshButton.stopSpinning();
        }
        return;
_L2:
        dealCardEndlessAdapter.enableAppending(true);
        otherDealsListHeaderBody.setVisibility(8);
        searchHelper.addDealsToMap(getGlobalSearchResultActivity().getPlace(), list);
        if (!getGlobalSearchResultActivity().isListMode())
        {
            switchToMap();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void computeABTestResults()
    {
        adapterCountReferenceList = new int[6];
        chooseAdapterReferenceList = new ArrayList();
        if (isShowExactMatchMerchant1410USCAmatchNoDeals && primaryListSize != 0 || !isShowExactMatchMerchant1410USCAmatchNoDeals && !isShowExactMatchMerchant1410USCAmatchBelow && !isShowExactMatchMerchant1410USCAmatchAbove || businessListSize == 0)
        {
            handleNoBusinessResult();
        } else
        {
            if (isShowExactMatchMerchant1410USCAmatchNoDeals)
            {
                handleMatchNoDeals();
                return;
            }
            if (isShowExactMatchMerchant1410USCAmatchAbove)
            {
                handleMatchAbove();
                return;
            }
            if (isShowExactMatchMerchant1410USCAmatchBelow)
            {
                handleMatchBelow();
                return;
            }
        }
    }

    public void configureSyncManager()
    {
        String s2 = getGlobalSearchResultActivity().getDeepLinkWithApiParameters();
        String s;
        String s1;
        if (Strings.notEmpty(s2))
        {
            s1 = Strings.md5(s2);
        } else
        {
            s1 = "";
        }
        if (Strings.isEmpty(s2))
        {
            s = "GLOBAL_SEARCH";
        } else
        {
            s = Channel.encodePath(new String[] {
                "GLOBAL_SEARCH", s1
            });
        }
        if (Strings.isEmpty(s2))
        {
            s1 = Channel.encodePath(new String[] {
                "GLOBAL_SEARCH", "otherDeal"
            });
        } else
        {
            s1 = Channel.encodePath(new String[] {
                "GLOBAL_SEARCH", "otherDeal", s1
            });
        }
        otherDealChannel = s1;
        syncManager.configure(s, otherDealChannel, s2);
        syncManager.setSearchTerm(searchTerm);
        if (dataState == 0)
        {
            syncManager.forceUpdateOnAutoSync();
        }
        pagerChannelAndSubchannel = s;
    }

    protected View createHeaderView()
    {
        View view = getActivity().getLayoutInflater().inflate(0x7f03010b, null);
        otherDealsListHeaderHeading = (TextView)view.findViewById(0x7f100319);
        otherDealsListTryNewSearchHeaderHeading = (TextView)view.findViewById(0x7f10031a);
        otherDealsListHeaderBody = view.findViewById(0x7f100318);
        otherDealsListHeaderBody.setVisibility(8);
        return view;
    }

    protected void enableMyLocation(boolean flag)
    {
        GoogleMap googlemap = searchMapView.getGoogleMap();
        if (googlemap != null)
        {
            googlemap.setMyLocationEnabled(flag);
            googlemap.getUiSettings().setMyLocationButtonEnabled(false);
            googlemap.getUiSettings().setCompassEnabled(flag);
        }
    }

    protected View getCardView(ListAdapter listadapter, int i, View view, ViewGroup viewgroup)
    {
        viewgroup = (DealSummary)listadapter.getItem(i);
        tracking(nstChannel, viewgroup, i, getDealImpressionExtraInfo(viewgroup));
        view = getDealCardView(view, viewgroup, getPlaces());
        if (view instanceof HasImageView)
        {
            imagePrefetchAdapterHelper.prefetchNextImage(listadapter, i, (HasImageView)view);
            return view;
        } else
        {
            Ln.d("Prefetching doesn't work with views like %s as it does not implement com.groupon.view.HasImageView", new Object[] {
                view
            });
            return view;
        }
    }

    protected DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment)
    {
        basecardlistfragment = new OtherDealsHeaderAdapter(getActivity().getLayoutInflater());
        BusinessHeaderAdapter businessheaderadapter = new BusinessHeaderAdapter(getActivity().getLayoutInflater());
        DealsNearbyAdapter dealsnearbyadapter = new DealsNearbyAdapter(getActivity().getLayoutInflater());
        businessAdapter = new BusinessNonExactMatchAdapter(getActivity());
        businessExactMatchAdapter = new BusinessExactMatchAdapter(getActivity());
        return new DealCardEndlessAdapter(this, this, new DealCardMultiColumnListAdapter(new MergeOtherDealsHeaderAdapter(baseadapter, dealsnearbyadapter, basecardlistfragment, businessExactMatchAdapter, businessheaderadapter, businessAdapter), getDealListColumns()) {

            final GlobalSearchResultFragment this$0;

            public void onDealCardClicked(int i, View view, DealSummary dealsummary)
            {
                GlobalSearchResultFragment.this.onDealCardClicked(i, view, dealsummary);
            }

            public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
            {
                onMemberClick(view, dealsummary);
            }

            
            {
                this$0 = GlobalSearchResultFragment.this;
                super(listadapter, i);
            }
        });
    }

    protected View getDealCardView(View view, DealSummary dealsummary, List list)
    {
        if (view != null && (view instanceof DealCardBase))
        {
            view = (DealCardBase)view;
        } else
        if (isSmallDealCardsOnSearch1508)
        {
            view = new DefaultSmallDealCard(activity);
        } else
        {
            view = new DefaultLargeDealCard(activity);
        }
        dealsummary.putAttr("is_show_badge_ab_test_on", Boolean.valueOf(isShowBadgeOnSearch1509USCA));
        view.setInfoWithPlaces(dealsummary, list);
        if (isSmallDealCardsOnSearch1508 && currentCountryManager.getCurrentCountry().isUSACompatible() && DealUtils.isLocalDeal(dealsummary) && Strings.notEmpty(dealsummary.derivedMerchantName))
        {
            view.setTitle(dealsummary.derivedMerchantName);
        }
        return view;
    }

    protected JsonEncodedNSTField getDealImpressionExtraInfo(AbstractDeal abstractdeal)
    {
        Object obj = super.getDealImpressionExtraInfo(abstractdeal);
        if (isShowBadgeOnSearch1509USCA && !DealUtils.isSoldOutOrClosed(abstractdeal) && (obj instanceof DealImpressionMetadata))
        {
            obj = (DealImpressionMetadata)obj;
            abstractdeal = abstractdeal.badges.iterator();
            do
            {
                if (!abstractdeal.hasNext())
                {
                    break;
                }
                Badge badge = (Badge)abstractdeal.next();
                if (!DealUtils.isBadgeValid(badge))
                {
                    continue;
                }
                obj.badgeDisplayText = badge.text;
                obj.badgeType = badge.badgeType;
                break;
            } while (true);
            return ((JsonEncodedNSTField) (obj));
        } else
        {
            return ((JsonEncodedNSTField) (obj));
        }
    }

    public GlobalSearchResult getGlobalSearchResultActivity()
    {
        return (GlobalSearchResult)getActivity();
    }

    protected Channel getOriginatingChannel(DealSummary dealsummary)
    {
        if (Strings.notEmpty(((GlobalSearchResult)getActivity()).getDeepLinkWithApiParameters()))
        {
            return Channel.GLOBAL_SEARCH;
        } else
        {
            return super.getOriginatingChannel(dealsummary);
        }
    }

    public String getOriginatingNstChannel()
    {
        return ((GlobalSearchResult)getActivity()).getOriginatingNstChannel().toString();
    }

    protected Place getPlaceForMap()
    {
        Object obj = getGlobalSearchResultActivity().getDeepLinkWithApiParameters();
        if (!Strings.isEmpty(obj)) goto _L2; else goto _L1
_L1:
        Object obj1 = getGlobalSearchResultActivity().getPlace();
_L4:
        return ((Place) (obj1));
_L2:
        obj1 = Uri.parse(((String) (obj)));
        obj = ((Uri) (obj1)).getQueryParameter("lat");
        obj1 = ((Uri) (obj1)).getQueryParameter("lng");
        if (!Strings.notEmpty(obj) || !Strings.notEmpty(obj1))
        {
            break; /* Loop/switch isn't completed */
        }
        float f = Float.parseFloat(((String) (obj)));
        float f1 = Float.parseFloat(((String) (obj1)));
        obj = new Place("", f, f1);
_L5:
        obj1 = obj;
        if (obj == null)
        {
            obj = locationService.getBestGuessForLocation();
            return new Place("", ((GeoPoint) (obj)).getLatitudeDegrees(), ((GeoPoint) (obj)).getLongitudeDegrees());
        }
        if (true) goto _L4; else goto _L3
        obj;
        Ln.e(((Throwable) (obj)));
_L3:
        obj = null;
          goto _L5
    }

    protected List getPlaces()
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(getGlobalSearchResultActivity().getPlace());
        return arraylist;
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public SearchSyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected int getTrackingPositionOffset(int i)
    {
        int k = 0;
        for (int j = 0; j < chooseAdapterReferenceList.size();)
        {
            int l;
label0:
            {
                int i1 = ((Integer)chooseAdapterReferenceList.get(j)).intValue();
                if (i1 == i)
                {
                    return j - k;
                }
                if (i1 != 4 && i1 != 2)
                {
                    l = k;
                    if (i1 != 1)
                    {
                        break label0;
                    }
                }
                l = k + 1;
            }
            j++;
            k = l;
        }

        return 0;
    }

    protected void handleMatchAbove()
    {
        if (!isExactMatch) goto _L2; else goto _L1
_L1:
        if (primaryListSize != 0 || otherListSize != 0) goto _L4; else goto _L3
_L3:
        if (businessListSize != 1) goto _L6; else goto _L5
_L5:
        addIntegerToList(3, businessListSize);
_L8:
        return;
_L6:
        addIntegerToList(3, 1);
        addIntegerToList(4, 1);
        addIntegerToList(5, businessListSize - 1);
        return;
_L4:
        addIntegerToList(3, 1);
        if (primaryListSize > 0)
        {
            addIntegerToList(1, 1);
            addIntegerToList(0, primaryListSize);
        }
        if (otherListSize > 0)
        {
            addIntegerToList(2, 1);
            addIntegerToList(0, otherListSize);
        }
        if (businessListSize > 1)
        {
            addIntegerToList(4, 1);
            addIntegerToList(5, businessListSize - 1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (primaryListSize > 0)
        {
            addIntegerToList(0, primaryListSize);
        }
        if (otherListSize > 0)
        {
            addIntegerToList(2, 1);
            addIntegerToList(0, otherListSize);
        }
        if (businessListSize > 0)
        {
            addIntegerToList(4, 1);
            addIntegerToList(5, businessListSize);
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void handleMatchBelow()
    {
        if (primaryListSize > 0)
        {
            addIntegerToList(0, primaryListSize);
        }
        if (otherListSize > 0)
        {
            addIntegerToList(2, 1);
            addIntegerToList(0, otherListSize);
        }
        if (businessListSize > 0)
        {
            addIntegerToList(4, 1);
            addIntegerToList(5, businessListSize);
        }
    }

    protected void handleMatchNoDeals()
    {
        if (!isExactMatch) goto _L2; else goto _L1
_L1:
        if (otherListSize <= 0) goto _L4; else goto _L3
_L3:
        addIntegerToList(3, 1);
        addIntegerToList(2, 1);
        addIntegerToList(0, otherListSize);
_L6:
        return;
_L4:
        addIntegerToList(3, 1);
        return;
_L2:
        if (otherListSize > 0)
        {
            addIntegerToList(2, 1);
            addIntegerToList(0, otherListSize);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void handleNoBusinessResult()
    {
        if (primaryListSize > 0 && otherListSize > 0)
        {
            addIntegerToList(0, primaryListSize);
            addIntegerToList(2, 1);
            addIntegerToList(0, otherListSize);
        } else
        {
            if (primaryListSize == 0 && otherListSize > 0)
            {
                addIntegerToList(2, 1);
                addIntegerToList(0, otherListSize);
                return;
            }
            if (primaryListSize > 0)
            {
                addIntegerToList(0, primaryListSize);
                return;
            }
        }
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.handleSyncError(runnable, exception);
            showNoDealsHeader();
            return;
        }
    }

    public void handleSyncErrorCancellation(Runnable runnable, Exception exception)
    {
        super.handleSyncErrorCancellation(runnable, exception);
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        listLoaderCallback = new GlobalSearchResultDealSummaryListLoaderCallback(javalistadapter);
        getLoaderManager().initLoader(0, null, listLoaderCallback);
    }

    protected void logDealImpression(String s, String s1, DealSummary dealsummary, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
        if ((GlobalSearchResult)getActivity() != null)
        {
            super.logDealImpression(getOriginatingNstChannel(), s1, dealsummary, getTrackingPositionOffset(0) + i, jsonencodednstfield, s2, abtestservice, flag, true);
        }
    }

    protected volatile void logDealImpression(String s, String s1, Object obj, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
        logDealImpression(s, s1, (DealSummary)obj, i, jsonencodednstfield, s2, abtestservice, flag, flag1);
    }

    public void onActivityCreated(Bundle bundle)
    {
        boolean flag1 = true;
        super.onActivityCreated(bundle);
        MapsInitializer.initialize(getActivity());
        searchMapView.onCreate(bundle);
        searchMapView.resetInternalStates();
        searchMapView.setDealClickListener(this);
        searchMapSection.setVisibility(8);
        otherDealsListHeaderBody.setVisibility(8);
        globalSearchMapRefreshButton.setProgress(getResources().getDrawable(0x7f0202bb));
        globalSearchMapRefreshButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GlobalSearchResultFragment this$0;

            public void onClick(View view)
            {
                reloadDeals();
            }

            
            {
                this$0 = GlobalSearchResultFragment.this;
                super();
            }
        });
        boolean flag2 = Strings.isEmpty(getGlobalSearchResultActivity().getDeepLinkWithApiParameters());
        boolean flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchNoDeals"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchNoDeals = flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchAbove"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchAbove = flag;
        if (flag2 && abTestService.isVariantEnabled("showExactMatchMerchant1410USCA", "matchBelow"))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isShowExactMatchMerchant1410USCAmatchBelow = flag;
        isShowBadgeOnSearch1509USCA = badgesAbTestHelper.isShowBadgeOnSearch();
        searchHelper.init(searchListSection, searchMapSection, searchMapView);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        recoverInstantState(bundle);
        adapterCountReferenceList = new int[6];
        chooseAdapterReferenceList = new ArrayList();
        isSmallDealCardsOnSearch1508 = abTestService.isVariantEnabled("smallDealCardsOnSearch1508", "on");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03010d, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDealClicked(int i, DealSummary dealsummary)
    {
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
        if (buyUtil.showOptionsWithImages(dealsummary, getActivity()))
        {
            startActivity(intentFactory.newGoodsMultiOptionIntent(dealsummary.remoteId, Channel.GLOBAL_SEARCH, i));
        } else
        {
            startActivity(intentFactory.newDealIntent(dealsummary, Channel.GLOBAL_SEARCH, null));
        }
        loggingUtils.logClick("", "search_result_click", "global_search", dealsummary.remoteId);
    }

    public void onDestroyView()
    {
        if (searchMapView != null)
        {
            searchMapView.release();
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (searchMapView != null)
        {
            searchMapView.onLowMemory();
        }
    }

    public void onPause()
    {
        super.onPause();
        searchMapView.onPause();
        searchHelper.enableMyLocation(false);
    }

    public void onResume()
    {
        super.onResume();
        searchMapView.onResume();
        if (!getGlobalSearchResultActivity().isListMode())
        {
            switchToMap();
        } else
        {
            switchToList();
        }
        abTestService.isVariantEnabled("AAonSearchResultsPage1510", "On");
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (searchMapView != null)
        {
            searchMapView.onSaveInstanceState(bundle);
        }
        bundle.putInt("data_state", dataState);
    }

    protected void recoverInstantState(Bundle bundle)
    {
        if (bundle != null)
        {
            dataState = bundle.getInt("data_state");
        }
    }

    public void reloadDeals()
    {
        listLoaderCallback.reloadList();
        globalSearchMapRefreshButton.startSpinning();
        searchMapView.clearDeals();
        otherDealsListHeaderBody.setVisibility(8);
        forceReload();
        setLocationAndReload();
    }

    protected boolean requiresRedirectLogging()
    {
        return false;
    }

    protected void setLocationAndReload()
    {
        this;
        JVM INSTR monitorenter ;
        Place place = searchHelper.getPlaceForMap(getGlobalSearchResultActivity());
        reload();
        searchMapView.moveCamera(new LatLng(place.lat, place.lng));
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setSearchTerm(String s)
    {
        searchTerm = s;
    }

    protected void showNoDealsHeader()
    {
        if (primaryListSize != 0 || otherListSize != 0 || businessListSize != 0)
        {
            return;
        }
        String s;
        if (isAdded())
        {
            if (Strings.notEmpty(((GlobalSearchResult)getActivity()).getDeepLinkWithApiParameters()))
            {
                s = ((GlobalSearchResult)getActivity()).getDeepLinkSearchQuery();
            } else
            {
                s = searchTerm;
            }
        } else
        {
            s = searchTerm;
        }
        if (Strings.notEmpty(s))
        {
            s = String.format(NO_DEALS_TEXT, new Object[] {
                s
            });
        } else
        {
            s = getResources().getString(0x7f0801ff);
        }
        otherDealsListHeaderHeading.setText(s);
        otherDealsListHeaderBody.setVisibility(0);
        if (primaryListSize == 0 && otherListSize == 0 && (businessListSize == 0 && !isExactMatch || isShowExactMatchMerchant1410USCAmatchNoDeals && !isExactMatch))
        {
            otherDealsListTryNewSearchHeaderHeading.setVisibility(0);
        }
        dealCardEndlessAdapter.enableAppending(false);
    }

    public void switchToList()
    {
        searchHelper.switchToList();
    }

    public void switchToMap()
    {
        searchHelper.switchToMap();
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return true;
    }





/*
    static int access$102(GlobalSearchResultFragment globalsearchresultfragment, int i)
    {
        globalsearchresultfragment.dataState = i;
        return i;
    }

*/


/*
    static int access$202(GlobalSearchResultFragment globalsearchresultfragment, int i)
    {
        globalsearchresultfragment.primaryListSize = i;
        return i;
    }

*/


/*
    static int access$302(GlobalSearchResultFragment globalsearchresultfragment, int i)
    {
        globalsearchresultfragment.otherListSize = i;
        return i;
    }

*/


/*
    static int access$402(GlobalSearchResultFragment globalsearchresultfragment, int i)
    {
        globalsearchresultfragment.businessListSize = i;
        return i;
    }

*/



/*
    static boolean access$602(GlobalSearchResultFragment globalsearchresultfragment, boolean flag)
    {
        globalsearchresultfragment.isExactMatch = flag;
        return flag;
    }

*/



/*
    static int[] access$702(GlobalSearchResultFragment globalsearchresultfragment, int ai[])
    {
        globalsearchresultfragment.adapterCountReferenceList = ai;
        return ai;
    }

*/




/*
    static List access$902(GlobalSearchResultFragment globalsearchresultfragment, List list)
    {
        globalsearchresultfragment.chooseAdapterReferenceList = list;
        return list;
    }

*/
}
