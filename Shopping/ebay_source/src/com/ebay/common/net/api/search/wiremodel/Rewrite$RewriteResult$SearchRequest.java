// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

public static class OWN
{
    static class Feature
    {

        String name;
        List value;

        Feature()
        {
        }
    }

    static class OutputSelector
    {

        OutputSelector()
        {
        }
    }

    static class PaginationInput
    {

        int entriesPerPage;
        int pageNumber;
        int skipCount;

        PaginationInput()
        {
        }
    }

    static class SearchContraints
    {

        List globalAspect;
        List scopedAspect;

        SearchContraints()
        {
        }
    }

    static final class SearchScope extends Enum
    {

        private static final SearchScope $VALUES[];
        public static final SearchScope ITEM_TITLE_AND_DESCRIPTION_SEARCH;
        public static final SearchScope ITEM_TITLE_SEARCH;
        String apiName;

        public static SearchScope valueOf(String s)
        {
            return (SearchScope)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SearchRequest$SearchScope, s);
        }

        public static SearchScope[] values()
        {
            return (SearchScope[])$VALUES.clone();
        }

        static 
        {
            ITEM_TITLE_SEARCH = new SearchScope("ITEM_TITLE_SEARCH", 0, "ItemTitleSearch");
            ITEM_TITLE_AND_DESCRIPTION_SEARCH = new SearchScope("ITEM_TITLE_AND_DESCRIPTION_SEARCH", 1, "ItemTitleAndDescriptionSearch");
            $VALUES = (new SearchScope[] {
                ITEM_TITLE_SEARCH, ITEM_TITLE_AND_DESCRIPTION_SEARCH
            });
        }

        private SearchScope(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    static class UserContext
    {

        Rewrite.RewriteResult.Location userLocation;

        UserContext()
        {
        }
    }


    public List categoryIds;
    public SearchContraints contraints;
    public List excludeCategoryIds;
    public List features;
    public String keyword;
    public OutputSelector outputSelector;
    public PaginationInput paginationInput;
    public List requestConfig;
    public List scopes;
    public String sellerName;
    public PaginationInput shipToLocation;
    public PaginationInput sortOrder;
    public UserContext userContext;

    public UserContext()
    {
        sortOrder = OWN;
    }
}
