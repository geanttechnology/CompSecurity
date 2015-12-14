// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.brightroll.androidsdk;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

// Referenced classes of package com.brightroll.androidsdk:
//            AsyncHttpRequestDelegate

public class AsyncHttpRequest extends AsyncTask
{

    AsyncHttpRequestDelegate _flddelegate;
    Exception exception;
    HttpResponse response;
    String responseContent;
    int timeout;
    String url;

    public AsyncHttpRequest()
    {
    }

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        HttpGet httpget;
        avoid = AndroidHttpClient.newInstance("BrightRoll Android SDK");
        httpget = new HttpGet(url);
        response = avoid.execute(httpget);
        if (response == null)
        {
            throw new Exception("response is null");
        }
          goto _L1
        Exception exception2;
        exception2;
        exception = exception2;
        httpget.abort();
        avoid.close();
_L4:
        return null;
_L1:
        InputStream inputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        inputstream = response.getEntity().getContent();
        bytearrayoutputstream = new ByteArrayOutputStream();
_L2:
        int i = inputstream.read();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        responseContent = bytearrayoutputstream.toString("UTF8");
        avoid.close();
        continue; /* Loop/switch isn't completed */
        bytearrayoutputstream.write(i);
          goto _L2
        Exception exception1;
        exception1;
        avoid.close();
        throw exception1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public AsyncHttpRequestDelegate getDelegate()
    {
        return _flddelegate;
    }

    public Exception getException()
    {
        return exception;
    }

    public HttpResponse getResponse()
    {
        return response;
    }

    public String getResponseContent()
    {
        return responseContent;
    }

    public int getTimeout()
    {
        return timeout;
    }

    public String getUrl()
    {
        return url;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        if (exception == null)
        {
            _flddelegate.asyncHttpRequestCompleted(this);
            return;
        } else
        {
            exception.printStackTrace();
            _flddelegate.asyncHttpRequestFailed(this);
            return;
        }
    }

    public void setDelegate(AsyncHttpRequestDelegate asynchttprequestdelegate)
    {
        _flddelegate = asynchttprequestdelegate;
    }

    public void setTimeout(int i)
    {
        timeout = i;
    }

    public void setUrl(String s)
    {
        url = s;
    }

    public void start()
    {
        execute(new Void[0]);
    }
}
