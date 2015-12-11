// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.Context;
import android.os.Build;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.framework.AmazonUrlConnectionHelpers;
import com.amazon.identity.auth.device.framework.AuthEndpointErrorParser;
import com.amazon.identity.auth.device.framework.ExchangeTokenRetryLogic;
import com.amazon.identity.auth.device.framework.Tracer;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.cookie.Cookie;
import org.json.JSONObject;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            BuildInfo, MAPLog, StreamUtils

public class AuthPortalHelper
{

    public static final String CUSTOM_USER_AGENT;
    private static final String TAG = com/amazon/identity/auth/device/utils/AuthPortalHelper.getName();
    private final AuthEndpointErrorParser mAuthEndpointErrorParser = new AuthEndpointErrorParser();

    public AuthPortalHelper()
    {
    }

    public boolean isFailure(int i)
    {
        return mAuthEndpointErrorParser.isFailure(i);
    }

    public HttpURLConnection setUpIdentityRequest(Context context, URL url, boolean flag, List list, String s, String s1, Tracer tracer)
        throws IOException
    {
        tracer = AmazonUrlConnectionHelpers.openConnection(url, new ExchangeTokenRetryLogic(context), tracer, context);
        url = tracer;
        if (flag)
        {
            context = new AuthenticationMethodFactory(context, s);
            context.setPackageName(s1);
            url = AmazonUrlConnectionHelpers.openConnection(tracer, context.newAuthenticationMethod("BustedIdentityADPAuthenticator"));
        }
        url.setDoOutput(true);
        if (list != null && list.size() > 0)
        {
            for (context = list.iterator(); context.hasNext(); url.addRequestProperty("Cookie", String.format("%s=%s", new Object[] {
    list.getName(), list.getValue()
})))
            {
                list = (Cookie)context.next();
            }

        }
        url.setRequestMethod("POST");
        url.setRequestProperty("User-Agent", CUSTOM_USER_AGENT);
        return url;
    }

    public HttpURLConnection startIdentityRequestJSON$2cf2a247(Context context, URL url, JSONObject jsonobject, String s, String s1, Tracer tracer)
        throws IOException
    {
        s = setUpIdentityRequest(context, url, false, null, s, s1, tracer);
        s.addRequestProperty("Content-Type", "application/json");
        MAPLog.i(TAG, "Starting JSON request to exchange token endpoint");
        context = s.getOutputStream();
        url = new OutputStreamWriter(context, "UTF-8");
        url.write(jsonobject.toString());
        url.flush();
        StreamUtils.closeStream(context);
        StreamUtils.closeStream(url);
        return s;
        jsonobject;
        StreamUtils.closeStream(context);
        StreamUtils.closeStream(url);
        throw jsonobject;
    }

    public HttpURLConnection startIdentityRequestURLEncoded(Context context, URL url, UrlEncodedFormEntity urlencodedformentity, boolean flag, List list, String s, String s1, 
            Tracer tracer)
        throws IOException
    {
        url = setUpIdentityRequest(context, url, flag, list, s, s1, tracer);
        url.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        MAPLog.i(TAG, "Starting request to exchange token endpoint");
        context = url.getOutputStream();
        urlencodedformentity.writeTo(context);
        StreamUtils.closeStream(context);
        return url;
        url;
        StreamUtils.closeStream(context);
        throw url;
    }

    static 
    {
        CUSTOM_USER_AGENT = (new StringBuilder("AmazonWebView/MAPClientLib/")).append(BuildInfo.getBuildInfo().mMapSWVersion).append("/Android/").append(android.os.Build.VERSION.RELEASE).append("/").append(Build.MODEL).toString();
    }
}
