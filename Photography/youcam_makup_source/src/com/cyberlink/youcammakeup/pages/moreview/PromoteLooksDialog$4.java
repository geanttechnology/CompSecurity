// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import com.cyberlink.youcammakeup.clflurry.YMKLooksPromotionItemEvent;
import com.cyberlink.youcammakeup.clflurry.ao;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            PromoteLooksDialog, aj

class a
    implements android.support.v4.view.eListener
{

    final PromoteLooksDialog a;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        MakeupItemMetadata makeupitemmetadata;
        String s;
        if (PromoteLooksDialog.i(a) != null)
        {
            if ((makeupitemmetadata = PromoteLooksDialog.i(a).b(i)) != null && makeupitemmetadata.b() != null && !(s = makeupitemmetadata.b()).isEmpty())
            {
                b.a(new ao(s));
                b.a(new YMKLooksPromotionItemEvent(com.cyberlink.youcammakeup.clflurry.Event.Operation.a, makeupitemmetadata.b(), makeupitemmetadata.c()));
                return;
            }
        }
    }

    Operation(PromoteLooksDialog promotelooksdialog)
    {
        a = promotelooksdialog;
        super();
    }
}
