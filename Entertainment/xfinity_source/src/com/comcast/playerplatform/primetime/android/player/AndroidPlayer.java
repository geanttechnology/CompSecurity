// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import com.adobe.ave.MediaErrorCode;
import com.adobe.mediacore.MediaPlayerItem;
import com.comcast.playerplatform.primetime.android.ads.managers.BaseAdManager;
import com.comcast.playerplatform.primetime.android.asset.Asset;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.events.AbstractPlayerPlatformVideoEventListener;
import com.comcast.playerplatform.primetime.android.primetime.PlayerAudioTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerClosedCaptionsTrack;
import com.comcast.playerplatform.primetime.android.primetime.PlayerTimeline;
import com.comcast.playerplatform.primetime.android.util.FragmentInfo;
import com.comcast.playerplatform.primetime.android.util.LogFactory;
import com.comcast.playerplatform.primetime.android.util.PlayerLogger;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.primetime.android.player:
//            Player

public class AndroidPlayer
    implements android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener, Player
{

    private Context appContext;
    private Asset currentChannel;
    private AbstractPlayerPlatformVideoEventListener listener;
    private SurfaceView playerSurface;
    private MediaPlayer primeTimePlayer;
    private PlayerStatus status;

    public AndroidPlayer(Context context)
    {
        status = PlayerStatus.IDLE;
        primeTimePlayer = new MediaPlayer();
        playerSurface = new SurfaceView(context);
        appContext = context;
        primeTimePlayer.setOnErrorListener(this);
        primeTimePlayer.setOnPreparedListener(this);
        primeTimePlayer.setScreenOnWhilePlaying(true);
        primeTimePlayer.setOnBufferingUpdateListener(new android.media.MediaPlayer.OnBufferingUpdateListener() {

            final AndroidPlayer this$0;

            public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
            {
            }

            
            {
                this$0 = AndroidPlayer.this;
                super();
            }
        });
    }

    private void notifyPlayStateChange()
    {
        this;
        JVM INSTR monitorenter ;
        if (listener != null)
        {
            listener.playStateChanged(status);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void sendMediaOpened()
    {
        if (listener != null)
        {
            listener.mediaOpened("HLS", "Live", null, getAvailableAudioLanguages(), getAvailableClosedCaptionTracks(), getVideoWidth(), getVideoHeight(), getDuration(), 0.0D, false);
        }
    }

    public void addEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listener = abstractplayerplatformvideoeventlistener;
    }

    public void destroy()
    {
        primeTimePlayer.reset();
        primeTimePlayer.release();
    }

    public BaseAdManager getAdManager()
    {
        return null;
    }

    public List getAvailableAudioLanguages()
    {
        return new ArrayList();
    }

    public List getAvailableBitrates()
    {
        return null;
    }

    public List getAvailableClosedCaptionTracks()
    {
        return new ArrayList();
    }

    public List getAvailableProfiles()
    {
        return null;
    }

    public boolean getClosedCaptionsStatus()
    {
        return false;
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
        return null;
    }

    public float getCurrentPlaybackSpeed()
    {
        return 0.0F;
    }

    public long getCurrentPosition()
    {
        return 0L;
    }

    public long getDuration()
    {
        return 0L;
    }

    public long getEndPosition()
    {
        return 0L;
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
        return null;
    }

    public List getSupportedPlaybackSpeeds()
    {
        return null;
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
        return (long)primeTimePlayer.getVideoHeight();
    }

    public StreamType getVideoType()
    {
        return StreamType.LINEAR;
    }

    public long getVideoWidth()
    {
        return (long)primeTimePlayer.getVideoWidth();
    }

    public View getView()
    {
        return playerSurface;
    }

    public boolean hasCC()
    {
        return false;
    }

    public boolean hasDRM()
    {
        return false;
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (listener != null)
        {
            listener.mediaFailed(String.valueOf(i), String.valueOf(j));
        }
        status = PlayerStatus.ERROR;
        notifyPlayStateChange();
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        status = PlayerStatus.PREPARED;
        notifyPlayStateChange();
        sendMediaOpened();
        status = PlayerStatus.PAUSED;
        notifyPlayStateChange();
        primeTimePlayer.setDisplay(playerSurface.getHolder());
        mediaplayer.start();
        if (!primeTimePlayer.isPlaying()) goto _L2; else goto _L1
_L1:
        status = PlayerStatus.PLAYING;
        notifyPlayStateChange();
_L4:
        notifyPlayStateChange();
        return;
_L2:
        if (false)
        {
            status = PlayerStatus.PLAYING;
            notifyPlayStateChange();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void pause()
    {
        primeTimePlayer.pause();
    }

    public void play()
    {
        primeTimePlayer.start();
    }

    public void removeEventListener(AbstractPlayerPlatformVideoEventListener abstractplayerplatformvideoeventlistener)
    {
        listener = null;
    }

    public void seekToLive()
    {
    }

    public void setAsset(final Asset asset, long l, BaseAdManager baseadmanager)
    {
        currentChannel = asset;
        try
        {
            new com.adobe.mediacore.MediaPlayerItemLoader.LoaderListener() {

                final AndroidPlayer this$0;

                public void onError(MediaErrorCode mediaerrorcode, String s)
                {
                    Log.i("yourface", "uhoh something went wrong");
                }

                public void onLoadComplete(MediaPlayerItem mediaplayeritem)
                {
                    Log.i("yourface", "yaya");
                }

            
            {
                this$0 = AndroidPlayer.this;
                super();
            }
            };
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final AndroidPlayer this$0;
                final Asset val$asset;

                public void run()
                {
                    try
                    {
                        status = PlayerStatus.INITIALIZING;
                        notifyPlayStateChange();
                        HashMap hashmap = new HashMap();
                        hashmap.put("Cookie", (new StringBuilder()).append(asset.authCookieName).append(" = ").append(asset.authCookieValue).toString());
                        primeTimePlayer.setDataSource(appContext, Uri.parse(asset.getManifestUri()), hashmap);
                        status = PlayerStatus.INITIALIZED;
                        notifyPlayStateChange();
                        primeTimePlayer.prepareAsync();
                        status = PlayerStatus.PREPARING;
                        notifyPlayStateChange();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                }

            
            {
                this$0 = AndroidPlayer.this;
                asset = asset1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (final Asset asset)
        {
            asset.printStackTrace();
        }
    }

    public void setClosedCaptionsEnabled(boolean flag)
    {
        primeTimePlayer.selectTrack(0);
    }

    public void setClosedCaptionsTrack(PlayerClosedCaptionsTrack playerclosedcaptionstrack)
    {
        android.media.MediaPlayer.TrackInfo atrackinfo[] = primeTimePlayer.getTrackInfo();
        int j = atrackinfo.length;
        for (int i = 0; i < j; i++)
        {
            if (!atrackinfo[i].getLanguage().equals(playerclosedcaptionstrack.getName()));
        }

    }

    public void setLogger(LogFactory logfactory)
    {
    }

    public void setLoggingVerbosity(com.adobe.mediacore.logging.Logger.Verbosity verbosity)
    {
    }

    public void setPosition(long l, boolean flag)
    {
        primeTimePlayer.seekTo((int)l);
    }

    public void setPositionRelative(long l)
    {
        primeTimePlayer.seekTo(primeTimePlayer.getCurrentPosition() + (int)l);
    }

    public void setPreferredAudioLanguage(PlayerAudioTrack playeraudiotrack)
    {
    }

    public void setVolume(int i)
    {
    }

    public void stop()
    {
        primeTimePlayer.reset();
    }


/*
    static PlayerStatus access$002(AndroidPlayer androidplayer, PlayerStatus playerstatus)
    {
        androidplayer.status = playerstatus;
        return playerstatus;
    }

*/



}
