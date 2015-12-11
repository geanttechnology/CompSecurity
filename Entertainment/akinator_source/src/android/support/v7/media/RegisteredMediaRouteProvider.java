// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.media:
//            MediaRouteProvider, MediaRouteProviderDescriptor, MediaRouteDescriptor, MediaRouteProviderProtocol, 
//            MediaRouteDiscoveryRequest

final class RegisteredMediaRouteProvider extends MediaRouteProvider
    implements ServiceConnection
{
    private final class Connection
        implements android.os.IBinder.DeathRecipient
    {

        private int mNextControllerId;
        private int mNextRequestId;
        private final SparseArray mPendingCallbacks = new SparseArray();
        private int mPendingRegisterRequestId;
        private final ReceiveHandler mReceiveHandler = new ReceiveHandler(this);
        private final Messenger mReceiveMessenger;
        private final Messenger mServiceMessenger;
        private int mServiceVersion;
        final RegisteredMediaRouteProvider this$0;

        private void failPendingCallbacks()
        {
            for (int i = 0; i < mPendingCallbacks.size(); i++)
            {
                ((MediaRouter.ControlRequestCallback)mPendingCallbacks.valueAt(i)).onError(null, null);
            }

            mPendingCallbacks.clear();
        }

        private boolean sendRequest(int i, int j, int k, Object obj, Bundle bundle)
        {
            Message message;
            message = Message.obtain();
            message.what = i;
            message.arg1 = j;
            message.arg2 = k;
            message.obj = obj;
            message.setData(bundle);
            message.replyTo = mReceiveMessenger;
            mServiceMessenger.send(message);
            return true;
            obj;
            if (i != 2)
            {
                Log.e("MediaRouteProviderProxy", "Could not send message to service.", ((Throwable) (obj)));
            }
_L2:
            return false;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void binderDied()
        {
            mPrivateHandler.post(new Runnable() {

                final Connection this$1;

                public void run()
                {
                    onConnectionDied(Connection.this);
                }

            
            {
                this$1 = Connection.this;
                super();
            }
            });
        }

        public int createRouteController(String s)
        {
            int i = mNextControllerId;
            mNextControllerId = i + 1;
            Bundle bundle = new Bundle();
            bundle.putString("routeId", s);
            int j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(3, j, i, null, bundle);
            return i;
        }

        public void dispose()
        {
            sendRequest(2, 0, 0, null, null);
            mReceiveHandler.dispose();
            mServiceMessenger.getBinder().unlinkToDeath(this, 0);
            mPrivateHandler.post(new Runnable() {

                final Connection this$1;

                public void run()
                {
                    failPendingCallbacks();
                }

            
            {
                this$1 = Connection.this;
                super();
            }
            });
        }

        public boolean onControlRequestFailed(int i, String s, Bundle bundle)
        {
            MediaRouter.ControlRequestCallback controlrequestcallback = (MediaRouter.ControlRequestCallback)mPendingCallbacks.get(i);
            if (controlrequestcallback != null)
            {
                mPendingCallbacks.remove(i);
                controlrequestcallback.onError(s, bundle);
                return true;
            } else
            {
                return false;
            }
        }

        public boolean onControlRequestSucceeded(int i, Bundle bundle)
        {
            MediaRouter.ControlRequestCallback controlrequestcallback = (MediaRouter.ControlRequestCallback)mPendingCallbacks.get(i);
            if (controlrequestcallback != null)
            {
                mPendingCallbacks.remove(i);
                controlrequestcallback.onResult(bundle);
                return true;
            } else
            {
                return false;
            }
        }

        public boolean onDescriptorChanged(Bundle bundle)
        {
            if (mServiceVersion != 0)
            {
                onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(bundle));
                return true;
            } else
            {
                return false;
            }
        }

        public boolean onGenericFailure(int i)
        {
            if (i == mPendingRegisterRequestId)
            {
                mPendingRegisterRequestId = 0;
                onConnectionError(this, "Registation failed");
            }
            MediaRouter.ControlRequestCallback controlrequestcallback = (MediaRouter.ControlRequestCallback)mPendingCallbacks.get(i);
            if (controlrequestcallback != null)
            {
                mPendingCallbacks.remove(i);
                controlrequestcallback.onError(null, null);
            }
            return true;
        }

        public boolean onGenericSuccess(int i)
        {
            return true;
        }

        public boolean onRegistered(int i, int j, Bundle bundle)
        {
            if (mServiceVersion == 0 && i == mPendingRegisterRequestId && j >= 1)
            {
                mPendingRegisterRequestId = 0;
                mServiceVersion = j;
                onConnectionDescriptorChanged(this, MediaRouteProviderDescriptor.fromBundle(bundle));
                onConnectionReady(this);
                return true;
            } else
            {
                return false;
            }
        }

        public boolean register()
        {
            int i = mNextRequestId;
            mNextRequestId = i + 1;
            mPendingRegisterRequestId = i;
            if (!sendRequest(1, mPendingRegisterRequestId, 1, null, null))
            {
                return false;
            }
            try
            {
                mServiceMessenger.getBinder().linkToDeath(this, 0);
            }
            catch (RemoteException remoteexception)
            {
                binderDied();
                return false;
            }
            return true;
        }

        public void releaseRouteController(int i)
        {
            int j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(4, j, i, null, null);
        }

        public void selectRoute(int i)
        {
            int j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(5, j, i, null, null);
        }

        public boolean sendControlRequest(int i, Intent intent, MediaRouter.ControlRequestCallback controlrequestcallback)
        {
            int j = mNextRequestId;
            mNextRequestId = j + 1;
            if (sendRequest(9, j, i, intent, null))
            {
                if (controlrequestcallback != null)
                {
                    mPendingCallbacks.put(j, controlrequestcallback);
                }
                return true;
            } else
            {
                return false;
            }
        }

        public void setDiscoveryRequest(MediaRouteDiscoveryRequest mediaroutediscoveryrequest)
        {
            int i = mNextRequestId;
            mNextRequestId = i + 1;
            if (mediaroutediscoveryrequest != null)
            {
                mediaroutediscoveryrequest = mediaroutediscoveryrequest.asBundle();
            } else
            {
                mediaroutediscoveryrequest = null;
            }
            sendRequest(10, i, 0, mediaroutediscoveryrequest, null);
        }

        public void setVolume(int i, int j)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", j);
            j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(7, j, i, null, bundle);
        }

        public void unselectRoute(int i, int j)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("unselectReason", j);
            j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(6, j, i, null, bundle);
        }

        public void updateVolume(int i, int j)
        {
            Bundle bundle = new Bundle();
            bundle.putInt("volume", j);
            j = mNextRequestId;
            mNextRequestId = j + 1;
            sendRequest(8, j, i, null, bundle);
        }


        public Connection(Messenger messenger)
        {
            this$0 = RegisteredMediaRouteProvider.this;
            super();
            mNextRequestId = 1;
            mNextControllerId = 1;
            mServiceMessenger = messenger;
            mReceiveMessenger = new Messenger(mReceiveHandler);
        }
    }

    private final class Controller extends MediaRouteProvider.RouteController
    {

        private Connection mConnection;
        private int mControllerId;
        private int mPendingSetVolume;
        private int mPendingUpdateVolumeDelta;
        private final String mRouteId;
        private boolean mSelected;
        final RegisteredMediaRouteProvider this$0;

        public void attachConnection(Connection connection)
        {
            mConnection = connection;
            mControllerId = connection.createRouteController(mRouteId);
            if (mSelected)
            {
                connection.selectRoute(mControllerId);
                if (mPendingSetVolume >= 0)
                {
                    connection.setVolume(mControllerId, mPendingSetVolume);
                    mPendingSetVolume = -1;
                }
                if (mPendingUpdateVolumeDelta != 0)
                {
                    connection.updateVolume(mControllerId, mPendingUpdateVolumeDelta);
                    mPendingUpdateVolumeDelta = 0;
                }
            }
        }

        public void detachConnection()
        {
            if (mConnection != null)
            {
                mConnection.releaseRouteController(mControllerId);
                mConnection = null;
                mControllerId = 0;
            }
        }

        public boolean onControlRequest(Intent intent, MediaRouter.ControlRequestCallback controlrequestcallback)
        {
            if (mConnection != null)
            {
                return mConnection.sendControlRequest(mControllerId, intent, controlrequestcallback);
            } else
            {
                return false;
            }
        }

        public void onRelease()
        {
            onControllerReleased(this);
        }

        public void onSelect()
        {
            mSelected = true;
            if (mConnection != null)
            {
                mConnection.selectRoute(mControllerId);
            }
        }

        public void onSetVolume(int i)
        {
            if (mConnection != null)
            {
                mConnection.setVolume(mControllerId, i);
                return;
            } else
            {
                mPendingSetVolume = i;
                mPendingUpdateVolumeDelta = 0;
                return;
            }
        }

        public void onUnselect()
        {
            onUnselect(0);
        }

        public void onUnselect(int i)
        {
            mSelected = false;
            if (mConnection != null)
            {
                mConnection.unselectRoute(mControllerId, i);
            }
        }

        public void onUpdateVolume(int i)
        {
            if (mConnection != null)
            {
                mConnection.updateVolume(mControllerId, i);
                return;
            } else
            {
                mPendingUpdateVolumeDelta = mPendingUpdateVolumeDelta + i;
                return;
            }
        }

        public Controller(String s)
        {
            this$0 = RegisteredMediaRouteProvider.this;
            super();
            mPendingSetVolume = -1;
            mRouteId = s;
        }
    }

    private final class PrivateHandler extends Handler
    {

        final RegisteredMediaRouteProvider this$0;

        private PrivateHandler()
        {
            this$0 = RegisteredMediaRouteProvider.this;
            super();
        }

    }

    private static final class ReceiveHandler extends Handler
    {

        private final WeakReference mConnectionRef;

        private boolean processMessage(Connection connection, int i, int j, int k, Object obj, Bundle bundle)
        {
            i;
            JVM INSTR tableswitch 0 5: default 40
        //                       0 42
        //                       1 50
        //                       2 58
        //                       3 107
        //                       4 131
        //                       5 84;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
            return false;
_L2:
            connection.onGenericFailure(j);
            return true;
_L3:
            connection.onGenericSuccess(j);
            return true;
_L4:
            if (obj == null || (obj instanceof Bundle))
            {
                return connection.onRegistered(j, k, (Bundle)obj);
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (obj == null || (obj instanceof Bundle))
            {
                return connection.onDescriptorChanged((Bundle)obj);
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (obj == null || (obj instanceof Bundle))
            {
                return connection.onControlRequestSucceeded(j, (Bundle)obj);
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (obj == null || (obj instanceof Bundle))
            {
                if (bundle == null)
                {
                    bundle = null;
                } else
                {
                    bundle = bundle.getString("error");
                }
                return connection.onControlRequestFailed(j, bundle, (Bundle)obj);
            }
            if (true) goto _L1; else goto _L8
_L8:
        }

        public void dispose()
        {
            mConnectionRef.clear();
        }

        public void handleMessage(Message message)
        {
            Connection connection = (Connection)mConnectionRef.get();
            if (connection != null && !processMessage(connection, message.what, message.arg1, message.arg2, message.obj, message.peekData()) && RegisteredMediaRouteProvider.DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append("Unhandled message from server: ").append(message).toString());
            }
        }

        public ReceiveHandler(Connection connection)
        {
            mConnectionRef = new WeakReference(connection);
        }
    }


    private static final boolean DEBUG = Log.isLoggable("MediaRouteProviderProxy", 3);
    private static final String TAG = "MediaRouteProviderProxy";
    private Connection mActiveConnection;
    private boolean mBound;
    private final ComponentName mComponentName;
    private boolean mConnectionReady;
    private final ArrayList mControllers = new ArrayList();
    private final PrivateHandler mPrivateHandler = new PrivateHandler();
    private boolean mStarted;

    public RegisteredMediaRouteProvider(Context context, ComponentName componentname)
    {
        super(context, new MediaRouteProvider.ProviderMetadata(componentname));
        mComponentName = componentname;
    }

    private void attachControllersToConnection()
    {
        int j = mControllers.size();
        for (int i = 0; i < j; i++)
        {
            ((Controller)mControllers.get(i)).attachConnection(mActiveConnection);
        }

    }

    private void bind()
    {
        Intent intent;
        if (mBound)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (DEBUG)
        {
            Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Binding").toString());
        }
        intent = new Intent("android.media.MediaRouteProviderService");
        intent.setComponent(mComponentName);
        mBound = getContext().bindService(intent, this, 1);
        if (!mBound && DEBUG)
        {
            Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Bind failed").toString());
        }
_L1:
        return;
        SecurityException securityexception;
        securityexception;
        if (DEBUG)
        {
            Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Bind failed").toString(), securityexception);
            return;
        }
          goto _L1
    }

    private void detachControllersFromConnection()
    {
        int j = mControllers.size();
        for (int i = 0; i < j; i++)
        {
            ((Controller)mControllers.get(i)).detachConnection();
        }

    }

    private void disconnect()
    {
        if (mActiveConnection != null)
        {
            setDescriptor(null);
            mConnectionReady = false;
            detachControllersFromConnection();
            mActiveConnection.dispose();
            mActiveConnection = null;
        }
    }

    private void onConnectionDescriptorChanged(Connection connection, MediaRouteProviderDescriptor mediarouteproviderdescriptor)
    {
        if (mActiveConnection == connection)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Descriptor changed, descriptor=").append(mediarouteproviderdescriptor).toString());
            }
            setDescriptor(mediarouteproviderdescriptor);
        }
    }

    private void onConnectionDied(Connection connection)
    {
        if (mActiveConnection == connection)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Service connection died").toString());
            }
            disconnect();
        }
    }

    private void onConnectionError(Connection connection, String s)
    {
        if (mActiveConnection == connection)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Service connection error - ").append(s).toString());
            }
            unbind();
        }
    }

    private void onConnectionReady(Connection connection)
    {
        if (mActiveConnection == connection)
        {
            mConnectionReady = true;
            attachControllersToConnection();
            connection = getDiscoveryRequest();
            if (connection != null)
            {
                mActiveConnection.setDiscoveryRequest(connection);
            }
        }
    }

    private void onControllerReleased(Controller controller)
    {
        mControllers.remove(controller);
        controller.detachConnection();
        updateBinding();
    }

    private boolean shouldBind()
    {
        while (mStarted && (getDiscoveryRequest() != null || !mControllers.isEmpty())) 
        {
            return true;
        }
        return false;
    }

    private void unbind()
    {
        if (mBound)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Unbinding").toString());
            }
            mBound = false;
            disconnect();
            getContext().unbindService(this);
        }
    }

    private void updateBinding()
    {
        if (shouldBind())
        {
            bind();
            return;
        } else
        {
            unbind();
            return;
        }
    }

    public boolean hasComponentName(String s, String s1)
    {
        return mComponentName.getPackageName().equals(s) && mComponentName.getClassName().equals(s1);
    }

    public MediaRouteProvider.RouteController onCreateRouteController(String s)
    {
        Object obj = getDescriptor();
        if (obj != null)
        {
            obj = ((MediaRouteProviderDescriptor) (obj)).getRoutes();
            int j = ((List) (obj)).size();
            for (int i = 0; i < j; i++)
            {
                if (((MediaRouteDescriptor)((List) (obj)).get(i)).getId().equals(s))
                {
                    s = new Controller(s);
                    mControllers.add(s);
                    if (mConnectionReady)
                    {
                        s.attachConnection(mActiveConnection);
                    }
                    updateBinding();
                    return s;
                }
            }

        }
        return null;
    }

    public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest mediaroutediscoveryrequest)
    {
        if (mConnectionReady)
        {
            mActiveConnection.setDiscoveryRequest(mediaroutediscoveryrequest);
        }
        updateBinding();
    }

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        if (DEBUG)
        {
            Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Connected").toString());
        }
        if (!mBound) goto _L2; else goto _L1
