// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, u, w, aw, 
//            ax, aq, br, bv, 
//            bd, bx, bc, ap, 
//            s, t, au, n

public class v extends FrameLayout
    implements au.c, ax.c
{
    private class a extends TimerTask
    {

        final v a;

        public void run()
        {
            v.t(a);
        }

        private a()
        {
            a = v.this;
            super();
        }

    }

    private class b extends Button
    {

        final v a;

        public b(Context context)
        {
            a = v.this;
            super(context);
            v1 = v.a(v.this).q().a(bv.d.v);
            setBackgroundDrawable(new BitmapDrawable(v.this));
            setWidth(getWidth());
            setHeight(getHeight());
        }
    }

    private class c extends Drawable
    {

        Bitmap a;
        Bitmap b;
        final v c;

        public void draw(Canvas canvas)
        {
            Rect rect = getBounds();
            canvas.drawBitmap(a, rect.left, rect.top, null);
            int l1 = (int)Math.ceil((float)(rect.width() - a.getWidth()) / (float)b.getWidth());
            int i1 = rect.left;
            int k1 = a.getWidth() + i1;
            for (int j1 = 0; j1 < l1; j1++)
            {
                canvas.drawBitmap(b, k1, rect.top, null);
                k1 += b.getWidth();
            }

        }

        public int getMinimumHeight()
        {
            return b.getHeight();
        }

        public int getOpacity()
        {
            return 1;
        }

        public void setAlpha(int i1)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }

        public c()
        {
            c = v.this;
            super();
            a = v.a(v.this).q().a(bv.d.w);
            b = v.a(v.this).q().a(bv.d.x);
        }
    }

    private class d extends View
    {

        int a;
        String b;
        int c;
        int d;
        TextPaint e;
        final v f;

        public void a(int i1)
        {
            c = i1;
            invalidate();
        }

        public void a(String s1)
        {
            b = s1;
            invalidate();
        }

        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            Rect rect = new Rect();
            e.getTextBounds(b, 0, b.length(), rect);
            float f1 = (c - rect.width()) / 2;
            float f2 = ((float)d - e.getTextSize()) / 2.0F;
            canvas.drawText(b, f1, f2 + e.getTextSize() + (float)e.baselineShift, e);
        }

        protected void onMeasure(int i1, int j1)
        {
            setMeasuredDimension(c, d);
        }

        public void setBackgroundDrawable(Drawable drawable)
        {
            super.setBackgroundDrawable(drawable);
            d = drawable.getMinimumHeight();
        }

        public d(Context context, int i1)
        {
            f = v.this;
            super(context);
            b = "";
            a = i1;
            c = 0;
            d = 0;
            e = new TextPaint();
            e.setTextSize(com.tremorvideo.sdk.android.videoad.ad.H());
            e.setColor(a);
            e.setTypeface(Typeface.create("helvetica", 1));
            e.setAntiAlias(true);
        }
    }


    private static String T = "";
    private static int U = 0;
    long A;
    boolean B;
    boolean C;
    int D;
    Handler E;
    au F;
    Runnable G;
    private u H;
    private ax I;
    private VideoView J;
    private d K;
    private aq L;
    private int M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int V;
    private View W;
    private boolean Z;
    boolean a;
    private Activity aa;
    private a.a ab;
    private Timer ac;
    private long ad;
    private long ae;
    private long af;
    private AlertDialog ag;
    private Runnable ah;
    int b;
    w c;
    w d;
    boolean e;
    boolean f;
    int g;
    boolean h;
    boolean i;
    br j;
    int k;
    int l;
    RelativeLayout m;
    boolean n;
    boolean o;
    boolean p;
    boolean q;
    boolean r;
    long s;
    long t;
    List u;
    int v;
    boolean w;
    n x;
    boolean y;
    boolean z;

    public v(Activity activity, a.a a1, u u1, int i1)
    {
        super(activity);
        H = null;
        L = null;
        a = false;
        b = 0;
        e = false;
        f = true;
        h = false;
        i = false;
        n = false;
        o = false;
        p = true;
        q = true;
        r = false;
        s = 0L;
        t = 0L;
        N = false;
        O = false;
        P = false;
        Q = false;
        R = false;
        S = false;
        V = -1;
        W = null;
        Z = true;
        v = 0;
        w = true;
        B = false;
        C = false;
        ac = null;
        ad = 0L;
        ae = 0L;
        af = -1L;
        ag = null;
        D = 0;
        E = new Handler();
        F = com.tremorvideo.sdk.android.videoad.ad.A();
        G = new Runnable() {

            final v a;

            public void run()
            {
                com.tremorvideo.sdk.android.videoad.ad.d("ASSET DOWNLOAD TIMEOUT");
                if (a.x != null)
                {
                    if ((a.x instanceof s) || (a.x instanceof u) && !a.x.p || (a.x instanceof t) && !a.x.p)
                    {
                        if (a.v > 1)
                        {
                            a.F.b();
                            a.g();
                            return;
                        } else
                        {
                            a.F.b();
                            a.x = null;
                            a.b();
                            return;
                        }
                    } else
                    {
                        a.F.b();
                        a.g();
                        return;
                    }
                } else
                {
                    a.F.b();
                    a.g();
                    return;
                }
            }

            
            {
                a = v.this;
                super();
            }
        };
        ah = new Runnable() {

            final v a;

            public void run()
            {
                if (!v.e(a).isPlaying())
                {
                    if (a.o)
                    {
                        v.n(a);
                    }
                } else
                {
                    int j1 = v.e(a).getCurrentPosition();
                    v.e(a, j1);
                    v.c(a, j1);
                    v.i(a).a(v.o(a));
                }
                v.i(a).postDelayed(this, 500L);
            }

            
            {
                a = v.this;
                super();
            }
        };
        aa = activity;
        ab = a1;
        T = "invalid session id";
        D = i1;
        if (u1 != null)
        {
            a(u1);
        } else
        if (ad.e == 1)
        {
            v = 0;
            activity = new LinearLayout(aa);
            a1 = new ProgressBar(aa, null, 0x101007a);
            a1.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
            activity.setGravity(17);
            activity.addView(a1);
            addView(activity, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
    }

    private void A()
    {
        View view = g(H.R());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        m.addView(view, layoutparams);
        s = 0L;
        t = com.tremorvideo.sdk.android.videoad.ad.D();
        a(0, true);
        if (!a)
        {
            a = true;
            c.e();
        }
    }

    private boolean B()
    {
        return H.L() && q && !q() && !o;
    }

    private String C()
    {
        if (H.N)
        {
            if (b > 0)
            {
                return (new StringBuilder()).append("Advertisement: ").append(H.E()).toString();
            } else
            {
                return (new StringBuilder()).append("Ads by Tremor Video: ").append(H.E()).toString();
            }
        } else
        {
            return "";
        }
    }

    private String D()
    {
        int i1 = J.getCurrentPosition();
        if (H.N)
        {
            if (i1 < 5000 && b == 0)
            {
                return (new StringBuilder()).append("Ads by Tremor Video: ").append(String.valueOf(F())).toString();
            } else
            {
                return (new StringBuilder()).append("Advertisement: ").append(String.valueOf(F())).toString();
            }
        } else
        {
            return "";
        }
    }

    private void E()
    {
        Object obj;
        long l1;
        long l2;
        long l3;
        try
        {
            obj = H.R();
        }
        catch (Exception exception)
        {
            com.tremorvideo.sdk.android.videoad.ad.a(exception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        obj = (String)((aw) (obj)).f().get("auto-skip");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        l1 = Long.parseLong(((String) (obj))) * 1000L;
        if (s < l1)
        {
            l2 = com.tremorvideo.sdk.android.videoad.ad.D();
            l3 = t;
            t = l2;
            if (I.c() == -1 && !h)
            {
                s = s + (l2 - l3);
                if (s >= l1)
                {
                    k();
                }
            }
        }
    }

    private int F()
    {
        int i1;
        if (M != 0)
        {
            if ((i1 = Math.round((float)(M - J.getCurrentPosition()) / 1000F)) >= 0)
            {
                return i1;
            }
        }
        return 0;
    }

    private void G()
    {
        if (!B)
        {
            ae = -1L;
            B = true;
            aa.runOnUiThread(new Runnable() {

                final v a;

                public void run()
                {
                    if (v.p(a) == null)
                    {
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(v.q(a));
                        builder.setTitle("Cannot play video");
                        builder.setMessage("Sorry, this video cannot be played");
                        builder.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener(this) {

                            final _cls7 a;

                            public void onClick(DialogInterface dialoginterface, int i1)
                            {
                                v.r(a.a);
                            }

            
            {
                a = _pcls7;
                super();
            }
                        });
                        v.a(a, builder.create());
                        v.p(a).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(this) {

                            final _cls7 a;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                v.r(a.a);
                            }

            
            {
                a = _pcls7;
                super();
            }
                        });
                    }
                    v.p(a).show();
                    v.a(a, 0L);
                    if (v.e(a).isPlaying())
                    {
                        v.e(a).stopPlayback();
                    }
                    v.e(a).setVisibility(8);
                }

            
            {
                a = v.this;
                super();
            }
            });
        }
    }

    private void H()
    {
        J();
        aa.runOnUiThread(new Runnable() {

            final v a;

            public void run()
            {
                if (v.p(a) != null && v.p(a).isShowing())
                {
                    v.p(a).dismiss();
                }
                v.a(a, null);
                v.e(a).destroyDrawingCache();
                v.s(a).a(null);
            }

            
            {
                a = v.this;
                super();
            }
        });
    }

    private void I()
    {
        long l2 = SystemClock.elapsedRealtime();
        long l1 = l2 - ad;
        ad = l2;
        if (!h && !o && !i && !I.c)
        {
            if (B)
            {
                if (ae > -1L)
                {
                    ae = ae + l1;
                    if (ae > 5000L)
                    {
                        i = true;
                        ae = -1L;
                        if (ag != null && ag.isShowing())
                        {
                            ag.dismiss();
                        }
                        H();
                    }
                }
            } else
            {
                if (af > -1L)
                {
                    long l3 = J.getCurrentPosition();
                    if (l3 == af)
                    {
                        ae = l1 + ae;
                    } else
                    {
                        ae = 0L;
                    }
                    af = l3;
                } else
                {
                    ae = ae + l1;
                }
                if (ae > ad.h)
                {
                    G();
                    return;
                }
            }
        }
    }

    private void J()
    {
        if (ac != null)
        {
            ac.cancel();
            ac.purge();
            ac = null;
        }
    }

    static int a(v v1, int i1)
    {
        v1.V = i1;
        return i1;
    }

    static long a(v v1, long l1)
    {
        v1.ae = l1;
        return l1;
    }

    static AlertDialog a(v v1, AlertDialog alertdialog)
    {
        v1.ag = alertdialog;
        return alertdialog;
    }

    private View a(View view, u.b b1)
    {
        int i1 = -1;
        if (L != null)
        {
            ((ViewGroup)L.getParent()).removeView(L);
        } else
        {
            L = com.tremorvideo.sdk.android.videoad.ad.a(aa);
            L.a(b1.b());
            L.a(new aq.d() {

                final v a;

                public boolean a(String s1)
                {
                    s1 = v.a(a).c(s1);
                    if (s1 != null)
                    {
                        v.b(a, s1);
                    }
                    return false;
                }

            
            {
                a = v.this;
                super();
            }
            });
        }
        if (b1.g() == u.c.e)
        {
            RelativeLayout relativelayout = new RelativeLayout(aa);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(b1.e(), b1.f());
            layoutparams3.topMargin = b1.c();
            layoutparams3.leftMargin = b1.d();
            relativelayout.addView(view, layoutparams);
            relativelayout.addView(L, layoutparams3);
            return relativelayout;
        }
        if (b1.g().b())
        {
            LinearLayout linearlayout = new LinearLayout(aa);
            linearlayout.setOrientation(0);
            android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(0, -1);
            layoutparams1.weight = 1.0F;
            int j1 = b1.e();
            android.widget.LinearLayout.LayoutParams layoutparams4;
            if (b1.f() == 0)
            {
                i1 = -1;
            } else
            {
                i1 = b1.f();
            }
            layoutparams4 = new android.widget.LinearLayout.LayoutParams(j1, i1);
            layoutparams4.gravity = 16;
            if (b1.g() == u.c.c)
            {
                linearlayout.addView(L, layoutparams4);
                linearlayout.addView(view, layoutparams1);
            } else
            {
                linearlayout.addView(view, layoutparams1);
                linearlayout.addView(L, layoutparams4);
            }
            return linearlayout;
        }
        if (b1.g().a())
        {
            LinearLayout linearlayout1 = new LinearLayout(aa);
            linearlayout1.setOrientation(1);
            android.widget.LinearLayout.LayoutParams layoutparams2 = new android.widget.LinearLayout.LayoutParams(-1, 0);
            layoutparams2.weight = 1.0F;
            android.widget.LinearLayout.LayoutParams layoutparams5;
            if (b1.e() != 0)
            {
                i1 = b1.e();
            }
            layoutparams5 = new android.widget.LinearLayout.LayoutParams(i1, b1.f());
            layoutparams5.gravity = 1;
            if (b1.g() == u.c.b)
            {
                linearlayout1.addView(view, layoutparams2);
                linearlayout1.addView(L, layoutparams5);
                return linearlayout1;
            } else
            {
                linearlayout1.addView(L, layoutparams5);
                linearlayout1.addView(view, layoutparams2);
                return linearlayout1;
            }
        } else
        {
            return null;
        }
    }

    static u a(v v1)
    {
        return v1.H;
    }

    private void a(int i1, boolean flag)
    {
        if (p)
        {
            K.measure(-1, -1);
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -K.getMeasuredHeight());
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.startNow();
            long l1;
            if (flag)
            {
                l1 = 500L;
            } else
            {
                l1 = 0L;
            }
            translateanimation.setDuration(l1);
            translateanimation.setFillAfter(true);
            translateanimation.setFillBefore(true);
            if (i1 > 0)
            {
                translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + (long)i1);
            }
            K.setAnimation(translateanimation);
            p = false;
        }
    }

    static void a(v v1, int i1, boolean flag)
    {
        v1.b(i1, flag);
    }

    static void a(v v1, aw aw1)
    {
        v1.c(aw1);
    }

    static void a(v v1, u u1)
    {
        v1.b(u1);
    }

    static void a(v v1, boolean flag)
    {
        v1.a(flag);
    }

    private void a(boolean flag)
    {
label0:
        {
            if (B() != p)
            {
                if (!p)
                {
                    break label0;
                }
                a(0, flag);
            }
            return;
        }
        b(0, flag);
    }

    static int b(v v1, int i1)
    {
        v1.M = i1;
        return i1;
    }

    static long b(v v1, long l1)
    {
        v1.af = l1;
        return l1;
    }

    private void b(int i1)
    {
        W.measure(-1, -1);
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, -W.getMeasuredHeight() * 2, 0.0F);
        translateanimation.setDuration(750L);
        translateanimation.setFillAfter(true);
        translateanimation.setFillBefore(true);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        if (i1 > 0)
        {
            translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + (long)i1);
        }
        W.setAnimation(translateanimation);
        a(i1 - 200, true);
    }

    private void b(int i1, boolean flag)
    {
        if (!p && B())
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, -K.getHeight(), 0.0F);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.startNow();
            long l1;
            if (flag)
            {
                l1 = 500L;
            } else
            {
                l1 = 0L;
            }
            translateanimation.setDuration(l1);
            if (i1 > 0)
            {
                translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + (long)i1);
            }
            K.setAnimation(translateanimation);
            p = true;
        }
    }

    private void b(u u1)
    {
        u = new ArrayList();
        u1 = H.l().iterator();
        do
        {
            if (!u1.hasNext())
            {
                break;
            }
            aw aw1 = (aw)u1.next();
            if (aw1.a() == aw.b.j)
            {
                u.add(aw1);
            } else
            if (aw1.a() == aw.b.x)
            {
                u.add(aw1);
            } else
            if (aw1.b() >= 0)
            {
                u.add(aw1);
            }
        } while (true);
    }

    static void b(v v1)
    {
        v1.o();
    }

    static void b(v v1, aw aw1)
    {
        v1.f(aw1);
    }

    static int c(v v1)
    {
        return v1.V;
    }

    private void c(int i1)
    {
        v();
        r();
        d(i1);
        if (o)
        {
            A();
        }
    }

    private void c(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = i;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!J.isPlaying() || J.getCurrentPosition() < J.getDuration() - 200)
        {
            f(aw1);
        }
        if (true) goto _L1; else goto _L3
