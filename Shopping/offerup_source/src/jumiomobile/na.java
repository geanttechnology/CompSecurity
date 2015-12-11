// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            mt, nb, nu, bg, 
//            bv, mh, mw, mk, 
//            nl, no, nc, jh

public class na extends FrameLayout
    implements mt
{

    private nl a;
    private bv b;
    private bv c;
    private TextView d;
    private mw e;
    private int f;
    private android.widget.FrameLayout.LayoutParams g;
    private nu h;

    public na(Context context, nu nu1)
    {
        super(context);
        f = 0;
        h = nu1;
        setWillNotDraw(false);
        a(context);
        if (nu1 != null)
        {
            nu1.addOnLayoutChangeListener(new nb(this, nu1));
        }
    }

    static int a(na na1)
    {
        return na1.f;
    }

    static int a(na na1, int i)
    {
        na1.f = i;
        return i;
    }

    private void a(Context context)
    {
        int i = (int)bg.a(context, 75F);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        b = new bv(context);
        b.setPathStringStack(mh.at);
        b.setLayoutParams(layoutparams);
        b.setPaintColor(0xb3ffffff);
        addView(b);
        c = new bv(context);
        c.setPathStringStack(mh.au);
        c.setLayoutParams(layoutparams);
        c.setPaintColor(0xb3ffffff);
        addView(c);
        e = new mw(context);
        e.setLayoutParams(layoutparams);
        addView(e);
        d = new TextView(context);
        layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 1;
        d.setLayoutParams(layoutparams);
        d.setTextColor(0xb3ffffff);
        d.setVisibility(4);
        d.setText(mk.a(context, "overlay_liveness_advice"));
        addView(d);
        a = new nl(context);
        g = new android.widget.FrameLayout.LayoutParams(i, i);
        g.gravity = 1;
        a.setLayoutParams(g);
        a.setBorderWidth(3);
        a.setColor(0xd95e760a);
        a.setVisibility(4);
        a.a(no.a);
        addView(a);
    }

    private void a(View view, boolean flag, boolean flag1)
    {
        float f2 = 1.0F;
        int i;
        if (flag1)
        {
            float f1;
            AlphaAnimation alphaanimation;
            if (flag)
            {
                f1 = 0.0F;
            } else
            {
                f1 = 1.0F;
            }
            if (!flag)
            {
                f2 = 0.0F;
            }
            alphaanimation = new AlphaAnimation(f1, f2);
            alphaanimation.setDuration(250L);
            view.setAnimation(alphaanimation);
        }
        if (flag)
        {
            i = 0;
        } else
        {
            i = 4;
        }
        view.setVisibility(i);
    }

    public int a(int i)
    {
        return 0;
    }

    public void a(int i, int j)
    {
        a.a(i, Integer.toString(j));
    }

    public void a(jh jh1)
    {
        switch (nc.a[jh1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a(((View) (a)), false, false);
            a(((View) (d)), false, false);
            a(((View) (c)), true, true);
            e.a(false);
            return;

        case 2: // '\002'
            a(((View) (a)), true, true);
            a(((View) (d)), true, true);
            a(((View) (c)), false, false);
            e.a(true);
            return;

        case 3: // '\003'
            a(((View) (a)), false, true);
            break;
        }
        a(((View) (d)), false, true);
        a(((View) (b)), false, true);
        a(((View) (e)), false, true);
        e.a(false);
    }

    public void a(boolean flag)
    {
    }

    public int getROIXOffset()
    {
        return 0;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        int l = getMeasuredWidth();
        i = getMeasuredHeight();
        if (l == 0 || i == 0)
        {
            return;
        }
        int k = (int)(((float)l - (float)l * 0.9F) / 2.0F);
        j = (int)(((float)i - (float)i * 0.95F) / 2.0F);
        e.setPadding(k, -j, k, j * 3);
        int i1 = (int)(((float)l - (float)l * 0.8F) / 2.0F);
        k = (int)(((float)i - (float)i * 0.85F) / 2.0F);
        b.setPadding(i1, k - j, i1, j * 2 + k);
        c.setPadding(i1, k - j, i1, j * 2 + k);
        float f1;
        float f2;
        if ((float)l / (float)i < 0.7616F)
        {
            f1 = (float)(l - i1 * 2) / 0.7616F;
        } else
        {
            f1 = i - k * 2 - j;
        }
        l = Math.round(f1 / 5.5F);
        g.width = l;
        g.height = l;
        f2 = ((float)i - f1) / 2.0F;
        l = Math.round(f1 / 6F + f2);
        a.setY(l);
        d.setY(i - k - j * 2);
    }

    public void setIsFrontCam(boolean flag)
    {
    }
}
