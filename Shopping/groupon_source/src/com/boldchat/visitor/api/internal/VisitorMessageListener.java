// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONObject;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            VisitorMessageProcessor

public interface VisitorMessageListener
{

    public abstract void addMessage(long l, JSONObject jsonobject);

    public abstract void autoMessage(String s);

    public abstract void beginActiveAssist(JSONObject jsonobject);

    public abstract void chatClosed(VisitorMessageProcessor visitormessageprocessor);

    public abstract void heartbeat();

    public abstract void onClose(int i, String s, boolean flag, VisitorMessageProcessor visitormessageprocessor);

    public abstract void onError(Exception exception, VisitorMessageProcessor visitormessageprocessor);

    public abstract void onOpen(VisitorMessageProcessor visitormessageprocessor);

    public abstract void onReconnecting(VisitorMessageProcessor visitormessageprocessor);

    public abstract void redirect(String s, VisitorMessageProcessor visitormessageprocessor);

    public abstract void reset(VisitorMessageProcessor visitormessageprocessor);

    public abstract void updateActiveAssist(long l, JSONObject jsonobject);

    public abstract void updateBusy(JSONObject jsonobject);

    public abstract void updateChat(long l, JSONObject jsonobject);

    public abstract void updateTyper(long l, JSONObject jsonobject);
}
