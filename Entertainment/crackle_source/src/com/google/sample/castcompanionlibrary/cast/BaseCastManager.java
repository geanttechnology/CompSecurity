// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.app.MediaRouteDialogFactory;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.sample.castcompanionlibrary.cast.callbacks.IBaseCastConsumer;
import com.google.sample.castcompanionlibrary.cast.exceptions.CastException;
import com.google.sample.castcompanionlibrary.cast.exceptions.NoConnectionException;
import com.google.sample.castcompanionlibrary.cast.exceptions.OnFailedListener;
import com.google.sample.castcompanionlibrary.cast.exceptions.TransientNetworkDisconnectionException;
import com.google.sample.castcompanionlibrary.utils.LogUtils;
import com.google.sample.castcompanionlibrary.utils.Utils;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            DeviceSelectionListener, CastMediaRouterCallback

public abstract class BaseCastManager
    implements DeviceSelectionListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, OnFailedListener
{
    public static final class ReconnectionStatus extends Enum
    {

        private static final ReconnectionStatus $VALUES[];
        public static final ReconnectionStatus FINALIZE;
        public static final ReconnectionStatus INACTIVE;
        public static final ReconnectionStatus IN_PROGRESS;
        public static final ReconnectionStatus STARTED;

        public static ReconnectionStatus valueOf(String s)
        {
            return (ReconnectionStatus)Enum.valueOf(com/google/sample/castcompanionlibrary/cast/BaseCastManager$ReconnectionStatus, s);
        }

        public static ReconnectionStatus[] values()
        {
            return (ReconnectionStatus[])$VALUES.clone();
        }

        static 
        {
            STARTED = new ReconnectionStatus("STARTED", 0);
            IN_PROGRESS = new ReconnectionStatus("IN_PROGRESS", 1);
            FINALIZE = new ReconnectionStatus("FINALIZE", 2);
            INACTIVE = new ReconnectionStatus("INACTIVE", 3);
            $VALUES = (new ReconnectionStatus[] {
                STARTED, IN_PROGRESS, FINALIZE, INACTIVE
            });
        }

        private ReconnectionStatus(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int FEATURE_DEBUGGING = 1;
    public static final int FEATURE_LOCKSCREEN = 2;
    public static final int FEATURE_NOTIFICATION = 4;
    public static final int NO_STATUS_CODE = -1;
    public static final String PREFS_KEY_APPLICATION_ID = "application-id";
    public static final String PREFS_KEY_CAST_ACTIVITY_NAME = "cast-activity-name";
    public static final String PREFS_KEY_ROUTE_ID = "route-id";
    public static final String PREFS_KEY_SESSION_ID = "session-id";
    public static final String PREFS_KEY_VOLUME_INCREMENT = "volume-increment";
    private static final int SESSION_RECOVERY_TIMEOUT = 5;
    private static final String TAG = LogUtils.makeLogTag(com/google/sample/castcompanionlibrary/cast/BaseCastManager);
    protected static BaseCastManager mCastManager;
    protected GoogleApiClient mApiClient;
    protected String mApplicationId;
    private final Set mBaseCastConsumers = new HashSet();
    protected int mCapabilities;
    protected boolean mConnectionSuspened;
    protected Context mContext;
    protected boolean mDebuggingEnabled;
    private boolean mDestroyOnDisconnect;
    protected String mDeviceName;
    protected Handler mHandler;
    protected MediaRouteSelector mMediaRouteSelector;
    protected MediaRouter mMediaRouter;
    protected CastMediaRouterCallback mMediaRouterCallback;
    protected ReconnectionStatus mReconnectionStatus;
    protected AsyncTask mReconnectionTask;
    protected CastDevice mSelectedCastDevice;
    protected boolean mUiVisible;
    protected int mVisibilityCounter;
    private boolean mWifiConnectivity;

    protected BaseCastManager(Context context, String s)
    {
        mDestroyOnDisconnect = false;
        mReconnectionStatus = ReconnectionStatus.INACTIVE;
        mWifiConnectivity = true;
        LogUtils.LOGD(TAG, "BaseCastManager is instantiated");
        mContext = context;
        mHandler = new Handler(Looper.getMainLooper());
        mApplicationId = s;
        Utils.saveStringToPreference(mContext, "application-id", s);
        LogUtils.LOGD(TAG, (new StringBuilder()).append("Application ID is: ").append(mApplicationId).toString());
        mMediaRouter = MediaRouter.getInstance(context);
        mMediaRouteSelector = (new android.support.v7.media.MediaRouteSelector.Builder()).addControlCategory(CastMediaControlIntent.categoryForCast(mApplicationId)).build();
        mMediaRouterCallback = new CastMediaRouterCallback(this, context);
        mMediaRouter.addCallback(mMediaRouteSelector, mMediaRouterCallback, 1);
    }

    public static boolean checkGooglePlaySevices(Activity activity)
    {
        return Utils.checkGooglePlaySevices(activity);
    }

    public static BaseCastManager getCastManager()
    {
        return mCastManager;
    }

    private void launchApp()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        LogUtils.LOGD(TAG, "launchApp() is called");
        if (!isConnected())
        {
            if (mReconnectionStatus == ReconnectionStatus.IN_PROGRESS)
            {
                mReconnectionStatus = ReconnectionStatus.INACTIVE;
                return;
            }
            checkConnectivity();
        }
        if (mReconnectionStatus == ReconnectionStatus.IN_PROGRESS)
        {
            LogUtils.LOGD(TAG, "Attempting to join a previously interrupted session...");
            String s = Utils.getStringFromPreference(mContext, "session-id");
            LogUtils.LOGD(TAG, "joinApplication() -> start");
            Cast.CastApi.joinApplication(mApiClient, mApplicationId, s).setResultCallback(new ResultCallback() {

                final BaseCastManager this$0;

                public void onResult(com.google.android.gms.cast.Cast.ApplicationConnectionResult applicationconnectionresult)
                {
                    if (applicationconnectionresult.getStatus().isSuccess())
                    {
                        LogUtils.LOGD(BaseCastManager.TAG, "joinApplication() -> success");
                        onApplicationConnected(applicationconnectionresult.getApplicationMetadata(), applicationconnectionresult.getApplicationStatus(), applicationconnectionresult.getSessionId(), applicationconnectionresult.getWasLaunched());
                        return;
                    } else
                    {
                        LogUtils.LOGD(BaseCastManager.TAG, "joinApplication() -> failure");
                        onApplicationConnectionFailed(applicationconnectionresult.getStatus().getStatusCode());
                        return;
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.Cast.ApplicationConnectionResult)result);
                }

            
            {
                this$0 = BaseCastManager.this;
                super();
            }
            });
            return;
        } else
        {
            LogUtils.LOGD(TAG, "Launching app");
            Cast.CastApi.launchApplication(mApiClient, mApplicationId).setResultCallback(new ResultCallback() {

                final BaseCastManager this$0;

                public void onResult(com.google.android.gms.cast.Cast.ApplicationConnectionResult applicationconnectionresult)
                {
                    if (applicationconnectionresult.getStatus().isSuccess())
                    {
                        LogUtils.LOGD(BaseCastManager.TAG, "launchApplication() -> success result");
                        onApplicationConnected(applicationconnectionresult.getApplicationMetadata(), applicationconnectionresult.getApplicationStatus(), applicationconnectionresult.getSessionId(), applicationconnectionresult.getWasLaunched());
                        return;
                    } else
                    {
                        LogUtils.LOGD(BaseCastManager.TAG, "launchApplication() -> failure result");
                        onApplicationConnectionFailed(applicationconnectionresult.getStatus().getStatusCode());
                        return;
                    }
                }

                public volatile void onResult(Result result)
                {
                    onResult((com.google.android.gms.cast.Cast.ApplicationConnectionResult)result);
                }

            
            {
                this$0 = BaseCastManager.this;
                super();
            }
            });
            return;
        }
    }

    private void reconnectSessionIfPossibleInternal(android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
        if (!isConnected())
        {
            String s = Utils.getStringFromPreference(mContext, "session-id");
            String s1 = Utils.getStringFromPreference(mContext, "route-id");
            LogUtils.LOGD(TAG, (new StringBuilder()).append("reconnectSessionIfPossible() Retrieved from preferences: sessionId=").append(s).append(", routeId=").append(s1).toString());
            if (s != null && s1 != null)
            {
                mReconnectionStatus = ReconnectionStatus.IN_PROGRESS;
                routeinfo = CastDevice.getFromBundle(routeinfo.getExtras());
                if (routeinfo != null)
                {
                    LogUtils.LOGD(TAG, (new StringBuilder()).append("trying to acquire Cast Client for ").append(routeinfo).toString());
                    onDeviceSelected(routeinfo);
                    return;
                }
            }
        }
    }

    public void addBaseCastConsumer(IBaseCastConsumer ibasecastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (ibasecastconsumer == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (mBaseCastConsumers.add(ibasecastconsumer))
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Successfully added the new BaseCastConsumer listener ").append(ibasecastconsumer).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ibasecastconsumer;
        throw ibasecastconsumer;
    }

    public MenuItem addMediaRouterButton(Menu menu, int i)
    {
        menu = menu.findItem(i);
        MediaRouteActionProvider mediarouteactionprovider = (MediaRouteActionProvider)MenuItemCompat.getActionProvider(menu);
        mediarouteactionprovider.setRouteSelector(mMediaRouteSelector);
        if (getMediaRouteDialogFactory() != null)
        {
            mediarouteactionprovider.setDialogFactory(getMediaRouteDialogFactory());
        }
        return menu;
    }

    public final boolean canConsiderSessionRecovery()
    {
        String s = Utils.getStringFromPreference(mContext, "session-id");
        String s1 = Utils.getStringFromPreference(mContext, "route-id");
        if (s == null || s1 == null)
        {
            return false;
        } else
        {
            LogUtils.LOGD(TAG, "Found session info in the preferences, so proceed with an attempt to reconnect if possible");
            return true;
        }
    }

    void cancelReconnectionTask()
    {
        LogUtils.LOGD(TAG, "cancelling reconnection task");
        if (mReconnectionTask != null && !mReconnectionTask.isCancelled())
        {
            mReconnectionTask.cancel(true);
        }
    }

    public void checkConnectivity()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        if (!isConnected())
        {
            if (mConnectionSuspened)
            {
                throw new TransientNetworkDisconnectionException();
            } else
            {
                throw new NoConnectionException();
            }
        } else
        {
            return;
        }
    }

    public void decrementUiCounter()
    {
        this;
        JVM INSTR monitorenter ;
        mHandler.postDelayed(new Runnable() {

            final BaseCastManager this$0;

            public void run()
            {
                BaseCastManager basecastmanager = BaseCastManager.this;
                int i = basecastmanager.mVisibilityCounter - 1;
                basecastmanager.mVisibilityCounter = i;
                if (i == 0)
                {
                    LogUtils.LOGD(BaseCastManager.TAG, "UI is no longer visible");
                    if (mUiVisible)
                    {
                        mUiVisible = false;
                        onUiVisibilityChanged(false);
                    }
                    return;
                } else
                {
                    LogUtils.LOGD(BaseCastManager.TAG, "UI is visible");
                    return;
                }
            }

            
            {
                this$0 = BaseCastManager.this;
                super();
            }
        }, 300L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void disconnect()
    {
        if (isConnected())
        {
            setDevice(null, mDestroyOnDisconnect);
        }
    }

    public void enableFeatures(int i)
    {
        mCapabilities = i;
    }

    abstract com.google.android.gms.cast.Cast.CastOptions.Builder getCastOptionBuilder(CastDevice castdevice);

    public final String getDeviceName()
    {
        return mDeviceName;
    }

    public final double getDeviceVolume()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        return Cast.CastApi.getVolume(mApiClient);
    }

    abstract MediaRouteDialogFactory getMediaRouteDialogFactory();

    public final MediaRouteSelector getMediaRouteSelector()
    {
        return mMediaRouteSelector;
    }

    public ReconnectionStatus getReconnectionStatus()
    {
        return mReconnectionStatus;
    }

    public void incrementDeviceVolume(double d)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        double d1 = getDeviceVolume();
        if (d1 >= 0.0D)
        {
            setDeviceVolume(d1 + d);
        }
    }

    public void incrementUiCounter()
    {
        this;
        JVM INSTR monitorenter ;
        mVisibilityCounter = mVisibilityCounter + 1;
        if (!mUiVisible)
        {
            mUiVisible = true;
            onUiVisibilityChanged(true);
        }
        if (mVisibilityCounter != 0) goto _L2; else goto _L1
_L1:
        LogUtils.LOGD(TAG, "UI is no longer visible");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        LogUtils.LOGD(TAG, "UI is visible");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isConnected()
    {
        return mApiClient != null && mApiClient.isConnected();
    }

    public final boolean isDeviceMute()
        throws TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        return Cast.CastApi.isMute(mApiClient);
    }

    protected boolean isFeatureEnabled(int i)
    {
        return (mCapabilities & i) > 0;
    }

    abstract void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, String s1, boolean flag);

    abstract void onApplicationConnectionFailed(int i);

    abstract void onApplicationStopFailed(int i);

    public void onCastDeviceDetected(android.support.v7.media.MediaRouter.RouteInfo routeinfo)
    {
        if (mBaseCastConsumers != null)
        {
            for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
            {
                IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
                try
                {
                    ibasecastconsumer.onCastDeviceDetected(routeinfo);
                }
                catch (Exception exception)
                {
                    LogUtils.LOGE(TAG, (new StringBuilder()).append("onCastDeviceDetected(): Failed to inform ").append(ibasecastconsumer).toString(), exception);
                }
            }

        }
    }

    public void onConnected(Bundle bundle)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onConnected() reached with prior suspension: ").append(mConnectionSuspened).toString());
        if (!mConnectionSuspened) goto _L2; else goto _L1
