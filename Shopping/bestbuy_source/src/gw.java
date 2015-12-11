// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class gw
{

    private static String a = gw.getSimpleName();
    private static DefaultHttpClient b;
    private static HttpResponse c;

    public gw()
    {
    }

    public static String a(String s, String s1, String s2, String s3, Map map)
    {
        return a(c(s, s1, s2, s3, map));
    }

    public static String a(String s, String s1, Map map)
    {
        return a(s, "", "", s1, map);
    }

    private static String a(String s, List list)
    {
        if (list == null)
        {
            return s;
        }
        StringBuffer stringbuffer = new StringBuffer();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (NameValuePair)list.next();
            String s1 = ((NameValuePair) (obj)).getName().replace(" ", "%20").replace("&", "+");
            obj = ((NameValuePair) (obj)).getValue().replace(" ", "%20");
            stringbuffer.append((new StringBuilder()).append(s1).append("=").append(((String) (obj))).toString());
            if (list.hasNext())
            {
                stringbuffer.append("&");
            }
        } while (true);
        if (s.contains("?"))
        {
            return (new StringBuilder()).append(s).append("&").append(stringbuffer).toString();
        } else
        {
            return (new StringBuilder()).append(s).append("?").append(stringbuffer).toString();
        }
    }

    public static String a(String s, List list, List list1, String s1)
    {
        return a(a(s, "", "", list, list1, s1, gx.a, true, "application/json"));
    }

    public static String a(String s, List list, List list1, String s1, boolean flag)
    {
        return a(a(s, "", "", list, list1, s1, gx.a, flag, "application/xml"));
    }

    private static String a(HttpResponse httpresponse)
    {
        String s1 = "";
        Header header = httpresponse.getFirstHeader("Content-Encoding");
        HttpEntity httpentity = httpresponse.getEntity();
        String s = s1;
        if (httpentity != null)
        {
            s = s1;
            if (httpentity.isStreaming())
            {
                int i = httpresponse.getStatusLine().getStatusCode();
                if (i == 409 || i == 403 || i == 401 || i == 412)
                {
                    httpentity.consumeContent();
                    return (new StringBuilder()).append("").append(i).toString();
                }
                httpresponse = httpentity.getContent();
                if (header != null && header.getValue().equalsIgnoreCase("gzip"))
                {
                    gs.b(a, "Using GZIP");
                    httpresponse = new GZIPInputStream(httpresponse);
                }
                try
                {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    a(((InputStream) (httpresponse)), ((OutputStream) (bytearrayoutputstream)));
                    httpresponse.close();
                    s = new String(bytearrayoutputstream.toByteArray());
                    bytearrayoutputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpResponse httpresponse)
                {
                    gs.e(a, (new StringBuilder()).append("Error converting response input stream to byte array to a string: ").append(httpresponse.getLocalizedMessage()).toString());
                    throw httpresponse;
                }
            }
        }
        httpentity.consumeContent();
        return s;
    }

    private static HttpResponse a(String s, String s1, String s2, List list, List list1, String s3, gx gx1, boolean flag, 
            String s4)
    {
        Object obj;
        Object obj1;
        if (b == null)
        {
            b = a();
        }
        obj1 = null;
        obj = null;
        if (gx1 != gx.b && gx1 != gx.c) goto _L2; else goto _L1
_L1:
label0:
        {
            NameValuePair namevaluepair;
            if (gx1 == gx.b)
            {
                obj = new HttpPost(s);
            } else
            if (gx1 == gx.c)
            {
                obj = new HttpPut(s);
            }
            if (list != null)
            {
                ((HttpEntityEnclosingRequestBase)obj).setEntity(new UrlEncodedFormEntity(list));
            }
            obj1 = obj;
            if (s3 != null)
            {
                obj1 = new StringEntity(s3, "UTF-8");
                ((StringEntity) (obj1)).setContentType(s4);
                ((HttpEntityEnclosingRequestBase)obj).setEntity(((HttpEntity) (obj1)));
                s4 = s;
                break label0;
            }
        }
          goto _L3
_L2:
        if (gx1 == gx.d)
        {
            obj = new HttpDelete(s);
            s4 = s;
            continue; /* Loop/switch isn't completed */
        }
        if (gx1 != gx.a) goto _L3; else goto _L4
_L4:
        Iterator iterator;
        String s5;
        try
        {
            obj1 = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.e(a, (new StringBuilder()).append("Exception Caught while creating HttpGet: ").append(s.getLocalizedMessage()).toString());
            throw s;
        }
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_422;
        }
        iterator = list.iterator();
