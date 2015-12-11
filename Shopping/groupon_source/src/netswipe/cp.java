// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.util.concurrent.TimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

// Referenced classes of package netswipe:
//            cu, cl, di, de

class cp extends cu
{

    final cl a;
    private char c[];
    private String d;

    public cp(cl cl1, String s, char ac[])
    {
        a = cl1;
        super();
        d = "";
        d = s;
        c = ac;
    }

    protected transient Boolean a(Void avoid[])
    {
        b = new HttpPost((new StringBuilder()).append(cl.b()).append("/").append(d).append("/").append(di.a(new byte[] {
            -98, -66, 73, -47, 98, 31
        }, 0xcd7953eb6c7773fbL)).toString());
        b.setHeader("Authorization", (new StringBuilder()).append("Basic ").append(cl.a(a)).toString());
        b.setHeader("Accept", "application/json");
        b.setHeader("Content-Type", "application/json");
        b.setHeader("User-Agent", "Jumio Netswipe Android SDK 2.0.3");
        avoid = new de();
        avoid.put("changedCardHolderName", c);
        ((HttpPost)b).setEntity(new StringEntity(avoid.toString()));
        a(30000);
        avoid = cl.e(a).execute(b);
        a(((HttpResponse) (avoid)));
        avoid.getEntity().consumeContent();
        boolean flag = true;
_L2:
        return Boolean.valueOf(flag);
        avoid;
        boolean flag1 = false;
        if (a())
        {
            cl.a(a, new TimeoutException(avoid.getMessage()), getClass());
            flag = flag1;
        } else
        {
            flag = flag1;
            if (!isCancelled())
            {
                cl.a(a, avoid, getClass());
                flag = flag1;
            }
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Boolean boolean1)
    {
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
