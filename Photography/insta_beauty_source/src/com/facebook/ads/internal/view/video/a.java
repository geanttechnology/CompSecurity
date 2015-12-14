// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.video;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.NativeAdVideoActivity;
import com.facebook.ads.internal.adapters.d;
import com.facebook.ads.internal.util.b;
import com.facebook.ads.internal.util.c;
import com.facebook.ads.internal.util.o;
import java.util.HashMap;

public class a extends FrameLayout
{

    private com.facebook.ads.internal.view.video.support.a a;
    private d b;
    private c c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private boolean h;
    private int i;
    private Handler j;
    private Handler k;
    private Runnable l;
    private Runnable m;
    private float n;

    public a(Context context)
    {
        super(context);
        e();
    }

    static int a(a a1, int i1)
    {
        a1.i = i1;
        return i1;
    }

    private void a(Context context, Intent intent)
    {
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        intent.putExtra("useNativeCloseButton", true);
        intent.putExtra("viewType", com.facebook.ads.InterstitialAdActivity.Type.VIDEO);
        intent.putExtra("videoURL", getVideoURI());
        intent.putExtra("videoPlayReportURL", getVideoPlayReportURI());
        intent.putExtra("videoTimeReportURL", getVideoTimeReportURI());
        intent.putExtra("predefinedOrientationKey", 13);
        intent.addFlags(0x10000000);
    }

    static void a(a a1)
    {
        a1.g();
    }

    private boolean a(Class class1)
    {
        try
        {
            Context context = getContext();
            class1 = new Intent(context, class1);
            a(context, ((Intent) (class1)));
            context.startActivity(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            com.facebook.ads.internal.util.c.a(com.facebook.ads.internal.util.b.a(class1, "Error occurred while loading fullscreen video activity."));
            return false;
        }
        return true;
    }

    static c b(a a1)
    {
        return a1.c;
    }

    static com.facebook.ads.internal.view.video.support.a c(a a1)
    {
        return a1.a;
    }

    static int d(a a1)
    {
        return a1.i;
    }

    static Handler e(a a1)
    {
        return a1.k;
    }

    private void e()
    {
        n = 0.0F;
        Object obj = new RelativeLayout(getContext());
        Object obj1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout) (obj)).setGravity(17);
        ((RelativeLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        setBackgroundColor(0);
        obj1 = getContext();
        a = new com.facebook.ads.internal.view.video.support.a(((Context) (obj1)));
        a.setBackgroundColor(0);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(10, -1);
        layoutparams.addRule(12, -1);
        layoutparams.addRule(11, -1);
        layoutparams.addRule(9, -1);
        a.setLayoutParams(layoutparams);
        a.setFrameVideoViewListener(new _cls1(this));
        ((RelativeLayout) (obj)).addView(a);
        addView(((View) (obj)));
        k = new Handler();
        l = new b();
        k.postDelayed(l, 250L);
        j = new Handler();
        m = new a();
        j.postDelayed(m, 250L);
        b = new d(((Context) (obj1)), this, 50, true, new _cls2(this));
        b.a(0);
        b.b(250);
        b.a();
        setOnTouchListenerInternal(new _cls3(this));
        setOnClickListenerInternal(new _cls4(this));
        c = new c(((Context) (obj1)));
        obj = new android.widget.FrameLayout.LayoutParams(100, 100, 80);
        c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        c.setOnTouchListener(new _cls5());
        c.setOnClickListener(new _cls6());
        addView(c);
    }

    static Handler f(com.facebook.ads.internal.view.video.a a1)
    {
        return a1.j;
    }

    private void f()
    {
        if (!h && getVideoTimeReportURI() != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("time", Integer.toString(i / 1000));
            hashmap.put("inline", "1");
            (new o(hashmap)).execute(new String[] {
                getVideoTimeReportURI()
            });
            h = true;
            i = 0;
        }
    }

    private void g()
    {
        if (!a(com/facebook/ads/NativeAdVideoActivity))
        {
            a(com/facebook/ads/InterstitialAdActivity);
        }
    }

    private void setOnClickListenerInternal(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(onclicklistener);
    }

    private void setOnTouchListenerInternal(android.view.View.OnTouchListener ontouchlistener)
    {
        super.setOnTouchListener(ontouchlistener);
    }

    public void a()
    {
        if (i > 0)
        {
            f();
            i = 0;
        }
    }

    public void b()
    {
        d = null;
    }

    public void c()
    {
        c.a(c, false);
        a.a();
    }

    public void d()
    {
        c.a(c, true);
        a.b();
    }

    public boolean getAutoplay()
    {
        return g;
    }

    public String getVideoPlayReportURI()
    {
        return e;
    }

    public String getVideoTimeReportURI()
    {
        return f;
    }

    public String getVideoURI()
    {
        return d;
    }

    float getVolume()
    {
        return n;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        b.a();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        f();
        b.b();
    }

    public void setAutoplay(boolean flag)
    {
        g = flag;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
    }

    public void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
    }

