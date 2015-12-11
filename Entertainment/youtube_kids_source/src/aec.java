// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.VideoView;

public final class aec
    implements aea
{

    private final adw controlsOverlay;
    private final rx playbackService;
    private aef state;
    private final VideoView videoView;
    private final aeg videoViewProgressRequester = new aeg(this, null);

    public aec(adw adw1, VideoView videoview, rx rx1)
    {
        controlsOverlay = adw1;
        videoView = videoview;
        playbackService = rx1;
        state = aef.INIT;
        videoview.setOnPreparedListener(new aed(this));
        videoview.setOnCompletionListener(new aee(this));
        adw1.setListener(this);
        adw1.showReplay(false);
    }

    private void handleCompletionEvent()
    {
        controlsOverlay.setControlsState(cuv.g);
        controlsOverlay.showReplay(true);
        videoViewProgressRequester.onVideoEnded();
        if (playbackService != null)
        {
            playbackService.i();
        }
    }

    private void transitionToPause()
    {
        state = aef.PLAYBACK_LOADED;
        videoView.pause();
        controlsOverlay.setControlsState(cuv.c);
    }

    private void transitionToPlay()
    {
        if (state.isCurrentOrPast(aef.VIDEO_VIEW_PREPARED))
        {
            state = aef.PLAYING;
            videoView.start();
            videoViewProgressRequester.startRequesting();
            controlsOverlay.setControlsState(cuv.b);
            controlsOverlay.showReplay(false);
            return;
        } else
        {
            state = aef.PLAY_PENDING;
            return;
        }
    }

    public final void changeRecording(aei aei1)
    {
        state = aef.INIT;
        videoView.stopPlayback();
        videoViewProgressRequester.stopRequesting();
        controlsOverlay.setControlsState(cuv.d);
        videoView.setVideoPath(aei1.getRecordingPath());
        onReplay();
    }

    public final void handleVideoStageEvent(ctd ctd1)
    {
        adw adw1 = controlsOverlay;
        boolean flag;
        if (ctd1.b == ctt.j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        adw1.showReplay(flag);
        ctd1 = ctd1.b;
        if (ctd1.a(ctt.b))
        {
            state = aef.max(state, aef.PLAYBACK_LOADED);
        }
        if (ctd1 == ctt.a)
        {
            controlsOverlay.setControlsState(cuv.a);
        } else
        {
            if (!state.isCurrentOrPast(aef.PLAYBACK_LOADED) || ctd1.b())
            {
                controlsOverlay.setControlsState(cuv.d);
                return;
            }
            if (ctd1 == ctt.g)
            {
                controlsOverlay.setControlsState(cuv.c);
                return;
            }
            if (ctd1 == ctt.j)
            {
                handleCompletionEvent();
                return;
            }
        }
    }

    public final void handleYouTubePlayerStateEvent(ctf ctf1)
    {
        if (state.isCurrentOrPast(aef.PLAYBACK_LOADED))
        {
            adw adw1;
            switch (ctf1.a)
            {
            default:
                return;

            case 0: // '\0'
            case 5: // '\005'
                transitionToPause();
                controlsOverlay.setControlsState(cuv.d);
                return;

            case 6: // '\006'
                adw1 = controlsOverlay;
                break;
            }
            cuv cuv1;
            if (ctf1.b)
            {
                cuv1 = cuv.b;
            } else
            {
                cuv1 = cuv.c;
            }
            adw1.setControlsState(cuv1);
            if (ctf1.b)
            {
                transitionToPlay();
                return;
            }
        }
    }

    public final void onDestroy()
    {
        videoViewProgressRequester.stopRequesting();
    }

    public final void onPause()
    {
        if (playbackService != null)
        {
            playbackService.i();
        }
        transitionToPause();
    }

    public final void onPlay()
    {
        if (playbackService != null)
        {
            playbackService.g();
        }
        transitionToPlay();
    }

    public final void onReplay()
    {
        controlsOverlay.showReplay(false);
        controlsOverlay.resetTime();
        if (playbackService != null)
        {
            playbackService.i();
            playbackService.a(0);
            playbackService.g();
        }
        transitionToPlay();
    }

    public final void onSeekTo(int i)
    {
        videoView.seekTo(i);
        controlsOverlay.showReplay(false);
        if (playbackService != null)
        {
            playbackService.a(i);
        }
    }

    public final void startRecordingPlayback()
    {
        if (playbackService == null)
        {
            transitionToPlay();
        }
    }



/*
    static aef access$102(aec aec1, aef aef1)
    {
        aec1.state = aef1;
        return aef1;
    }

*/




}
