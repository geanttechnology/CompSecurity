// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.cal;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.EbaySoaRequest;

// Referenced classes of package com.ebay.mobile.cal:
//            CalMessageLogger

private static class t> extends t>
{

    protected void logCal(com.ebay.common.net.api.cal. )
    {
        if (!TextUtils.isEmpty(((EbaySoaRequest)request).soaGlobalId))
        {
            EbaySite ebaysite = EbaySite.getInstanceFromId(((EbaySoaRequest)request).soaGlobalId);
            if (ebaysite != null)
            {
                .setSiteID(ebaysite.id);
            }
        }
    }

    public aBuilder(EbaySoaRequest ebaysoarequest, CalMessageLogger calmessagelogger)
    {
        super(ebaysoarequest, calmessagelogger);
    }
}
