// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;


public class MAPJavascriptInterface
{
    public static interface MAPJavascriptInterfaceCallback
    {
    }


    private static final String TAG = com/amazon/identity/auth/device/framework/MAPJavascriptInterface.getName();
    private final MAPJavascriptInterfaceCallback mCallback;

    public MAPJavascriptInterface(MAPJavascriptInterfaceCallback mapjavascriptinterfacecallback)
    {
        mCallback = mapjavascriptinterfacecallback;
    }

}
