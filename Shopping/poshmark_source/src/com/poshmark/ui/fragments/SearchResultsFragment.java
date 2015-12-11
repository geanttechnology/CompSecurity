// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.poshmark.analytics.Analytics;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.SearchResults;
import com.poshmark.db.DbApi;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.ui.customviews.PMCustomSearchWidget;
import com.poshmark.ui.customviews.PMListView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFilterableFragment, BrandFragment

public class SearchResultsFragment extends PMFilterableFragment
    implements PMNotificationListener
{

    private ListingSummaryAdapter adapter;
    String keywordSource;
    PMListView resultsListView;
    String screenStackTag;
    SearchResults searchResultsData;
    String searchTrigger;
    PMCustomSearchWidget searchView;

    public SearchResultsFragment()
    {
        adapter = null;
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
            PMApi.getSearchResults(searchManager.getSearchRequestString(), null, searchTrigger, keywordSource, new PMApiResponseHandler() {

                final SearchResultsFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        SearchResultsFragment.this.handleResponse(pmapiresponse, false);
                        hideFilterButtonsForSingleFacet();
                        filterWidget.setVisibility(0);
                    }
                }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
            });
        } else
        if (searchResultsData.getNextPageMaxValue() != null)
        {
            getFilterModel().setNextPageId(searchResultsData.getNextPageMaxValue());
            PMApi.getSearchResults(searchManager.getSearchRequestString(), searchResultsData.getNextPageMaxValue(), null, null, new PMApiResponseHandler() {

                final SearchResultsFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (isAdded())
                    {
                        SearchResultsFragment.this.handleResponse(pmapiresponse, true);
                    }
                }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
            });
            return;
        }
    }

    private String getSearchTitle()
    {
        Object obj;
        String s;
        Object obj1;
        s = "";
        obj1 = getFilterModel();
        obj = s;
        if (searchTrigger == null) goto _L2; else goto _L1
_L1:
        obj = s;
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        if (!searchTrigger.equalsIgnoreCase("br")) goto _L5; else goto _L4
_L4:
        s = ((SearchFilterModel) (obj1)).getBrand();
        obj = s;
        if (s == null)
        {
            obj = "All Brands";
        }
_L2:
        return ((String) (obj));
_L5:
        if (!searchTrigger.equalsIgnoreCase("ct"))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = DbApi.getCurrentCategoryFromId(((SearchFilterModel) (obj1)).getCategory());
        if (obj != null)
        {
            s = ((MetaItem) (obj)).getDisplay();
        }
        obj = s;
        if (s == null)
        {
            return "All Categories";
        }
        if (true) goto _L2; else goto _L6
_L6:
        if (searchTrigger.equalsIgnoreCase("sl"))
        {
            return (new StringBuilder()).append("\"").append(((SearchFilterModel) (obj1)).getQueryText()).append("\"").toString();
        }
        obj = s;
        if (searchTrigger.equalsIgnoreCase("clr"))
        {
label0:
            {
                obj1 = ((SearchFilterModel) (obj1)).getColorList();
                if (obj1 == null || ((List) (obj1)).isEmpty())
                {
                    break label0;
                }
                int j = ((List) (obj1)).size();
                int i = 0;
                do
                {
                    obj = s;
                    if (i >= j)
                    {
                        break;
                    }
                    obj = (new StringBuilder()).append(s).append((String)((List) (obj1)).get(i)).toString();
                    s = ((String) (obj));
                    if (i + 1 < j)
                    {
                        s = (new StringBuilder()).append(((String) (obj))).append(", ").toString();
                    }
                    i++;
                } while (true);
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
        return (new StringBuilder()).append("").append("All Colors").toString();
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
        if (searchView != null)
        {
            searchView.setSilentText(getFilterModel().getQueryText());
            searchView.clearFocus();
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
            }
            if (searchView != null)
            {
                searchView.setSilentText(getFilterModel().getQueryText());
                searchView.clearFocus();
                return;
            }
        }
    }

    public boolean allowFilteringOnAllCategories()
    {
        return searchTrigger == null || !searchTrigger.equalsIgnoreCase("ct");
    }

    public void filterContent()
    {
        getFilterModel().clearNextPageId();
        searchResultsData = null;
        isFilterApplied = true;
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
        return screenStackTag;
    }

    public boolean handleBack()
    {
        ((PMContainerActivity)getActivity()).killDrawerFragment(this);
        return false;
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300ad, viewgroup, false);
        resultsListView = (PMListView)layoutinflater.findViewById(0x7f0c029a);
        resultsListView.setup(adapter, null, null, new com.poshmark.ui.customviews.PMListView.LoadMoreItemsListener() {

            final SearchResultsFragment this$0;

            public void loadItems(boolean flag)
            {
                getSearchResults(flag);
            }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
        });
        searchTrigger = getArguments().getString("SEARCH_TRIGGER");
        if (searchTrigger != null && searchTrigger.equals("sl"))
        {
            keywordSource = getArguments().getString("KEYWORD_SOURCE");
            NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SEARCH_LISTINGS_BY_KEYWORD);
        }
        filterWidget = (ListingsFilterWidget)layoutinflater.findViewById(0x7f0c006a);
        if (filterWidget != null)
        {
            filterWidget.setOwnerFragment(this);
        }
        hideFilterButtonsForSingleFacet();
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
    }

    public void onPause()
    {
        super.onPause();
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    protected void pullParametersFromState(Bundle bundle)
    {
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        fragmentType = PMFragment.FRAGMENT_TYPE.HAS_DRAWER;
        if (bundle == null)
        {
            bundle = (SearchFilterModel)getFragmentDataOfType(com/poshmark/utils/SearchFilterModel);
            getFilterManager().setSearchModel(bundle);
        }
        setScreenTagBasedOnSearchType();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "browse_listing_results_screen";
    }

    public void setupActionBar()
    {
label0:
        {
            if (getUserVisibleHint())
            {
                if (keywordSource == null)
                {
                    break label0;
                }
                super.setupActionBar(0x7f030006);
                View view = getActivity().getActionBar().getCustomView();
                if (view != null)
                {
                    searchView = (PMCustomSearchWidget)view.findViewById(0x7f0c0041);
                    searchView.setSilentText(getFilterModel().getQueryText());
                    searchView.setParentListener(new PMSearchViewListener() {

                        final SearchResultsFragment this$0;

                        public void clearSearchString()
                        {
                        }

                        public void fireKeywordSearch(Bundle bundle, SearchFilterModel searchfiltermodel, boolean flag)
                        {
                            if (flag)
                            {
                                ((PMContainerActivity)getActivity()).launchFragment(bundle, com/poshmark/ui/fragments/BrandFragment, searchfiltermodel);
                                return;
                            }
                            searchTrigger = bundle.getString("SEARCH_TRIGGER");
                            if (searchTrigger != null && searchTrigger.equals("sl"))
                            {
                                keywordSource = bundle.getString("KEYWORD_SOURCE");
                                NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SEARCH_LISTINGS_BY_KEYWORD);
                            }
                            getFilterManager().setSearchModel(searchfiltermodel);
                            searchView.setSilentText(getFilterModel().getQueryText());
                            showProgressDialogWithMessage(getResources().getString(0x7f060190));
                            getSearchResults(false);
                        }

            
            {
                this$0 = SearchResultsFragment.this;
                super();
            }
                    });
                }
            }
            return;
        }
        super.setupActionBar();
        setTitle(getSearchTitle());
    }


}
