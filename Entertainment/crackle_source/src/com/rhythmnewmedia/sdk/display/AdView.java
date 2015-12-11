// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.display;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.rhythmnewmedia.sdk.NoAdReason;
import com.rhythmnewmedia.sdk.RhythmActivity;
import com.rhythmnewmedia.sdk.d;
import com.rhythmnewmedia.sdk.h;
import com.rhythmnewmedia.sdk.i;
import com.rhythmnewmedia.sdk.m;
import com.rhythmnewmedia.sdk.n;
import com.rhythmnewmedia.sdk.o;
import com.rhythmnewmedia.sdk.u;
import com.rhythmnewmedia.sdk.util.Util;
import com.rhythmnewmedia.sdk.v;
import com.rhythmnewmedia.sdk.w;
import com.rhythmnewmedia.sdk.x;
import com.rhythmnewmedia.sdk.y;
import com.rhythmnewmedia.sdk.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.rhythmnewmedia.sdk.display:
//            AdControlListener, AdEventListener

public class AdView extends RelativeLayout
{
    public static final class a
    {

        public int a;
        public int b;
        public int c;
        public int d;

        public a()
        {
        }
    }

    public static final class b
    {

        public boolean a;
        public int b;
        public float c;
        public boolean d;

        public static b a(Uri uri)
        {
            String s;
            String s1;
            b b1;
            try
            {
                b1 = new b();
                if (uri.getQueryParameter("useBackground") != null)
                {
                    b1.a = Boolean.parseBoolean(uri.getQueryParameter("useBackground"));
                }
                s1 = uri.getQueryParameter("backgroundColor");
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                y.c("Error parsing expandProperties: %s", new Object[] {
                    uri.toString()
                });
                return null;
            }
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            if (s1.length() <= 0)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            s = s1;
            if (s1.charAt(0) == '#')
            {
                s = s1.substring(1);
            }
            b1.b = Integer.parseInt(s, 16);
            if (uri.getQueryParameter("backgroundOpacity") != null)
            {
                b1.c = Float.parseFloat(uri.getQueryParameter("backgroundOpacity"));
            }
            if (uri.getQueryParameter("isModal") != null)
            {
                b1.d = Boolean.parseBoolean(uri.getQueryParameter("isModal"));
            }
            return b1;
        }

        public b()
        {
            a = false;
            b = 0xffffff;
            c = 1.0F;
            d = false;
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        private static final c d[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/rhythmnewmedia/sdk/display/AdView$c, s);
        }

        public static c[] values()
        {
            return (c[])d.clone();
        }

        static 
        {
            a = new c("DEFAULT", 0);
            b = new c("EXPANDED", 1);
            c = new c("HIDDEN", 2);
            d = (new c[] {
                a, b, c
            });
        }

        private c(String s, int j)
        {
            super(s, j);
        }
    }


    private static String a = null;
    private static final Pattern b = Pattern.compile("requestId=(.*?)&.*?id=(.*?)[&|\"]");
    protected boolean acknowledged;
    protected AdControlListener adControlListener;
    protected AdEventListener adEventListener;
    protected final o adServerAPI;
    protected m adUnit;
    private String c;
    protected final Handler callingThreadCallbackHandler;
    protected final d clickHandler;
    protected com.rhythmnewmedia.sdk.d.b clickListener;
    public u currentAdResponse;
    private Runnable d;
    protected final com.rhythmnewmedia.sdk.a.b _flddelegate;
    protected boolean displayed;
    private boolean e;
    private float f;
    private final List g;
    public boolean pinned;
    protected boolean ready;
    protected boolean shouldAcknowledge;
    protected c state;
    protected final WebView webView;

    public AdView(Context context)
    {
        super(context);
        adServerAPI = (o)z.a.a(com/rhythmnewmedia/sdk/o, new Object[] {
            getContext()
        });
        clickHandler = (d)z.a.a(com/rhythmnewmedia/sdk/d, new Object[0]);
        _flddelegate = c();
        callingThreadCallbackHandler = new Handler();
        webView = new WebView(getContext());
        adEventListener = null;
        adControlListener = null;
        clickListener = null;
        adUnit = m.b;
        c = null;
        state = c.a;
        d = new n(this);
        e = false;
        f = 1.0F;
        g = new ArrayList();
        a();
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        adServerAPI = (o)z.a.a(com/rhythmnewmedia/sdk/o, new Object[] {
            getContext()
        });
        clickHandler = (d)z.a.a(com/rhythmnewmedia/sdk/d, new Object[0]);
        _flddelegate = c();
        callingThreadCallbackHandler = new Handler();
        webView = new WebView(getContext());
        adEventListener = null;
        adControlListener = null;
        clickListener = null;
        adUnit = m.b;
        c = null;
        state = c.a;
        d = new n(this);
        e = false;
        f = 1.0F;
        g = new ArrayList();
        a();
    }

