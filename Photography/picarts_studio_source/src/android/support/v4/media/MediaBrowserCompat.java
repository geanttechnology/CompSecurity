// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;

public final class MediaBrowserCompat
{

    private final MediaBrowserImplBase mImpl;

    public MediaBrowserCompat(Context context, ComponentName componentname, ConnectionCallback connectioncallback, Bundle bundle)
    {
        mImpl = new MediaBrowserImplBase(context, componentname, connectioncallback, bundle);
    }

    public final void connect()
    {
        mImpl.connect();
    }

    public final void disconnect()
    {
        mImpl.disconnect();
    }

    public final Bundle getExtras()
    {
        return mImpl.getExtras();
    }

    public final void getItem(String s, ItemCallback itemcallback)
    {
        mImpl.getItem(s, itemcallback);
    }

    public final String getRoot()
    {
        return mImpl.getRoot();
    }

    public final ComponentName getServiceComponent()
    {
        return mImpl.getServiceComponent();
    }

    public final android.support.v4.media.session.MediaSessionCompat.Token getSessionToken()
    {
        return mImpl.getSessionToken();
    }

    public final boolean isConnected()
    {
        return mImpl.isConnected();
    }

    public final void subscribe(String s, SubscriptionCallback subscriptioncallback)
    {
        mImpl.subscribe(s, subscriptioncallback);
    }

    public final void unsubscribe(String s)
    {
        mImpl.unsubscribe(s);
    }

    private class MediaBrowserImplBase
    {

        private static final int CONNECT_STATE_CONNECTED = 2;
        private static final int CONNECT_STATE_CONNECTING = 1;
        private static final int CONNECT_STATE_DISCONNECTED = 0;
        private static final int CONNECT_STATE_SUSPENDED = 3;
        private static final boolean DBG = false;
        private static final String TAG = "MediaBrowserCompat";
        private final ConnectionCallback mCallback;
        private final Context mContext;
        private Bundle mExtras;
        private final Handler mHandler = new Handler();
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
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
            class ServiceCallbacks extends IMediaBrowserServiceCompatCallbacks.Stub
            {

                private WeakReference mMediaBrowser;

                public void onConnect(String s, android.support.v4.media.session.MediaSessionCompat.Token token, Bundle bundle)
                {
                    MediaBrowserImplBase mediabrowserimplbase = (MediaBrowserImplBase)mMediaBrowser.get();
                    if (mediabrowserimplbase != null)
                    {
                        mediabrowserimplbase.onServiceConnected(this, s, token, bundle);
                    }
                }

                public void onConnectFailed()
                {
                    MediaBrowserImplBase mediabrowserimplbase = (MediaBrowserImplBase)mMediaBrowser.get();
                    if (mediabrowserimplbase != null)
                    {
                        mediabrowserimplbase.onConnectionFailed(this);
                    }
                }

                public void onLoadChildren(String s, List list)
                {
                    MediaBrowserImplBase mediabrowserimplbase = (MediaBrowserImplBase)mMediaBrowser.get();
                    if (mediabrowserimplbase != null)
                    {
                        mediabrowserimplbase.onLoadChildren(this, s, list);
                    }
                }

                public ServiceCallbacks()
                {
                    mMediaBrowser = new WeakReference(MediaBrowserImplBase.this);
                }
            }

            return new ServiceCallbacks();
        }

