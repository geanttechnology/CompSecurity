// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.List;

public class StyleTagPickerInfo
{

    public List allItems;
    public List categoryFacetList;
    public MetaItem currentCategory;
    public List selectedItems;
    public List tagsFacetList;

    public StyleTagPickerInfo()
    {
        allItems = new ArrayList();
        selectedItems = new ArrayList();
    }
}
