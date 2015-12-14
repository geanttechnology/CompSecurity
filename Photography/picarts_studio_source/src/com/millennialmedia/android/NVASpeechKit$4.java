// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.SpeechError;

// Referenced classes of package com.millennialmedia.android:
//            NVASpeechKit, MMLog

class a
    implements com.nuance.nmdp.speechkit.nd.Listener
{

    private NVASpeechKit a;

    private void a(DataUploadCommand datauploadcommand)
    {
        if (NVASpeechKit.c(a) != null && NVASpeechKit.h(a) == datauploadcommand)
        {
            if (NVASpeechKit.i(a) == stomWordsOp.Add)
            {
                NVASpeechKit.c(a).onCustomWordsAdded();
            } else
            {
                NVASpeechKit.c(a).onCustomWordsDeleted();
            }
        }
        NVASpeechKit.j(a);
    }

    public void onError(DataUploadCommand datauploadcommand, SpeechError speecherror)
    {
        MMLog.e("NVASpeechKit", (new StringBuilder("DataUploadCommand listener error. command:")).append(datauploadcommand.toString()).append(" Error:").append(speecherror.getErrorDetail()).toString());
        a(datauploadcommand);
    }

    public void onResults(DataUploadCommand datauploadcommand, DataUploadResult datauploadresult)
    {
        MMLog.b("NVASpeechKit", (new StringBuilder("DataUploadCommand listener successful command:")).append(datauploadcommand.toString()).append(" isVocRegenerated:").append(datauploadresult.isVocRegenerated()).append(" results:").append(datauploadresult.toString()).toString());
        a(datauploadcommand);
    }

    (NVASpeechKit nvaspeechkit)
    {
        a = nvaspeechkit;
        super();
    }
}
