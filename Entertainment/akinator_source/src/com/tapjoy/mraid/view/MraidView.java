// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCacheMap;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.mraid.controller.Utility;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.tapjoy.mraid.view:
//            BasicWebView, Browser, ActionHandler

public class MraidView extends BasicWebView
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action PLAY_AUDIO;
        public static final Action PLAY_VIDEO;

        public static Action valueOf(String s1)
        {
            return (Action)Enum.valueOf(com/tapjoy/mraid/view/MraidView$Action, s1);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            PLAY_AUDIO = new Action("PLAY_AUDIO", 0);
            PLAY_VIDEO = new Action("PLAY_VIDEO", 1);
            $VALUES = (new Action[] {
                PLAY_AUDIO, PLAY_VIDEO
            });
        }

        private Action(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public static abstract class NewLocationReciever
    {

        public abstract void OnNewLocation(VIEW_STATE view_state);

        public NewLocationReciever()
        {
        }
    }

    public static final class PLACEMENT_TYPE extends Enum
    {

        private static final PLACEMENT_TYPE $VALUES[];
        public static final PLACEMENT_TYPE INLINE;
        public static final PLACEMENT_TYPE INTERSTITIAL;

        public static PLACEMENT_TYPE valueOf(String s1)
        {
            return (PLACEMENT_TYPE)Enum.valueOf(com/tapjoy/mraid/view/MraidView$PLACEMENT_TYPE, s1);
        }

        public static PLACEMENT_TYPE[] values()
        {
            return (PLACEMENT_TYPE[])$VALUES.clone();
        }

        static 
        {
            INLINE = new PLACEMENT_TYPE("INLINE", 0);
            INTERSTITIAL = new PLACEMENT_TYPE("INTERSTITIAL", 1);
            $VALUES = (new PLACEMENT_TYPE[] {
                INLINE, INTERSTITIAL
            });
        }

        private PLACEMENT_TYPE(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    public static final class VIEW_STATE extends Enum
    {

        private static final VIEW_STATE $VALUES[];
        public static final VIEW_STATE DEFAULT;
        public static final VIEW_STATE EXPANDED;
        public static final VIEW_STATE HIDDEN;
        public static final VIEW_STATE LEFT_BEHIND;
        public static final VIEW_STATE OPENED;
        public static final VIEW_STATE RESIZED;

        public static VIEW_STATE valueOf(String s1)
        {
            return (VIEW_STATE)Enum.valueOf(com/tapjoy/mraid/view/MraidView$VIEW_STATE, s1);
        }

        public static VIEW_STATE[] values()
        {
            return (VIEW_STATE[])$VALUES.clone();
        }

        static 
        {
            DEFAULT = new VIEW_STATE("DEFAULT", 0);
            RESIZED = new VIEW_STATE("RESIZED", 1);
            EXPANDED = new VIEW_STATE("EXPANDED", 2);
            HIDDEN = new VIEW_STATE("HIDDEN", 3);
            LEFT_BEHIND = new VIEW_STATE("LEFT_BEHIND", 4);
            OPENED = new VIEW_STATE("OPENED", 5);
            $VALUES = (new VIEW_STATE[] {
                DEFAULT, RESIZED, EXPANDED, HIDDEN, LEFT_BEHIND, OPENED
            });
        }

        private VIEW_STATE(String s1, int i1)
        {
            super(s1, i1);
        }
    }

    final class a extends AsyncTask
    {

        TapjoyHttpURLResponse a;
        TapjoyURLConnection b;
        String c;
        final MraidView d;

        private transient Void a(String as[])
        {
            c = as[0];
            try
            {
                b = new TapjoyURLConnection();
                a = b.getResponseFromURL(c);
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
            }
            return null;
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected final void onPostExecute(Object obj)
        {
            if (a.statusCode == 0 || a.response == null)
            {
                TapjoyLog.e("MRAIDView", "Connection not properly established");
                if (MraidView.a(d) != null)
                {
                    MraidView.a(d).onReceivedError(d, 0, "Connection not properly established", c);
                    return;
                }
                break MISSING_BLOCK_LABEL_192;
            }
            try
            {
                if (a.statusCode == 302 && a.redirectURL != null && a.redirectURL.length() > 0)
                {
                    TapjoyLog.i("MRAIDView", (new StringBuilder("302 redirectURL detected: ")).append(a.redirectURL).toString());
                    d.loadUrlStandard(a.redirectURL);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                TapjoyLog.w("MRAIDView", (new StringBuilder("error in loadURL ")).append(obj).toString());
                ((Exception) (obj)).printStackTrace();
                return;
            }
            d.loadDataWithBaseURL(c, a.response, "text/html", "utf-8", c);
        }

        private a()
        {
            d = MraidView.this;
            super();
        }

        a(byte byte0)
        {
            this();
        }
    }

    final class b
        implements Runnable
    {

        final MraidView a;

        public final void run()
        {
            while (!MraidView.m(a)) 
            {
                try
                {
                    Thread.sleep(250L);
                    MraidView.n(a);
                }
                catch (Exception exception) { }
            }
        }

        public b()
        {
            a = MraidView.this;
            super();
        }
    }

    final class c
        implements Runnable
    {

        final MraidView a;

        public final void run()
        {
            int i1 = 0;
_L2:
            if (MraidView.j(a) == null || MraidView.j(a).isPlaying())
            {
                break MISSING_BLOCK_LABEL_45;
            }
            Thread.sleep(50L);
            int j1 = i1 + 50;
            i1 = j1;
            if (j1 < 10000)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((Activity)MraidView.i(a)).runOnUiThread(new Runnable(this) {

                final c a;

                public final void run()
                {
                    if (MraidView.l(a.a) != null)
                    {
                        MraidView.l(a.a).setVisibility(8);
                    }
                    (new Thread(new c.a(a))).start();
                }

            
            {
                a = c1;
                super();
            }
            });
            return;
            Exception exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public c()
        {
            a = MraidView.this;
            super();
        }
    }

    final class c.a
        implements Runnable
    {

        final c a;
        private boolean b;

        public final void run()
        {
_L5:
            if (MraidView.j(a.a) == null) goto _L2; else goto _L1
_L1:
            Thread.sleep(100L);
            if (b == MraidView.j(a.a).isPlaying()) goto _L4; else goto _L3
_L3:
            b = MraidView.j(a.a).isPlaying();
            String s1;
            if (b)
            {
                s1 = "videoplay";
            } else
            {
                s1 = "videopause";
            }
            try
            {
                a.a.loadUrl((new StringBuilder("javascript:try{Tapjoy.AdUnit.dispatchEvent('")).append(s1).append("')}catch(e){}").toString());
            }
            catch (Exception exception) { }
_L4:
            if (true) goto _L5; else goto _L2
_L2:
        }

        public c.a(c c1)
        {
            a = c1;
            super();
            b = false;
        }
    }

    public static final class customCloseState extends Enum
    {

        private static final customCloseState $VALUES[];
        public static final customCloseState HIDDEN;
        public static final customCloseState OPEN;
        public static final customCloseState UNKNOWN;

        public static customCloseState valueOf(String s1)
        {
            return (customCloseState)Enum.valueOf(com/tapjoy/mraid/view/MraidView$customCloseState, s1);
        }

        public static customCloseState[] values()
        {
            return (customCloseState[])$VALUES.clone();
        }

        static 
        {
            HIDDEN = new customCloseState("HIDDEN", 0);
            OPEN = new customCloseState("OPEN", 1);
            UNKNOWN = new customCloseState("UNKNOWN", 2);
            $VALUES = (new customCloseState[] {
                HIDDEN, OPEN, UNKNOWN
            });
        }

        private customCloseState(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public static final String ACTION_KEY = "action";
    public static final String DIMENSIONS = "expand_dimensions";
    public static final String EXPAND_URL = "expand_url";
    public static final int MRAID_ID = 102;
    public static final String PLAYER_PROPERTIES = "player_properties";
    private static int c[] = {
        0x101011f, 0x1010120
    };
    private static final String d[] = {
        ".mp4", ".3gp", ".mpg"
    };
    private static MraidPlayer t;
    private Context A;
    private RelativeLayout B;
    private VideoView C;
    private android.webkit.WebChromeClient.CustomViewCallback D;
    private ProgressBar E;
    private Handler F = new Handler() {

        final MraidView a;

        public final void handleMessage(Message message)
        {
            Object obj = message.getData();
            message.what;
            JVM INSTR tableswitch 1000 1010: default 68
        //                       1000 100
        //                       1001 541
        //                       1002 626
        //                       1003 646
        //                       1004 666
        //                       1005 74
        //                       1006 677
        //                       1007 702
        //                       1008 691
        //                       1009 713
        //                       1010 311;
               goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
            super.handleMessage(message);
            return;
_L7:
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onExpandClose();
            }
            continue; /* Loop/switch isn't completed */
_L2:
            Object obj1 = (android.view.ViewGroup.MarginLayoutParams)a.getLayoutParams();
            if (obj1 != null)
            {
                a.removeCloseImageButton();
                MraidView.a(a, VIEW_STATE.RESIZED);
                obj1.height = ((Bundle) (obj)).getInt("resize_height", ((android.view.ViewGroup.MarginLayoutParams) (obj1)).height);
                obj1.width = ((Bundle) (obj)).getInt("resize_width", ((android.view.ViewGroup.MarginLayoutParams) (obj1)).width);
                obj1.leftMargin = ((Bundle) (obj)).getInt("resize_x", ((android.view.ViewGroup.MarginLayoutParams) (obj1)).leftMargin);
                obj1.topMargin = ((Bundle) (obj)).getInt("resize_y", ((android.view.ViewGroup.MarginLayoutParams) (obj1)).topMargin);
                obj1 = (new StringBuilder("window.mraidview.fireChangeEvent({ state: 'resized', size: { width: ")).append(((android.view.ViewGroup.MarginLayoutParams) (obj1)).width).append(", height: ").append(((android.view.ViewGroup.MarginLayoutParams) (obj1)).height).append(", x: ").append(((android.view.ViewGroup.MarginLayoutParams) (obj1)).leftMargin).append(", y: ").append(((android.view.ViewGroup.MarginLayoutParams) (obj1)).topMargin).append("}});").toString();
                a.injectMraidJavaScript(((String) (obj1)));
                a.requestLayout();
                MraidView.c(a, ((Bundle) (obj)).getString("resize_customClosePostition"));
                a.showCloseImageButton();
            }
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onResize();
            }
            continue; /* Loop/switch isn't completed */
_L12:
            Object obj2 = (android.view.ViewGroup.MarginLayoutParams)a.getLayoutParams();
            if (obj2 != null)
            {
                a.removeCloseImageButton();
                obj2.height = ((Bundle) (obj)).getInt("resize_height", ((android.view.ViewGroup.MarginLayoutParams) (obj2)).height);
                obj2.width = ((Bundle) (obj)).getInt("resize_width", ((android.view.ViewGroup.MarginLayoutParams) (obj2)).width);
                obj2 = (new StringBuilder("window.mraidview.fireChangeEvent({ state: '")).append(a.getState()).append("', size: { width: ").append((int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj2)).width / MraidView.b(a))).append(", height: ").append((int)((float)((android.view.ViewGroup.MarginLayoutParams) (obj2)).height / MraidView.b(a))).append("}});").toString();
                TapjoyLog.i("MRAIDView", (new StringBuilder("resize: injection: ")).append(((String) (obj2))).toString());
                a.injectMraidJavaScript(((String) (obj2)));
                a.requestLayout();
                MraidView.c(a, ((Bundle) (obj)).getString("resize_customClosePostition"));
                if (MraidView.c(a) != PLACEMENT_TYPE.INLINE && MraidView.d(a) == customCloseState.OPEN)
                {
                    a.showCloseImageButton();
                }
            }
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onResize();
            }
            continue; /* Loop/switch isn't completed */
_L3:
            static final class _cls7
            {

                static final int a[];

                static 
                {
                    a = new int[VIEW_STATE.values().length];
                    try
                    {
                        a[VIEW_STATE.RESIZED.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        a[VIEW_STATE.EXPANDED.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[VIEW_STATE.DEFAULT.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls7.a[MraidView.e(a).ordinal()])
            {
            case 1: // '\001'
                MraidView.f(a);
                break;

            case 2: // '\002'
                a.a();
                break;

            case 3: // '\003'
                if (MraidView.c(a) != PLACEMENT_TYPE.INLINE)
                {
                    MraidView.g(a);
                }
                break;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            a.setVisibility(4);
            a.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: 'hidden' });");
            continue; /* Loop/switch isn't completed */
_L5:
            a.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: 'default' });");
            a.setVisibility(0);
            continue; /* Loop/switch isn't completed */
_L6:
            MraidView.a(a, ((Bundle) (obj)));
            continue; /* Loop/switch isn't completed */
_L8:
            MraidView.a(a, VIEW_STATE.LEFT_BEHIND);
            continue; /* Loop/switch isn't completed */
_L10:
            a.playAudioImpl(((Bundle) (obj)));
            continue; /* Loop/switch isn't completed */
_L9:
            a.playVideoImpl(((Bundle) (obj)));
            continue; /* Loop/switch isn't completed */
_L11:
            String s1 = ((Bundle) (obj)).getString("message");
            obj = ((Bundle) (obj)).getString("action");
            obj = (new StringBuilder("window.mraidview.fireErrorEvent(\"")).append(s1).append("\", \"").append(((String) (obj))).append("\")").toString();
            a.injectMraidJavaScript(((String) (obj)));
            if (true) goto _L1; else goto _L13
_L13:
        }

            
            {
                a = MraidView.this;
                super();
            }
    };
    private boolean G;
    WebViewClient a = new WebViewClient() {

        final MraidView a;

        public final void onLoadResource(WebView webview, String s1)
        {
        }

        public final void onPageFinished(WebView webview, String s1)
        {
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onPageFinished(webview, s1);
            }
            MraidView.a(a, (int)((float)a.getHeight() / MraidView.b(a)));
            MraidView.b(a, (int)((float)a.getWidth() / MraidView.b(a)));
            MraidView.h(a).init(MraidView.b(a));
            a.createCloseImageButton();
            if (MraidView.c(a) == PLACEMENT_TYPE.INLINE)
            {
                a.removeCloseImageButton();
            }
        }

        public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onPageStarted(webview, s1, bitmap);
            }
        }

        public final void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            if (MraidView.a(a) != null)
            {
                MraidView.a(a).onReceivedError(webview, i1, s1, s2);
            }
            TapjoyLog.d("MRAIDView", (new StringBuilder("error:")).append(s1).toString());
            super.onReceivedError(webview, i1, s1, s2);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webview, String s1)
        {
            if (TapjoyCache.getInstance() != null)
            {
                TapjoyCacheMap tapjoycachemap = TapjoyCache.getInstance().getCachedData();
                if (tapjoycachemap.containsKey(s1))
                {
                    if ((new File(((TapjoyCachedAssetData)tapjoycachemap.get(s1)).getLocalFilePath())).exists())
                    {
                        Object obj = a;
                        obj = MraidView.a(s1);
                        if (obj != null)
                        {
                            return ((WebResourceResponse) (obj));
                        }
                    } else
                    {
                        TapjoyCache.getInstance().removeAssetFromCache(s1);
                    }
                }
            }
            return super.shouldInterceptRequest(webview, s1);
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
            Uri uri;
            TapjoyLog.i("MRAIDView", (new StringBuilder("shouldOverrideUrlLoading: ")).append(s1).toString());
            if (MraidView.a(a) != null && MraidView.a(a).shouldOverrideUrlLoading(webview, s1))
            {
                return true;
            }
            uri = Uri.parse(s1);
            if (s1.startsWith("mraid"))
            {
                return super.shouldOverrideUrlLoading(webview, s1);
            }
            if (!s1.startsWith("tel:"))
            {
                break MISSING_BLOCK_LABEL_160;
            }
            webview = new Intent("android.intent.action.DIAL", Uri.parse(s1));
            webview.addFlags(0x10000000);
            a.getContext().startActivity(webview);
            return true;
            if (!s1.startsWith("mailto:"))
            {
                break MISSING_BLOCK_LABEL_203;
            }
            webview = new Intent("android.intent.action.VIEW", Uri.parse(s1));
            webview.addFlags(0x10000000);
            a.getContext().startActivity(webview);
            return true;
            try
            {
                webview = new Intent();
                webview.setAction("android.intent.action.VIEW");
                webview.setData(uri);
                webview.addFlags(0x10000000);
                a.getContext().startActivity(webview);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                try
                {
                    webview = new Intent();
                    webview.setAction("android.intent.action.VIEW");
                    webview.setData(uri);
                    webview.addFlags(0x10000000);
                    a.getContext().startActivity(webview);
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    return false;
                }
                return true;
            }
            return true;
        }

            
            {
                a = MraidView.this;
                super();
            }
    };
    WebChromeClient b = new WebChromeClient() {

        final MraidView a;

        public final void onCloseWindow(WebView webview)
        {
            super.onCloseWindow(webview);
            MraidView.g(a);
        }

        public final boolean onConsoleMessage(ConsoleMessage consolemessage)
        {
            if (MraidView.a(a) != null)
            {
                return MraidView.a(a).onConsoleMessage(consolemessage);
            } else
            {
                return super.onConsoleMessage(consolemessage);
            }
        }

        public final void onHideCustomView()
        {
            super.onHideCustomView();
        }

        public final boolean onJsAlert(WebView webview, String s1, String s2, JsResult jsresult)
        {
            TapjoyLog.d("MRAIDView", s2);
            return false;
        }

        public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
        {
label0:
            {
                TapjoyLog.i("MRAIDView", "-- onShowCustomView --");
                super.onShowCustomView(view, customviewcallback);
                MraidView.a(a, customviewcallback);
                if (view instanceof FrameLayout)
                {
                    customviewcallback = (FrameLayout)view;
                    if ((customviewcallback.getFocusedChild() instanceof VideoView) && (MraidView.i(a) instanceof Activity))
                    {
                        break label0;
                    }
                }
                return;
            }
            view = (Activity)MraidView.i(a);
            MraidView.a(a, (VideoView)customviewcallback.getFocusedChild());
            customviewcallback.removeView(MraidView.j(a));
            if (MraidView.k(a) == null)
            {
                MraidView.a(a, new RelativeLayout(MraidView.i(a)));
                MraidView.k(a).setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
                MraidView.k(a).setBackgroundColor(0xff000000);
            }
            customviewcallback = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            customviewcallback.addRule(13);
            MraidView.j(a).setLayoutParams(customviewcallback);
            MraidView.a(a, new ProgressBar(MraidView.i(a), null, 0x101007a));
            MraidView.l(a).setVisibility(0);
            customviewcallback = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            customviewcallback.addRule(13);
            MraidView.l(a).setLayoutParams(customviewcallback);
            MraidView.k(a).addView(MraidView.j(a));
            MraidView.k(a).addView(MraidView.l(a));
            view.getWindow().addContentView(MraidView.k(a), new android.view.ViewGroup.LayoutParams(-1, -1));
            (new Thread(a. new c())).start();
            a.setVisibility(8);
            MraidView.j(a).setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener(this) {

                final _cls5 a;

                public final void onPrepared(MediaPlayer mediaplayer)
                {
                    TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                    TapjoyLog.i("MRAIDView", (new StringBuilder("isPlaying: ")).append(mediaplayer.isPlaying()).toString());
                    if (!mediaplayer.isPlaying())
                    {
                        mediaplayer.start();
                    }
                }

            
            {
                a = _pcls5;
                super();
            }
            });
            MraidView.j(a).setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener(this) {

                final _cls5 a;

                public final void onCompletion(MediaPlayer mediaplayer)
                {
                    TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                    a.a.videoViewCleanup();
                }

            
            {
                a = _pcls5;
                super();
            }
            });
            MraidView.j(a).setOnErrorListener(new android.media.MediaPlayer.OnErrorListener(this) {

                final _cls5 a;

                public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
                {
                    TapjoyLog.i("MRAIDView", "** ON ERROR **");
                    a.a.videoViewCleanup();
                    return false;
                }

            
            {
                a = _pcls5;
                super();
            }
            });
            MraidView.j(a).start();
        }

            
            {
                a = MraidView.this;
                super();
            }
    };
    private customCloseState e;
    private boolean f;
    private boolean g;
    private Utility h;
    private float i;
    private int j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private PLACEMENT_TYPE q;
    private VIEW_STATE r;
    private MraidViewListener s;
    private final HashSet u;
    private int v;
    private int w;
    private Thread x;
    private boolean y;
    private int z;

    public MraidView(Context context)
    {
        super(context);
        e = customCloseState.UNKNOWN;
        f = false;
        r = VIEW_STATE.DEFAULT;
        u = new HashSet();
        v = 0;
        w = 0;
        x = null;
        y = false;
        A = context;
        initialize();
    }

    public MraidView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        e = customCloseState.UNKNOWN;
        f = false;
        r = VIEW_STATE.DEFAULT;
        u = new HashSet();
        v = 0;
        w = 0;
        x = null;
        y = false;
        initialize();
        context = getContext().obtainStyledAttributes(attributeset, c);
        int i1 = context.getDimensionPixelSize(0, -1);
        int j1 = context.getDimensionPixelSize(1, -1);
        if (i1 > 0 && j1 > 0)
        {
            h.setMaxSize(i1, j1);
        }
        context.recycle();
    }

    public MraidView(Context context, MraidViewListener mraidviewlistener)
    {
        super(context);
        e = customCloseState.UNKNOWN;
        f = false;
        r = VIEW_STATE.DEFAULT;
        u = new HashSet();
        v = 0;
        w = 0;
        x = null;
        y = false;
        setListener(mraidviewlistener);
        A = context;
        initialize();
    }

    static int a(MraidView mraidview, int i1)
    {
        mraidview.l = i1;
        return i1;
    }

    static android.webkit.WebChromeClient.CustomViewCallback a(MraidView mraidview, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        mraidview.D = customviewcallback;
        return customviewcallback;
    }

    static WebResourceResponse a(String s1)
    {
        return c(s1);
    }

    static ProgressBar a(MraidView mraidview, ProgressBar progressbar)
    {
        mraidview.E = progressbar;
        return progressbar;
    }

    static RelativeLayout a(MraidView mraidview, RelativeLayout relativelayout)
    {
        mraidview.B = relativelayout;
        return relativelayout;
    }

    static VideoView a(MraidView mraidview, VideoView videoview)
    {
        mraidview.C = videoview;
        return videoview;
    }

    static MraidViewListener a(MraidView mraidview)
    {
        return mraidview.s;
    }

    static VIEW_STATE a(MraidView mraidview, VIEW_STATE view_state)
    {
        mraidview.r = view_state;
        return view_state;
    }

    static void a(MraidView mraidview, Bundle bundle)
    {
        if (mraidview.r != VIEW_STATE.EXPANDED)
        {
            com.tapjoy.mraid.controller.Abstract.Dimensions dimensions = (com.tapjoy.mraid.controller.Abstract.Dimensions)bundle.getParcelable("expand_dimensions");
            Object obj = bundle.getString("expand_url");
            bundle = (com.tapjoy.mraid.controller.Abstract.Properties)bundle.getParcelable("expand_properties");
            if (URLUtil.isValidUrl(((String) (obj))))
            {
                mraidview.loadUrl(((String) (obj)));
            }
            obj = (FrameLayout)mraidview.getRootView().findViewById(0x1020002);
            Object obj1 = (ViewGroup)mraidview.getParent();
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
            layoutparams.topMargin = dimensions.x;
            layoutparams.leftMargin = dimensions.y;
            int j1 = ((ViewGroup) (obj1)).getChildCount();
            int i1;
            for (i1 = 0; i1 < j1 && ((ViewGroup) (obj1)).getChildAt(i1) != mraidview; i1++) { }
            mraidview.p = i1;
            Object obj2 = new FrameLayout(mraidview.getContext());
            ((FrameLayout) (obj2)).setId(100);
            ((ViewGroup) (obj1)).addView(((View) (obj2)), i1, new android.view.ViewGroup.LayoutParams(mraidview.getWidth(), mraidview.getHeight()));
            ((ViewGroup) (obj1)).removeView(mraidview);
            obj1 = new FrameLayout(mraidview.getContext());
            ((FrameLayout) (obj1)).setOnTouchListener(mraidview. new android.view.View.OnTouchListener() {

                final MraidView a;

                public final boolean onTouch(View view, MotionEvent motionevent)
                {
                    TapjoyLog.i("MRAIDView", "background touch called");
                    return true;
                }

            
            {
                a = MraidView.this;
                super();
            }
            });
            obj2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
            ((FrameLayout) (obj1)).setId(101);
            ((FrameLayout) (obj1)).setPadding(dimensions.x, dimensions.y, 0, 0);
            ((FrameLayout) (obj1)).addView(mraidview, layoutparams);
            ((FrameLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
            if (((com.tapjoy.mraid.controller.Abstract.Properties) (bundle)).useBackground)
            {
                ((FrameLayout) (obj1)).setBackgroundColor(((com.tapjoy.mraid.controller.Abstract.Properties) (bundle)).backgroundColor | (int)(((com.tapjoy.mraid.controller.Abstract.Properties) (bundle)).backgroundOpacity * 255F) * 0x10000000);
            }
            if (!((com.tapjoy.mraid.controller.Abstract.Properties) (bundle)).useCustomClose)
            {
                mraidview.showCloseImageButton();
            }
            bundle = (new StringBuilder("window.mraidview.fireChangeEvent({ state: 'expanded', size: { width: ")).append((int)((float)dimensions.width / mraidview.i)).append(", height: ").append((int)((float)dimensions.height / mraidview.i)).append(",x:0,y:0} });").toString();
            TapjoyLog.d("MRAIDView", (new StringBuilder("doExpand: injection: ")).append(bundle).toString());
            mraidview.injectMraidJavaScript(bundle);
            mraidview.r = VIEW_STATE.EXPANDED;
            mraidview.c();
            if (mraidview.s != null)
            {
                mraidview.s.onExpand();
            }
        }
    }

    static void a(MraidView mraidview, String s1)
    {
        mraidview.WebView.evaluateJavascript(s1, null);
    }

    static float b(MraidView mraidview)
    {
        return mraidview.i;
    }

    static int b(MraidView mraidview, int i1)
    {
        mraidview.m = i1;
        return i1;
    }

    private void b()
    {
        r = VIEW_STATE.DEFAULT;
        if (s != null)
        {
            s.onResizeClose();
        }
        String s1 = (new StringBuilder("window.mraidview.fireChangeEvent({ state: 'default', size: { width: ")).append(m).append(", height: ").append(l).append(", x:0,y:0}});").toString();
        TapjoyLog.d("MRAIDView", (new StringBuilder("closeResized: injection: ")).append(s1).toString());
        injectMraidJavaScript(s1);
        b("top-right");
        d();
    }

    static void b(MraidView mraidview, String s1)
    {
        mraidview.WebView.loadUrl(s1);
    }

    private void b(String s1)
    {
        if (s1 == null)
        {
            return;
        }
        String s2 = null;
        if (s1.equals("top-right"))
        {
            s2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
        } else
        if (s1.equals("top-center"))
        {
            s2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
        } else
        if (s1.equals("top-left"))
        {
            s2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = 1";
        } else
        if (s1.equals("center"))
        {
            s2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
        } else
        if (s1.equals("bottom-right"))
        {
            s2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
        } else
        if (s1.equals("bottom-left"))
        {
            s2 = "document.getElementById(\"closeButton\").style.left = 1;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
        } else
        if (s1.equals("bottom-center"))
        {
            s2 = "document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 -18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
        }
        if (s2 != null)
        {
            injectMraidJavaScript(s2);
            return;
        } else
        {
            TapjoyLog.d("MRAIDView", "Reposition of close button failed.");
            return;
        }
    }

    private static WebResourceResponse c(String s1)
    {
        s1 = TapjoyCache.getInstance().getCachedDataForURL(s1);
        if (s1 == null)
        {
            return null;
        }
        try
        {
            FileInputStream fileinputstream = new FileInputStream(s1.getLocalFilePath());
            s1 = new WebResourceResponse(s1.getMimeType(), "UTF-8", fileinputstream);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return s1;
    }

    static PLACEMENT_TYPE c(MraidView mraidview)
    {
        return mraidview.q;
    }

    private void c()
    {
        WindowManager windowmanager = (WindowManager)getContext().getSystemService("window");
        int i1 = windowmanager.getDefaultDisplay().getWidth();
        int j1 = windowmanager.getDefaultDisplay().getHeight();
        if ((i1 != v || j1 != w) && (getPlacementType() == PLACEMENT_TYPE.INLINE && getViewState() == VIEW_STATE.EXPANDED || getPlacementType() == PLACEMENT_TYPE.INTERSTITIAL))
        {
            resizeOrientation(i1, j1, "top-right", true);
        }
    }

    static void c(MraidView mraidview, String s1)
    {
        mraidview.b(s1);
    }

    static customCloseState d(MraidView mraidview)
    {
        return mraidview.e;
    }

    private void d()
    {
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        if (G)
        {
            layoutparams.height = n;
            layoutparams.width = o;
        }
        setVisibility(0);
        requestLayout();
    }

    private static boolean d(String s1)
    {
        boolean flag1 = false;
        String as[] = d;
        int j1 = as.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (!s1.endsWith(as[i1]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    static VIEW_STATE e(MraidView mraidview)
    {
        return mraidview.r;
    }

    static void f(MraidView mraidview)
    {
        mraidview.b();
    }

    static void g(MraidView mraidview)
    {
        try
        {
            if (mraidview.s != null)
            {
                mraidview.s.onClose();
            }
            ((ViewGroup)(ViewGroup)mraidview.getParent()).removeView(mraidview);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MraidView mraidview)
        {
            return;
        }
    }

    private int getContentViewHeight()
    {
        View view = getRootView().findViewById(0x1020002);
        if (view != null)
        {
            return view.getHeight();
        } else
        {
            return -1;
        }
    }

    static Utility h(MraidView mraidview)
    {
        return mraidview.h;
    }

    static Context i(MraidView mraidview)
    {
        return mraidview.A;
    }

    static VideoView j(MraidView mraidview)
    {
        return mraidview.C;
    }

    static RelativeLayout k(MraidView mraidview)
    {
        return mraidview.B;
    }

    static ProgressBar l(MraidView mraidview)
    {
        return mraidview.E;
    }

    static boolean m(MraidView mraidview)
    {
        return mraidview.y;
    }

    static void n(MraidView mraidview)
    {
        mraidview.c();
    }

    protected final void a()
    {
        this;
        JVM INSTR monitorenter ;
        resetContents();
        String s1 = (new StringBuilder("window.mraidview.fireChangeEvent({ state: 'default', size: { width: ")).append(m).append(", height: ").append(l).append("}});").toString();
        TapjoyLog.d("MRAIDView", (new StringBuilder("closeExpanded: injection: ")).append(s1).toString());
        injectMraidJavaScript(s1);
        r = VIEW_STATE.DEFAULT;
        F.sendEmptyMessage(1005);
        setVisibility(0);
        removeCloseImageButton();
        ((Activity)getContext()).setRequestedOrientation(z);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void addJavascriptObject(Object obj, String s1)
    {
        addJavascriptInterface(obj, s1);
    }

    public void clearView()
    {
        reset();
        super.clearView();
    }

    public void close()
    {
        F.sendEmptyMessage(1001);
    }

    public void createCloseImageButton()
    {
        injectMraidJavaScript("window.mraidview.createCss();");
        TapjoyLog.d("MRAIDView", "Creating close button.");
    }

    public void expand(com.tapjoy.mraid.controller.Abstract.Dimensions dimensions, String s1, com.tapjoy.mraid.controller.Abstract.Properties properties)
    {
        Message message = F.obtainMessage(1004);
        Bundle bundle = new Bundle();
        bundle.putParcelable("expand_dimensions", dimensions);
        bundle.putString("expand_url", s1);
        bundle.putParcelable("expand_properties", properties);
        message.setData(bundle);
        F.sendMessage(message);
    }

    public customCloseState getCloseButtonState()
    {
        return e;
    }

    public ConnectivityManager getConnectivityManager()
    {
        return (ConnectivityManager)getContext().getSystemService("connectivity");
    }

    public PLACEMENT_TYPE getPlacementType()
    {
        return q;
    }

    MraidPlayer getPlayer()
    {
        if (t != null)
        {
            t.releasePlayer();
        }
        MraidPlayer mraidplayer = new MraidPlayer(getContext());
        t = mraidplayer;
        return mraidplayer;
    }

    public String getSize()
    {
        return (new StringBuilder("{ width: ")).append((int)Math.ceil((float)getWidth() / i)).append(", height: ").append((int)Math.ceil((float)getHeight() / i)).append("}").toString();
    }

    public String getState()
    {
        return r.toString().toLowerCase();
    }

    public VIEW_STATE getViewState()
    {
        return r;
    }

    public boolean hasMraidTag(String s1)
    {
        return Pattern.compile("<\\s*script[^>]+mraid\\.js").matcher(s1).find();
    }

    public void hide()
    {
        F.sendEmptyMessage(1002);
    }

    public void initialize()
    {
        setPlacementType(PLACEMENT_TYPE.INTERSTITIAL);
        Object obj = new DisplayMetrics();
        ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        i = ((DisplayMetrics) (obj)).density;
        g = false;
        h = new Utility(this, getContext());
        addJavascriptInterface(h, "MRAIDUtilityControllerBridge");
        setWebViewClient(a);
        setWebChromeClient(b);
        j = getContentViewHeight();
        if (getViewTreeObserver() != null)
        {
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
        obj = (WindowManager)getContext().getSystemService("window");
        v = ((WindowManager) (obj)).getDefaultDisplay().getWidth();
        w = ((WindowManager) (obj)).getDefaultDisplay().getHeight();
        if (getContext() instanceof Activity)
        {
            z = ((Activity)getContext()).getRequestedOrientation();
        }
    }

    public void injectMraidJavaScript(String s1)
    {
        if (s1 != null && f)
        {
            loadUrl((new StringBuilder("javascript:")).append(s1).toString());
        }
    }

    public boolean isExpanded()
    {
        return r == VIEW_STATE.EXPANDED;
    }

    public boolean isMraid()
    {
        return f;
    }

    public boolean isPageFinished()
    {
        return g;
    }

    public void loadDataWithBaseURL(String s1, String s2, String s3, String s4, String s5)
    {
        StringBuffer stringbuffer;
        int i1;
        int i2;
        if (s2 == null)
        {
            return;
        }
        stringbuffer = new StringBuffer();
        i2 = s2.indexOf("<html>");
        f = false;
        i1 = s2.indexOf("mraid.js");
        if (i1 <= 0 || !hasMraidTag(s2)) goto _L2; else goto _L1
_L1:
        int j1;
        f = true;
        j1 = i1;
_L5:
        if (j1 < 0)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        if (!s2.substring(j1, j1 + 7).equals("<script")) goto _L4; else goto _L3
_L3:
        int k1 = j1;
_L8:
        int l1 = 0;
_L6:
        j1 = i1;
        if (l1 < s2.length())
        {
            if (s2.substring(i1 + l1, i1 + l1 + 2).equalsIgnoreCase("/>"))
            {
                j1 = i1 + l1 + 2;
            } else
            {
label0:
                {
                    if (!s2.substring(i1 + l1, i1 + l1 + 9).equalsIgnoreCase("</script>"))
                    {
                        break label0;
                    }
                    j1 = i1 + l1 + 9;
                }
            }
        }
        if (i2 < 0)
        {
            TapjoyLog.d("MRAIDView", "wrapping fragment");
            stringbuffer.append("<html>");
            stringbuffer.append("<head>");
            stringbuffer.append("<meta name='viewport' content='user-scalable=no initial-scale=1.0' />");
            stringbuffer.append("<title>Advertisement</title>");
            stringbuffer.append("</head>");
            stringbuffer.append("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;\">");
            stringbuffer.append("<div align=\"center\"> ");
            stringbuffer.append(s2.substring(0, k1));
            stringbuffer.append("<script type=text/javascript>");
            String s8 = (String)TapjoyUtil.getResource("mraid.js");
            String s6 = s8;
            if (s8 == null)
            {
                s6 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", getContext());
            }
            stringbuffer.append(s6);
            stringbuffer.append("</script>");
            stringbuffer.append(s2.substring(j1));
        } else
        {
            i1 = s2.indexOf("<head>");
            if (i1 != -1)
            {
                String s9 = (String)TapjoyUtil.getResource("mraid.js");
                String s7 = s9;
                if (s9 == null)
                {
                    s7 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", getContext());
                }
                stringbuffer.append(s2.substring(0, i1 + 6));
                stringbuffer.append("<script type='text/javascript'>");
                stringbuffer.append(s7);
                stringbuffer.append("</script>");
                stringbuffer.append(s2.substring(i1 + 6));
            }
        }
        TapjoyLog.d("MRAIDView", "injected js/mraid.js");
_L7:
        super.loadDataWithBaseURL(s1, stringbuffer.toString(), s3, s4, s5);
        return;
_L4:
        j1--;
          goto _L5
        l1++;
          goto _L6
_L2:
        stringbuffer.append(s2);
          goto _L7
        k1 = i1;
          goto _L8
    }

    public void loadUrl(String s1)
    {
        ((Activity)A).runOnUiThread(new Runnable(s1) {

            final String a;
            final MraidView b;

            public final void run()
            {
                if (URLUtil.isValidUrl(a))
                {
                    if (a.startsWith("javascript:"))
                    {
                        if (android.os.Build.VERSION.SDK_INT >= 19)
                        {
                            try
                            {
                                String s2 = a.replaceFirst("javascript:", "");
                                MraidView.a(b, s2);
                                return;
                            }
                            catch (Exception exception)
                            {
                                TapjoyLog.e("MRAIDView", (new StringBuilder("Exception in evaluateJavascript. Device not supported. ")).append(exception.toString()).toString());
                            }
                            return;
                        } else
                        {
                            MraidView.b(b, a);
                            return;
                        }
                    } else
                    {
                        (b. new a((byte)0)).execute(new String[] {
                            a
                        });
                        return;
                    }
                } else
                {
                    b.loadDataWithBaseURL(null, "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Connection not Established</title></head><h2>Connection Not Properly Established</h2><body></body></html>", "text/html", "utf-8", null);
                    return;
                }
            }

            
            {
                b = MraidView.this;
                a = s1;
                super();
            }
        });
    }

    public void loadUrlStandard(String s1)
    {
        super.loadUrl(s1);
    }

    protected void onAttachedToWindow()
    {
        if (!G)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            n = layoutparams.height;
            o = layoutparams.width;
            G = true;
        }
        y = false;
        if (x == null || !x.isAlive())
        {
            x = new Thread(new b());
            x.start();
        }
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow()
    {
        y = true;
        h.stopAllListeners();
        try
        {
            if (C != null)
            {
                C.stopPlayback();
            }
            if (D != null)
            {
                D.onCustomViewHidden();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        super.onDetachedFromWindow();
    }

    public void onGlobalLayout()
    {
        boolean flag1 = k;
        boolean flag = flag1;
        if (!k)
        {
            flag = flag1;
            if (j >= 0)
            {
                flag = flag1;
                if (getContentViewHeight() >= 0)
                {
                    flag = flag1;
                    if (j != getContentViewHeight())
                    {
                        flag = true;
                        injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: true});");
                    }
                }
            }
        }
        flag1 = flag;
        if (k)
        {
            flag1 = flag;
            if (j >= 0)
            {
                flag1 = flag;
                if (getContentViewHeight() >= 0)
                {
                    flag1 = flag;
                    if (j == getContentViewHeight())
                    {
                        flag1 = false;
                        injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: false});");
                    }
                }
            }
        }
        if (j < 0)
        {
            j = getContentViewHeight();
        }
        k = flag1;
    }

    public void open(String s1, boolean flag, boolean flag1, boolean flag2)
    {
        Object obj = null;
        boolean flag3;
        if (d(s1))
        {
            obj = s1;
            flag3 = true;
        } else
        {
            TapjoyHttpURLResponse tapjoyhttpurlresponse = (new TapjoyURLConnection()).getRedirectFromURL(s1);
            TapjoyLog.i("MRAIDView", (new StringBuilder("redirect: ")).append(tapjoyhttpurlresponse.redirectURL).append(", ").append(tapjoyhttpurlresponse.statusCode).toString());
            if (tapjoyhttpurlresponse != null && tapjoyhttpurlresponse.redirectURL != null && tapjoyhttpurlresponse.redirectURL.length() > 0 && d(tapjoyhttpurlresponse.redirectURL))
            {
                obj = tapjoyhttpurlresponse.redirectURL;
                flag3 = true;
            } else
            {
                flag3 = false;
            }
        }
        if (flag3)
        {
            s1 = new com.tapjoy.mraid.controller.Abstract.Dimensions();
            s1.x = 0;
            s1.y = 0;
            s1.width = getWidth();
            s1.height = getHeight();
            playVideo(((String) (obj)), false, true, true, false, s1, "fullscreen", "exit");
            return;
        } else
        {
            TapjoyLog.d("MRAIDView", (new StringBuilder("Mraid Browser open:")).append(s1).toString());
            obj = new Intent(getContext(), com/tapjoy/mraid/view/Browser);
            ((Intent) (obj)).putExtra("extra_url", s1);
            ((Intent) (obj)).putExtra("open_show_back", flag);
            ((Intent) (obj)).putExtra("open_show_forward", flag1);
            ((Intent) (obj)).putExtra("open_show_refresh", flag2);
            ((Intent) (obj)).addFlags(0x10000000);
            getContext().startActivity(((Intent) (obj)));
            return;
        }
    }

    public void openMap(String s1, boolean flag)
    {
        TapjoyLog.d("MRAIDView", (new StringBuilder("Opening Map Url ")).append(s1).toString());
        s1 = Utils.convert(s1.trim());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s1 = new Intent("android.intent.action.VIEW", Uri.parse(s1));
        s1.setFlags(0x10000000);
        getContext().startActivity(s1);
        return;
        s1;
        s1.printStackTrace();
        return;
    }

    public void playAudio(String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s2, String s3)
    {
        com.tapjoy.mraid.controller.Abstract.PlayerProperties playerproperties = new com.tapjoy.mraid.controller.Abstract.PlayerProperties();
        playerproperties.setProperties(false, flag, flag1, flag3, flag2, s2, s3);
        s2 = new Bundle();
        s2.putString("action", Action.PLAY_AUDIO.toString());
        s2.putString("expand_url", s1);
        s2.putParcelable("player_properties", playerproperties);
        if (playerproperties.isFullScreen())
        {
            try
            {
                s1 = new Intent(getContext(), com/tapjoy/mraid/view/ActionHandler);
                s1.putExtras(s2);
                getContext().startActivity(s1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1.printStackTrace();
            }
            return;
        } else
        {
            s1 = F.obtainMessage(1008);
            s1.setData(s2);
            F.sendMessage(s1);
            return;
        }
    }

    public void playAudioImpl(Bundle bundle)
    {
        com.tapjoy.mraid.controller.Abstract.PlayerProperties playerproperties = (com.tapjoy.mraid.controller.Abstract.PlayerProperties)bundle.getParcelable("player_properties");
        bundle = bundle.getString("expand_url");
        MraidPlayer mraidplayer = getPlayer();
        mraidplayer.setPlayData(playerproperties, bundle);
        mraidplayer.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, 1));
        ((ViewGroup)getParent()).addView(mraidplayer);
        mraidplayer.playAudio();
    }

    public void playVideo(String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, com.tapjoy.mraid.controller.Abstract.Dimensions dimensions, String s2, 
            String s3)
    {
        Message message;
        message = F.obtainMessage(1007);
        com.tapjoy.mraid.controller.Abstract.PlayerProperties playerproperties = new com.tapjoy.mraid.controller.Abstract.PlayerProperties();
        playerproperties.setProperties(flag, flag1, flag2, false, flag3, s2, s3);
        s2 = new Bundle();
        s2.putString("expand_url", s1);
        s2.putString("action", Action.PLAY_VIDEO.toString());
        s2.putParcelable("player_properties", playerproperties);
        if (dimensions != null)
        {
            s2.putParcelable("expand_dimensions", dimensions);
        }
        if (!playerproperties.isFullScreen())
        {
            break MISSING_BLOCK_LABEL_143;
        }
        s1 = new Intent(getContext(), com/tapjoy/mraid/view/ActionHandler);
        s1.putExtras(s2);
        s1.setFlags(0x10000000);
        getContext().startActivity(s1);
_L1:
        return;
        s1;
        s1.printStackTrace();
        return;
        if (dimensions != null)
        {
            message.setData(s2);
            F.sendMessage(message);
            return;
        }
          goto _L1
    }

    public void playVideoImpl(Bundle bundle)
    {
        Object obj = (com.tapjoy.mraid.controller.Abstract.PlayerProperties)bundle.getParcelable("player_properties");
        com.tapjoy.mraid.controller.Abstract.Dimensions dimensions = (com.tapjoy.mraid.controller.Abstract.Dimensions)bundle.getParcelable("expand_dimensions");
        String s1 = bundle.getString("expand_url");
        bundle = getPlayer();
        bundle.setPlayData(((com.tapjoy.mraid.controller.Abstract.PlayerProperties) (obj)), s1);
        obj = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
        obj.topMargin = dimensions.x;
        obj.leftMargin = dimensions.y;
        bundle.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new FrameLayout(getContext());
        ((FrameLayout) (obj)).setId(101);
        ((FrameLayout) (obj)).setPadding(dimensions.x, dimensions.y, 0, 0);
        ((FrameLayout)getRootView().findViewById(0x1020002)).addView(((View) (obj)), new android.widget.FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout) (obj)).addView(bundle);
        setVisibility(4);
        bundle.setListener(new Player() {

            final MraidView a;

            public final void onComplete()
            {
                FrameLayout framelayout = (FrameLayout)a.getRootView().findViewById(101);
                ((ViewGroup)framelayout.getParent()).removeView(framelayout);
                a.setVisibility(0);
            }

            public final void onError()
            {
                onComplete();
            }

            public final void onPrepared()
            {
            }

            
            {
                a = MraidView.this;
                super();
            }
        });
        bundle.playVideo();
    }

    public void raiseError(String s1, String s2)
    {
        Message message = F.obtainMessage(1009);
        Bundle bundle = new Bundle();
        bundle.putString("message", s1);
        bundle.putString("action", s2);
        message.setData(bundle);
        F.sendMessage(message);
    }

    public void removeCloseImageButton()
    {
        injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"hidden\";");
        TapjoyLog.d("MRAIDView", "Removing close button.");
        e = customCloseState.HIDDEN;
    }

    public void removeListener()
    {
        s = null;
    }

    public void reset()
    {
        if (r != VIEW_STATE.EXPANDED) goto _L2; else goto _L1
_L1:
        a();
_L4:
        invalidate();
        h.deleteOldAds();
        h.stopAllListeners();
        d();
        return;
_L2:
        if (r == VIEW_STATE.RESIZED)
        {
            b();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void resetContents()
    {
        FrameLayout framelayout1 = (FrameLayout)getRootView().findViewById(0x1020002);
        FrameLayout framelayout = (FrameLayout)getRootView().findViewById(100);
        FrameLayout framelayout2 = (FrameLayout)getRootView().findViewById(101);
        framelayout2.removeView(this);
        framelayout1.removeView(framelayout2);
        d();
        if (framelayout != null)
        {
            ViewGroup viewgroup = (ViewGroup)framelayout.getParent();
            if (viewgroup != null)
            {
                viewgroup.addView(this, p);
                viewgroup.removeView(framelayout);
                viewgroup.invalidate();
            }
        }
    }

    public void resize(int i1, int j1, int k1, int l1, String s1, boolean flag)
    {
        Message message = F.obtainMessage(1000);
        Bundle bundle = new Bundle();
        bundle.putInt("resize_width", i1);
        bundle.putInt("resize_height", j1);
        bundle.putInt("resize_x", k1);
        bundle.putInt("resize_y", l1);
        bundle.putBoolean("resize_allowOffScreen", flag);
        bundle.putString("resize_customClosePostition", s1);
        message.setData(bundle);
        F.sendMessage(message);
    }

    public void resizeOrientation(int i1, int j1, String s1, boolean flag)
    {
        v = i1;
        w = j1;
        TapjoyLog.i("MRAIDView", (new StringBuilder("resizeOrientation to dimensions: ")).append(i1).append("x").append(j1).toString());
        Message message = F.obtainMessage(1010);
        Bundle bundle = new Bundle();
        bundle.putInt("resize_width", i1);
        bundle.putInt("resize_height", j1);
        bundle.putBoolean("resize_allowOffScreen", flag);
        bundle.putString("resize_customClosePostition", s1);
        message.setData(bundle);
        F.sendMessage(message);
    }

    public WebBackForwardList restoreState(Bundle bundle)
    {
        return super.restoreState(bundle);
    }

    public WebBackForwardList saveState(Bundle bundle)
    {
        return super.saveState(bundle);
    }

    public void setContext(Context context)
    {
        A = context;
    }

    public void setListener(MraidViewListener mraidviewlistener)
    {
        s = mraidviewlistener;
    }

    public void setMaxSize(int i1, int j1)
    {
        h.setMaxSize(i1, j1);
    }

    public void setOrientationProperties(boolean flag, String s1)
    {
        int i1;
        if (!flag)
        {
            if (s1.equals("landscape"))
            {
                i1 = 0;
            } else
            {
                i1 = 1;
            }
        } else
        {
            i1 = -1;
        }
        ((Activity)getContext()).setRequestedOrientation(i1);
    }

    public void setPlacementType(PLACEMENT_TYPE placement_type)
    {
        if (placement_type.equals(PLACEMENT_TYPE.INLINE) || placement_type.equals(PLACEMENT_TYPE.INTERSTITIAL))
        {
            q = placement_type;
        } else
        {
            TapjoyLog.d("MRAIDView", "Incorrect placement type.");
        }
        if (placement_type.equals(PLACEMENT_TYPE.INLINE) && (x == null || !x.isAlive()))
        {
            x = new Thread(new b());
            x.start();
        }
    }

    public void show()
    {
        F.sendEmptyMessage(1003);
    }

    public void showCloseImageButton()
    {
        injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"visible\";");
        TapjoyLog.d("MRAIDView", "Showing close button.");
        e = customCloseState.OPEN;
    }

    public boolean videoPlaying()
    {
        return C != null;
    }

    public void videoViewCleanup()
    {
        if (B != null)
        {
            ((ViewGroup)B.getParent()).removeView(B);
            B.setVisibility(8);
            B = null;
        }
        try
        {
            if (C != null)
            {
                C.stopPlayback();
            }
            if (D != null)
            {
                D.onCustomViewHidden();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        C = null;
        D = null;
        if (this != null)
        {
            setVisibility(0);
        }
        loadUrl("javascript:try{Tapjoy.AdUnit.dispatchEvent('videoend')}catch(e){}");
    }

}
