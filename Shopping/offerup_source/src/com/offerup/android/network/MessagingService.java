// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.dto.response.MessagesResponse;
import retrofit.Callback;

public interface MessagingService
{

    public abstract DiscussionsResponse getBuyingDiscussions();

    public abstract DiscussionsResponse getItemDiscussions(long l);

    public abstract MessagesResponse getMessages(long l);

    public abstract void sendMessage(long l, long l1, String s, Callback callback);

    public abstract void sendMessage(long l, String s, Callback callback);
}
