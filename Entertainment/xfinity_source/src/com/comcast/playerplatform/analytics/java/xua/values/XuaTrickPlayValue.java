// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaTrickPlayValue extends AbstractXuaValue
{

    private long position;
    private String type;

    public XuaTrickPlayValue()
    {
    }

    public long getPosition()
    {
        return position;
    }

    public String getType()
    {
        return type;
    }

    public void setPosition(long l)
    {
        position = l;
    }

    public void setType(String s)
    {
        type = s;
    }
}
