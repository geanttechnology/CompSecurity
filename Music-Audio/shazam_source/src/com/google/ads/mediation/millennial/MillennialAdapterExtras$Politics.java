// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.mediation.millennial;


// Referenced classes of package com.google.ads.mediation.millennial:
//            MillennialAdapterExtras

public static final class description extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN CONSERVATIVE;
    public static final UNKNOWN DEMOCRAT;
    public static final UNKNOWN INDEPENDENT;
    public static final UNKNOWN LIBERAL;
    public static final UNKNOWN MODERATE;
    public static final UNKNOWN OTHER;
    public static final UNKNOWN REPUBLICAN;
    public static final UNKNOWN UNKNOWN;
    private final String description;

    public static description valueOf(String s)
    {
        return (description)Enum.valueOf(com/google/ads/mediation/millennial/MillennialAdapterExtras$Politics, s);
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
        REPUBLICAN = new <init>("REPUBLICAN", 0, "republican");
        DEMOCRAT = new <init>("DEMOCRAT", 1, "democrat");
        CONSERVATIVE = new <init>("CONSERVATIVE", 2, "conservative");
        MODERATE = new <init>("MODERATE", 3, "moderate");
        LIBERAL = new <init>("LIBERAL", 4, "liberal");
        INDEPENDENT = new <init>("INDEPENDENT", 5, "independent");
        OTHER = new <init>("OTHER", 6, "other");
        UNKNOWN = new <init>("UNKNOWN", 7, "unknown");
        $VALUES = (new .VALUES[] {
            REPUBLICAN, DEMOCRAT, CONSERVATIVE, MODERATE, LIBERAL, INDEPENDENT, OTHER, UNKNOWN
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        description = s1;
    }
}
