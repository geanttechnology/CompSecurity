// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage;

import com.comcast.playerplatform.analytics.java.xua.XuaMessage;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xmessage:
//            AbstractXMessageBuilder, XMessage

public class XMessageComposer
{

    private AbstractXMessageBuilder messageBuilder;

    public XMessageComposer()
    {
    }

    public void constructMessage()
    {
        messageBuilder.buildNewMessage();
        messageBuilder.buildXuaValue();
        messageBuilder.buildXuaAsset();
        messageBuilder.buildXuaEvent();
    }

    public XuaMessage getFormattedMessage()
    {
        return getMessage().getFormattedMessage();
    }

    public XMessage getMessage()
    {
        return messageBuilder.getMessage();
    }

    public void setMessageBuilder(AbstractXMessageBuilder abstractxmessagebuilder)
    {
        messageBuilder = abstractxmessagebuilder;
    }
}
