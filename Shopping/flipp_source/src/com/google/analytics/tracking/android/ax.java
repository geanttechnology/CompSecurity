// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
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
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

// Referenced classes of package com.google.analytics.tracking.android:
//            p, ak, ba, al, 
//            an, r

final class ax
    implements p
{

    private final String a;
    private final HttpClient b;
    private final Context c;
    private ak d;
    private URL e;

    ax(HttpClient httpclient, Context context)
    {
        this(httpclient, ak.a(context), context);
    }

    private ax(HttpClient httpclient, ak ak1, Context context)
    {
        c = context.getApplicationContext();
        a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[] {
            "GoogleAnalytics", "3.0", android.os.Build.VERSION.RELEASE, ba.a(Locale.getDefault()), Build.MODEL, Build.ID
        });
        b = httpclient;
        d = ak1;
    }

    private URL a(al al1)
    {
        if (e != null)
        {
            return e;
        }
        al1 = al1.d;
        if ("http:".equals(al1))
        {
            al1 = "http://www.google-analytics.com/collect";
        } else
        {
            al1 = "https://ssl.google-analytics.com/collect";
        }
        try
        {
            al1 = new URL(al1);
        }
        // Misplaced declaration of an exception variable
        catch (al al1)
        {
            an.a("Error trying to parse the hardcoded host url. This really shouldn't happen.");
            return null;
        }
        return al1;
    }

    private HttpEntityEnclosingRequest a(String s, String s1)
    {
        String s2;
        if (TextUtils.isEmpty(s))
        {
            an.d("Empty hit, discarding.");
            return null;
        }
        s2 = (new StringBuilder()).append(s1).append("?").append(s).toString();
        if (s2.length() >= 2036) goto _L2; else goto _L1
_L1:
        s = new BasicHttpEntityEnclosingRequest("GET", s2);
_L4:
        s.addHeader("User-Agent", a);
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
            an.d("Encoding error, discarding hit");
            return null;
        }
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void a(HttpEntityEnclosingRequest httpentityenclosingrequest)
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
            break MISSING_BLOCK_LABEL_138;
        }
        httpentityenclosingrequest = httpentityenclosingrequest.getEntity().getContent();
        if (httpentityenclosingrequest == null)
        {
            break MISSING_BLOCK_LABEL_138;
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
                an.c("Error Writing hit to log...");
            }
        }
        an.c(stringbuffer.toString());
        return;
    }

    public final int a(List list)
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
        Object obj1;
        Object obj2;
        int i;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (al)list.get(j);
        obj2 = a(((al) (obj)));
        if (obj2 == null)
        {
            if (an.a())
            {
                an.d((new StringBuilder("No destination: discarding hit: ")).append(((al) (obj)).a).toString());
            } else
            {
                an.d("No destination: discarding hit.");
            }
            i = k + 1;
        } else
        {
label0:
            {
                obj1 = new HttpHost(((URL) (obj2)).getHost(), ((URL) (obj2)).getPort(), ((URL) (obj2)).getProtocol());
                obj2 = ((URL) (obj2)).getPath();
                if (TextUtils.isEmpty(((al) (obj)).a))
                {
                    obj = "";
                } else
                {
                    long l1 = System.currentTimeMillis();
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append(((al) (obj)).a);
                    if (((al) (obj)).c > 0L)
                    {
                        l1 -= ((al) (obj)).c;
                        if (l1 >= 0L)
                        {
                            stringbuilder.append("&qt=").append(l1);
                        }
                    }
                    stringbuilder.append("&z=").append(((al) (obj)).b);
                    obj = stringbuilder.toString();
                }
                obj2 = a(((String) (obj)), ((String) (obj2)));
                if (obj2 != null)
                {
                    break label0;
                }
                i = k + 1;
            }
        }
_L3:
        j++;
        k = i;
        if (true) goto _L2; else goto _L1
        ((HttpEntityEnclosingRequest) (obj2)).addHeader("Host", ((HttpHost) (obj1)).toHostString());
        if (an.a())
        {
            a(((HttpEntityEnclosingRequest) (obj2)));
        }
        if (((String) (obj)).length() > 8192)
        {
            an.d("Hit too long (> 8192 bytes)--not sent");
        } else
        {
label1:
            {
                if (!d.b())
                {
                    break label1;
                }
                an.b("Dry run enabled. Hit not actually sent.");
            }
        }
_L5:
        i = k + 1;
          goto _L3
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        r.a(c);
        i = 0;
_L7:
        int i1;
        obj = b.execute(((HttpHost) (obj1)), ((org.apache.http.HttpRequest) (obj2)));
        i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
        obj1 = ((HttpResponse) (obj)).getEntity();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        ((HttpEntity) (obj1)).consumeContent();
        flag = i;
        if (i1 == 200) goto _L5; else goto _L4
_L4:
        an.d((new StringBuilder("Bad response: ")).append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        flag = i;
          goto _L5
        ClientProtocolException clientprotocolexception;
        clientprotocolexception;
        flag = i;
_L6:
        an.d("ClientProtocolException sending hit; discarding hit...");
          goto _L5
        list;
        an.d((new StringBuilder("Exception sending hit: ")).append(list.getClass().getSimpleName()).toString());
        an.d(list.getMessage());
        return k;
_L1:
        return k;
        clientprotocolexception;
          goto _L6
        i = ((flag) ? 1 : 0);
          goto _L7
    }

    public final void a(String s)
    {
        try
        {
            e = new URL(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            e = null;
        }
    }

    public final boolean a()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)c.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            an.c("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }
}
