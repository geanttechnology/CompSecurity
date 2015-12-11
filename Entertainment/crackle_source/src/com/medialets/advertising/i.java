// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.MimeTypeMap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.medialets.analytics.MMEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.medialets.advertising:
//            f, AdView, s, AdManager, 
//            DisplayInfo, y, a

final class i extends LinearLayout
    implements android.view.animation.Animation.AnimationListener
{
    final class a extends WebViewClient
    {

        private i a;

        public final void onPageFinished(WebView webview, String s1)
        {
            a.toggleProgressIndicator(false);
            for (webview = i.c(a).iterator(); webview.hasNext(); ((b)webview.next()).onBrowserComplete(s1)) { }
            if (i.d(a).getAdEvent() != null)
            {
                i.d(a).getAdEvent().addBreadCrumbUrl(s1);
            }
        }

        public final void onPageStarted(WebView webview, String s1, Bitmap bitmap)
        {
            a.toggleProgressIndicator(true);
        }

        public final boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
        {
            if (keyevent.getKeyCode() == 4)
            {
                if (i.b(a).canGoBack())
                {
                    i.b(a).goBack();
                } else
                {
                    a.dismiss();
                }
                return true;
            } else
            {
                return false;
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webview, String s1)
        {
label0:
            {
                for (webview = i.c(a).iterator(); webview.hasNext(); ((b)webview.next()).onBrowserRequest(s1)) { }
                int i1 = s1.lastIndexOf('.');
                webview = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s1.substring(i1 + 1));
                boolean flag1 = false;
                boolean flag;
                if (!s1.startsWith("tel:") && !s1.startsWith("mailto:") && !s1.startsWith("market:") && !s1.startsWith("sms:") && !s1.startsWith("http://maps.google.com/maps?"))
                {
                    flag = flag1;
                    if (webview == null)
                    {
                        break label0;
                    }
                    flag = flag1;
                    if (!webview.startsWith("video"))
                    {
                        break label0;
                    }
                }
                webview = new Intent("android.intent.action.VIEW", Uri.parse(s1));
                webview.addCategory("android.intent.category.BROWSABLE");
                webview.putExtra("com.android.browser.application_id", a.getContext().getPackageName());
                try
                {
                    a.getContext().startActivity(webview);
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    return false;
                }
                flag = true;
            }
            return flag;
        }

        a()
        {
            a = i.this;
            super();
        }
    }

    static interface b
    {

        public abstract void onBrowserComplete(String s1);

        public abstract void onBrowserRequest(String s1);
    }


    private String a;
    private AdView b;
    private int c;
    private s d;
    private RelativeLayout e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private ProgressBar j;
    private boolean k;
    private boolean l;
    private List m;
    protected android.view.View.OnClickListener mButtonClick;

    private i(Context context, AdView adview)
    {
        super(context);
        k = false;
        l = false;
        mButtonClick = new f(this);
        b = adview;
        m = new ArrayList();
        a();
    }

    public static i a(AdView adview, String s1)
    {
        adview = new i(adview.getContext(), adview);
        adview.a = s1;
        ((i) (adview)).d.loadUrl(((i) (adview)).a);
        return adview;
    }

    private void a()
    {
        Activity activity;
        int i1;
        activity = AdManager.getInstance().getCurrentActivity();
        setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        setOrientation(1);
        d = new s(getContext());
        Object obj = d.getSettings();
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setAllowFileAccess(true);
        d.clearCache(true);
        d.setHorizontalScrollBarEnabled(true);
        d.setVerticalScrollBarEnabled(true);
        d.setWebViewClient(new a());
        obj = new android.widget.LinearLayout.LayoutParams(-1, -1);
        obj.weight = 1.0F;
        addView(d, ((android.view.ViewGroup.LayoutParams) (obj)));
        Object obj1 = DisplayInfo.getInstance();
        obj = "background-160.png";
        i1 = 30;
        if (((DisplayInfo) (obj1)).getDpi(getContext()) == 240)
        {
            obj = "background-240.png";
            i1 = 45;
        }
        obj1 = new android.widget.RelativeLayout.LayoutParams(-1, i1);
        e = new RelativeLayout(getContext());
        e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        e.setGravity(17);
        try
        {
            obj = BitmapFactory.decodeStream(getContext().getAssets().open(((String) (obj))));
            e.setBackgroundDrawable(new BitmapDrawable(((Bitmap) (obj))));
            obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
            Object obj2 = BitmapFactory.decodeStream(getContext().getAssets().open("back.png"));
            f = new Button(getContext());
            f.setBackgroundDrawable(new BitmapDrawable(((Bitmap) (obj2))));
            f.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            f.setEnabled(true);
            f.setId(304);
            f.setOnClickListener(mButtonClick);
            obj = BitmapFactory.decodeStream(getContext().getAssets().open("forward.png"));
            obj2 = new android.widget.RelativeLayout.LayoutParams(i1, i1);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(1, 304);
            g = new Button(getContext());
            g.setBackgroundDrawable(new BitmapDrawable(((Bitmap) (obj))));
            g.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            g.setEnabled(true);
            g.setId(305);
            g.setOnClickListener(mButtonClick);
            obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11, -1);
            obj2 = BitmapFactory.decodeStream(getContext().getAssets().open("close.png"));
            h = new Button(getContext());
            h.setBackgroundDrawable(new BitmapDrawable(((Bitmap) (obj2))));
            h.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            h.setEnabled(true);
            h.setId(296);
            h.setOnClickListener(mButtonClick);
            obj = BitmapFactory.decodeStream(getContext().getAssets().open("refresh.png"));
            obj2 = new android.widget.RelativeLayout.LayoutParams(i1, i1);
            ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(0, 296);
            i = new Button(getContext());
            i.setBackgroundDrawable(new BitmapDrawable(((Bitmap) (obj))));
            i.setEnabled(true);
            i.setId(297);
            i.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
            i.setOnClickListener(mButtonClick);
            e.addView(f);
            e.addView(g);
            e.addView(h);
            e.addView(i);
        }
        catch (IOException ioexception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Error loading graphical assets for the EmbeddedBrowser: ").append(ioexception.toString()).toString());
        }
        addView(e);
        i1 = 30;
        if (DisplayInfo.getInstance().getDpi(getContext()) == 240)
        {
            i1 = 45;
        }
        obj = new android.widget.RelativeLayout.LayoutParams(i1, i1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, 296);
        j = new ProgressBar(getContext(), null, 0x1010077);
        j.setIndeterminate(true);
        j.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        j.setVisibility(8);
        j.setPadding(5, 5, 5, 5);
        j.setId(306);
        e.addView(j);
        obj = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj)));
        obj = new TranslateAnimation(((DisplayMetrics) (obj)).widthPixels, 0.0F, 0.0F, 0.0F);
        ((TranslateAnimation) (obj)).setDuration(750L);
        ((TranslateAnimation) (obj)).setAnimationListener(this);
        startAnimation(((Animation) (obj)));
        invalidate();
        requestLayout();
        setFocusable(true);
        setFocusableInTouchMode(true);
        bringToFront();
        requestFocus();
        if (b.getSlotType() != 1) goto _L2; else goto _L1
