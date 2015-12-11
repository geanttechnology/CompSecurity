// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.common.product.b;
import com.target.mothership.common.product.d;
import com.target.mothership.common.product.n;
import com.target.mothership.common.product.r;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.TGTDvmRemoteData;
import com.target.mothership.model.f;
import com.target.mothership.services.e.e.b.a.a;
import com.target.mothership.services.e.e.b.a.c;
import com.target.mothership.services.e.e.b.a.h;
import com.target.mothership.services.e.e.b.a.i;
import com.target.mothership.services.e.e.b.a.j;
import com.target.mothership.services.e.e.b.a.k;
import com.target.mothership.services.e.e.b.a.l;
import com.target.mothership.services.e.e.b.a.m;
import com.target.mothership.services.e.e.b.a.p;
import com.target.mothership.services.e.e.b.a.q;
import com.target.mothership.services.e.e.b.a.s;
import com.target.mothership.services.e.e.b.a.t;
import com.target.mothership.services.e.e.b.a.u;
import com.target.mothership.services.e.e.b.a.v;
import com.target.mothership.services.e.e.b.a.w;
import com.target.mothership.services.e.e.b.a.x;
import com.target.mothership.services.e.e.b.a.y;
import com.target.mothership.services.e.i.g;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductOnlineInfo, TGTProductPrice, TGTProductPriceRange, TGTProductLimitedAvailability, 
//            TGTProductEyeBrow, TGTProductStoreInfo, TGTProductInStoreLocation, TGTProductImage, 
//            TGTProductAttributes, TGTProductChokingHazard, TGTProductCartWheel, TGTProductIndustryRating, 
//            TGTProductEsrbRating, TGTProductMpaaRating, TGTProductRiaaRating, TGTProductCallout, 
//            TGTProductPromotion, TGTProductVariationValues, TGTProductVariationType, TGTProductDetails, 
//            TGTProductVariation, TGTProductVariationSummary, TGTProductCollection, TGTProductFeature, 
//            TGTProductGuestReview, TGTProductRootLevelCategory, TGTProductAgeRestriction

public abstract class e extends f
{
    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a DIMENSION_ONE;
        public static final a DIMENSION_TWO;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/mothership/model/product/handler/e$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            DIMENSION_ONE = new a("DIMENSION_ONE", 0);
            DIMENSION_TWO = new a("DIMENSION_TWO", 1);
            $VALUES = (new a[] {
                DIMENSION_ONE, DIMENSION_TWO
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    private static final String COLLECTION_PARENT = "COLLECTION_PARENT";

    public e(com.target.mothership.model.h h1)
    {
        super(h1);
    }

    private List a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return Collections.emptyList();
        } else
        {
            list = new LinkedHashSet(list);
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(list);
            return arraylist;
        }
    }

