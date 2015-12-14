// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.sina.WeiboException;
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
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

public class bsf
{

    public bsf()
    {
    }

    public String a(String s, String s1)
    {
        Object obj;
        obj = null;
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
        int i;
        s = s1.execute(s);
        i = s.getStatusLine().getStatusCode();
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        org.apache.http.HttpEntity httpentity = s.getEntity();
        s = obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s = EntityUtils.toString(httpentity);
        s1.getConnectionManager().shutdown();
        return s;
        throw new WeiboException("QQ Status Code Not 200", i);
        s;
        throw s;
        s;
        s1.getConnectionManager().shutdown();
        throw s;
        s;
        throw new Exception(s);
    }

    public String a(String s, String s1, List list)
    {
        HttpClient httpclient;
        s = (new StringBuilder()).append(s).append('?').append(s1).toString();
        httpclient = a();
        s = new HttpPost(s);
        MultipartEntity multipartentity;
        multipartentity = new MultipartEntity();
        QParameter qparameter;
        StringBody stringbody;
        for (s1 = bsg.a(s1).iterator(); s1.hasNext(); multipartentity.addPart(qparameter.getName(), stringbody))
        {
            qparameter = (QParameter)s1.next();
            stringbody = new StringBody(bsg.b(qparameter.getValue()), Charset.forName("UTF-8"));
        }

        break MISSING_BLOCK_LABEL_133;
        s;
        throw s;
        s;
        httpclient.getConnectionManager().shutdown();
        throw s;
        Object obj;
        for (s1 = list.iterator(); s1.hasNext(); multipartentity.addPart(((String) (obj)), new FileBody(list, ((String) (obj)), "image/jpeg", "utf-8")))
        {
            obj = (QParameter)s1.next();
            list = new File(((QParameter) (obj)).getValue());
            obj = ((QParameter) (obj)).getName();
        }

        break MISSING_BLOCK_LABEL_214;
        s;
        throw new Exception(s);
        int i;
        s.setEntity(multipartentity);
        s = httpclient.execute(s);
        i = s.getStatusLine().getStatusCode();
        if (i != 200) goto _L2; else goto _L1
_L1:
        s = s.getEntity();
        if (s == null) goto _L4; else goto _L3
_L3:
        s = EntityUtils.toString(s);
_L6:
        httpclient.getConnectionManager().shutdown();
        return s;
_L2:
        throw new WeiboException("QQ Status Code Not 200", i);
_L4:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public HttpClient a()
    {
        Object obj;
        try
        {
            obj = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore) (obj)).load(null, null);
            obj = new bsc(((KeyStore) (obj)));
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
            return new DefaultHttpClient();
        }
        return ((HttpClient) (obj));
    }

    public String b(String s, String s1, List list)
    {
        HttpClient httpclient;
        s = (new StringBuilder()).append(s).append('?').append(s1).toString();
        httpclient = a();
        s = new HttpPost(s);
        MultipartEntity multipartentity;
        multipartentity = new MultipartEntity();
        QParameter qparameter;
        StringBody stringbody;
        for (s1 = bsg.a(s1).iterator(); s1.hasNext(); multipartentity.addPart(qparameter.getName(), stringbody))
        {
            qparameter = (QParameter)s1.next();
            stringbody = new StringBody(bsg.b(qparameter.getValue()), Charset.forName("UTF-8"));
        }

        break MISSING_BLOCK_LABEL_133;
        s;
        throw s;
        s;
        httpclient.getConnectionManager().shutdown();
        throw s;
        ByteArrayBody bytearraybody;
        for (s1 = list.iterator(); s1.hasNext(); multipartentity.addPart(list.getName(), bytearraybody))
        {
            list = (QImageParameter)s1.next();
            bytearraybody = new ByteArrayBody(list.getValue(), list.getName());
        }

        break MISSING_BLOCK_LABEL_200;
        s;
        throw new Exception(s);
        int i;
        s.setEntity(multipartentity);
        s = httpclient.execute(s);
        i = s.getStatusLine().getStatusCode();
        if (i != 200) goto _L2; else goto _L1
_L1:
        s = s.getEntity();
        if (s == null) goto _L4; else goto _L3
_L3:
        s = EntityUtils.toString(s);
_L6:
        httpclient.getConnectionManager().shutdown();
        return s;
_L2:
        throw new WeiboException("QQ Status Code Not 200", i);
_L4:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
