// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.List;

public class MetaItemPickerInfo
{

    public List allItems;
    public MetaItem currentCategory;
    public MetaItem currentSelection;

    public MetaItemPickerInfo()
    {
        allItems = new ArrayList();
    }

    public void addToAllItems(MetaItem metaitem)
    {
        allItems.add(metaitem);
    }

    public List getAllItems()
    {
        return allItems;
    }

    public MetaItem getCurrentSelection()
    {
        return currentSelection;
    }

    public void setAllItems(List list)
    {
        allItems = list;
    }
}
