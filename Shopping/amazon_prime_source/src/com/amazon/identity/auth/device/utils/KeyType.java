// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;


public final class KeyType extends Enum
{

    private static final KeyType $VALUES[];
    public static final KeyType Debug;
    public static final KeyType Release;
    public static final KeyType ReleaseDebug;

    private KeyType(String s, int i)
    {
        super(s, i);
    }

    public static KeyType valueOf(String s)
    {
        return (KeyType)Enum.valueOf(com/amazon/identity/auth/device/utils/KeyType, s);
    }

    public static KeyType[] values()
    {
        return (KeyType[])$VALUES.clone();
    }

    static 
    {
        Debug = new KeyType("Debug", 0);
        ReleaseDebug = new KeyType("ReleaseDebug", 1);
        Release = new KeyType("Release", 2);
        $VALUES = (new KeyType[] {
            Debug, ReleaseDebug, Release
        });
    }
}
