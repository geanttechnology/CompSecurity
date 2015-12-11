// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.e.a;

import android.support.v4.f.a;
import com.target.mothership.common.params.ProductRecommendationsParam;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.CategoryId;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.common.product.ProductIdentifier;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.common.product.p;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.e.e.a:
//            a

public class b extends e
{

    private static final com.target.mothership.services.f.a.a CATEGORY_ID = new com.target.mothership.services.f.a.a("categoryId");
    private static final com.target.mothership.services.f.a.a CHANNEL = new com.target.mothership.services.f.a.a("channel");
    private static final String COMMA = ",";
    private static final com.target.mothership.services.f.a.a ENDECA_ID = new com.target.mothership.services.f.a.a("endecaId");
    private static final com.target.mothership.services.f.a.a FACETS = new com.target.mothership.services.f.a.a("facets");
    private static final c GET_BLACK_FRIDAY_PRICES;
    public static final String HEADER_REQUIRED_STORE_INFO_KEY = "X-REQUIRE-STORE-INFO";
    private static final com.target.mothership.services.f.a.a ID = new com.target.mothership.services.f.a.a("id");
    private static final com.target.mothership.services.f.a.a ID_TYPE = new com.target.mothership.services.f.a.a("id-type");
    private static final com.target.mothership.services.f.a.a LIMIT = new com.target.mothership.services.f.a.a("limit");
    private static final com.target.mothership.services.f.a.a MAX_PRICE = new com.target.mothership.services.f.a.a("maxPrice");
    private static final com.target.mothership.services.f.a.a MIN_PRICE = new com.target.mothership.services.f.a.a("minPrice");
    private static final com.target.mothership.services.f.a.a OFFSET = new com.target.mothership.services.f.a.a("offset");
    private static final com.target.mothership.services.f.a.a PAGE_NO = new com.target.mothership.services.f.a.a("pageNumber");
    private static final c PRODUCT_DEALS;
    private static final c PRODUCT_DEALS_WITH_STORE;
    private static final c PRODUCT_DETAILS;
    private static final c PRODUCT_DETAILS_WITH_STORE;
    private static final c PRODUCT_RECOMMENDATIONS;
    private static final c PRODUCT_SUMMARY;
    private static final c PRODUCT_SUMMARY_LIST;
    private static final c PRODUCT_SUMMARY_LIST_WITH_STORE;
    private static final c PRODUCT_SUMMARY_WITH_STORE;
    private static final String RECOMMENDATION_CATEGORY_ID = "categoryId";
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_CONTEXT = new com.target.mothership.services.f.a.a("context");
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_GUEST_ID = new com.target.mothership.services.f.a.a("visId");
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_MAX_LIMIT = new com.target.mothership.services.f.a.a("max");
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_MIN_LIMIT = new com.target.mothership.services.f.a.a("min");
    private static final String RECOMMENDATION_PLACEMENT_ID = "placementId";
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_PRODUCT_IDS = new com.target.mothership.services.f.a.a("productId");
    private static final com.target.mothership.services.f.a.a RECOMMENDATION_SEARCH_TERM = new com.target.mothership.services.f.a.a("searchTerm");
    private static final com.target.mothership.services.f.a.a SEARCH_TERM = new com.target.mothership.services.f.a.a("searchTerm");
    private static final String SEMICOLAN = ";";
    private static final String SEPARATOR = "Z";
    private static final com.target.mothership.services.f.a.a SORT_BY = new com.target.mothership.services.f.a.a("sortBy");
    private static final com.target.mothership.services.f.a.a STORE_ID = new com.target.mothership.services.f.a.a("store-id");
    private static final String STRING_BARCODE = "BARCODE";
    private static final String STRING_DPCI = "DPCI";
    public static final String STRING_FALSE = "false";
    private static final String STRING_TCIN = "TCIN";
    public static final String STRING_TRUE = "true";
    private static final com.target.mothership.services.f.a.a X_REQUIRE_STORE_INFO_HEADER = new com.target.mothership.services.f.a.a("X-REQUIRE-STORE-INFO");

