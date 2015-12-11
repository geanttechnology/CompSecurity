// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class description extends Enum
{

    private static final NO_KIDS $VALUES[];
    public static final NO_KIDS HAS_KIDS;
    public static final NO_KIDS NO_KIDS;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Children, s);
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
        HAS_KIDS = new <init>("HAS_KIDS", 0, "true");
        NO_KIDS = new <init>("NO_KIDS", 1, "false");
        $VALUES = (new .VALUES[] {
            HAS_KIDS, NO_KIDS
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
