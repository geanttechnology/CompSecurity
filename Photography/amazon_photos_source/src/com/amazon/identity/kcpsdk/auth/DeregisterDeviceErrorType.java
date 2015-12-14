// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public final class DeregisterDeviceErrorType extends Enum
{

    private static final DeregisterDeviceErrorType $VALUES[];
    public static final DeregisterDeviceErrorType DeregisterDeviceErrorTypeFailed;

    private DeregisterDeviceErrorType(String s, int i)
    {
        super(s, i);
    }

    public static DeregisterDeviceErrorType valueOf(String s)
    {
        return (DeregisterDeviceErrorType)Enum.valueOf(com/amazon/identity/kcpsdk/auth/DeregisterDeviceErrorType, s);
    }

    public static DeregisterDeviceErrorType[] values()
    {
        return (DeregisterDeviceErrorType[])$VALUES.clone();
    }

    static 
    {
        DeregisterDeviceErrorTypeFailed = new DeregisterDeviceErrorType("DeregisterDeviceErrorTypeFailed", 0);
        $VALUES = (new DeregisterDeviceErrorType[] {
            DeregisterDeviceErrorTypeFailed
        });
    }
}
