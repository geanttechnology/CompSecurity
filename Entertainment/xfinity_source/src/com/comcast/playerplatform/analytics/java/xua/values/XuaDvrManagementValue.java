// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaDvrManagementValue extends AbstractXuaValue
{

    private String count;
    private String type;

    public XuaDvrManagementValue(String s, String s1)
    {
        count = s;
        type = s1;
    }

    public String getCount()
    {
        return count;
    }

    public String getType()
    {
        return type;
    }

    public void setCount(String s)
    {
        count = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
