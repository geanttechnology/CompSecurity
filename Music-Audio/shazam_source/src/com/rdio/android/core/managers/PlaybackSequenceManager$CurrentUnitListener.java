// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.d.e;
import com.rdio.android.core.events.playback.LoadTrackKeyForPlaybackEvent;
import com.rdio.android.core.events.playback.LoadTrackKeyForPreBufferingEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceAbsoluteEndEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceEndedEvent;
import com.rdio.android.core.events.playback.PlaybackSequencePositionChangedEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceUpdatedEvent;
import com.rdio.android.core.sequencing.SequencerUnit;
import java.util.List;

// Referenced classes of package com.rdio.android.core.managers:
//            PlaybackSequenceManager

public class this._cls0
    implements com.rdio.android.core.sequencing.is._cls0
{

    public boolean startPlayback;
    final PlaybackSequenceManager this$0;

    private void postSequencePositionChangedEvent(SequencerUnit sequencerunit)
    {
        sequencerunit = new PlaybackSequencePositionChangedEvent(sequencerunit.getCurrentPosition());
        eventBus.post(sequencerunit);
    }

    public void onError(com.rdio.android.core.sequencing.nit> nit>)
    {
    }

    public void onInitialTrackKeyReady(String s, SequencerUnit sequencerunit)
    {
        s = new LoadTrackKeyForPlaybackEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition(), startPlayback);
        eventBus.post(s);
        PlaybackSequenceManager.access$000(PlaybackSequenceManager.this);
    }

    public void onJumpComplete(String s, SequencerUnit sequencerunit)
    {
        s = new LoadTrackKeyForPlaybackEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition(), true);
        eventBus.post(s);
        postSequencePositionChangedEvent(sequencerunit);
    }

    public void onMoveToNextComplete(String s, SequencerUnit sequencerunit)
    {
        s = new LoadTrackKeyForPlaybackEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition(), true);
        eventBus.post(s);
        postSequencePositionChangedEvent(sequencerunit);
    }

    public void onMoveToPreviousComplete(String s, SequencerUnit sequencerunit)
    {
        s = new LoadTrackKeyForPlaybackEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition(), true);
        eventBus.post(s);
        postSequencePositionChangedEvent(sequencerunit);
    }

    public void onNextTrackKeyReady(String s, SequencerUnit sequencerunit)
    {
        s = new LoadTrackKeyForPreBufferingEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition() + 1);
        eventBus.post(s);
    }

    public void onPreviousTrackKeyReady(String s, SequencerUnit sequencerunit)
    {
    }

    public void onSequenceChanged(int ai[], SequencerUnit sequencerunit)
    {
        List list = sequencerunit.getSequenceAsKeys();
        list.remove(0);
        ai = new PlaybackSequenceUpdatedEvent(sequencerunit.getParentModel(), list, ai);
        eventBus.post(ai);
    }

    public void onSequenceReachedEnd(SequencerUnit sequencerunit)
    {
        eventBus.post(new PlaybackSequenceEndedEvent());
        if (!PlaybackSequenceManager.access$100(PlaybackSequenceManager.this))
        {
            eventBus.post(new PlaybackSequenceAbsoluteEndEvent());
        }
    }

    public void onSourceConversion(String s, String s1)
    {
    }

    public ()
    {
        this$0 = PlaybackSequenceManager.this;
        super();
    }
}
