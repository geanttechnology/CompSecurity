// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;
import android.widget.VideoView;
import com.tapjoy.internal.cw;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.view.BasicWebView;
import com.tapjoy.mraid.view.MraidView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TapjoyUtil, TapjoyLog, TJVideoListener, 
//            TJPlacementData, TJPlacementManager, TJAdUnitSaveStateData, TJAdUnitActivity, 
//            TapjoyConnectCore, TJCOffers

public class TJAdUnit
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener
{
    public static interface TJAdUnitWebViewListener
    {

        public abstract void onClosed();

        public abstract void onContentReady();
    }

    final class a
        implements MraidViewListener
    {

        final TJAdUnit a;

        private boolean a()
        {
            boolean flag1 = false;
            NetworkInfo networkinfo;
            boolean flag;
            boolean flag2;
            try
            {
                networkinfo = TJAdUnit.e(a).getConnectivityManager().getActiveNetworkInfo();
            }
            catch (Exception exception)
            {
                return false;
            }
            flag = flag1;
            if (networkinfo == null)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            flag = flag1;
            if (!networkinfo.isAvailable())
            {
                break MISSING_BLOCK_LABEL_46;
            }
            flag2 = networkinfo.isConnected();
            flag = flag1;
            if (flag2)
            {
                flag = true;
            }
            return flag;
        }

        private static boolean a(String s1)
        {
            boolean flag = false;
            String s2;
            try
            {
                s2 = (new URL("https://ws.tapjoyads.com/")).getHost();
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return false;
            }
            if (s2 != null && s1.contains(s2) || s1.contains(TapjoyConnectCore.getRedirectDomain()) || s1.contains(TapjoyUtil.getRedirectDomain(TapjoyConnectCore.getPlacementURL())))
            {
                flag = true;
            }
            return flag;
        }

        public final boolean onClose()
        {
            if (TJAdUnit.n(a) != null)
            {
                TJAdUnit.n(a).handleClose();
            }
            return false;
        }

        public final boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            int i1 = 0;
            if (!TJAdUnit.i(a).closeRequested) goto _L2; else goto _L1
_L1:
            String as[];
            as = new String[5];
            as[0] = "Uncaught";
            as[1] = "uncaught";
            as[2] = "Error";
            as[3] = "error";
            as[4] = "not defined";
            TapjoyLog.i("TJAdUnit", "shouldClose...");
            if (TJAdUnit.n(a) == null) goto _L2; else goto _L3
_L3:
            int j1 = as.length;
_L8:
            if (i1 >= j1) goto _L2; else goto _L4
_L4:
            String s1 = as[i1];
            if (!consolemessage.message().contains(s1)) goto _L6; else goto _L5
_L5:
            TJAdUnit.n(a).handleClose();
_L2:
            return true;
_L6:
            i1++;
            if (true) goto _L8; else goto _L7
_L7:
        }

        public final boolean onEventFired()
        {
            return false;
        }

        public final boolean onExpand()
        {
            return false;
        }

        public final boolean onExpandClose()
        {
            return false;
        }

        public final void onPageFinished(WebView webview, String s1)
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("onPageFinished: ")).append(s1).toString());
            if (a != null && TJAdUnit.e(a) != null && TJAdUnit.e(a).isMraid())
            {
                TJAdUnit.i(a).allowRedirect = false;
            }
            if (!TJAdUnit.o(a) && TJAdUnit.p(a) == 1)
            {
                TJCOffers.onOffersResponse();
            }
            if (TJAdUnit.n(a) != null)
            {
                TJAdUnit.n(a).setProgressSpinnerVisibility(false);
            }
            TJAdUnit.q(a);
            if (TJAdUnit.r(a))
            {
                TJAdUnit.s(a);
            }
            TJAdUnit.i(a).flushMessageQueue();
        }

        public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("onPageStarted: ")).append(s1).toString());
            if (TJAdUnit.i(a) != null)
            {
                TJAdUnit.i(a).allowRedirect = true;
                TJAdUnit.i(a).customClose = false;
                TJAdUnit.i(a).closeRequested = false;
            }
        }

        public final boolean onReady()
        {
            return false;
        }

        public final void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            if (!TJAdUnit.o(a) && TJAdUnit.p(a) == 1)
            {
                TJCOffers.onOffersResponseFailed("Failed to load offers from server");
                if (TJAdUnit.c(a) instanceof Activity)
                {
                    ((Activity)TJAdUnit.c(a)).finish();
                }
            } else
            if (TJAdUnit.n(a) != null)
            {
                TJAdUnit.n(a).showErrorDialog();
                return;
            }
        }

        public final boolean onResize()
        {
            return false;
        }

        public final boolean onResizeClose()
        {
            return false;
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            if (!a())
            {
                if (TJAdUnit.n(a) != null)
                {
                    TJAdUnit.n(a).showErrorDialog();
                }
                return true;
            }
            TapjoyLog.i("TJAdUnit", (new StringBuilder("interceptURL: ")).append(s1).toString());
            boolean flag;
            if (a != null && TJAdUnit.e(a) != null && TJAdUnit.e(a).isMraid() && s1.contains("mraid"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                return false;
            }
            if (a(s1))
            {
                TapjoyLog.i("TJAdUnit", (new StringBuilder("Open redirecting URL:")).append(s1).toString());
                ((MraidView)webview).loadUrlStandard(s1);
                return true;
            }
            if (TJAdUnit.i(a).allowRedirect)
            {
                return false;
            } else
            {
                webview.loadUrl(s1);
                return true;
            }
        }

        private a()
        {
            a = TJAdUnit.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }


    public static TJVideoListener publisherVideoListener;
    private TJAdUnitWebViewListener a;
    private Context b;
    private TJAdUnitActivity c;
    private TJAdUnitJSBridge d;
    private BasicWebView e;
    private MraidView f;
    private VideoView g;
    private int h;
    private boolean i;
    private boolean j;
    private Timer k;
    private int l;
    private Runnable m;
    private boolean n;
    private boolean o;
    private volatile boolean p;
    private boolean q;
    private int r;
    private Handler s;

    public TJAdUnit(Context context)
    {
        k = new Timer();
        r = -1;
        setContext(context);
    }

    static VideoView a(TJAdUnit tjadunit, VideoView videoview)
    {
        tjadunit.g = videoview;
        return videoview;
    }

    static TJAdUnitJSBridge a(TJAdUnit tjadunit, TJAdUnitJSBridge tjadunitjsbridge)
    {
        tjadunit.d = tjadunitjsbridge;
        return tjadunitjsbridge;
    }

    static BasicWebView a(TJAdUnit tjadunit, BasicWebView basicwebview)
    {
        tjadunit.e = basicwebview;
        return basicwebview;
    }

    static MraidView a(TJAdUnit tjadunit, MraidView mraidview)
    {
        tjadunit.f = mraidview;
        return mraidview;
    }

    private static boolean a(int i1)
    {
        return i1 == 0 || i1 == 8 || i1 == 6 || i1 == 11;
    }

    static boolean a(TJAdUnit tjadunit)
    {
        return tjadunit.p;
    }

    static boolean a(TJAdUnit tjadunit, boolean flag)
    {
        tjadunit.j = flag;
        return flag;
    }

    private static boolean b(int i1)
    {
        return i1 == 1 || i1 == 9 || i1 == 7 || i1 == 12;
    }

    static boolean b(TJAdUnit tjadunit)
    {
        tjadunit.p = true;
        return true;
    }

    static Context c(TJAdUnit tjadunit)
    {
        return tjadunit.b;
    }

    static BasicWebView d(TJAdUnit tjadunit)
    {
        return tjadunit.e;
    }

    static MraidView e(TJAdUnit tjadunit)
    {
        return tjadunit.f;
    }

    static VideoView f(TJAdUnit tjadunit)
    {
        return tjadunit.g;
    }

    static boolean g(TJAdUnit tjadunit)
    {
        return tjadunit.j;
    }

    static int h(TJAdUnit tjadunit)
    {
        return tjadunit.h;
    }

    static TJAdUnitJSBridge i(TJAdUnit tjadunit)
    {
        return tjadunit.d;
    }

    static void j(TJAdUnit tjadunit)
    {
        tjadunit.k.cancel();
        tjadunit.k = new Timer();
        tjadunit.k.schedule(tjadunit. new TimerTask() {

            final TJAdUnit a;

            public final void run()
            {
                TJAdUnit.i(a).onVideoProgress(TJAdUnit.f(a).getCurrentPosition());
            }

            
            {
                a = TJAdUnit.this;
                super();
            }
        }, 500L, 500L);
    }

    static Handler k(TJAdUnit tjadunit)
    {
        return tjadunit.s;
    }

    static Timer l(TJAdUnit tjadunit)
    {
        return tjadunit.k;
    }

    static int m(TJAdUnit tjadunit)
    {
        tjadunit.h = 0;
        return 0;
    }

    static TJAdUnitActivity n(TJAdUnit tjadunit)
    {
        return tjadunit.c;
    }

    static boolean o(TJAdUnit tjadunit)
    {
        return tjadunit.q;
    }

    static int p(TJAdUnit tjadunit)
    {
        return tjadunit.l;
    }

    static boolean q(TJAdUnit tjadunit)
    {
        tjadunit.q = true;
        return true;
    }

    static boolean r(TJAdUnit tjadunit)
    {
        return tjadunit.o;
    }

    static void s(TJAdUnit tjadunit)
    {
        tjadunit.d.display();
    }

    public void clearVideo(TJAdUnitJSBridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        if (g != null)
        {
            TapjoyUtil.runOnMainThread(new Runnable(adunitasynctasklistner) {

                final TJAdUnitJSBridge.AdUnitAsyncTaskListner a;
                final TJAdUnit b;

                public final void run()
                {
                    TJAdUnit.l(b).cancel();
                    TJAdUnit.f(b).setVisibility(4);
                    TJAdUnit.f(b).stopPlayback();
                    TJAdUnit.a(b, false);
                    TJAdUnit.m(b);
                    a.onComplete(true);
                }

            
            {
                b = TJAdUnit.this;
                a = adunitasynctasklistner;
                super();
            }
            });
            return;
        } else
        {
            adunitasynctasklistner.onComplete(false);
            return;
        }
    }

    public void closeRequested()
    {
        if (f != null && f.videoPlaying())
        {
            f.videoViewCleanup();
            return;
        } else
        {
            d.closeRequested();
            return;
        }
    }

    public void destroy()
    {
        d.destroy();
        if (e != null)
        {
            e.removeAllViews();
            e = null;
        }
        if (f != null)
        {
            f.removeAllViews();
            f = null;
        }
        k.cancel();
        q = false;
        p = false;
        o = false;
        b = null;
        c = null;
        if (a != null)
        {
            a.onClosed();
        }
    }

    public void fireContentReady()
    {
        if (a != null)
        {
            a.onContentReady();
        }
    }

    public BasicWebView getBackgroundWebView()
    {
        return e;
    }

    public boolean getCloseRequested()
    {
        return d.closeRequested;
    }

    public int getOrientation()
    {
        return r;
    }

    public TJVideoListener getPublisherVideoListener()
    {
        return publisherVideoListener;
    }

    public int getVideoSeekTime()
    {
        return h;
    }

    public VideoView getVideoView()
    {
        return g;
    }

    public MraidView getWebView()
    {
        return f;
    }

    public boolean isAdUnitConstructed()
    {
        return p;
    }

    public boolean isLockedOrientation()
    {
        return n;
    }

    public void load(TJPlacementData tjplacementdata)
    {
        if (!p)
        {
            m = new Runnable(tjplacementdata) {

                final TJPlacementData a;
                final TJAdUnit b;

                public final void run()
                {
                    if (TJAdUnit.a(b))
                    {
                        return;
                    }
                    TJAdUnit.b(b);
                    TJAdUnit.a(b, new BasicWebView(TJAdUnit.c(b)));
                    TJAdUnit.d(b).loadDataWithBaseURL(null, "<!DOCTYPE html><html><head><title>Tapjoy Background Webview</title></head></html>", "text/html", "utf-8", null);
                    TJAdUnit.a(b, new MraidView(TJAdUnit.c(b)));
                    TJAdUnit.e(b).setListener(b. new a((byte)0));
                    TJAdUnit.a(b, new VideoView(TJAdUnit.c(b)));
                    TJAdUnit.f(b).setOnCompletionListener(b);
                    TJAdUnit.f(b).setOnErrorListener(b);
                    TJAdUnit.f(b).setOnPreparedListener(b);
                    TJAdUnit.f(b).setVisibility(4);
                    TJAdUnit.a(b, new TJAdUnitJSBridge(TJAdUnit.c(b), b));
                    if (!cw.c(a.getRedirectURL()))
                    {
                        TJAdUnit.e(b).loadUrl(a.getRedirectURL());
                        return;
                    }
                    if (a.getBaseURL() != null && a.getHttpResponse() != null)
                    {
                        TJAdUnit.e(b).loadDataWithBaseURL(a.getBaseURL(), a.getHttpResponse(), "text/html", "utf-8", null);
                        return;
                    }
                    if (a.getUrl() != null)
                    {
                        TJAdUnit.e(b).loadUrl(a.getUrl());
                        return;
                    } else
                    {
                        TapjoyLog.e("TJAdUnit", "Error loading ad unit content");
                        return;
                    }
                }

            
            {
                b = TJAdUnit.this;
                a = tjplacementdata;
                super();
            }
            };
            TapjoyUtil.runOnMainThread(m);
        }
    }

    public void loadVideoUrl(String s1, TJAdUnitJSBridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        TapjoyUtil.runOnMainThread(new Runnable(s1, adunitasynctasklistner) {

            final String a;
            final TJAdUnitJSBridge.AdUnitAsyncTaskListner b;
            final TJAdUnit c;

            public final void run()
            {
                if (TJAdUnit.f(c) != null)
                {
                    TapjoyLog.i("TJAdUnit", (new StringBuilder("loadVideoUrl: ")).append(a).toString());
                    TJAdUnit.f(c).setVisibility(0);
                    TJAdUnit.f(c).setVideoPath(a);
                    TJAdUnit.f(c).seekTo(0);
                    b.onComplete(true);
                    return;
                } else
                {
                    b.onComplete(false);
                    return;
                }
            }

            
            {
                c = TJAdUnit.this;
                a = s1;
                b = adunitasynctasklistner;
                super();
            }
        });
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        TapjoyLog.i("TJAdUnit", "video -- onCompletion");
        k.cancel();
        if (!i)
        {
            d.onVideoCompletion();
            if (getPublisherVideoListener() != null)
            {
                getPublisherVideoListener().onVideoComplete();
            }
        }
        i = false;
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        TapjoyLog.e("TJAdUnit", (new StringBuilder("video -- onError, what: ")).append(i1).append(" extra: ").append(j1).toString());
        i = true;
        k.cancel();
        i1;
        JVM INSTR tableswitch 100 100: default 64
    //                   100 175;
           goto _L1 _L2
_L1:
        mediaplayer = "MEDIA_ERROR_UNKNOWN";
_L8:
        mediaplayer = (new StringBuilder()).append(mediaplayer).append(" -- ").toString();
        j1;
        JVM INSTR lookupswitch 4: default 132
    //                   -1010: 213
    //                   -1007: 206
    //                   -1004: 182
    //                   -110: 220;
           goto _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_220;
_L3:
        mediaplayer = "MEDIA_ERROR_EXTRA_UNKNOWN";
_L9:
        d.onVideoError(mediaplayer);
        if (getPublisherVideoListener() != null)
        {
            getPublisherVideoListener().onVideoError(3);
        }
        return i1 == 1 || j1 == -1004;
_L2:
        mediaplayer = "MEDIA_ERROR_SERVER_DIED";
          goto _L8
_L6:
        mediaplayer = (new StringBuilder()).append(mediaplayer).append("MEDIA_ERROR_IO").toString();
          goto _L9
_L5:
        mediaplayer = "MEDIA_ERROR_MALFORMED";
          goto _L9
_L4:
        mediaplayer = "MEDIA_ERROR_UNSUPPORTED";
          goto _L9
        mediaplayer = "MEDIA_ERROR_TIMED_OUT";
          goto _L9
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = "";
        i1;
        JVM INSTR lookupswitch 5: default 56
    //                   3: 73
    //                   700: 66
    //                   701: 80
    //                   702: 87
    //                   801: 94;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        d.onVideoInfo(mediaplayer);
        return false;
_L3:
        mediaplayer = "MEDIA_INFO_VIDEO_TRACK_LAGGING";
        continue; /* Loop/switch isn't completed */
_L2:
        mediaplayer = "MEDIA_INFO_VIDEO_RENDERING_START";
        continue; /* Loop/switch isn't completed */
_L4:
        mediaplayer = "MEDIA_INFO_BUFFERING_START";
        continue; /* Loop/switch isn't completed */
_L5:
        mediaplayer = "MEDIA_INFO_BUFFERING_END";
        continue; /* Loop/switch isn't completed */
_L6:
        mediaplayer = "MEDIA_INFO_NOT_SEEKABLE";
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        TapjoyLog.i("TJAdUnit", "video -- onPrepared");
        int i1 = g.getDuration();
        int j1 = g.getMeasuredWidth();
        int k1 = g.getMeasuredHeight();
        if (h > 0 && g.getCurrentPosition() != h)
        {
            mediaplayer.setOnSeekCompleteListener(new android.media.MediaPlayer.OnSeekCompleteListener(i1, j1, k1) {

                final int a;
                final int b;
                final int c;
                final TJAdUnit d;

                public final void onSeekComplete(MediaPlayer mediaplayer1)
                {
                    TJAdUnit.i(d).onVideoReady(a, b, c);
                }

            
            {
                d = TJAdUnit.this;
                a = i1;
                b = j1;
                c = k1;
                super();
            }
            });
        } else
        {
            d.onVideoReady(i1, j1, k1);
        }
        mediaplayer.setOnInfoListener(this);
    }

    public boolean pauseVideo()
    {
        if (g != null && g.isPlaying())
        {
            k.cancel();
            g.pause();
            h = g.getCurrentPosition();
            TapjoyLog.i("TJAdUnit", (new StringBuilder("Video paused at: ")).append(h).toString());
            d.onVideoPaused(h);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean playVideo()
    {
        TapjoyLog.i("TJAdUnit", "playVideo");
        if (g == null)
        {
            return false;
        }
        g.start();
        if (s == null)
        {
            s = new Handler(Looper.getMainLooper());
        }
        s.postDelayed(new Runnable() {

            final TJAdUnit a;

            public final void run()
            {
                if (TJAdUnit.f(a).getCurrentPosition() != 0)
                {
                    if (!TJAdUnit.g(a))
                    {
                        TJAdUnit.a(a, true);
                        if (a.getPublisherVideoListener() != null)
                        {
                            a.getPublisherVideoListener().onVideoStart();
                        }
                    }
                    TJAdUnit.i(a).onVideoStarted(TJAdUnit.h(a));
                    TJAdUnit.j(a);
                    return;
                } else
                {
                    TJAdUnit.k(a).postDelayed(this, 200L);
                    return;
                }
            }

            
            {
                a = TJAdUnit.this;
                super();
            }
        }, 200L);
        return true;
    }

    public boolean preload(TJPlacementData tjplacementdata)
    {
        if (m != null || !tjplacementdata.isPrerenderingRequested() || !TJPlacementManager.canPreRenderPlacement())
        {
            fireContentReady();
            return false;
        } else
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("Pre-rendering ad unit for placement: ")).append(tjplacementdata.getPlacementName()).toString());
            TJPlacementManager.incrementPlacementPreRenderCount();
            load(tjplacementdata);
            return true;
        }
    }

    public void resume(TJAdUnitSaveStateData tjadunitsavestatedata)
    {
        if (l == 0 && d.didLaunchOtherActivity)
        {
            TapjoyLog.i("TJAdUnit", (new StringBuilder("onResume bridge.didLaunchOtherActivity callbackID: ")).append(d.otherActivityCallbackID).toString());
            d.invokeJSCallback(d.otherActivityCallbackID, new Object[] {
                Boolean.TRUE
            });
            d.didLaunchOtherActivity = false;
        }
        if (tjadunitsavestatedata != null)
        {
            h = tjadunitsavestatedata.seekTime;
            g.seekTo(h);
        }
    }

    public void setBackgroundColor(String s1, TJAdUnitJSBridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        TapjoyUtil.runOnMainThread(new Runnable(s1, adunitasynctasklistner) {

            final String a;
            final TJAdUnitJSBridge.AdUnitAsyncTaskListner b;
            final TJAdUnit c;

            public final void run()
            {
                try
                {
                    TapjoyLog.i("TJAdUnit", (new StringBuilder("setBackgroundColor: ")).append(a).toString());
                    TJAdUnit.d(c).setBackgroundColor(Color.parseColor(a));
                    b.onComplete(true);
                    return;
                }
                catch (Exception exception)
                {
                    TapjoyLog.i("TJAdUnit", (new StringBuilder("Error setting background color. backgroundWebView: ")).append(TJAdUnit.d(c)).append(", hexColor: ").append(a).toString());
                }
                b.onComplete(false);
            }

            
            {
                c = TJAdUnit.this;
                a = s1;
                b = adunitasynctasklistner;
                super();
            }
        });
    }

    public void setBackgroundContent(String s1, TJAdUnitJSBridge.AdUnitAsyncTaskListner adunitasynctasklistner)
    {
        TapjoyUtil.runOnMainThread(new Runnable(s1, adunitasynctasklistner) {

            final String a;
            final TJAdUnitJSBridge.AdUnitAsyncTaskListner b;
            final TJAdUnit c;

            public final void run()
            {
                try
                {
                    TapjoyLog.i("TJAdUnit", (new StringBuilder("setBackgroundContent: ")).append(a).toString());
                    TJAdUnit.d(c).loadDataWithBaseURL(null, a, "text/html", "utf-8", null);
                    b.onComplete(true);
                    return;
                }
                catch (Exception exception)
                {
                    TapjoyLog.i("TJAdUnit", (new StringBuilder("Error setting background content. backgroundWebView: ")).append(TJAdUnit.d(c)).append(", content: ").append(a).toString());
                }
                b.onComplete(false);
            }

            
            {
                c = TJAdUnit.this;
                a = s1;
                b = adunitasynctasklistner;
                super();
            }
        });
    }

    public void setContext(Context context)
    {
        b = context;
        if (f != null)
        {
            f.setContext(b);
        }
        if (d != null)
        {
            d.setContext(b);
        }
        if (b instanceof TJAdUnitActivity)
        {
            c = (TJAdUnitActivity)b;
        }
    }

    public void setOrientation(int i1)
    {
        int k1 = 0;
        if (c == null) goto _L2; else goto _L1
_L1:
        if (c == null) goto _L4; else goto _L3
_L3:
        int j1;
        int l1;
        int i2;
        l1 = c.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        c.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        j1 = displaymetrics.widthPixels;
        i2 = displaymetrics.heightPixels;
        if ((l1 != 0 && l1 != 2 || i2 <= j1) && (l1 != 1 && l1 != 3 || j1 <= i2)) goto _L6; else goto _L5
_L5:
        j1 = k1;
        l1;
        JVM INSTR tableswitch 0 3: default 140
    //                   0 216
    //                   1 142
    //                   2 221
    //                   3 227;
           goto _L7 _L8 _L9 _L10 _L11
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        j1 = 1;
_L12:
label0:
        {
            if (r != -1)
            {
                j1 = r;
            }
            if (!a(j1) || !a(i1))
            {
                k1 = i1;
                if (!b(j1))
                {
                    break label0;
                }
                k1 = i1;
                if (!b(i1))
                {
                    break label0;
                }
            }
            k1 = r;
        }
        c.setRequestedOrientation(k1);
        r = k1;
        n = true;
_L2:
        return;
_L8:
        j1 = 1;
        continue; /* Loop/switch isn't completed */
_L10:
        j1 = 9;
        continue; /* Loop/switch isn't completed */
_L11:
        j1 = 8;
        if (true) goto _L12; else goto _L6
_L6:
        j1 = k1;
        switch (l1)
        {
        default:
            TapjoyLog.e("TJAdUnit", "Unknown screen orientation. Defaulting to landscape.");
            j1 = k1;
            break;

        case 1: // '\001'
            j1 = 1;
            break;

        case 2: // '\002'
            j1 = 8;
            break;

        case 3: // '\003'
            j1 = 9;
            break;

        case 0: // '\0'
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        j1 = -1;
        if (true) goto _L12; else goto _L13
_L13:
    }

    public void setViewType(int i1)
    {
        l = i1;
    }

    public void setVisible(boolean flag)
    {
        o = flag;
        if (o && q)
        {
            d.display();
        }
    }

    public void setWebViewListener(TJAdUnitWebViewListener tjadunitwebviewlistener)
    {
        a = tjadunitwebviewlistener;
    }
}
