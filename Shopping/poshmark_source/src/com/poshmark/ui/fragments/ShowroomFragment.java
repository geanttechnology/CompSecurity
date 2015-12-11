// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.controllers.ShowroomsController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.ShowroomListings;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.data_model.models.inner_models.CoverShot;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.CollectionSortWidget;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CollectionSortWidgetListener;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.meta_data.AvailabilityMetaData;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, ShareFragment

public class ShowroomFragment extends PMFilterableFragment
    implements PMNotificationListener, CollectionSortWidgetListener
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE ALL;
        public static final MODE JUST_IN;
        public static final MODE PRICE_DROP;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/ShowroomFragment$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            JUST_IN = new MODE("JUST_IN", 0);
            ALL = new MODE("ALL", 1);
            PRICE_DROP = new MODE("PRICE_DROP", 2);
            $VALUES = (new MODE[] {
                JUST_IN, ALL, PRICE_DROP
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    private CursorAdapter adapter;
    private Drawable background;
    MODE currentMode;
    private LinearLayout filterWidgetLayout;
    private View headerView;
    private Showroom showroom;
    private ShowroomListings showroomData;
    private String showroomId;
    private PMListView showroomListView;

    public ShowroomFragment()
    {
        showroomData = null;
    }

    private void createShowroomHeaderView()
    {
        boolean flag = FeatureManager.getGlobalFeatureManager().isShowroomPriceDropEnabled();
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f0300ba, null);
        Object obj = (LinearLayout)headerView.findViewById(0x7f0c0067);
        if (flag)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            obj = (CollectionSortWidget)headerView.findViewById(0x7f0c0068);
            ((CollectionSortWidget) (obj)).setSortSelectionListener(this);
            ((CollectionSortWidget) (obj)).setLeftButtonText(getResources().getString(0x7f06003c));
            ((CollectionSortWidget) (obj)).setCenterButtonText(getResources().getString(0x7f06015c));
            ((CollectionSortWidget) (obj)).setRightButtonText(getResources().getString(0x7f06021b));
            if (currentMode == MODE.JUST_IN)
            {
                ((CollectionSortWidget) (obj)).selectCenterButton();
            } else
            if (currentMode == MODE.PRICE_DROP)
            {
                ((CollectionSortWidget) (obj)).selectRightButton();
            } else
            {
                ((CollectionSortWidget) (obj)).selectLeftButton();
            }
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
        }
        if (showroom != null)
        {
            updateHeaderView();
        }
    }

    private void getShowroomListings(boolean flag)
    {
        if (isFilterApplied && showroom != null)
        {
            loadFilterResults(flag);
            return;
        } else
        {
            loadShowroomListings(flag);
            return;
        }
    }

    private void handleFilterResultsResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            Object obj = getFilterManager().getSearchModel().getLabelForAnalytics();
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listings_filtered", ((String) (obj)));
            obj = (PMData)pmapiresponse.data;
            if (!flag)
            {
                showroomData = (ShowroomListings)pmapiresponse.data;
                showroomListView.setListData(showroomData);
                showroomListView.updateList();
                saveFacetLists(showroomData.getFacets());
                showroomListView.setSelection(0);
                if (showroomData.isEmpty())
                {
                    showroomListView.showDefaultEmptyContentView();
                }
                return;
            } else
            {
                showroomData.append(((PMData) (obj)));
                showroomListView.updateList();
                return;
            }
        } else
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_LISTING));
            return;
        }
    }

    private void handleShowroomListingsResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        showroomData = (ShowroomListings)pmapiresponse.data;
        showroomData.createHashAndRemoveDups();
        showroomListView.setListData(showroomData);
        showroomListView.updateList();
        showroomListView.setSelection(0);
        saveFacetLists(showroomData.getFacets());
        if (((ShowroomListings)pmapiresponse.data).isEmpty())
        {
            showroomListView.showDefaultEmptyContentView();
        }
_L6:
        return;
