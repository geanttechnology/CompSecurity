// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpfeaturereviews;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpfeaturereviews:
//            SIFeatureReviews

public class PDPFeaturesParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private SIFeatureReviews si;

    public PDPFeaturesParent()
    {
    }

    public SIFeatureReviews getSi()
    {
        return si;
    }

    public void setSi(SIFeatureReviews sifeaturereviews)
    {
        si = sifeaturereviews;
    }
}
