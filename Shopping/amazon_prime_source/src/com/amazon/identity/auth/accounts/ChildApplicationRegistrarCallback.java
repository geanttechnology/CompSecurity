// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import com.amazon.identity.kcpsdk.auth.RegisterDeviceResponse;

public interface ChildApplicationRegistrarCallback
{

    public abstract void onAuthenticationFailed();

    public abstract void onBadResponse();

    public abstract void onInvalidRequest();

    public abstract void onNetworkError();

    public abstract void onRegisterChildApplicationComplete(RegisterDeviceResponse registerdeviceresponse);
}
