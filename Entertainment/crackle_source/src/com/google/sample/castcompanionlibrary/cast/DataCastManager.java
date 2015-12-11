// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import android.content.Context;
import android.support.v7.app.MediaRouteDialogFactory;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.sample.castcompanionlibrary.cast.callbacks.IDataCastConsumer;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

public class DataCastManager extends BaseCastManager
    implements com.google.android.gms.cast.Cast.MessageReceivedCallback
{
    class CastListener extends com.google.android.gms.cast.Cast.Listener
    {

        final DataCastManager this$0;

        public void onApplicationDisconnected(int i)
        {
            DataCastManager.this.onApplicationDisconnected(i);
        }

        public void onApplicationStatusChanged()
        {
            DataCastManager.this.onApplicationStatusChanged();
        }

        CastListener()
        {
            this$0 = DataCastManager.this;
            super();
        }
    }


    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/DataCastManager);
    private static DataCastManager sInstance;
    protected Set mDataConsumers;
    private final Set mNamespaceList = new HashSet();

    protected transient DataCastManager(Context context, String s, String as[])
    {
        super(context, s);
        mDataConsumers = new HashSet();
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                context = as[i];
                mNamespaceList.add(context);
            }

        }
    }

    private void attachDataChannels()
        throws IllegalStateException, IOException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (!mNamespaceList.isEmpty() && Cast.CastApi != null)
        {
            String s;
            for (Iterator iterator = mNamespaceList.iterator(); iterator.hasNext(); Cast.CastApi.setMessageReceivedCallbacks(mApiClient, s, this))
            {
                s = (String)iterator.next();
            }

        }
    }

    private void detachDataChannels()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (!mNamespaceList.isEmpty())
        {
            for (Iterator iterator = mNamespaceList.iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                try
                {
                    Cast.CastApi.removeMessageReceivedCallbacks(mApiClient, s);
                }
                catch (IllegalStateException illegalstateexception)
                {
                    LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to add namespace: ").append(s).toString(), illegalstateexception);
                }
                catch (IOException ioexception)
                {
                    LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to add namespace: ").append(s).toString(), ioexception);
                }
            }

        }
    }

    public static DataCastManager getInstance()
        throws CastException
    {
        if (sInstance == null)
        {
            LogUtils.LOGE(TAG, "No DataCastManager instance was initialized, you need to call initialize() first");
            throw new CastException();
        } else
        {
            return sInstance;
        }
    }

    public static DataCastManager getInstance(Context context)
        throws CastException
    {
        if (sInstance == null)
        {
            LogUtils.LOGE(TAG, "No DataCastManager instance was initialized, you need to call initialize() first");
            throw new CastException();
        } else
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Updated context to: ").append(context.getClass().getName()).toString());
            sInstance.mContext = context;
            return sInstance;
        }
    }

    public static transient DataCastManager initialize(Context context, String s, String as[])
    {
        if (sInstance == null)
        {
            LogUtils.LOGD(TAG, "New instance of DataCastManager is created");
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) != 0)
            {
                LogUtils.LOGE(TAG, "Couldn't find the appropriate version of Goolge Play Services");
                throw new RuntimeException("Couldn't find the appropriate version of Goolge Play Services");
            }
            sInstance = new DataCastManager(context, s, as);
            mCastManager = sInstance;
        }
        return sInstance;
    }

    public void addDataCastConsumer(IDataCastConsumer idatacastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (idatacastconsumer == null) goto _L2; else goto _L1
_L1:
        super.addBaseCastConsumer(idatacastconsumer);
        if (!mDataConsumers.add(idatacastconsumer)) goto _L4; else goto _L3
_L3:
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Successfully added the new DataCastConsumer listener ").append(idatacastconsumer).toString());
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Adding Listener ").append(idatacastconsumer).append(" was already registered, ").append("skipping this step").toString());
        if (true) goto _L2; else goto _L5
_L5:
        idatacastconsumer;
        throw idatacastconsumer;
    }

    public boolean addNamespace(String s)
        throws IllegalStateException, IOException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("namespace cannot be empty");
        }
        if (mNamespaceList.contains(s))
        {
            LogUtils.LOGD(TAG, "Ignoring to add a namespace that is already added.");
            return false;
        }
        try
        {
            Cast.CastApi.setMessageReceivedCallbacks(mApiClient, s, this);
            mNamespaceList.add(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtils.LOGE(TAG, "Failed to add namespace", s);
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            LogUtils.LOGE(TAG, "Failed to add namespace", s);
            return false;
        }
        return true;
    }

    protected com.google.android.gms.cast.Cast.CastOptions.Builder getCastOptionBuilder(CastDevice castdevice)
    {
        castdevice = com.google.android.gms.cast.Cast.CastOptions.builder(mSelectedCastDevice, new CastListener());
        if (isFeatureEnabled(1))
        {
            castdevice.setDebuggingEnabled();
        }
        return castdevice;
    }

    protected MediaRouteDialogFactory getMediaRouteDialogFactory()
    {
        return null;
    }

    public void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationConnected() reached with sessionId: ").append(s1).toString());
        Utils.saveStringToPreference(mContext, "session-id", s1);
        if (mReconnectionStatus != BaseCastManager.ReconnectionStatus.IN_PROGRESS) goto _L2; else goto _L1
