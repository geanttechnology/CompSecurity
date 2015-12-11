// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import com.target.ui.view.b.a;

// Referenced classes of package com.target.ui.view:
//            BitmapImageView

public class SquareBitmapImageView extends BitmapImageView
{

    private static final float ASPECT_RATIO = 1F;
    private a mAspectMeasurer;

    public SquareBitmapImageView(Context context)
    {
        super(context);
        a();
    }

    public SquareBitmapImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public SquareBitmapImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        mAspectMeasurer = new a(1.0D);
    }

    protected void onMeasure(int i, int j)
    {
        mAspectMeasurer.a(i, j);
        super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(mAspectMeasurer.a(), 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(mAspectMeasurer.b(), 0x40000000));
    }
}
