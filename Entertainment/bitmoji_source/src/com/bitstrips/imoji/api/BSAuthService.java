// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.api;

import com.bitstrips.imoji.models.BSUser;
import retrofit.Callback;

public interface BSAuthService
{

    public abstract void createUser(BSUser bsuser, Callback callback);

    public abstract void exchangeTokens(String s, int i, Callback callback);

    public abstract void getToken(String s, String s1, String s2, String s3, String s4, Callback callback);
}
