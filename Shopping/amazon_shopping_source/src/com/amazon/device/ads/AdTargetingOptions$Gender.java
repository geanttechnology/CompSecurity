// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            AdTargetingOptions

public static final class gender extends Enum
{

    private static final FEMALE $VALUES[];
    public static final FEMALE FEMALE;
    public static final FEMALE MALE;
    public static final FEMALE UNKNOWN;
    final String gender;

    public static gender valueOf(String s)
    {
        return (gender)Enum.valueOf(com/amazon/device/ads/AdTargetingOptions$Gender, s);
    }

    public static gender[] values()
    {
        return (gender[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "unknown");
        MALE = new <init>("MALE", 1, "male");
        FEMALE = new <init>("FEMALE", 2, "female");
        $VALUES = (new .VALUES[] {
            UNKNOWN, MALE, FEMALE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        gender = s1;
    }
}
