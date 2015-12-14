// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import viewpagerindicator.TabPageIndicator;

public class cfu extends FrameLayout
{

    final TabPageIndicator a;
    private int b;
    private TextView c;
    private View d;

    public cfu(TabPageIndicator tabpageindicator, Context context)
    {
        a = tabpageindicator;
        super(context, null, 0x7f0100e7);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300cf, this, true);
        c = (TextView)findViewById(0x7f0d033e);
    }

    public static int a(cfu cfu1, int i)
    {
        cfu1.b = i;
        return i;
    }

    public int a()
    {
        return b;
    }

    public void a(int i, int j, int k, int l)
    {
        c.setCompoundDrawablesWithIntrinsicBounds(i, j, k, l);
    }

    public void a(CharSequence charsequence)
    {
        c.setText(charsequence);
    }

    public void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (TabPageIndicator.access$400(a) > 0 && getMeasuredWidth() > TabPageIndicator.access$400(a))
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(TabPageIndicator.access$400(a), 0x40000000), j);
        }
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (d == null)
        {
            d = new View(getContext());
            d.setBackgroundColor(0xff0080ff);
            Object obj = c.getPaint();
            obj = new android.widget.FrameLayout.LayoutParams((int)Layout.getDesiredWidth(c.getText(), ((android.text.TextPaint) (obj))) + yp.a(getContext(), 20F), yp.a(getContext(), 2.0F), 81);
            addView(d, ((android.view.ViewGroup.LayoutParams) (obj)));
        }
        if (flag)
        {
            c.setTextColor(0xff0080ff);
            d.setVisibility(0);
            return;
        } else
        {
            c.setTextColor(-1);
            d.setVisibility(4);
            return;
        }
    }
}
