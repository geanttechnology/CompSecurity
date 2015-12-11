// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.AdRtmDataManager;
import com.ebay.common.content.dm.SearchDataManager;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.common.net.api.search.SearchConfiguration;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.common.net.api.search.SearchResultState;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.SearchCompositeRecyclerAdapter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.AdsWebViewActivity;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.ads.GoogleTextAdLoader;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.HttpError;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.google.android.gms.ads.AdListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.mobile.search:
//            SearchActivitySync, SearchViewManager, SearchUtil

public final class SearchResultFragment extends BaseFragment
    implements DialogFragmentCallback, com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer, com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener, com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.OnRequestMoreListener
{
    public static interface OnScrollEventListener
    {

        public abstract void onScrollDown();

        public abstract void onScrollUp();
    }

    public static interface OnSearchEventsListener
    {

        public abstract void onIafTokenFailure();

        public abstract void onRelatedSearchItemClicked(ArrayList arraylist);

        public abstract void onRequestTermination();

        public abstract void onSearchComplete(SearchResult searchresult);

        public abstract void onSearchError(boolean flag);

        public abstract void onSearchItemClicked(long l, Date date, ItemCurrency itemcurrency, boolean flag, com.ebay.common.ConstantsCommon.ItemKind itemkind, int i);

        public abstract void onSearchStarted(SearchParameters searchparameters);
    }

    public static interface OnTrackingEventsListener
    {

        public abstract void onBarcodeSearchComplete(String s, String s1);

        public abstract void onBarcodeSearchFailed(String s, String s1);

        public abstract void onPromptOfEbayNowCorrection();

        public abstract void onRefineAspect();

        public abstract void onRefineAuctionType();

        public abstract void onRefineCategory();

        public abstract void onRefineCondition();

        public abstract void onRefineMaxDistance();

        public abstract void onRefineNear();

        public abstract void onRefineOpen();

        public abstract void onRefinePreferredLocation();

        public abstract void onRefinePriceRange();

        public abstract void onRefineSort(String s);

        public abstract void onRelatedSearchesAvailable();

        public abstract void onZeroResults(boolean flag);
    }

    public class RestartSearchListener
        implements android.view.View.OnClickListener
    {

        public final SearchParameters params;
        final SearchResultFragment this$0;

        public void onClick(View view)
        {
            restartSearch(params, false, false);
        }

        public RestartSearchListener(SearchParameters searchparameters)
        {
            this$0 = SearchResultFragment.this;
            super();
            params = searchparameters;
        }
    }

    private class SearchResultObserver extends com.ebay.common.content.dm.SearchDataManager.ConcreteObserver
    {

        private boolean deliverContentEvents;
        final SearchResultFragment this$0;

        private void setDeliverContentEvents(boolean flag)
        {
            deliverContentEvents = flag;
        }

        public void onAdsLoaded(SearchResultState searchresultstate)
        {
            if (searchResultState != null)
            {
                searchresultstate = searchresultstate.getSearchAds();
                SiteSpeedData sitespeeddata = SiteSpeedActivityUtil.getSiteSpeedData(getBaseActivity());
                int i;
                if (searchresultstate == null)
                {
                    i = 0;
                } else
                {
                    i = ((com.ebay.common.net.api.search.SearchResultState.SearchAds) (searchresultstate)).adsList.size();
                }
                sitespeeddata.addExtendedData("i_ac", String.valueOf(i));
                sitespeeddata.setEventName((new StringBuilder()).append(sitespeeddata.eventName).append("WithAds").toString());
                SiteSpeedActivityUtil.allLoaded(getBaseActivity());
                if (searchresultstate != null)
                {
                    viewManager.adsLoaded(searchresultstate, getAdsClickListener());
                    return;
                }
            }
        }

        public void onPopularSearchesAvailable(ArrayList arraylist, int i)
        {
            SearchResultFragment.this.onPopularSearchesAvailable(arraylist, true);
        }

        public void onSearchComplete(SearchResultState searchresultstate)
        {
            searchResultState = searchresultstate;
            SearchResultFragment.this.onSearchComplete(searchResultState);
            restoreScrollPosition();
        }

        public void onSearchContentChanged(ListContent listcontent)
        {
            if (deliverContentEvents)
            {
                Object obj = listcontent.getStatus();
                if (((ResultStatus) (obj)).hasError())
                {
                    if (((ResultStatus) (obj)).canRetry())
                    {
                        showPagedListRetryDialog();
                        return;
                    } else
                    {
                        invokeErrorHandler(((ResultStatus) (obj)));
                        return;
                    }
                }
                obj = viewManager.getListAdapter();
                ArrayList arraylist = new ArrayList(listcontent.getList());
                int i = listcontent.getTotalItemCount();
                int j = listcontent.getPagesLoaded();
                if (obj != null)
                {
                    ((SearchCompositeRecyclerAdapter) (obj)).setList(0, ((SearchCompositeRecyclerAdapter) (obj)).newSection(0, "", arraylist, i, maxNumberSearchItems, j, loadMoreOffset));
                    return;
                }
            }
        }

        public void onSearchStarted(SearchParameters searchparameters)
        {
            viewManager.searchStarted(searchparameters);
        }


        private SearchResultObserver()
        {
            this$0 = SearchResultFragment.this;
            super();
            deliverContentEvents = true;
        }

    }


    private static final int DIALOG_NONRECOVERABLE_INFORMATION = 3;
    private static final int DIALOG_PAGED_LIST_RETRY = 1;
    private static final String INSTANCE_STATE_SCROLL_POSITION = "scroll-position";
    private boolean activePagedListRetry;
    private android.view.View.OnClickListener adsClickListener;
    public Treatment adsExperimentState;
    private int adsResId;
    private Parcelable gridState;
    private int headerHeight;
    private boolean intialSearchStarted;
    private int layoutResId;
    private int loadMoreOffset;
    private int maxNumberSearchItems;
    private ResultStatus pendingErrorStatus;
    private ArrayList relatedSearches;
    private final Runnable restoreScrollPositionRunnable = new Runnable() {

        final SearchResultFragment this$0;

        public void run()
        {
            viewManager.setScrollPosition(scrollPosition);
            scrollPosition = 0;
        }

            
            {
                this$0 = SearchResultFragment.this;
                super();
            }
    };
    private OnScrollEventListener scrollListener;
    private int scrollPosition;
    private SearchDataManager searchDataManager;
    private OnSearchEventsListener searchEventsListener;
    private final SearchResultObserver searchResultObserver = new SearchResultObserver();
    private boolean searchResultObserverRegistered;
    private SearchResultState searchResultState;
    private SearchActivitySync searchSync;
    private final EbayTimer timer = new EbayTimer(1000L);
    private OnTrackingEventsListener trackingEventListener;
    private SearchViewManager viewManager;

    public SearchResultFragment()
    {
        searchResultState = null;
        relatedSearches = null;
        searchSync = null;
        searchEventsListener = null;
        trackingEventListener = null;
        scrollListener = null;
        pendingErrorStatus = null;
        searchResultObserverRegistered = false;
        searchDataManager = null;
        intialSearchStarted = false;
        activePagedListRetry = false;
    }

    private android.view.View.OnClickListener getAdsClickListener()
    {
        if (adsClickListener == null)
        {
            adsClickListener = new android.view.View.OnClickListener() {

                final SearchResultFragment this$0;

                public void onClick(View view)
                {
                    Object obj = (com.ebay.common.rtm.RtmContent.Ad)view.getTag();
                    ((AdRtmDataManager)DataManager.get(getBaseActivity().getEbayContext(), new com.ebay.common.content.dm.AdRtmDataManager.KeyParams())).track(((com.ebay.common.rtm.RtmContent.Ad) (obj)), new TrackingData("RtmThemedSearch", TrackingType.PAGE_IMPRESSION));
                    if (DeviceConfiguration.getAsync().get(DcsBoolean.SearchAdsShowWebView))
                    {
                        AdsWebViewActivity.start((Activity)view.getContext(), ((com.ebay.common.rtm.RtmContent.Ad) (obj)).externalLink.toString(), null, null);
                        return;
                    } else
                    {
                        obj = ((com.ebay.common.rtm.RtmContent.Ad) (obj)).externalLink;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(((URL) (obj)).toExternalForm()));
                        view.getContext().startActivity(intent);
                        return;
                    }
                }

            
            {
                this$0 = SearchResultFragment.this;
                super();
            }
            };
        }
        return adsClickListener;
    }

    private SearchResult getSearchResult()
    {
        if (searchResultState == null)
        {
            return null;
        } else
        {
            return searchResultState.getResult();
        }
    }

    private void handleSearchErrors(ResultStatus resultstatus)
    {
        List list = resultstatus.getMessages();
        boolean flag;
        if (EbayErrorUtil.noProductMatch(list) || EbayErrorUtil.productIdInvalid(list))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        searchEventsListener.onSearchError(flag);
        if (flag)
        {
            resultstatus = searchSync.getSearchParameters();
            if (trackingEventListener != null)
            {
                trackingEventListener.onBarcodeSearchFailed(((SearchParameters) (resultstatus)).productId, ((SearchParameters) (resultstatus)).productIdType);
            }
            viewManager.barcodeSearchError(((SearchParameters) (resultstatus)).productId, headerHeight);
            return;
        } else
        {
            viewManager.searchError();
            invokeErrorHandler(resultstatus);
            return;
        }
    }

    private void initiateSearch()
    {
        while (searchDataManager == null || !searchSync.areSearchParametersReady()) 
        {
            return;
        }
        intialSearchStarted = true;
        loadSearchResults(false, searchSync.getSearchParameters(), false);
    }

    private void invokeErrorHandler(ResultStatus resultstatus)
    {
        com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultstatus.getFirstError();
        if (SearchUtil.useSearchService(searchSync.getSearchParameters()) && (message instanceof HttpError) && message.getId() == 401)
        {
            searchEventsListener.onIafTokenFailure();
            return;
        }
        try
        {
            EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            pendingErrorStatus = resultstatus;
        }
    }

    private void loadSearchResults(boolean flag, SearchParameters searchparameters, boolean flag1)
    {
        Bundle bundle = searchSync.getTrackingBundle();
        timer.stop();
        searchEventsListener.onSearchStarted(searchparameters);
        if (flag || !searchDataManager.isRunningSearch())
        {
            searchResultObserver.setDeliverContentEvents(false);
            if (flag || searchResultState == null)
            {
                searchResultState = null;
                relatedSearches = null;
                SearchConfiguration searchconfiguration = SearchUtil.getDefaultSearchConfig(false, searchSync.getCguidPersister());
                if (searchconfiguration.isAdDeliveryEnabled)
                {
                    if (adsExperimentState == null)
                    {
                        adsExperimentState = Experiments.getAdsTreatment(MyApp.getPrefs().getCurrentSite(), getFwActivity().getEbayContext());
                    }
                    searchconfiguration.isAdDeliveryEnabled = com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.isActive(adsExperimentState, com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource.AdsOnSrp);
                }
                searchparameters.primaryPostalCodeSpec = MyApp.getPrefs().getShipToPostalCode();
                if (flag1 && searchparameters.category == null)
                {
                    searchparameters.category = new EbayCategorySummary(0L, null);
                }
                searchDataManager.executeSearch(searchparameters, searchResultObserver, searchconfiguration, searchSync.getSearchTracker(searchparameters, bundle));
                if (flag1)
                {
                    searchparameters.category = null;
                    return;
                }
            } else
            {
                searchDataManager.loadData(searchResultObserver);
                return;
            }
        }
    }

    private void onPopularSearchesAvailable(ArrayList arraylist, boolean flag)
    {
    }

    private void refreshList()
    {
        SearchCompositeRecyclerAdapter searchcompositerecycleradapter = viewManager.getListAdapter();
        if (searchcompositerecycleradapter != null)
        {
            viewManager.refreshList(searchcompositerecycleradapter);
        }
    }

    private void registerManagedObservers()
    {
        if (!searchResultObserverRegistered && searchDataManager != null)
        {
            searchResultObserverRegistered = true;
            searchDataManager.registerObserver(searchResultObserver);
        }
    }

    private void restoreScrollPosition()
    {
        if (scrollPosition == 0 || scrollPosition == viewManager.getScrollPosition() || viewManager.getListAdapter() == null)
        {
            return;
        } else
        {
            viewManager.postGridViewRunnable(restoreScrollPositionRunnable);
            return;
        }
    }

    private void setLayoutResId(int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            layoutResId = 0x7f030257;
            return;

        case 1: // '\001'
            layoutResId = 0x7f030258;
            break;
        }
    }

    private void setResultsAdapter(SearchResult searchresult, ArrayList arraylist)
    {
        SearchCompositeRecyclerAdapter searchcompositerecycleradapter;
        int i;
        int j;
        boolean flag;
        if (layoutResId == 0x7f030258)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        arraylist = viewManager.getListAdapter();
        if (arraylist != null)
        {
            arraylist.setOnRequestMoreListener(null);
        }
        arraylist = new ArrayList(searchresult.resultOwner.getDataList());
        i = searchresult.totalItemCount;
        searchresult = searchSync.getSearchParameters();
        j = (int)Math.ceil((double)arraylist.size() / (double)((SearchParameters) (searchresult)).maxCountPerPage);
        searchcompositerecycleradapter = new SearchCompositeRecyclerAdapter(getBaseActivity(), layoutResId, adsResId, flag, searchresult, searchResultState.getOriginalSearchParameters(), getAdsClickListener());
        searchcompositerecycleradapter.setLoadingViewResource(0x7f0301d3);
        if (flag)
        {
            searchcompositerecycleradapter.setHeaderViewResource(0x7f0301cf);
        } else
        {
            searchcompositerecycleradapter.setHeaderViewResource(0x7f0301ce);
        }
        searchcompositerecycleradapter.setEmptyViewResource(0x7f030093);
        searchcompositerecycleradapter.setHeaderHeight(headerHeight);
        searchcompositerecycleradapter.setSearchParameters(searchresult);
        searchcompositerecycleradapter.add(searchcompositerecycleradapter.newSection(0, "", arraylist, i, maxNumberSearchItems, j, loadMoreOffset));
        searchcompositerecycleradapter.setOnRequestMoreListener(this);
        viewManager.setGridAdapter(searchcompositerecycleradapter);
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final SearchResultFragment this$0;

            public void OnTimer()
            {
                viewManager.onFragmentTimerTick();
            }

            
            {
                this$0 = SearchResultFragment.this;
                super();
            }
        });
    }

    private void showDialogAllowingStateLoss(DialogFragment dialogfragment, String s)
    {
        FragmentManager fragmentmanager = getFragmentManager();
        try
        {
            dialogfragment.show(fragmentmanager, s);
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            fragmentmanager.beginTransaction().add(dialogfragment, s).commitAllowingStateLoss();
        }
    }

    private void showInformationDialog(String s, String s1)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setTitle(s);
        builder.setMessage(s1);
        builder.setPositiveButton(getString(0x7f070738));
        showDialogAllowingStateLoss(builder.createFromFragment(3, this), "search-dialog-information");
    }

    private void trackOnSearchComplete(SearchResult searchresult)
    {
        if (trackingEventListener != null)
        {
            if (searchresult.isBarcodeSearch())
            {
                trackingEventListener.onBarcodeSearchComplete(searchresult.getProductId(), searchresult.getProductType());
                return;
            }
            if (searchresult.totalItemCount == 0)
            {
                trackingEventListener.onZeroResults(false);
                return;
            }
        }
    }

    private void unregisterManagedObservers()
    {
        if (searchResultObserverRegistered && searchDataManager != null)
        {
            searchResultObserverRegistered = false;
            searchDataManager.unregisterObserver(searchResultObserver);
        }
    }

    public void applyRefinements(SearchParameters searchparameters, boolean flag)
    {
        searchparameters.allowExpansions = true;
        viewManager.refinementsChanged();
        loadSearchResults(true, searchparameters, flag);
    }

    public void applySort(SearchParameters searchparameters, boolean flag)
    {
        viewManager.sortChanged(searchparameters);
        loadSearchResults(true, searchparameters, flag);
    }

    public void cacheHeaderHeight(int i)
    {
        headerHeight = i;
        if (viewManager != null)
        {
            viewManager.onHeaderHeightUpdated(headerHeight);
        }
    }

    public DialogFragment createRetryDialog(int i)
    {
        Object obj = new com.ebay.app.AlertDialogFragment.Builder();
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setMessage(getString(0x7f070151));
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setPositiveButton(getString(0x7f070920));
        ((com.ebay.app.AlertDialogFragment.Builder) (obj)).setNegativeButton(getString(0x7f0701cc));
        obj = ((com.ebay.app.AlertDialogFragment.Builder) (obj)).createFromFragment(i, this);
        ((DialogFragment) (obj)).setCancelable(false);
        return ((DialogFragment) (obj));
    }

    public int getItemCount()
    {
        SearchResult searchresult;
label0:
        {
            if (searchResultState != null)
            {
                searchresult = searchResultState.getResult();
                if (searchresult != null)
                {
                    break label0;
                }
            }
            return 0;
        }
        return searchresult.totalItemCount;
    }

    public boolean hasResults()
    {
        SearchResult searchresult = getSearchResult();
        return searchresult != null && searchresult.totalItemCount > 0;
    }

    public void layoutSearchResults(int i)
    {
        final Parcelable gridState = viewManager.getGridState();
        setLayoutResId(i);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), 0x7f04000f);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SearchResultFragment this$0;
            final Parcelable val$gridState;

            public void onAnimationEnd(Animation animation1)
            {
                animation1 = searchResultState.getResult();
                setResultsAdapter(animation1, relatedSearches);
                animation1 = searchResultState.getSearchAds();
                if (animation1 != null)
                {
                    viewManager.adsLoaded(animation1, getAdsClickListener());
                }
                viewManager.postGridViewRunnable(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        viewManager.startGridViewAnimation(AnimationUtils.loadAnimation(getActivity(), 0x7f04000e));
                        viewManager.restoreGridState(gridState);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = SearchResultFragment.this;
                gridState = parcelable;
                super();
            }
        });
        viewManager.startGridViewAnimation(animation);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setLayoutResId(searchSync.getSearchViewType());
        if (bundle != null)
        {
            scrollPosition = bundle.getInt("scroll-position", 0);
        }
        int i = searchSync.getDeviceConfiguration().getSearchPageSize(getResources());
        loadMoreOffset = i / 4;
        maxNumberSearchItems = i * 50;
        initiateSearch();
        if (searchDataManager != null && searchDataManager.isRunningSearch())
        {
            viewManager.searchStarted(searchSync.getSearchParameters());
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        registerManagedObservers();
        try
        {
            searchEventsListener = (OnSearchEventsListener)activity;
            searchSync = (SearchActivitySync)activity;
            scrollListener = (OnScrollEventListener)activity;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement these interfaces: ").append(com/ebay/mobile/search/SearchActivitySync.toString()).append(", ").append(com/ebay/mobile/search/SearchResultFragment$OnSearchEventsListener.toString()).append(com/ebay/mobile/search/SearchResultFragment$OnScrollEventListener.toString()).toString());
        }
        if (activity instanceof OnTrackingEventsListener)
        {
            trackingEventListener = (OnTrackingEventsListener)activity;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
        setupTimer();
        layoutResId = 0x7f030257;
        adsResId = 0x7f0301c9;
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0301e5, viewgroup, false);
        viewManager = new SearchViewManager(layoutinflater, scrollListener);
        if (activePagedListRetry)
        {
            activePagedListRetry = false;
            showPagedListRetryDialog();
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onDestroyView()
    {
        viewManager.removeCallbacks(restoreScrollPositionRunnable);
        gridState = viewManager.getGridState();
        viewManager = null;
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        unregisterManagedObservers();
        searchEventsListener = null;
        searchSync = null;
        scrollListener = null;
        if (getSearchResult() != null)
        {
            timer.stop();
            searchResultObserver.setDeliverContentEvents(false);
        }
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (getActivity() != null)
        {
            switch (i)
            {
            case 2: // '\002'
            default:
                return;

            case 1: // '\001'
                if (j == 1)
                {
                    searchDataManager.retryFailedPages();
                    activePagedListRetry = false;
                    return;
                } else
                {
                    searchEventsListener.onRequestTermination();
                    return;
                }

            case 3: // '\003'
                dialogfragment = getSearchResult();
                break;
            }
            if (dialogfragment != null)
            {
                dialogfragment.clearBopisCorrectedSearch();
                dialogfragment.clearPostalCodeCorrectedSearch();
                dialogfragment.clearEbayNowMetroCorrectedSearch();
                return;
            }
        }
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (flag)
        {
            loadSearchResults(true, searchSync.getSearchParameters(), false);
            return;
        } else
        {
            searchEventsListener.onRequestTermination();
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        datamanagercontainer.initialize(CurrencyConversionDataManager.KEY, this);
        if (searchDataManager == null)
        {
            searchDataManager = (SearchDataManager)DataManager.get(getBaseActivity().getEbayContext(), new com.ebay.common.content.dm.SearchDataManager.KeyParams());
            registerManagedObservers();
            if (!intialSearchStarted)
            {
                initiateSearch();
            }
        }
    }

    public void onRateChanged(CurrencyConversionDataManager currencyconversiondatamanager, CurrencyConversionRate currencyconversionrate)
    {
        refreshList();
    }

    public void onRateLoadComplete(CurrencyConversionDataManager currencyconversiondatamanager, ResultStatus resultstatus, CurrencyConversionRate currencyconversionrate, com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams conversionrequestparams)
    {
    }

    public void onRequestMore(CompositeArrayRecyclerAdapter compositearrayrecycleradapter, com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section, int i, int j)
    {
        compositearrayrecycleradapter = getSearchResult();
        if (compositearrayrecycleradapter != null)
        {
            ((SearchResult) (compositearrayrecycleradapter)).resultOwner.loadPage(j);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (pendingErrorStatus != null)
        {
            EbayErrorHandler.handleResultStatus(this, 0, pendingErrorStatus);
            pendingErrorStatus = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("scroll-position", scrollPosition);
    }

    public void onSearchComplete(final SearchResultState textAdLoader)
    {
        Object obj;
        Object obj1;
        obj = textAdLoader.getResult();
        obj1 = ((SearchResult) (obj)).resultStatus;
        if (!((ResultStatus) (obj1)).hasError()) goto _L2; else goto _L1
_L1:
        handleSearchErrors(((ResultStatus) (obj1)));
_L5:
        return;
_L2:
        obj1 = searchSync.getSearchParameters().buyerPostalCode;
        if (textAdLoader.isInitialDelivery())
        {
            trackOnSearchComplete(((SearchResult) (obj)));
        }
        int i = ((SearchResult) (obj)).totalItemCount;
        searchEventsListener.onSearchComplete(((SearchResult) (obj)));
        int j;
        boolean flag;
        if (((SearchResult) (obj)).resultOwner.getDataList().size() > i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewManager.searchComplete(i, flag, headerHeight);
        if (!((SearchResult) (obj)).getBopisMetroCorrectedSearch()) goto _L4; else goto _L3
_L3:
        showInformationDialog(getString(0x7f070528), getString(0x7f070527));
_L6:
        obj1 = textAdLoader.getPopularSearchKeywords();
        if (i != 0 || flag)
        {
            searchResultObserver.setDeliverContentEvents(true);
            onPopularSearchesAvailable(((ArrayList) (obj1)), false);
            timer.start();
        }
        setResultsAdapter(((SearchResult) (obj)), relatedSearches);
        if (gridState != null)
        {
            viewManager.restoreGridState(gridState);
            gridState = null;
        }
        obj = textAdLoader.getSearchAds();
        if (obj != null)
        {
            viewManager.adsLoaded(((com.ebay.common.net.api.search.SearchResultState.SearchAds) (obj)), getAdsClickListener());
        }
        if (textAdLoader.isInitialDelivery())
        {
            if (textAdLoader.isFetchingAds())
            {
                SiteSpeedActivityUtil.primaryLoaded(getBaseActivity());
            } else
            {
                SiteSpeedActivityUtil.primaryAndAllLoaded(getBaseActivity());
            }
        }
        textAdLoader = DeviceConfiguration.getAsync();
        j = textAdLoader.get(com.ebay.nautilus.domain.dcs.DcsDomain.Ads.I.srpThresholdResultCount19791);
        if (textAdLoader.get(com.ebay.nautilus.domain.dcs.DcsDomain.Ads.B.srpShowDirectGoogleTextAd) && j > 0 && i <= j)
        {
            if (adsExperimentState == null)
            {
                adsExperimentState = Experiments.getAdsTreatment(MyApp.getPrefs().getCurrentSite(), getFwActivity().getEbayContext());
            }
            if (com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.isActive(adsExperimentState, com.ebay.mobile.experimentation.Experiments.AdsExperimentDefinition.AdsPageSource.AdsOnSrp))
            {
                textAdLoader = new GoogleTextAdLoader();
                textAdLoader.loadAd(getActivity(), (FrameLayout)getView(), searchSync.getSearchParameters().keywords, true, new AdListener() {

                    final SearchResultFragment this$0;
                    final GoogleTextAdLoader val$textAdLoader;

                    public void onAdLoaded()
                    {
                        super.onAdLoaded();
                        if (textAdLoader.textAdView != null && viewManager != null)
                        {
                            viewManager.googleTextAdLoaded(textAdLoader.textAdView);
                        }
                    }

            
            {
                this$0 = SearchResultFragment.this;
                textAdLoader = googletextadloader;
                super();
            }
                });
                return;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (((SearchResult) (obj)).getEbayNowMetroCorrectedSearch())
        {
            showInformationDialog(getString(0x7f070544), getString(0x7f070543));
            trackingEventListener.onPromptOfEbayNowCorrection();
        } else
        if (((SearchResult) (obj)).getInvalidPostalCodeCorrectedSearch())
        {
            if (SearchUtil.isZipCodeDefault(((String) (obj1))))
            {
                ((SearchResult) (obj)).clearPostalCodeCorrectedSearch();
            } else
            {
                showInformationDialog(getString(0x7f070553), getString(0x7f070552));
            }
        }
          goto _L6
    }

    public void restartSearch(SearchParameters searchparameters, boolean flag, boolean flag1)
    {
        searchparameters.allowExpansions = flag;
        loadSearchResults(true, searchparameters, flag1);
    }

    public void showPagedListRetryDialog()
    {
        if (activePagedListRetry)
        {
            return;
        } else
        {
            activePagedListRetry = true;
            showDialogAllowingStateLoss(createRetryDialog(1), "search-dialog-list-retry");
            return;
        }
    }




/*
    static int access$102(SearchResultFragment searchresultfragment, int i)
    {
        searchresultfragment.scrollPosition = i;
        return i;
    }

*/






/*
    static SearchResultState access$402(SearchResultFragment searchresultfragment, SearchResultState searchresultstate)
    {
        searchresultfragment.searchResultState = searchresultstate;
        return searchresultstate;
    }

*/





}
