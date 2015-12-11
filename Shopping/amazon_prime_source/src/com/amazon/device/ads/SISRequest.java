// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLogger

interface SISRequest
{

    public abstract Metrics.MetricType getCallMetricType();

    public abstract String getLogTag();

    public abstract MobileAdsLogger getLogger();

    public abstract String getPath();

    public abstract HashMap getPostParameters();

    public abstract WebRequest.QueryStringParameters getQueryParameters();

    public abstract void onResponseReceived(JSONObject jsonobject);
}
