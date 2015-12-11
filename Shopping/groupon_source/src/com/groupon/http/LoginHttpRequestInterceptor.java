// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http;

import com.groupon.service.LoginService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.service.gdt.GdtService;
import com.groupon.service.marketrate.MarketRateServiceBase;
import com.groupon.util.CountryNotSupportedException;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class LoginHttpRequestInterceptor
    implements Interceptor
{

    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_VALUE_OAUTH = "OAuth ";
    private static final String URI_TESTING_HOST = "groupon.com";
    private CurrentCountryManager currentCountryManager;
    private CurrentCountryService currentCountryService;
    private GdtService gdtService;
    private LoginService loginService;
    private MarketRateServiceBase marketRateServiceBase;

    public LoginHttpRequestInterceptor()
    {
    }

    public Response intercept(com.squareup.okhttp.Interceptor.Chain chain)
        throws IOException
    {
        Request request;
        com.squareup.okhttp.Request.Builder builder;
        String s7;
        URI uri;
        request = chain.request();
        builder = request.newBuilder();
        s7 = loginService.getAccessToken();
        uri = request.uri();
        if (!Strings.notEmpty(s7) || uri == null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        String s1;
        Object obj1;
        String s2;
        String s3;
        String s4;
        String s5;
        Object obj3;
        String s6;
        Object obj4;
        s2 = null;
        s = null;
        obj4 = null;
        s4 = null;
        s6 = null;
        s5 = null;
        obj3 = null;
        s1 = s5;
        obj = s4;
        s3 = s6;
        obj1 = obj4;
        Object obj2 = uri.getHost();
        s1 = s5;
        obj = s4;
        s = ((String) (obj2));
        s3 = s6;
        obj1 = obj4;
        s2 = ((String) (obj2));
        s4 = (new URI(currentCountryService.getBaseUrl(currentCountryManager.getCurrentCountry()))).getHost();
        s1 = s5;
        obj = s4;
        s = ((String) (obj2));
        s3 = s6;
        obj1 = s4;
        s2 = ((String) (obj2));
        s5 = (new URI(marketRateServiceBase.getCurrentBaseUrl())).getHost();
        s1 = s5;
        obj = s4;
        s = ((String) (obj2));
        s3 = s5;
        obj1 = s4;
        s2 = ((String) (obj2));
        s6 = (new URI(gdtService.getCurrentBaseUrl())).getHost();
        obj1 = s6;
        s = ((String) (obj2));
        obj = s4;
        s1 = s5;
        obj2 = obj1;
_L4:
        obj1 = uri.getScheme();
        if (obj1 != null && ((String) (obj1)).equalsIgnoreCase("https") && (Strings.equalsIgnoreCase(s, obj) || Strings.equalsIgnoreCase(s, s1) || Strings.equalsIgnoreCase(s, obj2) || Ln.isDebugEnabled() && s.endsWith("groupon.com")) && request.header("Suppress authorization") != null)
        {
            builder.header("Authorization", (new StringBuilder()).append("OAuth ").append(s7).toString());
        }
_L2:
        builder.removeHeader("Suppress authorization");
        return chain.proceed(builder.build());
        obj1;
        obj2 = obj3;
        continue; /* Loop/switch isn't completed */
        CountryNotSupportedException countrynotsupportedexception;
        countrynotsupportedexception;
        obj2 = obj3;
        s1 = s3;
        countrynotsupportedexception = ((CountryNotSupportedException) (obj1));
        s = s2;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
