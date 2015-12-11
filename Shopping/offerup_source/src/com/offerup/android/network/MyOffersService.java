// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import retrofit.Callback;

public interface MyOffersService
{

    public abstract void getBuyingArchivedItems(Callback callback);

    public abstract void getSellingArchivedItems(Callback callback);

    public abstract void getSellingItems(Callback callback);
}
