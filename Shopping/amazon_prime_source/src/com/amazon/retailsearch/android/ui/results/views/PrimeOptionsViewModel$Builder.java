// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            PrimeOptionsViewModel

public static class gestureListener
{

    private String asin;
    private ProductGestureListener gestureListener;
    private List offerList;
    private String productGroup;

    public PrimeOptionsViewModel build()
    {
        if (gestureListener == null)
        {
            return null;
        } else
        {
            PrimeOptionsViewModel primeoptionsviewmodel = new PrimeOptionsViewModel();
            PrimeOptionsViewModel.access$000(primeoptionsviewmodel, offerList);
            PrimeOptionsViewModel.access$100(primeoptionsviewmodel, asin);
            PrimeOptionsViewModel.access$200(primeoptionsviewmodel, productGroup);
            primeoptionsviewmodel.setGestureListener(gestureListener);
            return primeoptionsviewmodel;
        }
    }

    public (List list, String s, String s1, ProductGestureListener productgesturelistener)
    {
        offerList = list;
        asin = s;
        productGroup = s1;
        gestureListener = productgesturelistener;
    }
}
