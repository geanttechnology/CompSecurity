// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.app.Activity;
import android.speech.tts.UtteranceProgressListener;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            TalkDelegate

public class DummyTalkDelegate
    implements TalkDelegate
{

    public DummyTalkDelegate(Activity activity)
    {
    }

    public void announceTitle()
    {
    }

    public void cancelAllMessages()
    {
    }

    public void ignoreAnnounceTitleOnce()
    {
    }

    public void onDestroy()
    {
    }

    public void setTitle(String s)
    {
    }

    public void setUtteranceListener(UtteranceProgressListener utteranceprogresslistener)
    {
    }

    public void speak(int i)
    {
    }

    public void speak(String s)
    {
    }

    public void speakManagedMessage(int i)
    {
    }

    public void speakThenListen(String s)
    {
    }

    public void stopSpeaking()
    {
    }
}
