// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.rtm;

import android.content.Context;
import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.common.net.api.rtm:
//            GetRtm

public static class initRtmContext extends initRtmContext
{

    private static final String operationName = "getRTMContent";

    public A(Context context, String s, long l, String s1, String s2, EbaySite ebaysite, 
            String s3, String s4)
    {
        super("CommonMobileAppServiceV2", true, "getRTMContent", context, s2, ebaysite, s3, s4, "20188");
        itemId = String.valueOf(l);
        categoryId = s1;
        title = s;
        adRequest = true;
        super.rotocol = "SOAP12";
        super.ersion = "1.1.0";
        initRtmContext(context);
    }
}
