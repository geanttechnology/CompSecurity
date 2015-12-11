// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShippingLabelContact

public static class entry
{
    public static class EntryItem extends BaseDataMapped
    {

        public String key;
        public List value;

        public EntryItem()
        {
            value = new ArrayList();
        }
    }


    public ArrayList entry;

    public EntryItem.value()
    {
        entry = new ArrayList();
    }
}
