// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.task;

import android.os.Process;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.Consts;
import com.igexin.sdk.encrypt.RC4Carder;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public abstract class HttpTask extends Thread
{

    public static HttpClient httpClient;
    protected CallbackListener callbackListener;
    private byte data[];
    private boolean isEncrypt;
    public HttpRequestBase request;
    private String url;

    public HttpTask(String s, byte abyte0[], CallbackListener callbacklistener)
    {
        isEncrypt = false;
        callbackListener = null;
        url = s;
        data = abyte0;
        callbackListener = callbacklistener;
    }

    public HttpTask(String s, byte abyte0[], CallbackListener callbacklistener, boolean flag)
    {
        isEncrypt = false;
        callbackListener = null;
        url = s;
        data = abyte0;
        callbackListener = callbacklistener;
        isEncrypt = flag;
    }

    public void httpExecuteData()
    {
        int i;
        httpClient = new DefaultHttpClient();
        i = 0;
_L2:
        if (i >= 3)
        {
            break; /* Loop/switch isn't completed */
        }
        HttpResponse httpresponse;
        httpresponse = httpClient.execute(request);
        if (httpresponse.getStatusLine().getStatusCode() == 200)
        {
            parseData(EntityUtils.toByteArray(httpresponse.getEntity()));
            return;
        }
        if (i == 2)
        {
            try
            {
                if (callbackListener != null)
                {
                    callbackListener.exceptionHandler(new Exception((new StringBuilder()).append("Http response code is : ").append(httpresponse.getStatusLine().getStatusCode()).toString()));
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                if (i == 2 && callbackListener != null)
                {
                    callbackListener.exceptionHandler(exception);
                }
            }
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public abstract void parseData(byte abyte0[]);

    public final void run()
    {
        super.run();
        Process.setThreadPriority(10);
        if (data == null)
        {
            request = new HttpGet(url);
            httpExecuteData();
            return;
        }
        HttpPost httppost = new HttpPost(url);
        request = httppost;
        if (isEncrypt)
        {
            request.addHeader("EncryptType", "RC4");
            request.addHeader("AppKey", Consts.VPUSH_APPKEY);
            data = RC4Carder.Encrypt(data, Consts.VPUSH_APPSECRET);
            System.out.println((new StringBuilder()).append("isEncrypt...data = ").append(new String(data)).toString());
        }
        httppost.setEntity(new InputStreamEntity(new ByteArrayInputStream(data), data.length));
        httpExecuteData();
    }
}
