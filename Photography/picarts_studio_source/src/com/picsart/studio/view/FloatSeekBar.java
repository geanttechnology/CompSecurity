// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.SeekBar;
import junit.framework.Assert;
import myobfuscated.bf.a;

// Referenced classes of package com.picsart.studio.view:
//            c

public class FloatSeekBar extends SeekBar
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    public float a;
    public float b;
    private c c;

    public FloatSeekBar(Context context)
    {
        this(context, null);
    }

    public FloatSeekBar(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x7f0c0244);
    }

    public FloatSeekBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        super.setOnSeekBarChangeListener(this);
        setMax(1000);
        context = context.obtainStyledAttributes(attributeset, a.FloatSeekBar, i, 0x7f0c0244);
        int j = context.getIndexCount();
        i = 0;
        float f = 0.0F;
        float f1 = 1.0F;
        while (i < j) 
        {
            int k = context.getIndex(i);
            float f2;
            if (k == a.FloatSeekBar_min_value)
            {
                f2 = context.getFloat(i, 0.0F);
            } else
            {
                f2 = f;
                if (k == a.FloatSeekBar_max_value)
                {
                    f1 = context.getFloat(i, 1.0F);
                    f2 = f;
                }
            }
            i++;
            f = f2;
        }
        context.recycle();
        setValueInterval(f, f1);
    }

    private float a(int i)
    {
        return a + ((float)i / 1000F) * (b - a);
    }

    public final float a()
    {
        return a(getProgress());
    }

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        if (c != null)
        {
            c.a(this, a(i), flag);
        }
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        if (c != null)
        {
            c.a(this);
        }
    }

    public void setOnSeekBarChangeListener(android.widget.SeekBar.OnSeekBarChangeListener onseekbarchangelistener)
    {
        throw new UnsupportedOperationException();
    }

    public void setOnValueChangedListener(c c1)
    {
        c = c1;
    }

    public void setValue(float f)
    {
        float f1;
        float f2;
        f1 = a;
        f2 = b;
        if (f >= f1) goto _L2; else goto _L1
_L1:
        setProgress(Math.round((1000F * (f1 - a)) / (b - a)));
        return;
_L2:
        f1 = f;
        if (f > f2)
        {
            f1 = f2;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setValueInterval(float f, float f1)
    {
        boolean flag;
        if (f < f1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        a = f;
        b = f1;
    }

    static 
    {
        com/picsart/studio/view/FloatSeekBar.getSimpleName();
    }
}
