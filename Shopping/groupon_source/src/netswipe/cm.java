// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.nio.charset.Charset;
import java.util.concurrent.TimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package netswipe:
//            cu, cl, di, de, 
//            dq, dn, dv, ds, 
//            ck

class cm extends cu
{

    final cl a;
    private byte c[];
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public cm(cl cl1, String s, byte abyte0[], String s1, String s2, String s3, String s4)
    {
        a = cl1;
        super();
        c = null;
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        c = abyte0;
        d = s1;
        e = s2;
        f = s3;
        g = s4;
        h = s;
    }

    protected transient Boolean a(Void avoid[])
    {
        b = new HttpPost((new StringBuilder()).append(cl.b()).append("/").append(h).append("/").append(di.a(new byte[] {
            1, -114, -15, 83, -71, 50
        }, 0xb6f50d13ca3403c7L)).toString());
        b.setHeader("Authorization", (new StringBuilder()).append("Basic ").append(cl.a(a)).toString());
        b.setHeader("Accept", "application/json");
        b.setHeader("User-Agent", "Jumio Netswipe Android SDK 2.0.3");
        avoid = new de();
        Object obj = new de();
        ((de) (obj)).put("cameraPosition", d);
        ((de) (obj)).put("orientationMode", e);
        ((de) (obj)).put("imageSize", f);
        ((de) (obj)).put("flashMode", g);
        avoid.put("cameraDeviceDetail", obj);
        obj = new dq(dn.b);
        ((dq) (obj)).a("cameraDeviceDetail", new dv(avoid.toString(), "application/json", Charset.defaultCharset()));
        ((dq) (obj)).a("image", new ds(c, "image/webp", "rawImage"));
        ((HttpPost)b).setEntity(((HttpEntity) (obj)));
        a(0x15f90);
        avoid = cl.e(a).execute(b);
        a(((HttpResponse) (avoid)));
        avoid.getEntity().consumeContent();
        boolean flag = true;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        if (a())
        {
            cl.a(a, new TimeoutException(avoid.getMessage()), getClass());
            flag = false;
        } else
        {
            if (!isCancelled())
            {
                cl.a(a, avoid, getClass());
            }
            flag = false;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
        cl.f(a).b(h);
        cl.a(a, boolean1);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Boolean)obj);
    }
}
