// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.server;

import android.util.Pair;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Vector;

// Referenced classes of package com.supersonic.mediationsdk.server:
//            Server

public class ServerURL
{

    public static final String AMPERSAND = "&";
    public static final String APPLICATION_KEY = "applicationKey";
    public static final String APPLICATION_USER_ID = "applicationUserId";
    private static String BASE_URL_PREFIX = "http://www.ultraadserver.com/api/rest/v";
    private static String BASE_URL_SUFFIX = "/ultra/cpv?platform=android&";
    public static final String EQUAL = "=";
    public static final String IMPRESSION = "impression";

    public ServerURL()
    {
    }

    public static String createURLParams(Vector vector)
        throws UnsupportedEncodingException
    {
        Object obj = "";
        Iterator iterator = vector.iterator();
        Pair pair;
        for (vector = ((Vector) (obj)); iterator.hasNext(); vector = (new StringBuilder()).append(((String) (obj))).append((String)pair.first).append("=").append(URLEncoder.encode((String)pair.second, "UTF-8")).toString())
        {
            pair = (Pair)iterator.next();
            obj = vector;
            if (vector.length() > 0)
            {
                obj = (new StringBuilder()).append(vector).append("&").toString();
            }
        }

        return vector;
    }

    private static String getBaseUrl(String s)
    {
        return (new StringBuilder()).append(BASE_URL_PREFIX).append(s).append(BASE_URL_SUFFIX).toString();
    }

    public static String getCPVProvidersURL(String s, String s1)
        throws UnsupportedEncodingException
    {
        Vector vector = new Vector();
        vector.add(new Pair("applicationKey", s));
        vector.add(new Pair("applicationUserId", s1));
        s = createURLParams(vector);
        return (new StringBuilder()).append(getBaseUrl(SupersonicUtils.getSDKVersion())).append(s).toString();
    }

    public static String getRequestURL(String s, boolean flag)
        throws UnsupportedEncodingException
    {
        Object obj = new Vector();
        ((Vector) (obj)).add(new Pair("impression", Boolean.toString(flag)));
        obj = createURLParams(((Vector) (obj)));
        return (new StringBuilder()).append(s).append("&").append(((String) (obj))).toString();
    }

    public static String getUniqueUsersURL(String s, String s1)
        throws UnsupportedEncodingException
    {
        Vector vector = new Vector();
        vector.add(new Pair("applicationKey", s));
        vector.add(new Pair("applicationUserId", s1));
        s = createURLParams(vector);
        return (new StringBuilder()).append(Server.getUniqueUsersBaseURL()).append(s).toString();
    }

}
