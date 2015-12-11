// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.model.product.CompositeProduct;
import com.target.ui.model.product.TGTCompositeProduct;
import com.target.ui.model.product.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class l
{

    public static final int CATEGORY_LIST = 1;
    private static final int CATEGORY_LIST_DVM_REQUEST = 2;
    public static final int CUSTOM_LIST = 2;
    private static final int CUSTOM_LIST_DVM_REQUEST = 0;
    public static final int DEFAULT = 3;
    private static final int DEFAULT_LIST_DVM_REQUEST = 1;
    public static final Integer INVALID_DVM_POSITION = Integer.valueOf(-1);
    private static final Integer PLP_DVM_PLACEMENTS_GRID[] = {
        Integer.valueOf(6), Integer.valueOf(33)
    };
    private static final Integer PLP_DVM_PLACEMENTS_LIST[] = {
        Integer.valueOf(2), Integer.valueOf(11)
    };
    private static final Integer SLP_DVM_PLACEMENTS_GRID[] = {
        Integer.valueOf(12)
    };
    private static final Integer SLP_DVM_PLACEMENTS_LIST[] = {
        Integer.valueOf(4)
    };
    private static final String TAG = com/target/ui/util/l.getSimpleName();

    public l()
    {
    }

    public static int a(int i)
    {
        switch (i)
        {
        default:
            return 1;

        case 2: // '\002'
            return 0;

        case 1: // '\001'
            return 2;
        }
    }

    public static int a(int i, boolean flag, int j)
    {
        Integer ainteger[] = a(i, flag);
        if (j >= ainteger.length)
        {
            return INVALID_DVM_POSITION.intValue();
        } else
        {
            return ainteger[j].intValue();
        }
    }

    private static DvmDataResponse a(List list, int i, int j, boolean flag)
    {
        if (j == 1 && i == a(j, flag, 1) && list.size() > 1)
        {
            return (DvmDataResponse)list.get(1);
        } else
        {
            return (DvmDataResponse)list.get(0);
        }
    }

    public static CompositeProduct a(DvmDataResponse dvmdataresponse)
    {
        TGTCompositeProduct tgtcompositeproduct = new TGTCompositeProduct();
        tgtcompositeproduct.a(a.DVM);
        tgtcompositeproduct.a(dvmdataresponse);
        tgtcompositeproduct.a(null);
        return tgtcompositeproduct;
    }

    private static CompositeProduct a(ProductDetails productdetails)
    {
        TGTCompositeProduct tgtcompositeproduct = new TGTCompositeProduct();
        tgtcompositeproduct.a(a.DEFAULT);
        tgtcompositeproduct.a(productdetails);
        tgtcompositeproduct.a(null);
        return tgtcompositeproduct;
    }

    public static void a(List list, List list1)
    {
        TGTCompositeProduct tgtcompositeproduct;
        for (list1 = list1.iterator(); list1.hasNext(); list.add(tgtcompositeproduct))
        {
            ProductDetails productdetails = (ProductDetails)list1.next();
            tgtcompositeproduct = new TGTCompositeProduct();
            tgtcompositeproduct.a(a.DEFAULT);
            tgtcompositeproduct.a(productdetails);
            tgtcompositeproduct.a(null);
        }

    }

    public static void a(List list, List list1, List list2, int i, boolean flag)
    {
        List list3 = Arrays.asList(a(i, flag));
        list1 = list1.iterator();
        for (int j = 0; list1.hasNext(); j++)
        {
            ProductDetails productdetails = (ProductDetails)list1.next();
            if (!list2.isEmpty() && list3.contains(Integer.valueOf(j)))
            {
                list.add(a(a(list2, j, i, flag)));
            }
            list.add(a(productdetails));
        }

    }

    private static Integer[] a(int i, boolean flag)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            if (flag)
            {
                return PLP_DVM_PLACEMENTS_GRID;
            } else
            {
                return PLP_DVM_PLACEMENTS_LIST;
            }

        case 2: // '\002'
            return new Integer[0];

        case 3: // '\003'
            break;
        }
        if (flag)
        {
            return SLP_DVM_PLACEMENTS_GRID;
        } else
        {
            return SLP_DVM_PLACEMENTS_LIST;
        }
    }

}
