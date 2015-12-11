// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecVideoTrackRenderer

final class k
    implements Runnable
{

    final int a;
    final int b;
    final float c;
    final MediaCodecVideoTrackRenderer d;

    k(MediaCodecVideoTrackRenderer mediacodecvideotrackrenderer, int i, int j, float f)
    {
        d = mediacodecvideotrackrenderer;
        a = i;
        b = j;
        c = f;
        super();
    }

    public final void run()
    {
        MediaCodecVideoTrackRenderer.access$000(d).onVideoSizeChanged(a, b, c);
    }
}
