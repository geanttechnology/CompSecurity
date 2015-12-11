// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProvider, GNODrawerItem

public class GNOMenuItemProviderBase extends GNOMenuItemProvider
{

    private Map mItemMap;

    public GNOMenuItemProviderBase()
    {
        mItemMap = new LinkedHashMap();
    }

    public void addItem(GNODrawerItem gnodraweritem)
    {
        mItemMap.put(gnodraweritem.getId(), gnodraweritem);
    }

    public GNODrawerItem getItem(String s)
    {
        return (GNODrawerItem)mItemMap.get(s);
    }

    public Collection getItems()
    {
        return mItemMap.values();
    }
}
