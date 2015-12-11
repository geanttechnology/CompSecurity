// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.c.a.a;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

// Referenced classes of package android.support.design.widget:
//            ai, be, ad, ae, 
//            a, an, ao, ab

class aa extends ai
{

    an a;
    private Drawable g;
    private Drawable h;
    private Drawable i;
    private float j;
    private float k;
    private int l;
    private be m;
    private boolean n;

    aa(View view, ao ao1)
    {
        super(view, ao1);
        l = view.getResources().getInteger(0x10e0000);
        m = new be();
        m.a(view);
        m.a(b, a(new ad(this, (byte)0)));
        m.a(c, a(new ad(this, (byte)0)));
        m.a(d, a(new ae(this, (byte)0)));
    }

    static float a(aa aa1)
    {
        return aa1.j;
    }

    private Animation a(Animation animation)
    {
        animation.setInterpolator(android.support.design.widget.a.a);
        animation.setDuration(l);
        return animation;
    }

    static boolean a(aa aa1, boolean flag)
    {
        aa1.n = flag;
        return flag;
    }

    static float b(aa aa1)
    {
        return aa1.k;
    }

    private static ColorStateList b(int i1)
    {
        return new ColorStateList(new int[][] {
            c, b, new int[0]
        }, new int[] {
            i1, i1, 0
        });
    }

    private void e()
    {
        Rect rect = new Rect();
        a.getPadding(rect);
        f.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void a()
    {
        m.a();
    }

    void a(float f)
    {
        if (j != f && a != null)
        {
            a.a(f, k + f);
            j = f;
            e();
        }
    }

    void a(int i1)
    {
        android.support.v4.c.a.a.a(h, b(i1));
    }

    void a(ColorStateList colorstatelist)
    {
        android.support.v4.c.a.a.a(g, colorstatelist);
        if (i != null)
        {
            android.support.v4.c.a.a.a(i, colorstatelist);
        }
    }

    void a(android.graphics.PorterDuff.Mode mode)
    {
        android.support.v4.c.a.a.a(g, mode);
    }

    void a(Drawable drawable, ColorStateList colorstatelist, android.graphics.PorterDuff.Mode mode, int i1, int j1)
    {
        g = android.support.v4.c.a.a.c(drawable.mutate());
        android.support.v4.c.a.a.a(g, colorstatelist);
        if (mode != null)
        {
            android.support.v4.c.a.a.a(g, mode);
        }
        drawable = new GradientDrawable();
        drawable.setShape(1);
        drawable.setColor(-1);
        drawable.setCornerRadius(f.a());
        h = android.support.v4.c.a.a.c(drawable);
        android.support.v4.c.a.a.a(h, b(i1));
        android.support.v4.c.a.a.a(h, android.graphics.PorterDuff.Mode.MULTIPLY);
        if (j1 > 0)
        {
            i = a(j1, colorstatelist);
            drawable = (new Drawable[] {
                i, g, h
            });
        } else
        {
            i = null;
            drawable = (new Drawable[] {
                g, h
            });
        }
        a = new an(e.getResources(), new LayerDrawable(drawable), f.a(), j, j + k);
        a.a(false);
        f.a(a);
        e();
    }

    void a(int ai1[])
    {
        m.a(ai1);
    }

    void b()
    {
        if (n || e.getVisibility() != 0)
        {
            return;
        } else
        {
            Animation animation = AnimationUtils.loadAnimation(e.getContext(), 0x7f05000b);
            animation.setInterpolator(android.support.design.widget.a.a);
            animation.setDuration(200L);
            animation.setAnimationListener(new ab(this));
            e.startAnimation(animation);
            return;
        }
    }

    void b(float f)
    {
        if (k != f && a != null)
        {
            k = f;
            an an1 = a;
            float f1 = j;
            an1.a(an1.b, f1 + f);
            e();
        }
    }

    void c()
    {
        if (e.getVisibility() != 0 || n)
        {
            e.clearAnimation();
            e.setVisibility(0);
            Animation animation = AnimationUtils.loadAnimation(e.getContext(), 0x7f05000a);
            animation.setDuration(200L);
            animation.setInterpolator(android.support.design.widget.a.a);
            e.startAnimation(animation);
        }
    }
}
