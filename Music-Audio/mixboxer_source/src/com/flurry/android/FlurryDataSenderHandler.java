// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public interface FlurryDataSenderHandler
{

    public abstract void onResponse(int i, String s, String s1);

    public abstract void onServerError(String s);
}