_L1:
        mConnectionSuspened = false;
        onConnectivityRecovered();
_L5:
        return;
_L2:
        if (!isConnected())
        {
            if (mReconnectionStatus == ReconnectionStatus.IN_PROGRESS)
            {
                mReconnectionStatus = ReconnectionStatus.INACTIVE;
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        Cast.CastApi.requestStatus(mApiClient);
        launchApp();
        if (mBaseCastConsumers == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bundle = mBaseCastConsumers.iterator();
_L3:
        IBaseCastConsumer ibasecastconsumer;
        if (!bundle.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        ibasecastconsumer = (IBaseCastConsumer)bundle.next();
        try
        {
            ibasecastconsumer.onConnected();
        }
        catch (Exception exception)
        {
            try
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onConnected: Failed to inform ").append(ibasecastconsumer).toString(), exception);
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                LogUtils.LOGE(TAG, "error requesting status", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                LogUtils.LOGE(TAG, "error requesting status", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                LogUtils.LOGE(TAG, "error requesting status due to network issues", bundle);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                LogUtils.LOGE(TAG, "error requesting status due to network issues", bundle);
                return;
            }
        }
          goto _L3
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onConnectionFailed() reached, error code: ").append(connectionresult.getErrorCode()).append(", reason: ").append(connectionresult.toString()).toString());
        mSelectedCastDevice = null;
        if (mMediaRouter != null)
        {
            mMediaRouter.selectRoute(mMediaRouter.getDefaultRoute());
        }
        if (mBaseCastConsumers != null)
        {
            for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
            {
                IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
                try
                {
                    ibasecastconsumer.onConnectionFailed(connectionresult);
                }
                catch (Exception exception)
                {
                    LogUtils.LOGE(TAG, (new StringBuilder()).append("onConnectionFailed(): Failed to inform ").append(ibasecastconsumer).toString(), exception);
                }
            }

        }
        if (false)
        {
            Utils.showErrorDialog(mContext, com.google.sample.castcompanionlibrary.R.string.failed_to_connect);
        }
    }

    public void onConnectionSuspended(int i)
    {
        mConnectionSuspened = true;
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onConnectionSuspended() was called with cause: ").append(i).toString());
        for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
        {
            IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
            try
            {
                ibasecastconsumer.onConnectionSuspended(i);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onConnectionSuspended(): Failed to inform ").append(ibasecastconsumer).toString(), exception);
            }
        }

    }

    public void onConnectivityRecovered()
    {
        for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
        {
            IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
            try
            {
                ibasecastconsumer.onConnectivityRecovered();
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onConnectivityRecovered: Failed to inform ").append(ibasecastconsumer).toString(), exception);
            }
        }

    }

    public void onDeviceSelected(CastDevice castdevice)
    {
        setDevice(castdevice, mDestroyOnDisconnect);
    }

    abstract void onDeviceUnselected();

    protected void onDisconnected()
    {
        LogUtils.LOGD(TAG, "onDisconnected() reached");
        mDeviceName = null;
        if (mBaseCastConsumers != null)
        {
            for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
            {
                IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
                try
                {
                    ibasecastconsumer.onDisconnected();
                }
                catch (Exception exception)
                {
                    LogUtils.LOGE(TAG, (new StringBuilder()).append("onDisconnected(): Failed to inform ").append(ibasecastconsumer).toString(), exception);
                }
            }

        }
    }

    public void onFailed(int i, int j)
    {
        LogUtils.LOGD(TAG, (new StringBuilder()).append("onFailed() was called with statusCode: ").append(j).toString());
        for (Iterator iterator = mBaseCastConsumers.iterator(); iterator.hasNext();)
        {
            IBaseCastConsumer ibasecastconsumer = (IBaseCastConsumer)iterator.next();
            try
            {
                ibasecastconsumer.onFailed(i, j);
            }
            catch (Exception exception)
            {
                LogUtils.LOGE(TAG, (new StringBuilder()).append("onFailed(): Failed to inform ").append(ibasecastconsumer).toString(), exception);
            }
        }

    }

    protected void onUiVisibilityChanged(boolean flag)
    {
        if (flag)
        {
            if (mMediaRouter != null && mMediaRouterCallback != null)
            {
                LogUtils.LOGD(TAG, "onUiVisibilityChanged() addCallback called");
                mMediaRouter.addCallback(mMediaRouteSelector, mMediaRouterCallback, 1);
            }
        } else
        if (mMediaRouter != null)
        {
            LogUtils.LOGD(TAG, "onUiVisibilityChanged() removeCallback called");
            mMediaRouter.removeCallback(mMediaRouterCallback);
            return;
        }
    }

    public void onWifiConnectivityChanged(boolean flag)
    {
        String s1 = TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("WIFI connectivity changed to ");
        String s;
        if (flag)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        LogUtils.LOGD(s1, stringbuilder.append(s).toString());
        if (flag && !mWifiConnectivity)
        {
            mWifiConnectivity = true;
            mHandler.postDelayed(new Runnable() {

                final BaseCastManager this$0;

                public void run()
                {
                    reconnectSessionIfPossible(mContext, false, 10);
                }

            
            {
                this$0 = BaseCastManager.this;
                super();
            }
            }, 1000L);
            return;
        } else
        {
            mWifiConnectivity = flag;
            return;
        }
    }

    public void reconnectSessionIfPossible(Context context, boolean flag)
    {
        reconnectSessionIfPossible(context, flag, 5);
    }

    public void reconnectSessionIfPossible(final Context context, final boolean showDialog, final int timeoutInSeconds)
    {
        if (!isConnected())
        {
            String s = Utils.getStringFromPreference(mContext, "route-id");
            if (canConsiderSessionRecovery())
            {
                Object obj1 = mMediaRouter.getRoutes();
                Object obj = null;
                android.support.v7.media.MediaRouter.RouteInfo routeinfo = obj;
                if (obj1 != null)
                {
                    routeinfo = obj;
                    if (!((List) (obj1)).isEmpty())
                    {
                        obj1 = ((List) (obj1)).iterator();
                        do
                        {
                            routeinfo = obj;
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            routeinfo = (android.support.v7.media.MediaRouter.RouteInfo)((Iterator) (obj1)).next();
                        } while (!routeinfo.getId().equals(s));
                    }
                }
                if (routeinfo != null)
                {
                    reconnectSessionIfPossibleInternal(routeinfo);
                } else
                {
                    mReconnectionStatus = ReconnectionStatus.STARTED;
                }
                mReconnectionTask = new AsyncTask() {

                    private final int FAILED = 2;
                    private final int SUCCESS = 1;
                    private ProgressDialog dlg;
                    final BaseCastManager this$0;
                    final Context val$context;
                    final boolean val$showDialog;
                    final int val$timeoutInSeconds;

                    protected transient Integer doInBackground(Void avoid[])
                    {
                        int i = 0;
                        while (i < timeoutInSeconds) 
                        {
                            if (mReconnectionTask.isCancelled())
                            {
                                if (dlg != null)
                                {
                                    dlg.dismiss();
                                }
                                return Integer.valueOf(1);
                            }
                            try
                            {
                                if (isConnected())
                                {
                                    cancel(true);
                                }
                                Thread.sleep(1000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[]) { }
                            i++;
                        }
                        return Integer.valueOf(2);
                    }

                    protected volatile Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected void onCancelled()
                    {
                        if (dlg != null)
                        {
                            dlg.dismiss();
                        }
                        super.onCancelled();
                    }

                    protected void onPostExecute(Integer integer)
                    {
                        if (showDialog && dlg != null)
                        {
                            dlg.dismiss();
                        }
                        if (integer != null && integer.intValue() == 2)
                        {
                            mReconnectionStatus = ReconnectionStatus.INACTIVE;
                            onDeviceSelected(null);
                        }
                    }

                    protected volatile void onPostExecute(Object obj2)
                    {
                        onPostExecute((Integer)obj2);
                    }

                    protected void onPreExecute()
                    {
                        if (!showDialog)
                        {
                            return;
                        } else
                        {
                            dlg = new ProgressDialog(context);
                            dlg.setMessage(context.getString(com.google.sample.castcompanionlibrary.R.string.session_reconnection_attempt));
                            dlg.setIndeterminate(true);
                            dlg.setCancelable(true);
                            dlg.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                                final _cls3 this$1;

                                public void onCancel(DialogInterface dialoginterface)
                                {
                                    static class _cls7
                                    {

                                        static final int $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[];

                                        static 
                                        {
                                            $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus = new int[ReconnectionStatus.values().length];
                                            try
                                            {
                                                $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[ReconnectionStatus.STARTED.ordinal()] = 1;
                                            }
                                            catch (NoSuchFieldError nosuchfielderror2) { }
                                            try
                                            {
                                                $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[ReconnectionStatus.IN_PROGRESS.ordinal()] = 2;
                                            }
                                            catch (NoSuchFieldError nosuchfielderror1) { }
                                            try
                                            {
                                                $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[ReconnectionStatus.FINALIZE.ordinal()] = 3;
                                            }
                                            catch (NoSuchFieldError nosuchfielderror)
                                            {
                                                return;
                                            }
                                        }
                                    }

                                    _cls7..SwitchMap.com.google.sample.castcompanionlibrary.cast.BaseCastManager.ReconnectionStatus[mReconnectionStatus.ordinal()];
                                    JVM INSTR tableswitch 1 3: default 44
                                //                                               1 93
                                //                                               2 93
                                //                                               3 93;
                                       goto _L1 _L2 _L2 _L2
_L1:
                                    mReconnectionStatus = ReconnectionStatus.INACTIVE;
                                    if (dlg != null)
                                    {
                                        dlg.dismiss();
                                    }
                                    mReconnectionTask.cancel(true);
                                    return;
_L2:
                                    mReconnectionStatus = ReconnectionStatus.INACTIVE;
                                    onDeviceSelected(null);
                                    if (true) goto _L1; else goto _L3
_L3:
                                }

            
            {
                this$1 = _cls3.this;
                super();
            }
                            });
                            dlg.setButton(-2, "Cancel", new android.content.DialogInterface.OnClickListener() {

                                final _cls3 this$1;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    _cls7..SwitchMap.com.google.sample.castcompanionlibrary.cast.BaseCastManager.ReconnectionStatus[mReconnectionStatus.ordinal()];
                                    JVM INSTR tableswitch 1 3: default 44
                                //                                               1 93
                                //                                               2 93
                                //                                               3 93;
                                       goto _L1 _L2 _L2 _L2
_L1:
                                    mReconnectionStatus = ReconnectionStatus.INACTIVE;
                                    if (dlg != null)
                                    {
                                        dlg.cancel();
                                    }
                                    mReconnectionTask.cancel(true);
                                    return;
_L2:
                                    mReconnectionStatus = ReconnectionStatus.INACTIVE;
                                    onDeviceSelected(null);
                                    if (true) goto _L1; else goto _L3
_L3:
                                }

            
            {
                this$1 = _cls3.this;
                super();
            }
                            });
                            dlg.show();
                            return;
                        }
                    }


            
            {
                this$0 = BaseCastManager.this;
                showDialog = flag;
                context = context1;
                timeoutInSeconds = i;
                super();
            }
                };
                mReconnectionTask.execute(new Void[0]);
                return;
            }
        }
    }

    public void removeBaseCastConsumer(IBaseCastConsumer ibasecastconsumer)
    {
        this;
        JVM INSTR monitorenter ;
        if (ibasecastconsumer == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        if (mBaseCastConsumers.remove(ibasecastconsumer))
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("Successfully removed the existing BaseCastConsumer listener ").append(ibasecastconsumer).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ibasecastconsumer;
        throw ibasecastconsumer;
    }

    public void setContext(Context context)
    {
        mContext = context;
    }

    public void setDevice(CastDevice castdevice, boolean flag)
    {
        mSelectedCastDevice = castdevice;
        if (mSelectedCastDevice != null)
        {
            castdevice = mSelectedCastDevice.getFriendlyName();
        } else
        {
            castdevice = null;
        }
        mDeviceName = castdevice;
        if (mSelectedCastDevice != null) goto _L2; else goto _L1
_L1:
        if (!mConnectionSuspened)
        {
            Utils.saveStringToPreference(mContext, "session-id", null);
            Utils.saveStringToPreference(mContext, "route-id", null);
        }
        mConnectionSuspened = false;
        if (isConnected() && flag)
        {
            try
            {
                LogUtils.LOGD(TAG, "Calling stopApplication");
                stopApplication();
            }
            // Misplaced declaration of an exception variable
            catch (CastDevice castdevice)
            {
                LogUtils.LOGE(TAG, "Failed to stop the application after disconecting route", castdevice);
            }
            // Misplaced declaration of an exception variable
            catch (CastDevice castdevice)
            {
                LogUtils.LOGE(TAG, "Failed to stop the application after disconecting route", castdevice);
            }
            // Misplaced declaration of an exception variable
            catch (CastDevice castdevice)
            {
                LogUtils.LOGE(TAG, "Failed to stop the application after disconecting route", castdevice);
            }
            // Misplaced declaration of an exception variable
            catch (CastDevice castdevice)
            {
                LogUtils.LOGE(TAG, "Failed to stop the application after disconecting route", castdevice);
            }
        }
        onDisconnected();
        onDeviceUnselected();
        if (mApiClient != null)
        {
            LogUtils.LOGD(TAG, "Trying to disconnect");
            mApiClient.disconnect();
            if (mMediaRouter != null)
            {
                mMediaRouter.selectRoute(mMediaRouter.getDefaultRoute());
            }
            mApiClient = null;
        }
_L4:
        return;
_L2:
        if (mApiClient == null)
        {
            LogUtils.LOGD(TAG, (new StringBuilder()).append("acquiring a conenction to Google Play services for ").append(mSelectedCastDevice).toString());
            castdevice = getCastOptionBuilder(mSelectedCastDevice);
            mApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(mContext)).addApi(Cast.API, castdevice.build()).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
            mApiClient.connect();
            return;
        }
        if (!mApiClient.isConnected())
        {
            mApiClient.connect();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setDeviceMute(boolean flag)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        try
        {
            Cast.CastApi.setMute(mApiClient, flag);
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, (new StringBuilder()).append("Failed to set mute to: ").append(flag).toString(), exception);
        }
        throw new CastException("Failed to mute");
    }

    public void setDeviceVolume(double d)
        throws CastException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        try
        {
            Cast.CastApi.setVolume(mApiClient, d);
            return;
        }
        catch (Exception exception)
        {
            LogUtils.LOGE(TAG, "Failed to set volume", exception);
        }
        throw new CastException("Failed to set volume");
    }

    public final void setReconnectionStatus(ReconnectionStatus reconnectionstatus)
    {
        mReconnectionStatus = reconnectionstatus;
    }

    public final void setStopOnDisconnect(boolean flag)
    {
        mDestroyOnDisconnect = flag;
    }

    public void stopApplication()
        throws IllegalStateException, IOException, TransientNetworkDisconnectionException, NoConnectionException
    {
        checkConnectivity();
        Cast.CastApi.stopApplication(mApiClient).setResultCallback(new ResultCallback() {

            final BaseCastManager this$0;

            public volatile void onResult(Result result)
            {
                onResult((Status)result);
            }

            public void onResult(Status status)
            {
                if (!status.isSuccess())
                {
                    LogUtils.LOGD(BaseCastManager.TAG, "stopApplication -> onResult: stopping application failed");
                    onApplicationStopFailed(status.getStatusCode());
                    return;
                } else
                {
                    LogUtils.LOGD(BaseCastManager.TAG, "stopApplication -> onResult Stopped application successfully");
                    return;
                }
            }

            
            {
                this$0 = BaseCastManager.this;
                super();
            }
        });
    }


}
