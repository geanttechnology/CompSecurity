// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.ui.fragment.product.common.PageItemHierarchy;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class k extends com.target.ui.analytics.b.a
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Browse;
        public static final a DeepLink;
        public static final a Query;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/b/k$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Browse = new a("Browse", 0);
            Query = new a("Query", 1);
            DeepLink = new a("DeepLink", 2);
            $VALUES = (new a[] {
                Browse, Query, DeepLink
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    public final long loadTimeMS;
    public final PageItemHierarchy pageItemHierarchy;
    public final ProductSummary productSummary;
    public final ProductSummaryParam productSummaryParam;
    public final a searchMethod;

    private k(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, a a1, long l)
    {
        productSummary = productsummary;
        productSummaryParam = productsummaryparam;
        pageItemHierarchy = pageitemhierarchy;
        searchMethod = a1;
        loadTimeMS = l;
    }

    public static k a(ProductSummary productsummary, long l)
    {
        return new k(productsummary, null, null, a.DeepLink, l);
    }

    public static k a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, long l)
    {
        return new k(productsummary, productsummaryparam, null, a.Query, l);
    }

    public static k a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, long l)
    {
        return new k(productsummary, productsummaryparam, pageitemhierarchy, a.Browse, l);
    }
}
