// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.groupon.models.CategoryMetadata;
import com.groupon.models.FilterCategory;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.util.Strings;

public class CategoriesUtil
{
    public static final class CategoryComparator
        implements Comparator
    {

        public int compare(Category category, Category category1)
        {
            return category.friendlyName.compareTo(category1.friendlyName);
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((Category)obj, (Category)obj1);
        }

        public CategoryComparator()
        {
        }
    }


    public static final String BROWSE_BY_CATEGORY = "browse_by_category";
    public static final int CATEGORIES_ITEM_MIN_COUNT = 2;
    public static final String CATEGORIES_LIST = "categories_list";
    public static final String CATEGORY = "category";
    public static final String CATEGORY_CAROUSEL = "category_carousel";
    public static final int CATEGORY_CAROUSEL_ANIMATION_DELAY = 200;
    public static final int CATEGORY_CAROUSEL_ANIMATION_DURATION = 400;
    public static final int CATEGORY_CAROUSEL_ANIMATION_REPEAT_COUNT = 1;
    public static final String CATEGORY_CLICK = "category_click";
    public static final String CATEGORY_FROM_GOODS = "category_from_goods";
    public static final String CURRENT_CATEGORY_ID = "current_category_id";
    public static final String GOODS_CATEGORY_EXTRA_INFO = "goods_category_extra_info";
    public static final String SECONDARY_GOODS_CAROUSEL = "secondary_goods_carousel";
    public static final String SELECTED_CATEGORY_ID = "selected_category_id";
    public static final String SELECTED_CATEGORY_ITEM = "selected_category_item";
    private AbTestService abTestService;
    private Application application;
    private CurrentCountryManager currentCountryManager;
    private Map goodsCategoryMetadataMap;
    private Map nearbyCategoryMetadataMap;
    private SharedPreferences prefs;