    public AdView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        adServerAPI = (o)z.a.a(com/rhythmnewmedia/sdk/o, new Object[] {
            getContext()
        });
        clickHandler = (d)z.a.a(com/rhythmnewmedia/sdk/d, new Object[0]);
        _flddelegate = c();
        callingThreadCallbackHandler = new Handler();
        webView = new WebView(getContext());
        adEventListener = null;
        adControlListener = null;
        clickListener = null;
        adUnit = m.b;
        c = null;
        state = c.a;
        d = new n(this);
        e = false;
        f = 1.0F;
        g = new ArrayList();
        a();
    }

    public AdView(AdView adview)
    {
        super(adview.getContext());
        adServerAPI = (o)z.a.a(com/rhythmnewmedia/sdk/o, new Object[] {
            getContext()
        });
        clickHandler = (d)z.a.a(com/rhythmnewmedia/sdk/d, new Object[0]);
        _flddelegate = c();
        callingThreadCallbackHandler = new Handler();
        webView = new WebView(getContext());
        adEventListener = null;
        adControlListener = null;
        clickListener = null;
        adUnit = m.b;
        c = null;
        state = c.a;
        d = new n(this);
        e = false;
        f = 1.0F;
        g = new ArrayList();
        setAdEventListener(adview.adEventListener);
        setTargeting(adview.c);
    }

    static String a(AdView adview)
    {
        return adview.c;
    }

    private static String a(String s)
    {
        return String.format("<html><head><style type='text/css'>body {-webkit-tap-highlight- R.color: rgba(0,0,0,0);-webkit-touch-callout: none;background-color: transparent;margin: 0px;}</style ><script>document.ontouchmove = function(event) {event.preventDefault();}</script></head><body>%s</body></html>", new Object[] {
            s
        });
    }

    private void a()
    {
        b();
        if (getContext() != null && getContext().getResources() != null)
        {
            f = getContext().getResources().getDisplayMetrics().density;
        }
        resetSize();
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setVisibility(0);
        webView.setInitialScale((int)(100F * f));
        webView.setBackgroundColor(0);
        webView.getSettings().setNeedInitialFocus(false);
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new Object(), "RNMDAlertSignal");
        Util.a(webView, new com.rhythmnewmedia.sdk.util.Util.ProcessCallback() {

            final AdView a;

            public final void process(String s)
            {
                if (a.getHandler() != null)
                {
                    a.getHandler().post(new Runnable(this, s) {

                        final String a;
                        final _cls1 b;

                        public final void run()
                        {
                            b.a.handleClick(a);
                        }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                    });
                    return;
                } else
                {
                    a.handleClick(s);
                    return;
                }
            }

            
            {
                a = AdView.this;
                super();
            }
        });
        webView.setWebViewClient(new WebViewClient() {

            final AdView a;
            private boolean b;

            public final void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                y.a("********************* adview rendered and ready", new Object[0]);
                a.ready = true;
                Util.a(a.callingThreadCallbackHandler, a.adEventListener, "onAdReady", new Object[] {
                    a
                });
                s = com.rhythmnewmedia.sdk.h.a.values();
                int k = s.length;
                for (int j = 0; j < k; j++)
                {
                    com.rhythmnewmedia.sdk.h.a a1 = s[j];
                    Util.a(webview, String.format("(typeof %s === 'function' ? RhythmJSBridge.process('rhythm://rhythm.sdk?cmd=adConnector&name=%s') : null);", new Object[] {
                        a1.a().a(), a1.name()
                    }));
                }

            }

            public final void onReceivedError(WebView webview, int j, String s, String s1)
            {
                super.onReceivedError(webview, j, s, s1);
                y.a("********************* adview render failed %d: %s", new Object[] {
                    Integer.valueOf(j), s
                });
                Util.a(a.callingThreadCallbackHandler, a.adEventListener, "onNoAdReceived", new Object[] {
                    a, NoAdReason.error
                });
            }

            public final boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                a.handleClick(s);
                return true;
            }

            
            {
                a = AdView.this;
                super();
                b = true;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {

            final AdView a;

            public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
            {
                webview = a.getAPIConnectors().iterator();
                boolean flag;
                if (webview.hasNext())
                {
                    flag = ((h)webview.next()).a(s1, a);
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    a.handleClick(s1);
                }
                y.a("[JS LOG] %s", new Object[] {
                    s1
                });
                jsresult.confirm();
                return true;
            }

            public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
            {
                return false;
            }

            
            {
                a = AdView.this;
                super();
            }
        });
        addView(webView);
        setBackgroundColor(0);
    }

    private void a(c c1)
    {
        if (c1 != state)
        {
            state = c1;
            for (c1 = g.iterator(); c1.hasNext(); ((h)c1.next()).d(this)) { }
        }
    }

    private void a(i j)
    {
        if (currentAdResponse.m() > 0)
        {
            Iterator iterator = currentAdResponse.l().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.rhythmnewmedia.sdk.a.e e1 = (com.rhythmnewmedia.sdk.a.e)iterator.next();
                if (e1.c)
                {
                    e1.a = Util.a(e1.a, "action", String.valueOf(j.a.a()));
                    if (j.c != null)
                    {
                        String s;
                        if (j.c.length() > 30)
                        {
                            s = j.c.substring(0, 30);
                        } else
                        {
                            s = j.c;
                        }
                        e1.a = Util.a(e1.a, "label", Util.d(s));
                    }
                }
            } while (true);
            adServerAPI.a(currentAdResponse.l());
        }
    }

    private void b()
    {
        ready = false;
        displayed = false;
        shouldAcknowledge = false;
        acknowledged = false;
        if (getState() != c.b) goto _L2; else goto _L1
_L1:
        Runnable runnable = new Runnable() {

            final AdView a;

            public final void run()
            {
                try
                {
                    a.close();
                    return;
                }
                catch (Exception exception)
                {
                    y.a(exception, (new StringBuilder()).append("While resetting the AdView ").append(exception.getMessage()).toString(), new Object[0]);
                }
            }

            
            {
                a = AdView.this;
                super();
            }
        };
        if (getHandler() == null) goto _L4; else goto _L3
_L3:
        getHandler().post(runnable);
_L2:
        a(c.a);
        g.clear();
        return;
_L4:
        if (getContext() instanceof Activity)
        {
            ((Activity)getContext()).runOnUiThread(runnable);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private com.rhythmnewmedia.sdk.a.b c()
    {
        return new com.rhythmnewmedia.sdk.a.b() {

            com.rhythmnewmedia.sdk.a.a a;
            final AdView b;

            public final void a(com.rhythmnewmedia.sdk.a.a a1)
            {
                a = a1;
            }

            public final void a(com.rhythmnewmedia.sdk.a.d d1)
            {
                if (d1 == com.rhythmnewmedia.sdk.a.d.a)
                {
                    d1 = NoAdReason.noAd;
                } else
                {
                    d1 = NoAdReason.error;
                }
                Util.a(b.callingThreadCallbackHandler, b.adEventListener, "onNoAdReceived", new Object[] {
                    b, d1
                });
            }

            public final void a(InputStream inputstream)
            {
                b.acknowledged = false;
                if (a == null)
                {
                    y.b("ad data loaded but ad type not set", new Object[0]);
                    a(com.rhythmnewmedia.sdk.a.d.e);
                    return;
                }
                if (a == com.rhythmnewmedia.sdk.a.a.b)
                {
                    b.a(inputstream);
                    return;
                } else
                {
                    b.b(inputstream);
                    return;
                }
            }

            public final String c()
            {
                return b.getAdRequestParameterString();
            }

            public final String d()
            {
                return AdView.a(b);
            }

            public final String e()
            {
                if (Util.a() == null)
                {
                    Util.a(b.webView.getSettings().getUserAgentString());
                }
                return b.webView.getSettings().getUserAgentString();
            }

            
            {
                b = AdView.this;
                super();
            }
        };
    }

    public static void resetAdHost(Context context)
    {
        ((o)z.a.a(com/rhythmnewmedia/sdk/o, new Object[] {
            context
        })).a(context);
    }

    final void a(InputStream inputstream)
    {
        shouldAcknowledge = true;
        try
        {
            currentAdResponse = (u)(new v()).a(inputstream);
            if (currentAdResponse == null)
            {
                Util.a(callingThreadCallbackHandler, adEventListener, "onNoAdReceived", new Object[] {
                    this, NoAdReason.noAd
                });
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            y.a(inputstream, "error parsing ad XML", new Object[0]);
            Util.a(callingThreadCallbackHandler, adEventListener, "onNoAdReceived", new Object[] {
                this, NoAdReason.error
            });
            return;
        }
        Util.a(callingThreadCallbackHandler, adEventListener, "onAdReceived", new Object[] {
            this
        });
        if (currentAdResponse.i() == com.rhythmnewmedia.sdk.u.a.a)
        {
            inputstream = new StringBuilder();
            inputstream.append("<div style =\"text-align: center\">");
            if (currentAdResponse.e() != null)
            {
                inputstream.append("<a href=\"");
                inputstream.append(currentAdResponse.e());
                inputstream.append("\">");
            }
            inputstream.append("<img src=\"");
            inputstream.append(currentAdResponse.d());
            inputstream.append("\" border=\"0\"/>");
            if (currentAdResponse.e() != null)
            {
                inputstream.append("</a>");
            }
            inputstream.append("</div>");
            inputstream = a(inputstream.toString());
            y.a("(%s) rendering image ad type", new Object[] {
                currentAdResponse.a()
            });
            webView.clearView();
            webView.loadData(inputstream, "text/html", "UTF-8");
            return;
        }
        y.a("(%s) rendering %s", new Object[] {
            currentAdResponse.a(), currentAdResponse.d()
        });
        renderAdFromUrl(currentAdResponse.d());
        return;
    }

    final void b(InputStream inputstream)
    {
        Util.a(callingThreadCallbackHandler, adEventListener, "onAdReceived", new Object[] {
            this
        });
        Object obj;
        Matcher matcher;
        try
        {
            inputstream = Util.a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            y.a(inputstream, "error reading ad HTML", new Object[0]);
            Util.a(callingThreadCallbackHandler, adEventListener, "onNoAdReceived", new Object[] {
                this, NoAdReason.error
            });
            return;
        }
        obj = new u();
        matcher = b.matcher(inputstream);
        if (matcher.find())
        {
            ((u) (obj)).a(matcher.group(1));
            ((u) (obj)).b(matcher.group(2));
        }
        currentAdResponse = ((u) (obj));
        currentAdResponse.d(-1);
        obj = inputstream;
        if (!inputstream.contains("<html"))
        {
            obj = a(inputstream);
        }
        y.a("(%s) rendering from data directly", new Object[] {
            currentAdResponse.a()
        });
        webView.clearView();
        webView.loadData(((String) (obj)), "text/html", "UTF-8");
    }

    public void cancel()
    {
        e = true;
        setAdEventListener(null);
        setAdControlListener(null);
    }

    public void close()
    {
        ViewGroup viewgroup1 = (ViewGroup)getRootView().findViewById(0x1020002);
        FrameLayout framelayout = (FrameLayout)getRootView().findViewById(5000);
        FrameLayout framelayout1 = (FrameLayout)getRootView().findViewById(5010);
        ViewGroup viewgroup = (ViewGroup)framelayout.getParent();
        framelayout1.removeView(this);
        viewgroup1.removeView(framelayout1);
        resetSize();
        requestLayout();
        int ai[] = (int[])framelayout.getTag();
        viewgroup.addView(this, ai[0]);
        if (ai.length > 1 && (getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
        {
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
            marginlayoutparams.leftMargin = ai[1];
            marginlayoutparams.topMargin = ai[2];
            marginlayoutparams.rightMargin = ai[3];
            marginlayoutparams.bottomMargin = ai[4];
        }
        viewgroup.removeView(framelayout);
        viewgroup.invalidate();
        a(c.a);
    }

    public void expand(a a1, b b1)
    {
        ViewGroup viewgroup = (ViewGroup)getRootView().findViewById(0x1020002);
        Object obj = (ViewGroup)getParent();
        android.widget.FrameLayout.LayoutParams layoutparams;
        int j;
        int k;
        if (a1 == null)
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams(viewgroup.getWidth(), viewgroup.getHeight());
        } else
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams((int)((float)a1.c * f), (int)((float)a1.d * f));
            layoutparams.leftMargin = (int)((float)a1.a * f);
            layoutparams.topMargin = (int)((float)a1.b * f);
        }
        k = ((ViewGroup) (obj)).getChildCount();
        for (j = 0; j < k && ((ViewGroup) (obj)).getChildAt(j) != this; j++) { }
        FrameLayout framelayout = new FrameLayout(getContext());
        framelayout.setId(5000);
        framelayout.setBackgroundColor(0);
        android.view.ViewGroup.LayoutParams layoutparams1 = getLayoutParams();
        if (layoutparams1 instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
            framelayout.setTag(new int[] {
                j, marginlayoutparams.leftMargin, marginlayoutparams.topMargin, marginlayoutparams.rightMargin, marginlayoutparams.bottomMargin
            });
        } else
        {
            framelayout.setTag(new int[] {
                j
            });
        }
        ((ViewGroup) (obj)).addView(framelayout, j, layoutparams1);
        ((ViewGroup) (obj)).removeView(this);
        obj = new FrameLayout(getContext());
        ((FrameLayout) (obj)).setId(5010);
        if (a1 != null)
        {
            ((FrameLayout) (obj)).setPadding((int)((float)a1.a * f), (int)((float)a1.b * f), 0, 0);
        }
        if (b1 != null && b1.a)
        {
            y.a("!!!!! %d  %f", new Object[] {
                Integer.valueOf(b1.b), Float.valueOf(b1.c)
            });
            ((FrameLayout) (obj)).setBackgroundColor(b1.b | (int)(b1.c * 255F) * 0x10000000);
        } else
        {
            ((FrameLayout) (obj)).setBackgroundColor(0);
        }
        ((FrameLayout) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            final AdView a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = AdView.this;
                super();
            }
        });
        a1 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout) (obj)).addView(this, layoutparams);
        webView.getLayoutParams().width = layoutparams.width;
        webView.getLayoutParams().height = layoutparams.height;
        viewgroup.addView(((View) (obj)), a1);
        a(c.b);
    }

    public Iterable getAPIConnectors()
    {
        return g;
    }

    public int getAdHeight()
    {
        return (int)(f * (float)adUnit.b());
    }

    protected String getAdRequestParameterString()
    {
        return String.format("&channel=%s&delivery=xml&%s", new Object[] {
            adUnit.c(), getSizeParameters()
        });
    }

    public int getAdWidth()
    {
        return (int)(f * (float)adUnit.a());
    }

    public String getCurrentAdTitle()
    {
        if (currentAdResponse != null)
        {
            return currentAdResponse.c();
        } else
        {
            return null;
        }
    }

    protected String getSizeParameters()
    {
        StringBuilder stringbuilder = new StringBuilder("w=");
        stringbuilder.append(webView.getLayoutParams().width);
        stringbuilder.append("&h=");
        stringbuilder.append(webView.getLayoutParams().height);
        return stringbuilder.toString();
    }

    public c getState()
    {
        return state;
    }

    public String getTargeting()
    {
        return c;
    }

    public i handleClick(String s)
    {
        Object obj;
        i j;
        if (currentAdResponse == null)
        {
            y.d("clicked on ad with unknown server response", new Object[0]);
            return clickHandler.a;
        }
        j = com.rhythmnewmedia.sdk.d.a(s, getContext(), this, currentAdResponse.a(), currentAdResponse.b());
        if (j.a == com.rhythmnewmedia.sdk.d.a.k && j.e != null && (j.e instanceof h))
        {
            s = (h)j.e;
            s.a(this);
            s.b(this);
            if (g.size() == 0 && displayed)
            {
                s.c(this);
            }
            g.add(s);
            return j;
        }
        if (j.a != com.rhythmnewmedia.sdk.d.a.l)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        if (currentAdResponse.n() != 0)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj = Uri.parse(s);
        obj = ((Uri) (obj)).getQueryParameter("ctb");
        static final class _cls7
        {

            static final int a[];

            static 
            {
                a = new int[com.rhythmnewmedia.sdk.d.a.values().length];
                try
                {
                    a[com.rhythmnewmedia.sdk.d.a.f.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.rhythmnewmedia.sdk.d.a.g.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.rhythmnewmedia.sdk.d.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (obj != null)
        {
            try
            {
                currentAdResponse.d(Color.parseColor(String.format("#%s", new Object[] {
                    obj
                })));
            }
            catch (Throwable throwable) { }
        }
        obj = s;
        if (j.e != null)
        {
            obj = s;
            if (j.e instanceof String)
            {
                obj = (String)j.e;
            }
        }
        s = new Intent(getContext(), com/rhythmnewmedia/sdk/RhythmActivity);
        s.putExtra("url", ((String) (obj)));
        s.putExtra("rnmdActivityType", 1);
        s.putExtra("rnmdRequestId", currentAdResponse.a());
        s.putExtra("rnmdAdId", currentAdResponse.b());
        s.putExtra("backgroundColor", currentAdResponse.n());
        s.putExtra("ipckey", w.a(new Object[] {
            this
        }));
        s.setFlags(0x10010000);
        getContext().startActivity(s);
        if (j.a.b())
        {
            a(j);
        }
        _cls7.a[j.a.ordinal()];
        JVM INSTR tableswitch 1 3: default 392
    //                   1 411
    //                   2 418
    //                   3 425;
           goto _L1 _L2 _L3 _L4
_L1:
        if (clickListener != null)
        {
            clickListener.a(j);
        }
        return j;
_L2:
        pin();
        continue; /* Loop/switch isn't completed */
_L3:
        unpin();
        continue; /* Loop/switch isn't completed */
_L4:
        Util.a(callingThreadCallbackHandler, adControlListener, "onAdDidRequestDismissal", new Object[] {
            this
        });
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void hide()
    {
        setVisibility(4);
        a(c.c);
    }

    public void injectJavascript(String s)
    {
        Util.a(webView, s);
    }

    public boolean isCancelled()
    {
        return e;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (!ready || !shouldAcknowledge || acknowledged || currentAdResponse == null) goto _L2; else goto _L1
_L1:
        acknowledged = true;
        if (currentAdResponse.k() <= 0) goto _L4; else goto _L3
_L3:
        adServerAPI.a(currentAdResponse.j());
_L2:
        if (ready && !displayed)
        {
            displayed = true;
            for (canvas = g.iterator(); canvas.hasNext(); ((h)canvas.next()).c(this)) { }
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (currentAdResponse.a() != null && currentAdResponse.b() != null)
        {
            canvas = adServerAPI;
            String s = currentAdResponse.a();
            String s1 = currentAdResponse.b();
            x.a.a(new com.rhythmnewmedia.sdk.o._cls1(canvas, s, s1));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void pin()
    {
        if (!pinned)
        {
            pinned = true;
            callingThreadCallbackHandler.removeCallbacks(d);
            Util.a(callingThreadCallbackHandler, adControlListener, "onAdPinned", new Object[] {
                this
            });
        }
    }

    public void renderAdFromUrl(String s)
    {
        if (currentAdResponse == null)
        {
            currentAdResponse = new u();
            currentAdResponse.d(-1);
            currentAdResponse.a("-1");
            currentAdResponse.b("-100");
        }
        webView.clearView();
        webView.loadUrl(s);
    }

    public void requestNewAd()
    {
        b();
        Util.a(callingThreadCallbackHandler, adEventListener, "onWillRequestAd", new Object[] {
            this
        });
        this;
        JVM INSTR monitorenter ;
        adServerAPI.b(_flddelegate);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resetSize()
    {
        setLayoutParams(new android.view.ViewGroup.LayoutParams((int)(f * (float)adUnit.a()), (int)(f * (float)adUnit.b())));
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams((int)(f * (float)adUnit.a()), (int)(f * (float)adUnit.b()));
        webView.setLayoutParams(layoutparams);
    }

    public void setAdControlListener(AdControlListener adcontrollistener)
    {
        adControlListener = adcontrollistener;
    }

    public void setAdEventListener(AdEventListener adeventlistener)
    {
        adEventListener = adeventlistener;
    }

    protected void setAdUnit(m m1)
    {
        adUnit = m1;
        resetSize();
    }

    public void setBackgroundColor(int j)
    {
        super.setBackgroundColor(j);
        webView.setBackgroundColor(0);
    }

    public void setClickListener(com.rhythmnewmedia.sdk.d.b b1)
    {
        clickListener = b1;
    }

    public void setTargeting(String s)
    {
        c = Util.c(s);
    }

    public void show()
    {
        setVisibility(0);
        a(c.a);
    }

    public void unpin()
    {
        if (pinned)
        {
            pinned = false;
            Util.a(callingThreadCallbackHandler, adControlListener, "onAdUnpinned", new Object[] {
                this
            });
        }
    }

    static 
    {
        y.a(" ", new Object[0]);
        y.a(" ", new Object[0]);
        y.a("--------- RhythmSDK %s (%s %s)", new Object[] {
            "5.0.1", "50831", "09/28/2011 04:45 PM"
        });
    }

    // Unreferenced inner class com/rhythmnewmedia/sdk/n
    /* block-local class not found */
    class n {}

}
