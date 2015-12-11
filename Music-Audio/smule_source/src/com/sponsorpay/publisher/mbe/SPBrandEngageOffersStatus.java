// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;


public final class SPBrandEngageOffersStatus extends Enum
{

    private static final SPBrandEngageOffersStatus ENUM$VALUES[];
    public static final SPBrandEngageOffersStatus MUST_QUERY_SERVER_FOR_OFFERS;
    public static final SPBrandEngageOffersStatus QUERYING_SERVER_FOR_OFFERS;
    public static final SPBrandEngageOffersStatus READY_TO_SHOW_OFFERS;
    public static final SPBrandEngageOffersStatus SHOWING_OFFERS;
    public static final SPBrandEngageOffersStatus USER_ENGAGED;
    private final boolean canChangeParameters;
    private final boolean canRequestOffers;
    private final boolean canShowOffers;

    private SPBrandEngageOffersStatus(String s, int i, boolean flag, boolean flag1, boolean flag2)
    {
        super(s, i);
        canShowOffers = flag;
        canRequestOffers = flag1;
        canChangeParameters = flag2;
    }

    public static SPBrandEngageOffersStatus valueOf(String s)
    {
        return (SPBrandEngageOffersStatus)Enum.valueOf(com/sponsorpay/publisher/mbe/SPBrandEngageOffersStatus, s);
    }

    public static SPBrandEngageOffersStatus[] values()
    {
        SPBrandEngageOffersStatus aspbrandengageoffersstatus[] = ENUM$VALUES;
        int i = aspbrandengageoffersstatus.length;
        SPBrandEngageOffersStatus aspbrandengageoffersstatus1[] = new SPBrandEngageOffersStatus[i];
        System.arraycopy(aspbrandengageoffersstatus, 0, aspbrandengageoffersstatus1, 0, i);
        return aspbrandengageoffersstatus1;
    }

    boolean canChangeParameters()
    {
        return canChangeParameters;
    }

    boolean canRequestOffers()
    {
        return canRequestOffers;
    }

    boolean canShowOffers()
    {
        return canShowOffers;
    }

    static 
    {
        MUST_QUERY_SERVER_FOR_OFFERS = new SPBrandEngageOffersStatus("MUST_QUERY_SERVER_FOR_OFFERS", 0, false, true, true);
        QUERYING_SERVER_FOR_OFFERS = new SPBrandEngageOffersStatus("QUERYING_SERVER_FOR_OFFERS", 1, false, false, false);
        READY_TO_SHOW_OFFERS = new SPBrandEngageOffersStatus("READY_TO_SHOW_OFFERS", 2, true, true, true);
        SHOWING_OFFERS = new SPBrandEngageOffersStatus("SHOWING_OFFERS", 3, true, false, false);
        USER_ENGAGED = new SPBrandEngageOffersStatus("USER_ENGAGED", 4, true, true, false);
        ENUM$VALUES = (new SPBrandEngageOffersStatus[] {
            MUST_QUERY_SERVER_FOR_OFFERS, QUERYING_SERVER_FOR_OFFERS, READY_TO_SHOW_OFFERS, SHOWING_OFFERS, USER_ENGAGED
        });
    }
}
