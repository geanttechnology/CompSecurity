// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive;


public final class NetworkType extends Enum
{

    private static final NetworkType $VALUES[];
    public static final NetworkType Mobile;
    public static final NetworkType NotConnected;
    public static final NetworkType Unknown;
    public static final NetworkType Wifi;

    private NetworkType(String s, int i)
    {
        super(s, i);
    }

    public static NetworkType valueOf(String s)
    {
        return (NetworkType)Enum.valueOf(com/amazon/retailsearch/adaptive/NetworkType, s);
    }

    public static NetworkType[] values()
    {
        return (NetworkType[])$VALUES.clone();
    }

    static 
    {
        Wifi = new NetworkType("Wifi", 0);
        Mobile = new NetworkType("Mobile", 1);
        Unknown = new NetworkType("Unknown", 2);
        NotConnected = new NetworkType("NotConnected", 3);
        $VALUES = (new NetworkType[] {
            Wifi, Mobile, Unknown, NotConnected
        });
    }
}
