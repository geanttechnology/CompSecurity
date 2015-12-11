// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.google.gson.reflect.TypeToken;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.CategoryAdapter;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ListingsFilterUtils;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment, SubCategoryListFragment, SearchResultsFragment

public class CategoryListFragment extends PMFragment
{

    boolean allOptionVisible;
    boolean allowMultiSelect;
    boolean backoutFlag;
    CategoryAdapter categoryAdapter;
    CategorySubCategorySelectionModel currentSelectionModel;
    CategorySubCategorySelectionModel currentSelectionModel_copy;
    boolean isBrowseMode;
    boolean isListingMode;
    View listHeaderView;
    ListView listView;
    PMFilterableFragment parentFragment;
    boolean returnResult;
    boolean selectAllOptionForNoSelections;
    MetaItem selectedCategory;

    public CategoryListFragment()
    {
        allowMultiSelect = true;
        allOptionVisible = false;
        selectAllOptionForNoSelections = false;
        backoutFlag = false;
        returnResult = true;
        isBrowseMode = false;
        isListingMode = false;
    }

    private void setupAdapter()
    {
        if (parentFragment == null) goto _L2; else goto _L1
_L1:
        currentSelectionModel = new CategorySubCategorySelectionModel();
        currentSelectionModel.categoryFacetList = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE);
        currentSelectionModel.subCategoryFacetList = parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.STYLE_TAGS);
        currentSelectionModel.currentCategory = parentFragment.searchManager.getCurrentCategory();
        if (currentSelectionModel.currentCategory != null)
        {
            List list = DbApi.getSubCategoriesForCategory(currentSelectionModel.currentCategory.getId());
            currentSelectionModel.scrubbedSubCategoryList = ListingsFilterUtils.getScrubbedList(list, parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.STYLE_TAGS));
            if (currentSelectionModel.scrubbedSubCategoryList == null)
            {
                currentSelectionModel.scrubbedSubCategoryList = new ArrayList();
            }
            currentSelectionModel.currentSubCategorySelection = new ArrayList();
            currentSelectionModel.currentSubCategorySelection.addAll(parentFragment.getFilterManager().getCurrentSubCategories());
        }
_L4:
        currentSelectionModel_copy = CategorySubCategorySelectionModel.clone(currentSelectionModel);
        categoryAdapter = new CategoryAdapter(getActivity(), 0x7f03001f, currentSelectionModel, this);
        return;
