// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.utils;

import com.comcast.cim.httpcomponentsandroid.NameValuePair;
import com.comcast.cim.httpcomponentsandroid.message.BasicNameValuePair;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class URLEncodedUtils
{

    public URLEncodedUtils()
    {
    }

    private static String decode(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = "ISO-8859-1";
        }
        try
        {
            return URLDecoder.decode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
    }

    private static String encode(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = "ISO-8859-1";
        }
        try
        {
            return URLEncoder.encode(s, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException(s);
        }
    }

    public static String format(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (NameValuePair)iterator.next();
            String s1 = encode(list.getName(), s);
            list = list.getValue();
            if (list != null)
            {
                list = encode(list, s);
            } else
            {
                list = "";
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(s1);
            stringbuilder.append("=");
            stringbuilder.append(list);
        }
        return stringbuilder.toString();
    }

    public static List parse(URI uri, String s)
    {
        List list = Collections.emptyList();
        String s1 = uri.getRawQuery();
        uri = list;
        if (s1 != null)
        {
            uri = list;
            if (s1.length() > 0)
            {
                uri = new ArrayList();
                parse(((List) (uri)), new Scanner(s1), s);
            }
        }
        return uri;
    }

    public static void parse(List list, Scanner scanner, String s)
    {
        scanner.useDelimiter("&");
        String s1;
        String s2;
        for (; scanner.hasNext(); list.add(new BasicNameValuePair(s2, s1)))
        {
            String as[] = scanner.next().split("=");
            if (as.length == 0 || as.length > 2)
            {
                throw new IllegalArgumentException("bad parameter");
            }
            s2 = decode(as[0], s);
            s1 = null;
            if (as.length == 2)
            {
                s1 = decode(as[1], s);
            }
        }

    }
}
