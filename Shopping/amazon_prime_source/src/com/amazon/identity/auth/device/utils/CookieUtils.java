// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.amazon.identity.auth.device.token.MAPCookie;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.apache.http.cookie.Cookie;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, ParcelUtils

public final class CookieUtils
{

    private static final String TAG = com/amazon/identity/auth/device/utils/CookieUtils.getName();

    private CookieUtils()
    {
    }

    public static String[] extractCookieStringArray(List list)
    {
        if (list != null)
        {
            ArrayList arraylist = new ArrayList();
            for (list = list.iterator(); list.hasNext(); arraylist.add(((MAPCookie)(Cookie)list.next()).getSetCookieHeader())) { }
            return (String[])arraylist.toArray(new String[arraylist.size()]);
        } else
        {
            return new String[0];
        }
    }

    public static List fromJson(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        int i;
        try
        {
            s = new JSONArray(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "Failed to parse cookies", s);
            return arraylist;
        }
        i = 0;
        if (i >= s.length())
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist.add(parseMapCookieFromSetCookieString(s.getString(i), s1));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break MISSING_BLOCK_LABEL_55;
_L4:
        break MISSING_BLOCK_LABEL_28;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static List fromJsonOrSerializedBundle(String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            return new ArrayList();
        }
        if (s.startsWith("["))
        {
            return fromJson(s, s1);
        } else
        {
            return fromSerializedBundle(s, s1);
        }
    }

    public static List fromSerializedBundle(String s, String s1)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        s = ParcelUtils.stringToBundle(s);
        if (s != null) goto _L2; else goto _L1
_L1:
        return arraylist;
_L2:
        try
        {
            s = s.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.w(TAG, "Failed to deserialize parcel", s);
            s = null;
        }
        if (s != null)
        {
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                arraylist.add(parseMapCookieFromSetCookieString(s[i], s1));
                i++;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static Bundle getBundleForCookieList(List list)
    {
        Bundle bundle = new Bundle();
        bundle.putStringArray("com.amazon.identity.auth.device.api.cookiekeys.all", extractCookieStringArray(list));
        return bundle;
    }

    public static SimpleDateFormat getCookieExpireDateFormatter()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd MMM yyyy kk:mm:ss 'GMT'", Locale.US);
        simpledateformat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpledateformat;
    }

    public static List getCookieNamesFromCookies(String as[])
    {
        ArrayList arraylist = new ArrayList();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            MAPCookie mapcookie = parseMapCookieFromSetCookieString(as[i], null);
            if (!TextUtils.isEmpty(mapcookie.getName()))
            {
                arraylist.add(mapcookie.getName());
            }
        }

        return arraylist;
    }

    public static String getFullCookieDomainFromUrl(String s)
        throws MalformedURLException
    {
        s = (new URL(s)).getHost();
        if (!TextUtils.isEmpty(s))
        {
            return (new StringBuilder(".")).append(s.trim()).toString();
        } else
        {
            throw new MalformedURLException("Host of the url is null");
        }
    }

    public static String getNonExpiringCookieExpiresString()
    {
        Object obj = Calendar.getInstance();
        Calendar.getInstance();
        ((Calendar) (obj)).setTime(new Date());
        ((Calendar) (obj)).add(1, 30);
        obj = ((Calendar) (obj)).getTime();
        return getCookieExpireDateFormatter().format(((Date) (obj)));
    }

    public static MAPCookie parseMapCookieFromSetCookieString(String s, String s1)
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s.trim(), ";");
        String s6 = null;
        String s7 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        boolean flag1 = false;
        boolean flag = false;
        while (stringtokenizer.hasMoreTokens()) 
        {
            String s2 = stringtokenizer.nextToken().trim();
            int i = s2.indexOf("=");
            s = null;
            if (i != -1)
            {
                s = s2.substring(0, i);
                String s8 = s2.substring(i + 1);
                s2 = s;
                s = s8;
            }
            if (s2.equalsIgnoreCase("domain"))
            {
                s5 = s;
            } else
            if (s2.equalsIgnoreCase("Expires"))
            {
                s4 = s;
            } else
            if (s2.equalsIgnoreCase("Path"))
            {
                s3 = s;
            } else
            if (s2.equalsIgnoreCase("Secure"))
            {
                flag1 = true;
            } else
            if (s2.equalsIgnoreCase("HttpOnly"))
            {
                flag = true;
            } else
            {
                s6 = s2;
                s7 = s;
            }
        }
        return new MAPCookie(s6, s7, s5, s4, s3, s1, flag1, flag);
    }

    public static String toJson(List list)
    {
        JSONArray jsonarray = new JSONArray();
        list = extractCookieStringArray(list);
        if (list != null)
        {
            int j = list.length;
            for (int i = 0; i < j; i++)
            {
                jsonarray.put(list[i]);
            }

        }
        return jsonarray.toString();
    }

    public static String toSerializedBundleString(List list)
    {
        return ParcelUtils.bundleToString(getBundleForCookieList(list));
    }

}
