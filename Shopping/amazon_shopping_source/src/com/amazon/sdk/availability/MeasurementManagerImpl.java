// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            MeasurementManager, Measurement, Logger, AvailabilityService, 
//            StringUtil

public class MeasurementManagerImpl
    implements MeasurementManager
{

    public MeasurementManagerImpl()
    {
    }

    public void putMeasurement(Context context, Measurement measurement)
    {
        if (context == null || measurement == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        measurement = measurement.build().toString();
        Logger.v((new StringBuilder()).append("putMetric: ").append(measurement).toString());
        Intent intent = new Intent(context, com/amazon/sdk/availability/AvailabilityService);
        intent.setAction("PutMeasurement");
        intent.putExtra("payload", measurement);
        context.startService(intent);
        return;
        context;
        Logger.e((new StringBuilder()).append("failed to putMeasurement: ").append(context.getMessage()).toString());
        return;
    }

    public void putMeasurement(Context context, Measurement measurement, Serializable serializable)
    {
        if (context == null || measurement == null || serializable == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        measurement = measurement.build().toString();
        Logger.v((new StringBuilder()).append("putMetric: ").append(measurement).toString());
        Intent intent = new Intent(context, com/amazon/sdk/availability/AvailabilityService);
        intent.setAction("PutMeasurement");
        intent.putExtra("payload", measurement);
        intent.putExtra("mapOfFiles", serializable);
        context.startService(intent);
        return;
        context;
        Logger.e((new StringBuilder()).append("failed to putMeasurement: ").append(context.getMessage()).toString());
        return;
    }

    public void setIdentityInformation(Context context, String s, String s1, String s2, String s3, String s4, String as[])
    {
        Logger.v((new StringBuilder()).append("setIdentityInformation: ").append(s).append(", ").append(s1).append(", ").append(s2).append(", ").append(s3).append(", ").append(s4).toString());
        Intent intent = new Intent(context, com/amazon/sdk/availability/AvailabilityService);
        intent.setAction("SetIdentity");
        intent.putExtra("marketplaceId", s);
        intent.putExtra("customerId", s1);
        intent.putExtra("deviceType", s2);
        intent.putExtra("deviceId", s3);
        intent.putExtra("region", s4);
        if (as != null && as.length > 0)
        {
            s = StringUtil.join(as, ",");
            intent.putExtra("clientIds", s);
            Logger.v((new StringBuilder()).append("setIdentityInformation: supported client ids: ").append(s).toString());
        }
        context.startService(intent);
    }
}
