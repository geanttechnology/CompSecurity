// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.imageservice;

import android.app.Application;
import android.content.SharedPreferences;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Ln;

public class ImageServiceHelper
{

    private static final String CDN_PATTERN = ".*/((t|c)[0-9]+x[0-9]+(q[0-9]+)?)\\.(jpg|png)$";
    private static final Pattern CDN_URL_PATTERN = Pattern.compile(".*/((t|c)[0-9]+x[0-9]+(q[0-9]+)?)\\.(jpg|png)$");
    private static final String IMAGE_SERVICE_AUTH_HEADER = "X-IMAGE-SERVICE-AUTH";
    private static final String IMAGE_SERVICE_CLIENT_HEADER = "X-IMAGE-SERVICE-CLIENT";
    private static final String IMAGE_SERVICE_PREF = "image_services_auth_caches";
    private String apiKey;
    private SharedPreferences authKeyCachesSharedPreferences;
    private String client;

    public ImageServiceHelper(Application application, String s, String s1)
    {
        authKeyCachesSharedPreferences = application.getSharedPreferences("image_services_auth_caches", 0);
        client = s;
        apiKey = s1;
        application = authKeyCachesSharedPreferences.getString("X-IMAGE-SERVICE-CLIENT", "");
        String s2 = authKeyCachesSharedPreferences.getString("X-IMAGE-SERVICE-AUTH", "");
        if (!s.equals(application) || !s1.equals(s2))
        {
            Ln.d("client or apiKey updated, clearing cache", new Object[0]);
            authKeyCachesSharedPreferences.edit().clear().putString("X-IMAGE-SERVICE-CLIENT", s).putString("X-IMAGE-SERVICE-AUTH", s1).apply();
        }
    }

    private String getImageServiceKey(String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Missing metadata");
        }
        String s2 = authKeyCachesSharedPreferences.getString(s, null);
        String s1 = s2;
        if (s2 == null)
        {
            s1 = getSHA1ForString(String.format("%s|%s", new Object[] {
                apiKey, s
            }));
            authKeyCachesSharedPreferences.edit().putString(s, s1).apply();
        }
        return s1;
    }

    private String getSHA1ForString(String s)
    {
        StringBuffer stringbuffer;
        int i;
        int j;
        try
        {
            s = MessageDigest.getInstance("SHA1").digest(s.getBytes("UTF-8"));
            stringbuffer = new StringBuffer();
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.w(s);
            return "";
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(Integer.toString((s[i] & 0xff) + 256, 16).substring(1));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        s = stringbuffer.toString();
        return s;
    }

    public void addImageServiceAuthenticationHeader(HttpURLConnection httpurlconnection)
    {
        String s = httpurlconnection.getURL().toString();
        Ln.d((new StringBuilder()).append("Image service: requesting ").append(s).toString(), new Object[0]);
        Object obj = CDN_URL_PATTERN.matcher(s);
        if (((Matcher) (obj)).matches())
        {
            obj = ((Matcher) (obj)).group(1);
            if (obj != null)
            {
                obj = getImageServiceKey(((String) (obj)));
                Ln.d((new StringBuilder()).append("Image service: adding auth key ").append(((String) (obj))).append(" to URL ").append(s).toString(), new Object[0]);
                httpurlconnection.setRequestProperty("X-IMAGE-SERVICE-CLIENT", client);
                httpurlconnection.setRequestProperty("X-IMAGE-SERVICE-AUTH", ((String) (obj)));
            }
        }
    }

}
