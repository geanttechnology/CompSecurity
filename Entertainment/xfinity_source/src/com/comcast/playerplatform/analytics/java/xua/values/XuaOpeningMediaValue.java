// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.values;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;

public class XuaOpeningMediaValue extends AbstractXuaValue
{

    private String manifestUrl;

    public XuaOpeningMediaValue(String s)
    {
        manifestUrl = s;
    }

    public String getManifestUrl()
    {
        return manifestUrl;
    }

    public void setManifestUrl(String s)
    {
        manifestUrl = s;
    }
}
