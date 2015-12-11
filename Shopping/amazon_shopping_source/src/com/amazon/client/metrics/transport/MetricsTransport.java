// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.transport;

import com.amazon.client.metrics.MetricEvent;

public interface MetricsTransport
{

    public static final int CLIENT_ERROR = 3;
    public static final int CREDENTIALS_ERROR = 5;
    public static final int EMPTY_DATA_ERROR = 8;
    public static final int FAILURE = -1;
    public static final int ILLEGAL_ACCESS_ERROR = 11;
    public static final int IO_ERROR = 10;
    public static final int NETWORK_ERROR = 2;
    public static final int NO_RESPONSE_ERROR = 12;
    public static final int NO_USABLE_CONNECTION = 7;
    public static final int REQUEST_FAILED_ERROR = 9;
    public static final int SERVER_ERROR = 4;
    public static final int SUCCESS = 1;
    public static final int UNEXPECTED_ERROR = 6;

    public abstract void close();

    public abstract void shutdown();

    public abstract int transmit(byte abyte0[], MetricEvent metricevent);
}
