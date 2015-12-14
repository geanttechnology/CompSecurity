// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            MMLayout, AdViewOverlayActivity, MMAdImpl, MMAdImplController, 
//            MMLog, MMActivity, OverlaySettings, HttpMMHeaders, 
//            MMWebView, InlineVideoView

class AdViewOverlayView extends MMLayout
{

    boolean a;
    OverlaySettings b;
    WeakReference c;
    private Button d;
    private ProgressBar j;
    private CloseTopDrawable k;

    AdViewOverlayView(AdViewOverlayActivity adviewoverlayactivity, OverlaySettings overlaysettings)
    {
        super(adviewoverlayactivity.b);
        c = new WeakReference(adviewoverlayactivity);
        e = new AdViewOverlayViewMMAdImpl(adviewoverlayactivity.b);
        setId(15062);
        e.e = "i";
        b = overlaysettings;
        Object obj;
        boolean flag;
        long l;
        boolean flag1;
        if (adviewoverlayactivity.b instanceof Activity)
        {
            overlaysettings = (NonConfigurationInstance)adviewoverlayactivity.b.getLastNonConfigurationInstance();
            float f1;
            int i;
            if (overlaysettings != null)
            {
                a = ((NonConfigurationInstance) (overlaysettings)).a;
                e.h = ((NonConfigurationInstance) (overlaysettings)).b;
                b = ((NonConfigurationInstance) (overlaysettings)).c;
                if (e != null && e.h != null && e.h.a != null)
                {
                    addView(e.h.a);
                }
                MMLog.b("AdViewOverlayView", (new StringBuilder("Restoring configurationinstance w/ controller= ")).append(((NonConfigurationInstance) (overlaysettings)).b).toString());
            } else
            {
                MMLog.b("AdViewOverlayView", "Null configurationinstance ");
            }
        } else
        {
            overlaysettings = null;
        }
        f1 = adviewoverlayactivity.b.getResources().getDisplayMetrics().density;
        if (b.h != 0 && b.i != 0)
        {
            obj = new android.widget.RelativeLayout.LayoutParams((int)((float)b.i * f1), (int)((float)b.h * f1));
        } else
        {
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        }
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = Integer.valueOf((int)(0.0625F * f1 * (float)b.d));
        setPadding(((Integer) (obj)).intValue(), ((Integer) (obj)).intValue(), ((Integer) (obj)).intValue(), ((Integer) (obj)).intValue());
        adviewoverlayactivity = new Button(adviewoverlayactivity.b);
        adviewoverlayactivity.setId(301);
        adviewoverlayactivity.setContentDescription("mraidCloseButton");
        k = new CloseTopDrawable(f1);
        adviewoverlayactivity.setOnClickListener(new android.view.View.OnClickListener() {

            private AdViewOverlayView a;

            public void onClick(View view)
            {
                MMLog.a("AdViewOverlayView", "Close button clicked.");
                a.b();
            }

            
            {
                a = AdViewOverlayView.this;
                super();
            }
        });
        i = (int)(50F * f1 + 0.5F);
        obj = new android.widget.RelativeLayout.LayoutParams(i, i);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        adviewoverlayactivity.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        adviewoverlayactivity.post(new SetCloseButtonTouchDelegateRunnable(adviewoverlayactivity, ((android.widget.RelativeLayout.LayoutParams) (obj)).topMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).leftMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).bottomMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).rightMargin));
        d = adviewoverlayactivity;
        if (b.a() && !b.b())
        {
            e.j = b.q;
        }
        MMAdImplController.a(e);
        if (d != null)
        {
            addView(d);
        }
        if (!a && !b.a())
        {
            adviewoverlayactivity = b;
            if (((OverlaySettings) (adviewoverlayactivity)).p && ((OverlaySettings) (adviewoverlayactivity)).q != 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                j();
            }
        }
        adviewoverlayactivity = b;
        if (((OverlaySettings) (adviewoverlayactivity)).b || ((OverlaySettings) (adviewoverlayactivity)).n != null && ((OverlaySettings) (adviewoverlayactivity)).n.isTransparent)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (e != null && e.h != null && e.h.a != null)
            {
                e.h.a.setBackgroundColor(0);
            }
            setBackgroundColor(0);
        } else
        {
            if (e != null && e.h != null && e.h.a != null)
            {
                e.h.a.setBackgroundColor(-1);
            }
            setBackgroundColor(-1);
        }
        adviewoverlayactivity = b;
        if (((OverlaySettings) (adviewoverlayactivity)).n != null && ((OverlaySettings) (adviewoverlayactivity)).n.enableHardwareAccel)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && e != null && e.h != null && e.h.a != null)
        {
            e.h.a.c();
        }
        if (overlaysettings != null) goto _L2; else goto _L1
