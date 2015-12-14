// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public interface IAmazonWebserviceCallListener
{

    public abstract void onAuthenticationFailed();

    public abstract void onNetworkFailure();

    public abstract void onParseError$6fe276bc();

    public abstract void onResponseComplete(Object obj);
}
