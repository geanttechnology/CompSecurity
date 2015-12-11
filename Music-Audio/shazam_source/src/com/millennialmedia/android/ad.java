// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Random;

// Referenced classes of package com.millennialmedia.android:
//            ak, ab, al, ac, 
//            ao, an, u, at, 
//            am

public final class ad extends ak
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener
{
    final class a
    {

        int a;
        int b;
        u c;
        final ad d;

        final android.view.ViewGroup.LayoutParams a(android.view.ViewGroup.LayoutParams layoutparams)
        {
            layoutparams.width = c.a;
            layoutparams.height = c.b;
            return layoutparams;
        }

        final a a(int i, int j, int k, int l)
        {
            if (i + k + j <= l) goto _L2; else goto _L1
_L1:
            j += l - k;
            if (j >= 0) goto _L4; else goto _L3
_L3:
            int i1;
            int j1;
            i1 = 0;
            j1 = l;
_L6:
            a a1 = new a(this, (byte)0);
            a1.a = i1 - i;
            a1.b = j1;
            return a1;
_L4:
            i1 = j;
            j1 = k;
            if (j + k > l)
            {
                i1 = l - k;
                j1 = k;
            }
            continue; /* Loop/switch isn't completed */
_L2:
            i1 = j;
            j1 = k;
            if (j <= 0)
            {
                i1 = i;
                j1 = k;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

        a(u u1)
        {
            d = ad.this;
            super();
            c = u1;
            a = u1.d;
            b = u1.e;
        }
    }

    private final class a.a
    {

        int a;
        int b;
        final a c;

        private a.a(a a1)
        {
            c = a1;
            super();
        }

        a.a(a a1, byte byte0)
        {
            this(a1);
        }
    }

    final class b extends ak.b
    {

        final ad a;

        final void a(Bitmap bitmap)
        {
            a.a.setImageBitmap(bitmap);
            a.a.setVisibility(0);
            a.a.bringToFront();
        }

        final void a(Map map)
        {
            if (a.c > 0)
            {
                map.put("hsht", String.valueOf(a.c));
            }
            if (a.d > 0)
            {
                map.put("hswd", String.valueOf(a.d));
            }
            super.a(map);
        }

        final boolean h()
        {
            return a.b != 0;
        }

        final void i()
        {
            if (a.a.getDrawable() == null) goto _L2; else goto _L1
_L1:
            int j;
            int k = a.b;
            j = k;
            if (k == 4)
            {
                j = (new Random()).nextInt(4);
            }
            j;
            JVM INSTR tableswitch 2 3: default 64
        //                       2 117
        //                       3 140;
               goto _L3 _L4 _L5
_L3:
            Object obj = new AlphaAnimation(1.0F, 0.0F);
_L7:
            ((Animation) (obj)).setDuration(1000L);
            ((Animation) (obj)).setAnimationListener(a);
            ((Animation) (obj)).setFillEnabled(true);
            ((Animation) (obj)).setFillBefore(true);
            ((Animation) (obj)).setFillAfter(true);
            an.a(new Runnable(this, ((Animation) (obj))) {

                final Animation a;
                final b b;

                public final void run()
                {
                    b.a.a.startAnimation(a);
                }

            
            {
                b = b1;
                a = animation;
                super();
            }
            });
_L2:
            return;
_L4:
            obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(float)a.getHeight());
            continue; /* Loop/switch isn't completed */
_L5:
            obj = new TranslateAnimation(0.0F, 0.0F, 0.0F, a.getHeight());
            if (true) goto _L7; else goto _L6
_L6:
        }

        final String m()
        {
            return "millennialmedia.action.ACTION_GETAD_FAILED";
        }

        final String n()
        {
            return "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
        }

        final String o()
        {
            return "getad";
        }

        public final boolean p()
        {
            return false;
        }

        public final boolean q()
        {
            return true;
        }

        final boolean r()
        {
            return a.getWindowToken() != null;
        }

        public b(Context context)
        {
            a = ad.this;
            super(ad.this, context);
            n = new c(this);
        }
    }

    private static final class c extends ab.a
    {

        public final void a(String s)
        {
            super.a(s);
            s = (ab)a.get();
            if (s != null && s.h())
            {
                s.i();
            }
        }

        c(ab ab1)
        {
            super(ab1);
        }
    }

    final class d extends View
    {

        final ad a;

        final void a(View view)
        {
            this;
            JVM INSTR monitorenter ;
            ad.b(a, view);
            if (getParent() != null && (getParent() instanceof ViewGroup))
            {
                ((ViewGroup)getParent()).addView(view);
            }
            this;
            JVM INSTR monitorexit ;
            return;
            view;
            throw view;
        }

        protected final void onRestoreInstanceState(Parcelable parcelable)
        {
            al.b();
            ad.a(a, a);
            super.onRestoreInstanceState(parcelable);
        }

        protected final Parcelable onSaveInstanceState()
        {
            al.b();
            a(a);
            return super.onSaveInstanceState();
        }

        public d(Context context)
        {
            a = ad.this;
            super(context);
        }
    }


    ImageView a;
    int b;
    int c;
    int d;
    int e;
    int f;
    d g;

    public ad(Context context)
    {
        super(context);
        b = 4;
        c = 0;
        d = 0;
        e = -50;
        f = -50;
        h = new b(context);
        setBackgroundColor(0);
        h.f = "b";
        setOnClickListener(this);
        setFocusable(true);
        a = new ImageView(context);
        a.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        a.setVisibility(8);
        addView(a, new android.widget.RelativeLayout.LayoutParams(-2, -2));
        setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-2, -2));
    }

    private void a(int i)
    {
        try
        {
            android/view/View.getMethod("setTranslationX", new Class[] {
                Float.TYPE
            }).invoke(this, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        catch (Exception exception)
        {
            al.a("MMAdView", "Unable to call setTranslationX", exception);
        }
    }

    private void a(View view)
    {
        this;
        JVM INSTR monitorenter ;
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        Object obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        if (obj instanceof ViewGroup)
        {
            obj = (ViewGroup)obj;
            if (view.getParent() != null)
            {
                ((ViewGroup) (obj)).removeView(view);
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    static void a(ad ad1, View view)
    {
        ad1.b(view);
    }

    private void b(int i)
    {
        try
        {
            android/view/View.getMethod("setTranslationY", new Class[] {
                Float.TYPE
            }).invoke(this, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
        catch (Exception exception)
        {
            al.a("MMAdView", "Unable to call setTranslationY", exception);
        }
    }

    private void b(View view)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a(view);
        obj = getContext();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (!(obj instanceof Activity))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((Activity)obj).getWindow();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = ((Window) (obj)).getDecorView();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (obj instanceof ViewGroup)
        {
            ((ViewGroup)obj).addView(view);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    static void b(ad ad1, View view)
    {
        ad1.a(view);
    }

    private boolean c()
    {
        return f == -50 && e == -50;
    }

    private void getAdInternal()
    {
        if (h != null)
        {
            h.g();
        }
    }

    final void a()
    {
        Object obj = h;
        if (((ab) (obj)).l != null)
        {
            obj = ((ab) (obj)).l;
            if (((ac) (obj)).b != null)
            {
                ((ac) (obj)).b.a((ab)((ac) (obj)).c.get());
            }
        }
    }

    final void a(u u1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        a.setImageBitmap(null);
        if (!an.c())
        {
            break MISSING_BLOCK_LABEL_399;
        }
        if (g == null)
        {
            g = new d(getContext());
            g.setId(0x121f0dbe);
            g.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(1, 1));
            g.setBackgroundColor(0);
        }
        if (g.getParent() != null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        if (obj instanceof ViewGroup)
        {
            ((ViewGroup)obj).addView(g);
        }
        int ai1[];
        int ai2[];
        obj = new a(u1);
        if (!u1.f)
        {
            int ai[] = new int[2];
            ((a) (obj)).d.getLocationInWindow(ai);
            a.a a1 = ((a) (obj)).a(ai[0], ((a) (obj)).c.d, ((a) (obj)).c.a, ((a) (obj)).c.g);
            ((a) (obj)).c.a = a1.b;
            obj.a = a1.a;
            a1 = new int[2];
            ((a) (obj)).d.getLocationInWindow(a1);
            a1 = ((a) (obj)).a(a1[1], ((a) (obj)).c.e, ((a) (obj)).c.b, ((a) (obj)).c.h);
            ((a) (obj)).c.b = a1.b;
            obj.b = a1.a;
        }
        ai1 = new int[2];
        getLocationInWindow(ai1);
        b(this);
        ai2 = new int[2];
        getLocationInWindow(ai2);
        if (c())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            f = layoutparams.width;
            e = layoutparams.height;
            if (f <= 0)
            {
                f = getWidth();
            }
            if (e <= 0)
            {
                e = getHeight();
            }
        }
        int i;
        int j;
        int k;
        int l;
        i = ai1[0];
        j = ai2[0];
        k = ai1[1];
        l = ai2[1];
        ((a) (obj)).a(getLayoutParams());
        a(((a) (obj)).a + (i - j));
        b(((a) (obj)).b + (k - l));
        setCloseArea(u1.c);
        this;
        JVM INSTR monitorexit ;
        return;
        u1;
        throw u1;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (!an.c())
        {
            break MISSING_BLOCK_LABEL_174;
        }
        if (super.j != null && super.j.getParent() != null && (super.j.getParent() instanceof ViewGroup))
        {
            ((ViewGroup)super.j.getParent()).removeView(super.j);
            super.j = null;
        }
        if (!c())
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            layoutparams.width = f;
            layoutparams.height = e;
            a(0);
            b(0);
            f = -50;
            e = -50;
        }
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        i = true;
        g.a(this);
        obj = getParent();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        if (obj instanceof ViewGroup)
        {
            obj = (ViewGroup)obj;
            if (g.getParent() != null)
            {
                ((ViewGroup) (obj)).removeView(g);
            }
        }
        i = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void getAd()
    {
        if (h != null && h.c != null)
        {
            at at = h.c;
            if (h != null)
            {
                h.c = at;
            }
            getAdInternal();
            return;
        } else
        {
            getAdInternal();
            return;
        }
    }

    public final volatile String getApid()
    {
        return super.getApid();
    }

    public final volatile boolean getIgnoresDensityScaling()
    {
        return super.getIgnoresDensityScaling();
    }

    public final volatile at getListener()
    {
        return super.getListener();
    }

    public final volatile am getMMRequest()
    {
        return super.getMMRequest();
    }

    public final void onAnimationEnd(Animation animation)
    {
        a.setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onClick(View view)
    {
        (new StringBuilder("On click for ")).append(view.getId()).append(" view, ").append(view).append(" adimpl").append(h);
        al.b();
        onTouchEvent(MotionEvent.obtain(0L, System.currentTimeMillis(), 1, 0.0F, 0.0F, 0));
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        au.c.a(new Runnable() {

            final ad a;

            public final void run()
            {
                float f1 = a.getContext().getResources().getDisplayMetrics().density;
                if (a.d <= 0)
                {
                    a.d = (int)((float)a.getWidth() / f1);
                }
                if (a.c <= 0)
                {
                    a.c = (int)((float)a.getHeight() / f1);
                }
            }

            
            {
                a = ad.this;
                super();
            }
        });
    }

    public final volatile boolean onTouchEvent(MotionEvent motionevent)
    {
        return super.onTouchEvent(motionevent);
    }

    public final void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && h != null && h.l != null)
        {
            if (h.l.b == null)
            {
                h.l.b = ac.c(h);
            }
            ao ao1 = h.l.b;
            if (ao1 != null && !ao1.a(h.h) && !ao1.c.equals("expanded"))
            {
                ao1.p();
                addView(ao1);
                return;
            }
        }
    }

    public final volatile void setApid(String s)
    {
        super.setApid(s);
    }

    public final void setBackgroundColor(int i)
    {
        super.setBackgroundColor(i);
        if (h != null && h.l != null && h.l.b != null)
        {
            h.l.b.setBackgroundColor(i);
        }
    }

    public final void setHeight(int i)
    {
        c = i;
    }

    public final volatile void setIgnoresDensityScaling(boolean flag)
    {
        super.setIgnoresDensityScaling(flag);
    }

    public final volatile void setListener(at at)
    {
        super.setListener(at);
    }

    public final volatile void setMMRequest(am am)
    {
        super.setMMRequest(am);
    }

    public final void setTransitionType(int i)
    {
        b = i;
    }

    public final void setWidth(int i)
    {
        d = i;
    }
}
