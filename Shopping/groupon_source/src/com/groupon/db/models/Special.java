// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            Business, Category

public class Special
{

    private Collection categories;
    private volatile ArrayList categoriesList;
    public boolean claimed;
    public String derivedBusinessName;
    public String derivedBusinessUrl;
    public String descriptionHtml;
    public String descriptionText;
    public double distance;
    public String endTime;
    public String expiration;
    public String finePrintHtml;
    public String instructionsHtml;
    public boolean isExactMatch;
    public String name;
    public Business parentBusiness;
    private Long primaryKey;
    public String recurringHtml;
    public String recurringText;
    public String redemptionMethod;
    public String redemptionUnit;
    public String remoteId;
    public String shortRecurringHtml;
    public String shortRecurringText;
    public String startTime;

    public Special()
    {
        name = "";
        descriptionHtml = "";
        descriptionText = "";
        endTime = "";
        startTime = "";
        shortRecurringText = "";
        shortRecurringHtml = "";
        expiration = "";
        finePrintHtml = "";
        instructionsHtml = "";
        recurringText = "";
        recurringHtml = "";
        redemptionMethod = "";
        redemptionUnit = "";
        isExactMatch = false;
        claimed = false;
        distance = 0.0D;
        derivedBusinessName = "";
        derivedBusinessUrl = "";
        categories = Collections.emptyList();
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (parentBusiness != null)
        {
            derivedBusinessName = parentBusiness.name;
            derivedBusinessUrl = parentBusiness.businessUrl;
        }
        for (Iterator iterator = getCategories().iterator(); iterator.hasNext(); ((Category)iterator.next()).afterJsonDeserializationPostProcessor()) { }
    }

    public ArrayList getCategories()
    {
        if (categoriesList != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (categoriesList == null)
        {
            categoriesList = new ArrayList(categories);
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return categoriesList;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getDerivedBusinessName()
    {
        return derivedBusinessName;
    }

    public void setCategories(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((Category)collection.next()).parentSpecial = this;
        }

        categories = ((Collection) (obj));
    }
}
