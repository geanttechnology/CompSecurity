// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.product.interfaces.ProductSummary;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, i, s

class be extends f
{
    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a PointInside;
        public static final a Target;

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/target/ui/analytics/a/be$a, s1);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            PointInside = new a("PointInside", 0);
            Target = new a("Target", 1);
            $VALUES = (new a[] {
                PointInside, Target
            });
        }

        private a(String s1, int j)
        {
            super(s1, j);
        }
    }

    static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b Browse;
        public static final b DeepLink;
        public static final b Query;

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/target/ui/analytics/a/be$b, s1);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            Browse = new b("Browse", 0);
            Query = new b("Query", 1);
            DeepLink = new b("DeepLink", 2);
            $VALUES = (new b[] {
                Browse, Query, DeepLink
            });
        }

        private b(String s1, int j)
        {
            super(s1, j);
        }
    }


    private static final String PAGE_NUMBER_PREFIX = "page ";
    private final long mLoadTimeMS;
    private final PageItemHierarchy mPageItemHierarchy;
    private final ProductSummary mProductSummary;
    private final ProductSummaryParam mProductSummaryParam;
    private final a mSearchEndpoint;
    private final b mSearchMethod;

    private be(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, a a1, b b1, long l)
    {
        mProductSummary = productsummary;
        mProductSummaryParam = productsummaryparam;
        mPageItemHierarchy = pageitemhierarchy;
        mSearchEndpoint = a1;
        mSearchMethod = b1;
        mLoadTimeMS = l;
    }

    static be a(ProductSummary productsummary, long l)
    {
        return new be(productsummary, null, null, null, b.DeepLink, l);
    }

    static be a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, long l)
    {
        return new be(productsummary, productsummaryparam, null, a.Target, b.Query, l);
    }

    static be a(ProductSummary productsummary, ProductSummaryParam productsummaryparam, PageItemHierarchy pageitemhierarchy, long l)
    {
        return new be(productsummary, productsummaryparam, pageitemhierarchy, null, b.Browse, l);
    }

    private static String a(ProductSummaryParam productsummaryparam)
    {
        if (productsummaryparam == null)
        {
            return "";
        }
        if (!productsummaryparam.e().b())
        {
            return "";
        } else
        {
            return (String)productsummaryparam.e().c();
        }
    }

    private static String a(ProductSummary productsummary)
    {
        if (productsummary == null || productsummary.a().isEmpty())
        {
            return "";
        } else
        {
            return com.target.ui.analytics.a.i.a(productsummary.a(), Integer.valueOf(productsummary.e()));
        }
    }

    private static String a(a a1)
    {
        if (a1 == null)
        {
            return "";
        }
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchEndpoint[];
            static final int $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchMethod[];

            static 
            {
                $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchEndpoint = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchEndpoint[a.PointInside.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchEndpoint[a.Target.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchMethod = new int[b.values().length];
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchMethod[b.Browse.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchMethod[b.Query.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$analytics$brighttag$ViewPLPEvent$SearchMethod[b.DeepLink.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.ViewPLPEvent.SearchEndpoint[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "Point Inside";

        case 2: // '\002'
            return "Endeca";
        }
    }

    private static String a(b b1)
    {
        if (b1 == null)
        {
            return "";
        }
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.ViewPLPEvent.SearchMethod[b1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "browse";

        case 2: // '\002'
            return "search";
        }
    }

    private static String a(b b1, ProductSummary productsummary)
    {
        if (b1 == null)
        {
            return "";
        }
        if (productsummary == null || productsummary.a().isEmpty())
        {
            return "";
        }
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.ViewPLPEvent.SearchMethod[b1.ordinal()])
        {
        default:
            return "";

        case 2: // '\002'
            return "successfulSearch";
        }
    }

    private static List a(PageItemHierarchy pageitemhierarchy)
    {
        ArrayList arraylist = new ArrayList();
        if (pageitemhierarchy == null)
        {
            return arraylist;
        }
        Iterator iterator = pageitemhierarchy.b().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            PageItem pageitem = (PageItem)iterator.next();
            if (pageitem.g().b())
            {
                arraylist.add(pageitem.g().c());
            }
        } while (true);
        if (pageitemhierarchy.a().g().b())
        {
            arraylist.add(pageitemhierarchy.a().g().c());
        }
        return arraylist;
    }

    private static String b(ProductSummary productsummary)
    {
        if (productsummary == null)
        {
            return "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("page ");
            stringbuilder.append(String.valueOf(productsummary.h()));
            return stringbuilder.toString();
        }
    }

    private static String c(ProductSummary productsummary)
    {
        if (productsummary == null || productsummary.a().isEmpty())
        {
            return String.valueOf(0);
        } else
        {
            return String.valueOf(productsummary.a().size());
        }
    }

    protected Map b()
    {
        Map map = super.b();
        com.target.ui.analytics.a.i.a(map, "products", a(mProductSummary));
        com.target.ui.analytics.a.i.a(map, "listPagination", b(mProductSummary));
        com.target.ui.analytics.a.i.a(map, "productsLoaded", c(mProductSummary));
        com.target.ui.analytics.a.i.a(map, "internalSearchTerm", a(mProductSummaryParam));
        com.target.ui.analytics.a.i.a(map, "internalSearchResults", String.valueOf(mProductSummary.f()));
        com.target.ui.analytics.a.i.a(map, "internalSearchEngine", a(mSearchEndpoint));
        com.target.ui.analytics.a.i.a(map, "productFindingMethod", a(mSearchMethod));
        com.target.ui.analytics.a.i.a(map, "events", a(mSearchMethod, mProductSummary));
        return map;
    }

    protected s c()
    {
        boolean flag = true;
        if (mProductSummary.h() <= 1)
        {
            flag = false;
        }
        switch (_cls1..SwitchMap.com.target.ui.analytics.brighttag.ViewPLPEvent.SearchMethod[mSearchMethod.ordinal()])
        {
        default:
            return s.ProductListing;

        case 1: // '\001'
            if (flag)
            {
                return s.BrowseResultsMore;
            } else
            {
                return s.Browse;
            }

        case 2: // '\002'
            break;
        }
        if (flag)
        {
            return s.SearchResultsMore;
        } else
        {
            return s.SearchResults;
        }
    }

    protected List d()
    {
        if (mSearchMethod == b.Browse)
        {
            return a(mPageItemHierarchy);
        } else
        {
            return Collections.emptyList();
        }
    }

    protected Long i()
    {
        return Long.valueOf(mLoadTimeMS);
    }
}
