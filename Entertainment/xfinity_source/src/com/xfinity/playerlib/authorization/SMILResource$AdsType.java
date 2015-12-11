// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;


// Referenced classes of package com.xfinity.playerlib.authorization:
//            SMILResource

public static final class  extends Enum
{

    private static final C3_ADS $VALUES[];
    public static final C3_ADS AUDITUDE_ADS;
    public static final C3_ADS C3_ADS;
    public static final C3_ADS NO_ADS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/authorization/SMILResource$AdsType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO_ADS = new <init>("NO_ADS", 0);
        AUDITUDE_ADS = new <init>("AUDITUDE_ADS", 1);
        C3_ADS = new <init>("C3_ADS", 2);
        $VALUES = (new .VALUES[] {
            NO_ADS, AUDITUDE_ADS, C3_ADS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
