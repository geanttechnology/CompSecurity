// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
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
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// Referenced classes of package android.support.v7:
//            aam, abo, aaz, abt

class adf
    implements aam
{
    public static interface a
    {

        public abstract void a(aaz aaz1);

        public abstract void b(aaz aaz1);

        public abstract void c(aaz aaz1);
    }


    private final String a;
    private final HttpClient b;
    private final Context c;
    private a d;

    adf(HttpClient httpclient, Context context, a a1)
    {
        c = context.getApplicationContext();
        a = a("GoogleTagManager", "4.00", android.os.Build.VERSION.RELEASE, a(Locale.getDefault()), Build.MODEL, Build.ID);
        b = httpclient;
        d = a1;
    }

    static String a(Locale locale)
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

    private HttpEntityEnclosingRequest a(URL url)
    {
        url = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
        url.addHeader("User-Agent", a);
        return url;
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        url = null;
_L2:
        abo.b((new StringBuilder()).append("Exception sending hit: ").append(urisyntaxexception.getClass().getSimpleName()).toString());
        abo.b(urisyntaxexception.getMessage());
        return url;
        urisyntaxexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(HttpEntityEnclosingRequest httpentityenclosingrequest)
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
                abo.d("Error Writing hit to log...");
            }
        }
        abo.d(stringbuffer.toString());
        return;
    }

    String a(String s, String s1, String s2, String s3, String s4, String s5)
    {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            s, s1, s2, s3, s4, s5
        });
    }

    URL a(aaz aaz1)
    {
        aaz1 = aaz1.c();
        try
        {
            aaz1 = new URL(aaz1);
        }
        // Misplaced declaration of an exception variable
        catch (aaz aaz1)
        {
            abo.a("Error trying to parse the GTM url.");
            return null;
        }
        return aaz1;
    }

    public void a(List list)
    {
        boolean flag;
        int i;
        int j;
        j = Math.min(list.size(), 40);
        flag = true;
        i = 0;
_L2:
        aaz aaz1;
        Object obj;
        Object obj1;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aaz1 = (aaz)list.get(i);
        obj1 = a(aaz1);
        if (obj1 == null)
        {
            abo.b("No destination: discarding hit.");
            d.b(aaz1);
        } else
        {
label0:
            {
                obj = a(((URL) (obj1)));
                if (obj != null)
                {
                    break label0;
                }
                d.b(aaz1);
            }
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        boolean flag1;
        boolean flag2;
        obj1 = new HttpHost(((URL) (obj1)).getHost(), ((URL) (obj1)).getPort(), ((URL) (obj1)).getProtocol());
        ((HttpEntityEnclosingRequest) (obj)).addHeader("Host", ((HttpHost) (obj1)).toHostString());
        a(((HttpEntityEnclosingRequest) (obj)));
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        flag2 = flag;
        abt.b(c);
        flag1 = false;
        flag2 = flag1;
        flag = flag1;
        obj = b.execute(((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj)));
        flag2 = flag1;
        flag = flag1;
        int k = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        flag2 = flag1;
        flag = flag1;
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        flag2 = flag1;
        flag = flag1;
        ((HttpEntity) (obj1)).consumeContent();
        if (k == 200)
        {
            break MISSING_BLOCK_LABEL_311;
        }
        flag2 = flag1;
        flag = flag1;
        abo.b((new StringBuilder()).append("Bad response: ").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        flag2 = flag1;
        flag = flag1;
        try
        {
            d.c(aaz1);
            break MISSING_BLOCK_LABEL_406;
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            abo.b("ClientProtocolException sending hit; discarding hit...");
            d.b(aaz1);
            flag = flag2;
        }
        catch (IOException ioexception)
        {
            abo.b((new StringBuilder()).append("Exception sending hit: ").append(ioexception.getClass().getSimpleName()).toString());
            abo.b(ioexception.getMessage());
            d.c(aaz1);
        }
          goto _L3
        flag2 = flag1;
        flag = flag1;
        d.a(aaz1);
        break MISSING_BLOCK_LABEL_406;
_L1:
        return;
        flag = flag1;
          goto _L3
    }

    public boolean a()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            abo.d("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }
}
