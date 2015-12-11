// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import java.io.Serializable;
import org.json.JSONObject;

public class Value
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String catPath;
    private int count;
    private String value;

    public Value()
    {
    }

    public static Value loadData(JSONObject jsonobject)
    {
        Value value1 = new Value();
        value1.value = jsonobject.optString("value");
        value1.count = jsonobject.optInt("count");
        value1.catPath = jsonobject.optString("cat_path");
        return value1;
    }

    public String getCatPath()
    {
        return catPath;
    }

    public int getCount()
    {
        return count;
    }

    public String getValue()
    {
        return value;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setValue(String s)
    {
        value = s;
    }
}
