// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import android.content.Context;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

// Referenced classes of package co.vine.android.network:
//            HttpOperationClient

public class ThreadedHttpOperationClient extends HttpOperationClient
{

    private static ThreadedHttpOperationClient sInstance = null;
    private ClientConnectionManager mConnectionManager;
    private final Context mContext;
    private HttpClient mHttpClient;

    private ThreadedHttpOperationClient(Context context)
    {
        mContext = context.getApplicationContext();
        initialize();
    }

    public static ThreadedHttpOperationClient getInstance(Context context)
    {
        co/vine/android/network/ThreadedHttpOperationClient;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new ThreadedHttpOperationClient(context.getApplicationContext());
        }
        context = sInstance;
        co/vine/android/network/ThreadedHttpOperationClient;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void initialize()
    {
        HttpParams httpparams = initializeHttpParams();
        mConnectionManager = initializeConnectionManager(httpparams, initializeSchemeRegistry(mContext));
        mHttpClient = initializeHttpClient(mContext, mConnectionManager, httpparams);
    }

    private ClientConnectionManager initializeConnectionManager(HttpParams httpparams, SchemeRegistry schemeregistry)
    {
        return new ThreadSafeClientConnManager(httpparams, schemeregistry);
    }

    public HttpClient getHttpClient()
    {
        return mHttpClient;
    }

    public void restart()
    {
        mConnectionManager.shutdown();
        initialize();
    }

    public void shutdown()
    {
        mConnectionManager.shutdown();
    }

}
