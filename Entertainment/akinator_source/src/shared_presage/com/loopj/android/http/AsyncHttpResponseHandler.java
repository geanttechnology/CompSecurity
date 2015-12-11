// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.util.ByteArrayBuffer;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            ResponseHandlerInterface

public class AsyncHttpResponseHandler
    implements ResponseHandlerInterface
{
    static final class a extends Handler
    {

        private final WeakReference a;

        public final void handleMessage(Message message)
        {
            AsyncHttpResponseHandler asynchttpresponsehandler = (AsyncHttpResponseHandler)a.get();
            if (asynchttpresponsehandler != null)
            {
                asynchttpresponsehandler.handleMessage(message);
            }
        }

        a(AsyncHttpResponseHandler asynchttpresponsehandler)
        {
            a = new WeakReference(asynchttpresponsehandler);
        }
    }


    protected static final int BUFFER_SIZE = 4096;
    public static final String DEFAULT_CHARSET = "UTF-8";
    protected static final int FAILURE_MESSAGE = 1;
    protected static final int FINISH_MESSAGE = 3;
    private static final String LOG_TAG = "AsyncHttpResponseHandler";
    protected static final int PROGRESS_MESSAGE = 4;
    protected static final int RETRY_MESSAGE = 5;
    protected static final int START_MESSAGE = 2;
    protected static final int SUCCESS_MESSAGE = 0;
    private Handler handler;
    private Header requestHeaders[];
    private URI requestURI;
    private String responseCharset;
    private Boolean useSynchronousMode;

    public AsyncHttpResponseHandler()
    {
        responseCharset = "UTF-8";
        useSynchronousMode = Boolean.valueOf(false);
        requestURI = null;
        requestHeaders = null;
        if (Looper.myLooper() != null)
        {
            handler = new a(this);
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
    {
        byte abyte0[];
        InputStream inputstream;
        long l;
        Object obj = null;
        abyte0 = obj;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        inputstream = httpentity.getContent();
        abyte0 = obj;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        long l1 = httpentity.getContentLength();
        if (l1 > 0x7fffffffL)
        {
            throw new IllegalArgumentException("HTTP entity too large to be buffered in memory");
        }
        l = l1;
        if (l1 < 0L)
        {
            l = 4096L;
        }
        httpentity = new ByteArrayBuffer((int)l);
        abyte0 = new byte[4096];
        int i = 0;
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        i += j;
        httpentity.append(abyte0, 0, j);
        sendProgressMessage(i, (int)l);
          goto _L1
        httpentity;
        try
        {
            inputstream.close();
            throw httpentity;
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntity httpentity)
        {
            System.gc();
        }
        throw new IOException("File too large to fit into available memory");
        inputstream.close();
        abyte0 = httpentity.toByteArray();
        return abyte0;
    }

    public boolean getUseSynchronousMode()
    {
        return useSynchronousMode.booleanValue();
    }

    protected void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            message = ((Message) ((Object[])message.obj));
            if (message != null && message.length >= 3)
            {
                onSuccess(((Integer)message[0]).intValue(), (Header[])message[1], (byte[])message[2]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "SUCCESS_MESSAGE didn't got enough params");
                return;
            }

        case 1: // '\001'
            message = ((Message) ((Object[])message.obj));
            if (message != null && message.length >= 4)
            {
                onFailure(((Integer)message[0]).intValue(), (Header[])message[1], (byte[])message[2], (Throwable)message[3]);
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "FAILURE_MESSAGE didn't got enough params");
                return;
            }

        case 2: // '\002'
            onStart();
            return;

        case 3: // '\003'
            onFinish();
            return;

        case 4: // '\004'
            message = ((Message) ((Object[])message.obj));
            if (message != null && message.length >= 2)
            {
                try
                {
                    onProgress(((Integer)message[0]).intValue(), ((Integer)message[1]).intValue());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Log.e("AsyncHttpResponseHandler", "custom onProgress contains an error", message);
                }
                return;
            } else
            {
                Log.e("AsyncHttpResponseHandler", "PROGRESS_MESSAGE didn't got enough params");
                return;
            }

        case 5: // '\005'
            onRetry();
            return;
        }
    }

    protected Message obtainMessage(int i, Object obj)
    {
        Message message;
        if (handler != null)
        {
            message = handler.obtainMessage(i, obj);
        } else
        {
            Message message1 = Message.obtain();
            message = message1;
            if (message1 != null)
            {
                message1.what = i;
                message1.obj = obj;
                return message1;
            }
        }
        return message;
    }

    public void onFailure(int i, Throwable throwable, String s)
    {
        onFailure(throwable, s);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, String s)
    {
        onFailure(i, throwable, s);
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        abyte0 = null;
_L1:
        try
        {
            onFailure(i, aheader, throwable, ((String) (abyte0)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.e("AsyncHttpResponseHandler", abyte0.toString());
        }
        break MISSING_BLOCK_LABEL_43;
        abyte0 = new String(abyte0, getCharset());
          goto _L1
        onFailure(i, aheader, ((Throwable) (abyte0)), ((String) (null)));
        return;
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

    public void onProgress(int i, int j)
    {
    }

    public void onRetry()
    {
    }

    public void onStart()
    {
    }

    public void onSuccess(int i, String s)
    {
        onSuccess(s);
    }

    public void onSuccess(int i, Header aheader[], String s)
    {
        onSuccess(i, s);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        if (abyte0 != null)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        abyte0 = null;
_L1:
        try
        {
            onSuccess(i, aheader, ((String) (abyte0)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Log.e("AsyncHttpResponseHandler", abyte0.toString());
        }
        break MISSING_BLOCK_LABEL_41;
        abyte0 = new String(abyte0, getCharset());
          goto _L1
        onFailure(i, aheader, abyte0, ((String) (null)));
        return;
    }

    public void onSuccess(String s)
    {
    }

    protected void postRunnable(Runnable runnable)
    {
        if (runnable != null)
        {
            handler.post(runnable);
        }
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
            handler.sendMessage(message);
            return;
        }
    }

    public final void sendProgressMessage(int i, int j)
    {
        sendMessage(obtainMessage(4, ((Object) (new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }))));
    }

    public void sendResponseMessage(HttpResponse httpresponse)
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

    public final void sendRetryMessage()
    {
        sendMessage(obtainMessage(5, null));
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

    public void setUseSynchronousMode(boolean flag)
    {
        useSynchronousMode = Boolean.valueOf(flag);
    }
}
