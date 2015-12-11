// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class SubClass
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private int id;

    public SubClass()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public int getId()
    {
        return id;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setId(int i)
    {
        id = i;
    }
}