    public CategoriesUtil()
    {
        goodsCategoryMetadataMap = new HashMap();
        nearbyCategoryMetadataMap = new HashMap();
        goodsCategoryMetadataMap.put("96a83591-1322-4162-9ea0-6527472eafea", new CategoryMetadata("auto-and-home-improvement", "96a83591-1322-4162-9ea0-6527472eafea", 0x7f080207, 0x7f020195));
        goodsCategoryMetadataMap.put("9070f5c4-bd1f-40e5-b680-60f15097aa9d", new CategoryMetadata("baby-kids-and-toys", "9070f5c4-bd1f-40e5-b680-60f15097aa9d", 0x7f080208, 0x7f020196));
        goodsCategoryMetadataMap.put("acdda4d9-237b-4136-9d9e-39eab292b7d1", new CategoryMetadata("electronics", "acdda4d9-237b-4136-9d9e-39eab292b7d1", 0x7f080209, 0x7f020198));
        goodsCategoryMetadataMap.put("c75467fa-b249-41e3-8966-eb6c73c5d9cb", new CategoryMetadata("entertainment-and-media", "c75467fa-b249-41e3-8966-eb6c73c5d9cb", 0x7f08020a, 0x7f020199));
        goodsCategoryMetadataMap.put("4de0bea0-9df2-456f-aabf-3d6fc081dfe6", new CategoryMetadata("food-and-drink-goods", "4de0bea0-9df2-456f-aabf-3d6fc081dfe6", 0x7f08020b, 0x7f02019a));
        goodsCategoryMetadataMap.put("9308a9a1-d736-42f7-b66b-f301f1fd652f", new CategoryMetadata("health-and-beauty", "9308a9a1-d736-42f7-b66b-f301f1fd652f", 0x7f08020c, 0x7f020197));
        goodsCategoryMetadataMap.put("22b22452-35dd-4b44-a42c-9d6c070c075b", new CategoryMetadata("home-and-garden", "22b22452-35dd-4b44-a42c-9d6c070c075b", 0x7f08020d, 0x7f02019b));
        goodsCategoryMetadataMap.put("e87eaeb1-0a39-43fd-87d5-51cd112f7b34", new CategoryMetadata("household-essentials", "e87eaeb1-0a39-43fd-87d5-51cd112f7b34", 0x7f08020e, 0x7f02019c));
        goodsCategoryMetadataMap.put("53d5a99b-f3b5-498c-8a26-fcceb8a79610", new CategoryMetadata("jewelry-and-watches", "53d5a99b-f3b5-498c-8a26-fcceb8a79610", 0x7f08020f, 0x7f02019d));
        goodsCategoryMetadataMap.put("29004ed3-c7d7-4f58-b9fb-2e4ba0f34a18", new CategoryMetadata("men", "29004ed3-c7d7-4f58-b9fb-2e4ba0f34a18", 0x7f080210, 0x7f02019e));
        goodsCategoryMetadataMap.put("a0e884fd-3ace-4fd6-ae8e-80199d0c40b8", new CategoryMetadata("sports-and-outdoors", "a0e884fd-3ace-4fd6-ae8e-80199d0c40b8", 0x7f080211, 0x7f02019f));
        goodsCategoryMetadataMap.put("9f75f737-0c1e-457c-acb9-53a8314cc3f7", new CategoryMetadata("women", "9f75f737-0c1e-457c-acb9-53a8314cc3f7", 0x7f080212, 0x7f0201a0));
        nearbyCategoryMetadataMap.put("food-and-drink", new CategoryMetadata("food-and-drink", "f052f491-36c2-406f-a196-be2c59d281f4", 0x7f08028a, 0x7f020255));
        nearbyCategoryMetadataMap.put("things-to-do", new CategoryMetadata("things-to-do", "938de4d2-b8f5-41c7-860f-94ded05f43c8", 0x7f08028e, 0x7f02025b));
        nearbyCategoryMetadataMap.put("beauty-and-spas", new CategoryMetadata("beauty-and-spas", "294ea30b-dd37-49a1-9805-e9e6c7617902", 0x7f0804f0, 0x7f020254));
        nearbyCategoryMetadataMap.put("health-and-fitness", new CategoryMetadata("health-and-fitness", "1d73e2c7-995a-4e27-a424-734e366888f7", 0x7f08028b, 0x7f020257));
        nearbyCategoryMetadataMap.put("home-improvement", new CategoryMetadata("home-improvement", "01d6ec1d-5511-4b16-a8c1-9bca75966a0d", 0x7f08028c, 0x7f020258));
        nearbyCategoryMetadataMap.put("local-services", new CategoryMetadata("local-services", "69b3c3a7-6cb8-4b6f-8002-7b8aeb95b599", 0x7f08028d, 0x7f020259));
        nearbyCategoryMetadataMap.put("automotive", new CategoryMetadata("automotive", "b92833c4-49cb-4f5f-83b2-660f6ab111b2", 0x7f080289, 0x7f020253));
        nearbyCategoryMetadataMap.put("shopping", new CategoryMetadata("shopping", "c60d65f4-6015-4ed8-b847-d02fd70b5f14", 0x7f08045a, 0x7f02025a));
    }

    public ArrayList convertToArrayList(Set set)
    {
        if (set.size() >= 2)
        {
            return new ArrayList(set);
        } else
        {
            return new ArrayList();
        }
    }

    public FilterCategory getCategoriesFilter(String s)
    {
        if (!Strings.equalsIgnoreCase(prefs.getString(getCategoryModeKey(s), ""), com.groupon.models.FilterCategory.Mode.EVERYTHING.toString()))
        {
            String s1 = prefs.getString(getCategoryNameKey(s), "");
            String s2 = prefs.getString(getCategoryIdKey(s), "");
            s = prefs.getString(getCategoryFacetGroupFiltersKey(s), "");
            if (Strings.notEmpty(s1) && (Strings.notEmpty(s2) || Strings.notEmpty(s)))
            {
                if (Strings.notEmpty(s))
                {
                    return new FilterCategory(s1, s2, s);
                } else
                {
                    return new FilterCategory(s1, s2);
                }
            }
        }
        return new FilterCategory();
    }

    protected String getCategoryFacetGroupFiltersKey(String s)
    {
        return (new StringBuilder()).append(s).append("categoryFacetGroupFilters").toString();
    }

    protected String getCategoryIdKey(String s)
    {
        return (new StringBuilder()).append(s).append("categoryId").toString();
    }

    protected String getCategoryModeKey(String s)
    {
        return (new StringBuilder()).append(s).append("categoryMode").toString();
    }

    protected String getCategoryNameKey(String s)
    {
        return (new StringBuilder()).append(s).append("categoryName").toString();
    }

