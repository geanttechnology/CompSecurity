// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.events;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.retailsearch.android.api.display.results.item.RetailSearchResultItem;
import com.amazon.retailsearch.android.ui.results.ContentSwitcherModel;
import com.amazon.retailsearch.android.ui.results.ProductView;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.layout.ImmersiveProduct;
import com.amazon.retailsearch.android.ui.results.views.InteractiveRetailSearchResultView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.DetailPageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
{
    private static final class ViewTapLocation extends Enum
    {

        private static final ViewTapLocation $VALUES[];
        public static final ViewTapLocation IN_VIEW;
        public static final ViewTapLocation MISS;
        public static final ViewTapLocation WITHIN_PADDING;

        public static ViewTapLocation valueOf(String s)
        {
            return (ViewTapLocation)Enum.valueOf(com/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation, s);
        }

        public static ViewTapLocation[] values()
        {
            return (ViewTapLocation[])$VALUES.clone();
        }

        static 
        {
            MISS = new ViewTapLocation("MISS", 0);
            IN_VIEW = new ViewTapLocation("IN_VIEW", 1);
            WITHIN_PADDING = new ViewTapLocation("WITHIN_PADDING", 2);
            $VALUES = (new ViewTapLocation[] {
                MISS, IN_VIEW, WITHIN_PADDING
            });
        }

        private ViewTapLocation(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int MIN_TOUCH_TARGET_RADIUS = 24;
    private DisplayMetrics displayMetrics;
    private ProductView productView;
    private RetailSearchResultItem resultItem;
    private List tapTargets;
    UserInteractionListener userInteractionListener;

    public ProductGestureListener(DisplayMetrics displaymetrics)
    {
        tapTargets = new ArrayList();
        RetailSearchDaggerGraphController.inject(this);
        displayMetrics = displaymetrics;
    }

    private ViewTapLocation eventInView(MotionEvent motionevent, View view, int i)
    {
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        float f = (float)view.getWidth() / 2.0F;
        float f1 = (float)view.getHeight() / 2.0F;
        float f2 = (float)i * displayMetrics.density;
        float f3 = Math.abs(((float)ai[0] + f) - motionevent.getRawX());
        float f4 = Math.abs(((float)ai[1] + f1) - motionevent.getRawY());
        if (f3 <= f && f4 <= f1)
        {
            return ViewTapLocation.IN_VIEW;
        }
        if (f3 <= Math.max(f2, f) && f4 <= Math.max(f2, f1))
        {
            return ViewTapLocation.WITHIN_PADDING;
        } else
        {
            return ViewTapLocation.MISS;
        }
    }

    public void addTapTarget(InteractiveRetailSearchResultView interactiveretailsearchresultview)
    {
        if (interactiveretailsearchresultview != null)
        {
            tapTargets.add(interactiveretailsearchresultview);
        }
    }

    public InteractiveRetailSearchResultView getTappedTarget(MotionEvent motionevent)
    {
        InteractiveRetailSearchResultView interactiveretailsearchresultview = null;
        int i = 0;
        Iterator iterator = tapTargets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            InteractiveRetailSearchResultView interactiveretailsearchresultview1 = (InteractiveRetailSearchResultView)iterator.next();
            Object obj = interactiveretailsearchresultview1.getView();
            if (obj != null && ((View) (obj)).getVisibility() == 0)
            {
                obj = eventInView(motionevent, ((View) (obj)), 24);
                if (obj == ViewTapLocation.IN_VIEW)
                {
                    return interactiveretailsearchresultview1;
                }
                if (obj == ViewTapLocation.WITHIN_PADDING)
                {
                    if (i == 0)
                    {
                        interactiveretailsearchresultview = interactiveretailsearchresultview1;
                    }
                    i++;
                }
            }
        } while (true);
        if (interactiveretailsearchresultview != null && i == 1)
        {
            return interactiveretailsearchresultview;
        } else
        {
            return null;
        }
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        motionevent = getTappedTarget(motionevent);
        if (motionevent == null)
        {
            if (productView != null && productView.isImmersiveViewSupported() && productView.getResultLayoutType() != ResultLayoutType.ImmersiveView)
            {
                productView.switchViewTypes(new ContentSwitcherModel(5, com/amazon/retailsearch/android/ui/results/layout/ImmersiveProduct, productView.getModel()));
                productView.scrollIntoView();
                return true;
            } else
            {
                userInteractionListener.resultItemSelected(resultItem, DetailPageType.MAIN);
                return true;
            }
        } else
        {
            motionevent.handleSingleTap();
            return true;
        }
    }

    public void setProductView(ProductView productview)
    {
        productView = productview;
    }

    public void setResultItem(RetailSearchResultItem retailsearchresultitem)
    {
        resultItem = retailsearchresultitem;
    }
}
