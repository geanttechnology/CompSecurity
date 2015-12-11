// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler

public class BinaryHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static String mAllowedContentTypes[] = {
        "image/jpeg", "image/png"
    };

    public BinaryHttpResponseHandler()
    {
    }

    public BinaryHttpResponseHandler(String as[])
    {
        this();
        mAllowedContentTypes = as;
    }

    protected void handleFailureMessage(Throwable throwable, byte abyte0[])
    {
        onFailure(throwable, abyte0);
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            super.handleMessage(message);
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])(Object[])message.obj));
            handleSuccessMessage(((Integer)message[0]).intValue(), (byte[])(byte[])message[1]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            break;
        }
        handleFailureMessage((Throwable)message[0], (byte[])(byte[])message[1]);
    }

    protected void handleSuccessMessage(int i, byte abyte0[])
    {
        onSuccess(i, abyte0);
    }

    public void onFailure(Throwable throwable, byte abyte0[])
    {
        onFailure(throwable);
    }

    public void onSuccess(int i, byte abyte0[])
    {
        onSuccess(abyte0);
    }

    public void onSuccess(byte abyte0[])
    {
    }

    protected void sendFailureMessage(Throwable throwable, byte abyte0[])
    {
        sendMessage(obtainMessage(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    void sendResponseMessage(HttpResponse httpresponse)
    {
        Object obj;
        StatusLine statusline;
        obj = null;
        boolean flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        if (aheader.length != 1)
        {
            sendFailureMessage(new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"), null);
            return;
        }
        Header header = aheader[0];
        String as[] = mAllowedContentTypes;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (as[i].equals(header.getValue()))
            {
                flag = true;
            }
        }

        if (!flag)
        {
            sendFailureMessage(new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"), null);
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
            sendFailureMessage(new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), httpresponse);
            return;
        } else
        {
            sendSuccessMessage(statusline.getStatusCode(), httpresponse);
            return;
        }
        httpresponse;
        sendFailureMessage(httpresponse, (byte[])null);
        httpresponse = obj;
          goto _L1
        httpresponse = null;
          goto _L2
    }

    protected void sendSuccessMessage(int i, byte abyte0[])
    {
        sendMessage(obtainMessage(0, ((Object) (new Object[] {
            Integer.valueOf(i), abyte0
        }))));
    }

}
