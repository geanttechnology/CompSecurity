// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.tagging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.a.e;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.shazam.android.ad.a.b;
import com.shazam.android.p.m;
import com.shazam.android.widget.loading.a;
import com.shazam.i.b.c;

// Referenced classes of package com.shazam.android.widget.tagging:
//            g, m, l, k, 
//            f, b, a

public final class o extends FrameLayout
{

    final l a = new l(this, com.shazam.i.b.ar.a.e.a());
    private final e b = android.support.v4.a.e.a(com.shazam.i.b.c.a());
    private final BroadcastReceiver c = new a((byte)0);
    private final IntentFilter d = new IntentFilter("com.shazam.android.actions.BOTTOM_BAR_HEIGHT_CHANGED");
    private final com.shazam.android.widget.tagging.a e = new k(this);
    private final com.shazam.android.widget.tagging.m f;
    private final a g = new a();
    private boolean h;
    private boolean i;
    private int j;
    private int k;

    public o(Context context)
    {
        super(context);
    /* block-local class not found */
    class a {}

        Object obj;
        int i1;
        if ((new com.shazam.android.p.c()).d())
        {
            obj = new g(com.shazam.i.b.c.a().getResources());
        } else
        {
            obj = new f();
        }
        f = ((com.shazam.android.widget.tagging.m) (obj));
        context = new ImageView(context);
        f.a(context);
        context.setBackgroundResource(0x7f02004f);
        context.setImageDrawable(g);
        context.setId(0x7f11002c);
        i1 = getResources().getDimensionPixelSize(0x7f0a003c);
        setPadding(i1, i1, i1, getResources().getDimensionPixelSize(0x7f0a003d));
        context.setOnClickListener(a);
        setVisibility(8);
        setClipToPadding(false);
        addView(context);
    }

    static int a(o o1, int i1)
    {
        o1.j = i1;
        return i1;
    }

    private void a(int i1)
    {
    /* block-local class not found */
    class c {}

        animate().translationY(-g()).setInterpolator(new android.support.v4.view.b.c()).setListener(new com.shazam.android.widget.a.a(new android.animation.Animator.AnimatorListener[] {
            new com.shazam.android.widget.a.c(this, 0), new c((byte)0)
        })).setStartDelay(i1);
    }

    static void a(o o1)
    {
        o1.a(200);
    }

    static int b(o o1)
    {
        return o1.j;
    }

    static void c(o o1)
    {
        o1.h();
    }

    static a d(o o1)
    {
        return o1.g;
    }

    private int g()
    {
        return j + k;
    }

    private void h()
    {
        if (h)
        {
            a(0);
        }
    }

    private void setInitialAnimationState(int i1)
    {
        setTranslationY(g() + i1);
    }

    public final void a()
    {
label0:
        {
            setVisibility(0);
            if (!h)
            {
                h = true;
                if (getMeasuredHeight() != 0)
                {
                    break label0;
                }
                i = true;
            }
            return;
        }
        a(0);
    }

    public final void b()
    {
        if (h)
        {
            h = false;
            animate().cancel();
            animate().setListener(new com.shazam.android.widget.a.c(this, 8)).setInterpolator(new android.support.v4.view.b.a()).translationY(getMeasuredHeight() + g());
        }
    }

    public final void c()
    {
        com.shazam.android.widget.tagging.b.a(this);
        animate().cancel();
        setTranslationX(0.0F);
        setTranslationY(f());
    }

    public final void d()
    {
        k = getResources().getDimensionPixelSize(0x7f0a0041);
        h();
    }

    public final void e()
    {
        k = 0;
        h();
    }

    final int f()
    {
        if (h)
        {
            return -g();
        } else
        {
            return getMeasuredHeight() + g();
        }
    }

    public final com.shazam.android.widget.tagging.a getController()
    {
        return e;
    }

    public final boolean isShown()
    {
        return h;
    }

    protected final void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        j = com.shazam.android.ad.a.b.a();
        b.a(c, d);
    }

    protected final void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        b.a(c);
    }

    protected final void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
        i1 = getMeasuredHeight();
        if (i && i1 > 0)
        {
            i = false;
            setInitialAnimationState(i1);
            getViewTreeObserver().addOnPreDrawListener(new _cls1());
        }
    }

    // Unreferenced inner class com/shazam/android/widget/tagging/o$b
    /* block-local class not found */
    class b {}


    /* member class not found */
    class _cls1 {}

}
