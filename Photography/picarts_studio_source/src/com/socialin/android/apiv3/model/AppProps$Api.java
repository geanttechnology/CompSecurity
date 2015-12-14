// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;


public final class contactsSendGZIP
{

    public String analyticsUrl;
    public String baseUrl;
    public String contactAnalyticsUrl;
    public boolean contactsSendGZIP;
    public String fourSquareUrl;
    public String locationProvider;
    public String notificationPolicy;
    public String notificationUrl;
    public String retryUrl;
    public String uploadUrl;

    public ()
    {
        baseUrl = "https://api.picsart.com/";
        retryUrl = "https://api.picsart.com/";
        uploadUrl = "https://api.picsart.com/";
        notificationUrl = "https://api.picsart.com/";
        analyticsUrl = "https://analytics.picsart.com/";
        notificationPolicy = "pull";
        fourSquareUrl = "https://api.picsart.com/4sqr";
        locationProvider = "";
        contactAnalyticsUrl = "https://analytics.picsart.com/secure";
        contactsSendGZIP = false;
    }
}
