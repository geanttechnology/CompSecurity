// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.melnykov.fab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import myobfuscated.as.a;

// Referenced classes of package com.melnykov.fab:
//            b

public class FloatingActionButton extends ImageButton
{

    private boolean a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private final Interpolator i;

    public FloatingActionButton(Context context)
    {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        i = new AccelerateDecelerateInterpolator();
        a(context, attributeset);
    }

    public FloatingActionButton(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        i = new AccelerateDecelerateInterpolator();
        a(context, attributeset);
    }

    static int a(FloatingActionButton floatingactionbutton)
    {
        return floatingactionbutton.f;
    }

    static int a(FloatingActionButton floatingactionbutton, int j)
    {
        return floatingactionbutton.c(j);
    }

    private Drawable a(int j)
    {
        Object obj = new ShapeDrawable(new OvalShape());
        ((ShapeDrawable) (obj)).getPaint().setColor(j);
        if (e && !b())
        {
            Resources resources = getResources();
            if (f == 0)
            {
                j = 0x7f020620;
            } else
            {
                j = 0x7f020621;
            }
            obj = new LayerDrawable(new Drawable[] {
                resources.getDrawable(j), obj
            });
            ((LayerDrawable) (obj)).setLayerInset(1, g, g, g, g);
            return ((Drawable) (obj));
        } else
        {
            return ((Drawable) (obj));
        }
    }

    private void a()
    {
        Object obj = new StateListDrawable();
        Drawable drawable = a(c);
        ((StateListDrawable) (obj)).addState(new int[] {
            0x10100a7
        }, drawable);
        drawable = a(b);
        ((StateListDrawable) (obj)).addState(new int[0], drawable);
        if (b())
        {
            float f1;
            int j;
            if (e)
            {
                f1 = c(0x7f0b00eb);
            } else
            {
                f1 = 0.0F;
            }
            setElevation(f1);
            j = d;
            obj = new RippleDrawable(new ColorStateList(new int[][] {
                new int[0]
            }, new int[] {
                j
            }), ((Drawable) (obj)), null);
            setOutlineProvider(new ViewOutlineProvider() {

                private FloatingActionButton a;

                public final void getOutline(View view, Outline outline)
                {
                    view = a;
                    int k;
                    if (com.melnykov.fab.FloatingActionButton.a(a) == 0)
                    {
                        k = 0x7f0b00ef;
                    } else
                    {
                        k = 0x7f0b00ee;
                    }
                    k = com.melnykov.fab.FloatingActionButton.a(view, k);
                    outline.setOval(0, 0, k, k);
                }

            
            {
                a = FloatingActionButton.this;
                super();
            }
            });
            setClipToOutline(true);
            setBackground(((Drawable) (obj)));
            return;
        }
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            setBackground(((Drawable) (obj)));
            return;
        } else
        {
            setBackgroundDrawable(((Drawable) (obj)));
            return;
        }
    }

    private void a(Context context, AttributeSet attributeset)
    {
        a = true;
        b = b(0x7f0f00b2);
        c = b(0x7f0f00b3);
        d = b(0x106000b);
        f = 0;
        e = true;
        getResources().getDimensionPixelOffset(0x7f0b00ec);
        g = c(0x7f0b00ed);
        if (attributeset == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        context = context.obtainStyledAttributes(attributeset, b.FloatingActionButton, 0, 0);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        b = context.getColor(b.FloatingActionButton_fab_colorNormal, b(0x7f0f00b2));
        c = context.getColor(b.FloatingActionButton_fab_colorPressed, b(0x7f0f00b3));
        d = context.getColor(b.FloatingActionButton_fab_colorRipple, b(0x106000b));
        e = context.getBoolean(b.FloatingActionButton_fab_shadow, true);
        f = context.getInt(b.FloatingActionButton_fab_type, 0);
        context.recycle();
        a();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    static void a(FloatingActionButton floatingactionbutton, boolean flag, boolean flag1)
    {
        floatingactionbutton.a(flag, flag1, true);
    }

    private int b(int j)
    {
        return getResources().getColor(j);
    }

    private static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 21;
    }

    private int c(int j)
    {
        return getResources().getDimensionPixelSize(j);
    }

    public final void a(boolean flag, boolean flag1, boolean flag2)
    {
        boolean flag3 = false;
        if (a == flag && !flag2) goto _L2; else goto _L1
_L1:
        int k;
        a = flag;
        k = getHeight();
        if (k != 0 || flag2) goto _L4; else goto _L3
_L3:
        ViewTreeObserver viewtreeobserver = getViewTreeObserver();
        if (!viewtreeobserver.isAlive()) goto _L4; else goto _L5
_L5:
        viewtreeobserver.addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener(flag, flag1) {

            private boolean a;
            private boolean b;
            private FloatingActionButton c;

            public final boolean onPreDraw()
            {
                ViewTreeObserver viewtreeobserver1 = c.getViewTreeObserver();
                if (viewtreeobserver1.isAlive())
                {
                    viewtreeobserver1.removeOnPreDrawListener(this);
                }
                com.melnykov.fab.FloatingActionButton.a(c, a, b);
                return true;
            }

            
            {
                c = FloatingActionButton.this;
                a = flag;
                b = flag1;
                super();
            }
        });
_L2:
        return;
_L4:
        int j;
        if (flag)
        {
            j = 0;
        } else
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            float f1;
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                j = ((android.view.ViewGroup.MarginLayoutParams)layoutparams).bottomMargin;
            } else
            {
                j = 0;
            }
            j += k;
        }
        if (flag1)
        {
            myobfuscated.as.a.a(this).a(i).a().a(j);
        } else
        {
            f1 = j;
            if (myobfuscated.at.a.a)
            {
                myobfuscated.at.a.a(this).b(f1);
            } else
            {
                setTranslationY(f1);
            }
        }
        j = ((flag3) ? 1 : 0);
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            j = 1;
        }
        if (j == 0)
        {
            setClickable(flag);
            return;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onMeasure(int j, int k)
    {
        super.onMeasure(j, k);
        if (f == 0)
        {
            j = 0x7f0b00ef;
        } else
        {
            j = 0x7f0b00ee;
        }
        k = c(j);
        j = k;
        if (e)
        {
            j = k;
            if (!b())
            {
                j = g;
                if (!h && (getLayoutParams() instanceof android.view.ViewGroup.MarginLayoutParams))
                {
                    android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
                    marginlayoutparams.setMargins(marginlayoutparams.leftMargin - g, marginlayoutparams.topMargin - g, marginlayoutparams.rightMargin - g, marginlayoutparams.bottomMargin - g);
                    requestLayout();
                    h = true;
                }
                j = j * 2 + k;
            }
        }
        setMeasuredDimension(j, j);
    }

    public void setColorNormal(int j)
    {
        if (j != b)
        {
            b = j;
            a();
        }
    }

    public void setColorNormalResId(int j)
    {
        setColorNormal(b(j));
    }

    public void setColorPressed(int j)
    {
        if (j != c)
        {
            c = j;
            a();
        }
    }

    public void setColorPressedResId(int j)
    {
        setColorPressed(b(j));
    }

    public void setColorRipple(int j)
    {
        if (j != d)
        {
            d = j;
            a();
        }
    }

    public void setColorRippleResId(int j)
    {
        setColorRipple(b(j));
    }

    public void setShadow(boolean flag)
    {
        if (flag != e)
        {
            e = flag;
            a();
        }
    }

    public void setType(int j)
    {
        if (j != f)
        {
            f = j;
            a();
        }
    }
}
