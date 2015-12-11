// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;
import com.comcast.cim.httpcomponentsandroid.client.AuthCache;
import java.util.HashMap;

public class BasicAuthCache
    implements AuthCache
{

    private final HashMap map = new HashMap();

    public BasicAuthCache()
    {
    }

    public AuthScheme get(HttpHost httphost)
    {
        if (httphost == null)
        {
            throw new IllegalArgumentException("HTTP host may not be null");
        } else
        {
            return (AuthScheme)map.get(httphost);
        }
    }

    public void put(HttpHost httphost, AuthScheme authscheme)
    {
        if (httphost == null)
        {
            throw new IllegalArgumentException("HTTP host may not be null");
        } else
        {
            map.put(httphost, authscheme);
            return;
        }
    }

    public void remove(HttpHost httphost)
    {
        if (httphost == null)
        {
            throw new IllegalArgumentException("HTTP host may not be null");
        } else
        {
            map.remove(httphost);
            return;
        }
    }

    public String toString()
    {
        return map.toString();
    }
}
