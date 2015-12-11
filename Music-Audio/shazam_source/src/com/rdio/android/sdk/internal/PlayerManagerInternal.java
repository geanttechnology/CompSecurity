// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.a.d.e;
import com.rdio.android.audioplayer.RdioAudioPlayer;
import com.rdio.android.audioplayer.RdioNativePlayer;
import com.rdio.android.audioplayer.interfaces.AudioError;
import com.rdio.android.audioplayer.interfaces.AudioInfo;
import com.rdio.android.audioplayer.interfaces.AudioPlayerListener;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.core.events.playback.LoadTrackKeyForPlaybackEvent;
import com.rdio.android.core.events.playback.PlaybackCompletedEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventInfo;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.core.events.playback.commands.LocalLoadSequenceEvent;
import com.rdio.android.core.events.playback.commands.LocalPlaybackCommandEvent;
import com.rdio.android.core.events.playback.commands.LocalQueueCommandEvent;
import com.rdio.android.core.events.playback.commands.PlaybackCommand;
import com.rdio.android.core.events.playback.commands.QueueCommand;
import com.rdio.android.core.managers.PlaybackSequenceManager;
import com.rdio.android.core.sequencing.ProxySequencerUnit;
import com.rdio.android.sdk.PlayRequest;
import com.rdio.android.sdk.PlayerListener;
import com.rdio.android.sdk.PlayerManager;
import com.rdio.android.sdk.RdioListener;
import com.rdio.android.sdk.RdioResponseListener;
import com.rdio.android.sdk.model.Track;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.rdio.android.sdk.internal:
//            PlaybackStateChangedEvent, PlayTrackKeyEvent, OnlineMediaSource

