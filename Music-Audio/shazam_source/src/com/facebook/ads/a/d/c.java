// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class c
{

    private Handler a;

    public c()
    {
        if (Looper.myLooper() != null)
        {
            a = new Handler() {

                final c a;

                public final void handleMessage(Message message)
                {
                    a.a(message);
                }

            
            {
                a = c.this;
                super();
            }
            };
        }
    }

    final Message a(int i, Object obj)
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

    protected final void a()
    {
        b(a(3, null));
    }

    protected final void a(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])(Object[])message.obj));
            ((Integer)message[0]).intValue();
            a((String)message[1]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        a((Throwable)message[0], (String)message[1]);
    }

    public void a(String s)
    {
    }

    public void a(Throwable throwable, String s)
    {
    }

    final void a(HttpResponse httpresponse)
    {
        Object obj;
        StatusLine statusline;
        obj = null;
        statusline = httpresponse.getStatusLine();
        org.apache.http.HttpEntity httpentity = httpresponse.getEntity();
        httpresponse = obj;
        if (httpentity != null)
        {
            try
            {
                httpresponse = EntityUtils.toString(new BufferedHttpEntity(httpentity), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (HttpResponse httpresponse)
            {
                b(httpresponse, null);
                httpresponse = obj;
            }
        }
        if (statusline.getStatusCode() >= 300)
        {
            b(new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), httpresponse);
            return;
        } else
        {
            b(a(0, ((Object) (new Object[] {
                Integer.valueOf(statusline.getStatusCode()), httpresponse
            }))));
            return;
        }
    }

    final void b(Message message)
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

    protected final void b(Throwable throwable, String s)
    {
        b(a(1, ((Object) (new Object[] {
            throwable, s
        }))));
    }
}
