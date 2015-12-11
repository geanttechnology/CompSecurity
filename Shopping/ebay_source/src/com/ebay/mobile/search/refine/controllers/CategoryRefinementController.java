// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search.refine.controllers;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.search.DetailMode;
import com.ebay.mobile.search.SearchRefineFragment;
import com.ebay.mobile.search.refine.adapters.CategoryOptionAdapter;
import com.ebay.mobile.search.refine.adapters.RefineOptionAdapter;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.ebay.mobile.search.refine.controllers:
//            BaseDetailController

public class CategoryRefinementController extends BaseDetailController
    implements android.widget.AdapterView.OnItemClickListener
{
    public static interface CategoryProvider
    {

        public abstract void clearAspects();

        public abstract void fetchParentChain(long l);

        public abstract Long getCategoryParent(long l);

        public abstract EbayCategorySummary getCategorySummary(long l);

        public abstract void setCategoryParentHeader(String s, Boolean boolean1, Boolean boolean2, Boolean boolean3);
    }


    private final int PLACEHOLDER_ITEM_ID;
    private CategoryOptionAdapter adapter;
    private boolean canNavigateUp;
    private HashMap categoryCache;
    private CategoryProvider categoryProvider;
    private com.ebay.common.model.search.EbayCategoryHistogram.Category currentCategory;
    private final ListView listView;

    public CategoryRefinementController(SearchRefineFragment searchrefinefragment, com.ebay.common.model.search.EbayCategoryHistogram.Category category, com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[], boolean flag, ListView listview)
    {
        this(searchrefinefragment, category, acategory, flag, null, listview);
    }

    protected CategoryRefinementController(SearchRefineFragment searchrefinefragment, com.ebay.common.model.search.EbayCategoryHistogram.Category category, com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[], boolean flag, CategoryRefinementController categoryrefinementcontroller, ListView listview)
    {
label0:
        {
            super(searchrefinefragment);
            categoryCache = null;
            PLACEHOLDER_ITEM_ID = -2;
            canNavigateUp = true;
            currentCategory = null;
            categoryProvider = searchrefinefragment;
            searchrefinefragment = category;
            if (category == null)
            {
                searchrefinefragment = SearchRefineFragment.rootCategoryPlaceholder;
            }
            currentCategory = searchrefinefragment;
            canNavigateUp = determineCanNavigateUp();
            listView = listview;
            listView.setOnItemClickListener(this);
            if (categoryrefinementcontroller != null)
            {
                categoryCache = categoryrefinementcontroller.categoryCache;
            }
            if (categoryCache == null)
            {
                categoryCache = new HashMap();
            }
            if (acategory != null)
            {
                searchrefinefragment = acategory;
                if (acategory.length != 0)
                {
                    break label0;
                }
            }
            searchrefinefragment = acategory;
            if (flag)
            {
                searchrefinefragment = new com.ebay.common.model.search.EbayCategoryHistogram.Category[1];
                searchrefinefragment[0] = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
                searchrefinefragment[0].name = (new StringBuilder()).append(getString(0x7f0705f1)).append("...").toString();
                searchrefinefragment[0].id = -2L;
            }
        }
        category = searchrefinefragment;
        if (currentCategory != null)
        {
            int i = 1;
            if (searchrefinefragment != null)
            {
                i = 1 + searchrefinefragment.length;
            }
            category = new com.ebay.common.model.search.EbayCategoryHistogram.Category[i];
            category[0] = currentCategory;
            if (searchrefinefragment != null)
            {
                for (int j = 0; j < searchrefinefragment.length; j++)
                {
                    category[j + 1] = searchrefinefragment[j];
                }

            }
        }
        searchrefinefragment = category;
        if (category == null)
        {
            searchrefinefragment = new com.ebay.common.model.search.EbayCategoryHistogram.Category[0];
        }
        adapter = new CategoryOptionAdapter(refineFragment.getActivity(), currentCategory, searchrefinefragment, flag);
    }

    private boolean determineCanNavigateUp()
    {
        Long long1;
        boolean flag1;
        flag1 = true;
        long1 = categoryProvider.getCategoryParent(currentCategory.id);
        if (currentCategory.id > 0L && long1 != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (!TextUtils.isEmpty(getSearchParameters().keywords)) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!TextUtils.isEmpty(getSearchParameters().sellerId)) goto _L4; else goto _L5
_L5:
        if (long1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (long1.longValue() > 0L) goto _L4; else goto _L6
_L6:
        return false;
    }

    private com.ebay.common.model.search.EbayCategoryHistogram.Category[] getChildrenForCategory(long l, ArrayList arraylist)
    {
        Object obj = null;
        com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[];
        if (l <= 0L)
        {
            acategory = obj;
            if (arraylist.size() > 0)
            {
                acategory = (com.ebay.common.model.search.EbayCategoryHistogram.Category[])arraylist.toArray(new com.ebay.common.model.search.EbayCategoryHistogram.Category[0]);
            }
        } else
        {
            arraylist = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)arraylist.get(0);
            acategory = obj;
            if (((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (arraylist)).children != null)
            {
                acategory = obj;
                if (((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (arraylist)).children.size() > 0)
                {
                    return (com.ebay.common.model.search.EbayCategoryHistogram.Category[])((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (arraylist)).children.toArray(new com.ebay.common.model.search.EbayCategoryHistogram.Category[0]);
                }
            }
        }
        return acategory;
    }

    private String getParentTitle(com.ebay.common.model.search.EbayCategoryHistogram.Category category)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        if (category != null)
        {
            if (category.id == SearchRefineFragment.rootCategorySummaryPlaceholder.id)
            {
                stringbuilder.append(SearchRefineFragment.rootCategorySummaryPlaceholder.name);
            } else
            if (categoryProvider.getCategoryParent(category.id) != null)
            {
                category = categoryProvider.getCategorySummary(categoryProvider.getCategoryParent(category.id).longValue());
                if (category != null)
                {
                    stringbuilder.append(((EbayCategorySummary) (category)).name);
                } else
                {
                    stringbuilder.append(categoryProvider.getCategorySummary(SearchRefineFragment.rootCategoryPlaceholder.id).name);
                }
            } else
            {
                stringbuilder.append((new StringBuilder()).append(getString(0x7f0705f1)).append("...").toString());
            }
        }
        return stringbuilder.toString();
    }

    private void updateParentButtonState()
    {
        boolean flag1 = true;
        if (!isActive())
        {
            return;
        }
        canNavigateUp = determineCanNavigateUp();
        Boolean boolean1;
        CategoryProvider categoryprovider;
        String s;
        boolean flag;
        boolean flag2;
        if (currentCategory.id > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        boolean1 = Boolean.valueOf(flag);
        categoryprovider = categoryProvider;
        s = getParentTitle(currentCategory);
        flag2 = canNavigateUp;
        if (boolean1.booleanValue() && canNavigateUp)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        categoryprovider.setCategoryParentHeader(s, Boolean.valueOf(flag2), boolean1, Boolean.valueOf(flag));
    }

    public RefineOptionAdapter getAdapter()
    {
        return adapter;
    }

    public DetailMode getDetailMode()
    {
        return DetailMode.CATEGORIES;
    }

    public String getTitle()
    {
        return getString(0x7f07096d);
    }

    public void notifyHeaderClicked()
    {
        onUpClicked();
    }

    public void onAncestorMetadataUpdated()
    {
        updateParentButtonState();
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (adapter.speculative || i < 0)
        {
            return;
        }
        adapterview = (com.ebay.common.model.search.EbayCategoryHistogram.Category)adapterview.getItemAtPosition(i);
        boolean flag;
        if (i == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onItemRowClicked(adapterview, flag);
        refineFragment.trackingEventListener.onRefineCategory();
    }

    public void onItemRowClicked(com.ebay.common.model.search.EbayCategoryHistogram.Category category, boolean flag)
    {
        if (category.id == -2L)
        {
            return;
        } else
        {
            categoryProvider.clearAspects();
            getSearchParameters().aspectHistogram = null;
            onItemRowClickedInternal(category, flag);
            return;
        }
    }

    public void onItemRowClickedInternal(com.ebay.common.model.search.EbayCategoryHistogram.Category category, boolean flag)
    {
        EbayCategorySummary ebaycategorysummary = SearchRefineFragment.rootCategorySummaryPlaceholder;
        EbayCategorySummary ebaycategorysummary1 = new EbayCategorySummary(category);
        if (category == currentCategory)
        {
            refineFragment.showRootRefinementPanel();
            return;
        }
        boolean flag1 = false;
        if (getSearchParameters().keywords != null || !TextUtils.isEmpty(getSearchParameters().sellerId) || category.id > 0L)
        {
            flag1 = true;
        }
        com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[] = null;
        if (category instanceof com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)
        {
            acategory = (com.ebay.common.model.search.EbayCategoryHistogram.Category[])((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)category).children.toArray(new com.ebay.common.model.search.EbayCategoryHistogram.Category[0]);
        }
        refineFragment.setCategory(ebaycategorysummary1, flag);
        ebaycategorysummary1 = getSearchParameters().category;
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
        if (ebaycategorysummary1 == null && deviceconfiguration.get(DcsBoolean.SearchServiceUvcc))
        {
            refineFragment.setUserSelectedAllCategories();
        }
        if (flag1)
        {
            searchParamsUpdated();
        }
        refineCategory(category, acategory, flag1, listView);
    }

    public void onResume()
    {
        if (currentCategory == null)
        {
            closeIfActive();
            return;
        }
        super.onResume();
        if (currentCategory.id > 0L && categoryProvider.getCategoryParent(currentCategory.id) == null)
        {
            categoryProvider.fetchParentChain(currentCategory.id);
        }
        updateParentButtonState();
    }

    public void onSearchParametersUpdated(SearchParameters searchparameters, EbayAspectHistogram ebayaspecthistogram, EbayCategoryHistogram ebaycategoryhistogram)
    {
        if (ebaycategoryhistogram == null)
        {
            closeIfActive();
            return;
        }
        long l = SearchRefineFragment.rootCategorySummaryPlaceholder.id;
        if (searchparameters.category == null)
        {
            categoryCache.clear();
        } else
        {
            l = searchparameters.category.id;
        }
        categoryCache.put(Long.valueOf(l), ebaycategoryhistogram);
        ebayaspecthistogram = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
        if (searchparameters.category == null)
        {
            searchparameters = getChildrenForCategory(0L, ebaycategoryhistogram.categories);
            ebayaspecthistogram.id = SearchRefineFragment.rootCategorySummaryPlaceholder.id;
            ebayaspecthistogram.name = SearchRefineFragment.rootCategorySummaryPlaceholder.name;
        } else
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)ebaycategoryhistogram.categories.get(0);
            searchparameters = getChildrenForCategory(searchparameters.category.id, ebaycategoryhistogram.categories);
            ebayaspecthistogram.id = parentcategory.id;
            ebayaspecthistogram.name = parentcategory.name;
        }
        refineCategory(ebayaspecthistogram, searchparameters, false, listView);
    }

    public void onUpClicked()
    {
        Object obj;
        if (canNavigateUp)
        {
            if ((obj = categoryProvider.getCategoryParent(currentCategory.id)) != null)
            {
                EbayCategorySummary ebaycategorysummary = categoryProvider.getCategorySummary(((Long) (obj)).longValue());
                obj = ebaycategorysummary;
                if (ebaycategorysummary == null)
                {
                    obj = categoryProvider.getCategorySummary(SearchRefineFragment.rootCategorySummaryPlaceholder.id);
                }
                if (obj != null)
                {
                    com.ebay.common.model.search.EbayCategoryHistogram.Category category = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
                    category.id = ((EbayCategorySummary) (obj)).id;
                    category.name = ((EbayCategorySummary) (obj)).name;
                    onItemRowClicked(category, false);
                    return;
                }
            }
        }
    }

    public void refineCategory(com.ebay.common.model.search.EbayCategoryHistogram.Category category, com.ebay.common.model.search.EbayCategoryHistogram.Category acategory[], boolean flag, ListView listview)
    {
        if (acategory != null)
        {
            int i = 0;
            while (i < acategory.length) 
            {
                com.ebay.common.model.search.EbayCategoryHistogram.Category category1 = acategory[i];
                if (!refineFragment.categoryToParent.containsKey(Long.valueOf(category1.id)))
                {
                    HashMap hashmap = refineFragment.categoryToParent;
                    long l1 = category1.id;
                    long l;
                    if (category == null)
                    {
                        l = SearchRefineFragment.rootCategorySummaryPlaceholder.id;
                    } else
                    {
                        l = category.id;
                    }
                    hashmap.put(Long.valueOf(l1), Long.valueOf(l));
                    refineFragment.categoryToSummary.put(Long.valueOf(category1.id), new EbayCategorySummary(category1));
                }
                i++;
            }
        }
        acategory = new CategoryRefinementController(refineFragment, category, acategory, flag, this, listview);
        listview.setAdapter(acategory.getAdapter());
        if (category != null && category.id > 0L);
        refineFragment.showCategoryDetails(acategory);
    }
}
