// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.sequencing;

import com.google.a.d.e;
import com.rdio.android.api.models.ApiModel;
import java.util.List;

public interface SequencerUnit
{
    public static final class Error extends Enum
    {

        private static final Error $VALUES[];
        public static final Error UnableToConvertToStation;

        public static Error valueOf(String s)
        {
            return (Error)Enum.valueOf(com/rdio/android/core/sequencing/SequencerUnit$Error, s);
        }

        public static Error[] values()
        {
            return (Error[])$VALUES.clone();
        }

        static 
        {
            UnableToConvertToStation = new Error("UnableToConvertToStation", 0);
            $VALUES = (new Error[] {
                UnableToConvertToStation
            });
        }

        private Error(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface Listener
    {

        public abstract void onError(Error error);

        public abstract void onInitialTrackKeyReady(String s, SequencerUnit sequencerunit);

        public abstract void onJumpComplete(String s, SequencerUnit sequencerunit);

        public abstract void onMoveToNextComplete(String s, SequencerUnit sequencerunit);

        public abstract void onMoveToPreviousComplete(String s, SequencerUnit sequencerunit);

        public abstract void onNextTrackKeyReady(String s, SequencerUnit sequencerunit);

        public abstract void onPreviousTrackKeyReady(String s, SequencerUnit sequencerunit);

        public abstract void onSequenceChanged(int ai[], SequencerUnit sequencerunit);

        public abstract void onSequenceReachedEnd(SequencerUnit sequencerunit);

        public abstract void onSourceConversion(String s, String s1);
    }

    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode Normal;
        public static final Mode RepeatAll;
        public static final Mode RepeatOne;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/rdio/android/core/sequencing/SequencerUnit$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            Normal = new Mode("Normal", 0);
            RepeatAll = new Mode("RepeatAll", 1);
            RepeatOne = new Mode("RepeatOne", 2);
            $VALUES = (new Mode[] {
                Normal, RepeatAll, RepeatOne
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void cancel();

    public abstract void computeNextTrackKey();

    public abstract void computePreviousTrackKey();

    public abstract int getCurrentPosition();

    public abstract Mode getMode();

    public abstract String getParentKey();

    public abstract ApiModel getParentModel();

    public abstract List getSequenceAsKeys();

    public abstract void initialize(String s, int i, Listener listener, e e);

    public abstract boolean isReady();

    public abstract boolean isShuffling();

    public abstract void jumpToPosition(int i);

    public abstract void moveToNext();

    public abstract void moveToPrevious();

    public abstract void prepareForPlayback();

    public abstract void setListener(Listener listener);

    public abstract void setMode(Mode mode);

    public abstract boolean toggleShuffle();
}
