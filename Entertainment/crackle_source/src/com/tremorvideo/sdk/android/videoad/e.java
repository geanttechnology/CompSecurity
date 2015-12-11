// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextPaint;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tremorvideo.sdk.android.videoad.a.a;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            a, ad, u, aw, 
//            ax, aq, br, w, 
//            bv, bd, bx, bc, 
//            ap, n, bb

public class com.tremorvideo.sdk.android.videoad.e extends com.tremorvideo.sdk.android.videoad.a
    implements ax.c
{
    public static interface a
    {

        public abstract void a(n n1);
    }

    private class b extends TimerTask
    {

        final com.tremorvideo.sdk.android.videoad.e a;

        public void run()
        {
            com.tremorvideo.sdk.android.videoad.e.r(a);
        }

        private b()
        {
            a = com.tremorvideo.sdk.android.videoad.e.this;
            super();
        }

    }

    private class c extends Button
    {

        final com.tremorvideo.sdk.android.videoad.e a;

        public c(Context context)
        {
            a = com.tremorvideo.sdk.android.videoad.e.this;
            super(context);
            e1 = com.tremorvideo.sdk.android.videoad.e.a(com.tremorvideo.sdk.android.videoad.e.this).q().a(bv.d.v);
            setBackgroundDrawable(new BitmapDrawable(com.tremorvideo.sdk.android.videoad.e.this));
            setWidth(getWidth());
            setHeight(getHeight());
            setFocusable(false);
        }
    }

    private class d extends Drawable
    {

        Bitmap a;
        Bitmap b;
        final com.tremorvideo.sdk.android.videoad.e c;

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

        public d()
        {
            c = com.tremorvideo.sdk.android.videoad.e.this;
            super();
            a = com.tremorvideo.sdk.android.videoad.e.a(com.tremorvideo.sdk.android.videoad.e.this).q().a(bv.d.w);
            b = com.tremorvideo.sdk.android.videoad.e.a(com.tremorvideo.sdk.android.videoad.e.this).q().a(bv.d.x);
        }
    }

    class e extends AsyncTask
    {

        String a;
        final com.tremorvideo.sdk.android.videoad.e b;

        protected transient String a(String as[])
        {
            String s1;
            try
            {
                a = null;
                b.A = as[0];
                s1 = b.A.replace("|", "%7C");
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.d((new StringBuilder()).append("Exception vast tag download:").append(as).toString());
                return null;
            }
            as = s1;
            if (s1.contains(" "))
            {
                as = s1.replace(" ", "%20");
            }
            as = com.tremorvideo.sdk.android.videoad.bb.a(as, ad.x());
            as.a();
            as = as.b();
            return as;
        }

        protected void a(String s1)
        {
            if (s1 == null || s1.length() <= 0) goto _L2; else goto _L1
_L1:
            com.tremorvideo.sdk.android.videoad.a.a a1;
            int j1;
            a1 = new com.tremorvideo.sdk.android.videoad.a.a(s1);
            s1 = s1.split("\n");
            j1 = s1.length;
            int i1 = 0;
_L4:
            String s2;
            if (i1 >= j1)
            {
                break; /* Loop/switch isn't completed */
            }
            s2 = s1[i1];
            com.tremorvideo.sdk.android.videoad.ad.a(ad.d.c, s2);
            i1++;
            if (true) goto _L4; else goto _L3
_L3:
            try
            {
                b.a(a1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                ad.d((new StringBuilder()).append("Vast Tag Parsing failed ").append(s1).toString());
                b.h();
            }
_L6:
            cancel(true);
            return;
_L2:
            ad.d("Vast Tag Download failed ");
            b.h();
            if (true) goto _L6; else goto _L5
_L5:
        }

        protected void b(String s1)
        {
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onCancelled(Object obj)
        {
            b((String)obj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        e()
        {
            b = com.tremorvideo.sdk.android.videoad.e.this;
            super();
        }
    }

    private class f extends View
    {

        int a;
        String b;
        int c;
        int d;
        TextPaint e;
        final com.tremorvideo.sdk.android.videoad.e f;

        public void a(int i1)
        {
            c = i1;
            invalidate();
        }

        public void a(String s1)
        {
            if (com.tremorvideo.sdk.android.videoad.e.a(f).N)
            {
                b = s1;
                invalidate();
            }
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

        public f(Context context, int i1)
        {
            f = com.tremorvideo.sdk.android.videoad.e.this;
            super(context);
            b = "";
            a = i1;
            c = 0;
            d = 0;
            e = new TextPaint();
            e.setTextSize(ad.H());
            e.setColor(a);
            e.setTypeface(Typeface.create("helvetica", 1));
            e.setAntiAlias(true);
            setFocusable(false);
        }
    }


    private static String S = "";
    private static int T = 0;
    String A;
    int B;
    boolean C;
    a D;
    boolean E;
    int F;
    private u G;
    private ax H;
    private VideoView I;
    private f J;
    private aq K;
    private int L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int U;
    private View V;
    private boolean W;
    private Timer X;
    private long Y;
    private long Z;
    boolean a;
    private long aa;
    private AlertDialog ab;
    private Runnable ac;
    int b;
    w e;
    w f;
    boolean g;
    boolean h;
    int i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    br n;
    int o;
    int p;
    RelativeLayout q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    long w;
    long x;
    List y;
    boolean z;

    public com.tremorvideo.sdk.android.videoad.e(Activity activity, a.a a1, u u1, boolean flag, a a2)
    {
        super(a1, activity);
        K = null;
        a = false;
        b = 0;
        g = false;
        h = true;
        j = false;
        k = false;
        l = false;
        m = false;
        r = false;
        s = false;
        t = true;
        u = true;
        v = false;
        w = 0L;
        x = 0L;
        M = false;
        N = false;
        O = false;
        P = false;
        Q = false;
        R = false;
        U = -1;
        V = null;
        W = true;
        X = null;
        Y = 0L;
        Z = 0L;
        aa = -1L;
        ab = null;
        z = false;
        A = null;
        B = 0;
        C = true;
        E = true;
        F = 0;
        ac = new Runnable() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void run()
            {
                if (com.tremorvideo.sdk.android.videoad.e.d(a).isPlaying()) goto _L2; else goto _L1
_L1:
                if (a.s)
                {
                    com.tremorvideo.sdk.android.videoad.e.n(a);
                }
_L4:
                com.tremorvideo.sdk.android.videoad.e.h(a).postDelayed(this, 500L);
                return;
_L2:
                int i1 = com.tremorvideo.sdk.android.videoad.e.d(a).getCurrentPosition();
                com.tremorvideo.sdk.android.videoad.e.e(a, i1);
                com.tremorvideo.sdk.android.videoad.e.c(a, i1);
                if (a.t)
                {
                    com.tremorvideo.sdk.android.videoad.e.h(a).a(com.tremorvideo.sdk.android.videoad.e.o(a));
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        };
        G = u1;
        com.tremorvideo.sdk.android.videoad.ad.a(c.getWindow());
        z = flag;
        A = c.getIntent().getExtras().getString("vastURL");
        F = c.getIntent().getExtras().getInt("skipDelaySeconds");
        E = c.getIntent().getExtras().getBoolean("bWaterMark");
        S = "invalid session id";
        c.requestWindowFeature(1);
        c.getWindow().setFlags(1024, 1024);
        D = a2;
        if (u1 != null)
        {
            a(u1);
            return;
        }
        activity = new LinearLayout(c);
        a1 = new ProgressBar(c, null, 0x101007a);
        a1.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        activity.setGravity(17);
        activity.addView(a1);
        if (ad.q() >= 9)
        {
            c.setRequestedOrientation(6);
        } else
        {
            c.setRequestedOrientation(0);
        }
        c.setContentView(activity);
    }

    private boolean A()
    {
        return G != null && G.L() && u && !p() && !s;
    }

    private String B()
    {
        if (G.N)
        {
            if (b > 0 || z)
            {
                return (new StringBuilder()).append("Advertisement: ").append(G.E()).toString();
            } else
            {
                return (new StringBuilder()).append("Ads by Tremor Video: ").append(G.E()).toString();
            }
        } else
        {
            return "";
        }
    }

    private String C()
    {
        int i1 = I.getCurrentPosition();
        if (G.N)
        {
            if (!z && i1 < 5000 && b == 0)
            {
                return (new StringBuilder()).append("Ads by Tremor Video: ").append(String.valueOf(E())).toString();
            } else
            {
                return (new StringBuilder()).append("Advertisement: ").append(String.valueOf(E())).toString();
            }
        } else
        {
            return "";
        }
    }

    private void D()
    {
        Object obj;
        long l1;
        long l2;
        long l3;
        try
        {
            obj = G.R();
        }
        catch (Exception exception)
        {
            com.tremorvideo.sdk.android.videoad.ad.a(exception);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        obj = (String)((aw) (obj)).f().get("auto-skip");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        l1 = Long.parseLong(((String) (obj))) * 1000L;
        if (w < l1)
        {
            l2 = ad.D();
            l3 = x;
            x = l2;
            if (H.c() == -1 && !j)
            {
                w = w + (l2 - l3);
                if (w >= l1)
                {
                    d.a(this);
                }
            }
        }
    }

    private int E()
    {
        int i1;
        if (L != 0)
        {
            if ((i1 = Math.round((float)(L - I.getCurrentPosition()) / 1000F)) >= 0)
            {
                return i1;
            }
        }
        return 0;
    }

    private void F()
    {
        if (!k)
        {
            Z = -1L;
            k = true;
            c.runOnUiThread(new Runnable() {

                final com.tremorvideo.sdk.android.videoad.e a;

                public void run()
                {
                    if (com.tremorvideo.sdk.android.videoad.e.p(a) == null)
                    {
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a.c);
                        builder.setTitle("Cannot play video");
                        builder.setMessage("Sorry, this video cannot be played");
                        builder.setPositiveButton("OK", new android.content.DialogInterface.OnClickListener(this) {

                            final _cls5 a;

                            public void onClick(DialogInterface dialoginterface, int i1)
                            {
                                com.tremorvideo.sdk.android.videoad.e.q(a.a);
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                        com.tremorvideo.sdk.android.videoad.e.a(a, builder.create());
                        com.tremorvideo.sdk.android.videoad.e.p(a).setOnCancelListener(new android.content.DialogInterface.OnCancelListener(this) {

                            final _cls5 a;

                            public void onCancel(DialogInterface dialoginterface)
                            {
                                com.tremorvideo.sdk.android.videoad.e.q(a.a);
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                    }
                    com.tremorvideo.sdk.android.videoad.e.p(a).show();
                    com.tremorvideo.sdk.android.videoad.e.a(a, 0L);
                    if (com.tremorvideo.sdk.android.videoad.e.d(a).isPlaying())
                    {
                        com.tremorvideo.sdk.android.videoad.e.d(a).stopPlayback();
                    }
                    com.tremorvideo.sdk.android.videoad.e.d(a).setVisibility(8);
                }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
            });
        }
    }

    private void G()
    {
        I();
        c.runOnUiThread(new Runnable() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void run()
            {
                if (com.tremorvideo.sdk.android.videoad.e.p(a) != null && com.tremorvideo.sdk.android.videoad.e.p(a).isShowing())
                {
                    com.tremorvideo.sdk.android.videoad.e.p(a).dismiss();
                }
                com.tremorvideo.sdk.android.videoad.e.a(a, null);
                com.tremorvideo.sdk.android.videoad.e.d(a).destroyDrawingCache();
                a.d.a(a);
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        });
    }

    private void H()
    {
        long l2 = SystemClock.elapsedRealtime();
        long l1 = l2 - Y;
        Y = l2;
        if (!j && !s && !l && !H.c)
        {
            if (k)
            {
                if (Z > -1L)
                {
                    Z = Z + l1;
                    if (Z > 5000L)
                    {
                        l = true;
                        Z = -1L;
                        if (ab != null && ab.isShowing())
                        {
                            ab.dismiss();
                        }
                        G();
                    }
                }
            } else
            {
                if (aa > -1L)
                {
                    long l3 = I.getCurrentPosition();
                    if (l3 == aa)
                    {
                        Z = l1 + Z;
                    } else
                    {
                        Z = 0L;
                    }
                    aa = l3;
                } else
                {
                    Z = Z + l1;
                }
                if (Z > ad.h)
                {
                    F();
                    return;
                }
            }
        }
    }

    private void I()
    {
        if (X != null)
        {
            X.cancel();
            X.purge();
            X = null;
        }
    }

    static int a(com.tremorvideo.sdk.android.videoad.e e1, int i1)
    {
        e1.U = i1;
        return i1;
    }

    static long a(com.tremorvideo.sdk.android.videoad.e e1, long l1)
    {
        e1.Z = l1;
        return l1;
    }

    static AlertDialog a(com.tremorvideo.sdk.android.videoad.e e1, AlertDialog alertdialog)
    {
        e1.ab = alertdialog;
        return alertdialog;
    }

    private View a(View view, u.b b1)
    {
        int i1 = -1;
        if (K != null)
        {
            ((ViewGroup)K.getParent()).removeView(K);
        } else
        {
            K = com.tremorvideo.sdk.android.videoad.ad.a(c);
            K.a(b1.b());
            K.a(new aq.d() {

                final com.tremorvideo.sdk.android.videoad.e a;

                public boolean a(String s1)
                {
                    s1 = com.tremorvideo.sdk.android.videoad.e.a(a).c(s1);
                    if (s1 != null)
                    {
                        com.tremorvideo.sdk.android.videoad.e.b(a, s1);
                    }
                    return false;
                }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
            });
        }
        if (b1.g() == u.c.e)
        {
            RelativeLayout relativelayout = new RelativeLayout(c);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(b1.e(), b1.f());
            layoutparams3.topMargin = b1.c();
            layoutparams3.leftMargin = b1.d();
            relativelayout.addView(view, layoutparams);
            relativelayout.addView(K, layoutparams3);
            return relativelayout;
        }
        if (b1.g().b())
        {
            LinearLayout linearlayout = new LinearLayout(c);
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
                linearlayout.addView(K, layoutparams4);
                linearlayout.addView(view, layoutparams1);
            } else
            {
                linearlayout.addView(view, layoutparams1);
                linearlayout.addView(K, layoutparams4);
            }
            return linearlayout;
        }
        if (b1.g().a())
        {
            LinearLayout linearlayout1 = new LinearLayout(c);
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
                linearlayout1.addView(K, layoutparams5);
                return linearlayout1;
            } else
            {
                linearlayout1.addView(K, layoutparams5);
                linearlayout1.addView(view, layoutparams2);
                return linearlayout1;
            }
        } else
        {
            return null;
        }
    }

    static u a(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.G;
    }

    private void a(int i1)
    {
        V.measure(-1, -1);
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, -V.getMeasuredHeight() * 2, 0.0F);
        translateanimation.setDuration(750L);
        translateanimation.setFillAfter(true);
        translateanimation.setFillBefore(true);
        translateanimation.setInterpolator(new DecelerateInterpolator());
        if (i1 > 0)
        {
            translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + (long)i1);
        }
        V.setAnimation(translateanimation);
        a(i1 - 200, true);
    }

    private void a(int i1, boolean flag)
    {
        if (t)
        {
            J.measure(-1, -1);
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -J.getMeasuredHeight());
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
            J.setAnimation(translateanimation);
            t = false;
        }
    }

    static void a(com.tremorvideo.sdk.android.videoad.e e1, int i1, boolean flag)
    {
        e1.b(i1, flag);
    }

    static void a(com.tremorvideo.sdk.android.videoad.e e1, aw aw1)
    {
        e1.c(aw1);
    }

    static void a(com.tremorvideo.sdk.android.videoad.e e1, u u1)
    {
        e1.b(u1);
    }

    static void a(com.tremorvideo.sdk.android.videoad.e e1, boolean flag)
    {
        e1.a(flag);
    }

    private void a(u u1, boolean flag)
    {
label0:
        {
label1:
            {
                boolean flag1 = false;
                S = "";
                G = u1;
                if (flag && D != null)
                {
                    D.a(G);
                }
                if (!G.b())
                {
                    G.a(c);
                }
                T = 0;
                w = 0L;
                b(u1);
                String as[] = G.c(0).split("-");
                if (as.length > 1)
                {
                    as = as[1].split("x");
                    if (as.length == 2)
                    {
                        o = Integer.parseInt(as[0]);
                        p = Integer.parseInt(as[1]);
                    }
                }
                if (flag)
                {
                    break label0;
                }
                n = u1.f();
                flag = n.a("orientation");
                M = flag;
                if (flag)
                {
                    ad.d("Compatibity: orientation");
                }
                flag = n.a("alpha-disable-blending");
                O = flag;
                if (flag)
                {
                    ad.d("Compatibity: alpha-disable-blending");
                }
                flag = n.a("lock-orientation");
                N = flag;
                if (flag)
                {
                    ad.d("Compatibity: lock-orientation");
                }
                if (ad.q() <= 18)
                {
                    flag = flag1;
                    if (!n.a("manual-measure"))
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            P = flag;
            if (flag)
            {
                ad.d("Compatibity: manual-measure");
            }
            flag = n.a("pause-bug");
            Q = flag;
            if (flag)
            {
                ad.d("Compatibity: pause-bug");
            }
            flag = n.a("disable-video-tag-autoplay");
            R = flag;
            if (flag)
            {
                ad.d("Compatibity: disable-video-tag-autoplay");
            }
        }
    }

    private void a(boolean flag)
    {
label0:
        {
            if (A() != t)
            {
                if (!t)
                {
                    break label0;
                }
                a(0, flag);
            }
            return;
        }
        b(0, flag);
    }

    static int b(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.U;
    }

    static int b(com.tremorvideo.sdk.android.videoad.e e1, int i1)
    {
        e1.L = i1;
        return i1;
    }

    static long b(com.tremorvideo.sdk.android.videoad.e e1, long l1)
    {
        e1.aa = l1;
        return l1;
    }

    private void b(int i1)
    {
        View view = new View(c);
        view.setBackgroundColor(Color.argb(255, 0, 0, 0));
        c.setContentView(view);
        u();
        q();
        c(i1);
        if (s)
        {
            z();
        }
    }

    private void b(int i1, boolean flag)
    {
        if (!t && A() && G.N)
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, -J.getHeight(), 0.0F);
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
            J.setAnimation(translateanimation);
            t = true;
        }
    }

    static void b(com.tremorvideo.sdk.android.videoad.e e1, aw aw1)
    {
        e1.f(aw1);
    }

    private void b(u u1)
    {
        y = new ArrayList();
        u1 = G.l().iterator();
        do
        {
            if (!u1.hasNext())
            {
                break;
            }
            aw aw1 = (aw)u1.next();
            if (aw1.a() == aw.b.j)
            {
                y.add(aw1);
            } else
            if (aw1.a() == aw.b.x)
            {
                y.add(aw1);
            } else
            if (aw1.b() >= 0)
            {
                y.add(aw1);
            }
        } while (true);
    }

    static View c(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.V;
    }

    private void c(int i1)
    {
        k = false;
        m = false;
        if (G.p)
        {
            I.setVideoURI(Uri.parse(G.a(0)));
        } else
        {
            I.setVideoPath(G.a(c, 0));
        }
        I.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener(i1) {

            final int a;
            final com.tremorvideo.sdk.android.videoad.e b;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                b.m = true;
                if (a > 0)
                {
                    com.tremorvideo.sdk.android.videoad.e.d(b).seekTo(a);
                }
                if (!com.tremorvideo.sdk.android.videoad.e.a(b).p || !b.j)
                {
                    com.tremorvideo.sdk.android.videoad.e.e(b);
                }
                int j1 = com.tremorvideo.sdk.android.videoad.e.d(b).getDuration();
                if (j1 > 0)
                {
                    com.tremorvideo.sdk.android.videoad.e.b(b, j1);
                } else
                {
                    com.tremorvideo.sdk.android.videoad.e.b(b, com.tremorvideo.sdk.android.videoad.e.a(b).D);
                }
                if (com.tremorvideo.sdk.android.videoad.e.a(b).g(com.tremorvideo.sdk.android.videoad.e.f(b)))
                {
                    com.tremorvideo.sdk.android.videoad.e.a(b, com.tremorvideo.sdk.android.videoad.e.a(b));
                }
                if (a == 0)
                {
                    com.tremorvideo.sdk.android.videoad.e.h(b).a(com.tremorvideo.sdk.android.videoad.e.g(b));
                }
                com.tremorvideo.sdk.android.videoad.e.h(b).postDelayed(com.tremorvideo.sdk.android.videoad.e.i(b), 10L);
                com.tremorvideo.sdk.android.videoad.e.d(b).setOnPreparedListener(null);
                com.tremorvideo.sdk.android.videoad.e.a(b, -1L);
                com.tremorvideo.sdk.android.videoad.e.b(b, a);
            }

            
            {
                b = com.tremorvideo.sdk.android.videoad.e.this;
                a = i1;
                super();
            }
        });
        I.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public boolean onError(MediaPlayer mediaplayer, int j1, int k1)
            {
                com.tremorvideo.sdk.android.videoad.e.j(a);
                return true;
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        });
        I.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
label0:
                {
                    if (!a.k)
                    {
                        com.tremorvideo.sdk.android.videoad.e.c(a, com.tremorvideo.sdk.android.videoad.e.f(a));
                        if (!com.tremorvideo.sdk.android.videoad.e.a(a).P())
                        {
                            break label0;
                        }
                        com.tremorvideo.sdk.android.videoad.e.d(a).pause();
                        a.s = true;
                        mediaplayer = a;
                        mediaplayer.b = ((com.tremorvideo.sdk.android.videoad.e) (mediaplayer)).b + 1;
                        if (!com.tremorvideo.sdk.android.videoad.e.a(a).O)
                        {
                            com.tremorvideo.sdk.android.videoad.e.a(a).O = true;
                            mediaplayer = com.tremorvideo.sdk.android.videoad.e.a(a).C();
                            if (mediaplayer != null)
                            {
                                com.tremorvideo.sdk.android.videoad.e.k(a).a(mediaplayer);
                            }
                        }
                        com.tremorvideo.sdk.android.videoad.e.l(a);
                    }
                    return;
                }
                com.tremorvideo.sdk.android.videoad.e.m(a);
                a.l = true;
                com.tremorvideo.sdk.android.videoad.e.a(a).O = true;
                mediaplayer = com.tremorvideo.sdk.android.videoad.e.a(a).C();
                if (mediaplayer != null)
                {
                    com.tremorvideo.sdk.android.videoad.e.k(a).a(mediaplayer);
                }
                if (com.tremorvideo.sdk.android.videoad.e.d(a).isPlaying())
                {
                    com.tremorvideo.sdk.android.videoad.e.d(a).stopPlayback();
                }
                com.tremorvideo.sdk.android.videoad.e.d(a).destroyDrawingCache();
                a.d.a(a);
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        });
        Z = 0L;
    }

    private void c(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = l;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!I.isPlaying() || I.getCurrentPosition() < I.getDuration() - 200)
        {
            f(aw1);
        }
        if (true) goto _L1; else goto _L3
_L3:
        aw1;
        throw aw1;
    }

    static void c(com.tremorvideo.sdk.android.videoad.e e1, int i1)
    {
        e1.e(i1);
    }

    static void c(com.tremorvideo.sdk.android.videoad.e e1, aw aw1)
    {
        e1.d(aw1);
    }

    static VideoView d(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.I;
    }

    private void d(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (G != null && G.N() && !a && i1 >= G.O())
        {
            a = true;
            e.e();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void d(aw aw1)
    {
        if (aw1.a() == aw.b.j)
        {
            H.a(aw1, b + 1);
        } else
        {
            H.a(aw1);
        }
        w = 0x7fffffffffffffffL;
    }

    static void d(com.tremorvideo.sdk.android.videoad.e e1, int i1)
    {
        e1.c(i1);
    }

    private void e(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList(y.size());
        if (k)
        {
            break MISSING_BLOCK_LABEL_177;
        }
        iterator = y.iterator();
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
        y.removeAll(((java.util.Collection) (obj)));
        this;
        JVM INSTR monitorexit ;
    }

    private void e(aw aw1)
    {
        H.b(aw1);
    }

    static void e(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.y();
    }

    static void e(com.tremorvideo.sdk.android.videoad.e e1, int i1)
    {
        e1.d(i1);
    }

    static int f(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.L;
    }

    private void f(aw aw1)
    {
        this;
        JVM INSTR monitorenter ;
        if (aw1.a() != aw.b.v) goto _L2; else goto _L1
_L1:
        w();
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (aw1.a() != aw.b.j)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        H.a(aw1, b + 1, null);
          goto _L3
        aw1;
        throw aw1;
        H.c(aw1);
          goto _L3
    }

    private View g(aw aw1)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(500L);
        alphaanimation.setFillAfter(true);
        Object obj = I.getContext();
        c c1 = new c(((Context) (obj)));
        TextView textview = new TextView(((Context) (obj)));
        textview.setText(aw1.h());
        textview.setTextColor(G.q().a(com.tremorvideo.sdk.android.videoad.bv.c.a));
        textview.setShadowLayer(6F, 0.0F, 0.0F, G.q().a(bv.c.b));
        textview.setGravity(1);
        textview.setTypeface(Typeface.create("helvetica", 1));
        textview.setTextSize(2, ad.I());
        obj = new LinearLayout(((Context) (obj)));
        ((LinearLayout) (obj)).setGravity(17);
        ((LinearLayout) (obj)).setOrientation(1);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        ((LinearLayout) (obj)).addView(c1, layoutparams);
        ((LinearLayout) (obj)).addView(textview);
        ((LinearLayout) (obj)).setAnimation(alphaanimation);
        c1.setOnClickListener(new android.view.View.OnClickListener(((View) (obj)), aw1) {

            final View a;
            final aw b;
            final com.tremorvideo.sdk.android.videoad.e c;

            public void onClick(View view)
            {
                c.q.post(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        a.c.q.removeView(a.a);
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
                com.tremorvideo.sdk.android.videoad.e.c(c, b);
                c.w = 0x7fffffffffffffffL;
                c.s = false;
                com.tremorvideo.sdk.android.videoad.e.a(c, com.tremorvideo.sdk.android.videoad.e.a(c));
                com.tremorvideo.sdk.android.videoad.e.a(c, true);
                com.tremorvideo.sdk.android.videoad.e.d(c, 0);
            }

            
            {
                c = com.tremorvideo.sdk.android.videoad.e.this;
                a = view;
                b = aw1;
                super();
            }
        });
        return ((View) (obj));
    }

    static String g(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.B();
    }

    static f h(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.J;
    }

    private void h(aw aw1)
    {
        if (e != null)
        {
            e.a(aw1);
        }
        if (f != null)
        {
            f.a(aw1);
        }
    }

    static Runnable i(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.ac;
    }

    private void i()
    {
label0:
        {
            if (V != null && U == -1)
            {
                if (!p())
                {
                    break label0;
                }
                if (V.getVisibility() != 0)
                {
                    V.setVisibility(0);
                    a(0);
                }
                if (V instanceof bd)
                {
                    ((bd)V).a();
                }
            }
            return;
        }
        V.setVisibility(4);
        V.setAnimation(null);
        b(0, true);
    }

    static void j(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.F();
    }

    static ax k(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.H;
    }

    static void l(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.z();
    }

    static void m(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.I();
    }

    static void n(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.D();
    }

    static String o(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.C();
    }

    static AlertDialog p(com.tremorvideo.sdk.android.videoad.e e1)
    {
        return e1.ab;
    }

    private boolean p()
    {
        return f == null && U == -1 && V != null;
    }

    private void q()
    {
        if (G != null && G.F())
        {
            int i1 = 0;
            if (N)
            {
                i1 = s();
            }
            V = G.G().a(c, i1, G.q());
        } else
        {
            V = r();
        }
        if (V != null)
        {
            q.addView(V, new android.view.ViewGroup.LayoutParams(-2, -2));
            i();
            if (p())
            {
                a(2000);
            }
        }
    }

    static void q(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.G();
    }

    private View r()
    {
        while (G != null && !G.H() || U != -1 || !W) 
        {
            return null;
        }
        return (new bc(G.q(), G.I(), G.J(), G.K())).a(c, new bc.a() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void a(int i1)
            {
                if (com.tremorvideo.sdk.android.videoad.e.b(a) == -1)
                {
                    com.tremorvideo.sdk.android.videoad.e.a(a, i1);
                    TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -com.tremorvideo.sdk.android.videoad.e.c(a).getMeasuredHeight() * 2);
                    translateanimation.setDuration(500L);
                    translateanimation.setFillAfter(true);
                    translateanimation.setFillBefore(true);
                    translateanimation.setInterpolator(new DecelerateInterpolator());
                    translateanimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 200L);
                    com.tremorvideo.sdk.android.videoad.e.c(a).setAnimation(translateanimation);
                    if (!a.s)
                    {
                        com.tremorvideo.sdk.android.videoad.e.a(a, 400, true);
                    }
                }
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        });
    }

    static void r(com.tremorvideo.sdk.android.videoad.e e1)
    {
        e1.H();
    }

    private int s()
    {
        int j1 = t();
        int i1 = j1;
        if (G != null)
        {
            i1 = j1;
            if (G.S() != null)
            {
                i1 = j1 - G.S().a();
            }
        }
        return i1;
    }

    private int t()
    {
        Display display = ((WindowManager)c.getSystemService("window")).getDefaultDisplay();
        if (N)
        {
            return Math.max(display.getWidth(), display.getHeight());
        } else
        {
            return display.getWidth();
        }
    }

    private void u()
    {
        Object obj1 = new android.view.View.OnClickListener() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void onClick(View view1)
            {
                com.tremorvideo.sdk.android.videoad.e.a(a, (aw)view1.getTag());
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        };
        int i1 = s();
        int j1 = Math.round(160F * ad.K());
        J = new f(c, G.q().a(bv.c.c));
        J.setId(1);
        J.setTag("");
        J.setBackgroundDrawable(new d());
        J.a(j1);
        f f1 = J;
        Object obj;
        if (T == 0)
        {
            obj = B();
        } else
        {
            obj = "";
        }
        f1.a(((String) (obj)));
        u = true;
        t = true;
        e = new w(c, ((android.view.View.OnClickListener) (obj1)), G, i1);
        if (a)
        {
            e.f();
        }
        if (e.a())
        {
            f = new w(c, ((android.view.View.OnClickListener) (obj1)), G, e.b(), i1);
            if (f.c() >= i1 - j1)
            {
                u = false;
            }
        }
        obj1 = new LinearLayout(c);
        ((LinearLayout) (obj1)).setGravity(17);
        if (P || z)
        {
            I = new ap(c, J.getHeight(), o, p);
        } else
        {
            I = new VideoView(c);
            I.setId(48879);
        }
        I.setFocusable(false);
        if (ad.u())
        {
            I.setOnTouchListener(new android.view.View.OnTouchListener() {

                boolean a;
                final com.tremorvideo.sdk.android.videoad.e b;

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
                b = com.tremorvideo.sdk.android.videoad.e.this;
                super();
                a = false;
            }
            });
        }
        ((LinearLayout) (obj1)).addView(I);
        obj = new RelativeLayout(c);
        ((RelativeLayout) (obj)).setBackgroundColor(0xff000000);
        ((RelativeLayout) (obj)).addView(((View) (obj1)), new android.widget.RelativeLayout.LayoutParams(-1, -1));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11);
        ((RelativeLayout) (obj)).addView(J, ((android.view.ViewGroup.LayoutParams) (obj1)));
        if (!G.N)
        {
            a(0, false);
        }
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(14);
        ((RelativeLayout) (obj)).addView(e.d(), ((android.view.ViewGroup.LayoutParams) (obj1)));
        if (f != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(10);
            layoutparams.addRule(5);
            ((RelativeLayout) (obj)).addView(f.d(), layoutparams);
        }
        a(false);
        if (G.S() == null)
        {
            q = ((RelativeLayout) (obj));
            q.setFocusable(true);
            q.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final com.tremorvideo.sdk.android.videoad.e a;

                public void onFocusChange(View view1, boolean flag)
                {
                }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
            });
            c.setContentView(((View) (obj)));
            return;
        } else
        {
            View view = a(((View) (obj)), G.S());
            q = ((RelativeLayout) (obj));
            obj = new android.widget.LinearLayout.LayoutParams(-1, -1);
            obj.gravity = 17;
            c.setContentView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
            return;
        }
    }

    private void v()
    {
        Object obj = new android.view.View.OnClickListener() {

            final com.tremorvideo.sdk.android.videoad.e a;

            public void onClick(View view)
            {
                com.tremorvideo.sdk.android.videoad.e.b(a, (aw)view.getTag());
            }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
        };
        RelativeLayout relativelayout = q;
        int i1 = s();
        u = true;
        if (e != null)
        {
            relativelayout.removeView(e.d());
            e = null;
        }
        if (f != null)
        {
            relativelayout.removeView(f.d());
            f = null;
        }
        e = new w(c, ((android.view.View.OnClickListener) (obj)), G, i1);
        if (a)
        {
            e.f();
        }
        if (e.a())
        {
            f = new w(c, ((android.view.View.OnClickListener) (obj)), G, e.b(), i1);
            int j1 = Math.round(160F * ad.K());
            if (f.c() >= i1 - j1)
            {
                u = false;
            }
        }
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(14);
        relativelayout.addView(e.d(), ((android.view.ViewGroup.LayoutParams) (obj)));
        if (f != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams.addRule(10);
            layoutparams.addRule(5);
            relativelayout.addView(f.d(), layoutparams);
        }
    }

    private void w()
    {
        this;
        JVM INSTR monitorenter ;
        aw aw1;
        if (!a || !G.N())
        {
            break MISSING_BLOCK_LABEL_76;
        }
        I();
        aw1 = G.n();
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        d(aw1);
        r = true;
        I.pause();
        I.stopPlayback();
        I.destroyDrawingCache();
        d.a(this);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        com.tremorvideo.sdk.android.videoad.ad.a(((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        throw obj;
    }

    private void x()
    {
        if (I != null && I.isPlaying())
        {
            I.pause();
            T = I.getCurrentPosition();
        }
    }

    private void y()
    {
        if (I != null && !H.d() && !s && !j && m)
        {
            I.start();
        }
    }

    private void z()
    {
        View view = g(G.R());
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        q.addView(view, layoutparams);
        w = 0L;
        x = ad.D();
        a(0, true);
        if (!a)
        {
            a = true;
            e.e();
        }
    }

    public void a()
    {
        if (!z) goto _L2; else goto _L1
_L1:
        if (G == null) goto _L4; else goto _L3
_L3:
        if (!j)
        {
            T = 0;
        }
        w = 0L;
        u();
        q();
        c();
_L6:
        return;
_L4:
        f();
        return;
_L2:
        if (n.c() != S)
        {
            ad.d((new StringBuilder()).append("Playing Video Format: ").append(G.c(0)).toString());
            S = n.c();
            T = 0;
            w = 0L;
            u();
            q();
        }
        if (H.b())
        {
            H.e();
            e(((aw) (null)));
            if (a)
            {
                e.f();
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void a(Configuration configuration)
    {
        if (G != null && !N)
        {
            if (i != configuration.orientation)
            {
                i = configuration.orientation;
                if (M)
                {
                    b(I.getCurrentPosition());
                } else
                {
                    v();
                }
            }
            a(false);
            i();
        }
    }

    public void a(com.tremorvideo.sdk.android.videoad.a.a a1)
    {
        ad.d("onVastTagDownloaded");
        if (G != null)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        G = (u)com.tremorvideo.sdk.android.videoad.n.a(a1, F, E);
_L1:
        if (!a1.b())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (B < 100)
        {
            (new e()).execute(new String[] {
                a1.d(), "wrapper"
            });
            B = B + 1;
            return;
        }
        break MISSING_BLOCK_LABEL_127;
        try
        {
            G.a("vast", a1);
        }
        // Misplaced declaration of an exception variable
        catch (com.tremorvideo.sdk.android.videoad.a.a a1)
        {
            ad.d((new StringBuilder()).append("onVastTagDownloaded Exception : ").append(a1).toString());
            return;
        }
          goto _L1
        ad.d("Too many wrapper");
        h();
        return;
        a(G);
        g();
        return;
    }

    public void a(aw aw1)
    {
        x();
    }

    public void a(u u1)
    {
        H = new ax(c, d, u1.q());
        H.a(this);
        i = Resources.getSystem().getConfiguration().orientation;
        if (i == 2)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        a(u1, z);
        if (N)
        {
            i = 0;
            ad.d(c);
        }
        u1 = G.B();
        if (u1 != null)
        {
            H.a(u1);
        }
        if (G.p)
        {
            X = new Timer();
            Y = SystemClock.elapsedRealtime();
            X.scheduleAtFixedRate(new b(), 10L, 100L);
        }
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        while (i1 == 84 || i1 == 82) 
        {
            return true;
        }
        if (i1 == 4)
        {
            w();
            return true;
        } else
        {
            return false;
        }
    }

    public void b()
    {
        j = true;
        if (!Q)
        {
            x();
        }
    }

    public void b(aw aw1)
    {
        y();
    }

    public void c()
    {
        if (G != null && !((KeyguardManager)c.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            j = false;
            if (!s)
            {
                int i1;
                if (M)
                {
                    b(T);
                } else
                {
                    c(T);
                }
                if (!I.isPlaying())
                {
                    y();
                }
            }
            if (q != null)
            {
                for (i1 = 0; i1 < 3; i1++)
                {
                    q.postDelayed(new Runnable() {

                        final com.tremorvideo.sdk.android.videoad.e a;

                        public void run()
                        {
                            a.q.requestLayout();
                            a.q.invalidate();
                        }

            
            {
                a = com.tremorvideo.sdk.android.videoad.e.this;
                super();
            }
                    }, (i1 + 1) * 500);
                }

            }
        }
    }

    public void d()
    {
        super.d();
        if (j)
        {
            c();
        }
        if (M)
        {
            b(T);
        }
    }

    public int e()
    {
        if (L == 0)
        {
            return -1;
        } else
        {
            return I.getCurrentPosition();
        }
    }

    public void f()
    {
        try
        {
            (new e()).execute(new String[] {
                A
            });
            return;
        }
        catch (Exception exception)
        {
            ad.d((new StringBuilder()).append("VAST Content Exception: ").append(exception).toString());
        }
        h();
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (C)
        {
            C = false;
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void h()
    {
        Intent intent = new Intent();
        intent.putExtra("TREMOR_VAST_RESULT", "Vast Tag Playback Failure");
        c.setResult(0, intent);
        c.finish();
    }

    public boolean j()
    {
        boolean flag = true;
        if (k)
        {
            flag = false;
        }
        return flag;
    }

    public void l()
    {
        if (e != null)
        {
            e.g();
        }
        if (f != null)
        {
            f.g();
        }
    }

    public boolean m()
    {
        return H != null && !H.d();
    }

    public a.b n()
    {
        return a.b.b;
    }

    public void o()
    {
        super.o();
        I();
        if (ab != null && ab.isShowing())
        {
            ab.dismiss();
        }
        ab = null;
    }

}
