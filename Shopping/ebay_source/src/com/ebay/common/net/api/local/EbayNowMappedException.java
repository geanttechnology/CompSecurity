// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;


public class EbayNowMappedException
{

    public static final String CARRIER_TRACKING_ID_NOT_FOUND = "CARRIER_TRACKING_ID_NOT_FOUND";
    public static final String INVALID_PHONE = "INVALID_PHONE";
    public static final String NO_SELLER_FOUND = "NO_SELLER_FOUND";
    public static final String ORACLE_ID_NOT_FOUND = "ORACLE_ID_NOT_FOUND";
    public static final String QUOTE_ALREADY_BOOKED = "QUOTE_ALREADY_BOOKED";
    public static final String REASSIGNMENT_TO_SAME_CARRIER = "REASSIGNMENT_TO_SAME_CARRIER";
    public static final String RESERVATION_TOKEN_EXPIRED = "RESERVATION_TOKEN_EXPIRED";
    public static final String RESERVATION_TOKEN_NOT_FOUND = "RESERVATION_TOKEN_NOT_FOUND";
    public static final String SELLER_EIAS_TOKEN_NOT_FOUND = "SELLER_EIAS_TOKEN_NOT_FOUND";
    public static final String SHIPPING_SERVICE_NOT_FOUND = "SHIPPING_SERVICE_NOT_FOUND";
    public static final String STORE_CLOSED = "STORE_CLOSED";
    public static final String STORE_NOT_FOUND = "STORE_NOT_FOUND";
    public static final String STORE_NOT_IN_ZONE = "STORE_NOT_IN_ZONE";
    public static final String TRACKING_ID_NOT_FOUND = "TRACKING_ID_NOT_FOUND";
    public static final String ZONE_ID_NOT_FOUND = "ZONE_ID_NOT_FOUND";
    public String errorId;
    public String message;

    public EbayNowMappedException()
    {
    }
}