public class PlayerManagerInternal
    implements PlayerManager
{

    private final int DEFAULT_STREAM_BUFFER_SIZE = 0x100000;
    private Context context;
    private int currentInitialPositionMSec;
    private OnlineMediaSource currentMediaSource;
    private String currentParentKey;
    private PlayRequest currentPlayRequest;
    private AudioPlayerListener currentPlayerListener;
    private PlaybackStateChangedEvent.State currentState;
    private Track currentTrack;
    private String currentTrackKey;
    private e eventBus;
    private boolean isWaitingForResetToSetDataSource;
    private RdioListener listener;
    private Handler mHandler;
    private String playbackToken;
    private RdioAudioPlayer player;
    private List playerListeners;
    private String playerName;
    private RdioService_Api rdioService;
    private PlaybackSequenceManager sequenceManager;

    public PlayerManagerInternal(Context context1, String s, RdioService_Api rdioservice_api, e e1, RdioListener rdiolistener, Handler handler)
    {
        playbackToken = null;
        playerListeners = new ArrayList();
        currentPlayerListener = new AudioPlayerListener() {

            final PlayerManagerInternal this$0;

            public void onComplete()
            {
                player.release();
                ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
                reportplaybackeventinfo.trackKey = currentTrackKey;
                eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackEnded, reportplaybackeventinfo));
                updateCurrentState(PlaybackStateChangedEvent.State.Stopped);
                PlayerListener playerlistener;
                for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(playerlistener. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onComplete();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                {
                    playerlistener = (PlayerListener)iterator.next();
                }

                eventBus.post(new PlaybackCompletedEvent());
            }

            public void onError(AudioError audioerror)
            {
                Log.e("rdio", (new StringBuilder("AudioError encountered : ")).append(audioerror).append(" : ").append(audioerror.getDescription()).toString());
                stop(false);
                updateCurrentState(PlaybackStateChangedEvent.State.Error);
                final PlayerListener listener;
                for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(audioerror. new Runnable() {

            final _cls2 this$1;
            final AudioError val$error;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onError(error);
            }

            
            {
                this$1 = final__pcls2;
                listener = playerlistener;
                error = AudioError.this;
                super();
            }
        }))
                {
                    listener = (PlayerListener)iterator.next();
                }

            }

            public void onInfo(AudioInfo audioinfo)
            {
                if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.BufferingEnd)
                {
                    PlayerListener playerlistener;
                    for (audioinfo = playerListeners.iterator(); audioinfo.hasNext(); mHandler.post(playerlistener. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onBufferingEnded();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                    {
                        playerlistener = (PlayerListener)audioinfo.next();
                    }

                } else
                if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.BufferingStart)
                {
                    PlayerListener playerlistener1;
                    for (audioinfo = playerListeners.iterator(); audioinfo.hasNext(); mHandler.post(playerlistener1. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onBufferingStarted();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                    {
                        playerlistener1 = (PlayerListener)audioinfo.next();
                    }

                } else
                if (audioinfo.getDetail() == com.rdio.android.audioplayer.interfaces.AudioInfo.AudioInfoDetail.AudioStart && currentInitialPositionMSec > 0)
                {
                    seekTo(currentInitialPositionMSec);
                }
            }

            public void onPrepared()
            {
                ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
                currentTrack = currentMediaSource.getTrack();
                reportplaybackeventinfo.trackKey = currentTrackKey;
                reportplaybackeventinfo.parentKey = currentParentKey;
                eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackStarted, reportplaybackeventinfo));
                play();
                PlayerListener playerlistener;
                for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(playerlistener. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onPrepared();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                {
                    playerlistener = (PlayerListener)iterator.next();
                }

            }

            public void onResetComplete()
            {
                if (isWaitingForResetToSetDataSource)
                {
                    isWaitingForResetToSetDataSource = false;
                    onPlayAudio(new PlayTrackKeyEvent(currentTrackKey, currentParentKey, true, currentInitialPositionMSec));
                    return;
                } else
                {
                    updateCurrentState(PlaybackStateChangedEvent.State.Stopped);
                    return;
                }
            }

            public void onSeekCompleted()
            {
                PlayerListener playerlistener;
                for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(playerlistener. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onSeekCompleted();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                {
                    playerlistener = (PlayerListener)iterator.next();
                }

            }

            public void onSeekStarted()
            {
                PlayerListener playerlistener;
                for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(playerlistener. new Runnable() {

            final _cls2 this$1;
            final PlayerListener val$listener;

            public void run()
            {
                listener.onSeekStarted();
            }

            
            {
                this$1 = final__pcls2;
                listener = PlayerListener.this;
                super();
            }
        }))
                {
                    playerlistener = (PlayerListener)iterator.next();
                }

            }

            
            {
                this$0 = PlayerManagerInternal.this;
                super();
            }
        };
        context = context1;
        player = new RdioNativePlayer(context1);
        eventBus = e1;
        rdioService = rdioservice_api;
        listener = rdiolistener;
        playerName = s;
        mHandler = handler;
        player.setAudioPlayerListener(currentPlayerListener);
        updateCurrentState(PlaybackStateChangedEvent.State.None);
    }

    private void resetPlayer()
    {
        if (player.isReset() || player.isResetting())
        {
            break MISSING_BLOCK_LABEL_120;
        }
        boolean flag;
        if (player.getState() == com.rdio.android.audioplayer.interfaces.AudioPlayer.AudioPlayerState.Error || player.isPreparing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            player.reset();
        }
        if (!flag && (player.isReset() || player.isResetting()))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        player.release();
        player = new RdioNativePlayer(context);
        player.setAudioPlayerListener(currentPlayerListener);
        updateCurrentState(PlaybackStateChangedEvent.State.None);
        return;
        IOException ioexception;
        ioexception;
    }

    public void addPlayerListener(PlayerListener playerlistener)
    {
        playerListeners.add(playerlistener);
    }

    protected void cleanUp()
    {
        if (currentState == PlaybackStateChangedEvent.State.Playing || currentState == PlaybackStateChangedEvent.State.Paused)
        {
            stop();
        }
        playerListeners.clear();
        playerListeners = null;
        currentPlayerListener = null;
        sequenceManager = null;
        rdioService = null;
        eventBus = null;
        listener = null;
    }

    public void enqueue(String s)
    {
        s = new QueueCommand(com.rdio.android.core.events.playback.commands.QueueCommand.Operation.Add, s);
        eventBus.post(new LocalQueueCommandEvent(s, com/rdio/android/core/sequencing/ProxySequencerUnit));
    }

    protected RdioResponseListener extractTrackFromSourceGet(final PlayRequest request)
    {
        return new RdioResponseListener() {

            final PlayerManagerInternal this$0;
            final PlayRequest val$request;

            public void onResponse(RdioApiResponse rdioapiresponse)
            {
                if (!rdioapiresponse.isSuccess())
                {
                    postOnError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("Unable to look up source ")).append(request.sourceKey).toString());
                    updateCurrentState(PlaybackStateChangedEvent.State.Error);
                }
                rdioapiresponse = (JSONObject)rdioapiresponse.getResult();
                try
                {
                    if (!rdioapiresponse.has(request.sourceKey) || !rdioapiresponse.getJSONObject(request.sourceKey).has("trackKeys"))
                    {
                        postOnError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("Unable parse source ")).append(request.sourceKey).append(" when trying to play.").toString());
                        updateCurrentState(PlaybackStateChangedEvent.State.Error);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (RdioApiResponse rdioapiresponse)
                {
                    postOnError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("Unable parse source ")).append(request.sourceKey).append(" to extract track information.").toString());
                    updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    return;
                }
                rdioapiresponse = rdioapiresponse.getJSONObject(request.sourceKey).getJSONArray("trackKeys");
                if (rdioapiresponse.length() < request.sourceIndex)
                {
                    postOnError(com.rdio.android.sdk.Rdio.RdioError.TRACK_LOOKUP, (new StringBuilder("Source index ")).append(request.sourceIndex).append(" is invalid for source ").append(request.sourceKey).toString());
                    updateCurrentState(PlaybackStateChangedEvent.State.Error);
                    return;
                }
                rdioapiresponse = (String)rdioapiresponse.get(request.sourceIndex);
                onPlayAudio(new PlayTrackKeyEvent(rdioapiresponse, request.sourceKey, true, request.initialPositionMSec));
                return;
            }

            
            {
                this$0 = PlayerManagerInternal.this;
                request = playrequest;
                super();
            }
        };
    }

    public int getCurrentDuration()
    {
        if (player.isPrepared())
        {
            return player.getDuration();
        } else
        {
            return 0;
        }
    }

    public int getCurrentPosition()
    {
        if (player.isPrepared())
        {
            return player.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public Track getCurrentTrack()
    {
        return currentTrack;
    }

    public com.rdio.android.sdk.PlayerListener.PlayState getState()
    {
        return PlaybackStateChangedEvent.translateState(currentState);
    }

    public boolean isPlaying()
    {
        return player.isPlaying();
    }

    public void onLoadTrackKeyForPlayback(LoadTrackKeyForPlaybackEvent loadtrackkeyforplaybackevent)
    {
        PlayTrackKeyEvent playtrackkeyevent = new PlayTrackKeyEvent(loadtrackkeyforplaybackevent.getTrackKey(), loadtrackkeyforplaybackevent.getParentKey(), false, 0);
        if (currentPlayRequest != null)
        {
            playtrackkeyevent = new PlayTrackKeyEvent(loadtrackkeyforplaybackevent.getTrackKey(), loadtrackkeyforplaybackevent.getParentKey(), true, currentPlayRequest.initialPositionMSec);
            currentPlayRequest = null;
        }
        onPlayAudio(playtrackkeyevent);
    }

    protected void onPlayAudio(PlayTrackKeyEvent playtrackkeyevent)
    {
        currentTrack = null;
        currentTrackKey = playtrackkeyevent.trackKey;
        currentParentKey = playtrackkeyevent.parentKey;
        currentInitialPositionMSec = playtrackkeyevent.timeOffset;
        resetPlayer();
        if (currentMediaSource != null)
        {
            currentMediaSource.destroy();
        }
        com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfoRequestArgs playbackinforequestargs = new com.rdio.android.audioplayer.sources.RdioMediaSource.PlaybackInfoRequestArgs();
        playbackinforequestargs.manualPlay = true;
        playbackinforequestargs.streamQuality = "aac-low,mp3-low";
        playbackinforequestargs.trackKey = playtrackkeyevent.trackKey;
        playbackinforequestargs.parentKey = playtrackkeyevent.parentKey;
        playbackinforequestargs.playerName = playerName;
        ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
        reportplaybackeventinfo.trackKey = playtrackkeyevent.trackKey;
        reportplaybackeventinfo.parentKey = playtrackkeyevent.parentKey;
        reportplaybackeventinfo.streamType = playbackinforequestargs.streamQuality;
        try
        {
            updateCurrentState(PlaybackStateChangedEvent.State.Loading);
            currentMediaSource = new OnlineMediaSource(rdioService, listener, this, playbackinforequestargs, playbackToken, 0x100000);
        }
        // Misplaced declaration of an exception variable
        catch (PlayTrackKeyEvent playtrackkeyevent) { }
        if (player.isResetting())
        {
            isWaitingForResetToSetDataSource = true;
            return;
        }
        try
        {
            isWaitingForResetToSetDataSource = false;
            player.setDataSource(currentMediaSource, com.rdio.android.audioplayer.extractors.MediaTypeUtil.MediaType.Unknown, 0);
            player.prepareAsync();
            playtrackkeyevent = new ReportPlaybackEvent(ReportPlaybackEventType.TrackLoading, reportplaybackeventinfo);
            eventBus.post(playtrackkeyevent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PlayTrackKeyEvent playtrackkeyevent)
        {
            updateCurrentState(PlaybackStateChangedEvent.State.Error);
        }
        return;
    }

    public void pause()
    {
        if (!isPlaying())
        {
            return;
        } else
        {
            player.pause();
            updateCurrentState(PlaybackStateChangedEvent.State.Paused);
            ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
            reportplaybackeventinfo.position = getCurrentPosition();
            reportplaybackeventinfo.trackKey = currentTrackKey;
            eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackPaused, reportplaybackeventinfo));
            return;
        }
    }

    public void play()
    {
        if (isPlaying())
        {
            return;
        }
        try
        {
            player.start();
            if (currentState == PlaybackStateChangedEvent.State.Paused)
            {
                ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
                reportplaybackeventinfo.position = getCurrentPosition();
                reportplaybackeventinfo.trackKey = currentTrackKey;
                eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackResumed, reportplaybackeventinfo));
            }
            updateCurrentState(PlaybackStateChangedEvent.State.Playing);
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public void play(PlayRequest playrequest)
    {
        currentPlayRequest = playrequest;
        eventBus.post(new LocalLoadSequenceEvent(playrequest.sourceKey, playrequest.sourceIndex, com/rdio/android/core/sequencing/ProxySequencerUnit));
    }

    public void postOnError(final com.rdio.android.sdk.Rdio.RdioError error, final String msg)
    {
        mHandler.post(new Runnable() {

            final PlayerManagerInternal this$0;
            final com.rdio.android.sdk.Rdio.RdioError val$error;
            final String val$msg;

            public void run()
            {
                listener.onError(error, msg);
            }

            
            {
                this$0 = PlayerManagerInternal.this;
                error = rdioerror;
                msg = s;
                super();
            }
        });
    }

    public void seekTo(int i)
    {
        if (i >= player.getDuration())
        {
            player.release();
            ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
            reportplaybackeventinfo.position = getCurrentPosition();
            reportplaybackeventinfo.trackKey = currentTrackKey;
            eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackSkipped, reportplaybackeventinfo));
            updateCurrentState(PlaybackStateChangedEvent.State.Stopped);
            return;
        } else
        {
            player.seekTo(i);
            ReportPlaybackEventInfo reportplaybackeventinfo1 = new ReportPlaybackEventInfo();
            reportplaybackeventinfo1.position = getCurrentPosition();
            reportplaybackeventinfo1.seekToPosition = i;
            reportplaybackeventinfo1.trackKey = currentTrackKey;
            eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackSeek, reportplaybackeventinfo1));
            play();
            return;
        }
    }

    public void setPlaybackToken(String s)
    {
        playbackToken = s;
    }

    public void skipNext()
    {
        stop(true);
        eventBus.post(new LocalPlaybackCommandEvent(PlaybackCommand.SkipNext));
    }

    public void skipPrev()
    {
        stop(true);
        eventBus.post(new LocalPlaybackCommandEvent(PlaybackCommand.SkipPrev));
    }

    public void stop()
    {
        stop(true);
    }

    protected void stop(boolean flag)
    {
        if (flag)
        {
            updateCurrentState(PlaybackStateChangedEvent.State.Stopped);
            ReportPlaybackEventInfo reportplaybackeventinfo = new ReportPlaybackEventInfo();
            reportplaybackeventinfo.trackKey = currentTrackKey;
            reportplaybackeventinfo.position = getCurrentPosition();
            eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.TrackSkipped, reportplaybackeventinfo));
        }
        player.release();
    }

    protected void updateCurrentState(final PlaybackStateChangedEvent.State state)
    {
        if (currentState != state)
        {
            currentState = state;
            eventBus.post(new PlaybackStateChangedEvent(state));
            Iterator iterator = playerListeners.iterator();
            while (iterator.hasNext()) 
            {
                final PlayerListener listener = (PlayerListener)iterator.next();
                mHandler.post(new Runnable() {

                    final PlayerManagerInternal this$0;
                    final PlayerListener val$listener;
                    final PlaybackStateChangedEvent.State val$state;

                    public void run()
                    {
                        listener.onPlayStateChanged(PlaybackStateChangedEvent.translateState(state));
                    }

            
            {
                this$0 = PlayerManagerInternal.this;
                listener = playerlistener;
                state = state1;
                super();
            }
                });
            }
        }
    }

    protected void updateListenersPosition(final int mSec)
    {
        final PlayerListener listener;
        for (Iterator iterator = playerListeners.iterator(); iterator.hasNext(); mHandler.post(new Runnable() {

        final PlayerManagerInternal this$0;
        final PlayerListener val$listener;
        final int val$mSec;

        public void run()
        {
            listener.onPositionUpdate(mSec);
        }

            
            {
                this$0 = PlayerManagerInternal.this;
                listener = playerlistener;
                mSec = i;
                super();
            }
    }))
        {
            listener = (PlayerListener)iterator.next();
        }

    }









/*
    static boolean access$502(PlayerManagerInternal playermanagerinternal, boolean flag)
    {
        playermanagerinternal.isWaitingForResetToSetDataSource = flag;
        return flag;
    }

*/




/*
    static Track access$802(PlayerManagerInternal playermanagerinternal, Track track)
    {
        playermanagerinternal.currentTrack = track;
        return track;
    }

*/

}
