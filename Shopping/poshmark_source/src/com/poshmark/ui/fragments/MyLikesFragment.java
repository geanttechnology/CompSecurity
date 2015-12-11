// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.adapters.BundlesAdapter;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.data_model.models.MyBundles;
import com.poshmark.data_model.models.MyLikes;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.Comment;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.CollectionSortWidget;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.CollectionSortWidgetListener;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ImageUtils;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.view_holders.BundleViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, MappPageFragment, ViewBundleFragment

public class MyLikesFragment extends PMFilterableFragment
    implements ListingNotificationHandler, CollectionSortWidgetListener
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE ALL;
        public static final MODE BUNDLES;
        public static final MODE PRICE_DROP;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/MyLikesFragment$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            BUNDLES = new MODE("BUNDLES", 0);
            ALL = new MODE("ALL", 1);
            PRICE_DROP = new MODE("PRICE_DROP", 2);
            $VALUES = (new MODE[] {
                BUNDLES, ALL, PRICE_DROP
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    private static String screenTag = "mlk";
    private ListingSummaryAdapter adapter;
    Bitmap backgroundBmp;
    private BundlesAdapter bundlesAdapter;
    private boolean callFromUserSettings;
    MODE currentMode;
    View headerView;
    private MyBundles myBundles;
    private PMListView myBundlesListView;
    private MyLikes myLikes;
    private PMListView myLikesListView;

    public MyLikesFragment()
    {
        adapter = null;
        myLikes = null;
    }

    private void getMyBundles(boolean flag)
    {
        if (!flag)
        {
            myBundlesListView.removeEmptyContentView();
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            searchManager.getSearchRequestString();
            PMApi.getMyBundles(null, new PMApiResponseHandler() {

                final MyLikesFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleMyBundlesApiResponse(pmapiresponse, false);
                    }
                }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
            });
        } else
        if (myBundles.getNextPageMaxValue() != null)
        {
            PMApi.getMyBundles(myBundles.getNextPageMaxValue(), new PMApiResponseHandler() {

                final MyLikesFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        handleMyBundlesApiResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void getMyLikes(boolean flag)
    {
        if (flag) goto _L2; else goto _L1
_L1:
        if (!isFilterApplied) goto _L4; else goto _L3
_L3:
        myLikesListView.removeEmptyContentView();
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        PMApi.getMyLikedListingsFiltered(null, searchManager.getSearchRequestString(), getFilterModel().getSearchTrigger(), new PMApiResponseHandler() {

            final MyLikesFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    MyLikesFragment.this.handleResponse(pmapiresponse, false);
                    if (filterWidget != null)
                    {
                        filterWidget.setVisibility(0);
                    }
                }
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
_L6:
        return;
_L4:
        myLikesListView.removeEmptyContentView();
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        searchManager.getSearchRequestString();
        PMApi.getMyLikedListings(null, new PMApiResponseHandler() {

            final MyLikesFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    MyLikesFragment.this.handleResponse(pmapiresponse, false);
                }
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        return;
_L2:
        if (!isFilterApplied)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (myLikes.getNextPageMaxValue() == null) goto _L6; else goto _L5
_L5:
        getFilterModel().setNextPageId(myLikes.getNextPageMaxValue());
        String s = searchManager.getSearchRequestString();
        PMApi.getMyLikedListingsFiltered(myLikes.getNextPageMaxValue(), s, null, new PMApiResponseHandler() {

            final MyLikesFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    MyLikesFragment.this.handleResponse(pmapiresponse, true);
                }
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        return;
        if (myLikes.getNextPageMaxValue() == null) goto _L6; else goto _L7
_L7:
        getFilterModel().setNextPageId(myLikes.getNextPageMaxValue());
        searchManager.getSearchRequestString();
        PMApi.getMyLikedListings(myLikes.getNextPageMaxValue(), new PMApiResponseHandler() {

            final MyLikesFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    MyLikesFragment.this.handleResponse(pmapiresponse, true);
                }
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        return;
    }

    private void handleMyBundlesApiResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        myBundles = (MyBundles)pmapiresponse.data;
        myBundlesListView.setListData(myBundles);
        myBundlesListView.updateList();
        myBundlesListView.setSelection(0);
        if (myBundles.isEmpty())
        {
            showEmptyMyBundlesMessage();
        }
_L6:
        return;
_L4:
        myBundles.append((PMData)pmapiresponse.data);
        myBundlesListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_MY_LIKES, PMApplication.getContext().getString(0x7f0600e8)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void handleResponse(PMApiResponse pmapiresponse, boolean flag)
    {
        hideProgressDialog();
        if (pmapiresponse.hasError()) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        myLikes = (MyLikes)pmapiresponse.data;
        myLikesListView.setListData(myLikes);
        myLikesListView.updateList();
        myLikesListView.setSelection(0);
        if (myLikes.isEmpty())
        {
            myLikesListView.showDefaultEmptyContentView();
        }
_L6:
        return;
_L4:
        myLikes.append((PMData)pmapiresponse.data);
        myLikesListView.updateList();
        return;
_L2:
        if (!flag)
        {
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.LOAD_MY_LIKES, PMApplication.getContext().getString(0x7f0600e8)));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
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

    private View setupHeaderView(View view)
    {
        Object obj;
label0:
        {
            view = null;
            boolean flag = FeatureManager.getGlobalFeatureManager().isBrandPriceDropEnabled();
            boolean flag1 = FeatureManager.getGlobalFeatureManager().isMyLikesFiltersEnabled();
            if (flag || flag1)
            {
                view = LayoutInflater.from(getActivity()).inflate(0x7f03008b, null);
                obj = (FrameLayout)view.findViewById(0x7f0c020a);
                if (flag)
                {
                    obj = (CollectionSortWidget)view.findViewById(0x7f0c0068);
                    ((CollectionSortWidget) (obj)).setSortSelectionListener(this);
                    ((CollectionSortWidget) (obj)).setLeftButtonText(getResources().getString(0x7f06003c));
                    ((CollectionSortWidget) (obj)).setCenterButtonText(getResources().getString(0x7f060068));
                    ((CollectionSortWidget) (obj)).setRightButtonText(getResources().getString(0x7f06021b));
                    if (currentMode == MODE.BUNDLES)
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
                    ((FrameLayout) (obj)).setVisibility(8);
                }
                obj = (LinearLayout)view.findViewById(0x7f0c0069);
                if (!flag1)
                {
                    break label0;
                }
                filterWidget = (ListingsFilterWidget)view.findViewById(0x7f0c006a);
                filterWidget.setOwnerFragment(this);
            }
            return view;
        }
        ((LinearLayout) (obj)).setVisibility(8);
        return view;
    }

    private void setupMyLikesList()
    {
        if (currentMode == MODE.BUNDLES) goto _L2; else goto _L1
_L1:
        myLikesListView.removeEmptyContentView();
        if (!bUpdateOnShow && myLikes != null) goto _L4; else goto _L3
_L3:
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            getMyLikes(false);
        }
_L6:
        return;
_L4:
        myLikesListView.updateList();
        if (myLikes.isEmpty())
        {
            showEmptyMyLikesMessage();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        myBundlesListView.removeEmptyContentView();
        if (!bUpdateOnShow && myBundles != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            showProgressDialogWithMessage(getResources().getString(0x7f060190));
            getMyBundles(false);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
        myBundlesListView.updateList();
        if (myBundles.isEmpty())
        {
            showEmptyMyBundlesMessage();
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    private void showEmptyMyBundlesMessage()
    {
        LinearLayout linearlayout = (LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f03003c, null);
        myBundlesListView.showEmptyContentView(linearlayout);
        ((PMButton)linearlayout.findViewById(0x7f0c010c)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyLikesFragment this$0;

            public void onClick(View view)
            {
                view = new Bundle();
                view.putString("URL", "https://www.poshmark.com/mapp/bundles_help");
                view.putString("ANALYTICS_PAGE_NAME", "bundle_learn_more_screen");
                ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
    }

    private void showEmptyMyLikesMessage()
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        if (myLikesListView.getHeaderViewsCount() == 0)
        {
            myLikesListView.showEmptyContentView(layoutinflater.inflate(0x7f03003d, null));
        }
    }

    public void addCommentToListing(String s, Comment comment)
    {
    }

    public void deleteListing(String s)
    {
        bUpdateOnShow = true;
    }

    public void filterContent()
    {
        getFilterModel().clearNextPageId();
        myLikes = null;
        isFilterApplied = true;
    }

    public void fireSearch()
    {
        ((PMContainerActivity)getActivity()).closeDrawer();
        getMyLikes(false);
    }

    public SearchFilterModel getFilterModel()
    {
        return getFilterManager().getSearchModel();
    }

    public String getTrackingLabel()
    {
        return screenTag;
    }

    public void handleNotification(final Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.FILTER_SELECTION_ACTION"))
        {
            if (!facetsAvailable())
            {
                showProgressDialogWithMessage(null);
                getFilterManager().getSearchModel().setCount("1");
                PMApi.getMyLikesFacets(getFilterManager().getSearchRequestString(), new PMApiResponseHandler() {

                    final MyLikesFragment this$0;
                    final Intent val$intent;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        hideProgressDialog();
                        getFilterManager().getSearchModel().clearCount();
                        if (isAdded() && !pmapiresponse.hasError())
                        {
                            saveFacetLists(((MyLikes)pmapiresponse.data).getFacets());
                            handleNotification(intent);
                        }
                    }

            
            {
                this$0 = MyLikesFragment.this;
                intent = intent1;
                super();
            }
                });
            } else
            {
                super.handleNotification(intent);
            }
        }
        if (intent.getAction().equals("com.poshmark.intents.LOGOUT_COMPLETE"))
        {
            myLikes = null;
        } else
        if (intent.getAction().equals("com.poshmark.intents.LOGIN_COMPLETE"))
        {
            bUpdateOnShow = true;
            return;
        }
    }

    public void likeListing(String s, boolean flag)
    {
        bUpdateOnShow = true;
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
        bundle = getArguments();
        if (bundle != null)
        {
            boolean flag;
            if (bundle.getBoolean("callFromUserSettings"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            callFromUserSettings = flag;
        }
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGIN_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.LOGOUT_COMPLETE", this);
        ListingNotificationManager.getListingNotificationManager().registerListingMessageHandler(this);
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        bundlesAdapter = new BundlesAdapter(getActivity(), this, null, 0x80000000);
        bUpdateOnShow = true;
        bundle = null;
        if (getArguments() != null)
        {
            bundle = getArguments().getString("MODE");
        }
        if (bundle == null)
        {
            bundle = getFilterManager().getSearchModel().getSortBy();
            if (bundle != null && bundle.equalsIgnoreCase("price_drop"))
            {
                currentMode = MODE.PRICE_DROP;
                getFilterModel().setSearchTrigger("mlkpd");
                replaceTrackingLabel(getFilterModel().getSearchTrigger());
                return;
            } else
            {
                currentMode = MODE.ALL;
                getFilterModel().setSearchTrigger("mlk");
                replaceTrackingLabel(getFilterModel().getSearchTrigger());
                return;
            }
        }
        currentMode = MODE.valueOf(bundle);
        if (currentMode == MODE.ALL)
        {
            getFilterModel().setSearchTrigger("mlk");
            replaceTrackingLabel(getFilterModel().getSearchTrigger());
            return;
        }
        if (currentMode == MODE.PRICE_DROP)
        {
            getFilterModel().setSearchTrigger("mlkpd");
            replaceTrackingLabel(getFilterModel().getSearchTrigger());
            return;
        } else
        {
            replaceTrackingLabel("mbnd");
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03008d, viewgroup, false);
        myLikesListView = (PMListView)layoutinflater.findViewById(0x7f0c020e);
        headerView = setupHeaderView(layoutinflater);
        myLikesListView.setup(adapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final MyLikesFragment this$0;

            public void loadItems(boolean flag)
            {
                getMyLikes(true);
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        myBundlesListView = (PMListView)layoutinflater.findViewById(0x7f0c020f);
        myBundlesListView.setup(bundlesAdapter, headerView, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final MyLikesFragment this$0;

            public void loadItems(boolean flag)
            {
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        myBundlesListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MyLikesFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CustomMatrixCursor)bundlesAdapter.getCursor();
                adapterview.moveToPosition(i - 1);
                adapterview = (PMBundle)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
                view = (BundleViewHolder)view.getTag();
                view = getParentActivity();
                Bundle bundle1 = new Bundle();
                bundle1.putString("ID", adapterview.getSellerId());
                view.launchFragment(bundle1, com/poshmark/ui/fragments/ViewBundleFragment, null);
            }

            
            {
                this$0 = MyLikesFragment.this;
                super();
            }
        });
        if (currentMode == MODE.BUNDLES)
        {
            myBundlesListView.setVisibility(0);
            showFilterWidget(false);
            return layoutinflater;
        } else
        {
            myLikesListView.setVisibility(0);
            showFilterWidget(true);
            return layoutinflater;
        }
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (getUserVisibleHint())
        {
            setupMyLikesList();
            bUpdateOnShow = false;
        }
        ImageView imageview;
        try
        {
            if (headerView == null)
            {
                break MISSING_BLOCK_LABEL_108;
            }
            int i = getActivity().getWindowManager().getDefaultDisplay().getWidth();
            int j = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 120F);
            backgroundBmp = ImageUtils.loadScaledBitmapFromResource(getResources(), 0x7f020112, i, j, true);
            if (backgroundBmp == null)
            {
                break MISSING_BLOCK_LABEL_108;
            }
            imageview = (ImageView)headerView.findViewById(0x7f0c0062);
        }
        catch (Exception exception)
        {
            return;
        }
        if (imageview == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        imageview.setImageBitmap(backgroundBmp);
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
        if (headerView != null && backgroundBmp != null)
        {
            ImageView imageview = (ImageView)headerView.findViewById(0x7f0c0062);
            if (imageview != null)
            {
                imageview.setImageBitmap(null);
            }
            backgroundBmp.recycle();
            backgroundBmp = null;
        }
    }

    protected void pullParametersFromState(Bundle bundle)
    {
label0:
        {
            if (bundle == null)
            {
                bundle = (SearchFilterModel)getFragmentDataOfType(com/poshmark/utils/SearchFilterModel);
                if (bundle == null)
                {
                    break label0;
                }
                getFilterManager().setSearchModel(bundle);
            }
            return;
        }
        bundle = new SearchFilterModel();
        bundle.setFacet("category_v2");
        bundle.setFacet("category_feature");
        bundle.setFacet("color");
        bundle.setFacet("size");
        bundle.setFacet("brand");
        bundle.setSearchTrigger("mlk");
        getFilterManager().setSearchModel(bundle);
    }

    public void setActionBarTitle()
    {
        TextView textview = (TextView)getActivity().getActionBar().getCustomView().findViewById(0x7f0c0035);
        textview.setText(getString(0x7f0601b2));
        textview.setVisibility(0);
    }

    public void setViewNameForAnalytics()
    {
        if (currentMode == MODE.BUNDLES)
        {
            viewNameForAnalytics = "my_bundles_screen";
        } else
        {
            if (currentMode == MODE.ALL)
            {
                viewNameForAnalytics = "listings_liked_screen";
                return;
            }
            if (currentMode == MODE.PRICE_DROP)
            {
                viewNameForAnalytics = "listings_liked_price_drop_screen";
                return;
            }
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setActionBarTitle();
    }

    public void showBundles()
    {
        Analytics.getInstance().trackView("my_bundles_screen");
        Analytics.getInstance().trackEvent("my_bundles_screen", "bundle", "view_my_bundles_tapped", null);
        currentMode = MODE.BUNDLES;
        showFilterWidget(false);
        myLikesListView.setVisibility(8);
        myBundlesListView.setVisibility(0);
        replaceTrackingLabel("mbnd");
        getMyBundles(false);
    }

    public void showFilterWidget(boolean flag)
    {
        LinearLayout linearlayout = (LinearLayout)headerView.findViewById(0x7f0c0069);
        if (flag)
        {
            linearlayout.setVisibility(0);
            return;
        } else
        {
            linearlayout.setVisibility(8);
            return;
        }
    }

    public void sortAll()
    {
        myLikesListView.setVisibility(0);
        showFilterWidget(true);
        myBundlesListView.setVisibility(8);
        getFilterModel().clearNextPageId();
        myLikes = null;
        isFilterApplied = true;
        getFilterModel().clearSortBy();
        getFilterModel().setSearchTrigger("mlk");
        replaceTrackingLabel("mlk");
        currentMode = MODE.ALL;
        fireSearch();
        Analytics.getInstance().trackView("listings_liked_screen");
    }

    public void sortPriceDrop()
    {
        myLikesListView.setVisibility(0);
        showFilterWidget(true);
        myBundlesListView.setVisibility(8);
        getFilterModel().clearNextPageId();
        myLikes = null;
        isFilterApplied = true;
        getFilterModel().setSortBy("price_drop");
        getFilterModel().setSearchTrigger("mlkpd");
        replaceTrackingLabel("mlkpd");
        currentMode = MODE.PRICE_DROP;
        fireSearch();
        Analytics.getInstance().trackView("listings_liked_price_drop_screen");
    }

    public void sortWidgetClicked(com.poshmark.ui.customviews.CollectionSortWidget.SortType sorttype)
    {
        static class _cls12
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

        switch (_cls12..SwitchMap.com.poshmark.ui.customviews.CollectionSortWidget.SortType[sorttype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            sortAll();
            return;

        case 2: // '\002'
            showBundles();
            return;

        case 3: // '\003'
            sortPriceDrop();
            break;
        }
    }

    public void updateListing(ListingDetails listingdetails)
    {
    }





}
