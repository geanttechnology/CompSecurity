// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package android.support.design.widget:
//            z, aj, ai, af, 
//            aa

public class FloatingActionButton extends ImageView
{

    private ColorStateList a;
    private android.graphics.PorterDuff.Mode b;
    private int c;
    private int d;
    private int e;
    private int f;
    private final Rect g;
    private final ai h;

    public FloatingActionButton(Context context)
    {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset, int i)
    {
        TypedArray typedarray;
        super(context, attributeset, i);
        g = new Rect();
        typedarray = context.obtainStyledAttributes(attributeset, a.I, i, 0x7f0c0194);
        attributeset = typedarray.getDrawable(a.J);
        a = typedarray.getColorStateList(a.K);
        typedarray.getInt(a.L, -1);
        JVM INSTR lookupswitch 5: default 112
    //                   3: 288
    //                   5: 295
    //                   9: 302
    //                   14: 309
    //                   15: 316;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_316;
_L1:
        context = null;
_L7:
        b = context;
        d = typedarray.getColor(a.Q, 0);
        e = typedarray.getInt(a.O, 0);
        c = typedarray.getDimensionPixelSize(a.M, 0);
        float f1 = typedarray.getDimension(a.N, 0.0F);
        float f2 = typedarray.getDimension(a.P, 0.0F);
        typedarray.recycle();
        context = new z(this);
        i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            h = new aj(this, context);
        } else
        if (i >= 12)
        {
            h = new af(this, context);
        } else
        {
            h = new aa(this, context);
        }
        i = (int)getResources().getDimension(0x7f0b00a4);
        f = (getSizeDimension() - i) / 2;
        h.a(attributeset, a, b, d, c);
        h.a(f1);
        h.b(f2);
        setClickable(true);
        return;
_L2:
        context = android.graphics.PorterDuff.Mode.SRC_OVER;
          goto _L7
_L3:
        context = android.graphics.PorterDuff.Mode.SRC_IN;
          goto _L7
_L4:
        context = android.graphics.PorterDuff.Mode.SRC_ATOP;
          goto _L7
_L5:
        context = android.graphics.PorterDuff.Mode.MULTIPLY;
          goto _L7
        context = android.graphics.PorterDuff.Mode.SCREEN;
          goto _L7
    }

    private static int a(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(j);
        j = android.view.View.MeasureSpec.getSize(j);
        switch (k)
        {
        case 0: // '\0'
        default:
            return i;

        case -2147483648: 
            return Math.min(i, j);

        case 1073741824: 
            return j;
        }
    }

    static Rect a(FloatingActionButton floatingactionbutton)
    {
        return floatingactionbutton.g;
    }

    static void a(FloatingActionButton floatingactionbutton, Drawable drawable)
    {
        floatingactionbutton.View.setBackgroundDrawable(drawable);
    }

    static int b(FloatingActionButton floatingactionbutton)
    {
        return floatingactionbutton.f;
    }

    public final void a()
    {
        h.c();
    }

    public final void b()
    {
        h.b();
    }

    protected void drawableStateChanged()
    {
        super.drawableStateChanged();
        h.a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList()
    {
        return a;
    }

    public android.graphics.PorterDuff.Mode getBackgroundTintMode()
    {
        return b;
    }

    final int getSizeDimension()
    {
        switch (e)
        {
        default:
            return getResources().getDimensionPixelSize(0x7f0b00a7);

        case 1: // '\001'
            return getResources().getDimensionPixelSize(0x7f0b00a6);
        }
    }

    public void jumpDrawablesToCurrentState()
    {
        super.jumpDrawablesToCurrentState();
        h.a();
    }

    protected void onMeasure(int i, int j)
    {
        int k = getSizeDimension();
        i = Math.min(a(k, i), a(k, j));
        setMeasuredDimension(g.left + i + g.right, i + g.top + g.bottom);
    }

    public void setBackgroundDrawable(Drawable drawable)
    {
        h.a(drawable, a, b, d, c);
    }

    public void setBackgroundTintList(ColorStateList colorstatelist)
    {
        if (a != colorstatelist)
        {
            a = colorstatelist;
            h.a(colorstatelist);
        }
    }

    public void setBackgroundTintMode(android.graphics.PorterDuff.Mode mode)
    {
        if (b != mode)
        {
            b = mode;
            h.a(mode);
        }
    }

    public void setRippleColor(int i)
    {
        if (d != i)
        {
            d = i;
            h.a(i);
        }
    }
}
