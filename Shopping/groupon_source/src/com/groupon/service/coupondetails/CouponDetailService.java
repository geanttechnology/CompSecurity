// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.coupondetails;

import android.content.Context;
import com.groupon.http.synchronous.SyncHttp;
import com.squareup.okhttp.RequestBody;

// Referenced classes of package com.groupon.service.coupondetails:
//            CouponDetailResponse

public class CouponDetailService extends SyncHttp
{

    public CouponDetailService(Context context, RequestBody requestbody)
    {
        super(context, com/groupon/service/coupondetails/CouponDetailResponse, "https:/freebies/clicks", requestbody);
        method("POST");
    }
}
