// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.audio;

import android.util.Log;
import com.google.android.speech.logger.SpeechLibLogger;
import dbh;

// Referenced classes of package com.google.android.speech.audio:
//            SpeakNowSoundPlayer

public class DefaultMicrophoneInputStreamCallbacks extends MicrophoneInputStream.Callbacks
{

    private static final boolean DBG = false;
    private static final String TAG = "DefaultMicrophoneInputStreamCallbacks";
    private final dbh mAudioRouter;
    private final SpeechLibLogger mLogger;
    private final SpeakNowSoundPlayer mSoundPlayer;

    public DefaultMicrophoneInputStreamCallbacks(dbh dbh, SpeakNowSoundPlayer speaknowsoundplayer, SpeechLibLogger speechliblogger)
    {
        mAudioRouter = dbh;
        mSoundPlayer = speaknowsoundplayer;
        mLogger = speechliblogger;
    }

    public void awaitingRouting(String s)
    {
        s = mAudioRouter;
    }

    public void cancelPendingAwaitRouting(String s)
    {
        s = mAudioRouter;
    }

    public void onEvent(int i)
    {
        switch (i)
        {
        default:
            Log.w("DefaultMicrophoneInputStreamCallbacks", (new StringBuilder("Ignoring mic event: ")).append(i).toString());
            return;

        case 1: // '\001'
            mLogger.recordOpenMicrophoneLatencyStart();
            return;

        case 2: // '\002'
            mLogger.recordBreakdownEvent(49);
            return;

        case 3: // '\003'
            mLogger.recordBreakdownEvent(50);
            return;

        case 4: // '\004'
            mLogger.recordBreakdownEvent(54);
            return;

        case 5: // '\005'
            mLogger.recordBreakdownEvent(53);
            return;

        case 6: // '\006'
            mLogger.recordBreakdownEvent(52);
            return;

        case 7: // '\007'
            mLogger.recordBreakdownEvent(51);
            break;
        }
    }

    public int playSpeakNowSound()
    {
        if (mSoundPlayer != null)
        {
            return mSoundPlayer.playSpeakNowSound();
        } else
        {
            return 0;
        }
    }
}
