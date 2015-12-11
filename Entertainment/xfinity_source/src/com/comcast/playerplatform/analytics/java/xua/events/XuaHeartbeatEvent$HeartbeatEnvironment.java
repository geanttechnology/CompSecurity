// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.events;


// Referenced classes of package com.comcast.playerplatform.analytics.java.xua.events:
//            XuaHeartbeatEvent

public static class bufferSize
{

    private Long bufferSize;
    private Float clientCpu;
    private Float clientMem;
    private Float clientNet;
    private Float playerCpu;

    public Long getBufferSize()
    {
        return bufferSize;
    }

    public Float getClientCpu()
    {
        return clientCpu;
    }

    public Float getClientMem()
    {
        return clientMem;
    }

    public Float getClientNet()
    {
        return clientNet;
    }

    public Float getPlayerCpu()
    {
        return playerCpu;
    }

    public void setBufferSize(Long long1)
    {
        bufferSize = long1;
    }

    public void setClientCpu(Float float1)
    {
        clientCpu = float1;
    }

    public void setClientMem(Float float1)
    {
        clientMem = float1;
    }

    public void setClientNet(Float float1)
    {
        clientNet = float1;
    }

    public void setPlayerCpu(Float float1)
    {
        playerCpu = float1;
    }

    public a(Float float1, Float float2, Float float3, Float float4, Long long1)
    {
        clientCpu = float1;
        playerCpu = float2;
        clientNet = float3;
        clientMem = float4;
        bufferSize = long1;
    }
}
