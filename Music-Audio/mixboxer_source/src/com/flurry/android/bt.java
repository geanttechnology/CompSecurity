// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            a, AppCloudResponseHandler, AppCloudResponseRequestManagerHandler, FlurryAppCloud, 
//            FlurryAppCloudRequestManager, AppCloudResponse, gq

final class bt extends a
{

    public bt()
        throws Exception
    {
    }

    private transient JSONObject a(HashMap ahashmap[])
    {
        try
        {
            c = (AppCloudResponseHandler)ahashmap[0].get("del");
            d = (AppCloudResponseRequestManagerHandler)ahashmap[0].get("del_internal");
            e = ahashmap[0];
            Object obj = new HttpPut((new StringBuilder()).append("https://").append(FlurryAppCloud.I()).append("/").append((String)ahashmap[0].get("url")).toString());
            a(((org.apache.http.message.AbstractHttpMessage) (obj)), ahashmap[0]);
            ((HttpPut) (obj)).setEntity(new UrlEncodedFormEntity((List)ahashmap[0].get("data")));
            HttpClient httpclient = a;
            org.apache.http.HttpHost httphost = b;
            BasicHttpContext basichttpcontext = new BasicHttpContext();
            if (!(httpclient instanceof HttpClient))
            {
                obj = httpclient.execute(httphost, ((org.apache.http.HttpRequest) (obj)), basichttpcontext);
            } else
            {
                obj = Instrumentation.execute(httpclient, httphost, ((org.apache.http.HttpRequest) (obj)), basichttpcontext);
            }
            obj = EntityUtils.toString(((HttpResponse) (obj)).getEntity()).toString();
            if (((String)ahashmap[0].get("url")).matches(".*v1/user/.*/logout.*"))
            {
                FlurryAppCloudRequestManager.UserSession = "";
            }
            return new JSONObject(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (HashMap ahashmap[])
        {
            ahashmap.printStackTrace();
        }
        return null;
    }

    protected final volatile Object doInBackground(Object aobj[])
    {
        return a((HashMap[])aobj);
    }

    protected final volatile void onPostExecute(Object obj)
    {
        obj = (JSONObject)obj;
        obj = new AppCloudResponse(((JSONObject) (obj)));
        if (d != null)
        {
            d.handleResponse(((AppCloudResponse) (obj)), c, gq.iS, e);
            return;
        }
        try
        {
            c.handleResponse(((AppCloudResponse) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
        }
        return;
    }
}
