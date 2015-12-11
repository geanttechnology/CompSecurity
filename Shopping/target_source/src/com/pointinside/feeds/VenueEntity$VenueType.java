// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            VenueEntity

public static final class  extends Enum
{

    private static final Corporate $VALUES[];
    public static final Corporate Airport;
    public static final Corporate AmusementPark;
    public static final Corporate BigBox;
    public static final Corporate ConventionCenter;
    public static final Corporate Corporate;
    public static final Corporate CruiseShip;
    public static final Corporate Event;
    public static final Corporate Hospital;
    public static final Corporate Mall;
    public static final Corporate Stadium;
    public static final Corporate Tradeshow;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/feeds/VenueEntity$VenueType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Mall = new <init>("Mall", 0);
        Airport = new <init>("Airport", 1);
        BigBox = new <init>("BigBox", 2);
        Hospital = new <init>("Hospital", 3);
        Stadium = new <init>("Stadium", 4);
        ConventionCenter = new <init>("ConventionCenter", 5);
        Event = new <init>("Event", 6);
        CruiseShip = new <init>("CruiseShip", 7);
        Tradeshow = new <init>("Tradeshow", 8);
        AmusementPark = new <init>("AmusementPark", 9);
        Corporate = new <init>("Corporate", 10);
        $VALUES = (new .VALUES[] {
            Mall, Airport, BigBox, Hospital, Stadium, ConventionCenter, Event, CruiseShip, Tradeshow, AmusementPark, 
            Corporate
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
