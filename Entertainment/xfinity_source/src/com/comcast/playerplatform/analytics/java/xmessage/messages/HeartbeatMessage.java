// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent;
import com.comcast.playerplatform.analytics.java.xua.values.XuaHeartbeatValue;

public class HeartbeatMessage extends AbstractXMessageBuilder
{

    private Long bitrate;
    private String cc;
    private Long currentPosition;
    private com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatEnvironment environment;
    private long evtTimestamp;
    private Integer fps;
    private com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatFragment fragment;
    private String sap;
    private AbstractXuaAsset xuaAsset;

    public HeartbeatMessage(long l, Long long1, Long long2, Integer integer, String s, String s1, 
            AbstractXuaAsset abstractxuaasset, com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatEnvironment heartbeatenvironment, com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent.HeartbeatFragment heartbeatfragment)
    {
        evtTimestamp = l;
        currentPosition = long1;
        bitrate = long2;
        fps = integer;
        cc = s;
        sap = s1;
        xuaAsset = abstractxuaasset;
        environment = heartbeatenvironment;
        fragment = heartbeatfragment;
    }

    public void buildXuaEvent()
    {
        XuaHeartbeatEvent xuaheartbeatevent = new XuaHeartbeatEvent(evtTimestamp, XuaEventType.xuaHeartBeat.name(), getMessage().getValue());
        xuaheartbeatevent.setAsset(xuaAsset);
        xuaheartbeatevent.setEnvironment(environment);
        xuaheartbeatevent.setFragment(fragment);
        getMessage().setEvent(xuaheartbeatevent);
    }

    public void buildXuaValue()
    {
        XuaHeartbeatValue xuaheartbeatvalue = new XuaHeartbeatValue();
        xuaheartbeatvalue.setCurrentPosition(currentPosition);
        xuaheartbeatvalue.setBitRate(bitrate);
        xuaheartbeatvalue.setFramesPerSecond(fps);
        xuaheartbeatvalue.setClosedCaptionTrack(cc);
        xuaheartbeatvalue.setSecondaryAudioTrack(sap);
        getMessage().setValue(xuaheartbeatvalue);
    }
}
