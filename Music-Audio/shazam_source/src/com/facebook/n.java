// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.net.HttpURLConnection;
import java.util.List;

// Referenced classes of package com.facebook:
//            GraphRequest, k, o

public class n extends AsyncTask
{

    private static final String a = com/facebook/n.getCanonicalName();
    private final HttpURLConnection b;
    private final o c;
    private Exception d;

    public n(o o1)
    {
        this(o1, (byte)0);
    }

    private n(o o1, byte byte0)
    {
        c = o1;
        b = null;
    }

    private transient List a()
    {
        List list;
        try
        {
            if (b == null)
            {
                return GraphRequest.a(c);
            }
            list = GraphRequest.a(b, c);
        }
        catch (Exception exception)
        {
            d = exception;
            return null;
        }
        return list;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected void onPostExecute(Object obj)
    {
        super.onPostExecute((List)obj);
        if (d != null)
        {
            String.format("onPostExecute: exception encountered during request: %s", new Object[] {
                d.getMessage()
            });
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (k.b())
        {
            String.format("execute async task: %s", new Object[] {
                this
            });
        }
        if (c.a == null)
        {
            Handler handler;
            if (Thread.currentThread() instanceof HandlerThread)
            {
                handler = new Handler();
            } else
            {
                handler = new Handler(Looper.getMainLooper());
            }
            c.a = handler;
        }
    }

    public String toString()
    {
        return (new StringBuilder("{RequestAsyncTask:  connection: ")).append(b).append(", requests: ").append(c).append("}").toString();
    }

}
