// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.data.UnifiedStream.PaginationInput;

// Referenced classes of package com.ebay.nautilus.domain.net.api.unifiedstream:
//            UssDealDetailsRequest

public static class Q
{

    public final int DEFAULT_LIMIT = 200;
    public final String DEFAULT_READSET = "FEATURED";
    public String dealCategoryId;
    public String lastRefreshedTag;
    public int limit;
    public int offset;
    public PaginationInput paginationInput;
    public String readset;

    public Q()
    {
    }
}
