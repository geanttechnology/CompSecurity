// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.containertag.proto;

import com.google.tagmanager.protobuf.AbstractParser;
import com.google.tagmanager.protobuf.CodedInputStream;
import com.google.tagmanager.protobuf.ExtensionRegistryLite;
import com.google.tagmanager.protobuf.InvalidProtocolBufferException;

// Referenced classes of package com.google.analytics.containertag.proto:
//            Serving

static final class n extends AbstractParser
{

    public n parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return new nit>(codedinputstream, extensionregistrylite, null);
    }

    public volatile Object parsePartialFrom(CodedInputStream codedinputstream, ExtensionRegistryLite extensionregistrylite)
        throws InvalidProtocolBufferException
    {
        return parsePartialFrom(codedinputstream, extensionregistrylite);
    }

    n()
    {
    }
}
