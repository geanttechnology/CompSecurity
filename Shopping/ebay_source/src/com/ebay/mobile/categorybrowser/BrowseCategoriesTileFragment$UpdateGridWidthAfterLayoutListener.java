// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesTileFragment

public static final class newGridWidth
    implements android.view.fterLayoutListener
{

    private final WeakReference fragmentReference;
    private final int newGridWidth;
    private final WeakReference viewReference;

    public void onGlobalLayout()
    {
        BrowseCategoriesTileFragment browsecategoriestilefragment = (BrowseCategoriesTileFragment)fragmentReference.get();
        View view;
        for (view = (View)viewReference.get(); browsecategoriestilefragment == null || view == null || view.getWidth() <= 0;)
        {
            return;
        }

        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        browsecategoriestilefragment.setColumnSpan(newGridWidth);
    }

    public (BrowseCategoriesTileFragment browsecategoriestilefragment, View view, int i)
    {
        fragmentReference = new WeakReference(browsecategoriestilefragment);
        viewReference = new WeakReference(view);
        newGridWidth = i;
    }
}
