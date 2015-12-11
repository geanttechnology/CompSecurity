// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.model;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwContext;

// Referenced classes of package com.ebay.mobile.analytics.model:
//            TrackingData

public static final class ebayContext
{

    private final Context context;
    private final EbayContext ebayContext;

    public void send(TrackingData trackingdata)
    {
        trackingdata.send(context, ebayContext);
    }

    public (Activity activity)
    {
        context = activity;
        if (activity instanceof FwActivity)
        {
            activity = ((FwActivity)activity).getEbayContext();
        } else
        {
            activity = null;
        }
        ebayContext = activity;
    }

    public ebayContext(Service service)
    {
        context = service;
        ebayContext = ((FwContext)service).getEbayContext();
    }

    public ebayContext(EbayContext ebaycontext)
    {
        context = (Context)ebaycontext.getExtension(android/content/Context);
        ebayContext = ebaycontext;
    }
}
