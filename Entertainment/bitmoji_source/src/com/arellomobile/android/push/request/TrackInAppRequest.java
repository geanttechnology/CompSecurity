// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.request;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.arellomobile.android.push.request:
//            PushRequest

public class TrackInAppRequest extends PushRequest
{

    private String mOrderId;
    private long mPurchaseTime;
    private String mSku;

    public TrackInAppRequest(String s, String s1, long l)
    {
        mOrderId = s;
        mSku = s1;
        mPurchaseTime = l;
    }

    protected void buildParams(Context context, Map map)
        throws JSONException
    {
        map.put("orderId", mOrderId);
        map.put("sku", mSku);
        map.put("purchaseTime", Long.valueOf(mPurchaseTime));
    }

    public String getMethod()
    {
        return "trackInApp";
    }
}
