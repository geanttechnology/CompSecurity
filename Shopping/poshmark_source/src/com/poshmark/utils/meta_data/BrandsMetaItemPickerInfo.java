// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.MetaItemList;

// Referenced classes of package com.poshmark.utils.meta_data:
//            MetaItemPickerInfo

public class BrandsMetaItemPickerInfo extends MetaItemPickerInfo
{

    public MetaItemList recentItems;

    public BrandsMetaItemPickerInfo()
    {
        recentItems = new MetaItemList(6);
    }

    public void addToRecentItems(MetaItem metaitem)
    {
        recentItems.add(metaitem);
    }

    public MetaItemList getRecentItems()
    {
        return recentItems;
    }
}
