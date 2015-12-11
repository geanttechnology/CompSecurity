// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;


// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            GetChildrenCategoriesRequest

public static final class pageNumber
{

    public final String categoryId;
    public final Integer level;
    public final String pageNumber;
    public final String siteId;

    public (String s, long l, Integer integer, Integer integer1)
    {
        siteId = s;
        categoryId = Long.toString(l);
        level = integer;
        if (integer1 != null)
        {
            s = integer1.toString();
        } else
        {
            s = null;
        }
        pageNumber = s;
    }
}