    public String getDisplayTitle(CategoryMetadata categorymetadata)
    {
        return application.getString(categorymetadata.titleResId);
    }

    public List getGoodsCategories(List list)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        if (list != null && list.size() >= 2)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Category category = (Category)list.next();
                CategoryMetadata categorymetadata = (CategoryMetadata)goodsCategoryMetadataMap.get(category.guid);
                if (categorymetadata != null)
                {
                    category.friendlyNameShort = getDisplayTitle(categorymetadata);
                    category.imageResId = categorymetadata.imageResId;
                    category.relevanceContext = "mobile_goods";
                    category.isSubcategory = false;
                    category.visibility = 8;
                    linkedhashset.add(category);
                }
            } while (true);
        }
        return convertToArrayList(linkedhashset);
    }

    public List getNearbyCategories(List list)
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        if (list != null && list.size() >= 2)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Category category = (Category)list.next();
                CategoryMetadata categorymetadata = (CategoryMetadata)nearbyCategoryMetadataMap.get(category.id);
                if (categorymetadata != null)
                {
                    category.friendlyNameShort = getDisplayTitle(categorymetadata);
                    category.imageResId = categorymetadata.imageResId;
                    category.relevanceContext = "mobile_local";
                    category.isSubcategory = false;
                    category.visibility = 8;
                    linkedhashset.add(category);
                }
            } while (true);
        }
        return convertToArrayList(linkedhashset);
    }

    public String getRelevanceContext(String s)
    {
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            if (Strings.equalsIgnoreCase(s, "local"))
            {
                return "mobile_local";
            }
            if (Strings.equalsIgnoreCase(s, "goods"))
            {
                return "mobile_goods";
            } else
            {
                return "mobile_search";
            }
        } else
        {
            return "mobile_search_intl";
        }
    }

    public String getStringFromFacet(String s, Context context)
    {
        if (s.equalsIgnoreCase("local"))
        {
            return context.getString(0x7f080061);
        }
        if (s.equalsIgnoreCase("goods"))
        {
            return context.getString(0x7f080060);
        } else
        {
            return context.getString(0x7f08005e);
        }
    }

    public String getTitleFromFacet(String s, Context context)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   98539350: 73
    //                   103145323: 58;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_73;
_L4:
        switch (byte0)
        {
        default:
            return s;

        case 0: // '\0'
            return context.getString(0x7f080257);

        case 1: // '\001'
            break;
        }
        break MISSING_BLOCK_LABEL_96;
_L3:
        if (s.equals("local"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("goods"))
        {
            byte0 = 1;
        }
          goto _L4
        if (currentCountryManager.getCurrentCountry().isShoppingChannelEnabled() && !currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            return context.getString(0x7f08044b);
        } else
        {
            return context.getString(0x7f080206);
        }
    }

    public boolean isCarouselGoodsCategorySelectorEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("goodsCategorySelector1511USCA", "carousel") || abTestService.isINTLVariantEnabled("goodsCategorySelector1511%s", "carousel") && !currentCountryManager.getCurrentCountry().isUSACompatible() && currentCountryManager.getCurrentCountry().isSearchEnabledCountry() && !currentCountryManager.getCurrentCountry().isJapan();
    }

    public boolean isCarouselNearbyCategorySelectorEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("nearbyCategorySelector1508USCA", "carousel");
    }

    public boolean isSingleGoodsCategorySelectorEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("goodsCategorySelector1511USCA", "single") || abTestService.isINTLVariantEnabled("goodsCategorySelector1511%s", "single") && !currentCountryManager.getCurrentCountry().isUSACompatible() && currentCountryManager.getCurrentCountry().isSearchEnabledCountry();
    }

    public boolean isSingleNearbyCategorySelectorEnabled()
    {
        return abTestService.isVariantEnabledAndUSCA("nearbyCategorySelector1508USCA", "single");
    }

    public void saveCategoryToPrefs(String s, String s1, String s2, String s3)
    {
        prefs.edit().putString(getCategoryModeKey(s3), com.groupon.models.FilterCategory.Mode.SELECTION.toString()).putString(getCategoryNameKey(s3), s1).putString(getCategoryIdKey(s3), s).putString(getCategoryFacetGroupFiltersKey(s3), s2).apply();
    }
}
