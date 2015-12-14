// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.a.a;
import com.tencent.connect.b.m;
import com.tencent.open.a.k;
import com.tencent.open.b.g;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
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
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open.utils:
//            f, n, m, d, 
//            g, h

public class HttpUtils
{

    private static final String a = com/tencent/open/utils/HttpUtils.getName();

    private HttpUtils()
    {
    }

    public static int a(IOException ioexception)
    {
        if (ioexception instanceof CharConversionException)
        {
            return -20;
        }
        if (ioexception instanceof MalformedInputException)
        {
            return -21;
        }
        if (ioexception instanceof UnmappableCharacterException)
        {
            return -22;
        }
        if (ioexception instanceof HttpResponseException)
        {
            return -23;
        }
        if (ioexception instanceof ClosedChannelException)
        {
            return -24;
        }
        if (ioexception instanceof ConnectionClosedException)
        {
            return -25;
        }
        if (ioexception instanceof EOFException)
        {
            return -26;
        }
        if (ioexception instanceof FileLockInterruptionException)
        {
            return -27;
        }
        if (ioexception instanceof FileNotFoundException)
        {
            return -28;
        }
        if (ioexception instanceof HttpRetryException)
        {
            return -29;
        }
        if (ioexception instanceof ConnectTimeoutException)
        {
            return -7;
        }
        if (ioexception instanceof SocketTimeoutException)
        {
            return -8;
        }
        if (ioexception instanceof InvalidPropertiesFormatException)
        {
            return -30;
        }
        if (ioexception instanceof MalformedChunkCodingException)
        {
            return -31;
        }
        if (ioexception instanceof MalformedURLException)
        {
            return -3;
        }
        if (ioexception instanceof NoHttpResponseException)
        {
            return -32;
        }
        if (ioexception instanceof InvalidClassException)
        {
            return -33;
        }
        if (ioexception instanceof InvalidObjectException)
        {
            return -34;
        }
        if (ioexception instanceof NotActiveException)
        {
            return -35;
        }
        if (ioexception instanceof NotSerializableException)
        {
            return -36;
        }
        if (ioexception instanceof OptionalDataException)
        {
            return -37;
        }
        if (ioexception instanceof StreamCorruptedException)
        {
            return -38;
        }
        if (ioexception instanceof WriteAbortedException)
        {
            return -39;
        }
        if (ioexception instanceof ProtocolException)
        {
            return -40;
        }
        if (ioexception instanceof SSLHandshakeException)
        {
            return -41;
        }
        if (ioexception instanceof SSLKeyException)
        {
            return -42;
        }
        if (ioexception instanceof SSLPeerUnverifiedException)
        {
            return -43;
        }
        if (ioexception instanceof SSLProtocolException)
        {
            return -44;
        }
        if (ioexception instanceof BindException)
        {
            return -45;
        }
        if (ioexception instanceof ConnectException)
        {
            return -46;
        }
        if (ioexception instanceof NoRouteToHostException)
        {
            return -47;
        }
        if (ioexception instanceof PortUnreachableException)
        {
            return -48;
        }
        if (ioexception instanceof SyncFailedException)
        {
            return -49;
        }
        if (ioexception instanceof UTFDataFormatException)
        {
            return -50;
        }
        if (ioexception instanceof UnknownHostException)
        {
            return -51;
        }
        if (ioexception instanceof UnknownServiceException)
        {
            return -52;
        }
        if (ioexception instanceof UnsupportedEncodingException)
        {
            return -53;
        }
        return !(ioexception instanceof ZipException) ? -2 : -54;
    }

    public static f a(Context context)
    {
        if (context == null)
        {
            return null;
        }
        Object obj = (ConnectivityManager)context.getSystemService("connectivity");
        if (obj == null)
        {
            return null;
        }
        obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        if (obj == null)
        {
            return null;
        }
        if (((NetworkInfo) (obj)).getType() == 0)
        {
            String s = c(context);
            int i = b(context);
            if (!TextUtils.isEmpty(s) && i >= 0)
            {
                return new f(s, i);
            }
        }
        return null;
    }

