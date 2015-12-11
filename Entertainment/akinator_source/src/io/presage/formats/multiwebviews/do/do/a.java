// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews.do.do;

import android.content.Context;
import android.os.Handler;
import java.io.IOException;
import shared_presage.com.google.android.exoplayer.DefaultLoadControl;
import shared_presage.com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import shared_presage.com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import shared_presage.com.google.android.exoplayer.TrackRenderer;
import shared_presage.com.google.android.exoplayer.audio.AudioCapabilities;
import shared_presage.com.google.android.exoplayer.chunk.VideoFormatSelectorUtil;
import shared_presage.com.google.android.exoplayer.hls.HlsChunkSource;
import shared_presage.com.google.android.exoplayer.hls.HlsMasterPlaylist;
import shared_presage.com.google.android.exoplayer.hls.HlsPlaylist;
import shared_presage.com.google.android.exoplayer.hls.HlsPlaylistParser;
import shared_presage.com.google.android.exoplayer.hls.HlsSampleSource;
import shared_presage.com.google.android.exoplayer.upstream.DefaultAllocator;
import shared_presage.com.google.android.exoplayer.upstream.DefaultBandwidthMeter;
import shared_presage.com.google.android.exoplayer.upstream.DefaultUriDataSource;
import shared_presage.com.google.android.exoplayer.util.ManifestFetcher;

// Referenced classes of package io.presage.formats.multiwebviews.do.do:
//            b

public final class a
    implements shared_presage.com.google.android.exoplayer.util.ManifestFetcher.ManifestCallback
{

    private final Context a;
    private final String b;
    private final String c;
    private final AudioCapabilities d;
    private io.presage.formats.multiwebviews.do.a e;
    private b f;

    public a(Context context, String s, String s1, AudioCapabilities audiocapabilities)
    {
        a = context;
        b = s;
        c = s1;
        d = audiocapabilities;
    }

    public final void a(io.presage.formats.multiwebviews.do.a a1, b b1)
    {
        e = a1;
        f = b1;
        a1 = new HlsPlaylistParser();
        (new ManifestFetcher(c, new DefaultUriDataSource(a, b), a1)).singleLoad(e.f().getLooper(), this);
    }

    public final void onSingleManifest(Object obj)
    {
        HlsPlaylist hlsplaylist = (HlsPlaylist)obj;
        Object obj1 = e.f();
        DefaultLoadControl defaultloadcontrol = new DefaultLoadControl(new DefaultAllocator(0x40000));
        DefaultBandwidthMeter defaultbandwidthmeter = new DefaultBandwidthMeter();
        obj = null;
        if (hlsplaylist instanceof HlsMasterPlaylist)
        {
            obj = (HlsMasterPlaylist)hlsplaylist;
            try
            {
                obj = VideoFormatSelectorUtil.selectVideoFormatsForDefaultDisplay(a, ((HlsMasterPlaylist) (obj)).variants, null, false);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                f.h();
                return;
            }
        }
        obj = new HlsSampleSource(new HlsChunkSource(new DefaultUriDataSource(a, defaultbandwidthmeter, b), c, hlsplaylist, defaultbandwidthmeter, ((int []) (obj)), 1, d), defaultloadcontrol, 0x1000000, ((Handler) (obj1)), e, 0);
        obj1 = new MediaCodecVideoTrackRenderer(((shared_presage.com.google.android.exoplayer.SampleSource) (obj)), 1, 5000L, ((Handler) (obj1)), e, 50);
        obj = new MediaCodecAudioTrackRenderer(((shared_presage.com.google.android.exoplayer.SampleSource) (obj)));
        f.a(new TrackRenderer[] {
            obj1, obj
        });
    }

    public final void onSingleManifestError(IOException ioexception)
    {
        f.h();
    }
}
