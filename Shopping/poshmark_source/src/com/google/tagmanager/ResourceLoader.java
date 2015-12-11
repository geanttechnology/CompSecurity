// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.FileNotFoundException;
import java.io.IOException;

// Referenced classes of package com.google.tagmanager:
//            NetworkClientFactory, LoadCallback, Log, NetworkClient, 
//            ProtoExtensionRegistry, CtfeHost, PreviewManager

class ResourceLoader
    implements Runnable
{

    private static final String CTFE_URL_PREFIX = "/r?id=";
    private static final String CTFE_URL_SUFFIX = "&v=a50788154";
    private static final String PREVIOUS_CONTAINER_VERSION_QUERY_NAME = "pv";
    static final String SDK_VERSION = "a50788154";
    private LoadCallback mCallback;
    private final NetworkClientFactory mClientFactory;
    private final String mContainerId;
    private final Context mContext;
    private volatile CtfeHost mCtfeHost;
    private volatile String mCtfeUrlPathAndQuery;
    private final String mDefaultCtfeUrlPathAndQuery;
    private volatile String mPreviousVersion;

    public ResourceLoader(Context context, String s, CtfeHost ctfehost)
    {
        this(context, s, new NetworkClientFactory(), ctfehost);
    }

    ResourceLoader(Context context, String s, NetworkClientFactory networkclientfactory, CtfeHost ctfehost)
    {
        mContext = context;
        mClientFactory = networkclientfactory;
        mContainerId = s;
        mCtfeHost = ctfehost;
        mDefaultCtfeUrlPathAndQuery = (new StringBuilder()).append("/r?id=").append(s).toString();
        mCtfeUrlPathAndQuery = mDefaultCtfeUrlPathAndQuery;
        mPreviousVersion = null;
    }

    private void loadResource()
    {
        NetworkClient networkclient;
        String s;
        if (!okToLoad())
        {
            mCallback.onFailure(LoadCallback.Failure.NOT_AVAILABLE);
            return;
        }
        Log.v("Start loading resource from network ...");
        s = getCtfeUrl();
        networkclient = mClientFactory.createNetworkClient();
        Object obj = networkclient.getInputStream(s);
        LoadCallback loadcallback;
        obj = com.google.analytics.containertag.proto.Serving.OptionalResource.parseFrom(((java.io.InputStream) (obj)), ProtoExtensionRegistry.getRegistry());
        Log.v((new StringBuilder()).append("Successfully loaded resource: ").append(obj).toString());
        if (!((com.google.analytics.containertag.proto.Serving.OptionalResource) (obj)).hasResource())
        {
            Log.v((new StringBuilder()).append("No change for container: ").append(mContainerId).toString());
        }
        loadcallback = mCallback;
        if (!((com.google.analytics.containertag.proto.Serving.OptionalResource) (obj)).hasResource())
        {
            break MISSING_BLOCK_LABEL_260;
        }
        obj = ((com.google.analytics.containertag.proto.Serving.OptionalResource) (obj)).getResource();
_L1:
        loadcallback.onSuccess(obj);
        networkclient.close();
        Log.v("Load resource from network finished.");
        return;
        obj;
        Log.w((new StringBuilder()).append("No data is retrieved from the given url: ").append(s).append(". Make sure container_id: ").append(mContainerId).append(" is correct.").toString());
        mCallback.onFailure(LoadCallback.Failure.SERVER_ERROR);
        networkclient.close();
        return;
        obj;
        Log.w((new StringBuilder()).append("Error when loading resources from url: ").append(s).append(" ").append(((IOException) (obj)).getMessage()).toString(), ((Throwable) (obj)));
        mCallback.onFailure(LoadCallback.Failure.IO_ERROR);
        networkclient.close();
        return;
        obj = null;
          goto _L1
        Object obj1;
        obj1;
        Log.w((new StringBuilder()).append("Error when parsing downloaded resources from url: ").append(s).append(" ").append(((IOException) (obj1)).getMessage()).toString(), ((Throwable) (obj1)));
        mCallback.onFailure(LoadCallback.Failure.SERVER_ERROR);
        networkclient.close();
        return;
        obj1;
        networkclient.close();
        throw obj1;
    }

    private boolean okToLoad()
    {
        NetworkInfo networkinfo = ((ConnectivityManager)mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            Log.v("...no network connectivity");
            return false;
        } else
        {
            return true;
        }
    }

    String getCtfeUrl()
    {
        String s1 = (new StringBuilder()).append(mCtfeHost.getCtfeServerAddress()).append(mCtfeUrlPathAndQuery).append("&v=a50788154").toString();
        String s = s1;
        if (mPreviousVersion != null)
        {
            s = s1;
            if (!mPreviousVersion.trim().equals(""))
            {
                s = (new StringBuilder()).append(s1).append("&pv=").append(mPreviousVersion).toString();
            }
        }
        s1 = s;
        if (PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG))
        {
            s1 = (new StringBuilder()).append(s).append("&gtm_debug=x").toString();
        }
        return s1;
    }

    public void run()
    {
        if (mCallback == null)
        {
            throw new IllegalStateException("callback must be set before execute");
        } else
        {
            mCallback.startLoad();
            loadResource();
            return;
        }
    }

    void setCtfeURLPathAndQuery(String s)
    {
        if (s == null)
        {
            mCtfeUrlPathAndQuery = mDefaultCtfeUrlPathAndQuery;
            return;
        } else
        {
            Log.d((new StringBuilder()).append("Setting CTFE URL path: ").append(s).toString());
            mCtfeUrlPathAndQuery = s;
            return;
        }
    }

    void setLoadCallback(LoadCallback loadcallback)
    {
        mCallback = loadcallback;
    }

    void setPreviousVersion(String s)
    {
        Log.d((new StringBuilder()).append("Setting previous container version: ").append(s).toString());
        mPreviousVersion = s;
    }
}
