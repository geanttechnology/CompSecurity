// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.entities.address;

import java.util.ArrayList;
import java.util.List;

public class AddressComponent
{

    private String longName;
    private String shortName;
    private List types;

    public AddressComponent()
    {
        types = new ArrayList();
    }

    public String getLongName()
    {
        return longName;
    }

    public String getShortName()
    {
        return shortName;
    }

    public List getTypes()
    {
        return types;
    }

    public void setLongName(String s)
    {
        longName = s;
    }

    public void setShortName(String s)
    {
        shortName = s;
    }

    public void setTypes(List list)
    {
        types = list;
    }
}
