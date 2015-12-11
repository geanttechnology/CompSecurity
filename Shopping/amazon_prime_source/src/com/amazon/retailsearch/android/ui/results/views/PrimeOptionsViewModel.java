// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import com.amazon.retailsearch.android.ui.results.events.ProductGestureListener;
import java.util.List;

public class PrimeOptionsViewModel
{
    public static class Builder
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
                primeoptionsviewmodel.setOfferList(offerList);
                primeoptionsviewmodel.setAsin(asin);
                primeoptionsviewmodel.setProductGroup(productGroup);
                primeoptionsviewmodel.setGestureListener(gestureListener);
                return primeoptionsviewmodel;
            }
        }

        public Builder(List list, String s, String s1, ProductGestureListener productgesturelistener)
        {
            offerList = list;
            asin = s;
            productGroup = s1;
            gestureListener = productgesturelistener;
        }
    }


    private String asin;
    private ProductGestureListener gestureListener;
    private List offerList;
    private String productGroup;

    public PrimeOptionsViewModel()
    {
    }

    private void setAsin(String s)
    {
        asin = s;
    }

    private void setOfferList(List list)
    {
        offerList = list;
    }

    private void setProductGroup(String s)
    {
        productGroup = s;
    }

    public String getAsin()
    {
        return asin;
    }

    public ProductGestureListener getGestureListener()
    {
        return gestureListener;
    }

    public List getOfferList()
    {
        return offerList;
    }

    public String getProductGroup()
    {
        return productGroup;
    }

    public void setGestureListener(ProductGestureListener productgesturelistener)
    {
        gestureListener = productgesturelistener;
    }



}
