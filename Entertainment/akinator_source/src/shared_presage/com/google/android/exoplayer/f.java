// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecAudioTrackRenderer

final class f
    implements Runnable
{

    final shared_presage.com.google.android.exoplayer.audio.AudioTrack.WriteException a;
    final MediaCodecAudioTrackRenderer b;

    f(MediaCodecAudioTrackRenderer mediacodecaudiotrackrenderer, shared_presage.com.google.android.exoplayer.audio.AudioTrack.WriteException writeexception)
    {
        b = mediacodecaudiotrackrenderer;
        a = writeexception;
        super();
    }

    public final void run()
    {
        MediaCodecAudioTrackRenderer.access$000(b).onAudioTrackWriteError(a);
    }
}
