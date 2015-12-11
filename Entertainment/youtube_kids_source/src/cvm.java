// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;
import org.apache.http.protocol.ResponseConnControl;
import org.apache.http.protocol.ResponseContent;

public final class cvm
    implements bn
{

    final HttpParams a = (new BasicHttpParams()).setBooleanParameter("http.connection.stalecheck", false).setBooleanParameter("http.tcp.nodelay", true).setIntParameter("http.socket.buffer-size", 8192);
    final HttpService b;
    ServerSocket c;
    private final cwa d = new cwa();
    private ExecutorService e;
    private cvr f;
    private cvw g;

    private cvm(bjp bjp, boolean flag, Key key, bjp bjp1, cvl cvl, bmi bmi, cvk cvk)
    {
        BasicHttpProcessor basichttpprocessor = new BasicHttpProcessor();
        basichttpprocessor.addInterceptor(d);
        basichttpprocessor.addInterceptor(new ResponseContent());
        basichttpprocessor.addInterceptor(new ResponseConnControl());
        HttpRequestHandlerRegistry httprequesthandlerregistry = new HttpRequestHandlerRegistry();
        httprequesthandlerregistry.register("/local", new cvu(key));
        f = new cvr(bjp1, cvl, cvk);
        httprequesthandlerregistry.register("/exocache", f);
        if (flag)
        {
            g = new cvw(key, bmi, bjp, cvk);
            httprequesthandlerregistry.register("/pudl", g);
        }
        b = new HttpService(basichttpprocessor, new DefaultConnectionReuseStrategy(), new DefaultHttpResponseFactory());
        b.setHandlerResolver(httprequesthandlerregistry);
        b.setParams(a);
    }

    public static cvm a(bjp bjp, boolean flag, Key key, bjp bjp1, cvl cvl, bmi bmi, cvk cvk)
    {
        bjp = new cvm(bjp, flag, key, bjp1, cvl, bmi, cvk);
        bjp.c = new ServerSocket();
        key = InetAddress.getByAddress("localhost", new byte[] {
            127, 0, 0, 1
        });
        ((cvm) (bjp)).c.bind(new InetSocketAddress(key, 0));
        bjp.e = Executors.newSingleThreadExecutor();
        ((cvm) (bjp)).e.execute(new cvn(bjp));
        return bjp;
        bjp;
        bmo.a("IOException when starting MediaServer", bjp);
_L2:
        return null;
        bjp;
        bmo.a("Cannot instantiate MediaServer", bjp);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
