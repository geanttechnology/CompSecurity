// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.a.b.ad;
import com.a.b.aq;

// Referenced classes of package com.wishabi.flipp.widget:
//            cg

public class ItemDetailImageView extends FrameLayout
{

    private final ImageView a;
    private final ProgressBar b;
    private String c;
    private float d;

    public ItemDetailImageView(Context context)
    {
        this(context, null);
    }

    public ItemDetailImageView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ItemDetailImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d = 1.0F;
        a = new ImageView(context);
        a.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        addView(a);
        b = new ProgressBar(context);
        b.setIndeterminate(true);
        b.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -2, 17));
        addView(b);
    }

    static ProgressBar a(ItemDetailImageView itemdetailimageview)
    {
        return itemdetailimageview.b;
    }

    protected void onMeasure(int i, int j)
    {
        Resources resources = getResources();
        Drawable drawable = a.getDrawable();
        if (drawable == null || resources == null)
        {
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec((int)(d * (float)android.view.View.MeasureSpec.getSize(i)), 0x40000000));
            return;
        } else
        {
            j = (int)TypedValue.applyDimension(1, 320F, resources.getDisplayMetrics());
            int k = drawable.getIntrinsicWidth();
            super.onMeasure(i, android.view.View.MeasureSpec.makeMeasureSpec(Math.min(j, (drawable.getIntrinsicHeight() * android.view.View.MeasureSpec.getSize(i)) / k), 0x40000000));
            return;
        }
    }

    public void setImageUrl(String s)
    {
        if ((c != null || s != null) && (c == null || s == null || !c.equals(s)))
        {
            c = s;
            a.setImageDrawable(null);
            if (s != null)
            {
                ad.a(getContext()).a(c).a(a, new cg(this));
                return;
            }
        }
    }

    public void setRatio(float f)
    {
        d = f;
        requestLayout();
    }
}
