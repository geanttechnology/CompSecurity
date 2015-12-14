// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

static final class  extends AbstractParser
{

    public  parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return new nit>(codedinputstream, extensionregistrylite, null);
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream, extensionregistrylite);
    }

    ()
    {
    }
}
