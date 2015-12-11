// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.content.Context;
import android.content.res.Resources;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.nielsen.app.sdk:
//            c, h, a

class AppRequestManager
{
    private class AppClient extends DefaultHttpClient
    {

        final AppRequestManager a;
        private final int b = 80;
        private final int c = 443;
        private KeyStore d;

        private SSLSocketFactory a()
            throws Exception
        {
            boolean flag;
            flag = true;
            d = KeyStore.getInstance(KeyStore.getDefaultType());
            if (d == null) goto _L2; else goto _L1
_L1:
            Object obj = AppRequestManager.a(a).getResources();
            if (obj == null) goto _L4; else goto _L3
_L3:
            int i1 = ((Resources) (obj)).getIdentifier("nielsen", "raw", AppRequestManager.a(a).getPackageName());
            if (i1 == 0) goto _L4; else goto _L5
_L5:
            obj = ((Resources) (obj)).openRawResource(i1);
            if (obj == null) goto _L7; else goto _L6
_L6:
            d.load(((InputStream) (obj)), new char[] {
                'n', '1', '3', 'l', 's', '3', 'n', '!'
            });
_L13:
            if (!flag)
            {
                d.load(null, null);
            }
            if (obj != null)
            {
                ((InputStream) (obj)).close();
            }
_L8:
            return new AppSocketFactory(this, d);
            Object obj1;
            obj1;
            obj = null;
_L11:
            com.nielsen.app.sdk.c.a(((Throwable) (obj1)), true, 9, 'E', "It failed in loadeing the keystore, it will try to handle the HTTPS calls without credentings. If the CA authorirty id well-known, then there should be no issue", new Object[0]);
            d.load(null, null);
            if (obj != null)
            {
                ((InputStream) (obj)).close();
            }
              goto _L8
            obj1;
            obj = null;
_L10:
            d.load(null, null);
            if (obj != null)
            {
                ((InputStream) (obj)).close();
            }
            throw obj1;
_L2:
            throw new Exception("Could not get the default trust store type (BKS)");
            obj1;
            continue; /* Loop/switch isn't completed */
            obj1;
            if (true) goto _L10; else goto _L9
_L9:
            obj1;
              goto _L11
_L7:
            flag = false;
            continue; /* Loop/switch isn't completed */
_L4:
            flag = false;
            obj = null;
            if (true) goto _L13; else goto _L12
_L12:
        }

        protected ClientConnectionManager createClientConnectionManager()
        {
            Object obj;
            try
            {
                obj = new SchemeRegistry();
                SSLSocketFactory sslsocketfactory = a();
                sslsocketfactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                ((SchemeRegistry) (obj)).register(new Scheme("https", sslsocketfactory, 443));
                ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                obj = new ThreadSafeClientConnManager(a.p, ((SchemeRegistry) (obj)));
            }
            catch (Exception exception)
            {
                com.nielsen.app.sdk.c.a(exception, true, 9, 'E', "Could not create the socket", new Object[0]);
                return null;
            }
            return ((ClientConnectionManager) (obj));
        }

        public AppClient(int i1, int j1, int k1)
        {
            a = AppRequestManager.this;
            super();
            d = null;
            p = getParams();
            p.setIntParameter("http.socket.timeout", j1);
            p.setIntParameter("http.connection.timeout", i1);
            p.setIntParameter("http.socket.buffer-size", k1);
            HttpProtocolParams.setContentCharset(p, "UTF-8");
            HttpProtocolParams.setVersion(p, HttpVersion.HTTP_1_1);
            setParams(p);
        }
    }

    public class AppClient.AppSocketFactory extends SSLSocketFactory
    {

        SSLContext a;
        a b;
        final AppClient c;

        public Socket createSocket()
            throws IOException
        {
            return a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String s1, int i1, boolean flag)
            throws IOException, UnknownHostException
        {
            return a.getSocketFactory().createSocket(socket, s1, i1, flag);
        }

        public AppClient.AppSocketFactory(AppClient appclient, KeyStore keystore)
            throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
        {
            c = appclient;
            super(keystore);
            a = SSLContext.getInstance("TLS");
            b = new a(this);
            appclient = b;
            keystore = a;
            SecureRandom securerandom = new SecureRandom();
            keystore.init(null, new TrustManager[] {
                appclient
            }, securerandom);
        }
    }

