// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.security.KeyStore;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.flurry.android:
//            gs

final class ch
{

    private ch()
    {
    }

    static HttpClient a(HttpParams httpparams)
    {
        com/flurry/android/ch;
        JVM INSTR monitorenter ;
        Object obj;
        obj = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore) (obj)).load(null, null);
        obj = new gs(((KeyStore) (obj)));
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(httpparams, schemeregistry), httpparams);
        httpparams = ((HttpParams) (obj));
_L2:
        com/flurry/android/ch;
        JVM INSTR monitorexit ;
        return httpparams;
        Exception exception;
        exception;
        httpparams = new DefaultHttpClient(httpparams);
        if (true) goto _L2; else goto _L1
_L1:
        httpparams;
        throw httpparams;
    }
}