    private List a(List list, a a1)
    {
        String s1 = null;
        if (list != null) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        return ((List) (obj));
_L2:
        Iterator iterator = list.iterator();
        list = null;
        do
        {
            obj = list;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = ((w)iterator.next()).L();
            if (obj != null)
            {
                if (a1.equals(a.DIMENSION_ONE))
                {
                    s1 = ((y) (obj)).a();
                } else
                if (a1.equals(a.DIMENSION_TWO))
                {
                    s1 = ((y) (obj)).b();
                }
                if (list == null)
                {
                    list = new ArrayList();
                }
                if (o.b(s1) && o.g(s1))
                {
                    list.add(s1.toLowerCase());
                }
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private List a(List list, List list1)
    {
        ArrayList arraylist;
        Iterator iterator;
        if (list == null || list1 == null)
        {
            return Collections.emptyList();
        }
        arraylist = new ArrayList();
        iterator = list1.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Iterator iterator1;
        list1 = (String)iterator.next();
        iterator1 = list.iterator();
_L6:
        if (!iterator1.hasNext()) goto _L4; else goto _L3
_L3:
        w w1;
        y y1;
        w1 = (w)iterator1.next();
        y1 = w1.L();
        if (y1 == null || !list1.equalsIgnoreCase(y1.a())) goto _L6; else goto _L5
_L5:
        if (w1.D().a() != null)
        {
            list1 = w1.D().a();
        } else
        {
            list1 = null;
        }
        arraylist.add(list1);
_L4:
        if (true) goto _L7; else goto _L2
_L2:
        return arraylist;
    }

    private void a(TGTProductOnlineInfo tgtproductonlineinfo, com.target.mothership.services.e.e.b.a.o o1)
    {
        Object obj1 = null;
        if (o1 == null)
        {
            tgtproductonlineinfo.a(false);
            return;
        }
        Object obj;
        Object obj2;
        q q1;
        if (o1.g() != null || o1.h() != null || o1.j() != null || o1.i() != null || o1.c() != null || o1.a())
        {
            tgtproductonlineinfo.a(true);
        } else
        {
            tgtproductonlineinfo.a(false);
        }
        obj = new TGTProductPrice();
        obj2 = o1.h();
        if (obj2 != null)
        {
            a(((TGTProductPrice) (obj)), ((p) (obj2)));
        } else
        {
            obj = null;
        }
        obj2 = new TGTProductPriceRange();
        q1 = o1.i();
        if (q1 != null)
        {
            a(((TGTProductPriceRange) (obj2)), q1);
            obj1 = obj2;
        }
        tgtproductonlineinfo.a(n.a(o1.g()));
        tgtproductonlineinfo.a(((com.target.mothership.model.product.interfaces.ProductPrice) (obj)));
        tgtproductonlineinfo.a(((com.target.mothership.model.product.interfaces.ProductPriceRange) (obj1)));
        tgtproductonlineinfo.b(o1.a());
        tgtproductonlineinfo.a((new com.target.mothership.services.e.i.f()).a(o1.j()));
        tgtproductonlineinfo.a((new g()).a(o1.k()));
        if (o1.f() != null)
        {
            obj = new TGTProductLimitedAvailability();
            ((TGTProductLimitedAvailability) (obj)).a(o1.f().a());
            ((TGTProductLimitedAvailability) (obj)).a(o1.f().b());
            tgtproductonlineinfo.a(((com.target.mothership.model.product.interfaces.ProductLimitedAvailability) (obj)));
        }
        tgtproductonlineinfo.a(o1.b());
        obj = new ArrayList();
        obj1 = o1.c();
        if (obj1 != null)
        {
            TGTProductEyeBrow tgtproducteyebrow;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(tgtproducteyebrow))
            {
                com.target.mothership.services.e.e.b.a.f f1 = (com.target.mothership.services.e.e.b.a.f)((Iterator) (obj1)).next();
                tgtproducteyebrow = new TGTProductEyeBrow();
                tgtproducteyebrow.a(com.target.mothership.common.product.f.a(f1.a()));
                tgtproducteyebrow.a(f1.b());
            }

        }
        tgtproductonlineinfo.a(((List) (obj)));
        tgtproductonlineinfo.a(o1.d());
        tgtproductonlineinfo.c(o1.e());
    }

    private void a(TGTProductPrice tgtproductprice, p p1)
    {
        if (p1 == null)
        {
            return;
        } else
        {
            tgtproductprice.a(p1.a());
            tgtproductprice.a(p1.b());
            tgtproductprice.b(p1.c());
            tgtproductprice.b(p1.d());
            tgtproductprice.c(p1.e());
            tgtproductprice.a(Integer.valueOf(p1.f()));
            tgtproductprice.b(p1.c());
            tgtproductprice.c(p1.g());
            return;
        }
    }

    private void a(TGTProductPriceRange tgtproductpricerange, q q1)
    {
        if (q1 == null)
        {
            return;
        } else
        {
            tgtproductpricerange.a(q1.a());
            tgtproductpricerange.b(q1.b());
            tgtproductpricerange.a(q1.c());
            tgtproductpricerange.c(q1.d());
            tgtproductpricerange.d(q1.e());
            tgtproductpricerange.b(q1.f());
            tgtproductpricerange.c(q1.h());
            tgtproductpricerange.a(q1.g());
            return;
        }
    }

    private void a(TGTProductStoreInfo tgtproductstoreinfo, v v1)
    {
        Object obj2 = null;
        if (v1 == null)
        {
            tgtproductstoreinfo.a(false);
            return;
        }
        tgtproductstoreinfo.a(v1.a());
        tgtproductstoreinfo.a(n.a(v1.g()));
        Object obj = new TGTProductPrice();
        Object obj1;
        List list;
        if (v1.h() != null)
        {
            a(((TGTProductPrice) (obj)), v1.h());
        } else
        {
            obj = null;
        }
        obj1 = new TGTProductPriceRange();
        if (v1.i() != null)
        {
            a(((TGTProductPriceRange) (obj1)), v1.i());
        } else
        {
            obj1 = null;
        }
        tgtproductstoreinfo.a(((com.target.mothership.model.product.interfaces.ProductPrice) (obj)));
        tgtproductstoreinfo.a(((com.target.mothership.model.product.interfaces.ProductPriceRange) (obj1)));
        tgtproductstoreinfo.b(v1.c());
        list = v1.b();
        obj = obj2;
        if (list != null)
        {
            obj1 = new ArrayList();
            Iterator iterator = list.iterator();
            do
            {
                obj = obj1;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (l)iterator.next();
                TGTProductInStoreLocation tgtproductinstorelocation = new TGTProductInStoreLocation();
                tgtproductinstorelocation.b(((l) (obj)).b());
                tgtproductinstorelocation.a(((l) (obj)).a());
                tgtproductinstorelocation.a(new StoreIdentifier(String.valueOf(v1.a())));
                ((List) (obj1)).add(tgtproductinstorelocation);
            } while (true);
        }
        tgtproductstoreinfo.a(((List) (obj)));
        tgtproductstoreinfo.a((new com.target.mothership.services.e.i.f()).a(v1.j()));
        tgtproductstoreinfo.a((new g()).a(v1.k()));
    }

    private void a(s s1, TGTProductImage tgtproductimage)
    {
        if (s1 == null)
        {
            return;
        }
        Object obj;
        l l1;
        if (s1.D() != null)
        {
            obj = s1.D().a();
        } else
        {
            obj = null;
        }
        if (obj != null)
        {
            tgtproductimage.a(((URL) (obj)));
            return;
        }
        obj = d.UNKNOWN;
        s1 = s1.K();
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.b();
        if (s1 == null) goto _L2; else goto _L3
_L3:
        s1 = s1.iterator();
_L6:
        if (!s1.hasNext()) goto _L2; else goto _L4
_L4:
        l1 = (l)s1.next();
        if (!o.g(l1.a())) goto _L6; else goto _L5
_L5:
        s1 = d.a(l1.a());
_L8:
        s1 = com.target.mothership.util.p.a(s1);
        try
        {
            s1 = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (s s1)
        {
            s1 = null;
        }
        tgtproductimage.a(s1);
        return;
_L2:
        s1 = ((s) (obj));
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void c(TGTProductAttributes tgtproductattributes, s s1)
    {
        if (s1 == null)
        {
            return;
        }
        TGTProductStoreInfo tgtproductstoreinfo = new TGTProductStoreInfo();
        tgtproductstoreinfo.a(r.a(s1.J()));
        if (r.a(s1.J()).equals(r.OK))
        {
            tgtproductstoreinfo.a(true);
            a(tgtproductstoreinfo, s1.K());
        } else
        {
            tgtproductstoreinfo.a(false);
        }
        if (s1.K() != null && s1.K().d() != null)
        {
            tgtproductstoreinfo.a(new Boolean(s1.K().d()));
        } else
        {
            tgtproductstoreinfo.a(null);
        }
        tgtproductattributes.a(tgtproductstoreinfo);
    }

    protected void a(TGTProductAttributes tgtproductattributes, s s1)
    {
        boolean flag1 = true;
        Object obj1 = null;
        b(tgtproductattributes, s1);
        tgtproductattributes.f(s1.p());
        tgtproductattributes.d(s1.q());
        tgtproductattributes.a(s1.G());
        tgtproductattributes.b(s1.H());
        tgtproductattributes.b(s1.r());
        tgtproductattributes.a(s1.s());
        tgtproductattributes.c(s1.t());
        tgtproductattributes.e(s1.u());
        tgtproductattributes.g(s1.v());
        if (s1.U() != null)
        {
            TGTDvmRemoteData tgtdvmremotedata = new TGTDvmRemoteData();
            tgtdvmremotedata.a(s1.U());
            tgtproductattributes.a(tgtdvmremotedata);
        }
        Object obj = new ArrayList();
        Object obj2 = s1.w();
        if (obj2 != null)
        {
            TGTProductChokingHazard tgtproductchokinghazard;
            for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(tgtproductchokinghazard))
            {
                c c1 = (c)((Iterator) (obj2)).next();
                tgtproductchokinghazard = new TGTProductChokingHazard();
                tgtproductchokinghazard.a(c1.a());
                tgtproductchokinghazard.b(c1.b());
            }

        }
        tgtproductattributes.b(((List) (obj)));
        tgtproductattributes.a(com.target.mothership.common.product.b.a(s1.y()));
        obj = new ArrayList();
        obj2 = s1.x();
        if (obj2 != null)
        {
            obj2 = ((List) (obj2)).iterator();
            while (((Iterator) (obj2)).hasNext()) 
            {
                Object obj3 = (com.target.mothership.services.e.e.b.a.b)((Iterator) (obj2)).next();
                Object obj4 = new TGTProductCartWheel();
                boolean flag;
                if (com.target.mothership.common.product.b.a(s1.y()).equals(b.OK))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((TGTProductCartWheel) (obj4)).a(flag);
                ((TGTProductCartWheel) (obj4)).a(((com.target.mothership.services.e.e.b.a.b) (obj3)).a());
                ((TGTProductCartWheel) (obj4)).a(((com.target.mothership.services.e.e.b.a.b) (obj3)).b());
                ((TGTProductCartWheel) (obj4)).b(((com.target.mothership.services.e.e.b.a.b) (obj3)).c());
                ((TGTProductCartWheel) (obj4)).c(((com.target.mothership.services.e.e.b.a.b) (obj3)).d());
                ((TGTProductCartWheel) (obj4)).d(((com.target.mothership.services.e.e.b.a.b) (obj3)).e());
                ((TGTProductCartWheel) (obj4)).e(((com.target.mothership.services.e.e.b.a.b) (obj3)).f());
                ((List) (obj)).add(obj4);
            }
        }
        tgtproductattributes.a(((List) (obj)));
        obj2 = new TGTProductIndustryRating();
        if (s1.E() != null)
        {
            if (s1.E().a() != null)
            {
                obj = new TGTProductEsrbRating();
                ((TGTProductEsrbRating) (obj)).a(com.target.mothership.common.product.e.a(s1.E().a().a()));
                ((TGTProductEsrbRating) (obj)).a(s1.E().a().b());
                ((TGTProductIndustryRating) (obj2)).a(((com.target.mothership.model.product.interfaces.ProductEsrbRating) (obj)));
            }
            if (s1.E().b() != null)
            {
                obj = new TGTProductMpaaRating();
                ((TGTProductMpaaRating) (obj)).a(com.target.mothership.common.product.l.a(s1.E().b().a()));
                ((TGTProductIndustryRating) (obj2)).a(((com.target.mothership.model.product.interfaces.ProductMpaaRating) (obj)));
            }
            obj = obj2;
            if (s1.E().c() != null)
            {
                obj = new TGTProductRiaaRating();
                ((TGTProductRiaaRating) (obj)).a(s1.E().c().a());
                ((TGTProductIndustryRating) (obj2)).a(((com.target.mothership.model.product.interfaces.ProductRiaaRating) (obj)));
                obj = obj2;
            }
        } else
        {
            obj = null;
        }
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductIndustryRating) (obj)));
        if (s1.I() != null)
        {
            obj = new Tcin(s1.I());
        } else
        {
            obj = null;
        }
        tgtproductattributes.b(((Tcin) (obj)));
        c(tgtproductattributes, s1);
        obj = new ArrayList();
        obj2 = s1.P();
        if (obj2 != null)
        {
            for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(obj4))
            {
                obj3 = (com.target.mothership.services.e.e.b.a.a)((Iterator) (obj2)).next();
                obj4 = new TGTProductCallout();
                ((TGTProductCallout) (obj4)).a(com.target.mothership.common.product.a.a(((com.target.mothership.services.e.e.b.a.a) (obj3)).a()));
                ((TGTProductCallout) (obj4)).a(((com.target.mothership.services.e.e.b.a.a) (obj3)).b());
            }

        }
        tgtproductattributes.d(((List) (obj)));
        obj = new ArrayList();
        obj2 = s1.Q();
        if (obj2 != null)
        {
            for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(obj4))
            {
                obj3 = (t)((Iterator) (obj2)).next();
                obj4 = new TGTProductPromotion();
                ((TGTProductPromotion) (obj4)).a(((t) (obj3)).a());
                ((TGTProductPromotion) (obj4)).b(((t) (obj3)).b());
            }

        }
        tgtproductattributes.e(((List) (obj)));
        obj = s1.R();
        if (o.g(((String) (obj))))
        {
            obj = new CouponPromotionId(((String) (obj)));
        } else
        {
            obj = null;
        }
        tgtproductattributes.a(((CouponPromotionId) (obj)));
        obj = s1.S();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        tgtproductattributes.h(flag);
        tgtproductattributes.f(((List) (obj)));
        obj = obj1;
        if (s1.L() != null)
        {
            obj = new TGTProductVariationValues();
            ((TGTProductVariationValues) (obj)).a(s1.L().a());
            ((TGTProductVariationValues) (obj)).b(s1.L().b());
        }
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductVariationValues) (obj)));
    }

    protected void a(TGTProductDetails tgtproductdetails, com.target.mothership.services.e.e.b.b b1)
    {
        Object obj2 = null;
        if (b1 == null)
        {
            return;
        }
        a(((TGTProductAttributes) (tgtproductdetails)), ((s) (b1)));
        Object obj = new TGTProductVariationType();
        Object obj1;
        Object obj3;
        if (b1.c() != null)
        {
            ((TGTProductVariationType) (obj)).a(b1.c().a());
            ((TGTProductVariationType) (obj)).b(b1.c().b());
            tgtproductdetails.j(true);
        } else
        {
            tgtproductdetails.j(false);
            obj = null;
        }
        tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductVariationDimensions) (obj)));
        obj3 = b1.d();
        if (obj3 != null)
        {
            obj1 = new ArrayList();
            TGTProductVariation tgtproductvariation;
            for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj1)).add(tgtproductvariation))
            {
                w w1 = (w)((Iterator) (obj3)).next();
                tgtproductvariation = new TGTProductVariation();
                a(((TGTProductDetails) (tgtproductvariation)), ((com.target.mothership.services.e.e.b.b) (w1)));
            }

        } else
        {
            obj1 = null;
        }
        tgtproductdetails.g(((List) (obj1)));
        if (obj != null)
        {
            obj3 = new TGTProductVariationSummary();
            ((TGTProductVariationSummary) (obj3)).a(((com.target.mothership.model.product.interfaces.ProductVariationDimensions) (obj)));
            obj1 = a(a(b1.d(), a.DIMENSION_ONE));
            obj = obj1;
            if (((List) (obj1)).isEmpty())
            {
                obj = null;
            }
            List list = a(a(b1.d(), a.DIMENSION_TWO));
            obj1 = list;
            if (list.isEmpty())
            {
                obj1 = null;
            }
            ((TGTProductVariationSummary) (obj3)).a(a(b1.d(), ((List) (obj))));
            ((TGTProductVariationSummary) (obj3)).b(((List) (obj)));
            ((TGTProductVariationSummary) (obj3)).c(((List) (obj1)));
            obj = obj3;
        } else
        {
            obj = null;
        }
        tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductVariationSummary) (obj)));
        obj = new ArrayList();
        obj1 = b1.e();
        if (obj1 != null && ((List) (obj1)).size() > 0)
        {
            TGTProductCollection tgtproductcollection;
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(tgtproductcollection))
            {
                obj3 = (com.target.mothership.services.e.e.b.a.d)((Iterator) (obj1)).next();
                tgtproductcollection = new TGTProductCollection();
                a(((TGTProductDetails) (tgtproductcollection)), ((com.target.mothership.services.e.e.b.b) (obj3)));
            }

            tgtproductdetails.i(true);
        } else
        {
            boolean flag;
            if (o.g(b1.O()) && "COLLECTION_PARENT".equals(b1.O()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            tgtproductdetails.i(flag);
        }
        tgtproductdetails.h(((List) (obj)));
        tgtproductdetails.a(b1.m());
        obj3 = b1.M();
        obj = obj2;
        if (obj3 != null)
        {
            obj1 = new ArrayList();
            Iterator iterator = ((List) (obj3)).iterator();
            do
            {
                obj = obj1;
                if (!iterator.hasNext())
                {
                    break;
                }
                obj = (com.target.mothership.services.e.e.b.a.g)iterator.next();
                TGTProductFeature tgtproductfeature = new TGTProductFeature();
                tgtproductfeature.a(((com.target.mothership.services.e.e.b.a.g) (obj)).a());
                tgtproductfeature.b(((com.target.mothership.services.e.e.b.a.g) (obj)).b());
                ((List) (obj1)).add(tgtproductfeature);
            } while (true);
        }
        tgtproductdetails.c(((List) (obj)));
        tgtproductdetails.c(b1.N());
        tgtproductdetails.a(com.target.mothership.common.product.k.a(b1.T()));
    }

    protected void b(TGTProductAttributes tgtproductattributes, s s1)
    {
        Object obj2 = null;
        Object obj1 = null;
        if (s1 == null)
        {
            return;
        }
        Object obj;
        TGTProductGuestReview tgtproductguestreview;
        if (s1.f() != null)
        {
            obj = new Dpci(s1.f());
        } else
        {
            obj = null;
        }
        tgtproductattributes.a(((Dpci) (obj)));
        obj = s1.g();
        if (o.g(((String) (obj))))
        {
            obj = new Tcin(((String) (obj)));
        } else
        {
            obj = new Tcin("");
        }
        tgtproductattributes.a(((Tcin) (obj)));
        if (s1.h() != null)
        {
            obj = new Upc(s1.h());
        } else
        {
            obj = null;
        }
        tgtproductattributes.a(((Upc) (obj)));
        if (s1.i() != null)
        {
            tgtproductattributes.l(s1.i());
        } else
        {
            tgtproductattributes.l("");
        }
        if (s1.j() != null)
        {
            tgtproductattributes.a(s1.j());
        } else
        {
            tgtproductattributes.a("");
        }
        obj = new TGTProductOnlineInfo();
        a(((TGTProductOnlineInfo) (obj)), s1.k());
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductOnlineInfo) (obj)));
        tgtproductattributes.a(s1.l());
        tgtproductattributes.a(s1.m());
        tgtproductattributes.a(com.target.mothership.common.product.c.a(s1.n()));
        tgtproductguestreview = new TGTProductGuestReview();
        if (s1.o() != null)
        {
            BigDecimal bigdecimal = s1.o().a();
            obj = bigdecimal;
            if (bigdecimal == null)
            {
                obj = new BigDecimal(0);
            }
            tgtproductguestreview.a(((BigDecimal) (obj)));
            tgtproductguestreview.a(s1.o().b());
            obj = tgtproductguestreview;
        } else
        {
            obj = null;
        }
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductGuestReview) (obj)));
        tgtproductattributes.a(com.target.mothership.common.product.j.a(s1.A()));
        tgtproductattributes.b(s1.B());
        tgtproductattributes.c(s1.C());
        obj = new TGTProductImage();
        if (s1.D() != null)
        {
            ((TGTProductImage) (obj)).c(s1.D().b());
            a(s1, ((TGTProductImage) (obj)));
            ((TGTProductImage) (obj)).b(s1.D().a());
            ((TGTProductImage) (obj)).a(s1.D().c());
        } else
        {
            a(s1, ((TGTProductImage) (obj)));
        }
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductImage) (obj)));
        obj = obj2;
        if (s1.z() != null)
        {
            obj = obj2;
            if (o.g(s1.z().b()))
            {
                TGTProductRootLevelCategory tgtproductrootlevelcategory = new TGTProductRootLevelCategory();
                String s2 = s1.z().a();
                obj = obj1;
                if (o.g(s2))
                {
                    obj = new CategoryId(s2);
                }
                tgtproductrootlevelcategory.a(((CategoryId) (obj)));
                tgtproductrootlevelcategory.a(s1.z().b());
                obj = tgtproductrootlevelcategory;
            }
        }
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductRootLevelCategory) (obj)));
        obj = new TGTProductAgeRestriction();
        ((TGTProductAgeRestriction) (obj)).a(s1.F());
        tgtproductattributes.a(((com.target.mothership.model.product.interfaces.ProductAgeRestriction) (obj)));
    }
}
