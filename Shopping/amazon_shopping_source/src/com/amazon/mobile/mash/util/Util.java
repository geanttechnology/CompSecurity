// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.util;

import android.net.Uri;
import android.util.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.util:
//            MASHDebug

public final class Util
{

    private Util()
    {
    }

    public static byte[] getPostDataAsByteArray(JSONObject jsonobject)
        throws JSONException
    {
        Object obj = null;
        if (jsonobject != null)
        {
            obj = new android.net.Uri.Builder();
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); ((android.net.Uri.Builder) (obj)).appendQueryParameter(s, jsonobject.getString(s)))
            {
                s = (String)iterator.next();
            }

            jsonobject = ((android.net.Uri.Builder) (obj)).toString();
            obj = jsonobject;
            if (jsonobject.startsWith("?"))
            {
                obj = jsonobject.substring(1);
            }
        }
        if (MASHDebug.isEnabled())
        {
            Log.i("Amazon", (new StringBuilder()).append("postDataString is: ").append(((String) (obj))).toString());
        }
        if (!isEmpty(((String) (obj))))
        {
            return EncodingUtils.getBytes(((String) (obj)), "UTF-8");
        } else
        {
            return null;
        }
    }

    public static boolean isDefined(String s)
    {
        return s != null && s.length() != 0 && !"null".equalsIgnoreCase(s) && !"undefined".equalsIgnoreCase(s);
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.length() == 0;
    }

    public static boolean isHttpsAmazonUrl(String s)
    {
        s = Uri.parse(s);
        if ("https".equalsIgnoreCase(s.getScheme()))
        {
            s = s.getHost();
            return Pattern.compile("\\.amazon\\.(com|cn|co\\.uk|co\\.jp|de|fr|ca|it|es|in)$").matcher(s).find();
        } else
        {
            return false;
        }
    }

    public static boolean isUrlMalformed(String s)
    {
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return true;
        }
        return false;
    }

    public static boolean isUrlWhitelisted(String s)
    {
        return s.startsWith("file:///") || s.startsWith("javascript:") || isHttpsAmazonUrl(s);
    }
}
