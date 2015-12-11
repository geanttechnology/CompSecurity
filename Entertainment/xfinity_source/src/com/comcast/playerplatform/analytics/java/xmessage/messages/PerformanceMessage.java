// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaMapValue;
import java.util.HashMap;
import java.util.Map;

public class PerformanceMessage extends AbstractXMessageBuilder
{

    private final long evtTimestamp;
    private final String stepName;
    private final long valueMs;
    private final AbstractXuaAsset xuaAsset;

    public PerformanceMessage(long l, String s, long l1, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        stepName = s;
        valueMs = l1;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaPerformance.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        Object obj = new HashMap();
        ((Map) (obj)).put(stepName, String.valueOf(valueMs));
        obj = new XuaMapValue(((Map) (obj)));
        getMessage().setValue(((com.comcast.playerplatform.analytics.java.xua.AbstractXuaValue) (obj)));
    }
}
