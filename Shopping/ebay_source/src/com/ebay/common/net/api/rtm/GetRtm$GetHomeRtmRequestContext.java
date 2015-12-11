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

    public A(Context context, String s, String s1, String s2, String s3, EbaySite ebaysite, String s4, 
            String s5)
    {
        super("CommonMobileAppServiceV2", true, "getRTMContent", context, s3, ebaysite, s4, s5, "19792");
        adRequest = true;
        placementId = s;
        promoPlacementId = s1;
        promoCguid = s2;
    }
}
