// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.gift;

import java.util.List;

public class DerivedGiftCategory
{

    public String category;
    public List themeList;

    public DerivedGiftCategory(String s, List list)
    {
        category = s;
        themeList = list;
    }
}