        private static String getStateLabel(int i)
        {
            switch (i)
            {
            default:
                return (new StringBuilder("UNKNOWN/")).append(i).toString();

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

        private final void onConnectionFailed(final IMediaBrowserServiceCompatCallbacks callback)
        {
            mHandler.post(new Runnable() {

                final MediaBrowserImplBase this$0;
                final IMediaBrowserServiceCompatCallbacks val$callback;

                public void run()
                {
                    Log.e("MediaBrowserCompat", (new StringBuilder("onConnectFailed for ")).append(mServiceComponent).toString());
                    if (!isCurrent(callback, "onConnectFailed"))
                    {
                        return;
                    }
                    if (mState != 1)
                    {
                        Log.w("MediaBrowserCompat", (new StringBuilder("onConnect from service while mState=")).append(MediaBrowserImplBase.getStateLabel(mState)).append("... ignoring").toString());
                        return;
                    } else
                    {
                        forceCloseConnection();
                        mCallback.onConnectionFailed();
                        return;
                    }
                }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    callback = imediabrowserservicecompatcallbacks;
                    super();
                }

                private class ConnectionCallback
                {

                    public void onConnected()
                    {
                    }

                    public void onConnectionFailed()
                    {
                    }

                    public void onConnectionSuspended()
                    {
                    }

                    public ConnectionCallback()
                    {
                    }
                }

            });
        }

        private final void onLoadChildren(final IMediaBrowserServiceCompatCallbacks callback, final String parentId, final List list)
        {
            mHandler.post(new Runnable() {

                final MediaBrowserImplBase this$0;
                final IMediaBrowserServiceCompatCallbacks val$callback;
                final List val$list;
                final String val$parentId;

                public void run()
                {
                    if (isCurrent(callback, "onLoadChildren"))
                    {
                        List list1 = list;
                        if (list1 == null)
                        {
                            list1 = Collections.emptyList();
                        }
                        class Subscription
                        {

                            SubscriptionCallback callback;
                            final String id;

                            Subscription(String s)
                            {
                                id = s;
                            }
                        }

                        Subscription subscription = (Subscription)mSubscriptions.get(parentId);
                        if (subscription != null)
                        {
                            subscription.callback.onChildrenLoaded(parentId, list1);
                            return;
                        }
                    }
                }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    callback = imediabrowserservicecompatcallbacks;
                    list = list1;
                    parentId = s;
                    super();
                }

                private class SubscriptionCallback
                {

                    public void onChildrenLoaded(String s, List list1)
                    {
                    }

                    public void onError(String s)
                    {
                    }

                    public SubscriptionCallback()
                    {
                    }
                }

            });
        }

