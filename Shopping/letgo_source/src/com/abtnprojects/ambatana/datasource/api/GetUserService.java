// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.models.user.User;
import retrofit.Callback;

public interface GetUserService
{

    public abstract User getUser(String s);

    public abstract void getUser(String s, Callback callback);
}
