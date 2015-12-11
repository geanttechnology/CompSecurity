// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.values.XuaGenericEventValue;

public class GenericStringMessage extends AbstractXMessageBuilder
{

    private String eventName;
    private String eventValue;
    private long evtTimestamp;
    private AbstractXuaAsset xuaAsset;

    public GenericStringMessage(long l, String s, String s1, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        eventName = s;
        eventValue = s1;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, eventName, getMessage().getValue());
        xuaevent.setTimeStamp(evtTimestamp);
        xuaevent.setEventName(eventName);
        xuaevent.setValue(getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaGenericEventValue xuagenericeventvalue = new XuaGenericEventValue();
        xuagenericeventvalue.setValue(eventValue);
        getMessage().setValue(xuagenericeventvalue);
    }
}
