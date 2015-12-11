// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.flurry.android:
//            FlurryDataSenderHandler, ch

public class FlurryDataSenderAsyncOperation extends AsyncTask
{

    private String gh;
    private FlurryDataSenderHandler ix;

    public FlurryDataSenderAsyncOperation()
    {
        ix = null;
        gh = null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((HashMap[])aobj);
    }

    protected transient HttpResponse doInBackground(HashMap ahashmap[])
    {
        try
        {
            ix = (FlurryDataSenderHandler)ahashmap[0].get("del");
            gh = (String)ahashmap[0].get("id");
            Object obj = (String)ahashmap[0].get("url");
            ByteArrayEntity bytearrayentity = new ByteArrayEntity((byte[])(byte[])ahashmap[0].get("data"));
            bytearrayentity.setContentType("application/octet-stream");
            ahashmap = new HttpPost(((String) (obj)));
            ahashmap.setEntity(bytearrayentity);
            obj = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 10000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 15000);
            ahashmap.getParams().setBooleanParameter("http.protocol.expect-continue", false);
            obj = ch.a(((HttpParams) (obj)));
            if (!(obj instanceof HttpClient))
            {
                return ((HttpClient) (obj)).execute(ahashmap);
            }
            ahashmap = Instrumentation.execute(((HttpClient) (obj)), ahashmap);
        }
        // Misplaced declaration of an exception variable
        catch (HashMap ahashmap[])
        {
            ahashmap.printStackTrace();
            return null;
        }
        return ahashmap;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((HttpResponse)obj);
    }

    protected void onPostExecute(HttpResponse httpresponse)
    {
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        if (httpresponse.getStatusLine() != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        ix.onServerError(gh);
        return;
        try
        {
            httpresponse = httpresponse.getStatusLine();
            int i = httpresponse.getStatusCode();
            httpresponse = httpresponse.getReasonPhrase();
            ix.onResponse(i, httpresponse, gh);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            httpresponse.printStackTrace();
        }
        return;
    }
}
