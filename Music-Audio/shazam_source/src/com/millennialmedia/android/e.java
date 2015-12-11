// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.TouchDelegate;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

// Referenced classes of package com.millennialmedia.android:
//            ak, d, ab, ac, 
//            al, MMActivity, OverlaySettings, HttpMMHeaders, 
//            ao, f, z, ap, 
//            w

final class com.millennialmedia.android.e extends ak
{
    final class a extends ak.b
    {

        final com.millennialmedia.android.e a;

        final void a()
        {
            com.millennialmedia.android.e.a(a);
        }

        final boolean b()
        {
            if (a.b.b())
            {
                OverlaySettings overlaysettings = a.b;
                boolean flag;
                if (!overlaysettings.p)
                {
                    overlaysettings.p = true;
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

        final ap c()
        {
            (new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(a.h);
            al.b();
            if (a.h.o != 0L || a.b.b())
            {
                com.millennialmedia.android.f f1 = new com.millennialmedia.android.f(n, new g(this));
                m = f1;
                return f1;
            } else
            {
                z z1 = new z(n, new g(this));
                m = z1;
                return z1;
            }
        }

        public a(Context context)
        {
            a = com.millennialmedia.android.e.this;
            super(com.millennialmedia.android.e.this, context);
            n = new h(this);
        }
    }

    private static final class b
        implements android.view.animation.Animation.AnimationListener
    {

        private WeakReference a;

        public final void onAnimationEnd(Animation animation)
        {
            animation = (com.millennialmedia.android.e)a.get();
            if (animation != null)
            {
                animation = (Activity)animation.getContext();
                al.b();
                animation.finish();
            }
        }

        public final void onAnimationRepeat(Animation animation)
        {
        }

        public final void onAnimationStart(Animation animation)
        {
            animation = (com.millennialmedia.android.e)a.get();
            if (animation != null && com.millennialmedia.android.e.b(animation) != null)
            {
                com.millennialmedia.android.e.b(animation).setVisibility(8);
            }
        }

        public b(com.millennialmedia.android.e e1)
        {
            a = new WeakReference(e1);
        }
    }

    private static class c extends Drawable
    {

        protected boolean a;
        protected final Paint b = new Paint();

        public void draw(Canvas canvas)
        {
            Rect rect = copyBounds();
            int j = rect.right - rect.left;
            int k = rect.bottom - rect.top;
            float f1 = (float)j / 6F;
            b.setStrokeWidth(f1);
            char c1;
            if (a)
            {
                c1 = '\377';
            } else
            {
                c1 = 'P';
            }
            b.setARGB(255, c1, c1, c1);
            canvas.drawLine(f1 / 2.0F, f1 / 2.0F, (float)j - f1 / 2.0F, (float)k - f1 / 2.0F, b);
            canvas.drawLine((float)j - f1 / 2.0F, f1 / 2.0F, f1 / 2.0F, (float)k - f1 / 2.0F, b);
        }

        public int getOpacity()
        {
            return -3;
        }

        public void setAlpha(int j)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }

        c()
        {
            a = true;
            a = true;
            b.setAntiAlias(true);
            b.setStyle(android.graphics.Paint.Style.STROKE);
        }
    }

    private static final class d extends c
    {

        final float c;
        final float d;

        public final void draw(Canvas canvas)
        {
            Rect rect = copyBounds();
            float f1 = (float)(rect.right - rect.left) / 10F;
            float f2 = (float)rect.right - c * 20F;
            float f3 = (float)rect.top + c * 20F;
            b.setStrokeWidth(f1);
            b.setColor(0xff000000);
            b.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawCircle(f2, f3, 12F * c, b);
            b.setColor(-1);
            b.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(f2, f3, c * 10F, b);
            b.setColor(0xff000000);
            canvas.drawCircle(f2, f3, 7F * c, b);
            b.setColor(-1);
            b.setStrokeWidth(f1 / 2.0F);
            b.setStyle(android.graphics.Paint.Style.STROKE);
            canvas.drawLine(f2 - d, f3 - d, f2 + d, f3 + d, b);
            canvas.drawLine(f2 + d, f3 - d, f2 - d, f3 + d, b);
        }

        d(float f1)
        {
            c = f1;
            d = 4F * f1;
            b.setColor(0xff000000);
        }
    }

    private static final class e extends AsyncTask
    {

        private String a;
        private boolean b;
        private WeakReference c;

        private transient String a()
        {
            b = true;
            if (TextUtils.isEmpty(a))
            {
                break MISSING_BLOCK_LABEL_98;
            }
            Object obj = (new w()).a(a);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            StatusLine statusline = ((HttpResponse) (obj)).getStatusLine();
            if (obj == null || statusline == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            if (statusline.getStatusCode() == 404)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            obj = ((HttpResponse) (obj)).getEntity();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_98;
            }
            obj = w.a(((HttpEntity) (obj)).getContent());
            b = false;
            return ((String) (obj));
            Exception exception;
            exception;
            al.a("AdViewOverlayView", "Unable to get weboverlay", exception);
            return null;
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (String)obj;
            com.millennialmedia.android.e e1 = (com.millennialmedia.android.e)c.get();
            if (e1 != null)
            {
                if (b)
                {
                    com.millennialmedia.android.d d1 = (com.millennialmedia.android.d)e1.c.get();
                    if (d1 != null)
                    {
                        d1.a();
                    } else
                    {
                        com.millennialmedia.android.e.a(e1);
                    }
                }
                if (obj != null && e1.h != null && e1.h.l != null)
                {
                    e1.h.l.a(((String) (obj)), a);
                }
            }
        }

        protected final void onPreExecute()
        {
            com.millennialmedia.android.e e1 = (com.millennialmedia.android.e)c.get();
            if (e1 != null && com.millennialmedia.android.e.c(e1) == null)
            {
                com.millennialmedia.android.e.d(e1);
            }
            super.onPreExecute();
        }

        public e(com.millennialmedia.android.e e1, String s)
        {
            a = s;
            c = new WeakReference(e1);
        }
    }

    private static final class f
    {

        boolean a;
        ac b;
        OverlaySettings c;

        private f()
        {
        }

        f(byte byte0)
        {
            this();
        }
    }

    static final class g extends ab.b
    {

        public final boolean a()
        {
            ab ab1 = (ab)f.get();
            if (ab1 != null && (ab1 instanceof a))
            {
                return ab1.b();
            } else
            {
                return false;
            }
        }

        public g(ab ab1)
        {
            super(ab1);
        }
    }

    private static final class h extends ab.a
    {

        public final void a(String s)
        {
            super.a(s);
            s = (ab)a.get();
            if (s != null)
            {
                s.a();
            }
        }

        h(ab ab1)
        {
            super(ab1);
        }
    }

    private static final class i
        implements Runnable
    {

        int a;
        int b;
        int c;
        int d;
        private final Button e;

        public final void run()
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

        i(Button button, int j, int k, int l, int i1)
        {
            e = button;
            a = j;
            b = k;
            c = l;
            d = i1;
        }
    }


    boolean a;
    OverlaySettings b;
    WeakReference c;
    d d;
    private Button e;
    private ProgressBar f;

    com.millennialmedia.android.e(com.millennialmedia.android.d d1, OverlaySettings overlaysettings)
    {
        super(d1.d);
        c = new WeakReference(d1);
        h = new a(d1.d);
        setId(15062);
        h.f = "i";
        b = overlaysettings;
        float f1;
        Object obj;
        int j;
        boolean flag;
        long l;
        boolean flag1;
        if (d1.d instanceof Activity)
        {
            overlaysettings = (f)d1.d.getLastNonConfigurationInstance();
            if (overlaysettings != null)
            {
                a = ((f) (overlaysettings)).a;
                h.l = ((f) (overlaysettings)).b;
                b = ((f) (overlaysettings)).c;
                if (h != null && h.l != null && h.l.b != null)
                {
                    addView(h.l.b);
                }
                (new StringBuilder("Restoring configurationinstance w/ controller= ")).append(((f) (overlaysettings)).b);
            }
            al.b();
        } else
        {
            overlaysettings = null;
        }
        f1 = d1.d.getResources().getDisplayMetrics().density;
        if (b.i != 0 && b.j != 0)
        {
            obj = new android.widget.RelativeLayout.LayoutParams((int)((float)b.j * f1), (int)((float)b.i * f1));
        } else
        {
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        }
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        obj = Integer.valueOf((int)(0.0625F * f1 * (float)b.e));
        setPadding(((Integer) (obj)).intValue(), ((Integer) (obj)).intValue(), ((Integer) (obj)).intValue(), ((Integer) (obj)).intValue());
        d1 = new Button(d1.d);
        d1.setId(301);
        d1.setContentDescription("mraidCloseButton");
        d = new d(f1);
        d1.setOnClickListener(new android.view.View.OnClickListener() {

            final com.millennialmedia.android.e a;

            public final void onClick(View view)
            {
                al.a();
                a.b();
            }

            
            {
                a = com.millennialmedia.android.e.this;
                super();
            }
        });
        j = (int)(50F * f1 + 0.5F);
        obj = new android.widget.RelativeLayout.LayoutParams(j, j);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        d1.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        d1.post(new i(d1, ((android.widget.RelativeLayout.LayoutParams) (obj)).topMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).leftMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).bottomMargin, ((android.widget.RelativeLayout.LayoutParams) (obj)).rightMargin));
        e = d1;
        if (b.a() && !b.b())
        {
            h.o = b.r;
        }
        ac.a(h);
        if (e != null)
        {
            addView(e);
        }
        if (!a && !b.a())
        {
            d1 = b;
            if (((OverlaySettings) (d1)).q && ((OverlaySettings) (d1)).r != 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                e();
            }
        }
        d1 = b;
        if (((OverlaySettings) (d1)).b || ((OverlaySettings) (d1)).o != null && ((OverlaySettings) (d1)).o.a)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (h != null && h.l != null && h.l.b != null)
            {
                h.l.b.setBackgroundColor(0);
            }
            setBackgroundColor(0);
        } else
        {
            if (h != null && h.l != null && h.l.b != null)
            {
                h.l.b.setBackgroundColor(-1);
            }
            setBackgroundColor(-1);
        }
        d1 = b;
        if (((OverlaySettings) (d1)).o != null && ((OverlaySettings) (d1)).o.e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && h != null && h.l != null && h.l.b != null)
        {
            h.l.b.c();
        }
        if (overlaysettings != null) goto _L2; else goto _L1
_L1:
        if (b.c().equals("slideup"))
        {
            d1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            al.a();
        } else
        {
            if (!b.c().equals("slidedown"))
            {
                continue;
            }
            d1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
            al.a();
        }
_L4:
        overlaysettings = b;
        if (overlaysettings.c > 0L)
        {
            l = overlaysettings.c;
        } else
        if (overlaysettings.o != null)
        {
            l = overlaysettings.o.b;
        } else
        {
            l = 0L;
        }
        d1.setDuration(l);
        startAnimation(d1);
_L2:
        do
        {
            d1 = b;
            if (((OverlaySettings) (d1)).a || ((OverlaySettings) (d1)).o != null && ((OverlaySettings) (d1)).o.d)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a(flag1);
            return;
        } while (!b.c().equals("explode"));
        d1 = new ScaleAnimation(1.1F, 0.9F, 0.1F, 0.9F, 1, 0.5F, 1, 0.5F);
        al.a();
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void a(com.millennialmedia.android.e e1)
    {
        if (!e1.a && e1.f != null)
        {
            e1.a = true;
            e1.f.setVisibility(8);
            e1.removeView(e1.f);
            e1.f = null;
        }
    }

