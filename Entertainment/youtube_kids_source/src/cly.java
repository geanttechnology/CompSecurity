// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.ConditionVariable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import org.chromium.net.HttpUrlRequest;
import org.chromium.net.HttpUrlRequestFactory;
import org.chromium.net.HttpUrlRequestListener;

public final class cly
    implements art, HttpUrlRequestListener
{

    private final HttpUrlRequestFactory a;
    private final atj b;
    private final asq c;
    private final int d;
    private final int e;
    private final ConditionVariable f = new ConditionVariable();
    private volatile HttpUrlRequest g;
    private clz h;
    private boolean i;

    public cly(HttpUrlRequestFactory httpurlrequestfactory, atj atj1, asq asq1, int j, int k)
    {
        a = (HttpUrlRequestFactory)b.a(httpurlrequestfactory);
        b = atj1;
        c = asq1;
        d = j;
        e = k;
    }

    static int a(cly cly1)
    {
        return cly1.e;
    }

    public final int a(byte abyte0[], int j, int k)
    {
        bne bne = bnc.a("Cronet read()");
        j = h.a(abyte0, j, k);
        if (c != null)
        {
            c.a(j);
        }
        bnc.a(bne);
        return j;
    }

    public final long a(arx arx1)
    {
        if (i)
        {
            bmo.b("Opening an already open source.");
        }
        bne bne = bnc.a("Cronet creating request");
        long l = arx1.d;
        long l1 = arx1.e;
        bmo.e((new StringBuilder(63)).append("Opening offset ").append(l).append(" length ").append(l1).toString());
        HashMap hashmap = new HashMap();
        l = arx1.d;
        String s = (new StringBuilder(27)).append("bytes=").append(l).append("-").toString();
        Object obj = s;
        if (arx1.e != -1L)
        {
            obj = String.valueOf(s);
            l = arx1.d;
            l1 = arx1.e;
            obj = (new StringBuilder(String.valueOf(obj).length() + 20)).append(((String) (obj))).append((l + l1) - 1L).toString();
        }
        hashmap.put("Range", obj);
        h = new clz(this);
        obj = h;
        g = a.a(arx1.a.toString(), 3, hashmap, ((java.nio.channels.WritableByteChannel) (obj)), this);
        bnc.a(bne);
        obj = bnc.a("Cronet connecting");
        f.close();
        g.c();
        if (!f.block(d))
        {
            throw new IOException("Timed out waiting for headers.");
        }
        bnc.a(((bne) (obj)));
        int j = g.b();
        if (j < 200 || j > 299)
        {
            throw new IOException((new StringBuilder(38)).append("Failed fetch, responseCode=").append(j).toString());
        }
        obj = g.e();
        if (b != null && !b.a(obj))
        {
            arx1 = String.valueOf(obj);
            if (arx1.length() != 0)
            {
                arx1 = "Unacceptable contentType: ".concat(arx1);
            } else
            {
                arx1 = new String("Unacceptable contentType: ");
            }
            throw new IOException(arx1);
        }
        l1 = g.a();
        if (arx1.e == -1L)
        {
            l = l1;
            if (l1 == -1L)
            {
                throw new IOException("Couldn't determine content length.");
            }
        } else
        if (l1 == -1L)
        {
            l = arx1.e;
        } else
        {
            l = l1;
            if (l1 != arx1.e)
            {
                throw new IOException("Server returned incorrect content length.");
            }
        }
        if (c != null)
        {
            c.b();
        }
        i = true;
        bmo.e((new StringBuilder(36)).append("Fetching ").append(l).append(" bytes.").toString());
        return l;
    }

    public final void a()
    {
        bmo.e("close() called");
        if (g != null)
        {
            g.d();
            g = null;
        }
        if (h != null)
        {
            h.close();
            clz clz1 = h;
            clz1.a.clear();
            clz1.b.clear();
            h = null;
        }
        if (i)
        {
            if (c != null)
            {
                c.c();
            }
            i = false;
        }
    }

    public final void a(HttpUrlRequest httpurlrequest)
    {
        if (g != httpurlrequest)
        {
            bmo.e("Request objects out of sync.");
            return;
        } else
        {
            f.open();
            return;
        }
    }

    public final void b(HttpUrlRequest httpurlrequest)
    {
        if (g != httpurlrequest)
        {
            bmo.e("Request objects out of sync.");
            return;
        } else
        {
            f.open();
            return;
        }
    }
}
