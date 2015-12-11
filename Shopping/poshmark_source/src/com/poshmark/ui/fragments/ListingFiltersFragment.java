// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.gson.reflect.TypeToken;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.PriceInfo;
import com.poshmark.db.DbApi;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ListingsFilterUtils;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import com.poshmark.utils.meta_data.MySizePickerInfo;
import com.poshmark.utils.meta_data.PricePickerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment, MetaItemListViewFragment, BrandsMetaItemListViewFragment, 
//            CategoryListFragment, ColorPickerFragment, PricePickerFragment, MySizePickerFragment

public class ListingFiltersFragment extends PMFragment
    implements PMNotificationListener
{

    PMTextView availabilityValueTextView;
    PMTextView brandValueTextView;
    PMTextView categoryValueTextView;
    LinearLayout colorValuesImageContainer;
    PMTextView conditionValueTextView;
    boolean createdFromSavedState;
    MetaItem currentAvailabilityItem;
    MetaItem currentBrandItem;
    MetaItem currentCategoryItem;
    List currentColors;
    MetaItem currentConditionItem;
    List currentPrices;
    List currentSizes;
    List currentSubCategories;
    View dividerView;
    boolean isG2FiltersEnabled;
    boolean isInitialized;
    boolean isMySizeSelected;
    PMFilterableFragment parentFragment;
    PMTextView priceValueTextView;
    PMTextView sizeValueTextView;
    PMTextView styleValueTextView;

    public ListingFiltersFragment()
    {
        currentSizes = new ArrayList();
        currentPrices = new ArrayList();
        currentSubCategories = new ArrayList();
        currentColors = new ArrayList();
        isMySizeSelected = true;
        createdFromSavedState = false;
        isInitialized = false;
        isG2FiltersEnabled = false;
    }

    private void fireSearch()
    {
        Object obj = getFilterModel();
        parentFragment.getFilterManager().updateSizes(currentSizes);
        parentFragment.getFilterManager().updatePrices(currentPrices);
        parentFragment.getFilterManager().updateSubCatogories(currentSubCategories);
        parentFragment.getFilterManager().updateColors(currentColors);
        if (currentCategoryItem != null)
        {
            ((SearchFilterModel) (obj)).setCategory(currentCategoryItem.getId());
        } else
        {
            ((SearchFilterModel) (obj)).clearCategory();
        }
        ((SearchFilterModel) (obj)).clearBrand();
        if (currentBrandItem != null)
        {
            ((SearchFilterModel) (obj)).setBrand(currentBrandItem.getId());
        }
        if (isMySizeSelected)
        {
            ((SearchFilterModel) (obj)).getFilters().enableMySize(true);
        } else
        {
            ((SearchFilterModel) (obj)).getFilters().enableMySize(false);
        }
        if (currentConditionItem != null && !currentConditionItem.getId().equals("not_nwt"))
        {
            ((SearchFilterModel) (obj)).setCondition(currentConditionItem.getId());
        } else
        {
            ((SearchFilterModel) (obj)).clearCondition();
        }
        if (currentAvailabilityItem != null && !currentAvailabilityItem.getDisplay().equalsIgnoreCase(getString(0x7f060040)))
        {
            ((SearchFilterModel) (obj)).setAvailability(currentAvailabilityItem.getId());
        } else
        {
            ((SearchFilterModel) (obj)).enableUnsoldOption(false);
        }
        obj = ((SearchFilterModel) (obj)).getLabelForAnalytics();
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_applied", ((String) (obj)));
        if (fragmentType == PMFragment.FRAGMENT_TYPE.DRAWER)
        {
            PMNotificationManager.fireNotification("com.poshmark.intents.SEARCH_FILTER_ACTION");
        } else
        {
            Object obj1 = (PMFragment)getTargetFragment();
            if (obj1 != null)
            {
                Bundle bundle = new Bundle();
                bundle.putBoolean("FILTERS_CHANGED", true);
                Intent intent = new Intent();
                intent.putExtra("RETURNED_RESULTS", bundle);
                ((PMFragment) (obj1)).onActivityResult(getTargetRequestCode(), -1, intent);
                obj1 = getActivity();
                if (obj1 != null)
                {
                    ((Activity) (obj1)).onBackPressed();
                    return;
                }
            }
        }
    }

    private String getCommaSeparatedPrices()
    {
        String s = "";
        if (currentPrices != null && currentPrices.size() > 0)
        {
            for (Iterator iterator = currentPrices.iterator(); iterator.hasNext();)
            {
                PriceInfo priceinfo = (PriceInfo)iterator.next();
                s = (new StringBuilder()).append(s).append(priceinfo.getDisplay()).toString();
            }

            return s;
        } else
        {
            return "";
        }
    }

    private void launchAvailabilitySelection()
    {
        MetaItemPickerInfo metaitempickerinfo = new MetaItemPickerInfo();
        metaitempickerinfo.allItems = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.AVAILABILITY_MODE);
        metaitempickerinfo.currentSelection = currentAvailabilityItem;
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.AVAILABILITY_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, this, 6);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "inventory_status");
    }

    private void launchBrandSelection()
    {
        BrandsMetaItemPickerInfo brandsmetaitempickerinfo = new BrandsMetaItemPickerInfo();
        brandsmetaitempickerinfo.allItems.addAll(parentFragment.getBrandsFacetList());
        brandsmetaitempickerinfo.currentSelection = currentBrandItem;
        Bundle bundle = new Bundle();
        bundle.putBoolean("SEARCH_ENABLED", true);
        bundle.putBoolean("RETURN_RESULT", true);
        if (parentFragment != null && !parentFragment.allowFilteringOnAllBrands())
        {
            bundle.putBoolean("SHOW_ALL", false);
        }
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, brandsmetaitempickerinfo, this, 3);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "brand");
    }

    private void launchConditionSelection()
    {
        MetaItemPickerInfo metaitempickerinfo = new MetaItemPickerInfo();
        metaitempickerinfo.allItems = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.CONDITION_MODE);
        metaitempickerinfo.currentSelection = currentConditionItem;
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.CONDITION_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, this, 5);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "condition");
    }

    private void prefillSearchOptions(SearchFilterModel searchfiltermodel, boolean flag)
    {
        if (isInitialized)
        {
            return;
        }
        String s = searchfiltermodel.getCategory();
        if (s != null)
        {
            currentCategoryItem = DbApi.getCurrentCategoryFromId(s);
        }
        searchfiltermodel = searchfiltermodel.getBrand();
        if (searchfiltermodel != null)
        {
            currentBrandItem = DbApi.getBrandItemFromLabel(searchfiltermodel);
        }
        searchfiltermodel = parentFragment.getFilterManager().getCurrentSubCategories();
        if (searchfiltermodel != null)
        {
            MetaItem metaitem;
            for (searchfiltermodel = searchfiltermodel.iterator(); searchfiltermodel.hasNext(); currentSubCategories.add(MetaItem.clone(metaitem)))
            {
                metaitem = (MetaItem)searchfiltermodel.next();
            }

        }
        searchfiltermodel = parentFragment.getFilterManager().getCurrentColorSelections();
        if (searchfiltermodel != null)
        {
            PMColor pmcolor;
            for (searchfiltermodel = searchfiltermodel.iterator(); searchfiltermodel.hasNext(); currentColors.add(PMColor.clone(pmcolor)))
            {
                pmcolor = (PMColor)searchfiltermodel.next();
            }

        }
        searchfiltermodel = parentFragment.getFilterManager().getCurrentSizeSelections();
        if (searchfiltermodel != null)
        {
            MetaItem metaitem1;
            for (searchfiltermodel = searchfiltermodel.iterator(); searchfiltermodel.hasNext(); currentSizes.add(MetaItem.clone(metaitem1)))
            {
                metaitem1 = (MetaItem)searchfiltermodel.next();
            }

        }
        isMySizeSelected = parentFragment.getFilterManager().isMySizeEnabled();
        searchfiltermodel = parentFragment.getFilterManager().getCurrentPriceSelections();
        if (searchfiltermodel != null)
        {
            PriceInfo priceinfo;
            for (searchfiltermodel = searchfiltermodel.iterator(); searchfiltermodel.hasNext(); currentPrices.add(priceinfo))
            {
                priceinfo = (PriceInfo)searchfiltermodel.next();
            }

        }
        currentAvailabilityItem = parentFragment.getFilterManager().getCurrentAvailability();
        currentConditionItem = parentFragment.getFilterManager().getCurrentCondition();
        isInitialized = true;
    }

    private void setup(SearchFilterModel searchfiltermodel, boolean flag)
    {
        prefillSearchOptions(searchfiltermodel, flag);
        updateView();
    }

    private void setupView(View view)
    {
        int i = (int)ViewUtils.dipToPixels(getActivity().getApplicationContext(), 30F);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f0c01c1);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams();
        layoutparams.setMargins(0, i, 0, 0);
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        linearlayout.setLayoutParams(layoutparams);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f060056);
        brandValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01bf);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchBrandSelection();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        linearlayout = (LinearLayout)view.findViewById(0x7f0c01c2);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020022));
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f060075);
        categoryValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01bf);
        styleValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01c0);
        dividerView = linearlayout.findViewById(0x7f0c0099);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchCategorySelection();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        linearlayout = (LinearLayout)view.findViewById(0x7f0c01c3);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020022));
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f06008b);
        colorValuesImageContainer = (LinearLayout)linearlayout.findViewById(0x7f0c01a2);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchColorPicker();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        linearlayout = (LinearLayout)view.findViewById(0x7f0c01c4);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020022));
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f060280);
        sizeValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01bf);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchSizeSelection();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        linearlayout = (LinearLayout)view.findViewById(0x7f0c01c5);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f060219);
        priceValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01bf);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchPricePicker();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        linearlayout = (LinearLayout)view.findViewById(0x7f0c01c6);
        linearlayout.setBackgroundDrawable(getResources().getDrawable(0x7f020024));
        linearlayout.setPadding(0, i / 2, 0, i / 2);
        layoutparams = (android.widget.LinearLayout.LayoutParams)linearlayout.getLayoutParams();
        layoutparams.setMargins(0, i, 0, 0);
        linearlayout.setLayoutParams(layoutparams);
        ((PMTextView)linearlayout.findViewById(0x7f0c0035)).setText(0x7f060091);
        conditionValueTextView = (PMTextView)linearlayout.findViewById(0x7f0c01bf);
        linearlayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchConditionSelection();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        view = (LinearLayout)view.findViewById(0x7f0c01c7);
        view.setBackgroundDrawable(getResources().getDrawable(0x7f020021));
        view.setPadding(0, i / 2, 0, i / 2);
        ((PMTextView)view.findViewById(0x7f0c0035)).setText(0x7f06004e);
        availabilityValueTextView = (PMTextView)view.findViewById(0x7f0c01bf);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view1)
            {
                launchAvailabilitySelection();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
    }

    private void updateSearchFilters(int i, Bundle bundle)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String s1;
        String s2;
        s2 = "";
        s1 = "";
        obj2 = null;
        obj = bundle.getString("DATA_SELECTED");
        if (obj != null)
        {
            obj2 = (MetaItem)StringUtils.fromJson(((String) (obj)), com/poshmark/data_model/models/MetaItem);
        }
        obj = s2;
        obj1 = s1;
        i;
        JVM INSTR tableswitch 1 9: default 96
    //                   1 159
    //                   2 339
    //                   3 465
    //                   4 505
    //                   5 577
    //                   6 612
    //                   7 103
    //                   8 275
    //                   9 647;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L8:
        break; /* Loop/switch isn't completed */
