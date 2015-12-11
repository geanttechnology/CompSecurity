// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.Brand;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.SearchResults;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.triggers.BrandShareTrigger;
import com.poshmark.triggers.PMTriggerManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.BrandFollowButtonLayout;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.view_holders.BrandHeaderViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, ShareFragment

public class BrandFragment_v1 extends PMFilterableFragment
    implements ListingNotificationHandler
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE ALL;
        public static final MODE JUST_IN;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/BrandFragment_v1$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            JUST_IN = new MODE("JUST_IN", 0);
            ALL = new MODE("ALL", 1);
            $VALUES = (new MODE[] {
                JUST_IN, ALL
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    private ListingSummaryAdapter adapter;
    Drawable background;
    private Brand brand;
    private BrandHeaderViewHolder brandHeaderViewHolder;
    private String brandName;
    boolean brandUnknown;
    MODE currentMode;
    private View headerView;
    String keywordSource;
    PMListView resultsListView;
    String screenStackTag;
    SearchResults searchResultsData;
    private android.view.View.OnClickListener shareButtonListener;

    public BrandFragment_v1()
    {
        adapter = null;
        brand = null;
        brandUnknown = false;
        keywordSource = null;
        shareButtonListener = new android.view.View.OnClickListener() {

            final BrandFragment_v1 this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.name());
                PMActivity pmactivity = (PMActivity)getActivity();
                if (isAdded() && brand != null)
                {
                    pmactivity.launchFragmentInNewActivity(view, com/poshmark/ui/fragments/ShareFragment, brand);
                }
            }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
        };
    }

    private void getSearchResults(boolean flag)
    {
        if (!flag)
        {
            if (filterWidget != null)
            {
                filterWidget.setVisibility(8);
                filterWidget.updateFilterWidget();
            }
            showProgressDialogWithMessage(getResources().getString(0x7f06023b));
            resultsListView.removeEmptyContentView();
            String s = searchManager.getSearchRequestString();
            PMApi.getListingsForBrand(brandName, s, null, getFilterModel().getSearchTrigger(), keywordSource, new PMApiResponseHandler() {

                final BrandFragment_v1 this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        BrandFragment_v1.this.handleResponse(pmapiresponse, false);
                        hideFilterButtonsForSingleFacet();
                        filterWidget.setVisibility(0);
                    }
                }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
            });
        } else
        if (searchResultsData.getNextPageMaxValue() != null)
        {
            getFilterModel().setNextPageId(searchResultsData.getNextPageMaxValue());
            String s1 = searchManager.getSearchRequestString();
            PMApi.getListingsForBrand(brandName, s1, searchResultsData.getNextPageMaxValue(), null, null, new PMApiResponseHandler() {

                final BrandFragment_v1 this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        BrandFragment_v1.this.handleResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
            });
            return;
        }
    }

    private void handleBrandShareTrigger()
    {
        BrandShareTrigger brandsharetrigger = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
        if (brandsharetrigger != null && brandsharetrigger.isValid())
        {
            brandsharetrigger.incrementViewCount();
            if (brandsharetrigger.shouldFireTrigger())
            {
                brandHeaderViewHolder.shareTriggerLayout.setVisibility(0);
                if (brandsharetrigger.getCurrentState() == com.poshmark.triggers.PMTrigger.TriggerState.INITIAL)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_displayed_first_time", brandName);
                } else
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_displayed", brandName);
                }
                brandsharetrigger.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.IGNORED);
            }
        }
    }

    private void handleResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        String s = getFilterModel().getLabelForAnalytics();
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listings_filtered", s);
        pmapiresponse = (SearchResults)pmapiresponse.data;
        saveFacetLists(pmapiresponse.getFacets());
        searchResultsData = pmapiresponse;
        resultsListView.setListData(searchResultsData);
        resultsListView.updateList();
        resultsListView.setSelection(0);
        if (pmapiresponse.isEmpty())
        {
            resultsListView.showDefaultEmptyContentView();
        }
