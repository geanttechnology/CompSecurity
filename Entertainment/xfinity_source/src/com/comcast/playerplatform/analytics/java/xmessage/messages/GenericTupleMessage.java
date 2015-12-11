// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaGenericEvent;
import com.comcast.playerplatform.analytics.java.xua.values.XuaGenericTupleValue;
import java.util.Map;

public class GenericTupleMessage extends AbstractXMessageBuilder
{

    private String eventName;
    private Map eventValue;
    private long evtTimestamp;
    private AbstractXuaAsset xuaAsset;

    public GenericTupleMessage(long l, String s, Map map, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        eventName = s;
        eventValue = map;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaGenericEvent xuagenericevent = new XuaGenericEvent(evtTimestamp, eventName, eventValue);
        xuagenericevent.setAsset(xuaAsset);
        getMessage().setEvent(xuagenericevent);
    }

    public void buildXuaValue()
    {
        XuaGenericTupleValue xuagenerictuplevalue = new XuaGenericTupleValue();
        xuagenerictuplevalue.setValue(eventValue);
        getMessage().setValue(xuagenerictuplevalue);
    }
}
