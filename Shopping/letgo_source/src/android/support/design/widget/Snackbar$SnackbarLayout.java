// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.ah;
import android.support.v4.view.ay;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.support.design.widget:
//            Snackbar

public static class setClickable extends LinearLayout
{
    static interface a
    {

        public abstract void a(View view, int i, int j, int k, int l);
    }


    private TextView a;
    private TextView b;
    private int c;
    private int d;
    private a e;

    private static void a(View view, int i, int j)
    {
        if (ah.x(view))
        {
            ah.a(view, ah.k(view), i, ah.l(view), j);
            return;
        } else
        {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), j);
            return;
        }
    }

    private boolean a(int i, int j, int k)
    {
        boolean flag = false;
        if (i != getOrientation())
        {
            setOrientation(i);
            flag = true;
        }
        if (a.getPaddingTop() != j || a.getPaddingBottom() != k)
        {
            a(((View) (a)), j, k);
            flag = true;
        }
        return flag;
    }

    void a(int i, int j)
    {
        ah.c(a, 0.0F);
        ah.q(a).a(1.0F).a(j).b(i).b();
        if (b.getVisibility() == 0)
        {
            ah.c(b, 0.0F);
            ah.q(b).a(1.0F).a(j).b(i).b();
        }
    }

    void b(int i, int j)
    {
        ah.c(a, 1.0F);
        ah.q(a).a(0.0F).a(j).b(i).b();
        if (b.getVisibility() == 0)
        {
            ah.c(b, 1.0F);
            ah.q(b).a(0.0F).a(j).b(i).b();
        }
    }

    TextView getActionView()
    {
        return b;
    }

    TextView getMessageView()
    {
        return a;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        a = (TextView)findViewById(android.support.v7.kbarLayout.findViewById);
        b = (TextView)findViewById(android.support.v7.kbarLayout.findViewById);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag && e != null)
        {
            e.a(this, i, j, k, l);
        }
    }

    protected void onMeasure(int i, int j)
    {
        int l;
        int i1;
        super.onMeasure(i, j);
        int k = i;
        if (c > 0)
        {
            k = i;
            if (getMeasuredWidth() > c)
            {
                k = android.view.sureSpec(c, 0x40000000);
                super.onMeasure(k, j);
            }
        }
        l = getResources().getDimensionPixelSize(android.support.v7.tical_2lines);
        i1 = getResources().getDimensionPixelSize(android.support.v7.tical);
        if (a.getLayout().getLineCount() > 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 || d <= 0 || b.getMeasuredWidth() <= d) goto _L2; else goto _L1
_L1:
        if (!a(1, l, l - i1)) goto _L4; else goto _L3
_L3:
        i = 1;
_L6:
        if (i != 0)
        {
            super.onMeasure(k, j);
        }
        return;
_L2:
        if (i != 0)
        {
            i = l;
        } else
        {
            i = i1;
        }
        if (a(0, i, i))
        {
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        i = 0;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void setOnLayoutChangeListener(a a1)
    {
        e = a1;
    }

    public a(Context context)
    {
        this(context, null);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        attributeset = context.obtainStyledAttributes(attributeset, android.support.v7.tes);
        c = attributeset.getDimensionPixelSize(android.support.v7.id_maxWidth, -1);
        d = attributeset.getDimensionPixelSize(android.support.v7.tionInlineWidth, -1);
        if (attributeset.hasValue(android.support.v7.tion))
        {
            ah.f(this, attributeset.getDimensionPixelSize(android.support.v7.tion, 0));
        }
        attributeset.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(android.support.v7.ude, this);
    }
}
