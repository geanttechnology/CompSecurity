// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;

// Referenced classes of package android.support.v4.media:
//            MediaBrowserCompat, IMediaBrowserServiceCompat, IMediaBrowserServiceCompatCallbacks

static class mRootHints
{

    private static final int CONNECT_STATE_CONNECTED = 2;
    private static final int CONNECT_STATE_CONNECTING = 1;
    private static final int CONNECT_STATE_DISCONNECTED = 0;
    private static final int CONNECT_STATE_SUSPENDED = 3;
    private static final boolean DBG = false;
    private static final String TAG = "MediaBrowserCompat";
    private final mServiceCallbacks mCallback;
    private final Context mContext;
    private Bundle mExtras;
    private final Handler mHandler = new Handler();
    private android.support.v4.media.session.Callbacks mMediaSessionToken;
    private final Bundle mRootHints;
    private String mRootId;
    private IMediaBrowserServiceCompat mServiceBinder;
    private IMediaBrowserServiceCompatCallbacks mServiceCallbacks;
    private final ComponentName mServiceComponent;
    private MediaServiceConnection mServiceConnection;
    private int mState;
    private final ArrayMap mSubscriptions = new ArrayMap();

    private void forceCloseConnection()
    {
        if (mServiceConnection != null)
        {
            mContext.unbindService(mServiceConnection);
        }
        mState = 0;
        mServiceConnection = null;
        mServiceBinder = null;
        mServiceCallbacks = null;
        mRootId = null;
        mMediaSessionToken = null;
    }

    private ServiceCallbacks getNewServiceCallbacks()
    {
    /* block-local class not found */
    class ServiceCallbacks {}

        return new ServiceCallbacks();
    }

    private static String getStateLabel(int i)
    {
        switch (i)
        {
        default:
            return (new StringBuilder()).append("UNKNOWN/").append(i).toString();

        case 0: // '\0'
            return "CONNECT_STATE_DISCONNECTED";

        case 1: // '\001'
            return "CONNECT_STATE_CONNECTING";

        case 2: // '\002'
            return "CONNECT_STATE_CONNECTED";

        case 3: // '\003'
            return "CONNECT_STATE_SUSPENDED";
        }
    }

    private boolean isCurrent(IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks, String s)
    {
        if (mServiceCallbacks != imediabrowserservicecompatcallbacks)
        {
            if (mState != 0)
            {
                Log.i("MediaBrowserCompat", (new StringBuilder()).append(s).append(" for ").append(mServiceComponent).append(" with mServiceConnection=").append(mServiceCallbacks).append(" this=").append(this).toString());
            }
            return false;
        } else
        {
            return true;
        }
    }

    private final void onConnectionFailed(IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks)
    {
    /* block-local class not found */
    class _cls6 {}

        mHandler.post(new _cls6(imediabrowserservicecompatcallbacks));
    }

    private final void onLoadChildren(IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks, String s, List list)
    {
    /* block-local class not found */
    class _cls7 {}

        mHandler.post(new _cls7(imediabrowserservicecompatcallbacks, list, s));
    }

    private final void onServiceConnected(IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks, String s, android.support.v4.media.session. , Bundle bundle)
    {
    /* block-local class not found */
    class _cls5 {}

        mHandler.post(new _cls5(imediabrowserservicecompatcallbacks, s, , bundle));
    }

    public void connect()
    {
        MediaServiceConnection mediaserviceconnection;
        Intent intent;
        boolean flag;
        if (mState != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("connect() called while not disconnected (state=").append(getStateLabel(mState)).append(")").toString());
        }
        if (mServiceBinder != null)
        {
            throw new RuntimeException((new StringBuilder()).append("mServiceBinder should be null. Instead it is ").append(mServiceBinder).toString());
        }
        if (mServiceCallbacks != null)
        {
            throw new RuntimeException((new StringBuilder()).append("mServiceCallbacks should be null. Instead it is ").append(mServiceCallbacks).toString());
        }
        mState = 1;
        intent = new Intent("android.media.browse.MediaBrowserServiceCompat");
        intent.setComponent(mServiceComponent);
    /* block-local class not found */
    class MediaServiceConnection {}

        mediaserviceconnection = new MediaServiceConnection(null);
        mServiceConnection = mediaserviceconnection;
        flag = false;
        boolean flag1 = mContext.bindService(intent, mServiceConnection, 1);
        flag = flag1;
_L2:
    /* block-local class not found */
    class _cls1 {}

