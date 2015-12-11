// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.item;

import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.Dimension;
import com.amazon.rio.j2me.client.services.mShop.VariationProductInfo;
import com.amazon.rio.j2me.client.services.mShop.VisualBucket;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.item:
//            ProductController

public class Variations
{
    private static interface AttributeFetcher
    {

        public abstract List getAttributes(int i);
    }

    public class Child
    {

        public final int index;
        final Variations this$0;

        private void getAttributes(AttributeFetcher attributefetcher, Object aobj[])
        {
            List list = getSelectionCriteria();
            for (int i = 0; i < dimensions.length; i++)
            {
                List list1 = attributefetcher.getAttributes(i);
                if (list1 == null || list1.isEmpty())
                {
                    continue;
                }
                int j = ((Integer)list.get(i)).intValue();
                if (-1 < j)
                {
                    aobj[i] = list1.get(j);
                }
            }

        }

        private List getSelectionCriteria()
        {
            return getVariationProductInfo().getVariationAttributes();
        }

        public String getAsin()
        {
            return getVariationProductInfo().getAsin();
        }

        public String[] getAttributeNames()
        {
            String as[] = new String[dimensions.length];
            getAttributes(valueFetcher, as);
            return as;
        }

        public BasicOfferListing getBasicOffer()
        {
            return getVariationProductInfo().getBasicOffer();
        }

        public byte[] getImage()
        {
            VisualBucket visualbucket;
            List list = getSelectionCriteria();
            visualbucket = bestBucketMatchingCriteria(list);
            if (visualbucket == null) goto _L2; else goto _L1
_L1:
            Object obj = visualbucket.getBestImage();
            if (Util.isEmpty(((byte []) (obj)))) goto _L4; else goto _L3
_L3:
            return ((byte []) (obj));
_L4:
            byte abyte0[];
            obj = visualbucket.getSameAsBucket();
            obj = bestBucketMatchingCriteria(((List) (obj)));
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            abyte0 = ((VisualBucket) (obj)).getBestImage();
            obj = abyte0;
            if (!Util.isEmpty(abyte0)) goto _L3; else goto _L2
_L2:
            return null;
        }

        public String getImageUrl()
        {
            Object obj1;
            List list = getSelectionCriteria();
            obj1 = bestBucketMatchingCriteria(list);
            if (obj1 == null) goto _L2; else goto _L1
_L1:
            Object obj = ((VisualBucket) (obj1)).getBestImageUrl();
            if (Util.isEmpty(((String) (obj)))) goto _L4; else goto _L3
_L3:
            return ((String) (obj));
_L4:
            obj = ((VisualBucket) (obj1)).getSameAsBucket();
            obj = bestBucketMatchingCriteria(((List) (obj)));
            if (obj == null)
            {
                break; /* Loop/switch isn't completed */
            }
            obj1 = ((VisualBucket) (obj)).getBestImageUrl();
            obj = obj1;
            if (!Util.isEmpty(((String) (obj1)))) goto _L3; else goto _L2
_L2:
            String s;
            if (productController != null)
            {
                s = productController.getImageUrl();
            } else
            {
                s = null;
            }
            return s;
        }

        public VariationProductInfo getVariationProductInfo()
        {
            return variationProductInfos[index];
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer();
            Util.join(getAttributeNames(), stringbuffer, " - ");
            Object obj = getBasicOffer();
            if (obj != null && !((BasicOfferListing) (obj)).getPriceViolatesMap())
            {
                obj = ((BasicOfferListing) (obj)).getPrice();
                if (!Util.isEmpty(((String) (obj))))
                {
                    stringbuffer.append(": ");
                    stringbuffer.append(((String) (obj)));
                }
            }
            return stringbuffer.toString();
        }

        private Child(int i)
        {
            this$0 = Variations.this;
            super();
            index = i;
        }

    }


    private Child children[];
    private final Dimension dimensions[];
    private final String mAvailableMessages[];
    private final String mPrices[];
    private final ProductController productController;
    private final AttributeFetcher swatchFetcher = new AttributeFetcher() {

        final Variations this$0;

        public List getAttributes(int i)
        {
            return dimensions[i].getSwatches();
        }

            
            {
                this$0 = Variations.this;
                super();
            }
    };
    private final AttributeFetcher valueFetcher = new AttributeFetcher() {

        final Variations this$0;

        public List getAttributes(int i)
        {
            return dimensions[i].getValues();
        }

            
            {
                this$0 = Variations.this;
                super();
            }
    };
    private final VariationProductInfo variationProductInfos[];
    private VisualBucket visualBuckets[];

