// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessor, PublicURLProcessException

public class DealsURLProcessor extends PublicURLProcessor
{

    public DealsURLProcessor(Uri uri)
    {
        super(uri);
    }

    protected void doProcess(Context context)
        throws PublicURLProcessException
    {
        if (ActivityUtils.isPublicURLDealsEnabled())
        {
            ActivityUtils.startDealsActivity(context, null, null, getParams(), true);
            return;
        } else
        {
            throw new PublicURLProcessException(PublicURLProcessException.PublicURLErrorCode.ERROR_CODE_ERROR_PATH);
        }
    }

    public String getMetricIdentity()
    {
        return "DEALS";
    }
}