_L1:
        obj1 = s1;
        obj = s2;
_L12:
        if (((String) (obj)).length() > 0 && ((String) (obj1)).length() > 0)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_selected", (new StringBuilder()).append(((String) (obj))).append("/").append(((String) (obj1))).toString());
        }
        return;
_L2:
        s1 = "category";
        if (obj2 != null)
        {
            currentCategoryItem = ((MetaItem) (obj2));
            currentSizes.clear();
            obj2 = currentCategoryItem.getId();
            bundle = bundle.getString("TAGS_LIST");
            obj = s1;
            obj1 = obj2;
            if (bundle != null)
            {
                currentSubCategories = (List)StringUtils.fromJson(bundle, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
                obj = s1;
                obj1 = obj2;
            }
        } else
        {
            currentCategoryItem = null;
            currentSizes.clear();
            currentSubCategories.clear();
            obj1 = "all";
            obj = s1;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        String s3 = "style";
        if (obj2 != null)
        {
            currentCategoryItem = ((MetaItem) (obj2));
        }
        bundle = bundle.getString("TAGS_LIST");
        obj = s3;
        obj1 = s1;
        if (bundle != null)
        {
            currentSubCategories = (List)StringUtils.fromJson(bundle, new TypeToken() {

                final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
            });
            obj = s3;
            obj1 = s1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        boolean flag = bundle.getBoolean("SIZE_CHANGED");
        boolean flag2 = bundle.getBoolean("MYSIZE_SWITCH_STATE", false);
        obj = "size";
        isMySizeSelected = flag2;
        if (obj2 != null)
        {
            currentCategoryItem = ((MetaItem) (obj2));
        }
        if (flag)
        {
            bundle = bundle.getString("SIZE_LIST");
            if (bundle != null)
            {
                currentSizes = (List)StringUtils.fromJson(bundle, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
            }
        }
        bundle = getFilterManager().getSearchModel().getCommaSeparatedSizes();
        obj1 = bundle;
        if (isMySizeSelected)
        {
            obj = (new StringBuilder()).append("size").append("My Size").toString();
            obj1 = bundle;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = "brand";
        if (obj2 != null)
        {
            currentBrandItem = ((MetaItem) (obj2));
            obj1 = currentBrandItem.getId();
        } else
        {
            currentBrandItem = null;
            obj1 = "all";
        }
        continue; /* Loop/switch isn't completed */
_L5:
        obj2 = "price";
        obj = obj2;
        obj1 = s1;
        if (bundle.getBoolean("PRICE_CHANGED"))
        {
            bundle = bundle.getString("PRICE_LIST");
            obj = obj2;
            obj1 = s1;
            if (bundle != null)
            {
                currentPrices = (List)StringUtils.fromJson(bundle, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
                obj1 = getCommaSeparatedPrices();
                obj = obj2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        bundle = "condition";
        obj = bundle;
        obj1 = s1;
        if (obj2 != null)
        {
            currentConditionItem = ((MetaItem) (obj2));
            obj1 = currentConditionItem.getId();
            obj = bundle;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        bundle = "inventory_status";
        obj = bundle;
        obj1 = s1;
        if (obj2 != null)
        {
            currentAvailabilityItem = ((MetaItem) (obj2));
            obj1 = currentAvailabilityItem.getId();
            obj = bundle;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        boolean flag1 = bundle.getBoolean("COLOR_CHANGED");
        String s = "color";
        obj = s;
        obj1 = s1;
        if (flag1)
        {
            bundle = bundle.getString("COLOR_LIST");
            obj = s;
            obj1 = s1;
            if (bundle != null)
            {
                currentColors = (List)StringUtils.fromJson(bundle, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
                obj = s;
                obj1 = s1;
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void updateView()
    {
        Object obj;
        Object obj4;
        if (currentBrandItem != null)
        {
            brandValueTextView.setVisibility(0);
            brandValueTextView.setText(currentBrandItem.getDisplay());
        } else
        {
            brandValueTextView.setVisibility(8);
        }
        if (currentCategoryItem != null)
        {
            categoryValueTextView.setVisibility(0);
            categoryValueTextView.setText(currentCategoryItem.getDisplay());
        } else
        {
            categoryValueTextView.setVisibility(8);
        }
        obj = "";
        obj4 = currentSubCategories.iterator();
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            Object obj1 = (MetaItem)((Iterator) (obj4)).next();
            obj1 = (new StringBuilder()).append(((String) (obj))).append(((MetaItem) (obj1)).getDisplay()).toString();
            obj = obj1;
            if (((Iterator) (obj4)).hasNext())
            {
                obj = (new StringBuilder()).append(((String) (obj1))).append(", ").toString();
            }
        } while (true);
        if (currentCategoryItem != null)
        {
            dividerView.setVisibility(0);
            styleValueTextView.setVisibility(0);
            PMColor pmcolor;
            Object obj5;
            int i;
            if (((String) (obj)).length() > 0)
            {
                styleValueTextView.setText(((CharSequence) (obj)));
            } else
            {
                styleValueTextView.setText(0x7f06003c);
            }
        }
        colorValuesImageContainer.removeAllViews();
        for (obj = currentColors.iterator(); ((Iterator) (obj)).hasNext(); colorValuesImageContainer.addView(((View) (obj4))))
        {
            pmcolor = (PMColor)((Iterator) (obj)).next();
            obj4 = new ImageView(getActivity());
            obj5 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            obj5.height = (int)ViewUtils.dipToPixels(getActivity(), 30F);
            obj5.width = (int)ViewUtils.dipToPixels(getActivity(), 30F);
            i = (int)ViewUtils.dipToPixels(getActivity(), 10F);
            ((android.widget.LinearLayout.LayoutParams) (obj5)).setMargins(i, i, i, i);
            ((ImageView) (obj4)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj5)));
            obj5 = (GradientDrawable)getActivity().getResources().getDrawable(0x7f020038);
            ((GradientDrawable) (obj5)).setColor(Color.parseColor(pmcolor.rgb));
            ((ImageView) (obj4)).setImageDrawable(((android.graphics.drawable.Drawable) (obj5)));
        }

        obj = "";
        if (isMySizeSelected)
        {
            String s = (new StringBuilder()).append("").append(getString(0x7f0601ba)).toString();
            obj = s;
            if (currentSizes.size() > 0)
            {
                obj = (new StringBuilder()).append(s).append(", ").toString();
            }
        }
        obj4 = currentSizes.iterator();
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            Object obj2 = (MetaItem)((Iterator) (obj4)).next();
            obj2 = (new StringBuilder()).append(((String) (obj))).append(((MetaItem) (obj2)).getDisplay()).toString();
            obj = obj2;
            if (((Iterator) (obj4)).hasNext())
            {
                obj = (new StringBuilder()).append(((String) (obj2))).append(", ").toString();
            }
        } while (true);
        if (((String) (obj)).length() > 0)
        {
            sizeValueTextView.setVisibility(0);
            sizeValueTextView.setText(((CharSequence) (obj)));
        } else
        {
            sizeValueTextView.setVisibility(8);
        }
        obj4 = currentPrices.iterator();
        obj = "";
        do
        {
            if (!((Iterator) (obj4)).hasNext())
            {
                break;
            }
            Object obj3 = (PriceInfo)((Iterator) (obj4)).next();
            obj3 = (new StringBuilder()).append(((String) (obj))).append(((PriceInfo) (obj3)).getDisplay()).toString();
            obj = obj3;
            if (((Iterator) (obj4)).hasNext())
            {
                obj = (new StringBuilder()).append(((String) (obj3))).append(", ").toString();
            }
        } while (true);
        if (((String) (obj)).length() > 0)
        {
            priceValueTextView.setVisibility(0);
            priceValueTextView.setText(((CharSequence) (obj)));
        } else
        {
            priceValueTextView.setVisibility(8);
        }
        if (currentAvailabilityItem != null && !currentAvailabilityItem.getDisplay().equalsIgnoreCase(getString(0x7f060040)))
        {
            availabilityValueTextView.setVisibility(0);
            availabilityValueTextView.setText(currentAvailabilityItem.getDisplay());
        } else
        {
            availabilityValueTextView.setVisibility(8);
        }
        if (currentConditionItem != null && !currentConditionItem.getDisplay().equalsIgnoreCase(getString(0x7f060040)))
        {
            conditionValueTextView.setVisibility(0);
            conditionValueTextView.setText(currentConditionItem.getDisplay());
            return;
        } else
        {
            conditionValueTextView.setVisibility(8);
            return;
        }
    }

    public FilterResultsManager getFilterManager()
    {
        return parentFragment.getFilterManager();
    }

    public SearchFilterModel getFilterModel()
    {
        return parentFragment.getFilterManager().getSearchModel();
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.UPDATE_SEARCH_DRAWER"))
        {
            setup(getFilterModel(), false);
        }
    }

    public void launchCategorySelection()
    {
        CategorySubCategorySelectionModel categorysubcategoryselectionmodel = new CategorySubCategorySelectionModel();
        if (currentCategoryItem != null)
        {
            categorysubcategoryselectionmodel.scrubbedSubCategoryList = ListingsFilterUtils.getScrubbedList(DbApi.getSubCategoriesForCategory(currentCategoryItem.getId()), parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.STYLE_TAGS));
            if (categorysubcategoryselectionmodel.scrubbedSubCategoryList == null)
            {
                categorysubcategoryselectionmodel.scrubbedSubCategoryList = new ArrayList();
            }
            categorysubcategoryselectionmodel.currentCategory = currentCategoryItem;
        }
        categorysubcategoryselectionmodel.currentSubCategorySelection = currentSubCategories;
        categorysubcategoryselectionmodel.categoryFacetList = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE);
        categorysubcategoryselectionmodel.subCategoryFacetList = parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.STYLE_TAGS);
        Bundle bundle = new Bundle();
        if (parentFragment.allowFilteringOnAllCategories())
        {
            bundle.putBoolean("SHOW_ALL_VISIBLE", true);
            bundle.putBoolean("SET_SHOW_ALL", true);
        } else
        {
            bundle.putBoolean("SHOW_ALL_VISIBLE", false);
            bundle.putBoolean("SET_SHOW_ALL", false);
        }
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/CategoryListFragment, categorysubcategoryselectionmodel, this, 1);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "category");
    }

    public void launchColorPicker()
    {
        ColorPickerInfo colorpickerinfo = new ColorPickerInfo();
        colorpickerinfo.allItems = parentFragment.getColorFacetList();
        colorpickerinfo.colorFacetList = parentFragment.getUnscrubbedColorFacetList();
        if (!currentColors.isEmpty())
        {
            colorpickerinfo.selectedColors = currentColors;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("COLOR_PICKER_MODE", ColorPickerFragment.COLOR_MODE.COLOR_FILTER.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, colorpickerinfo, this, 9);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "color");
    }

    public void launchPricePicker()
    {
        PricePickerInfo pricepickerinfo = new PricePickerInfo();
        pricepickerinfo.allItems = DbApi.getCannedPriceRanges();
        pricepickerinfo.selectedItems.addAll(currentPrices);
        ((PMActivity)getActivity()).launchFragmentForResult(null, com/poshmark/ui/fragments/PricePickerFragment, pricepickerinfo, this, 4);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "price");
    }

    public void launchSizeSelection()
    {
        MySizePickerInfo mysizepickerinfo = new MySizePickerInfo();
        if (currentCategoryItem != null)
        {
            mysizepickerinfo.allItems = ListingsFilterUtils.getScrubbedList(DbApi.getSizesForCategory(currentCategoryItem.getId()), parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE));
            if (mysizepickerinfo.allItems == null)
            {
                mysizepickerinfo.allItems = new ArrayList();
            }
            mysizepickerinfo.currentCategory = currentCategoryItem;
        }
        mysizepickerinfo.selectedItems.addAll(currentSizes);
        mysizepickerinfo.categoryFacetList = parentFragment.getFacetList(MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE);
        mysizepickerinfo.sizeFacetList = parentFragment.getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE);
        mysizepickerinfo.bIsMySizeEnabled = isMySizeSelected;
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", MySizePickerFragment.MODE.SEARCH_FILTER.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MySizePickerFragment, mysizepickerinfo, this, 2);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "size");
    }

    public void logScreenTracking()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1)
        {
            updateSearchFilters(i, intent.getBundleExtra("RETURNED_RESULTS"));
            if (isG2FiltersEnabled)
            {
                fireSearch();
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        isG2FiltersEnabled = FeatureManager.getGlobalFeatureManager().isFilterBarv2FeatureEnabled();
        if (bundle != null)
        {
            parentFragment = (PMFilterableFragment)getActivity().getSupportFragmentManager().getFragment(bundle, getFragmentId().toString());
            String s = bundle.getString("CURRENT_SIZES_JSON");
            if (s != null)
            {
                currentSizes = (List)StringUtils.fromJson(s, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
            }
            s = bundle.getString("CURRENT_CATEGORY_STYLE_TAGS_JSON");
            if (s != null)
            {
                currentSubCategories = (List)StringUtils.fromJson(s, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
            }
            s = bundle.getString("CURRENT_COLORS_JSON");
            if (s != null)
            {
                currentColors = (List)StringUtils.fromJson(s, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
            }
            s = bundle.getString("CURRENT_PRICES_JSON");
            if (s != null)
            {
                currentPrices = (List)StringUtils.fromJson(s, new TypeToken() {

                    final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
                });
            }
            s = bundle.getString("CURRENT_CATEGORY_ITEM_JSON");
            if (s != null)
            {
                currentCategoryItem = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
            }
            s = bundle.getString("CURRENT_BRAND_ITEM_JSON");
            if (s != null)
            {
                currentBrandItem = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
            }
            s = bundle.getString("CURRENT_CONDITION_ITEM_JSON");
            if (s != null)
            {
                currentConditionItem = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
            }
            s = bundle.getString("CURRENT_AVAILABILITY_ITEM_JSON");
            if (s != null)
            {
                currentAvailabilityItem = (MetaItem)StringUtils.fromJson(s, com/poshmark/data_model/models/MetaItem);
            }
            isMySizeSelected = bundle.getBoolean("MY_SIZE", true);
            createdFromSavedState = true;
            return;
        } else
        {
            if (getArguments() == null);
            parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
            createdFromSavedState = false;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030072, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onFragmentResult(Bundle bundle, int i)
    {
        updateSearchFilters(i, bundle);
    }

    public void onPMResume()
    {
        super.onPMResume();
        setup(getFilterModel(), false);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.UPDATE_SEARCH_DRAWER", this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        getActivity().getSupportFragmentManager().putFragment(bundle, getFragmentId().toString(), parentFragment);
        java.lang.reflect.Type type = (new TypeToken() {

            final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        }).getType();
        bundle.putString("CURRENT_SIZES_JSON", StringUtils.toJson(currentSizes, type));
        type = (new TypeToken() {

            final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        }).getType();
        bundle.putString("CURRENT_PRICES_JSON", StringUtils.toJson(currentPrices, type));
        type = (new TypeToken() {

            final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        }).getType();
        bundle.putString("CURRENT_CATEGORY_STYLE_TAGS_JSON", StringUtils.toJson(currentSubCategories, type));
        type = (new TypeToken() {

            final ListingFiltersFragment this$0;

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        }).getType();
        bundle.putString("CURRENT_COLORS_JSON", StringUtils.toJson(currentColors, type));
        if (currentCategoryItem != null)
        {
            bundle.putString("CURRENT_CATEGORY_ITEM_JSON", StringUtils.toJson(currentCategoryItem));
        }
        if (currentBrandItem != null)
        {
            bundle.putString("CURRENT_BRAND_ITEM_JSON", StringUtils.toJson(currentBrandItem));
        }
        if (currentConditionItem != null)
        {
            bundle.putString("CURRENT_CONDITION_ITEM_JSON", StringUtils.toJson(currentConditionItem));
        }
        if (currentAvailabilityItem != null)
        {
            bundle.putString("CURRENT_AVAILABILITY_ITEM_JSON", StringUtils.toJson(currentAvailabilityItem));
        }
        bundle.putBoolean("MY_SIZE", isMySizeSelected);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_filter_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setNextActionButton(getString(0x7f06004a), new android.view.View.OnClickListener() {

            final ListingFiltersFragment this$0;

            public void onClick(View view)
            {
                fireSearch();
            }

            
            {
                this$0 = ListingFiltersFragment.this;
                super();
            }
        });
        setTitle(0x7f060125);
    }




}
