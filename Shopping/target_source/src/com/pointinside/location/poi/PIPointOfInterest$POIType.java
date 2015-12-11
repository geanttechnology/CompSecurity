// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.poi;


// Referenced classes of package com.pointinside.location.poi:
//            PIPointOfInterest

public static final class name extends Enum
{

    private static final Beacon $VALUES[];
    public static final Beacon Beacon;
    public static final Beacon None;
    private final String name;

    public static name valueOf(String s)
    {
        return (name)Enum.valueOf(com/pointinside/location/poi/PIPointOfInterest$POIType, s);
    }

    public static name[] values()
    {
        return (name[])$VALUES.clone();
    }

    public String toString()
    {
        return name;
    }

    static 
    {
        None = new <init>("None", 0, null);
        Beacon = new <init>("Beacon", 1, "Beacon");
        $VALUES = (new .VALUES[] {
            None, Beacon
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
