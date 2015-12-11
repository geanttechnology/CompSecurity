// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import java.util.List;
import retrofit.Callback;

public interface GetConversationsService
{

    public abstract List getConversations(int i, int j);

    public abstract void getConversations(int i, int j, Callback callback);
}
