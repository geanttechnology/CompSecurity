// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;


public final class EResType extends Enum
{

    private static final EResType $VALUES[];
    public static final EResType ASSET;
    public static final EResType LOCAL;
    public static final EResType NETWORK;
    public static final EResType ONLINE;
    public static final EResType RES;

    private EResType(String s, int i)
    {
        super(s, i);
    }

    public static EResType valueOf(String s)
    {
        return (EResType)Enum.valueOf(com/wantu/model/res/EResType, s);
    }

    public static EResType[] values()
    {
        return (EResType[])$VALUES.clone();
    }

    static 
    {
        RES = new EResType("RES", 0);
        ASSET = new EResType("ASSET", 1);
        LOCAL = new EResType("LOCAL", 2);
        NETWORK = new EResType("NETWORK", 3);
        ONLINE = new EResType("ONLINE", 4);
        $VALUES = (new EResType[] {
            RES, ASSET, LOCAL, NETWORK, ONLINE
        });
    }
}
