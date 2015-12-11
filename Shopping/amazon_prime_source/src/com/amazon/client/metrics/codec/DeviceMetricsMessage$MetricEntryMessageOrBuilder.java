// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static interface 
    extends MessageOrBuilder
{

    public abstract  getDataPoint(int i);

    public abstract int getDataPointCount();

    public abstract List getDataPointList();

    public abstract  getDataPointOrBuilder(int i);

    public abstract List getDataPointOrBuilderList();

    public abstract String getProgram();

    public abstract ByteString getProgramBytes();

    public abstract String getSource();

    public abstract ByteString getSourceBytes();

    public abstract long getTimestamp();

    public abstract boolean hasProgram();

    public abstract boolean hasSource();

    public abstract boolean hasTimestamp();
}
