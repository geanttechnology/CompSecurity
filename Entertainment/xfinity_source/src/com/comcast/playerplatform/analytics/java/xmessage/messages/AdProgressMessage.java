// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xmessage.messages;

import com.comcast.playerplatform.analytics.java.xua.AbstractXuaAsset;
import com.comcast.playerplatform.analytics.java.xua.XuaEventType;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xmessage.messages:
//            GenericStringMessage

public class AdProgressMessage extends GenericStringMessage
{

    public AdProgressMessage(long l, int i, AbstractXuaAsset abstractxuaasset)
    {
        super(l, XuaEventType.xuaAdProgress.name(), String.valueOf(i), abstractxuaasset);
    }
}
