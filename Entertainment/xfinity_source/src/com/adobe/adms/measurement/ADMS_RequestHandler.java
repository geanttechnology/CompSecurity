// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.StrictHostnameVerifier;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_Measurement

final class ADMS_RequestHandler
{

    ADMS_RequestHandler()
    {
    }

    private static HttpURLConnection requestConnect(String s)
    {
        URL url;
        url = new URL(s);
        if (s.indexOf("https://") < 0)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        s = (HttpsURLConnection)url.openConnection();
        s.setHostnameVerifier(new StrictHostnameVerifier());
        return s;
        try
        {
            s = (HttpURLConnection)url.openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Exception opening URL : ").append(s.getMessage()).toString());
            return null;
        }
        return s;
    }

    protected static boolean sendRequest(String s, Hashtable hashtable)
    {
        boolean flag;
        flag = false;
        if (s == null)
        {
            return false;
        }
        HttpURLConnection httpurlconnection = requestConnect(s);
        if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
        httpurlconnection.setConnectTimeout(5000);
        httpurlconnection.setReadTimeout(5000);
        if (hashtable == null) goto _L4; else goto _L3
_L3:
        hashtable = hashtable.entrySet().iterator();
        do
        {
            if (!hashtable.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)hashtable.next();
            String s1 = (String)entry.getValue();
            if (s1.trim().length() > 0)
            {
                httpurlconnection.setRequestProperty((String)entry.getKey(), s1);
            }
        } while (true);
          goto _L4
        s;
        flag = false;
        ADMS_Measurement.sharedInstance().debugLog("Timed out sending request.");
_L2:
        return flag;
_L4:
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Request Sent : ").append(s).toString());
        httpurlconnection.getResponseCode();
        httpurlconnection.getInputStream().close();
        httpurlconnection.disconnect();
        flag = true;
        continue; /* Loop/switch isn't completed */
        s;
        flag = false;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("IOException while sending request, retrying. Exception: ").append(s.getMessage()).toString());
        continue; /* Loop/switch isn't completed */
        s;
        flag = true;
        ADMS_Measurement.sharedInstance().debugLog((new StringBuilder()).append("Exception while attempting to send hit : ").append(s.getMessage()).toString());
        if (true) goto _L2; else goto _L5
_L5:
    }
}
