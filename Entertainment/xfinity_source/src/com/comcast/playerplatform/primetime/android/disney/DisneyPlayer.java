// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.disney;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.asset.DisneyAsset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.player.DisneyEspnTokenDelegate;
import com.comcast.playerplatform.primetime.android.player.Player;
import com.comcast.playerplatform.primetime.android.player.PlayerSettings;
import com.comcast.playerplatform.primetime.android.player.PlayerSettingsListener;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.ClosedCaptionFormatBuilder;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import com.comcast.playerplatform.util.android.StringUtil;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.common.VPAuthToken;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.media.VPCatalogManager;
import com.disney.datg.videoplatforms.sdk.media.VPMedia;
import com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer;
import com.disney.datg.videoplatforms.sdk.media.VPPlayerManager;
import com.disney.datg.videoplatforms.sdk.models.VPCatalog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.playerplatform.primetime.android.disney:
//            DisneyClosedCaptionTrack

public class DisneyPlayer
    implements android.media.MediaPlayer.OnErrorListener, android.view.SurfaceHolder.Callback, Player, PlayerSettingsListener, com.disney.datg.videoplatforms.sdk.media.VPMedia.VPMediaAuthorizationListener
{

    private static final Logger logger = LoggerFactory.getLogger(com/comcast/playerplatform/primetime/android/disney/DisneyPlayer);
    private Activity activity;
    private ArrayList captioningTracks;
    private RelativeLayout ccContainer;
    private ClosedCaptionFormatBuilder closedCaptionOptions;
    private Asset currentChannel;
    private DisneyClosedCaptionTrack disneyCaptionTrack;
    private Map disneyNetwordIdMap;
    boolean isDrmComplete;
    private boolean isRetryAttempting;
    private AbstractPlayerPlatformVideoEventListener listener;
    private VPMediaPlayer mediaPlayer;
    private AsyncHandler newPlayerHandler;
    private VPPlayerManager playerManager;
    private PlayerSettings playerSettings;
    private SurfaceView playerSurface;
    private String provider;
    private AsyncHandler refreshPlayerHandler;
    private PlayerStatus status;

    public DisneyPlayer(Context context, Activity activity1, PlayerSettings playersettings)
    {
        provider = "comcast";
        isDrmComplete = false;
        disneyCaptionTrack = new DisneyClosedCaptionTrack(false);
        isRetryAttempting = false;
        refreshPlayerHandler = new AsyncHandler() {

            final DisneyPlayer this$0;

            public void onAsyncTask()
            {
            }

            public void onError(Exception exception)
            {
                DisneyPlayer.logger.error(String.format("TeaTime-error: ", new Object[] {
                    exception.getMessage()
                }));
                if (listener != null)
                {
                    listener.onBufferComplete();
                    handleDisneyException(exception);
                }
                mediaPlayer.release();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s)
            {
                status = PlayerStatus.PREPARED;
                updatePlayState(PlayerStatus.PREPARED);
                isDrmComplete = true;
                if (listener != null)
                {
                    listener.onBufferComplete();
                }
                isRetryAttempting = false;
            }

            
            {
                this$0 = DisneyPlayer.this;
                super();
            }
        };
        newPlayerHandler = new AsyncHandler() {

            final DisneyPlayer this$0;

            public void onAsyncTask()
            {
            }

            public void onError(Exception exception)
            {
                DisneyPlayer.logger.error(String.format("TeaTime-error: ", new Object[] {
                    exception.getMessage()
                }));
                if (listener != null)
                {
                    handleDisneyException(exception);
                }
                mediaPlayer.release();
            }

            public void onSuccess(MediaPlayer mediaplayer)
            {
                setUpPlayer(mediaplayer);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((MediaPlayer)obj);
            }

            
            {
                this$0 = DisneyPlayer.this;
                super();
            }
        };
        ccContainer = new RelativeLayout(context);
        ccContainer.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        captioningTracks = new ArrayList(1);
        captioningTracks.add(disneyCaptionTrack);
        status = PlayerStatus.IDLE;
        disneyNetwordIdMap = getDisneyNetwordIdMap();
        playerSurface = new SurfaceView(context);
        playerSurface.getHolder().addCallback(this);
        playerSettings = playersettings;
        playerSettings.addListener(this);
        activity = activity1;
        setClosedCaptionsOptions();
    }

    private VPMedia getMediaFromCatalog()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        obj5 = null;
        obj6 = null;
        obj7 = null;
        obj4 = null;
        obj = playerManager.getCatalogManager().getChannelCatalog(null);
        obj1 = obj5;
        obj2 = obj6;
        obj3 = obj7;
        VPCatalog vpcatalog = (VPCatalog)((Future) (obj)).get(5L, TimeUnit.SECONDS);
        obj = obj4;
        obj1 = obj5;
        obj2 = obj6;
        obj3 = obj7;
        if (vpcatalog.getCollection() == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj = obj4;
        obj1 = obj5;
        obj2 = obj6;
        obj3 = obj7;
        if (vpcatalog.getCollection().size() <= 0)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        obj1 = obj5;
        obj2 = obj6;
        obj3 = obj7;
        updatePlayState(PlayerStatus.INITIALIZED);
        obj1 = obj5;
        obj2 = obj6;
        obj3 = obj7;
        obj = (VPMedia)vpcatalog.getCollection().get(0);
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        ((VPMedia) (obj)).setOnAuthorizationListener(this);
        obj1 = obj;
        obj2 = obj;
        obj3 = obj;
        try
        {
            updatePlayState(PlayerStatus.PREPARING);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception = ((InterruptedException) (obj3));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = obj1;
        }
        if (obj == null && listener != null)
        {
            listener.mediaFailed("2002", "Failed to acquire Disney Media");
        }
        return ((VPMedia) (obj));
    }

    private void handleDisneyException(Exception exception)
    {
        if (exception instanceof AndroidSDKException)
        {
            listener.mediaFailed(String.valueOf(((AndroidSDKException)exception).getErrorCode().getErrorCode()), ((AndroidSDKException)exception).getLocalizedMessage());
            return;
        } else
        {
            listener.mediaFailed("2003", (new StringBuilder()).append("Generic disney playback failure. ").append(exception.getLocalizedMessage()).toString());
            return;
        }
    }

    private void playMedia(final VPMedia media)
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final DisneyPlayer this$0;
            final VPMedia val$media;

            public void run()
            {
                Activity activity1;
                if (activity == null)
                {
                    break MISSING_BLOCK_LABEL_52;
                }
                activity1 = activity;
_L1:
                playerManager.getPlayer(activity1, media, playerSurface.getHolder(), newPlayerHandler);
                return;
                try
                {
                    activity1 = ((DisneyAsset)currentChannel).getActivity();
                }
                catch (Exception exception)
                {
                    if (listener != null)
                    {
                        listener.onBufferComplete();
                        handleDisneyException(exception);
                    }
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = DisneyPlayer.this;
                media = vpmedia;
                super();
            }
        });
    }

    private void refreshCaptionContainer()
    {
        if (ccContainer.getParent() != null)
        {
            ((FrameLayout)ccContainer.getParent()).removeView(ccContainer);
        }
        ((FrameLayout)playerSurface.getParent()).addView(ccContainer);
    }

    private void retryAsset()
    {
        logger.debug("teatime-retryAsset");
        isRetryAttempting = true;
        isDrmComplete = false;
        if (listener != null)
        {
            listener.onBufferStart();
        }
        FrameLayout framelayout = (FrameLayout)playerSurface.getParent();
        framelayout.removeAllViews();
        framelayout.addView(playerSurface);
        setAsset(currentChannel, -1L, null);
    }

    private void setUpPlayer(MediaPlayer mediaplayer)
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
        }
        mediaPlayer = (VPMediaPlayer)mediaplayer;
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setClosedCaptionContainer(ccContainer);
        mediaPlayer.enableClosedCaptioning(disneyCaptionTrack.isSelected());
        if (closedCaptionOptions != null)
        {
            mediaPlayer.setCaptionStyle(closedCaptionOptions.toVPCaptionStyle());
        }
        status = PlayerStatus.PREPARED;
        updatePlayState(PlayerStatus.PREPARED);
        if (listener != null)
        {
            listener.onBufferComplete();
        }
        if (isRetryAttempting)
        {
            play();
        } else
        if (!playerSettings.isAutoplay())
        {
            status = PlayerStatus.PAUSED;
            updatePlayState(PlayerStatus.PAUSED);
            isRetryAttempting = true;
            return;
        }
    }

    private void updatePlayState(PlayerStatus playerstatus)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isRetryAttempting)
        {
            status = playerstatus;
            if (listener != null)
            {
                listener.playStateChanged(status);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        playerstatus;
        throw playerstatus;
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listener = abstractplayerplatformvideoeventlistener;
    }

    public void destroy()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.reset();
        }
        playerSettings.removeListener(this);
    }

    public BaseAdManager getAdManager()
    {
        return null;
    }

    public List getAvailableAudioLanguages()
    {
        return new ArrayList(0);
    }

    public List getAvailableBitrates()
    {
        return new ArrayList();
    }

    public List getAvailableClosedCaptionTracks()
    {
        return captioningTracks;
    }

    public List getAvailableProfiles()
    {
        return new ArrayList();
    }

    public String getChannelId(String s)
    {
        s = s.replace(" ", "").toLowerCase();
        currentChannel.setChannelName(s);
        return (String)disneyNetwordIdMap.get(s);
    }

    public boolean getClosedCaptionsStatus()
    {
        return true;
    }

    public PlayerAudioTrack getCurrentAudioTrack()
    {
        return null;
    }

    public int getCurrentBitrate()
    {
        return 0;
    }

    public Asset getCurrentChannel()
    {
        return currentChannel;
    }

    public PlayerClosedCaptionsTrack getCurrentClosedCaptionTrack()
    {
        return disneyCaptionTrack;
    }

    public float getCurrentPlaybackSpeed()
    {
        return 1.0F;
    }

    public long getCurrentPosition()
    {
        if (mediaPlayer != null)
        {
            return (long)mediaPlayer.getCurrentPosition();
        } else
        {
            return -1L;
        }
    }

    public Map getDisneyNetwordIdMap()
    {
        if (disneyNetwordIdMap == null)
        {
            disneyNetwordIdMap = new HashMap();
            disneyNetwordIdMap.put("disneychannel", "004");
            disneyNetwordIdMap.put("disneyjunior", "008");
            disneyNetwordIdMap.put("disneyxd", "009");
            disneyNetwordIdMap.put("abcfamily", "002");
        }
        return disneyNetwordIdMap;
    }

    public long getDuration()
    {
        return 0L;
    }

    public long getEndPosition()
    {
        if (mediaPlayer != null)
        {
            return (long)mediaPlayer.getDuration();
        } else
        {
            return -1L;
        }
    }

    public FragmentInfo getFragmentInfo()
    {
        return null;
    }

    public PlayerLogger getLogger()
    {
        return null;
    }

    public PlayerStatus getPlayerStatus()
    {
        return status;
    }

    public List getSupportedClosedCaptionsOptions()
    {
        return new ArrayList();
    }

    public List getSupportedPlaybackSpeeds()
    {
        return new ArrayList();
    }

    public PlayerTimeline getTimeline()
    {
        return null;
    }

    public String getVersion()
    {
        return null;
    }

    public long getVideoHeight()
    {
        if (mediaPlayer != null)
        {
            return (long)mediaPlayer.getVideoHeight();
        } else
        {
            return 0L;
        }
    }

    public StreamType getVideoType()
    {
        return StreamType.LINEAR;
    }

    public long getVideoWidth()
    {
        if (mediaPlayer != null)
        {
            return (long)mediaPlayer.getVideoWidth();
        } else
        {
            return 0L;
        }
    }

    public View getView()
    {
        return playerSurface;
    }

    public boolean hasCC()
    {
        return true;
    }

    public boolean hasDRM()
    {
        return true;
    }

    public void onAuthorizationFailure(VPMedia vpmedia, String s)
    {
        logger.error((new StringBuilder()).append("TeaTime-Disney Media Authorization failed with message: ").append(s).toString());
        if (listener != null)
        {
            listener.mediaFailed("40102", s);
        }
    }

    public void onAuthorizationSuccess(VPMedia vpmedia)
    {
        isDrmComplete = true;
        if (!isRetryAttempting && listener != null)
        {
            listener.drmComplete(currentChannel.getManifestUri(), null, null);
        }
    }

    public void onAuthorizationTokenRequest(final VPMedia mediaToAuthorize)
    {
        ThreadManager.getInstance().executeRunnable(new Runnable() {

            final DisneyPlayer this$0;
            final VPMedia val$mediaToAuthorize;

            public void run()
            {
                DisneyPlayer.logger.debug("TeaTime-Disney Player Auth Token request received");
                DisneyEspnTokenDelegate disneyespntokendelegate = currentChannel.getDisneyEspnTokenDelegate();
                if (currentChannel.getDrmKey() == null || disneyespntokendelegate != null && (isDrmComplete || isRetryAttempting))
                {
                    currentChannel.setDrmKey(disneyespntokendelegate.onTokenExpired(currentChannel.getChannelName(), currentChannel.getDrmKey()));
                }
                mediaToAuthorize.authorizeMediaWithAuthToken(new VPAuthToken() {

                    final _cls4 this$1;

            
            {
                this$1 = _cls4.this;
                super();
                _pcls4 = currentChannel.getDrmKey();
                HashMap hashmap = new HashMap();
                hashmap.put("token_type", "offsite.comcast");
                hashmap.put("token", _cls4.this);
                setTokenParameters(hashmap);
            }
                });
            }

            
            {
                this$0 = DisneyPlayer.this;
                mediaToAuthorize = vpmedia;
                super();
            }
        });
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        logger.error("TeaTime-media player error");
        if (isRetryAttempting) goto _L2; else goto _L1
_L1:
        status = PlayerStatus.PAUSED;
        retryAsset();
_L4:
        return false;
_L2:
        updatePlayState(PlayerStatus.ERROR);
        if (listener != null)
        {
            listener.mediaFailed(String.valueOf(i), "An error has occuring with playing this stream");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void pause()
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.pause();
        }
        updatePlayState(PlayerStatus.PAUSED);
    }

    public void play()
    {
        logger.debug("teatime-play()");
        if (status == PlayerStatus.PAUSED && !isRetryAttempting)
        {
            retryAsset();
            return;
        } else
        {
            isRetryAttempting = false;
            mediaPlayer.start();
            updatePlayState(PlayerStatus.PLAYING);
            return;
        }
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listener = null;
    }

    public void seekToLive()
    {
    }

    public void setAsset(Asset asset, long l, BaseAdManager baseadmanager)
    {
        isDrmComplete = false;
        currentChannel = asset;
        updatePlayState(PlayerStatus.INITIALIZING);
        refreshCaptionContainer();
        String s = currentChannel.getNetworkId();
        baseadmanager = s;
        if (!StringUtil.isNotNullOrEmpty(s))
        {
            baseadmanager = getChannelId(asset.getChannelName());
        }
        playerManager = VPPlayerManager.getPlayerManager(provider, baseadmanager);
        asset = getMediaFromCatalog();
        if (asset == null)
        {
            return;
        }
        try
        {
            playMedia(asset);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Asset asset)
        {
            logger.error(String.format("TeaTime-error: %s", new Object[] {
                asset.getMessage()
            }));
        }
        if (listener != null)
        {
            listener.mediaFailed(String.valueOf(asset.getErrorCode().getErrorCode()), String.valueOf(asset.getMessage()));
        }
        return;
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
label0:
        {
            disneyCaptionTrack.setIsSelected(flag);
            if (mediaPlayer != null)
            {
                mediaPlayer.enableClosedCaptioning(flag);
            }
            if (ccContainer != null)
            {
                if (!flag)
                {
                    break label0;
                }
                ccContainer.setVisibility(0);
            }
            return;
        }
        ccContainer.setVisibility(8);
    }

    public void setClosedCaptionsOptions()
    {
        if (mediaPlayer != null)
        {
            ClosedCaptionFormatBuilder closedcaptionformatbuilder = playerSettings.getCaptionFormat();
            mediaPlayer.setCaptionStyle(closedcaptionformatbuilder.toVPCaptionStyle());
        }
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
    }

    public void setLogger(LogFactory logfactory)
    {
    }

    public void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
    }

    public void setPosition(long l, boolean flag)
    {
    }

    public void setPositionRelative(long l)
    {
    }

    public void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack)
    {
    }

    public void setVolume(int i)
    {
    }

    public void settingUpdated(com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting setting)
    {
        static class _cls5
        {

            static final int $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[];

            static 
            {
                $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting = new int[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.values().length];
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTION_FORMAT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTIONS_ENABLED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.CAPTIONS_TRACK.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting[com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting.AUDIO_TRACK.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls5..SwitchMap.com.comcast.playerplatform.primetime.android.player.PlayerSettings.Setting[setting.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            setClosedCaptionsOptions();
            return;

        case 2: // '\002'
            setClosedCaptionsEnabled(playerSettings.getClosedCaptionsEnabled());
            return;

        case 3: // '\003'
            setClosedCaptionsTrack(playerSettings.getClosedCaptionsTrack());
            return;

        case 4: // '\004'
            setPreferredAudioLanguage(playerSettings.getPreferredAudioLanguage());
            break;
        }
    }

    public void stop()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.reset();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        logger.debug("TeaTime-Surface Changed");
        if (mediaPlayer != null)
        {
            mediaPlayer.setDisplay(surfaceholder);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        logger.debug("TeaTime- Surface Created");
        if (mediaPlayer != null)
        {
            mediaPlayer.setDisplay(surfaceholder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        logger.debug("TeaTime-Surface Destroyed");
    }







/*
    static boolean access$1102(DisneyPlayer disneyplayer, boolean flag)
    {
        disneyplayer.isRetryAttempting = flag;
        return flag;
    }

*/










/*
    static PlayerStatus access$902(DisneyPlayer disneyplayer, PlayerStatus playerstatus)
    {
        disneyplayer.status = playerstatus;
        return playerstatus;
    }

*/
}
