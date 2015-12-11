// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bgt extends Enum
{

    public static final bgt a;
    private static bgt c;
    private static bgt d;
    private static bgt e;
    private static bgt f;
    private static bgt g;
    private static bgt h;
    private static final bgt j[];
    public final String b;
    private String i;

    private bgt(String s, int k, String s1, String s2)
    {
        super(s, k);
        i = s1;
        b = s2;
    }

    public static bgt valueOf(String s)
    {
        return (bgt)Enum.valueOf(bgt, s);
    }

    public static bgt[] values()
    {
        return (bgt[])j.clone();
    }

    public final String toString()
    {
        return i;
    }

    static 
    {
        a = new bgt("ADSENSE_SKIPPABLE", 0, "AdSense Skippable", "adsenseSkippable.xml");
        c = new bgt("ADSENSE_NONSKIPPABLE", 1, "AdSense Nonskippable", "adsenseNonkippable.xml");
        d = new bgt("DOUBLECLICK_AD", 2, "Doubleclick Ad", "xfpVastAd.xml");
        e = new bgt("FREEWHEEL_AD", 3, "FreeWheel Ad", "freewheelVastAd.xml");
        f = new bgt("AD_WITH_COMPANION", 4, "Ad with Companion", "ctaAnnotationsVastAd.xml");
        g = new bgt("APP_PROMOTION_AD", 5, "Ad with App Promotion", "infoCardVastAd.xml");
        h = new bgt("BRAND_SURVEY", 6, "Brand Ad Survey", "surveyVastAd.xml");
        j = (new bgt[] {
            a, c, d, e, f, g, h
        });
    }
}
