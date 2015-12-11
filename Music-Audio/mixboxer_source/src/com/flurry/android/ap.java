// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import com.flurry.org.apache.http.entity.mime.HttpMultipartMode;
import com.flurry.org.apache.http.entity.mime.MultipartEntity;
import com.flurry.org.apache.http.entity.mime.content.FileBody;
import com.flurry.org.apache.http.entity.mime.content.StringBody;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            a, AppCloudResponseHandler, AppCloudResponseRequestManagerHandler, FlurryAppCloud, 
//            AppCloudResponse, gq

final class ap extends a
{

    public ap()
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
            HttpPost httppost = new HttpPost((new StringBuilder()).append("https://").append(FlurryAppCloud.I()).append("/").append((String)ahashmap[0].get("url")).toString());
            a(((org.apache.http.message.AbstractHttpMessage) (httppost)), ahashmap[0]);
            httppost.setEntity(c((List)ahashmap[0].get("data")));
            ahashmap = a;
            org.apache.http.HttpHost httphost = b;
            BasicHttpContext basichttpcontext = new BasicHttpContext();
            if (!(ahashmap instanceof HttpClient))
            {
                ahashmap = ahashmap.execute(httphost, httppost, basichttpcontext);
            } else
            {
                ahashmap = Instrumentation.execute(ahashmap, httphost, httppost, basichttpcontext);
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

    private static MultipartEntity c(List list)
        throws Exception
    {
        MultipartEntity multipartentity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
        int i = 0;
        while (i < list.size()) 
        {
            if (((NameValuePair)list.get(i)).getName().equals("file"))
            {
                String as[] = ((NameValuePair)list.get(i)).getValue().split("/");
                String s = as[as.length - 1];
                multipartentity.addPart("file", new FileBody(new File(((NameValuePair)list.get(i)).getValue()), s, "application/octet-stream", "utf-8"));
            } else
            {
                String s1 = ((NameValuePair)list.get(i)).getName();
                if (s1 != "filename" && s1 != "file")
                {
                    multipartentity.addPart(s1, new StringBody(((NameValuePair)list.get(i)).getValue()));
                }
            }
            i++;
        }
        return multipartentity;
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
            d.handleResponse(((AppCloudResponse) (obj)), c, gq.iR, e);
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
