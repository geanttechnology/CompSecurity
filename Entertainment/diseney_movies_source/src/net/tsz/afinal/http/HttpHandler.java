// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http;

import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.core.AsyncTask;
import net.tsz.afinal.http.entityhandler.EntityCallBack;
import net.tsz.afinal.http.entityhandler.FileEntityHandler;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package net.tsz.afinal.http:
//            AjaxCallBack

public class HttpHandler extends AsyncTask
    implements EntityCallBack
{

    private static final int UPDATE_FAILURE = 3;
    private static final int UPDATE_LOADING = 2;
    private static final int UPDATE_START = 1;
    private static final int UPDATE_SUCCESS = 4;
    private final AjaxCallBack callback;
    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private HttpResponse httpResponse;
    private HttpUriRequest httpUriRequest;
    private boolean isResume;
    private final FileEntityHandler mFileEntityHandler = new FileEntityHandler();
    private final StringEntityHandler mStrEntityHandler = new StringEntityHandler();
    private String targetUrl;
    private long time;

    public HttpHandler(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, AjaxCallBack ajaxcallback, String s)
    {
        executionCount = 0;
        targetUrl = null;
        isResume = false;
        client = abstracthttpclient;
        context = httpcontext;
        callback = ajaxcallback;
        charset = s;
    }

    private void handleResponse(HttpResponse httpresponse)
    {
        org.apache.http.HttpEntity httpentity;
        httpResponse = httpresponse;
        StatusLine statusline = httpresponse.getStatusLine();
        if (statusline.getStatusCode() >= 300)
        {
            String s = (new StringBuilder("response status error code:")).append(statusline.getStatusCode()).toString();
            httpresponse = s;
            if (statusline.getStatusCode() == 416)
            {
                httpresponse = s;
                if (isResume)
                {
                    httpresponse = (new StringBuilder(String.valueOf(s))).append(" \n maybe you have download complete.").toString();
                }
            }
            publishProgress(new Object[] {
                Integer.valueOf(3), new HttpResponseException(statusline.getStatusCode(), statusline.getReasonPhrase()), httpresponse
            });
            return;
        }
        try
        {
            httpentity = httpresponse.getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            publishProgress(new Object[] {
                Integer.valueOf(3), httpresponse, httpresponse.getMessage()
            });
            return;
        }
        httpresponse = null;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_176;
        }
        time = SystemClock.uptimeMillis();
        if (targetUrl == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        httpresponse = ((HttpResponse) (mFileEntityHandler.handleEntity(httpentity, this, targetUrl, isResume)));
_L1:
        publishProgress(new Object[] {
            Integer.valueOf(4), httpresponse
        });
        return;
        httpresponse = ((HttpResponse) (mStrEntityHandler.handleEntity(httpentity, this, charset)));
          goto _L1
    }

    private void makeRequestWithRetries(HttpUriRequest httpurirequest)
        throws IOException
    {
        httpUriRequest = httpurirequest;
        if (isResume && targetUrl != null)
        {
            File file = new File(targetUrl);
            long l1 = 0L;
            long l = l1;
            if (file.isFile())
            {
                l = l1;
                if (file.exists())
                {
                    l = file.length();
                }
            }
            if (l > 0L)
            {
                httpurirequest.setHeader("RANGE", (new StringBuilder("bytes=")).append(l).append("-").toString());
            }
        }
        boolean flag = true;
        Object obj = null;
        HttpRequestRetryHandler httprequestretryhandler = client.getHttpRequestRetryHandler();
        do
        {
            if (!flag)
            {
                if (obj != null)
                {
                    throw obj;
                } else
                {
                    throw new IOException("\u672A\u77E5\u7F51\u7EDC\u9519\u8BEF");
                }
            }
            try
            {
                if (!isCancelled())
                {
                    obj = client.execute(httpurirequest, context);
                    if (!isCancelled())
                    {
                        handleResponse(((HttpResponse) (obj)));
                    }
                }
                return;
            }
            // Misplaced declaration of an exception variable
            catch (HttpUriRequest httpurirequest)
            {
                publishProgress(new Object[] {
                    Integer.valueOf(3), httpurirequest, "unknownHostException\uFF1Acan't resolve host"
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                int i = executionCount + 1;
                executionCount = i;
                flag = httprequestretryhandler.retryRequest(((IOException) (obj)), i, context);
            }
            catch (NullPointerException nullpointerexception)
            {
                nullpointerexception = new IOException((new StringBuilder("NPE in HttpClient")).append(nullpointerexception.getMessage()).toString());
                int j = executionCount + 1;
                executionCount = j;
                flag = httprequestretryhandler.retryRequest(nullpointerexception, j, context);
            }
            catch (Exception exception)
            {
                exception = new IOException((new StringBuilder("Exception")).append(exception.getMessage()).toString());
                int k = executionCount + 1;
                executionCount = k;
                flag = httprequestretryhandler.retryRequest(exception, k, context);
            }
        } while (true);
    }

    public void callBack(long l, long l1, boolean flag)
    {
        if (callback != null && callback.isProgress())
        {
            if (flag)
            {
                publishProgress(new Object[] {
                    Integer.valueOf(2), Long.valueOf(l), Long.valueOf(l1)
                });
            } else
            {
                long l2 = SystemClock.uptimeMillis();
                if (l2 - time >= (long)callback.getRate())
                {
                    time = l2;
                    publishProgress(new Object[] {
                        Integer.valueOf(2), Long.valueOf(l), Long.valueOf(l1)
                    });
                    return;
                }
            }
        }
    }

    protected transient Object doInBackground(Object aobj[])
    {
        if (aobj != null && aobj.length == 3)
        {
            targetUrl = String.valueOf(aobj[1]);
            isResume = ((Boolean)aobj[2]).booleanValue();
        }
        try
        {
            publishProgress(new Object[] {
                Integer.valueOf(1)
            });
            makeRequestWithRetries((HttpUriRequest)aobj[0]);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            publishProgress(new Object[] {
                Integer.valueOf(3), aobj, ((IOException) (aobj)).getMessage()
            });
        }
        return null;
    }

    public HttpResponse getHttpResponse()
    {
        return httpResponse;
    }

    public HttpUriRequest getHttpUriRequest()
    {
        return httpUriRequest;
    }

    public boolean isStop()
    {
        return mFileEntityHandler.isStop();
    }

    protected transient void onProgressUpdate(Object aobj[])
    {
        Integer.valueOf(String.valueOf(aobj[0])).intValue();
        JVM INSTR tableswitch 1 4: default 44
    //                   1 50
    //                   2 67
    //                   3 108
    //                   4 137;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        super.onProgressUpdate(aobj);
        return;
_L2:
        if (callback != null)
        {
            callback.onStart();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (callback != null)
        {
            callback.onLoading(Long.valueOf(String.valueOf(aobj[1])).longValue(), Long.valueOf(String.valueOf(aobj[2])).longValue());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (callback != null)
        {
            callback.onFailure((Throwable)aobj[1], (String)aobj[2]);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (callback != null)
        {
            callback.onSuccess(aobj[1]);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setHttpResponse(HttpResponse httpresponse)
    {
        httpResponse = httpresponse;
    }

    public void setHttpUriRequest(HttpUriRequest httpurirequest)
    {
        httpUriRequest = httpurirequest;
    }

    public void setRate(int i)
    {
        if (callback != null)
        {
            callback.setRate(i);
        }
    }

    public void stop()
    {
        mFileEntityHandler.setStop(true);
    }
}