_L2:
        if (currentSelectionModel == null)
        {
            currentSelectionModel = new CategorySubCategorySelectionModel();
            currentSelectionModel.categoryFacetList = DbApi.getAllCategories();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void allItemSelected()
    {
        currentSelectionModel_copy.currentCategory = null;
        currentSelectionModel_copy.currentSubCategorySelection.clear();
        Object obj = StringUtils.toJson(currentSelectionModel_copy.currentCategory, com/poshmark/data_model/models/MetaItem);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_SELECTED", ((String) (obj)));
        obj = (new TypeToken() {

            final CategoryListFragment this$0;

            
            {
                this$0 = CategoryListFragment.this;
                super();
            }
        }).getType();
        bundle.putString("TAGS_LIST", StringUtils.toJson(currentSelectionModel_copy.currentSubCategorySelection, ((java.lang.reflect.Type) (obj))));
        obj = new Intent();
        ((Intent) (obj)).putExtra("RETURNED_RESULTS", bundle);
        returnResult(((Intent) (obj)));
    }

    public View getListHeaderView()
    {
        return listHeaderView;
    }

    public String getTrackingLabel()
    {
        return "ct";
    }

    public boolean isListingFlow()
    {
        return isListingMode;
    }

    public void itemSelected(MetaItem metaitem)
    {
        currentSelectionModel_copy.currentCategory = metaitem;
        List list = DbApi.getSubCategoriesForCategory(metaitem.getId());
        currentSelectionModel_copy.scrubbedSubCategoryList = ListingsFilterUtils.getScrubbedList(list, currentSelectionModel_copy.subCategoryFacetList);
        if (currentSelectionModel_copy.scrubbedSubCategoryList == null)
        {
            currentSelectionModel_copy.scrubbedSubCategoryList = new ArrayList();
        }
        if (currentSelectionModel.currentCategory != null && !currentSelectionModel_copy.currentCategory.getId().equals(currentSelectionModel.currentCategory.getId()))
        {
            currentSelectionModel_copy.currentSubCategorySelection.clear();
        } else
        {
            currentSelectionModel_copy.currentSubCategorySelection.clear();
            currentSelectionModel_copy.currentSubCategorySelection.addAll(currentSelectionModel.currentSubCategorySelection);
        }
        if (!metaitem.getId().equals(DbApi.OTHER_ID)) goto _L2; else goto _L1
_L1:
        if (!returnResult) goto _L4; else goto _L3
_L3:
        returnData();
_L6:
        return;
_L4:
        propogateResult();
        return;
_L2:
        metaitem = new Bundle();
        metaitem.putBoolean("SHOW_ALL_VISIBLE", true);
        metaitem.putBoolean("SET_SHOW_ALL", showSubCategoryAllChecked());
        metaitem.putBoolean("SHOW_ALL_AS_NONE", isListingMode);
        metaitem.putBoolean("LISTING_FLOW_MODE", isListingMode);
        ((PMActivity)getActivity()).launchFragmentForResult(metaitem, com/poshmark/ui/fragments/SubCategoryListFragment, currentSelectionModel_copy, this, 7);
        if (isBrowseMode)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "browse_listings_by_category_shop_tab", null);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            listView = (ListView)getView().findViewById(0x7f0c0205);
            setupHeaderView();
            listView.setAdapter(categoryAdapter);
            categoryAdapter.setListView(listView);
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
            super.onActivityResult(i, j, intent);
            if (j != 0)
            {
                String s = intent.getBundleExtra("RETURNED_RESULTS").getString("TAGS_LIST");
                if (s != null)
                {
                    TypeToken typetoken = new TypeToken() {

                        final CategoryListFragment this$0;

            
            {
                this$0 = CategoryListFragment.this;
                super();
            }
                    };
                    currentSelectionModel_copy.currentSubCategorySelection = (List)StringUtils.fromJson(s, typetoken);
                }
                if (!returnResult)
                {
                    break label0;
                }
                returnResult(intent);
            }
            return;
        }
        propogateResult();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            allowMultiSelect = getArguments().getBoolean("MULTI_SELECT_ENABLED");
            allOptionVisible = getArguments().getBoolean("SHOW_ALL_VISIBLE", false);
            selectAllOptionForNoSelections = getArguments().getBoolean("SET_SHOW_ALL", false);
            isBrowseMode = getArguments().getBoolean("ENABLE_BROWSE_MODE", false);
            isListingMode = getArguments().getBoolean("ENABLE_LISTING_MODE", false);
            returnResult = getArguments().getBoolean("RETURN_RESULT", true);
            parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
            currentSelectionModel = (CategorySubCategorySelectionModel)getFragmentDataOfType(com/poshmark/utils/meta_data/CategorySubCategorySelectionModel);
            setupAdapter();
            return;
        } else
        {
            backoutFlag = true;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300c1, viewgroup, false);
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
label0:
        {
            if (i == 17)
            {
                if (bundle == null)
                {
                    break label0;
                }
                bundle = bundle.getString("DATA_SELECTED");
                if (bundle != null)
                {
                    selectedCategory = (MetaItem)StringUtils.fromJson(bundle, com/poshmark/data_model/models/MetaItem);
                    currentSelectionModel_copy.currentCategory = selectedCategory;
                    bundle = DbApi.getSubCategoriesForCategory(selectedCategory.getId());
                    currentSelectionModel_copy.scrubbedSubCategoryList = ListingsFilterUtils.getScrubbedList(bundle, currentSelectionModel_copy.subCategoryFacetList);
                    if (currentSelectionModel_copy.scrubbedSubCategoryList == null)
                    {
                        currentSelectionModel_copy.scrubbedSubCategoryList = new ArrayList();
                    }
                }
            }
            return;
        }
        backoutFlag = true;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (backoutFlag)
        {
            getActivity().onBackPressed();
        }
    }

    public void propogateResult()
    {
        SearchFilterModel searchfiltermodel = new SearchFilterModel();
        searchfiltermodel.setAvailability("available");
        Object obj = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (obj != null && ((UserStateSummary) (obj)).user_info.isMySizeAvailable())
        {
            searchfiltermodel.enableMySizeFilter(true);
        }
        searchfiltermodel.setSearchTrigger("ct");
        searchfiltermodel.setCategory(currentSelectionModel_copy.currentCategory.getId());
        searchfiltermodel.setSubCategories(currentSelectionModel_copy.currentSubCategorySelection);
        searchfiltermodel.setFacet("brand");
        searchfiltermodel.setFacet("size");
        searchfiltermodel.setFacet("color");
        obj = new Bundle();
        ((Bundle) (obj)).putString("SEARCH_TRIGGER", "ct");
        ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
        if (isBrowseMode)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "browse_listings_by_subcategory_shop_tab", null);
        }
    }

    public void returnData()
    {
        Object obj = StringUtils.toJson(currentSelectionModel_copy.currentCategory, com/poshmark/data_model/models/MetaItem);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_SELECTED", ((String) (obj)));
        obj = (new TypeToken() {

            final CategoryListFragment this$0;

            
            {
                this$0 = CategoryListFragment.this;
                super();
            }
        }).getType();
        bundle.putString("TAGS_LIST", StringUtils.toJson(currentSelectionModel_copy.currentSubCategorySelection, ((java.lang.reflect.Type) (obj))));
        obj = new Intent();
        ((Intent) (obj)).putExtra("RETURNED_RESULTS", bundle);
        returnResult(((Intent) (obj)));
    }

    public void returnResult(Intent intent)
    {
        PMFragment pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment != null)
        {
            pmfragment.onActivityResult(getTargetRequestCode(), -1, intent);
            intent = getActivity();
            if (intent != null)
            {
                intent.onBackPressed();
            }
            return;
        } else
        {
            finishActivityWithResult(-1, intent);
            return;
        }
    }

    public void setViewNameForAnalytics()
    {
        if (isListingMode)
        {
            viewNameForAnalytics = "listing_select_category_screen";
            return;
        }
        if (allOptionVisible || allowMultiSelect)
        {
            viewNameForAnalytics = "listing_select_category_filter_screen";
            return;
        } else
        {
            viewNameForAnalytics = "listing_select_category_screen";
            return;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (allowMultiSelect)
        {
            setNextActionButton("DONE", new android.view.View.OnClickListener() {

                final CategoryListFragment this$0;

                public void onClick(View view)
                {
                    returnData();
                }

            
            {
                this$0 = CategoryListFragment.this;
                super();
            }
            });
        }
        if (isListingMode)
        {
            setTitle(0x7f060240);
            return;
        } else
        {
            setTitle(0x7f060073);
            return;
        }
    }

    public void setupHeaderView()
    {
        listHeaderView = LayoutInflater.from(getActivity()).inflate(0x7f03005b, null, false);
        PMTextView pmtextview = (PMTextView)listHeaderView.findViewById(0x7f0c0072);
        LinearLayout linearlayout = (LinearLayout)listHeaderView.findViewById(0x7f0c0166);
        LinearLayout linearlayout1 = (LinearLayout)listHeaderView.findViewById(0x7f0c0071);
        linearlayout.setVisibility(8);
        if (allOptionVisible)
        {
            linearlayout1.setVisibility(0);
            pmtextview.setText("All");
            if (showAllChecked())
            {
                pmtextview.setTextColor(getResources().getColor(0x7f09003c));
                pmtextview.setTypeface(null, 1);
                pmtextview.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
            }
        } else
        {
            linearlayout1.setVisibility(8);
        }
        listView.addHeaderView(listHeaderView);
    }

    public boolean showAllChecked()
    {
        return selectAllOptionForNoSelections && !currentSelectionModel.selectionsPresent() && currentSelectionModel.currentCategory == null;
    }

    public boolean showSubCategoryAllChecked()
    {
        while (currentSelectionModel_copy.currentCategory == null || currentSelectionModel.currentCategory == null || !currentSelectionModel_copy.currentCategory.getId().equals(currentSelectionModel.currentCategory.getId())) 
        {
            return false;
        }
        return true;
    }
}
