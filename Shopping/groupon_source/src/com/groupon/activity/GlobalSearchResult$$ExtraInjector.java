// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import com.groupon.models.category.Category;

// Referenced classes of package com.groupon.activity:
//            GlobalSearchResult

public class 
{

    public static void inject(com.f2prateek.dart.r r, GlobalSearchResult globalsearchresult, Object obj)
    {
        Object obj1 = r.r(obj, "sourceChannel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'sourceChannel' for field 'searchSourceChannel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        globalsearchresult.searchSourceChannel = (Channel)obj1;
        obj1 = r.hannel(obj, "search_term");
        if (obj1 != null)
        {
            globalsearchresult.searchTerm = (String)obj1;
        }
        obj1 = r.hannel(obj, "isDeepLinked");
        if (obj1 != null)
        {
            globalsearchresult.isDeepLinked = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.hannel(obj, "global_search_channel_filter");
        if (obj1 != null)
        {
            globalsearchresult.searchChannelFilter = (String)obj1;
        }
        obj1 = r.Filter(obj, "fromGlobalSearch");
        if (obj1 != null)
        {
            globalsearchresult.isFromGlobalSearch = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.earch(obj, "carousel_origin_channel");
        if (obj1 != null)
        {
            globalsearchresult.carouselOriginChannel = (Channel)obj1;
        }
        obj1 = r.nChannel(obj, "originating_channel");
        if (obj1 != null)
        {
            globalsearchresult.originatingChannel = (Channel)obj1;
        }
        obj1 = r.annel(obj, "current_category_id");
        if (obj1 != null)
        {
            globalsearchresult.currentCategoryId = (String)obj1;
        }
        obj1 = r.ryId(obj, "selected_category_item");
        if (obj1 != null)
        {
            globalsearchresult.selectedCategoryItem = (Category)obj1;
        }
        obj1 = r.oryItem(obj, "selected_category_id");
        if (obj1 != null)
        {
            globalsearchresult.selectedCategoryId = (Integer)obj1;
        }
        obj1 = r.oryId(obj, "facet_group_filter");
        if (obj1 != null)
        {
            globalsearchresult.availableFacetGroupFiltersFromDeepLink = (String)obj1;
        }
        obj1 = r.tGroupFiltersFromDeepLink(obj, "deep_link_with_api_parameters");
        if (obj1 != null)
        {
            globalsearchresult.deepLinkWithApiParameters = (String)obj1;
        }
        obj1 = r.piParameters(obj, "searchOrigin");
        if (obj1 != null)
        {
            globalsearchresult.searchOrigin = (String)obj1;
        }
        obj1 = r.piParameters(obj, "searchFilter");
        if (obj1 != null)
        {
            globalsearchresult.searchFilter = (String)obj1;
        }
        obj1 = r.piParameters(obj, "isFromFinderOrCollectionCard");
        if (obj1 != null)
        {
            globalsearchresult.isFromFinderOrCollectionCard = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.rCollectionCard(obj, "isFromCollectionCard");
        if (obj1 != null)
        {
            globalsearchresult.isFromCollectionCard = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.ionCard) (r.ionCard(obj, "category_carousel")));
        if (r != null)
        {
            globalsearchresult.isCategoryCarousel = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
