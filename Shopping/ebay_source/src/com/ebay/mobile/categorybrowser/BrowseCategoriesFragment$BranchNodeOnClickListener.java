// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.EbayCategory;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            BrowseCategoriesFragment, CategoryViewModel, CategoryLineItemAdapter

public static final class fragmentReference
    implements com.ebay.mobile.common.view.ner
{

    private final WeakReference fragmentReference;

    public void onClick(View view, ViewModel viewmodel)
    {
        BrowseCategoriesFragment browsecategoriesfragment;
        browsecategoriesfragment = (BrowseCategoriesFragment)fragmentReference.get();
        break MISSING_BLOCK_LABEL_11;
        if (browsecategoriesfragment != null && browsecategoriesfragment.getView() != null && browsecategoriesfragment.getView().getParent() != null && (viewmodel instanceof CategoryViewModel))
        {
            viewmodel = ((CategoryViewModel)viewmodel).category;
            if (viewmodel != null)
            {
                Object obj = new Bundle();
                ((Bundle) (obj)).putLong("categoryId", ((EbayCategory) (viewmodel)).id);
                ((Bundle) (obj)).putString("categoryName", ((EbayCategory) (viewmodel)).name);
                ((Bundle) (obj)).putInt("categoryLevel", ((EbayCategory) (viewmodel)).level);
                if (BrowseCategoriesFragment.access$000(browsecategoriesfragment) == -1L)
                {
                    view = CategoryViewModel.getCategoryImageUrl(((EbayCategory) (viewmodel)).id);
                } else
                {
                    view = BrowseCategoriesFragment.access$100(browsecategoriesfragment);
                }
                ((Bundle) (obj)).putString("categoryImageUrl", view);
                if (BrowseCategoriesFragment.access$200(browsecategoriesfragment) == EbaySite.US && ((EbayCategory) (viewmodel)).id == 6000L)
                {
                    view = EbaySite.MOTOR;
                } else
                {
                    view = BrowseCategoriesFragment.access$200(browsecategoriesfragment);
                }
                ((Bundle) (obj)).putParcelable("categorySite", view);
                view = new EbayCategory[BrowseCategoriesFragment.access$300(browsecategoriesfragment).length + 1];
                System.arraycopy(BrowseCategoriesFragment.access$300(browsecategoriesfragment), 0, view, 0, BrowseCategoriesFragment.access$300(browsecategoriesfragment).length);
                view[view.length - 1] = viewmodel;
                ((Bundle) (obj)).putParcelableArray("navigationIdPath", view);
                view = Fragment.instantiate(browsecategoriesfragment.getActivity(), com/ebay/mobile/categorybrowser/BrowseCategoriesFragment.getName(), ((Bundle) (obj)));
                obj = browsecategoriesfragment.getFragmentManager().beginTransaction();
                if (android.os.agmentManager >= 21)
                {
                    Object obj2 = TransitionInflater.from(browsecategoriesfragment.getActivity());
                    Object obj1 = ((TransitionInflater) (obj2)).inflateTransition(0x10f0001);
                    obj2 = ((TransitionInflater) (obj2)).inflateTransition(0x10f0002);
                    view.setSharedElementEnterTransition(((android.transition.Transition) (obj1)));
                    view.setEnterTransition(null);
                    browsecategoriesfragment.setExitTransition(null);
                    view.setSharedElementReturnTransition(((android.transition.Transition) (obj1)));
                    view.setReturnTransition(((android.transition.Transition) (obj2)));
                    browsecategoriesfragment.setReenterTransition(null);
                    int i = BrowseCategoriesFragment.access$400(browsecategoriesfragment).findAdapterPositionByEbayCategoryId(((EbayCategory) (viewmodel)).id);
                    obj1 = BrowseCategoriesFragment.access$500(browsecategoriesfragment).findViewHolderForAdapterPosition(i);
                    if (obj1 != null && ((android.support.v7.widget.EbayCategoryId) (obj1)).EbayCategoryId != null)
                    {
                        ((FragmentTransaction) (obj)).addSharedElement(((android.support.v7.widget.EbayCategoryId) (obj1)).EbayCategoryId, ((android.support.v7.widget.EbayCategoryId) (obj1)).EbayCategoryId.getTransitionName());
                    }
                }
                viewmodel = BrowseCategoriesFragment.createFragmentTag(((EbayCategory) (viewmodel)).level);
                ((FragmentTransaction) (obj)).addToBackStack(viewmodel).replace(((ViewGroup)browsecategoriesfragment.getView().getParent()).getId(), view, viewmodel);
                ((FragmentTransaction) (obj)).commit();
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
