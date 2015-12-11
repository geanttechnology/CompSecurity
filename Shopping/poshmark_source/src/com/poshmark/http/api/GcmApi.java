// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.http.BrainTreeHttpResponseHandler;
import com.poshmark.http.PMHttpRequest;
import java.util.Map;

public class GcmApi
{

    public GcmApi()
    {
    }

    public static void PostGcmMessage(BrainTreeHttpResponseHandler braintreehttpresponsehandler)
    {
        PMHttpRequest pmhttprequest = new PMHttpRequest(com.poshmark.http.PMHttpRequest.REQUEST_TYPE.HTTP_POST, "https://android.googleapis.com/gcm/send");
        pmhttprequest.headers.put("Authorization", "key=AIzaSyA7erstLkZ2EHcUvF40MW_fiUxQkb0bMvE");
        pmhttprequest.headers.put("Content-Type", "application/json");
        pmhttprequest.formData.put("registration_id", "APA91bGmEpnZ4gmOKQHra3mjAtHqDHaZkfFR-V37CLicOBA9O0cIwYdq8d5jlVef2hetMyZRyXekSm9NXmUGblnZ3li187-hqMzbiNKRvwSNS2ep-86_WLeGn6_oEAZSun66wCCc0CoPO0uc3Os7ZOMe0K7OV-P-9w");
        pmhttprequest.execute(braintreehttpresponsehandler);
    }
}