    public Variations(ProductController productcontroller, Dimension adimension[], VariationProductInfo avariationproductinfo[], VisualBucket avisualbucket[])
    {
        productController = productcontroller;
        dimensions = adimension;
        variationProductInfos = avariationproductinfo;
        visualBuckets = avisualbucket;
        if (Util.isEmpty(avariationproductinfo))
        {
            mPrices = null;
            mAvailableMessages = null;
            return;
        } else
        {
            mPrices = new String[avariationproductinfo.length];
            mAvailableMessages = new String[avariationproductinfo.length];
            return;
        }
    }

    private VisualBucket bestBucketMatchingCriteria(List list)
    {
        VisualBucket visualbucket = null;
        int j = 0;
        for (int i = 0; i < visualBuckets.length;)
        {
            VisualBucket visualbucket1 = visualBuckets[i];
            int l = compareSelectionCriterias(list, visualbucket1.getAttributes());
            if (l == list.size())
            {
                return visualbucket1;
            }
            int k = j;
            if (j < l)
            {
                visualbucket = visualbucket1;
                k = l;
            }
            i++;
            j = k;
        }

        return visualbucket;
    }

    private int compareSelectionCriterias(List list, List list1)
    {
        int j = 0;
        if (list == null || list1 == null)
        {
            return 0;
        }
        if (list1.size() != list.size())
        {
            return 0;
        }
        for (int i = 0; i < list.size();)
        {
            Object obj = list.get(i);
            int k = j;
            if (obj != null)
            {
                k = j;
                if (obj.equals(list1.get(i)))
                {
                    k = j + 1;
                }
            }
            i++;
            j = k;
        }

        return j;
    }

    private int getVariationProductInfoIndex(String s)
    {
        if (!Util.isEmpty(variationProductInfos) && !Util.isEmpty(s)) goto _L2; else goto _L1
_L1:
        int j = -1;
_L6:
        return j;
_L2:
        int i = 0;
_L7:
        if (i >= variationProductInfos.length) goto _L4; else goto _L3
_L3:
        VariationProductInfo variationproductinfo;
        variationproductinfo = variationProductInfos[i];
        if (variationproductinfo == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        if (s.equals(variationproductinfo.getAsin())) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return -1;
    }

    private int getVariationProductInfoIndex(List list)
    {
        if (!Util.isEmpty(variationProductInfos) && !Util.isEmpty(list)) goto _L2; else goto _L1
_L1:
        int j = -1;
_L6:
        return j;
_L2:
        int i = 0;
_L7:
        if (i >= variationProductInfos.length) goto _L4; else goto _L3
_L3:
        VariationProductInfo variationproductinfo;
        variationproductinfo = variationProductInfos[i];
        if (variationproductinfo == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = i;
        if (list.equals(variationproductinfo.getVariationAttributes())) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return -1;
    }

    public String getAvailableMessage(List list)
    {
        Object obj = null;
        int i = getVariationProductInfoIndex(list);
        list = obj;
        if (i >= 0)
        {
            list = mAvailableMessages[i];
        }
        return list;
    }

    public Child getChildWithAsin(String s)
    {
        if (!Util.isEmpty(s))
        {
            Child achild[] = getChildren();
            for (int i = 0; i < achild.length; i++)
            {
                if (s.equals(achild[i].getAsin()))
                {
                    return achild[i];
                }
            }

        }
        return null;
    }

    public Child[] getChildren()
    {
        if (children == null)
        {
            children = new Child[variationProductInfos.length];
            for (int i = 0; i < variationProductInfos.length; i++)
            {
                children[i] = new Child(i);
            }

        }
        return children;
    }

    public String[] getDimensionLabels()
    {
        String as[] = new String[dimensions.length];
        for (int i = 0; i < dimensions.length; i++)
        {
            as[i] = dimensions[i].getDisplayLabel();
        }

        return as;
    }

    public Dimension[] getDimensions()
    {
        return dimensions;
    }

    public String getPrice(List list)
    {
        Object obj = null;
        int i = getVariationProductInfoIndex(list);
        list = obj;
        if (i >= 0)
        {
            list = mPrices[i];
        }
        return list;
    }

    public VariationProductInfo[] getVariationProductInfos()
    {
        return variationProductInfos;
    }

    public void setAvailableMessage(String s, String s1)
    {
        int i = getVariationProductInfoIndex(s);
        if (mAvailableMessages != null && i >= 0 && i < mAvailableMessages.length)
        {
            mAvailableMessages[i] = s1;
        }
    }

    public void setPrice(String s, String s1)
    {
        int i = getVariationProductInfoIndex(s);
        if (mPrices != null && i >= 0 && i < mPrices.length)
        {
            mPrices[i] = s1;
        }
    }





}
