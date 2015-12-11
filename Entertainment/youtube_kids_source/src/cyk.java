// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class cyk extends ViewGroup
{

    public List a;
    public cyl b;
    public int c;
    public float d;
    public Typeface e;
    public int f;
    public int g;
    public int h;
    private Resources i;
    private List j;
    private List k;
    private List l;
    private List m;
    private cyc n;

    public cyk(Context context)
    {
        super(context);
        i = getContext().getResources();
        j = new ArrayList();
        k = new ArrayList();
        a = new ArrayList();
        l = new ArrayList();
        m = new ArrayList();
        b = new cyl(getContext());
        int i1 = (int)i.getDimension(0x7f0a000a);
        b.setPadding(i1, i1, i1, i1);
    }

    private static void a(List list, String s)
    {
        Object obj = Html.fromHtml(s);
        s = obj.toString();
        obj = new SpannableStringBuilder(((CharSequence) (obj)));
        int i1 = 0;
        while (i1 < ((SpannableStringBuilder) (obj)).length()) 
        {
            int j1 = s.substring(i1).indexOf("\n");
            if (j1 == -1)
            {
                j1 = ((SpannableStringBuilder) (obj)).length();
            } else
            {
                j1 += i1;
            }
            list.add(((SpannableStringBuilder) (obj)).subSequence(i1, j1));
            i1 = j1 + 1;
        }
    }

    public final void a(cyc cyc1)
    {
        n = cyc1;
        k.clear();
        j.clear();
        l.clear();
        m.clear();
        a(k, cyc1.c);
        a(j, cyc1.d);
        requestLayout();
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        if (!m.isEmpty() && !l.isEmpty())
        {
            int i2 = k1 - i1;
            j1 = getPaddingLeft();
            int j2 = getPaddingRight();
            k1 = getPaddingTop();
            int k2 = n.b.b;
            l1 = 0;
            while (l1 < j.size()) 
            {
                cyl cyl1 = (cyl)a.get(l1);
                i1 = ((Integer)l.get(l1)).intValue();
                int l2 = ((Integer)m.get(l1)).intValue();
                if ((k2 & 4) != 0)
                {
                    i1 = i2 - j2 - i1;
                } else
                if ((k2 & 2) != 0)
                {
                    i1 = (int)((double)(i2 - i1) / 2D);
                } else
                {
                    i1 = j1;
                }
                if (n.b.f)
                {
                    i1 = j1;
                }
                cyl1.layout(i1, k1, cyl1.getMeasuredWidth() + i1, cyl1.getMeasuredHeight() + k1);
                l1++;
                k1 += l2;
            }
        }
    }

    protected final void onMeasure(int i1, int j1)
    {
        int l1 = 0;
        int j2 = android.view.View.MeasureSpec.getSize(i1);
        int i2 = android.view.View.MeasureSpec.getSize(j1);
        int k2 = getPaddingLeft();
        int i3 = getPaddingRight();
        int k1 = getPaddingTop();
        int l2 = getPaddingBottom();
        k2 = android.view.View.MeasureSpec.makeMeasureSpec(j2 - (k2 + i3), 0);
        l2 = android.view.View.MeasureSpec.makeMeasureSpec(i2 - (k1 + l2), 0);
        k1 = 0;
        while (k1 < j.size()) 
        {
            cyl cyl1;
            if (k1 < a.size())
            {
                cyl1 = (cyl)a.get(k1);
            } else
            {
                cyl1 = new cyl(getContext());
                cyl1.a(c);
                cyl1.a(d);
                cyl1.a(e);
                cyl1.b(f);
                cyl1.c(g);
                cyl1.setBackgroundColor(h);
                cyl1.b = null;
                cyl1.a = null;
                cyl1.requestLayout();
                int j3 = (int)i.getDimension(0x7f0a000a);
                cyl1.setPadding(j3, j3, j3, j3);
                addView(cyl1);
                a.add(cyl1);
            }
            if (k1 < k.size())
            {
                cyl1.setVisibility(0);
                cyl1.a((CharSequence)k.get(k1));
                cyl1.measure(k2, l2);
            } else
            {
                cyl1.setVisibility(8);
            }
            k1++;
        }
        l.clear();
        m.clear();
        Iterator iterator = j.iterator();
        int k3;
        for (k1 = 0; iterator.hasNext(); k1 = k3 + k1)
        {
            CharSequence charsequence = (CharSequence)iterator.next();
            b.a(charsequence);
            b.measure(k2, l2);
            int l3 = b.getMeasuredWidth();
            k3 = b.getMeasuredHeight();
            l.add(Integer.valueOf(l3));
            m.add(Integer.valueOf(k3));
            l1 = Math.max(l3, l1);
        }

        l1 = getPaddingLeft() + getPaddingRight() + l1;
        k1 += getPaddingTop() + getPaddingBottom();
        k2 = android.view.View.MeasureSpec.getMode(i1);
        if (k2 == 0x80000000)
        {
            i1 = Math.min(j2, l1);
        } else
        {
            i1 = l1;
            if (k2 == 0x40000000)
            {
                i1 = j2;
            }
        }
        if (android.view.View.MeasureSpec.getMode(j1) == 0x80000000)
        {
            j1 = Math.min(i2, k1);
        } else
        {
            j1 = k1;
            if (k2 == 0x40000000)
            {
                j1 = i2;
            }
        }
        setMeasuredDimension(i1, j1);
    }
}
