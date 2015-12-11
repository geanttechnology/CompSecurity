// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class description extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER FEMALE;
    public static final OTHER MALE;
    public static final OTHER OTHER;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Gender, s);
    }

    public static description[] values()
    {
        return (description[])$VALUES.clone();
    }

    public final String getDescription()
    {
        return description;
    }

    static 
    {
        MALE = new <init>("MALE", 0, "male");
        FEMALE = new <init>("FEMALE", 1, "female");
        OTHER = new <init>("OTHER", 2, "other");
        $VALUES = (new .VALUES[] {
            MALE, FEMALE, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
