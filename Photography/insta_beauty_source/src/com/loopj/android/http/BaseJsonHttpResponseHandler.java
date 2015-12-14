// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import org.apache.http.Header;

// Referenced classes of package com.loopj.android.http:
//            TextHttpResponseHandler

public abstract class BaseJsonHttpResponseHandler extends TextHttpResponseHandler
{

    private static final String LOG_TAG = "BaseJsonHttpResponseHandler";

    public BaseJsonHttpResponseHandler()
    {
        this("UTF-8");
    }

    public BaseJsonHttpResponseHandler(String s)
    {
        super(s);
    }

    public final void onFailure(final int statusCode, final Header headers[], final String responseString, final Throwable throwable)
    {
        if (responseString != null)
        {
            headers = new _cls2();
            if (!getUseSynchronousMode())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            onFailure(statusCode, headers, throwable, null, null);
            return;
        }
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, String s, Object obj);

    public final void onSuccess(final int statusCode, final Header headers[], final String responseString)
    {
        if (statusCode != 204)
        {
            headers = new _cls1();
            if (!getUseSynchronousMode())
            {
                (new Thread(headers)).start();
                return;
            } else
            {
                headers.run();
                return;
            }
        } else
        {
            onSuccess(statusCode, headers, null, null);
            return;
        }
    }

    public abstract void onSuccess(int i, Header aheader[], String s, Object obj);

    protected abstract Object parseResponse(String s, boolean flag);

    private class _cls2
        implements Runnable
    {

        final BaseJsonHttpResponseHandler this$0;
        final Header val$headers[];
        final String val$responseString;
        final int val$statusCode;
        final Throwable val$throwable;

        public void run()
        {
            try
            {
                final Object jsonResponse = parseResponse(responseString, true);
                class _cls1
                    implements Runnable
                {

                    final _cls2 this$1;
                    final Object val$jsonResponse;

                    public void run()
                    {
                        onFailure(statusCode, headers, throwable, responseString, jsonResponse);
                    }

                _cls1()
                {
                    this$1 = _cls2.this;
                    jsonResponse = obj;
                    super();
                }
                }

                postRunnable(new _cls1());
                return;
            }
            catch (Throwable throwable1)
            {
                Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", throwable1);
            }
            class _cls2
                implements Runnable
            {

                final _cls2 this$1;

                public void run()
                {
                    onFailure(statusCode, headers, throwable, responseString, null);
                }

                _cls2()
                {
                    this$1 = _cls2.this;
                    super();
                }
            }

            postRunnable(new _cls2());
        }

        _cls2()
        {
            this$0 = BaseJsonHttpResponseHandler.this;
            responseString = s;
            statusCode = i;
            headers = aheader;
            throwable = throwable1;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final BaseJsonHttpResponseHandler this$0;
        final Header val$headers[];
        final String val$responseString;
        final int val$statusCode;

        public void run()
        {
            try
            {
                final Object jsonResponse = parseResponse(responseString, false);
                class _cls1
                    implements Runnable
                {

                    final _cls1 this$1;
                    final Object val$jsonResponse;

                    public void run()
                    {
                        onSuccess(statusCode, headers, responseString, jsonResponse);
                    }

                _cls1()
                {
                    this$1 = _cls1.this;
                    jsonResponse = obj;
                    super();
                }
                }

                postRunnable(new _cls1());
                return;
            }
            catch (final Throwable t)
            {
                Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", t);
                class _cls2
                    implements Runnable
                {

                    final _cls1 this$1;
                    final Throwable val$t;

                    public void run()
                    {
                        onFailure(statusCode, headers, t, responseString, null);
                    }

                _cls2()
                {
                    this$1 = _cls1.this;
                    t = throwable;
                    super();
                }
                }

                postRunnable(new _cls2());
                return;
            }
        }

        _cls1()
        {
            this$0 = BaseJsonHttpResponseHandler.this;
            responseString = s;
            statusCode = i;
            headers = aheader;
            super();
        }
    }

}
