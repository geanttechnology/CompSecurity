// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;


// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            GetCategoryPathRequest

public static final class categoryId
{

    public final String categoryId;
    public final String siteId;

    public (String s, long l)
    {
        siteId = s;
        categoryId = Long.toString(l);
    }
}
