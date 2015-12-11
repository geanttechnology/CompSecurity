// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

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

// Referenced classes of package jumiomobile:
//            ee, eu, bf, ed, 
//            eb, ec, ev, fs

public class et extends ee
{

    private static final Boolean u = Boolean.valueOf(true);
    private static final Boolean v = Boolean.valueOf(false);
    private ImageView n;
    private ImageView o;
    private LinearLayout p;
    private TextView q;
    private ArrayList r;
    private boolean s;
    private et t;
    private TextWatcher w;

    public et(Context context)
    {
        super(context);
        s = true;
        t = this;
        w = new eu(this);
        b.removeTextChangedListener(e);
        removeView(a);
        removeView(b);
        int i = bf.a(context, 14);
        int j = bf.a(context, 13);
        int k = bf.a(context, 13);
        int l = bf.a(context, 14);
        int i1 = bf.a(context, 5);
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
        ((RelativeLayout) (obj1)).setPadding(i, 0, j, bf.a(context, 14));
        ((RelativeLayout) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        ((RelativeLayout) (obj1)).setBackgroundColor(0xccffffff);
        ((LinearLayout) (obj)).addView(((android.view.View) (obj1)));
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        a.setPadding(0, bf.a(context, 12), 0, bf.a(context, 10));
        a.setId(ed.H);
        ((RelativeLayout) (obj1)).addView(a);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(3, ed.H);
        b.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        b.setPadding(0, 0, 0, 0);
        b.setId(ed.I);
        b.setInputType(0);
        b.setKeyListener(DigitsKeyListener.getInstance("0123456789 "));
        b.setImeOptions(5);
        b.setGravity(3);
        ((RelativeLayout) (obj1)).addView(b);
        a(b);
        n = new ImageView(context);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
        n.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        n.setPadding(0, bf.a(context, 14), 0, 0);
        n.setId(ed.J);
        n.setAlpha(0.0F);
        n.setTag(v);
        ((RelativeLayout) (obj1)).addView(n);
        o = new ImageView(context);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(6, ed.J);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(8, ed.J);
        o.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj2)));
        o.setPadding(0, bf.a(context, 14), 0, 0);
        o.setId(ed.K);
        o.setAdjustViewBounds(true);
        o.setScaleType(android.widget.ImageView.ScaleType.FIT_CENTER);
        o.setAlpha(0.0F);
        o.setTag(v);
        ((RelativeLayout) (obj1)).addView(o);
        p = new LinearLayout(context);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        p.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        p.setPadding(k, l, k, l);
        p.setOrientation(0);
        p.setVisibility(8);
        ((LinearLayout) (obj)).addView(p);
        obj = new ImageView(context);
        obj1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1.gravity = 16;
        ((ImageView) (obj)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
        ((ImageView) (obj)).setAdjustViewBounds(true);
        ((ImageView) (obj)).setImageBitmap(eb.a(getResources(), eb.r));
        p.addView(((android.view.View) (obj)));
        q = new TextView(context);
        obj = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj.gravity = 16;
        obj.leftMargin = i1;
        q.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        q.setTextColor(0xff181818);
        q.setTextSize(0, bf.a(context, 15));
        q.setPadding(bf.a(context, 7), 0, 0, 0);
        q.setShadowLayer(1.0F, 1.0F, 1.0F, 0xffdfdfdf);
        q.setText(ec.a(context, "manual_entry_card_number_not_supported"));
        p.addView(q);
        b.addTextChangedListener(w);
    }

    private Bitmap a(CreditCardType creditcardtype)
    {
        if (creditcardtype == null)
        {
            return null;
        }
        switch (ev.a[creditcardtype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return eb.a(getResources(), eb.k);

        case 2: // '\002'
            return eb.a(getResources(), eb.l);

        case 3: // '\003'
            return eb.a(getResources(), eb.m);

        case 4: // '\004'
            return eb.a(getResources(), eb.n);

        case 5: // '\005'
            return eb.a(getResources(), eb.o);

        case 6: // '\006'
            return eb.a(getResources(), eb.p);

        case 7: // '\007'
            return eb.a(getResources(), eb.q);

        case 8: // '\b'
            return Bitmap.createBitmap(78, 44, android.graphics.Bitmap.Config.ARGB_8888);
        }
    }

    static Bitmap a(et et1, CreditCardType creditcardtype)
    {
        return et1.a(creditcardtype);
    }

    static ImageView a(et et1)
    {
        return et1.n;
    }

    static ArrayList b(et et1)
    {
        return et1.r;
    }

    static TextView c(et et1)
    {
        return et1.q;
    }

    static boolean d(et et1)
    {
        return et1.s;
    }

    static LinearLayout e(et et1)
    {
        return et1.p;
    }

    static et f(et et1)
    {
        return et1.t;
    }

    public void a(boolean flag)
    {
        float f2 = 1.0F;
        this;
        JVM INSTR monitorenter ;
        if (n.getTag().equals(v) && !flag) goto _L2; else goto _L1
_L1:
        boolean flag1 = n.getTag().equals(u);
        if (!flag1 || !flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        ImageView imageview = n;
        if (!flag) goto _L5; else goto _L4
_L4:
        Object obj = u;
_L6:
        imageview.setTag(obj);
        obj = n;
        float f1;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 1.0F;
        }
        break MISSING_BLOCK_LABEL_158;
_L7:
        obj = ObjectAnimator.ofFloat(obj, "alpha", new float[] {
            f1, f2
        });
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).setDuration(250L);
        ((ObjectAnimator) (obj)).start();
          goto _L2
        obj;
        throw obj;
_L5:
        obj = v;
          goto _L6
        while (!flag) 
        {
            f2 = 0.0F;
            break;
        }
          goto _L7
    }

    public boolean a()
    {
        s = fs.d(new StringBuilder(b.getText()));
        o.setImageBitmap(eb.a(getResources(), eb.s));
        b(s);
        if (!s)
        {
            q.setText(ec.a(getContext(), "manual_entry_card_number_invalid"));
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
        this;
        JVM INSTR monitorenter ;
        if (o.getTag().equals(v) && !flag) goto _L2; else goto _L1
_L1:
        boolean flag1 = o.getTag().equals(u);
        if (!flag1 || !flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        Object obj1 = o;
        if (!flag) goto _L5; else goto _L4
_L4:
        Object obj = u;
_L8:
        int i;
        ((ImageView) (obj1)).setTag(obj);
        i = bf.a(getContext(), 30);
        obj = n;
        float f1;
        float f2;
        AnimatorSet animatorset;
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = -i;
        }
          goto _L6
_L9:
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
          goto _L7
_L10:
        obj1 = ObjectAnimator.ofFloat(obj1, "alpha", new float[] {
            f1, f2
        });
        animatorset = new AnimatorSet();
        animatorset.setDuration(250L);
        animatorset.setInterpolator(new DecelerateInterpolator());
        animatorset.play(((android.animation.Animator) (obj))).with(((android.animation.Animator) (obj1)));
        animatorset.start();
          goto _L2
        obj;
        throw obj;
_L5:
        obj = v;
          goto _L8
_L12:
        f2 = 0.0F;
          goto _L9
_L14:
        f2 = 0.0F;
          goto _L10
_L6:
        if (!flag) goto _L12; else goto _L11
_L11:
        f2 = -i;
          goto _L9
_L7:
        if (!flag) goto _L14; else goto _L13
_L13:
        f2 = f3;
          goto _L10
    }

    public void setSupportedCreditCardTypes(ArrayList arraylist)
    {
        r = arraylist;
    }

}
