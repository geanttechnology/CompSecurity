// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.FragmentManager;
import android.transition.TransitionInflater;
import android.view.View;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.data.EbayCategory;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesFragment, CategoryViewModel

public static final class fragmentReference
    implements com.ebay.mobile.common.view.ner
{

    private final WeakReference fragmentReference;

    public void onClick(View view, ViewModel viewmodel)
    {
        BrowseCategoriesFragment browsecategoriesfragment;
        browsecategoriesfragment = (BrowseCategoriesFragment)fragmentReference.get();
        break MISSING_BLOCK_LABEL_11;
        if (browsecategoriesfragment != null && (viewmodel instanceof CategoryViewModel))
        {
            viewmodel = ((CategoryViewModel)viewmodel).category;
            if (viewmodel != null)
            {
                view = BrowseCategoriesFragment.createFragmentTag(((EbayCategory) (viewmodel)).level);
                int i = 0;
                if (((EbayCategory) (viewmodel)).level < 1)
                {
                    view = BrowseCategoriesFragment.createFragmentTag(1);
                    i = 1;
                }
                FragmentManager fragmentmanager = browsecategoriesfragment.getFragmentManager();
                if (!browsecategoriesfragment.isTablet && ((EbayCategory) (viewmodel)).level < 1 && android.os.let >= 21)
                {
                    browsecategoriesfragment.setReturnTransition(TransitionInflater.from(browsecategoriesfragment.getActivity()).inflateTransition(0x10f0004));
                }
                fragmentmanager.popBackStack(view, i);
                return;
            }
        }
        return;
    }

    public (BrowseCategoriesFragment browsecategoriesfragment)
    {
        fragmentReference = new WeakReference(browsecategoriesfragment);
    }
}
