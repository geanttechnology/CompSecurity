// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad;

import com.amazon.blueshift.bluefront.android.vad.config.DnnVADConfig;
import com.amazon.blueshift.bluefront.android.vad.config.VADConfig;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad:
//            VoiceActivityDetector

public class DnnVAD extends VoiceActivityDetector
{

    public DnnVAD(int i, DnnVADConfig dnnvadconfig)
    {
        super(i, dnnvadconfig);
    }

    protected ByteBuffer setupVAD(DnnVADConfig dnnvadconfig)
    {
        Preconditions.checkNotNull(dnnvadconfig, "DnnVadConfig cannot be null.");
        ByteBuffer bytebuffer = createVAD(true);
        if (dnnvadconfig.getThreshold().isPresent())
        {
            setDNNThreshold(bytebuffer, ((Float)dnnvadconfig.getThreshold().get()).floatValue());
        }
        return bytebuffer;
    }

    protected volatile ByteBuffer setupVAD(VADConfig vadconfig)
    {
        return setupVAD((DnnVADConfig)vadconfig);
    }
}
