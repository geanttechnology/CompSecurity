// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.content.Context;
import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm

public static class promoCguid extends promoCguid
{

    private static final String operationName = "getRTMContent";

    public (Context context, String s, String s1, EbaySite ebaysite, String s2, String s3)
    {
        super("CommonMobileAppServiceV2", true, "getRTMContent", context, s1, ebaysite, s2, s3, "19792");
        adRequest = false;
        promoPlacementId = s;
        promoCguid = s3;
    }
}
