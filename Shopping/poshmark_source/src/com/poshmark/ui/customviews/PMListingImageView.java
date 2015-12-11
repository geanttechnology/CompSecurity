// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMImageView

public class PMListingImageView extends PMImageView
{

    static final int LEFT = 1;
    static final int MY_BUNDLES_ROW_IMAGE_1 = 5;
    static final int MY_BUNDLES_ROW_IMAGE_2 = 6;
    static final int MY_BUNDLES_ROW_IMAGE_3 = 7;
    static final int ONE_THIRD = 4;
    static final int QUAD = 3;
    static final int SQUARE = 0;
    static final int TOP = 2;
    boolean bHeightWidthSet;
    int height;
    int layoutType;
    int width;

    public PMListingImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bHeightWidthSet = false;
        layoutType = getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.PMCovershotImageView).getInt(0, 0);
    }

    public void launchFragmentOnClick()
    {
    }

    protected void onMeasure(int i, int j)
    {
        if (bHeightWidthSet) goto _L2; else goto _L1
_L1:
        width = getDefaultSize(getSuggestedMinimumWidth(), i);
        layoutType;
        JVM INSTR tableswitch 1 6: default 60
    //                   1 98
    //                   2 116
    //                   3 129
    //                   4 142
    //                   5 155
    //                   6 168;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        width = getDefaultSize(getSuggestedMinimumWidth(), i);
_L10:
        height = width;
        setMeasuredDimension(width, height);
        bHeightWidthSet = true;
        return;
_L4:
        width = width - width / 3;
        continue; /* Loop/switch isn't completed */
_L5:
        width = width / 2;
        continue; /* Loop/switch isn't completed */
_L6:
        width = width / 2;
        continue; /* Loop/switch isn't completed */
_L7:
        width = width / 3;
        continue; /* Loop/switch isn't completed */
_L8:
        width = width / 3;
        continue; /* Loop/switch isn't completed */
_L9:
        width = width / 2;
        if (true) goto _L10; else goto _L2
_L2:
        if (layoutType == 0)
        {
            width = getDefaultSize(getSuggestedMinimumWidth(), i);
            height = width;
        }
        setMeasuredDimension(width, height);
        return;
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
    }
}
