// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.shopapp.voice.search;

import android.text.TextUtils;
import android.util.Log;
import com.amazon.dee.result.bif.BIF;
import com.amazon.dee.result.bif.ConfidenceBin;
import com.amazon.dee.result.bif.Intent;
import com.amazon.dee.result.bif.Interpretation;
import com.amazon.dee.result.bif.ScoreSource;
import com.amazon.shopapp.voice.module.VoiceContext;
import java.util.ArrayList;
import java.util.List;

public class VoiceResult
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status ERROR;
        public static final Status HIGH_CONFIDENCE;
        public static final Status LOW_CONFIDENCE;
        public static final Status MEDIUM_CONFIDENCE;
        public static final Status NO_SPEECH_DETECTED;
        public static final Status WRONG_TIME_ON_DEVICE;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/shopapp/voice/search/VoiceResult$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            HIGH_CONFIDENCE = new Status("HIGH_CONFIDENCE", 0);
            MEDIUM_CONFIDENCE = new Status("MEDIUM_CONFIDENCE", 1);
            LOW_CONFIDENCE = new Status("LOW_CONFIDENCE", 2);
            NO_SPEECH_DETECTED = new Status("NO_SPEECH_DETECTED", 3);
            WRONG_TIME_ON_DEVICE = new Status("WRONG_TIME_ON_DEVICE", 4);
            ERROR = new Status("ERROR", 5);
            $VALUES = (new Status[] {
                HIGH_CONFIDENCE, MEDIUM_CONFIDENCE, LOW_CONFIDENCE, NO_SPEECH_DETECTED, WRONG_TIME_ON_DEVICE, ERROR
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/shopapp/voice/search/VoiceResult.getCanonicalName();
    private final String mAsrRequestId;
    private final ArrayList mInterpretations;
    private final Status mStatus;
    private final String mUtteranceId;

    public VoiceResult(String s, BIF bif)
    {
        mInterpretations = new ArrayList();
        if (bif == null)
        {
            mStatus = Status.ERROR;
            mAsrRequestId = null;
            mUtteranceId = null;
            return;
        }
        mAsrRequestId = s;
        mUtteranceId = bif.getUtteranceId();
        s = bif.getBestTokenString();
        List list = bif.getInterpretations();
        List list1 = bif.getTokensAsStringList();
        if (VoiceContext.isDebug())
        {
            Log.v(TAG, (new StringBuilder()).append("Best interpretation: ").append(s).toString());
            Log.v(TAG, (new StringBuilder()).append("Interpretations: ").append(list.size()).toString());
            Log.v(TAG, (new StringBuilder()).append("Result strings: ").append(list1).toString());
        }
        if (TextUtils.isEmpty(s) || list == null || list.isEmpty() || list1 == null || list1.isEmpty())
        {
            mStatus = Status.NO_SPEECH_DETECTED;
            return;
        }
        s = null;
        int i = 0;
        while (i < list.size() && i < list1.size()) 
        {
            Object obj = (Interpretation)list.get(i);
            bif = s;
            if (obj != null)
            {
                if (((Interpretation) (obj)).getIntent() == null)
                {
                    bif = s;
                } else
                {
                    obj = ((Interpretation) (obj)).getIntent().getConfidenceScoreBin(ScoreSource.SLU);
                    bif = s;
                    if (obj != null)
                    {
                        String s1 = (String)list1.get(i);
                        bif = s;
                        if (!TextUtils.isEmpty(s1))
                        {
                            if (obj == ConfidenceBin.HIGH || obj == ConfidenceBin.MEDIUM)
                            {
                                mInterpretations.add(s1);
                            }
                            bif = s;
                            if (s == null)
                            {
                                bif = ((BIF) (obj));
                            }
                        }
                    }
                }
            }
            i++;
            s = bif;
        }
        if (s == null)
        {
            mStatus = Status.ERROR;
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[];

            static 
            {
                $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin = new int[ConfidenceBin.values().length];
                try
                {
                    $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.HIGH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.MEDIUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$dee$result$bif$ConfidenceBin[ConfidenceBin.LOW.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.dee.result.bif.ConfidenceBin[s.ordinal()])
        {
        default:
            mStatus = Status.ERROR;
            return;

        case 1: // '\001'
            mStatus = Status.HIGH_CONFIDENCE;
            return;

        case 2: // '\002'
            mStatus = Status.MEDIUM_CONFIDENCE;
            return;

        case 3: // '\003'
            mStatus = Status.LOW_CONFIDENCE;
            break;
        }
    }

    public VoiceResult(String s, Status status)
    {
        mInterpretations = new ArrayList();
        mStatus = status;
        mAsrRequestId = s;
        mUtteranceId = null;
    }

    public String getAsrRequestId()
    {
        return mAsrRequestId;
    }

    public ArrayList getInterpretations()
    {
        return mInterpretations;
    }

    public Status getStatus()
    {
        return mStatus;
    }

    public String getUtteranceId()
    {
        return mUtteranceId;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        StringBuilder stringbuilder1 = stringbuilder.append("status: ");
        String s;
        if (mStatus == null)
        {
            s = null;
        } else
        {
            s = mStatus.name();
        }
        stringbuilder1.append(s).append(", ASR request ID: ").append(mAsrRequestId).append(", utterance ID: ").append(mUtteranceId).append(", interpretations: ").append(mInterpretations);
        return stringbuilder.toString();
    }

}
