// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.itemview;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;

// Referenced classes of package com.ebay.mobile.itemview:
//            ProductReviewsDataManager

public static final class ebayCountry
{

    public final EbayCountry ebayCountry;
    public final int maxResultsPerPage;
    public final int pageNumber;
    public final String subjectReferenceId;
    public final Authentication user;

    public String toString()
    {
        return (new StringBuilder()).append("maxResultsPerPage: ").append(maxResultsPerPage).append(", ").append("pageNumber: ").append(pageNumber).append(", ").append("subjectReferenceId: ").append(subjectReferenceId).toString();
    }

    public (String s, int i, int j, Authentication authentication, EbayCountry ebaycountry)
    {
        if (ebaycountry == null || TextUtils.isEmpty(s) || i <= 0)
        {
            throw new IllegalArgumentException("invalid argument");
        } else
        {
            maxResultsPerPage = j;
            pageNumber = i;
            subjectReferenceId = s;
            user = authentication;
            ebayCountry = ebaycountry;
            return;
        }
    }
}
