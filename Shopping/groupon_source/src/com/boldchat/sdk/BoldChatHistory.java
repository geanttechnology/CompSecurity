// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import com.boldchat.visitor.api.PersonType;

public interface BoldChatHistory
{

    public abstract void addMessage(String s, PersonType persontype, long l, String s1, String s2, String s3);

    public abstract void clearChatHistory();

    public abstract void scrollToBottom();

    public abstract void setStatus(String s);
}
