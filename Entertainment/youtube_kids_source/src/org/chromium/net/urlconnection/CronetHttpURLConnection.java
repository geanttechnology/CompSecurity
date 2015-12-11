// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net.urlconnection;

import android.util.Pair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.chromium.net.ResponseInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlRequestContext;
import org.chromium.net.UrlRequestException;

// Referenced classes of package org.chromium.net.urlconnection:
//            MessageLoop, CronetInputStream

public class CronetHttpURLConnection extends HttpURLConnection
{

    private final UrlRequestContext a;
    private final MessageLoop b = new MessageLoop();
    private final UrlRequest c;
    private final List d = new ArrayList();
    private CronetInputStream e;
    private ResponseInfo f;
    private UrlRequestException g;
    private ByteBuffer h;
    private boolean i;

    protected CronetHttpURLConnection(URL url, UrlRequestContext urlrequestcontext)
    {
        super(url);
        i = false;
        a = urlrequestcontext;
        c = a.a(url.toString(), new CronetUrlRequestListener(), b);
        e = new CronetInputStream(this);
    }

    private int a(String s)
    {
        for (int j = 0; j < d.size(); j++)
        {
            if (((String)((Pair)d.get(j)).first).equalsIgnoreCase(s))
            {
                return j;
            }
        }

        return -1;
    }

    static URL a(CronetHttpURLConnection cronethttpurlconnection, URL url)
    {
        cronethttpurlconnection.url = url;
        return url;
    }

    static ByteBuffer a(CronetHttpURLConnection cronethttpurlconnection, ByteBuffer bytebuffer)
    {
        cronethttpurlconnection.h = bytebuffer;
        return bytebuffer;
    }

    static ResponseInfo a(CronetHttpURLConnection cronethttpurlconnection, ResponseInfo responseinfo)
    {
        cronethttpurlconnection.f = responseinfo;
        return responseinfo;
    }

    static UrlRequestException a(CronetHttpURLConnection cronethttpurlconnection, UrlRequestException urlrequestexception)
    {
        cronethttpurlconnection.g = urlrequestexception;
        return urlrequestexception;
    }

    static MessageLoop a(CronetHttpURLConnection cronethttpurlconnection)
    {
        return cronethttpurlconnection.b;
    }

    private final void a(String s, String s1, boolean flag)
    {
label0:
        {
            if (connected)
            {
                throw new IllegalStateException("Cannot modify request property after connection is made.");
            }
            int j = a(s);
            if (j >= 0)
            {
                if (!flag)
                {
                    break label0;
                }
                d.remove(j);
            }
            d.add(Pair.create(s, s1));
            return;
        }
        throw new UnsupportedOperationException("Cannot add multiple headers of the same key. crbug.com/432719.");
    }

    static boolean a(CronetHttpURLConnection cronethttpurlconnection, boolean flag)
    {
        cronethttpurlconnection.i = true;
        return true;
    }

    static ByteBuffer b(CronetHttpURLConnection cronethttpurlconnection)
    {
        return cronethttpurlconnection.h;
    }

    private void b()
    {
        if (g != null)
        {
            throw g;
        }
        if (f == null)
        {
            throw new NullPointerException("Response info is null when there is no exception.");
        } else
        {
            return;
        }
    }

    static boolean c(CronetHttpURLConnection cronethttpurlconnection)
    {
        return cronethttpurlconnection.instanceFollowRedirects;
    }

    static UrlRequest d(CronetHttpURLConnection cronethttpurlconnection)
    {
        return cronethttpurlconnection.c;
    }

    static CronetInputStream e(CronetHttpURLConnection cronethttpurlconnection)
    {
        return cronethttpurlconnection.e;
    }

    final ByteBuffer a()
    {
        h = null;
        b.a();
        return h;
    }

    public final void addRequestProperty(String s, String s1)
    {
        a(s, s1, false);
    }