        if (!flag)
        {
            mHandler.post(new _cls1(mediaserviceconnection));
        }
        return;
        Exception exception;
        exception;
        Log.e("MediaBrowserCompat", (new StringBuilder()).append("Failed binding to service ").append(mServiceComponent).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void disconnect()
    {
        if (mServiceCallbacks != null)
        {
            try
            {
                mServiceBinder.disconnect(mServiceCallbacks);
            }
            catch (RemoteException remoteexception)
            {
                Log.w("MediaBrowserCompat", (new StringBuilder()).append("RemoteException during connect for ").append(mServiceComponent).toString());
            }
        }
        forceCloseConnection();
    }

    void dump()
    {
        Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mServiceComponent=").append(mServiceComponent).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mCallback=").append(mCallback).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mRootHints=").append(mRootHints).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mState=").append(getStateLabel(mState)).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mServiceConnection=").append(mServiceConnection).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mServiceBinder=").append(mServiceBinder).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mServiceCallbacks=").append(mServiceCallbacks).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mRootId=").append(mRootId).toString());
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("  mMediaSessionToken=").append(mMediaSessionToken).toString());
    }

    public Bundle getExtras()
    {
        if (!isConnected())
        {
            throw new IllegalStateException((new StringBuilder()).append("getExtras() called while not connected (state=").append(getStateLabel(mState)).append(")").toString());
        } else
        {
            return mExtras;
        }
    }

    public void getItem(String s, mExtras mextras)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("mediaId is empty.");
        }
        if (mextras == null)
        {
            throw new IllegalArgumentException("cb is null.");
        }
        if (mState != 2)
        {
            Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
    /* block-local class not found */
    class _cls2 {}

            mHandler.post(new _cls2(mextras, s));
            return;
        }
    /* block-local class not found */
    class _cls3 {}

        _cls3 _lcls3 = new _cls3(mHandler, mextras, s);
        try
        {
            mServiceBinder.getMediaItem(s, _lcls3);
            return;
        }
        catch (RemoteException remoteexception)
        {
            Log.i("MediaBrowserCompat", "Remote error getting media item.");
        }
    /* block-local class not found */
    class _cls4 {}

        mHandler.post(new _cls4(mextras, s));
    }

    public String getRoot()
    {
        if (!isConnected())
        {
            throw new IllegalStateException((new StringBuilder()).append("getSessionToken() called while not connected(state=").append(getStateLabel(mState)).append(")").toString());
        } else
        {
            return mRootId;
        }
    }

    public ComponentName getServiceComponent()
    {
        if (!isConnected())
        {
            throw new IllegalStateException((new StringBuilder()).append("getServiceComponent() called while not connected (state=").append(mState).append(")").toString());
        } else
        {
            return mServiceComponent;
        }
    }

    public android.support.v4.media.session.Component getSessionToken()
    {
        if (!isConnected())
        {
            throw new IllegalStateException((new StringBuilder()).append("getSessionToken() called while not connected(state=").append(mState).append(")").toString());
        } else
        {
            return mMediaSessionToken;
        }
    }

    public boolean isConnected()
    {
        return mState == 2;
    }

    public void subscribe(String s, mState mstate)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("parentId is null");
        }
        if (mstate == null)
        {
            throw new IllegalArgumentException("callback is null");
        }
    /* block-local class not found */
    class Subscription {}

        Subscription subscription = (Subscription)mSubscriptions.get(s);
        boolean flag;
        if (subscription == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            subscription = new Subscription(s);
            mSubscriptions.put(s, subscription);
        }
        subscription.callback = mstate;
        if (mState != 2)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        mServiceBinder.addSubscription(s, mServiceCallbacks);
        return;
        mstate;
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("addSubscription failed with RemoteException parentId=").append(s).toString());
        return;
    }

    public void unsubscribe(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("parentId is empty.");
        }
        Subscription subscription = (Subscription)mSubscriptions.remove(s);
        if (mState != 2 || subscription == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        mServiceBinder.removeSubscription(s, mServiceCallbacks);
        return;
        RemoteException remoteexception;
        remoteexception;
        Log.d("MediaBrowserCompat", (new StringBuilder()).append("removeSubscription failed with RemoteException parentId=").append(s).toString());
        return;
    }


/*
    static Bundle access$1002(ServiceCallbacks servicecallbacks, Bundle bundle)
    {
        servicecallbacks.mExtras = bundle;
        return bundle;
    }

*/




/*
    static IMediaBrowserServiceCompatCallbacks access$1202(mExtras mextras, IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks)
    {
        mextras.mServiceCallbacks = imediabrowserservicecompatcallbacks;
        return imediabrowserservicecompatcallbacks;
    }

*/



/*
    static IMediaBrowserServiceCompat access$1302(mServiceCallbacks mservicecallbacks, IMediaBrowserServiceCompat imediabrowserservicecompat)
    {
        mservicecallbacks.mServiceBinder = imediabrowserservicecompat;
        return imediabrowserservicecompat;
    }

*/














/*
    static int access$602(MediaServiceConnection mediaserviceconnection, int i)
    {
        mediaserviceconnection.mState = i;
        return i;
    }

*/



/*
    static String access$802(mState mstate, String s)
    {
        mstate.mRootId = s;
        return s;
    }

*/


/*
    static android.support.v4.media.session.viceConnection access$902(mRootId mrootid, android.support.v4.media.session.viceConnection viceconnection)
    {
        mrootid.mMediaSessionToken = viceconnection;
        return viceconnection;
    }

*/

    public mMediaSessionToken(Context context, ComponentName componentname, mMediaSessionToken mmediasessiontoken, Bundle bundle)
    {
        mState = 0;
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        if (componentname == null)
        {
            throw new IllegalArgumentException("service component must not be null");
        }
        if (mmediasessiontoken == null)
        {
            throw new IllegalArgumentException("connection callback must not be null");
        } else
        {
            mContext = context;
            mServiceComponent = componentname;
            mCallback = mmediasessiontoken;
            mRootHints = bundle;
            return;
        }
    }
}
