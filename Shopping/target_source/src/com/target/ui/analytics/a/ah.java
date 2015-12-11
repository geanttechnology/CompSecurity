// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            e, i, s, y

public class ah extends e
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ProductDetailPage;
        public static final a ProductListPage;
        public static final a SearchResults;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/ah$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ProductDetailPage = new a("ProductDetailPage", 0);
            ProductListPage = new a("ProductListPage", 1);
            SearchResults = new a("SearchResults", 2);
            $VALUES = (new a[] {
                ProductDetailPage, ProductListPage, SearchResults
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }


    private final a mLocation;
    private final PageItemHierarchy mPageItemHierarchy;

    private ah(a a1, PageItemHierarchy pageitemhierarchy)
    {
        mLocation = a1;
        mPageItemHierarchy = pageitemhierarchy;
    }

    public static ah a(a a1)
    {
        return new ah(a1, null);
    }

    public static ah a(a a1, PageItemHierarchy pageitemhierarchy)
    {
        return new ah(a1, pageitemhierarchy);
    }

    private String b(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$TapMapEvent$MapButtonLocation[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$TapMapEvent$MapButtonLocation = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapMapEvent$MapButtonLocation[a.ProductDetailPage.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapMapEvent$MapButtonLocation[a.ProductListPage.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$TapMapEvent$MapButtonLocation[a.SearchResults.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapMapEvent.MapButtonLocation[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "pdp";

        case 2: // '\002'
            return "plp";

        case 3: // '\003'
            return "srst";
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "screenTypeAbbr", b(mLocation));
        return map;
    }

    protected s c()
    {
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.TapMapEvent.MapButtonLocation[mLocation.ordinal()])
        {
        default:
            return s.Unknown;

        case 1: // '\001'
            return s.ProductDetails;

        case 2: // '\002'
            return s.ProductListing;

        case 3: // '\003'
            return s.SearchResults;
        }
    }

    protected List d()
    {
        if (mLocation == a.ProductDetailPage)
        {
            return com.target.ui.analytics.a.i.a(mPageItemHierarchy);
        } else
        {
            return Collections.emptyList();
        }
    }

    protected y i()
    {
        return y.MapInteraction;
    }
}
