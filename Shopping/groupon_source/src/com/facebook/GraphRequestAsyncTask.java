// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook:
//            GraphRequestBatch, GraphRequest, FacebookSdk

public class GraphRequestAsyncTask extends AsyncTask
{

    private static final String TAG = com/facebook/GraphRequestAsyncTask.getCanonicalName();
    private static Method executeOnExecutorMethod;
    private final HttpURLConnection connection;
    private Exception exception;
    private final GraphRequestBatch requests;

    public GraphRequestAsyncTask(GraphRequestBatch graphrequestbatch)
    {
        this(null, graphrequestbatch);
    }

    public GraphRequestAsyncTask(HttpURLConnection httpurlconnection, GraphRequestBatch graphrequestbatch)
    {
        requests = graphrequestbatch;
        connection = httpurlconnection;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient List doInBackground(Void avoid[])
    {
        try
        {
            if (connection == null)
            {
                return requests.executeAndWait();
            }
            avoid = GraphRequest.executeConnectionAndWait(connection, requests);
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            exception = avoid;
            return null;
        }
        return avoid;
    }

    GraphRequestAsyncTask executeOnSettingsExecutor()
    {
        if (executeOnExecutorMethod != null)
        {
            try
            {
                executeOnExecutorMethod.invoke(this, new Object[] {
                    FacebookSdk.getExecutor(), null
                });
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                return this;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                return this;
            }
            return this;
        } else
        {
            execute(new Void[0]);
            return this;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        super.onPostExecute(list);
        if (exception != null)
        {
            Log.d(TAG, String.format("onPostExecute: exception encountered during request: %s", new Object[] {
                exception.getMessage()
            }));
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        if (requests.getCallbackHandler() == null)
        {
            requests.setCallbackHandler(new Handler());
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("{RequestAsyncTask: ").append(" connection: ").append(connection).append(", requests: ").append(requests).append("}").toString();
    }

    static 
    {
        Method amethod[] = android/os/AsyncTask.getMethods();
        int j = amethod.length;
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    Method method = amethod[i];
                    if (!"executeOnExecutor".equals(method.getName()))
                    {
                        break label0;
                    }
                    Class aclass[] = method.getParameterTypes();
                    if (aclass.length != 2 || aclass[0] != java/util/concurrent/Executor || !aclass[1].isArray())
                    {
                        break label0;
                    }
                    executeOnExecutorMethod = method;
                }
                return;
            }
            i++;
        } while (true);
    }
}
