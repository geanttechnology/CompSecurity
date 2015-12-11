// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;

import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchRewriteDescriptor;

// Referenced classes of package com.ebay.common.net.api.search.idealmodel:
//            SrpListItem

public class RewriteEndSrpListItem extends SrpListItem
{

    public final SearchRewriteDescriptor expansionDescriptor;

    public RewriteEndSrpListItem(KnownSearchExpansion knownsearchexpansion, com.ebay.common.net.api.search.SearchExpansion.ExpansionResult expansionresult)
    {
        super(SrpListItem.SrpListItemType.REWRITE_END, null, null);
        expansionDescriptor = new SearchRewriteDescriptor(knownsearchexpansion, expansionresult);
    }
}
