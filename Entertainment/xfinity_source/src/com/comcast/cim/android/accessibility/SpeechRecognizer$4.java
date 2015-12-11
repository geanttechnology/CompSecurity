// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.accessibility;

import android.speech.tts.UtteranceProgressListener;

// Referenced classes of package com.comcast.cim.android.accessibility:
//            SpeechRecognizer

class this._cls0 extends UtteranceProgressListener
{

    final SpeechRecognizer this$0;

    public void onDone(String s)
    {
        if (s.equals((new StringBuilder()).append(.UtteranceID.FOLLOWUP_WITH_LISTEN).append("").toString()))
        {
            listen();
        }
    }

    public void onError(String s)
    {
    }

    public void onStart(String s)
    {
    }

    .UtteranceID()
    {
        this$0 = SpeechRecognizer.this;
        super();
    }
}
