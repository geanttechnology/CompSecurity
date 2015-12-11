// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;


public interface AppLovinPostbackListener
{

    public abstract void onPostbackFailure(String s, int i);

    public abstract void onPostbackSuccess(String s);
}
