// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.core.player.overlay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.libraries.youtube.common.ui.TouchImageView;
import cux;
import sp;
import sq;
import ss;
import st;

public final class DefaultOverflowOverlay extends FrameLayout
    implements android.view.View.OnClickListener, android.view.animation.Animation.AnimationListener, ss
{

    private RelativeLayout a;
    private TouchImageView b;
    private TouchImageView c;
    private TouchImageView d;
    private TouchImageView e;
    private View f;
    private TouchImageView g;
    private Animation h;
    private Animation i;
    private Animation j;
    private Animation k;
    private cux l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p[];
    private int q;
    private android.app.AlertDialog.Builder r;
    private final sq s;
    private st t;

    public DefaultOverflowOverlay(Context context)
    {
        this(context, null);
    }

    public DefaultOverflowOverlay(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        r = (new android.app.AlertDialog.Builder(context)).setTitle(context.getString(0x7f0b0124)).setNegativeButton(0x7f0b00db, new sp(this));
        s = new sq(this);
        h = AnimationUtils.loadAnimation(context, 0x7f05000a);
        i = AnimationUtils.loadAnimation(context, 0x7f05000c);
        i.setAnimationListener(this);
        int i1 = context.getResources().getInteger(0x7f0e0007);
        h.setDuration(i1);
        i.setDuration(i1);
        j = AnimationUtils.loadAnimation(context, 0x7f05001d);
        k = AnimationUtils.loadAnimation(context, 0x7f05001e);
    }

    public static st a(DefaultOverflowOverlay defaultoverflowoverlay)
    {
        return defaultoverflowoverlay.t;
    }

    private void e()
    {
        boolean flag1 = true;
        TouchImageView touchimageview = c;
        boolean flag;
        if (m && l.k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        touchimageview.setEnabled(flag);
        touchimageview = b;
        if (n && l.k)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        touchimageview.setEnabled(flag);
        e.setEnabled(o);
    }

    public final void a()
    {
        clearAnimation();
        setVisibility(0);
        a.startAnimation(j);
        startAnimation(h);
    }

    public final void a(Animation animation)
    {
        if (getVisibility() == 0)
        {
            startAnimation(animation);
        }
    }

    public final void a(cux cux1)
    {
        l = cux1;
    }

    public final void a(st st1)
    {
        t = st1;
    }

    public final void a(boolean flag)
    {
        m = flag;
        e();
    }

    public final void a(String as[], int i1)
    {
        p = as;
        q = i1;
    }

    public final void b()
    {
        a.startAnimation(k);
        startAnimation(i);
    }

    public final void b(boolean flag)
    {
        n = flag;
        e();
    }

    public final void c()
    {
        clearAnimation();
        setVisibility(8);
        i.setStartTime(0L);
    }

    public final void c(boolean flag)
    {
        c.setSelected(flag);
    }

    public final void d()
    {
        m = false;
        n = false;
        o = false;
        p = null;
        q = -1;
        e();
    }

    public final void d(boolean flag)
    {
        boolean flag1 = false;
        Object obj = e;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((TouchImageView) (obj)).setVisibility(i1);
        obj = f;
        if (flag)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
    }

    public final void e(boolean flag)
    {
        o = flag;
        e();
    }

    public final void f(boolean flag)
    {
        e.setSelected(flag);
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (animation == i)
        {
            c();
            i.setStartTime(0L);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    public final void onClick(View view)
    {
        if (view != b || p == null || p.length <= 0) goto _L2; else goto _L1
_L1:
        r.setSingleChoiceItems(p, q, s).create().show();
_L4:
        if (!i.hasStarted())
        {
            b();
            view = t;
        }
        return;
_L2:
        if (view == c)
        {
            t.a();
        } else
        if (view == d)
        {
            t.b();
        } else
        if (view == e)
        {
            view = t;
        } else
        if (view == g)
        {
            view = t;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void onFinishInflate()
    {
        super.onFinishInflate();
        a = (RelativeLayout)findViewById(0x7f100104);
        b = (TouchImageView)findViewById(0x7f100109);
        b.setOnClickListener(this);
        c = (TouchImageView)findViewById(0x7f100107);
        c.setOnClickListener(this);
        d = (TouchImageView)findViewById(0x7f10010b);
        d.setOnClickListener(this);
        e = (TouchImageView)findViewById(0x7f100105);
        e.setOnClickListener(this);
        f = findViewById(0x7f100106);
        g = (TouchImageView)findViewById(0x7f10010d);
        g.setOnClickListener(this);
        d(false);
        setOnClickListener(this);
    }
}
