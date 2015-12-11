// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement.consumer;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HttpTransaction;
import com.newrelic.agent.android.measurement.Measurement;
import com.newrelic.agent.android.measurement.MeasurementType;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;

// Referenced classes of package com.newrelic.agent.android.measurement.consumer:
//            BaseMeasurementConsumer

public class HttpTransactionHarvestingConsumer extends BaseMeasurementConsumer
{

    public HttpTransactionHarvestingConsumer()
    {
        super(MeasurementType.Network);
    }

    public void consumeMeasurement(Measurement measurement)
    {
        measurement = (HttpTransactionMeasurement)measurement;
        HttpTransaction httptransaction = new HttpTransaction();
        httptransaction.setUrl(measurement.getUrl());
        httptransaction.setHttpMethod(measurement.getHttpMethod());
        httptransaction.setStatusCode(measurement.getStatusCode());
        httptransaction.setErrorCode(measurement.getErrorCode());
        httptransaction.setTotalTime(measurement.getTotalTime());
        httptransaction.setCarrier(Agent.getActiveNetworkCarrier());
        httptransaction.setWanType(Agent.getActiveNetworkWanType());
        httptransaction.setBytesReceived(measurement.getBytesReceived());
        httptransaction.setBytesSent(measurement.getBytesSent());
        httptransaction.setAppData(measurement.getAppData());
        httptransaction.setTimestamp(Long.valueOf(measurement.getStartTime()));
        Harvest.addHttpTransaction(httptransaction);
    }
}
