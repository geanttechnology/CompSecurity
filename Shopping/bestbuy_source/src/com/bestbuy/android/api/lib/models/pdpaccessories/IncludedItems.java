// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpaccessories;

import gu;
import java.io.Serializable;

public class IncludedItems
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String name;

    public IncludedItems()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String s)
    {
        name = s;
    }
}
