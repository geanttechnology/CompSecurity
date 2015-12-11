// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item;

import com.target.mothership.common.page_item.PageIdentifier;
import com.target.mothership.common.params.PageItemParams;
import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.e.d.c.a;

// Referenced classes of package com.target.mothership.model.page_item:
//            a

public class b
    implements com.target.mothership.model.page_item.a
{

    private final a mService = new a();

    public b()
    {
    }

    public void a(PageIdentifier pageidentifier, PageItemParams pageitemparams, h h)
    {
        h = new e(new com.target.mothership.model.page_item.handler.a(h));
        mService.a(pageidentifier.a(), pageitemparams, h);
    }

    public void a(PageItemParams pageitemparams, h h)
    {
        h = new e(new com.target.mothership.model.page_item.handler.a(h));
        mService.a(pageitemparams, h);
    }

    public void b(PageItemParams pageitemparams, h h)
    {
        h = new e(new com.target.mothership.model.page_item.handler.a(h));
        mService.b(pageitemparams, h);
    }

    public void c(PageItemParams pageitemparams, h h)
    {
        h = new e(new com.target.mothership.model.page_item.handler.a(h));
        mService.c(pageitemparams, h);
    }
}
