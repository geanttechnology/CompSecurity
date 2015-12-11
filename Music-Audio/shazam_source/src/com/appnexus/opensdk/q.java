// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieSyncManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.k;
import com.appnexus.opensdk.b.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.appnexus.opensdk:
//            au

final class q
    implements AdActivity.a
{

    static LinkedList a = new LinkedList();
    private Activity b;
    private WebView c;
    private boolean d;

    public q(Activity activity)
    {
        d = false;
        b = activity;
    }

    static Activity a(q q1)
    {
        return q1.b;
    }

    static void a(q q1, String s)
    {
        Object obj;
        if (k.a(s))
        {
            obj = null;
        } else
        {
            obj = Uri.parse(s);
        }
        if (obj == null)
        {
            com.appnexus.opensdk.b.b.d(b.j, com.appnexus.opensdk.b.b.a(an.d.opening_url_failed, s));
            return;
        }
        obj = new Intent("android.intent.action.VIEW", ((Uri) (obj)));
        ((Intent) (obj)).setFlags(0x10000000);
        try
        {
            q1.b.startActivity(((Intent) (obj)));
            q1.f();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (q q1)
        {
            com.appnexus.opensdk.b.b.d(b.j, com.appnexus.opensdk.b.b.a(an.d.opening_url_failed, s));
        }
    }

    static WebView b(q q1)
    {
        return q1.c;
    }

    private void f()
    {
        d = true;
        b.finish();
    }

    public final void a()
    {
        b.setContentView(an.b.activity_in_app_browser);
        c = (WebView)a.poll();
        if (c == null || c.getSettings() == null)
        {
            f();
            return;
        }
        WebView webview = (WebView)b.findViewById(an.a.web_view);
        Object obj = webview.getLayoutParams();
        Object obj1 = (ViewGroup)webview.getParent();
        int i = ((ViewGroup) (obj1)).indexOfChild(webview);
        ((ViewGroup) (obj1)).removeView(webview);
        l.a(c);
        c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        ((ViewGroup) (obj1)).addView(c, i);
        obj = (ImageButton)b.findViewById(an.a.browser_back);
        obj1 = (ImageButton)b.findViewById(an.a.browser_forward);
        ImageButton imagebutton = (ImageButton)b.findViewById(an.a.open_browser);
        ImageButton imagebutton1 = (ImageButton)b.findViewById(an.a.browser_refresh);
        ProgressBar progressbar = (ProgressBar)b.findViewById(an.a.progress_bar);
        ((ImageButton) (obj)).setEnabled(false);
        ((ImageButton) (obj1)).setEnabled(false);
        i = android.os.Build.VERSION.SDK_INT;
        String s;
        if (i >= 17)
        {
            Drawable drawable = b.getResources().getDrawable(0x1080024).mutate();
            ((ImageButton) (obj)).setScaleX(-1F);
            ((ImageButton) (obj)).setLayoutDirection(1);
            ((ImageButton) (obj)).setImageDrawable(drawable);
        } else
        {
            ((ImageButton) (obj)).post(new _cls1(((ImageButton) (obj1)), ((ImageButton) (obj))));
        }
        s = b.getIntent().getStringExtra("bridgeid");
        if (s != null)
        {
            k.b b1 = null;
            Iterator iterator = k.b.d.iterator();
            final class _cls1
                implements Runnable
            {

                final ImageButton a;
                final ImageButton b;
                final q c;

                public final void run()
                {
                    Bitmap bitmap = BitmapFactory.decodeResource(q.a(c).getResources(), 0x1080024);
                    a.setImageBitmap(bitmap);
                    Matrix matrix = new Matrix();
                    b.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
                    matrix.postRotate(180F);
                    bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    b.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                    a.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
                    b.setImageBitmap(bitmap);
                }

            
            {
                c = q.this;
                a = imagebutton;
                b = imagebutton1;
                super();
            }
            }

            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Pair pair = (Pair)iterator.next();
                if (((String)pair.first).equals(s))
                {
                    b1 = (k.b)pair.second;
                    k.b.d.remove(pair);
                }
            } while (true);
            if (b1 != null)
            {
                if (i >= 16)
                {
                    ((ImageButton) (obj)).setBackground(b1.b);
                    ((ImageButton) (obj1)).setBackground(b1.a);
                    imagebutton1.setBackground(b1.c);
                } else
                {
                    ((ImageButton) (obj)).setBackgroundDrawable(b1.b);
                    ((ImageButton) (obj1)).setBackgroundDrawable(b1.a);
                    imagebutton1.setBackgroundDrawable(b1.c);
                }
            }
        }
        ((ImageButton) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public final void onClick(View view)
            {
                com.appnexus.opensdk.q.b(a).goBack();
            }

            
            {
                a = q.this;
                super();
            }
        });
        ((ImageButton) (obj1)).setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public final void onClick(View view)
            {
                com.appnexus.opensdk.q.b(a).goForward();
            }

            
            {
                a = q.this;
                super();
            }
        });
        imagebutton1.setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public final void onClick(View view)
            {
                com.appnexus.opensdk.q.b(a).reload();
            }

            
            {
                a = q.this;
                super();
            }
        });
        imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

            final q a;

            public final void onClick(View view)
            {
                com.appnexus.opensdk.b.b.b(b.j, com.appnexus.opensdk.b.b.a(an.d.opening_native_current));
                q.a(a, com.appnexus.opensdk.q.b(a).getUrl());
            }

            
            {
                a = q.this;
                super();
            }
        });
        c.setWebViewClient(new WebViewClient(((ImageButton) (obj)), ((ImageButton) (obj1))) {

            final ImageButton a;
            final ImageButton b;
            final q c;

            public final void onPageFinished(WebView webview1, String s1)
            {
                a.setEnabled(webview1.canGoBack());
                b.setEnabled(webview1.canGoForward());
                webview1 = CookieSyncManager.getInstance();
                if (webview1 != null)
                {
                    webview1.sync();
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webview1, String s1)
            {
                com.appnexus.opensdk.b.b.a(b.j, com.appnexus.opensdk.b.b.a(an.d.opening_url, s1));
                if (s1.startsWith("http"))
                {
                    return false;
                } else
                {
                    q.a(c, s1);
                    return true;
                }
            }

            
            {
                c = q.this;
                a = imagebutton;
                b = imagebutton1;
                super();
            }
        });
        c.setWebChromeClient(new au(b, progressbar) {

            final ProgressBar a;
            final q b;

            public final boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                com.appnexus.opensdk.b.b.d(b.j, com.appnexus.opensdk.b.b.a(an.d.console_message, consolemessage.message(), consolemessage.lineNumber(), consolemessage.sourceId()));
                return true;
            }

            public final boolean onJsAlert(WebView webview1, String s1, String s2, JsResult jsresult)
            {
                com.appnexus.opensdk.b.b.d(b.j, com.appnexus.opensdk.b.b.a(an.d.js_alert, s2, s1));
                jsresult.confirm();
                return true;
            }

            public final void onProgressChanged(WebView webview1, int j)
            {
                if (j < 100 && a.getVisibility() == 8)
                {
                    a.setVisibility(0);
                }
                a.setProgress(j);
                if (j == 100)
                {
                    a.setVisibility(8);
                }
            }

            public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
            {
                super.onShowCustomView(view, customviewcallback);
                if (view instanceof FrameLayout)
                {
                    view = (FrameLayout)view;
                    if (view.getFocusedChild() instanceof VideoView)
                    {
                        customviewcallback = (VideoView)view.getFocusedChild();
                        view.removeView(customviewcallback);
                        ((Activity)com.appnexus.opensdk.q.b(b).getContext()).setContentView(customviewcallback);
                        customviewcallback.start();
                    }
                }
            }

            
            {
                b = q.this;
                a = progressbar;
                super(activity);
            }
        });
    }

    public final void b()
    {
        d = true;
    }

    public final void c()
    {
        if (c == null)
        {
            return;
        }
        l.a(c);
        if (d)
        {
            c.destroy();
            return;
        } else
        {
            a.addFirst(c);
            return;
        }
    }

    public final void d()
    {
    }

    public final WebView e()
    {
        return c;
    }

}
