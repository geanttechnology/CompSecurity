// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesFragment, CategoryViewModel

public static final class fragmentReference
    implements com.ebay.mobile.common.view.ner
{

    private final WeakReference fragmentReference;

    public void onClick(View view, ViewModel viewmodel)
    {
        for (view = (BrowseCategoriesFragment)fragmentReference.get(); view == null || !(viewmodel instanceof CategoryViewModel);)
        {
            return;
        }

        view.startSearch(((CategoryViewModel)viewmodel).category);
    }

    public (BrowseCategoriesFragment browsecategoriesfragment)
    {
        fragmentReference = new WeakReference(browsecategoriesfragment);
    }
}
