// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad;

import com.amazon.blueshift.bluefront.android.vad.config.VADConfig;
import com.amazon.blueshift.bluefront.android.vad.config.WebRtcVADConfig;
import com.google.common.base.Optional;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad:
//            VoiceActivityDetector

public final class WebRtcVAD extends VoiceActivityDetector
{

    public WebRtcVAD(int i, WebRtcVADConfig webrtcvadconfig)
    {
        super(i, webrtcvadconfig);
    }

    protected volatile ByteBuffer setupVAD(VADConfig vadconfig)
    {
        return setupVAD((WebRtcVADConfig)vadconfig);
    }

    protected ByteBuffer setupVAD(WebRtcVADConfig webrtcvadconfig)
    {
        ByteBuffer bytebuffer = createVAD(false);
        if (webrtcvadconfig.getCustomizedAggression().isPresent())
        {
            webrtcvadconfig = (com.amazon.blueshift.bluefront.android.vad.config.WebRtcVADConfig.Aggression)webrtcvadconfig.getCustomizedAggression().get();
            setWebRtcCustomizedMode(bytebuffer, webrtcvadconfig.getOverHangMax1(), webrtcvadconfig.getOverHangMax2(), webrtcvadconfig.getLocalThreshold(), webrtcvadconfig.getGlobalThreshold());
            return bytebuffer;
        } else
        {
            setWebRtcMode(bytebuffer, webrtcvadconfig.getAggressionMode().ordinal());
            return bytebuffer;
        }
    }
}
