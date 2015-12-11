// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaOpeningMediaValue;

public class OpeningMediaMessage extends AbstractXMessageBuilder
{

    private long evtTimestamp;
    private String manifestUrl;
    private AbstractXuaAsset xuaAsset;

    public OpeningMediaMessage(long l, AbstractXuaAsset abstractxuaasset, String s)
    {
        evtTimestamp = l;
        xuaAsset = abstractxuaasset;
        manifestUrl = s;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaOpeningMedia.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaOpeningMediaValue xuaopeningmediavalue = new XuaOpeningMediaValue(manifestUrl);
        getMessage().setValue(xuaopeningmediavalue);
    }
}
