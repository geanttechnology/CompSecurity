// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.handler;

import android.graphics.Color;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.g;
import com.target.mothership.model.common.TGTDvmRemoteData;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.ProductExtendedData;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.mothership.model.product.interfaces.ProductSummaryWrapper;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.e.b.b;
import com.target.mothership.services.e.e.b.b.a;
import com.target.mothership.services.e.e.b.b.c;
import com.target.mothership.services.e.e.b.b.d;
import com.target.mothership.services.e.e.b.b.f;
import com.target.mothership.services.e.e.b.e;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.product.handler:
//            e, TGTProductSummary, TGTProductDetails, TGTProductFacet, 
//            TGTProductEntry, TGTProductExtendedData, TGTProductRgbValue, TGTProductFacetPrice, 
//            TGTProductSummaryWrapper

public class l extends com.target.mothership.model.product.handler.e
{

    private static final String TAG = com/target/mothership/model/product/handler/l.getSimpleName();
    private final aa mTransformer = new aa() {

        final l this$0;

        public ProductSummaryWrapper a(com.target.mothership.services.e.e.b.f f1)
        {
            TGTProductSummaryWrapper tgtproductsummarywrapper = new TGTProductSummaryWrapper();
            tgtproductsummarywrapper.a(f1.a());
            tgtproductsummarywrapper.a(com.target.mothership.model.product.handler.l.a(l.this, f1.b()));
            return tgtproductsummarywrapper;
        }

        public volatile Object a(Object obj)
        {
            return a((com.target.mothership.services.e.e.b.f)obj);
        }

            
            {
                this$0 = l.this;
                super();
            }
    };

    public l(h h)
    {
        super(h);
    }

    static ProductSummary a(l l1, e e1)
    {
        return l1.a(e1);
    }

    private ProductSummary a(e e1)
    {
        Object obj1 = null;
        boolean flag = false;
        TGTProductSummary tgtproductsummary = new TGTProductSummary();
        Object obj = new ArrayList();
        Object obj2 = e1.a();
        if (obj2 != null)
        {
            TGTProductDetails tgtproductdetails;
            for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj)).add(tgtproductdetails))
            {
                b b1 = (b)((Iterator) (obj2)).next();
                tgtproductdetails = new TGTProductDetails();
                a(tgtproductdetails, b1);
            }

        }
        tgtproductsummary.a(((List) (obj)));
        obj = new ArrayList();
        double d1;
        int i;
        int j;
        int k;
        if (e1.b() != null)
        {
            a(((List) (obj)), e1.b());
        } else
        {
            obj = null;
        }
        tgtproductsummary.b(((List) (obj)));
        if (e1.d() != null)
        {
            obj = new ArrayList();
            b(((List) (obj)), e1.d());
            tgtproductsummary.e(((List) (obj)));
        } else
        {
            tgtproductsummary.e(null);
        }
        if (e1.c() != null)
        {
            obj = new ArrayList();
            b(((List) (obj)), e1.c());
            tgtproductsummary.d(((List) (obj)));
        } else
        {
            tgtproductsummary.d(null);
        }
        obj2 = new ArrayList();
        obj = obj1;
        if (e1.e() != null)
        {
            obj = obj1;
            if (e1.e().size() > 0)
            {
                obj = obj1;
                if (((com.target.mothership.services.e.e.b.b.e)e1.e().get(0)).a() != null)
                {
                    a(((List) (obj2)), ((com.target.mothership.services.e.e.b.b.e)e1.e().get(0)).a());
                    obj = obj2;
                }
            }
        }
        tgtproductsummary.c(((List) (obj)));
        tgtproductsummary.a(e1.f().booleanValue());
        NumberFormatException numberformatexception;
        if (e1.g() != null)
        {
            j = Integer.valueOf(e1.g()).intValue();
        } else
        {
            j = 0;
        }
        tgtproductsummary.a(j);
        if (e1.h() != null)
        {
            k = Integer.valueOf(e1.h()).intValue();
        } else
        {
            k = 0;
        }
        tgtproductsummary.b(k);
        if (e1.i() != null)
        {
            tgtproductsummary.c(Integer.valueOf(e1.i()).intValue());
        } else
        {
            tgtproductsummary.c(0);
        }
        tgtproductsummary.a(e1.j());
        tgtproductsummary.a(e1.k());
        if (e1.i() == null && e1.g() == null)
        {
            break MISSING_BLOCK_LABEL_588;
        }
        if (e1.l() != null) goto _L2; else goto _L1
_L1:
        d1 = 0.0D;
        i = Integer.valueOf(e1.i()).intValue() / Integer.valueOf(e1.g()).intValue();
        d1 = i;
_L3:
        i = (int)Math.ceil(d1);
