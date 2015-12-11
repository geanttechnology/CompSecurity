// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.a;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.j;
import com.target.mothership.common.product.n;
import com.target.mothership.common.product.q;
import com.target.mothership.model.f;
import com.target.mothership.model.product.interfaces.ProductPrice;
import com.target.mothership.model.product.interfaces.ProductPriceRange;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.e.b.d;
import com.target.mothership.services.e.e.b.g;
import com.target.mothership.services.x;
import com.target.mothership.util.c;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            TGTProductDetails, TGTProductImage, TGTProductGuestReview, TGTProductStoreInfo, 
//            TGTProductOnlineInfo, TGTProductCallout, TGTProductPromotion, TGTProductPrice, 
//            TGTProductPriceRange, TGTProductRecommendations

public class h extends f
{

    private final aa mTransformer = new aa() {

        final h this$0;

        private TGTProductDetails a(g g1)
        {
            TGTProductDetails tgtproductdetails = new TGTProductDetails();
            tgtproductdetails.l(g1.c());
            tgtproductdetails.a(g1.b());
            tgtproductdetails.g(g1.k());
            tgtproductdetails.a(g1.j());
            Object obj = new TGTProductImage();
            ((TGTProductImage) (obj)).a(g1.l());
            tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductImage) (obj)));
            obj = new TGTProductGuestReview();
            ((TGTProductGuestReview) (obj)).a(g1.n());
            ((TGTProductGuestReview) (obj)).a(g1.m());
            tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductGuestReview) (obj)));
            obj = new TGTProductStoreInfo();
            ((TGTProductStoreInfo) (obj)).a(false);
            tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductStoreInfo) (obj)));
            obj = new TGTProductOnlineInfo();
            ((TGTProductOnlineInfo) (obj)).a(true);
            ((TGTProductOnlineInfo) (obj)).a(Collections.emptyList());
            Object obj1;
            if (g1.o())
            {
                ((TGTProductOnlineInfo) (obj)).a(i.InStock);
            } else
            {
                ((TGTProductOnlineInfo) (obj)).a(i.OutOfStock);
            }
            if (g1.a() == q.PARENT)
            {
                ((TGTProductOnlineInfo) (obj)).a(n.RANGE);
                ((TGTProductOnlineInfo) (obj)).a(c(g1));
            } else
            {
                ((TGTProductOnlineInfo) (obj)).a(n.SINGLE);
                ((TGTProductOnlineInfo) (obj)).a(b(g1));
            }
            tgtproductdetails.a(((com.target.mothership.model.product.interfaces.ProductOnlineInfo) (obj)));
            obj = new ArrayList();
            obj1 = g1.p();
            if (o.g(((String) (obj1))))
            {
                TGTProductCallout tgtproductcallout = new TGTProductCallout();
                tgtproductcallout.a(a.UNKNOWN);
                tgtproductcallout.a(((String) (obj1)));
                ((List) (obj)).add(tgtproductcallout);
            }
            tgtproductdetails.d(((List) (obj)));
            obj = new ArrayList();
            obj1 = g1.q();
            if (obj1 != null)
            {
                obj1 = ((List) (obj1)).iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    String s = (String)((Iterator) (obj1)).next();
                    if (o.g(s))
                    {
                        TGTProductPromotion tgtproductpromotion = new TGTProductPromotion();
                        tgtproductpromotion.b(s);
                        tgtproductpromotion.a("");
                    }
                } while (true);
            }
            tgtproductdetails.e(((List) (obj)));
            tgtproductdetails.a(j.a(g1.r()));
            obj = g1.s();
            g1 = null;
            if (o.g(((String) (obj))))
            {
                g1 = new Tcin(((String) (obj)));
            }
            tgtproductdetails.b(g1);
            return tgtproductdetails;
        }

        private ProductPrice b(g g1)
        {
            TGTProductPrice tgtproductprice = new TGTProductPrice();
            tgtproductprice.a(c.USD);
            BigDecimal bigdecimal;
            if (o.g(g1.d()))
            {
                bigdecimal = new BigDecimal(g1.d());
            } else
            {
                bigdecimal = c.ZERO;
            }
            tgtproductprice.a(bigdecimal);
            if (o.g(g1.g()))
            {
                g1 = new BigDecimal(g1.g());
            } else
            {
                g1 = c.ZERO;
            }
            tgtproductprice.b(g1);
            tgtproductprice.b(null);
            tgtproductprice.a(null);
            return tgtproductprice;
        }

        private ProductPriceRange c(g g1)
        {
            TGTProductPriceRange tgtproductpricerange = new TGTProductPriceRange();
            tgtproductpricerange.a(c.USD);
            BigDecimal bigdecimal;
            if (o.g(g1.i()))
            {
                bigdecimal = new BigDecimal(g1.i());
            } else
            {
                bigdecimal = c.ZERO;
            }
            tgtproductpricerange.a(bigdecimal);
            if (o.g(g1.h()))
            {
                bigdecimal = new BigDecimal(g1.h());
            } else
            {
                bigdecimal = c.ZERO;
            }
            tgtproductpricerange.b(bigdecimal);
            if (o.g(g1.e()))
            {
                bigdecimal = new BigDecimal(g1.e());
            } else
            {
                bigdecimal = c.ZERO;
            }
            tgtproductpricerange.c(bigdecimal);
            if (o.g(g1.f()))
            {
                g1 = new BigDecimal(g1.f());
            } else
            {
                g1 = c.ZERO;
            }
            tgtproductpricerange.d(g1);
            tgtproductpricerange.b(null);
            tgtproductpricerange.a(null);
            return tgtproductpricerange;
        }

        public ProductRecommendations a(d d1)
        {
            TGTProductRecommendations tgtproductrecommendations = new TGTProductRecommendations();
            tgtproductrecommendations.a(d1.a());
            tgtproductrecommendations.b(d1.b());
            ArrayList arraylist = new ArrayList();
            if (d1.c() != null)
            {
                for (d1 = d1.c().iterator(); d1.hasNext(); arraylist.add(a((g)d1.next()))) { }
            }
            tgtproductrecommendations.a(arraylist);
            return tgtproductrecommendations;
        }

        public volatile Object a(Object obj)
        {
            return a((d)obj);
        }

            
            {
                this$0 = h.this;
                super();
            }
    };

    public h(com.target.mothership.model.h h1)
    {
        super(h1);
    }

    protected ProductRecommendations a(d d1)
    {
        return (ProductRecommendations)mTransformer.a(d1);
    }

    public Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    public x b(x x)
    {
        return x;
    }
}
