// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import com.amazon.mShop.feature.ExperimentRecorder;
import com.amazon.shopapp.voice.module.ExperimentProvider;

// Referenced classes of package com.amazon.mShop.voice:
//            VoiceSearchInitializer

public class this._cls0
    implements ExperimentProvider
{

    final VoiceSearchInitializer this$0;

    public String getTreatment(String s)
    {
        return ExperimentRecorder.getInstance().getTreatment(s);
    }

    public I()
    {
        this$0 = VoiceSearchInitializer.this;
        super();
    }
}
