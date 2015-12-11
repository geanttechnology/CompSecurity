// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.webkit.WebView;
import android.widget.FrameLayout;
import com.rhythmnewmedia.sdk.i;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;
import com.rhythmnewmedia.sdk.video.VideoEventAdapter;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            InterstitialAdView

final class > extends VideoEventAdapter
{

    final boolean a;
    final FrameLayout b;
    final i c;
    final InterstitialAdView d;

    public final void onCompletion(RhythmVideoView rhythmvideoview, int j, int k, int l)
    {
        if (c.d)
        {
            d.unpin();
        } else
        {
            d.removeView(b);
        }
        if (d.a != null)
        {
            d.a.b(c);
        }
    }

    public final void onError(RhythmVideoView rhythmvideoview, int j, int k, int l, int i1)
    {
        if (c.d)
        {
            d.unpin();
            return;
        } else
        {
            d.removeView(b);
            return;
        }
    }

    public final void onPrepared(RhythmVideoView rhythmvideoview, int j, int k)
    {
        if (a)
        {
            rhythmvideoview = new android.widget.Params(-1, -1);
            rhythmvideoview.addRule(13);
            b.setLayoutParams(rhythmvideoview);
            if (d.a != null)
            {
                d.a.a_();
            }
        }
        d.webView.loadUrl("javascript:net.rnmd.sdk.rhythmMovieStarted()");
    }

    _cls9(InterstitialAdView interstitialadview, boolean flag, FrameLayout framelayout, i j)
    {
        d = interstitialadview;
        a = flag;
        b = framelayout;
        c = j;
        super();
    }
}
