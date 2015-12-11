// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua.events;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;

public class XuaHeartbeatEvent extends XuaEvent
{
    public static class HeartbeatEnvironment
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

        public HeartbeatEnvironment(Float float1, Float float2, Float float3, Float float4, Long long1)
        {
            clientCpu = float1;
            playerCpu = float2;
            clientNet = float3;
            clientMem = float4;
            bufferSize = long1;
        }
    }

    public static class HeartbeatFragment
    {

        private int downloadDuration;
        private int downloadLatency;
        private Integer fragmentDuration;
        private int fragmentSize;
        private int numberOfFragments;

        public int getDownloadDuration()
        {
            return downloadDuration;
        }

        public int getDownloadLatency()
        {
            return downloadLatency;
        }

        public Integer getFragmentDuration()
        {
            return fragmentDuration;
        }

        public int getFragmentSize()
        {
            return fragmentSize;
        }

        public int getNumberOfFragments()
        {
            return numberOfFragments;
        }

        public void setDownloadDuration(int i)
        {
            downloadDuration = i;
        }

        public void setDownloadLatency(int i)
        {
            downloadLatency = i;
        }

        public void setFragmentDuration(Integer integer)
        {
            fragmentDuration = integer;
        }

        public void setFragmentSize(int i)
        {
            fragmentSize = i;
        }

        public void setNumberOfFragments(int i)
        {
            numberOfFragments = i;
        }

        public HeartbeatFragment(int i, int j, int k, int l, Integer integer)
        {
            numberOfFragments = i;
            fragmentSize = j;
            downloadLatency = k;
            downloadDuration = l;
            fragmentDuration = integer;
        }
    }


    private HeartbeatEnvironment environment;
    private HeartbeatFragment fragment;

    public XuaHeartbeatEvent()
    {
    }

    public XuaHeartbeatEvent(long l, String s, AbstractXuaValue abstractxuavalue)
    {
        super(l, s, abstractxuavalue);
    }

    public HeartbeatEnvironment getEnvironment()
    {
        return environment;
    }

    public HeartbeatFragment getFragment()
    {
        return fragment;
    }

    public void setEnvironment(HeartbeatEnvironment heartbeatenvironment)
    {
        environment = heartbeatenvironment;
    }

    public void setFragment(HeartbeatFragment heartbeatfragment)
    {
        fragment = heartbeatfragment;
    }
}