    public void setVideoPlayReportURI(String s)
    {
        e = s;
    }

    public void setVideoTimeReportURI(String s)
    {
        a();
        f = s;
    }

    public void setVideoURI(String s)
    {
        d = s;
        if (s != null)
        {
            a.setup(Uri.parse(s));
            if (g)
            {
                a.a();
            }
        }
    }

    void setVolume(float f1)
    {
        n = f1;
    }

    private class _cls1
        implements com.facebook.ads.internal.view.video.support.b
    {

        final com.facebook.ads.internal.view.video.a a;
        final com.facebook.ads.internal.view.video.a b;

        public void a(MediaPlayer mediaplayer)
        {
            MediaPlayer mediaplayer1 = mediaplayer;
            if (mediaplayer.isPlaying())
            {
                mediaplayer.stop();
                mediaplayer.release();
                mediaplayer1 = new MediaPlayer();
            }
            mediaplayer1.setVolume(b.getVolume(), b.getVolume());
            mediaplayer1.setLooping(false);
            if (a.getAutoplay())
            {
                a.c();
                return;
            }
            try
            {
                a.d();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (MediaPlayer mediaplayer)
            {
                mediaplayer.printStackTrace();
            }
            return;
        }

        _cls1(a a2)
        {
            b = a.this;
            a = a2;
            super();
        }
    }


    private class b extends t
    {

        public void run()
        {
            com.facebook.ads.internal.view.video.a a1;
            for (a1 = (com.facebook.ads.internal.view.video.a)a(); a1 == null || a1 == null;)
            {
                return;
            }

            int i1 = com.facebook.ads.internal.view.video.a.c(a1).getCurrentPosition();
            if (i1 > com.facebook.ads.internal.view.video.a.d(a1))
            {
                com.facebook.ads.internal.view.video.a.a(a1, i1);
            }
            com.facebook.ads.internal.view.video.a.e(a1).postDelayed(this, 250L);
        }

        public b()
        {
        }
    }


    private class a extends t
    {

        public void run()
        {
            com.facebook.ads.internal.view.video.a a1 = (com.facebook.ads.internal.view.video.a)a();
            if (a1 == null)
            {
                return;
            }
            if (com.facebook.ads.internal.view.video.a.c(a1).getCurrentPosition() > 3000)
            {
                (new o()).execute(new String[] {
                    a1.getVideoPlayReportURI()
                });
                return;
            } else
            {
                com.facebook.ads.internal.view.video.a.f(a1).postDelayed(this, 250L);
                return;
            }
        }

        public a()
        {
        }
    }


    private class _cls2 extends com.facebook.ads.internal.adapters.d.a
    {

        final com.facebook.ads.internal.view.video.a a;
        final com.facebook.ads.internal.view.video.a b;

        public void a()
        {
            if (a.getAutoplay())
            {
                b.c();
                return;
            } else
            {
                b.d();
                return;
            }
        }

        public void b()
        {
            b.d();
        }

        _cls2(com.facebook.ads.internal.view.video.a a2)
        {
            b = com.facebook.ads.internal.view.video.a.this;
            a = a2;
            super();
        }
    }


    private class _cls3
        implements android.view.View.OnTouchListener
    {

        final com.facebook.ads.internal.view.video.a a;
        final com.facebook.ads.internal.view.video.a b;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1 && a.getVideoURI() != null)
            {
                com.facebook.ads.internal.view.video.a.a(b);
                return true;
            } else
            {
                return false;
            }
        }

