// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import com.groupon.http.NameValuePair;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import okio.Buffer;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class HttpUtil
{
    public static class ExcludeParamFilter
        implements ParamFilter
    {

        private Set excludeSet;

        public boolean match(String s)
        {
            return excludeSet.contains(s);
        }

        public ExcludeParamFilter(Set set)
        {
            excludeSet = set;
        }
    }

    public static interface ParamFilter
    {

        public abstract boolean match(String s);
    }

    public static class PrefixParamFilter
        implements ParamFilter
    {

        private String prefix;

        public boolean match(String s)
        {
            return s.startsWith(prefix);
        }

        public PrefixParamFilter(String s)
        {
            prefix = s;
        }
    }


    public static final String BASE_64_CHARSET = "base64";
    public static final int HTTP_404 = 404;
    public static final String NAME_VALUE_SEPARATOR = "=";
    public static final String PARAMETER_SEPARATOR = "&";
    public static final String URL_CHAR_ENCODING = "utf-8";

    private HttpUtil()
    {
    }

    public static HashMap arrayToHash(List list)
    {
        if (list.size() % 2 != 0)
        {
            throw new RuntimeException((new StringBuilder()).append("Invalid URL name/value pairs: ").append(Strings.toString(list)).toString());
        }
        HashMap hashmap = new HashMap();
        for (list = list.iterator(); list.hasNext(); hashmap.put(Strings.toString(list.next()), Strings.toString(list.next()))) { }
        return hashmap;
    }

    public static boolean canParseJsonErrorMessage(int i)
    {
        return i == 400 || i == 409;
    }

    public static byte[] convertToBytes(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("data may not be null");
        }
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("base64");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return s.getBytes(Charset.defaultCharset());
        }
        return abyte0;
    }

    public static List extractNameValuePairs(URI uri)
    {
        Object obj;
        List list = Collections.emptyList();
        obj = uri.getRawQuery();
        uri = list;
        if (!Strings.notEmpty(obj)) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = new Scanner(((String) (obj)));
        ((Scanner) (obj)).useDelimiter("&");
_L3:
        String as[];
        uri = arraylist;
        if (!((Scanner) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        as = ((Scanner) (obj)).next().split("=");
        if (as.length == 0 || as.length > 2)
        {
            throw new IllegalArgumentException("bad parameter");
        }
        String s = URLDecoder.decode(as[0], "utf-8");
        uri = "";
        try
        {
            if (as.length == 2)
            {
                uri = URLDecoder.decode(as[1], "utf-8");
            }
            arraylist.add(new NameValuePair(s, uri));
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            Ln.e(uri);
        }
        if (true) goto _L3; else goto _L2
_L2:
        return uri;
    }

    public static HashMap extractParams(String s)
    {
        Object obj;
        try
        {
            obj = extractNameValuePairs(new URI(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        s = new HashMap();
        NameValuePair namevaluepair;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); s.put(namevaluepair.name, namevaluepair.value))
        {
            namevaluepair = (NameValuePair)((Iterator) (obj)).next();
        }

        return s;
    }

    public static transient void filter(HashMap hashmap, ParamFilter aparamfilter[])
    {
        for (hashmap = hashmap.keySet().iterator(); hashmap.hasNext();)
        {
            String s = (String)hashmap.next();
            int j = aparamfilter.length;
            int i = 0;
            while (i < j) 
            {
                if (aparamfilter[i].match(s))
                {
                    hashmap.remove();
                }
                i++;
            }
        }

    }

    public static String getRequestBodyString(RequestBody requestbody, int i)
    {
        if (requestbody != null && !isContentTypeBinary(requestbody.contentType()))
        {
            Buffer buffer = new Buffer();
            try
            {
                requestbody.writeTo(buffer);
                if (buffer.size() <= (long)i)
                {
                    return buffer.readUtf8();
                }
                requestbody = buffer.readUtf8(i);
            }
            // Misplaced declaration of an exception variable
            catch (RequestBody requestbody)
            {
                return "";
            }
            return requestbody;
        } else
        {
            return "";
        }
    }

    public static List hashToArray(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        java.util.Map.Entry entry;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); arraylist.add(entry.getValue()))
        {
            entry = (java.util.Map.Entry)hashmap.next();
            arraylist.add(entry.getKey());
        }

        return arraylist;
    }

    public static boolean isContentTypeBinary(MediaType mediatype)
    {
        mediatype = Strings.toString(mediatype).toLowerCase();
        return mediatype.contains("binary") || mediatype.contains("multipart/form-data");
    }

    public static boolean isExceptionResponseCode(int i)
    {
        return i < 200 || i >= 400;
    }

    public static boolean isUrlTrackerImage(String s)
    {
        return s.contains("logs/analytic/event.gif") || s.contains("logs/analytic/view.gif");
    }

    public static String nvpsToQueryString(Object aobj[])
    {
        if (aobj == null || aobj.length == 0)
        {
            return "";
        }
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < aobj.length; i += 2)
        {
            arraylist.add((new StringBuilder()).append(aobj[i]).append("=").append(aobj[i + 1]).toString());
        }

        return Strings.join("&", arraylist);
    }

    public static String urlEncode(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        list = (NameValuePair)iterator.next();
        s = URLEncoder.encode(((NameValuePair) (list)).name, "utf-8");
        if (((NameValuePair) (list)).value == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        list = URLEncoder.encode(((NameValuePair) (list)).value, "utf-8");
_L3:
        if (stringbuilder.length() > 0)
        {
            stringbuilder.append("&");
        }
        stringbuilder.append(s);
        stringbuilder.append("=");
        stringbuilder.append(list);
        if (true) goto _L2; else goto _L1
        list;
        Ln.e(list);
_L1:
        return stringbuilder.toString();
        list = "";
          goto _L3
    }
}
