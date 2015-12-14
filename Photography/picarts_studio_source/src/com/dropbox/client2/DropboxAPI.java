// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dropbox.client2;

import com.dropbox.client2.session.Session;
import java.util.Map;

public final class DropboxAPI
{

    public Session a;

    public DropboxAPI(Session session)
    {
        if (session == null)
        {
            throw new IllegalArgumentException("Session must not be null.");
        } else
        {
            a = session;
            return;
        }
    }

    protected static boolean a(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map != null && (map instanceof Boolean))
        {
            return ((Boolean)map).booleanValue();
        } else
        {
            return false;
        }
    }

    protected static long b(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map != null)
        {
            if (map instanceof Number)
            {
                return ((Number)map).longValue();
            }
            if (map instanceof String)
            {
                return Long.parseLong((String)map, 16);
            }
        }
        return 0L;
    }
}
