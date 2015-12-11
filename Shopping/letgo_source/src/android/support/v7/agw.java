// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Message;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package android.support.v7:
//            agv

public class agw extends agv
{

    private static String a[] = {
        "image/jpeg", "image/png"
    };

    public agw()
    {
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
            message = ((Message) ((Object[])(Object[])message.obj));
            c(((Integer)message[0]).intValue(), (byte[])(byte[])message[1]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        c((Throwable)message[0], message[1].toString());
    }

    protected void a(Throwable throwable, byte abyte0[])
    {
        b(a(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void a(HttpResponse httpresponse)
    {
        Object obj;
        StatusLine statusline;
        obj = null;
        boolean flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        if (aheader.length != 1)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"))), null);
            return;
        }
        Header header = aheader[0];
        String as[] = a;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (Pattern.matches(as[i], header.getValue()))
            {
                flag = true;
            }
        }

        if (!flag)
        {
            a(((Throwable) (new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"))), null);
            return;
        }
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
        a(((Throwable) (httpresponse)), (byte[])null);
        httpresponse = obj;
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

    protected void c(int i, byte abyte0[])
    {
        a(i, abyte0);
    }

}
