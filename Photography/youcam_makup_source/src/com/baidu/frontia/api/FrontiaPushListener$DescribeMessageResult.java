// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia.api;

import org.json.JSONObject;

public class a
{

    private com.baidu.frontia.module.push.ult a;

    public String getChannelId()
    {
        return a.getChannelId();
    }

    public JSONObject getExtras()
    {
        return a.getExtras();
    }

    public String getId()
    {
        return a.getId();
    }

    public ssageResult.getId getMessage()
    {
        return new Impl(a.getMessage());
    }

    public String getTag()
    {
        return a.getTag();
    }

    public ssageResult.getTag getTrigger()
    {
        return new ssageResult.getTag(a.getTrigger());
    }

    public String getUserId()
    {
        return a.getUserId();
    }

    ssageResult(com.baidu.frontia.module.push.ult ult)
    {
        a = ult;
    }
}
