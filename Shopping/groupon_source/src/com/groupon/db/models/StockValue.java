// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.io.Serializable;

// Referenced classes of package com.groupon.db.models:
//            StockCategory

public class StockValue
    implements Serializable
{

    public String id;
    public int maxStock;
    public String name;
    public transient StockCategory parentStockCategory;
    public Long primaryKey;
    public int soldQuantity;

    public StockValue()
    {
        id = "";
        name = "";
        soldQuantity = 0;
        maxStock = 0;
    }
}
