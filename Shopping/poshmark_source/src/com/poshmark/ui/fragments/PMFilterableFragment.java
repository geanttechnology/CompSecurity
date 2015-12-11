// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.Facets;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.db.DbApi;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.ListingsFilterWidget;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.ListingsFilterUtils;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MetaItemListViewFragment, BrandsMetaItemListViewFragment, CategoryListFragment, 
//            ColorPickerFragment, PricePickerFragment, MySizePickerFragment, ListingFiltersFragment

public class PMFilterableFragment extends PMFragment
    implements PMNotificationListener
{

    Facets facetLists;
    ListingsFilterWidget filterWidget;
    boolean isFilterApplied;
    FilterResultsManager searchManager;

    public PMFilterableFragment()
    {
        searchManager = new FilterResultsManager();
        isFilterApplied = false;
    }

    private List getAvailabilityMetaItemListFromFacetList()
    {
        return DbApi.getAvailabilityList();
    }

    private List getBrandMetaItemListFromFacetList()
    {
        if (facetLists != null)
        {
            List list = facetLists.getBrandFacets();
            if (list != null && list.size() > 0)
            {
                searchManager.getSearchModel().getCategory();
                return ListingsFilterUtils.getScrubbedList(DbApi.getBrandsForAllCategories(), list);
            }
        }
        return DbApi.getBrandsForAllCategories();
    }

    private List getCategoryMetaItemListFromFacetList()
    {
        List list1 = DbApi.getAllCategories();
        List list = list1;
        if (facetLists != null)
        {
            List list2 = facetLists.getCategoryFacets();
            list = list1;
            if (list2 != null)
            {
                list = list1;
                if (list2.size() > 0)
                {
                    list = ListingsFilterUtils.getScrubbedList(list1, list2);
                }
            }
        }
        return list;
    }

    private List getColorMetaItemListFromFacetList()
    {
        if (facetLists != null)
        {
            List list = facetLists.getColorFacets();
            if (list != null && list.size() > 0)
            {
                return ListingsFilterUtils.getScrubbedColorList(DbApi.getAllColors(), list);
            }
        }
        return DbApi.getAllColors();
    }

    private List getConditionMetaItemListFromFacetList()
    {
        return DbApi.getAllConditions();
    }

    private List getSizeMetaItemListFromFacetList()
    {
        String s = searchManager.getSearchModel().getCategory();
        if (s != null)
        {
            if (facetLists != null)
            {
                List list = facetLists.getSizeFacets();
                if (list != null && list.size() > 0)
                {
                    return ListingsFilterUtils.getScrubbedList(DbApi.getSizesForCategory(s), list);
                } else
                {
                    return DbApi.getSizesForCategory(s);
                }
            } else
            {
                return DbApi.getSizesForCategory(s);
            }
        } else
        {
            return null;
        }
    }

    private List getStyleTagsMetaItemListFromFacetList()
    {
        String s = searchManager.getSearchModel().getCategory();
        if (s != null)
        {
            if (facetLists != null)
            {
                List list = facetLists.getStyleTagsFacets();
                if (list != null && list.size() > 0)
                {
                    return ListingsFilterUtils.getScrubbedList(DbApi.getSubCategoriesForCategory(s), list);
                } else
                {
                    return DbApi.getSubCategoriesForCategory(s);
                }
            } else
            {
                return DbApi.getSubCategoriesForCategory(s);
            }
        } else
        {
            return null;
        }
    }

    private void launchAvailabilitySelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "inventory_status");
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.AVAILABILITY_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, this, this, 11);
    }

    private void launchBrandSelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "brand");
        Bundle bundle = new Bundle();
        bundle.putBoolean("SEARCH_ENABLED", true);
        bundle.putBoolean("RETURN_RESULT", true);
        if (!allowFilteringOnAllBrands())
        {
            bundle.putBoolean("SHOW_ALL", false);
        }
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, this, this, 6);
    }

    private void launchCategorySelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "category");
        Bundle bundle = new Bundle();
        bundle.putString("DISPLAY_MODE", "CATEGORY");
        if (allowFilteringOnAllCategories())
        {
            bundle.putBoolean("SHOW_ALL_VISIBLE", true);
            bundle.putBoolean("SET_SHOW_ALL", true);
        } else
        {
            bundle.putBoolean("SHOW_ALL_VISIBLE", false);
        }
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/CategoryListFragment, this, this, 17);
    }

    private void launchColorSelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "color");
        PMActivity pmactivity = (PMActivity)getActivity();
        Bundle bundle = new Bundle();
        bundle.putInt("COLOR_PICKER_MODE", ColorPickerFragment.COLOR_MODE.COLOR_FILTER.ordinal());
        pmactivity.launchFragmentForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, this, this, 15);
    }

    private void launchConditionSelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "condition");
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.CONDITION_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, this, this, 10);
    }

    private void launchPriceSelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "price");
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.PRICE_MODE.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/PricePickerFragment, this, this, 9);
    }

    private void launchSizeSelection()
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "size");
        Bundle bundle = new Bundle();
        bundle.putInt("MODE", MySizePickerFragment.MODE.SEARCH_FILTER.ordinal());
        ((PMActivity)getActivity()).launchFragmentForResult(bundle, com/poshmark/ui/fragments/MySizePickerFragment, this, this, 8);
    }

    private void launchStyleTagSelection()
    {
    }

    public boolean allowFilteringOnAllBrands()
    {
        return true;
    }

    public boolean allowFilteringOnAllCategories()
    {
        return true;
    }

    public boolean facetsAvailable()
    {
        return facetLists != null;
    }

    public void filterContent()
    {
    }

    public List getBrandsFacetList()
    {
        return getBrandMetaItemListFromFacetList();
    }

    public MetaItem getBrandsMetaItemSelection()
    {
        return getFilterManager().getCurrentBrand();
    }

    public List getColorFacetList()
    {
        return getColorMetaItemListFromFacetList();
    }

    public MetaItem getCurrentMetaItemSelection(MetaItemListViewFragment.META_ITEM_MODES meta_item_modes)
    {
        static class _cls6
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES = new int[MetaItemListViewFragment.META_ITEM_MODES.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.CONDITION_MODE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.AVAILABILITY_MODE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.SIZE_MODE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$MetaItemListViewFragment$META_ITEM_MODES[MetaItemListViewFragment.META_ITEM_MODES.STYLE_TAGS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls6..SwitchMap.com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES[meta_item_modes.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getFilterManager().getCurrentCategory();

        case 2: // '\002'
            return getFilterManager().getCurrentBrand();

        case 3: // '\003'
            return getFilterManager().getCurrentCondition();

        case 4: // '\004'
            return getFilterManager().getCurrentAvailability();
        }
    }

    public List getFacetList(MetaItemListViewFragment.META_ITEM_MODES meta_item_modes)
    {
        switch (_cls6..SwitchMap.com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES[meta_item_modes.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return getCategoryMetaItemListFromFacetList();

        case 5: // '\005'
            return getSizeMetaItemListFromFacetList();

        case 2: // '\002'
            return getBrandMetaItemListFromFacetList();

        case 3: // '\003'
            return getConditionMetaItemListFromFacetList();

        case 4: // '\004'
            return getAvailabilityMetaItemListFromFacetList();

        case 6: // '\006'
            return getStyleTagsMetaItemListFromFacetList();
        }
    }

    public FilterResultsManager getFilterManager()
    {
        return searchManager;
    }

    public List getPriceList()
    {
        return DbApi.getCannedPriceRanges();
    }

    public List getUnscrubbedColorFacetList()
    {
        if (facetLists != null)
        {
            return facetLists.getColorFacets();
        } else
        {
            return null;
        }
    }

    public List getUnscrubbedFacetList(MetaItemListViewFragment.META_ITEM_MODES meta_item_modes)
    {
        _cls6..SwitchMap.com.poshmark.ui.fragments.MetaItemListViewFragment.META_ITEM_MODES[meta_item_modes.ordinal()];
        JVM INSTR tableswitch 5 6: default 32
    //                   5 34
    //                   6 49;
           goto _L1 _L2 _L3
_L1:
        return null;
_L2:
        if (facetLists != null)
        {
            return facetLists.getSizeFacets();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (facetLists != null)
        {
            return facetLists.getStyleTagsFacets();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void handleNotification(Intent intent)
    {
        if (!intent.getAction().equals("com.poshmark.intents.FILTER_SELECTION_ACTION")) goto _L2; else goto _L1
_L1:
        intent = intent.getExtras().getBundle("RESULT");
        if (intent == null) goto _L2; else goto _L3
_L3:
        intent.getInt("FILTER_ACTION");
        JVM INSTR tableswitch 5 17: default 100
    //                   5 141
    //                   6 101
    //                   7 100
    //                   8 106
    //                   9 111
    //                   10 121
    //                   11 126
    //                   12 100
    //                   13 100
    //                   14 100
    //                   15 131
    //                   16 136
    //                   17 116;
           goto _L2 _L4 _L5 _L2 _L6 _L7 _L8 _L9 _L2 _L2 _L2 _L10 _L11 _L12
_L2:
        return;
_L5:
        launchBrandSelection();
        return;
_L6:
        launchSizeSelection();
        return;
_L7:
        launchPriceSelection();
        return;
_L12:
        launchCategorySelection();
        return;
_L8:
        launchConditionSelection();
        return;
_L9:
        launchAvailabilitySelection();
        return;
_L10:
        launchColorSelection();
        return;
_L11:
        launchStyleTagSelection();
        return;
_L4:
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_clicked", "all");
        intent = (PMContainerActivity)getActivity();
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_DRAWER", false);
        intent.launchFragmentForResult(bundle, com/poshmark/ui/fragments/ListingFiltersFragment, this, this, 5);
        return;
    }

    public void hideFilterButtonsForSingleFacet()
    {
        if (facetLists != null && !filterWidget.getIsG2FiltersEnabled())
        {
            List list = facetLists.getCategoryFacets();
            if (list != null && list.size() == 1)
            {
                filterWidget.hideButton(com.poshmark.ui.customviews.ListingsFilterWidget.FILTER_BUTTON.CATEGORY);
            }
            list = facetLists.getBrandFacets();
            if (list != null && list.size() == 1)
            {
                filterWidget.hideButton(com.poshmark.ui.customviews.ListingsFilterWidget.FILTER_BUTTON.BRAND);
                return;
            }
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        Object obj1;
        Object obj2;
        String s2;
        int k;
        boolean flag;
        super.onActivityResult(i, j, intent);
        s2 = "";
        obj1 = "";
        flag = false;
        k = 0;
        obj2 = null;
        if (j == 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Bundle bundle;
        bundle = intent.getBundleExtra("RETURNED_RESULTS");
        intent = bundle.getString("DATA_SELECTED");
        if (intent != null)
        {
            obj2 = (MetaItem)StringUtils.fromJson(intent, com/poshmark/data_model/models/MetaItem);
        }
        intent = s2;
        obj = obj1;
        i;
        JVM INSTR tableswitch 5 17: default 140
    //                   5 922
    //                   6 228
    //                   7 147
    //                   8 368
    //                   9 746
    //                   10 662
    //                   11 704
    //                   12 147
    //                   13 147
    //                   14 147
    //                   15 834
    //                   16 558
    //                   17 263;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L6 _L6 _L6 _L11 _L12 _L13
_L3:
        obj = obj1;
        intent = s2;
_L6:
        if (intent.length() > 0 && ((String) (obj)).length() > 0)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_selected", (new StringBuilder()).append(intent).append("/").append(((String) (obj))).toString());
        }
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "filter_applied", getFilterManager().getSearchModel().getLabelForAnalytics());
_L2:
        return;
_L5:
        intent = "brand";
        obj = obj1;
        if (obj2 != null)
        {
            obj = ((MetaItem) (obj2)).getId();
            getFilterManager().updateBrand(((MetaItem) (obj2)));
        }
        filterContent();
        continue; /* Loop/switch isn't completed */
_L13:
        intent = "category";
        if (obj2 != null)
        {
            obj = ((MetaItem) (obj2)).getId();
            getFilterManager().updateCategory(((MetaItem) (obj2)));
        } else
        {
            obj = "all";
            getFilterManager().getSearchModel().clearCategory();
        }
        getFilterManager().clearsubCategories();
        obj1 = bundle.getString("TAGS_LIST");
        if (obj1 != null)
        {
            obj1 = (List)StringUtils.fromJson(((String) (obj1)), new TypeToken() {

                final PMFilterableFragment this$0;

            
            {
                this$0 = PMFilterableFragment.this;
                super();
            }
            });
            getFilterManager().updateSubCatogories(((List) (obj1)));
        }
        getFilterManager().clearSizeSelection();
        filterContent();
        continue; /* Loop/switch isn't completed */
_L7:
        s2 = "size";
        boolean flag1 = bundle.getBoolean("SIZE_CHANGED");
        boolean flag2 = bundle.getBoolean("MYSIZE_SWITCH_STATE", false);
        j = 0;
        i = k;
        if (getFilterManager().isMySizeEnabled() != flag2)
        {
            getFilterManager().toggleMySize();
            i = 1;
            j = 1;
        }
        if (obj2 != null)
        {
            getFilterManager().updateCategory(((MetaItem) (obj2)));
            i = 1;
        }
        k = i;
        if (flag1)
        {
            intent = bundle.getString("SIZE_LIST");
            k = i;
            if (intent != null)
            {
                intent = (List)StringUtils.fromJson(intent, new TypeToken() {

                    final PMFilterableFragment this$0;

            
            {
                this$0 = PMFilterableFragment.this;
                super();
            }
                });
                getFilterManager().updateSizes(intent);
                k = 1;
                filterContent();
            }
        }
        intent = getFilterManager().getSearchModel().getCommaSeparatedSizes();
        obj1 = intent;
        if (j != 0)
        {
            obj1 = (new StringBuilder()).append(intent).append("My Size").toString();
        }
        intent = s2;
        obj = obj1;
        if (k != 0)
        {
            filterContent();
            intent = s2;
            obj = obj1;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        obj1 = "style";
        i = ((flag) ? 1 : 0);
        if (obj2 != null)
        {
            getFilterManager().updateCategory(((MetaItem) (obj2)));
            i = 1;
        }
        intent = bundle.getString("TAGS_LIST");
        if (intent != null)
        {
            intent = (List)StringUtils.fromJson(intent, new TypeToken() {

                final PMFilterableFragment this$0;

            
            {
                this$0 = PMFilterableFragment.this;
                super();
            }
            });
            getFilterManager().updateSubCatogories(intent);
            i = 1;
            filterContent();
        }
        obj2 = getFilterManager().getSearchModel().getCommaSeparatedTags();
        intent = ((Intent) (obj1));
        obj = obj2;
        if (i != 0)
        {
            filterContent();
            intent = ((Intent) (obj1));
            obj = obj2;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        s2 = "condition";
        intent = s2;
        obj = obj1;
        if (obj2 != null)
        {
            getFilterManager().updateCondition(((MetaItem) (obj2)));
            filterContent();
            obj = ((MetaItem) (obj2)).getId();
            intent = s2;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        s2 = "inventory_status";
        intent = s2;
        obj = obj1;
        if (obj2 != null)
        {
            getFilterManager().updateAvailability(((MetaItem) (obj2)));
            filterContent();
            obj = ((MetaItem) (obj2)).getId();
            intent = s2;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        String s = "price";
        intent = s;
        obj = obj1;
        if (bundle.getBoolean("PRICE_CHANGED"))
        {
            s2 = bundle.getString("PRICE_LIST");
            intent = s;
            obj = obj1;
            if (s2 != null)
            {
                intent = (List)StringUtils.fromJson(s2, new TypeToken() {

                    final PMFilterableFragment this$0;

            
            {
                this$0 = PMFilterableFragment.this;
                super();
            }
                });
                getFilterManager().updatePrices(intent);
                obj = getFilterManager().getCommaSeparatedPrices();
                filterContent();
                intent = s;
            }
        }
        continue; /* Loop/switch isn't completed */
_L11:
        String s1 = "color";
        intent = s1;
        obj = obj1;
        if (bundle.getBoolean("COLOR_CHANGED"))
        {
            s2 = bundle.getString("COLOR_LIST");
            intent = s1;
            obj = obj1;
            if (s2 != null)
            {
                intent = (List)StringUtils.fromJson(s2, new TypeToken() {

                    final PMFilterableFragment this$0;

            
            {
                this$0 = PMFilterableFragment.this;
                super();
            }
                });
                getFilterManager().updateColors(intent);
                obj = getFilterManager().getCommaSeparatedPrices();
                filterContent();
                intent = s1;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        intent = s2;
        obj = obj1;
        if (bundle.getBoolean("FILTERS_CHANGED", false))
        {
            filterContent();
            intent = s2;
            obj = obj1;
        }
        if (true) goto _L6; else goto _L14
_L14:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            searchManager.pullFromBundle(bundle);
        }
    }

    public void onPMResume()
    {
        super.onPMResume();
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.FILTER_SELECTION_ACTION", this);
        if (filterWidget != null)
        {
            filterWidget.updateFilterWidget();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        searchManager.saveToBundle(bundle);
    }

    public void saveFacetLists(Facets facets)
    {
        facetLists = facets;
    }

    public void setViewNameForAnalytics()
    {
    }
}
