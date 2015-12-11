// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;


// Referenced classes of package com.amazon.geo.mapsv2.util:
//            MapsInitializerInternal

public static final class  extends Enum
{

    private static final FAILED $VALUES[];
    public static final FAILED CANCELED;
    public static final FAILED FAILED;
    public static final FAILED OK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/geo/mapsv2/util/MapsInitializerInternal$PreloadResult, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OK = new <init>("OK", 0);
        CANCELED = new <init>("CANCELED", 1);
        FAILED = new <init>("FAILED", 2);
        $VALUES = (new .VALUES[] {
            OK, CANCELED, FAILED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
