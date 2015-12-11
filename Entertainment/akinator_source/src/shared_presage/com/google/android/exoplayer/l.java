// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import android.view.Surface;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

final class l
    implements Runnable
{

    final Surface a;
    final MediaCodecVideoTrackRenderer b;

    l(MediaCodecVideoTrackRenderer mediacodecvideotrackrenderer, Surface surface)
    {
        b = mediacodecvideotrackrenderer;
        a = surface;
        super();
    }

    public final void run()
    {
        MediaCodecVideoTrackRenderer.access$000(b).onDrawnToSurface(a);
    }
}
