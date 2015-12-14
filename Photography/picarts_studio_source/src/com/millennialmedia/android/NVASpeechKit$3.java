// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.SpeechError;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMLog

class a
    implements com.nuance.nmdp.speechkit.Listener
{

    private NVASpeechKit a;

    public void onComplete(GenericCommand genericcommand, GenericResult genericresult, SpeechError speecherror)
    {
        if (speecherror != null)
        {
            MMLog.e("NVASpeechKit", (new StringBuilder("GenericCommand listener. Error: ")).append(speecherror.getErrorDetail()).toString());
        } else
        {
            MMLog.b("NVASpeechKit", (new StringBuilder("GenericCommand listener. Success: ")).append(genericresult.getQueryResult()).toString());
        }
        NVASpeechKit.g(a);
    }

    stener(NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