_L3:
        aw1;
        throw aw1;
    }

    private void c(u u1)
    {
        T = "";
        H = u1;
        j = u1.f();
        b(u1);
        boolean flag = j.a("orientation");
        N = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: orientation");
        }
        flag = j.a("alpha-disable-blending");
        P = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: alpha-disable-blending");
        }
        flag = j.a("lock-orientation");
        O = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: lock-orientation");
        }
        if (com.tremorvideo.sdk.android.videoad.ad.q() > 18 || j.a("manual-measure"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Q = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: manual-measure");
        }
        flag = j.a("pause-bug");
        R = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: pause-bug");
        }
        flag = j.a("disable-video-tag-autoplay");
        S = flag;
        if (flag)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("Compatibity: disable-video-tag-autoplay");
        }
        u1 = H.c(0).split("-");
        if (u1.length > 1)
        {
            u1 = u1[1].split("x");
            if (u1.length == 2)
            {
                k = Integer.parseInt(u1[0]);
                l = Integer.parseInt(u1[1]);
            }
        }
    }

    static void c(v v1, int i1)
    {
        v1.f(i1);
    }

    static void c(v v1, aw aw1)
    {
        v1.d(aw1);
    }

    static View d(v v1)
    {
        return v1.W;
    }

    private void d(int i1)
    {
        B = false;
        C = false;
        if (H.p)
        {
            J.setVideoURI(Uri.parse(H.a(0)));
        } else
        {
            J.setVideoPath(H.a(aa, 0));
        }
        J.requestFocus();
        J.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final v a;

            public boolean onError(MediaPlayer mediaplayer, int j1, int k1)
            {
                com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Media player error: What: ").append(j1).append(" Extra: ").append(k1).toString());
                return false;
            }

            
            {
                a = v.this;
                super();
            }
        });
        J.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener(i1) {

            final int a;
            final v b;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                b.C = true;
                if (a > 0)
                {
                    v.e(b).seekTo(a);
                }
                if (!v.a(b).p || !b.h)
                {
                    v.f(b);
                }
                int j1 = v.e(b).getDuration();
                if (j1 > 0)
                {
                    v.b(b, j1);
                } else
                {
                    v.b(b, v.a(b).D);
                }
                if (v.a(b).g(v.g(b)))
                {
                    v.a(b, v.a(b));
                }
                if (a == 0)
                {
                    v.i(b).a(v.h(b));
                }
                v.i(b).postDelayed(v.j(b), 10L);
                v.e(b).setOnPreparedListener(null);
                v.a(b, -1L);
                v.b(b, a);
            }

            
            {
                b = v.this;
                a = i1;
                super();
            }
        });
        J.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final v a;

            public boolean onError(MediaPlayer mediaplayer, int j1, int k1)
            {
                v.k(a);
                return true;
            }

            
            {
                a = v.this;
                super();
            }
        });
        J.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final v a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