    public void connect()
    {
        if (connected)
        {
            b();
            return;
        }
        connected = true;
        Pair pair;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); c.a((String)pair.first, (String)pair.second))
        {
            pair = (Pair)iterator.next();
        }

        c.a();
        b.a();
        b();
    }

    public void disconnect()
    {
        if (connected)
        {
            try
            {
                e.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            e = null;
            c.b();
        }
    }

    public InputStream getErrorStream()
    {
        CronetInputStream cronetinputstream = null;
        try
        {
            connect();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        if (f.a() >= 400)
        {
            cronetinputstream = e;
        }
        return cronetinputstream;
    }

    public InputStream getInputStream()
    {
        connect();
        if (!instanceFollowRedirects && i)
        {
            throw new IOException("Cannot read response body of a redirect.");
        }
        if (f.a() >= 400)
        {
            throw new FileNotFoundException(url.toString());
        } else
        {
            return e;
        }
    }

    public Map getRequestProperties()
    {
        if (connected)
        {
            throw new IllegalStateException("Cannot access request headers after connection is set.");
        }
        TreeMap treemap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Pair pair;
        ArrayList arraylist;
        for (Iterator iterator = d.iterator(); iterator.hasNext(); treemap.put(pair.first, Collections.unmodifiableList(arraylist)))
        {
            pair = (Pair)iterator.next();
            if (treemap.containsKey(pair.first))
            {
                throw new IllegalStateException("Should not have multiple values.");
            }
            arraylist = new ArrayList();
            arraylist.add(pair.second);
        }

        return Collections.unmodifiableMap(treemap);
    }

    public String getRequestProperty(String s)
    {
        int j = a(s);
        if (j >= 0)
        {
            return (String)((Pair)d.get(j)).second;
        } else
        {
            return null;
        }
    }

    public int getResponseCode()
    {
        connect();
        return f.a();
    }

    public String getResponseMessage()
    {
        connect();
        return f.b();
    }

    public final void setRequestProperty(String s, String s1)
    {
        a(s, s1, true);
    }

    public boolean usingProxy()
    {
        return false;
    }

    private class CronetUrlRequestListener
        implements UrlRequestListener
    {

        private CronetHttpURLConnection a;

        private void a()
        {
            if (CronetHttpURLConnection.e(a) != null)
            {
                CronetHttpURLConnection.e(a).a = true;
            }
            CronetHttpURLConnection.a(a).b();
        }

        public final void a(ExtendedResponseInfo extendedresponseinfo)
        {
            CronetHttpURLConnection.a(a, extendedresponseinfo.a());
            a();
        }

        public final void a(ResponseInfo responseinfo)
        {
            CronetHttpURLConnection.a(a, responseinfo);
            CronetHttpURLConnection.a(a).b();
        }

        public final void a(ResponseInfo responseinfo, String s)
        {
            CronetHttpURLConnection.a(a, true);
            if (CronetHttpURLConnection.c(a))
            {
                try
                {
                    CronetHttpURLConnection.a(a, new URL(s));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ResponseInfo responseinfo)
                {
                    return;
                }
            } else
            {
                CronetHttpURLConnection.a(a, responseinfo);
                CronetHttpURLConnection.d(a).b();
                a();
                return;
            }
        }

        public final void a(ResponseInfo responseinfo, ByteBuffer bytebuffer)
        {
            CronetHttpURLConnection.a(a, responseinfo);
            CronetHttpURLConnection.a(a, ByteBuffer.allocate(bytebuffer.capacity()));
            CronetHttpURLConnection.b(a).put(bytebuffer);
            CronetHttpURLConnection.b(a).flip();
            CronetHttpURLConnection.a(a).b();
        }

        public final void a(ResponseInfo responseinfo, UrlRequestException urlrequestexception)
        {
            CronetHttpURLConnection.a(a, responseinfo);
            CronetHttpURLConnection.a(a, urlrequestexception);
            a();
        }

        public CronetUrlRequestListener()
        {
            a = CronetHttpURLConnection.this;
            super();
        }
    }

}