        private final void onServiceConnected(final IMediaBrowserServiceCompatCallbacks callback, final String root, final android.support.v4.media.session.MediaSessionCompat.Token session, final Bundle extra)
        {
            mHandler.post(new Runnable() {

                final MediaBrowserImplBase this$0;
                final IMediaBrowserServiceCompatCallbacks val$callback;
                final Bundle val$extra;
                final String val$root;
                final android.support.v4.media.session.MediaSessionCompat.Token val$session;

                public void run()
                {
                    if (isCurrent(callback, "onConnect"))
                    {
                        if (mState != 1)
                        {
                            Log.w("MediaBrowserCompat", (new StringBuilder("onConnect from service while mState=")).append(MediaBrowserImplBase.getStateLabel(mState)).append("... ignoring").toString());
                            return;
                        }
                        mRootId = root;
                        mMediaSessionToken = session;
                        mExtras = extra;
                        mState = 2;
                        mCallback.onConnected();
                        Iterator iterator = mSubscriptions.keySet().iterator();
                        while (iterator.hasNext()) 
                        {
                            String s = (String)iterator.next();
                            try
                            {
                                mServiceBinder.addSubscription(s, mServiceCallbacks);
                            }
                            catch (RemoteException remoteexception) { }
                        }
                    }
                }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    callback = imediabrowserservicecompatcallbacks;
                    root = s;
                    session = token;
                    extra = bundle;
                    super();
                }
            });
        }

        public void connect()
        {
            final MediaServiceConnection thisConnection;
            Intent intent;
            boolean flag;
            if (mState != 0)
            {
                throw new IllegalStateException((new StringBuilder("connect() called while not disconnected (state=")).append(getStateLabel(mState)).append(")").toString());
            }
            if (mServiceBinder != null)
            {
                throw new RuntimeException((new StringBuilder("mServiceBinder should be null. Instead it is ")).append(mServiceBinder).toString());
            }
            if (mServiceCallbacks != null)
            {
                throw new RuntimeException((new StringBuilder("mServiceCallbacks should be null. Instead it is ")).append(mServiceCallbacks).toString());
            }
            mState = 1;
            intent = new Intent("android.media.browse.MediaBrowserServiceCompat");
            intent.setComponent(mServiceComponent);
            class MediaServiceConnection
                implements ServiceConnection
            {

                final MediaBrowserImplBase this$0;

                private boolean isCurrent(String s)
                {
                    if (mServiceConnection != this)
                    {
                        if (mState != 0)
                        {
                            Log.i("MediaBrowserCompat", (new StringBuilder()).append(s).append(" for ").append(mServiceComponent).append(" with mServiceConnection=").append(mServiceConnection).append(" this=").append(this).toString());
                        }
                        return false;
                    } else
                    {
                        return true;
                    }
                }

                public void onServiceConnected(ComponentName componentname, IBinder ibinder)
                {
                    if (!isCurrent("onServiceConnected"))
                    {
                        return;
                    }
                    mServiceBinder = IMediaBrowserServiceCompat.Stub.asInterface(ibinder);
                    mServiceCallbacks = getNewServiceCallbacks();
                    mState = 1;
                    try
                    {
                        mServiceBinder.connect(mContext.getPackageName(), mRootHints, mServiceCallbacks);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (ComponentName componentname)
                    {
                        Log.w("MediaBrowserCompat", (new StringBuilder("RemoteException during connect for ")).append(mServiceComponent).toString());
                    }
                }

                public void onServiceDisconnected(ComponentName componentname)
                {
                    if (!isCurrent("onServiceDisconnected"))
                    {
                        return;
                    } else
                    {
                        mServiceBinder = null;
                        mServiceCallbacks = null;
                        mState = 3;
                        mCallback.onConnectionSuspended();
                        return;
                    }
                }

                private MediaServiceConnection()
                {
                    this$0 = MediaBrowserImplBase.this;
                    super();
                }

            }

            thisConnection = new MediaServiceConnection();
            mServiceConnection = thisConnection;
            flag = false;
            boolean flag1 = mContext.bindService(intent, mServiceConnection, 1);
            flag = flag1;
_L2:
            if (!flag)
            {
                mHandler.post(new Runnable() {

                    final MediaBrowserImplBase this$0;
                    final ServiceConnection val$thisConnection;

                    public void run()
                    {
                        if (thisConnection == mServiceConnection)
                        {
                            forceCloseConnection();
                            mCallback.onConnectionFailed();
                        }
                    }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    thisConnection = serviceconnection;
                    super();
                }
                });
            }
            return;
            Exception exception;
            exception;
            Log.e("MediaBrowserCompat", (new StringBuilder("Failed binding to service ")).append(mServiceComponent).toString());
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
                    Log.w("MediaBrowserCompat", (new StringBuilder("RemoteException during connect for ")).append(mServiceComponent).toString());
                }
            }
            forceCloseConnection();
        }

        void dump()
        {
            (new StringBuilder("  mServiceComponent=")).append(mServiceComponent);
            (new StringBuilder("  mCallback=")).append(mCallback);
            (new StringBuilder("  mRootHints=")).append(mRootHints);
            (new StringBuilder("  mState=")).append(getStateLabel(mState));
            (new StringBuilder("  mServiceConnection=")).append(mServiceConnection);
            (new StringBuilder("  mServiceBinder=")).append(mServiceBinder);
            (new StringBuilder("  mServiceCallbacks=")).append(mServiceCallbacks);
            (new StringBuilder("  mRootId=")).append(mRootId);
            (new StringBuilder("  mMediaSessionToken=")).append(mMediaSessionToken);
        }

        public Bundle getExtras()
        {
            if (!isConnected())
            {
                throw new IllegalStateException((new StringBuilder("getExtras() called while not connected (state=")).append(getStateLabel(mState)).append(")").toString());
            } else
            {
                return mExtras;
            }
        }

        public void getItem(final String mediaId, final ItemCallback cb)
        {
            if (TextUtils.isEmpty(mediaId))
            {
                throw new IllegalArgumentException("mediaId is empty.");
            }
            if (cb == null)
            {
                throw new IllegalArgumentException("cb is null.");
            }
            if (mState != 2)
            {
                Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
                mHandler.post(new Runnable() {

                    final MediaBrowserImplBase this$0;
                    final ItemCallback val$cb;
                    final String val$mediaId;

                    public void run()
                    {
                        cb.onError(mediaId);
                    }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    cb = itemcallback;
                    mediaId = s;
                    super();
                }

                    private class ItemCallback
                    {

                        public void onError(String s)
                        {
                        }

                        public void onItemLoaded(MediaItem mediaitem)
                        {
                        }

                        public ItemCallback()
                        {
                        }
                    }

                });
                return;
            }
            ResultReceiver resultreceiver = new ResultReceiver(mediaId) {

                final MediaBrowserImplBase this$0;
                final ItemCallback val$cb;
                final String val$mediaId;

                protected void onReceiveResult(int i, Bundle bundle)
                {
                    if (i != 0 || bundle == null || !bundle.containsKey("media_item"))
                    {
                        cb.onError(mediaId);
                        return;
                    }
                    bundle = bundle.getParcelable("media_item");
                    if (!(bundle instanceof MediaItem))
                    {
                        cb.onError(mediaId);
                        return;
                    } else
                    {
                        cb.onItemLoaded((MediaItem)bundle);
                        return;
                    }
                }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    cb = itemcallback;
                    mediaId = s;
                    super(final_handler);
                }

                private class MediaItem
                    implements Parcelable
                {

                    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

                        public final MediaItem createFromParcel(Parcel parcel)
                        {
                            return new MediaItem(parcel);
                        }

                        public final volatile Object createFromParcel(Parcel parcel)
                        {
                            return createFromParcel(parcel);
                        }

                        public final MediaItem[] newArray(int i)
                        {
                            return new MediaItem[i];
                        }

                        public final volatile Object[] newArray(int i)
                        {
                            return newArray(i);
                        }

                    };
                    public static final int FLAG_BROWSABLE = 1;
                    public static final int FLAG_PLAYABLE = 2;
                    private final MediaDescriptionCompat mDescription;
                    private final int mFlags;

                    public int describeContents()
                    {
                        return 0;
                    }

                    public MediaDescriptionCompat getDescription()
                    {
                        return mDescription;
                    }

                    public int getFlags()
                    {
                        return mFlags;
                    }

                    public String getMediaId()
                    {
                        return mDescription.getMediaId();
                    }

                    public boolean isBrowsable()
                    {
                        return (mFlags & 1) != 0;
                    }

                    public boolean isPlayable()
                    {
                        return (mFlags & 2) != 0;
                    }

                    public String toString()
                    {
                        StringBuilder stringbuilder = new StringBuilder("MediaItem{");
                        stringbuilder.append("mFlags=").append(mFlags);
                        stringbuilder.append(", mDescription=").append(mDescription);
                        stringbuilder.append('}');
                        return stringbuilder.toString();
                    }

                    public void writeToParcel(Parcel parcel, int i)
                    {
                        parcel.writeInt(mFlags);
                        mDescription.writeToParcel(parcel, i);
                    }


                    private MediaItem(Parcel parcel)
                    {
                        mFlags = parcel.readInt();
                        mDescription = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }


                    public MediaItem(MediaDescriptionCompat mediadescriptioncompat, int i)
                    {
                        if (mediadescriptioncompat == null)
                        {
                            throw new IllegalArgumentException("description cannot be null");
                        }
                        if (TextUtils.isEmpty(mediadescriptioncompat.getMediaId()))
                        {
                            throw new IllegalArgumentException("description must have a non-empty media id");
                        } else
                        {
                            mFlags = i;
                            mDescription = mediadescriptioncompat;
                            return;
                        }
                    }
                }

            };
            try
            {
                mServiceBinder.getMediaItem(mediaId, resultreceiver);
                return;
            }
            catch (RemoteException remoteexception)
            {
                Log.i("MediaBrowserCompat", "Remote error getting media item.");
            }
            mHandler.post(new Runnable() {

                final MediaBrowserImplBase this$0;
                final ItemCallback val$cb;
                final String val$mediaId;

                public void run()
                {
                    cb.onError(mediaId);
                }

                
                {
                    this$0 = MediaBrowserImplBase.this;
                    cb = itemcallback;
                    mediaId = s;
                    super();
                }
            });
        }

        public String getRoot()
        {
            if (!isConnected())
            {
                throw new IllegalStateException((new StringBuilder("getSessionToken() called while not connected(state=")).append(getStateLabel(mState)).append(")").toString());
            } else
            {
                return mRootId;
            }
        }

        public ComponentName getServiceComponent()
        {
            if (!isConnected())
            {
                throw new IllegalStateException((new StringBuilder("getServiceComponent() called while not connected (state=")).append(mState).append(")").toString());
            } else
            {
                return mServiceComponent;
            }
        }

        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken()
        {
            if (!isConnected())
            {
                throw new IllegalStateException((new StringBuilder("getSessionToken() called while not connected(state=")).append(mState).append(")").toString());
            } else
            {
                return mMediaSessionToken;
            }
        }

        public boolean isConnected()
        {
            return mState == 2;
        }

        public void subscribe(String s, SubscriptionCallback subscriptioncallback)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("parentId is null");
            }
            if (subscriptioncallback == null)
            {
                throw new IllegalArgumentException("callback is null");
            }
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
            subscription.callback = subscriptioncallback;
            if (mState != 2)
            {
                break MISSING_BLOCK_LABEL_100;
            }
            mServiceBinder.addSubscription(s, mServiceCallbacks);
            return;
            s;
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
            s;
        }


