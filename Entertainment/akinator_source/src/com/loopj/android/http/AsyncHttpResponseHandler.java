// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import cz.msebera.android.httpclient.util.ByteArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URI;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface, AsyncHttpClient, LogInterface, Utils

public abstract class AsyncHttpResponseHandler
    implements ResponseHandlerInterface
{
    private static class ResponderHandler extends Handler
    {

        private final AsyncHttpResponseHandler mResponder;

        public void handleMessage(Message message)
        {
            mResponder.handleMessage(message);
        }

        ResponderHandler(AsyncHttpResponseHandler asynchttpresponsehandler, Looper looper1)
        {
            super(looper1);
            mResponder = asynchttpresponsehandler;
        }
    }


    protected static final int BUFFER_SIZE = 4096;
    protected static final int CANCEL_MESSAGE = 6;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpRH";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    public static final String UTF8_BOM = "\uFEFF";
    private WeakReference TAG;
    private Handler handler;
    private Looper looper;
    private Header requestHeaders[];
    private URI requestURI;
    private String responseCharset;
    private boolean usePoolThread;
    private boolean useSynchronousMode;

    public AsyncHttpResponseHandler()
    {
        this(((Looper) (null)));
    }

    public AsyncHttpResponseHandler(Looper looper1)
    {
        responseCharset = "UTF-8";
        requestURI = null;
        requestHeaders = null;
        looper = null;
        TAG = new WeakReference(null);
        Looper looper2 = looper1;
        if (looper1 == null)
        {
            looper2 = Looper.myLooper();
        }
        looper = looper2;
        setUseSynchronousMode(false);
        setUsePoolThread(false);
    }

    public AsyncHttpResponseHandler(boolean flag)
    {
        responseCharset = "UTF-8";
        requestURI = null;
        requestHeaders = null;
        looper = null;
        TAG = new WeakReference(null);
        setUsePoolThread(flag);
        if (!getUsePoolThread())
        {
            looper = Looper.myLooper();
            setUseSynchronousMode(false);
        }
    }

    public String getCharset()
    {
        if (responseCharset == null)
        {
            return "UTF-8";
        } else
        {
            return responseCharset;
        }
    }

    public Header[] getRequestHeaders()
    {
        return requestHeaders;
    }

    public URI getRequestURI()
    {
        return requestURI;
    }

    byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        Object obj;
        InputStream inputstream;
        long l;
        long l1;
        byte abyte0[] = null;
        obj = abyte0;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        inputstream = httpentity.getContent();
        obj = abyte0;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        l1 = httpentity.getContentLength();
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        int i;
        long l2;
        if (l1 <= 0L)
        {
            i = 4096;
        } else
        {
            i = (int)l1;
        }
        obj = new ByteArrayBuffer(i);
        abyte0 = new byte[4096];
        l = 0L;
_L1:
        i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        l2 = l + (long)i;
        ((ByteArrayBuffer) (obj)).append(abyte0, 0, i);
        if (l1 <= 0L)
        {
            l = 1L;
        } else
        {
            l = l1;
        }
        sendProgressMessage(l2, l);
        l = l2;
          goto _L1
        obj;
        try
        {
            AsyncHttpClient.silentCloseInputStream(inputstream);
            AsyncHttpClient.endEntityViaReflection(httpentity);
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        AsyncHttpClient.silentCloseInputStream(inputstream);
        AsyncHttpClient.endEntityViaReflection(httpentity);
        obj = ((ByteArrayBuffer) (obj)).toByteArray();
        return ((byte []) (obj));
    }

    public Object getTag()
    {
        return TAG.get();
    }

    public boolean getUsePoolThread()
    {
        return usePoolThread;
    }

    public boolean getUseSynchronousMode()
    {
        return useSynchronousMode;
    }

    protected void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 0 6: default 331
    //                   0 48
    //                   1 121
    //                   2 193
    //                   3 198
    //                   4 203
    //                   5 277
    //                   6 326;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        message = ((Message) ((Object[])(Object[])message.obj));
        if (message != null)
        {
            try
            {
                if (message.length >= 3)
                {
                    onSuccess(((Integer)message[0]).intValue(), (Header[])(Header[])message[1], (byte[])(byte[])message[2]);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                onUserException(message);
                return;
            }
        }
        AsyncHttpClient.log.e("AsyncHttpRH", "SUCCESS_MESSAGE didn't got enough params");
        return;
_L3:
        message = ((Message) ((Object[])(Object[])message.obj));
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        if (message.length >= 4)
        {
            onFailure(((Integer)message[0]).intValue(), (Header[])(Header[])message[1], (byte[])(byte[])message[2], (Throwable)message[3]);
            return;
        }
        AsyncHttpClient.log.e("AsyncHttpRH", "FAILURE_MESSAGE didn't got enough params");
        return;
_L4:
        onStart();
        return;
_L5:
        onFinish();
        return;
_L6:
        message = ((Message) ((Object[])(Object[])message.obj));
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        int i = message.length;
        if (i < 2)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        try
        {
            onProgress(((Long)message[0]).longValue(), ((Long)message[1]).longValue());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Message message) { }
        AsyncHttpClient.log.e("AsyncHttpRH", "custom onProgress contains an error", message);
        return;
        AsyncHttpClient.log.e("AsyncHttpRH", "PROGRESS_MESSAGE didn't got enough params");
        return;
_L7:
        message = ((Message) ((Object[])(Object[])message.obj));
        if (message == null)
        {
            break MISSING_BLOCK_LABEL_312;
        }
        if (message.length == 1)
        {
            onRetry(((Integer)message[0]).intValue());
            return;
        }
        AsyncHttpClient.log.e("AsyncHttpRH", "RETRY_MESSAGE didn't get enough params");
        return;
_L8:
        onCancel();
        return;
_L1:
    }

    protected Message obtainMessage(int i, Object obj)
    {
        return Message.obtain(handler, i, obj);
    }

    public void onCancel()
    {
        AsyncHttpClient.log.d("AsyncHttpRH", "Request got cancelled");
    }

    public abstract void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public void onFinish()
    {
    }

    public void onPostProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onPreProcessResponse(ResponseHandlerInterface responsehandlerinterface, HttpResponse httpresponse)
    {
    }

    public void onProgress(long l, long l1)
    {
        LogInterface loginterface = AsyncHttpClient.log;
        double d;
        if (l1 > 0L)
        {
            d = (((double)l * 1.0D) / (double)l1) * 100D;
        } else
        {
            d = -1D;
        }
        loginterface.v("AsyncHttpRH", String.format("Progress %d from %d (%2.0f%%)", new Object[] {
            Long.valueOf(l), Long.valueOf(l1), Double.valueOf(d)
        }));
    }

    public void onRetry(int i)
    {
        AsyncHttpClient.log.d("AsyncHttpRH", String.format("Request retry no. %d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void onStart()
    {
    }

    public abstract void onSuccess(int i, Header aheader[], byte abyte0[]);

    public void onUserException(Throwable throwable)
    {
        AsyncHttpClient.log.e("AsyncHttpRH", "User-space exception detected!", throwable);
        throw new RuntimeException(throwable);
    }

    protected void postRunnable(Runnable runnable)
    {
label0:
        {
            if (runnable != null)
            {
                if (!getUseSynchronousMode() && handler != null)
                {
                    break label0;
                }
                runnable.run();
            }
            return;
        }
        handler.post(runnable);
    }

    public final void sendCancelMessage()
    {
        sendMessage(obtainMessage(6, null));
    }

    public final void sendFailureMessage(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        sendMessage(obtainMessage(1, ((Object) (new Object[] {
            Integer.valueOf(i), aheader, abyte0, throwable
        }))));
    }

    public final void sendFinishMessage()
    {
        sendMessage(obtainMessage(3, null));
    }

    protected void sendMessage(Message message)
    {
        if (getUseSynchronousMode() || handler == null)
        {
            handleMessage(message);
        } else
        if (!Thread.currentThread().isInterrupted())
        {
            boolean flag;
            if (handler != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Utils.asserts(flag, "handler should not be null!");
            handler.sendMessage(message);
            return;
        }
    }

    public final void sendProgressMessage(long l, long l1)
    {
        sendMessage(obtainMessage(4, ((Object) (new Object[] {
            Long.valueOf(l), Long.valueOf(l1)
        }))));
    }

    public void sendResponseMessage(HttpResponse httpresponse)
        throws IOException
    {
        StatusLine statusline;
        byte abyte0[];
label0:
        {
            if (!Thread.currentThread().isInterrupted())
            {
                statusline = httpresponse.getStatusLine();
                abyte0 = getResponseData(httpresponse.getEntity());
                if (!Thread.currentThread().isInterrupted())
                {
                    if (statusline.getStatusCode() < 300)
                    {
                        break label0;
                    }
                    sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0, new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()));
                }
            }
            return;
        }
        sendSuccessMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), abyte0);
    }

    public final void sendRetryMessage(int i)
    {
        sendMessage(obtainMessage(5, ((Object) (new Object[] {
            Integer.valueOf(i)
        }))));
    }

    public final void sendStartMessage()
    {
        sendMessage(obtainMessage(2, null));
    }

    public final void sendSuccessMessage(int i, Header aheader[], byte abyte0[])
    {
        sendMessage(obtainMessage(0, ((Object) (new Object[] {
            Integer.valueOf(i), aheader, abyte0
        }))));
    }

    public void setCharset(String s)
    {
        responseCharset = s;
    }

    public void setRequestHeaders(Header aheader[])
    {
        requestHeaders = aheader;
    }

    public void setRequestURI(URI uri)
    {
        requestURI = uri;
    }

    public void setTag(Object obj)
    {
        TAG = new WeakReference(obj);
    }

    public void setUsePoolThread(boolean flag)
    {
        if (flag)
        {
            looper = null;
            handler = null;
        }
        usePoolThread = flag;
    }

    public void setUseSynchronousMode(boolean flag)
    {
        boolean flag1;
        flag1 = flag;
        if (!flag)
        {
            flag1 = flag;
            if (looper == null)
            {
                flag1 = true;
                AsyncHttpClient.log.w("AsyncHttpRH", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
            }
        }
        if (flag1 || handler != null) goto _L2; else goto _L1
_L1:
        handler = new ResponderHandler(this, looper);
_L4:
        useSynchronousMode = flag1;
        return;
_L2:
        if (flag1 && handler != null)
        {
            handler = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
