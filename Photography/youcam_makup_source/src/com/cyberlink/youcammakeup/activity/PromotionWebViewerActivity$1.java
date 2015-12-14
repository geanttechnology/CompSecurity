// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.utility.r;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            PromotionWebViewerActivity

class a
    implements r
{

    final PromotionWebViewerActivity a;

    public void a()
    {
        View view = a.findViewById(0x7f0c01fd);
        if (view != null)
        {
            view.performClick();
        }
    }

    (PromotionWebViewerActivity promotionwebvieweractivity)
    {
        a = promotionwebvieweractivity;
        super();
    }
}
