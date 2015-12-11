// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class AsyncHttpResponseHandler
{

    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;

    public AsyncHttpResponseHandler()
    {
        if (Looper.myLooper() != null)
        {
            handler = new Handler() {

                final AsyncHttpResponseHandler this$0;

                public void handleMessage(Message message)
                {
                    AsyncHttpResponseHandler.this.handleMessage(message);
                }

            
            {
                this$0 = AsyncHttpResponseHandler.this;
                super();
            }
            };
        }
    }

    protected void handleFailureMessage(Throwable throwable, String s)
    {
        onFailure(throwable, s);
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])(Object[])message.obj));
            handleSuccessMessage(((Integer)message[0]).intValue(), (String)message[1]);
            return;

        case 1: // '\001'
            message = ((Message) ((Object[])(Object[])message.obj));
            handleFailureMessage((Throwable)message[0], (String)message[1]);
            return;

        case 2: // '\002'
            onStart();
            return;

        case 3: // '\003'
            onFinish();
            break;
        }
    }

    protected void handleSuccessMessage(int i, String s)
    {
        onSuccess(i, s);
    }

    protected Message obtainMessage(int i, Object obj)
    {
        if (handler != null)
        {
            return handler.obtainMessage(i, obj);
        } else
        {
            Message message = new Message();
            message.what = i;
            message.obj = obj;
            return message;
        }
    }

    public void onFailure(Throwable throwable)
    {
    }

    public void onFailure(Throwable throwable, String s)
    {
        onFailure(throwable);
    }

    public void onFinish()
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, String s)
    {
        onSuccess(s);
    }

    public void onSuccess(String s)
    {
    }

    protected void sendFailureMessage(Throwable throwable, String s)
    {
        sendMessage(obtainMessage(1, ((Object) (new Object[] {
            throwable, s
        }))));
    }

    protected void sendFailureMessage(Throwable throwable, byte abyte0[])
    {
        sendMessage(obtainMessage(1, ((Object) (new Object[] {
            throwable, abyte0
        }))));
    }

    protected void sendFinishMessage()
    {
        sendMessage(obtainMessage(3, null));
    }

    protected void sendMessage(Message message)
    {
        if (handler != null)
        {
            handler.sendMessage(message);
            return;
        } else
        {
            handleMessage(message);
            return;
        }
    }

    void sendResponseMessage(HttpResponse httpresponse)
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
                sendFailureMessage(httpresponse, (String)null);
                httpresponse = obj;
            }
        }
        if (statusline.getStatusCode() >= 300)
        {
            sendFailureMessage(new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), httpresponse);
            return;
        } else
        {
            sendSuccessMessage(statusline.getStatusCode(), httpresponse);
            return;
        }
    }

    protected void sendStartMessage()
    {
        sendMessage(obtainMessage(2, null));
    }

    protected void sendSuccessMessage(int i, String s)
    {
        sendMessage(obtainMessage(0, ((Object) (new Object[] {
            new Integer(i), s
        }))));
    }
}
