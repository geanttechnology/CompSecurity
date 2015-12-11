// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.ImageView;
import java.util.LinkedList;
import java.util.ListIterator;

// Referenced classes of package com.smule.android.console:
//            j, l

public class i extends ImageView
    implements j
{

    private int a;
    private int b;
    private final int c;
    private Paint d;
    private LinkedList e;
    private StringBuilder f;
    private int g;
    private int h;

    public i(Context context, int k)
    {
        super(context);
        a = 20;
        d = new Paint();
        d.setTypeface(Typeface.MONOSPACE);
        d.setColor(-1);
        e = new LinkedList();
        f = new StringBuilder(512);
        c = k;
        setFontSize(a);
        h = 0;
    }

    public void a()
    {
        int i1 = e.size();
        for (int k = 0; k < i1; k++)
        {
            e.remove(0);
        }

        requestLayout();
        invalidate();
    }

    public void a(int k, int i1, int j1, int k1)
    {
        h = i1;
    }

    public void a(String s)
    {
        int k = 0;
        float f1 = getWidth();
        f.delete(0, f.length());
        if (e.size() > 0)
        {
            f.append((String)e.get(e.size() - 1));
            e.remove(e.size() - 1);
        }
        f.append(s);
        int j1 = 0;
        while (k < f.length()) 
        {
            int i2 = f.indexOf("\n", j1);
            int l1;
            if (i2 != -1)
            {
                int j2 = d.breakText(f, k, i2, true, f1, null);
                l1 = j2;
                j1 = i2;
                if (j2 < i2 - k)
                {
                    j1 = -1;
                    l1 = j2;
                }
            } else
            {
                l1 = d.breakText(f, k, f.length(), true, f1, null);
                j1 = i2;
            }
            e.add(f.substring(k, k + l1));
            if (j1 != -1)
            {
                i2 = 1;
            } else
            {
                i2 = 0;
            }
            k = l1 + i2 + k;
            if (j1 != -1 && k == f.length())
            {
                e.add("");
            }
            l1 = k;
            j1 = k;
            k = l1;
        }
        if (e.size() > 2048)
        {
            int k1 = e.size();
            for (int i1 = 0; i1 < k1 - 2048; i1++)
            {
                e.remove(0);
            }

        }
        requestLayout();
        invalidate();
    }

    public int getFontSize()
    {
        return (int)d.getTextSize();
    }

    public int getViewableHeight()
    {
        return (e.size() * b + 16) - h;
    }

    protected void onDraw(Canvas canvas)
    {
        boolean flag = false;
        canvas.drawColor(0xff000000);
        int i1 = h / b;
        int k = i1;
        if (i1 >= e.size())
        {
            k = e.size() - 1;
        }
        i1 = k;
        if (k < 0)
        {
            i1 = 0;
        }
        float f1 = 16F + (float)(b * i1);
        ListIterator listiterator = e.listIterator(i1);
        k = ((flag) ? 1 : 0);
        do
        {
            float f2;
label0:
            {
                if (listiterator.hasNext())
                {
                    canvas.drawText((String)listiterator.next(), 0.0F, f1, d);
                    f2 = b;
                    k++;
                    if (k <= g)
                    {
                        break label0;
                    }
                }
                return;
            }
            f1 = f2 + f1;
        } while (true);
    }

    protected void onMeasure(int k, int i1)
    {
        int j1;
        if (e.size() < g)
        {
            j1 = g;
        } else
        {
            j1 = e.size();
        }
        i1 = getDefaultSize(j1 * b, i1);
        setMeasuredDimension(getDefaultSize(0, k), i1);
    }

    public void setFontSize(int k)
    {
        boolean flag1 = false;
        l al[] = l.values();
        int j1 = al.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (k != al[i1].a())
                    {
                        break label0;
                    }
                    flag = true;
                }
                if (!flag)
                {
                    k = l.b.a();
                }
                a = k;
                d.setTextSize(a);
                b = a + 2;
                g = c / b;
                return;
            }
            i1++;
        } while (true);
    }
}
