// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xmessage.AbstractXMessageBuilder;
import com.comcast.playerplatform.analytics.java.xmessage.XMessage;
import com.comcast.playerplatform.analytics.java.xua.XuaEvent;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;
import com.comcast.playerplatform.analytics.java.xua.values.XuaPageViewValue;

public class PageViewMessage extends AbstractXMessageBuilder
{

    private long evtTimestamp;
    private String pageId;
    private String title;

    public void buildXuaEvent()
    {
        XuaEvent xuaevent = new XuaEvent(evtTimestamp, XuaEventType.xuaPageView.name(), getMessage().getValue());
        getMessage().setEvent(xuaevent);
    }

    public void buildXuaValue()
    {
        XuaPageViewValue xuapageviewvalue = new XuaPageViewValue(pageId, title);
        getMessage().setValue(xuapageviewvalue);
    }
}
