// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaSearchValue extends AbstractXuaValue
{

    private String query;

    public XuaSearchValue(String s)
    {
        query = s;
    }

    public String getQuery()
    {
        return query;
    }

    public void setQuery(String s)
    {
        query = s;
    }
}
