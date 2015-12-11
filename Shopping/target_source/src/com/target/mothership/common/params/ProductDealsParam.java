// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import com.target.mothership.model.store.interfaces.Store;

// Referenced classes of package com.target.mothership.common.params:
//            ProductSummaryParam

public class ProductDealsParam extends ProductSummaryParam
{

    public ProductDealsParam()
    {
        this(null);
    }

    public ProductDealsParam(Store store)
    {
        super(store, null, null, null);
    }
}
