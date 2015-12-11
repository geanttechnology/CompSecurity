// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item;

import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.model.c;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.page_item:
//            a, b

class d extends c
    implements a
{

    private b mPageItemLiveDataSource;

    public d()
    {
        mPageItemLiveDataSource = new b();
    }

    public void a(PageIdentifier pageidentifier, PageItemParams pageitemparams, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_category_page_items.json");
            mPageItemLiveDataSource.a(pageidentifier, pageitemparams, h1);
            return;
        }
    }

    public void a(PageItemParams pageitemparams, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_category_page_items.json");
            mPageItemLiveDataSource.a(pageitemparams, h1);
            return;
        }
    }

    public void b(PageItemParams pageitemparams, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_deals_page_items.json");
            mPageItemLiveDataSource.a(pageitemparams, h1);
            return;
        }
    }

    public void c(PageItemParams pageitemparams, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_featured_page_items.json");
            mPageItemLiveDataSource.a(pageitemparams, h1);
            return;
        }
    }
}
