// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecAudioTrackRenderer

final class e
    implements Runnable
{

    final shared_presage.com.google.android.exoplayer.audio.AudioTrack.InitializationException a;
    final MediaCodecAudioTrackRenderer b;

    e(MediaCodecAudioTrackRenderer mediacodecaudiotrackrenderer, shared_presage.com.google.android.exoplayer.audio.AudioTrack.InitializationException initializationexception)
    {
        b = mediacodecaudiotrackrenderer;
        a = initializationexception;
        super();
    }

    public final void run()
    {
        MediaCodecAudioTrackRenderer.access$000(b).onAudioTrackInitializationError(a);
    }
}
