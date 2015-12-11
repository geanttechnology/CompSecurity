// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;


// Referenced classes of package com.ebay.common.net.api.search:
//            SearchExpansion, KnownSearchExpansion, SearchParameters

public class SearchRewriteDescriptor
{

    public final SearchExpansion expansion = new SearchExpansion();
    public SearchParameters expansionSearchParameters;
    public final KnownSearchExpansion expansionType;

    public SearchRewriteDescriptor(KnownSearchExpansion knownsearchexpansion, SearchExpansion.ExpansionResult expansionresult)
    {
        expansionType = knownsearchexpansion;
        expansion.expansionResult = expansionresult;
        expansion.expansionType = knownsearchexpansion.serviceExpansionName;
    }

    public void setExpansionSearchParameters(SearchParameters searchparameters)
    {
        expansionSearchParameters = searchparameters;
    }
}
