// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            ClientLogInfo

public class ClientMetrics
{

    private List clickedSlots;
    private List exposedSlots;
    private ClientLogInfo logInfo;
    private List metrics;

    public ClientMetrics()
    {
    }

    public List getClickedSlots()
    {
        return clickedSlots;
    }

    public List getExposedSlots()
    {
        return exposedSlots;
    }

    public ClientLogInfo getLogInfo()
    {
        return logInfo;
    }

    public List getMetrics()
    {
        return metrics;
    }

    public void setClickedSlots(List list)
    {
        clickedSlots = list;
    }

    public void setExposedSlots(List list)
    {
        exposedSlots = list;
    }

    public void setLogInfo(ClientLogInfo clientloginfo)
    {
        logInfo = clientloginfo;
    }

    public void setMetrics(List list)
    {
        metrics = list;
    }
}
