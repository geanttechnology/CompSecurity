// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import java.util.Map;

// Referenced classes of package com.boldchat.visitor.api:
//            PreChat, Chat, UnavailableReason, UnavailableForm

public interface CreateChatListener
{

    public abstract void onChatCreateFailed(int i, String s);

    public abstract void onChatCreated(PreChat prechat, Chat chat);

    public abstract void onChatUnavailable(Chat chat, UnavailableReason unavailablereason, UnavailableForm unavailableform, Map map);
}
