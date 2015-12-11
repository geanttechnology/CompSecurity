// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.models.chat.ApiConversation;
import retrofit.Callback;

public interface GetConversationMessagesService
{

    public abstract ApiConversation getConversations(String s, String s1, int i, int j);

    public abstract void getConversations(String s, String s1, int i, int j, Callback callback);
}
