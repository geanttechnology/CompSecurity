// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import android.content.Context;
import com.google.a.d.e;
import com.rdio.android.api.models.Ad;
import com.rdio.android.core.events.ads.AdBreakCompletedEvent;
import com.rdio.android.core.events.ads.AdCompletedEvent;
import com.rdio.android.core.events.ads.AdPlayerCommandEvent;
import com.rdio.android.core.events.ads.AdPlayerPositionUpdateEvent;
import com.rdio.android.core.events.ads.AdPlayerStateChanged;
import com.rdio.android.core.events.ads.BeginAdBreakEvent;
import com.rdio.android.core.events.ads.CurrentAdChangedEvent;
import com.rdio.android.core.events.ads.HasPendingAdEvent;
import com.rdio.android.core.events.playback.commands.PlaybackCommand;
import com.rdio.android.core.media.SimpleUriAudioPlayer;
import com.rdio.android.core.util.Logging;
import java.util.ArrayList;
import java.util.List;

public class AdPlayerManager
{

    private static final String TAG = "AdPlayerManager";
    private final SimpleUriAudioPlayer audioPlayer;
    private final com.rdio.android.core.media.SimpleUriAudioPlayer.Listener audioPlayerListener = new com.rdio.android.core.media.SimpleUriAudioPlayer.Listener() {

        final AdPlayerManager this$0;

        public void onError()
        {
            handleAdCompletion(true);
        }

        public void onPlaybackComplete()
        {
            handleAdCompletion(false);
        }

        public void onPlayingChanged(boolean flag)
        {
            eventBus.post(new AdPlayerStateChanged(flag));
        }

        public void onPositionChanged()
        {
            eventBus.post(new AdPlayerPositionUpdateEvent(audioPlayer.getPosition(), audioPlayer.getDuration()));
        }

            
            {
                this$0 = AdPlayerManager.this;
                super();
            }
    };
    private final e eventBus;
    private final Logging logging;
    private List pendingAds;

    private AdPlayerManager(Context context, e e1, Logging logging1)
    {
        eventBus = e1;
        logging = logging1;
        audioPlayer = new SimpleUriAudioPlayer(context, logging1);
        audioPlayer.setListener(audioPlayerListener);
    }

    private void handleAdCompletion(boolean flag)
    {
        logging.log(4, "AdPlayerManager", (new StringBuilder("Ad completed hadError: ")).append(flag).toString());
        e e1 = eventBus;
        Ad ad = (Ad)pendingAds.get(0);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e1.post(new AdCompletedEvent(ad, flag, false, false));
        pendingAds.remove(0);
        if (pendingAds.isEmpty())
        {
            logging.log(4, "AdPlayerManager", "No more ads, ad break complete");
            eventBus.post(new AdBreakCompletedEvent());
            return;
        } else
        {
            playPendingAd();
            return;
        }
    }

    public static AdPlayerManager newInstance(Context context, e e1, Logging logging1)
    {
        context = new AdPlayerManager(context, e1, logging1);
        e1.register(context);
        return context;
    }

    private void playPendingAd()
    {
        if (pendingAds == null || pendingAds.isEmpty())
        {
            logging.log(4, "AdPlayerManager", "No ads to play");
            eventBus.post(new AdBreakCompletedEvent());
            return;
        }
        if (audioPlayer.isPlaying())
        {
            logging.log(4, "AdPlayerManager", "Already playing an ad");
            return;
        } else
        {
            logging.log(4, "AdPlayerManager", (new StringBuilder("Playing ad: ")).append(((Ad)pendingAds.get(0)).key).toString());
            audioPlayer.playUri(((Ad)pendingAds.get(0)).surl);
            eventBus.post(new CurrentAdChangedEvent((Ad)pendingAds.get(0)));
            return;
        }
    }

    public void onAdPlayerCommand(AdPlayerCommandEvent adplayercommandevent)
    {
        logging.log(4, "AdPlayerManager", (new StringBuilder("Received ad player command event: ")).append(adplayercommandevent.getCommand()).toString());
        if (adplayercommandevent.getCommand() == PlaybackCommand.Play)
        {
            audioPlayer.play();
            return;
        } else
        {
            audioPlayer.pause();
            return;
        }
    }

    public void onBeginAdBreak(BeginAdBreakEvent beginadbreakevent)
    {
        logging.log(4, "AdPlayerManager", "Beginning ad break");
        playPendingAd();
    }

    public void onHasPendingAd(HasPendingAdEvent haspendingadevent)
    {
        if (pendingAds == null)
        {
            pendingAds = new ArrayList();
        }
        logging.log(4, "AdPlayerManager", (new StringBuilder("Received pending ad: ")).append(haspendingadevent.getAd().key).toString());
        pendingAds.add(haspendingadevent.getAd());
    }



}