_L1:
        disconnect();
        if (ibinder != null)
        {
            componentname = new Messenger(ibinder);
        } else
        {
            componentname = null;
        }
        if (!MediaRouteProviderProtocol.isValidRemoteMessenger(componentname))
        {
            break MISSING_BLOCK_LABEL_124;
        }
        componentname = new Connection(componentname);
        if (!componentname.register()) goto _L4; else goto _L3
_L3:
        mActiveConnection = componentname;
_L2:
        return;
_L4:
        if (!DEBUG) goto _L2; else goto _L5
_L5:
        Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Registration failed").toString());
        return;
        Log.e("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Service returned invalid messenger binder").toString());
        return;
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        if (DEBUG)
        {
            Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Service disconnected").toString());
        }
        disconnect();
    }

    public void rebindIfDisconnected()
    {
        if (mActiveConnection == null && shouldBind())
        {
            unbind();
            bind();
        }
    }

    public void start()
    {
        if (!mStarted)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Starting").toString());
            }
            mStarted = true;
            updateBinding();
        }
    }

    public void stop()
    {
        if (mStarted)
        {
            if (DEBUG)
            {
                Log.d("MediaRouteProviderProxy", (new StringBuilder()).append(this).append(": Stopping").toString());
            }
            mStarted = false;
            updateBinding();
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Service connection ").append(mComponentName.flattenToShortString()).toString();
    }








}
