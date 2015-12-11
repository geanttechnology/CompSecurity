// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.network;

import retrofit.Callback;

public interface SystemService
{

    public abstract void getStatusJson(String s, String s1, String s2, String s3, Callback callback);
}
