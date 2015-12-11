// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaErrorValue;
import java.util.Map;

public class ErrorMessage extends AbstractXMessageBuilder
{

    private String code;
    private String description;
    private String errorClass;
    private long evtTimestamp;
    private Map otherValues;
    private AbstractXuaAsset xuaAsset;

    public ErrorMessage(long l, String s, String s1, String s2, Map map, AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        code = s;
        errorClass = s1;
        description = s2;
        xuaAsset = abstractxuaasset;
        otherValues = map;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaError.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaErrorValue xuaerrorvalue = new XuaErrorValue(code, errorClass, description, otherValues);
        getMessage().setValue(xuaerrorvalue);
    }
}
