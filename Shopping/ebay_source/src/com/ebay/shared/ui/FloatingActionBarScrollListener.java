// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.view.View;
import com.ebay.mobile.widget.EbayScrollView;

public class FloatingActionBarScrollListener
    implements com.ebay.mobile.widget.EbayScrollView.OnScrollChangedListener
{

    final View viewToAnimate;

    public FloatingActionBarScrollListener(View view)
    {
        viewToAnimate = view;
    }

    public void onScrollChanged(EbayScrollView ebayscrollview, int i, int j, int k, int l)
    {
        i = j - l;
        float f = viewToAnimate.getTranslationY();
        float f2 = ebayscrollview.getHeight();
        float f1 = viewToAnimate.getHeight();
        f2 = (float)ebayscrollview.getChildAt(ebayscrollview.getChildCount() - 1).getBottom() - (f2 + (float)j);
        if ((float)j < f1)
        {
            viewToAnimate.setTranslationY(Math.min(f1 - (float)j, 0.0F));
        } else
        {
            if (f2 < f1)
            {
                if (i < 0)
                {
                    viewToAnimate.setTranslationY(0.0F);
                    return;
                } else
                {
                    viewToAnimate.setTranslationY(Math.max(f2, 0.0F));
                    return;
                }
            }
            if (i < 0)
            {
                viewToAnimate.setTranslationY(Math.max(f - (float)Math.abs(i), 0.0F));
                return;
            }
            if (i > 0)
            {
                viewToAnimate.setTranslationY(Math.min((float)Math.abs(i) + f, f1));
                return;
            }
        }
    }
}