_L6:
        return;
_L4:
        pmapiresponse = (SearchResults)pmapiresponse.data;
        searchResultsData.append(pmapiresponse);
        resultsListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_LISTING));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void populateHeaderViews()
    {
        brandHeaderViewHolder.brandTitleView.setText(brandName);
        brandHeaderViewHolder.followFollowingButtonContainer.setVisibility(0);
        brandHeaderViewHolder.followFollowingButtonLayout.setParentScreenNameForAnalytics(viewNameForAnalytics);
        if (!brandUnknown)
        {
            brandHeaderViewHolder.followFollowingButtonLayout.setBrand(brandName);
            String s = String.format(getResources().getString(0x7f06005c), new Object[] {
                brand.canonical_name
            });
            brandHeaderViewHolder.shareBrandBannerMessageView.setText(s);
            brandHeaderViewHolder.followFollowingButtonLayout.setVisibility(0);
            brandHeaderViewHolder.filterWidgetLayout.setVisibility(0);
            return;
        } else
        {
            brandHeaderViewHolder.unknownBrandButton.setVisibility(0);
            brandHeaderViewHolder.followFollowingButtonLayout.setVisibility(8);
            return;
        }
    }

    private void setScreenTagBasedOnSearchType()
    {
        SearchFilterModel searchfiltermodel = getFilterModel();
        if (searchfiltermodel != null)
        {
            screenStackTag = searchfiltermodel.getSearchTrigger();
        }
        if (screenStackTag != null)
        {
            setTrackingLabel(screenStackTag);
        }
    }

    private void setupHeader()
    {
        if (brand == null)
        {
            PMApi.getBrandMetaData(brandName, new PMApiResponseHandler() {

                final BrandFragment_v1 this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        if (!pmapiresponse.hasError())
                        {
                            brand = (Brand)pmapiresponse.data;
                            brandName = brand.canonical_name;
                            brandUnknown = false;
                            handleBrandShareTrigger();
                        } else
                        {
                            brandUnknown = true;
                        }
                        populateHeaderViews();
                    }
                }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
            });
            return;
        } else
        {
            populateHeaderViews();
            return;
        }
    }

    private void setupHeaderViewHolder(View view)
    {
        view = LayoutInflater.from(getActivity());
        brandHeaderViewHolder = new BrandHeaderViewHolder();
        if (currentMode == MODE.JUST_IN)
        {
            headerView = view.inflate(0x7f030015, null);
        } else
        {
            headerView = view.inflate(0x7f030014, null);
            brandHeaderViewHolder.justInButton = (Button)headerView.findViewById(0x7f0c0073);
            brandHeaderViewHolder.justInButton.setOnClickListener(new android.view.View.OnClickListener() {

                final BrandFragment_v1 this$0;

                public void onClick(View view1)
                {
                    view1 = new Bundle();
                    view1.putString("NAME", brandName);
                    view1.putString("MODE", MODE.JUST_IN.toString());
                    ((PMContainerActivity)getActivity()).launchFragment(view1, com/poshmark/ui/fragments/BrandFragment_v1, null);
                }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
            });
        }
        brandHeaderViewHolder.shareTriggerLayout = (RelativeLayout)headerView.findViewById(0x7f0c006b);
        brandHeaderViewHolder.cancelTriggerButton = (ImageView)headerView.findViewById(0x7f0c006d);
        brandHeaderViewHolder.inviteFriendsButton = (PMButton)headerView.findViewById(0x7f0c0070);
        brandHeaderViewHolder.cancelTriggerButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BrandFragment_v1 this$0;

            public void onClick(View view1)
            {
                brandHeaderViewHolder.shareTriggerLayout.setVisibility(8);
                view1 = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
                if (view1 != null)
                {
                    view1.setNewState(com.poshmark.triggers.PMTrigger.TriggerState.DISMISSED);
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_close_button_tapped", brandName);
                }
            }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
        });
        brandHeaderViewHolder.inviteFriendsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BrandFragment_v1 this$0;

            public void onClick(View view1)
            {
                view1 = (PMActivity)getActivity();
                if (isAdded() && brand != null)
                {
                    Object obj = PMTriggerManager.getGlobalTriggerManager().getBrandShareTrigger();
                    if (obj != null)
                    {
                        ((BrandShareTrigger) (obj)).setNewState(com.poshmark.triggers.PMTrigger.TriggerState.INTERACTED);
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "brand_share_banner_invite_friends_button_tapped", brandName);
                    }
                    obj = new Bundle();
                    ((Bundle) (obj)).putString("MODE", com.poshmark.utils.ShareManager.SHARE_MODE.SHARE_MODE_BRAND.name());
                    view1.launchFragment(((Bundle) (obj)), com/poshmark/ui/fragments/ShareFragment, brand);
                }
            }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
        });
        brandHeaderViewHolder.backgroundImage = (ImageView)headerView.findViewById(0x7f0c0062);
        brandHeaderViewHolder.brandTitleView = (PMTextView)headerView.findViewById(0x7f0c0056);
        brandHeaderViewHolder.followFollowingButtonLayout = (BrandFollowButtonLayout)headerView.findViewById(0x7f0c0066);
        brandHeaderViewHolder.followFollowingButtonContainer = (LinearLayout)headerView.findViewById(0x7f0c0065);
        brandHeaderViewHolder.unknownBrandButton = (Button)headerView.findViewById(0x7f0c0064);
        brandHeaderViewHolder.unknownBrandButton.setOnClickListener(new android.view.View.OnClickListener() {

            final BrandFragment_v1 this$0;

            public void onClick(View view1)
            {
                showAlertMessage("", getResources().getString(0x7f0602a5));
            }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
        });
        brandHeaderViewHolder.shareBrandBannerMessageView = (PMTextView)headerView.findViewById(0x7f0c006f);
        brandHeaderViewHolder.filterWidgetLayout = (LinearLayout)headerView.findViewById(0x7f0c0069);
        if (brand != null)
        {
            brandHeaderViewHolder.filterWidgetLayout.setVisibility(0);
        }
        filterWidget = (ListingsFilterWidget)headerView.findViewById(0x7f0c006a);
        filterWidget.setOwnerFragment(this);
    }

    private void setupSearchResultsList()
    {
        resultsListView.removeEmptyContentView();
        if (bUpdateOnShow || searchResultsData == null)
        {
            resultsListView.setSelection(0);
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            getSearchResults(false);
        } else
        {
            resultsListView.updateList();
            if (searchResultsData.isEmpty())
            {
                resultsListView.showDefaultEmptyContentView();
                return;
            }
        }
    }

    public void addCommentToListing(String s, Comment comment)
    {
    }

    public void deleteListing(String s)
    {
    }

    public void filterContent()
    {
        getFilterModel().clearNextPageId();
        searchResultsData = null;
        isFilterApplied = true;
        if (!getFilterModel().getBrand().equalsIgnoreCase(brandName))
        {
            brandName = getFilterModel().getBrand();
            brand = null;
        }
    }

    public void fireSearch()
    {
        ((PMContainerActivity)getActivity()).closeDrawer();
        getSearchResults(false);
    }

    public SearchFilterModel getFilterModel()
    {
        return getFilterManager().getSearchModel();
    }

    public String getTrackingLabel()
    {
        return "br";
    }

    public void handleNotification(Intent intent)
    {
        super.handleNotification(intent);
        if (intent.getAction().equals("com.poshmark.intents.SEARCH_FILTER_ACTION"))
        {
            getFilterModel().clearNextPageId();
            fireSearch();
        }
    }

    public void likeListing(String s, boolean flag)
    {
    }

    public void newListingCreated()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        if (bundle == null)
        {
            brandName = getArguments().getString("NAME");
            if (brandName == null)
            {
                brandName = getArguments().getString("ID");
            }
        } else
        {
            brandName = bundle.getString("BRAND_NAME");
        }
        getFilterModel().getPrimaryFilters().addBrand(brandName);
        keywordSource = getArguments().getString("KEYWORD_SOURCE");
        bundle = getArguments().getString("MODE");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        bundle = getFilterManager().getSearchModel().getSortBy();
        if (bundle == null || !bundle.equalsIgnoreCase("added_desc"))
        {
            currentMode = MODE.ALL;
            getFilterModel().setSearchTrigger("br");
        } else
        {
            currentMode = MODE.JUST_IN;
            getFilterModel().setSearchTrigger("brj");
        }
