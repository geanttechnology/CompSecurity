// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.widget.ImageView;
import com.cyberlink.you.g;

public class PhotoThumbImageView extends ImageView
{

    private static final int a = Math.round(TypedValue.applyDimension(1, 150F, g.I().getResources().getDisplayMetrics()));

    public PhotoThumbImageView(Context context)
    {
        super(context);
    }

    public PhotoThumbImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PhotoThumbImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public static Pair a(int i, int j)
    {
        float f = (float)a / (float)i;
        j = (int)((float)j * f);
        return Pair.create(Integer.valueOf((int)(f * (float)i)), Integer.valueOf(j));
    }

    public static void a(ImageView imageview, int i, int j)
    {
        Pair pair = a(i, j);
        if (imageview.getLayoutParams() instanceof android.widget.RelativeLayout.LayoutParams)
        {
            imageview.getLayoutParams().width = ((Integer)pair.first).intValue();
            imageview.getLayoutParams().height = ((Integer)pair.second).intValue();
        }
    }

    protected void onMeasure(int i, int j)
    {
        Drawable drawable;
        int k;
        k = 0;
        drawable = getDrawable();
        if (drawable == null) goto _L2; else goto _L1
_L1:
        int l;
        int i1;
        l = drawable.getIntrinsicWidth();
        i1 = drawable.getIntrinsicHeight();
        if (l <= 0 || i1 <= 0) goto _L4; else goto _L3
_L3:
        if (getLayoutParams() == null) goto _L6; else goto _L5
_L5:
        float f = (float)getLayoutParams().width / (float)getLayoutParams().height;
        if (Math.abs((float)l / (float)i1 - f) > 0.05F) goto _L6; else goto _L7
_L7:
        i = 1;
_L9:
label0:
        {
            float f1;
            Pair pair;
            if (i != 0)
            {
                i = getLayoutParams().width;
                j = getLayoutParams().height;
            } else
            {
                j = 0;
                i = k;
            }
            if (i != 0)
            {
                k = j;
                if (j != 0)
                {
                    break label0;
                }
            }
            pair = a(l, i1);
            k = ((Integer)pair.second).intValue();
            i = ((Integer)pair.first).intValue();
        }
        f1 = (float)a / 2.4F;
        j = k;
        if ((float)k < f1)
        {
            j = (int)f1;
        }
        k = i;
        if ((float)i < f1)
        {
            k = (int)f1;
        }
        setMeasuredDimension(k, j);
        return;
_L4:
        super.onMeasure(i, j);
        return;
_L2:
        super.onMeasure(i, j);
        return;
_L6:
        i = 0;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
