// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.a;

import com.target.ui.util.deep_link.PromotionParams;

// Referenced classes of package com.target.ui.fragment.shop.a:
//            a

public class b
    implements a
{

    private a.a mListener;

    public b(a.a a1)
    {
        mListener = a1;
    }

    public void a(PromotionParams promotionparams)
    {
        mListener.c(promotionparams);
    }
}
