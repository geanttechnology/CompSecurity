// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaBitrateChangedValue extends AbstractXuaValue
{

    private long value;

    public XuaBitrateChangedValue()
    {
    }

    public long getValue()
    {
        return value;
    }

    public void setValue(long l)
    {
        value = l;
    }
}
