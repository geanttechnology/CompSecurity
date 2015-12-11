// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.meta_data;

import java.util.ArrayList;
import java.util.List;

public class PricePickerInfo
{

    public List allItems;
    public List selectedItems;

    public PricePickerInfo()
    {
        selectedItems = new ArrayList();
    }
}
