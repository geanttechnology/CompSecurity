// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.api;

import com.bitstrips.imoji.models.JSONStringPayload;
import retrofit.Callback;

public interface BitstripsService
{

    public abstract void bsAuthEmailLookup(String s, Callback callback);

    public abstract void getAvatarInfo(String s, String s1, String s2, Callback callback);

    public abstract void linkAccounts(String s, String s1, String s2, Callback callback);

    public abstract void purchasePack(String s, String s1, String s2, String s3, JSONStringPayload jsonstringpayload, Callback callback);

    public abstract void saveAvatar(String s, String s1, JSONStringPayload jsonstringpayload, Callback callback);
}
