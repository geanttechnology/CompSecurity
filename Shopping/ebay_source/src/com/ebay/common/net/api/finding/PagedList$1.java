// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;


// Referenced classes of package com.ebay.common.net.api.finding:
//            PagedList

class ge
    implements Runnable
{

    final PagedList this$0;
    final ge val$page;

    public void run()
    {
        PagedList.access$000(PagedList.this, val$page);
    }

    ge()
    {
        this$0 = final_pagedlist;
        val$page = ge.this;
        super();
    }
}
