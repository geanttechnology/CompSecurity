// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            aj

public class o
{

    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private static final int e = 5;
    private static final int f = 6;
    private Handler g;

    public o()
    {
        if (Looper.myLooper() != null)
        {
            g = new Handler() {

                final o a;

                public void handleMessage(Message message)
                {
                    a.a(message);
                }

            
            {
                a = o.this;
                super();
            }
            };
        }
    }

    public o(Handler handler)
    {
        g = handler;
    }

    protected Message a(int j, Object obj)
    {
        if (g != null)
        {
            return g.obtainMessage(j, obj);
        } else
        {
            Message message = new Message();
            message.what = j;
            message.obj = obj;
            return message;
        }
    }

    public void a(int j, String s)
    {
    }

    protected void a(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 4: // '\004'
            Object aobj[] = (Object[])(Object[])message.obj;
            c(message.arg1, (String)aobj[0]);
            return;

        case 5: // '\005'
            c((byte[])(byte[])message.obj, message.arg1);
            return;

        case 6: // '\006'
            i();
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            d((Throwable)message[0], (String)message[1]);
            return;

        case 2: // '\002'
            d();
            return;

        case 3: // '\003'
            c();
            return;
        }
    }

    public void a(Throwable throwable)
    {
    }

    void a(HttpResponse httpresponse)
    {
        StatusLine statusline;
        int j;
        statusline = httpresponse.getStatusLine();
        j = statusline.getStatusCode();
        Object obj1 = httpresponse.getEntity();
        if (j < 300) goto _L2; else goto _L1
_L1:
        httpresponse = EntityUtils.toString(((HttpEntity) (obj1)));
_L4:
        if (statusline.getStatusCode() >= 300)
        {
            c(new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), httpresponse);
        }
        return;
_L2:
        if (obj1 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IllegalArgumentException("HTTP entity may not be null");
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            c(httpresponse, ((String) (null)));
        }
_L9:
        httpresponse = null;
        if (true) goto _L4; else goto _L3
_L3:
        InputStream inputstream = ((HttpEntity) (obj1)).getContent();
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        b(0, ((String) (null)));
        b(new byte[0], 0);
        h();
        return;
        if (((HttpEntity) (obj1)).getContentLength() > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        j = (int)((HttpEntity) (obj1)).getContentLength();
        Object obj;
        if (j < 0)
        {
            j = 4096;
        }
        obj = null;
        httpresponse = obj;
        HeaderElement aheaderelement[];
        if (((HttpEntity) (obj1)).getContentType() == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        aheaderelement = ((HttpEntity) (obj1)).getContentType().getElements();
        httpresponse = obj;
        if (aheaderelement.length <= 0)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        aheaderelement = aheaderelement[0].getParameterByName("charset");
        httpresponse = obj;
        if (aheaderelement == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        httpresponse = aheaderelement.getValue();
        b(j, httpresponse);
        int k = 0;
_L8:
        httpresponse = null;
        if (Thread.currentThread().isInterrupted())
        {
            c(new InterruptedException("request interupted!"), ((String) (null)));
            return;
        }
        if (false)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        httpresponse = new byte[1024];
        break MISSING_BLOCK_LABEL_409;
_L6:
        if (Thread.currentThread().isInterrupted())
        {
            c(new InterruptedException("request interupted!"), ((String) (null)));
            return;
        }
        int i1;
        int j1 = inputstream.read(httpresponse, j, i1);
        int l;
        if (j1 == -1)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        l = j + j1;
        j1 = i1 - j1;
        j = l;
        i1 = j1;
        if (j1 > 0) goto _L6; else goto _L5
_L5:
        j = k;
_L10:
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_376;
        }
        b(httpresponse, l);
        k = j;
        if (j == 0) goto _L8; else goto _L7
_L7:
        h();
          goto _L9
        boolean flag = true;
        l = j;
        j = ((flag) ? 1 : 0);
          goto _L10
        j = 0;
        i1 = 1024;
          goto _L6
    }

    public void a(byte abyte0[], int j)
    {
    }

    protected void b(int j, String s)
    {
        Message message = a(4, null);
        message.obj = ((Object) (new Object[] {
            s, null
        }));
        message.arg1 = j;
        b(message);
    }

    protected void b(Message message)
    {
        if (g != null)
        {
            Thread thread = g.getLooper().getThread();
            if (thread.isAlive() && !thread.isInterrupted())
            {
                g.sendMessage(message);
            }
            return;
        } else
        {
            a(message);
            return;
        }
    }

    public void b(Throwable throwable, String s)
    {
        aj.a("BDAutoUpdateSDK", "AsyncHttpResponseHandler:onFailure");
        a(throwable);
    }

    protected void b(byte abyte0[], int j)
    {
        abyte0 = a(5, abyte0);
        abyte0.arg1 = j;
        b(((Message) (abyte0)));
    }

    public void c()
    {
        aj.a("BDAutoUpdateSDK", "AsyncHttpResponseHandler:onFinish");
    }

    protected void c(int j, String s)
    {
        a(j, s);
    }

    protected void c(Throwable throwable, String s)
    {
        b(a(1, ((Object) (new Object[] {
            throwable, s
        }))));
    }

    protected void c(byte abyte0[], int j)
    {
        a(abyte0, j);
    }

    public void d()
    {
        aj.a("BDAutoUpdateSDK", "AsyncHttpResponseHandler:onStart");
    }

    protected void d(Throwable throwable, String s)
    {
        b(throwable, s);
    }

    public void e()
    {
    }

    protected void f()
    {
        b(a(2, null));
    }

    protected void g()
    {
        b(a(3, null));
    }

    protected void h()
    {
        b(a(6, null));
    }

    protected void i()
    {
        e();
    }
}
