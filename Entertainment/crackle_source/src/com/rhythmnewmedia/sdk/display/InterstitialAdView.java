// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.rhythmnewmedia.sdk.RhythmActivity;
import com.rhythmnewmedia.sdk.i;
import com.rhythmnewmedia.sdk.m;
import com.rhythmnewmedia.sdk.u;
import com.rhythmnewmedia.sdk.video.RhythmVideoView;
import com.rhythmnewmedia.sdk.video.VideoEventAdapter;
import com.rhythmnewmedia.sdk.w;
import com.rhythmnewmedia.sdk.y;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdView

public class InterstitialAdView extends AdView
{
    public static interface a
    {

        public abstract void a_();

        public abstract void b(i j);
    }


    a a;

    public InterstitialAdView(Context context)
    {
        super(context);
        a = null;
        super.setAdUnit(m.g);
    }

    public InterstitialAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = null;
        super.setAdUnit(m.g);
    }

    public InterstitialAdView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a = null;
        super.setAdUnit(m.g);
    }

    protected String getAdRequestParameterString()
    {
        return String.format("&channel=%s&%s", new Object[] {
            adUnit.c(), getSizeParameters()
        });
    }

    public i handleClick(String s)
    {
        i j = super.handleClick(s);
        static final class _cls2
        {

            static final int a[];

            static 
            {
                a = new int[com.rhythmnewmedia.sdk.d.a.values().length];
                try
                {
                    a[com.rhythmnewmedia.sdk.d.a.s.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.rhythmnewmedia.sdk.d.a.n.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        RhythmVideoView rhythmvideoview;
        switch (_cls2.a[j.a.ordinal()])
        {
        default:
            return j;

        case 1: // '\001'
        case 2: // '\002'
            rhythmvideoview = (RhythmVideoView)j.e;
            break;
        }
        if (rhythmvideoview != null)
        {
            boolean flag;
            if (!rhythmvideoview.isFullscreen())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                currentAdResponse.a(com.rhythmnewmedia.sdk.u.a.c);
                rhythmvideoview.setSkipButtonDelay(currentAdResponse.h());
                s = new FrameLayout(getContext());
                s.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(1, 1));
                s.setBackgroundColor(0xff000000);
                addView(s);
                android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
                layoutparams.gravity = 17;
                rhythmvideoview.setLayoutParams(layoutparams);
                s.addView(rhythmvideoview);
            } else
            {
                s = null;
            }
            rhythmvideoview.setVideoEventListener(new VideoEventAdapter(flag, s, j) {

                final boolean a;
                final FrameLayout b;
                final i c;
                final InterstitialAdView d;

                public final void onCompletion(RhythmVideoView rhythmvideoview1, int k, int l, int i1)
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

                public final void onError(RhythmVideoView rhythmvideoview1, int k, int l, int i1, int j1)
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

                public final void onPrepared(RhythmVideoView rhythmvideoview1, int k, int l)
                {
                    if (a)
                    {
                        rhythmvideoview1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                        rhythmvideoview1.addRule(13);
                        b.setLayoutParams(rhythmvideoview1);
                        if (d.a != null)
                        {
                            d.a.a_();
                        }
                    }
                    d.webView.loadUrl("javascript:net.rnmd.sdk.rhythmMovieStarted()");
                }

            
            {
                d = InterstitialAdView.this;
                a = flag;
                b = framelayout;
                c = j;
                super();
            }
            });
        }
        pin();
        return j;
    }

    public void setInterstitialListener(a a1)
    {
        a = a1;
    }

    public boolean showAsTakeover()
    {
label0:
        {
            if (isCancelled())
            {
                return false;
            }
            if (!ready)
            {
                y.b("Attempted to initiate a takeover when the ad was not ready - please make sure you've received the onAdReady callback event first", new Object[0]);
                return false;
            }
            if (getParent() != null)
            {
                if (!(getParent() instanceof ViewGroup))
                {
                    break label0;
                }
                ((ViewGroup)getParent()).removeView(this);
            }
            Intent intent = new Intent(getContext(), com/rhythmnewmedia/sdk/RhythmActivity);
            intent.putExtra("rnmdActivityType", 2);
            intent.putExtra("rnmdRequestId", currentAdResponse.a());
            intent.putExtra("rnmdAdId", currentAdResponse.b());
            intent.putExtra("ipckey", w.a(new Object[] {
                this, webView
            }));
            intent.setFlags(0x10010000);
            getContext().startActivity(intent);
            return true;
        }
        y.b("Attempted to initiate a takeover but could not remove interstitial from its parent - please make sure this view is not a child of any other view", new Object[0]);
        return false;
    }
}