_L4:
        tgtproductsummary.d(i);
        if (e1.m() != null)
        {
            obj = new TGTDvmRemoteData();
            ((TGTDvmRemoteData) (obj)).a(e1.m());
            tgtproductsummary.a(((com.target.mothership.model.dvm.interfaces.DvmRemoteData) (obj)));
        }
        i = ((flag) ? 1 : 0);
        if (j > 0)
        {
            i = (int)Math.ceil((float)k / (float)j);
        }
        tgtproductsummary.e(i);
        return tgtproductsummary;
        numberformatexception;
        com.target.a.a.b.a(TAG, "Exception while parsing for the page number");
          goto _L3
_L2:
        i = Integer.valueOf(e1.l()).intValue();
          goto _L4
        i = 0;
          goto _L4
    }

    private void a(List list, List list1)
    {
        list1 = list1.iterator();
_L6:
        if (!list1.hasNext()) goto _L2; else goto _L1
_L1:
        TGTProductFacet tgtproductfacet;
        ArrayList arraylist;
        Object obj;
        obj = (c)list1.next();
        tgtproductfacet = new TGTProductFacet();
        arraylist = new ArrayList();
        obj = ((c) (obj)).a();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((List) (obj)).iterator();
_L5:
        TGTProductEntry tgtproductentry;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj1 = (a)((Iterator) (obj)).next();
        tgtproductentry = new TGTProductEntry();
        Object obj2 = new ArrayList();
        Object obj3 = ((a) (obj1)).a();
        if (obj3 != null)
        {
            TGTProductExtendedData tgtproductextendeddata;
            for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj2)).add(tgtproductextendeddata))
            {
                com.target.mothership.services.e.e.b.b.b b1 = (com.target.mothership.services.e.e.b.b.b)((Iterator) (obj3)).next();
                tgtproductextendeddata = new TGTProductExtendedData();
                tgtproductextendeddata.a(b1.a());
                tgtproductextendeddata.b(b1.b());
            }

        }
        tgtproductentry.a(((List) (obj2)));
        tgtproductentry.a(((a) (obj1)).b());
        tgtproductentry.a(((a) (obj1)).c());
        tgtproductentry.b(((a) (obj1)).d());
label0:
        do
        {
label1:
            {
                for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext();)
                {
                    ProductExtendedData productextendeddata = (ProductExtendedData)((Iterator) (obj2)).next();
                    if (productextendeddata.a() != null && o.g(productextendeddata.b()))
                    {
                        static class _cls2
                        {

                            static final int $SwitchMap$com$target$mothership$common$product$FacetKey[];

                            static 
                            {
                                $SwitchMap$com$target$mothership$common$product$FacetKey = new int[g.values().length];
                                try
                                {
                                    $SwitchMap$com$target$mothership$common$product$FacetKey[g.CATEGORY_ID.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$target$mothership$common$product$FacetKey[g.ENDECA_ID.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls2..SwitchMap.com.target.mothership.common.product.FacetKey[productextendeddata.a().ordinal()])
                        {
                        case 1: // '\001'
                            tgtproductentry.a(new CategoryId(productextendeddata.b()));
                            break;

                        case 2: // '\002'
                            tgtproductentry.a(new EndecaId(productextendeddata.b()));
                            break;
                        }
                        continue label0;
                    }
                }

                obj2 = new ArrayList();
                obj1 = ((a) (obj1)).e();
                if (obj1 != null)
                {
                    TGTProductRgbValue tgtproductrgbvalue;
                    for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj2)).add(tgtproductrgbvalue))
                    {
                        f f1 = (f)((Iterator) (obj1)).next();
                        tgtproductrgbvalue = new TGTProductRgbValue();
                        tgtproductrgbvalue.a(f1.a());
                        tgtproductrgbvalue.b(f1.b());
                        tgtproductrgbvalue.c(f1.c());
                        tgtproductrgbvalue.a(String.format("#%02x%02x%02x", new Object[] {
                            Integer.valueOf(f1.a()), Integer.valueOf(f1.b()), Integer.valueOf(f1.c())
                        }));
                        tgtproductrgbvalue.d(Color.rgb(f1.a(), f1.b(), f1.c()));
                    }

                }
                tgtproductentry.b(((List) (obj2)));
                break label1;
            }
        } while (true);
        arraylist.add(tgtproductentry);
        if (true) goto _L5; else goto _L4
_L4:
        tgtproductfacet.a(arraylist);
        list.add(tgtproductfacet);
          goto _L6
_L2:
    }

    private void b(List list, List list1)
    {
        TGTProductFacetPrice tgtproductfacetprice;
        for (list1 = list1.iterator(); list1.hasNext(); list.add(tgtproductfacetprice))
        {
            d d1 = (d)list1.next();
            tgtproductfacetprice = new TGTProductFacetPrice();
            tgtproductfacetprice.a(d1.a());
            tgtproductfacetprice.a(d1.b());
            tgtproductfacetprice.a(d1.c());
        }

    }

    protected ProductSummaryWrapper a(com.target.mothership.services.e.e.b.f f1)
    {
        return (ProductSummaryWrapper)mTransformer.a(f1);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.e.e.b.f)obj);
    }

}
