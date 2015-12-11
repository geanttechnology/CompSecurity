// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item;

import com.target.mothership.b;
import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.model.a;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.page_item:
//            a, d, b

public class c extends a
    implements com.target.mothership.model.page_item.a
{

    private final com.target.mothership.model.page_item.a mPageItemDataSource;

    public c()
    {
        if (com.target.mothership.b.a().m())
        {
            mPageItemDataSource = new d();
            return;
        } else
        {
            mPageItemDataSource = new com.target.mothership.model.page_item.b();
            return;
        }
    }

    public void a(PageIdentifier pageidentifier, PageItemParams pageitemparams, h h)
    {
        mPageItemDataSource.a(pageidentifier, pageitemparams, h);
    }

    public void a(PageItemParams pageitemparams, h h)
    {
        mPageItemDataSource.a(pageitemparams, h);
    }

    public void b(PageItemParams pageitemparams, h h)
    {
        mPageItemDataSource.b(pageitemparams, h);
    }

    public void c(PageItemParams pageitemparams, h h)
    {
        mPageItemDataSource.c(pageitemparams, h);
    }
}
