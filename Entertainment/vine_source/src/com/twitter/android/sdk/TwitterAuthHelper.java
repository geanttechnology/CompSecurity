// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.sdk;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

public class TwitterAuthHelper
{

    private static final String FORM_URLENCODED_HEADER = "application/x-www-form-urlencoded";
    private static final String OAUTH_SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String OAUTH_VERSION = "1.0";
    private static final SecureRandom RAND = new SecureRandom();
    private static final String REALM = "https://api.twitter.com/";
    private static final String UTF8 = "UTF8";

    private TwitterAuthHelper()
    {
    }

    public static void attachHeader(HttpURLConnection httpurlconnection, String s, String s1, String s2, String s3, long l, HttpEntity httpentity)
        throws URISyntaxException
    {
        httpurlconnection.addRequestProperty("Authorization", makeAuthorizationHeaderValue(httpurlconnection.getURL().toURI(), httpurlconnection.getRequestMethod(), s, s1, s2, s3, l, httpentity));
    }

    public static void attachHeader(HttpRequestBase httprequestbase, String s, String s1, String s2, String s3, long l, HttpEntity httpentity)
    {
        httprequestbase.setHeader("Authorization", makeAuthorizationHeaderValue(httprequestbase.getURI(), httprequestbase.getMethod(), s, s1, s2, s3, l, httpentity));
    }

    public static String encode(String s)
    {
        if (s == null)
        {
            return "";
        } else
        {
            return Uri.encode(s);
        }
    }

    public static String makeAuthorizationHeaderValue(String s, String s1, String s2, String s3, String s4)
    {
        if (s4 == null)
        {
            return String.format("OAuth realm=\"%s\", oauth_version=\"%s\", oauth_nonce=\"%s\", oauth_timestamp=\"%s\", oauth_signature=\"%s\", oauth_consumer_key=\"%s\", oauth_signature_method=\"%s\"", new Object[] {
                "https://api.twitter.com/", "1.0", s2, s3, s, s1, "HMAC-SHA1"
            });
        } else
        {
            return String.format("OAuth realm=\"%s\", oauth_version=\"%s\", oauth_token=\"%s\", oauth_nonce=\"%s\", oauth_timestamp=\"%s\", oauth_signature=\"%s\", oauth_consumer_key=\"%s\", oauth_signature_method=\"%s\"", new Object[] {
                "https://api.twitter.com/", "1.0", s4, s2, s3, s, s1, "HMAC-SHA1"
            });
        }
    }

    public static String makeAuthorizationHeaderValue(URI uri, String s, String s1, String s2, String s3, String s4, long l, 
            HttpEntity httpentity)
    {
        String s5 = (new StringBuilder()).append(String.valueOf(System.nanoTime())).append(String.valueOf(Math.abs(RAND.nextLong()))).toString();
        String s6 = String.valueOf(l / 1000L);
        return makeAuthorizationHeaderValue(sign(makeSignatureBase(uri, s, s1, s5, s6, s3, httpentity), s4, s2), s3, s5, s6, s1);
    }

    public static String makeSignatureBase(URI uri, String s, String s1, String s2, String s3, String s4, HttpEntity httpentity)
    {
        String s5 = uri.getRawQuery();
        StringBuilder stringbuilder = new StringBuilder();
        if (s5 != null)
        {
            stringbuilder.append(s5);
        }
        if (httpentity != null)
        {
            Header header = httpentity.getContentType();
            int i;
            int j;
            int k;
            if (header != null && "application/x-www-form-urlencoded".equals(header.getValue()))
            {
                try
                {
                    httpentity = EntityUtils.toString(httpentity);
                    if (!TextUtils.isEmpty(stringbuilder))
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append(httpentity);
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity) { }
            }
        }
        httpentity = parseForm(stringbuilder.toString(), true);
        httpentity.put("oauth_consumer_key", s4);
        httpentity.put("oauth_nonce", s2);
        httpentity.put("oauth_signature_method", "HMAC-SHA1");
        httpentity.put("oauth_timestamp", s3);
        httpentity.put("oauth_version", "1.0");
        if (s1 != null)
        {
            httpentity.put("oauth_token", s1);
        }
        s = new StringBuilder(s);
        uri = urlFromRequest(uri);
        s.append("&").append(encode(uri)).append("&");
        k = httpentity.size();
        i = 0;
        uri = httpentity.entrySet().iterator();
        do
        {
            if (!uri.hasNext())
            {
                break;
            }
            s1 = (java.util.Map.Entry)uri.next();
            s.append(encode(encode((String)s1.getKey()))).append("%3D").append(encode(encode((String)s1.getValue())));
            j = i + 1;
            i = j;
            if (j < k)
            {
                s.append("%26");
                i = j;
            }
        } while (true);
        return s.toString();
    }

    public static TreeMap parseForm(String s, boolean flag)
    {
        TreeMap treemap = new TreeMap();
        if (s != null)
        {
            s = s.split("&");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                String as[] = s[i].split("=");
                if (as.length == 2)
                {
                    if (flag)
                    {
                        treemap.put(urldecode(as[0], "UTF8"), urldecode(as[1], "UTF8"));
                    } else
                    {
                        treemap.put(as[0], as[1]);
                    }
                } else
                if (!TextUtils.isEmpty(as[0]))
                {
                    if (flag)
                    {
                        treemap.put(urldecode(as[0], "UTF8"), "");
                    } else
                    {
                        treemap.put(as[0], "");
                    }
                }
                i++;
            }
        }
        return treemap;
    }

    public static String sign(String s, String s1, String s2)
    {
        String s3 = s2;
        if (s2 == null)
        {
            s3 = "";
        }
        try
        {
            s1 = new SecretKeySpec((new StringBuilder()).append(urlencode(s1, "UTF8")).append('&').append(urlencode(s3, "UTF8")).toString().getBytes("UTF8"), "HmacSHA1");
            s2 = Mac.getInstance("HmacSHA1");
            s2.init(s1);
            s = urlencode(new String(Base64.encode(s2.doFinal(s.getBytes("UTF8")), 0), "UTF8"), "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public static String urlFromRequest(URI uri)
    {
        return (new StringBuilder()).append(uri.getScheme()).append("://").append(uri.getHost()).append(uri.getPath()).toString();
    }

    public static String urldecode(String s, String s1)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            s = URLDecoder.decode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage(), s);
        }
        return s;
    }

    public static String urlencode(String s, String s1)
    {
        if (s == null)
        {
            return "";
        }
        try
        {
            s = URLEncoder.encode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s.getMessage(), s);
        }
        return s;
    }

}
