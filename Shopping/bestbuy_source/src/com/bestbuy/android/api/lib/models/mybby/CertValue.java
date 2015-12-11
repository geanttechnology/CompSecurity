// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import org.json.JSONObject;

public class CertValue
{

    private String description;
    private String displayName;
    private int displaySequence;
    private String name;
    private int requiredPoints;

    public CertValue()
    {
    }

    public static CertValue loadData(JSONObject jsonobject)
    {
        CertValue certvalue = new CertValue();
        certvalue.description = jsonobject.optString("description");
        certvalue.displayName = jsonobject.optString("displayName");
        certvalue.displaySequence = Integer.parseInt(jsonobject.optString("displaySequence"));
        certvalue.name = jsonobject.optString("name");
        return certvalue;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public int getDisplaySequence()
    {
        return displaySequence;
    }

    public String getName()
    {
        return name;
    }

    public int getRequiredPoints()
    {
        return requiredPoints;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setDisplaySequence(int i)
    {
        displaySequence = i;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setRequiredPoints(int i)
    {
        requiredPoints = i;
    }
}
