// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.util.Log;
import com.fotoable.comlib.util.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class DownLoadFileTask extends AsyncTask
{

    private final String TAG = "DownLoaderTask";
    DownLoadFileTaskFinishedCallBack lisener;
    private String mUrl;

    public DownLoadFileTask(String s)
    {
        mUrl = s;
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
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
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
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
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
        }
        throw exception;
    }

    private String download()
    {
        Object obj;
        String s;
        s = "";
        HttpEntity httpentity;
        int i;
        try
        {
            obj = new HttpPost(mUrl);
            ((HttpPost) (obj)).setEntity(new UrlEncodedFormEntity(new ArrayList(), "UTF-8"));
            ((HttpPost) (obj)).setHeader("Content-Encoding", "gzip");
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            org.apache.http.params.HttpParams httpparams = defaulthttpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparams, 5000);
            HttpConnectionParams.setSoTimeout(httpparams, 5000);
            obj = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            exception = s;
            continue; /* Loop/switch isn't completed */
        }
        i = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        httpentity = ((HttpResponse) (obj)).getEntity();
        Log.v("DownLoaderTask", (new StringBuilder()).append("DownLoaderTask responseCode: ").append(i).toString());
        obj = s;
        if (i != 200)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        obj = s;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        obj = convertStreamToString(httpentity.getContent());
_L2:
        Log.v("DownLoaderTask", ((String) (obj)));
        return ((String) (obj));
        obj;
        ((IllegalStateException) (obj)).printStackTrace();
        obj = s;
        continue; /* Loop/switch isn't completed */
        obj;
        ((Exception) (obj)).printStackTrace();
        obj = s;
        continue; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        ioexception = s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        return download();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        if (lisener != null)
        {
            lisener.DownLoadFinished(s);
        }
    }

    protected void onPreExecute()
    {
    }

    protected transient void onProgressUpdate(Integer ainteger[])
    {
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Integer[])aobj);
    }

    public void setLisener(DownLoadFileTaskFinishedCallBack downloadfiletaskfinishedcallback)
    {
        lisener = downloadfiletaskfinishedcallback;
    }

    private class DownLoadFileTaskFinishedCallBack
    {

        public abstract void DownLoadFinished(String s);
    }

}
