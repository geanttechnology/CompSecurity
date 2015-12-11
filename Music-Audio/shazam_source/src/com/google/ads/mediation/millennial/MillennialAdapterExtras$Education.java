// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class description extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER ASSOCIATES;
    public static final OTHER BACHELORS;
    public static final OTHER DOCTORATE;
    public static final OTHER HIGH_SCHOOL;
    public static final OTHER IN_COLLEGE;
    public static final OTHER MASTERS;
    public static final OTHER OTHER;
    public static final OTHER SOME_COLLEGE;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Education, s);
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
        HIGH_SCHOOL = new <init>("HIGH_SCHOOL", 0, "highschool");
        IN_COLLEGE = new <init>("IN_COLLEGE", 1, "incollege");
        SOME_COLLEGE = new <init>("SOME_COLLEGE", 2, "somecollege");
        ASSOCIATES = new <init>("ASSOCIATES", 3, "associates");
        BACHELORS = new <init>("BACHELORS", 4, "bachelors");
        MASTERS = new <init>("MASTERS", 5, "masters");
        DOCTORATE = new <init>("DOCTORATE", 6, "doctorate");
        OTHER = new <init>("OTHER", 7, "other");
        $VALUES = (new .VALUES[] {
            HIGH_SCHOOL, IN_COLLEGE, SOME_COLLEGE, ASSOCIATES, BACHELORS, MASTERS, DOCTORATE, OTHER
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
