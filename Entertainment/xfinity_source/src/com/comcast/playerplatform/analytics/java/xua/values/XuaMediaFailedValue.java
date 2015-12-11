// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaMediaFailedValue extends AbstractXuaValue
{

    private String code;
    private String description;
    private String manifestUrl;
    private long pos;

    public XuaMediaFailedValue(String s, String s1, long l, String s2)
    {
        code = s;
        description = s1;
        pos = l;
        manifestUrl = s2;
    }

    public String getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public String getManifestUrl()
    {
        return manifestUrl;
    }

    public long getPos()
    {
        return pos;
    }

    public void setCode(String s)
    {
        code = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setManifestUrl(String s)
    {
        manifestUrl = s;
    }

    public void setPos(long l)
    {
        pos = l;
    }
}
