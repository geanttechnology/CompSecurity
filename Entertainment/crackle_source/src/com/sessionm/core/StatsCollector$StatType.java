// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            StatsCollector

public static final class  extends Enum
{

    public static final dD dB;
    public static final dD dC;
    public static final dD dD;
    private static final dD dE[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/core/StatsCollector$StatType, s);
    }

    public static [] values()
    {
        return ([])dE.clone();
    }

    static 
    {
        dB = new <init>("AVERAGE", 0);
        dC = new <init>("VALUE", 1);
        dD = new <init>("COUNT", 2);
        dE = (new dE[] {
            dB, dC, dD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
