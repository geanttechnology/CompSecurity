// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.google.tagmanager:
//            NetworkClient, Log

class HttpNetworkClient
    implements NetworkClient
{

    private HttpClient mClient;

    HttpNetworkClient()
    {
    }

    private void closeWithClient(HttpClient httpclient)
    {
        if (httpclient != null && httpclient.getConnectionManager() != null)
        {
            httpclient.getConnectionManager().shutdown();
        }
    }

    private InputStream handleServerResponse(HttpClient httpclient, HttpResponse httpresponse)
        throws IOException
    {
        int i = httpresponse.getStatusLine().getStatusCode();
        if (i == 200)
        {
            Log.v("Success response");
            return httpresponse.getEntity().getContent();
        }
        httpclient = (new StringBuilder()).append("Bad response: ").append(i).toString();
        if (i == 404)
        {
            throw new FileNotFoundException(httpclient);
        } else
        {
            throw new IOException(httpclient);
        }
    }

    public void close()
    {
        closeWithClient(mClient);
    }

    HttpClient createNewHttpClient()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        return new DefaultHttpClient(basichttpparams);
    }

    HttpPost createPostRequest(String s, byte abyte0[])
    {
        s = new HttpPost(s);
        s.setEntity(new ByteArrayEntity(abyte0));
        return s;
    }

    public InputStream getInputStream(String s)
        throws IOException
    {
        mClient = createNewHttpClient();
        HttpClient httpclient = mClient;
        s = new HttpGet(s);
        if (!(httpclient instanceof HttpClient))
        {
            s = httpclient.execute(s);
        } else
        {
            s = HttpInstrumentation.execute((HttpClient)httpclient, s);
        }
        return handleServerResponse(mClient, s);
    }

    public void sendPostRequest(String s, byte abyte0[])
        throws IOException
    {
        HttpClient httpclient = createNewHttpClient();
        s = createPostRequest(s, abyte0);
        if (!(httpclient instanceof HttpClient))
        {
            s = httpclient.execute(s);
        } else
        {
            s = HttpInstrumentation.execute((HttpClient)httpclient, s);
        }
        handleServerResponse(httpclient, s);
        closeWithClient(httpclient);
    }
}