label0:
                {
                    if (!a.B)
                    {
                        v.c(a, v.g(a));
                        if (!v.a(a).P())
                        {
                            break label0;
                        }
                        v.e(a).pause();
                        a.o = true;
                        mediaplayer = a;
                        mediaplayer.b = ((v) (mediaplayer)).b + 1;
                        v.l(a);
                    }
                    return;
                }
                v.m(a);
                a.i = true;
                v.e(a).stopPlayback();
                a.k();
            }

            
            {
                a = v.this;
                super();
            }
        });
        ae = 0L;
    }

    private void d(aw aw1)
    {
        if (aw1.a() == aw.b.j)
        {
            I.a(aw1, b);
        } else
        {
            I.a(aw1);
        }
        s = 0x7fffffffffffffffL;
    }

    static void d(v v1, int i1)
    {
        v1.d(i1);
    }

    static VideoView e(v v1)
    {
        return v1.J;
    }

    private void e(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (H.N() && !a && i1 >= H.O())
        {
            a = true;
            c.e();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void e(aw aw1)
    {
        I.b(aw1);
    }

    static void e(v v1, int i1)
    {
        v1.e(i1);
    }

    private void f(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList(u.size());
        if (B)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        iterator = u.iterator();
_L3:
        aw aw1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_166;
        }
        aw1 = (aw)iterator.next();
        if (aw1.a() != aw.b.j) goto _L2; else goto _L1
_L1:
        if (i1 >= aw1.e())
        {
            ((ArrayList) (obj)).add(aw1);
            f(aw1);
        }
          goto _L3
        obj;
        throw obj;
_L2:
        if (aw1.a() != aw.b.x) goto _L5; else goto _L4
_L4:
        if (i1 >= aw1.e())
        {
            ((ArrayList) (obj)).add(aw1);
            f(aw1);
        }
          goto _L3
_L5:
        if (aw1.b() < 0 || i1 < aw1.b()) goto _L3; else goto _L6
_L6:
        ((ArrayList) (obj)).add(aw1);
        h(aw1);
          goto _L3
        u.removeAll(((java.util.Collection) (obj)));
        this;
        JVM INSTR monitorexit ;
    }

    private void f(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        if (aw1.a() != aw.b.v) goto _L2; else goto _L1
_L1:
        x();
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        I.c(aw1);
        if (true) goto _L4; else goto _L3
_L3:
        aw1;
        throw aw1;
    }

    static void f(v v1)
    {
        v1.z();
    }

    static int g(v v1)
    {
        return v1.M;
    }

    private View g(aw aw1)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setFillAfter(true);
        Object obj = J.getContext();
        b b1 = new b(((Context) (obj)));
        TextView textview = new TextView(((Context) (obj)));
        textview.setText(aw1.h());
        textview.setTextColor(H.q().a(bv.c.a));
        textview.setShadowLayer(6F, 0.0F, 0.0F, H.q().a(bv.c.b));
        textview.setGravity(1);
        textview.setTypeface(Typeface.create("helvetica", 1));
        textview.setTextSize(2, com.tremorvideo.sdk.android.videoad.ad.I());
        obj = new LinearLayout(((Context) (obj)));
        ((LinearLayout) (obj)).setGravity(17);
        ((LinearLayout) (obj)).setOrientation(1);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        ((LinearLayout) (obj)).addView(b1, layoutparams);
        ((LinearLayout) (obj)).addView(textview);
        ((LinearLayout) (obj)).setAnimation(alphaanimation);
        b1.setOnClickListener(new android.view.View.OnClickListener(((View) (obj)), aw1) {

            final View a;
            final aw b;
            final v c;

            public void onClick(View view)
            {
                c.m.post(new Runnable(this) {

                    final _cls4 a;

                    public void run()
                    {
                        a.c.m.removeView(a.a);
                    }

            
            {
                a = _pcls4;
                super();
            }
                });
                v.c(c, b);
                c.s = 0x7fffffffffffffffL;
                c.o = false;
                v.a(c, v.a(c));
                v.a(c, true);
                v.d(c, 0);
            }

            
            {
                c = v.this;
                a = view;
                b = aw1;
                super();
            }
        });
        return ((View) (obj));
    }

    static String h(v v1)
    {
        return v1.C();
    }

    private void h(aw aw1)
    {
        if (c != null)
        {
            c.a(aw1);
        }
        if (d != null)
        {
            d.a(aw1);
        }
    }

    static d i(v v1)
    {
        return v1.K;
    }

    static Runnable j(v v1)
    {
        return v1.ah;
    }

    static void k(v v1)
    {
        v1.G();
    }

    static void l(v v1)
    {
        v1.A();
    }

    static void m(v v1)
    {
        v1.J();
    }

    static void n(v v1)
    {
        v1.E();
    }

    static String o(v v1)
    {
        return v1.D();
    }

    private void o()
    {
        if (T != j.c())
        {
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Playing Video Format: ").append(H.c(0)).toString());
            if (!H.b())
            {
                H.a(aa);
            }
            T = j.c();
            U = 0;
            s = 0L;
            v();
            r();
        }
    }

    static AlertDialog p(v v1)
    {
        return v1.ag;
    }

    private void p()
    {
label0:
        {
            if (W != null && V == -1)
            {
                if (!q())
                {
                    break label0;
                }
                if (W.getVisibility() != 0)
                {
                    W.setVisibility(0);
                    b(0);
                }
                if (W instanceof bd)
                {
                    ((bd)W).a();
                }
            }
            return;
        }
        W.setVisibility(4);
        W.setAnimation(null);
        b(0, true);
    }

    static Activity q(v v1)
    {
        return v1.aa;
    }

    private boolean q()
    {
        return d == null && V == -1 && W != null;
    }

    private void r()
    {
        if (H.F())
        {
            int i1 = 0;
            if (O)
            {
                i1 = t();
            }
            W = H.G().a(aa, i1, H.q());
        } else
        {
            W = s();
        }
        if (W != null)
        {
            m.addView(W, new android.widget.FrameLayout.LayoutParams(-2, -2));
            p();
            if (q())
            {
                b(2000);
            }
        }
    }

    static void r(v v1)
    {
        v1.H();
    }

    private View s()
    {
        while (!H.H() || V != -1 || !Z) 
        {
            return null;
        }
        return (new bc(H.q(), H.I(), H.J(), H.K())).a(aa, new bc.a() {

            final v a;

            public void a(int i1)
            {
                if (v.c(a) == -1)
                {
                    v.a(a, i1);
                    TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -v.d(a).getMeasuredHeight() * 2);
                    translateanimation.setDuration(500L);
                    translateanimation.setFillAfter(true);
                    translateanimation.setFillBefore(true);
                    translateanimation.setInterpolator(new DecelerateInterpolator());
                    translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 200L);
                    v.d(a).setAnimation(translateanimation);
                    if (!a.o)
                    {
                        v.a(a, 400, true);
                    }
                }
            }

            
            {
                a = v.this;
                super();
            }
        });
    }

    static a.a s(v v1)
    {
        return v1.ab;
    }

    private int t()
    {
        int j1 = u();
        int i1 = j1;
        if (H.S() != null)
        {
            i1 = j1 - H.S().a();
        }
        return i1;
    }

    static void t(v v1)
    {
        v1.I();
    }

    private int u()
    {
        return D;
    }

    private void v()
    {
        Object obj = new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view1)
            {
                v.a(a, (aw)view1.getTag());
            }

            
            {
                a = v.this;
                super();
            }
        };
        int i1 = t();
        int j1 = Math.round(160F * com.tremorvideo.sdk.android.videoad.ad.K());
        K = new d(aa, H.q().a(bv.c.c));
        K.setId(1);
        K.setTag("");
        K.setBackgroundDrawable(new c());
        K.a(j1);
        K.a(C());
        q = true;
        p = true;
        c = new w(aa, ((android.view.View.OnClickListener) (obj)), H, i1);
        if (a)
        {
            c.f();
        }
        if (c.a())
        {
            d = new w(aa, ((android.view.View.OnClickListener) (obj)), H, c.b(), i1);
            if (d.c() >= i1 - j1)
            {
                q = false;
            }
        }
        Object obj1 = new LinearLayout(aa);
        ((LinearLayout) (obj1)).setGravity(17);
        if (Q)
        {
            J = new ap(aa, K.getHeight(), k, l);
        } else
        {
            J = new VideoView(aa);
            J.setId(48879);
        }
        if (com.tremorvideo.sdk.android.videoad.ad.u())
        {
            J.setOnTouchListener(new android.view.View.OnTouchListener() {

                boolean a;
                final v b;

                public boolean onTouch(View view1, MotionEvent motionevent)
                {
                    view1 = (VideoView)view1;
                    boolean flag;
                    if (!a)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    a = flag;
                    if (a)
                    {
                        view1.pause();
                        return false;
                    } else
                    {
                        view1.start();
                        return false;
                    }
                }

            
            {
                b = v.this;
                super();
                a = false;
            }
            });
        }
        ((LinearLayout) (obj1)).addView(J);
        obj = new RelativeLayout(aa);
        ((RelativeLayout) (obj)).setBackgroundColor(0xff000000);
        ((RelativeLayout) (obj)).addView(((View) (obj1)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((RelativeLayout) (obj)).addView(K, ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((RelativeLayout) (obj)).addView(c.d(), ((android.view.ViewGroup.LayoutParams) (obj1)));
        if (d != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(10);
            layoutparams.addRule(5);
            ((RelativeLayout) (obj)).addView(d.d(), layoutparams);
        }
        a(false);
        if (H.S() == null)
        {
            m = ((RelativeLayout) (obj));
            removeAllViews();
            addView(((View) (obj)), new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        } else
        {
            View view = a(((View) (obj)), H.S());
            m = ((RelativeLayout) (obj));
            (new android.widget.LinearLayout.LayoutParams(-1, -1)).gravity = 17;
            removeAllViews();
            addView(view, new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
    }

    private void w()
    {
        Object obj = new android.view.View.OnClickListener() {

            final v a;

            public void onClick(View view)
            {
                v.b(a, (aw)view.getTag());
            }

            
            {
                a = v.this;
                super();
            }
        };
        RelativeLayout relativelayout = m;
        int i1 = t();
        q = true;
        if (c != null)
        {
            relativelayout.removeView(c.d());
            c = null;
        }
        if (d != null)
        {
            relativelayout.removeView(d.d());
            d = null;
        }
        c = new w(aa, ((android.view.View.OnClickListener) (obj)), H, i1);
        if (a)
        {
            c.f();
        }
        if (c.a())
        {
            d = new w(aa, ((android.view.View.OnClickListener) (obj)), H, c.b(), i1);
            int j1 = Math.round(160F * com.tremorvideo.sdk.android.videoad.ad.K());
            if (d.c() >= i1 - j1)
            {
                q = false;
            }
        }
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        relativelayout.addView(c.d(), ((android.view.ViewGroup.LayoutParams) (obj)));
        if (d != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(10);
            layoutparams.addRule(5);
            relativelayout.addView(d.d(), layoutparams);
        }
    }

    private void x()
    {
        aw aw1;
        try
        {
            if (!a || !H.N())
            {
                break MISSING_BLOCK_LABEL_68;
            }
            J();
            aw1 = H.n();
        }
        catch (Exception exception)
        {
            com.tremorvideo.sdk.android.videoad.ad.a(exception);
            return;
        }
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        d(aw1);
        n = true;
        J.pause();
        J.stopPlayback();
        J.destroyDrawingCache();
        k();
    }

    private void y()
    {
        if (J != null && J.isPlaying())
        {
            J.pause();
            U = J.getCurrentPosition();
        }
    }

    private void z()
    {
        if (!I.d() && !o && J != null && !h && C)
        {
            J.start();
        }
    }

    public void a()
    {
        if (ad.e != 1)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (H == null) goto _L2; else goto _L1
_L1:
        aa.runOnUiThread(new Runnable() {

            final v a;

            public void run()
            {
                v.b(a);
                a.d();
            }

            
            {
                a = v.this;
                super();
            }
        });
_L4:
        return;
_L2:
        if (z) goto _L4; else goto _L3
_L3:
        b();
        return;
        o();
        d();
        return;
    }

    public void a(int i1)
    {
        if (I.b())
        {
            I.e();
            e(((aw) (null)));
            if (a)
            {
                c.f();
            }
        }
        aa.finishActivity(11);
    }

    public void a(aw aw1)
    {
        y();
    }

    public void a(n n1)
    {
        com.tremorvideo.sdk.android.videoad.ad.d("onCurrentAdDownloadFlowStart");
        x = n1;
        if (x instanceof s)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("onCurrentAdDownloadFlowStart : AdRichMedia");
        } else
        if (x instanceof t)
        {
            com.tremorvideo.sdk.android.videoad.ad.d("onCurrentAdDownloadFlowStart : AdVAST");
            return;
        }
    }

    public void a(u u1)
    {
        H = u1;
        I = new ax(aa, ab, u1.q());
        I.a(this);
        c(u1);
        if (H.p)
        {
            ac = new Timer();
            ad = SystemClock.elapsedRealtime();
            ac.scheduleAtFixedRate(new a(), 10L, 100L);
        }
        g = Resources.getSystem().getConfiguration().orientation;
        if (g == 2)
        {
            g = 0;
        } else
        {
            g = 1;
        }
        if (O)
        {
            g = 0;
        }
    }

    public void b()
    {
        if (v == 0)
        {
            x = F.e();
            if (x != null && ((x instanceof s) || (x instanceof u) && !x.p || (x instanceof t) && !x.p))
            {
                v = 1;
                F.b();
                x = null;
            }
        }
        if (E != null)
        {
            E.removeCallbacks(G);
        }
        if (v == 0 || v == 1)
        {
            A = SystemClock.elapsedRealtime();
            if (v == 1)
            {
                try
                {
                    Thread.sleep(1000L);
                    com.tremorvideo.sdk.android.videoad.ad.d("downloadManager.start call streaming true");
                    F.a(true, this);
                }
                catch (Exception exception) { }
            } else
            {
                com.tremorvideo.sdk.android.videoad.ad.d("downloadManager.start call streaming false");
                F.a(false, this);
            }
            v = v + 1;
            E.postDelayed(G, (long)ad.f + ad.g);
        } else
        {
            g();
        }
        com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("attempt=").append(v).toString());
    }

    public void b(aw aw1)
    {
        z();
    }

    public void c()
    {
        h = true;
        z = true;
        if (!R)
        {
            y();
        }
    }

    public void d()
    {
        h = false;
        z = false;
        if (y && ad.e == 1)
        {
            y = false;
            i();
        }
        if (!o && J != null)
        {
            if (N)
            {
                c(U);
            } else
            {
                d(U);
            }
            if (!J.isPlaying())
            {
                z();
            }
        }
    }

    public void e()
    {
        if (c != null)
        {
            c.g();
        }
        if (d != null)
        {
            d.g();
        }
    }

    public void f()
    {
        if (N)
        {
            c(U);
        }
    }

    public void g()
    {
        if (E != null)
        {
            E.removeCallbacks(G);
        }
        TremorAdapterCalls.onGetAdFailed();
        aa.runOnUiThread(new Runnable() {

            final v a;

            public void run()
            {
                a.k();
            }

            
            {
                a = v.this;
                super();
            }
        });
    }

    public void h()
    {
        com.tremorvideo.sdk.android.videoad.ad.d("onRequestDownloadComplete");
    }

    public void i()
    {
        this;
        JVM INSTR monitorenter ;
        if (!w) goto _L2; else goto _L1
_L1:
        Object obj;
        com.tremorvideo.sdk.android.videoad.ad.d("onAsssetDownloadComplete showAd loop");
        obj = com.tremorvideo.sdk.android.videoad.ad.A();
        if (((au) (obj)).e(com.tremorvideo.sdk.android.videoad.ad.o())) goto _L4; else goto _L3
_L3:
        g();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        w = false;
        obj = ((au) (obj)).f();
        if (!(obj instanceof u) && !(obj instanceof t))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        com.tremorvideo.sdk.android.videoad.ad.d("Frame Video Suported Ad present ");
        H = (u)obj;
        a(H);
        a();
          goto _L2
        Exception exception;
        exception;
        throw exception;
        com.tremorvideo.sdk.android.videoad.ad.d("Frame Video Suported Ad NOT present ");
        g();
          goto _L2
    }

    public void j()
    {
        com.tremorvideo.sdk.android.videoad.ad.d("onRequestDownloadTimeout");
        g();
    }

    public void k()
    {
        J();
        if (ag != null && ag.isShowing())
        {
            ag.dismiss();
        }
        ag = null;
        if (ab != null)
        {
            ab.a(null);
        }
    }

    public void l()
    {
        com.tremorvideo.sdk.android.videoad.ad.d("onAsssetDownloadComplete");
        E.removeCallbacks(G);
        if (z)
        {
            y = true;
            return;
        } else
        {
            i();
            return;
        }
    }

    public void m()
    {
        if (w)
        {
            g();
        }
    }

    public void n()
    {
        b();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (!O)
        {
            if (g != configuration.orientation)
            {
                g = configuration.orientation;
                if (N)
                {
                    c(J.getCurrentPosition());
                } else
                {
                    w();
                }
            }
            a(false);
            p();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        while (i1 == 84 || i1 == 82) 
        {
            return true;
        }
        if (i1 == 4)
        {
            x();
            return true;
        } else
        {
            return false;
        }
    }

}