        _cls3(com.facebook.ads.internal.view.video.a a2)
        {
            b = com.facebook.ads.internal.view.video.a.this;
            a = a2;
            super();
        }
    }


    private class _cls4
        implements android.view.View.OnClickListener
    {

        final com.facebook.ads.internal.view.video.a a;
        final com.facebook.ads.internal.view.video.a b;

        public void onClick(View view)
        {
            if (a.getVideoURI() != null)
            {
                com.facebook.ads.internal.view.video.a.a(b);
            }
        }

        _cls4(com.facebook.ads.internal.view.video.a a2)
        {
            b = com.facebook.ads.internal.view.video.a.this;
            a = a2;
            super();
        }
    }


    private class c extends Button
    {

        final com.facebook.ads.internal.view.video.a a;
        private Paint b;
        private Path c;
        private Path d;
        private Path e;
        private int f;
        private boolean g;

        private void a()
        {
            f = 60;
            c = new Path();
            d = new Path();
            e = new Path();
            class _cls1 extends Paint
            {

                final c a;

                _cls1()
                {
                    a = c.this;
                    super();
                    setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
                    setStrokeCap(android.graphics.Paint.Cap.ROUND);
                    setStrokeWidth(3F);
                    setAntiAlias(true);
                    setColor(-1);
                }
            }

            b = new _cls1();
            b();
            setClickable(true);
            setBackgroundColor(0);
        }

        static void a(c c1, boolean flag)
        {
            c1.a(flag);
        }

        private void a(boolean flag)
        {
            g = flag;
            refreshDrawableState();
            invalidate();
        }

        static boolean a(c c1)
        {
            return c1.c();
        }

        private void b()
        {
            Object obj = getResources().getDisplayMetrics();
            int i1 = (int)((float)f * ((DisplayMetrics) (obj)).density);
            float f1 = f;
            obj = new android.widget.RelativeLayout.LayoutParams(i1, (int)(((DisplayMetrics) (obj)).density * f1));
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
            setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        }

        private boolean c()
        {
            return g;
        }

        protected void onDraw(Canvas canvas)
        {
            if (canvas.isHardwareAccelerated() && android.os.Build.VERSION.SDK_INT < 17)
            {
                setLayerType(1, null);
            }
            float f1 = (float)Math.max(canvas.getWidth(), canvas.getHeight()) / 100F;
            if (c())
            {
                e.rewind();
                e.moveTo(26.5F * f1, 15.5F * f1);
                e.lineTo(26.5F * f1, 84.5F * f1);
                e.lineTo(82.5F * f1, 50.5F * f1);
                e.lineTo(26.5F * f1, f1 * 15.5F);
                e.close();
                canvas.drawPath(e, b);
            } else
            {
                c.rewind();
                c.moveTo(29F * f1, 21F * f1);
                c.lineTo(29F * f1, 79F * f1);
                c.lineTo(45F * f1, 79F * f1);
                c.lineTo(45F * f1, 21F * f1);
                c.lineTo(29F * f1, 21F * f1);
                c.close();
                d.rewind();
                d.moveTo(55F * f1, 21F * f1);
                d.lineTo(55F * f1, 79F * f1);
                d.lineTo(71F * f1, 79F * f1);
                d.lineTo(71F * f1, 21F * f1);
                d.lineTo(55F * f1, f1 * 21F);
                d.close();
                canvas.drawPath(c, b);
                canvas.drawPath(d, b);
            }
            super.onDraw(canvas);
        }

        public c(Context context)
        {
            a = com.facebook.ads.internal.view.video.a.this;
            super(context);
            a();
        }
    }


    private class _cls5
        implements android.view.View.OnTouchListener
    {

        final com.facebook.ads.internal.view.video.a a;

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getAction() == 1)
            {
                if (c.a(com.facebook.ads.internal.view.video.a.b(a)))
                {
                    a.c();
                    return true;
                } else
                {
                    a.d();
                    return true;
                }
            } else
            {
                return false;
            }
        }

        _cls5()
        {
            a = com.facebook.ads.internal.view.video.a.this;
            super();
        }
    }


    private class _cls6
        implements android.view.View.OnClickListener
    {

        final com.facebook.ads.internal.view.video.a a;

        public void onClick(View view)
        {
            if (c.a(com.facebook.ads.internal.view.video.a.b(a)))
            {
                a.c();
                return;
            } else
            {
                a.d();
                return;
            }
        }

        _cls6()
        {
            a = com.facebook.ads.internal.view.video.a.this;
            super();
        }
    }

}
