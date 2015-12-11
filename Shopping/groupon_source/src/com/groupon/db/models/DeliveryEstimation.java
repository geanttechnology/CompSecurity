// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeliveryEstimation
{
    protected static class ActualEstimation
    {

        public String description;
        public String maxDays;
        public String minDays;

        protected ActualEstimation()
        {
            description = "";
            minDays = "";
            maxDays = "";
        }
    }

    public static class EstimatedDeals
    {

        public String dealUuid;
        public ActualEstimation estimate;
        public List products;

        public EstimatedDeals()
        {
            dealUuid = "";
        }
    }

    public static class EstimatedProducts
    {

        public ActualEstimation estimate;
        public String optionUuid;
        public String productUuid;

        public EstimatedProducts()
        {
            productUuid = "";
            optionUuid = "";
        }
    }

    protected static class Estimates
    {

        public List deals;

        protected Estimates()
        {
        }
    }


    public String dealUuid;
    public ArrayList dealsList;
    public Estimates estimates;
    public HashMap estimatesMap;
    public Date modificationDate;
    public Long primaryKey;

    public DeliveryEstimation()
    {
        estimatesMap = new HashMap();
    }

    public void afterJsonDeserializationPostProcessor(EstimatedDeals estimateddeals)
    {
        dealUuid = estimateddeals.dealUuid;
        Iterator iterator = estimateddeals.products.iterator();
        while (iterator.hasNext()) 
        {
            estimateddeals = (EstimatedProducts)iterator.next();
            HashMap hashmap = estimatesMap;
            String s = ((EstimatedProducts) (estimateddeals)).optionUuid;
            if (((EstimatedProducts) (estimateddeals)).estimate != null)
            {
                estimateddeals = ((EstimatedProducts) (estimateddeals)).estimate.description;
            } else
            {
                estimateddeals = "";
            }
            hashmap.put(s, estimateddeals);
        }
    }

    public void setDealsList()
    {
        if (dealsList == null)
        {
            dealsList = new ArrayList();
        }
        dealsList.addAll(estimates.deals);
    }
}