_L1:
        i1 = y.f();
        c = activity.getRequestedOrientation();
        if (!y.g()) goto _L4; else goto _L3
_L3:
        activity.setRequestedOrientation(1);
_L6:
        obj = activity.getWindow().findViewById(0x1020016);
        if (obj != null)
        {
            obj = (ViewGroup)((View) (obj)).getParent();
            if (obj != null)
            {
                ((ViewGroup) (obj)).setVisibility(8);
            }
        }
        activity.getWindow().addFlags(1024);
_L2:
        ((ViewGroup)activity.getWindow().findViewById(0x1020002)).addView(this);
        return;
_L4:
        if (i1 == 1)
        {
            activity.setRequestedOrientation(1);
        } else
        if (i1 == 2)
        {
            activity.setRequestedOrientation(0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    static boolean a(i i1)
    {
        return i1.l;
    }

    static s b(i i1)
    {
        return i1.d;
    }

    static List c(i i1)
    {
        return i1.m;
    }

    static AdView d(i i1)
    {
        return i1.b;
    }

    public final void a(b b1)
    {
        m.add(b1);
    }

    public final void b(b b1)
    {
        m.remove(b1);
    }

    protected final void dismiss()
    {
        m.clear();
        Object obj = new DisplayMetrics();
        y.c().getMetrics(((DisplayMetrics) (obj)));
        obj = new TranslateAnimation(0.0F, ((DisplayMetrics) (obj)).widthPixels, 0.0F, 0.0F);
        ((TranslateAnimation) (obj)).setDuration(750L);
        ((TranslateAnimation) (obj)).setAnimationListener(this);
        k = true;
        startAnimation(((Animation) (obj)));
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (!k)
        {
            l = false;
            com.medialets.advertising.a.a("onAnimationEnd called in EmbeddedBrowser");
            if (b != null)
            {
                com.medialets.advertising.a.a("calling stopDurationTimer in onAnimationEnd");
                b.stopDurationTimer();
            }
            return;
        }
        d.stopLoading();
        d.destroy();
        animation = AdManager.getInstance().getCurrentActivity();
        if (b.getSlotType() == 1)
        {
            Object obj = animation.getWindow().findViewById(0x1020016);
            if (obj != null)
            {
                obj = (ViewGroup)((View) (obj)).getParent();
                if (obj != null)
                {
                    ((ViewGroup) (obj)).setVisibility(0);
                }
            }
            animation.getWindow().clearFlags(1024);
            animation.setRequestedOrientation(c);
        }
        ((ViewGroup)animation.getWindow().findViewById(0x1020002)).removeView(this);
        b.requestFocus();
        b.setClicked(false);
        if (b.getAdEvent() != null)
        {
            b.getAdEvent().addBreadCrumbUrl("MMEmbeddedBrowserClosed");
        }
        if (b != null)
        {
            com.medialets.advertising.a.a("EmbeddedBrowser is starting the duration timer");
            b.startDurationTimer();
        }
        l = false;
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        if (!k)
        {
            b.dismissLoadingView();
        }
        l = true;
    }

    public final boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (l)
        {
            return true;
        }
        if (keyevent.getKeyCode() == 4)
        {
            if (d.canGoBack())
            {
                d.goBack();
                return true;
            } else
            {
                dismiss();
                return true;
            }
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    protected final void toggleProgressIndicator(boolean flag)
    {
        if (flag)
        {
            i.setVisibility(8);
            j.setVisibility(0);
            return;
        } else
        {
            j.setVisibility(8);
            i.setVisibility(0);
            return;
        }
    }

    // Unreferenced inner class com/medialets/advertising/f
    final class f
        implements android.view.View.OnClickListener
    {

        private i a;

        public final void onClick(View view)
        {
            view.getId();
            JVM INSTR lookupswitch 4: default 48
        //                       296: 49
        //                       297: 89
        //                       304: 78
        //                       305: 67;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            return;
_L2:
            if (!i.a(a))
            {
                a.dismiss();
                return;
            }
              goto _L1
_L5:
            i.b(a).goForward();
            return;
_L4:
            i.b(a).goBack();
            return;
_L3:
            i.b(a).reload();
            return;
        }

            f()
            {
                a = i.this;
                super();
            }
    }

}
