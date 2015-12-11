// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public final class RenameDeviceErrorType extends Enum
{

    private static final RenameDeviceErrorType $VALUES[];
    public static final RenameDeviceErrorType RenameDeviceErrorTypeAlreadyUsed;
    public static final RenameDeviceErrorType RenameDeviceErrorTypeInvalidInput;
    public static final RenameDeviceErrorType RenameDeviceErrorTypeUnrecognized;

    private RenameDeviceErrorType(String s, int i)
    {
        super(s, i);
    }

    public static RenameDeviceErrorType valueOf(String s)
    {
        return (RenameDeviceErrorType)Enum.valueOf(com/amazon/identity/kcpsdk/auth/RenameDeviceErrorType, s);
    }

    public static RenameDeviceErrorType[] values()
    {
        return (RenameDeviceErrorType[])$VALUES.clone();
    }

    static 
    {
        RenameDeviceErrorTypeInvalidInput = new RenameDeviceErrorType("RenameDeviceErrorTypeInvalidInput", 0);
        RenameDeviceErrorTypeAlreadyUsed = new RenameDeviceErrorType("RenameDeviceErrorTypeAlreadyUsed", 1);
        RenameDeviceErrorTypeUnrecognized = new RenameDeviceErrorType("RenameDeviceErrorTypeUnrecognized", 2);
        $VALUES = (new RenameDeviceErrorType[] {
            RenameDeviceErrorTypeInvalidInput, RenameDeviceErrorTypeAlreadyUsed, RenameDeviceErrorTypeUnrecognized
        });
    }
}
