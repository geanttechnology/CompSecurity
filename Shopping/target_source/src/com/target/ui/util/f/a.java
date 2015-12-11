// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.f;

import com.google.a.a.e;
import com.pointinside.maps.Location;
import com.pointinside.products.Ancestor;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.c;
import com.target.mothership.common.product.d;
import com.target.mothership.common.store.InStoreLocation;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductEntry;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.ui.model.refine.ProductRefineModel;
import com.target.ui.model.refine.ProductSortModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a
{

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final String PI_ANCESTOR_AISLE = "Aisle";
    private static final String PI_ANCESTOR_DEPARTMENT = "Department";

    public static ProductSummaryParam a(ProductSummaryParam productsummaryparam, ProductRefineModel productrefinemodel, List list)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ProductEntry productentry = (ProductEntry)list.next();
            if (productentry.b().b())
            {
                arraylist.add(productentry.b().c());
            }
        } while (true);
        productsummaryparam.a(arraylist);
        productsummaryparam.c(Integer.valueOf(0));
        productrefinemodel = (com.target.ui.model.refine.ProductSortModel.SortLabel)productrefinemodel.b().c().d();
        if (productrefinemodel != null)
        {
            productrefinemodel = productrefinemodel.a();
        } else
        {
            productrefinemodel = null;
        }
        productsummaryparam.a(productrefinemodel);
        return productsummaryparam;
    }

    public static InStoreLocation a(List list)
    {
        if (list.isEmpty())
        {
            return null;
        }
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        Object obj = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            InStoreLocation instorelocation = (InStoreLocation)iterator.next();
            if (instorelocation.b().b())
            {
                a1.put(instorelocation.b().c(), instorelocation);
                ((List) (obj)).add(instorelocation.b().c());
            }
        } while (true);
        obj = c(((List) (obj)));
        if (obj == null)
        {
            return (InStoreLocation)list.get(0);
        } else
        {
            return (InStoreLocation)a1.get(obj);
        }
    }

    public static com.target.ui.util.f.a.a a(ProductDetails productdetails)
    {
        Object obj = com.target.ui.util.f.a.a.FOUND_NONE;
        if (productdetails.i().equals(c.ONLINE_ONLY))
        {
            return new com.target.ui.util.f.a.a(null, null, ((com.target.ui.util.f.a.a) (obj)));
        }
        if (productdetails.u().a())
        {
            productdetails = a(productdetails.u().b());
            if (productdetails == null)
            {
                return new com.target.ui.util.f.a.a(null, d.UNKNOWN, com.target.ui.util.f.a.a.FOUND_UNKNOWN_DEPARTMENT);
            }
            if (productdetails.b().b())
            {
                return new com.target.ui.util.f.a.a((String)productdetails.b().c(), null, com.target.ui.util.f.a.a.FOUND_AISLE);
            }
            obj = productdetails.a();
            if (((d) (obj)).equals(d.UNKNOWN))
            {
                productdetails = com.target.ui.util.f.a.a.FOUND_UNKNOWN_DEPARTMENT;
            } else
            {
                productdetails = com.target.ui.util.f.a.a.FOUND_KNOWN_DEPARTMENT;
            }
        } else
        {
            Object obj1 = null;
            productdetails = ((ProductDetails) (obj));
            obj = obj1;
        }
        return new com.target.ui.util.f.a.a(null, ((d) (obj)), productdetails);
    }

    public static com.target.ui.view.DepartmentBadgeView.a a(d d1)
    {
        com.target.ui.view.DepartmentBadgeView.a a1 = com.target.ui.view.DepartmentBadgeView.a.UNKNOWN;
        if (d1 == null)
        {
            return a1;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$product$Department[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$Department = new int[d.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.APPAREL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.BABY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.ELECTRONICS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.FURNITURE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GARAGE_HARDWARE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GIFTS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.GROCERY.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.HEALTH_BEAUTY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.HOME.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.JEWELRY.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.KITCHEN.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.LAUNDRY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.LAUNDRY_CLEANING_CLOSET.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.PATIO_OUTDOOR_DECOR.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.SPORTING_GOODS.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.STATIONERY_OFFICE_SUPPLIES.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.TOYS.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.SERVICES.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$Department[d.UNKNOWN.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.Department[d1.ordinal()])
        {
        default:
            return a1;

        case 1: // '\001'
            return com.target.ui.view.DepartmentBadgeView.a.APPAREL;

        case 2: // '\002'
            return com.target.ui.view.DepartmentBadgeView.a.BABY;

        case 3: // '\003'
            return com.target.ui.view.DepartmentBadgeView.a.ELECTRONICS;

        case 4: // '\004'
            return com.target.ui.view.DepartmentBadgeView.a.FURNISHINGS;

        case 5: // '\005'
            return com.target.ui.view.DepartmentBadgeView.a.AUTO;

        case 6: // '\006'
            return com.target.ui.view.DepartmentBadgeView.a.GIFT_FINDER;

        case 7: // '\007'
            return com.target.ui.view.DepartmentBadgeView.a.GROCERY;

        case 8: // '\b'
            return com.target.ui.view.DepartmentBadgeView.a.BEAUTY;

        case 9: // '\t'
            return com.target.ui.view.DepartmentBadgeView.a.HOME;

        case 10: // '\n'
            return com.target.ui.view.DepartmentBadgeView.a.JEWELRY;

        case 11: // '\013'
            return com.target.ui.view.DepartmentBadgeView.a.KITCHEN;

        case 12: // '\f'
            return com.target.ui.view.DepartmentBadgeView.a.HOUSEHOLD;

        case 13: // '\r'
            return com.target.ui.view.DepartmentBadgeView.a.CLEANING_CLOSET;

        case 14: // '\016'
            return com.target.ui.view.DepartmentBadgeView.a.PATIO_OUTDOOR;

        case 15: // '\017'
            return com.target.ui.view.DepartmentBadgeView.a.SPORTING_GOODS;

        case 16: // '\020'
            return com.target.ui.view.DepartmentBadgeView.a.SCHOOL_AND_OFFICE;

        case 17: // '\021'
            return com.target.ui.view.DepartmentBadgeView.a.TOYS_AND_GAMES;

        case 18: // '\022'
        case 19: // '\023'
            return com.target.ui.view.DepartmentBadgeView.a.UNKNOWN;
        }
    }

    public static String a(Location location)
    {
        if (location == null || location.ancestry == null)
        {
            return null;
        }
        for (location = location.ancestry.iterator(); location.hasNext();)
        {
            Ancestor ancestor = (Ancestor)location.next();
            if ("Department".equals(ancestor.name))
            {
                return ancestor.title;
            }
        }

        return null;
    }

    public static e b(Location location)
    {
        if (location == null || location.ancestry == null)
        {
            return e.e();
        }
        location = location.ancestry.iterator();
_L4:
        if (!location.hasNext()) goto _L2; else goto _L1
_L1:
        Ancestor ancestor = (Ancestor)location.next();
        if (!"Aisle".equals(ancestor.name)) goto _L4; else goto _L3
_L3:
        location = ancestor.title;
_L6:
        if (location == null || "N/A".equals(location) || "0".equals(location))
        {
            return e.e();
        } else
        {
            return e.b(location);
        }
_L2:
        location = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Location b(List list)
    {
        if (list.isEmpty())
        {
            return null;
        }
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        Object obj = new ArrayList();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Location location = (Location)iterator.next();
            e e1 = b(location);
            if (e1.b())
            {
                a1.put(e1.c(), location);
                ((List) (obj)).add(e1.c());
            }
        } while (true);
        obj = c(((List) (obj)));
        if (obj == null)
        {
            return (Location)list.get(0);
        } else
        {
            return (Location)a1.get(obj);
        }
    }

    public static com.target.ui.view.DepartmentBadgeView.a c(Location location)
    {
        return a(d.a(a(location)));
    }

    private static String c(List list)
    {
        if (list.isEmpty())
        {
            return null;
        } else
        {
            Collections.sort(list);
            return (String)list.get(0);
        }
    }
}
