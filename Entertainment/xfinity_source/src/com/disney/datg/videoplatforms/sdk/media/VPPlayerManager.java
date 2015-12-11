// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.app.Activity;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.ThreadPoolAccessor;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.VPCatalog;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            Configuration, VPCatalogManager, VODMediaPlayer, VPMediaPlayer, 
//            LiveMediaPlayer, VPMedia

public class VPPlayerManager
{
    public static final class PlayerType extends Enum
    {

        private static final PlayerType $VALUES[];
        public static final PlayerType LIVE;
        public static final PlayerType NATIVE;
        public static final PlayerType VOD;

        public static PlayerType valueOf(String s)
        {
            return (PlayerType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPPlayerManager$PlayerType, s);
        }

        public static PlayerType[] values()
        {
            return (PlayerType[])$VALUES.clone();
        }

        static 
        {
            LIVE = new PlayerType("LIVE", 0);
            VOD = new PlayerType("VOD", 1);
            NATIVE = new PlayerType("NATIVE", 2);
            $VALUES = (new PlayerType[] {
                LIVE, VOD, NATIVE
            });
        }

        private PlayerType(String s, int i)
        {
            super(s, i);
        }
    }


    private static String TAG = com/disney/datg/videoplatforms/sdk/media/VPPlayerManager.getName();
    private static VPPlayerManager _instance = new VPPlayerManager();
    private VPCatalogManager catalogManager;
    private Configuration configuration;
    private Future currentMediaPlayer;
    private ThreadPoolExecutor executorService;
    private boolean isCancelled;
    private boolean requestInProgress;

    private VPPlayerManager()
    {
        isCancelled = false;
        requestInProgress = false;
    }

    private static VPPlayerManager getInstance()
    {
        return _instance;
    }

