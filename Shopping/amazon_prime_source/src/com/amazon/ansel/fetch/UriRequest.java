// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.collection.CollectionMap;
import com.amazon.ansel.fetch.tools.web.HttpMethod;

public class UriRequest
{

    private final CollectionMap headers;
    private final String method;
    private final String uri;

    public UriRequest(String s)
    {
        this(HttpMethod.GET.getName(), s, null);
    }

    public UriRequest(String s, String s1, CollectionMap collectionmap)
    {
        method = s;
        uri = s1;
        headers = collectionmap;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (UriRequest)obj;
        if (headers == null)
        {
            if (((UriRequest) (obj)).headers != null)
            {
                return false;
            }
        } else
        if (!headers.equals(((UriRequest) (obj)).headers))
        {
            return false;
        }
        if (method == null)
        {
            if (((UriRequest) (obj)).method != null)
            {
                return false;
            }
        } else
        if (!method.equals(((UriRequest) (obj)).method))
        {
            return false;
        }
        if (uri != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((UriRequest) (obj)).uri == null) goto _L1; else goto _L3
_L3:
        return false;
        if (uri.equals(((UriRequest) (obj)).uri)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public CollectionMap getHeaders()
    {
        return headers;
    }

    public String getMethod()
    {
        return method;
    }

    public String getUri()
    {
        return uri;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (headers == null)
        {
            i = 0;
        } else
        {
            i = headers.hashCode();
        }
        if (method == null)
        {
            j = 0;
        } else
        {
            j = method.hashCode();
        }
        if (uri != null)
        {
            k = uri.hashCode();
        }
        return ((i + 31) * 31 + j) * 31 + k;
    }

    public String toString()
    {
        if (uri != null)
        {
            return uri;
        } else
        {
            return "";
        }
    }
}
