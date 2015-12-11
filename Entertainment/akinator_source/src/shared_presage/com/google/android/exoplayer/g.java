// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecTrackRenderer

final class g
    implements Runnable
{

    final MediaCodecTrackRenderer.DecoderInitializationException a;
    final MediaCodecTrackRenderer b;

    g(MediaCodecTrackRenderer mediacodectrackrenderer, MediaCodecTrackRenderer.DecoderInitializationException decoderinitializationexception)
    {
        b = mediacodectrackrenderer;
        a = decoderinitializationexception;
        super();
    }

    public final void run()
    {
        MediaCodecTrackRenderer.access$000(b).onDecoderInitializationError(a);
    }
}
