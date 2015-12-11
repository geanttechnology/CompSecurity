// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            SlidingFrameLayout, ds, dp, dq, 
//            do, dl, dm, dn, 
//            dr

public class ShoppingListPopup extends SlidingFrameLayout
    implements android.view.View.OnClickListener
{

    private dr a;
    private final RelativeLayout b;
    private final TextView c;
    private final TextView d;
    private final Button e;
    private long f;
    private Animator g;
    private Animator h;
    private Animator i;
    private dq j;
    private int k;
    private int l;

    public ShoppingListPopup(Context context)
    {
        this(context, null);
    }

    public ShoppingListPopup(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ShoppingListPopup(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        setBackgroundColor(getResources().getColor(0x7f090036));
        View.inflate(getContext(), 0x7f030050, this);
        context = (RelativeLayout)findViewById(0x7f0b0133);
        b = (RelativeLayout)context.findViewById(0x7f0b0136);
        c = (TextView)context.findViewById(0x7f0b0139);
        c.setAlpha(0.0F);
        e = (Button)context.findViewById(0x7f0b0135);
        e.setOnClickListener(this);
        d = (TextView)context.findViewById(0x7f0b0138);
        f = 1000L;
        k = ds.c;
        l = dp.d;
    }

    static int a(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.k;
    }

    static int a(ShoppingListPopup shoppinglistpopup, int i1)
    {
        shoppinglistpopup.k = i1;
        return i1;
    }

    static dq a(ShoppingListPopup shoppinglistpopup, dq dq1)
    {
        shoppinglistpopup.j = dq1;
        return dq1;
    }

    static dr b(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.a;
    }

    static Button c(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.e;
    }

    static RelativeLayout d(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.b;
    }

    static TextView e(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.c;
    }

    static long f(ShoppingListPopup shoppinglistpopup)
    {
        return shoppinglistpopup.f;
    }

    public final void a(String s, boolean flag)
    {
        float f1;
        float f2;
        boolean flag1;
        d.setText(s);
        if (k == ds.b || k == ds.c)
        {
            return;
        }
        AnimatorSet animatorset;
        if (k == ds.a)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (i != null)
        {
            i.cancel();
        }
        if (j != null)
        {
            j.a = true;
        }
        if (h != null)
        {
            h.cancel();
        }
        b.setAlpha(1.0F);
        c.setAlpha(0.0F);
        e.setVisibility(0);
        setVisibility(0);
        if (!flag) goto _L2; else goto _L1
_L1:
        animatorset = new AnimatorSet();
        f1 = getXFraction();
        f2 = getYFraction();
        do.a[l - 1];
        JVM INSTR tableswitch 1 3: default 176
    //                   1 300
    //                   2 343
    //                   3 385;
           goto _L3 _L4 _L5 _L6
_L3:
        f1 = f2;
        if (f2 == 0.0F)
        {
            f1 = f2;
            if (flag1)
            {
                f1 = 1.0F;
            }
        }
        s = ObjectAnimator.ofFloat(this, "yFraction", new float[] {
            f1, 0.0F
        });
_L7:
        f1 = getAlpha();
        if (f1 == 1.0F && flag1)
        {
            f1 = 0.0F;
        }
        animatorset.playTogether(new Animator[] {
            s, ObjectAnimator.ofFloat(this, "alpha", new float[] {
                f1, 1.0F
            })
        });
        g = animatorset;
        g.addListener(new dl(this));
        g.start();
        return;
_L4:
        f2 = f1;
        if (f1 == 0.0F)
        {
            f2 = f1;
            if (flag1)
            {
                f2 = -1F;
            }
        }
        s = ObjectAnimator.ofFloat(this, "xFraction", new float[] {
            f2, 0.0F
        });
        continue; /* Loop/switch isn't completed */
_L5:
        if (f2 == 0.0F && flag1)
        {
            f1 = -1F;
        } else
        {
            f1 = f2;
        }
        s = ObjectAnimator.ofFloat(this, "yFraction", new float[] {
            f1, 0.0F
        });
        continue; /* Loop/switch isn't completed */
_L6:
        float f3 = f1;
        if (f1 == 0.0F)
        {
            f3 = f1;
            if (flag1)
            {
                f3 = 1.0F;
            }
        }
        s = ObjectAnimator.ofFloat(this, "xFraction", new float[] {
            f3, 0.0F
        });
        if (true) goto _L7; else goto _L2
_L2:
        k = ds.c;
        return;
    }

    public final void a(boolean flag)
    {
        if (k == ds.a || k == ds.d || k == ds.e)
        {
            return;
        }
        if (i != null)
        {
            i.cancel();
        }
        if (j != null)
        {
            j.a = true;
        }
        if (g != null)
        {
            g.cancel();
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        float f1;
        float f2;
        AnimatorSet animatorset;
        animatorset = new AnimatorSet();
        f1 = getXFraction();
        f2 = getYFraction();
        do.a[l - 1];
        JVM INSTR tableswitch 1 3: default 132
    //                   1 217
    //                   2 240
    //                   3 263;
           goto _L3 _L4 _L5 _L6
_L3:
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "yFraction", new float[] {
            f2, 1.0F
        });
_L7:
        animatorset.playTogether(new Animator[] {
            objectanimator, ObjectAnimator.ofFloat(this, "alpha", new float[] {
                getAlpha(), 0.0F
            })
        });
        h = animatorset;
        h.addListener(new dm(this));
        h.start();
        return;
_L4:
        objectanimator = ObjectAnimator.ofFloat(this, "xFraction", new float[] {
            f1, -1F
        });
        continue; /* Loop/switch isn't completed */
_L5:
        objectanimator = ObjectAnimator.ofFloat(this, "yFraction", new float[] {
            f2, -1F
        });
        continue; /* Loop/switch isn't completed */
_L6:
        objectanimator = ObjectAnimator.ofFloat(this, "xFraction", new float[] {
            f1, 1.0F
        });
        if (true) goto _L7; else goto _L2
_L2:
        setVisibility(8);
        k = ds.a;
        return;
    }

    public void onClick(View view)
    {
        if (k == ds.c)
        {
            view = new AnimatorSet();
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(b, "alpha", new float[] {
                1.0F, 0.0F
            });
            ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(c, "alpha", new float[] {
                0.0F, 1.0F
            });
            view.play(objectanimator).before(objectanimator1);
            i = view;
            i.addListener(new dn(this));
            i.start();
            if (a != null)
            {
                view = d.getText().toString();
                a.a(view);
                return;
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        super.onTouchEvent(motionevent);
        return true;
    }

    public void setAnchor$31b0e336(int i1)
    {
        l = i1;
    }

    public void setDismissDelay(long l1)
    {
        f = l1;
    }

    public void setShoppingListPopupListener(dr dr1)
    {
        a = dr1;
    }
}
