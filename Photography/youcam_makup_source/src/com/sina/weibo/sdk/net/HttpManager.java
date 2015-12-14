// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.URI;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.sina.weibo.sdk.net:
//            WeiboParameters, SSLSocketFactoryEx, NetStateManager, CustomRedirectHandler

public class HttpManager
{

    private static final String BOUNDARY = getBoundry();
    private static final int BUFFER_SIZE = 8192;
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String END_MP_BOUNDARY = (new StringBuilder("--")).append(BOUNDARY).append("--").toString();
    private static final String HTTP_METHOD_GET = "GET";
    private static final String HTTP_METHOD_POST = "POST";
    private static final String MP_BOUNDARY = (new StringBuilder("--")).append(BOUNDARY).toString();
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final int SOCKET_TIMEOUT = 20000;
    private static final String TAG = "HttpManager";
    private static SSLSocketFactory sSSLSocketFactory;

    public HttpManager()
    {
    }

    public static void buildParams(OutputStream outputstream, WeiboParameters weiboparameters)
    {
        Object obj;
        Object obj1;
        obj = weiboparameters.keySet();
        obj1 = ((Set) (obj)).iterator();
_L4:
        if (((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        obj = ((Set) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext())
        {
            outputstream.write((new StringBuilder("\r\n")).append(END_MP_BOUNDARY).toString().getBytes());
            return;
        }
          goto _L3
_L2:
        try
        {
            String s = (String)((Iterator) (obj1)).next();
            if (weiboparameters.get(s) instanceof String)
            {
                StringBuilder stringbuilder = new StringBuilder(100);
                stringbuilder.setLength(0);
                stringbuilder.append(MP_BOUNDARY).append("\r\n");
                stringbuilder.append("content-disposition: form-data; name=\"").append(s).append("\"\r\n\r\n");
                stringbuilder.append(weiboparameters.get(s)).append("\r\n");
                outputstream.write(stringbuilder.toString().getBytes());
            }
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new WeiboException(outputstream);
        }
          goto _L4
_L3:
        Object obj2;
        obj1 = (String)((Iterator) (obj)).next();
        obj2 = weiboparameters.get(((String) (obj1)));
        if (!(obj2 instanceof Bitmap)) goto _L6; else goto _L5
_L5:
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(MP_BOUNDARY).append("\r\n");
        stringbuilder1.append("content-disposition: form-data; name=\"").append(((String) (obj1))).append("\"; filename=\"file\"\r\n");
        stringbuilder1.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
        outputstream.write(stringbuilder1.toString().getBytes());
        obj1 = (Bitmap)obj2;
        obj2 = new ByteArrayOutputStream();
        ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, ((OutputStream) (obj2)));
        outputstream.write(((ByteArrayOutputStream) (obj2)).toByteArray());
        outputstream.write("\r\n".getBytes());
          goto _L7
_L6:
        if (!(obj2 instanceof ByteArrayOutputStream)) goto _L7; else goto _L8
_L8:
        StringBuilder stringbuilder2 = new StringBuilder();
        stringbuilder2.append(MP_BOUNDARY).append("\r\n");
        stringbuilder2.append("content-disposition: form-data; name=\"").append(((String) (obj1))).append("\"; filename=\"file\"\r\n");
        stringbuilder2.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
        outputstream.write(stringbuilder2.toString().getBytes());
        obj1 = (ByteArrayOutputStream)obj2;
        outputstream.write(((ByteArrayOutputStream) (obj1)).toByteArray());
        outputstream.write("\r\n".getBytes());
        ((ByteArrayOutputStream) (obj1)).close();
          goto _L7
    }

    private static native String calcOauthSignNative(Context context, String s, String s1);

    public static String downloadFile(Context context, String s, String s1, String s2)
    {
        com/sina/weibo/sdk/net/HttpManager;
        JVM INSTR monitorenter ;
        File file;
        context = new File(s1);
        if (!context.exists())
        {
            context.mkdirs();
        }
        file = new File(context, s2);
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        context = file.getPath();
_L3:
        com/sina/weibo/sdk/net/HttpManager;
        JVM INSTR monitorexit ;
        return context;
_L2:
        if (URLUtil.isValidUrl(s))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        context = "";
          goto _L3
        HttpClient httpclient = getNewHttpClient();
        long l = 0L;
        s1 = new File(s1, (new StringBuilder(String.valueOf(s2))).append("_temp").toString());
        if (!s1.exists()) goto _L5; else goto _L4
_L4:
        l = s1.length();
_L16:
        int i;
        context = new HttpGet(s);
        context.setHeader("RANGE", (new StringBuilder("bytes=")).append(l).append("-").toString());
        context = httpclient.execute(context);
        i = context.getStatusLine().getStatusCode();
        if (i != 206) goto _L7; else goto _L6
_L6:
        s = context.getHeaders("Content-Range");
        long l1;
        l1 = l;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_633;
        }
        l1 = l;
        if (s.length == 0)
        {
            break MISSING_BLOCK_LABEL_633;
        }
        s = s[0].getValue();
        l1 = Long.parseLong(s.substring(s.indexOf('/') + 1));
_L19:
        s = context.getEntity();
        context = context.getFirstHeader("Content-Encoding");
        if (context == null) goto _L9; else goto _L8
_L8:
        if (context.getValue().toLowerCase().indexOf("gzip") <= -1) goto _L9; else goto _L10
_L10:
        context = new GZIPInputStream(s.getContent());
_L21:
        s = new RandomAccessFile(s1, "rw");
        s.seek(l);
        s2 = new byte[1024];
_L22:
        i = context.read(s2);
        if (i != -1) goto _L12; else goto _L11
_L11:
        s.close();
        context.close();
        if (l1 == 0L) goto _L14; else goto _L13
_L13:
        if (s1.length() >= l1) goto _L15; else goto _L14
_L14:
        s1.delete();
        if (httpclient == null)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        httpclient.getConnectionManager().closeExpiredConnections();
        httpclient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
_L18:
        context = "";
          goto _L3
_L5:
        s1.createNewFile();
          goto _L16
_L20:
        context.printStackTrace();
        s1.delete();
        if (httpclient == null) goto _L18; else goto _L17
_L17:
        httpclient.getConnectionManager().closeExpiredConnections();
        httpclient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
          goto _L18
        context;
        throw context;
_L7:
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_505;
        }
        l1 = 0L;
        s = context.getFirstHeader("Content-Length");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_633;
        }
        l1 = Integer.valueOf(s.getValue()).intValue();
        l = 0L;
          goto _L19
        try
        {
            throw new WeiboHttpException(readRsponse(context), i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        finally
        {
            if (httpclient == null) goto _L0; else goto _L0
        }
          goto _L20
        httpclient.getConnectionManager().closeExpiredConnections();
        httpclient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
        throw context;
_L9:
        context = s.getContent();
          goto _L21
_L12:
        s.write(s2, 0, i);
          goto _L22
_L15:
        s1.renameTo(file);
        s = file.getPath();
        context = s;
        if (httpclient == null) goto _L3; else goto _L23
_L23:
        httpclient.getConnectionManager().closeExpiredConnections();
        httpclient.getConnectionManager().closeIdleConnections(300L, TimeUnit.SECONDS);
        context = s;
          goto _L3
        long l2 = 0L;
        l = l1;
        l1 = l2;
          goto _L19
    }

    public static String getBoundry()
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer();
        i = 1;
_L2:
        long l;
        if (i >= 12)
        {
            return stringbuffer.toString();
        }
        l = System.currentTimeMillis() + (long)i;
        if (l % 3L != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append((char)(int)l % 9);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (l % 3L == 1L)
        {
            stringbuffer.append((char)(int)(l % 26L + 65L));
        } else
        {
            stringbuffer.append((char)(int)(l % 26L + 97L));
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static Certificate getCertificate(String s)
    {
        Object obj;
        obj = CertificateFactory.getInstance("X.509");
        s = com/sina/weibo/sdk/net/HttpManager.getResourceAsStream(s);
        obj = ((CertificateFactory) (obj)).generateCertificate(s);
        if (s != null)
        {
            s.close();
        }
        return ((Certificate) (obj));
        Exception exception;
        exception;
        if (s != null)
        {
            s.close();
        }
        throw exception;
    }

    public static HttpClient getNewHttpClient()
    {
        Object obj;
        try
        {
            obj = new BasicHttpParams();
            HttpProtocolParams.setVersion(((HttpParams) (obj)), HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(((HttpParams) (obj)), "UTF-8");
            Object obj1 = new SchemeRegistry();
            ((SchemeRegistry) (obj1)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            ((SchemeRegistry) (obj1)).register(new Scheme("https", getSSLSocketFactory(), 443));
            obj1 = new ThreadSafeClientConnManager(((HttpParams) (obj)), ((SchemeRegistry) (obj1)));
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 25000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 20000);
            obj = new DefaultHttpClient(((ClientConnectionManager) (obj1)), ((HttpParams) (obj)));
        }
        catch (Exception exception)
        {
            return new DefaultHttpClient();
        }
        return ((HttpClient) (obj));
    }

    private static String getOauthSign(Context context, String s, String s1, String s2, String s3)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        if (!TextUtils.isEmpty(s1))
        {
            stringbuilder.append(s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            stringbuilder.append(s2);
        }
        return calcOauthSignNative(context, stringbuilder.toString(), s3);
    }

    private static SSLSocketFactory getSSLSocketFactory()
    {
        if (sSSLSocketFactory == null)
        {
            try
            {
                KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
                keystore.load(null, null);
                Certificate certificate = getCertificate("cacert_cn.cer");
                Certificate certificate1 = getCertificate("cacert_com.cer");
                keystore.setCertificateEntry("cnca", certificate);
                keystore.setCertificateEntry("comca", certificate1);
                sSSLSocketFactory = new SSLSocketFactoryEx(keystore);
                LogUtil.d("HttpManager", "getSSLSocketFactory noraml !!!!!");
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                sSSLSocketFactory = SSLSocketFactory.getSocketFactory();
                LogUtil.d("HttpManager", "getSSLSocketFactory error default !!!!!");
            }
        }
        return sSSLSocketFactory;
    }

    private static String getTimestamp()
    {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }

    public static String openRedirectUrl4LocationUri(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        Object obj;
        DefaultHttpClient defaulthttpclient;
        Object obj1;
        Object obj2;
        obj1 = null;
        defaulthttpclient = null;
        obj2 = null;
        obj = defaulthttpclient;
        CustomRedirectHandler customredirecthandler = new CustomRedirectHandler() {

            public void onReceivedException()
            {
            }

            public boolean shouldRedirectUrl(String s2)
            {
                return true;
            }

        };
        obj = defaulthttpclient;
        defaulthttpclient = (DefaultHttpClient)getNewHttpClient();
        defaulthttpclient.setRedirectHandler(customredirecthandler);
        setHttpCommonParam(context, weiboparameters);
        defaulthttpclient.getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
        if (!s1.equals("GET")) goto _L2; else goto _L1
_L1:
        weiboparameters = new HttpGet((new StringBuilder(String.valueOf(s))).append("?").append(weiboparameters.encodeUrl()).toString());
_L4:
        weiboparameters.setHeader("User-Agent", NetworkHelper.generateUA(context));
        defaulthttpclient.execute(weiboparameters);
        context = customredirecthandler.getRedirectUrl();
        shutdownHttpClient(defaulthttpclient);
        return context;
_L2:
        weiboparameters = obj2;
        if (!s1.equals("POST")) goto _L4; else goto _L3
_L3:
        weiboparameters = new HttpPost(s);
          goto _L4
        context;
        obj = defaulthttpclient;
_L8:
        throw new WeiboException(context);
        context;
_L6:
        shutdownHttpClient(((HttpClient) (obj)));
        throw context;
        context;
        obj = defaulthttpclient;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        obj = obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String openUrl(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        context = readRsponse(requestHttpExecute(context, s, s1, weiboparameters));
        LogUtil.d("HttpManager", (new StringBuilder("Response : ")).append(context).toString());
        return context;
    }

    public static String openUrl4RdirectURL(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj = null;
        obj2 = null;
        DefaultHttpClient defaulthttpclient = (DefaultHttpClient)getNewHttpClient();
        defaulthttpclient.setRedirectHandler(new RedirectHandler() {

            public URI getLocationURI(HttpResponse httpresponse, HttpContext httpcontext)
            {
                LogUtil.d("HttpManager", "openUrl4RdirectURL getLocationURI method");
                return null;
            }

            public boolean isRedirectRequested(HttpResponse httpresponse, HttpContext httpcontext)
            {
                LogUtil.d("HttpManager", "openUrl4RdirectURL isRedirectRequested method");
                return false;
            }

        });
        setHttpCommonParam(context, weiboparameters);
        defaulthttpclient.getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
        if (!s1.equals("GET")) goto _L2; else goto _L1
_L1:
        context = (new StringBuilder(String.valueOf(s))).append("?").append(weiboparameters.encodeUrl()).toString();
        LogUtil.d("HttpManager", (new StringBuilder("openUrl4RdirectURL GET url : ")).append(context).toString());
        context = new HttpGet(context);
_L6:
        int i;
        context = defaulthttpclient.execute(context);
        i = context.getStatusLine().getStatusCode();
        if (i != 301 && i != 302) goto _L4; else goto _L3
_L3:
        context = context.getFirstHeader("Location").getValue();
        LogUtil.d("HttpManager", (new StringBuilder("RedirectURL = ")).append(context).toString());
        shutdownHttpClient(defaulthttpclient);
        return context;
_L2:
        context = obj2;
        if (!s1.equals("POST")) goto _L6; else goto _L5
_L5:
        context = new HttpPost(s);
        LogUtil.d("HttpManager", (new StringBuilder("openUrl4RdirectURL POST url : ")).append(s).toString());
          goto _L6
_L8:
        throw new WeiboException(context);
        context;
        shutdownHttpClient(((HttpClient) (obj)));
        throw context;
_L4:
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        context = readRsponse(context);
        shutdownHttpClient(defaulthttpclient);
        return context;
        try
        {
            throw new WeiboHttpException(readRsponse(context), i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            obj = defaulthttpclient;
        }
        finally
        {
            obj = defaulthttpclient;
        }
        continue; /* Loop/switch isn't completed */
        context;
        obj = obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static String readRsponse(HttpResponse httpresponse)
    {
        Object obj = null;
        if (httpresponse != null) goto _L2; else goto _L1
_L1:
        httpresponse = ((HttpResponse) (obj));
_L10:
        return httpresponse;
_L2:
        ByteArrayOutputStream bytearrayoutputstream;
        obj = httpresponse.getEntity();
        bytearrayoutputstream = new ByteArrayOutputStream();
        Object obj1 = ((HttpEntity) (obj)).getContent();
        Object obj2;
        obj2 = obj1;
        obj = obj1;
        Header header = httpresponse.getFirstHeader("Content-Encoding");
        httpresponse = ((HttpResponse) (obj1));
        if (header == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        httpresponse = ((HttpResponse) (obj1));
        obj2 = obj1;
        obj = obj1;
        if (header.getValue().toLowerCase().indexOf("gzip") <= -1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        obj2 = obj1;
        obj = obj1;
        httpresponse = new GZIPInputStream(((InputStream) (obj1)));
        obj2 = httpresponse;
        obj = httpresponse;
        obj1 = new byte[8192];
_L4:
        obj2 = httpresponse;
        obj = httpresponse;
        int i = httpresponse.read(((byte []) (obj1)));
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        obj2 = httpresponse;
        obj = httpresponse;
        obj1 = new String(bytearrayoutputstream.toByteArray(), "UTF-8");
        obj2 = httpresponse;
        obj = httpresponse;
        LogUtil.d("HttpManager", (new StringBuilder("readRsponse result : ")).append(((String) (obj1))).toString());
        if (httpresponse != null)
        {
            try
            {
                httpresponse.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                httpresponse.printStackTrace();
            }
        }
        httpresponse = ((HttpResponse) (obj1));
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                httpresponse.printStackTrace();
                return ((String) (obj1));
            }
            return ((String) (obj1));
        }
        continue; /* Loop/switch isn't completed */
        obj2 = httpresponse;
        obj = httpresponse;
        bytearrayoutputstream.write(((byte []) (obj1)), 0, i);
        if (true) goto _L4; else goto _L3
_L3:
        httpresponse;
        obj = obj2;
_L8:
        throw new WeiboException(httpresponse);
        httpresponse;
_L6:
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        if (bytearrayoutputstream != null)
        {
            try
            {
                bytearrayoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw httpresponse;
        httpresponse;
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
        httpresponse;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static HttpResponse requestHttpExecute(Context context, String s, String s1, WeiboParameters weiboparameters)
    {
        Object obj;
        String s2;
        Object obj2;
        Object obj3;
        Object obj4;
        obj3 = null;
        obj = null;
        s2 = null;
        obj4 = null;
        obj2 = null;
        Object obj1 = getNewHttpClient();
        obj = obj1;
        s2 = obj3;
        obj1 = obj4;
        ((HttpClient) (obj)).getParams().setParameter("http.route.default-proxy", NetStateManager.getAPN());
        s2 = obj3;
        obj1 = obj4;
        setHttpCommonParam(context, weiboparameters);
        s2 = obj3;
        obj1 = obj4;
        if (!s1.equals("GET")) goto _L2; else goto _L1
_L1:
        s2 = obj3;
        obj1 = obj4;
        s = (new StringBuilder(String.valueOf(s))).append("?").append(weiboparameters.encodeUrl()).toString();
        s2 = obj3;
        obj1 = obj4;
        context = new HttpGet(s);
        s2 = obj3;
        obj1 = obj4;
        LogUtil.d("HttpManager", (new StringBuilder("requestHttpExecute GET Url : ")).append(s).toString());
        s = obj2;
_L7:
        s2 = s;
        obj1 = s;
        context = ((HttpClient) (obj)).execute(context);
        s2 = s;
        obj1 = s;
        int i = context.getStatusLine().getStatusCode();
        if (i == 200) goto _L4; else goto _L3
_L3:
        s2 = s;
        obj1 = s;
        try
        {
            throw new WeiboHttpException(readRsponse(context), i);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s = ((String) (obj));
        }
        finally
        {
            s = ((String) (obj1));
        }
        context = s2;
_L13:
        s1.printStackTrace();
        throw new WeiboException(s1);
        s1;
        obj = s;
        s = context;
        context = s1;
_L10:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        shutdownHttpClient(((HttpClient) (obj)));
        throw context;
_L2:
        s2 = obj3;
        obj1 = obj4;
        if (!s1.equals("POST"))
        {
            break MISSING_BLOCK_LABEL_513;
        }
        s2 = obj3;
        obj1 = obj4;
        LogUtil.d("HttpManager", (new StringBuilder("requestHttpExecute POST Url : ")).append(s).toString());
        s2 = obj3;
        obj1 = obj4;
        s = new HttpPost(s);
        s2 = obj3;
        obj1 = obj4;
        context = new ByteArrayOutputStream();
        if (!weiboparameters.hasBinaryData()) goto _L6; else goto _L5
_L5:
        s.setHeader("Content-Type", (new StringBuilder("multipart/form-data; boundary=")).append(BOUNDARY).toString());
        buildParams(context, weiboparameters);
_L8:
        s.setEntity(new ByteArrayEntity(context.toByteArray()));
        s1 = context;
        context = s;
        s = s1;
          goto _L7
_L6:
        s1 = ((String) (weiboparameters.get("content-type")));
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        if (!(s1 instanceof String))
        {
            break MISSING_BLOCK_LABEL_492;
        }
        weiboparameters.remove("content-type");
        s.setHeader("Content-Type", (String)s1);
_L9:
        s1 = weiboparameters.encodeUrl();
        LogUtil.d("HttpManager", (new StringBuilder("requestHttpExecute POST postParam : ")).append(s1).toString());
        context.write(s1.getBytes("UTF-8"));
          goto _L8
        s.setHeader("Content-Type", "application/x-www-form-urlencoded");
          goto _L9
        s1;
        s = context;
        context = s1;
          goto _L10
        s2 = obj3;
        obj1 = obj4;
        if (!s1.equals("DELETE")) goto _L12; else goto _L11
_L11:
        s2 = obj3;
        obj1 = obj4;
        context = new HttpDelete(s);
        s = obj2;
          goto _L7
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        shutdownHttpClient(((HttpClient) (obj)));
        return context;
        context;
        obj = null;
        s = s2;
          goto _L10
        s1;
        s = null;
        context = ((Context) (obj));
          goto _L13
_L12:
        context = null;
        s = obj2;
          goto _L7
        s1;
        s = ((String) (obj));
          goto _L13
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboparameters)
    {
        String s1 = "";
        if (!TextUtils.isEmpty(weiboparameters.getAppKey()))
        {
            String s = Utility.getAid(context, weiboparameters.getAppKey());
            s1 = s;
            if (!TextUtils.isEmpty(s))
            {
                weiboparameters.put("aid", s);
                s1 = s;
            }
        }
        String s2 = getTimestamp();
        weiboparameters.put("oauth_timestamp", s2);
        Object obj = weiboparameters.get("access_token");
        Object obj1 = weiboparameters.get("refresh_token");
        Object obj2 = weiboparameters.get("phone");
        if (obj != null && (obj instanceof String))
        {
            obj = (String)obj;
        } else
        if (obj1 != null && (obj1 instanceof String))
        {
            obj = (String)obj1;
        } else
        if (obj2 != null && (obj2 instanceof String))
        {
            obj = (String)obj2;
        } else
        {
            obj = "";
        }
        weiboparameters.put("oauth_sign", getOauthSign(context, s1, ((String) (obj)), weiboparameters.getAppKey(), s2));
    }

    public static void shutdownHttpClient(HttpClient httpclient)
    {
        if (httpclient == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        httpclient.getConnectionManager().closeExpiredConnections();
        return;
        httpclient;
    }

    static 
    {
        System.loadLibrary("weibosdkcore");
    }
}
