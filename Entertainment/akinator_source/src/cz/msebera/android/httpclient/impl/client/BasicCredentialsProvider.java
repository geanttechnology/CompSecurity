// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
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

    public void clear()
    {
        credMap.clear();
    }

    public Credentials getCredentials(AuthScope authscope)
    {
        Args.notNull(authscope, "Authentication scope");
        return matchCredentials(credMap, authscope);
    }

    public void setCredentials(AuthScope authscope, Credentials credentials)
    {
        Args.notNull(authscope, "Authentication scope");
        credMap.put(authscope, credentials);
    }

    public String toString()
    {
        return credMap.toString();
    }
}
