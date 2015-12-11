// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

final class m
    implements Runnable
{

    final int a;
    final long b;
    final MediaCodecVideoTrackRenderer c;

    m(MediaCodecVideoTrackRenderer mediacodecvideotrackrenderer, int i, long l)
    {
        c = mediacodecvideotrackrenderer;
        a = i;
        b = l;
        super();
    }

    public final void run()
    {
        MediaCodecVideoTrackRenderer.access$000(c).onDroppedFrames(a, b);
    }
}
