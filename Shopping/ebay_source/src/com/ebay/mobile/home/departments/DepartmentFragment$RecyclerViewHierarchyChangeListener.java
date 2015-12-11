// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.ebay.mobile.home.cards.DepartmentTitleViewHolder;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewHolder;
import com.ebay.mobile.home.cards.NativeAdsViewHolder;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentFragment

static class fragmentReference
    implements android.view.archyChangeListener
{

    private final WeakReference fragmentReference;

    public void onChildViewAdded(View view, View view1)
    {
        byte byte0 = 0;
        view = (DepartmentFragment)fragmentReference.get();
        Object obj;
        if (view != null && view.getView() != null)
        {
            if ((obj = (RecyclerView)view.getView().findViewById(0x7f1002e8)) != null && (view1 = ((RecyclerView) (obj)).getChildViewHolder(view1)) != null)
            {
                if (view1 instanceof DepartmentTitleViewHolder)
                {
                    obj = ((android.support.v7.widget.stener.fragmentReference) (view1)).fragmentReference;
                    if (view.hasCarousel())
                    {
                        byte0 = 4;
                    }
                    ((View) (obj)).setVisibility(byte0);
                    view.addObserver((DepartmentTitleViewHolder)view1, true);
                    return;
                }
                if (view1 instanceof NativeAdsViewHolder)
                {
                    ((NativeAdsViewHolder)view1).doInitialViewAdd(((RecyclerView) (obj)).getWidth());
                    return;
                }
                if ((view1 instanceof FeaturedCategoriesViewHolder) && DepartmentFragment.access$400(view))
                {
                    view1 = ((android.support.v7.widget.stener.fragmentReference) (view1)).fragmentReference;
                    view1.measure(0, 0);
                    view.getClass();
                    (new fragmentReference(view, view1, 0, view1.getMeasuredHeight())).fragmentReference(1.0F, null);
                    return;
                }
            }
        }
    }

    public void onChildViewRemoved(View view, View view1)
    {
        view = (DepartmentFragment)fragmentReference.get();
        RecyclerView recyclerview;
        if (view != null && view.getView() != null)
        {
            if ((recyclerview = (RecyclerView)view.getView().findViewById(0x7f1002e8)) != null && ((view1 = recyclerview.getChildViewHolder(view1)) != null && (view1 instanceof DepartmentTitleViewHolder)))
            {
                view.removeObserver((DepartmentTitleViewHolder)view1);
                return;
            }
        }
    }

    (DepartmentFragment departmentfragment)
    {
        fragmentReference = new WeakReference(departmentfragment);
    }
}
