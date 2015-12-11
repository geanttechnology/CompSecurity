// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import java.util.Map;

public class XuaGenericTupleValue extends AbstractXuaValue
{

    private Map value;

    public XuaGenericTupleValue()
    {
    }

    public Map getValue()
    {
        return value;
    }

    public void setValue(Map map)
    {
        value = map;
    }
}
