// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.wantu.weibo.other.sina.WeiboException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
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

public class brq
{

    private static bru a = new bru();
    private static brk b;
    private static brp c = null;

    public static String a(Context context, String s, String s1, bru bru1, brp brp)
    {
        String s2 = "";
        for (int i = 0; i < bru1.a(); i++)
        {
            String s3 = bru1.a(i);
            if (s3.equals("pic"))
            {
                s2 = bru1.b(s3);
                bru1.a(s3);
            }
        }

        if (TextUtils.isEmpty(s2))
        {
            return a(context, s, s1, bru1, null, brp);
        } else
        {
            return a(context, s, s1, bru1, s2, brp);
        }
    }

    public static String a(Context context, String s, String s1, bru bru1, String s2, brp brp)
    {
        Object obj = null;
        HttpClient httpclient = a(context);
        if (!s1.equals("GET")) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s).append("?").append(b(bru1)).toString();
        context = new HttpGet(s);
_L5:
        a(s1, ((HttpUriRequest) (context)), bru1, s, brp);
        context = httpclient.execute(context);
        if (context.getStatusLine().getStatusCode() == 200) goto _L4; else goto _L3
_L3:
        s = a(((HttpResponse) (context)));
        context = obj;
        s1 = new JSONObject(s);
        context = obj;
        s = s1.getString("error");
        context = s;
        int i = s1.getInt("error_code");
        context = s;
_L7:
        try
        {
            throw new WeiboException(String.format(context, new Object[0]), i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new WeiboException(context);
        }
_L2:
        ByteArrayOutputStream bytearrayoutputstream;
        if (!s1.equals("POST"))
        {
            break MISSING_BLOCK_LABEL_274;
        }
        context = new HttpPost(s);
        bytearrayoutputstream = new ByteArrayOutputStream(51200);
        if (TextUtils.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        a(((OutputStream) (bytearrayoutputstream)), bru1);
        context.setHeader("Content-Type", "multipart/form-data; boundary=7cd4a6d158c");
        a(((OutputStream) (bytearrayoutputstream)), new File(s2));
_L6:
        s2 = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.close();
        context.setEntity(new ByteArrayEntity(s2));
          goto _L5
        context.setHeader("Content-Type", "application/x-www-form-urlencoded");
        bytearrayoutputstream.write(c(bru1).getBytes("UTF-8"));
          goto _L6
        if (!s1.equals("DELETE"))
        {
            break MISSING_BLOCK_LABEL_313;
        }
        context = new HttpDelete(s);
          goto _L5
        s;
        s.printStackTrace();
        i = 0;
          goto _L7
_L4:
        context = a(((HttpResponse) (context)));
        return context;
        context = null;
          goto _L5
    }

    private static String a(HttpResponse httpresponse)
    {
        byte abyte0[];
        HttpEntity httpentity = httpresponse.getEntity();
        ByteArrayOutputStream bytearrayoutputstream;
        int i;
        try
        {
            abyte0 = httpentity.getContent();
            bytearrayoutputstream = new ByteArrayOutputStream();
            httpresponse = httpresponse.getFirstHeader("Content-Encoding");
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new WeiboException(httpresponse);
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            throw new WeiboException(httpresponse);
        }
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        if (httpresponse.getValue().toLowerCase().indexOf("gzip") <= -1)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        httpresponse = new GZIPInputStream(abyte0);
_L2:
        abyte0 = new byte[512];
_L1:
        i = httpresponse.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        httpresponse = new String(bytearrayoutputstream.toByteArray());
        return httpresponse;
        httpresponse = abyte0;
          goto _L2
    }

    public static HttpClient a(Context context)
    {
        Object obj;
        Object obj2;
        try
        {
            obj = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) (obj)).load(null, null);
            Object obj1 = new brr(((KeyStore) (obj)));
            ((SSLSocketFactory) (obj1)).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            obj = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 10000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 10000);
            HttpProtocolParams.setVersion(((HttpParams) (obj)), HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(((HttpParams) (obj)), "UTF-8");
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj1)), 443));
            obj1 = new ThreadSafeClientConnManager(((HttpParams) (obj)), schemeregistry);
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 50000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 0x30d40);
            obj = new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj1)), ((HttpParams) (obj)));
            if (((WifiManager)context.getSystemService("wifi")).isWifiEnabled())
            {
                break MISSING_BLOCK_LABEL_257;
            }
            obj1 = Uri.parse("content://telephony/carriers/preferapn");
            context = context.getContentResolver().query(((Uri) (obj1)), null, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return new DefaultHttpClient();
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        if (!context.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_257;
        }
        obj2 = context.getString(context.getColumnIndex("proxy"));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        if (((String) (obj2)).trim().length() > 0)
        {
            obj2 = new HttpHost(((String) (obj2)), 80);
            ((HttpClient) (obj)).getParams().setParameter("http.route.default-proxy", obj2);
        }
        context.close();
        return ((HttpClient) (obj));
    }

    public static void a(brk brk1)
    {
        b = brk1;
    }

    public static void a(brp brp)
    {
        c = brp;
    }

    private static void a(OutputStream outputstream, bru bru1)
    {
        int i = 0;
        while (i < bru1.a()) 
        {
            String s = bru1.a(i);
            StringBuilder stringbuilder = new StringBuilder(10);
            stringbuilder.setLength(0);
            stringbuilder.append("--7cd4a6d158c").append("\r\n");
            stringbuilder.append("content-disposition: form-data; name=\"").append(s).append("\"\r\n\r\n");
            stringbuilder.append(bru1.b(s)).append("\r\n");
            byte abyte0[] = stringbuilder.toString().getBytes();
            try
            {
                outputstream.write(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream)
            {
                throw new WeiboException(outputstream);
            }
            i++;
        }
    }

    private static void a(OutputStream outputstream, File file)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("--7cd4a6d158c").append("\r\n");
        stringbuilder.append("Content-Disposition: form-data; name=\"pic\"; filename=\"").append("news_image").append("\"\r\n");
        stringbuilder.append("Content-Type: ").append("image/png").append("\r\n\r\n");
        byte abyte0[] = stringbuilder.toString().getBytes();
        int i;
        try
        {
            file = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (OutputStream outputstream)
        {
            throw new WeiboException(outputstream);
        }
        outputstream.write(abyte0);
        abyte0 = new byte[4096];
_L1:
        i = file.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        outputstream.write(abyte0, 0, i);
          goto _L1
        outputstream;
        throw new WeiboException(outputstream);
        outputstream;
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream)
            {
                throw new WeiboException(outputstream);
            }
        }
        throw outputstream;
        outputstream.write("\r\n".getBytes());
        outputstream.write("\r\n--7cd4a6d158c--".getBytes());
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        file.close();
        return;
        outputstream;
        throw new WeiboException(outputstream);
    }

    public static void a(String s, String s1)
    {
        a.a(s, s1);
    }

    public static void a(String s, HttpUriRequest httpurirequest, bru bru1, String s1, brp brp)
    {
        if (!a(a))
        {
            for (int i = 0; i < a.a(); i++)
            {
                String s2 = a.a(i);
                httpurirequest.setHeader(s2, a.b(s2));
            }

        }
        if (!a(bru1) && b != null)
        {
            s = b.a(s, s1, bru1, brt.b(), brt.c(), brp);
            if (s != null)
            {
                httpurirequest.setHeader("Authorization", s);
            }
        }
        httpurirequest.setHeader("User-Agent", (new StringBuilder()).append(System.getProperties().getProperty("http.agent")).append(" WeiboAndroidSDK").toString());
    }

    public static boolean a(bru bru1)
    {
        return bru1 == null || bru1.a() == 0;
    }

    public static char[] a(byte abyte0[])
    {
        char ac[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        char ac1[] = new char[((abyte0.length + 2) / 3) * 4];
        int i = 0;
        int j = 0;
        while (j < abyte0.length) 
        {
            int l = (abyte0[j] & 0xff) << 8;
            int k;
            int i1;
            if (j + 1 < abyte0.length)
            {
                l |= abyte0[j + 1] & 0xff;
                k = 1;
            } else
            {
                k = 0;
            }
            l <<= 8;
            if (j + 2 < abyte0.length)
            {
                l |= abyte0[j + 2] & 0xff;
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                i1 = l & 0x3f;
            } else
            {
                i1 = 64;
            }
            ac1[i + 3] = ac[i1];
            l >>= 6;
            if (k != 0)
            {
                k = l & 0x3f;
            } else
            {
                k = 64;
            }
            ac1[i + 2] = ac[k];
            k = l >> 6;
            ac1[i + 1] = ac[k & 0x3f];
            ac1[i + 0] = ac[k >> 6 & 0x3f];
            j += 3;
            i += 4;
        }
        return ac1;
    }

    public static String b(bru bru1)
    {
        if (bru1 == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        int i = 0;
        while (i < bru1.a()) 
        {
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((new StringBuilder()).append(URLEncoder.encode(bru1.a(i))).append("=").append(URLEncoder.encode(bru1.b(i))).toString());
            i++;
        }
        return stringbuilder.toString();
    }

    public static String c(bru bru1)
    {
        int i = 0;
        if (bru1 == null || a(bru1))
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        while (i < bru1.a()) 
        {
            String s = bru1.a(i);
            if (j != 0)
            {
                stringbuilder.append("&");
            }
            try
            {
                stringbuilder.append(URLEncoder.encode(s, "UTF-8")).append("=").append(URLEncoder.encode(bru1.b(s), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) { }
            j++;
            i++;
        }
        return stringbuilder.toString();
    }

}
