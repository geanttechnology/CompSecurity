// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.generated.BaseTrack;
import com.rdio.android.core.events.BroadcastPlaybackInfoEvent;
import com.rdio.android.core.events.playback.LoadTrackKeyForPlaybackEvent;
import com.rdio.android.core.events.playback.LoadTrackKeyForPreBufferingEvent;
import com.rdio.android.core.events.playback.PlaybackCompletedEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceAbsoluteEndEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceChangedEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceComputeNextKeyEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceEndedEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceErrorEvent;
import com.rdio.android.core.events.playback.PlaybackSequencePositionChangedEvent;
import com.rdio.android.core.events.playback.PlaybackSequenceUpdatedEvent;
import com.rdio.android.core.events.playback.PlaybackStateChangedEvent;
import com.rdio.android.core.events.playback.QueueChangedEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEvent;
import com.rdio.android.core.events.playback.ReportPlaybackEventType;
import com.rdio.android.core.events.playback.SetQueueEvent;
import com.rdio.android.core.events.playback.commands.LocalLoadSequenceEvent;
import com.rdio.android.core.events.playback.commands.LocalPlaybackCommandEvent;
import com.rdio.android.core.events.playback.commands.LocalQueueCommandEvent;
import com.rdio.android.core.events.playback.commands.PlaybackCommand;
import com.rdio.android.core.events.playback.commands.QueueCommand;
import com.rdio.android.core.events.playback.commands.SetSequenceEvent;
import com.rdio.android.core.sequencing.ImmutableSequencerUnit;
import com.rdio.android.core.sequencing.SequencerUnit;
import com.rdio.android.core.sequencing.SingleTrackSequencerUnit;
import com.rdio.android.core.sequencing.StationSequencerUnit;
import com.rdio.android.core.util.Logging;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PlaybackSequenceManager
{
    public class CurrentUnitListener
        implements com.rdio.android.core.sequencing.SequencerUnit.Listener
    {

        public boolean startPlayback;
        final PlaybackSequenceManager this$0;

        private void postSequencePositionChangedEvent(SequencerUnit sequencerunit)
        {
            sequencerunit = new PlaybackSequencePositionChangedEvent(sequencerunit.getCurrentPosition());
            eventBus.post(sequencerunit);
        }

        public void onError(com.rdio.android.core.sequencing.SequencerUnit.Error error)
        {
        }

        public void onInitialTrackKeyReady(String s, SequencerUnit sequencerunit)
        {
            s = new LoadTrackKeyForPlaybackEvent(s, sequencerunit.getParentKey(), sequencerunit.getCurrentPosition(), startPlayback);
            eventBus.post(s);
            postSequenceChangedEvent();
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
            if (!moveToNextUnit())
            {
                eventBus.post(new PlaybackSequenceAbsoluteEndEvent());
            }
        }

        public void onSourceConversion(String s, String s1)
        {
        }

        public CurrentUnitListener()
        {
            this$0 = PlaybackSequenceManager.this;
            super();
        }
    }


    private static final String TAG = "PlaybackSequenceManager";
    protected final CurrentUnitListener currentUnitListener = instantiateUnitListener();
    protected final e eventBus;
    protected final Logging logging;
    protected List sequencerUnits;

    public PlaybackSequenceManager(e e1, Logging logging1)
    {
        eventBus = e1;
        logging = logging1;
        e1.register(this);
    }

    private void enqueueItem(String s, Class class1)
    {
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("enqueueItem(): adding key ")).append(s).append(" to queue").toString());
        if (sequencerUnits == null)
        {
            sequencerUnits = new ArrayList();
        }
        try
        {
            class1 = instantiateSequenceUnit(class1);
            sequencerUnits.add(class1);
            class1.initialize(s, 0, null, eventBus);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logging.log(6, "PlaybackSequenceManager", "enqueueItem(): Could not create SequencerUnit instance");
            logging.logException(s, true);
            eventBus.post(new PlaybackSequenceErrorEvent());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logging.log(6, "PlaybackSequenceManager", "enqueueItem(): Could not create SequencerUnit instance");
        }
        logging.logException(s, true);
        eventBus.post(new PlaybackSequenceErrorEvent());
    }

    private boolean moveToNextUnit()
    {
        if (sequencerUnits.isEmpty())
        {
            return false;
        }
        ((SequencerUnit)sequencerUnits.remove(0)).setListener(null);
        if (sequencerUnits.isEmpty())
        {
            return false;
        } else
        {
            ((SequencerUnit)sequencerUnits.get(0)).setListener(currentUnitListener);
            ((SequencerUnit)sequencerUnits.get(0)).prepareForPlayback();
            return true;
        }
    }

    private void postSequenceChangedEvent()
    {
        SequencerUnit sequencerunit = getCurrentUnit();
        if (sequencerunit == null || !sequencerunit.isReady())
        {
            logging.log(4, "PlaybackSequenceManager", "postSequenceChangedEvent(): current unit is not ready, not posting event.");
            return;
        }
        logging.log(4, "PlaybackSequenceManager", "postSequenceChangedEvent(): current unit ready, posting event");
        Object obj;
        if (sequencerUnits.size() > 1)
        {
            obj = new ArrayList(sequencerUnits.size() - 1);
            for (int i = 1; i < sequencerUnits.size(); i++)
            {
                ((List) (obj)).add(((SequencerUnit)sequencerUnits.get(i)).getParentKey());
            }

        } else
        {
            obj = null;
        }
        obj = new PlaybackSequenceChangedEvent(sequencerunit.getParentModel(), sequencerunit.getSequenceAsKeys(), ((List) (obj)), sequencerunit.getCurrentPosition());
        eventBus.post(obj);
    }

    private void processSequence(String s, int i, Class class1, boolean flag)
    {
        if (sequencerUnits == null)
        {
            sequencerUnits = new ArrayList();
        }
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("processSequence(): parent=")).append(s).append(" start=").append(i).append(" startPlayback=").append(flag).toString());
        currentUnitListener.startPlayback = flag;
        if (getCurrentUnit() == null || !getCurrentUnit().isReady() || !getCurrentUnit().getParentKey().equals(s)) goto _L2; else goto _L1
