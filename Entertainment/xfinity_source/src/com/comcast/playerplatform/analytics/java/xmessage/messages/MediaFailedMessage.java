// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaMediaFailedValue;

public class MediaFailedMessage extends AbstractXMessageBuilder
{

    private String code;
    private String description;
    private long evtTimestamp;
    private String manifestUrl;
    private long position;
    private AbstractXuaAsset xuaAsset;

    public MediaFailedMessage(long l, String s, String s1, long l1, String s2, 
            AbstractXuaAsset abstractxuaasset)
    {
        evtTimestamp = l;
        code = s;
        description = s1;
        position = l1;
        manifestUrl = s2;
        xuaAsset = abstractxuaasset;
    }

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaMediaFailed.name(), getMessage().getValue());
        xuaevent.setAsset(xuaAsset);
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaMediaFailedValue xuamediafailedvalue = new XuaMediaFailedValue(code, description, position, manifestUrl);
        getMessage().setValue(xuamediafailedvalue);
    }
}
