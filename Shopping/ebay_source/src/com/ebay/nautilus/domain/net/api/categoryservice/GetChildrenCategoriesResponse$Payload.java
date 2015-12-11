// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            GetChildrenCategoriesResponse

public static final class ils extends ePayload
{

    public List categoryNodes;
    public int numberOfChildrenCategories;
    public ils paginationDetails;

    public ils()
    {
    }
}
