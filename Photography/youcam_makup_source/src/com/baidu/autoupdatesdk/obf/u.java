// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.content.Context;
import android.os.Looper;
import com.baidu.autoupdatesdk.ICallback;
import com.baidu.autoupdatesdk.UICallback;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            b, am, ao, x, 
//            aj

public class u
    implements b
{

    private static HttpClient a = am.a();
    private static ExecutorService b = ao.b();
    private static ExecutorService c = ao.a();
    private boolean d;

    private u()
    {
        d = false;
    }

    public static HttpClient a(Context context)
    {
        am.a(context, a);
        return a;
    }

    private void a(x x1, ICallback icallback, String s)
    {
        x1.a(0x80000000, s);
        x1.b(icallback);
    }

    private static void a(HttpEntity httpentity)
    {
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        httpentity.consumeContent();
        return;
        httpentity;
        httpentity.printStackTrace();
        return;
    }

    public static ExecutorService b()
    {
        return b;
    }

    public static ExecutorService c()
    {
        return c;
    }

    private void c(x x1, ICallback icallback)
    {
        icallback = UICallback.wrap(icallback);
        b.submit(new Runnable(x1, icallback) {

            final x a;
            final ICallback b;
            final u c;

            public void run()
            {
                c.b(a, b);
            }

            
            {
                c = u.this;
                a = x1;
                b = icallback;
                super();
            }
        });
    }

    public static u d()
    {
        return new u();
    }

    private void d(x x1, ICallback icallback)
    {
        x1.a(-1, x1.a("connect error"));
        x1.b(icallback);
    }

    public void a()
    {
        d = true;
    }

    public void a(x x1, ICallback icallback)
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new RuntimeException("This thread(non_ui) forbids invoke.");
        } else
        {
            c(x1, icallback);
            return;
        }
    }

    public void b(x x1, ICallback icallback)
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        Object obj5;
        ByteArrayBuffer bytearraybuffer;
        byte abyte0[];
        InputStream inputstream;
        Object obj6;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            throw new RuntimeException("This thread(ui) forbids invoke.");
        }
        if (!am.a(x1.c()))
        {
            x1.a(-1, x1.a("Net not connected."));
            x1.b(icallback);
            return;
        }
        obj6 = a(x1.c());
        bytearraybuffer = null;
        abyte0 = null;
        inputstream = null;
        obj1 = null;
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        byte abyte1[] = x1.h();
        if (abyte1 != null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        x1.a(0x80000000, x1.a("encode error"));
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        x1.b(icallback);
        a(((HttpEntity) (null)));
        return;
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        HttpPost httppost = new HttpPost(x1.a());
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        aj.a("BDAutoUpdateSDK", (new StringBuilder()).append("RequestUrl=").append(x1.a()).toString());
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        httppost.setEntity(new ByteArrayEntity(abyte1));
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        obj6 = ((HttpClient) (obj6)).execute(httppost);
        obj3 = obj1;
        obj4 = bytearraybuffer;
        obj5 = abyte0;
        obj = inputstream;
        obj1 = ((HttpResponse) (obj6)).getEntity();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!d)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.a(icallback);
        a(((HttpEntity) (obj1)));
        return;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        int i = ((HttpResponse) (obj6)).getStatusLine().getStatusCode();
        if (i >= 200 && i < 300)
        {
            break MISSING_BLOCK_LABEL_452;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.a(-2, x1.a("http %d", new Object[] {
            Integer.valueOf(i)
        }));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.b(icallback);
        a(((HttpEntity) (obj1)));
        return;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        bytearraybuffer = new ByteArrayBuffer(1024);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        abyte0 = new byte[512];
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        inputstream = ((HttpEntity) (obj1)).getContent();
_L2:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        bytearraybuffer.append(abyte0, 0, i);
        if (true) goto _L2; else goto _L1
        obj1;
        obj = obj3;
        d(x1, icallback);
        obj = obj3;
        ((ClientProtocolException) (obj1)).printStackTrace();
        a(((HttpEntity) (obj3)));
        return;
_L1:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        a(((HttpEntity) (obj1)));
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!d)
        {
            break MISSING_BLOCK_LABEL_676;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.a(icallback);
        a(((HttpEntity) (obj1)));
        return;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.a(bytearraybuffer.toByteArray());
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        x1.b(icallback);
        a(((HttpEntity) (obj1)));
        return;
        Object obj2;
        obj2;
        obj = obj4;
        d(x1, icallback);
        obj = obj4;
        ((IOException) (obj2)).printStackTrace();
        a(((HttpEntity) (obj4)));
        return;
        obj2;
        obj = obj5;
        a(x1, icallback, ((Exception) (obj2)).getMessage());
        obj = obj5;
        ((Exception) (obj2)).printStackTrace();
        a(((HttpEntity) (obj5)));
        return;
        x1;
        a(((HttpEntity) (obj)));
        throw x1;
    }

}
