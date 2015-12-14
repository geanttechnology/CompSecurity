// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.cyberlink.youcammakeup.j;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            AutoSizeRelativeLayout

public class d extends android.widget.RelativeLayout.LayoutParams
{

    private int a[] = {
        -1, -1, -2
    };
    private int b[] = {
        320, 360, 480, 600, 800
    };
    private int c;
    private int d;

    public d(int i, int k)
    {
        super(i, k);
    }

    public d(Context context, AttributeSet attributeset, int i, int k, boolean flag)
    {
        super(context, attributeset);
        context = context.obtainStyledAttributes(attributeset, j.AutoResizeLayout);
        boolean flag2 = context.getBoolean(2, flag);
        boolean flag1 = flag;
        if (flag != flag2)
        {
            flag1 = flag2;
        }
        context.recycle();
        c = i;
        d = k;
        if (c != 0)
        {
            i = (int)((float)AutoSizeRelativeLayout.c() / ((float)AutoSizeRelativeLayout.d() / 160F));
            float f;
            float f1;
            if (!flag1)
            {
                i = b(i);
            }
            f1 = (float)i / (float)c;
            f = f1;
            if (d != 0)
            {
                i = (int)((float)AutoSizeRelativeLayout.b() / ((float)AutoSizeRelativeLayout.d() / 160F));
                float f2;
                if (!flag1)
                {
                    i = c(i);
                }
                f2 = (float)i / (float)d;
                f = f2;
                if (f1 < f2)
                {
                    f = f1;
                }
            }
            if (f > 0.0F)
            {
                if (a(width))
                {
                    i = width;
                } else
                {
                    i = a(width, Math.round((float)width * f));
                }
                width = i;
                if (a(height))
                {
                    i = height;
                } else
                {
                    i = a(height, Math.round((float)height * f));
                }
                height = i;
                leftMargin = a(leftMargin, Math.round((float)leftMargin * f));
                topMargin = a(topMargin, Math.round((float)topMargin * f));
                rightMargin = a(rightMargin, Math.round((float)rightMargin * f));
                bottomMargin = a(bottomMargin, Math.round(f * (float)bottomMargin));
            }
        }
    }

    private int a(int i, int k)
    {
        byte byte0;
        if (i > 0)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        if (k == 0)
        {
            k = i;
            if (i != 0)
            {
                k = byte0;
            }
            return k;
        } else
        {
            return k;
        }
    }

    private boolean a(int i)
    {
        int k = 0;
        boolean flag = false;
        for (; k < a.length; k++)
        {
            if (i == a[k])
            {
                flag = true;
            }
        }

        return flag;
    }

    private int b(int i)
    {
        int k = 0;
        int l = b[0];
        for (; k < b.length; k++)
        {
            if (i >= b[k])
            {
                l = b[k];
            }
        }

        return l;
    }

    private int c(int i)
    {
        int k = 0;
        int l = b[0];
        for (; k < b.length; k++)
        {
            int i1 = b[k] * (AutoSizeRelativeLayout.b() / AutoSizeRelativeLayout.c());
            if (i >= i1)
            {
                l = i1;
            }
        }

        return l;
    }
}
