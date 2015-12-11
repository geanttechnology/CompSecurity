// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;


// Referenced classes of package com.ebay.nautilus.domain.net.api.categoryservice:
//            GetCategoryPathRequest

public static final class SiteCategoryInputDetail
{
    public static final class SiteCategoryInputDetail
    {

        public final String categoryId;
        public final String siteId;

        public SiteCategoryInputDetail(String s, long l)
        {
            siteId = s;
            categoryId = Long.toString(l);
        }
    }


    public final SiteCategoryInputDetail siteCategoryInputDetail;

    public SiteCategoryInputDetail.categoryId(String s, long l)
    {
        siteCategoryInputDetail = new SiteCategoryInputDetail(s, l);
    }
}
