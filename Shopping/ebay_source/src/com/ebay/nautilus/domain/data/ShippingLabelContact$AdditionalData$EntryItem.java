// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelContact

public static class value extends BaseDataMapped
{

    public String key;
    public List value;

    public Q()
    {
        value = new ArrayList();
    }
}
