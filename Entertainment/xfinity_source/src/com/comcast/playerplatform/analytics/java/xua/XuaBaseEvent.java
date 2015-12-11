// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            AbstractXuaAsset, XuaNetworkInfo

public abstract class XuaBaseEvent
{

    private AbstractXuaAsset asset;
    protected String eventName;
    protected XuaNetworkInfo networkInfo;
    protected long timeStamp;

    public XuaBaseEvent()
    {
    }

    public AbstractXuaAsset getAsset()
    {
        return asset;
    }

    public String getEventName()
    {
        return eventName;
    }

    public XuaNetworkInfo getNetworkInfo()
    {
        return networkInfo;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setAsset(AbstractXuaAsset abstractxuaasset)
    {
        asset = abstractxuaasset;
    }

    public void setEventName(String s)
    {
        eventName = s;
    }

    public void setNetworkInfo(XuaNetworkInfo xuanetworkinfo)
    {
        networkInfo = xuanetworkinfo;
    }

    public void setTimeStamp(long l)
    {
        timeStamp = l;
    }
}
