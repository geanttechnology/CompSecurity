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
import com.poshmark.data_model.adapters.SubCategoryAdapter;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.db.DbApi;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ListingsFilterUtils;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment

public class SubCategoryListFragment extends PMFragment
{

    boolean allOptionVisible;
    boolean allowMultiSelect;
    boolean backoutFlag;
    CategorySubCategorySelectionModel currentSelectionModel;
    CategorySubCategorySelectionModel currentSelectionModel_copy;
    boolean isListingFlowMode;
    View listHeaderView;
    ListView listView;
    PMFilterableFragment parentFragment;
    boolean selectAllOptionForNoSelections;
    MetaItem selectedCategory;
    boolean showAllAsNone;
    SubCategoryAdapter subCategoryAdapter;

    public SubCategoryListFragment()
    {
        allowMultiSelect = true;
        allOptionVisible = false;
        selectAllOptionForNoSelections = false;
        showAllAsNone = false;
        isListingFlowMode = false;
        backoutFlag = false;
    }

    private void setupAdapter()
    {
        if (parentFragment != null)
        {
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
        }
        if (currentSelectionModel != null)
        {
            currentSelectionModel_copy = CategorySubCategorySelectionModel.clone(currentSelectionModel);
        }
        subCategoryAdapter = new SubCategoryAdapter(getActivity(), 0x7f03008a, currentSelectionModel, this);
    }

    public void allItemSelected()
    {
        currentSelectionModel_copy.currentSubCategorySelection.clear();
        returnData();
    }

    public View getListHeaderView()
    {
        return listHeaderView;
    }

    public String getTrackingLabel()
    {
        return "sct";
    }

    public void itemSelected(MetaItem metaitem)
    {
        currentSelectionModel_copy.currentSubCategorySelection.clear();
        currentSelectionModel_copy.currentSubCategorySelection.add(metaitem);
        returnData();
    }

    public void onActivityCreated(Bundle bundle)
    {
label0:
        {
            super.onActivityCreated(bundle);
            if (bundle == null)
            {
                listView = (ListView)getView().findViewById(0x7f0c0205);
                setupHeaderView();
                listView.setAdapter(subCategoryAdapter);
                subCategoryAdapter.setListView(listView);
                if (!isListingFlowMode)
                {
                    break label0;
                }
                setTitle(getResources().getString(0x7f060245));
            }
            return;
        }
        setTitle(currentSelectionModel.currentCategory.getDisplay());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            allowMultiSelect = getArguments().getBoolean("MULTI_SELECT_ENABLED");
            allOptionVisible = getArguments().getBoolean("SHOW_ALL_VISIBLE", false);
            selectAllOptionForNoSelections = getArguments().getBoolean("SET_SHOW_ALL", false);
            showAllAsNone = getArguments().getBoolean("SHOW_ALL_AS_NONE", false);
            isListingFlowMode = getArguments().getBoolean("LISTING_FLOW_MODE", false);
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

    public void returnData()
    {
        Object obj = (PMFragment)getTargetFragment();
        Object obj1 = StringUtils.toJson(currentSelectionModel_copy.currentCategory, com/poshmark/data_model/models/MetaItem);
        Bundle bundle = new Bundle();
        bundle.putString("DATA_SELECTED", ((String) (obj1)));
        obj1 = (new TypeToken() {

            final SubCategoryListFragment this$0;

            
            {
                this$0 = SubCategoryListFragment.this;
                super();
            }
        }).getType();
        bundle.putString("TAGS_LIST", StringUtils.toJson(currentSelectionModel_copy.currentSubCategorySelection, ((java.lang.reflect.Type) (obj1))));
        obj1 = new Intent();
        ((Intent) (obj1)).putExtra("RETURNED_RESULTS", bundle);
        if (obj != null)
        {
            ((PMFragment) (obj)).onActivityResult(getTargetRequestCode(), -1, ((Intent) (obj1)));
            obj = ((PMFragment) (obj)).getParentActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return;
        } else
        {
            finishActivityWithResult(-1, ((Intent) (obj1)));
            return;
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_select_subcategory_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (allowMultiSelect)
        {
            setNextActionButton("DONE", new android.view.View.OnClickListener() {

                final SubCategoryListFragment this$0;

                public void onClick(View view)
                {
                    returnData();
                }

            
            {
                this$0 = SubCategoryListFragment.this;
                super();
            }
            });
        }
    }

    public void setupHeaderView()
    {
        listHeaderView = LayoutInflater.from(getActivity()).inflate(0x7f03005b, null, false);
        PMTextView pmtextview = (PMTextView)listHeaderView.findViewById(0x7f0c0072);
        Object obj = (LinearLayout)listHeaderView.findViewById(0x7f0c0166);
        LinearLayout linearlayout = (LinearLayout)listHeaderView.findViewById(0x7f0c0071);
        ((LinearLayout) (obj)).setVisibility(8);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        ((android.widget.LinearLayout.LayoutParams) (obj)).setMargins(0, 0, 0, (int)ViewUtils.dipToPixels(getActivity(), 30F));
        linearlayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        if (allOptionVisible)
        {
            linearlayout.setVisibility(0);
            if (showAllAsNone)
            {
                pmtextview.setText("None");
            } else
            {
                pmtextview.setText((new StringBuilder()).append(getResources().getString(0x7f06003c)).append(" ").append(currentSelectionModel_copy.currentCategory.getDisplay()).toString());
            }
            if (selectAllOptionForNoSelections && !currentSelectionModel_copy.selectionsPresent())
            {
                pmtextview.setTextColor(getResources().getColor(0x7f09003c));
                pmtextview.setTypeface(null, 1);
                pmtextview.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
            }
        } else
        {
            linearlayout.setVisibility(8);
        }
        listView.addHeaderView(listHeaderView);
    }
}