    public b(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private com.target.mothership.services.f.a.b a()
    {
        return a(PRODUCT_RECOMMENDATIONS, null, null, null, null);
    }

    private String a(com.target.mothership.common.product.ProductIdentifier.a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$params$ProductRecommendationsParam$RecommendationType[];
            static final int $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType = new int[com.target.mothership.common.product.ProductIdentifier.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.TCIN.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.DPCI.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$mothership$common$product$ProductIdentifier$ProductIdType[com.target.mothership.common.product.ProductIdentifier.a.BARCODE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                $SwitchMap$com$target$mothership$common$params$ProductRecommendationsParam$RecommendationType = new int[com.target.mothership.common.params.ProductRecommendationsParam.a.values().length];
                try
                {
                    $SwitchMap$com$target$mothership$common$params$ProductRecommendationsParam$RecommendationType[com.target.mothership.common.params.ProductRecommendationsParam.a.DEFAULT_RECOMMENDATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.mothership.common.product.ProductIdentifier.ProductIdType[a1.ordinal()])
        {
        default:
            throw new IllegalArgumentException(String.format("<%s> is not a supported input for ProductIdentifier. Allowed types are <%s, %s, %s>", new Object[] {
                a1.toString(), "TCIN", "DPCI", "BARCODE"
            }));

        case 1: // '\001'
            return "TCIN";

        case 2: // '\002'
            return "DPCI";

        case 3: // '\003'
            return "BARCODE";
        }
    }

    private String a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((Tcin)list.next()).b())) { }
        return o.a(arraylist, ",");
    }

    private Map a(boolean flag)
    {
        a a1 = new a();
        String s1 = X_REQUIRE_STORE_INFO_HEADER.a();
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        a1.put(s1, s);
        return a1;
    }

    private String b(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((ProductIdentifier)list.next()).b())) { }
        return o.a(arraylist, ",");
    }

    private Map c(ProductSummaryParam productsummaryparam)
    {
        a a1 = new a();
        if (productsummaryparam == null)
        {
            return a1;
        }
        if (productsummaryparam.e().b())
        {
            a1.put(SEARCH_TERM.a(), productsummaryparam.e().c());
        }
        if (productsummaryparam.c().b())
        {
            a1.put(CATEGORY_ID.a(), ((CategoryId)productsummaryparam.c().c()).a());
        }
        if (productsummaryparam.d().b())
        {
            a1.put(ENDECA_ID.a(), ((EndecaId)productsummaryparam.d().c()).a());
        }
        if (productsummaryparam.g().b())
        {
            a1.put(SORT_BY.a(), ((p)productsummaryparam.g().c()).toString());
        }
        if (productsummaryparam.h().b())
        {
            a1.put(MAX_PRICE.a(), productsummaryparam.h().c());
        }
        if (productsummaryparam.i().b())
        {
            a1.put(MIN_PRICE.a(), productsummaryparam.i().c());
        }
        a1.put(FACETS.a(), o.a(productsummaryparam.j(), "Z"));
        if (productsummaryparam.k().b())
        {
            a1.put(PAGE_NO.a(), Integer.toString(((Integer)productsummaryparam.k().c()).intValue()));
        }
        if (productsummaryparam.l().b())
        {
            a1.put(CHANNEL.a(), productsummaryparam.l().c());
        }
        if (productsummaryparam.m().b())
        {
            a1.put(OFFSET.a(), Integer.toString(((Integer)productsummaryparam.m().c()).intValue()));
        }
        if (productsummaryparam.n().b())
        {
            a1.put(LIMIT.a(), Integer.toString(((Integer)productsummaryparam.n().c()).intValue()));
        }
        return a1;
    }

    public com.target.mothership.services.f.a.b a(ProductRecommendationsParam productrecommendationsparam)
    {
        if (productrecommendationsparam == null)
        {
            return a();
        }
        switch (_cls1..SwitchMap.com.target.mothership.common.params.ProductRecommendationsParam.RecommendationType[productrecommendationsparam.a().ordinal()])
        {
        default:
            a a1 = new a();
            if (!productrecommendationsparam.d().isEmpty())
            {
                a1.put(RECOMMENDATION_PRODUCT_IDS.a(), a(productrecommendationsparam.d()));
            }
            if (productrecommendationsparam.e().b())
            {
                a1.put(RECOMMENDATION_SEARCH_TERM.a(), productrecommendationsparam.e().c());
            }
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("placementId");
            stringbuilder.append(",");
            stringbuilder.append(productrecommendationsparam.a().toString());
            if (productrecommendationsparam.f().b())
            {
                stringbuilder.append(";");
                stringbuilder.append("categoryId");
                stringbuilder.append(",");
                stringbuilder.append(((CategoryId)productrecommendationsparam.f().c()).a());
            }
            a1.put(RECOMMENDATION_CONTEXT.a(), stringbuilder.toString());
            if (productrecommendationsparam.b().b())
            {
                a1.put(RECOMMENDATION_MIN_LIMIT.a(), ((Integer)productrecommendationsparam.b().c()).toString());
            }
            if (productrecommendationsparam.c().b())
            {
                a1.put(RECOMMENDATION_MAX_LIMIT.a(), ((Integer)productrecommendationsparam.c().c()).toString());
            }
            if (productrecommendationsparam.g().b())
            {
                a1.put(RECOMMENDATION_GUEST_ID.a(), ((Guest)productrecommendationsparam.g().c()).getGuestId());
            }
            return a(PRODUCT_RECOMMENDATIONS, null, null, ((Map) (a1)), null);

        case 1: // '\001'
            return a();
        }
    }

    public com.target.mothership.services.f.a.b a(ProductSummaryParam productsummaryparam)
    {
        Map map = c(productsummaryparam);
        a a1 = new a();
        Map map1 = a(productsummaryparam.f());
        if (productsummaryparam.a() != null)
        {
            a1.put(STORE_ID.b(), productsummaryparam.a());
            productsummaryparam = PRODUCT_DEALS_WITH_STORE;
        } else
        {
            productsummaryparam = PRODUCT_DEALS;
        }
        return a(((c) (productsummaryparam)), null, ((Map) (a1)), map, map1);
    }

    public com.target.mothership.services.f.a.b a(com.target.mothership.services.e.e.a.a a1)
    {
        a a2 = new a();
        a2.put(ID_TYPE.b(), a(a1.a()));
        a2.put(ID.b(), b(a1.b()));
        Map map = a(a1.d());
        if (a1.c() != null)
        {
            a2.put(STORE_ID.b(), a1.c());
            a1 = PRODUCT_DETAILS_WITH_STORE;
        } else
        {
            a1 = PRODUCT_DETAILS;
        }
        return a(((c) (a1)), null, ((Map) (a2)), null, map);
    }

    public com.target.mothership.services.f.a.b a(String s)
    {
        c c1 = GET_BLACK_FRIDAY_PRICES;
        a a1 = new a();
        a1.put(STORE_ID.b(), s);
        return a(c1, null, ((Map) (a1)), null, null);
    }

    public com.target.mothership.services.f.a.b b(ProductSummaryParam productsummaryparam)
    {
        Map map = c(productsummaryparam);
        a a1 = new a();
        Map map1 = a(productsummaryparam.f());
        if (productsummaryparam.a() != null)
        {
            a1.put(STORE_ID.b(), productsummaryparam.a());
            productsummaryparam = PRODUCT_SUMMARY_WITH_STORE;
        } else
        {
            productsummaryparam = PRODUCT_SUMMARY;
        }
        return a(productsummaryparam, null, a1, map, map1);
    }

    public com.target.mothership.services.f.a.b b(com.target.mothership.services.e.e.a.a a1)
    {
        a a2 = new a();
        a2.put(ID_TYPE.b(), a(a1.a()));
        a2.put(ID.b(), b(a1.b()));
        Map map = a(a1.d());
        if (a1.c() != null)
        {
            a2.put(STORE_ID.b(), a1.c());
            a1 = PRODUCT_SUMMARY_LIST_WITH_STORE;
        } else
        {
            a1 = PRODUCT_SUMMARY_LIST;
        }
        return a(a1, null, a2, null, map);
    }

    static 
    {
        PRODUCT_DEALS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/deals");
        PRODUCT_DEALS_WITH_STORE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/deals/{store-id}");
        PRODUCT_DETAILS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/pdp/{id-type}/{id}");
        PRODUCT_DETAILS_WITH_STORE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/pdp/{id-type}/{id}/{store-id}");
        PRODUCT_SUMMARY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/list");
        PRODUCT_SUMMARY_WITH_STORE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/list/{store-id}");
        PRODUCT_SUMMARY_LIST = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/list/{id-type}/{id}");
        PRODUCT_SUMMARY_LIST_WITH_STORE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/products/list/{id-type}/{id}/{store-id}");
        PRODUCT_RECOMMENDATIONS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.PrzSecure, "/recommendations/v1/");
        GET_BLACK_FRIDAY_PRICES = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.TGTAppData, "/v1/black-friday-prices/{store-id}");
    }
}
