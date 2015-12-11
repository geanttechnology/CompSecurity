// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.os.Looper;
import java.lang.ref.WeakReference;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpRequest

public class RequestHandle
{

    private final WeakReference request;

    public RequestHandle(AsyncHttpRequest asynchttprequest)
    {
        request = new WeakReference(asynchttprequest);
    }

    public boolean cancel(final boolean mayInterruptIfRunning)
    {
        final AsyncHttpRequest _request = (AsyncHttpRequest)request.get();
        if (_request != null)
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                (new Thread(new Runnable() {

                    final RequestHandle this$0;
                    final AsyncHttpRequest val$_request;
                    final boolean val$mayInterruptIfRunning;

                    public void run()
                    {
                        _request.cancel(mayInterruptIfRunning);
                    }

            
            {
                this$0 = RequestHandle.this;
                _request = asynchttprequest;
                mayInterruptIfRunning = flag;
                super();
            }
                })).start();
                return true;
            } else
            {
                return _request.cancel(mayInterruptIfRunning);
            }
        } else
        {
            return false;
        }
    }

    public Object getTag()
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        if (asynchttprequest == null)
        {
            return null;
        } else
        {
            return asynchttprequest.getTag();
        }
    }

    public boolean isCancelled()
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        return asynchttprequest == null || asynchttprequest.isCancelled();
    }

    public boolean isFinished()
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        return asynchttprequest == null || asynchttprequest.isDone();
    }

    public RequestHandle setTag(Object obj)
    {
        AsyncHttpRequest asynchttprequest = (AsyncHttpRequest)request.get();
        if (asynchttprequest != null)
        {
            asynchttprequest.setRequestTag(obj);
        }
        return this;
    }

    public boolean shouldBeGarbageCollected()
    {
        boolean flag;
        if (isCancelled() || isFinished())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            request.clear();
        }
        return flag;
    }
}
