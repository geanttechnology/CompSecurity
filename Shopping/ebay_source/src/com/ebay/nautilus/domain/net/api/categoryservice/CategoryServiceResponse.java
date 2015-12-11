// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

public abstract class CategoryServiceResponse extends EbayResponse
{
    public static final class CategoryNodeDetail
    {

        public String actualCategory;
        public String categoryId;
        public int level;
        public String name;
        public String parentCategoryId;

        public CategoryNodeDetail()
        {
        }
    }

    public static final class CategoryPathNode
    {

        public CategoryNodeDetail categoryNodeDetail;
        public CategoryPathNode immediateChildCategory;

        public CategoryPathNode()
        {
        }
    }

    public static abstract class CategoryServicePayload extends BaseApiResponse
    {

        public String categoryTreeVersion;
        public LocaleType locale;

        public CategoryServicePayload()
        {
        }
    }

    public static final class ChildCategoryNode
    {

        public CategoryNodeDetail categoryNodeDetail;
        public List immediateChildCategories;

        public ChildCategoryNode()
        {
        }
    }

    public static final class LocaleType
    {

        String isoCountry;
        String isoLang;

        public LocaleType()
        {
        }
    }

    public static final class PaginationDetails
    {

        public int current;
        public int max;

        public PaginationDetails()
        {
        }
    }


    public CategoryServiceResponse()
    {
    }
}
