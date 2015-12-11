// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecTrackRenderer

final class i
    implements Runnable
{

    final String a;
    final long b;
    final long c;
    final MediaCodecTrackRenderer d;

    i(MediaCodecTrackRenderer mediacodectrackrenderer, String s, long l, long l1)
    {
        d = mediacodectrackrenderer;
        a = s;
        b = l;
        c = l1;
        super();
    }

    public final void run()
    {
        MediaCodecTrackRenderer.access$000(d).onDecoderInitialized(a, b, c);
    }
}
