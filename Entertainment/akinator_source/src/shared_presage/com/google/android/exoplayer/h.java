// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecTrackRenderer

final class h
    implements Runnable
{

    final android.media.MediaCodec.CryptoException a;
    final MediaCodecTrackRenderer b;

    h(MediaCodecTrackRenderer mediacodectrackrenderer, android.media.MediaCodec.CryptoException cryptoexception)
    {
        b = mediacodectrackrenderer;
        a = cryptoexception;
        super();
    }

    public final void run()
    {
        MediaCodecTrackRenderer.access$000(b).onCryptoError(a);
    }
}
