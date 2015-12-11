// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.mothership.model.dvm.interfaces.DvmRemoteData;
import com.target.mothership.services.x;
import com.target.ui.util.q;
import com.target.ui.view.shop.PageItemLayout;
import java.util.Map;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

class emoteData
    implements com.target.ui.helper.g.nt._cls1
{

    final PageItemFragment this$0;
    final DvmRemoteData val$dvmRemoteData;

    public void b(DvmDataResponse dvmdataresponse)
    {
        if (PageItemFragment.a(PageItemFragment.this) == null)
        {
            return;
        } else
        {
            PageItemFragment.b(PageItemFragment.this).put(val$dvmRemoteData.a(), dvmdataresponse);
            PageItemFragment.a(PageItemFragment.this).pageItemLayout.a(val$dvmRemoteData.a(), dvmdataresponse);
            return;
        }
    }

    public void b(x x)
    {
        q.a(PageItemFragment.TAG, "Error retrieving dvm data");
    }

    public void n()
    {
        if (PageItemFragment.c(PageItemFragment.this) != null)
        {
            PageItemFragment.b(PageItemFragment.this, getString(0x7f0902fc));
        }
    }

    emoteData()
    {
        this$0 = final_pageitemfragment;
        val$dvmRemoteData = DvmRemoteData.this;
        super();
    }
}