_L5:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_422;
        }
        s4 = (NameValuePair)iterator.next();
        s5 = s4.getName().replace(" ", "%20").replace("&", "+");
        obj = s4.getValue().replace(" ", "%20");
        s4 = ((String) (obj));
        if (!s5.equals("sort"))
        {
            s4 = ((String) (obj)).replace("&", "+");
        }
        ((StringBuffer) (obj1)).append((new StringBuilder()).append(s5).append("=").append(s4).toString());
        if (iterator.hasNext())
        {
            ((StringBuffer) (obj1)).append("&");
        }
          goto _L5
        obj = s.replace(" ", "%20");
        s4 = ((String) (obj));
        if (((StringBuffer) (obj1)).length() > 0)
        {
            s4 = a(((String) (obj)), list);
        }
        obj = new HttpGet(s4);
        continue; /* Loop/switch isn't completed */
_L7:
        if (flag && list1 != null)
        {
            for (obj1 = list1.iterator(); ((Iterator) (obj1)).hasNext(); ((HttpRequestBase) (obj)).addHeader(namevaluepair.getName(), namevaluepair.getValue()))
            {
                namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
            }

        }
        if (gx1 != gx.a)
        {
            if (list1 != null)
            {
                for (list1 = list1.iterator(); list1.hasNext(); ((HttpRequestBase) (obj)).addHeader(((NameValuePair) (obj1)).getName(), ((NameValuePair) (obj1)).getValue()))
                {
                    obj1 = (NameValuePair)list1.next();
                }

            }
            if (s.contains("/cartitems/cart/"))
            {
                gt.a(b);
            }
        }
        gs.b(a, (new StringBuilder()).append("APIRequest:makeRequest(): METHOD: ").append(gx1.a()).append(" URL: ").append(s4).append(" VALUE-PAIRS: ").append(list).toString());
        if (((HttpRequestBase) (obj)).getAllHeaders() != null)
        {
            gs.b(a, "APIRequest: Request Header");
            s = ((HttpRequestBase) (obj)).getAllHeaders();
            for (int i = 0; i < s.length; i++)
            {
                gs.b(a, (new StringBuilder()).append("name: ").append(s[i].getName()).append(" value: ").append(s[i].getValue()).toString());
            }

        }
        if (s3 != null && s3.compareTo("") != 0)
        {
            s = ((HttpEntityEnclosingRequestBase)obj).getEntity().getContent();
            for (list = (new Scanner(s)).useDelimiter("\\A"); list.hasNext(); gs.b(a, (new StringBuilder()).append("APIRequest - RequestBody: ").append(list.next()).toString())) { }
            s.close();
        }
        if (obj != null)
        {
            ((HttpRequestBase) (obj)).addHeader("Accept-Encoding", "gzip");
        }
        if (s1 != null && !s1.isEmpty() && s2 != null && !s2.isEmpty())
        {
            s = new AuthScope(AuthScope.ANY_HOST, -1);
            s1 = new UsernamePasswordCredentials(s1, s2);
            b.getCredentialsProvider().setCredentials(s, s1);
        }
        if (true)
        {
            c = p.a(b, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
        } else
        {
            c = p.a(b, ((org.apache.http.client.methods.HttpUriRequest) (obj)), null);
        }
        if (c != null)
        {
            int j = c.getStatusLine().getStatusCode();
            gs.b(a, (new StringBuilder()).append("Response Status Code: ").append(j).toString());
            if (c.getStatusLine() != null)
            {
                gs.a(a, (new StringBuilder()).append("Status Message: ").append(c.getStatusLine().getReasonPhrase()).toString());
            } else
            {
                gs.a(a, "Status or response was null");
            }
            if (j == 409 || j == 403 || j == 401 || j == 412 || s4.contains("/cartitems/cart/"))
            {
                return c;
            }
            if (j >= 400)
            {
                if (c != null)
                {
                    s = EntityUtils.toString(c.getEntity());
                } else
                {
                    s = "";
                }
                c.getEntity().consumeContent();
                throw new Exception((new StringBuilder()).append("Status Code: ").append(j).append("\n\nResponse:").append(c.toString()).append("\n\nResponse Body:").append(s).toString());
            }
            gs.b(a, (new StringBuilder()).append("APIRequest:makeRequest() - Response: ").append(null).toString());
        }
        return c;
_L3:
        s4 = s;
        obj = obj1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static HttpResponse a(String s, List list, List list1, String s1, String s2)
    {
        return a(s, "", "", list, list1, s1, gx.b, false, s2);
    }

    public static DefaultHttpClient a()
    {
        if (b == null)
        {
            BasicHttpParams basichttpparams = new BasicHttpParams();
            Object obj = System.getProperty("http.agent");
            HttpProtocolParams.setUseExpectContinue(basichttpparams, false);
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "utf-8");
            HttpProtocolParams.setUserAgent(basichttpparams, (new StringBuilder()).append("buyphone/").append(fs.a).append(" ").append(((String) (obj))).toString());
            basichttpparams.setBooleanParameter("http.protocol.expect-continue", true);
            basichttpparams.setBooleanParameter("http.keepAlive", true);
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 30000);
            HttpConnectionParams.setSoTimeout(basichttpparams, 30000);
            HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
            obj = new SchemeRegistry();
            ((SchemeRegistry) (obj)).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            SSLSocketFactory sslsocketfactory = SSLSocketFactory.getSocketFactory();
            sslsocketfactory.setHostnameVerifier((X509HostnameVerifier)SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            ((SchemeRegistry) (obj)).register(new Scheme("https", sslsocketfactory, 443));
            obj = new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj)));
            ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(5000));
            ConnManagerParams.setMaxTotalConnections(basichttpparams, 5000);
            b = new DefaultHttpClient(((org.apache.http.conn.ClientConnectionManager) (obj)), basichttpparams);
        }
        return b;
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0, 0, 1024);
            if (i == -1)
            {
                outputstream.flush();
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    public static String b(String s, List list, List list1, String s1, String s2)
    {
        return a(a(s, "", "", list, list1, s1, gx.b, false, s2));
    }

    public static String b(String s, List list, List list1, String s1, boolean flag)
    {
        return a(a(s, "", "", list, list1, s1, gx.c, flag, "application/json"));
    }

    public static Map b(String s, String s1, String s2, String s3, Map map)
    {
        s = c(s, s1, s2, s3, map).getAllHeaders();
        s1 = new HashMap();
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            s2 = s[i];
            s1.put(s2.getName(), s2.getValue());
        }

        return s1;
    }

    public static String c(String s, List list, List list1, String s1, String s2)
    {
        return a(a(s, "", "", list, list1, s1, gx.a, false, s2));
    }

    public static String c(String s, List list, List list1, String s1, boolean flag)
    {
        return a(a(s, "", "", list, list1, s1, gx.d, flag, "application/json"));
    }

    public static HttpResponse c(String s, String s1, String s2, String s3, Map map)
    {
        if (s3 != null)
        {
            s = (new StringBuilder()).append(s).append("/").append(s3).toString();
        }
        s3 = new ArrayList();
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); s3.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        return a(s, s1, s2, s3, null, null, gx.a, false, "application/xml");
    }

}