    public static VPPlayerManager getPlayerManager(String s, String s1)
        throws AndroidSDKException
    {
        if (TextUtils.isEmpty(s))
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION, "invalid partnerName");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_PLAYER_MANAGER_CREATION_EXCEPTION, "invalid network identifier");
        } else
        {
            Configuration configuration1 = new Configuration();
            configuration1.initialize(s, s1);
            s = getInstance();
            s.setConfiguration(configuration1);
            s.setCatalogManager(VPCatalogManager.getCatalogManager(null, configuration1));
            return s;
        }
    }

    private void shutdown()
    {
        this;
        JVM INSTR monitorenter ;
        if (executorService != null)
        {
            executorService.shutdownNow();
        }
        ThreadPoolAccessor.getManager().forceCancel();
        executorService = null;
        isCancelled = false;
        requestInProgress = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
        throws Throwable
    {
        shutdown();
        LogUtils.LOGE(TAG, "Removing VPPlayerManager and shutting down resources");
        super.finalize();
    }

    public VPCatalogManager getCatalogManager()
    {
        return catalogManager;
    }

    public MediaPlayer getPlayer(PlayerType playertype, Activity activity, SurfaceHolder surfaceholder, RelativeLayout relativelayout)
        throws AndroidSDKException
    {
        this;
        JVM INSTR monitorenter ;
        static class _cls2
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[];
            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType = new int[PlayerType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[PlayerType.VOD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[PlayerType.LIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPPlayerManager$PlayerType[PlayerType.NATIVE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType = new int[VPMedia.MediaType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[VPMedia.MediaType.LIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[VPMedia.MediaType.VOD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPPlayerManager.PlayerType[playertype.ordinal()];
        JVM INSTR tableswitch 1 3: default 184
    //                   1 65
    //                   2 105
    //                   3 144;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION);
        playertype;
_L11:
        throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, playertype);
        playertype;
_L12:
        this;
        JVM INSTR monitorexit ;
        throw playertype;
_L2:
        playertype = new VODMediaPlayer(activity, configuration);
        if (surfaceholder == null) goto _L6; else goto _L5
_L5:
        activity = playertype;
        activity = playertype;
        playertype.setDisplay(surfaceholder);
_L6:
        activity = playertype;
        activity = playertype;
        playertype.setClosedCaptionContainer(relativelayout);
_L9:
        this;
        JVM INSTR monitorexit ;
        return playertype;
_L3:
        playertype = new LiveMediaPlayer(activity, configuration);
        if (surfaceholder == null) goto _L8; else goto _L7
_L7:
        activity = playertype;
        activity = playertype;
        playertype.setDisplay(surfaceholder);
_L8:
        activity = playertype;
        activity = playertype;
        playertype.setClosedCaptionContainer(relativelayout);
          goto _L9
_L4:
        playertype = new VODMediaPlayer(activity, configuration);
        if (surfaceholder == null) goto _L9; else goto _L10
_L10:
        activity = playertype;
        activity = playertype;
        playertype.setDisplay(surfaceholder);
          goto _L9
        playertype;
          goto _L11
        playertype;
          goto _L12
    }

    public Future getPlayer(final Activity context, final VPMedia media, final SurfaceHolder holder, final RelativeLayout ccContainer, final AsyncHandler handler)
    {
        if (currentMediaPlayer != null)
        {
            if (!currentMediaPlayer.isCancelled() || !currentMediaPlayer.isDone())
            {
                currentMediaPlayer.cancel(true);
                shutdown();
            }
        } else
        {
            isCancelled = false;
        }
        this;
        JVM INSTR monitorenter ;
        if (isCancelled || executorService == null)
        {
            executorService = new ThreadPoolExecutor(10, 10, 12L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));
            executorService.allowCoreThreadTimeOut(true);
        }
        this;
        JVM INSTR monitorexit ;
        currentMediaPlayer = executorService.submit(new Callable() {

            final VPPlayerManager this$0;
            final RelativeLayout val$ccContainer;
            final Activity val$context;
            final AsyncHandler val$handler;
            final SurfaceHolder val$holder;
            final VPMedia val$media;

            public MediaPlayer call()
                throws Exception
            {
                catalogManager.setContext(context);
                if (media == null || TextUtils.isEmpty(media.getMediaId()))
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "media item is null");
                }
                if (isCancelled)
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
                }
                if (!TextUtils.isEmpty(media.getContentUrl())) goto _L2; else goto _L1
_L1:
                Object obj;
                if (TextUtils.isEmpty(media.getMediaId()))
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "media id is null or empty");
                }
                obj = null;
                if (media.getMediaType() != VPMedia.MediaType.VOD) goto _L4; else goto _L3
_L3:
                obj = catalogManager.getVideoCatalog(media.getMediaId(), null);
_L6:
                if (isCancelled)
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
                }
                break; /* Loop/switch isn't completed */
_L4:
                if (media.getMediaType() == VPMedia.MediaType.LIVE)
                {
                    obj = catalogManager.getChannelCatalog(null);
                }
                if (true) goto _L6; else goto _L5
_L5:
                if (obj == null) goto _L8; else goto _L7
_L7:
                obj = (VPCatalog)((Future) (obj)).get(Configuration.SERVICE_TIMEOUT, TimeUnit.SECONDS);
                if (obj == null) goto _L10; else goto _L9
_L9:
                if (((VPCatalog) (obj)).getCollection() == null || ((VPCatalog) (obj)).getCollection().size() <= 0) goto _L10; else goto _L11
_L11:
                VPMedia vpmedia = (VPMedia)((VPCatalog) (obj)).getCollection().get(0);
_L17:
                obj = PlayerType.VOD;
                _cls2..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMedia.MediaType[media.getMediaType().ordinal()];
                JVM INSTR tableswitch 1 2: default 867
            //                           1 666
            //                           2 673;
                   goto _L12 _L13 _L14
_L12:
                if (isCancelled)
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
                }
                  goto _L15
_L8:
                requestInProgress = false;
                throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "catalog returned null or empty results for video media");
_L10:
                try
                {
                    requestInProgress = false;
                    throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "catalog returned null or empty results for video media");
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj)));
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj)));
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj)));
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                    obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_TIMEOUT, ((Throwable) (obj)));
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    requestInProgress = false;
                }
                obj = new AndroidSDKException(ErrorCode.ANDROID_SDK_VIDEOS_SERVICE_ERROR, ((Throwable) (obj)));
                if (handler != null)
                {
                    handler.onError(((Exception) (obj)));
                }
                throw obj;
