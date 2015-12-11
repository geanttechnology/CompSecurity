// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaFPSChangedValue extends AbstractXuaValue
{

    private float value;

    public XuaFPSChangedValue()
    {
    }

    public float getValue()
    {
        return value;
    }

    public void setValue(float f)
    {
        value = f;
    }
}
