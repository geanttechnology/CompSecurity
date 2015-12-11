// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;


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
            return (State)Enum.valueOf(com/rdio/android/sdk/internal/PlaybackStateChangedEvent$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Playing = new State("Playing", 0);
            Paused = new State("Paused", 1);
            Stopped = new State("Stopped", 2);
            Loading = new State("Loading", 3);
            Error = new State("Error", 4);
            None = new State("None", 5);
            $VALUES = (new State[] {
                Playing, Paused, Stopped, Loading, Error, None
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

    public static com.rdio.android.sdk.PlayerListener.PlayState translateState(State state1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[];

            static 
            {
                $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State = new int[State.values().length];
                try
                {
                    $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[State.Playing.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[State.Paused.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[State.Stopped.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[State.Loading.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$rdio$android$sdk$internal$PlaybackStateChangedEvent$State[State.None.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.rdio.android.sdk.internal.PlaybackStateChangedEvent.State[state1.ordinal()])
        {
        default:
            return com.rdio.android.sdk.PlayerListener.PlayState.Error;

        case 1: // '\001'
            return com.rdio.android.sdk.PlayerListener.PlayState.Playing;

        case 2: // '\002'
            return com.rdio.android.sdk.PlayerListener.PlayState.Paused;

        case 3: // '\003'
            return com.rdio.android.sdk.PlayerListener.PlayState.Stopped;

        case 4: // '\004'
            return com.rdio.android.sdk.PlayerListener.PlayState.Loading;

        case 5: // '\005'
            return com.rdio.android.sdk.PlayerListener.PlayState.None;
        }
    }

    public State getState()
    {
        return state;
    }
}
