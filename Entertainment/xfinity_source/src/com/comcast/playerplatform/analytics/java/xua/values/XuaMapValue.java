// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import java.util.Map;

public class XuaMapValue extends AbstractXuaValue
{

    private Map map;

    public XuaMapValue(Map map1)
    {
        map = map1;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map1)
    {
        map = map1;
    }
}
