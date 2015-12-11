// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.endpointing;

import android.util.Log;
import com.google.android.speech.listeners.RecognitionEventListener;
import daz;
import dba;
import ewg;
import eyi;
import f;

// Referenced classes of package com.google.android.speech.endpointing:
//            EndpointerEventProcessor

public class DefaultEndpointerEventProcessor
    implements EndpointerEventProcessor
{

    private static final boolean DEBUG = false;
    private static final String TAG = "VS.DefaultEndpointerEventProcessor";
    private long mEndOfSpeechTriggerMs;
    private final RecognitionEventListener mEndpointerListener;
    private eyi mEndpointerParams;
    private final daz mStateMachine;

    public DefaultEndpointerEventProcessor(RecognitionEventListener recognitioneventlistener, eyi eyi1)
    {
        dba dba1 = daz.a("VS.DefaultEndpointerEventProcessor", State.NO_SPEECH_DETECTED).a(State.NO_SPEECH_DETECTED, State.SPEECH_DETECTED).a(State.NO_SPEECH_DETECTED, State.END_OF_SPEECH).a(State.SPEECH_DETECTED, State.DELAY_END_OF_SPEECH).a(State.SPEECH_DETECTED, State.END_OF_SPEECH).a(State.DELAY_END_OF_SPEECH, State.SPEECH_DETECTED).a(State.DELAY_END_OF_SPEECH, State.END_OF_SPEECH);
        dba1.c = false;
        mStateMachine = dba1.a();
        mEndpointerListener = (RecognitionEventListener)f.b(recognitioneventlistener);
        mEndpointerParams = eyi1;
    }

    private boolean processEndOfAudioAsEndOfSpeech()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mStateMachine.b(State.SPEECH_DETECTED)) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.END_OF_SPEECH);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean processEndOfAudioAsNoSpeechDetected()
    {
        this;
        JVM INSTR monitorenter ;
        if (!mStateMachine.b(State.NO_SPEECH_DETECTED)) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.END_OF_SPEECH);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean processEndOfSpeech(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (mEndpointerParams.b <= 0) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.DELAY_END_OF_SPEECH);
        setEndOfSpeechTriggerPoint((long)mEndpointerParams.b + l);
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        mStateMachine.a(State.END_OF_SPEECH);
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean processStartOfSpeech()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        if (!mStateMachine.b(State.NO_SPEECH_DETECTED)) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.SPEECH_DETECTED);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = flag1;
        if (!mStateMachine.b(State.DELAY_END_OF_SPEECH))
        {
            continue; /* Loop/switch isn't completed */
        }
        mStateMachine.a(State.SPEECH_DETECTED);
        flag = flag1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private void setEndOfSpeechTriggerPoint(long l)
    {
        this;
        JVM INSTR monitorenter ;
        mEndOfSpeechTriggerMs = l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean shouldTriggerEndOfSpeech(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (l <= mEndOfSpeechTriggerMs || !mStateMachine.b(State.DELAY_END_OF_SPEECH)) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.END_OF_SPEECH);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean shouldTriggerNoSpeechDetected(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mStateMachine.b(State.NO_SPEECH_DETECTED) || l <= (long)mEndpointerParams.a) goto _L2; else goto _L1
_L1:
        mStateMachine.a(State.END_OF_SPEECH);
        boolean flag = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void process(ewg ewg1)
    {
        if (ewg1 != null && ewg1.a) goto _L2; else goto _L1
_L1:
        Log.w("VS.DefaultEndpointerEventProcessor", "Received EP event without type.");
_L4:
        return;
_L2:
        int i;
        if (mStateMachine.b(State.END_OF_SPEECH))
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ewg1.b;
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (processStartOfSpeech())
        {
            mEndpointerListener.onBeginningOfSpeech(ewg1.c / 1000L);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (processEndOfSpeech(ewg1.c / 1000L))
        {
            mEndpointerListener.onEndOfSpeech();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (i != 2) goto _L4; else goto _L5
_L5:
        if (processEndOfAudioAsEndOfSpeech())
        {
            mEndpointerListener.onEndOfSpeech();
        }
        if (processEndOfAudioAsNoSpeechDetected())
        {
            mEndpointerListener.onNoSpeechDetected();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void updateProgress(int i, long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (shouldTriggerEndOfSpeech(l))
        {
            mEndpointerListener.onEndOfSpeech();
        }
        if (shouldTriggerNoSpeechDetected(l))
        {
            mEndpointerListener.onNoSpeechDetected();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State DELAY_END_OF_SPEECH;
        public static final State END_OF_SPEECH;
        public static final State NO_SPEECH_DETECTED;
        public static final State SPEECH_DETECTED;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/android/speech/endpointing/DefaultEndpointerEventProcessor$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            NO_SPEECH_DETECTED = new State("NO_SPEECH_DETECTED", 0);
            SPEECH_DETECTED = new State("SPEECH_DETECTED", 1);
            DELAY_END_OF_SPEECH = new State("DELAY_END_OF_SPEECH", 2);
            END_OF_SPEECH = new State("END_OF_SPEECH", 3);
            $VALUES = (new State[] {
                NO_SPEECH_DETECTED, SPEECH_DETECTED, DELAY_END_OF_SPEECH, END_OF_SPEECH
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }

}
