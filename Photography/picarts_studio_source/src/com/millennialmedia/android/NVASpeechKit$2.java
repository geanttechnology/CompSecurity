// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.os.Handler;
import com.nuance.nmdp.speechkit.Recognizer;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMLog

class a
    implements Runnable
{

    private NVASpeechKit a;

    public void run()
    {
        if (NVASpeechKit.a(a) != null)
        {
            double d = dioLevelTracker.a(NVASpeechKit.a(a).getAudioLevel());
            MMLog.b("NVASpeechKit", (new StringBuilder("audiolevel changed: level=")).append(d).toString());
            if (NVASpeechKit.b(a).update(d) && NVASpeechKit.c(a) != null)
            {
                NVASpeechKit.c(a).onAudioLevelUpdate(d);
            }
            if (NVASpeechKit.d(a) == ate.RECORDING || NVASpeechKit.b(a).b)
            {
                NVASpeechKit.f(a).postDelayed(NVASpeechKit.e(a), 50L);
            }
        }
    }

    ate(NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
