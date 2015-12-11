// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import retrofit.Callback;

public interface RatingService
{

    public abstract void submitRating(long l, long l1, int i, Callback callback);
}
