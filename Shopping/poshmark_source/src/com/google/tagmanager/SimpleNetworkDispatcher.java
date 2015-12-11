// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// Referenced classes of package com.google.tagmanager:
//            Dispatcher, Log, Hit, NetworkReceiver

class SimpleNetworkDispatcher
    implements Dispatcher
{
    public static interface DispatchListener
    {

        public abstract void onHitDispatched(Hit hit);

        public abstract void onHitPermanentDispatchFailure(Hit hit);

        public abstract void onHitTransientDispatchFailure(Hit hit);
    }


    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s; %s Build/%s)";
    private final Context ctx;
    private DispatchListener dispatchListener;
    private final HttpClient httpClient;
    private final String userAgent;

    SimpleNetworkDispatcher(HttpClient httpclient, Context context, DispatchListener dispatchlistener)
    {
        ctx = context.getApplicationContext();
        userAgent = createUserAgentString("GoogleTagManager", "3.01", android.os.Build.VERSION.RELEASE, getUserAgentLanguage(Locale.getDefault()), Build.MODEL, Build.ID);
        httpClient = httpclient;
        dispatchListener = dispatchlistener;
    }

    private HttpEntityEnclosingRequest constructGtmRequest(URL url)
    {
        Object obj = null;
        url = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
        url.addHeader("User-Agent", userAgent);
        return url;
        url;
_L2:
        Log.w((new StringBuilder()).append("Exception sending hit: ").append(url.getClass().getSimpleName()).toString());
        Log.w(url.getMessage());
        return ((HttpEntityEnclosingRequest) (obj));
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        obj = url;
        url = urisyntaxexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static String getUserAgentLanguage(Locale locale)
    {
        while (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) 
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(locale.getLanguage().toLowerCase());
        if (locale.getCountry() != null && locale.getCountry().length() != 0)
        {
            stringbuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringbuilder.toString();
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

    public void dispatchHits(List list)
    {
        boolean flag1;
        int i;
        int j;
        j = Math.min(list.size(), 40);
        flag1 = true;
        i = 0;
_L2:
        Hit hit;
        Object obj1;
        boolean flag;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_473;
        }
        hit = (Hit)list.get(i);
        obj1 = getUrl(hit);
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Log.w("No destination: discarding hit.");
        dispatchListener.onHitPermanentDispatchFailure(hit);
        flag = flag1;
_L3:
        i++;
        flag1 = flag;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj;
label0:
        {
            obj = constructGtmRequest(((URL) (obj1)));
            if (obj != null)
            {
                break label0;
            }
            dispatchListener.onHitPermanentDispatchFailure(hit);
            flag = flag1;
        }
          goto _L3
        boolean flag2;
        obj1 = new HttpHost(((URL) (obj1)).getHost(), ((URL) (obj1)).getPort(), ((URL) (obj1)).getProtocol());
        ((HttpEntityEnclosingRequest) (obj)).addHeader("Host", ((HttpHost) (obj1)).toHostString());
        logDebugInformation(((HttpEntityEnclosingRequest) (obj)));
        flag = flag1;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        flag2 = flag1;
        NetworkReceiver.sendRadioPoweredBroadcast(ctx);
        flag = false;
        flag2 = flag;
        flag1 = flag;
        HttpClient httpclient = httpClient;
        flag2 = flag;
        flag1 = flag;
        if (httpclient instanceof HttpClient) goto _L5; else goto _L4
_L4:
        flag2 = flag;
        flag1 = flag;
        obj = httpclient.execute(((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj)));
_L6:
        flag2 = flag;
        flag1 = flag;
        int k = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        flag2 = flag;
        flag1 = flag;
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        flag2 = flag;
        flag1 = flag;
        ((HttpEntity) (obj1)).consumeContent();
        if (k == 200)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        flag2 = flag;
        flag1 = flag;
        Log.w((new StringBuilder()).append("Bad response: ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        flag2 = flag;
        flag1 = flag;
        try
        {
            dispatchListener.onHitTransientDispatchFailure(hit);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w("ClientProtocolException sending hit; discarding hit...");
            dispatchListener.onHitPermanentDispatchFailure(hit);
            flag = flag2;
        }
        catch (IOException ioexception)
        {
            Log.w((new StringBuilder()).append("Exception sending hit: ").append(ioexception.getClass().getSimpleName()).toString());
            Log.w(ioexception.getMessage());
            dispatchListener.onHitTransientDispatchFailure(hit);
            flag = flag1;
        }
          goto _L3
_L5:
        flag2 = flag;
        flag1 = flag;
        obj = HttpInstrumentation.execute((HttpClient)httpclient, ((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj)));
          goto _L6
        flag2 = flag;
        flag1 = flag;
        dispatchListener.onHitDispatched(hit);
          goto _L3
    }

    URL getUrl(Hit hit)
    {
        hit = hit.getHitUrl();
        try
        {
            hit = new URL(hit);
        }
        // Misplaced declaration of an exception variable
        catch (Hit hit)
        {
            Log.e("Error trying to parse the GTM url.");
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
}
