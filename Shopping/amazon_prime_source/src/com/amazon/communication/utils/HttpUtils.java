// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.utils;

import java.net.URI;

public class HttpUtils
{

    public HttpUtils()
    {
    }

    public static String getRawFullUri(URI uri)
    {
        Object obj;
        if (uri.getQuery() != null)
        {
            uri = (new StringBuilder()).append(uri.getRawPath()).append("?").append(uri.getRawQuery()).toString();
        } else
        {
            uri = uri.getRawPath();
        }
        obj = uri;
        if (uri.length() == 0)
        {
            obj = "/";
        }
        return ((String) (obj));
    }
}
