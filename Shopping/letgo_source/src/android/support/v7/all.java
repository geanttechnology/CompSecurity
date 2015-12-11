// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package android.support.v7:
//            alp, alo, alq, alk, 
//            alm, aln

public final class all
{

    private final CharSequence a;
    private final alp b;
    private alk c;
    private final View d;
    private android.view.View.OnClickListener e;
    private Activity f;
    private ViewGroup g;
    private FrameLayout h;
    private Animation i;
    private Animation j;
    private aln k;

    private all(Activity activity, View view, ViewGroup viewgroup, alk alk1)
    {
        c = null;
        k = null;
        if (activity == null || view == null)
        {
            throw new IllegalArgumentException("Null parameters are not accepted");
        } else
        {
            f = activity;
            d = view;
            g = viewgroup;
            b = (new alp.a()).a();
            a = null;
            c = alk1;
            return;
        }
    }

    public static all a(Activity activity, View view, int i1, alk alk1)
    {
        return new all(activity, view, (ViewGroup)activity.findViewById(i1), alk1);
    }

    private FrameLayout a(Resources resources)
    {
        FrameLayout framelayout = new FrameLayout(f);
        if (e != null)
        {
            framelayout.setOnClickListener(e);
        }
        int i1;
        int j1;
        if (b.l > 0)
        {
            j1 = resources.getDimensionPixelSize(b.l);
        } else
        {
            j1 = b.k;
        }
        if (b.n > 0)
        {
            i1 = resources.getDimensionPixelSize(b.n);
        } else
        {
            i1 = b.m;
        }
        if (i1 == 0)
        {
            i1 = -1;
        }
        framelayout.setLayoutParams(new android.widget.FrameLayout.LayoutParams(i1, j1));
        if (b.g != -1)
        {
            framelayout.setBackgroundColor(b.g);
        } else
        {
            framelayout.setBackgroundColor(resources.getColor(b.e));
        }
        if (b.f != 0)
        {
            resources = new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, b.f));
            if (b.h)
            {
                resources.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
            }
            framelayout.setBackgroundDrawable(resources);
        }
        return framelayout;
    }

    public static void a()
    {
        alo.a().b();
    }

    private void a(Resources resources, TextView textview)
    {
        int i1 = resources.getColor(b.t);
        textview.setShadowLayer(b.u, b.w, b.v, i1);
    }

    public static void a(all all1)
    {
        all1.e();
    }

    private void a(TextView textview, String s1)
    {
        if (a != null)
        {
            SpannableString spannablestring = new SpannableString(a);
            spannablestring.setSpan(new alq(textview.getContext(), s1), 0, spannablestring.length(), 33);
            textview.setText(spannablestring);
        }
    }

    private RelativeLayout b(Resources resources)
    {
        RelativeLayout relativelayout;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        relativelayout = new RelativeLayout(f);
        relativelayout.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        int i1 = b.y;
        if (b.z > 0)
        {
            i1 = resources.getDimensionPixelSize(b.z);
        }
        relativelayout.setPadding(i1, i1, i1, i1);
        ImageView imageview = null;
        if (b.p != null || b.q != 0)
        {
            imageview = u();
            relativelayout.addView(imageview, imageview.getLayoutParams());
        }
        resources = c(resources);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        if (imageview != null)
        {
            layoutparams.addRule(1, imageview.getId());
        }
        if ((b.o & 0x11) == 0) goto _L2; else goto _L1
_L1:
        layoutparams.addRule(13);
_L4:
        relativelayout.addView(resources, layoutparams);
        return relativelayout;
_L2:
        if ((b.o & 0x10) != 0)
        {
            layoutparams.addRule(15);
        } else
        if ((b.o & 1) != 0)
        {
            layoutparams.addRule(14);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private TextView c(Resources resources)
    {
        TextView textview;
        textview = new TextView(f);
        textview.setId(257);
        if (b.A != null)
        {
            a(textview, b.A);
        } else
        if (b.B != 0)
        {
            a(textview, resources.getString(b.B));
        } else
        {
            textview.setText(a);
        }
        textview.setTypeface(Typeface.DEFAULT_BOLD);
        textview.setGravity(b.o);
        if (b.j == -1) goto _L2; else goto _L1
_L1:
        textview.setTextColor(b.j);
_L4:
        if (b.s != 0)
        {
            textview.setTextSize(2, b.s);
        }
        if (b.t != 0)
        {
            a(resources, textview);
        }
        if (b.x != 0)
        {
            textview.setTextAppearance(f, b.x);
        }
        return textview;
_L2:
        if (b.i != 0)
        {
            textview.setTextColor(resources.getColor(b.i));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean q()
    {
        return h != null && h.getParent() != null;
    }

    private boolean r()
    {
        return d != null && d.getParent() != null;
    }

    private void s()
    {
        View view = p();
        int i1;
        if (g != null)
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(g.getMeasuredWidth(), 0x80000000);
        } else
        {
            i1 = android.view.View.MeasureSpec.makeMeasureSpec(f.getWindow().getDecorView().getMeasuredWidth(), 0x80000000);
        }
        view.measure(i1, android.view.View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    private void t()
    {
        Object obj = f.getResources();
        h = a(((Resources) (obj)));
        obj = b(((Resources) (obj)));
        h.addView(((View) (obj)));
    }

    private ImageView u()
    {
        ImageView imageview = new ImageView(f);
        imageview.setId(256);
        imageview.setAdjustViewBounds(true);
        imageview.setScaleType(b.r);
        if (b.p != null)
        {
            imageview.setImageDrawable(b.p);
        }
        if (b.q != 0)
        {
            imageview.setImageResource(b.q);
        }
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(9, -1);
        layoutparams.addRule(15, -1);
        imageview.setLayoutParams(layoutparams);
        return imageview;
    }

    public void b()
    {
        alo.a().a(this);
    }

    public Animation c()
    {
        if (i == null && f != null)
        {
            if (l().c > 0)
            {
                i = AnimationUtils.loadAnimation(m(), l().c);
            } else
            {
                s();
                i = alm.a(p());
            }
        }
        return i;
    }

    public Animation d()
    {
        if (j == null && f != null)
        {
            if (l().d > 0)
            {
                j = AnimationUtils.loadAnimation(m(), l().d);
            } else
            {
                j = alm.b(p());
            }
        }
        return j;
    }

    public void e()
    {
        alo.a().b(this);
    }

    boolean f()
    {
        return f != null && (q() || r());
    }

    void g()
    {
        f = null;
    }

    void h()
    {
        g = null;
    }

    void i()
    {
        k = null;
    }

    aln j()
    {
        return k;
    }

    alp k()
    {
        return b;
    }

    alk l()
    {
        if (c == null)
        {
            c = k().d;
        }
        return c;
    }

    Activity m()
    {
        return f;
    }

    ViewGroup n()
    {
        return g;
    }

    CharSequence o()
    {
        return a;
    }

    View p()
    {
        if (d != null)
        {
            return d;
        }
        if (h == null)
        {
            t();
        }
        return h;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Crouton{text=").append(a).append(", style=").append(b).append(", configuration=").append(c).append(", customView=").append(d).append(", onClickListener=").append(e).append(", activity=").append(f).append(", viewGroup=").append(g).append(", croutonView=").append(h).append(", inAnimation=").append(i).append(", outAnimation=").append(j).append(", lifecycleCallback=").append(k).append('}').toString();
    }
}
