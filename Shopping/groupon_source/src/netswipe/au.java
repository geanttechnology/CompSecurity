// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package netswipe:
//            dc, av, aq, as, 
//            bi

public class au extends LinearLayout
{

    private av a;
    private ImageView b;
    private av c;
    private av d;
    private bi e;
    private int f;

    public au(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = 0;
        setOrientation(0);
        f = dc.a(context, 34);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        int i = dc.a(context, 1);
        obj = new RelativeLayout(context);
        Object obj1 = new android.widget.LinearLayout.LayoutParams(0, f);
        obj1.weight = 0.33F;
        ((RelativeLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        addView(((android.view.View) (obj)));
        a = new av(this, context, aq.a(getResources(), aq.l), false, 0, i);
        a.setEnabled(false);
        a.setId(as.j);
        ((RelativeLayout) (obj)).addView(a);
        b = new ImageView(context);
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(6, as.j);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(8, as.j);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(5, as.j);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(7, as.j);
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        b.setId(as.k);
        b.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        ((RelativeLayout) (obj)).addView(b);
        e = new bi(aq.a(getResources(), aq.l), a, b, getResources().getDisplayMetrics().densityDpi);
        d = new av(this, context, aq.a(getResources(), aq.n), 0.34F, true, i, i);
        d.setId(as.i);
        addView(d);
        c = new av(this, context, aq.a(getResources(), aq.o), 0.33F, false, i, 0);
        c.setEnabled(false);
        c.setId(as.l);
        addView(c);
    }

    static int a(au au1)
    {
        return au1.f;
    }

    public void a()
    {
        if (a != null)
        {
            a.setImageBitmap(aq.a(getResources(), aq.m));
        }
    }

    public void b()
    {
        if (a != null)
        {
            a.setImageBitmap(aq.a(getResources(), aq.l));
        }
    }

    public int getAnimationHeight()
    {
        return f;
    }

    public bi getFlashGlower()
    {
        return e;
    }

    public void setCameraButtonEnabled(boolean flag)
    {
        if (c != null)
        {
            c.setEnabled(flag);
        }
    }

    public void setFlashButtonEnabled(boolean flag)
    {
        if (a != null)
        {
            a.setEnabled(flag);
        }
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (a != null)
        {
            a.setOnClickListener(onclicklistener);
        }
        if (c != null)
        {
            c.setOnClickListener(onclicklistener);
        }
        if (d != null)
        {
            d.setOnClickListener(onclicklistener);
        }
    }
}
