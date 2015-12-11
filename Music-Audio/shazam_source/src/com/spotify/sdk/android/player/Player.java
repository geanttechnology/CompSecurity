// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.spotify.sdk.android.player;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.spotify.sdk.android.player:
//            ConnectionStateCallback, NativePlayerNotificationCallback, AudioTrackController, NativeSdkPlayer, 
//            NativePlayer, NativeSpotifyException, Config, AudioController, 
//            PlayerNotificationCallback, PlayerStateCallback, PlayerState, PlayConfig, 
//            Connectivity, PlaybackBitrate

public final class Player
    implements ConnectionStateCallback, NativePlayer.AudioDeliveredCallback, NativePlayer.AudioFlushCallback, NativePlayerNotificationCallback, ExecutorService
{
    public static interface InitializationObserver
    {

        public abstract void onError(Throwable throwable);

        public abstract void onInitialized(Player player);
    }


    static final int CACHE_REFRESH_INTERVAL_IN_MS = 5000;
    static final String THREAD_NAME = "SpotifySdkPlayer";
    private static Thread sPlayerThread;
    private final AudioController mAudioController;
    private final ScheduledExecutorService mCacheExecutorService = Executors.newSingleThreadScheduledExecutor();
    private final Set mConnectionStateCallbacks = Collections.synchronizedSet(new HashSet());
    private final Handler mHandler;
    private InitializationState mInitializationState;
    private final Object mInitializedMutex = new Object();
    private boolean mIsLoggedIn;
    private final Object mLoggedInMutex = new Object();
    private final NativePlayer mNativePlayer;
    private final List mPendingTasks = new LinkedList();
    private final Object mPendingTasksMutex = new Object();
    private final Set mPlayerNotificationCallbacks = Collections.synchronizedSet(new HashSet());
    private final Object mPlayerNotificationMutex = new Object();
    private volatile boolean mShouldShutdown;

    private Player(NativePlayer nativeplayer, AudioController audiocontroller, Handler handler)
    {
    /* block-local class not found */
    class InitializationState {}

        mInitializationState = InitializationState.PENDING;
        Object obj = audiocontroller;
        if (audiocontroller == null)
        {
            obj = new AudioTrackController();
        }
        mAudioController = ((AudioController) (obj));
        audiocontroller = handler;
        if (handler == null)
        {
            audiocontroller = new Handler(Looper.getMainLooper());
        }
        mHandler = audiocontroller;
        audiocontroller = nativeplayer;
        if (nativeplayer == null)
        {
            audiocontroller = new NativeSdkPlayer();
        }
        mNativePlayer = audiocontroller;
        mNativePlayer.registerAudioDeliveredCallback(this);
        mNativePlayer.registerAudioFlushCallback(this);
    }

    private void checkForShutdown()
    {
        if (isShutdown())
        {
            throw new RejectedExecutionException("Player is shut down");
        } else
        {
            return;
        }
    }

    public static Player create(Config config)
    {
        return create(config, null, null, null, null);
    }

    private static Player create(Config config, NativePlayer nativeplayer, AudioController audiocontroller, Handler handler, InitializationObserver initializationobserver)
    {
        if (config == null)
        {
            throw new IllegalArgumentException("Config can't be null");
        } else
        {
            nativeplayer = new Player(nativeplayer, audiocontroller, handler);
            config = new _cls1(nativeplayer, config, initializationobserver);
            sPlayerThread = config;
            config.start();
            return nativeplayer;
        }
    }

    public static Player create(Config config, InitializationObserver initializationobserver)
    {
        return create(config, null, null, null, initializationobserver);
    }

    private RunnableFuture createRunnableFuture(Runnable runnable, Object obj)
    {
        return new FutureTask(runnable, obj);
    }

    private RunnableFuture createRunnableFuture(Callable callable)
    {
        return new FutureTask(callable);
    }

    private void startRunLoop(Config config, InitializationObserver initializationobserver)
    {
        Object obj = mInitializedMutex;
        obj;
        JVM INSTR monitorenter ;
        mNativePlayer.initialize(config);
        mInitializationState = InitializationState.INITIALIZED;
        mShouldShutdown = false;
        mInitializedMutex.notifyAll();
        if (initializationobserver == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        mHandler.post(new _cls2(initializationobserver));
        obj;
        JVM INSTR monitorexit ;
        mNativePlayer.login(config.oauthToken);
        config = new _cls4();
        mCacheExecutorService.scheduleAtFixedRate(new _cls5(config), 5000L, 5000L, TimeUnit.MILLISECONDS);
        mNativePlayer.setConnectionStateCallback(this);
        mNativePlayer.setPlayerNotificationCallback(this);
        config = new ArrayList();
        mAudioController.start();
_L3:
        if (mShouldShutdown) goto _L2; else goto _L1
_L1:
        synchronized (mPendingTasksMutex)
        {
            if (!mPendingTasks.isEmpty())
            {
                config.addAll(mPendingTasks);
                mPendingTasks.clear();
            }
        }
        if (config.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        for (initializationobserver = config.iterator(); initializationobserver.hasNext(); ((Runnable)initializationobserver.next()).run()) { }
        break MISSING_BLOCK_LABEL_298;
        config;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw config;
        }
        // Misplaced declaration of an exception variable
        catch (Config config)
        {
            mInitializationState = InitializationState.TERMINATED;
        }
        if (initializationobserver != null)
        {
            mHandler.post(new _cls3(initializationobserver, config));
        }
        synchronized (mInitializedMutex)
        {
            mInitializedMutex.notifyAll();
        }
        return;
        initializationobserver;
        config;
        JVM INSTR monitorexit ;
        throw initializationobserver;
        config;
        initializationobserver;
        JVM INSTR monitorexit ;
        throw config;
        config.clear();
        mNativePlayer.pumpEvents();
          goto _L3
_L2:
        mAudioController.stop();
        mNativePlayer.logout();
        mNativePlayer.destroy();
        mCacheExecutorService.shutdown();
        mInitializationState = InitializationState.TERMINATED;
        return;
    }

    public final void addConnectionStateCallback(ConnectionStateCallback connectionstatecallback)
    {
        if (connectionstatecallback == null)
        {
            throw new IllegalArgumentException("Callback can't be null");
        } else
        {
            mConnectionStateCallbacks.add(connectionstatecallback);
            return;
        }
    }

    public final void addPlayerNotificationCallback(PlayerNotificationCallback playernotificationcallback)
    {
        if (playernotificationcallback == null)
        {
            throw new IllegalArgumentException("Callback can't be null");
        }
        synchronized (mPlayerNotificationMutex)
        {
            mPlayerNotificationCallbacks.add(playernotificationcallback);
        }
        return;
        playernotificationcallback;
        obj;
        JVM INSTR monitorexit ;
        throw playernotificationcallback;
    }

    public final boolean awaitTermination(long l, TimeUnit timeunit)
    {
        timeunit.timedJoin(sPlayerThread, l);
        return isTerminated();
    }

    public final void clearQueue()
    {
        submit(new _cls17());
    }

    public final void execute(Runnable runnable)
    {
        checkForShutdown();
        synchronized (mPendingTasksMutex)
        {
            mPendingTasks.add(runnable);
        }
        return;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public final void getPlayerState(PlayerStateCallback playerstatecallback)
    {
        execute(new _cls26(playerstatecallback));
    }

    public final List invokeAll(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final List invokeAll(Collection collection, long l, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException();
    }

    public final Object invokeAny(Collection collection)
    {
        throw new UnsupportedOperationException();
    }

    public final Object invokeAny(Collection collection, long l, TimeUnit timeunit)
    {
        throw new UnsupportedOperationException();
    }

    public final boolean isInitialized()
    {
        Object obj = mInitializedMutex;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (!isShutdown() && mInitializationState == InitializationState.INITIALIZED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isLoggedIn()
    {
        Object obj = mLoggedInMutex;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (isInitialized() && mIsLoggedIn)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isShutdown()
    {
        boolean flag;
        synchronized (mInitializedMutex)
        {
            flag = mShouldShutdown;
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean isTerminated()
    {
        Object obj = mInitializedMutex;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (mInitializationState == InitializationState.TERMINATED)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final boolean login(String s)
    {
        if (isLoggedIn())
        {
            return false;
        } else
        {
            submit(new _cls6(s));
            return true;
        }
    }

    public final boolean logout()
    {
        if (!isLoggedIn())
        {
            return false;
        } else
        {
            submit(new _cls7());
            return true;
        }
    }

    public final int onAudioDelivered(short aword0[], int i, int j, int k)
    {
        return mAudioController.onAudioDataDelivered(aword0, i, j, k);
    }

    public final void onAudioFlush()
    {
        mAudioController.onAudioFlush();
    }

    public final void onConnectionMessage(String s)
    {
        ConnectionStateCallback connectionstatecallback;
        for (Iterator iterator = mConnectionStateCallbacks.iterator(); iterator.hasNext(); mHandler.post(new _cls12(connectionstatecallback, s)))
        {
            connectionstatecallback = (ConnectionStateCallback)iterator.next();
        }

    }

    public final void onLoggedIn()
    {
        synchronized (mLoggedInMutex)
        {
            mIsLoggedIn = true;
        }
        ConnectionStateCallback connectionstatecallback;
        for (obj = mConnectionStateCallbacks.iterator(); ((Iterator) (obj)).hasNext(); mHandler.post(new _cls8(connectionstatecallback)))
        {
            connectionstatecallback = (ConnectionStateCallback)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_68;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoggedOut()
    {
        synchronized (mLoggedInMutex)
        {
            mIsLoggedIn = false;
        }
        ConnectionStateCallback connectionstatecallback;
        for (obj = mConnectionStateCallbacks.iterator(); ((Iterator) (obj)).hasNext(); mHandler.post(new _cls9(connectionstatecallback)))
        {
            connectionstatecallback = (ConnectionStateCallback)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_68;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onLoginFailed(Throwable throwable)
    {
        ConnectionStateCallback connectionstatecallback;
        for (Iterator iterator = mConnectionStateCallbacks.iterator(); iterator.hasNext(); mHandler.post(new _cls10(connectionstatecallback, throwable)))
        {
            connectionstatecallback = (ConnectionStateCallback)iterator.next();
        }

    }

    public final void onPlaybackError(int i, String s)
    {
        PlayerNotificationCallback.ErrorType errortype = PlayerNotificationCallback.ErrorType.fromCode(i);
        Object obj = mPlayerNotificationMutex;
        obj;
        JVM INSTR monitorenter ;
        PlayerNotificationCallback playernotificationcallback;
        for (Iterator iterator = mPlayerNotificationCallbacks.iterator(); iterator.hasNext(); mHandler.post(new _cls29(playernotificationcallback, errortype, s)))
        {
            playernotificationcallback = (PlayerNotificationCallback)iterator.next();
        }

        break MISSING_BLOCK_LABEL_75;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void onPlaybackEvent(int i, PlayerState playerstate)
    {
        PlayerNotificationCallback.EventType eventtype;
        eventtype = PlayerNotificationCallback.EventType.fromCode(i);
        if (eventtype == PlayerNotificationCallback.EventType.LOST_PERMISSION)
        {
            pause();
        }
        Object obj = mPlayerNotificationMutex;
        obj;
        JVM INSTR monitorenter ;
        PlayerNotificationCallback playernotificationcallback;
        for (Iterator iterator = mPlayerNotificationCallbacks.iterator(); iterator.hasNext(); mHandler.post(new _cls28(playernotificationcallback, eventtype, playerstate)))
        {
            playernotificationcallback = (PlayerNotificationCallback)iterator.next();
        }

        break MISSING_BLOCK_LABEL_87;
        playerstate;
        obj;
        JVM INSTR monitorexit ;
        throw playerstate;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void onTemporaryError()
    {
        ConnectionStateCallback connectionstatecallback;
        for (Iterator iterator = mConnectionStateCallbacks.iterator(); iterator.hasNext(); mHandler.post(new _cls11(connectionstatecallback)))
        {
            connectionstatecallback = (ConnectionStateCallback)iterator.next();
        }

    }

    public final void pause()
    {
        submit(new _cls18());
    }

    public final void play(PlayConfig playconfig)
    {
        submit(new _cls15(playconfig));
    }

    public final void play(String s)
    {
        submit(new _cls13(s));
    }

    public final void play(List list)
    {
        submit(new _cls14(list));
    }

    public final void queue(String s)
    {
        submit(new _cls16(s));
    }

    public final void removeConnectionStateCallback(ConnectionStateCallback connectionstatecallback)
    {
        mConnectionStateCallbacks.remove(connectionstatecallback);
    }

    public final void removePlayerNotificationCallback(PlayerNotificationCallback playernotificationcallback)
    {
        synchronized (mPlayerNotificationMutex)
        {
            mPlayerNotificationCallbacks.remove(playernotificationcallback);
        }
        return;
        playernotificationcallback;
        obj;
        JVM INSTR monitorexit ;
        throw playernotificationcallback;
    }

    public final void resume()
    {
        submit(new _cls19());
    }

    public final void seekToPosition(int i)
    {
        submit(new _cls22(i));
    }

    public final void setConnectivityStatus(Connectivity connectivity)
    {
        execute(new _cls27(connectivity));
    }

    public final void setPlaybackBitrate(PlaybackBitrate playbackbitrate)
    {
        submit(new _cls25(playbackbitrate));
    }

    public final void setRepeat(boolean flag)
    {
        submit(new _cls24(flag));
    }

    public final void setShuffle(boolean flag)
    {
        submit(new _cls23(flag));
    }

    public final void shutdown()
    {
        Object obj = mInitializedMutex;
        obj;
        JVM INSTR monitorenter ;
        InitializationState initializationstate;
        InitializationState initializationstate1;
        initializationstate = mInitializationState;
        initializationstate1 = InitializationState.PENDING;
        if (initializationstate != initializationstate1)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        mInitializedMutex.wait();
_L1:
        mShouldShutdown = true;
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Thread.currentThread().interrupt();
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final List shutdownNow()
    {
        shutdown();
        LinkedList linkedlist;
        synchronized (mPendingTasksMutex)
        {
            linkedlist = new LinkedList(mPendingTasks);
            mPendingTasks.clear();
        }
        return linkedlist;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void skipToNext()
    {
        submit(new _cls20());
    }

    public final void skipToPrevious()
    {
        submit(new _cls21());
    }

    public final Future submit(Runnable runnable)
    {
        checkForShutdown();
        RunnableFuture runnablefuture = createRunnableFuture(runnable, null);
        synchronized (mPendingTasksMutex)
        {
            mPendingTasks.add(runnable);
        }
        return runnablefuture;
        runnable;
        obj;
        JVM INSTR monitorexit ;
        throw runnable;
    }

    public final Future submit(Runnable runnable, Object obj)
    {
        checkForShutdown();
        obj = createRunnableFuture(runnable, obj);
        synchronized (mPendingTasksMutex)
        {
            mPendingTasks.add(obj);
        }
        return ((Future) (obj));
        obj;
        runnable;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public final Future submit(Callable callable)
    {
        checkForShutdown();
        RunnableFuture runnablefuture = createRunnableFuture(callable);
        synchronized (mPendingTasksMutex)
        {
            mPendingTasks.add(runnablefuture);
        }
        return runnablefuture;
        exception;
        callable;
        JVM INSTR monitorexit ;
        throw exception;
    }







    // Unreferenced inner class com/spotify/sdk/android/player/Player$Builder
    /* block-local class not found */
    class Builder {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls17 {}


    /* member class not found */
    class _cls26 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls29 {}


    /* member class not found */
    class _cls28 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls18 {}


    /* member class not found */
    class _cls15 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls16 {}


    /* member class not found */
    class _cls19 {}


    /* member class not found */
    class _cls22 {}


    /* member class not found */
    class _cls27 {}


    /* member class not found */
    class _cls25 {}


    /* member class not found */
    class _cls24 {}


    /* member class not found */
    class _cls23 {}


    /* member class not found */
    class _cls20 {}


    /* member class not found */
    class _cls21 {}

}
