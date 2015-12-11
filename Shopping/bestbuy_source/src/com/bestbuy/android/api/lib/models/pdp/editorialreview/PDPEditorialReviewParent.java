// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.editorialreview;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdp.editorialreview:
//            PDPEditorialReviewSI

public class PDPEditorialReviewParent
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private PDPEditorialReviewSI si;

    public PDPEditorialReviewParent()
    {
    }

    public PDPEditorialReviewSI getSi()
    {
        return si;
    }

    public void setSi(PDPEditorialReviewSI pdpeditorialreviewsi)
    {
        si = pdpeditorialreviewsi;
    }
}
