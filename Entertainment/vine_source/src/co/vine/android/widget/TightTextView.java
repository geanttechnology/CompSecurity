// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;

// Referenced classes of package co.vine.android.widget:
//            TypefacesTextView

public class TightTextView extends TypefacesTextView
{

    public TightTextView(Context context)
    {
        this(context, null, 0);
    }

    public TightTextView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public TightTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        if (android.view.View.MeasureSpec.getMode(i) != 0x40000000)
        {
            Layout layout = getLayout();
            int k = layout.getLineCount();
            if (k > 1)
            {
                float f = 0.0F;
                for (i = 0; i < k; i++)
                {
                    f = Math.max(f, layout.getLineWidth(i));
                }

                i = Math.round(f);
                if (i < getMeasuredWidth())
                {
                    super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(i, 0x80000000), j);
                }
            }
        }
    }
}
