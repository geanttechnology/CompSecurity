// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.conn.scheme.PlainSocketFactory;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.Scheme;
import com.comcast.cim.httpcomponentsandroid.conn.scheme.SchemeRegistry;
import com.comcast.cim.httpcomponentsandroid.conn.ssl.SSLSocketFactory;

public final class SchemeRegistryFactory
{

    public SchemeRegistryFactory()
    {
    }

    public static SchemeRegistry createDefault()
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeregistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        return schemeregistry;
    }
}
