// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import android.content.Context;
import com.google.a.a.e;
import com.target.mothership.common.product.h;
import com.target.mothership.common.weeklyad.c;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductVariation;
import com.target.mothership.model.product.interfaces.ProductVariationDimensions;
import com.target.mothership.model.product.interfaces.ProductVariationSummary;
import com.target.mothership.model.product.interfaces.ProductVariationValues;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariation;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariationItem;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ListItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.util.af;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

// Referenced classes of package com.target.ui.helper.product:
//            b

public class ProductVariationModelHelper
{

    private static final String COLOR_DIMENSION = "color";
    private static final String GIFT_CARD_DENOMINATIONS = "GIFTCARD_DENOMINATIONS";
    private static final String GIFT_CARD_TYPE = "GIFTCARD_DELIVERY";
    private static final String TAG = com/target/ui/helper/product/ProductVariationModelHelper.getSimpleName();
    private LinkedHashMap mAvailability;
    private Context mContext;
    private List mGridEntryList;
    private List mListEntryList;
    private String mListTitle;
    private com.target.ui.model.product.ProductVariationModel.a mVariationType;

    public ProductVariationModelHelper(Context context)
    {
        mVariationType = com.target.ui.model.product.ProductVariationModel.a.NONE;
        mListEntryList = new ArrayList();
        mGridEntryList = new ArrayList();
        mAvailability = new LinkedHashMap();
        mListTitle = "";
        mContext = context;
    }

    public static ProductDetails a(ProductDetails productdetails, ProductVariationModel productvariationmodel, b b1)
    {
        ListItem listitem = productvariationmodel.f();
        GridItem griditem = productvariationmodel.g();
        if (listitem == null && griditem == null)
        {
            return null;
        } else
        {
            return a(productdetails, productvariationmodel, b1, listitem, griditem);
        }
    }

    public static ProductDetails a(ProductDetails productdetails, ProductVariationModel productvariationmodel, b b1, ListItem listitem, GridItem griditem)
    {
        if (productdetails == null || productvariationmodel == null)
        {
            throw new IllegalArgumentException("ProductDetails or ProductVariationModel cannot be null");
        }
        String s = a(productvariationmodel.a(), listitem, griditem);
        productvariationmodel = b(productvariationmodel.a(), listitem, griditem);
        if (s == null && productvariationmodel == null)
        {
            return null;
        }
        if (productdetails.B())
        {
            return a(b1, a(productdetails, s));
        } else
        {
            return a(productdetails, s, ((String) (productvariationmodel)));
        }
    }

    public static ProductDetails a(ProductDetails productdetails, String s, String s1)
    {
        if (productdetails != null)
        {
            if ((productdetails = productdetails.a(s, s1)).b())
            {
                return (ProductDetails)productdetails.c();
            }
        }
        return null;
    }

