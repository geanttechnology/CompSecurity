// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            a, AppCloudResponseHandler, AppCloudResponseRequestManagerHandler, FlurryAppCloud, 
//            AppCloudResponse, gq

final class fb extends a
{

    public fb()
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
            HttpDelete httpdelete = new HttpDelete((new StringBuilder()).append("https://").append(FlurryAppCloud.I()).append("/").append((String)ahashmap[0].get("url")).toString());
            a(((org.apache.http.message.AbstractHttpMessage) (httpdelete)), ahashmap[0]);
            ahashmap = a;
            org.apache.http.HttpHost httphost = b;
            BasicHttpContext basichttpcontext = new BasicHttpContext();
            if (!(ahashmap instanceof HttpClient))
            {
                ahashmap = ahashmap.execute(httphost, httpdelete, basichttpcontext);
            } else
            {
                ahashmap = Instrumentation.execute(ahashmap, httphost, httpdelete, basichttpcontext);
            }
            return new JSONObject(EntityUtils.toString(ahashmap.getEntity()).toString());
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
            d.handleResponse(((AppCloudResponse) (obj)), c, gq.iU, e);
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