    private class AppClient.AppSocketFactory.a
        implements X509TrustManager
    {

        final AppClient.AppSocketFactory a;

        public void checkClientTrusted(X509Certificate ax509certificate[], String s1)
            throws CertificateException
        {
        }

        public void checkServerTrusted(X509Certificate ax509certificate[], String s1)
            throws CertificateException
        {
        }

        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }

        private AppClient.AppSocketFactory.a(AppClient.AppSocketFactory appsocketfactory)
        {
            a = appsocketfactory;
            super();
        }

    }

    private class AppEntity
        implements HttpEntity
    {

        final AppRequestManager a;
        private int b[];
        private String c[];
        private String d;
        private BlockingQueue e;
        private int f;

        static String[] a(AppEntity appentity)
        {
            return appentity.c;
        }

        static int[] b(AppEntity appentity)
        {
            return appentity.b;
        }

        static BlockingQueue c(AppEntity appentity)
        {
            return appentity.e;
        }

        static int d(AppEntity appentity)
        {
            return appentity.f;
        }

        static String e(AppEntity appentity)
        {
            return appentity.d;
        }

        public void consumeContent()
            throws IOException
        {
        }

        public InputStream getContent()
            throws IOException, IllegalStateException
        {
            return null;
        }

        public Header getContentEncoding()
        {
            return null;
        }

        public long getContentLength()
        {
            return 0L;
        }

        public Header getContentType()
        {
            return null;
        }

        public boolean isChunked()
        {
            return false;
        }

        public boolean isRepeatable()
        {
            return false;
        }

        public boolean isStreaming()
        {
            return false;
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
        }

        public AppEntity(String s1, int i1, BlockingQueue blockingqueue, List list)
            throws InterruptedException
        {
            a = AppRequestManager.this;
            super();
            b = null;
            c = null;
            d = "";
            e = null;
            f = 0;
            int j1;
            f = i1;
            d = s1;
            e = blockingqueue;
            j1 = list.size();
            b = new int[j1];
            c = new String[j1];
            i1 = 0;
_L7:
            if (i1 >= j1) goto _L2; else goto _L1
_L1:
            int k1;
            blockingqueue = (a)list.get(i1);
            k1 = blockingqueue.c();
            s1 = blockingqueue.b();
            blockingqueue = blockingqueue.a();
            k1;
            JVM INSTR tableswitch 1 2: default 276
        //                       1 228
        //                       2 228;
               goto _L3 _L4 _L4
_L3:
            if (e != null)
            {
                long l1 = com.nielsen.app.sdk.h.g();
                s1 = (new StringBuilder()).append("Ignoring part <name, value> = <").append(blockingqueue).append(", ").append(s1).append("> on a HTTP POST multipart request").toString();
                s1 = new b(3, f, d, l1, 0L, 0L, s1, null);
                e.put(s1);
            }
              goto _L5
_L4:
            s1 = new File(s1);
            b[i1] = (int)s1.length();
            c[i1] = s1.getName();
              goto _L5
            apprequestmanager;
            com.nielsen.app.sdk.c.a(AppRequestManager.this, true, 'E', "Failed to instantiate the App SDK entity object", new Object[0]);
_L2:
            return;
_L5:
            i1++;
            if (true) goto _L7; else goto _L6
_L6:
        }
    }

    public class AppEntity.FeedbackOutputStream extends FilterOutputStream
    {

        final AppEntity a;
        private int b;
        private String c;
        private int d;
        private int e;
        private int f;

        public void write(int i1)
            throws IOException
        {
            out.write(i1);
            b = b + 4;
            int j1 = b - d;
            i1 = j1;
            if (j1 > e)
            {
                f = f + 1;
                d = d + e;
                if (AppEntity.a(a) != null && f < AppEntity.a(a).length)
                {
                    c = AppEntity.a(a)[f];
                }
                if (AppEntity.b(a) != null && f < AppEntity.b(a).length)
                {
                    e = AppEntity.b(a)[f];
                }
                i1 = b - d;
            }
            if (AppEntity.c(a) == null)
            {
                break MISSING_BLOCK_LABEL_225;
            }
            long l1 = com.nielsen.app.sdk.h.g();
            b b1 = a.a. new b(3, AppEntity.d(a), AppEntity.e(a), l1, i1, e, c, null);
            AppEntity.c(a).put(b1);
            return;
            InterruptedException interruptedexception;
            interruptedexception;
            com.nielsen.app.sdk.c.a(interruptedexception, true, 9, 'E', (new StringBuilder()).append("Request ").append(AppEntity.e(a)).append(" was interrupted while waiting to add data to the messaging queue. VERY unliquely event").toString(), new Object[0]);
            return;
        }

        public void write(byte abyte0[], int i1, int j1)
            throws IOException
        {
            out.write(abyte0, i1, j1);
            b = b + j1;
            j1 = b - d;
            i1 = j1;
            if (j1 > e)
            {
                f = f + 1;
                d = d + e;
                if (AppEntity.a(a) != null && f < AppEntity.a(a).length)
                {
                    c = AppEntity.a(a)[f];
                }
                if (AppEntity.b(a) != null && f < AppEntity.b(a).length)
                {
                    e = AppEntity.b(a)[f];
                }
                i1 = b - d;
            }
            if (AppEntity.c(a) == null)
            {
                break MISSING_BLOCK_LABEL_227;
            }
            long l1 = com.nielsen.app.sdk.h.g();
            abyte0 = a.a. new b(3, AppEntity.d(a), AppEntity.e(a), l1, i1, e, c, null);
            AppEntity.c(a).put(abyte0);
            return;
            abyte0;
            com.nielsen.app.sdk.c.a(abyte0, true, 9, 'E', (new StringBuilder()).append("Request ").append(AppEntity.e(a)).append(" was interrupted while waiting to add data to the messaging queue. VERY unliquely event").toString(), new Object[0]);
            return;
        }

        public AppEntity.FeedbackOutputStream(AppEntity appentity, OutputStream outputstream)
        {
            a = appentity;
            super(outputstream);
            c = "";
            d = 0;
            e = 0;
            f = 0;
            b = 0;
            d = 0;
            if (AppEntity.a(appentity) != null && AppEntity.a(appentity).length < 0 && f >= 0)
            {
                c = AppEntity.a(appentity)[f];
                e = AppEntity.b(appentity)[f];
            }
        }
    }

    public class AppRequest
        implements Runnable
    {

        long a;
        long b;
        h c;
        final AppRequestManager d;
        private BlockingQueue e;
        private HttpClient f;
        private int g;
        private int h;
        private int i;
        private List j;
        private String k;
        private String l;
        private String m;
        private int n;

        private void a(String s1)
            throws Exception
        {
            if (e != null)
            {
                long l1 = com.nielsen.app.sdk.h.g();
                b b1 = d. new b(1, n, l, l1, 0L, 0L, null, null);
                e.put(b1);
            }
            f = d. new AppClient(g, h, i);
            n;
            JVM INSTR tableswitch 1 4: default 108
        //                       1 118
        //                       2 259
        //                       3 165
        //                       4 353;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new Exception("Invalid HTTP request type received");
_L2:
            HttpGet httpget = new HttpGet(m);
            if (s1 != null && !s1.isEmpty())
            {
                httpget.setHeader("User-Agent", s1);
            }
            s1 = f.execute(httpget);
_L7:
            a(((HttpResponse) (s1)));
            return;
_L4:
            HttpPost httppost = new HttpPost(m);
            if (s1 != null && !s1.isEmpty())
            {
                httppost.setHeader("User-Agent", s1);
            }
            if (j != null && j.size() > 0)
            {
                httppost.setEntity(d. new AppEntity(l, n, e, j));
            }
            s1 = f.execute(httppost);
            continue; /* Loop/switch isn't completed */
_L3:
            HttpPut httpput = new HttpPut(m);
            if (s1 != null && !s1.isEmpty())
            {
                httpput.setHeader("User-Agent", s1);
            }
            if (j != null && j.size() > 0)
            {
                httpput.setEntity(d. new AppEntity(l, n, e, j));
            }
            s1 = f.execute(httpput);
            continue; /* Loop/switch isn't completed */
_L5:
            HttpDelete httpdelete = new HttpDelete(m);
            if (s1 != null && !s1.isEmpty())
            {
                httpdelete.setHeader("User-Agent", s1);
            }
            s1 = f.execute(httpdelete);
            if (true) goto _L7; else goto _L6
_L6:
        }

        private void a(String s1, int i1, String s2, List list)
            throws InterruptedException
        {
            m = s2;
            j = list;
            n = i1;
            k = s1;
            if (e != null)
            {
                long l1 = com.nielsen.app.sdk.h.g();
                s1 = d. new b(0, i1, l, l1, 0L, 0L, "", null);
                e.put(s1);
            }
            AppRequestManager.a().a(this);
        }

        private void a(HttpResponse httpresponse)
            throws Exception
        {
            if (httpresponse == null)
            {
                throw new Exception("There was no response oject on the Nielsen server response");
            }
            Object obj = httpresponse.getStatusLine();
            Object obj1 = ((StatusLine) (obj)).getProtocolVersion();
            String s1 = ((ProtocolVersion) (obj1)).getProtocol();
            int i1 = ((ProtocolVersion) (obj1)).getMajor();
            int j1 = ((ProtocolVersion) (obj1)).getMinor();
            obj1 = ((StatusLine) (obj)).getReasonPhrase();
            int k1 = ((StatusLine) (obj)).getStatusCode();
            if (k1 != 200 && k1 != 201)
            {
                throw new Exception((new StringBuilder()).append("Request failed. Reason(").append(((String) (obj1))).append(") Code(").append(String.valueOf(k1)).append(") Protocol(").append(s1).append(") Version(").append(String.valueOf(i1)).append(".").append(String.valueOf(j1)).append(")").toString());
            }
            obj = (new StringBuilder()).append("Request executed. Reason(").append(((String) (obj1))).append(") Code(").append(String.valueOf(k1)).append(") Protocol(").append(s1).append(") Version(").append(String.valueOf(i1)).append(".").append(String.valueOf(j1)).append(")").toString();
            if (e != null)
            {
                long l1 = com.nielsen.app.sdk.h.g();
                obj = d. new b(3, n, l, l1, 0L, 0L, ((String) (obj)), null);
                e.put(obj);
            }
            httpresponse = httpresponse.getEntity();
            if (httpresponse == null)
            {
                throw new Exception("There was no data on the Nielsen server response");
            }
            byte abyte0[] = EntityUtils.toByteArray(httpresponse);
            long l2 = abyte0.length;
            if (l2 < 0L)
            {
                httpresponse.consumeContent();
                throw new Exception(String.format("Client received an invalid response. Check if it has permition for the connection used. Content received length = %d", new Object[] {
                    Long.valueOf(l2)
                }));
            }
            if (l2 > 0L)
            {
                httpresponse = new String(abyte0);
            } else
            {
                httpresponse = "";
            }
            if (httpresponse.contains("<br>"))
            {
                httpresponse.replaceAll("<br>", System.getProperty("line.separator"));
            }
            if (e != null)
            {
                long l3 = com.nielsen.app.sdk.h.g();
                httpresponse = d. new b(4, n, l, l3, 0L, 0L, httpresponse, null);
                e.put(httpresponse);
            }
            n = 0;
        }

        public void delete(String s1, String s2)
            throws InterruptedException
        {
            a(s1, 4, s2, null);
        }

        public void get(String s1, String s2)
            throws InterruptedException
        {
            a(s1, 1, s2, null);
        }

        public void post(String s1, String s2)
            throws InterruptedException
        {
            post(s1, s2, null);
        }

        public void post(String s1, String s2, List list)
            throws InterruptedException
        {
            a(s1, 3, s2, list);
        }

        public void put(String s1, String s2, List list)
            throws InterruptedException
        {
            a(s1, 2, s2, list);
        }

        public void run()
        {
            a(k);
            if (f != null)
            {
                ClientConnectionManager clientconnectionmanager = f.getConnectionManager();
                if (clientconnectionmanager != null)
                {
                    clientconnectionmanager.shutdown();
                }
            }
            AppRequestManager.a(AppRequestManager.a(), this);
            return;
            Object obj;
            obj;
            BlockingQueue blockingqueue = e;
            if (blockingqueue == null)
            {
                break MISSING_BLOCK_LABEL_94;
            }
            long l1 = com.nielsen.app.sdk.h.g();
            b b1 = d. new b(2, n, l, l1, 0L, 0L, "", ((Exception) (obj)));
            e.put(b1);
_L2:
            if (f != null)
            {
                ClientConnectionManager clientconnectionmanager1 = f.getConnectionManager();
                if (clientconnectionmanager1 != null)
                {
                    clientconnectionmanager1.shutdown();
                }
            }
            AppRequestManager.a(AppRequestManager.a(), this);
            return;
            clientconnectionmanager1;
            com.nielsen.app.sdk.c.a(clientconnectionmanager1, true, 9, 'E', "Thread (%s) interrupted", new Object[] {
                l
            });
            if (true) goto _L2; else goto _L1
_L1:
            clientconnectionmanager1;
            if (f != null)
            {
                ClientConnectionManager clientconnectionmanager3 = f.getConnectionManager();
                if (clientconnectionmanager3 != null)
                {
                    clientconnectionmanager3.shutdown();
                }
            }
            AppRequestManager.a(AppRequestManager.a(), this);
            throw clientconnectionmanager1;
            clientconnectionmanager1;
            com.nielsen.app.sdk.c.a(clientconnectionmanager1, true, 9, 'E', "Thread (%s) out of memory", new Object[] {
                l
            });
            if (f != null)
            {
                ClientConnectionManager clientconnectionmanager2 = f.getConnectionManager();
                if (clientconnectionmanager2 != null)
                {
                    clientconnectionmanager2.shutdown();
                }
            }
            AppRequestManager.a(AppRequestManager.a(), this);
            return;
        }

        public void runSynchronously(String s1)
            throws Exception
        {
            a(s1);
        }

        public AppRequest(String s1, AppRequestHandler apprequesthandler, int i1, int j1, int k1)
        {
            d = AppRequestManager.this;
            super();
            e = null;
            f = null;
            g = 0;
            h = 0;
            i = 0;
            j = null;
            k = "";
            l = "";
            m = "";
            n = 0;
            a = 0L;
            b = 0L;
            c = null;
            try
            {
                g = i1;
                h = j1;
                l = s1;
                i = k1;
                c = com.nielsen.app.sdk.a.m();
                e = apprequesthandler.getQueue();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (AppRequestManager apprequestmanager)
            {
                com.nielsen.app.sdk.c.a(AppRequestManager.this, true, 9, 'E', "Failed to instantiate the meter request object", new Object[0]);
            }
        }
    }

    public abstract class AppRequestHandler extends Thread
        implements Runnable
    {

        private boolean a;
        private String b;
        private BlockingQueue c;
        final AppRequestManager d;

        public BlockingQueue getQueue()
        {
            if (c == null)
            {
                c = new LinkedBlockingQueue();
            }
            return c;
        }

        public abstract void onError(String s1, long l1, Exception exception);

        public abstract void onFinish(String s1, long l1, String s2);

        public abstract void onIdle(String s1, long l1);

        public abstract void onStart(String s1, long l1);

        public abstract void onUpdate(String s1, long l1, long l2, long l3, 
                String s2);

        public void run()
        {
_L10:
            Object obj;
            if (a)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = (b)c.take();
            if (obj == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((b) (obj)).a();
            JVM INSTR tableswitch 0 4: default 234
        //                       0 64
        //                       1 106
        //                       2 141
        //                       3 165
        //                       4 192;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            if (false)
            {
            }
            break; /* Loop/switch isn't completed */
_L2:
            onIdle(((b) (obj)).c(), ((b) (obj)).d());
            break; /* Loop/switch isn't completed */
_L8:
            onError("The application was suspended or terminated while waiting sending information from the caller object", 0L, ((Exception) (obj)));
            d.l.remove(b);
            return;
_L3:
            try
            {
                onStart(((b) (obj)).c(), ((b) (obj)).d());
                break; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            finally
            {
                d.l.remove(b);
                throw obj;
            }
            if (true) goto _L8; else goto _L7
_L7:
            break; /* Loop/switch isn't completed */
_L4:
            onError(((b) (obj)).c(), ((b) (obj)).d(), ((b) (obj)).h());
            a = true;
            break; /* Loop/switch isn't completed */
_L5:
            onUpdate(((b) (obj)).c(), ((b) (obj)).d(), ((b) (obj)).e(), ((b) (obj)).f(), ((b) (obj)).g());
            break; /* Loop/switch isn't completed */
_L6:
            onFinish(((b) (obj)).c(), ((b) (obj)).d(), ((b) (obj)).g());
            a = true;
            if (true) goto _L10; else goto _L9
_L9:
            d.l.remove(b);
            return;
        }

        public AppRequestHandler(String s1)
            throws Exception
        {
            d = AppRequestManager.this;
            super();
            a = false;
            b = "";
            c = null;
            long l1 = com.nielsen.app.sdk.h.s();
            b = s1;
            if (l1 != 0L)
            {
                b = (new StringBuilder()).append(b).append("_").append(Long.toString(l1)).toString();
            }
            setName(b);
            getQueue();
            start();
            l.put(b, this);
        }
    }

    private class a
    {

        int a;
        String b;
        String c;
        final AppRequestManager d;

        public String a()
        {
            return c;
        }

        public String b()
        {
            return b;
        }

        public int c()
        {
            return a;
        }

        private a()
        {
            d = AppRequestManager.this;
            super();
            a = 0;
            b = "";
            c = "";
        }
    }

    class b
    {

        int a;
        int b;
        String c;
        long d;
        long e;
        long f;
        String g;
        Exception h;
        final AppRequestManager i;

        int a()
        {
            return a;
        }

        int b()
        {
            return b;
        }

        String c()
        {
            return c;
        }

        long d()
        {
            return d;
        }

        long e()
        {
            return e;
        }

        long f()
        {
            return f;
        }

        String g()
        {
            return g;
        }

        Exception h()
        {
            return h;
        }

        b(int i1, int j1, String s1, long l1, long l2, long l3, String s2, Exception exception)
        {
            i = AppRequestManager.this;
            super();
            a = 0;
            b = 1;
            c = null;
            d = 0L;
            e = 0L;
            f = 0L;
            g = null;
            h = null;
            a = i1;
            b = j1;
            c = s1;
            g = s2;
            d = l1;
            f = l3;
            e = l2;
            h = exception;
        }
    }


    public static final int a = 2;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 2;
    private static AppRequestManager t = null;
    Map l;
    HttpParams p;
    private int q;
    private ArrayList r;
    private ArrayList s;
    private Context u;

    private AppRequestManager(Context context, int i1)
    {
        l = new LinkedHashMap();
        p = null;
        q = 2;
        r = new ArrayList();
        s = new ArrayList();
        u = null;
        try
        {
            u = context;
            q = i1;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.nielsen.app.sdk.c.a(context, true, 'E', "Could not instantiate request manager object", new Object[0]);
        }
    }

    static Context a(AppRequestManager apprequestmanager)
    {
        return apprequestmanager.u;
    }

    static AppRequestManager a()
    {
        return t;
    }

    public static AppRequestManager a(Context context, int i1)
    {
        com/nielsen/app/sdk/AppRequestManager;
        JVM INSTR monitorenter ;
        if (t == null)
        {
            t = new AppRequestManager(context, i1);
        }
        context = t;
        com/nielsen/app/sdk/AppRequestManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static void a(AppRequestManager apprequestmanager, Runnable runnable)
    {
        apprequestmanager.b(runnable);
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!s.isEmpty() && r.size() < q)
        {
            Runnable runnable = (Runnable)s.get(0);
            s.remove(0);
            r.add(runnable);
            (new Thread(runnable)).start();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void b(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        r.remove(runnable);
        b();
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    public void a(Runnable runnable)
    {
        s.add(runnable);
        b();
    }

}