    public static ProductDetails a(b b1, List list)
    {
        list = list.iterator();
_L4:
        if (!list.hasNext()) goto _L2; else goto _L1
_L1:
        ProductDetails productdetails;
        Iterator iterator;
        productdetails = (ProductDetails)list.next();
        iterator = productdetails.A().iterator();
_L5:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        h h1 = (h)iterator.next();
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$helper$product$AddToCartItemType[];
            static final int $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[];

            static 
            {
                $SwitchMap$com$target$ui$helper$product$AddToCartItemType = new int[com.target.ui.helper.product.b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SMS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.EMAIL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.SHIP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$helper$product$AddToCartItemType[b.MAIL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType = new int[com.target.ui.model.product.ProductVariationModel.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_GRID.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$model$product$ProductVariationModel$VariationType[com.target.ui.model.product.ProductVariationModel.a.TWO_DIMENSION.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.helper.product.AddToCartItemType[b1.ordinal()];
        JVM INSTR tableswitch 1 4: default 96
    //                   1 99
    //                   2 112
    //                   3 125
    //                   4 125;
           goto _L5 _L6 _L7 _L8 _L8
_L8:
        continue; /* Loop/switch isn't completed */
_L6:
        if (!h1.equals(h.MOBILE)) goto _L5; else goto _L9
_L9:
        return productdetails;
_L7:
        if (!h1.equals(h.EMAIL)) goto _L5; else goto _L10
_L10:
        return productdetails;
        if (!h1.equals(h.MAIL)) goto _L5; else goto _L11
_L11:
        return productdetails;
_L2:
        return null;
    }

    public static WeeklyAdListingVariationItem a(WeeklyAdListingDetail weeklyadlistingdetail, ProductDetails productdetails)
    {
        if (weeklyadlistingdetail == null || !weeklyadlistingdetail.j().b() || productdetails == null || !productdetails.v().b())
        {
            return null;
        }
        String s = ((ProductVariationValues)productdetails.v().c()).a();
        productdetails = ((ProductVariationValues)productdetails.v().c()).b();
        if (s == null)
        {
            return null;
        }
        weeklyadlistingdetail = (WeeklyAdListingVariation)weeklyadlistingdetail.j().c();
        Object obj = weeklyadlistingdetail.a();
        if (obj == c.NONE)
        {
            return null;
        }
        if (productdetails != null && obj != c.SIZES_AND_COLORS)
        {
            return null;
        }
        if (obj == c.COLORS)
        {
            return weeklyadlistingdetail.a(s);
        }
        if (obj == c.SIZES)
        {
            return weeklyadlistingdetail.b(s);
        }
        obj = weeklyadlistingdetail.a(s, productdetails);
        if (obj == null)
        {
            return weeklyadlistingdetail.a(productdetails, s);
        } else
        {
            return ((WeeklyAdListingVariationItem) (obj));
        }
    }

    private ProductVariationModel a(String s, com.target.ui.model.product.ProductVariationModel.a a1, List list, List list1, LinkedHashMap linkedhashmap)
    {
        ProductVariationModel productvariationmodel = new ProductVariationModel();
        productvariationmodel.a(s);
        productvariationmodel.a(a1);
        productvariationmodel.a(list);
        productvariationmodel.b(list1);
        productvariationmodel.a(linkedhashmap);
        return productvariationmodel;
    }

    public static String a(com.target.ui.model.product.ProductVariationModel.a a1, ListItem listitem, GridItem griditem)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        _cls1..SwitchMap.com.target.ui.model.product.ProductVariationModel.VariationType[a1.ordinal()];
        JVM INSTR tableswitch 1 3: default 40
    //                   1 42
    //                   2 51
    //                   3 60;
           goto _L3 _L4 _L5 _L6
_L6:
        continue; /* Loop/switch isn't completed */
_L3:
        return null;
_L4:
        if (listitem == null) goto _L1; else goto _L7
_L7:
        return listitem.a();
_L5:
        if (griditem == null) goto _L1; else goto _L8
_L8:
        return griditem.a();
        if (listitem == null || griditem == null) goto _L1; else goto _L9
_L9:
        return griditem.a();
    }

    public static URL a(GridItem griditem)
    {
        if (griditem == null)
        {
            return null;
        } else
        {
            return griditem.c();
        }
    }

    public static List a(ProductDetails productdetails, String s)
    {
        ArrayList arraylist = new ArrayList();
        for (productdetails = productdetails.b(null, s).iterator(); productdetails.hasNext(); arraylist.add((ProductVariation)productdetails.next())) { }
        return arraylist;
    }

    public static String b(com.target.ui.model.product.ProductVariationModel.a a1, ListItem listitem, GridItem griditem)
    {
        if (a1 != null)
        {
            switch (_cls1..SwitchMap.com.target.ui.model.product.ProductVariationModel.VariationType[a1.ordinal()])
            {
            default:
                return null;

            case 3: // '\003'
                break;
            }
            if (listitem != null && griditem != null)
            {
                return listitem.a();
            }
        }
        return null;
    }

    private void b(ProductDetails productdetails)
    {
        if (productdetails != null && productdetails.H() && productdetails.D().b() && productdetails.J().b())
        {
            List list = ((ProductVariationSummary)productdetails.J().c()).b();
            List list1 = ((ProductVariationSummary)productdetails.J().c()).c();
            if (!list.isEmpty() && !list1.isEmpty())
            {
                d(productdetails);
                return;
            }
            if (!list.isEmpty() && list1.isEmpty())
            {
                c(productdetails);
                return;
            }
        }
    }

    private void c(ProductDetails productdetails)
    {
        if (((ProductVariationDimensions)productdetails.D().c()).a().equalsIgnoreCase("color"))
        {
            mVariationType = com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_GRID;
            f(productdetails);
        } else
        {
            mVariationType = com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_LIST;
            g(productdetails);
        }
        i(productdetails);
    }

    private void d(ProductDetails productdetails)
    {
        String s = ((ProductVariationDimensions)productdetails.D().c()).a();
        String s1 = ((ProductVariationDimensions)productdetails.D().c()).b();
        if (s != null && s.equalsIgnoreCase("GIFTCARD_DELIVERY") || s1 != null && s1.equalsIgnoreCase("GIFTCARD_DELIVERY"))
        {
            mVariationType = com.target.ui.model.product.ProductVariationModel.a.SINGLE_DIMENSION_LIST;
            e(productdetails);
            j(productdetails);
            return;
        } else
        {
            mVariationType = com.target.ui.model.product.ProductVariationModel.a.TWO_DIMENSION;
            g(productdetails);
            f(productdetails);
            h(productdetails);
            return;
        }
    }

    private void e(ProductDetails productdetails)
    {
        String s = ((ProductVariationDimensions)productdetails.D().c()).a();
        String s1 = ((ProductVariationDimensions)productdetails.D().c()).b();
        Object obj;
        if (s1 != null && s1.equals("GIFTCARD_DENOMINATIONS"))
        {
            obj = ((ProductVariationSummary)productdetails.J().c()).c();
        } else
        if (s != null && s.equals("GIFTCARD_DENOMINATIONS"))
        {
            obj = ((ProductVariationSummary)productdetails.J().c()).b();
        } else
        {
            obj = null;
        }
        if (s1 != null && s1.equals("GIFTCARD_DELIVERY"))
        {
            productdetails = ((ProductVariationSummary)productdetails.J().c()).c();
        } else
        if (s != null && s.equals("GIFTCARD_DELIVERY"))
        {
            productdetails = ((ProductVariationSummary)productdetails.J().c()).b();
        } else
        {
            productdetails = null;
        }
        for (obj = af.a(((List) (obj))).iterator(); ((Iterator) (obj)).hasNext(); mListEntryList.add(new ListItem(s, s)))
        {
            s = af.a((String)((Iterator) (obj)).next());
        }

        for (productdetails = productdetails.iterator(); productdetails.hasNext(); mGridEntryList.add(new GridItem(((String) (obj)), ((String) (obj)), null)))
        {
            obj = (String)productdetails.next();
        }

    }

    private void f(ProductDetails productdetails)
    {
        String s1 = ((ProductVariationDimensions)productdetails.D().c()).a();
        String s = ((ProductVariationDimensions)productdetails.D().c()).b();
        Object obj = ((ProductVariationSummary)productdetails.J().c()).b();
        Object obj1 = ((ProductVariationSummary)productdetails.J().c()).c();
        Object obj2 = Collections.emptyList();
        int k;
        if (s1 == null || !s1.equalsIgnoreCase("color"))
        {
            obj = obj2;
            if (s != null)
            {
                obj = obj2;
                if (s.equalsIgnoreCase("color"))
                {
                    obj = obj1;
                }
            }
        }
        obj1 = Collections.emptyList();
        if (productdetails.J().b())
        {
            productdetails = ((ProductVariationSummary)productdetails.J().c()).a();
        } else
        {
            productdetails = ((ProductDetails) (obj1));
        }
        for (k = 0; k < ((List) (obj)).size(); k++)
        {
            obj1 = null;
            obj2 = (String)((List) (obj)).get(k);
            if (k < productdetails.size())
            {
                obj1 = (URL)productdetails.get(k);
            }
            mGridEntryList.add(new GridItem(((String) (obj2)), ((String) (obj2)), ((URL) (obj1))));
        }

    }

    private void g(ProductDetails productdetails)
    {
        String s = ((ProductVariationDimensions)productdetails.D().c()).a();
        String s1 = ((ProductVariationDimensions)productdetails.D().c()).b();
        Object obj = ((ProductVariationSummary)productdetails.J().c()).b();
        productdetails = ((ProductVariationSummary)productdetails.J().c()).c();
        List list = Collections.emptyList();
        if (s != null && !s.equalsIgnoreCase("color"))
        {
            mListTitle = s;
            productdetails = ((ProductDetails) (obj));
        } else
        if (s1 != null && !s1.equalsIgnoreCase("color"))
        {
            mListTitle = s1;
        } else
        {
            productdetails = list;
        }
        for (productdetails = productdetails.iterator(); productdetails.hasNext(); mListEntryList.add(new ListItem(((String) (obj)), ((String) (obj)))))
        {
            obj = af.a((String)productdetails.next());
        }

    }

    private void h(ProductDetails productdetails)
    {
        for (Iterator iterator = mListEntryList.iterator(); iterator.hasNext();)
        {
            ListItem listitem = (ListItem)iterator.next();
            Iterator iterator1 = mGridEntryList.iterator();
            while (iterator1.hasNext()) 
            {
                GridItem griditem = (GridItem)iterator1.next();
                e e1 = productdetails.a(griditem.a(), listitem.a());
                mAvailability.put(new android.support.v4.f.h(listitem, griditem), new Boolean(e1.b()));
            }
        }

    }

    private void i(ProductDetails productdetails)
    {
        if (mListEntryList != null && !mListEntryList.isEmpty())
        {
            ListItem listitem;
            e e1;
            for (Iterator iterator = mListEntryList.iterator(); iterator.hasNext(); mAvailability.put(new android.support.v4.f.h(listitem, null), new Boolean(e1.b())))
            {
                listitem = (ListItem)iterator.next();
                e1 = productdetails.a(listitem.a(), null);
            }

        } else
        if (mGridEntryList != null && !mGridEntryList.isEmpty())
        {
            GridItem griditem;
            e e2;
            for (Iterator iterator1 = mGridEntryList.iterator(); iterator1.hasNext(); mAvailability.put(new android.support.v4.f.h(null, griditem), new Boolean(e2.b())))
            {
                griditem = (GridItem)iterator1.next();
                e2 = productdetails.a(griditem.a(), null);
            }

        }
    }

    private void j(ProductDetails productdetails)
    {
        for (Iterator iterator = mListEntryList.iterator(); iterator.hasNext();)
        {
            ListItem listitem = (ListItem)iterator.next();
            Iterator iterator1 = mGridEntryList.iterator();
            while (iterator1.hasNext()) 
            {
                GridItem griditem = (GridItem)iterator1.next();
                e e1 = productdetails.a(griditem.a(), listitem.a());
                mAvailability.put(new android.support.v4.f.h(listitem, griditem), new Boolean(e1.b()));
            }
        }

        if (mContext == null)
        {
            return;
        } else
        {
            mListTitle = mContext.getString(0x7f09048f);
            return;
        }
    }

    public ProductVariationModel a(ProductDetails productdetails)
    {
        mListTitle = "";
        mVariationType = com.target.ui.model.product.ProductVariationModel.a.NONE;
        mListEntryList.clear();
        mGridEntryList.clear();
        mAvailability.clear();
        b(productdetails);
        return a(mListTitle, mVariationType, mListEntryList, mGridEntryList, mAvailability);
    }

}
