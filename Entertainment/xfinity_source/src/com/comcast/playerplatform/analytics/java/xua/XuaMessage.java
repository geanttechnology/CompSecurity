// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaBaseEvent, XuaApplicationInfo, XuaSessionInfo, XuaDeviceInfo

public class XuaMessage
{

    private XuaBaseEvent analyticsEvent;
    private XuaApplicationInfo applicationInfo;
    private String protocolVersion;
    private XuaSessionInfo sessionInfo;
    private XuaDeviceInfo xuaDeviceInfo;

    public XuaMessage()
    {
    }

    public XuaMessage(String s, XuaApplicationInfo xuaapplicationinfo, XuaDeviceInfo xuadeviceinfo, XuaSessionInfo xuasessioninfo, XuaBaseEvent xuabaseevent)
    {
        protocolVersion = s;
        applicationInfo = xuaapplicationinfo;
        xuaDeviceInfo = xuadeviceinfo;
        sessionInfo = xuasessioninfo;
        analyticsEvent = xuabaseevent;
    }

    public XuaBaseEvent getAnalyticsEvent()
    {
        return analyticsEvent;
    }

    public XuaApplicationInfo getApplicationInfo()
    {
        return applicationInfo;
    }

    public String getEventName()
    {
        return analyticsEvent.getEventName();
    }

    public String getProtocolVersion()
    {
        return protocolVersion;
    }

    public XuaSessionInfo getSessionInfo()
    {
        return sessionInfo;
    }

    public XuaDeviceInfo getXuaDeviceInfo()
    {
        return xuaDeviceInfo;
    }

    public void setAnalyticsEvent(XuaBaseEvent xuabaseevent)
    {
        analyticsEvent = xuabaseevent;
    }

    public void setApplicationInfo(XuaApplicationInfo xuaapplicationinfo)
    {
        applicationInfo = xuaapplicationinfo;
    }

    public void setProtocolVersion(String s)
    {
        protocolVersion = s;
    }

    public void setSessionInfo(XuaSessionInfo xuasessioninfo)
    {
        sessionInfo = xuasessioninfo;
    }

    public void setXuaDeviceInfo(XuaDeviceInfo xuadeviceinfo)
    {
        xuaDeviceInfo = xuadeviceinfo;
    }
}
