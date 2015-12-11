// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class description extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER DIVORCED;
    public static final OTHER ENGAGED;
    public static final OTHER MARRIED;
    public static final OTHER OTHER;
    public static final OTHER RELATIONSHIP;
    public static final OTHER SINGLE;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$MaritalStatus, s);
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
        SINGLE = new <init>("SINGLE", 0, "single");
        DIVORCED = new <init>("DIVORCED", 1, "divorced");
        ENGAGED = new <init>("ENGAGED", 2, "engaged");
        RELATIONSHIP = new <init>("RELATIONSHIP", 3, "relationship");
        MARRIED = new <init>("MARRIED", 4, "married");
        OTHER = new <init>("OTHER", 5, "other");
        $VALUES = (new .VALUES[] {
            SINGLE, DIVORCED, ENGAGED, RELATIONSHIP, MARRIED, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
