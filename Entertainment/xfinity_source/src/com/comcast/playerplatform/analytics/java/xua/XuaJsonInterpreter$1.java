// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaJsonInterpreter, XuaEvent, XuaGenericEvent

class registerXuaBaseEvent extends aBaseEventDeserializer
{

    final XuaJsonInterpreter this$0;

    ent()
    {
        this$0 = XuaJsonInterpreter.this;
        super();
        registerXuaBaseEvent("XuaEvent", com/comcast/playerplatform/analytics/java/xua/XuaEvent);
        registerXuaBaseEvent("XuaGenericEvent", com/comcast/playerplatform/analytics/java/xua/XuaGenericEvent);
        registerXuaBaseEvent("XuaHeartbeatEvent", com/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent);
    }
}
