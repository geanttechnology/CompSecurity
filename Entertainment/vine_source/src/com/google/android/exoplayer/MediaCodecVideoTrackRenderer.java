// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import android.view.Surface;
import co.vine.android.player.SdkVideoView;

// Referenced classes of package com.google.android.exoplayer:
//            FrameworkSampleSource

public class MediaCodecVideoTrackRenderer
{
    public static interface EventListener
    {

        public abstract void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception);

        public abstract void onDecoderInitializationError(MediaCodecTrackRenderer.DecoderInitializationException decoderinitializationexception);

        public abstract void onDrawnToSurface(Surface surface);

        public abstract void onDroppedFrames(int i, long l);

        public abstract void onVideoSizeChanged(int i, int j);
    }


    public static final Object MSG_SET_SURFACE = Integer.valueOf(1);

    public MediaCodecVideoTrackRenderer(FrameworkSampleSource frameworksamplesource, int i, int j, Handler handler, SdkVideoView sdkvideoview, int k)
    {
    }

}
