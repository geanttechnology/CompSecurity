// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.flurry.android:
//            a, AppCloudResponseHandler, AppCloudResponseRequestManagerHandler, FlurryAppCloud, 
//            FlurryAppCloudRequestManager, AppCloudResponse, gq

final class fw extends a
{

    public fw()
        throws Exception
    {
    }

    private transient JSONObject a(HashMap ahashmap[])
    {
        Object obj;
        Object obj1;
        BasicHttpContext basichttpcontext;
        c = (AppCloudResponseHandler)ahashmap[0].get("del");
        d = (AppCloudResponseRequestManagerHandler)ahashmap[0].get("del_internal");
        e = ahashmap[0];
        obj1 = (new StringBuilder()).append("https://").append(FlurryAppCloud.I()).append("/").append((String)ahashmap[0].get("url")).toString();
        obj = new HttpGet(((String) (obj1)));
        Log.w("GET_OPERATION", (new StringBuilder()).append("URL = ").append(((String) (obj1))).toString());
        a(((org.apache.http.message.AbstractHttpMessage) (obj)), ahashmap[0]);
        ahashmap = a;
        obj1 = b;
        basichttpcontext = new BasicHttpContext();
        if (ahashmap instanceof HttpClient)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        ahashmap = ahashmap.execute(((org.apache.http.HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj)), basichttpcontext);
_L1:
        obj = new JSONObject(EntityUtils.toString(ahashmap.getEntity()).toString());
        ahashmap = ((HashMap []) (obj));
        if (((JSONObject) (obj)).getInt("code") == 400)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        ahashmap = ((HashMap []) (obj));
        if (!((JSONObject) (obj)).has("APPCLOUD_USER_SESSION"))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        FlurryAppCloudRequestManager.UserSession = ((JSONObject) (obj)).getString("APPCLOUD_USER_SESSION");
        return ((JSONObject) (obj));
        ahashmap = Instrumentation.execute(ahashmap, ((org.apache.http.HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj)), basichttpcontext);
          goto _L1
        ahashmap;
        ahashmap.printStackTrace();
        ahashmap = null;
        return ahashmap;
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
            d.handleResponse(((AppCloudResponse) (obj)), c, gq.iT, e);
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