_L1:
        if (b.c().equals("slideup"))
        {
            adviewoverlayactivity = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            MMLog.a("AdViewOverlayView", "Translate up");
        } else
        {
            if (!b.c().equals("slidedown"))
            {
                continue;
            }
            adviewoverlayactivity = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
            MMLog.a("AdViewOverlayView", "Translate down");
        }
_L4:
        overlaysettings = b;
        if (overlaysettings.c > 0L)
        {
            l = overlaysettings.c;
        } else
        if (overlaysettings.n != null)
        {
            l = overlaysettings.n.transitionTimeInMillis;
        } else
        {
            l = 0L;
        }
        adviewoverlayactivity.setDuration(l);
        startAnimation(adviewoverlayactivity);
_L2:
        do
        {
            adviewoverlayactivity = b;
            if (((OverlaySettings) (adviewoverlayactivity)).a || ((OverlaySettings) (adviewoverlayactivity)).n != null && ((OverlaySettings) (adviewoverlayactivity)).n.useCustomClose)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a(flag1);
            return;
        } while (!b.c().equals("explode"));
        adviewoverlayactivity = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
        MMLog.a("AdViewOverlayView", "Explode");
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(AdViewOverlayView adviewoverlayview)
    {
        if (!adviewoverlayview.a && adviewoverlayview.j != null)
        {
            adviewoverlayview.a = true;
            adviewoverlayview.j.setVisibility(8);
            adviewoverlayview.removeView(adviewoverlayview.j);
            adviewoverlayview.j = null;
        }
    }

    static Button b(AdViewOverlayView adviewoverlayview)
    {
        return adviewoverlayview.d;
    }

    static ProgressBar c(AdViewOverlayView adviewoverlayview)
    {
        return adviewoverlayview.j;
    }

    static void d(AdViewOverlayView adviewoverlayview)
    {
        adviewoverlayview.j();
    }

    private void j()
    {
        Object obj = (AdViewOverlayActivity)c.get();
        if (obj != null)
        {
            j = new ProgressBar(((AdViewOverlayActivity) (obj)).b);
            j.setIndeterminate(true);
            j.setVisibility(0);
            obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            addView(j, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
    }

    final void a()
    {
        post(new Runnable() {

            private AdViewOverlayView a;

            public void run()
            {
                a.b();
            }

            
            {
                a = AdViewOverlayView.this;
                super();
            }
        });
    }

    final void a(boolean flag)
    {
        b.a = flag;
        Button button = d;
        Object obj;
        if (flag)
        {
            obj = null;
        } else
        {
            obj = k;
        }
        button.setBackgroundDrawable(((Drawable) (obj)));
    }

    final void b()
    {
        MMLog.b("AdViewOverlayView", "Ad overlay closed");
        if ((Activity)getContext() == null)
        {
            return;
        } else
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation.setAnimationListener(new AnimationListener());
            alphaanimation.setFillEnabled(true);
            alphaanimation.setFillBefore(true);
            alphaanimation.setFillAfter(true);
            alphaanimation.setDuration(400L);
            startAnimation(alphaanimation);
            return;
        }
    }

    final void c()
    {
        super.c();
        d();
    }

    final void d()
    {
        if (d != null)
        {
            d.bringToFront();
        }
    }

    final void e()
    {
        removeView(h);
        addView(h, i.getCustomLayoutParams());
        d();
    }

    final void f()
    {
        removeView(h);
        addView(h, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        d();
    }

    private class AdViewOverlayViewMMAdImpl extends MMLayout.MMLayoutMMAdImpl
    {
        private class OverlayWebViewClientListener extends MMAdImpl.BasicWebViewClientListener
        {

            public void onPageFinished(String s)
            {
                super.onPageFinished(s);
                s = (MMAdImpl)a.get();
                if (s != null)
                {
                    s.a();
                }
            }

            OverlayWebViewClientListener(MMAdImpl mmadimpl)
            {
                super(mmadimpl);
            }
        }


        private AdViewOverlayView k;

        final void a()
        {
            AdViewOverlayView.a(k);
        }

        final boolean b()
        {
            if (k.b.b())
            {
                OverlaySettings overlaysettings = k.b;
                boolean flag;
                if (!overlaysettings.o)
                {
                    overlaysettings.o = true;
                    flag = false;
                } else
                {
                    flag = true;
                }
                if (!flag)
                {
                    return true;
                }
            }
            return false;
        }

        final MMWebViewClient c()
        {
            MMLog.b("AdViewOverlayView", (new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(k.e).toString());
            if (k.e.j != 0L || k.b.b())
            {
                return new BannerExpandedWebViewClient(i, new OverlayRedirectionListenerImpl(this));
            } else
            {
                return new InterstitialWebViewClient(i, new OverlayRedirectionListenerImpl(this));
            }
        }

        public AdViewOverlayViewMMAdImpl(Context context)
        {
            k = AdViewOverlayView.this;
            super(AdViewOverlayView.this, context);
            i = new OverlayWebViewClientListener(this);
        }

        private class OverlayRedirectionListenerImpl extends MMAdImpl.MMAdImplRedirectionListenerImpl
        {

            public boolean isExpandingToUrl()
            {
                MMAdImpl mmadimpl = (MMAdImpl)f.get();
                if (mmadimpl != null && (mmadimpl instanceof AdViewOverlayViewMMAdImpl))
                {
                    return mmadimpl.b();
                } else
                {
                    return false;
                }
            }

            public OverlayRedirectionListenerImpl(MMAdImpl mmadimpl)
            {
                super(mmadimpl);
            }
        }

    }


    private class NonConfigurationInstance
    {

        boolean a;
        MMAdImplController b;
        OverlaySettings c;

        private NonConfigurationInstance()
        {
        }

        NonConfigurationInstance(byte byte0)
        {
            this();
        }
    }


    private class CloseTopDrawable extends CloseDrawable
    {
        private class CloseDrawable extends Drawable
        {

            protected final Paint a = new Paint();
            private boolean b;

            public void draw(Canvas canvas)
            {
                Rect rect = copyBounds();
                int i = rect.right - rect.left;
                int l = rect.bottom - rect.top;
                float f1 = (float)i / 6F;
                a.setStrokeWidth(f1);
                char c1;
                if (b)
                {
                    c1 = '\377';
                } else
                {
                    c1 = 'P';
                }
                a.setARGB(255, c1, c1, c1);
                canvas.drawLine(f1 / 2.0F, f1 / 2.0F, (float)i - f1 / 2.0F, (float)l - f1 / 2.0F, a);
                canvas.drawLine((float)i - f1 / 2.0F, f1 / 2.0F, f1 / 2.0F, (float)l - f1 / 2.0F, a);
            }

            public int getOpacity()
            {
                return -3;
            }

            public void setAlpha(int i)
            {
            }

            public void setColorFilter(ColorFilter colorfilter)
            {
            }

            CloseDrawable(boolean flag)
            {
                b = true;
                b = true;
                a.setAntiAlias(true);
                a.setStyle(android.graphics.Paint.Style.STROKE);
            }
        }


        private float b;
        private float c;

        public void draw(Canvas canvas)
        {
            Rect rect = copyBounds();
            float f1 = (float)(rect.right - rect.left) / 10F;
            float f2 = (float)rect.right - b * 20F;
            float f3 = (float)rect.top + b * 20F;
            a.setStrokeWidth(f1);
            a.setColor(0xff000000);
            a.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawCircle(f2, f3, 12F * b, a);
            a.setColor(-1);
            a.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(f2, f3, b * 10F, a);
            a.setColor(0xff000000);
            canvas.drawCircle(f2, f3, 7F * b, a);
            a.setColor(-1);
            a.setStrokeWidth(f1 / 2.0F);
            a.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawLine(f2 - c, f3 - c, f2 + c, f3 + c, a);
            canvas.drawLine(f2 + c, f3 - c, f2 - c, f3 + c, a);
        }

        CloseTopDrawable(float f1)
        {
            super(true);
            b = f1;
            c = 4F * f1;
            a.setColor(0xff000000);
        }
    }


    private class SetCloseButtonTouchDelegateRunnable
        implements Runnable
    {

        private int a;
        private int b;
        private int c;
        private int d;
        private final Button e;

        public void run()
        {
            Object obj = new Rect();
            e.getHitRect(((Rect) (obj)));
            obj.top = ((Rect) (obj)).top + a;
            obj.right = ((Rect) (obj)).right + d;
            obj.bottom = ((Rect) (obj)).bottom + c;
            obj.left = ((Rect) (obj)).left + b;
            obj = new TouchDelegate(((Rect) (obj)), e);
            if (android/view/View.isInstance(e.getParent()))
            {
                ((View)e.getParent()).setTouchDelegate(((TouchDelegate) (obj)));
            }
        }

        SetCloseButtonTouchDelegateRunnable(Button button, int i, int l, int i1, int j1)
        {
            e = button;
            a = i;
            b = l;
            c = i1;
            d = j1;
        }
    }


    private class AnimationListener
        implements android.view.animation.Animation.AnimationListener
    {

        private WeakReference a;

        public void onAnimationEnd(Animation animation)
        {
            animation = (AdViewOverlayView)a.get();
            if (animation != null)
            {
                animation = (Activity)animation.getContext();
                MMLog.b("AdViewOverlayView", "Finishing overlay this is in w/ anim finishOverLayWithAnim()");
                animation.finish();
            }
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
            animation = (AdViewOverlayView)a.get();
            if (animation != null && AdViewOverlayView.b(animation) != null)
            {
                AdViewOverlayView.b(animation).setVisibility(8);
            }
        }

        public AnimationListener()
        {
            a = new WeakReference(AdViewOverlayView.this);
        }
    }

}
