// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.rhythmnewmedia.sdk.util.Util;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            G, y, I, J, 
//            i

public final class M extends FrameLayout
    implements android.view.animation.Animation.AnimationListener
{
    public static interface a
    {

        public abstract i a(String s);

        public abstract void m();
    }


    public final WebView a;
    private boolean b;
    private LinearLayout c;
    private ImageButton d;
    private TranslateAnimation e;
    private TranslateAnimation f;

    public M(Context context, a a1, G g)
    {
        super(context);
        c = null;
        d = null;
        if (g.c != null)
        {
            y.a(" - overlay url %s", new Object[] {
                g.c
            });
            a = new WebView(context);
            context = new android.widget.FrameLayout.LayoutParams(-1, -1);
            context.gravity = 17;
            setLayoutParams(context);
            a.setLayoutParams(context);
            a.getSettings().setJavaScriptEnabled(true);
            a.setHorizontalScrollBarEnabled(false);
            a.setVerticalScrollBarEnabled(false);
            float f1;
            if (getContext() != null && getContext().getResources() != null)
            {
                f1 = getContext().getResources().getDisplayMetrics().density;
            } else
            {
                f1 = 1.0F;
            }
            a.setInitialScale((int)(f1 * 100F));
            a.setBackgroundColor(0);
            a.getSettings().setCacheMode(2);
            a.getSettings().setNeedInitialFocus(true);
            Util.a(a, new com.rhythmnewmedia.sdk.util.Util.ProcessCallback(a1) {

                final a a;
                final M b;

                public final void process(String s)
                {
                    b.getHandler().post(new Runnable(this, s) {

                        final String a;
                        final _cls1 b;

                        public final void run()
                        {
                            b.a.a(a);
                        }

            
            {
                b = _pcls1;
                a = s;
                super();
            }
                    });
                }

            
            {
                b = M.this;
                a = a1;
                super();
            }
            });
            a.setWebViewClient(new WebViewClient(a1) {

                final a a;
                final M b;

                public final void onPageFinished(WebView webview, String s)
                {
                    super.onPageFinished(webview, s);
                    y.a("********************* ad overlay rendered and ready", new Object[0]);
                    a.m();
                }

                public final void onReceivedError(WebView webview, int j, String s, String s1)
                {
                    super.onReceivedError(webview, j, s, s1);
                    y.b("********************* ad overlay render failed %d: %s", new Object[] {
                        Integer.valueOf(j), s
                    });
                    a.m();
                }

                public final boolean shouldOverrideUrlLoading(WebView webview, String s)
                {
                    a.a(s);
                    return true;
                }

            
            {
                b = M.this;
                a = a1;
                super();
            }
            });
            a.loadUrl(g.c);
            addView(a);
            return;
        }
        static final class _cls5
        {

            static final int a[];

            static 
            {
                a = new int[I.a.values().length];
                try
                {
                    a[I.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[I.a.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        Object obj;
        ImageButton imagebutton;
        I i;
        if (g.e != null)
        {
            y.a(" - legacy overlay with %d elements", new Object[] {
                Integer.valueOf(g.e.size())
            });
            a = null;
            obj = new android.widget.FrameLayout.LayoutParams(-2, -2);
            obj.gravity = 81;
            obj.bottomMargin = 20;
            c = new LinearLayout(context);
            c.setOrientation(0);
            c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            addView(c);
            obj = g.e.iterator();
        } else
        {
            a = null;
            y.a("no overlay", new Object[0]);
            a1.m();
            return;
        }
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        i = (I)((Iterator) (obj)).next();
        if (i.a == I.a.a)
        {
            continue; /* Loop/switch isn't completed */
        }
        imagebutton = new ImageButton(context);
        imagebutton.setPadding(0, 0, 0, 0);
        imagebutton.setBackgroundColor(0);
        if (i.a == I.a.b)
        {
            g = BitmapFactory.decodeByteArray(J.a, 0, J.a.length);
            g.setDensity(160);
            imagebutton.setImageBitmap(g);
            imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

                final M a;

                public final void onClick(View view)
                {
                    a.a();
                }

            
            {
                a = M.this;
                super();
            }
            });
            g = new android.widget.FrameLayout.LayoutParams(-2, -2);
            g.rightMargin = 20;
            g.bottomMargin = 20;
            g.gravity = 85;
            imagebutton.setLayoutParams(g);
            addView(imagebutton);
            d = imagebutton;
            continue; /* Loop/switch isn't completed */
        }
        _cls5.a[i.a.ordinal()];
        JVM INSTR tableswitch 1 2: default 544
    //                   1 621
    //                   2 636;
           goto _L3 _L4 _L5
_L3:
        g = null;
_L6:
        if (g != null)
        {
            g.setDensity(160);
            imagebutton.setImageBitmap(g);
            imagebutton.setOnClickListener(new android.view.View.OnClickListener(a1, i) {

                final a a;
                final I b;
                final M c;

                public final void onClick(View view)
                {
                    a.a(b.b);
                }

            
            {
                c = M.this;
                a = a1;
                b = i;
                super();
            }
            });
            g = new android.widget.LinearLayout.LayoutParams(-2, -2);
            g.rightMargin = 20;
            g.leftMargin = 20;
            imagebutton.setLayoutParams(g);
            c.addView(imagebutton);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        g = BitmapFactory.decodeByteArray(J.b, 0, J.b.length);
        continue; /* Loop/switch isn't completed */
_L5:
        g = BitmapFactory.decodeByteArray(J.c, 0, J.c.length);
        if (true) goto _L6; else goto _L2
_L2:
        b = false;
        f = new TranslateAnimation(0.0F, 0.0F, 0.0F, 120F);
        f.setDuration(200L);
        f.setFillAfter(true);
        f.setAnimationListener(this);
        e = new TranslateAnimation(0.0F, 0.0F, 0.0F, -120F);
        e.setDuration(200L);
        e.setFillAfter(true);
        e.setAnimationListener(this);
        a1.m();
        return;
        if (true) goto _L8; else goto _L7
_L8:
        break MISSING_BLOCK_LABEL_352;
_L7:
    }

    final void a()
    {
        boolean flag;
        if (!b)
        {
            if (c != null)
            {
                c.startAnimation(e);
            }
            if (d != null)
            {
                d.startAnimation(f);
            }
        } else
        {
            if (c != null)
            {
                c.startAnimation(f);
            }
            if (d != null)
            {
                d.startAnimation(e);
            }
        }
        if (!b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
        invalidate();
    }

    public final void onAnimationEnd(Animation animation)
    {
        requestLayout();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (c != null)
        {
            j = getBottom() - c.getHeight() - 20;
            i = j;
            if (!b)
            {
                i = j + 120;
            }
            c.setAnimation(null);
            c.layout(c.getLeft(), i, c.getRight(), c.getHeight() + i);
        }
        if (d != null)
        {
            j = getBottom() - d.getHeight() - 20;
            i = j;
            if (b)
            {
                i = j + 120;
            }
            d.setAnimation(null);
            d.layout(d.getLeft(), i, d.getRight(), d.getHeight() + i);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionevent)
    {
        a();
        return super.onTouchEvent(motionevent);
    }
}
