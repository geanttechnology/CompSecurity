// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaMediaInfoValue extends AbstractXuaValue
{

    private final String description;
    private final int position;

    public XuaMediaInfoValue(int i, String s)
    {
        position = i;
        description = s;
    }

    public String getDescription()
    {
        return description;
    }

    public int getPosition()
    {
        return position;
    }
}
