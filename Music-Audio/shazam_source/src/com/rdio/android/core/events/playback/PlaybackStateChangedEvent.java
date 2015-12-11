// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public class PlaybackStateChangedEvent
{
    public static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Error;
        public static final State Loading;
        public static final State None;
        public static final State Paused;
        public static final State Playing;
        public static final State Stopped;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/rdio/android/core/events/playback/PlaybackStateChangedEvent$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Loading = new State("Loading", 0);
            Playing = new State("Playing", 1);
            Paused = new State("Paused", 2);
            Stopped = new State("Stopped", 3);
            Error = new State("Error", 4);
            None = new State("None", 5);
            $VALUES = (new State[] {
                Loading, Playing, Paused, Stopped, Error, None
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private State state;

    public PlaybackStateChangedEvent(State state1)
    {
        state = state1;
    }

    public State getState()
    {
        return state;
    }

    public boolean isStateConsideredPlaying()
    {
        return state == State.Playing || state == State.Loading;
    }
}