/*
        static Bundle access$1002(MediaBrowserImplBase mediabrowserimplbase, Bundle bundle)
        {
            mediabrowserimplbase.mExtras = bundle;
            return bundle;
        }

*/




/*
        static IMediaBrowserServiceCompatCallbacks access$1202(MediaBrowserImplBase mediabrowserimplbase, IMediaBrowserServiceCompatCallbacks imediabrowserservicecompatcallbacks)
        {
            mediabrowserimplbase.mServiceCallbacks = imediabrowserservicecompatcallbacks;
            return imediabrowserservicecompatcallbacks;
        }

*/



/*
        static IMediaBrowserServiceCompat access$1302(MediaBrowserImplBase mediabrowserimplbase, IMediaBrowserServiceCompat imediabrowserservicecompat)
        {
            mediabrowserimplbase.mServiceBinder = imediabrowserservicecompat;
            return imediabrowserservicecompat;
        }

*/














/*
        static int access$602(MediaBrowserImplBase mediabrowserimplbase, int i)
        {
            mediabrowserimplbase.mState = i;
            return i;
        }

*/



/*
        static String access$802(MediaBrowserImplBase mediabrowserimplbase, String s)
        {
            mediabrowserimplbase.mRootId = s;
            return s;
        }

*/


/*
        static android.support.v4.media.session.MediaSessionCompat.Token access$902(MediaBrowserImplBase mediabrowserimplbase, android.support.v4.media.session.MediaSessionCompat.Token token)
        {
            mediabrowserimplbase.mMediaSessionToken = token;
            return token;
        }

*/

        public MediaBrowserImplBase(Context context, ComponentName componentname, ConnectionCallback connectioncallback, Bundle bundle)
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
            if (connectioncallback == null)
            {
                throw new IllegalArgumentException("connection callback must not be null");
            } else
            {
                mContext = context;
                mServiceComponent = componentname;
                mCallback = connectioncallback;
                mRootHints = bundle;
                return;
            }
        }
    }

}
