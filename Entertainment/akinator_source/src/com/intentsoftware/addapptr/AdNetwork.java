// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;


public final class AdNetwork extends Enum
{

    private static final AdNetwork $VALUES[];
    public static final AdNetwork ADCOLONY;
    public static final AdNetwork ADMOB;
    public static final AdNetwork ADX;
    public static final AdNetwork AMAZON;
    public static final AdNetwork APPLIFT;
    public static final AdNetwork APPLOVIN;
    public static final AdNetwork APPRUPT;
    public static final AdNetwork DFP;
    public static final AdNetwork EMPTY;
    public static final AdNetwork FACEBOOK;
    public static final AdNetwork HOUSE;
    public static final AdNetwork INMOBI;
    public static final AdNetwork LOOPME;
    public static final AdNetwork MDOTM;
    public static final AdNetwork MILLENNIAL;
    public static final AdNetwork MOBFOX;
    public static final AdNetwork MOPUB;
    public static final AdNetwork NEXAGE;
    public static final AdNetwork OPENX;
    public static final AdNetwork PLAYHAVEN;
    public static final AdNetwork PUBMATIC;
    public static final AdNetwork SMAATO;
    public static final AdNetwork SMARTAD;
    public static final AdNetwork SMARTSTREAMTV;
    public static final AdNetwork UNITYADS;
    private String reportingName;
    private String serverConfigName;

    private AdNetwork(String s, int i, String s1)
    {
        super(s, i);
        reportingName = s1;
        serverConfigName = toString();
    }

    private AdNetwork(String s, int i, String s1, String s2)
    {
        super(s, i);
        reportingName = s1;
        serverConfigName = s2;
    }

    public static AdNetwork fromServerConfigName(String s)
    {
        AdNetwork aadnetwork[] = values();
        int j = aadnetwork.length;
        for (int i = 0; i < j; i++)
        {
            AdNetwork adnetwork = aadnetwork[i];
            if (adnetwork.serverConfigName.equals(s))
            {
                return adnetwork;
            }
        }

        return null;
    }

    public static AdNetwork valueOf(String s)
    {
        return (AdNetwork)Enum.valueOf(com/intentsoftware/addapptr/AdNetwork, s);
    }

    public static AdNetwork[] values()
    {
        return (AdNetwork[])$VALUES.clone();
    }

    String getReportingName()
    {
        return reportingName;
    }

    static 
    {
        HOUSE = new AdNetwork("HOUSE", 0, "House");
        MILLENNIAL = new AdNetwork("MILLENNIAL", 1, "Millennial");
        INMOBI = new AdNetwork("INMOBI", 2, "Inmobi");
        ADMOB = new AdNetwork("ADMOB", 3, "AdMob");
        SMARTSTREAMTV = new AdNetwork("SMARTSTREAMTV", 4, "GroupM", "GROUPM");
        EMPTY = new AdNetwork("EMPTY", 5, "Empty");
        MDOTM = new AdNetwork("MDOTM", 6, "MdotM");
        APPLOVIN = new AdNetwork("APPLOVIN", 7, "AppLovin");
        MOBFOX = new AdNetwork("MOBFOX", 8, "MobFox");
        APPLIFT = new AdNetwork("APPLIFT", 9, "AppLift");
        PLAYHAVEN = new AdNetwork("PLAYHAVEN", 10, "PlayHaven");
        SMARTAD = new AdNetwork("SMARTAD", 11, "SmartAdServer");
        NEXAGE = new AdNetwork("NEXAGE", 12, "RTB1", "RTB1");
        ADX = new AdNetwork("ADX", 13, "RTB2", "RTB2");
        DFP = new AdNetwork("DFP", 14, "DFP");
        SMAATO = new AdNetwork("SMAATO", 15, "Smaato");
        APPRUPT = new AdNetwork("APPRUPT", 16, "Apprupt");
        FACEBOOK = new AdNetwork("FACEBOOK", 17, "Facebook");
        UNITYADS = new AdNetwork("UNITYADS", 18, "Unity", "UNITY");
        ADCOLONY = new AdNetwork("ADCOLONY", 19, "AdColony");
        LOOPME = new AdNetwork("LOOPME", 20, "LoopMe");
        AMAZON = new AdNetwork("AMAZON", 21, "Amazon");
        MOPUB = new AdNetwork("MOPUB", 22, "MoPub");
        OPENX = new AdNetwork("OPENX", 23, "OpenX");
        PUBMATIC = new AdNetwork("PUBMATIC", 24, "PubMatic");
        $VALUES = (new AdNetwork[] {
            HOUSE, MILLENNIAL, INMOBI, ADMOB, SMARTSTREAMTV, EMPTY, MDOTM, APPLOVIN, MOBFOX, APPLIFT, 
            PLAYHAVEN, SMARTAD, NEXAGE, ADX, DFP, SMAATO, APPRUPT, FACEBOOK, UNITYADS, ADCOLONY, 
            LOOPME, AMAZON, MOPUB, OPENX, PUBMATIC
        });
    }
}