    public static n a(Context context, String s, String s1, Bundle bundle)
    {
        if (context != null)
        {
            Object obj = (ConnectivityManager)context.getSystemService("connectivity");
            if (obj != null)
            {
                obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
                if (obj == null || !((NetworkInfo) (obj)).isAvailable())
                {
                    throw new NetworkUnavailableException("network unavailable");
                }
            }
        }
        Object obj1;
        int i;
        int j;
        if (bundle != null)
        {
            bundle = new Bundle(bundle);
        } else
        {
            bundle = new Bundle();
        }
        obj1 = bundle.getString("appid_for_getting_config");
        bundle.remove("appid_for_getting_config");
        obj1 = a(context, ((String) (obj1)), s);
        if (s1.equals("GET"))
        {
            s1 = a(bundle);
            i = s1.length();
            k.b(a, (new StringBuilder()).append("-->openUrl2 before url =").append(s).toString());
            if (s.indexOf("?") == -1)
            {
                context = (new StringBuilder()).append(s).append("?").toString();
            } else
            {
                context = (new StringBuilder()).append(s).append("&").toString();
            }
            k.b(a, (new StringBuilder()).append("-->openUrl2 encodedParam =").append(s1).append(" -- url = ").append(context).toString());
            context = new HttpGet((new StringBuilder()).append(context).append(s1).toString());
            context.addHeader("Accept-Encoding", "gzip");
            i = 0 + i;
        } else
        if (s1.equals("POST"))
        {
            context = new HttpPost(s);
            context.addHeader("Accept-Encoding", "gzip");
            s = new Bundle();
            Iterator iterator = bundle.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s3 = (String)iterator.next();
                Object obj2 = bundle.get(s3);
                if (obj2 instanceof byte[])
                {
                    s.putByteArray(s3, (byte[])(byte[])obj2);
                }
            } while (true);
            if (!bundle.containsKey("method"))
            {
                bundle.putString("method", s1);
            }
            context.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            context.setHeader("Connection", "Keep-Alive");
            s1 = new ByteArrayOutputStream();
            s1.write(m.e("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            s1.write(m.e(a(bundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!s.isEmpty())
            {
                int l = s.size();
                s1.write(m.e("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                bundle = s.keySet().iterator();
                i = -1;
                do
                {
                    if (!bundle.hasNext())
                    {
                        break;
                    }
                    String s2 = (String)bundle.next();
                    j = i + 1;
                    s1.write(m.e((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s2).append("\"; filename=\"").append(s2).append("\"").append("\r\n").toString()));
                    s1.write(m.e("Content-Type: content/unknown\r\n\r\n"));
                    byte abyte0[] = s.getByteArray(s2);
                    if (abyte0 != null)
                    {
                        s1.write(abyte0);
                    }
                    i = j;
                    if (j < l - 1)
                    {
                        s1.write(m.e("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                        i = j;
                    }
                } while (true);
            }
            s1.write(m.e("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            s = s1.toByteArray();
            i = s.length + 0;
            s1.close();
            context.setEntity(new ByteArrayEntity(s));
        } else
        {
            context = null;
            i = 0;
        }
        context = ((HttpClient) (obj1)).execute(context);
        j = context.getStatusLine().getStatusCode();
        if (j == 200)
        {
            return new n(a(((HttpResponse) (context))), i);
        } else
        {
            throw new HttpStatusException((new StringBuilder()).append("http status code error:").append(j).toString());
        }
    }

    public static String a(Bundle bundle)
    {
        if (bundle == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        int i = 1;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (String)iterator.next();
            Object obj1 = bundle.get(((String) (obj)));
            if ((obj1 instanceof String) || (obj1 instanceof String[]))
            {
                if (obj1 instanceof String[])
                {
                    int j;
                    if (i != 0)
                    {
                        j = 0;
                    } else
                    {
                        stringbuilder.append("&");
                        j = i;
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(((String) (obj)))).append("=").toString());
                    obj = bundle.getStringArray(((String) (obj)));
                    i = j;
                    if (obj != null)
                    {
                        i = 0;
                        while (i < obj.length) 
                        {
                            if (i == 0)
                            {
                                stringbuilder.append(URLEncoder.encode(obj[i]));
                            } else
                            {
                                stringbuilder.append(URLEncoder.encode((new StringBuilder()).append(",").append(obj[i]).toString()));
                            }
                            i++;
                        }
                        i = j;
                    }
                } else
                {
                    if (i != 0)
                    {
                        i = 0;
                    } else
                    {
                        stringbuilder.append("&");
                    }
                    stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(((String) (obj)))).append("=").append(URLEncoder.encode(bundle.getString(((String) (obj))))).toString());
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String a(Bundle bundle, String s)
    {
        if (bundle == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = bundle.size();
        Iterator iterator = bundle.keySet().iterator();
        int i = -1;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            i++;
            Object obj = bundle.get(s1);
            if (obj instanceof String)
            {
                stringbuilder.append((new StringBuilder()).append("Content-Disposition: form-data; name=\"").append(s1).append("\"").append("\r\n").append("\r\n").append((String)obj).toString());
                if (i < j - 1)
                {
                    stringbuilder.append((new StringBuilder()).append("\r\n--").append(s).append("\r\n").toString());
                }
            }
        } while (true);
        return stringbuilder.toString();
    }

    private static String a(HttpResponse httpresponse)
    {
        byte abyte0[] = httpresponse.getEntity().getContent();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        httpresponse = httpresponse.getFirstHeader("Content-Encoding");
        if (httpresponse != null && httpresponse.getValue().toLowerCase().indexOf("gzip") > -1)
        {
            httpresponse = new GZIPInputStream(abyte0);
        } else
        {
            httpresponse = abyte0;
        }
        abyte0 = new byte[512];
        do
        {
            int i = httpresponse.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                return new String(bytearrayoutputstream.toByteArray(), "UTF-8");
            }
        } while (true);
    }

    public static HttpClient a(Context context, String s, String s1)
    {
        int i = 0;
        s1 = new SchemeRegistry();
        s1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        BasicHttpParams basichttpparams;
        int j;
        int l;
        if (android.os.Build.VERSION.SDK_INT < 16)
        {
            try
            {
                Object obj = KeyStore.getInstance(KeyStore.getDefaultType());
                ((KeyStore) (obj)).load(null, null);
                obj = new d(((KeyStore) (obj)));
                ((SSLSocketFactory) (obj)).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                s1.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            }
            catch (Exception exception)
            {
                s1.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else
        {
            s1.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        basichttpparams = new BasicHttpParams();
        if (context != null)
        {
            s = com.tencent.open.utils.g.a(context, s);
        } else
        {
            s = null;
        }
        if (s != null)
        {
            j = s.a("Common_HttpConnectionTimeout");
            i = s.a("Common_SocketConnectionTimeout");
        } else
        {
            j = 0;
        }
        l = j;
        if (j == 0)
        {
            l = 15000;
        }
        j = i;
        if (i == 0)
        {
            j = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basichttpparams, l);
        HttpConnectionParams.setSoTimeout(basichttpparams, j);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpProtocolParams.setUserAgent(basichttpparams, (new StringBuilder()).append("AndroidSDK_").append(android.os.Build.VERSION.SDK).append("_").append(Build.DEVICE).append("_").append(android.os.Build.VERSION.RELEASE).toString());
        s = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, s1), basichttpparams);
        context = a(context);
        if (context != null)
        {
            context = new HttpHost(((f) (context)).a, ((f) (context)).b);
            s.getParams().setParameter("http.route.default-proxy", context);
        }
        return s;
    }

    public static JSONObject a(m m1, Context context, String s, Bundle bundle, String s1)
    {
        k.a("openSDK_LOG", "OpenApi request");
        String s2;
        String s3;
        n n1;
        Object obj;
        int i;
        int j;
        int l;
        long l1;
        long l2;
        long l3;
        if (!s.toLowerCase().startsWith("http"))
        {
            s3 = (new StringBuilder()).append(com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/")).append(s).toString();
            s2 = (new StringBuilder()).append(com.tencent.open.utils.h.a().a(context, "https://openmobile.qq.com/")).append(s).toString();
        } else
        {
            s2 = s;
            s3 = s;
        }
        a(context, m1, s);
        l1 = SystemClock.elapsedRealtime();
        j = com.tencent.open.utils.g.a(context, m1.b()).a("Common_HttpRetryCount");
        k.b("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            config_value:").append(j).append("   appid:").append(m1.b()).append("     url:").append(s2).toString());
        if (j == 0)
        {
            j = 3;
        }
        k.b("OpenConfig_test", (new StringBuilder()).append("config 1:Common_HttpRetryCount            result_value:").append(j).append("   appid:").append(m1.b()).append("     url:").append(s2).toString());
        i = 0;
        m1 = null;
        l = i + 1;
        n1 = a(context, s3, s1, bundle);
        s = m.d(n1.a);
        try
        {
            i = s.getInt("ret");
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            i = -4;
        }
        try
        {
            l2 = n1.b;
            l3 = n1.c;
        }
        // Misplaced declaration of an exception variable
        catch (m m1)
        {
            m1.printStackTrace();
            g.a().a(s2, l1, 0L, 0L, -4);
            throw m1;
        }
        g.a().a(s2, l1, l2, l3, i);
        return s;
        obj;
        m1 = s;
        s = ((String) (obj));
_L7:
        s.printStackTrace();
        i = -7;
        if (l >= j) goto _L2; else goto _L1
_L1:
        l1 = SystemClock.elapsedRealtime();
_L4:
        l3 = 0L;
        if (l < j)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        l2 = 0L;
        s = m1;
        break MISSING_BLOCK_LABEL_271;
_L2:
        g.a().a(s2, l1, 0L, 0L, -7);
        throw s;
        obj;
        m1 = s;
        s = ((String) (obj));
_L5:
        s.printStackTrace();
        i = -8;
        if (l < j)
        {
            l1 = SystemClock.elapsedRealtime();
        } else
        {
            g.a().a(s2, l1, 0L, 0L, -8);
            throw s;
        }
        if (true) goto _L4; else goto _L3
_L3:
        m1;
        m1.printStackTrace();
        context = m1.getMessage();
        try
        {
            i = Integer.parseInt(context.replace("http status code error:", ""));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            i = -9;
        }
        g.a().a(s2, l1, 0L, 0L, i);
        throw m1;
        m1;
        m1.printStackTrace();
        throw m1;
        m1;
        m1.printStackTrace();
        g.a().a(s2, l1, 0L, 0L, -3);
        throw m1;
        m1;
        m1.printStackTrace();
        i = a(((IOException) (m1)));
        g.a().a(s2, l1, 0L, 0L, i);
        throw m1;
        s;
          goto _L5
        s;
        if (true) goto _L7; else goto _L6
_L6:
        for (i = l; false;)
        {
        }

        break MISSING_BLOCK_LABEL_222;
    }

    private static void a(Context context, m m1, String s)
    {
        if (s.indexOf("add_share") > -1 || s.indexOf("upload_pic") > -1 || s.indexOf("add_topic") > -1 || s.indexOf("set_user_face") > -1 || s.indexOf("add_t") > -1 || s.indexOf("add_pic_t") > -1 || s.indexOf("add_pic_url") > -1 || s.indexOf("add_video") > -1)
        {
            com.tencent.connect.a.a.a(context, m1, "requireApi", new String[] {
                s
            });
        }
    }

    public static void a(m m1, Context context, String s, Bundle bundle, String s1, com.tencent.tauth.a a1)
    {
        k.a("openSDK_LOG", "OpenApi requestAsync");
        (new Thread(m1, context, s, bundle, s1, a1) {

            final m a;
            final Context b;
            final String c;
            final Bundle d;
            final String e;
            final com.tencent.tauth.a f;

            public void run()
            {
                JSONObject jsonobject = com.tencent.open.utils.HttpUtils.a(a, b, c, d, e);
                if (f != null)
                {
                    f.a(jsonobject);
                    k.b("openSDK_LOG", "OpenApi onComplete");
                }
_L2:
                return;
                Object obj;
                obj;
                if (f == null) goto _L2; else goto _L1
_L1:
                f.a(((MalformedURLException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync MalformedURLException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L3
_L3:
                f.a(((ConnectTimeoutException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync onConnectTimeoutException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L4
_L4:
                f.a(((SocketTimeoutException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync onSocketTimeoutException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L5
_L5:
                f.a(((NetworkUnavailableException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync onNetworkUnavailableException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L6
_L6:
                f.a(((HttpStatusException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync onHttpStatusException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L7
_L7:
                f.a(((IOException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync IOException", ((Throwable) (obj)));
                return;
                obj;
                if (f == null) goto _L2; else goto _L8
_L8:
                f.a(((JSONException) (obj)));
                k.b("openSDK_LOG", "OpenApi requestAsync JSONException", ((Throwable) (obj)));
                return;
                obj;
                if (f != null)
                {
                    f.a(((Exception) (obj)));
                    k.b("openSDK_LOG", "OpenApi requestAsync onUnknowException", ((Throwable) (obj)));
                    return;
                }
                  goto _L2
            }

            
            {
                a = m1;
                b = context;
                c = s;
                d = bundle;
                e = s1;
                f = a1;
                super();
            }
        }).start();
    }

    private static int b(Context context)
    {
        int i = -1;
        if (android.os.Build.VERSION.SDK_INT >= 11) goto _L2; else goto _L1
_L1:
        if (context == null) goto _L4; else goto _L3
_L3:
        int l = Proxy.getPort(context);
        i = l;
        if (l < 0)
        {
            i = Proxy.getDefaultPort();
        }
_L6:
        return i;
_L4:
        return Proxy.getDefaultPort();
_L2:
        context = System.getProperty("http.proxyPort");
        if (!TextUtils.isEmpty(context))
        {
            int j;
            try
            {
                j = Integer.parseInt(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return -1;
            }
            return j;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static String c(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            if (context != null)
            {
                String s = Proxy.getHost(context);
                context = s;
                if (TextUtils.isEmpty(s))
                {
                    context = Proxy.getDefaultHost();
                }
                return context;
            } else
            {
                return Proxy.getDefaultHost();
            }
        } else
        {
            return System.getProperty("http.proxyHost");
        }
    }


    private class NetworkUnavailableException extends Exception
    {

        public NetworkUnavailableException(String s)
        {
            super(s);
        }
    }


    private class HttpStatusException extends Exception
    {

        public HttpStatusException(String s)
        {
            super(s);
        }
    }

}
