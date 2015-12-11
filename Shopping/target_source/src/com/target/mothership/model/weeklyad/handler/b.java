// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.Upc;
import com.target.mothership.common.weeklyad.ProductSlug;
import com.target.mothership.common.weeklyad.a;
import com.target.mothership.common.weeklyad.c;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.n.b.a.d;
import com.target.mothership.services.apigee.n.b.a.i;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.mothership.model.weeklyad.handler:
//            TGTWeeklyAdListingDetail, TGTWeeklyAdListingPromotion, TGTWeeklyAdListingVariation, TGTWeeklyAdListingVariationItem, 
//            TGTWeeklyAdListingCollectionItem

public class b extends f
{

    private aa mTransformer;

    public b(h h)
    {
        super(h);
        mTransformer = new aa() {

            final b this$0;

            public WeeklyAdListingDetail a(com.target.mothership.services.apigee.n.b.b b1)
            {
                TGTWeeklyAdListingDetail tgtweeklyadlistingdetail;
                tgtweeklyadlistingdetail = new TGTWeeklyAdListingDetail();
                tgtweeklyadlistingdetail.a(b1.a());
                tgtweeklyadlistingdetail.b(b1.b());
                tgtweeklyadlistingdetail.c(b1.c());
                tgtweeklyadlistingdetail.a(com.target.mothership.common.weeklyad.b.a(b1.d()));
                tgtweeklyadlistingdetail.i(b1.v());
                tgtweeklyadlistingdetail.a(com.target.mothership.common.weeklyad.a.a(b1.f()));
                Object obj;
                boolean flag;
                if (b1.e() != null)
                {
                    flag = b1.e().booleanValue();
                } else
                {
                    flag = false;
                }
                tgtweeklyadlistingdetail.a(flag);
                tgtweeklyadlistingdetail.a(new ProductSlug(b1.o()));
                if (o.f(b1.k()))
                {
                    obj = new Tcin(b1.k());
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.a(((Tcin) (obj)));
                if (o.f(b1.l()))
                {
                    obj = new Dpci(b1.l());
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.a(((Dpci) (obj)));
                if (o.f(b1.n()))
                {
                    obj = new Upc(b1.n());
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.a(((Upc) (obj)));
                if (o.f(b1.m()))
                {
                    tgtweeklyadlistingdetail.a(new CatEntryId(b1.m()));
                } else
                if (b1.p() != null && !b1.p().isEmpty() && o.f(((i)b1.p().get(0)).a()))
                {
                    tgtweeklyadlistingdetail.a(new CatEntryId(((i)b1.p().get(0)).a()));
                }
                tgtweeklyadlistingdetail.g(b1.j());
                obj = new ArrayList();
                if (b1.t() != null)
                {
                    ((List) (obj)).addAll(b1.t());
                }
                if (((List) (obj)).isEmpty())
                {
                    ((List) (obj)).add(b1.j());
                }
                tgtweeklyadlistingdetail.a(((List) (obj)));
                if (o.f(b1.r()))
                {
                    obj = b1.r();
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.h(((String) (obj)));
                tgtweeklyadlistingdetail.b(b1.q());
                if (o.f(b1.h()))
                {
                    obj = b1.h();
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.d(((String) (obj)));
                if (o.f(b1.g()))
                {
                    obj = b1.g();
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.e(((String) (obj)));
                if (o.f(b1.i()))
                {
                    obj = b1.i();
                } else
                {
                    obj = null;
                }
                tgtweeklyadlistingdetail.f(((String) (obj)));
                obj = new ArrayList();
                if (b1.p() != null)
                {
                    TGTWeeklyAdListingPromotion tgtweeklyadlistingpromotion;
                    for (Iterator iterator = b1.p().iterator(); iterator.hasNext(); ((List) (obj)).add(tgtweeklyadlistingpromotion))
                    {
                        i j = (i)iterator.next();
                        tgtweeklyadlistingpromotion = new TGTWeeklyAdListingPromotion();
                        tgtweeklyadlistingpromotion.a(j.c());
                        tgtweeklyadlistingpromotion.b(j.b());
                    }

                }
                tgtweeklyadlistingdetail.c(((List) (obj)));
                if (b1.s() == null) goto _L2; else goto _L1
_L1:
                Object obj1 = new TGTWeeklyAdListingVariation();
                if (b1.s().c() == null) goto _L4; else goto _L3
_L3:
                LinkedHashMap linkedhashmap = b1.s().c();
                ((TGTWeeklyAdListingVariation) (obj1)).a(new ArrayList());
                ((TGTWeeklyAdListingVariation) (obj1)).b().addAll(linkedhashmap.keySet());
                ((TGTWeeklyAdListingVariation) (obj1)).a(b1.s().a());
                ArrayList arraylist = new ArrayList();
                for (Iterator iterator1 = linkedhashmap.keySet().iterator(); iterator1.hasNext();)
                {
                    String s = (String)iterator1.next();
                    com.target.mothership.services.apigee.n.b.a.h h1 = (com.target.mothership.services.apigee.n.b.a.h)linkedhashmap.get(s);
                    String as[] = h1.d().split(",");
                    String as1[] = h1.e().split(",");
                    String as2[] = h1.h().split(",");
                    String as3[] = h1.b().split(",");
                    String as4[] = h1.c().split(",");
                    String as5[] = h1.g().split(",");
                    int l = as.length;
                    int k = 0;
                    while (k < l) 
                    {
                        TGTWeeklyAdListingVariationItem tgtweeklyadlistingvariationitem1 = new TGTWeeklyAdListingVariationItem();
                        tgtweeklyadlistingvariationitem1.a(new Tcin(as[k]));
                        tgtweeklyadlistingvariationitem1.a(new Dpci(as1[k]));
                        tgtweeklyadlistingvariationitem1.a(new CatEntryId(as2[k]));
                        tgtweeklyadlistingvariationitem1.a((String)h1.a().get(k));
                        tgtweeklyadlistingvariationitem1.b(as3[k]);
                        tgtweeklyadlistingvariationitem1.c(as4[k]);
                        tgtweeklyadlistingvariationitem1.d(s);
                        tgtweeklyadlistingvariationitem1.e(as5[k]);
                        if (o.f(h1.f()))
                        {
                            tgtweeklyadlistingvariationitem1.f(h1.f());
                        } else
                        {
                            tgtweeklyadlistingvariationitem1.f(tgtweeklyadlistingdetail.e());
                        }
                        if (!arraylist.contains(as5[k]))
                        {
                            arraylist.add(as5[k]);
                        }
                        ((TGTWeeklyAdListingVariation) (obj1)).a(tgtweeklyadlistingvariationitem1);
                        k++;
                    }
                }

                ((TGTWeeklyAdListingVariation) (obj1)).b(arraylist);
_L6:
                tgtweeklyadlistingdetail.a(((com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingVariation) (obj1)));
_L2:
                obj1 = new ArrayList();
                if (b1.u() != null)
                {
                    Object obj2 = b1.u().iterator();
                    while (((Iterator) (obj2)).hasNext()) 
                    {
                        Object obj3 = (d)((Iterator) (obj2)).next();
                        Object obj4 = new TGTWeeklyAdListingCollectionItem();
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).c(((d) (obj3)).g());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(new Tcin(((d) (obj3)).h()));
                        com.target.mothership.services.apigee.n.b.a.a a1;
                        TGTWeeklyAdListingVariationItem tgtweeklyadlistingvariationitem;
                        if (o.f(((d) (obj3)).i()))
                        {
                            b1 = new Dpci(((d) (obj3)).i());
                        } else
                        {
                            b1 = null;
                        }
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(b1);
                        if (o.f(((d) (obj3)).l()))
                        {
                            b1 = new CatEntryId(((d) (obj3)).l());
                        } else
                        {
                            b1 = null;
                        }
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(b1);
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).d(((d) (obj3)).j());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(((d) (obj3)).a());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).b(((d) (obj3)).b());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(com.target.mothership.common.weeklyad.b.a(((d) (obj3)).c()));
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).e(((d) (obj3)).d());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(com.target.mothership.common.weeklyad.a.a(((d) (obj3)).e()));
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(((d) (obj3)).f());
                        ((TGTWeeklyAdListingCollectionItem) (obj4)).a(new ProductSlug(((d) (obj3)).k()));
                        ((List) (obj1)).add(obj4);
                    }
                }
                break; /* Loop/switch isn't completed */
_L4:
                if (b1.s().b() == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                obj2 = new ArrayList();
                obj3 = b1.s().a();
                ((TGTWeeklyAdListingVariation) (obj1)).a(((c) (obj3)));
                obj4 = b1.s().b().iterator();
                while (((Iterator) (obj4)).hasNext()) 
                {
                    a1 = (com.target.mothership.services.apigee.n.b.a.a)((Iterator) (obj4)).next();
                    tgtweeklyadlistingvariationitem = new TGTWeeklyAdListingVariationItem();
                    tgtweeklyadlistingvariationitem.a(new Tcin(a1.d()));
                    tgtweeklyadlistingvariationitem.a(new Dpci(a1.e()));
                    tgtweeklyadlistingvariationitem.a(new CatEntryId(a1.i()));
                    tgtweeklyadlistingvariationitem.a(a1.a());
                    tgtweeklyadlistingvariationitem.b(a1.b());
                    tgtweeklyadlistingvariationitem.c(a1.c());
                    tgtweeklyadlistingvariationitem.d(a1.g());
                    tgtweeklyadlistingvariationitem.e(a1.h());
                    if (o.f(a1.f()))
                    {
                        tgtweeklyadlistingvariationitem.f(a1.f());
                    } else
                    {
                        tgtweeklyadlistingvariationitem.f(tgtweeklyadlistingdetail.e());
                    }
                    if (obj3 == c.COLORS && !((List) (obj2)).contains(a1.g()))
                    {
                        ((List) (obj2)).add(a1.g());
                    } else
                    if (obj3 == c.SIZES && !((List) (obj2)).contains(a1.h()))
                    {
                        ((List) (obj2)).add(a1.h());
                    }
                    ((TGTWeeklyAdListingVariation) (obj1)).a(tgtweeklyadlistingvariationitem);
                }
                if (obj3 == c.COLORS)
                {
                    ((TGTWeeklyAdListingVariation) (obj1)).a(((List) (obj2)));
                } else
                {
                    ((TGTWeeklyAdListingVariation) (obj1)).b(((List) (obj2)));
                }
                if (true) goto _L6; else goto _L5
_L5:
                tgtweeklyadlistingdetail.d(((List) (obj1)));
                return tgtweeklyadlistingdetail;
            }

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.apigee.n.b.b)obj);
            }

            
            {
                this$0 = b.this;
                super();
            }
        };
    }

    public WeeklyAdListingDetail a(com.target.mothership.services.apigee.n.b.b b1)
    {
        return (WeeklyAdListingDetail)mTransformer.a(b1);
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.n.b.b)obj);
    }
}
