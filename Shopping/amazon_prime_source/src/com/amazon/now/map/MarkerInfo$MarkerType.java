// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;


// Referenced classes of package com.amazon.now.map:
//            MarkerInfo

public static final class  extends Enum
{

    private static final Origin $VALUES[];
    public static final Origin Courier;
    public static final Origin Destination;
    public static final Origin Origin;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/now/map/MarkerInfo$MarkerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Destination = new <init>("Destination", 0);
        Courier = new <init>("Courier", 1);
        Origin = new <init>("Origin", 2);
        $VALUES = (new .VALUES[] {
            Destination, Courier, Origin
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
