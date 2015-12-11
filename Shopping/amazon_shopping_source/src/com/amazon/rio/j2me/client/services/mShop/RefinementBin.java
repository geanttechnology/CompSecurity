// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class RefinementBin
{

    private List ancestors;
    private String anyName;
    private String binId;
    private Integer binType;
    private Boolean hasMore;
    private Integer layout;
    private String name;
    private Integer selectMode;
    private List values;

    public RefinementBin()
    {
    }

    public void setAncestors(List list)
    {
        ancestors = list;
    }

    public void setAnyName(String s)
    {
        anyName = s;
    }

    public void setBinId(String s)
    {
        binId = s;
    }

    public void setBinType(Integer integer)
    {
        binType = integer;
    }

    public void setHasMore(Boolean boolean1)
    {
        hasMore = boolean1;
    }

    public void setLayout(Integer integer)
    {
        layout = integer;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setSelectMode(Integer integer)
    {
        selectMode = integer;
    }

    public void setValues(List list)
    {
        values = list;
    }
}
