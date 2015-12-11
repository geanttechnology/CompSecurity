// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            nv, bg, cv, ce, 
//            mf, mk, cf, mh

public abstract class nu extends RelativeLayout
{

    private Runnable a;
    protected TextView b;
    protected View c;
    protected ObjectAnimator d;
    protected TextView e;
    protected int f;
    protected ImageView g;
    protected int h;
    protected int i;
    protected int j;

    public nu(Context context)
    {
        super(context);
        j = 0xff97be0d;
        a = new nv(this);
        f = (int)bg.a(context, 10F);
        int k = (int)bg.a(context, 59F);
        c = new View(context);
        j = a(ce.b(context, cv.a(context, "netverify_helpButtonTextColor", "attr"), 0xff97be0d).getDefaultColor(), 255);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, k);
        layoutparams.addRule(10);
        setLayoutParams(layoutparams);
        c(context);
        b(context);
        a(context);
        setBackgroundColor(mf.a);
        d = ObjectAnimator.ofFloat(c, "alpha", new float[] {
            0.0F, 0.4F
        });
        d.setDuration(500L);
        d.setInterpolator(new AccelerateDecelerateInterpolator());
        d.setRepeatMode(2);
        d.setRepeatCount(-1);
    }

    private int a(int k, int l)
    {
        return (0xffffff & k) + (l << 24);
    }

    public void a()
    {
        b.performClick();
    }

    protected void a(Context context)
    {
        e = new TextView(context);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, mf.L);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(1, mf.K);
        e.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        e.setId(mf.M);
        obj = ce.b(context, cv.a(context, "netverify_infoBarTextColor", "attr"), -1);
        e.setTextColor(((ColorStateList) (obj)));
        e.setTextSize(0, (int)bg.b(context, 14F));
        e.setGravity(17);
        e.setPadding(f, 0, f, 0);
        addView(e);
    }

    public void a(boolean flag)
    {
        if (d == null)
        {
            return;
        }
        if (flag)
        {
            removeCallbacks(a);
            postDelayed(a, 10000L);
            return;
        } else
        {
            d.cancel();
            c.setAlpha(0.15F);
            removeCallbacks(a);
            return;
        }
    }

    public void a(boolean flag, boolean flag1)
    {
        TextView textview = e;
        int k;
        int l;
        int i1;
        if (flag)
        {
            k = i + h;
        } else
        {
            k = 0;
        }
        i1 = f;
        if (flag1)
        {
            l = i + h;
        } else
        {
            l = 0;
        }
        textview.setPadding(i1 + k, 0, l + f, 0);
    }

    protected void b(Context context)
    {
        h = (int)bg.a(context, 28F);
        i = (int)bg.a(context, 10F);
        g = new ImageView(context);
        context = new android.widget.RelativeLayout.LayoutParams(h, -2);
        context.addRule(15);
        context.addRule(9);
        context.leftMargin = i;
        g.setLayoutParams(context);
        g.setId(mf.K);
        g.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        g.setVisibility(8);
        addView(g);
    }

    public void b(boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
        Context context = getContext();
        float f1;
        if (flag)
        {
            f1 = 59F;
        } else
        {
            f1 = 39F;
        }
        layoutparams.height = (int)bg.a(context, f1);
        setLayoutParams(layoutparams);
    }

    protected void c(Context context)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(5, mf.L);
        layoutparams.addRule(6, mf.L);
        layoutparams.addRule(7, mf.L);
        layoutparams.addRule(8, mf.L);
        c.setLayoutParams(layoutparams);
        c.setBackgroundColor(j);
        c.setVisibility(8);
        c.setAlpha(0.15F);
        addView(c);
        b = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.rightMargin = (int)bg.a(context, 10F);
        layoutparams.addRule(11);
        layoutparams.addRule(15);
        int k = (int)bg.a(context, 5F);
        int l = (int)bg.a(context, 10F);
        b.setPadding(l, k, l, k);
        b.setLayoutParams(layoutparams);
        b.setId(mf.L);
        b.setVisibility(8);
        b.setText(mk.a(context, "infobar_help_button"));
        b.setTextSize(0, bg.b(context, 17F));
        b.setTextColor(j);
        setHelpButtonIndicator(false);
        b.setCompoundDrawablePadding(l);
        mf.a(b, cf.c(context, a(j, 77)));
        addView(b);
    }

    public int getCurrentHeight()
    {
        return getLayoutParams().height;
    }

    public ColorStateList getTextColor()
    {
        return e.getTextColors();
    }

    public void setCenterText(boolean flag)
    {
        TextView textview = e;
        byte byte0;
        if (flag)
        {
            byte0 = 17;
        } else
        {
            byte0 = 16;
        }
        textview.setGravity(byte0);
    }

    public void setHelpButtonClickListener(android.view.View.OnClickListener onclicklistener)
    {
        b.setOnClickListener(onclicklistener);
    }

    public void setHelpButtonEnabled(boolean flag)
    {
        b.setEnabled(flag);
    }

    public void setHelpButtonIndicator(boolean flag)
    {
        Object obj = getResources();
        int k;
        if (flag)
        {
            k = mh.X;
        } else
        {
            k = mh.W;
        }
        obj = mh.b(((android.content.res.Resources) (obj)), k);
        ((Drawable) (obj)).setColorFilter(j, android.graphics.PorterDuff.Mode.SRC_ATOP);
        b.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable) (obj)), null);
    }

    public void setHelpButtonVisibility(int k)
    {
        b.setVisibility(k);
    }

    public void setHelpText(CharSequence charsequence)
    {
        b.setText(charsequence);
    }

    public void setLeftImage(Bitmap bitmap)
    {
        g.setImageBitmap(bitmap);
        if (bitmap == null)
        {
            g.setEnabled(false);
            g.setVisibility(8);
            return;
        } else
        {
            g.setEnabled(true);
            g.setVisibility(0);
            return;
        }
    }

    public void setShowHelpButton(boolean flag)
    {
        boolean flag1 = false;
        Object obj = b;
        int k;
        if (flag)
        {
            k = 0;
        } else
        {
            k = 8;
        }
        ((TextView) (obj)).setVisibility(k);
        obj = c;
        if (flag)
        {
            k = ((flag1) ? 1 : 0);
        } else
        {
            k = 8;
        }
        ((View) (obj)).setVisibility(k);
    }

    public void setShowLoading(boolean flag)
    {
        ImageView imageview = g;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        imageview.setVisibility(byte0);
    }

    public void setText(CharSequence charsequence)
    {
        e.setText(charsequence);
    }
}
