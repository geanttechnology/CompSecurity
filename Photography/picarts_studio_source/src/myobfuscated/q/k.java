// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.q;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import myobfuscated.aj.d;
import myobfuscated.aj.f;
import myobfuscated.v.t;
import myobfuscated.v.u;

// Referenced classes of package myobfuscated.q:
//            b, l, c

public final class k
    implements b
{

    private static l a = new l((byte)0);
    private final t b;
    private final int c;
    private final l d;
    private HttpURLConnection e;
    private InputStream f;
    private volatile boolean g;

    public k(t t1)
    {
        this(t1, a);
    }

    private k(t t1, l l1)
    {
        b = t1;
        c = 2500;
        d = l1;
    }

    private InputStream a(URL url, int i, URL url1, Map map)
    {
        int j;
        do
        {
            if (i >= 5)
            {
                throw new HttpException("Too many (> 5) redirects!");
            }
            if (url1 != null)
            {
                try
                {
                    if (url.toURI().equals(url1.toURI()))
                    {
                        throw new HttpException("In re-direct loop");
                    }
                }
                // Misplaced declaration of an exception variable
                catch (URL url1) { }
            }
            e = (HttpURLConnection)url.openConnection();
            java.util.Map.Entry entry;
            for (url1 = map.entrySet().iterator(); url1.hasNext(); e.addRequestProperty((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)url1.next();
            }

            e.setConnectTimeout(2500);
            e.setReadTimeout(2500);
            e.setUseCaches(false);
            e.setDoInput(true);
            e.connect();
            if (g)
            {
                return null;
            }
            j = e.getResponseCode();
            if (j / 100 == 2)
            {
                url = e;
                if (TextUtils.isEmpty(url.getContentEncoding()))
                {
                    i = url.getContentLength();
                    f = myobfuscated.aj.d.a(url.getInputStream(), i);
                } else
                {
                    if (Log.isLoggable("HttpUrlFetcher", 3))
                    {
                        (new StringBuilder("Got non empty content encoding: ")).append(url.getContentEncoding());
                    }
                    f = url.getInputStream();
                }
                return f;
            }
            if (j / 100 != 3)
            {
                break;
            }
            url1 = e.getHeaderField("Location");
            if (TextUtils.isEmpty(url1))
            {
                throw new HttpException("Received empty or null redirect url");
            }
            URL url2 = new URL(url, url1);
            i++;
            url1 = url;
            url = url2;
        } while (true);
        if (j == -1)
        {
            throw new HttpException(j);
        } else
        {
            throw new HttpException(e.getResponseMessage(), j);
        }
    }

    public final void a()
    {
        if (f != null)
        {
            try
            {
                f.close();
            }
            catch (IOException ioexception) { }
        }
        if (e != null)
        {
            e.disconnect();
        }
    }

    public final void a(Priority priority, c c1)
    {
        long l1 = myobfuscated.aj.f.a();
        String s;
        t t1;
        try
        {
            t1 = b;
            if (t1.f != null)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            if (!TextUtils.isEmpty(t1.e))
            {
                break MISSING_BLOCK_LABEL_65;
            }
            s = t1.d;
        }
        // Misplaced declaration of an exception variable
        catch (Priority priority)
        {
            Log.isLoggable("HttpUrlFetcher", 3);
            c1.a(priority);
            return;
        }
        priority = s;
        if (TextUtils.isEmpty(s))
        {
            priority = t1.c.toString();
        }
        t1.e = Uri.encode(priority, "@#&=*+-_.,:!?()/~'%");
        t1.f = new URL(t1.e);
        priority = a(t1.f, 0, null, b.b.a());
        if (Log.isLoggable("HttpUrlFetcher", 2))
        {
            (new StringBuilder("Finished http url fetcher fetch in ")).append(myobfuscated.aj.f.a(l1)).append(" ms and loaded ").append(priority);
        }
        c1.a(priority);
        return;
    }

    public final void b()
    {
        g = true;
    }

    public final DataSource c()
    {
        return DataSource.REMOTE;
    }

    public final Class d()
    {
        return java/io/InputStream;
    }

}
