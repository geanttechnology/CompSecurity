// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.common.model:
//            FindProductReviewsAndGuidesData

public static class reviews
{

    public float averageRating;
    public List reviews;

    public I()
    {
        reviews = new LinkedList();
    }
}
