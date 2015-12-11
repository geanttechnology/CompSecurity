// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

// Referenced classes of package fr.castorflex.android.smoothprogressbar:
//            b, h, d, f, 
//            e, c, k

public class SmoothProgressBar extends ProgressBar
{

    public SmoothProgressBar(Context context)
    {
        this(context, null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, b.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeset, int i)
    {
        String s;
        Resources resources;
        int j;
        int l;
        int i1;
        int j1;
        int k1;
        boolean flag;
        boolean flag1;
        super(context, attributeset, i);
        resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, h.SmoothProgressBar, i, 0);
        i = attributeset.getColor(1, resources.getColor(d.spb_default_color));
        j = attributeset.getInteger(4, resources.getInteger(f.spb_default_sections_count));
        l = attributeset.getDimensionPixelSize(3, resources.getDimensionPixelSize(e.spb_default_stroke_separator_length));
        i1 = attributeset.getDimensionPixelSize(2, resources.getDimensionPixelSize(e.spb_default_stroke_width));
        s = attributeset.getString(5);
        j1 = attributeset.getInteger(6, resources.getInteger(f.spb_default_interpolator));
        flag = attributeset.getBoolean(7, resources.getBoolean(c.spb_default_reversed));
        flag1 = attributeset.getBoolean(8, resources.getBoolean(c.spb_default_mirror_mode));
        k1 = attributeset.getResourceId(9, 0);
        attributeset.recycle();
        j1;
        JVM INSTR tableswitch 1 3: default 180
    //                   1 256
    //                   2 234
    //                   3 245;
           goto _L1 _L2 _L3 _L4
_L1:
        attributeset = new AccelerateInterpolator();
_L6:
        int ai[];
        ai = null;
        if (k1 != 0)
        {
            ai = resources.getIntArray(k1);
        }
        context = new k(context);
        context.a = attributeset;
        if (j <= 0)
        {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        break; /* Loop/switch isn't completed */
_L3:
        attributeset = new AccelerateDecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L4:
        attributeset = new DecelerateInterpolator();
        continue; /* Loop/switch isn't completed */
_L2:
        attributeset = new LinearInterpolator();
        if (true) goto _L6; else goto _L5
_L5:
        context.b = j;
        if (l < 0)
        {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        context.g = l;
        context = context.b(i1);
        context.e = flag;
        context.f = flag1;
        if (s != null)
        {
            float f1 = Float.parseFloat(s);
            if (f1 < 0.0F)
            {
                throw new IllegalArgumentException("Speed must be >= 0");
            }
            context.d = f1;
        }
        if (ai != null && ai.length > 0)
        {
            if (ai == null || ai.length == 0)
            {
                throw new IllegalArgumentException("Your color array must not be empty");
            }
            context.c = ai;
        } else
        {
            context.a(i);
        }
        setIndeterminateDrawable(context.a());
        return;
    }
}
