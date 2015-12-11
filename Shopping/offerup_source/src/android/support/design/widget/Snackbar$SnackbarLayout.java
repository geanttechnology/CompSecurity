// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v4.view.bi;
import android.support.v4.view.cx;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package android.support.design.widget:
//            az

public class setClickable extends LinearLayout
{

    private TextView a;
    private Button b;
    private int c;
    private int d;
    private az e;

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
            TextView textview = a;
            if (bi.y(textview))
            {
                bi.a(textview, bi.k(textview), j, bi.l(textview), k);
            } else
            {
                textview.setPadding(textview.getPaddingLeft(), j, textview.getPaddingRight(), k);
            }
            flag = true;
        }
        return flag;
    }

    final void a(int i, int j)
    {
        bi.c(a, 0.0F);
        bi.q(a).a(1.0F).a(180L).b(70L).c();
        if (b.getVisibility() == 0)
        {
            bi.c(b, 0.0F);
            bi.q(b).a(1.0F).a(180L).b(70L).c();
        }
    }

    final void b(int i, int j)
    {
        bi.c(a, 1.0F);
        bi.q(a).a(0.0F).a(180L).b(0L).c();
        if (b.getVisibility() == 0)
        {
            bi.c(b, 1.0F);
            bi.q(b).a(0.0F).a(180L).b(0L).c();
        }
    }

    Button getActionView()
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
        a = (TextView)findViewById(0x7f1001cb);
        b = (Button)findViewById(0x7f1001cc);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (flag && e != null)
        {
            e.a();
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
        l = getResources().getDimensionPixelSize(0x7f0b0021);
        i1 = getResources().getDimensionPixelSize(0x7f0b00b1);
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

    void setOnLayoutChangeListener(az az1)
    {
        e = az1;
    }

    public (Context context)
    {
        this(context, null);
    }

    public <init>(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        attributeset = context.obtainStyledAttributes(attributeset, a.ag);
        c = attributeset.getDimensionPixelSize(a.ah, -1);
        d = attributeset.getDimensionPixelSize(a.aj, -1);
        if (attributeset.hasValue(a.ai))
        {
            bi.f(this, attributeset.getDimensionPixelSize(a.ai, 0));
        }
        attributeset.recycle();
        setClickable(true);
        LayoutInflater.from(context).inflate(0x7f040072, this);
    }
}
