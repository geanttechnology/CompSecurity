// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.flurry.android:
//            cy, ch

final class fl
{

    fl()
    {
    }

    static String D(String s1)
    {
        String s2;
        try
        {
            s2 = URLEncoder.encode(s1, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            cy.g("FlurryAgent", (new StringBuilder()).append("Cannot encode '").append(s1).append("'").toString());
            return "";
        }
        return s2;
    }

    private static String E(String s1)
    {
        String s2;
        try
        {
            s2 = URLDecoder.decode(s1, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            cy.g("FlurryAgent", (new StringBuilder()).append("Cannot decode '").append(s1).append("'").toString());
            return "";
        }
        return s2;
    }

    static byte[] F(String s1)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-1");
            messagedigest.update(s1.getBytes(), 0, s1.length());
            s1 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.d("FlurryAgent", (new StringBuilder()).append("Unsupported SHA1: ").append(s1.getMessage()).toString());
            return null;
        }
        return s1;
    }

    static String G(String s1)
    {
        return s1.replace("'", "\\'").replace("\\n", "").replace("\\r", "").replace("\\t", "");
    }

    static Map H(String s1)
    {
        HashMap hashmap = new HashMap();
        if (!TextUtils.isEmpty(s1))
        {
            s1 = s1.split("&");
            int j = s1.length;
            for (int i = 0; i < j; i++)
            {
                String as[] = s1[i].split("=");
                if (!as[0].equals("event"))
                {
                    hashmap.put(E(as[0]), E(as[1]));
                }
            }

        }
        return hashmap;
    }

    static int a(Context context, int i)
    {
        context = context.getResources().getDisplayMetrics();
        return Math.round((float)i / ((DisplayMetrics) (context)).density);
    }

    static HttpResponse a(String s1, int i, int j, boolean flag)
    {
        Object obj;
        try
        {
            obj = new HttpGet(s1);
            Object obj1 = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj1)), 10000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj1)), 15000);
            ((HttpParams) (obj1)).setParameter("http.protocol.handle-redirects", Boolean.valueOf(flag));
            obj1 = ch.a(((HttpParams) (obj1)));
            if (!(obj1 instanceof HttpClient))
            {
                return ((HttpClient) (obj1)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
            }
            obj = Instrumentation.execute(((HttpClient) (obj1)), ((org.apache.http.client.methods.HttpUriRequest) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            cy.c("FlurryAgent", (new StringBuilder()).append("Unknown host: ").append(s1.getMessage()).toString());
            return null;
        }
        catch (Exception exception)
        {
            cy.a("FlurryAgent", (new StringBuilder()).append("Failed to hit URL: ").append(s1).toString(), exception);
            return null;
        }
        return ((HttpResponse) (obj));
    }

    static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    static boolean a(Context context, Intent intent)
    {
        return context.getPackageManager().queryIntentActivities(intent, 0x10000).size() > 0;
    }

    static int b(Context context, int i)
    {
        context = context.getResources().getDisplayMetrics();
        float f = i;
        return Math.round(((DisplayMetrics) (context)).density * f);
    }

    static String d(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length << 1);
        char ac[] = new char[16];
        char[] _tmp = ac;
        ac[0] = '0';
        ac[1] = '1';
        ac[2] = '2';
        ac[3] = '3';
        ac[4] = '4';
        ac[5] = '5';
        ac[6] = '6';
        ac[7] = '7';
        ac[8] = '8';
        ac[9] = '9';
        ac[10] = 'a';
        ac[11] = 'b';
        ac[12] = 'c';
        ac[13] = 'd';
        ac[14] = 'e';
        ac[15] = 'f';
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            byte byte1 = (byte)(byte0 & 0xf);
            stringbuilder.append(ac[(byte)((byte0 & 0xf0) >> 4)]);
            stringbuilder.append(ac[byte1]);
        }

        return stringbuilder.toString();
    }

    static boolean g(long l)
    {
        boolean flag = false;
        if (System.currentTimeMillis() <= l)
        {
            flag = true;
        }
        return flag;
    }

    static int q(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    static int r(Context context)
    {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    static int s(Context context)
    {
        return a(context, q(context));
    }

    static String sanitize(String s1)
    {
        String s2;
        if (s1 == null)
        {
            s2 = "";
        } else
        {
            s2 = s1;
            if (s1.length() > 255)
            {
                return s1.substring(0, 255);
            }
        }
        return s2;
    }

    static int t(Context context)
    {
        return a(context, r(context));
    }

    static int u(Context context)
    {
        return context.getResources().getConfiguration().orientation;
    }
}
