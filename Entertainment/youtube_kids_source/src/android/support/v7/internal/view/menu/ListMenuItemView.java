// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import gl;
import gv;
import ha;

public class ListMenuItemView extends LinearLayout
    implements ha
{

    public boolean a;
    public boolean b;
    private gv c;
    private ImageView d;
    private RadioButton e;
    private TextView f;
    private CheckBox g;
    private TextView h;
    private Drawable i;
    private int j;
    private Context k;
    private Context l;
    private LayoutInflater m;

    public ListMenuItemView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ListMenuItemView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset);
        l = context;
        attributeset = context.obtainStyledAttributes(attributeset, gl.j, i1, 0);
        i = attributeset.getDrawable(5);
        j = attributeset.getResourceId(1, -1);
        a = attributeset.getBoolean(7, false);
        k = context;
        attributeset.recycle();
    }

    private LayoutInflater b()
    {
        if (m == null)
        {
            m = LayoutInflater.from(l);
        }
        return m;
    }

    public final void a(gv gv1, int i1)
    {
        char c1;
        Object obj;
        c = gv1;
        boolean flag;
        if (gv1.isVisible())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        setVisibility(i1);
        obj = gv1.a(this);
        if (obj != null)
        {
            f.setText(((CharSequence) (obj)));
            if (f.getVisibility() != 0)
            {
                f.setVisibility(0);
            }
        } else
        if (f.getVisibility() != 8)
        {
            f.setVisibility(8);
        }
        flag = gv1.isCheckable();
        if (flag || e != null || g != null)
        {
            Object obj1;
            if (c.d())
            {
                if (e == null)
                {
                    e = (RadioButton)b().inflate(0x7f04000e, this, false);
                    addView(e);
                }
                obj = e;
                obj1 = g;
            } else
            {
                if (g == null)
                {
                    g = (CheckBox)b().inflate(0x7f04000b, this, false);
                    addView(g);
                }
                obj = g;
                obj1 = e;
            }
            if (flag)
            {
                ((CompoundButton) (obj)).setChecked(c.isChecked());
                if (flag)
                {
                    i1 = 0;
                } else
                {
                    i1 = 8;
                }
                if (((CompoundButton) (obj)).getVisibility() != i1)
                {
                    ((CompoundButton) (obj)).setVisibility(i1);
                }
                if (obj1 != null && ((CompoundButton) (obj1)).getVisibility() != 8)
                {
                    ((CompoundButton) (obj1)).setVisibility(8);
                }
            } else
            {
                if (g != null)
                {
                    g.setVisibility(8);
                }
                if (e != null)
                {
                    e.setVisibility(8);
                }
            }
        }
        flag = gv1.c();
        gv1.b();
        if (flag && c.c())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        obj1 = h;
        c1 = c.b();
        if (c1 != 0) goto _L4; else goto _L3
_L3:
        obj = "";
_L10:
        ((TextView) (obj1)).setText(((CharSequence) (obj)));
_L2:
        if (h.getVisibility() != i1)
        {
            h.setVisibility(i1);
        }
        obj = gv1.getIcon();
        obj1 = c.b;
        if (b)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if ((i1 != 0 || a) && (d != null || obj != null || a))
        {
            if (d == null)
            {
                d = (ImageView)b().inflate(0x7f04000c, this, false);
                addView(d, 0);
            }
            if (obj != null || a)
            {
                obj1 = d;
                if (i1 == 0)
                {
                    obj = null;
                }
                ((ImageView) (obj1)).setImageDrawable(((Drawable) (obj)));
                if (d.getVisibility() != 0)
                {
                    d.setVisibility(0);
                }
            } else
            {
                d.setVisibility(8);
            }
        }
        setEnabled(gv1.isEnabled());
        return;
_L4:
        obj = new StringBuilder(null);
        c1;
        JVM INSTR lookupswitch 3: default 592
    //                   8: 619
    //                   10: 609
    //                   32: 629;
           goto _L5 _L6 _L7 _L8
_L8:
        break MISSING_BLOCK_LABEL_629;
_L7:
        break; /* Loop/switch isn't completed */
_L5:
        ((StringBuilder) (obj)).append(c1);
_L11:
        obj = ((StringBuilder) (obj)).toString();
        if (true) goto _L10; else goto _L9
_L9:
        ((StringBuilder) (obj)).append(null);
          goto _L11
_L6:
        ((StringBuilder) (obj)).append(null);
          goto _L11
        ((StringBuilder) (obj)).append(null);
          goto _L11
    }

    public final boolean a()
    {
        return false;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        setBackgroundDrawable(i);
        f = (TextView)findViewById(0x7f100072);
        if (j != -1)
        {
            f.setTextAppearance(k, j);
        }
        h = (TextView)findViewById(0x7f100075);
    }

    protected void onMeasure(int i1, int j1)
    {
        if (d != null && a)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams)d.getLayoutParams();
            if (layoutparams.height > 0 && layoutparams1.width <= 0)
            {
                layoutparams1.width = layoutparams.height;
            }
        }
        super.onMeasure(i1, j1);
    }
}
