// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.kindle.ui.NoContentOverlay;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.http.senna.sync.manager.SyncManager;
import com.amazon.gallery.thor.albums.AlbumPageTracker;
import com.amazon.gallery.thor.app.FreeTime;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.app.activity.MediaContentConfigurationHolder;
import com.amazon.gallery.thor.di.AppKeys;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            FTUELoadingContentFragment, FTUEAddPhotosFragment, CameraContentLoadingFragment, EmptyAlbumFragment, 
//            NoAlbumsFragment, ShowOverlayListener

public abstract class AbstractNoContentOverlay
    implements NoContentOverlay
{
    private class LoadingEndpointAsyncRunner extends AsyncTask
    {

        final AbstractNoContentOverlay this$0;

        private void loadEndpoint()
        {
            RestClient restclient = (RestClient)activity.getApplicationBean(Keys.REST_CLIENT);
            try
            {
                restclient.getEndpointManager().getEndpoint();
                return;
            }
            catch (TerminalException terminalexception)
            {
                GLogger.i(AbstractNoContentOverlay.TAG, "Failed to get endpoint", new Object[0]);
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            loadEndpoint();
            return null;
        }

        protected void onCancelled()
        {
            synchronized (AbstractNoContentOverlay.this)
            {
                loadingEndpointRunner = null;
            }
            return;
            exception;
            abstractnocontentoverlay;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected volatile void onCancelled(Object obj)
        {
            onCancelled((Void)obj);
        }

        protected void onCancelled(Void void1)
        {
            synchronized (AbstractNoContentOverlay.this)
            {
                loadingEndpointRunner = null;
            }
            return;
            exception;
            void1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            GLogger.d("LoadingEndpointAsyncRunner", "Finished", new Object[0]);
            synchronized (AbstractNoContentOverlay.this)
            {
                loadingEndpointRunner = null;
            }
            return;
            exception;
            void1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private LoadingEndpointAsyncRunner()
        {
            this$0 = AbstractNoContentOverlay.this;
            super();
        }

    }


    private static final String TAG = com/amazon/gallery/framework/kindle/ftue/AbstractNoContentOverlay.getName();
    protected BeanAwareActivity activity;
    protected volatile boolean attached;
    protected AuthenticationManager authenticationManager;
    protected Endpoint endpoint;
    protected Fragment fragment;
    protected Handler handler;
    private LoadingEndpointAsyncRunner loadingEndpointRunner;
    protected MediaStoreSyncProvider mediaStoreSyncProvider;
    protected NetworkConnectivity networkConnectivity;
    protected com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode nextContentMode;
    protected boolean noContentMode;
    protected ComponentProfiler profiler;
    protected ShowOverlayListener showOverlayListener;
    private final Runnable showRunnable = new Runnable() {

        final AbstractNoContentOverlay this$0;

        public void run()
        {
label0:
            {
                synchronized (AbstractNoContentOverlay.this)
                {
                    if (attached)
                    {
                        break label0;
                    }
                }
                return;
            }
            show();
            loadEndpoint();
            abstractnocontentoverlay;
            JVM INSTR monitorexit ;
            return;
            exception;
            abstractnocontentoverlay;
            JVM INSTR monitorexit ;
            throw exception;
        }

            
            {
                this$0 = AbstractNoContentOverlay.this;
                super();
            }
    };
    protected SyncManager syncManager;

    public AbstractNoContentOverlay(Profiler profiler1, SyncManager syncmanager, MediaStoreSyncProvider mediastoresyncprovider, NetworkConnectivity networkconnectivity, AuthenticationManager authenticationmanager)
    {
        handler = new Handler();
        attached = false;
        noContentMode = false;
        nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALL;
        profiler = new AddPhotosMetrics(profiler1);
        syncManager = syncmanager;
        mediaStoreSyncProvider = mediastoresyncprovider;
        networkConnectivity = networkconnectivity;
        authenticationManager = authenticationmanager;
    }

    private void loadEndpoint()
    {
        this;
        JVM INSTR monitorenter ;
        final NetworkConnectivity networkConnectivity;
        boolean flag;
        AuthenticationManager authenticationmanager = (AuthenticationManager)activity.getApplicationBean(Keys.AUTHENTICATING_MANAGER);
        networkConnectivity = (NetworkConnectivity)activity.getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        GlobalMessagingBus.register(this);
        flag = authenticationmanager.hasActiveAccount();
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (loadingEndpointRunner == null)
        {
            handler.post(new Runnable() {

                final AbstractNoContentOverlay this$0;
                final NetworkConnectivity val$networkConnectivity;

                public void run()
                {
label0:
                    {
                        synchronized (AbstractNoContentOverlay.this)
                        {
                            if (loadingEndpointRunner == null)
                            {
                                break label0;
                            }
                        }
                        return;
                    }
                    if (endpoint == null && networkConnectivity.getConnectionStatus() != com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.NONE)
                    {
                        loadingEndpointRunner = new LoadingEndpointAsyncRunner();
                        loadingEndpointRunner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                    abstractnocontentoverlay;
                    JVM INSTR monitorexit ;
                    return;
                    exception1;
                    abstractnocontentoverlay;
                    JVM INSTR monitorexit ;
                    throw exception1;
                }

            
            {
                this$0 = AbstractNoContentOverlay.this;
                networkConnectivity = networkconnectivity;
                super();
            }
            });
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void refresh()
    {
        if (attached && noContentMode && fragment != null)
        {
            boolean flag = fragment instanceof FTUELoadingContentFragment;
            boolean flag1 = shouldShowLoading();
            if (flag != flag1)
            {
                Fragment fragment1 = fragment;
                FragmentTransaction fragmenttransaction;
                if (!flag1)
                {
                    if (nextContentMode == com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALBUM)
                    {
                        fragment = createEmptyAlbumFragment();
                    } else
                    {
                        FTUEAddPhotosFragment ftueaddphotosfragment = createAddPhotosFragment();
                        ftueaddphotosfragment.setNoContentMode(nextContentMode);
                        fragment = ftueaddphotosfragment;
                    }
                } else
                {
                    FTUELoadingContentFragment ftueloadingcontentfragment = createLoadingContentFragment();
                    ftueloadingcontentfragment.setNoContentOverlay(this);
                    ftueloadingcontentfragment.setMediaStoreSyncProvider(mediaStoreSyncProvider);
                    fragment = ftueloadingcontentfragment;
                }
                fragmenttransaction = activity.getSupportFragmentManager().beginTransaction();
                fragmenttransaction.remove(fragment1);
                fragmenttransaction.add(getNoContentViewId(), fragment);
                fragmenttransaction.commitAllowingStateLoss();
                return;
            }
        }
    }

    private boolean shouldIgnoreCloudSync()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (activity != null)
            {
                flag = flag1;
                if (activity instanceof MediaContentConfigurationHolder)
                {
                    if (((MediaContentConfigurationHolder)activity).getMediaContentConfiguration().toViewDescriptor().getMediaProperty() != CommonMediaProperty.CAMERA)
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    private boolean shouldShowCameraLoading()
    {
        if (activity != null && (activity instanceof NativeGalleryActivity))
        {
            return ((NativeGalleryActivity)activity).configurationHasCameraContentLoadingScreen();
        } else
        {
            return false;
        }
    }

    private boolean shouldShowLoading()
    {
label0:
        {
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag2 = flag4;
            if (activity != null)
            {
                flag2 = flag4;
                if (activity.getIntent() != null)
                {
                    flag2 = activity.getIntent().getBooleanExtra("intent_extra_came_from_sign_in", false);
                }
            }
            boolean flag;
            boolean flag1;
            if (flag2 && mediaStoreSyncProvider.isCurrentlySyncing())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!((FreeTime)ThorGalleryApplication.getBean(AppKeys.THOR_FREE_TIME)).isFreeTime() && authenticationManager.getAccountId() != null && networkConnectivity.isNetworkConnected() && !syncManager.isColdBootCompleted() && !shouldIgnoreCloudSync())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag4 = AlbumPageTracker.getInstance().isLoading();
            if (!flag && !flag1)
            {
                flag2 = flag3;
                if (!flag4)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        return flag2;
    }

    public void attach(BeanAwareActivity beanawareactivity, Handler handler1, ShowOverlayListener showoverlaylistener)
    {
        activity = beanawareactivity;
        handler = handler1;
        showOverlayListener = showoverlaylistener;
        attached = true;
        if (isShowingNoContentMode())
        {
            showNoContentMode();
        }
    }

    protected FTUEAddPhotosFragment createAddPhotosFragment()
    {
        return new FTUEAddPhotosFragment();
    }

    protected CameraContentLoadingFragment createCameraContentLoadingFragment()
    {
        return new CameraContentLoadingFragment();
    }

    protected EmptyAlbumFragment createEmptyAlbumFragment()
    {
        return new EmptyAlbumFragment();
    }

    protected FTUELoadingContentFragment createLoadingContentFragment()
    {
        return new FTUELoadingContentFragment();
    }

    protected NoAlbumsFragment createNoAlbumsFragment()
    {
        return new NoAlbumsFragment();
    }

    public void detach()
    {
        this;
        JVM INSTR monitorenter ;
        hide();
        activity = null;
        fragment = null;
        handler = null;
        showOverlayListener = null;
        attached = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void hide()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = attached;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        GLogger.d(TAG, "Hiding no content overlay for no content mode", new Object[0]);
        handler.removeCallbacks(showRunnable);
        if (noContentMode && fragment != null)
        {
            noContentMode = false;
            FragmentTransaction fragmenttransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.remove(fragment);
            fragmenttransaction.commitAllowingStateLoss();
        }
        if (showOverlayListener != null)
        {
            showOverlayListener.onOverlayHide();
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isAttached()
    {
        return attached;
    }

    public boolean isShowingNoContentMode()
    {
        return noContentMode;
    }

    public void onEnterFullScreen()
    {
    }

    public void onExitFullScreen()
    {
    }

    public void onFocusedGained(ViewDescriptor viewdescriptor)
    {
    }

    public void onRotation()
    {
    }

    public void onViewStateChange(final ViewDescriptor viewDescriptor, final boolean finalized)
    {
        handler.post(new Runnable() {

            final AbstractNoContentOverlay this$0;
            final boolean val$finalized;
            final ViewDescriptor val$viewDescriptor;

            public void run()
            {
label0:
                {
                    synchronized (AbstractNoContentOverlay.this)
                    {
                        if (attached)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                if (finalized)
                {
                    break MISSING_BLOCK_LABEL_42;
                }
                hide();
                abstractnocontentoverlay;
                JVM INSTR monitorexit ;
                return;
                exception;
                abstractnocontentoverlay;
                JVM INSTR monitorexit ;
                throw exception;
                if (viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.TAG && viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.CUSTOM_DATA_SET)
                {
                    break MISSING_BLOCK_LABEL_78;
                }
                hide();
                abstractnocontentoverlay;
                JVM INSTR monitorexit ;
                return;
                if (viewDescriptor.getMediaProperty() != CommonMediaProperty.CAMERA) goto _L2; else goto _L1
_L1:
                nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CAMERA;
_L3:
                abstractnocontentoverlay;
                JVM INSTR monitorexit ;
                return;
_L2:
label1:
                {
                    if (viewDescriptor.getCollectionType() != com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.EVERYTHING)
                    {
                        break label1;
                    }
                    nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALL;
                }
                  goto _L3
label2:
                {
                    if (viewDescriptor.getMediaType() != MediaType.VIDEO)
                    {
                        break label2;
                    }
                    nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.VIDEOS;
                }
                  goto _L3
label3:
                {
                    if (viewDescriptor.getTag() == null || viewDescriptor.getTag().getType() != TagType.ALBUM)
                    {
                        break label3;
                    }
                    nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALBUM;
                }
                  goto _L3
label4:
                {
                    if (viewDescriptor.getTag() == null || viewDescriptor.getTag().getType() != TagType.FOLDER)
                    {
                        break label4;
                    }
                    nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CLOUD;
                }
                  goto _L3
                nextContentMode = com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.DEVICE;
                  goto _L3
            }

            
            {
                this$0 = AbstractNoContentOverlay.this;
                finalized = flag;
                viewDescriptor = viewdescriptor;
                super();
            }
        });
    }

    public void scheduleRefresh()
    {
        if (handler != null)
        {
            handler.post(new Runnable() {

                final AbstractNoContentOverlay this$0;

                public void run()
                {
                    if (attached)
                    {
                        refresh();
                    }
                }

            
            {
                this$0 = AbstractNoContentOverlay.this;
                super();
            }
            });
        }
    }

    protected void setNoContentFragment()
    {
        if (shouldShowCameraLoading())
        {
            fragment = createCameraContentLoadingFragment();
            return;
        }
        if (shouldShowLoading())
        {
            FTUELoadingContentFragment ftueloadingcontentfragment = createLoadingContentFragment();
            ftueloadingcontentfragment.setNoContentOverlay(this);
            ftueloadingcontentfragment.setMediaStoreSyncProvider(mediaStoreSyncProvider);
            fragment = ftueloadingcontentfragment;
            return;
        }
        if (nextContentMode == com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.CLOUD)
        {
            fragment = createNoAlbumsFragment();
            return;
        }
        if (nextContentMode == com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode.ALBUM)
        {
            fragment = createEmptyAlbumFragment();
            return;
        } else
        {
            FTUEAddPhotosFragment ftueaddphotosfragment = createAddPhotosFragment();
            ftueaddphotosfragment.setNoContentMode(nextContentMode);
            fragment = ftueaddphotosfragment;
            return;
        }
    }

    public void setNoContentMode(com.amazon.gallery.framework.kindle.ui.NoContentOverlay.ContentMode contentmode)
    {
        nextContentMode = contentmode;
    }

    public void show()
    {
        if (attached && !noContentMode)
        {
            GLogger.d(TAG, "Showing no content overlay for no content mode", new Object[0]);
            noContentMode = true;
            setNoContentFragment();
            FragmentTransaction fragmenttransaction = activity.getSupportFragmentManager().beginTransaction();
            fragmenttransaction.add(getNoContentViewId(), fragment);
            fragmenttransaction.commitAllowingStateLoss();
            if (showOverlayListener != null)
            {
                showOverlayListener.onOverlayShow();
                return;
            }
        }
    }

    public void showNoContentMode()
    {
        this;
        JVM INSTR monitorenter ;
        showNoContentMode(0L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void showNoContentMode(long l)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = attached;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        handler.removeCallbacks(showRunnable);
        handler.postDelayed(showRunnable, l);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }






/*
    static LoadingEndpointAsyncRunner access$202(AbstractNoContentOverlay abstractnocontentoverlay, LoadingEndpointAsyncRunner loadingendpointasyncrunner)
    {
        abstractnocontentoverlay.loadingEndpointRunner = loadingendpointasyncrunner;
        return loadingendpointasyncrunner;
    }

*/

}
