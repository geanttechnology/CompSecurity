// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import a;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import ca;
import fy;
import fz;
import gd;
import gj;
import gk;
import i;
import ip;
import ir;
import iz;
import j;
import km;
import m;
import r;

public class MediaRouteButton extends View
{

    private static final int l[] = {
        0x10100a0
    };
    private static final int m[] = {
        0x101009f
    };
    boolean a;
    private final ir b;
    private final fy c;
    private ip d;
    private gk e;
    private boolean f;
    private Drawable g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;

    public MediaRouteButton(Context context)
    {
        this(context, null);
    }

    public MediaRouteButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f01007b);
    }

    public MediaRouteButton(Context context, AttributeSet attributeset, int i1)
    {
        super(a.a(context, false), attributeset, i1);
        d = ip.c;
        e = gk.a();
        context = getContext();
        b = ir.a(context);
        c = new fy(this);
        context = context.obtainStyledAttributes(attributeset, km.a, i1, 0);
        attributeset = context.getDrawable(2);
        if (g != null)
        {
            g.setCallback(null);
            unscheduleDrawable(g);
        }
        g = attributeset;
        if (attributeset != null)
        {
            attributeset.setCallback(this);
            attributeset.setState(getDrawableState());
            boolean flag;
            if (getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            attributeset.setVisible(flag, false);
        }
        refreshDrawableState();
        j = context.getDimensionPixelSize(0, 0);
        k = context.getDimensionPixelSize(1, 0);
        context.recycle();
        setClickable(true);
        setLongClickable(true);
    }

    public static void a(MediaRouteButton mediaroutebutton)
    {
        mediaroutebutton.b();
    }

    private void b()
    {
        boolean flag = false;
        if (f)
        {
            Object obj = b;
            obj = ir.c();
            boolean flag1;
            boolean flag2;
            if (!((iz) (obj)).b() && ((iz) (obj)).a(d))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1 && ((iz) (obj)).f)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (h != flag1)
            {
                h = flag1;
                flag = true;
            }
            if (i != flag2)
            {
                i = flag2;
                flag = true;
            }
            if (flag)
            {
                refreshDrawableState();
            }
            obj = b;
            setEnabled(ir.a(d, 1));
        }
    }

    public final void a(gk gk1)
    {
        if (gk1 == null)
        {
            throw new IllegalArgumentException("factory must not be null");
        } else
        {
            e = gk1;
            return;
        }
    }

    public final void a(ip ip1)
    {
        if (ip1 == null)
        {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (!d.equals(ip1))
        {
            if (f)
            {
                if (!d.c())
                {
                    b.a(c);
                }
                if (!ip1.c())
                {
                    b.a(ip1, c, 0);
                }
            }
            d = ip1;
            b();
        }
    }

    public final boolean a()
    {
        Object obj;
        Object obj3;
        obj3 = null;
        if (!f)
        {
            return false;
        }
        obj = getContext();
_L8:
        if (!(obj instanceof ContextWrapper)) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof Activity)) goto _L4; else goto _L3
_L3:
        Activity activity = (Activity)obj;
