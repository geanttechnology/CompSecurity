// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import com.amazon.mShop.control.home.BasicProductsController;
import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.mShop.control.item.Variations;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.Dimension;
import com.amazon.rio.j2me.client.services.mShop.HyperText;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.VariationProductInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VariationsController
    implements BasicProductsSubscriber
{
    private class DimensionNode
    {

        private DimensionNode mChildren[];
        private int mDimension;
        private int mOption;

        public DimensionNode getChildAt(int i)
        {
            return mChildren[i];
        }

        public int getDimension()
        {
            return mDimension;
        }

        public int getNumChildren()
        {
            return mChildren.length;
        }

        public int getOption()
        {
            return mOption;
        }
    }


    final BasicProductsController mBasicProductController;
    private int mBeginIndexForFetch;
    private Map mChildIndexMap;
    private boolean mFetchComplete;
    private String mRequestId;
    private DimensionNode mRoot;
    private int mSelectedOptions[];
    private final Variations mVariations;

    private boolean continueToFetchInfosIfNeeded()
    {
        VariationProductInfo avariationproductinfo[];
        if (isIndexForFetchValid())
        {
            if (!Util.isEmpty(avariationproductinfo = mVariations.getVariationProductInfos()))
            {
                int j = getBeginIndexForFetch();
                int i = j + 127;
                ArrayList arraylist;
                if (i + 1 > avariationproductinfo.length)
                {
                    setBeginIndexForFetch(-1);
                    i = avariationproductinfo.length - 1;
                } else
                {
                    setBeginIndexForFetch(i + 1);
                }
                arraylist = new ArrayList();
                for (; j <= i; j++)
                {
                    arraylist.add(avariationproductinfo[j].getAsin());
                }

                mBasicProductController.requestBasicProducts(arraylist, mRequestId);
                return true;
            }
        }
        return false;
    }

    private List getAttrForCurrentSelectionAndSpecDimen(int i, int j)
    {
        ArrayList arraylist = new ArrayList(mSelectedOptions.length);
        for (int k = 0; k < mSelectedOptions.length; k++)
        {
            arraylist.add(Integer.valueOf(mSelectedOptions[k]));
        }

        arraylist.set(i, Integer.valueOf(j));
        return arraylist;
    }

    private int getBeginIndexForFetch()
    {
        return mBeginIndexForFetch;
    }

    private boolean isAvailableSubtree(DimensionNode dimensionnode)
    {
        int i = mSelectedOptions[dimensionnode.getDimension()];
        if (i != -1 && i != dimensionnode.getOption())
        {
            return false;
        }
        if (dimensionnode.getNumChildren() == 0)
        {
            return true;
        }
        boolean flag1 = false;
        i = 0;
        while (i < dimensionnode.getNumChildren()) 
        {
            boolean flag = flag1;
            if (dimensionnode.getChildAt(i) != null)
            {
                if (flag1 || isAvailableSubtree(dimensionnode.getChildAt(i)))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            }
            i++;
            flag1 = flag;
        }
        return flag1;
    }

    private boolean isFetchComplete()
    {
        return mFetchComplete;
    }

    private boolean isIndexForFetchValid()
    {
        return getBeginIndexForFetch() >= 0;
    }

    private void setBeginIndexForFetch(int i)
    {
        mBeginIndexForFetch = i;
    }

    private void setFetchComplete(boolean flag)
    {
        mFetchComplete = flag;
    }

    public void cancelFetchInfos()
    {
        mBasicProductController.cancel();
    }

    public List checkAvailabilitiesForDimension(int i)
    {
        int i1 = mVariations.getDimensions()[i].getValues().size();
        ArrayList arraylist = new ArrayList(i1);
        for (int j = 0; j < i1; j++)
        {
            arraylist.add(Boolean.FALSE);
        }

        i1 = mSelectedOptions[i];
        mSelectedOptions[i] = -1;
        Object obj = new Stack();
        for (int k = 0; k < mRoot.getNumChildren(); k++)
        {
            if (mRoot.getChildAt(k) != null)
            {
                ((Stack) (obj)).push(mRoot.getChildAt(k));
            }
        }

        ArrayList arraylist1 = new ArrayList();
label0:
        do
        {
            DimensionNode dimensionnode1;
            int l;
label1:
            do
            {
                for (; !((Stack) (obj)).empty(); arraylist1.add(dimensionnode1))
                {
                    dimensionnode1 = (DimensionNode)((Stack) (obj)).pop();
                    l = mSelectedOptions[dimensionnode1.getDimension()];
                    if (dimensionnode1.getDimension() != i)
                    {
                        continue label1;
                    }
                }

                break label0;
            } while (l != -1 && l != dimensionnode1.getOption());
            l = 0;
            while (l < dimensionnode1.getNumChildren()) 
            {
                if (dimensionnode1.getChildAt(l) != null)
                {
                    ((Stack) (obj)).push(dimensionnode1.getChildAt(l));
                }
                l++;
            }
        } while (true);
        obj = arraylist1.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            DimensionNode dimensionnode = (DimensionNode)((Iterator) (obj)).next();
            if (isAvailableSubtree(dimensionnode))
            {
                arraylist.set(dimensionnode.getOption(), Boolean.TRUE);
            }
        } while (true);
        mSelectedOptions[i] = i1;
        return arraylist;
    }

    public String getAvailabeMessage(int i, int j)
    {
        if (!isFetchComplete())
        {
            return null;
        } else
        {
            List list = getAttrForCurrentSelectionAndSpecDimen(i, j);
            return mVariations.getAvailableMessage(list);
        }
    }

    public List getCurrentSelection()
    {
        ArrayList arraylist = new ArrayList(mSelectedOptions.length);
        for (int i = 0; i < mSelectedOptions.length; i++)
        {
            arraylist.add(Integer.valueOf(mSelectedOptions[i]));
        }

        return arraylist;
    }

    public String getPrice(int i, int j)
    {
        if (!isFetchComplete())
        {
            return null;
        } else
        {
            List list = getAttrForCurrentSelectionAndSpecDimen(i, j);
            return mVariations.getPrice(list);
        }
    }

    public com.amazon.mShop.control.item.Variations.Child getSelectedChild(List list)
    {
        if (mChildIndexMap.get(list.toString()) == null)
        {
            return null;
        } else
        {
            int i = ((Integer)mChildIndexMap.get(list.toString())).intValue();
            return mVariations.getChildren()[i];
        }
    }

    public void onBasicProductsReceived(BasicProductsResponse basicproductsresponse)
    {
        boolean flag = false;
        if (basicproductsresponse != null)
        {
            basicproductsresponse = basicproductsresponse.getProducts();
            if (basicproductsresponse != null)
            {
                Iterator iterator = basicproductsresponse.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    basicproductsresponse = (SearchResult)iterator.next();
                    String s = basicproductsresponse.getBasicProduct().getAsin();
                    Object obj1 = basicproductsresponse.getBasicOffer();
                    if (!Util.isEmpty(s) && obj1 != null)
                    {
                        String s1 = ((BasicOfferListing) (obj1)).getPrice();
                        Object obj = null;
                        basicproductsresponse = obj;
                        if (!Util.isEmpty(((BasicOfferListing) (obj1)).getAvailabilityMessages()))
                        {
                            obj1 = (HyperText)((BasicOfferListing) (obj1)).getAvailabilityMessages().get(0);
                            basicproductsresponse = obj;
                            if (obj1 != null)
                            {
                                basicproductsresponse = ((HyperText) (obj1)).getText();
                            }
                        }
                        mVariations.setPrice(s, s1);
                        mVariations.setAvailableMessage(s, basicproductsresponse);
                    }
                } while (true);
            }
        }
        if (!continueToFetchInfosIfNeeded())
        {
            flag = true;
        }
        setFetchComplete(flag);
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        setBeginIndexForFetch(-1);
    }

    public List selectAndUpdate(int i, int j)
    {
        if (mSelectedOptions[i] == j)
        {
            return getCurrentSelection();
        }
        if (!((Boolean)checkAvailabilitiesForDimension(i).get(j)).booleanValue())
        {
            for (int k = 0; k < mVariations.getDimensions().length; k++)
            {
                mSelectedOptions[k] = -1;
            }

        }
        mSelectedOptions[i] = j;
        return getCurrentSelection();
    }
}
