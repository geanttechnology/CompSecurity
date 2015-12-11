// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice;

import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.bazaar_voice:
//            d, a

public class c extends com.target.mothership.model.c
    implements d
{

    private a mReviewLiveDataSource;

    public c()
    {
        mReviewLiveDataSource = new a();
    }

    public void a(com.target.mothership.common.params.c c1, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("product_review.json");
            mReviewLiveDataSource.a(c1, h1);
            return;
        }
    }
}
