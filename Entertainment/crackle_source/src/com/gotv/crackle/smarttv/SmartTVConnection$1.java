// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import com.gotv.crackle.util.Log;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVConnection

class val.JSONString
    implements Runnable
{

    final SmartTVConnection this$0;
    final String val$JSONString;
    final String val$locationURL;

    public void run()
    {
        Object obj;
        String s;
        Object obj1;
        DefaultHttpClient defaulthttpclient;
        Object obj2;
        defaulthttpclient = new DefaultHttpClient();
        obj2 = new HttpGet(val$locationURL);
        obj1 = null;
        s = null;
        obj = obj1;
        obj2 = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
        obj = obj1;
        ((HttpResponse) (obj2)).getStatusLine().getStatusCode();
        JVM INSTR tableswitch 200 200: default 397
    //                   200 241;
           goto _L1 _L2
_L1:
        obj = obj1;
        obj1 = (new StringBuilder()).append("http://").append(SmartTVConnection.access$100(SmartTVConnection.this).getHost()).append("/ws/app/").toString();
_L4:
        obj = obj1;
        Log.d("SmartTVConnection", (new StringBuilder()).append("CONNECT STATUS: ").append(((HttpResponse) (obj2)).getStatusLine().getStatusCode()).toString());
        obj = obj1;
_L6:
        Exception exception1;
        Header aheader[];
        int i;
        int j;
        try
        {
            obj = new HttpPost((new StringBuilder()).append(((String) (obj))).append("Crackle").toString());
            ((HttpPost) (obj)).setHeader("SLDeviceID", "CrackleDevice");
            ((HttpPost) (obj)).setHeader("User-Agent", "Android-Tablet");
            ((HttpPost) (obj)).setEntity(new StringEntity(val$JSONString));
            i = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj))).getStatusLine().getStatusCode();
        }
        catch (Exception exception)
        {
            Log.e("SmartTVConnection", (new StringBuilder()).append("Launch Message Error: ").append(exception.getMessage()).toString());
            return;
        }
        switch (i)
        {
        case 201: 
        default:
            return;
        }
_L2:
        obj = obj1;
        aheader = ((HttpResponse) (obj2)).getHeaders("Application-URL");
        obj = obj1;
        j = aheader.length;
        i = 0;
_L5:
        obj1 = s;
        if (i >= j) goto _L4; else goto _L3
_L3:
        obj1 = aheader[i];
        obj = s;
        Log.d("SmartTVConnection", (new StringBuilder()).append(((Header) (obj1)).getName()).append(" = ").append(((Header) (obj1)).getValue()).toString());
        obj = s;
        s = ((Header) (obj1)).getValue();
        i++;
          goto _L5
        exception1;
        Log.e("SmartTVConnection", (new StringBuilder()).append("CONNECT ERROR: ").append(exception1.getMessage()).toString());
          goto _L6
    }

    ()
    {
        this$0 = final_smarttvconnection;
        val$locationURL = s;
        val$JSONString = String.this;
        super();
    }
}
