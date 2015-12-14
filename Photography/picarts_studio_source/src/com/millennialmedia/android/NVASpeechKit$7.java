// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMLog

class a
    implements com.nuance.nmdp.speechkit.ener
{

    private NVASpeechKit a;

    public void onError(Recognizer recognizer, SpeechError speecherror)
    {
        MMLog.b("NVASpeechKit", (new StringBuilder("Speech Kit Error code:")).append(speecherror.getErrorCode()).append(" detail:").append(speecherror.getErrorDetail()).append(" suggestions:").append(speecherror.getSuggestion()).toString());
        NVASpeechKit.m(a);
        NVASpeechKit.a(a, speecherror);
        NVASpeechKit.o(a);
        if (NVASpeechKit.n(a) != null)
        {
            MMLog.b("NVASpeechKit", (new StringBuilder("Recognizer.Listener.onError: session id [")).append(NVASpeechKit.n(a).getSessionId()).append("]").toString());
        }
    }

    public void onRecordingBegin(Recognizer recognizer)
    {
        MMLog.b("NVASpeechKit", "recording begins");
        a._results = null;
        if (!NVASpeechKit.b(a).isTrackingAudioSample())
        {
            NVASpeechKit.a(a, ate.RECORDING);
        }
        NVASpeechKit.k(a);
        if (NVASpeechKit.b(a).isTrackingAudioSample())
        {
            NVASpeechKit.f(a).removeCallbacks(NVASpeechKit.l(a));
            NVASpeechKit.f(a).postDelayed(NVASpeechKit.l(a), 2000L);
        }
    }

    public void onRecordingDone(Recognizer recognizer)
    {
        MMLog.b("NVASpeechKit", "recording has ended");
        NVASpeechKit.m(a);
        if (!NVASpeechKit.b(a).isTrackingAudioSample())
        {
            NVASpeechKit.a(a, ate.PROCESSING);
        }
        if (NVASpeechKit.n(a) != null)
        {
            NVASpeechKit.a(a, NVASpeechKit.n(a).getSessionId());
        }
    }

    public void onResults(Recognizer recognizer, Recognition recognition)
    {
        MMLog.b("NVASpeechKit", "recording results returned.");
        NVASpeechKit.m(a);
        if (!NVASpeechKit.b(a).b)
        {
            NVASpeechKit.a(a, recognition.getDetailedResults());
            if (NVASpeechKit.p(a) != null)
            {
                MMLog.b("NVASpeechKit", (new StringBuilder("Recognizer.Listener.onResults: session id [")).append(NVASpeechKit.p(a)).append("]").toString());
            }
            a.logEvent();
            return;
        } else
        {
            a._results = new sult[0];
            NVASpeechKit.g(a);
            return;
        }
    }

    sult(NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
