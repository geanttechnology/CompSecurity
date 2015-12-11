// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import java.io.Serializable;
import org.json.JSONObject;

public class SortOption
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String value;

    public SortOption()
    {
    }

    public static SortOption loadData(JSONObject jsonobject)
    {
        SortOption sortoption = new SortOption();
        sortoption.displayName = jsonobject.optString("displayName");
        sortoption.value = jsonobject.optString("value");
        return sortoption;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getValue()
    {
        return value;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