    static Button b(com.millennialmedia.android.e e1)
    {
        return e1.e;
    }

    static ProgressBar c(com.millennialmedia.android.e e1)
    {
        return e1.f;
    }

    static void d(com.millennialmedia.android.e e1)
    {
        e1.e();
    }

    private void e()
    {
        Object obj = (com.millennialmedia.android.d)c.get();
        if (obj != null)
        {
            f = new ProgressBar(((com.millennialmedia.android.d) (obj)).d);
            f.setIndeterminate(true);
            f.setVisibility(0);
            obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            addView(f, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
    }

    final void a()
    {
        post(new Runnable() {

            final com.millennialmedia.android.e a;

            public final void run()
            {
                a.b();
            }

            
            {
                a = com.millennialmedia.android.e.this;
                super();
            }
        });
    }

    final void a(boolean flag)
    {
        b.a = flag;
        Button button = e;
        Object obj;
        if (flag)
        {
            obj = null;
        } else
        {
            obj = d;
        }
        button.setBackgroundDrawable(((Drawable) (obj)));
    }

    final void b()
    {
        al.b();
        if ((Activity)getContext() == null)
        {
            return;
        } else
        {
            AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
            alphaanimation.setAnimationListener(new b(this));
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
        if (e != null)
        {
            e.bringToFront();
        }
    }
}
