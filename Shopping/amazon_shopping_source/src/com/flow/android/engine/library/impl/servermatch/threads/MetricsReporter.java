// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.impl.servermatch.threads;

import android.os.Build;
import com.flow.android.engine.library.FlowStateEngineMetrics;
import com.flow.android.engine.library.impl.servermatch.ClientDeviceInfo;
import com.flow.android.engine.library.impl.servermatch.HttpManagerInterface;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.flow.android.engine.library.impl.servermatch.threads:
//            FlowServerRequestThread, ThreadPoolManagerInterface

public class MetricsReporter extends FlowServerRequestThread
{

    private static Object mMetricsReportingLock = new Object();
    private FlowStateEngineMetrics mEngineMetrics;

    public MetricsReporter(HttpManagerInterface httpmanagerinterface, ThreadPoolManagerInterface threadpoolmanagerinterface, ClientDeviceInfo clientdeviceinfo, String s, com.a9.vs.mobile.library.impl.jni.ServerResponse.Type type, ByteArrayInputStream bytearrayinputstream, FlowStateEngineMetrics flowstateenginemetrics)
    {
        super(httpmanagerinterface, threadpoolmanagerinterface, clientdeviceinfo, s, type, bytearrayinputstream, null, null);
        mEngineMetrics = flowstateenginemetrics;
    }

    private void sendMetricsToServer()
    {
        JSONObject jsonobject;
        Object obj;
        Object obj1;
        jsonobject = new JSONObject();
        obj = new JSONObject();
        obj1 = new JSONObject();
        Object obj2 = mDeviceInfo.getClientVersion();
        jsonobject.put("DEVICE_ID", mDeviceInfo.getClientDeviceId());
        jsonobject.put("MODEL", Build.MODEL);
        jsonobject.put("PLATFORM_VERSION", (new StringBuilder()).append("").append(android.os.Build.VERSION.SDK_INT).toString());
        jsonobject.put("PLATFORM", "Android");
        jsonobject.put("Marketplace", 1);
        jsonobject.put("SESSION_ID", mDeviceInfo.getClientId());
        jsonobject.put("APP_VERSION", obj2);
        jsonobject.put("Program", "Amazon");
        jsonobject.put("TIMESTAMP", System.currentTimeMillis());
        jsonobject.put("Operation", (new StringBuilder()).append("Amazon").append(((String) (obj2))).append("Metrics").append("Android").toString());
        if (mEngineMetrics == null)
        {
            break MISSING_BLOCK_LABEL_440;
        }
        obj2 = mEngineMetrics.getCounters();
        String s;
        for (Iterator iterator = ((Map) (obj2)).keySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put(s, ((Map) (obj2)).get(s)))
        {
            s = (String)iterator.next();
        }

        Map map = mEngineMetrics.getTiming();
        String s1;
        for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext(); ((JSONObject) (obj1)).put(s1, map.get(s1)))
        {
            s1 = (String)iterator1.next();
        }

        try
        {
            if (((JSONObject) (obj)).length() != 0)
            {
                jsonobject.put("counters", obj);
            }
            if (((JSONObject) (obj1)).length() != 0)
            {
                jsonobject.put("timing", obj1);
            }
            obj = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 5000);
            obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
            obj1 = new HttpPost(mApplicationURL);
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(new BasicNameValuePair("DATA", jsonobject.toString()));
            ((HttpPost) (obj1)).setEntity(new UrlEncodedFormEntity(arraylist));
            ((HttpClient) (obj)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
            return;
        }
        catch (JSONException jsonexception) { }
        catch (ClientProtocolException clientprotocolexception)
        {
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void run()
    {
        synchronized (mMetricsReportingLock)
        {
            sendMetricsToServer();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
