// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlacementStatusEvent

public static final class  extends Enum
{

    private static final END_ALL $VALUES[];
    public static final END_ALL END;
    public static final END_ALL END_ALL;
    public static final END_ALL FIRST_QUARTILE;
    public static final END_ALL SECOND_QUARTILE;
    public static final END_ALL START;
    public static final END_ALL STATUS;
    public static final END_ALL THIRD_QUARTILE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlacementStatusEvent$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        START = new <init>("START", 0);
        STATUS = new <init>("STATUS", 1);
        FIRST_QUARTILE = new <init>("FIRST_QUARTILE", 2);
        SECOND_QUARTILE = new <init>("SECOND_QUARTILE", 3);
        THIRD_QUARTILE = new <init>("THIRD_QUARTILE", 4);
        END = new <init>("END", 5);
        END_ALL = new <init>("END_ALL", 6);
        $VALUES = (new .VALUES[] {
            START, STATUS, FIRST_QUARTILE, SECOND_QUARTILE, THIRD_QUARTILE, END, END_ALL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