_L4:
        replaceTrackingLabel(getFilterModel().getSearchTrigger());
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        return;
_L2:
        currentMode = MODE.valueOf(bundle);
        if (currentMode == MODE.JUST_IN)
        {
            getFilterModel().setSortBy("added_desc");
            getFilterModel().setSearchTrigger("brj");
        } else
        if (currentMode == MODE.ALL)
        {
            getFilterModel().setSearchTrigger("br");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030026, viewgroup, false);
        setupHeaderViewHolder(layoutinflater);
        resultsListView = (PMListView)layoutinflater.findViewById(0x7f0c00c0);
        resultsListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final BrandFragment_v1 this$0;

            public void loadItems(boolean flag)
            {
                getSearchResults(flag);
            }

            
            {
                this$0 = BrandFragment_v1.this;
                super();
            }
        });
        setupHeader();
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (getUserVisibleHint())
        {
            setupSearchResultsList();
            bUpdateOnShow = false;
        }
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SEARCH_FILTER_ACTION", this);
        try
        {
            background = getResources().getDrawable(0x7f020111);
            if (background != null && brandHeaderViewHolder != null && brandHeaderViewHolder.backgroundImage != null)
            {
                brandHeaderViewHolder.backgroundImage.setImageDrawable(background);
                brandHeaderViewHolder.backgroundImage.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
        if (background != null && brandHeaderViewHolder != null && brandHeaderViewHolder.backgroundImage != null)
        {
            brandHeaderViewHolder.backgroundImage.setImageDrawable(null);
            background = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("BRAND_NAME", brandName);
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    protected void pullParametersFromState(Bundle bundle)
    {
        if (bundle == null)
        {
            bundle = (SearchFilterModel)getFragmentDataOfType(com/poshmark/utils/SearchFilterModel);
            if (bundle != null)
            {
                getFilterManager().setSearchModel(bundle);
            } else
            {
                bundle = new SearchFilterModel();
                bundle.setAvailability("available");
                UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
                if (userstatesummary != null && userstatesummary.user_info.isMySizeAvailable())
                {
                    bundle.enableMySizeFilter(true);
                }
                bundle.setFacet("category_v2");
                bundle.setFacet("size");
                getFilterManager().setSearchModel(bundle);
            }
        }
        setScreenTagBasedOnSearchType();
    }

    public void setViewNameForAnalytics()
    {
        if (currentMode == MODE.JUST_IN)
        {
            viewNameForAnalytics = "brand_just_in_screen";
            return;
        } else
        {
            viewNameForAnalytics = "brand_screen";
            return;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (currentMode == MODE.JUST_IN)
        {
            setTitle("Just In");
        } else
        {
            setTitle(brandName);
        }
        if (!brandUnknown)
        {
            setNextActionButton(getString(0x7f06024e), shareButtonListener);
        }
    }

    public void updateListing(ListingDetails listingdetails)
    {
    }




/*
    static Brand access$102(BrandFragment_v1 brandfragment_v1, Brand brand1)
    {
        brandfragment_v1.brand = brand1;
        return brand1;
    }

*/



/*
    static String access$202(BrandFragment_v1 brandfragment_v1, String s)
    {
        brandfragment_v1.brandName = s;
        return s;
    }

*/




}
