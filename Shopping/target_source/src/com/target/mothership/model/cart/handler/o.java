// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.text.Html;
import com.target.mothership.common.a;
import com.target.mothership.common.registries.RegistryId;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.model.common.TGTStorePickUpDetails;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.ac;
import com.target.mothership.services.apigee.c.b.s;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.services.apigee.c.b.u;
import com.target.mothership.services.apigee.d.b;
import com.target.mothership.services.apigee.d.c;
import com.target.mothership.util.l;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTCartProduct, TGTLimitedQuantityDetails, TGTCartOffers, TGTCartOfferPrice, 
//            TGTCartRegistryDetails, TGTCartProductCharges, al, u

class o
    implements aa
{

    private static final String CLOSE_PARENTHESIS = ")";
    private static final String DATE_FORMAT = "EEE MM/dd";
    private static final String HYPHEN = "-";
    private static final String OPEN_PARENTHESIS = "(";
    private static final String PRE_ORDER_DATE_FORMAT = "EEEE, MMM dd, yyyy";
    private static final String TRUE = "true";
    private static final int ZERO = 0;

    o()
    {
    }

    private Date a(String s1)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE MM/dd", Locale.US);
        try
        {
            s1 = simpledateformat.parse(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
        return s1;
    }

    private Date b(String s1)
    {
        Object obj = null;
        if (com.target.mothership.util.o.g(s1))
        {
            obj = new SimpleDateFormat("EEEE, MMM dd, yyyy", Locale.US);
            try
            {
                obj = ((SimpleDateFormat) (obj)).parse(s1);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                return null;
            }
        }
        return ((Date) (obj));
    }

    public TGTCartProduct a(b b1)
    {
        Object obj3;
        Object obj4;
        TGTCartOffers tgtcartoffers;
        Object obj5;
        Object obj7;
        Object obj8;
        Object obj9;
        TGTCartProduct tgtcartproduct;
        String s1;
        String s2;
        tgtcartproduct = new TGTCartProduct();
        if (b1.s() != null)
        {
            Object obj = b1.s().iterator();
            if (((Iterator) (obj)).hasNext())
            {
                obj = (t)((Iterator) (obj)).next();
                TGTOrderProductImage tgtorderproductimage = new TGTOrderProductImage();
                tgtorderproductimage.a(((t) (obj)).a());
                tgtorderproductimage.b(((t) (obj)).b());
                tgtcartproduct.a(tgtorderproductimage);
            }
        }
        tgtcartproduct.a(b1.l());
        tgtcartproduct.l(Html.fromHtml(b1.k()).toString());
        tgtcartproduct.a(b1.h());
        tgtcartproduct.a(b1.o());
        tgtcartproduct.a(b1.g());
        tgtcartproduct.h(b1.p());
        Object obj1 = null;
        if (b1.r() != null)
        {
            obj1 = Integer.valueOf(Double.valueOf(b1.r()).intValue());
        }
        tgtcartproduct.a(((Integer) (obj1)));
        if (com.target.mothership.util.o.g(b1.N()))
        {
            obj1 = new TGTLimitedQuantityDetails();
            ((TGTLimitedQuantityDetails) (obj1)).a(b1.M());
            ((TGTLimitedQuantityDetails) (obj1)).a(Double.valueOf(b1.N()).intValue());
            if (com.target.mothership.util.o.g(b1.O()))
            {
                ((TGTLimitedQuantityDetails) (obj1)).b(Double.valueOf(b1.O()).intValue());
            }
            if (((TGTLimitedQuantityDetails) (obj1)).b() != 0)
            {
                tgtcartproduct.a(((com.target.mothership.model.cart.interfaces.LimitedQuantityDetails) (obj1)));
            }
        }
        tgtcartproduct.e(b1.c());
        tgtcartproduct.f(b1.f());
        ArrayList arraylist;
        boolean flag;
        if (com.target.mothership.util.o.g(b1.q()) && "true".equalsIgnoreCase(b1.q()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        tgtcartproduct.g(flag);
        tgtcartproduct.i(b1.d());
        tgtcartproduct.j(b1.e());
        tgtcartproduct.a(b1.j());
        tgtcartproduct.a(b1.t());
        tgtcartproduct.b(b1.u());
        tgtcartproduct.c(b1.v());
        tgtcartproduct.h(b1.w());
        tgtcartproduct.c(b(b1.y()));
        tgtcartproduct.i(b1.x());
        tgtcartproduct.a(b1.z());
        if (b1.u())
        {
            obj1 = com.target.mothership.common.a.b.Email;
        } else
        {
            obj1 = (new com.target.mothership.model.common.b()).a(b1.a());
        }
        tgtcartproduct.a(((com.target.mothership.common.a.b) (obj1)));
        tgtcartproduct.a(((com.target.mothership.common.a.b) (obj1)).a());
        tgtcartproduct.k(b1.b());
        if (com.target.mothership.util.o.g(b1.K()))
        {
            flag = "true".equalsIgnoreCase(b1.K());
        } else
        {
            flag = false;
        }
        tgtcartproduct.k(flag);
        tgtcartoffers = null;
        obj4 = null;
        obj5 = b1.i();
        obj3 = obj4;
        obj1 = tgtcartoffers;
        if (com.target.mothership.util.o.g(((String) (obj5))))
        {
            obj3 = obj4;
            obj1 = tgtcartoffers;
            if (((String) (obj5)).startsWith("("))
            {
                obj3 = obj4;
                obj1 = tgtcartoffers;
                Iterator iterator1;
                Object obj10;
                com.target.mothership.services.apigee.c.b.u.a a1;
                TGTCartOfferPrice tgtcartofferprice;
                if (((String) (obj5)).endsWith(")"))
                {
                    if (((String) (obj5)).contains("-"))
                    {
                        int i = ((String) (obj5)).indexOf("-");
                        obj3 = a(((String) (obj5)).substring(1, i));
                        obj1 = a(((String) (obj5)).substring(i + 1, ((String) (obj5)).length() - 1));
                    } else
                    {
                        obj1 = a(((String) (obj5)).substring(1, ((String) (obj5)).length() - 1));
                        obj3 = obj4;
                    }
                }
            }
        }
        tgtcartproduct.a(((Date) (obj1)));
        tgtcartproduct.b(((Date) (obj3)));
        tgtcartproduct.j(b1.J());
        s1 = b1.m();
        s2 = b1.n();
        tgtcartoffers = null;
        obj1 = null;
        obj8 = null;
        obj3 = null;
        obj7 = null;
        obj4 = null;
        obj5 = null;
        obj9 = null;
        arraylist = new ArrayList();
        if (b1.H() != null)
        {
            iterator1 = b1.H().iterator();
            do
            {
                tgtcartoffers = ((TGTCartOffers) (obj1));
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj10 = (u)iterator1.next();
                tgtcartoffers = new TGTCartOffers();
                ArrayList arraylist1 = new ArrayList();
                if (((u) (obj10)).a() != null)
                {
                    for (obj10 = ((u) (obj10)).a().iterator(); ((Iterator) (obj10)).hasNext(); arraylist1.add(tgtcartofferprice))
                    {
                        a1 = (com.target.mothership.services.apigee.c.b.u.a)((Iterator) (obj10)).next();
                        obj1 = a1.b();
                        tgtcartofferprice = new TGTCartOfferPrice();
                        tgtcartofferprice.b(a1.b());
                        tgtcartofferprice.a(a1.a());
                    }

                }
                tgtcartoffers.a(arraylist1);
            } while (true);
        }
        tgtcartproduct.a(arraylist);
        if (b1.P() == null) goto _L2; else goto _L1
_L1:
        Object obj2;
        Iterator iterator;
        iterator = b1.P().iterator();
        obj2 = obj9;
_L4:
        obj5 = obj2;
        obj7 = obj4;
        obj8 = obj3;
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        obj5 = (com.target.mothership.services.apigee.d.b.a)iterator.next();
        obj7 = com.target.mothership.common.a.a(((com.target.mothership.services.apigee.d.b.a) (obj5)).a());
        if (obj7 == a.PRICE_FOR_EACH)
        {
            obj5 = ((com.target.mothership.services.apigee.d.b.a) (obj5)).b();
            obj3 = obj4;
            obj4 = obj5;
        } else
        if (obj7 == a.ORIGINAL_PRICE)
        {
            obj5 = ((com.target.mothership.services.apigee.d.b.a) (obj5)).b();
            obj4 = obj3;
            obj3 = obj5;
        } else
        if (obj7 == a.SALE_PRICE)
        {
            obj2 = ((com.target.mothership.services.apigee.d.b.a) (obj5)).b();
            obj5 = obj3;
            obj3 = obj4;
            obj4 = obj5;
        } else
        {
            Object obj6 = obj3;
            obj3 = obj4;
            obj4 = obj6;
        }
        obj5 = obj4;
        obj4 = obj3;
        obj3 = obj5;
        if (true) goto _L4; else goto _L2
_L2:
        tgtcartproduct.d(l.a(new String[] {
            s1, obj5, obj8, obj7, s2, tgtcartoffers
        }));
        tgtcartproduct.e(l.a(new String[] {
            s2, obj8, s1, obj5, obj7
        }));
        tgtcartproduct.f(l.a(new String[] {
            tgtcartoffers, obj7, s2, obj8, s1, obj5
        }));
        if (com.target.mothership.util.o.g(b1.A()))
        {
            obj2 = new TGTCartRegistryDetails();
            ((TGTCartRegistryDetails) (obj2)).a(new RegistryId(b1.A()));
            ((TGTCartRegistryDetails) (obj2)).a(b1.B());
            ((TGTCartRegistryDetails) (obj2)).a(b1.C());
            tgtcartproduct.a(((com.target.mothership.model.cart.interfaces.CartRegistryDetails) (obj2)));
        }
        if (b1.D() != null)
        {
            obj2 = new TGTStorePickUpDetails();
            ((TGTStorePickUpDetails) (obj2)).a(b1.D());
            ((TGTStorePickUpDetails) (obj2)).a(b1.E());
            tgtcartproduct.a(((com.target.mothership.model.common.StorePickUpDetails) (obj2)));
        }
        obj2 = new TGTCartProductCharges();
        obj3 = b1.I();
        ((TGTCartProductCharges) (obj2)).b(((c) (obj3)).a());
        ((TGTCartProductCharges) (obj2)).c(((c) (obj3)).b());
        ((TGTCartProductCharges) (obj2)).d(((c) (obj3)).c());
        ((TGTCartProductCharges) (obj2)).e(((c) (obj3)).d());
        ((TGTCartProductCharges) (obj2)).f(((c) (obj3)).e());
        ((TGTCartProductCharges) (obj2)).a(((c) (obj3)).f());
        tgtcartproduct.a(((com.target.mothership.model.cart.interfaces.CartProductCharges) (obj2)));
        obj2 = new ArrayList();
        if (b1.F() != null)
        {
            obj3 = new al();
            for (obj4 = b1.F().iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj2)).add(((al) (obj3)).a((ac)((Iterator) (obj4)).next()))) { }
        }
        tgtcartproduct.b(((List) (obj2)));
        obj2 = new ArrayList();
        if (b1.G() != null)
        {
            obj3 = new com.target.mothership.model.cart.handler.u();
            for (b1 = b1.G().iterator(); b1.hasNext(); ((List) (obj2)).add(((com.target.mothership.model.cart.handler.u) (obj3)).a((s)b1.next()))) { }
        }
        tgtcartproduct.c(((List) (obj2)));
        return tgtcartproduct;
    }

    public volatile Object a(Object obj)
    {
        return a((b)obj);
    }
}
