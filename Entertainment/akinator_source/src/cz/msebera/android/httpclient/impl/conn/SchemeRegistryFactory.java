// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;

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

    public static SchemeRegistry createSystemDefault()
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeregistry.register(new Scheme("https", 443, SSLSocketFactory.getSystemSocketFactory()));
        return schemeregistry;
    }
}
