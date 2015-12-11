// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.a.b.j;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import com.facebook.ads.a.f.o;
import com.facebook.ads.a.f.u;
import com.facebook.ads.a.g.a.a.e;
import com.facebook.ads.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class com.facebook.ads.a.g.a.a extends FrameLayout
{
    private static final class a extends u
    {

        public final void run()
        {
            com.facebook.ads.a.g.a.a a1 = (com.facebook.ads.a.g.a.a)super.a.get();
            if (a1 == null)
            {
                return;
            }
            if (com.facebook.ads.a.g.a.a.c(a1).getCurrentPosition() > 3000)
            {
                (new o()).execute(new String[] {
                    a1.getVideoPlayReportURI()
                });
                return;
            } else
            {
                com.facebook.ads.a.g.a.a.f(a1).postDelayed(this, 250L);
                return;
            }
        }

        public a(com.facebook.ads.a.g.a.a a1)
        {
            super(a1);
        }
    }

    private static final class b extends u
    {

        public final void run()
        {
            com.facebook.ads.a.g.a.a a1;
            for (a1 = (com.facebook.ads.a.g.a.a)super.a.get(); a1 == null || a1 == null;)
            {
                return;
            }

            int i1 = com.facebook.ads.a.g.a.a.c(a1).getCurrentPosition();
            if (i1 > com.facebook.ads.a.g.a.a.d(a1))
            {
                com.facebook.ads.a.g.a.a.a(a1, i1);
            }
            com.facebook.ads.a.g.a.a.e(a1).postDelayed(this, 250L);
        }

        public b(com.facebook.ads.a.g.a.a a1)
        {
            super(a1);
        }
    }

    final class c extends Button
    {

        final com.facebook.ads.a.g.a.a a;
        private Paint b;
        private Path c;
        private Path d;
        private Path e;
        private int f;
        private boolean g;

        static void a(c c1, boolean flag)
        {
            c1.g = flag;
            c1.refreshDrawableState();
            c1.invalidate();
        }

        static boolean a(c c1)
        {
            return c1.g;
        }

        protected final void onDraw(Canvas canvas)
        {
            if (canvas.isHardwareAccelerated() && android.os.Build.VERSION.SDK_INT < 17)
            {
                setLayerType(1, null);
            }
            float f1 = (float)Math.max(canvas.getWidth(), canvas.getHeight()) / 100F;
            if (g)
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
            a = com.facebook.ads.a.g.a.a.this;
            super(context);
            f = 60;
            c = new Path();
            d = new Path();
            e = new Path();
            b = new _cls1(this);
            a1 = getResources().getDisplayMetrics();
            int i1 = (int)((float)f * density);
            float f1 = f;
            a1 = new android.widget.RelativeLayout.LayoutParams(i1, (int)(density * f1));
            addRule(9);
            addRule(12);
            setLayoutParams(com.facebook.ads.a.g.a.a.this);
            setClickable(true);
            setBackgroundColor(0);
        }
    }


    public String a;
    private com.facebook.ads.a.g.a.a.a b;
    private j c;
    private c d;
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

    public com.facebook.ads.a.g.a.a(Context context)
    {
        super(context);
        n = 0.0F;
        context = new RelativeLayout(getContext());
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        context.setGravity(17);
        context.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        setBackgroundColor(0);
        obj = getContext();
        b = new com.facebook.ads.a.g.a.a.a(((Context) (obj)));
        b.setBackgroundColor(0);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(10, -1);
        layoutparams.addRule(12, -1);
        layoutparams.addRule(11, -1);
        layoutparams.addRule(9, -1);
        b.setLayoutParams(layoutparams);
        b.setFrameVideoViewListener(new com.facebook.ads.a.g.a.a.b(this) {

            final com.facebook.ads.a.g.a.a a;
            final com.facebook.ads.a.g.a.a b;

            public final void a(MediaPlayer mediaplayer)
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
                    a.b();
                    return;
                }
                try
                {
                    a.c();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (MediaPlayer mediaplayer)
                {
                    mediaplayer.printStackTrace();
                }
                return;
            }

            
            {
                b = com.facebook.ads.a.g.a.a.this;
                a = a2;
                super();
            }
        });
        context.addView(b);
        addView(context);
        k = new Handler();
        l = new b(this);
        k.postDelayed(l, 250L);
        j = new Handler();
        m = new a(this);
        j.postDelayed(m, 250L);
        c = new j(((Context) (obj)), this, 50, true, new com.facebook.ads.a.b.j.a(this) {

            final com.facebook.ads.a.g.a.a a;
            final com.facebook.ads.a.g.a.a b;

            public final void a()
            {
                if (a.getAutoplay())
                {
                    b.b();
                    return;
                } else
                {
                    b.c();
                    return;
                }
            }

            public final void b()
            {
                b.c();
            }

            
            {
                b = com.facebook.ads.a.g.a.a.this;
                a = a2;
                super();
            }
        });
        c.a = 0;
        c.b = 250;
        c.a();
        setOnTouchListenerInternal(new android.view.View.OnTouchListener(this) {

            final com.facebook.ads.a.g.a.a a;
            final com.facebook.ads.a.g.a.a b;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1 && a.getVideoURI() != null)
                {
                    com.facebook.ads.a.g.a.a.a(b);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                b = com.facebook.ads.a.g.a.a.this;
                a = a2;
                super();
            }
        });
        setOnClickListenerInternal(new android.view.View.OnClickListener(this) {

            final com.facebook.ads.a.g.a.a a;
            final com.facebook.ads.a.g.a.a b;

            public final void onClick(View view)
            {
                if (a.getVideoURI() != null)
                {
                    com.facebook.ads.a.g.a.a.a(b);
                }
            }

            
            {
                b = com.facebook.ads.a.g.a.a.this;
                a = a2;
                super();
            }
        });
        d = new c(((Context) (obj)));
        context = new android.widget.FrameLayout.LayoutParams(100, 100, 80);
        d.setLayoutParams(context);
        d.setOnTouchListener(new android.view.View.OnTouchListener() {

            final com.facebook.ads.a.g.a.a a;

            public final boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    if (c.a(com.facebook.ads.a.g.a.a.b(a)))
                    {
                        a.b();
                        return true;
                    } else
                    {
                        a.c();
                        return true;
                    }
                } else
                {
                    return false;
                }
            }

            
            {
                a = com.facebook.ads.a.g.a.a.this;
                super();
            }
        });
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final com.facebook.ads.a.g.a.a a;

            public final void onClick(View view)
            {
                if (c.a(com.facebook.ads.a.g.a.a.b(a)))
                {
                    a.b();
                    return;
                } else
                {
                    a.c();
                    return;
                }
            }

            
            {
                a = com.facebook.ads.a.g.a.a.this;
                super();
            }
        });
        addView(d);
    }

    static int a(com.facebook.ads.a.g.a.a a1, int i1)
    {
        a1.i = i1;
        return i1;
    }

    static void a(com.facebook.ads.a.g.a.a a1)
    {
        if (!a1.a(com/facebook/ads/l))
        {
            a1.a(com/facebook/ads/InterstitialAdActivity);
        }
    }

    private boolean a(Class class1)
    {
        try
        {
            Context context = getContext();
            class1 = new Intent(context, class1);
            Display display = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            display.getMetrics(displaymetrics);
            class1.putExtra("displayRotation", display.getRotation());
            class1.putExtra("displayWidth", displaymetrics.widthPixels);
            class1.putExtra("displayHeight", displaymetrics.heightPixels);
            class1.putExtra("useNativeCloseButton", true);
            class1.putExtra("viewType", com.facebook.ads.InterstitialAdActivity.a.b);
            class1.putExtra("videoURL", getVideoURI());
            class1.putExtra("videoPlayReportURL", getVideoPlayReportURI());
            class1.putExtra("videoTimeReportURL", getVideoTimeReportURI());
            class1.putExtra("predefinedOrientationKey", 13);
            class1.addFlags(0x10000000);
            context.startActivity(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(class1, "Error occurred while loading fullscreen video activity."));
            return false;
        }
        return true;
    }

    static c b(com.facebook.ads.a.g.a.a a1)
    {
        return a1.d;
    }

    static com.facebook.ads.a.g.a.a.a c(com.facebook.ads.a.g.a.a a1)
    {
        return a1.b;
    }

    static int d(com.facebook.ads.a.g.a.a a1)
    {
        return a1.i;
    }

    private void d()
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

    static Handler e(com.facebook.ads.a.g.a.a a1)
    {
        return a1.k;
    }

    static Handler f(com.facebook.ads.a.g.a.a a1)
    {
        return a1.j;
    }

    private void setOnClickListenerInternal(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(onclicklistener);
    }

    private void setOnTouchListenerInternal(android.view.View.OnTouchListener ontouchlistener)
    {
        super.setOnTouchListener(ontouchlistener);
    }

    public final void a()
    {
        if (i > 0)
        {
            d();
            i = 0;
        }
    }

    public final void b()
    {
        c.a(d, false);
        b.a();
    }

    public final void c()
    {
        c.a(d, true);
        b.a.pause();
    }

    public final boolean getAutoplay()
    {
        return g;
    }

    public final String getVideoPlayReportURI()
    {
        return e;
    }

    public final String getVideoTimeReportURI()
    {
        return f;
    }

    public final String getVideoURI()
    {
        return a;
    }

    final float getVolume()
    {
        return n;
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        c.a();
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        d();
        c.b();
    }

    public final void setAutoplay(boolean flag)
    {
        g = flag;
    }

    public final void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
    }

    public final void setOnTouchListener(android.view.View.OnTouchListener ontouchlistener)
    {
    }

    public final void setVideoPlayReportURI(String s)
    {
        e = s;
    }

    public final void setVideoTimeReportURI(String s)
    {
        a();
        f = s;
    }

    public final void setVideoURI(String s)
    {
        a = s;
        if (s != null)
        {
            b.setup(Uri.parse(s));
            if (g)
            {
                b.a();
            }
        }
    }

    final void setVolume(float f1)
    {
        n = f1;
    }

    // Unreferenced inner class com/facebook/ads/a/g/a/a$c$1

/* anonymous class */
    final class c._cls1 extends Paint
    {

        final c a;

            
            {
                a = c1;
                super();
                setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
                setStrokeCap(android.graphics.Paint.Cap.ROUND);
                setStrokeWidth(3F);
                setAntiAlias(true);
                setColor(-1);
            }
    }

}
