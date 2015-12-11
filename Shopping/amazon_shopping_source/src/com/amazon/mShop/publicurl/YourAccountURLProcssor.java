// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessor

public class YourAccountURLProcssor extends PublicURLProcessor
{

    public YourAccountURLProcssor(Uri uri)
    {
        super(uri);
    }

    protected void doProcess(Context context)
    {
        if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
        {
            RefMarkerObserver.logRefMarker("pn_youraccount_t");
        }
        ActivityUtils.startYourAccountActivity(context, getParams());
    }

    public String getMetricIdentity()
    {
        return "YourAccount";
    }
}
