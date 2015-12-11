// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.pds;

import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import java.net.URL;

public abstract class PdsRequest extends EbaySoaRequest
{

    private static final int PDS_TIMEOUT = 5000;
    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/mobileor/v1/commonservices";
    public static final String SERVICE_NAME = "CommonMobileAppService";
    public static final String SOAP_DOMAIN = "http://schemas.xmlsoap.org/soap/envelope/";
    protected final String cguid;

    PdsRequest(String s, String s1, String s2, String s3)
    {
        super("CommonMobileAppService", true, s2);
        super.iafToken = s;
        super.soaGlobalId = s1;
        super.setTimeout(5000);
        super.soaServiceVersion = "1.1.0";
        super.dataFormat = "XML";
        super.responseDataFormat = "XML";
        super.soaContentType = "text/xml;charset=UTF-8";
        cguid = s3;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.pdsApiUrl);
    }
}
