// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class agv
{

    private Handler a;

    public agv()
    {
        if (Looper.myLooper() != null)
        {
            a = new Handler() {

                final agv a;

                public void handleMessage(Message message)
                {
                    a.a(message);
                }

            
            {
                a = agv.this;
                super();
            }
            };
        }
    }

    protected Message a(int i, Object obj)
    {
        if (a != null)
        {
            return a.obtainMessage(i, obj);
        } else
        {
            Message message = Message.obtain();
            message.what = i;
            message.obj = obj;
            return message;
        }
    }

    public void a()
    {
    }

    public void a(int i, String s)
    {
        a(s);
    }

    public void a(int i, Header aheader[], String s)
    {
        a(i, s);
    }

    protected void a(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])(Object[])message.obj));
            c(((Integer)message[0]).intValue(), (Header[])(Header[])message[1], (String)message[2]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            c((Throwable)message[0], (String)message[1]);
            return;

        case 2: // '\002'
            a();
            return;

        case 3: // '\003'
            b();
            break;
        }
    }

    public void a(String s)
    {
    }

    public void a(Throwable throwable)
    {
    }

    public void a(Throwable throwable, String s)
    {
        a(throwable);
    }

    protected void a(Throwable throwable, byte abyte0[])
    {
        b(a(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void a(HttpResponse httpresponse)
    {
        Object obj1;
        StatusLine statusline;
        obj1 = null;
        statusline = httpresponse.getStatusLine();
        org.apache.http.HttpEntity httpentity = httpresponse.getEntity();
        Object obj = obj1;
        if (httpentity != null)
        {
            try
            {
                obj = EntityUtils.toString(new BufferedHttpEntity(httpentity), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                b(((Throwable) (obj)), (String)null);
                obj = obj1;
            }
        }
        if (statusline.getStatusCode() >= 300)
        {
            b(new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), ((String) (obj)));
            return;
        } else
        {
            b(statusline.getStatusCode(), httpresponse.getAllHeaders(), ((String) (obj)));
            return;
        }
    }

    public void b()
    {
    }

    protected void b(int i, Header aheader[], String s)
    {
        b(a(0, ((Object) (new Object[] {
            new Integer(i), aheader, s
        }))));
    }

    protected void b(Message message)
    {
        if (a != null)
        {
            a.sendMessage(message);
            return;
        } else
        {
            a(message);
            return;
        }
    }

    protected void b(Throwable throwable, String s)
    {
        b(a(1, ((Object) (new Object[] {
            throwable, s
        }))));
    }

    protected void c()
    {
        b(a(2, null));
    }

    protected void c(int i, Header aheader[], String s)
    {
        a(i, aheader, s);
    }

    protected void c(Throwable throwable, String s)
    {
        a(throwable, s);
    }

    protected void d()
    {
        b(a(3, null));
    }
}
