// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static interface 
    extends MessageOrBuilder
{

    public abstract String getKey();

    public abstract ByteString getKeyBytes();

    public abstract String getValue();

    public abstract ByteString getValueBytes();

    public abstract boolean hasKey();

    public abstract boolean hasValue();
}
