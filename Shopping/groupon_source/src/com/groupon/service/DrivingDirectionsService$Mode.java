// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;


// Referenced classes of package com.groupon.service:
//            DrivingDirectionsService

public static final class  extends Enum
{

    private static final BICYCLING $VALUES[];
    public static final BICYCLING BICYCLING;
    public static final BICYCLING DRIVING;
    public static final BICYCLING WALKING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/service/DrivingDirectionsService$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String toString()
    {
        return super.toString().toLowerCase();
    }

    static 
    {
        DRIVING = new <init>("DRIVING", 0);
        WALKING = new <init>("WALKING", 1);
        BICYCLING = new <init>("BICYCLING", 2);
        $VALUES = (new .VALUES[] {
            DRIVING, WALKING, BICYCLING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
