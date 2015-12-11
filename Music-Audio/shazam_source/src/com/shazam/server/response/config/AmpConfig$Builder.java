// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;


// Referenced classes of package com.shazam.server.response.config:
//            AmpConfig, Advertising, AmpApis, AmpNtp, 
//            AmpPlayWith, AmpProMode, AmpShare, AmpStyles, 
//            Charts, AmpNcm, AmpSettings, Stores, 
//            Wear

public static class _cls9
{

    private Advertising advertising;
    private AmpApis ampApis;
    private AmpNtp ampNtp;
    private AmpPlayWith ampPlayWith;
    private AmpProMode ampProMode;
    private AmpShare ampShare;
    private AmpStyles ampStyles;
    private Charts charts;
    private AmpNcm ncm;
    private AmpSettings settings;
    private Stores stores;
    private Wear wear;

    public static _cls9 ampConfig()
    {
        return new <init>();
    }

    public static <init> ampConfig(AmpConfig ampconfig)
    {
        <init> <init>1 = ampConfig();
        <init>1.advertising = AmpConfig.access$1200(ampconfig);
        <init>1.settings = AmpConfig.access$1300(ampconfig);
        <init>1.ampShare = AmpConfig.access$1400(ampconfig);
        <init>1.ampPlayWith = AmpConfig.access$1500(ampconfig);
        <init>1.ampNtp = AmpConfig.access$1600(ampconfig);
        <init>1.ncm = AmpConfig.access$1700(ampconfig);
        <init>1.stores = AmpConfig.access$1800(ampconfig);
        <init>1.charts = AmpConfig.access$1900(ampconfig);
        <init>1.wear = AmpConfig.access$2000(ampconfig);
        <init>1.ampApis = AmpConfig.access$2100(ampconfig);
        <init>1.ampStyles = AmpConfig.access$2200(ampconfig);
        <init>1.ampProMode = AmpConfig.access$2300(ampconfig);
        return <init>1;
    }

    public AmpConfig build()
    {
        return new AmpConfig(this);
    }

    public _cls300 withAdvertising(Advertising advertising1)
    {
        advertising = advertising1;
        return this;
    }

    public advertising withAmpApis(AmpApis ampapis)
    {
        ampApis = ampapis;
        return this;
    }

    public ampApis withAmpProMode(AmpProMode amppromode)
    {
        ampProMode = amppromode;
        return this;
    }

    public ampProMode withAmpShare(AmpShare ampshare)
    {
        ampShare = ampshare;
        return this;
    }

    public ampShare withAmpStyles(AmpStyles ampstyles)
    {
        ampStyles = ampstyles;
        return this;
    }

    public ampStyles withCharts(Charts charts1)
    {
        charts = charts1;
        return this;
    }

    public charts withNcm(AmpNcm ampncm)
    {
        ncm = ampncm;
        return this;
    }

    public ncm withNtp(AmpNtp ampntp)
    {
        ampNtp = ampntp;
        return this;
    }

    public ampNtp withPlayWith(AmpPlayWith ampplaywith)
    {
        ampPlayWith = ampplaywith;
        return this;
    }

    public ampPlayWith withSettings(AmpSettings ampsettings)
    {
        settings = ampsettings;
        return this;
    }

    public settings withStores(Stores stores1)
    {
        stores = stores1;
        return this;
    }

    public stores withWear(Wear wear1)
    {
        wear = wear1;
        return this;
    }













    public _cls9()
    {
    }
}
