// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

// Referenced classes of package cz.msebera.android.httpclient.conn.scheme:
//            SchemeSocketFactoryAdaptor, SchemeLayeredSocketFactory, LayeredSocketFactory

class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor
    implements SchemeLayeredSocketFactory
{

    private final LayeredSocketFactory factory;

    SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredsocketfactory)
    {
        super(layeredsocketfactory);
        factory = layeredsocketfactory;
    }

    public Socket createLayeredSocket(Socket socket, String s, int i, HttpParams httpparams)
        throws IOException, UnknownHostException
    {
        return factory.createSocket(socket, s, i, true);
    }
}
