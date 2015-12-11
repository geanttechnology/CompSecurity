// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;


// Referenced classes of package com.boldchat.visitor.api:
//            Message

public interface ChatMessageListener
{

    public abstract void onAutoMessage(String s);

    public abstract void onMessageAdded(Message message);

    public abstract void onPreliminaryMessageAdded(Message message);
}
