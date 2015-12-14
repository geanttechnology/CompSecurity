// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.SceneLoadedEvent;
import com.amazon.gallery.framework.gallery.widget.GridStatus;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ui.MarginHelper;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            LoadingSpinner, NetworkIndicator

public class ActivityIndicatorCheckThread extends Thread
{
    private class CheckVisibilityAndLoading
        implements Runnable
    {

        private GridStatus gridStatus;
        private LoadingSpinner loadingSpinner;
        private NetworkConnectivity networkConnectivity;
        final ActivityIndicatorCheckThread this$0;

        public void onDestroy()
        {
            networkIndicator.onDestroy();
        }

        public void run()
        {
            boolean flag2 = networkConnectivity.hasExceededErrorLimit();
            boolean flag1 = networkConnectivity.isNetworkConnected();
            NetworkIndicator.Status status;
            NetworkIndicator networkindicator;
            boolean flag;
            if (flag1 && flag2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag2 = gridStatus.isLoading();
            if (!flag1 || flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            networkindicator = networkIndicator;
            if (flag)
            {
                status = NetworkIndicator.Status.UNRELIABLE;
            } else
            {
                status = NetworkIndicator.Status.OFFLINE;
            }
            networkindicator.showIndicator(flag1, status);
            if (!flag1 && flag2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            loadingSpinner.showSpinner(flag1);
        }

        public CheckVisibilityAndLoading(NetworkConnectivity networkconnectivity, GridStatus gridstatus, LoadingSpinner loadingspinner)
        {
            this$0 = ActivityIndicatorCheckThread.this;
            super();
            gridStatus = gridstatus;
            loadingSpinner = loadingspinner;
            networkConnectivity = networkconnectivity;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/ui/ActivityIndicatorCheckThread.getName();
    private static final String THREAD_NAME = com/amazon/gallery/framework/kindle/ui/ActivityIndicatorCheckThread.getSimpleName();
    private CheckVisibilityAndLoading checkVisibilityAndLoading;
    private volatile boolean isDestroyed;
    private volatile boolean isPaused;
    private LoadingSpinner loadingSpinner;
    private final Object modificationLock = new Object();
    private NetworkIndicator networkIndicator;
    private final Handler uiThreadHandler = new Handler();

    public ActivityIndicatorCheckThread(Activity activity, ViewGroup viewgroup, GridStatus gridstatus, NetworkConnectivity networkconnectivity)
    {
        isPaused = false;
        isDestroyed = false;
        ViewGroup viewgroup1;
        if (viewgroup == null)
        {
            viewgroup = (ViewGroup)activity.findViewById(0x7f0c0111);
            viewgroup1 = (ViewGroup)activity.findViewById(0x7f0c011f);
        } else
        {
            viewgroup1 = (ViewGroup)viewgroup.findViewById(0x7f0c0111);
            ViewGroup viewgroup2 = (ViewGroup)viewgroup.findViewById(0x7f0c011f);
            viewgroup = viewgroup1;
            viewgroup1 = viewgroup2;
        }
        loadingSpinner = new LoadingSpinner(viewgroup);
        networkIndicator = new NetworkIndicator(activity, networkconnectivity, viewgroup1);
        checkVisibilityAndLoading = new CheckVisibilityAndLoading(networkconnectivity, gridstatus, loadingSpinner);
        setName(THREAD_NAME);
        setPriority(1);
        GLogger.d(TAG, "thread created.", new Object[0]);
    }

    public LoadingSpinner getLoadingSpinner()
    {
        return loadingSpinner;
    }

    public NetworkIndicator getNetworkIndicator()
    {
        return networkIndicator;
    }

    public void onDestroy()
    {
        GLogger.d(TAG, "thread onDestroyed.", new Object[0]);
        synchronized (modificationLock)
        {
            isPaused = false;
            isDestroyed = true;
            checkVisibilityAndLoading.onDestroy();
            checkVisibilityAndLoading = null;
            interrupt();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onPause()
    {
        GlobalMessagingBus.unregister(this);
        if (isPaused)
        {
            return;
        }
        synchronized (modificationLock)
        {
            isPaused = true;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onResume()
    {
        GlobalMessagingBus.register(this);
        if (!isPaused)
        {
            return;
        }
        synchronized (modificationLock)
        {
            isPaused = false;
            modificationLock.notify();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onSceneLoadedEvent(SceneLoadedEvent sceneloadedevent)
    {
        if (isDestroyed || isInterrupted() || isPaused)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        sceneloadedevent;
        this;
        JVM INSTR monitorexit ;
        throw sceneloadedevent;
    }

    public void run()
    {
        SystemClock.sleep(1000L);
_L2:
        if (isDestroyed || isInterrupted())
        {
            break; /* Loop/switch isn't completed */
        }
        uiThreadHandler.post(checkVisibilityAndLoading);
        this;
        JVM INSTR monitorenter ;
        wait(1000L);
        this;
        JVM INSTR monitorexit ;
        Object obj = modificationLock;
        obj;
        JVM INSTR monitorenter ;
        while (isPaused) 
        {
            GLogger.d(TAG, "thread pausing.", new Object[0]);
            modificationLock.wait();
        }
        break MISSING_BLOCK_LABEL_111;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            GLogger.d(TAG, "thread interrupted - ending the run.", new Object[0]);
        }
        Thread.currentThread().interrupt();
        continue; /* Loop/switch isn't completed */
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        GLogger.d(TAG, "thread ended run.", new Object[0]);
        return;
    }

    public void updateMargins(int i)
    {
        MarginHelper.adjustBottomMargin(loadingSpinner.getView(), i);
        MarginHelper.adjustBottomMargin(networkIndicator.getView(), i);
    }


}
