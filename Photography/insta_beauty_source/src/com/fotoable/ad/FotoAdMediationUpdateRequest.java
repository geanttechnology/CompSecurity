// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.os.Handler;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class FotoAdMediationUpdateRequest
{

    public static final String KFixedAdUrl = "http://fotorus.fotoable.com/fotorus/?m=ADconf&a=get&os=android";
    private ExecutorService executorService;
    private final Handler handler = new Handler();
    protected int timeout;

    public FotoAdMediationUpdateRequest()
    {
        timeout = 50000;
        executorService = Executors.newFixedThreadPool(1);
    }

    private String convertStreamToString(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        Crashlytics.logException(ioexception);
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            Crashlytics.logException(inputstream);
        }
        throw exception;
    }

    private String downloadFromUrl(String s)
    {
        Object obj = new DefaultHttpClient();
        HttpConnectionParams.setSoTimeout(((HttpClient) (obj)).getParams(), timeout);
        int i;
        try
        {
            obj = ((HttpClient) (obj)).execute(new HttpGet(s));
            Log.v("Mehtod_Get url:", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        s = ((HttpResponse) (obj)).getEntity();
        if (i != 200 || s == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s = convertStreamToString(s.getContent());
        return s;
        s;
        s.printStackTrace();
        Crashlytics.logException(s);
        return null;
        s;
        s.printStackTrace();
        Crashlytics.logException(s);
        return null;
    }

    public void download(final String url, final requestCallback callback)
    {
        final WeakReference callbackWeakRef = new WeakReference(callback);
        executorService.submit(new _cls1());
    }



    private class _cls1
        implements Runnable
    {

        final FotoAdMediationUpdateRequest this$0;
        final requestCallback val$callback;
        final WeakReference val$callbackWeakRef;
        final String val$url;

        public void run()
        {
            try
            {
                final String rtncontent = downloadFromUrl(url);
                class _cls1
                    implements Runnable
                {

                    final _cls1 this$1;
                    final String val$rtncontent;

                    public void run()
                    {
                        if (callbackWeakRef.get() == null)
                        {
                            return;
                        }
                        if (rtncontent == null)
                        {
                            Error error1 = new Error("error");
                            ((requestCallback)callbackWeakRef.get()).onRequestError(error1);
                            return;
                        } else
                        {
                            ((requestCallback)callbackWeakRef.get()).onRequestSuccess(rtncontent);
                            return;
                        }
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    rtncontent = s;
                    super();
                }

                    private class requestCallback
                    {

                        public abstract void onRequestError(Error error);

                        public abstract void onRequestSuccess(String s);
                    }

                }

                handler.post(new _cls1());
                return;
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            final Error error = new Error("error");
            class _cls2
                implements Runnable
            {

                final _cls1 this$1;
                final Error val$error;

                public void run()
                {
                    callback.onRequestError(error);
                }

                _cls2()
                {
                    this$1 = _cls1.this;
                    error = error1;
                    super();
                }
            }

            handler.post(new _cls2());
        }

        _cls1()
        {
            this$0 = FotoAdMediationUpdateRequest.this;
            url = s;
            callbackWeakRef = weakreference;
            callback = requestcallback;
            super();
        }
    }

}
