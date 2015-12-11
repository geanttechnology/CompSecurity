// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class cd extends RelativeLayout
{

    protected static final float MIN_RATIO = 1.33F;
    public float ratio;

    public cd(Context context)
    {
        super(context);
        ratio = 1.33F;
    }

    public cd(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ratio = 1.33F;
        init(context, attributeset);
    }

    public cd(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        ratio = 1.33F;
        init(context, attributeset);
    }

    public float getRatio()
    {
        return ratio;
    }

    public abstract void init(Context context, AttributeSet attributeset);

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        int i1;
label0:
        {
            k = 0;
            int k1 = android.view.View.MeasureSpec.getMode(i);
            l = android.view.View.MeasureSpec.getSize(i);
            int j1 = android.view.View.MeasureSpec.getMode(j);
            i1 = android.view.View.MeasureSpec.getSize(j);
            if (getContext().getResources().getConfiguration().orientation == 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 && ratio != 0.0F && ratio > 1.33F)
            {
                throw new IllegalArgumentException("Portrait ratio must be <= 1.33");
            }
            if (i == 0 && ratio != 0.0F && ratio < 1.33F)
            {
                throw new IllegalArgumentException("Landscape ratio must be >= 1.33");
            }
            if (k1 == 0x80000000 || k1 == 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (j1 != 0x80000000)
            {
                j = k;
                if (j1 != 0)
                {
                    break label0;
                }
            }
            j = 1;
        }
        if (l == 0 || j == 0 || ratio == 0.0F) goto _L2; else goto _L1
_L1:
        i = (int)((float)l / ratio);
        k = l;
_L4:
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(k, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(i, 0x40000000));
        return;
_L2:
        if (i == 0 || i1 == 0 || ratio == 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        k = (int)((float)i1 * ratio);
        i = i1;
        if (true) goto _L4; else goto _L3
_L3:
        if (i != 0 && j != 0 && ratio != 0.0F)
        {
            throw new IllegalArgumentException("layout_width or layout_height should be set to a fixed value when ratio is used");
        }
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = i1;
        k = l;
        if (j == 0) goto _L4; else goto _L5
_L5:
        i = i1;
        k = l;
        if (ratio == 0.0F)
        {
            throw new IllegalArgumentException("ratio should be set");
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void setRatio(float f)
    {
        ratio = f;
    }
}
