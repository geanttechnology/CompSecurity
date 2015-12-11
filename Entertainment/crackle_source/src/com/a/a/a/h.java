// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.a.a.a:
//            f

public class h extends f
{

    private static String a[] = {
        "image/jpeg", "image/png"
    };

    public h()
    {
    }

    public h(String as[])
    {
        this();
        a = as;
    }

    public void a(int i, byte abyte0[])
    {
        a(abyte0);
    }

    protected void a(Message message)
    {
        switch (message.what)
        {
        default:
            super.a(message);
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])message.obj));
            c(((Integer)message[0]).intValue(), (byte[])message[1]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])message.obj));
            break;
        }
        c((Throwable)message[0], (byte[])message[1]);
    }

    protected void a(Throwable throwable, byte abyte0[])
    {
        b(a(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void a(HttpResponse httpresponse)
    {
        byte abyte0[];
        StatusLine statusline;
        boolean flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        abyte0 = (byte[])null;
        if (aheader.length != 1)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"))), abyte0);
            return;
        }
        Header header = aheader[0];
        String as[] = a;
        int j = as.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                if (!flag)
                {
                    a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"))), abyte0);
                    return;
                }
                break;
            }
            if (as[i].equals(header.getValue()))
            {
                flag = true;
            }
            i++;
        } while (true);
        httpresponse = httpresponse.getEntity();
        if (httpresponse == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        httpresponse = new BufferedHttpEntity(httpresponse);
_L2:
        httpresponse = EntityUtils.toByteArray(httpresponse);
_L1:
        if (statusline.getStatusCode() >= 300)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()))), ((byte []) (httpresponse)));
            return;
        } else
        {
            b(statusline.getStatusCode(), httpresponse);
            return;
        }
        httpresponse;
        a(((Throwable) (httpresponse)), null);
        httpresponse = abyte0;
          goto _L1
        httpresponse = null;
          goto _L2
    }

    public void a(byte abyte0[])
    {
    }

    protected void b(int i, byte abyte0[])
    {
        b(a(0, ((Object) (new Object[] {
            Integer.valueOf(i), abyte0
        }))));
    }

    public void b(Throwable throwable, byte abyte0[])
    {
        a(throwable);
    }

    protected void c(int i, byte abyte0[])
    {
        a(i, abyte0);
    }

    protected void c(Throwable throwable, byte abyte0[])
    {
        b(throwable, abyte0);
    }

}
