// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import java.io.FileOutputStream;

// Referenced classes of package com.amazon.client.metrics.codec:
//            ProtocolBufferExample

public class ProtocolBufferDiskWriter
{

    public ProtocolBufferDiskWriter()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        ProtocolBufferExample.generateEncodedMetrics();
        (new FileOutputStream("/home/yilin/metrics-logs/encoded-file")).write(ProtocolBufferExample.generateEncodedMetrics());
    }
}
