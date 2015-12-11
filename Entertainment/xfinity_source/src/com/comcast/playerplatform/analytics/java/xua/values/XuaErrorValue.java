// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import java.util.Map;

public class XuaErrorValue extends AbstractXuaValue
{

    private String code;
    private String description;
    private String errorClass;
    private Map otherValues;

    public XuaErrorValue(String s, String s1, String s2, Map map)
    {
        code = s;
        errorClass = s1;
        description = s2;
        otherValues = map;
    }

    public String getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public String getErrorClass()
    {
        return errorClass;
    }

    public Map getOtherValues()
    {
        return otherValues;
    }

    public void setCode(String s)
    {
        code = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setErrorClass(String s)
    {
        errorClass = s;
    }

    public void setMap(Map map)
    {
        otherValues = map;
    }
}
