// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.net.Uri;
import android.support.v4.app.Fragment;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.util.o;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.shop.ChildPageItemFragment;
import com.target.ui.util.deep_link.f;
import com.target.ui.util.deep_link.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class y
{

    public static int a(List list, PageItem pageitem)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (a((PageItem)list.get(i), pageitem))
            {
                return i;
            }
        }

        return -1;
    }

    public static Fragment a(PageItem pageitem, Store store, List list, PageItemHierarchy pageitemhierarchy)
    {
        boolean flag = pageitem.c().b();
        if (a(pageitem, list))
        {
            pageitemhierarchy = b(pageitem, pageitemhierarchy);
        } else
        {
            pageitemhierarchy = a(pageitem, pageitemhierarchy);
        }
        if (flag)
        {
            pageitem = ChildPageItemFragment.a(pageitem, list);
            pageitem.a(pageitemhierarchy);
            return pageitem;
        }
        if (!pageitem.a().b())
        {
            return null;
        }
        pageitem = Uri.parse(((Action)pageitem.a().c()).b());
        if (!g.c(pageitem))
        {
            return null;
        }
        pageitem = (Fragment)g.a(pageitem, store).d().d();
        if (pageitem != null && (pageitem instanceof ProductSummaryPageFragment))
        {
            pageitem = (ProductSummaryPageFragment)pageitem;
            pageitem.a(list);
            pageitem.a(pageitemhierarchy);
            return pageitem;
        } else
        {
            return null;
        }
    }

    public static PageItemHierarchy a(PageItem pageitem, PageItemHierarchy pageitemhierarchy)
    {
        if (pageitemhierarchy == null)
        {
            return new PageItemHierarchy(pageitem, null);
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(pageitemhierarchy.b());
            arraylist.add(pageitemhierarchy.a());
            return new PageItemHierarchy(pageitem, arraylist);
        }
    }

    public static String a(PageItem pageitem)
    {
        if (pageitem.g().b())
        {
            return (String)pageitem.g().c();
        }
        if (pageitem.h().b() && ((ImageInfo)pageitem.h().c()).a().b())
        {
            return (String)((ImageInfo)pageitem.h().c()).a().c();
        } else
        {
            return "";
        }
    }

    public static List a(List list)
    {
        if (list == null)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            PageItem pageitem = (PageItem)list.next();
            if (o.g(a(pageitem)) && (pageitem.c().b() || pageitem.a().b() && g.d(Uri.parse(((Action)pageitem.a().c()).b()))))
            {
                arraylist.add(pageitem);
            }
        } while (true);
        return arraylist;
    }

    public static boolean a(Action action)
    {
        if (action == null)
        {
            return false;
        }
        boolean flag;
        if (o.g(action.b()) || action.a().b() && o.g((String)action.a().c()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public static boolean a(PageItem pageitem, PageItem pageitem1)
    {
        if (!pageitem.g().b() && !pageitem1.g().b())
        {
            return b(pageitem, pageitem1);
        }
        if (!pageitem.g().b() || !pageitem1.g().b())
        {
            return false;
        }
        if (!((String)pageitem.g().c()).equals(pageitem1.g().c()))
        {
            return false;
        } else
        {
            return b(pageitem, pageitem1);
        }
    }

    private static boolean a(PageItem pageitem, List list)
    {
        if (pageitem == null)
        {
            return false;
        }
        if (list == null || list.isEmpty())
        {
            return false;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            if (pageitem.equals((PageItem)list.next()))
            {
                return true;
            }
        }

        return false;
    }

    public static PageItemHierarchy b(PageItem pageitem, PageItemHierarchy pageitemhierarchy)
    {
        if (pageitemhierarchy == null)
        {
            return new PageItemHierarchy(pageitem, null);
        } else
        {
            return new PageItemHierarchy(pageitem, pageitemhierarchy.b());
        }
    }

    private static boolean b(PageItem pageitem, PageItem pageitem1)
    {
        if (!pageitem.a().b() && !pageitem1.a().b())
        {
            return true;
        }
        if (!pageitem.a().b() || !pageitem1.a().b())
        {
            return false;
        } else
        {
            return ((Action)pageitem.a().c()).b().equals(((Action)pageitem1.a().c()).b());
        }
    }
}
