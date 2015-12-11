// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.models:
//            StockValue, Option

public class StockCategory
{

    public String dealId;
    public Date modificationDate;
    public String name;
    public String optionId;
    public Option parentOption;
    public Long primaryKey;
    public Collection stockValues;

    public StockCategory()
    {
        name = "";
        stockValues = Collections.emptyList();
    }

    public void setStockValues(Collection collection)
    {
        Object obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        for (collection = ((Collection) (obj)).iterator(); collection.hasNext();)
        {
            ((StockValue)collection.next()).parentStockCategory = this;
        }

        stockValues = ((Collection) (obj));
    }
}
