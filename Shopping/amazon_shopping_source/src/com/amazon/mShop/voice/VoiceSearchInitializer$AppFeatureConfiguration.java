// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.voice;

import com.amazon.mShop.feature.Features;
import com.amazon.shopapp.voice.module.FeatureConfiguration;

// Referenced classes of package com.amazon.mShop.voice:
//            VoiceSearchInitializer

public class this._cls0
    implements FeatureConfiguration
{

    final VoiceSearchInitializer this$0;

    public String getFeatureState(String s)
    {
        return Features.getInstance().getFeatureState(s);
    }

    public boolean isFeatureActivated(String s)
    {
        return Features.getInstance().isFeatureActivated(s);
    }

    public ()
    {
        this$0 = VoiceSearchInitializer.this;
        super();
    }
}