_L2:
                vpmedia = media;
                continue; /* Loop/switch isn't completed */
_L13:
                try
                {
                    obj = PlayerType.LIVE;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (handler != null)
                    {
                        handler.onError(((Exception) (obj)));
                    }
                    throw obj;
                }
                  goto _L12
_L14:
                obj = PlayerType.VOD;
                  goto _L12
_L15:
                obj = (VPMediaPlayer)getPlayer(((PlayerType) (obj)), context, holder, ccContainer);
                if (isCancelled)
                {
                    requestInProgress = false;
                    ((VPMediaPlayer) (obj)).setDisplay(null);
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
                }
                ((VPMediaPlayer) (obj)).setDataSource(vpmedia, ((_cls1) (obj)). new AsyncHandler() {

                    final _cls1 this$1;
                    final VPMediaPlayer val$mediaPlayer;

                    public void onAsyncTask()
                    {
                    }

                    public void onError(Exception exception)
                    {
                        requestInProgress = false;
                        mediaPlayer.setDisplay(null);
                        exception = new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, exception);
                        if (handler != null)
                        {
                            handler.onError(exception);
                        }
                    }

                    public volatile void onSuccess(Object obj)
                    {
                        onSuccess((String)obj);
                    }

                    public void onSuccess(String s)
                    {
                        requestInProgress = false;
                        if (isCancelled)
                        {
                            mediaPlayer.setDisplay(null);
                            return;
                        } else
                        {
                            LogUtils.LOGD(VPPlayerManager.TAG, "setDatasource with VPMedia successfull");
                            mediaPlayer.setAudioStreamType(3);
                            mediaPlayer.setScreenOnWhilePlaying(true);
                            mediaPlayer.prepareAsync();
                            return;
                        }
                    }

            
            {
                this$1 = final__pcls1;
                mediaPlayer = VPMediaPlayer.this;
                super();
            }
                });
                ((VPMediaPlayer) (obj)).setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

                    final _cls1 this$1;

                    public void onPrepared(MediaPlayer mediaplayer)
                    {
                        if (handler != null)
                        {
                            handler.onSuccess(mediaplayer);
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                if (isCancelled)
                {
                    requestInProgress = false;
                    ((VPMediaPlayer) (obj)).setDisplay(null);
                    throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
                }
                return ((MediaPlayer) (obj));
                if (true) goto _L17; else goto _L16
_L16:
            }

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            
            {
                this$0 = VPPlayerManager.this;
                context = activity;
                media = vpmedia;
                handler = asynchandler;
                holder = surfaceholder;
                ccContainer = relativelayout;
                super();
            }
        });
        requestInProgress = true;
        if (currentMediaPlayer != null && isCancelled)
        {
            currentMediaPlayer.cancel(true);
        }
        return currentMediaPlayer;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    public Future getPlayer(Activity activity, VPMedia vpmedia, SurfaceHolder surfaceholder, AsyncHandler asynchandler)
    {
        return getPlayer(activity, vpmedia, surfaceholder, null, asynchandler);
    }

    public void setCatalogManager(VPCatalogManager vpcatalogmanager)
    {
        catalogManager = vpcatalogmanager;
    }

    public void setConfiguration(Configuration configuration1)
    {
        configuration = configuration1;
    }




/*
    static boolean access$102(VPPlayerManager vpplayermanager, boolean flag)
    {
        vpplayermanager.requestInProgress = flag;
        return flag;
    }

*/


}
