// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.a.a.a.h;
import com.a.a.n;
import com.rdio.android.core.OAuth2Session;
import com.rdio.android.core.RdioApiRequestArg;
import com.rdio.android.core.VolleyOAuth2RdioService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RdioService extends VolleyOAuth2RdioService
{

    private static final String SERVICE_BASE_URI = "https://services.rdio.com";
    private static final String WEB_BASE_URI = "https://www.rdio.com";
    private String apiVersion;

    public RdioService(String s, Context context, OAuth2Session oauth2session)
    {
        super(context, oauth2session, getUserAgentString(context));
        apiVersion = s;
        setApiBaseUri("https://services.rdio.com", "https://services.rdio.com", "https://www.rdio.com");
    }

    public RdioService(String s, Context context, OAuth2Session oauth2session, h h)
    {
        super(context, oauth2session, h, getUserAgentString(context));
        apiVersion = s;
        setApiBaseUri("https://services.rdio.com", "https://services.rdio.com", "https://www.rdio.com");
    }

    public RdioService(String s, OAuth2Session oauth2session, n n, int i)
    {
        super(oauth2session, n, i, getUserAgentString(null));
        apiVersion = s;
        setApiBaseUri("https://services.rdio.com", "https://services.rdio.com", "https://www.rdio.com");
    }

    private static String getUserAgentString(Context context)
    {
        Object obj;
        int i = 0;
        String s;
        String s1;
        PackageInfo packageinfo;
        int j;
        if (context != null)
        {
            s = context.getPackageName();
        } else
        {
            s = "unknownPackage";
        }
        s1 = "unknownVersion";
        obj = s1;
        packageinfo = context.getPackageManager().getPackageInfo(s, 0);
        obj = s1;
        context = packageinfo.versionName;
        obj = context;
        j = packageinfo.versionCode;
        i = j;
_L2:
        return (new StringBuilder()).append("Rdio Android SDK; ").append(s).append("/").append(context).append("; build ").append(i).toString();
        context;
        context = ((Context) (obj));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void postRequest(RdioApiRequestArg ardioapirequestarg[], com.rdio.android.core.RdioService_Api.ResponseListener responselistener, boolean flag, Object obj)
    {
        int j = ardioapirequestarg.length;
        int i = 0;
        boolean flag1 = false;
        while (i < j) 
        {
            if (ardioapirequestarg[i].getName() == "v" || flag1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            i++;
        }
        if (!flag1)
        {
            ardioapirequestarg = new ArrayList(Arrays.asList(ardioapirequestarg));
            ardioapirequestarg.add(createArg("v", apiVersion));
            super.postRequest((RdioApiRequestArg[])ardioapirequestarg.toArray(new RdioApiRequestArg[ardioapirequestarg.size()]), responselistener, flag, obj);
            return;
        } else
        {
            super.postRequest(ardioapirequestarg, responselistener, flag, obj);
            return;
        }
    }

    public void processWebViewActivity(Intent intent, String s)
    {
        super.getUserAccessToken(intent.getStringExtra("authResultUrl"), s);
    }
}
