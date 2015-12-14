// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import com.wantu.weibo.other.tencent.beans.QImageParameter;
import com.wantu.weibo.other.tencent.beans.QParameter;
import java.io.File;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class zo
{

    public zo()
    {
    }

    public String a(String s, String s1)
    {
        Object obj1;
        obj1 = null;
        String s2 = s;
        if (s1 != null)
        {
            s2 = s;
            if (!s1.equals(""))
            {
                s2 = (new StringBuilder()).append(s).append("?").append(s1).toString();
            }
        }
        s1 = a();
        s = new HttpGet(s2);
        Object obj = s1.execute(s);
        s = obj1;
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj = ((HttpResponse) (obj)).getEntity();
        s = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = EntityUtils.toString(((org.apache.http.HttpEntity) (obj)));
        s1.getConnectionManager().shutdown();
        return s;
        s;
        Crashlytics.logException(s);
        throw new Exception(s);
        s;
        s1.getConnectionManager().shutdown();
        throw s;
    }

    public String a(String s, String s1, List list)
    {
        HttpClient httpclient;
        aii aii1;
label0:
        {
            s = (new StringBuilder()).append(s).append('?').append(s1).toString();
            httpclient = a();
            s = new HttpPost(s);
            try
            {
                aii1 = new aii();
                QParameter qparameter;
                aio aio1;
                for (s1 = zp.a(s1).iterator(); s1.hasNext(); aii1.a(qparameter.getName(), aio1))
                {
                    qparameter = (QParameter)s1.next();
                    aio1 = new aio(zp.b(qparameter.getValue()), Charset.forName("UTF-8"));
                }

                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                httpclient.getConnectionManager().shutdown();
                throw s;
            }
        }
        Crashlytics.logException(s);
        throw new Exception(s);
        Object obj;
        for (s1 = list.iterator(); s1.hasNext(); aii1.a(((String) (obj)), new ain(list, ((String) (obj)), "image/jpeg", "utf-8")))
        {
            obj = (QParameter)s1.next();
            list = new File(((QParameter) (obj)).getValue());
            obj = ((QParameter) (obj)).getName();
        }

        s.setEntity(aii1);
        s = httpclient.execute(s);
        if (s.getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        s = s.getEntity();
        if (s == null) goto _L2; else goto _L3
_L3:
        s = EntityUtils.toString(s);
_L5:
        httpclient.getConnectionManager().shutdown();
        return s;
_L2:
        s = null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public HttpClient a()
    {
        Object obj;
        try
        {
            obj = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) (obj)).load(null, null);
            obj = new zm(((KeyStore) (obj)));
            ((SSLSocketFactory) (obj)).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams basichttpparams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
            HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
            SchemeRegistry schemeregistry = new SchemeRegistry();
            schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeregistry.register(new Scheme("https", ((org.apache.http.conn.scheme.SocketFactory) (obj)), 443));
            obj = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            return new DefaultHttpClient();
        }
        return ((HttpClient) (obj));
    }

    public String b(String s, String s1, List list)
    {
        HttpClient httpclient;
        aii aii1;
label0:
        {
            s = (new StringBuilder()).append(s).append('?').append(s1).toString();
            httpclient = a();
            s = new HttpPost(s);
            try
            {
                aii1 = new aii();
                QParameter qparameter;
                aio aio1;
                for (s1 = zp.a(s1).iterator(); s1.hasNext(); aii1.a(qparameter.getName(), aio1))
                {
                    qparameter = (QParameter)s1.next();
                    aio1 = new aio(zp.b(qparameter.getValue()), Charset.forName("UTF-8"));
                }

                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            finally
            {
                httpclient.getConnectionManager().shutdown();
                throw s;
            }
        }
        Crashlytics.logException(s);
        throw new Exception(s);
        aik aik1;
        for (s1 = list.iterator(); s1.hasNext(); aii1.a(list.getName(), aik1))
        {
            list = (QImageParameter)s1.next();
            aik1 = new aik(list.getValue(), list.getName());
        }

        s.setEntity(aii1);
        s = httpclient.execute(s);
        if (s.getStatusLine().getStatusCode() != 200) goto _L2; else goto _L1
_L1:
        s = s.getEntity();
        if (s == null) goto _L2; else goto _L3
_L3:
        s = EntityUtils.toString(s);
_L5:
        httpclient.getConnectionManager().shutdown();
        return s;
_L2:
        s = null;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
