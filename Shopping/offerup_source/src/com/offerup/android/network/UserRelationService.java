// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import retrofit.Callback;

public interface UserRelationService
{

    public abstract void blockUser(String s, long l);

    public abstract void createReport(String s, long l, Callback callback);

    public abstract void getUserRelationship(long l, Callback callback);

    public abstract void setFinalReason(String s, int i);

    public abstract void setFollow(long l, Callback callback);

    public abstract void setReason(String s, int i, Callback callback);

    public abstract void setUnfollow(long l, Callback callback);
}
