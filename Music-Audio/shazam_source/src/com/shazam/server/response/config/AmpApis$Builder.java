// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;


// Referenced classes of package com.shazam.server.response.config:
//            AmpApis, AmpAccount, AmpBeacon, AmpSearch, 
//            AmpSocial, AmpTagCount

public static class 
{

    private AmpAccount ampAccount;
    private AmpBeacon ampBeacon;
    private AmpSearch ampSearch;
    private AmpSocial ampSocial;
    private AmpTagCount ampTagCount;

    public static  ampApis()
    {
        return new <init>();
    }

    public AmpApis build()
    {
        return new AmpApis(this, null);
    }

    public <init> withAmpAccount(AmpAccount ampaccount)
    {
        ampAccount = ampaccount;
        return this;
    }

    public ampAccount withAmpBeacon(AmpBeacon ampbeacon)
    {
        ampBeacon = ampbeacon;
        return this;
    }

    public ampBeacon withAmpSearch(AmpSearch ampsearch)
    {
        ampSearch = ampsearch;
        return this;
    }

    public ampSearch withAmpSocial(AmpSocial ampsocial)
    {
        ampSocial = ampsocial;
        return this;
    }

    public ampSocial withAmpTagCount(AmpTagCount amptagcount)
    {
        ampTagCount = amptagcount;
        return this;
    }






    public ()
    {
    }
}
