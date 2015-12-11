// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// Referenced classes of package com.google.analytics.tracking.android:
//            Dispatcher, GoogleAnalytics, Utils, Log, 
//            Hit, HitBuilder, GANetworkReceiver

class SimpleNetworkDispatcher
    implements Dispatcher
{

    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private GoogleAnalytics gaInstance;
    private final HttpClient httpClient;
    private URL mOverrideHostUrl;
    private final String userAgent;

    SimpleNetworkDispatcher(HttpClient httpclient, Context context)
    {
        this(httpclient, GoogleAnalytics.getInstance(context), context);
    }

    SimpleNetworkDispatcher(HttpClient httpclient, GoogleAnalytics googleanalytics, Context context)
    {
        ctx = context.getApplicationContext();
        userAgent = createUserAgentString("GoogleAnalytics", "3.0", android.os.Build.VERSION.RELEASE, Utils.getLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        httpClient = httpclient;
        gaInstance = googleanalytics;
    }

    private HttpEntityEnclosingRequest buildRequest(String s, String s1)
    {
        String s2;
        if (TextUtils.isEmpty(s))
        {
            Log.w("Empty hit, discarding.");
            return null;
        }
        s2 = (new StringBuilder()).append(s1).append("?").append(s).toString();
        if (s2.length() >= 2036) goto _L2; else goto _L1
_L1:
        s = new BasicHttpEntityEnclosingRequest("GET", s2);
_L4:
        s.addHeader("User-Agent", userAgent);
        return s;
_L2:
        s1 = new BasicHttpEntityEnclosingRequest("POST", s1);
        try
        {
            s1.setEntity(new StringEntity(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("Encoding error, discarding hit");
            return null;
        }
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void logDebugInformation(HttpEntityEnclosingRequest httpentityenclosingrequest)
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        org.apache.http.Header aheader[] = httpentityenclosingrequest.getAllHeaders();
        int k = aheader.length;
        for (int i = 0; i < k; i++)
        {
            stringbuffer.append(aheader[i].toString()).append("\n");
        }

        stringbuffer.append(httpentityenclosingrequest.getRequestLine().toString()).append("\n");
        if (httpentityenclosingrequest.getEntity() == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        httpentityenclosingrequest = httpentityenclosingrequest.getEntity().getContent();
        if (httpentityenclosingrequest == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        int j = httpentityenclosingrequest.available();
        if (j > 0)
        {
            try
            {
                byte abyte0[] = new byte[j];
                httpentityenclosingrequest.read(abyte0);
                stringbuffer.append("POST:\n");
                stringbuffer.append(new String(abyte0)).append("\n");
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntityEnclosingRequest httpentityenclosingrequest)
            {
                Log.v("Error Writing hit to log...");
            }
        }
        Log.v(stringbuffer.toString());
        return;
    }

    public void close()
    {
        httpClient.getConnectionManager().shutdown();
    }

    String createUserAgentString(String s, String s1, String s2, String s3, String s4, String s5)
    {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            s, s1, s2, s3, s4, s5
        });
    }

    public int dispatchHits(List list)
    {
        boolean flag;
        int j;
        int k;
        int l;
        k = 0;
        l = Math.min(list.size(), 40);
        flag = true;
        j = 0;
_L2:
        Object obj;
        Object obj2;
        int i;
        if (j >= l)
        {
            break MISSING_BLOCK_LABEL_475;
        }
        obj = (Hit)list.get(j);
        obj2 = getUrl(((Hit) (obj)));
        if (obj2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Log.isVerbose())
        {
            Log.w((new StringBuilder()).append("No destination: discarding hit: ").append(((Hit) (obj)).getHitParams()).toString());
        } else
        {
            Log.w("No destination: discarding hit.");
        }
        i = k + 1;
_L3:
        j++;
        k = i;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj1;
label0:
        {
            obj1 = new HttpHost(((URL) (obj2)).getHost(), ((URL) (obj2)).getPort(), ((URL) (obj2)).getProtocol());
            obj2 = ((URL) (obj2)).getPath();
            if (TextUtils.isEmpty(((Hit) (obj)).getHitParams()))
            {
                obj = "";
            } else
            {
                obj = HitBuilder.postProcessHit(((Hit) (obj)), System.currentTimeMillis());
            }
            obj2 = buildRequest(((String) (obj)), ((String) (obj2)));
            if (obj2 != null)
            {
                break label0;
            }
            i = k + 1;
        }
          goto _L3
        ((HttpEntityEnclosingRequest) (obj2)).addHeader("Host", ((HttpHost) (obj1)).toHostString());
        if (Log.isVerbose())
        {
            logDebugInformation(((HttpEntityEnclosingRequest) (obj2)));
        }
        if (((String) (obj)).length() > 8192)
        {
            Log.w("Hit too long (> 8192 bytes)--not sent");
        } else
        {
label1:
            {
                if (!gaInstance.isDryRunEnabled())
                {
                    break label1;
                }
                Log.i("Dry run enabled. Hit not actually sent.");
            }
        }
_L7:
        i = k + 1;
          goto _L3
        i = ((flag) ? 1 : 0);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        GANetworkReceiver.sendRadioPoweredBroadcast(ctx);
        i = 0;
        flag = i;
        obj = httpClient;
        flag = i;
        if (obj instanceof HttpClient) goto _L5; else goto _L4
_L4:
        flag = i;
        obj = ((HttpClient) (obj)).execute(((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj2)));
_L8:
        flag = i;
        int i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        flag = i;
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        flag = i;
        ((HttpEntity) (obj1)).consumeContent();
        flag = i;
        if (i1 == 200) goto _L7; else goto _L6
_L6:
        flag = i;
        Log.w((new StringBuilder()).append("Bad response: ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        flag = i;
          goto _L7
        obj;
        Log.w("ClientProtocolException sending hit; discarding hit...");
          goto _L7
_L5:
        flag = i;
        obj = HttpInstrumentation.execute((HttpClient)obj, ((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj2)));
          goto _L8
        list;
        Log.w((new StringBuilder()).append("Exception sending hit: ").append(list.getClass().getSimpleName()).toString());
        Log.w(list.getMessage());
        return k;
          goto _L7
    }

    URL getUrl(Hit hit)
    {
        if (mOverrideHostUrl != null)
        {
            return mOverrideHostUrl;
        }
        hit = hit.getHitUrlScheme();
        if ("http:".equals(hit))
        {
            hit = "http://www.google-analytics.com/collect";
        } else
        {
            hit = "https://ssl.google-analytics.com/collect";
        }
        try
        {
            hit = new URL(hit);
        }
        // Misplaced declaration of an exception variable
        catch (Hit hit)
        {
            Log.e("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
        return hit;
    }

    public boolean okToDispatch()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)ctx.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            Log.v("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

    public void overrideHostUrl(String s)
    {
        try
        {
            mOverrideHostUrl = new URL(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            mOverrideHostUrl = null;
        }
    }
}