_L1:
        getCurrentUnit().jumpToPosition(i);
_L4:
        return;
_L2:
        if (getCurrentUnit() != null)
        {
            logging.log(4, "PlaybackSequenceManager", "Cancelling current sequencer unit");
            getCurrentUnit().cancel();
        }
        if (sequencerUnits.size() > 0)
        {
            ((SequencerUnit)sequencerUnits.remove(0)).setListener(null);
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        eventBus.post(new PlaybackStateChangedEvent(com.rdio.android.core.events.playback.PlaybackStateChangedEvent.State.Loading));
        class1 = instantiateSequenceUnit(class1);
        class1.initialize(s, i, currentUnitListener, eventBus);
        class1.prepareForPlayback();
        sequencerUnits.add(0, class1);
        if (flag)
        {
            try
            {
                eventBus.post(new ReportPlaybackEvent(ReportPlaybackEventType.LoadingParent, null));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                logging.log(6, "PlaybackSequenceManager", "processSequence(): Could not create SequencerUnit instance");
                logging.logException(s, true);
                eventBus.post(new PlaybackSequenceErrorEvent());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                logging.log(6, "PlaybackSequenceManager", "processSequence(): Could not create SequencerUnit instance");
            }
            logging.logException(s, true);
            eventBus.post(new PlaybackSequenceErrorEvent());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void removeQueueItems(int ai[])
    {
        if (sequencerUnits == null)
        {
            throw new IllegalArgumentException("Unable to remove queue items, nothing is in the queue");
        }
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i] + 1;
            if (sequencerUnits.size() > k)
            {
                sequencerUnits.remove(k);
            }
        }

    }

    public static Class sequencerUnitTypeForModel(ApiModel apimodel)
    {
        Class class1 = com/rdio/android/core/sequencing/ImmutableSequencerUnit;
        if (apimodel instanceof BaseTrack)
        {
            class1 = com/rdio/android/core/sequencing/SingleTrackSequencerUnit;
        } else
        if (apimodel instanceof BaseStation)
        {
            return com/rdio/android/core/sequencing/StationSequencerUnit;
        }
        return class1;
    }

    private void swapQueueItem(int ai[])
    {
        if (sequencerUnits == null)
        {
            throw new IllegalArgumentException("Unable to swap queue items, nothing is in the queue");
        }
        if (ai[0] + 1 >= sequencerUnits.size() || ai[0] + 1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Unable to swap queue items due to invalid position : ")).append(ai[0]).toString());
        }
        if (ai[1] + 1 >= sequencerUnits.size() || ai[1] + 1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Unable to swap queue items due to invalid position : ")).append(ai[1]).toString());
        } else
        {
            Collections.swap(sequencerUnits, ai[0] + 1, ai[1] + 1);
            return;
        }
    }

    public abstract boolean canGoNext();

    public abstract boolean canGoPrev();

    public SequencerUnit getCurrentUnit()
    {
        while (sequencerUnits == null || sequencerUnits.isEmpty()) 
        {
            return null;
        }
        return (SequencerUnit)sequencerUnits.get(0);
    }

    public List getQueueKeys()
    {
        ArrayList arraylist = new ArrayList();
        if (sequencerUnits == null)
        {
            return arraylist;
        }
        for (int i = 1; i < sequencerUnits.size(); i++)
        {
            arraylist.add(((SequencerUnit)sequencerUnits.get(i)).getParentKey());
        }

        return arraylist;
    }

    public int getQueueSize()
    {
        if (sequencerUnits == null || sequencerUnits.isEmpty())
        {
            return 0;
        } else
        {
            return sequencerUnits.size();
        }
    }

    public abstract SequencerUnit instantiateSequenceUnit(Class class1);

    protected CurrentUnitListener instantiateUnitListener()
    {
        return new CurrentUnitListener();
    }

    public void onBroadcastPlaybackInfo(BroadcastPlaybackInfoEvent broadcastplaybackinfoevent)
    {
        logging.log(4, "PlaybackSequenceManager", "onBroadcastPlaybackInfo");
        if (getCurrentUnit() == null)
        {
            return;
        } else
        {
            postSequenceChangedEvent();
            return;
        }
    }

    public void onComputeNextTrackKey(PlaybackSequenceComputeNextKeyEvent playbacksequencecomputenextkeyevent)
    {
        if (getCurrentUnit() != null)
        {
            getCurrentUnit().computeNextTrackKey();
        }
    }

    public void onLoadSequence(LocalLoadSequenceEvent localloadsequenceevent)
    {
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("onLoadSequence: ")).append(localloadsequenceevent.getParentKey()).toString());
        processSequence(localloadsequenceevent.getParentKey(), localloadsequenceevent.getStartPosition(), localloadsequenceevent.getSequencerUnitType(), true);
    }

    public void onPlaybackCompleted(PlaybackCompletedEvent playbackcompletedevent)
    {
        playbackcompletedevent = getCurrentUnit();
        if (playbackcompletedevent == null)
        {
            return;
        } else
        {
            playbackcompletedevent.moveToNext();
            return;
        }
    }

    public void onPlaybackSkip(LocalPlaybackCommandEvent localplaybackcommandevent)
    {
        SequencerUnit sequencerunit = getCurrentUnit();
        if (sequencerunit != null) goto _L2; else goto _L1
_L1:
        logging.log(4, "PlaybackSequenceManager", "Received command event but current unit is null");
_L7:
        return;
_L2:
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("Handling command: ")).append(localplaybackcommandevent.getCommand()).toString());
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[];
            static final int $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[];

            static 
            {
                $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand = new int[PlaybackCommand.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[PlaybackCommand.SkipNext.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[PlaybackCommand.SkipPrev.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation = new int[com.rdio.android.core.events.playback.commands.QueueCommand.Operation.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands.QueueCommand.Operation.Add.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands.QueueCommand.Operation.Remove.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands.QueueCommand.Operation.Move.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.rdio.android.core.events.playback.commands.PlaybackCommand[localplaybackcommandevent.getCommand().ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 93
    //                   2 107;
           goto _L3 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return;
_L4:
        if (!canGoNext()) goto _L7; else goto _L6
_L6:
        sequencerunit.moveToNext();
        return;
        if (!canGoPrev()) goto _L7; else goto _L8
_L8:
        sequencerunit.moveToPrevious();
        return;
    }

    public void onQueueSequence(LocalQueueCommandEvent localqueuecommandevent)
    {
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("onQueueSequence: ")).append(localqueuecommandevent.getCommand().getOperation()).toString());
        _cls1..SwitchMap.com.rdio.android.core.events.playback.commands.QueueCommand.Operation[localqueuecommandevent.getCommand().getOperation().ordinal()];
        JVM INSTR tableswitch 1 3: default 76
    //                   1 130
    //                   2 151
    //                   3 171;
           goto _L1 _L2 _L3 _L4
_L1:
        eventBus.post(new QueueChangedEvent(localqueuecommandevent.getCommand()));
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("onQueueSequence complete: ")).append(localqueuecommandevent.getCommand().getOperation()).toString());
        return;
_L2:
        enqueueItem((String)localqueuecommandevent.getCommand().getOperationData(), localqueuecommandevent.getSequencerUnitType());
        continue; /* Loop/switch isn't completed */
_L3:
        removeQueueItems((int[])(int[])localqueuecommandevent.getCommand().getOperationData());
        continue; /* Loop/switch isn't completed */
_L4:
        swapQueueItem((int[])(int[])localqueuecommandevent.getCommand().getOperationData());
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void onSetQueueEvent(SetQueueEvent setqueueevent)
    {
        logging.log(4, "PlaybackSequenceManager", "Received SetQueue event");
        if (sequencerUnits != null && sequencerUnits.size() > 1)
        {
            for (int i = sequencerUnits.size() - 1; i > 0; i--)
            {
                sequencerUnits.remove(i);
            }

        }
        for (int j = 0; j < setqueueevent.getQueueItems().size(); j++)
        {
            Map map = (Map)setqueueevent.getQueueItems().get(j);
            String s = (String)map.keySet().iterator().next();
            enqueueItem(s, (Class)map.get(s));
        }

        postSequenceChangedEvent();
    }

    public void onSetSequence(SetSequenceEvent setsequenceevent)
    {
        logging.log(4, "PlaybackSequenceManager", (new StringBuilder("onSetSequence: ")).append(setsequenceevent.getParentKey()).toString());
        if (getCurrentUnit() != null)
        {
            getCurrentUnit().cancel();
            ((SequencerUnit)sequencerUnits.remove(0)).setListener(null);
        }
        processSequence(setsequenceevent.getParentKey(), setsequenceevent.getStartPosition(), setsequenceevent.getSequencerUnitType(), false);
    }


}
