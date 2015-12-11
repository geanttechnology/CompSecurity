// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            ee, eb, ef, ea, 
//            ec, ed

public class dz extends HorizontalScrollView
{

    static final boolean a;
    private int b;
    private eb c;
    private ec d;
    private final ee e;

    public dz(Context context)
    {
        this(context, (byte)0);
    }

    private dz(Context context, byte byte0)
    {
        this(context, '\0');
    }

    private dz(Context context, char c1)
    {
        super(context, null, 0);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        b = (int)(24F * getResources().getDisplayMetrics().density);
        e = new ee(context);
        addView(e, -1, -2);
    }

    static ee a(dz dz1)
    {
        return dz1.e;
    }

    private void a(int i)
    {
        int j = e.getChildCount();
        Object obj;
        if (j != 0 && i >= 0 && i < j)
        {
            if ((obj = e.getChildAt(i)) != null)
            {
                int l = ((View) (obj)).getLeft() + 0;
                int k = l;
                if (i > 0)
                {
                    k = l - b;
                }
                smoothScrollTo(k, 0);
                obj = e;
                obj.a = i;
                obj.b = 0.0F;
                ((ee) (obj)).invalidate();
                return;
            }
        }
    }

    static void a(dz dz1, int i)
    {
        dz1.a(i);
    }

    static ec b(dz dz1)
    {
        return dz1.d;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        if (c != null)
        {
            a(c.c());
        }
    }

    public void setCustomTabColorizer(ed ed)
    {
        ee ee1 = e;
        ee1.c = ed;
        ee1.invalidate();
    }

    public transient void setDividerColors(int ai[])
    {
        ee ee1 = e;
        ee1.c = null;
        ee1.d.b = ai;
        ee1.invalidate();
    }

    public transient void setSelectedIndicatorColors(int ai[])
    {
        ee ee1 = e;
        ee1.c = null;
        ee1.d.a = ai;
        ee1.invalidate();
    }

    public void setTabAdapter(eb eb1)
    {
        e.removeAllViews();
        c = eb1;
        if (eb1 != null)
        {
            int i = 0;
            do
            {
                if (i >= c.a())
                {
                    break;
                }
                if (c.b())
                {
                    String s = c.a(i);
                    if (!a && s == null)
                    {
                        throw new AssertionError();
                    }
                    eb1 = new TextView(getContext());
                    eb1.setGravity(17);
                    eb1.setTextSize(2, 12F);
                    eb1.setTypeface(Typeface.DEFAULT_BOLD);
                    if (android.os.Build.VERSION.SDK_INT >= 11)
                    {
                        TypedValue typedvalue = new TypedValue();
                        getContext().getTheme().resolveAttribute(0x101030e, typedvalue, true);
                        eb1.setBackgroundResource(typedvalue.resourceId);
                    }
                    if (android.os.Build.VERSION.SDK_INT >= 14)
                    {
                        eb1.setAllCaps(true);
                    }
                    int j = (int)(16F * getResources().getDisplayMetrics().density);
                    eb1.setPadding(j, j, j, j);
                    eb1.setText(s);
                } else
                {
                    eb1 = c.a(e, i);
                }
                if (eb1 == null)
                {
                    break;
                }
                eb1.setOnClickListener(new ea(this));
                e.addView(eb1);
                i++;
            } while (true);
        }
    }

    public void setTabClickListener(ec ec)
    {
        d = ec;
    }

    static 
    {
        boolean flag;
        if (!com/wishabi/flipp/widget/dz.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
