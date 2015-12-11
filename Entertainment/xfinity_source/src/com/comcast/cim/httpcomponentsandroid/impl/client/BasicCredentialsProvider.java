// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.auth.AuthScope;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;
import com.comcast.cim.httpcomponentsandroid.client.CredentialsProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BasicCredentialsProvider
    implements CredentialsProvider
{

    private final ConcurrentHashMap credMap = new ConcurrentHashMap();

    public BasicCredentialsProvider()
    {
    }

    private static Credentials matchCredentials(Map map, AuthScope authscope)
    {
        Credentials credentials = (Credentials)map.get(authscope);
        Object obj1 = credentials;
        if (credentials == null)
        {
            int i = -1;
            Object obj = null;
            Iterator iterator = map.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj1 = (AuthScope)iterator.next();
                int j = authscope.match(((AuthScope) (obj1)));
                if (j > i)
                {
                    i = j;
                    obj = obj1;
                }
            } while (true);
            obj1 = credentials;
            if (obj != null)
            {
                obj1 = (Credentials)map.get(obj);
            }
        }
        return ((Credentials) (obj1));
    }

    public Credentials getCredentials(AuthScope authscope)
    {
        if (authscope == null)
        {
            throw new IllegalArgumentException("Authentication scope may not be null");
        } else
        {
            return matchCredentials(credMap, authscope);
        }
    }

    public String toString()
    {
        return credMap.toString();
    }
}
