// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class sr extends cvb
    implements sy
{

    private final SparseArray a = new SparseArray();
    private final SparseArray b = new SparseArray();
    private float c;
    private float d;
    private cyi e;

    public sr(Context context)
    {
        super(context);
        d = context.getResources().getDimensionPixelSize(0x7f0a0013);
        e = new cyi(tb.a(), tb.b(), tb.d(), tc.a(), tb.c(), td.a());
        setVisibility(4);
    }

    private void a(int i, int j)
    {
        d = sz.a(getContext(), c, i, j);
        for (i = 0; i < b.size(); i++)
        {
            a((cyk)b.valueAt(i));
        }

    }

    private void a(cyk cyk1)
    {
        float f = d;
        cyk1.d = f;
        cyk1.b.a(f);
        for (Iterator iterator = cyk1.a.iterator(); iterator.hasNext(); ((cyl)iterator.next()).a(f)) { }
        cyk1.requestLayout();
        int i = e.a;
        cyk1.h = i;
        for (Iterator iterator1 = cyk1.a.iterator(); iterator1.hasNext(); ((cyl)iterator1.next()).setBackgroundColor(i)) { }
        cyk1.requestLayout();
        cyk1.setBackgroundColor(e.b);
        i = e.e;
        cyk1.c = i;
        for (Iterator iterator2 = cyk1.a.iterator(); iterator2.hasNext(); ((cyl)iterator2.next()).a(i)) { }
        cyk1.requestLayout();
        android.graphics.Typeface typeface = td.a(getContext(), e);
        cyk1.e = typeface;
        cyk1.b.a(typeface);
        for (Iterator iterator5 = cyk1.a.iterator(); iterator5.hasNext(); ((cyl)iterator5.next()).a(typeface)) { }
        cyk1.requestLayout();
        i = e.c;
        cyk1.f = i;
        for (Iterator iterator3 = cyk1.a.iterator(); iterator3.hasNext(); ((cyl)iterator3.next()).b(i)) { }
        cyk1.requestLayout();
        cyk1.setPadding(10, 10, 10, 10);
        i = e.d;
        cyk1.g = i;
        cyk1.b.c(i);
        for (Iterator iterator4 = cyk1.a.iterator(); iterator4.hasNext(); ((cyl)iterator4.next()).c(i)) { }
        cyk1.requestLayout();
    }

    public final void a()
    {
        removeAllViews();
        a.clear();
        b.clear();
    }

    public final void a(float f)
    {
        c = f;
        a(getWidth(), getHeight());
    }

    public final void a(cyi cyi1)
    {
        e = cyi1;
        a(getWidth(), getHeight());
    }

    public final void a(List list)
    {
        HashSet hashset = new HashSet();
        for (int i = 0; i < a.size(); i++)
        {
            hashset.add(Integer.valueOf(a.keyAt(i)));
        }

        int j = 0;
        while (j < list.size()) 
        {
            cyc cyc1 = (cyc)list.get(j);
            hashset.remove(Integer.valueOf(cyc1.a));
            Object obj = (cyk)b.get(cyc1.a);
            if (TextUtils.isEmpty(cyc1.c) || !cyc1.b.e)
            {
                if (obj != null)
                {
                    ((cyk) (obj)).setVisibility(8);
                }
            } else
            {
                a.put(cyc1.a, cyc1);
                if (obj == null)
                {
                    obj = cyc1.c;
                    cyk cyk1 = new cyk(getContext());
                    a(cyk1);
                    cyk1.setTag(obj);
                    cyk1.a(cyc1);
                    addView(cyk1);
                    b.put(cyc1.a, cyk1);
                } else
                {
                    if (!cyc1.c.equals(((cyk) (obj)).getTag()))
                    {
                        ((cyk) (obj)).setTag(cyc1.c);
                        ((cyk) (obj)).a(cyc1);
                    }
                    ((cyk) (obj)).setVisibility(0);
                }
            }
            j++;
        }
        int k;
        for (list = hashset.iterator(); list.hasNext(); b.remove(k))
        {
            k = ((Integer)list.next()).intValue();
            removeView((View)b.get(k));
            a.remove(k);
        }

        setVisibility(0);
    }

    public final void b()
    {
        setVisibility(4);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1);
    }

    protected final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        requestLayout();
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1;
        int j1;
        int k1;
        i = k - i;
        j = l - j;
        l = (i * 15) / 100 / 2;
        i1 = (j * 15) / 100 / 2;
        j1 = (i * 85) / 100;
        k1 = (j * 85) / 100;
        k = 0;
_L5:
        cyk cyk1;
        if (k >= a.size())
        {
            break MISSING_BLOCK_LABEL_293;
        }
        cyk1 = (cyk)b.get(a.keyAt(k));
        if (cyk1.getVisibility() != 0) goto _L2; else goto _L1
_L1:
        int i2;
        int j2;
        Object obj = (cyc)a.valueAt(k);
        int l1 = cyk1.getMeasuredWidth();
        i2 = cyk1.getMeasuredHeight();
        obj = ((cyc) (obj)).b;
        j2 = ((cxy) (obj)).b;
        i = (((cxy) (obj)).c * j1) / 100;
        j = (((cxy) (obj)).d * k1) / 100;
        if (((cxy) (obj)).f)
        {
            break MISSING_BLOCK_LABEL_249;
        }
        if ((j2 & 1) == 0)
        {
            if ((j2 & 2) != 0)
            {
                i -= l1 / 2;
            } else
            {
                if ((j2 & 4) == 0)
                {
                    break MISSING_BLOCK_LABEL_249;
                }
                i -= l1;
            }
        }
_L3:
        if ((j2 & 8) == 0)
        {
            if ((j2 & 0x10) != 0)
            {
                j -= i2 / 2;
            } else
            if ((j2 & 0x20) != 0)
            {
                j -= i2;
            } else
            {
                j = 0;
            }
        }
        i += l;
        j += i1;
        cyk1.layout(i, j, l1 + i, i2 + j);
_L2:
        k++;
        continue; /* Loop/switch isn't completed */
        i = 0;
          goto _L3
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected final void onMeasure(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getSize(i);
        int i1 = android.view.View.MeasureSpec.getSize(j);
        setMeasuredDimension(l, i1);
        a(l, i1);
        int k = 0;
        do
        {
            if (k < a.size())
            {
                cyk cyk1 = (cyk)b.get(a.keyAt(k));
                if (cyk1.getVisibility() == 0)
                {
                    cxy cxy1 = ((cyc)a.valueAt(k)).b;
                    int j1 = cxy1.b;
                    i = (cxy1.c * l) / 100;
                    j = (cxy1.d * i1) / 100;
                    if ((j1 & 1) != 0)
                    {
                        i = l - i;
                    } else
                    if ((j1 & 2) != 0)
                    {
                        i = Math.min(i, l - i) * 2;
                    } else
                    if ((j1 & 4) == 0)
                    {
                        i = 0;
                    }
                    if ((j1 & 8) != 0)
                    {
                        j = i1 - j;
                    } else
                    if ((j1 & 0x10) != 0)
                    {
                        j = Math.min(j, i1 - j) * 2;
                    } else
                    if ((j1 & 0x20) == 0)
                    {
                        j = 0;
                    }
                    cyk1.measure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0), android.view.View.MeasureSpec.makeMeasureSpec(j, 0));
                }
                k++;
                continue;
            }
            return;
        } while (true);
    }
}
