// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.IHeaders;

public abstract class BaseFollowInterestRequest extends EbayCosRequest
{

    public static final int VERSION_CODES_LOLLIPOP = 21;

    protected BaseFollowInterestRequest(String s, String s1, String s2, String s3)
    {
        super(s, s1, CosVersionType.V2);
        iafToken = s2;
        if (!TextUtils.isEmpty(s3))
        {
            marketPlaceId = s3;
        }
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
    }

    public void maybeDisableGzip(IHeaders iheaders)
    {
        if (android.os.Build.VERSION.SDK_INT < 21)
        {
            iheaders.setHeader("accept-encoding", "gzip");
        }
    }
}