_L4:
        showroomData.append((PMData)pmapiresponse.data);
        showroomListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_SHOWROOM_LISTINGS, PMApplication.getContext().getString(0x7f0600ee)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void loadFilterResults(boolean flag)
    {
        Object obj = null;
        String s = ((String) (obj));
        if (flag)
        {
            s = ((String) (obj));
            if (showroomData != null)
            {
                obj = showroomData.getNextPageMaxValue();
                s = ((String) (obj));
                if (obj != null)
                {
                    getFilterManager().getSearchModel().setNextPageId(((String) (obj)));
                    s = ((String) (obj));
                }
            }
        }
        obj = (new GsonBuilder()).create();
        SearchFilterModel searchfiltermodel = getFilterManager().getSearchModel();
        if (!(obj instanceof Gson))
        {
            obj = ((Gson) (obj)).toJson(searchfiltermodel);
        } else
        {
            obj = GsonInstrumentation.toJson((Gson)obj, searchfiltermodel);
        }
        if (flag)
        {
            PMApi.getShowroomListings(showroomId, s, ((String) (obj)), getFilterModel().getSearchTrigger(), new PMApiResponseHandler() {

                final ShowroomFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleFilterResultsResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
            });
            return;
        } else
        {
            showroomListView.removeEmptyContentView();
            PMApi.getShowroomListings(showroomId, s, ((String) (obj)), getFilterModel().getSearchTrigger(), new PMApiResponseHandler() {

                final ShowroomFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleFilterResultsResponse(pmapiresponse, false);
                        hideFilterButtonsForSingleFacet();
                        filterWidgetLayout.setVisibility(0);
                    }
                }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void loadShowroom()
    {
        PMApi.getShowroom(showroomId, new PMApiResponseHandler() {

            final ShowroomFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded() && !pmapiresponse.hasError())
                {
                    showroom = (Showroom)pmapiresponse.data;
                    getShowroomListings(false);
                    updateHeaderView();
                }
            }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
        });
    }

    private void loadShowroomListings(boolean flag)
    {
        if (!flag)
        {
            showroomListView.removeEmptyContentView();
            PMApi.getShowroomListings(showroomId, null, null, getFilterModel().getSearchTrigger(), new PMApiResponseHandler() {

                final ShowroomFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        handleShowroomListingsResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
            });
            return;
        } else
        {
            PMApi.getShowroomListings(showroomId, showroomData.getNextPageMaxValue(), null, getFilterModel().getSearchTrigger(), new PMApiResponseHandler() {

                final ShowroomFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded() && !pmapiresponse.hasError())
                    {
                        handleShowroomListingsResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setScreenTagBasedOnSearchType()
    {
        String s = null;
        SearchFilterModel searchfiltermodel = getFilterModel();
        if (searchfiltermodel != null)
        {
            s = searchfiltermodel.getSearchTrigger();
        }
        if (s != null)
        {
            setTrackingLabel(s);
        }
    }

    private void setupActionBarShareActionButton()
    {
        Button button = getNextActionButton();
        if (button == null)
        {
            return;
        } else
        {
            button.setText(getString(0x7f06024e));
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final ShowroomFragment this$0;

                public void onClick(View view)
                {
                    shareShowroom();
                }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setupListView()
    {
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        createShowroomHeaderView();
        showroomListView = (PMListView)getView().findViewById(0x7f0c025a);
        filterWidgetLayout = (LinearLayout)headerView.findViewById(0x7f0c0069);
        filterWidget = (ListingsFilterWidget)headerView.findViewById(0x7f0c006a);
        filterWidget.setOwnerFragment(this);
        showroomListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final ShowroomFragment this$0;

            public void loadItems(boolean flag)
            {
                getShowroomListings(flag);
            }

            
            {
                this$0 = ShowroomFragment.this;
                super();
            }
        });
        if (PMApplicationSession.GetPMSession().isLoggedIn() && showroomData == null && showroom != null)
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            getShowroomListings(false);
        }
        if (showroomData != null)
        {
            showroomListView.setListData(showroomData);
            filterWidgetLayout.setVisibility(0);
            hideFilterButtonsForSingleFacet();
        }
    }

    private void shareShowroom()
    {
        Bundle bundle = new Bundle();
        bundle.putString("MODE", com.poshmark.utils.ShareManager_Old.SHARE_MODE.SHARE_MODE_SHOWROOM.name());
        ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShareFragment, showroom);
    }

    private void updateHeaderView()
    {
        ImageView imageview = (ImageView)headerView.findViewById(0x7f0c02d2);
        ImageLoader imageloader = ImageLoader.getInstance();
        imageloader.displayImage(showroom.getCoverShot().url, imageview);
        imageview = (ImageView)headerView.findViewById(0x7f0c0062);
        if (imageview != null)
        {
            imageloader.displayImage(showroom.getCoverShot().url, imageview);
        }
        ((PMTextView)headerView.findViewById(0x7f0c0241)).setText(showroom.getName());
    }

    public void filterContent()
    {
        showroomData = null;
    }

    public void fireSearch()
    {
        isFilterApplied = true;
        showProgressDialogWithMessage(getString(0x7f060190));
        loadFilterResults(false);
    }

    public SearchFilterModel getFilterModel()
    {
        return getFilterManager().getSearchModel();
    }

    public String getTrackingLabel()
    {
        return "shr";
    }

    public void handleNotification(Intent intent)
    {
        super.handleNotification(intent);
        if (intent.getAction().equals("com.poshmark.intents.SEARCH_FILTER_ACTION"))
        {
            intent = intent.getBundleExtra("RESULT");
            ParcelUuid parceluuid = (ParcelUuid)intent.getParcelable("PARENT_ID");
            if (fragmentId.equals(parceluuid.getUuid()))
            {
                intent.getString("SEARCH_FILTER_MODEL_JSON");
                fireSearch();
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupListView();
        if (showroom == null)
        {
            loadShowroom();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = ((Bundle) (getFragmentDataOfType(com/poshmark/data_model/models/Showroom)));
        if (bundle != null)
        {
            showroom = (Showroom)bundle;
            showroomId = showroom.getId();
        } else
        {
            showroomId = getArguments().getString("ID");
            showroom = ShowroomsController.getGlobalShowroomsController().getShowroomWithId(showroomId);
        }
        isFilterApplied = true;
        getFilterManager().updateAvailability(AvailabilityMetaData.getAvailabilityMetaItemFromLabel("available"));
        bundle = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (bundle != null && ((UserStateSummary) (bundle)).user_info.isMySizeAvailable())
        {
            getFilterManager().getSearchModel().enableMySizeFilter(true);
        }
        bundle = getArguments().getString("MODE");
        if (bundle != null) goto _L2; else goto _L1
_L1:
        bundle = getFilterManager().getSearchModel().getSortBy();
        if (bundle != null && bundle.equalsIgnoreCase("added_desc"))
        {
            currentMode = MODE.JUST_IN;
            getFilterModel().setSearchTrigger("shrj");
        } else
        if (bundle != null && bundle.equalsIgnoreCase("price_drop"))
        {
            currentMode = MODE.PRICE_DROP;
            getFilterModel().setSearchTrigger("shrpd");
        } else
        {
            currentMode = MODE.ALL;
            getFilterModel().setSearchTrigger("shr");
        }
_L4:
        replaceTrackingLabel(getFilterModel().getSearchTrigger());
        return;
_L2:
        currentMode = MODE.valueOf(bundle);
        if (currentMode == MODE.JUST_IN)
        {
            getFilterModel().setSortBy("added_desc");
            getFilterModel().setSearchTrigger("shrj");
        } else
        if (currentMode == MODE.ALL)
        {
            getFilterModel().setSearchTrigger("shr");
        } else
        if (currentMode == MODE.PRICE_DROP)
        {
            getFilterModel().setSearchTrigger("shrpd");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300bc, viewgroup, false);
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onResume()
    {
        super.onResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SEARCH_FILTER_ACTION", this);
        if (showroomListView != null)
        {
            showroomListView.updateList();
        }
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
                bundle.setFacet("category_feature");
                bundle.setFacet("brand");
                bundle.setFacet("size");
                bundle.setFacet("color");
                getFilterManager().setSearchModel(bundle);
            }
        }
        setScreenTagBasedOnSearchType();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "showroom_feed_screen";
    }

    public void setupActionBar()
    {
        if (getUserVisibleHint())
        {
            super.setupActionBar();
            setupActionBarShareActionButton();
            setTitle(0x7f06026e);
        }
    }

    public void sortAll()
    {
        getFilterModel().clearNextPageId();
        showroomData = null;
        isFilterApplied = true;
        getFilterModel().clearSortBy();
        getFilterModel().setSearchTrigger("shr");
        replaceTrackingLabel("shr");
        currentMode = MODE.ALL;
        fireSearch();
        Analytics.getInstance().trackView("showroom_feed_screen");
    }

    public void sortJustIn()
    {
        getFilterModel().clearNextPageId();
        showroomData = null;
        isFilterApplied = true;
        getFilterModel().setSortBy("added_desc");
        getFilterModel().setSearchTrigger("shrj");
        replaceTrackingLabel("shrj");
        currentMode = MODE.JUST_IN;
        fireSearch();
        Analytics.getInstance().trackView("showroom_just_in_screen");
    }

    public void sortPriceDrop()
    {
        getFilterModel().clearNextPageId();
        showroomData = null;
        isFilterApplied = true;
        getFilterModel().setSortBy("price_drop");
        getFilterModel().setSearchTrigger("shrpd");
        replaceTrackingLabel("shrpd");
        currentMode = MODE.PRICE_DROP;
        fireSearch();
        Analytics.getInstance().trackView("showroom_price_drop_screen");
    }

    public void sortWidgetClicked(com.poshmark.ui.customviews.CollectionSortWidget.SortType sorttype)
    {
        static class _cls8
        {

            static final int $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[];

            static 
            {
                $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType = new int[com.poshmark.ui.customviews.CollectionSortWidget.SortType.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[com.poshmark.ui.customviews.CollectionSortWidget.SortType.Left.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[com.poshmark.ui.customviews.CollectionSortWidget.SortType.Center.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$customviews$CollectionSortWidget$SortType[com.poshmark.ui.customviews.CollectionSortWidget.SortType.Right.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls8..SwitchMap.com.poshmark.ui.customviews.CollectionSortWidget.SortType[sorttype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            sortAll();
            return;

        case 2: // '\002'
            sortJustIn();
            return;

        case 3: // '\003'
            sortPriceDrop();
            break;
        }
    }




/*
    static Showroom access$202(ShowroomFragment showroomfragment, Showroom showroom1)
    {
        showroomfragment.showroom = showroom1;
        return showroom1;
    }

*/




}