_L6:
        obj = obj3;
        if (activity instanceof m)
        {
            obj = ((m)activity).b;
        }
        if (obj == null)
        {
            throw new IllegalStateException("The activity must be a subclass of FragmentActivity");
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = ((ContextWrapper)obj).getBaseContext();
        continue; /* Loop/switch isn't completed */
_L2:
        activity = null;
        if (true) goto _L6; else goto _L5
_L5:
        Object obj1 = b;
        obj1 = ir.c();
        if (((iz) (obj1)).b() || !((iz) (obj1)).a(d))
        {
            if (((r) (obj)).a("android.support.v7.mediarouter:MediaRouteChooserDialogFragment") != null)
            {
                Log.w("MediaRouteButton", "showDialog(): Route chooser dialog already showing!");
                return false;
            }
            gd gd1 = e.b();
            ip ip1 = d;
            if (ip1 == null)
            {
                throw new IllegalArgumentException("selector must not be null");
            }
            gd1.m();
            if (!gd1.W.equals(ip1))
            {
                gd1.W = ip1;
                Bundle bundle = ((j) (gd1)).k;
                Object obj2 = bundle;
                if (bundle == null)
                {
                    obj2 = new Bundle();
                }
                ((Bundle) (obj2)).putBundle("selector", ip1.a);
                if (((j) (gd1)).i >= 0)
                {
                    throw new IllegalStateException("Fragment already active");
                }
                gd1.k = ((Bundle) (obj2));
                obj2 = (fz)((i) (gd1)).b;
                if (obj2 != null)
                {
                    ((fz) (obj2)).a(ip1);
                }
            }
            gd1.a(((r) (obj)), "android.support.v7.mediarouter:MediaRouteChooserDialogFragment");
        } else
        {
            if (((r) (obj)).a("android.support.v7.mediarouter:MediaRouteControllerDialogFragment") != null)
            {
                Log.w("MediaRouteButton", "showDialog(): Route controller dialog already showing!");
                return false;
            }
            e.c().a(((r) (obj)), "android.support.v7.mediarouter:MediaRouteControllerDialogFragment");
        }
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        if (g != null)
        {
            int ai[] = getDrawableState();
            g.setState(ai);
            invalidate();
        }
    }

    public void jumpDrawablesToCurrentState()
    {
        if (getBackground() != null)
        {
            ca.a(getBackground());
        }
        if (g != null)
        {
            ca.a(g);
        }
    }

    public void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        f = true;
        if (!d.c())
        {
            b.a(d, c, 0);
        }
        b();
    }

    protected int[] onCreateDrawableState(int i1)
    {
        int ai[] = super.onCreateDrawableState(i1 + 1);
        if (i)
        {
            mergeDrawableStates(ai, m);
        } else
        if (h)
        {
            mergeDrawableStates(ai, l);
            return ai;
        }
        return ai;
    }

    public void onDetachedFromWindow()
    {
        f = false;
        if (!d.c())
        {
            b.a(c);
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (g != null)
        {
            int j2 = getPaddingLeft();
            int k2 = getWidth();
            int l2 = getPaddingRight();
            int k1 = getPaddingTop();
            int l1 = getHeight();
            int i2 = getPaddingBottom();
            int i1 = g.getIntrinsicWidth();
            int j1 = g.getIntrinsicHeight();
            j2 += (k2 - l2 - j2 - i1) / 2;
            k1 = (l1 - i2 - k1 - j1) / 2 + k1;
            g.setBounds(j2, k1, j2 + i1, k1 + j1);
            g.draw(canvas);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int k2;
        i2 = 0;
        l1 = android.view.View.MeasureSpec.getSize(i1);
        k1 = android.view.View.MeasureSpec.getSize(j1);
        int j2 = android.view.View.MeasureSpec.getMode(i1);
        j1 = android.view.View.MeasureSpec.getMode(j1);
        k2 = j;
        int l2;
        if (g != null)
        {
            i1 = g.getIntrinsicWidth();
        } else
        {
            i1 = 0;
        }
        k2 = Math.max(k2, i1);
        l2 = k;
        i1 = i2;
        if (g != null)
        {
            i1 = g.getIntrinsicHeight();
        }
        i2 = Math.max(l2, i1);
        j2;
        JVM INSTR lookupswitch 2: default 116
    //                   -2147483648: 187
    //                   1073741824: 181;
           goto _L1 _L2 _L3
_L1:
        i1 = k2 + getPaddingLeft() + getPaddingRight();
_L7:
        j1;
        JVM INSTR lookupswitch 2: default 156
    //                   -2147483648: 213
    //                   1073741824: 208;
           goto _L4 _L5 _L6
_L4:
        j1 = getPaddingTop() + i2 + getPaddingBottom();
_L8:
        setMeasuredDimension(i1, j1);
        return;
_L3:
        i1 = l1;
          goto _L7
_L2:
        i1 = Math.min(l1, k2 + getPaddingLeft() + getPaddingRight());
          goto _L7
_L6:
        j1 = k1;
          goto _L8
_L5:
        j1 = Math.min(k1, getPaddingTop() + i2 + getPaddingBottom());
          goto _L8
    }

    public boolean performClick()
    {
        boolean flag = false;
        boolean flag1 = super.performClick();
        if (!flag1)
        {
            playSoundEffect(0);
        }
        if (a() || flag1)
        {
            flag = true;
        }
        return flag;
    }

    public boolean performLongClick()
    {
        if (super.performLongClick())
        {
            return true;
        }
        if (!a)
        {
            return false;
        }
        Object obj = getContentDescription();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return false;
        }
        int ai[] = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(ai);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int i1 = getWidth();
        int j1 = getHeight();
        int k1 = ai[1];
        int l1 = j1 / 2;
        int i2 = context.getResources().getDisplayMetrics().widthPixels;
        obj = Toast.makeText(context, ((CharSequence) (obj)), 0);
        if (k1 + l1 < rect.height())
        {
            ((Toast) (obj)).setGravity(0x800035, i2 - ai[0] - i1 / 2, j1);
        } else
        {
            ((Toast) (obj)).setGravity(81, 0, j1);
        }
        ((Toast) (obj)).show();
        performHapticFeedback(0);
        return true;
    }

    public void setVisibility(int i1)
    {
        super.setVisibility(i1);
        if (g != null)
        {
            Drawable drawable = g;
            boolean flag;
            if (getVisibility() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            drawable.setVisible(flag, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return super.verifyDrawable(drawable) || drawable == g;
    }

}
