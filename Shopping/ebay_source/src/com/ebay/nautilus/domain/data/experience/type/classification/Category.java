// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.classification;

import com.ebay.nautilus.domain.data.experience.type.base.Action;
import com.ebay.nautilus.domain.data.experience.type.base.TextualDisplayValue;
import java.util.List;

public class Category
{

    public Action action;
    public List categories;
    public String categoryId;
    public String friendlyName;
    public TextualDisplayValue name;
    public Boolean selected;

    public Category()
    {
    }
}
