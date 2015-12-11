// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.search:
//            ISearchTracking

public interface ISearchEventTracker
{

    public abstract String generateSaaSTrackingHeader(EbayContext ebaycontext, int i, String s);

    public abstract void trackFindingResponse(Context context, int i, ISearchTracking isearchtracking);

    public abstract void trackResponse(Context context, int i, ISearchTracking isearchtracking);
}
