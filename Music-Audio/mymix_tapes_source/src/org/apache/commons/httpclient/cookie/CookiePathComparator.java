// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.cookie;

import java.util.Comparator;
import org.apache.commons.httpclient.Cookie;

public class CookiePathComparator
    implements Comparator
{

    public CookiePathComparator()
    {
    }

    private String normalizePath(Cookie cookie)
    {
        Object obj = cookie.getPath();
        cookie = ((Cookie) (obj));
        if (obj == null)
        {
            cookie = "/";
        }
        obj = cookie;
        if (!cookie.endsWith("/"))
        {
            obj = cookie + "/";
        }
        return ((String) (obj));
    }

    public int compare(Object obj, Object obj1)
    {
        obj = (Cookie)obj;
        obj1 = (Cookie)obj1;
        obj = normalizePath(((Cookie) (obj)));
        obj1 = normalizePath(((Cookie) (obj1)));
        if (!((String) (obj)).equals(obj1))
        {
            if (((String) (obj)).startsWith(((String) (obj1))))
            {
                return -1;
            }
            if (((String) (obj1)).startsWith(((String) (obj))))
            {
                return 1;
            }
        }
        return 0;
    }
}
