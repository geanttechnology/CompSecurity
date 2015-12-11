// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpreviews;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpreviews:
//            SIReviews

public class PDPReviewsParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIReviews si;

    public PDPReviewsParent()
    {
    }

    public SIReviews getSi()
    {
        return si;
    }

    public void setSi(SIReviews sireviews)
    {
        si = sireviews;
    }
}
