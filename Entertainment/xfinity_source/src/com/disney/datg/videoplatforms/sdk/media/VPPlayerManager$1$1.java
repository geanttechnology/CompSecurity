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
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.models.VPCatalog;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPPlayerManager, VPMediaPlayer, VPCatalogManager, VPMedia, 
//            Configuration

class val.mediaPlayer
    implements AsyncHandler
{

    final eAsync this$1;
    final VPMediaPlayer val$mediaPlayer;

    public void onAsyncTask()
    {
    }

    public void onError(Exception exception)
    {
        VPPlayerManager.access$102(_fld0, false);
        val$mediaPlayer.setDisplay(null);
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
        VPPlayerManager.access$102(_fld0, false);
        if (VPPlayerManager.access$200(_fld0))
        {
            val$mediaPlayer.setDisplay(null);
            return;
        } else
        {
            LogUtils.LOGD(VPPlayerManager.access$300(), "setDatasource with VPMedia successfull");
            val$mediaPlayer.setAudioStreamType(3);
            val$mediaPlayer.setScreenOnWhilePlaying(true);
            val$mediaPlayer.prepareAsync();
            return;
        }
    }

    l.ccContainer()
    {
        this$1 = final_cccontainer;
        val$mediaPlayer = VPMediaPlayer.this;
        super();
    }

    // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1

/* anonymous class */
    class VPPlayerManager._cls1
        implements Callable
    {

        final VPPlayerManager this$0;
        final RelativeLayout val$ccContainer;
        final Activity val$context;
        final AsyncHandler val$handler;
        final SurfaceHolder val$holder;
        final VPMedia val$media;

        public MediaPlayer call()
            throws Exception
        {
            VPPlayerManager.access$000(VPPlayerManager.this).setContext(context);
            if (media == null || TextUtils.isEmpty(media.getMediaId()))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "media item is null");
            }
            if (VPPlayerManager.access$200(VPPlayerManager.this))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
            }
            if (!TextUtils.isEmpty(media.getContentUrl())) goto _L2; else goto _L1
_L1:
            Object obj;
            if (TextUtils.isEmpty(media.getMediaId()))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "media id is null or empty");
            }
            obj = null;
            if (media.getMediaType() != VPMedia.MediaType.VOD) goto _L4; else goto _L3
_L3:
            obj = VPPlayerManager.access$000(VPPlayerManager.this).getVideoCatalog(media.getMediaId(), null);
_L6:
            if (VPPlayerManager.access$200(VPPlayerManager.this))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
            }
            break; /* Loop/switch isn't completed */
_L4:
            if (media.getMediaType() == VPMedia.MediaType.LIVE)
            {
                obj = VPPlayerManager.access$000(VPPlayerManager.this).getChannelCatalog(null);
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
            obj = VPPlayerManager.PlayerType.VOD;
            VPPlayerManager._cls2.$SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMedia$MediaType[media.getMediaType().ordinal()];
            JVM INSTR tableswitch 1 2: default 867
        //                       1 666
        //                       2 673;
               goto _L12 _L13 _L14
_L12:
            if (VPPlayerManager.access$200(VPPlayerManager.this))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
            }
              goto _L15
_L8:
            VPPlayerManager.access$102(VPPlayerManager.this, false);
            throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "catalog returned null or empty results for video media");
_L10:
            try
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                throw new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "catalog returned null or empty results for video media");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                if (handler != null)
                {
                    handler.onError(((Exception) (obj)));
                }
                throw obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                obj = VPPlayerManager.PlayerType.LIVE;
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
            obj = VPPlayerManager.PlayerType.VOD;
              goto _L12
_L15:
            obj = (VPMediaPlayer)getPlayer(((VPPlayerManager.PlayerType) (obj)), context, holder, ccContainer);
            if (VPPlayerManager.access$200(VPPlayerManager.this))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
                ((VPMediaPlayer) (obj)).setDisplay(null);
                throw new AndroidSDKException(ErrorCode.ANDROID_SDK_MEDIA_PLAYER_CREATION_EXCEPTION, "creation has been cancelled");
            }
            ((VPMediaPlayer) (obj)).setDataSource(vpmedia, ((VPPlayerManager._cls1._cls1) (obj)). new VPPlayerManager._cls1._cls1());
            ((VPMediaPlayer) (obj)).setOnPreparedListener(new VPPlayerManager._cls1._cls2());
            if (VPPlayerManager.access$200(VPPlayerManager.this))
            {
                VPPlayerManager.access$102(VPPlayerManager.this, false);
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
                this$0 = final_vpplayermanager;
                context = activity;
                media = vpmedia;
                handler = asynchandler;
                holder = surfaceholder;
                ccContainer = RelativeLayout.this;
                super();
            }

        // Unreferenced inner class com/disney/datg/videoplatforms/sdk/media/VPPlayerManager$1$2

/* anonymous class */
        class VPPlayerManager._cls1._cls2
            implements android.media.MediaPlayer.OnPreparedListener
        {

            final VPPlayerManager._cls1 this$1;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                if (handler != null)
                {
                    handler.onSuccess(mediaplayer);
                }
            }

                    
                    {
                        this$1 = VPPlayerManager._cls1.this;
                        super();
                    }
        }

    }

}
