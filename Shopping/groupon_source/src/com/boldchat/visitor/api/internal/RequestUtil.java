// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONObject;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            Base64

public class RequestUtil
{

    private static String additionalInfo = null;
    private static SimpleDateFormat iso8601Formatter;
    private static String userAgent = null;

    public static String getAuthorizationHeader(long l, String s)
    {
        try
        {
            s = (new StringBuilder()).append("Basic ").append(Base64.encodeToString((new StringBuilder()).append(l).append(":").append(s).toString().getBytes("UTF-8"), 2)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static Date getDateFromISO8601(String s)
    {
        if (s == null || s.length() == 0)
        {
            return new Date();
        }
        String s1;
        int i;
        try
        {
            i = s.indexOf(".");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return new Date();
        }
        s1 = s;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        s1 = (new StringBuilder()).append(s.substring(0, i)).append("Z").toString();
        s = iso8601Formatter.parse(s1);
        return s;
    }

    public static String getDefaultUserAgentString()
    {
        Object obj;
        String s;
        s = userAgent;
        obj = s;
        if (s != null) goto _L2; else goto _L1
_L1:
        int i;
        StringBuilder stringbuilder = new StringBuilder("BoldChatAPI/1.0");
        stringbuilder.append(" (");
        Object obj2;
        Class class1;
        Class aclass[];
        String s1;
        int j;
        if (System.getProperty("os.name") != null)
        {
            stringbuilder.append(System.getProperty("os.name"));
            if (System.getProperty("os.arch") != null)
            {
                stringbuilder.append(" ").append(System.getProperty("os.arch"));
            }
            if (System.getProperty("os.version") != null)
            {
                stringbuilder.append("/").append(System.getProperty("os.version"));
            }
        } else
        {
            stringbuilder.append("Unknown OS");
        }
        class1 = Class.forName("android.os.Build");
        if (class1 == null) goto _L4; else goto _L3
_L3:
        obj2 = null;
        aclass = class1.getDeclaredClasses();
        j = aclass.length;
        i = 0;
_L9:
        obj = obj2;
        if (i >= j) goto _L6; else goto _L5
_L5:
        obj = aclass[i];
        s1 = ((Class) (obj)).getCanonicalName();
        if (s1 == null) goto _L8; else goto _L7
_L7:
        if (!"android.os.Build.VERSION".equals(s1.toString())) goto _L8; else goto _L6
_L6:
        stringbuilder.append("; Android");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        stringbuilder.append(' ').append(((Class) (obj)).getField("RELEASE").get(null));
        stringbuilder.append("; ");
        stringbuilder.append(class1.getField("MANUFACTURER").get(null)).append(' ');
        stringbuilder.append(class1.getField("BRAND").get(null)).append(' ');
        stringbuilder.append(class1.getField("MODEL").get(null)).append('/');
        stringbuilder.append(class1.getField("ID").get(null));
_L4:
        stringbuilder.append(")");
        if (additionalInfo != null)
        {
            stringbuilder.append(" ").append(additionalInfo);
        }
        obj = stringbuilder.toString();
        userAgent = ((String) (obj));
_L2:
        return ((String) (obj));
_L8:
        i++;
          goto _L9
        Object obj1;
        obj1;
        ((Exception) (obj1)).printStackTrace();
          goto _L4
        obj1;
          goto _L4
    }

    public static String getRequestURL(long l, String s, String s1)
    {
        String s2;
        StringBuilder stringbuilder;
        try
        {
            stringbuilder = (new StringBuilder()).append("https://livechat");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        s = stringbuilder.append(s2).append(".boldchat.com/aid/").append(l).append("/rest/json/v1/").append(URLEncoder.encode(s1, "UTF-8")).toString();
        return s;
    }

    public static Map getStringMap(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != null && jsonobject.keySet() != null)
        {
            String s;
            for (Iterator iterator = jsonobject.keySet().iterator(); iterator.hasNext(); hashmap.put(s, jsonobject.optString(s)))
            {
                s = iterator.next().toString();
            }

        }
        return hashmap;
    }

    public static void setAdditionalInfo(String s)
    {
        additionalInfo = s;
        userAgent = null;
    }

    static 
    {
        iso8601Formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        iso8601Formatter.setTimeZone(TimeZone.getTimeZone("Z"));
    }
}