_L1:
        Object obj = mMediaRouter.getRoutes();
        if (obj == null) goto _L2; else goto _L3
_L3:
        boolean flag1;
        String s2 = Utils.getStringFromPreference(mContext, "route-id");
        boolean flag2 = false;
        obj = ((List) (obj)).iterator();
        do
        {
            flag1 = flag2;
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            android.support.v7.media.MediaRouter.RouteInfo routeinfo = (android.support.v7.media.MediaRouter.RouteInfo)((Iterator) (obj)).next();
            if (!s2.equals(routeinfo.getId()))
            {
                continue;
            }
            LogUtils.LOGD(TAG, "Found the correct route during reconnection attempt");
            flag1 = true;
            mReconnectionStatus = BaseCastManager.ReconnectionStatus.FINALIZE;
            mMediaRouter.selectRoute(routeinfo);
            break;
        } while (true);
        if (flag1) goto _L2; else goto _L4
_L4:
        onDeviceSelected(null);
        mReconnectionStatus = BaseCastManager.ReconnectionStatus.INACTIVE;
_L7:
        return;
_L2:
        Iterator iterator;
        attachDataChannels();
        iterator = mDataConsumers.iterator();
_L5:
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (IDataCastConsumer)iterator.next();
        try
        {
            ((IDataCastConsumer) (obj)).onApplicationConnected(applicationmetadata, s, s1, flag);
        }
        catch (Exception exception)
        {
            try
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationConnected(): Failed to inform ").append(obj).toString(), exception);
            }
            // Misplaced declaration of an exception variable
            catch (ApplicationMetadata applicationmetadata)
            {
                LogUtils.LOGE(TAG, "Failed to attach namespaces", applicationmetadata);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ApplicationMetadata applicationmetadata)
            {
                LogUtils.LOGE(TAG, "Failed to attach namespaces", applicationmetadata);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ApplicationMetadata applicationmetadata)
            {
                LogUtils.LOGE(TAG, "Failed to attach namespaces", applicationmetadata);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ApplicationMetadata applicationmetadata)
            {
                LogUtils.LOGE(TAG, "Failed to attach namespaces", applicationmetadata);
                return;
            }
        }
          goto _L5
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onApplicationConnectionFailed(int i)
    {
        onDeviceSelected(null);
        for (Iterator iterator = mDataConsumers.iterator(); iterator.hasNext();)
        {
            IDataCastConsumer idatacastconsumer = (IDataCastConsumer)iterator.next();
            try
            {
                idatacastconsumer.onApplicationConnectionFailed(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationConnectionFailed(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
        }

    }

    public void onApplicationDisconnected(int i)
    {
        for (Iterator iterator = mDataConsumers.iterator(); iterator.hasNext();)
        {
            IDataCastConsumer idatacastconsumer = (IDataCastConsumer)iterator.next();
            try
            {
                idatacastconsumer.onApplicationDisconnected(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationDisconnected(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
        }

        if (mMediaRouter != null)
        {
            mMediaRouter.selectRoute(mMediaRouter.getDefaultRoute());
        }
        onDeviceSelected(null);
    }

    public void onApplicationStatusChanged()
    {
        if (isConnected()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        Iterator iterator;
        s = Cast.CastApi.getApplicationStatus(mApiClient);
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onApplicationStatusChanged() reached: ").append(Cast.CastApi.getApplicationStatus(mApiClient)).toString());
        iterator = mDataConsumers.iterator();
_L3:
        IDataCastConsumer idatacastconsumer;
        if (!iterator.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        idatacastconsumer = (IDataCastConsumer)iterator.next();
        try
        {
            idatacastconsumer.onApplicationStatusChanged(s);
        }
        catch (Exception exception)
        {
            try
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationStatusChanged(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
            catch (IllegalStateException illegalstateexception)
            {
                LogUtils.LOGE(TAG, "onApplicationStatusChanged(): Failed", illegalstateexception);
                return;
            }
        }
          goto _L3
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onApplicationStopFailed(int i)
    {
        for (Iterator iterator = mDataConsumers.iterator(); iterator.hasNext();)
        {
            IDataCastConsumer idatacastconsumer = (IDataCastConsumer)iterator.next();
            try
            {
                idatacastconsumer.onApplicationStopFailed(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onApplicationStopFailed(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
        }

    }

    protected void onDeviceUnselected()
    {
        try
        {
            detachDataChannels();
            return;
        }
        catch (NoConnectionException noconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to detach data channels", noconnectionexception);
            return;
        }
        catch (TransientNetworkDisconnectionException transientnetworkdisconnectionexception)
        {
            LogUtils.LOGE(TAG, "Failed to detach data channels", transientnetworkdisconnectionexception);
        }
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        for (Iterator iterator = mDataConsumers.iterator(); iterator.hasNext();)
        {
            IDataCastConsumer idatacastconsumer = (IDataCastConsumer)iterator.next();
            try
            {
                idatacastconsumer.onMessageReceived(castdevice, s, s1);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onMessageReceived(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
        }

    }

    public void onMessageSendFailed(Status status)
    {
        for (Iterator iterator = mDataConsumers.iterator(); iterator.hasNext();)
        {
            IDataCastConsumer idatacastconsumer = (IDataCastConsumer)iterator.next();
            try
            {
                idatacastconsumer.onMessageSendFailed(status);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onMessageSendFailed(): Failed to inform ").append(idatacastconsumer).toString(), exception);
            }
        }

    }

    public void onVolumeChanged()
    {
    }

    public void removeDataCastConsumer(IDataCastConsumer idatacastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (idatacastconsumer == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        super.removeBaseCastConsumer(idatacastconsumer);
        mDataConsumers.remove(idatacastconsumer);
        this;
        JVM INSTR monitorexit ;
        return;
        idatacastconsumer;
        throw idatacastconsumer;
    }

    public boolean removeNamespace(String s)
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("namespace cannot be empty");
        }
        if (!mNamespaceList.contains(s))
        {
            LogUtils.LOGD(TAG, "Ignoring to remove a namespace that is not registered.");
            return false;
        }
        try
        {
            Cast.CastApi.removeMessageReceivedCallbacks(mApiClient, s);
            mNamespaceList.remove(s);
        }
        catch (IOException ioexception)
        {
            LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to remove namespace: ").append(s).toString(), ioexception);
            return false;
        }
        catch (IllegalStateException illegalstateexception)
        {
            LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to remove namespace: ").append(s).toString(), illegalstateexception);
            return false;
        }
        return true;
    }

    public void sendDataMessage(String s, String s1)
        throws IllegalArgumentException, IllegalStateException, IOException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("namespace cannot be empty");
        } else
        {
            Cast.CastApi.sendMessage(mApiClient, s1, s).setResultCallback(new ResultCallback() {

                final DataCastManager this$0;

                public volatile void onResult(Result result)
                {
                    onResult((Status)result);
                }

                public void onResult(Status status)
                {
                    if (!status.isSuccess())
                    {
                        onMessageSendFailed(status);
                    }
                }

            
            {
                this$0 = DataCastManager.this;
                super();
            }
            });
            return;
        }
    }

}
