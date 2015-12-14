// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.Vocalizer;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMLog

class a
    implements com.nuance.nmdp.speechkit.ner
{

    private NVASpeechKit a;

    public void onSpeakingBegin(Vocalizer vocalizer, String s, Object obj)
    {
        MMLog.b("NVASpeechKit", (new StringBuilder("Vocalization begins. text=")).append(s).toString());
        NVASpeechKit.a(a, ate.VOCALIZING);
    }

    public void onSpeakingDone(Vocalizer vocalizer, String s, SpeechError speecherror, Object obj)
    {
        MMLog.b("NVASpeechKit", "Vocalization has ended.");
        if (speecherror != null)
        {
            MMLog.e("NVASpeechKit", (new StringBuilder("Vocalizer error: ")).append(speecherror.getErrorDetail()).toString());
            NVASpeechKit.a(a, speecherror);
            return;
        } else
        {
            NVASpeechKit.a(a, ate.READY);
            return;
        }
    }

    ate(NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
