// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntrospectiveArrayList extends ArrayList
{

    private Map label;

    public IntrospectiveArrayList()
    {
        label = new HashMap();
    }

    public Map getLabel()
    {
        return label;
    }

    public String getLableValue(String s)
    {
        return (String)label.get(s);
    }

    public void setLabel(String s, String s1)
    {
        label.put(s, s1);
    }

    public void setLabel(Map map)
    {
        label = map;
    }
}
