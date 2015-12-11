// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.util.ArrayList;

// Referenced classes of package netswipe:
//            aw, bq, dc, as, 
//            aq, ar, br, cw

public class bp extends aw
{

    private ImageView n;
    private ImageView o;
    private LinearLayout p;
    private TextView q;
    private ArrayList r;
    private boolean s;
    private bp t;
    private TextWatcher u;

    public bp(Context context)
    {
        super(context);
        s = true;
        t = this;
        u = new bq(this);
        b.removeTextChangedListener(m);
        removeView(a);
        removeView(b);
        int i = dc.a(context, 13);
        int j = dc.a(context, 14);
        int k = dc.a(context, 5);
        Object obj = (android.widget.TableLayout.LayoutParams)getLayoutParams();
        obj.height = -2;
        setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        setPadding(0, 0, 0, 0);
        setBackgroundColor(0);
        obj = new LinearLayout(context);
        Object obj1 = new android.widget.TableRow.LayoutParams(-1, -2);
        obj1.span = 2;
        obj1.weight = 1.0F;
        ((LinearLayout) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((LinearLayout) (obj)).setOrientation(1);
        addView(((android.view.View) (obj)));
        obj1 = new RelativeLayout(context);
        Object obj2 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        ((RelativeLayout) (obj1)).setPadding(this.k, 0, l, dc.a(context, 14));
        ((RelativeLayout) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((RelativeLayout) (obj1)).setBackgroundColor(0xccffffff);
        ((LinearLayout) (obj)).addView(((android.view.View) (obj1)));
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        a.setPadding(0, dc.a(context, 12), 0, dc.a(context, 10));
        a.setId(as.L);
        ((RelativeLayout) (obj1)).addView(a);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, as.L);
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        b.setPadding(0, 0, 0, 0);
        b.setId(as.M);
        b.setInputType(0);
        b.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        b.setImeOptions(5);
        b.setGravity(3);
        ((RelativeLayout) (obj1)).addView(b);
        c();
        n = new ImageView(context);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        n.setPadding(0, dc.a(context, 14), 0, 0);
        n.setId(as.N);
        n.setAlpha(0.0F);
        ((RelativeLayout) (obj1)).addView(n);
        o = new ImageView(context);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(6, as.N);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(8, as.N);
        o.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        o.setPadding(0, dc.a(context, 14), 0, 0);
        o.setId(as.O);
        o.setAdjustViewBounds(true);
        o.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        o.setAlpha(0.0F);
        ((RelativeLayout) (obj1)).addView(o);
        p = new LinearLayout(context);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        p.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        p.setPadding(i, j, i, j);
        p.setOrientation(0);
        p.setVisibility(8);
        ((LinearLayout) (obj)).addView(p);
        obj = new ImageView(context);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.gravity = 16;
        ((ImageView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(aq.a(getResources(), aq.Q));
        p.addView(((android.view.View) (obj)));
        q = new TextView(context);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj.gravity = 16;
        obj.leftMargin = k;
        q.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        q.setTextColor(0xff181818);
        q.setTextSize(0, dc.a(context, 15));
        q.setPadding(dc.a(context, 7), 0, 0, 0);
        q.setShadowLayer(1.0F, 1.0F, 1.0F, 0xffdfdfdf);
        q.setText(ar.a(context, "manual_entry_card_number_not_supported"));
        p.addView(q);
        b.addTextChangedListener(u);
    }

    private Bitmap a(CreditCardType creditcardtype)
    {
        if (creditcardtype == null)
        {
            return null;
        }
        switch (br.a[creditcardtype.ordinal()])
        {
        default:
            return aq.a(getResources(), aq.i);

        case 1: // '\001'
            return aq.a(getResources(), aq.b);

        case 2: // '\002'
            return aq.a(getResources(), aq.c);

        case 3: // '\003'
            return aq.a(getResources(), aq.d);

        case 4: // '\004'
            return aq.a(getResources(), aq.e);

        case 5: // '\005'
            return aq.a(getResources(), aq.f);

        case 6: // '\006'
            return aq.a(getResources(), aq.g);

        case 7: // '\007'
            return aq.a(getResources(), aq.h);
        }
    }

    static Bitmap a(bp bp1, CreditCardType creditcardtype)
    {
        return bp1.a(creditcardtype);
    }

    static ImageView a(bp bp1)
    {
        return bp1.n;
    }

    static ArrayList b(bp bp1)
    {
        return bp1.r;
    }

    static TextView c(bp bp1)
    {
        return bp1.q;
    }

    static boolean d(bp bp1)
    {
        return bp1.s;
    }

    static LinearLayout e(bp bp1)
    {
        return bp1.p;
    }

    static bp f(bp bp1)
    {
        return bp1.t;
    }

    public void a(boolean flag)
    {
        float f2 = 1.0F;
        if (n.getAlpha() < 1.0F && !flag || n.getAlpha() > 0.0F && flag)
        {
            return;
        }
        Object obj = n;
        float f1;
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
        obj = ObjectAnimator.ofFloat(obj, "alpha", new float[] {
            f1, f2
        });
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).setDuration(250L);
        ((ObjectAnimator) (obj)).start();
    }

    public boolean a()
    {
        s = cw.d(new StringBuilder(b.getText()));
        o.setImageBitmap(aq.a(getResources(), aq.R));
        b(s);
        if (!s)
        {
            q.setText(ar.a(getContext(), "manual_entry_card_number_invalid"));
        }
        Object obj = p;
        int i;
        if (s)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = b;
        if (s)
        {
            i = 0xff444444;
        } else
        {
            i = 0xffcc0000;
        }
        ((EditText) (obj)).setTextColor(i);
        return s;
    }

    public void b(boolean flag)
    {
        float f3 = 1.0F;
        if (o.getAlpha() < 1.0F && !flag || o.getAlpha() > 0.0F && flag)
        {
            return;
        }
        int i = dc.a(getContext(), 30);
        Object obj = n;
        float f1;
        float f2;
        Object obj1;
        AnimatorSet animatorset;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = -i;
        }
        if (flag)
        {
            f2 = -i;
        } else
        {
            f2 = 0.0F;
        }
        obj = ObjectAnimator.ofFloat(obj, "translationX", new float[] {
            f1, f2
        });
        obj1 = o;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        if (flag)
        {
            f2 = f3;
        } else
        {
            f2 = 0.0F;
        }
        obj1 = ObjectAnimator.ofFloat(obj1, "alpha", new float[] {
            f1, f2
        });
        animatorset = new AnimatorSet();
        animatorset.setDuration(250L);
        animatorset.setInterpolator(new DecelerateInterpolator());
        animatorset.play(((android.animation.Animator) (obj))).with(((android.animation.Animator) (obj1)));
        animatorset.start();
    }

    public void setSupportedCreditCardTypes(ArrayList arraylist)
    {
        r = arraylist;
    }
}
